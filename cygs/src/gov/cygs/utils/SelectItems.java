package gov.cygs.utils;

import gov.cygs.dao.DBM;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@SessionScoped
public class SelectItems {

	@EJB DBM dbm;
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;	
	
	public SelectItems(){

	}
	
	private SelectItem[] ordertypes={
			new SelectItem("设立","设立"),
			new SelectItem("变更","变更")
	};
	
	private SelectItem[] idTypes={
			new SelectItem("身份证","身份证"),
			new SelectItem("其他有效身份证件","其他有效身份证件")
	};
	
	private SelectItem[] states={
			new SelectItem("创建","创建"),
			new SelectItem("保存","保存"),
			new SelectItem("已受理","已受理"),
			new SelectItem("已退回","已退回"),
			new SelectItem("预审通过","预审通过"),
			new SelectItem("审核中","审核中"),
			new SelectItem("已生成","已生成")
	};
	
	private SelectItem[] nats={
			new SelectItem("汉族","汉族"),
			new SelectItem("蒙古族","蒙古族"),
			new SelectItem("回族","回族"),
			new SelectItem("藏族","藏族"),
			new SelectItem("维吾尔族","维吾尔族"),
			new SelectItem("苗族","苗族"),
			new SelectItem("彝族","彝族"),
			new SelectItem("壮族","壮族"),
			new SelectItem("布依族","布依族"),
			new SelectItem("朝鲜族","朝鲜族"),
			new SelectItem("满族","满族"),
			new SelectItem("侗族","侗族"),
			new SelectItem("瑶族","瑶族"),
			new SelectItem("白族","白族"),
			new SelectItem("土家族","土家族"),
			new SelectItem("哈尼族","哈尼族"),
			new SelectItem("哈萨克族","哈萨克族"),
			new SelectItem("傣族","傣族"),
			new SelectItem("黎族","黎族"),
			new SelectItem("傈僳族","傈僳族"),
			new SelectItem("佤族","佤族"),
			new SelectItem("畲族","畲族"),
			new SelectItem("高山族","高山族"),
			new SelectItem("拉祜族","拉祜族"),
			new SelectItem("水族","水族"),
			new SelectItem("东乡族","东乡族"),
			new SelectItem("纳西族","纳西族"),
			new SelectItem("景颇族","景颇族"),
			new SelectItem("柯尔克孜族","柯尔克孜族"),
			new SelectItem("土族","土族"),
			new SelectItem("达斡尔族","达斡尔族"),
			new SelectItem("仫佬族","仫佬族"),
			new SelectItem("羌族","羌族"),
			new SelectItem("布朗族","布朗族"),
			new SelectItem("撒拉族","撒拉族"),
			new SelectItem("毛南族","毛南族"),
			new SelectItem("仡佬族","仡佬族"),
			new SelectItem("锡伯族","锡伯族"),
			new SelectItem("阿昌族","阿昌族"),
			new SelectItem("普米族","普米族"),
			new SelectItem("塔吉克族","塔吉克族"),
			new SelectItem("怒族","怒族"),
			new SelectItem("乌兹别克族","乌兹别克族"),
			new SelectItem("俄罗斯族","俄罗斯族"),
			new SelectItem("鄂温克族","鄂温克族"),
			new SelectItem("德昂族","德昂族"),
			new SelectItem("保安族","保安族"),
			new SelectItem("裕固族","裕固族"),
			new SelectItem("京族","京族"),
			new SelectItem("塔塔尔族","塔塔尔族"),
			new SelectItem("独龙族","独龙族"),
			new SelectItem("鄂伦春族","鄂伦春族"),
			new SelectItem("赫哲族","赫哲族"),
			new SelectItem("门巴族","门巴族"),
			new SelectItem("珞巴族","珞巴族"),
			new SelectItem("基诺族","基诺族"),
			new SelectItem("其他","其他"),
			new SelectItem("外国血统中国籍人","外国血统中国籍人")
	};	
	
	private SelectItem[] levels={
			new SelectItem("研究生","研究生"),
			new SelectItem("大学本科","大学本科"),
			new SelectItem("大学专科或专科学校","大学专科或专科学校"),
			new SelectItem("中等专业学校或中等技术学校","中等专业学校或中等技术学校"),
			new SelectItem("技工学校","技工学校"),
			new SelectItem("高中","高中"),
			new SelectItem("初中","初中"),
			new SelectItem("小学","小学"),
			new SelectItem("文盲或半文盲","文盲或半文盲")
	};
	
