package gov.cygs.entities;

import gov.cygs.utils.Utils;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.lang.reflect.Field;



/**
 * The persistent class for the companyreg database table.
 * 
 */
@Entity
@NamedQuery(name="Companyreg.findAll", query="SELECT c FROM Companyreg c")
public class Companyreg extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected static final int MAXROW = 11;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_date")
	protected Date authDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_dateb")
	protected Date authDateb;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_datee")
	protected Date authDatee;

	@Column(name="auth_dname")
	protected String authDname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_date2")
	protected Date authDate2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_dateb2")
	protected Date authDateb2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_datee2")
	protected Date authDatee2;

	@Column(name="auth_dname2")
	protected String authDname2;
	
	@Column(name="auth_idfile")
	protected String authIdfile;

	@Column(name="auth_idno")
	protected String authIdno;

	@Column(name="auth_idno2")
	protected String authIdno2;

	@Column(name="auth_idtype")
	protected String authIdtype;

	@Column(name="auth_mobile")
	protected String authMobile;

	@Column(name="auth_mobile2")
	protected String authMobile2;

	@Column(name="auth_name")
	protected String authName;

	@Column(name="auth_opt1")
	protected boolean authOpt1;

	@Column(name="auth_opt10")
	protected boolean authOpt10;

	@Column(name="auth_opt11")
	protected boolean authOpt11;

	@Column(name="auth_opt12")
	protected boolean authOpt12;

	@Column(name="auth_opt13")
	protected boolean authOpt13;

	@Column(name="auth_opt14")
	protected boolean authOpt14;

	@Column(name="auth_opt15")
	protected boolean authOpt15;

	@Column(name="auth_opt16")
	protected boolean authOpt16;

	@Column(name="auth_opt17")
	protected boolean authOpt17;
	
	@Column(name="auth_opt18")
	protected boolean authOpt18;

	@Column(name="auth_opt19")
	protected boolean authOpt19;

	@Column(name="auth_opt2")
	protected boolean authOpt2;

	@Column(name="auth_opt3")
	protected boolean authOpt3;

	@Column(name="auth_opt4")
	protected boolean authOpt4;

	@Column(name="auth_opt5")
	protected boolean authOpt5;

	@Column(name="auth_opt6")
	protected boolean authOpt6;

	@Column(name="auth_opt7")
	protected boolean authOpt7;

	@Column(name="auth_opt8")
	protected boolean authOpt8;

	@Column(name="auth_opt9")
	protected boolean authOpt9;

	@Column(name="auth_optblank")
	protected String authOptblank;

	@Column(name="auth_tele")
	protected String authTele;

	protected String caddress;

	protected float capital;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date capptime;
	
	protected String capprove;
	
	protected String cno;

	@Column(name="ceo_idfile")
	protected String ceoIdfile;

	@Column(name="ceo_idno")
	protected String ceoIdno;

	@Column(name="ceo_idtype")
	protected String ceoIdtype;

	@Column(name="ceo_mail")
	protected String ceoMail;

	@Column(name="ceo_mobile")
	protected String ceoMobile;

	@Column(name="ceo_name")
	protected String ceoName;

	@Column(name="ceo_tele")
	protected String ceoTele;

	protected int cernum;

	protected String cname;
	
	protected String cname0;

	protected String cname1;

	protected String cname2;

	protected String cname3;

	protected String cname4;

	protected String cname5;
	
	protected String cname6;
	
	@Column(name="cname_opt1")
	protected boolean cnameOpt1;

	@Column(name="cname_opt2")
	protected boolean cnameOpt2;

	@Column(name="cname_opt3")
	protected boolean cnameOpt3;

	@Column(name="cname_opt4")
	protected boolean cnameOpt4;

	@Column(name="cname_opt5")
	protected boolean cnameOpt5;

	@Column(name="cname_opt6")
	protected boolean cnameOpt6;

	protected String cnameno;

	protected String comment1;

	protected String comment2;

	protected String comment3;

	protected String comment4;

	protected String comment5;

	protected String comment6;

	protected String comment7;

	protected String comment8;

	protected String comment9;
	
	protected String comment10;

	protected String comment11;
	
	protected String comment12;
	
	protected String comment13; 
	
	protected String crange;

	protected String ctelephone;

	protected String ctype;

	@Column(name="ctype_sub")
	protected String ctypeSub;

	protected int cyears;

	protected String cyearslong;

	protected String czip;
	
	
	protected boolean dshui;
	
	protected boolean jshui;

	protected String duty;
	
	protected int empnum;
	
	protected int empfornum;

	@Column(name="fin_idfile")
	protected String finIdfile;

	@Column(name="fin_idno")
	protected String finIdno;

	@Column(name="fin_idtype")
	protected String finIdtype;

	@Column(name="fin_mail")
	protected String finMail;

	@Column(name="fin_mobile")
	protected String finMobile;

	@Column(name="fin_name")
	protected String finName;

	@Column(name="fin_tele")
	protected String finTele;

	protected String haddress;

	@Column(name="jl_duty")
	protected String jlDuty;

	@Column(name="jl_idfile")
	protected String jlIdfile;

	@Column(name="jl_idno")
	protected String jlIdno;

	@Column(name="jl_idtype")
	protected String jlIdtype;

	@Column(name="jl_name")
	protected String jlName;

	@Column(name="js_duty")
	protected String jsDuty;

	@Column(name="js_idfile")
	protected String jsIdfile;

	@Column(name="js_idno")
	protected String jsIdno;

	@Column(name="js_idtype")
	protected String jsIdtype;

	@Column(name="js_name")
	protected String jsName;

	@Column(name="lly_idfile")
	protected String llyIdfile;

	@Column(name="lly_idno")
	protected String llyIdno;

	@Column(name="lly_idtype")
	protected String llyIdtype;

	@Column(name="lly_mail")
	protected String llyMail;

	@Column(name="lly_mobile")
	protected String llyMobile;

	@Column(name="lly_name")
	protected String llyName;

	@Column(name="lly_tele")
	protected String llyTele;

	@Column(name="mark_addr1")
	protected String markAddr1;

	@Column(name="mark_addr2")
	protected String markAddr2;

	@Column(name="mark_addr3")
	protected String markAddr3;

	protected String prefix;

	protected String selrange;

	protected String transport;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected int userid;

	protected String jingshou;

	protected String uuid;
	
	protected String special;

	@Column(name="zxds_duty")
	protected String zxdsDuty;

	@Column(name="zxds_idfile")
	protected String zxdsIdfile;
	
	@Column(name="zxds_idno")
	protected String zxdsIdno;

	@Column(name="zxds_idtype")
	protected String zxdsIdtype;

	@Column(name="zxds_name")
	protected String zxdsName;

	//bi-directional many-to-one association to Shareholder
	@OneToMany( mappedBy="companyreg", cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER  )
	protected Set<Shareholder> shareholders;

	@OneToMany( mappedBy="companyreg", cascade={CascadeType.ALL}, fetch=FetchType.EAGER  )
	protected Set<Precondition> preconditions;

	@OneToMany( mappedBy="companyreg", cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER  )
	protected Set<Dongshi> dongshis;

	@OneToMany( mappedBy="companyreg", cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER  )
	protected Set<Jianshi> jianshis;

	@OneToMany( mappedBy="companyreg", cascade={CascadeType.ALL}, fetch=FetchType.EAGER  )
	protected Set<Upfile> upfiles;
	
	public Companyreg() {
		this.preconditions = new LinkedHashSet<Precondition>();
		this.shareholders = new LinkedHashSet<Shareholder>();
		this.upfiles = new LinkedHashSet<Upfile>();
		this.dongshis = new LinkedHashSet<Dongshi>();
		this.jianshis = new LinkedHashSet<Jianshi>();
		
		Companyreg creg = this;
		UUID uuid = UUID.randomUUID();
		creg.setUuid(uuid.toString());
		creg.setTransport("inner");
		creg.setCapprove("创建");
		creg.setCtype("有限责任公司");
		creg.setCtypeSub("I1");
		creg.setDuty("执行董事");
		creg.setCname("");
		creg.setCname0("");
		creg.setCname1("");
		creg.setCname2("");
		creg.setCname3("");
		creg.setCname4("");
		creg.setCname5("");
		creg.setCname6("");
		creg.setCnameOpt1(false);
		creg.setCnameOpt2(false);
		creg.setCnameOpt3(false);
		creg.setCnameOpt4(false);
		creg.setCnameOpt5(false);
		creg.setCnameOpt6(false);
		creg.setCno("");
		creg.setCnameno("");
		creg.setCyears(0);
		creg.setHaddress("");
		creg.setCaddress("");
		creg.setCtelephone("");
		creg.setCzip("130000");
		creg.setCeoName("");
		creg.setCrange("");
		creg.setSelrange("[]");
		creg.setCyearslong("长期");
		creg.setJshui(false);
		creg.setDshui(false);
		
		creg.setCeoTele("");
		creg.setCeoMobile("");
		creg.setCeoMail("");
		creg.setCeoIdtype("身份证");
		creg.setCeoIdno("");
		
		creg.setEmpnum(0);
		creg.setEmpfornum(0);
		
		creg.setZxdsName("");
		creg.setZxdsDuty("执行董事");
		creg.setZxdsIdtype("身份证");
		creg.setZxdsIdno("");
		
		creg.setJlName("");
		creg.setJlDuty("经理");
		creg.setJlIdtype("身份证");
		creg.setJlIdno("");
		
		creg.setJsName("");
		creg.setJsDuty("监事");
		creg.setJsIdtype("身份证");
		creg.setJsIdno("");
		creg.setJsIdfile("");

		creg.setLlyName("");
		creg.setLlyTele("");
		creg.setLlyMobile("");
		creg.setLlyMail("");
		creg.setLlyIdtype("身份证");
		creg.setLlyIdno("");
		
		creg.setFinName("");
		creg.setFinTele("");
		creg.setFinMobile("");
		creg.setFinMail("");
		creg.setFinIdtype("身份证");
		creg.setFinIdno("");
		
		creg.setMarkAddr1("");
		creg.setMarkAddr2("");
		creg.setMarkAddr3("");
		
		Date today = new Date();
		creg.setAuthDate(today);
		creg.setAuthDateb(new Date(today.getTime()));
		creg.setAuthDatee(new Date(today.getTime()+(long)24*3600000*31));
		creg.setAuthDate2(today);
		creg.setAuthDateb2(new Date(today.getTime()));
		creg.setAuthDatee2(new Date(today.getTime()+(long)24*3600000*31));
		creg.setAuthDname("");
		creg.setAuthDname2("");
		creg.setAuthIdtype("身份证");
		creg.setAuthIdno("");
		creg.setAuthIdno2("");
		creg.setAuthMobile("");
		creg.setAuthMobile2("");
		creg.setAuthTele("");
		creg.setAuthMobile("");
		creg.setAuthOpt1(false);
		creg.setAuthOpt2(true);
		creg.setAuthOpt3(false);
		creg.setAuthOpt4(false);
		creg.setAuthOpt5(false);
		creg.setAuthOpt6(false);
		creg.setAuthOpt7(false);
		creg.setAuthOpt8(false);
		creg.setAuthOpt9(false);
		creg.setAuthOpt10(false);
		creg.setAuthOpt11(false);
		creg.setAuthOpt12(false);
		creg.setAuthOpt13(true);
		creg.setAuthOpt14(true);
		creg.setAuthOpt15(true);
		creg.setAuthOpt16(true);
		creg.setAuthOpt17(true);
		creg.setAuthOpt18(true);
		creg.setAuthOpt19(true);
		creg.setAuthOptblank("");
		creg.setJingshou("");
		creg.setComment1("");
		creg.setComment2("");
		creg.setComment3("");
		creg.setComment4("");
		creg.setComment5("");
		creg.setComment6("");
		creg.setComment7("");
		creg.setComment8("");
		creg.setComment9("");
		creg.setComment10("");
		creg.setComment11("");
		creg.setComment12("");
		creg.setComment13("");
		creg.setPrefix("吉林省长春市朝阳区");
		LinkedHashSet<Shareholder> shs = new LinkedHashSet<Shareholder>();
		creg.setShareholders(shs);
		creg.setPreconditions(new LinkedHashSet<Precondition>());
		creg.setSpecial("请选择");
	}
	

	
	public String getFieldValue(String field){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
		SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);
		String value= "";
		Shareholder firstShare;
		Set<Shareholder> shares = this.getShareholders();
		firstShare=shares.iterator().next();
		
		int jsnum = this.getJianshis().size();
		int zgnum= 0;
		int fzgnum = 0;
		for(Jianshi js:this.getJianshis()){
			if(js.getJsempl().equals("职工代表")){
				zgnum++;
			}else{
				fzgnum++;
			}
		}

		
		switch(field){ 
			case "id":
				value = String.valueOf(this.id);
				break;
			case "authDate":
				value = sf.format(this.authDate);
				break;
			case "authDateb":
				value = sf.format(this.authDateb);
				break;
			case "authDatee":
				value = sf.format(this.authDatee);
				break;
			case "authDname":
				value = this.authDname;
				break;
			case "authIdfile":
				value = this.authIdfile;
				break;
			case "authMobile":
				value = this.authMobile;
				break;
			case "authName":
				value = this.authName;
				break;
			case "authOpt1":
				value = this.authOpt1?"√":"　";
				break;
			case "authOpt2":
				value = this.authOpt2?"√":"　";
				break;
			case "authOpt3":
				value = this.authOpt3?"√":"　";
				break;
			case "authOpt4":
				value = this.authOpt4?"√":"　";
				break;
			case "authOpt5":
				value = this.authOpt5?"√":"　";
				break;
			case "authOpt6":
				value = this.authOpt6?"√":"　";
				break;
			case "authOpt7":
				value = this.authOpt7?"√":"　";
				break;
			case "authOpt8":
				value = this.authOpt8?"√":"　";
				break;
			case "authOpt9":
				value = this.authOpt9?"√":"　";
				break;
			case "authOpt10":
				value = this.authOpt10?"√":"　";
				break;
			case "authOpt11":
				value = this.authOpt11?"√":"　";
				break;
			case "authOpt12":
				value = this.authOpt12?"√":"　";
				break;
			case "authOpt13":
				value = this.authOpt13?"√":"　";
				break;
			case "authOpt13b":
				value = this.authOpt13?"　":"√";
				break;
			case "authOpt14":
				value = this.authOpt14?"√":"　";
				break;
			case "authOpt14b":
				value = this.authOpt14?"　":"√";
				break;
			case "authOpt15":
				value = this.authOpt15?"√":"　";
				break;
			case "authOpt15b":
				value = this.authOpt15?"　":"√";
				break;
			case "authOpt16":
				value = this.authOpt16?"√":"　";
				break;
			case "authOpt16b":
				value = this.authOpt16?"　":"√";
				break;
			case "authOptblank":
				value = this.authOptblank;
				break;
			case "authTele":
				value = this.authTele;
				break;
			case "caddress":
				value = this.prefix +this.caddress;
				break;
			case "capital":
				value = Utils.numFormat(this.capital);
				break;
			case "capptime":
				value = sft.format(this.capptime);
				break;
			case "capprove":
				value = this.capprove;
				break;
			case "cno":
				value = this.cno;
				break;
			case "ceoIdfile":
				value = this.ceoIdfile;
				break;
			case "ceoIdno":
				value = this.ceoIdno;
				break;
			case "ceoIdtype":
				value = this.ceoIdtype;
				break;
			case "ceoMail":
				value = this.ceoMail;
				break;
			case "ceoMobile":
				value = this.ceoMobile;
				break;
			case "ceoName":
				value = this.ceoName;
				break;
			case "ceoTele":
				value = this.ceoTele;
				break;
			case "cernum":
				value = String.valueOf(this.cernum);
				break;
			case "cname":
				value = this.cname;
				break;
			case "cnameno":
				value = this.cnameno;
				break;
			case "comment1":
				value = this.comment1;
				break;
			case "comment2":
				value = this.comment2;
				break;
			case "comment3":
				value = this.comment3;
				break;
			case "comment4":
				value = this.comment5;
				break;
			case "comment5":
				value = this.comment5;
				break;
			case "comment6":
				value = this.comment6;
				break;
			case "comment7":
				value = this.comment7;
				break;
			case "crange":
				value = this.crange;
				break;
			case "ctelephone":
				value = this.ctelephone;
				break;
			case "ctype":
				value = this.ctype;
				break;
			case "ctypeSub":
				value = this.ctypeSub;
				break;
			case "cyears":
				value = String.valueOf(this.cyears)+"年";
				if(this.cyearslong.equals("长期")){
					value= "长期";
				}
				break;
			case "cyears1":
				value = String.valueOf(this.cyears)+"年";
				if(this.cyearslong.equals("长期")){
					value= "　　年";
				}
				break;				
			case "cyearsopt1":
				if(cyearslong.trim().equals("")){
					value = "√";
				}else{
					value = "　";
				}
				break;
			case "cyearsopt2":
				if(cyearslong.trim().equals("长期")){
					value = "√";
				}else{
					value = "　";
				}
				break;
			case "cyearslong":
				value = this.cyearslong.trim();
				break;
			case "czip":
				value = this.czip;
				break;
			case "czxds":
				if(this.duty.equals("执行董事")){
					value = "√";
				}else{
					value ="　";
				}
				break;
			case "cdsz":
				if(this.duty.equals("董事长")){
					value = "√";
				}else{
					value ="　";
				}
				break;
			case "cjl":
				if(this.duty.equals("经理")){
					value = "√";
				}else{
					value ="　";
				}
				break;
			case "duty":
				value = this.duty;
				break;
			case "empnum":
				value = String.valueOf(this.empnum);
				break;
			case "empfornum":
				value = String.valueOf(this.empfornum);
				break;
			case "finIdfile":
				value = this.finIdfile;
				break;
			case "finIdno":
				value = this.finIdno;
				break;
			case "finIdtype":
				value = this.finIdtype;
				break;
			case "finMail":
				value = this.finMail;
				break;
			case "finMobile":
				value = this.finMobile;
				break;
			case "finName":
				value = this.finName;
				break;
			case "finTele":
				value = this.finTele;
				break;
			case "haddress":
				value = this.prefix +this.haddress;
				break;
			case "jlDuty":
				value = this.jlDuty;
				break;
			case "jlIdfile":
				value = this.jlIdfile;
				break;
			case "jlIdno":
				value = this.jlIdno;
				break;
			case "jlIdtype":
				value = this.jlIdtype;
				break;
			case "jlName":
				value = this.jlName;
				break;
			case "jsDuty":
				value = this.jsDuty;
				break;
			case "jsIdfile":
				value = this.jsIdfile;
				break;
			case "jsIdno":
				value = this.jsIdno;
				break;
			case "jsIdtype":
				value = this.jsIdtype;
				break;
			case "jsName":
				value = this.jsName;
				break;
			case "llyIdfile":
				value = this.llyIdfile;
				break;
			case "llyIdno":
				value = this.llyIdno;
				break;
			case "llyIdtype":
				value = this.llyIdtype;
				break;
			case "llyMail":
				value = this.llyMail;
				break;
			case "llyMobile":
				value = this.llyMobile;
				break;
			case "llyName":
				value = this.llyName;
				break;
			case "llyTele":
				value = this.llyTele;
				break;
			case "markAddr1":
				value = this.markAddr1;
				break;
			case "markAddr2":
				value = this.markAddr2;
				break;
			case "markAddr3":
				value = this.markAddr3;
				break;
			case "transport":
				value = this.transport;
				break;
			case "updtime":
				value = sft.format(this.updtime);
				break;
			case "userid":
				value = String.valueOf(this.userid);
				break;
			case "uuid":
				value = this.uuid;
				break;
			case "zxdsDuty":
				value = "";
				for(Dongshi item:this.getDongshis()){
					if(item.getDspos().equals("执行董事")){
						value = item.getDspos();
					}
				}
				break;
			case "zxdsIdfile":
				value = this.zxdsIdfile;
				break;
			case "zxdsIdno":
				value = "";
				for(Dongshi item:this.getDongshis()){
					if(item.getDspos().equals("执行董事")){
						value = item.getDsidno();
					}
				}
				break;
			case "zxdsIdtype":
				value = "";
				for(Dongshi item:this.getDongshis()){
					if(item.getDspos().equals("执行董事")){
						value = item.getDsidtype();
					}
				}
				break;
			case "zxdsName":
				value = "";
				for(Dongshi item:this.getDongshis()){
					if(item.getDspos().equals("执行董事")){
						value = item.getDsname();
					}
				}
				break;
			case "shareHolders":
				String ctype = this.ctypeSub;
				if(ctype==null){
					value = "";
					break;
				}
				if(ctype.equals("I1")){
					Shareholder sh=this.getShareholders().iterator().next();
					value = "<w:p wsp:rsidR=\"001A43BC\" wsp:rsidRDefault=\"001A43BC\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>名称：</w:t></w:r><w:r wsp:rsidR=\"002D5212\" wsp:rsidRPr=\"002D5212\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>，住址：_________________________________。</w:t></w:r></w:p><w:p wsp:rsidR=\"001A43BC\" wsp:rsidRDefault=\"00CA3C09\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"840\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>证照号码：</w:t></w:r><w:r wsp:rsidR=\"001A43BC\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>：</w:t></w:r><w:r wsp:rsidR=\"002D5212\" wsp:rsidRPr=\"002D5212\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+sh.getShidno()+"</w:t></w:r><w:r wsp:rsidR=\"001A43BC\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>.</w:t></w:r></w:p>";
				}
				if(ctype.equals("I2")){
					Shareholder sh=this.getShareholders().iterator().next();
					value = "<w:p wsp:rsidR=\"00D646D1\" wsp:rsidRDefault=\"00D646D1\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"200\" w:first-line=\"560\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>姓名：</w:t></w:r><w:r wsp:rsidR=\"00667991\" wsp:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>，住址：_________________________________。</w:t></w:r></w:p><w:p wsp:rsidR=\"00D646D1\" wsp:rsidRDefault=\"00D646D1\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"840\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>身份证号：</w:t></w:r><w:r wsp:rsidR=\"00667991\" wsp:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShidno()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>.</w:t></w:r></w:p>";
//					value = "<w:p w:rsidR=\"00D646D1\" w:rsidRDefault=\"00D646D1\"><w:pPr><w:spacing w:line=\"400\" w:lineRule=\"exact\"/><w:ind w:firstLineChars=\"200\" w:firstLine=\"560\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>姓名：</w:t></w:r><w:r w:rsidR=\"00667991\" w:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>，住址：_________________________________。</w:t></w:r></w:p><w:p w:rsidR=\"00D646D1\" w:rsidRDefault=\"00D646D1\"><w:pPr><w:spacing w:line=\"400\" w:lineRule=\"exact\"/><w:ind w:firstLineChars=\"300\" w:firstLine=\"840\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>身份证号：</w:t></w:r><w:r w:rsidR=\"00667991\" w:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShidno()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>.</w:t></w:r></w:p>";
				}
				if(ctype.equals("II")){
					value = "";
					int index = 1;
					for(Shareholder sh:this.getShareholders()){
						value = value + "<w:p wsp:rsidR=\"000340D4\" wsp:rsidRDefault=\"000340D4\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"200\" w:first-line=\"480\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+index+"、姓名（或名称）："+ sh.getShname()+ "，住址：_________________________________。</w:t></w:r></w:p><w:p wsp:rsidR=\"000340D4\" wsp:rsidRDefault=\"000340D4\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"720\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>身份证号（或证件号码）："+sh.getShidno()+".</w:t></w:r></w:p>";
//						value = value + "<w:p wsp:rsidR=\"000340D4\" wsp:rsidRDefault=\"000340D4\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"200\" w:first-line=\"480\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+index+"、姓名（或名称）："+ sh.getShname()+ "，住址：_________________________________。</w:t></w:r></w:p><w:p wsp:rsidR=\"000340D4\" wsp:rsidRDefault=\"000340D4\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"720\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>身份证号（或证件号码）："+sh.getShidno()+".</w:t></w:r></w:p>";
						index ++;
					}
				}
				break;
			case "sharemode":
				ctype = this.ctypeSub;
				if(ctype==null){
					value = "";
					break;
				}
				if(ctype.equals("I1")||ctype.equals("I2")||ctype.equals("II")){
					Shareholder sh=this.getShareholders().iterator().next();
					value = sh.getShmethod();
				}
				break;

			case "shareNames":
				value = this.getShareNames();
				break;
			case "shareHolders2":
				ctype = this.ctypeSub;
				value = "";
				if(ctype==null){
					value = "";
					break;
				}
				if(ctype.equals("I1")){
					Shareholder sh=this.getShareholders().iterator().next();
					value = "<w:p wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00CA3C09\" wsp:rsidRDefault=\"00382827\" wsp:rsidP=\"00382827\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"233\" w:left=\"847\" w:hanging-chars=\"3\" w:hanging=\"8\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"002D5212\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>，认缴</w:t></w:r><w:r wsp:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+sh.getShmethod()+"</w:t></w:r><w:r wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>出资</w:t></w:r><w:r wsp:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>万元，于</w:t></w:r><w:r wsp:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+sf.format(sh.getShdate())+"</w:t></w:r><w:r wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>前到位。</w:t></w:r></w:p>";
//					value = "<w:p w:rsidR=\"001A43BC\" w:rsidRPr=\"00CA3C09\" w:rsidRDefault=\"00382827\" w:rsidP=\"00382827\"><w:pPr><w:spacing w:line=\"400\" w:lineRule=\"exact\"/><w:ind w:leftChars=\"233\" w:left=\"847\" w:hangingChars=\"3\" w:hanging=\"8\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr></w:pPr><w:r w:rsidRPr=\"00B12552\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r w:rsidR=\"001A43BC\" w:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>，认缴</w:t></w:r><w:r w:rsidRPr=\"00B12552\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShmethod()+"</w:t></w:r><w:r w:rsidR=\"001A43BC\" w:rsidRPr=\"00382827\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>出资</w:t></w:r><w:r w:rsidRPr=\"00B12552\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r w:rsidR=\"001A43BC\" w:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>万元，于</w:t></w:r><w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/><w:r w:rsidRPr=\"00B12552\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+ sf.format(sh.getShdate()) +"</w:t></w:r><w:bookmarkEnd w:id=\"0\"/><w:r w:rsidR=\"001A43BC\" w:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>前到位。</w:t></w:r></w:p>";
				}
				if(ctype.equals("I2")){
					Shareholder sh=this.getShareholders().iterator().next();
					value = "<w:p wsp:rsidR=\"00D646D1\" wsp:rsidRPr=\"00D571D3\" wsp:rsidRDefault=\"00667991\" wsp:rsidP=\"00667991\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"233\" w:left=\"847\" w:hanging-chars=\"3\" w:hanging=\"8\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>，</w:t></w:r><w:r wsp:rsidR=\"00D646D1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>认缴"+sh.getShmethod()+"出资</w:t></w:r><w:r wsp:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r wsp:rsidR=\"00D646D1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>万元，于</w:t></w:r><w:r wsp:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+sf.format(sh.getShdate())+"</w:t></w:r><w:r wsp:rsidR=\"00D646D1\" wsp:rsidRPr=\"00D571D3\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>前到位。</w:t></w:r></w:p>";
//					value = "<w:p w:rsidR=\"00D646D1\" w:rsidRPr=\"00D571D3\" w:rsidRDefault=\"00667991\" w:rsidP=\"00667991\"><w:pPr><w:spacing w:line=\"400\" w:lineRule=\"exact\"/><w:ind w:leftChars=\"233\" w:left=\"847\" w:hangingChars=\"3\" w:hanging=\"8\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr></w:pPr><w:r w:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+ sh.getShname() +"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>，</w:t></w:r><w:r w:rsidR=\"00D646D1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>认缴"+sh.getShmethod()+"出资</w:t></w:r><w:r w:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r w:rsidR=\"00D646D1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>万</w:t></w:r><w:r w:rsidR=\"00D646D1\" w:rsidRPr=\"00D571D3\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>元，于</w:t></w:r><w:r w:rsidRPr=\"00667991\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+ sf.format(sh.getShdate()) +"</w:t></w:r><w:r w:rsidR=\"00D646D1\" w:rsidRPr=\"00D571D3\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\" w:hAnsi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"eastAsia\"/><w:sz w:val=\"28\"/><w:szCs w:val=\"28\"/></w:rPr><w:t>前到位。</w:t></w:r></w:p>";
				}
				if(ctype.equals("II")){
					int index = 1;
					for(Shareholder sh:this.getShareholders()){
						value = value + "<w:p wsp:rsidR=\"000340D4\" wsp:rsidRPr=\"001D02C1\" wsp:rsidRDefault=\"000340D4\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"720\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+index + "、</w:t></w:r><w:r wsp:rsidR=\"001D02C1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t>" + sh.getShname() +"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/></w:rPr><w:t>，认缴"+sh.getShmethod()+"出资</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:b/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/></w:rPr><w:t>万元，占注册资本的"+Utils.numFormat(sh.getShpercent())+"</w:t></w:r><w:r wsp:rsidRPr=\"001D02C1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>%，于</w:t></w:r><w:r wsp:rsidR=\"001D02C1\" wsp:rsidRPr=\"001D02C1\"><w:rPr><w:rFonts w:ascii=\"黑体\" w:fareast=\"黑体\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"黑体\"/><w:sz w:val=\"30\"/><w:sz-cs w:val=\"30\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+ sf.format(sh.getShdate()) +"</w:t></w:r><w:r wsp:rsidRPr=\"001D02C1\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/></w:rPr><w:t>前到位；</w:t></w:r></w:p>";
//						value = value + "<w:p wsp:rsidR=\"001A43BC\" wsp:rsidRPr=\"00CA3C09\" wsp:rsidRDefault=\"001A43BC\"><w:pPr><w:spacing w:line=\"400\" w:line-rule=\"exact\"/><w:ind w:first-line-chars=\"300\" w:first-line=\"840\"/><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+index + "、" + sh.getShname() +"，认缴"+sh.getShmethod()+"出资</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:b/><w:color w:val=\"000000\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r><w:r wsp:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>万元，于</w:t></w:r><w:r wsp:rsidR=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>  </w:t></w:r><w:r wsp:rsidR=\"00696E1D\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>"+ sf.format(sh.getShdate()) +"</w:t></w:r><w:r wsp:rsidR=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>   </w:t></w:r><w:r wsp:rsidR=\"00696E1D\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidRPr=\"00CA3C09\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>前到位。</w:t></w:r></w:p>";
						index++;
					}
				}
				break;
			case "shcopy":
				int copy = this.getShareholders().size()+2;
				value = String.valueOf(copy);
				break;
			case "shareTable":
				String blankLine = "<w:tr wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"008E350B\"><w:trPr><w:cantSplit/><w:trHeight w:val=\"537\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1609\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1025\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1620\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1475\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"008E350B\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1164\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:right=\"-40\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc></w:tr>";
				String lastLine = "<w:tr wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"008E350B\"><w:trPr><w:cantSplit/><w:trHeight w:val=\"537\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1609\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1025\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1620\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1475\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"008E350B\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1164\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:right=\"-40\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00B27F11\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr></w:p></w:tc></w:tr>"; 
				int index = 0;
				value = "";
				for(Shareholder sh:this.getShareholders()){
					value = value + "<w:tr wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"008E350B\"><w:trPr><w:cantSplit/><w:trHeight w:val=\"537\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1609\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+sh.getShname()+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1025\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+sh.getShidtype()+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1620\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+sh.getShidno()+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1475\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"008E350B\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"001D4C24\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"008E350B\"><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+sf.format(sh.getShdate())+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1164\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+sh.getShmethod()+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:right=\"-40\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShamount())+"</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1080\" w:type=\"dxa\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00B27F11\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"008E350B\" wsp:rsidP=\"008E350B\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>"+Utils.numFormat(sh.getShpercent( ))+"%</w:t></w:r></w:p></w:tc></w:tr>";
					index++;
				}
				for(int i=index;i<18;i++){
					value = value + blankLine;
				}
				value = value +lastLine;
				break;
			case "shareinfo":
				value = getShinfo(false);
				break;
			case "shname":
				value = firstShare.getShname();
				break;
			case "shaddress":
				value = firstShare.getShaddr();
				break;
			case "shamount":
				value = Utils.numFormat(firstShare.getShamount());
				break;
			case "prefix":
				value = this.prefix;
				break;
			case "shidtype":
				value = firstShare.getShidtype();
				break;
			case "shidno":
				value = firstShare.getShidno();
				break;
			case "dsnum":
				int dsnum = this.getDongshis().size();
				value = Utils.numFormat(dsnum);
				break;
			case "jsnum":
				value = Utils.numFormat(jsnum);
				break;
			case "zgnum":
				value = Utils.numFormat(zgnum);
				break;
			case "fzgnum":
				value = Utils.numFormat(fzgnum);
				break;
			case "zcnum":
				value = Utils.numFormat(shares.size()+2);
				break;
			default:
				value = "";
				break;
		}
		if(value==null) value = "";
		return value;
	}
	public String getShinfo2(boolean preview){
		String tHead="<w:tbl><w:tblPr><w:tblW w:w=\"9720\" w:type=\"dxa\"/><w:tblInd w:w=\"-612\" w:type=\"dxa\"/><w:tblBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/><w:left w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/><w:bottom w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/><w:right w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/><w:insideH w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/><w:insideV w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tblBorders><w:tblLook w:val=\"04A0\"/></w:tblPr><w:tblGrid><w:gridCol w:w=\"2520\"/><w:gridCol w:w=\"3240\"/><w:gridCol w:w=\"1260\"/><w:gridCol w:w=\"2700\"/></w:tblGrid>";
		String midrow = "<w:tr wsp:rsidR=\"00025C63\"><w:tc><w:tcPr><w:tcW w:w=\"2520\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00025C63\" wsp:rsidRDefault=\"00025C63\" wsp:rsidP=\"00025C63\"><w:pPr><w:pStyle w:val=\"a3\"/><w:ind w:left=\"0\"/><w:rPr><w:color w:val=\"000000\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><w:color w:val=\"000000\"/></w:rPr><w:t>shname</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"3240\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00025C63\" wsp:rsidRDefault=\"00025C63\" wsp:rsidP=\"00025C63\"><w:pPr><w:pStyle w:val=\"a3\"/><w:ind w:left=\"0\"/><w:rPr><w:color w:val=\"000000\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><w:color w:val=\"000000\"/></w:rPr><w:t>shaddress</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1260\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00025C63\" wsp:rsidRDefault=\"00025C63\" wsp:rsidP=\"00025C63\"><w:pPr><w:pStyle w:val=\"a3\"/><w:ind w:left=\"0\"/><w:rPr><w:color w:val=\"000000\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><w:color w:val=\"000000\"/></w:rPr><w:t>shidtype</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"2700\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00025C63\" wsp:rsidRDefault=\"00025C63\" wsp:rsidP=\"00025C63\"><w:pPr><w:pStyle w:val=\"a3\"/><w:ind w:left=\"0\"/><w:rPr><w:color w:val=\"000000\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><w:color w:val=\"000000\"/></w:rPr><w:t>shidno</w:t></w:r></w:p></w:tc></w:tr>";
		String tEnd = "</w:tbl>";
		String value= "";
		Set<Shareholder> shares = this.getShareholders();
		value = value + tHead;
		for(Shareholder sh:shares){
			String str = midrow.replace("shname", sh.getShname());
			str = str.replace("shaddress", sh.getShaddr());
			str = str.replace("shidtype", sh.getShidtype());
			str = str.replace("shidno", sh.getShidno());
			value = value +str;
		}
		value = value + tEnd;
		return value;
	}
	
	public String getShinfo(boolean preview){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
		Set<Shareholder> shares = this.getShareholders();
		boolean index;
		if(shares.size()>1){
			index = true;
		}else{
			index = false;
		}
		
		String h1="<w:p wsp:rsidR=\"008C3150\" wsp:rsidRDefault=\"008C3150\" wsp:rsidP=\"008C3150\"><w:pPr><w:pStyle w:val=\"a8\"/><w:spacing w:line=\"288\" w:line-rule=\"auto\"/><w:ind w:first-line-chars=\"200\" w:first-line=\"480\"/><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr></w:pPr>";
		String h2="<w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>股东</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t>shname</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>认缴的出资额为</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t>shamount</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>万元人民币，占注册资本的</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shpercent</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>％。</w:t></w:r>";
		String h2np="<w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>股东</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shname</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>认缴的出资额为</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shamount</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>万元人民币，占注册资本的</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\"/><wx:font wx:val=\"Times New Roman\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shpercent</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"Times New Roman\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:color w:val=\"000000\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>％。</w:t></w:r>";
		String qizhong = "<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>其中</w:t></w:r>";
		String yi="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>以</w:t></w:r>";
		String fschuzi = "<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t>shmode</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>方式出资</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t>shnum</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/><w:u w:val=\"single\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>万元</w:t></w:r>";
		String fschuzinp ="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shmode</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>方式出资</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shnum</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> </w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>万元</w:t></w:r>";
		String pause="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>、</w:t></w:r>";
		String comma="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>，</w:t></w:r>";
		String fin="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>。</w:t></w:r>";
		String end="<w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>在 </w:t></w:r><w:r wsp:rsidR=\"00AF2FC2\"><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t>shdate</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:fareast=\"仿宋_GB2312\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"仿宋_GB2312\"/><w:sz w:val=\"24\"/><w:sz-cs w:val=\"24\"/></w:rPr><w:t> 前足额缴纳。</w:t></w:r></w:p>";
		
		String value = "";
		String str = "";
		int ind=1;
		for(Shareholder sh:shares){
			value=value+h1;
			if(index){
				str = pause.replace("、", Utils.numFormat(ind)+"、");
				value = value + str;
			}
			if(preview){
				str=h2.replace("shname", sh.getShname());
			}else{
				str=h2np.replace("shname", sh.getShname());
			}
			str=str.replace("shpercent", Utils.numFormat(sh.getShpercent(),2));
			str=str.replace("shamount", Utils.numFormat(sh.getShamount()));
			value = value + str;
			int modCount=1;
			int modSize=0;
			List<Shmode> shmodes=sh.getShmodes();
			for(Shmode mod:shmodes){
				if(mod.getShamount()<=0){
					continue;
				}
				modSize++;
			}
			for(Shmode mod:shmodes){
				if(mod.getShamount()<=0){
					continue;
				}
				if(modCount==1){
					value = value + qizhong;
				}
				value = value +yi;
				if(preview){
					str = fschuzi.replace("shmode", mod.getShmethod());
				}else{
					str = fschuzinp.replace("shmode", mod.getShmethod());
				}
				str = str.replace("shnum", Utils.numFormat(mod.getShamount()));
				value = value + str;
				if(modCount==modSize){
					value = value + comma;
				}else if(modCount<modSize) {
					value = value + pause;
				}
				modCount++;
			}
			str = end.replace("shdate", sf.format(sh.getShdate()));
			value = value + str;
			ind++;
		}
		return value;
	}
	
	public String getShtable(){
		String value = "";
		String dataLine = "<w:tr wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"000D7E82\"><w:trPr><w:cantSplit/><w:trHeight w:val=\"586\"/><w:jc w:val=\"center\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1217\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shname</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1134\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shidtype</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"2410\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shidno</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1418\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"002A5490\"><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shdate</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1417\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-28\" w:left=\"-59\" w:right=\"-70\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shmode</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"993\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-42\" w:left=\"-88\" w:right=\"-40\"/><w:jc w:val=\"right\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shamount</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"708\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:tabs><w:tab w:val=\"left\" w:pos=\"-35\"/></w:tabs><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-16\" w:left=\"-34\" w:right=\"-108\"/><w:jc w:val=\"right\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>percent</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4091\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:tabs><w:tab w:val=\"left\" w:pos=\"0\"/></w:tabs><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:right=\"-56\"/><w:jc w:val=\"left\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shaddress</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1508\" w:type=\"dxa\"/><w:tcBorders><w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-40\" w:right=\"-95\" w:hanging-chars=\"35\" w:hanging=\"84\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shphone</w:t></w:r></w:p></w:tc></w:tr>";
		String lastLine = "<w:tr wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"000D7E82\"><w:trPr><w:cantSplit/><w:trHeight w:val=\"552\"/><w:jc w:val=\"center\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1217\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shname</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1134\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shidtype</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"2410\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shidno</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1418\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"002A5490\"><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shdate</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1417\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-28\" w:left=\"-59\" w:right=\"-70\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shmode</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"993\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-42\" w:left=\"-88\" w:right=\"-40\"/><w:jc w:val=\"right\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shamount</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"708\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:tabs><w:tab w:val=\"left\" w:pos=\"-35\"/></w:tabs><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-16\" w:left=\"-34\" w:right=\"-108\"/><w:jc w:val=\"right\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>percent</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4091\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:tabs><w:tab w:val=\"left\" w:pos=\"0\"/></w:tabs><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:right=\"-56\"/><w:jc w:val=\"left\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shaddress</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"1508\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00BB3CE6\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00BB3CE6\" wsp:rsidP=\"00531CB2\"><w:pPr><w:spacing w:line=\"360\" w:line-rule=\"exact\"/><w:ind w:left-chars=\"-40\" w:right=\"-95\" w:hanging-chars=\"35\" w:hanging=\"84\"/><w:rPr><w:rFonts w:h-ansi=\"宋体\"/><w:sz w:val=\"24\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:h-ansi=\"宋体\" w:hint=\"fareast\"/><w:sz w:val=\"24\"/></w:rPr><w:t>shphone</w:t></w:r></w:p></w:tc></w:tr>";
		String str="";
		str = dataLine;
		int rowcount=1;
		for(Shareholder sh:this.getShareholders()){
			String line="";

			int modcount=1;
			for(Shmode mod:sh.getShmodes()){
				if(rowcount % MAXROW>0){
					line = dataLine;
				}else{
					line = lastLine;
				}
				str= line;
				if(mod.getShamount()>0){
					if(modcount==1){
						str= str.replace("shname", sh.getShname());
						str = str.replace("shidtype", sh.getShidtype());
						str = str.replace("shidno", sh.getShidno());
						str = str.replace("shdate", Utils.formatDate(sh.getShdate(),"yyyy/MM/dd"));
						str = str.replace("shmode", mod.getShmethod());
						str = str.replace("shamount", Utils.numFormat(mod.getShamount()));
						str = str.replace("percent", Utils.numFormat(mod.getShpercent(),2)+"%");
						str = str.replace("shaddress", sh.getShaddr());
						str = str.replace("shphone",sh.getShphone());
						value = value + str;
						modcount++;
						rowcount++;
					}else{
						str= str.replace("shname", "");
						str = str.replace("shidtype", "");
						str = str.replace("shidno", "");
						str = str.replace("shdate", "");
						str = str.replace("shamount", Utils.numFormat(mod.getShamount()));
						str = str.replace("shmode", mod.getShmethod());
						str = str.replace("percent", Utils.numFormat(mod.getShpercent(),2)+"%");
						str = str.replace("shaddress", "");
						str = str.replace("shphone","");
						value = value + str;
						modcount++;
						rowcount++;
					}
				}
			}
		}
		if(rowcount%MAXROW>0){
			int rows = rowcount%MAXROW;
			String bLine = dataLine;
			String blLine = lastLine; 
			bLine = bLine.replace("shname", "");
			bLine = bLine.replace("shidtype", "");
			bLine = bLine.replace("shidno", "");
			bLine = bLine.replace("shdate", "");
			bLine = bLine.replace("shmode", "");
			bLine = bLine.replace("percent", "");
			bLine = bLine.replace("shaddress", "");
			bLine = bLine.replace("shphone","");
			bLine = bLine.replace("shamount","");
			
			
			blLine = blLine.replace("shname", "");
			blLine = blLine.replace("shidtype", "");
			blLine = blLine.replace("shidno", "");
			blLine = blLine.replace("shdate", "");
			blLine = blLine.replace("shmode", "");
			blLine = blLine.replace("percent", "");
			blLine = blLine.replace("shaddress", "");
			blLine = blLine.replace("shphone","");
			blLine = blLine.replace("shamount","");

			for(int r=rows;r<=MAXROW;r++){
				if(r<MAXROW){
					value = value + bLine;
				}else{
					value = value + blLine;
				}
			}
		}
		return value;
	}
	
	public String getDsJsTable(){
		String value = "";
		String line1 = "<w:tr wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"00DC6AE8\"><w:trPr><w:trHeight w:val=\"3791\"/><w:jc w:val=\"center\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"8859\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>姓名</w:t></w:r><w:r wsp:rsidR=\"00DC6AE8\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perName </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>职务</w:t></w:r><w:r wsp:rsidR=\"001A321F\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perDuty </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件类型</w:t></w:r><w:r wsp:rsidR=\"00DC6AE8\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdtype </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件号码</w:t></w:r><w:r wsp:rsidR=\"00DC6AE8\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdno </w:t></w:r></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>（身份证件复印件粘贴处）</w:t></w:r></w:p></w:tc></w:tr>";
		String line2 = "<w:tr wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"00DC6AE8\"><w:trPr><w:trHeight w:val=\"3959\"/><w:jc w:val=\"center\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"8859\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"001A321F\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"001A321F\" wsp:rsidP=\"001A321F\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>姓名</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perName </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>职务</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perDuty </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件类型</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdtype </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件号码</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdno </w:t></w:r></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00DC6AE8\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>（身份证件复印件粘贴处）</w:t></w:r></w:p></w:tc></w:tr>";
		String line3 = "<w:tr wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"00DC6AE8\"><w:trPr><w:trHeight w:val=\"4091\"/><w:jc w:val=\"center\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"8859\" w:type=\"dxa\"/></w:tcPr><w:p wsp:rsidR=\"001A321F\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"001A321F\" wsp:rsidP=\"001A321F\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>姓名</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perName </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>职务</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perDuty </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件类型</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdtype </w:t></w:r><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>身份证件号码</w:t></w:r><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/><w:u w:val=\"single\"/></w:rPr><w:t> perIdno </w:t></w:r></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00DC6AE8\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00DC6AE8\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00DC6AE8\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr></w:p><w:p wsp:rsidR=\"00AA29FE\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00AA29FE\" wsp:rsidP=\"00DC6AE8\"><w:pPr><w:pStyle w:val=\"New\"/><w:spacing w:line=\"500\" w:line-rule=\"exact\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"00AC3351\"><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz-cs w:val=\"21\"/></w:rPr><w:t>（身份证件复印件粘贴处）</w:t></w:r></w:p></w:tc></w:tr>";
		
		List<Person> persons = new ArrayList<Person>();
		
		Person per = new Person();
		per.setName(this.jlName);
		per.setDuty("经理");
		per.setIdType(this.jlIdtype);
		per.setIdNo(this.jlIdno);
		
		persons.add(per);
		
		for(Dongshi ds:this.dongshis){
			per = new Person();
			per.setName(ds.getDsname());
			per.setDuty(ds.getDspos());
			per.setIdType(ds.getDsidtype());
			per.setIdNo(ds.getDsidno());
			boolean exist= false;
			for(Person p:persons){
				//检查该人员是否已经存在
				if(p.getIdNo().equals(per.getIdNo()) && p.getName().equals(per.getName())){
					//如果已经存在，则只需把职务合并
					p.setDuty(p.getDuty()+","+per.getDuty());
					exist = true;
					break;
				}
			}
			//如查不存在，则增加该人员 
			if(!exist){
				persons.add(per);
			}
		}

		for(Jianshi js:this.jianshis){
			per = new Person();
			per.setName(js.getJsname());
			per.setDuty(js.getJspos());
			per.setIdType(js.getJsidtype());
			per.setIdNo(js.getJsidno());
			boolean exist= false;
			for(Person p:persons){
				//检查该人员是否已经存在
				if(p.getIdNo().equals(per.getIdNo()) && p.getName().equals(per.getName())){
					//如果已经存在，则只需把职务合并
					p.setDuty(p.getDuty()+","+per.getDuty());
					exist = true;
					break;
				}
			}
			//如查不存在，则增加该人员 
			if(!exist){
				persons.add(per);
			}
		}
		
		int perIndex = 1;
		String tLine = line1;
		for(Person person:persons){
			int index = perIndex % 3;
			if(index ==1){
				tLine = line1;
			}else if(index ==2){
				tLine = line2;
			}else{
				tLine = line3;
			}
			tLine = tLine.replace("perName", person.getName());
			tLine = tLine.replace("perDuty", person.getDuty());
			tLine = tLine.replace("perIdtype", person.getIdType());
			tLine = tLine.replace("perIdno", person.getIdNo());
			value = value + tLine;
			perIndex++;
		}
		perIndex--;
		int row = perIndex % 3;
		if(row>0){
			for(int r=row+1;r<=3;r++){
				if(r==2){
					tLine = line2;
				}
				if(r==3){
					tLine = line3;
				}
				tLine = tLine.replace("perName", "      ");
				tLine = tLine.replace("perDuty", "    ");
				tLine = tLine.replace("perIdtype", "      ");
				tLine = tLine.replace("perIdno", "                ");
				value = value + tLine;
			}
		}
		return value;
	}
	
	public String getDsNames(boolean preview){
		String value = "";
		String pdsname = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>dsname</w:t></w:r>";
		String dsname = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>dsname</w:t></w:r>";
		String pause = "<w:r wsp:rsidRPr=\"001C7DBB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>、</w:t></w:r>";
		int dsInd = 1;
		String str = "";
		for(Dongshi ds:this.getDongshis()){
			if(preview){
				str = pdsname;
			}else{
				str = dsname;
			}
			str = str.replace("dsname", ds.getDsname());
			value = value +str;
			if(dsInd<this.getDongshis().size()){
				value = value + pause;
			}
			dsInd++;
		}
		return value;
	}

	public String getJsNames(boolean preview){
		String value = "";
		String pname = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>jsname</w:t></w:r>";
		String name = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>jsname</w:t></w:r>";
		String pause = "<w:r wsp:rsidRPr=\"001C7DBB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>、</w:t></w:r>";
		int jsInd = 1;
		String str = "";
		for(Jianshi js:this.getJianshis()){
			if(preview){
				str = pname;
			}else{
				str = name;
			}
			str = str.replace("jsname", js.getJsname());
			value = value +str;
			if(jsInd<this.getJianshis().size()){
				value = value + pause;
			}
			jsInd++;
		}
		return value;
	}
	
	//取职工监事字符串，以顿号分隔
	public String getZgNames(boolean preview){  
		String value = "";
		String pname = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>jsname</w:t></w:r>";
		String name = "<w:r wsp:rsidR=\"00D560AB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>jsname</w:t></w:r>";
		String pause = "<w:r wsp:rsidRPr=\"001C7DBB\"><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>、</w:t></w:r>";
		int jsInd = 1;
		String str = "";
		int zgnum = 0;
		for(Jianshi js:this.getJianshis()){
			if(js.getJsempl().equals("职工代表")){
				zgnum++;
			}
		}
		
		for(Jianshi js:this.getJianshis()){
			if(!js.getJsempl().equals("职工代表")){
				continue;
			}
			if(preview){
				str = pname;
			}else{
				str = name;
			}
			
			str = str.replace("jsname", js.getJsname());
			value = value +str;
			if(jsInd<zgnum){
				value = value + pause;
			}
			jsInd++;
		}
		return value;
	}
	
	public String getDszName(){
		String value = "";
		for(Dongshi ds:this.getDongshis()){
			if(ds.getDspos().equals("董事长")){
				value = ds.getDsname();
			}
		}
		return value;
	}
	
	public String getJszName(){
		String value = "";
		for(Jianshi p:this.getJianshis()){
			if(p.getJspos().equals("监事会主席")){
				value = p.getJsname();
			}
		}
		return value;
	}
	
	public String getComType(){
		String type = "";
		String t1= "";
		String t2= "";
		String t3= "";
		
		if(duty.equals("董事长")){
			t1= "Z1";
		}else if(duty.equals("经理")){
			t1= "Z3";
		}else{
			t1= "Z2";
		}
		
		if(this.getShareholders().size()>1){
			t2="II";
		}else{
			t2="I";
		}
		
		t3 = "1";
		if(duty.equals("执行董事")){
			t3 = "1";
		}
		if(duty.equals("经理")){
			if(!dshui){
				t3 = "2";
			}else{
				if(jshui){
					t3 = "a";
				}else{
					t3 = "b";
				}
			}
		}
		if(duty.equals("董事长")){
			if(jshui){
				t3 = "a";
			}else{
				t3 = "b";
			}
		}
		type = t1+t2+t3;
		return type;
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAuthDateb() {
		return this.authDateb;
	}

	public void setAuthDateb(Date authDateb) {
		this.authDateb = authDateb;
	}

	public Date getAuthDatee() {
		return this.authDatee;
	}

	public void setAuthDatee(Date authDatee) {
		this.authDatee = authDatee;
	}

	public String getAuthDname() {
		return this.authDname;
	}

	public void setAuthDname(String authDname) {
		this.authDname = authDname;
	}

	public String getAuthIdfile() {
		return this.authIdfile;
	}

	public void setAuthIdfile(String authIdfile) {
		this.authIdfile = authIdfile;
	}

	public String getAuthMobile() {
		return this.authMobile;
	}

	public void setAuthMobile(String authMobile) {
		this.authMobile = authMobile;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public boolean getAuthOpt1() {
		return this.authOpt1;
	}

	public void setAuthOpt1(boolean authOpt1) {
		this.authOpt1 = authOpt1;
	}

	public boolean getAuthOpt10() {
		return this.authOpt10;
	}

	public void setAuthOpt10(boolean authOpt10) {
		this.authOpt10 = authOpt10;
	}

	public boolean getAuthOpt11() {
		return this.authOpt11;
	}

	public void setAuthOpt11(boolean authOpt11) {
		this.authOpt11 = authOpt11;
	}

	public boolean getAuthOpt12() {
		return this.authOpt12;
	}

	public void setAuthOpt12(boolean authOpt12) {
		this.authOpt12 = authOpt12;
	}

	public boolean getAuthOpt13() {
		return this.authOpt13;
	}

	public void setAuthOpt13(boolean authOpt13) {
		this.authOpt13 = authOpt13;
	}

	public boolean getAuthOpt14() {
		return this.authOpt14;
	}

	public void setAuthOpt14(boolean authOpt14) {
		this.authOpt14 = authOpt14;
	}

	public boolean getAuthOpt15() {
		return this.authOpt15;
	}

	public void setAuthOpt15(boolean authOpt15) {
		this.authOpt15 = authOpt15;
	}

	public boolean getAuthOpt16() {
		return this.authOpt16;
	}

	public void setAuthOpt16(boolean authOpt16) {
		this.authOpt16 = authOpt16;
	}

	public boolean getAuthOpt2() {
		return this.authOpt2;
	}

	public void setAuthOpt2(boolean authOpt2) {
		this.authOpt2 = authOpt2;
	}

	public boolean getAuthOpt3() {
		return this.authOpt3;
	}

	public void setAuthOpt3(boolean authOpt3) {
		this.authOpt3 = authOpt3;
	}

	public boolean getAuthOpt4() {
		return this.authOpt4;
	}

	public void setAuthOpt4(boolean authOpt4) {
		this.authOpt4 = authOpt4;
	}

	public boolean getAuthOpt5() {
		return this.authOpt5;
	}

	public void setAuthOpt5(boolean authOpt5) {
		this.authOpt5 = authOpt5;
	}

	public boolean getAuthOpt6() {
		return this.authOpt6;
	}

	public void setAuthOpt6(boolean authOpt6) {
		this.authOpt6 = authOpt6;
	}

	public boolean getAuthOpt7() {
		return this.authOpt7;
	}

	public void setAuthOpt7(boolean authOpt7) {
		this.authOpt7 = authOpt7;
	}

	public boolean getAuthOpt8() {
		return this.authOpt8;
	}

	public void setAuthOpt8(boolean authOpt8) {
		this.authOpt8 = authOpt8;
	}

	public boolean getAuthOpt9() {
		return this.authOpt9;
	}

	public void setAuthOpt9(boolean authOpt9) {
		this.authOpt9 = authOpt9;
	}

	public String getAuthOptblank() {
		return this.authOptblank;
	}

	public void setAuthOptblank(String authOptblank) {
		this.authOptblank = authOptblank;
	}

	public String getAuthTele() {
		return this.authTele;
	}

	public void setAuthTele(String authTele) {
		this.authTele = authTele;
	}

	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public float getCapital() {
		return this.capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	public String getCeoIdfile() {
		return this.ceoIdfile;
	}

	public void setCeoIdfile(String ceoIdfile) {
		this.ceoIdfile = ceoIdfile;
	}

	public String getCeoIdno() {
		return this.ceoIdno;
	}

	public void setCeoIdno(String ceoIdno) {
		this.ceoIdno = ceoIdno;
	}

	public String getCeoIdtype() {
		return this.ceoIdtype;
	}

	public void setCeoIdtype(String ceoIdtype) {
		this.ceoIdtype = ceoIdtype;
	}

	public String getCeoMail() {
		return this.ceoMail;
	}

	public void setCeoMail(String ceoMail) {
		this.ceoMail = ceoMail;
	}

	public String getCeoMobile() {
		return this.ceoMobile;
	}

	public void setCeoMobile(String ceoMobile) {
		this.ceoMobile = ceoMobile;
	}

	public String getCeoName() {
		return this.ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getCeoTele() {
		return this.ceoTele;
	}

	public void setCeoTele(String ceoTele) {
		this.ceoTele = ceoTele;
	}

	public int getCernum() {
		return this.cernum;
	}

	public void setCernum(int cernum) {
		this.cernum = cernum;
	}

	public String getCname() {
		return this.cname;
	}
	
	public String getCnameUrl(){
		String cname = "http://"+this.cname;
		String urlstr = "";
		try {
			URI uri = new URI(cname);
			URL url = new URL(uri.toASCIIString());
			//url = java.net.URLEncoder.encode(cname,"UTF-8"); 
			urlstr = url.toString().substring(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlstr;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnameno() {
		return this.cnameno;
	}

	public void setCnameno(String cnameno) {
		this.cnameno = cnameno;
	}

	public String getComment1() {
		return this.comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return this.comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return this.comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return this.comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return this.comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getComment6() {
		return this.comment6;
	}

	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}

	public String getComment7() {
		return this.comment7;
	}

	public void setComment7(String comment7) {
		this.comment7 = comment7;
	}

	public String getCrange() {
		return this.crange;
	}

	public void setCrange(String crange) {
		this.crange = crange;
	}

	public String getCtelephone() {
		return this.ctelephone;
	}

	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCtypeSub() {
		return this.ctypeSub;
	}

	public void setCtypeSub(String ctypeSub) {
		this.ctypeSub = ctypeSub;
	}

	public int getCyears() {
		return this.cyears;
	}

	public void setCyears(int cyears) {
		this.cyears = cyears;
	}

	public String getCyearslong() {
		if(cyearslong == null){
			cyearslong ="";
		}
		return this.cyearslong;
	}

	public void setCyearslong(String cyearslong) {
		if(cyearslong == null){
			cyearslong = "";
		}
		this.cyearslong = cyearslong;
	}

	public String getCzip() {
		return this.czip;
	}

	public void setCzip(String czip) {
		this.czip = czip;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	//用列表存取职务信息
	public List<String> getDutyList() {
		return Utils.getStringAsList(this.duty);
	}

	public void setDutyList(List<String> dutys) {
		if(dutys!=null)
			this.setDuty(dutys.toString());
	}
	

	public String getFinIdfile() {
		return this.finIdfile;
	}

	public void setFinIdfile(String finIdfile) {
		this.finIdfile = finIdfile;
	}

	public String getFinIdno() {
		return this.finIdno;
	}

	public void setFinIdno(String finIdno) {
		this.finIdno = finIdno;
	}

	public String getFinIdtype() {
		return this.finIdtype;
	}

	public void setFinIdtype(String finIdtype) {
		this.finIdtype = finIdtype;
	}

	public String getFinMail() {
		return this.finMail;
	}

	public void setFinMail(String finMail) {
		this.finMail = finMail;
	}

	public String getFinMobile() {
		return this.finMobile;
	}

	public void setFinMobile(String finMobile) {
		this.finMobile = finMobile;
	}

	public String getFinName() {
		return this.finName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}

	public String getFinTele() {
		return this.finTele;
	}

	public void setFinTele(String finTele) {
		this.finTele = finTele;
	}

	public String getHaddress() {
		return this.haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getJlDuty() {
		return this.jlDuty;
	}

	public void setJlDuty(String jlDuty) {
		this.jlDuty = jlDuty;
	}

	public String getJlIdfile() {
		return this.jlIdfile;
	}

	public void setJlIdfile(String jlIdfile) {
		this.jlIdfile = jlIdfile;
	}

	public String getJlIdno() {
		return this.jlIdno;
	}

	public void setJlIdno(String jlIdno) {
		this.jlIdno = jlIdno;
	}

	public String getJlIdtype() {
		return this.jlIdtype;
	}

	public void setJlIdtype(String jlIdtype) {
		this.jlIdtype = jlIdtype;
	}

	public String getJlName() {
		return this.jlName;
	}

	public void setJlName(String jlName) {
		this.jlName = jlName;
	}

	public String getJsDuty() {
		return this.jsDuty;
	}

	public void setJsDuty(String jsDuty) {
		this.jsDuty = jsDuty;
	}

	public String getJsIdfile() {
		return this.jsIdfile;
	}

	public void setJsIdfile(String jsIdfile) {
		this.jsIdfile = jsIdfile;
	}

	public String getJsIdno() {
		return this.jsIdno;
	}

	public void setJsIdno(String jsIdno) {
		this.jsIdno = jsIdno;
	}

	public String getJsIdtype() {
		return this.jsIdtype;
	}

	public void setJsIdtype(String jsIdtype) {
		this.jsIdtype = jsIdtype;
	}

	public String getJsName() {
		return this.jsName;
	}

	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	public String getLlyIdfile() {
		return this.llyIdfile;
	}

	public void setLlyIdfile(String llyIdfile) {
		this.llyIdfile = llyIdfile;
	}

	public String getLlyIdno() {
		return this.llyIdno;
	}

	public void setLlyIdno(String llyIdno) {
		this.llyIdno = llyIdno;
	}

	public String getLlyIdtype() {
		return this.llyIdtype;
	}

	public void setLlyIdtype(String llyIdtype) {
		this.llyIdtype = llyIdtype;
	}

	public String getLlyMail() {
		return this.llyMail;
	}

	public void setLlyMail(String llyMail) {
		this.llyMail = llyMail;
	}

	public String getLlyMobile() {
		return this.llyMobile;
	}

	public void setLlyMobile(String llyMobile) {
		this.llyMobile = llyMobile;
	}

	public String getLlyName() {
		return this.llyName;
	}

	public void setLlyName(String llyName) {
		this.llyName = llyName;
	}

	public String getLlyTele() {
		return this.llyTele;
	}

	public void setLlyTele(String llyTele) {
		this.llyTele = llyTele;
	}

	public String getMarkAddr1() {
		return this.markAddr1;
	}

	public void setMarkAddr1(String markAddr1) {
		this.markAddr1 = markAddr1;
	}

	public String getMarkAddr2() {
		return this.markAddr2;
	}

	public void setMarkAddr2(String markAddr2) {
		this.markAddr2 = markAddr2;
	}

	public String getMarkAddr3() {
		return this.markAddr3;
	}

	public void setMarkAddr3(String markAddr3) {
		this.markAddr3 = markAddr3;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}


	public Date getUpdtime() {
		return updtime;
	}

	public void setUpdtime(Date updtime) {
		this.updtime = updtime;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getZxdsDuty() {
		return this.zxdsDuty;
	}

	public void setZxdsDuty(String zxdsDuty) {
		this.zxdsDuty = zxdsDuty;
	}

	public String getZxdsIdfile() {
		return this.zxdsIdfile;
	}

	public void setZxdsIdfile(String zxdsIdfile) {
		this.zxdsIdfile = zxdsIdfile;
	}

	public String getZxdsIdtype() {
		return this.zxdsIdtype;
	}

	public void setZxdsIdtype(String zxdsIdtype) {
		this.zxdsIdtype = zxdsIdtype;
	}

	public String getZxdsName() {
		return this.zxdsName;
	}

	public void setZxdsName(String zxdsName) {
		this.zxdsName = zxdsName;
	}

	public Set<Shareholder> getShareholders() {
		return this.shareholders;
	}

	public void setShareholders(Set<Shareholder> shareholders) {
		this.shareholders = shareholders;
	}

	public Shareholder addShareholder(Shareholder shareholder) {
		getShareholders().add(shareholder);
		shareholder.setCompanyreg(this);

		return shareholder;
	}

	public Shareholder removeShareholder(Shareholder shareholder) {
		getShareholders().remove(shareholder);
		shareholder.setCompanyreg(null);

		return shareholder;
	}
	
	public String getShareNames(){
		String names="";
		Set<Shareholder> shs = this.getShareholders();
		for(Shareholder sh: shs){
			if(!sh.getShtype().equals("录入")){
				names = names + sh.getShname() + ",";
			}
		}
		if(!names.equals("")){
			names = names.substring(0, names.length()-1);
		}
		return names;
	}
	
	public Date getCapptime() {
		return capptime;
	}

	public void setCapptime(Date capptime) {
		this.capptime = capptime;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCapprove() {
		return capprove;
	}

	public void setCapprove(String capprove) {
		this.capprove = capprove;
	}

	public String getZxdsIdno() {
		return zxdsIdno;
	}

	public void setZxdsIdno(String zxdsIdno) {
		this.zxdsIdno = zxdsIdno;
	}

	public String getComment8() {
		return comment8;
	}

	public void setComment8(String comment8) {
		this.comment8 = comment8;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public String getAuthIdno() {
		return authIdno;
	}

	public void setAuthIdno(String authIdno) {
		this.authIdno = authIdno;
	}

	public String getAuthIdtype() {
		return authIdtype;
	}

	public void setAuthIdtype(String authIdtype) {
		this.authIdtype = authIdtype;
	}

	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}

	public boolean isAuthOpt17() {
		return authOpt17;
	}

	public void setAuthOpt17(boolean authOpt17) {
		this.authOpt17 = authOpt17;
	}

	public String getCname1() {
		return cname1;
	}

	public void setCname1(String cname1) {
		this.cname1 = cname1;
	}

	public String getCname2() {
		return cname2;
	}

	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}

	public String getCname3() {
		return cname3;
	}

	public void setCname3(String cname3) {
		this.cname3 = cname3;
	}

	public String getCname4() {
		return cname4;
	}

	public void setCname4(String cname4) {
		this.cname4 = cname4;
	}

	public String getCname5() {
		return cname5;
	}

	public void setCname5(String cname5) {
		this.cname5 = cname5;
	}

	public String getCname6() {
		return cname6;
	}

	public void setCname6(String cname6) {
		this.cname6 = cname6;
	}

	public boolean isCnameOpt1() {
		return cnameOpt1;
	}

	public void setCnameOpt1(boolean cnameOpt1) {
		this.cnameOpt1 = cnameOpt1;
	}

	public boolean isCnameOpt2() {
		return cnameOpt2;
	}

	public void setCnameOpt2(boolean cnameOpt2) {
		this.cnameOpt2 = cnameOpt2;
	}

	public boolean isCnameOpt3() {
		return cnameOpt3;
	}

	public void setCnameOpt3(boolean cnameOpt3) {
		this.cnameOpt3 = cnameOpt3;
	}

	public boolean isCnameOpt4() {
		return cnameOpt4;
	}

	public void setCnameOpt4(boolean cnameOpt4) {
		this.cnameOpt4 = cnameOpt4;
	}

	public boolean isCnameOpt5() {
		return cnameOpt5;
	}

	public void setCnameOpt5(boolean cnameOpt5) {
		this.cnameOpt5 = cnameOpt5;
	}

	public boolean isCnameOpt6() {
		return cnameOpt6;
	}

	public void setCnameOpt6(boolean cnameOpt6) {
		this.cnameOpt6 = cnameOpt6;
	}

	public Date getAuthDate2() {
		return authDate2;
	}

	public void setAuthDate2(Date authDate2) {
		this.authDate2 = authDate2;
	}

	public Date getAuthDateb2() {
		return authDateb2;
	}

	public void setAuthDateb2(Date authDateb2) {
		this.authDateb2 = authDateb2;
	}

	public Date getAuthDatee2() {
		return authDatee2;
	}

	public void setAuthDatee2(Date authDatee2) {
		this.authDatee2 = authDatee2;
	}

	public String getAuthDname2() {
		return authDname2;
	}

	public void setAuthDname2(String authDname2) {
		this.authDname2 = authDname2;
	}

	public String getAuthIdno2() {
		return authIdno2;
	}

	public void setAuthIdno2(String authIdno2) {
		this.authIdno2 = authIdno2;
	}

	public boolean isAuthOpt18() {
		return authOpt18;
	}

	public void setAuthOpt18(boolean authOpt18) {
		this.authOpt18 = authOpt18;
	}

	public boolean isAuthOpt19() {
		return authOpt19;
	}

	public void setAuthOpt19(boolean authOpt19) {
		this.authOpt19 = authOpt19;
	}

	public String getComment9() {
		return comment9;
	}

	public void setComment9(String comment9) {
		this.comment9 = comment9;
	}

	public String getComment10() {
		return comment10;
	}

	public void setComment10(String comment10) {
		this.comment10 = comment10;
	}

	public String getAuthMobile2() {
		return authMobile2;
	}

	public void setAuthMobile2(String authMobile2) {
		this.authMobile2 = authMobile2;
	}

	public String getCname0() {
		return cname0;
	}

	public void setCname0(String cname0) {
		this.cname0 = cname0;
	}

	public String getSelrange() {
		return selrange;
	}

	public void setSelrange(String selrange) {
		this.selrange = selrange;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Set<Precondition> getPreconditions() {
		return preconditions;
	}

	public void setPreconditions(Set<Precondition> preconditions) {
		this.preconditions = preconditions;
	}
	
	public Precondition addPrecondition(Precondition precondition) {
		getPreconditions().add(precondition);
		precondition.setCompanyreg(this);
		return precondition;
	}

	public Precondition removePrecondition(Precondition precondition) {
		getPreconditions().remove(precondition);
		precondition.setCompanyreg(null);
		return precondition;
	}

	public Dongshi addDongshi(Dongshi obj) {
		getDongshis().add(obj);
		obj.setCompanyreg(this);
		return obj;
	}
	public Dongshi removeDongshi(Dongshi obj) {
		getDongshis().remove(obj);
		obj.setCompanyreg(null);
		return obj;
	}

	public Jianshi addJianshi(Jianshi obj) {
		getJianshis().add(obj);
		obj.setCompanyreg(this);
		return obj;
	}
	public Jianshi removeJianshi(Jianshi obj) {
		getJianshis().remove(obj);
		obj.setCompanyreg(null);
		return obj;
	}
	
	public Upfile addUpfile(Upfile upfile) {
		getUpfiles().add(upfile);
		upfile.setCompanyreg(this);
		return upfile;
	}

	public Upfile removeUpfile(Upfile upfile) {
		getUpfiles().remove(upfile);
		upfile.setCompanyreg(null);
		return upfile;
	}
	public String getComment11() {
		return comment11;
	}

	public void setComment11(String comment11) {
		this.comment11 = comment11;
	}

	public int getEmpnum() {
		return empnum;
	}

	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}

	public int getEmpfornum() {
		return empfornum;
	}

	public void setEmpfornum(int empfornum) {
		this.empfornum = empfornum;
	}

	public Set<Upfile> getUpfiles() {
		return upfiles;
	}

	public void setUpfiles(Set<Upfile> upfiles) {
		this.upfiles = upfiles;
	}



	public String getSpecial() {
		return special;
	}



	public void setSpecial(String special) {
		this.special = special;
	}



	public boolean isDshui() {
		return dshui;
	}



	public void setDshui(boolean dshui) {
		this.dshui = dshui;
	}



	public boolean isJshui() {
		return jshui;
	}



	public void setJshui(boolean jshui) {
		this.jshui = jshui;
	}



	public Set<Dongshi> getDongshis() {
		return dongshis;
	}



	public void setDongshis(Set<Dongshi> dongshis) {
		this.dongshis = dongshis;
	}



	public Set<Jianshi> getJianshis() {
		return jianshis;
	}



	public void setJianshis(Set<Jianshi> jianshis) {
		this.jianshis = jianshis;
	}



	public String getComment12() {
		return comment12;
	}



	public void setComment12(String comment12) {
		this.comment12 = comment12;
	}



	public String getComment13() {
		return comment13;
	}



	public void setComment13(String comment13) {
		this.comment13 = comment13;
	}

}