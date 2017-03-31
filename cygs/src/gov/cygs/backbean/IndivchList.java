package gov.cygs.backbean;

import gov.cygs.dao.DBM;
import gov.cygs.entities.Indivchg;
import gov.cygs.entities.SysUser;
import gov.cygs.service.IndivchService;
import gov.cygs.utils.Pager;
import gov.cygs.utils.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean 
@ViewScoped
public class IndivchList extends Pager {
	@EJB DBM dbm;
	@EJB IndivchService cregService;
	
	private List<Indivchg> cregList;
	private LazyDataModel model; 
	private Indivchg creg;
	private Indivchg selectedCreg;
	private SysUser currentUser;
	private boolean admin=false;
	private boolean showWelcome=false;
	
	//用于过滤查询的字段
	private String filterCompanyName;
	private String filterPersonName;
	private String filterState;
	private String filterCname1;
	private Date filterAppDateBegin;
	private Date filterAppDateEnd;
	
	public IndivchList() {
		super();
		this.queryObj="Indivchg";
	}
	
	@PostConstruct
	public void init(){
		//创建session, 防止Error Rendering View 错误
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.currentUser = Utils.getCurrentUser();
		if(this.currentUser==null){
			Utils.sendRedirect("/login.xhtml");
			return;
		}
		if(this.currentUser!=null &&(this.currentUser.getRole().equals("管理员") || this.currentUser.getRole().equals("分局管理员") ) ){
			this.admin = true;
		}
		
		this.queryObj="Indivchg";
		
		Map<String, Object> filter= new LinkedHashMap<String,Object>();
		
		if(!this.admin){
			filter.put("userid:number", new SelectItem(String.valueOf(currentUser.getId()),"="));
			filter.put("[ and (capprove='保存' or capprove='已受理' or capprove='预审通过' or capprove='已退回' or capprove='审核中' or capprove='核名通过' or capprove='已生成') ]:string", new SelectItem("","="));
			this.setUserFilter(filter);
		}
		if(this.admin){
			filter.put("special:string", new SelectItem(currentUser.getDistriction(),"="));
			filter.put("[and ((capprove='审核中' or capprove='已受理')  and transport='"+ currentUser.getLoginId()+"')]:string", new SelectItem("","="));
			this.setUserFilter(filter);
		}
	}
	
	public String reject(){
		cregService.updateCreg(this.selectedCreg,"已退回");
		return "";
	}

	public String approve(){
		cregService.updateCreg(this.selectedCreg,"预审通过");
		return "";
	}

	public String commit(){
		cregService.commit(this.selectedCreg);
		this.showWelcome = true;
		return "";
	}
	
	public String closeWelcome(){
		this.showWelcome = false;
		return "";
	}
	
	public void generate(){
		cregService.generate(this.selectedCreg,false);
	}
	
	public String preview(){
		if(!cregService.checkRules("all",selectedCreg)){
			return "";
		}
		cregService.generate(this.selectedCreg,true);
		return "";
	}

	public void doFilter(){
		this.condations.clear();
		Map<String, Object> filter= new HashMap<String,Object>();
		
		if(filterCompanyName!=null && !this.filterCompanyName.trim().equals(""))
			filter.put("cname:string", new SelectItem(this.filterCompanyName,"like"));
		if(filterPersonName!=null && !this.filterPersonName.trim().equals(""))
			filter.put("shame:string", new SelectItem(this.filterPersonName,"like"));
		if(filterState!=null && !this.filterState.trim().equals(""))
			filter.put("capprove:string", new SelectItem(this.filterState,"="));
		if(filterAppDateBegin!=null )
			filter.put("capptime:date:1", new SelectItem(this.filterAppDateBegin,">="));
		if(filterAppDateEnd!=null )
			filter.put("capptime:date:2", new SelectItem(this.filterAppDateEnd,"<="));
		// filter.put("[ and (capprove='保存' or capprove='已受理' or capprove='预审通过' or capprove='已退回' or capprove='审核中' or capprove='核名通过'  or capprove='提交核名' or capprove='已生成' ) ]:string", new SelectItem("","="));
		filter.put("special:string", new SelectItem(currentUser.getDistriction(),"="));

		this.setUserFilter(filter);
		String sortField=null;
		SortOrder sortOrder=SortOrder.ASCENDING;		
		Map f=null;
		super.getModel().load(0, this.pageSize, sortField, sortOrder,f);
	}
	
	public void resetFilter(){
		filterPersonName="";
		filterCompanyName="";
		filterState="";
		filterAppDateBegin=null;
		filterAppDateEnd=null;
		doFilter();
	}

	public List<Indivchg> getCregList() {
		return cregList;
	}

	public void setCregList(List<Indivchg> cregList) {
		this.cregList = cregList;
	}

	public Indivchg getCreg() {
		return creg;
	}

	public void setCreg(Indivchg creg) {
		this.creg = creg;
	}

	public Indivchg getSelectedCreg() {
		return selectedCreg;
	}

	public void setSelectedCreg(Indivchg selectedCreg) {
		this.selectedCreg = selectedCreg;
	}

	public String getFilterCompanyName() {
		return filterCompanyName;
	}

	public void setFilterCompanyName(String filterCompanyName) {
		this.filterCompanyName = filterCompanyName;
	}

	public String getFilterPersonName() {
		return filterPersonName;
	}

	public void setFilterPersonName(String filterPersonName) {
		this.filterPersonName = filterPersonName;
	}

	public Date getFilterAppDateBegin() {
		return filterAppDateBegin;
	}

	public void setFilterAppDateBegin(Date filterAppDateBegin) {
		this.filterAppDateBegin = filterAppDateBegin;
	}

	public Date getFilterAppDateEnd() {
		return filterAppDateEnd;
	}

	public void setFilterAppDateEnd(Date filterAppDateEnd) {
		this.filterAppDateEnd = filterAppDateEnd;
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

	public String getFilterState() {
		return filterState;
	}

	public void setFilterState(String filterState) {
		this.filterState = filterState;
	}

	public String getFilterCname1() {
		return filterCname1;
	}

	public void setFilterCname1(String filterCname1) {
		this.filterCname1 = filterCname1;
	}

	public boolean isShowWelcome() {
		return showWelcome;
	}

	public void setShowWelcome(boolean showWelcome) {
		this.showWelcome = showWelcome;
	}

}
	