	private SelectItem[] politicals={
			new SelectItem("中国共产党党员","中国共产党党员"),
			new SelectItem("中国共产党预备党员","中国共产党预备党员"),
			new SelectItem("中国共产主义青年团团员","中国共产主义青年团团员"),
			new SelectItem("中国国民党革命委员会会员","中国国民党革命委员会会员"),
			new SelectItem("中国民主同盟盟员","中国民主同盟盟员"),
			new SelectItem("中国民主建国会会员","中国民主建国会会员"),
			new SelectItem("中国民主促进会会员","中国民主促进会会员"),
			new SelectItem("中国农工民主党党员","中国农工民主党党员"),
			new SelectItem("中国致公党党员","中国致公党党员"),
			new SelectItem("九三学社社员","九三学社社员"),
			new SelectItem("台湾民主自治同盟盟员","台湾民主自治同盟盟员"),
			new SelectItem("无党派民主人士","无党派民主人士"),
			new SelectItem("群众","群众")
	};

	
	private SelectItem[] districtions={
			new SelectItem("吉林省长春市朝阳区","吉林省长春市朝阳区") ,
			new SelectItem("吉林省长春市宽城区","吉林省长春市宽城区"),
			new SelectItem("吉林省长春市南关区","吉林省长春市南关区"),
			new SelectItem("吉林省长春市二道区","吉林省长春市二道区"),
			new SelectItem("吉林省长春市绿园区","吉林省长春市绿园区"),
			new SelectItem("吉林省长春市北湖科技开发区","吉林省长春市北湖科技开发区"),
			new SelectItem("吉林省长春市长德新区","吉林省长春市长德新区"),
			new SelectItem("吉林省长春市空港经济开发区","吉林省长春市空港经济开发区"),
			new SelectItem("吉林省长春市高新技术产业开发区","吉林省长春市高新技术产业开发区"),
			new SelectItem("吉林省长春市经济技术开发区","吉林省长春市经济技术开发区"),
			new SelectItem("吉林省长春市长江路经济开发区","吉林省长春市长江路经济开发区"),
			new SelectItem("吉林省长春莲花山生态旅游度假区","吉林省长春莲花山生态旅游度假区"),
			new SelectItem("吉林省长春市净月开发区","吉林省长春市净月开发区"),
			new SelectItem("吉林省长春市汽车产业开发区","吉林省长春市汽车产业开发区"),
			new SelectItem("吉林省长春市双阳区","吉林省长春市双阳区"),
			new SelectItem("吉林省九台市","吉林省九台市"),
			new SelectItem("吉林省榆树市","吉林省榆树市"),
			new SelectItem("吉林省德惠市","吉林省德惠市"),
			new SelectItem("吉林省农安县","吉林省农安县")
	};

	public SelectItem[] getDistrictions() {
		return districtions;
	}
	
	private SelectItem[] bureau={
			new SelectItem("长春市工商行政管理局","长春市工商行政管理局"),
			new SelectItem("长春市工商行政管理局朝阳分局","长春市工商行政管理局朝阳分局"),
			new SelectItem("长春市工商行政管理局南关分局","长春市工商行政管理局南关分局"),
			new SelectItem("长春市工商行政管理局宽城分局","长春市工商行政管理局宽城分局"),
			new SelectItem("长春市工商行政管理局二道分局","长春市工商行政管理局二道分局"),
			new SelectItem("长春市工商行政管理局绿园分局","长春市工商行政管理局绿园分局"),
			new SelectItem("长春市工商行政管理局双阳分局","长春市工商行政管理局双阳分局"),
			new SelectItem("长春市工商行政管理局九台分局","长春市工商行政管理局九台分局"),
			new SelectItem("长春市工商行政管理局高新技术产业开发区分局(南区)","长春市工商行政管理局高新技术产业开发区分局(南区)"),
			new SelectItem("长春市工商行政管理局高新技术产业开发区分局(北区)","长春市工商行政管理局高新技术产业开发区分局(北区)"),
			new SelectItem("长春市工商行政管理局经济技术开发区分局","长春市工商行政管理局经济技术开发区分局"),
			new SelectItem("长春市工商行政管理局净月经济开发区分局","长春市工商行政管理局净月经济开发区分局"),
			new SelectItem("长春市工商行政管理局汽车产业开发区分局","长春市工商行政管理局汽车产业开发区分局"),
			new SelectItem("长春市工商行政管理局长江路经济开发区分局","长春市工商行政管理局长江路经济开发区分局"),
			new SelectItem("长春市工商行政管理局光复路市场管理分局","长春市工商行政管理局光复路市场管理分局"),
			new SelectItem("长春市工商行政管理局莲花山生态旅游度假区分局","长春市工商行政管理局莲花山生态旅游度假区分局"),
			new SelectItem("农安县市场监督管理局","农安县市场监督管理局"),
			new SelectItem("榆树市市场监督管理局","榆树市市场监督管理局"),
			new SelectItem("德惠市市场监督管理局","德惠市市场监督管理局")
	};

	public SelectItem[] getBureau() {
		return bureau;
	}

	private SelectItem[] statesName={
			new SelectItem("核名","核名"),
			new SelectItem("提交核名","提交核名"),
			new SelectItem("核名通过","核名通过"),
			new SelectItem("核名未通过","核名未通过"),
			new SelectItem("核名中","核名中")
	};

	private SelectItem[] roles={
			new SelectItem("管理员","管理员"),
			new SelectItem("用户","用户")
	};

	public SelectItem[] getOrdertypes() {
		return ordertypes;
	}

	public void setOrdertypes(SelectItem[] ordertypes) {
		this.ordertypes = ordertypes;
	}

	public SelectItem[] getRoles() {
		return roles;
	}

	public void setRoles(SelectItem[] roles) {
		this.roles = roles;
	}

	public SelectItem[] getStates() {
		return states;
	}

	public void setStates(SelectItem[] states) {
		this.states = states;
	}

	public SelectItem[] getIdTypes() {
		return idTypes;
	}

	public void setIdTypes(SelectItem[] idTypes) {
		this.idTypes = idTypes;
	}

	public SelectItem[] getStatesName() {
		return statesName;
	}

	public void setStatesName(SelectItem[] statesName) {
		this.statesName = statesName;
	}

	public SelectItem[] getNats() {
		return nats;
	}

	public SelectItem[] getLevels() {
		return levels;
	}

	public SelectItem[] getPoliticals() {
		return politicals;
	}


}
