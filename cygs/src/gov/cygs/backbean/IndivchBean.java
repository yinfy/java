package gov.cygs.backbean;

import gov.cygs.dao.DBM;
import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.Indivchg;
import gov.cygs.entities.Indivreg;
import gov.cygs.entities.Person;
import gov.cygs.entities.SysUser;
import gov.cygs.service.IndivService;
import gov.cygs.service.IndivchService;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean 
@ViewScoped
public class IndivchBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB DBM dbm;
	@EJB IndivchService cregService;
	private Indivchg creg;
	
	private int updateid;
	private Date today;

	private SysUser currentUser;
	private String currentPage;
	
	private boolean admin=false;
	private boolean namePassed=false;
	private boolean savePassed=true;
	private boolean showWelcome=false;
	private boolean confirmed = false;
	
	private boolean chkOpt1 = false;
	private boolean chkOpt2 = false;
	private boolean chkOpt3 = false;
	private boolean chkOpt4 = false;	
	
	private String DISCTRICTION = "";
	
	public String getDISCTRICTION() {
		return DISCTRICTION;
	}

	public void setDISCTRICTION(String dISCTRICTION) {
		DISCTRICTION = dISCTRICTION;
	}
	
	public IndivchBean() {
		
	}
	
	@PostConstruct
	public void init(){
		//创建session, 防止Error Rendering View 错误
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
try{
		String passvalue=null;
		passvalue=Utils.getAttribute("indivchid");
		String passvalue_para=Utils.getParam("indivchid");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>=0)){
			passvalue = passvalue_para; 
		}
		
		//是否是新建记录
		String newreg=Utils.getParam("cn");
		if(newreg!=null){
			passvalue = "0";
			Utils.setAttribute("indivchid","0");
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
		
		if(passvalue!=null)
			this.updateid= Integer.parseInt(passvalue);
		if(this.updateid<=0){
			newIndivchreg();
		}else{
			this.creg= (Indivchg) dbm.getObjectByID("Indivchg", updateid);

			if(!creg.getCnamenew().trim().equals("")){
				this.chkOpt1 = true;
			}
			if(!creg.getCaddressnew().trim().equals("")){
				this.chkOpt2 = true;
			}
			if(!creg.getCrangenew().trim().equals("")){
				this.chkOpt3 = true;
			}
			if(!creg.getCmodenew().trim().equals("")){
				this.chkOpt4 = true;
			}
			
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
	
	public String movemap(String dir){
		int step = 3;
		int MIN_IND=1;
		int MAX_IND=9;
		
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
		
		this.creg.setMapfile(creg.getLocal()+ newIndex);
		this.creg.setMapindex(newIndex);
		return "";
	}	
	
	public void setDistriction(){
		this.DISCTRICTION = this.creg.getPrefix();
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
			this.creg.setFamily("");
			this.creg.setCmodenew("");
			this.creg.setFamilynew("");
		}else{
			//this.creg.setCmodenew("个人经营");
		}
	}
	
	public Indivchg getCreg() {
		return creg;
	}

	public void setCreg(Indivchg creg) {
		this.creg = creg;
	}

	public boolean isSavePassed() {
		return savePassed;
	}

	public void setSavePassed(boolean savePassed) {
		this.savePassed = savePassed;
	}

	public String openpage(String page){
		String passvalue=null;
		passvalue=Utils.getAttribute("indivchid");
		String passvalue_para=Utils.getParam("indivchid");
		if(passvalue_para!=null && (Integer.parseInt(passvalue_para)>0)){
			passvalue = passvalue_para; 
		}
		if(passvalue!=null){
			this.updateid= Integer.parseInt(passvalue);
		}
		
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("indivchid", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			return page;
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
		return "/indivchg/index";
	}
	
	public String reject(){
		this.saveData("tips");
		cregService.updateCreg(this.creg,"已退回");
		return "/indivchg/index";
	}

	public String approve(){
		cregService.updateCreg(this.creg,"预审通过");
		return "/indivchg/index";
	}
	
	public String prepage(String page){
		if(this.currentPage !=null){
			this.saveData(this.currentPage);
		}
		Utils.setAttribute("indivchid", creg.getId().toString());
		if(!this.savePassed){
			return "";
		}else{
			return page;
		}
	}
	
	public void setLocal(){
		String local = creg.getLocal();
		creg.setLocal(local);
		return ;
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
	
	private void newIndivchreg(){
		this.creg = new Indivchg();
		this.creg.setUserid((int) currentUser.getId());
	}
	
	public boolean checkRules(String page){
		boolean pass= true;
		if(this.chkOpt1){
			if(creg.getCnamenew().trim().equals("")){
				Utils.addMessage("错误", "变更后名称不能为空");
				pass = false;
			}
			if(creg.getCnamenew().trim().equals(creg.getCname().trim())){
				Utils.addMessage("错误", "变更前后名称不能相同");
				pass = false;
			}
		}
		if(this.chkOpt2){
			if(creg.getCaddressnew().trim().equals("")){
				Utils.addMessage("错误", "变更后地址不能为空");
				pass = false;
			}
		}
		if(this.chkOpt3){
			if(creg.getCrangenew().trim().equals("")){
				Utils.addMessage("错误", "变更后经营范围不能为空");
				pass = false;
			}
		}
		if(this.chkOpt4){
			if(creg.getCmodenew().trim().equals("")){
				Utils.addMessage("错误", "变更后组成形式不能为空");
				pass = false;
			}
		}

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
				Utils.setAttribute("indivchid", creg.getId().toString());
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
	
}
