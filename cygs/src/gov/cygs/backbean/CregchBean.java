package gov.cygs.backbean;

import gov.cygs.dao.DBM;
import gov.cygs.ejb.RangeBean;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.Person;
import gov.cygs.entities.Precondition;
import gov.cygs.entities.Range;
import gov.cygs.entities.Shareholder;
import gov.cygs.entities.SysUser;
import gov.cygs.entities.Upfile;
import gov.cygs.exception.PersistenceException;
import gov.cygs.service.CregService;
import gov.cygs.service.CregchService;
import gov.cygs.utils.DocUtil;
import gov.cygs.utils.Utils;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import gov.cygs.utils.FileUpload;

@ManagedBean 
@ViewScoped
public class CregchBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB DBM dbm;
	@EJB CregchService cregchService;
	private Companychg creg;
	
	private int updateid;
	private Date today;

	private SysUser currentUser;
	private String currentPage;
	private Person selectedPerson;
	private List<Person> persons;
	
	private boolean admin=false;
	private boolean namePassed=false;
	private boolean savePassed=true;
	private boolean showWelcome=false;
	private boolean confirmed = false;
	
	private boolean orgnoEnable = true;
	private boolean chkOpt1 = false;
	private boolean chkOpt2 = false;
	private boolean chkOpt3 = false;
	private boolean chkOpt4 = false;
	
	public CregchBean() {
		
	}
	
	@PostConstruct
	public void init(){
		//创建session, 防止Error Rendering View 错误
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
try{
		String passvalue=null;
		passvalue=Utils.getAttribute("cregchid");
		String passvalue_para=Utils.getParam("cregchid");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>0)){
			passvalue = passvalue_para; 
		}
		
		String newreg=Utils.getParam("cn");
		if(newreg!=null){
			passvalue = "0";
			Utils.setAttribute("cregchid","0");
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
			newCompanyreg();
		}else{
			this.creg= (Companychg) dbm.getObjectByID("Companychg", updateid);
			
			if(!creg.getCnamenew().trim().equals("")){
				this.chkOpt1 = true;
			}
			if(!creg.getCaddressnew().trim().equals("")){
				this.chkOpt2 = true;
			}
			if(!creg.getCrangenew().trim().equals("")){
				this.chkOpt3 = true;
			}
			if(creg.getCyearslongnew().trim().equals("长期")|| creg.getCyearsnew()>0){
				this.chkOpt4 = true;
			}
			
			this.persons = Utils.getPersons(creg);
			
			if(admin){
				if(creg.getCapprove().equals("已受理") ){
					cregchService.updateCreg(creg,"审核中");
				}
			}
		}
}catch(Exception e){
	Utils.addMessage("错误", "请先登录");
}
	}
	
	
	public String openpage(String page){
		String passvalue=null;
		passvalue=Utils.getAttribute("cregchid");
		String passvalue_para=Utils.getParam("cregchid");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>0)){
			passvalue = passvalue_para; 
		}
		if(passvalue!=null){
			this.updateid= Integer.parseInt(passvalue);
		}
		
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("cregchid", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			return page;
		}
	}
	
	public void cnamenotype_change(){
		if(this.creg.getCnamenotype().equals("注册号")){
			this.orgnoEnable = true;
		}else{
			this.orgnoEnable = false;
			this.creg.setOrgno1("");
			this.creg.setOrgno2("");
			this.creg.setOrgno3("");
		}
	}
	
	public void onChkOpt1Change(){
		if(!this.chkOpt1){
			this.creg.setCnamenew("");
		}
	}
	public void onChkOpt2Change(){
		if(!this.chkOpt2){
			this.creg.setCaddressnew("");
		}
	}
	public void onChkOpt3Change(){
		if(!this.chkOpt3){
			this.creg.setCrangenew("");
		}
	}
	public void onChkOpt4Change(){
		if(!this.chkOpt4){
			this.creg.setCyearslongnew("");
			this.creg.setCyearsnew(0);
		}
	}
	
	public String commit(){
		this.saveData("tips");
		cregchService.commit(this.creg);
		this.showWelcome = true;
		return "";
	}
	
	public String closeWelcome(){
		this.showWelcome = false;
		return "/registerch/index";
	}
	
	public String reject(){
		this.saveData("tips");
		cregchService.updateCreg(this.creg,"已退回");
		return "/registerch/index";
	}

	public String approve(){
		cregchService.updateCreg(this.creg,"预审通过");
		return "/registerch/index";
	}
	
	public String prepage(String page){
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("cregchid", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			return page;
		}
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
	
	public int sharesExist(List<Shareholder> shareList, Shareholder share){
		int ind = -1;
		String uuid = share.getUuid();
		for(int i=0; i< shareList.size();i++){
			if(shareList.get(i).getUuid().equals(uuid)){
				ind = i;
				break;
			}
		}
		return ind;
		
	}
	
	private void newCompanyreg(){
		this.creg = new Companychg();
		this.creg.setUserid((int) currentUser.getId());
	}
	
	public boolean checkRules(String page){
		boolean pass= true;
		if(page.equals("biangeng") || page.equals("all")){
			if(this.chkOpt1){ //企业名称
				if(creg.getCnamenew().trim().equals("")){
					Utils.addMessage("错误", "必须输入新的企业名称");
					pass = false;
				}
				if(creg.getCnamenew().trim().equals(creg.getCname())){
					Utils.addMessage("错误", "新的企业名称不能与原名称相同");
					pass  = false;
				}
			}
			if(this.chkOpt2){ //住所
				if(creg.getCaddressnew().trim().equals("")){
					Utils.addMessage("错误", "必须输入新的住所");
					pass = false;
				}
				if(creg.getCaddressnew().trim().equals(creg.getHaddress())){
					Utils.addMessage("错误", "新的住所不能与原来相同");
					pass  = false;
				}
			}
			if(this.chkOpt3){ //经营范围
				if(creg.getCrangenew().trim().equals("")){
					Utils.addMessage("错误", "必须输入新的经营范围");
					pass = false;
				}
				if(creg.getCrangenew().trim().equals(creg.getCrange())){
					Utils.addMessage("错误", "新的经营范围不能与原来相同");
					pass  = false;
				}
			}
			if(this.chkOpt4){ //营业期限
				if(creg.getCyearslong()==null  || creg.getCyearslongnew()==null){
					Utils.addMessage("错误", "需要选择经营期限年限类型");
					pass= false;
				}else{
					if(creg.getCyearslong().equals("") && creg.getCyears()==0){
						Utils.addMessage("错误", "需要输入原来的具体年限数");
						pass= false;
					}
					if(creg.getCyearslongnew().equals("") && creg.getCyearsnew()==0){
						Utils.addMessage("错误", "需要输入新的具体年限数");
						pass= false;
					}
					if(creg.getCyearslongnew().equals("") && creg.getCyearslong().equals("") && creg.getCyearsnew()==creg.getCyears() ){
						Utils.addMessage("错误", "新的经营期限不能与原来的相同");
						pass= false;
					}
					if(creg.getCyearslongnew().equals("长期") && creg.getCyearslong().equals("长期")){
						Utils.addMessage("错误", "新的经营期限不能与原来的相同");
						pass= false;
					}
				}
			}

		}
		return pass;
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
    	
    	if(updatePerson.equals("lly")){
    		creg.setLlyName(pName);
    		creg.setLlyIdtype(pIdtype);
    		creg.setLlyIdno(pIdno);
    		creg.setLlyTele(pPhone);
    		creg.setLlyMobile(pMobile);
    		creg.setLlyMail(pEmail);
    	}

    	if(updatePerson.equals("auth")){
    		creg.setAuthDname(pName);
    		creg.setAuthIdtype(pIdtype);
    		creg.setAuthIdno(pIdno);
    		creg.setAuthTele(pPhone);
    		creg.setAuthMobile(pMobile);
    	}
    }

	
	public String saveData(String page){
		try {
			this.savePassed = true;
			if(!admin){
				if(!this.checkRules(page)){
					this.savePassed = false;
					return "";
				}
				if(!cregchService.checkRules(page,this.creg)){
					this.savePassed = false;
					return "";
				}else{
					cregchService.updateRelate(page, creg);
				}
			}
			
			if(this.updateid<=0){
				//保存数据
				cregchService.saveCreg(creg,"保存");
				Utils.setAttribute("cregchid", creg.getId().toString());
				Utils.addMessage("消息", "保存数据完毕");
			}else{
				if (this.admin){
					cregchService.updateCreg(creg,"审核中");
				}else{
					cregchService.updateCreg(creg,"保存");
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
	
	
	public Companychg getCreg() {
		return creg;
	}

	public void setCreg(Companychg creg) {
		this.creg = creg;
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

	public boolean isOrgnoEnable() {
		return orgnoEnable;
	}

	public void setOrgnoEnable(boolean orgnoEnable) {
		this.orgnoEnable = orgnoEnable;
	}

	public boolean isChkOpt1() {
		return chkOpt1;
	}

	public void setChkOpt1(boolean chkOpt1) {
		this.chkOpt1 = chkOpt1;
	}

	public boolean isChkOpt2() {
		return chkOpt2;
	}

	public void setChkOpt2(boolean chkOpt2) {
		this.chkOpt2 = chkOpt2;
	}

	public boolean isChkOpt3() {
		return chkOpt3;
	}

	public void setChkOpt3(boolean chkOpt3) {
		this.chkOpt3 = chkOpt3;
	}

	public boolean isChkOpt4() {
		return chkOpt4;
	}

	public void setChkOpt4(boolean chkOpt4) {
		this.chkOpt4 = chkOpt4;
	}

	public boolean isShowWelcome() {
		return showWelcome;
	}

	public void setShowWelcome(boolean showWelcome) {
		this.showWelcome = showWelcome;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}
