package gov.cygs.backbean;

import gov.cygs.dao.DBM;
import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.Indivreg;
import gov.cygs.entities.Person;
import gov.cygs.entities.SysUser;
import gov.cygs.service.IndivService;
import gov.cygs.utils.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean 
@ViewScoped
public class IndivBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB DBM dbm;
	@EJB IndivService cregService;
	private Indivreg creg;
	
	private int updateid;
	private Date today;

	private SysUser currentUser;
	private String currentPage;
	
	private boolean admin=false;
	private boolean namePassed=false;
	private boolean savePassed=true;
	private boolean showWelcome=false;
	private boolean confirmed = false;
	
	private String DISCTRICTION = "";
	
	public String getDISCTRICTION() {
		return DISCTRICTION;
	}

	public void setDISCTRICTION(String dISCTRICTION) {
		DISCTRICTION = dISCTRICTION;
	}

	private List<Person> persons;
	private Person selectedPerson;
	private String updatePerson=""; 
	
	public IndivBean() {
		
	}
	
	@PostConstruct
	public void init(){
		//创建session, 防止Error Rendering View 错误
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
try{
		String passvalue=null;
		passvalue=Utils.getAttribute("individ");
		String passvalue_para=Utils.getParam("individ");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>0)){
			passvalue = passvalue_para; 
		}
		
		String newreg=Utils.getParam("cn");
		if(newreg!=null){
			passvalue = "0";
			Utils.setAttribute("individ","0");
		}
		
		today = Utils.getday( new Date());
		
		this.currentUser = Utils.getCurrentUser();
		if(this.currentUser==null){
			Utils.sendRedirect("/login.xhtml");
			return;
		}
		
		if(this.currentUser!=null &&(this.currentUser.getRole().equals("管理员") || this.currentUser.getRole().equals("分局管理员") ) ){
			this.admin = true;
		}
		
		this.persons = new ArrayList<Person>();
		
		if(passvalue!=null)
			this.updateid= Integer.parseInt(passvalue);
		if(this.updateid<=0){
			newIndivreg();
		}else{
			this.creg= (Indivreg) dbm.getObjectByID("Indivreg", updateid);
			this.persons = Utils.getPersons(creg);
			this.DISCTRICTION = this.creg.getPrefix();
			
			if(admin){
				if(creg.getCapprove().equals("已受理") ){
					cregService.updateCreg(creg,"审核中");
				}
			}
		}
}catch(Exception e){
	Utils.addMessage("错误", "请先登录");
}
	}
	
	public void onCmodeChange(){
		if(creg.getCmode().equals("个人经营")){
			creg.setFamily("");
		}
	}
	
	public void setDistriction(){
		this.DISCTRICTION = this.creg.getPrefix();
	}
	
	public Indivreg getCreg() {
		return creg;
	}

	public void setCreg(Indivreg creg) {
		this.creg = creg;
	}

	public boolean isSavePassed() {
		return savePassed;
	}

	public void setSavePassed(boolean savePassed) {
		this.savePassed = savePassed;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public String openpage(String page){
		String passvalue=null;
		passvalue=Utils.getAttribute("individ");
		String passvalue_para=Utils.getParam("individ");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>0)){
			passvalue = passvalue_para; 
		}
		if(passvalue!=null){
			this.updateid= Integer.parseInt(passvalue);
		}
		
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("individ", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			if(creg.getAuthMode().equals("本人办理") && page.equals("weituo") ){
				page = "weizhi";
			}
			return page;
		}
	}
	
    public void updatePerson(String updatePerson){
    	if(selectedPerson==null) return;
    	String pName = selectedPerson.getName();
    	String pIdno = selectedPerson.getIdNo();
    	String pIdtype = selectedPerson.getIdType();
    	String pPhone = selectedPerson.getPhone();
    	String pMobile = selectedPerson.getMobile();
    	String pEmail = selectedPerson.getEmail();
    	if(updatePerson==null) return;
    	
    	if(updatePerson.equals("creg")){
    		creg.setShname(pName);
    		creg.setShidno(pIdno);
    		creg.setShmobile(pMobile);
    		creg.setShemail(pEmail);
    	}

    	if(updatePerson.equals("auth")){
    		creg.setAuthDname(pName);
    		creg.setAuthIdno(pIdno);
    		creg.setAuthMobile(pMobile);
    	}
    }
	
	public String commit(){
		this.saveData("tips");
		cregService.commit(this.creg);
		this.showWelcome = true;
		return "";
	}
	
	public String closeWelcome(){
		this.showWelcome = false;
		return "/indivreg/index";
	}
	
	public String reject(){
		this.saveData("tips");
		cregService.updateCreg(this.creg,"已退回");
		return "/indivreg/index";
	}

	public String approve(){
		cregService.updateCreg(this.creg,"预审通过");
		return "/indivreg/index";
	}
	
	public String prepage(String page){
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("individ", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			if(creg.getAuthMode().equals("本人办理") && page.equals("weituo") ){
				page = "creg";
			}			
			return page;
		}
	}
	
	public String movemap(String dir){
		int step = 3;
		int MIN_IND=1;
		int MAX_IND=9;
		
		
		if(creg.getLocal().equals("清和工商所")){
			step=3;
			MAX_IND=9;
		}
		
		if(creg.getLocal().equals("桂林工商所")){
			step=7;
			MAX_IND=133;
		}
		
		int index = creg.getMapindex();
		int newIndex = index;

		int line_min = ((index - index%step)+1);
		if(line_min>index){
			line_min= line_min-step;
		}
		int line_max = ((index-1)/step+1) * step;
		
		if(dir.equals("east")){
			if(newIndex<line_max) newIndex = newIndex +1;
		}
		if(dir.equals("west")){
			if(newIndex>line_min)newIndex = newIndex -1;
		}
		if(dir.equals("south")){
			newIndex = newIndex +step;
			if(newIndex>MAX_IND){
				newIndex = index;
			}
		}
		if(dir.equals("north")){
			newIndex = newIndex -step;
			if(newIndex<MIN_IND){
				newIndex = index;
			}
		}
		
		this.creg.setMapfile(creg.getLocal()+ "_"+ (newIndex<10?"0":"")+ newIndex);
		this.creg.setMapindex(newIndex);
		return "";
	}
	
	public int itemExist(List<EntityImpl> itemList, EntityImpl item){
		int ind = -1;
		for(int i=0; i< itemList.size();i++){
			if((int)itemList.get(i).getId() == (int)item.getId()){
				ind = i;
				break;
			}
		}
		return ind;
	}
	
	private void newIndivreg(){
		this.creg = new Indivreg();
		this.creg.setUserid((int) currentUser.getId());
	}
	
	public boolean checkRules(String page){
		boolean pass= true;
		return pass;
	}
	
	public String saveData(String page){
		try {
			this.savePassed = true;
			if(!admin){
				if(!this.checkRules(page)){
					this.savePassed = false;
					return "";
				}
				if(!cregService.checkRules(page,this.creg)){
					this.savePassed = false;
					return "";
				}else{
					cregService.updateRelate(page, creg);
				}
			}
			
			if(this.updateid<=0){
				//保存数据
				cregService.saveCreg(creg,"保存");
				Utils.setAttribute("individ", creg.getId().toString());
				Utils.addMessage("消息", "保存数据完毕");
			}else{
				if (this.admin){
					cregService.updateCreg(creg,"审核中");
				}else{
					cregService.updateCreg(creg,"保存");
				}
				Utils.addMessage("消息", "保存数据完毕");
			}
		} catch (Exception e) {
			this.savePassed = false;
			Utils.addMessage("错误", "保存数据失败");
		}
		this.savePassed = true;
		return "";
	}
	
	public SysUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(SysUser currentUser) {
		this.currentUser = currentUser;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isNamePassed() {
		return namePassed;
	}

	public void setNamePassed(boolean namePassed) {
		this.namePassed = namePassed;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isShowWelcome() {
		return showWelcome;
	}

	public void setShowWelcome(boolean showWelcome) {
		this.showWelcome = showWelcome;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}
