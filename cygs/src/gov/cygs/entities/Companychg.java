package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


/**
 * The persistent class for the companychg database table.
 * 
 */
@Entity
@NamedQuery(name="Companychg.findAll", query="SELECT c FROM Companychg c")
public class Companychg extends EntityImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_date")
	private Date authDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_dateb")
	private Date authDateb;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="auth_datee")
	private Date authDatee;

	@Column(name="auth_dname")
	private String authDname;

	@Column(name="auth_idfile")
	private String authIdfile;

	@Column(name="auth_idno")
	private String authIdno;

	@Column(name="auth_idtype")
	private String authIdtype;

	@Column(name="auth_mobile")
	private String authMobile;

	@Column(name="auth_name")
	private String authName;

	@Column(name="auth_opt1")
	private boolean authOpt1;

	@Column(name="auth_opt10")
	private boolean authOpt10;

	@Column(name="auth_opt11")
	private boolean authOpt11;

	@Column(name="auth_opt12")
	private boolean authOpt12;

	@Column(name="auth_opt13")
	private boolean authOpt13;

	@Column(name="auth_opt14")
	private boolean authOpt14;

	@Column(name="auth_opt15")
	private boolean authOpt15;

	@Column(name="auth_opt16")
	private boolean authOpt16;

	@Column(name="auth_opt2")
	private boolean authOpt2;

	@Column(name="auth_opt3")
	private boolean authOpt3;

	@Column(name="auth_opt4")
	private boolean authOpt4;

	@Column(name="auth_opt5")
	private boolean authOpt5;

	@Column(name="auth_opt6")
	private boolean authOpt6;

	@Column(name="auth_opt7")
	private boolean authOpt7;

	@Column(name="auth_opt8")
	private boolean authOpt8;

	@Column(name="auth_opt9")
	private boolean authOpt9;

	@Column(name="auth_optblank")
	private String authOptblank;

	@Column(name="auth_tele")
	private String authTele;

	private String caddress;

	private String caddressnew;

	private String capprove;

	@Temporal(TemporalType.TIMESTAMP)
	private Date capptime;

	private String cname;

	private String cnamenew;

	private String cnameno;
	
	private String cnamenotype;

	private String cno;

	private String comment1;

	private String comment2;

	private String comment3;

	private String comment4;

	private String comment5;

	private String crange;

	private String crangenew;

	private String ctelephone;

	private String ctype;

	@Column(name="ctype_sub")
	private String ctypeSub;

	private int cyears;

	private String cyearslong;

	private String cyearslongnew;

	private int cyearsnew;

	private String czip;

	private int empfornum;

	private int empnum;

	private String haddress;

	private String jingshou;

	@Column(name="lly_idfile")
	private String llyIdfile;

	@Column(name="lly_idno")
	private String llyIdno;

	@Column(name="lly_idtype")
	private String llyIdtype;

	@Column(name="lly_mail")
	private String llyMail;

	@Column(name="lly_mobile")
	private String llyMobile;

	@Column(name="lly_name")
	private String llyName;

	@Column(name="lly_tele")
	private String llyTele;

	@Column(name="mark_addr1")
	private String markAddr1;

	@Column(name="mark_addr2")
	private String markAddr2;

	@Column(name="mark_addr3")
	private String markAddr3;

	private String orgno1;

	private String orgno2;

	private String orgno3;

	private String prefix;
	
	private String prefix0;

	private String selrange;
	
	private String special;

	private String transport;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updtime;

	private int userid;

	private String uuid;
	

	public Companychg() {
		UUID uuid = UUID.randomUUID();
		Companychg creg = this;
		Date today = new Date();
		creg.setUuid(uuid.toString());
		creg.setTransport("inner");
		creg.setCapptime(today);
		creg.setCapprove("创建");
		creg.setCtype("有限责任公司");
		creg.setCtypeSub("II");
		creg.setCname("");
		creg.setCnamenew("");
		creg.setCno("");
		creg.setCnameno("");
		creg.setCnamenotype("注册号");
		creg.setCyears(0);
		creg.setCyearsnew(0);
		creg.setHaddress("");
		creg.setCaddress("");
		creg.setCaddressnew("");
		creg.setCtelephone("");
		creg.setCzip("130000");
		creg.setCrange("");
		creg.setCrangenew("");
		creg.setSelrange("[]");
		creg.setCyearslong("");
		creg.setCyearslongnew("");
		creg.setEmpnum(0);
		creg.setEmpfornum(0);

		creg.setLlyName("");
		creg.setLlyTele("");
		creg.setLlyMobile("");
		creg.setLlyMail("");
		creg.setLlyIdtype("身份证");
		creg.setLlyIdno("");
		
		creg.setMarkAddr1("");
		creg.setMarkAddr2("");
		creg.setMarkAddr3("");
		
		creg.setAuthDate(today);
		creg.setAuthDateb(new Date(today.getTime()));
		creg.setAuthDatee(new Date(today.getTime()+(long)24*3600000*31));
		creg.setAuthDname("");
		creg.setAuthIdtype("身份证");
		creg.setAuthIdno("");
		creg.setAuthMobile("");
		creg.setAuthTele("");
		creg.setAuthMobile("");
		creg.setAuthOpt1(false);
		creg.setAuthOpt2(false);
		creg.setAuthOpt3(true);
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
		creg.setAuthOptblank("");
		creg.setJingshou("");
		creg.setComment1("");
		creg.setComment2("");
		creg.setComment3("");
		creg.setComment4("");
		creg.setComment5("");
		creg.setPrefix("吉林省长春市朝阳区");
		creg.setPrefix0("吉林省长春市朝阳区");
		creg.setSpecial("请选择");
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAuthDate() {
		return this.authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
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

	public String getAuthIdno() {
		return this.authIdno;
	}

	public void setAuthIdno(String authIdno) {
		this.authIdno = authIdno;
	}

	public String getAuthIdtype() {
		return this.authIdtype;
	}

	public void setAuthIdtype(String authIdtype) {
		this.authIdtype = authIdtype;
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

	public String getCaddressnew() {
		return this.caddressnew;
	}

	public void setCaddressnew(String caddressnew) {
		this.caddressnew = caddressnew;
	}

	public String getCapprove() {
		return this.capprove;
	}

	public void setCapprove(String capprove) {
		this.capprove = capprove;
	}

	public Date getCapptime() {
		return this.capptime;
	}

	public void setCapptime(Date capptime) {
		this.capptime = capptime;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnamenew() {
		return this.cnamenew;
	}

	public void setCnamenew(String cnamenew) {
		this.cnamenew = cnamenew;
	}

	public String getCnameno() {
		return this.cnameno;
	}

	public void setCnameno(String cnameno) {
		this.cnameno = cnameno;
	}

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
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

	public String getCrange() {
		return this.crange;
	}

	public void setCrange(String crange) {
		this.crange = crange;
	}

	public String getCrangenew() {
		return this.crangenew;
	}

	public void setCrangenew(String crangenew) {
		this.crangenew = crangenew;
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
		if(cyearslong==null){
			cyearslong ="";
		}
		return this.cyearslong;
	}

	public void setCyearslong(String cyearslong) {
		this.cyearslong = cyearslong;
		if(this.cyearslong==null){
			this.cyearslong ="";
		}
	}

	public String getCyearslongnew() {
		if(this.cyearslongnew==null){
			this.cyearslongnew ="";
		}
		return this.cyearslongnew;
	}

	public void setCyearslongnew(String cyearslongnew) {
		this.cyearslongnew = cyearslongnew;
		if(this.cyearslongnew==null){
			this.cyearslongnew ="";
		}
	}

	public int getCyearsnew() {
		return this.cyearsnew;
	}

	public void setCyearsnew(int cyearsnew) {
		this.cyearsnew = cyearsnew;
	}

	public String getCzip() {
		return this.czip;
	}

	public void setCzip(String czip) {
		this.czip = czip;
	}

	public int getEmpfornum() {
		return this.empfornum;
	}

	public void setEmpfornum(int empfornum) {
		this.empfornum = empfornum;
	}

	public int getEmpnum() {
		return this.empnum;
	}

	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}

	public String getHaddress() {
		return this.haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getJingshou() {
		return this.jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
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

	public String getOrgno1() {
		return this.orgno1;
	}

	public void setOrgno1(String orgno1) {
		this.orgno1 = orgno1;
	}

	public String getOrgno2() {
		return this.orgno2;
	}

	public void setOrgno2(String orgno2) {
		this.orgno2 = orgno2;
	}

	public String getOrgno3() {
		return this.orgno3;
	}

	public void setOrgno3(String orgno3) {
		this.orgno3 = orgno3;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSelrange() {
		return this.selrange;
	}

	public void setSelrange(String selrange) {
		this.selrange = selrange;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Date getUpdtime() {
		return this.updtime;
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
	
	public String getFieldValue(String field){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
		SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);
		String value= "";
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
				value = this.prefix0+this.caddress;
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

			case "cname":
				value = this.cname;
				break;
			case "cnamenew":
				value = this.cnamenew;
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
			case "crange":
				value = this.crange;
				break;
			case "crangenew":
				value = this.crangenew;
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
			case "cyearsnew":
				value = String.valueOf(this.cyearsnew)+"年";
				if(this.cyearslongnew.equals("长期")){
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
				if(cyearslong.equals("")){
					value = "√";
				}else{
					value = " ";
				}
				break;
			case "cyearsopt2":
				if(cyearslong.equals("长期")){
					value = "√";
				}else{
					value = " ";
				}
				break;
			case "cyearslong":
				value = this.cyearslong;
				break;
			case "cyearslongnew":
				value = this.cyearslongnew;
				break;
			case "czip":
				value = this.czip;
				break;
			case "empnum":
				value = String.valueOf(this.empnum);
				break;
			case "empfornum":
				value = String.valueOf(this.empfornum);
				break;
			case "haddress":
				value = this.prefix0+this.haddress;
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
			case "orgno1":
				value = this.orgno1;
				break;
			case "orgno2":
				value = this.orgno2;
				break;
			case "orgno3":
				value = this.orgno3;
				break;
			case "orgno1chk":
				if(!orgno1.trim().equals("")){
					value = "×";
				}else{
					value = "√";
				}
				break;
			case "orgno2chk":
				if(!orgno2.trim().equals("")){
					value = "×";
				}else{
					value = "√";
				}
				break;
			case "orgno3chk":
				if(!orgno3.trim().equals("")){
					value = "×";
				}else{
					value = "√";
				}
				break;
			case "orgno1stk":
				if(orgno1.trim().equals("")){
					value = " ";
				}else{
					value = "<w:strike/>";
				}
				break;
			case "orgno2stk":
				if(orgno2.trim().equals("")){
					value = " ";
				}else{
					value = "<w:strike/>";
				}
				break;
			case "orgno3stk":
				if(orgno3.trim().equals("")){
					value = " ";
				}else{
					value = "<w:strike/>";
				}
				break;
				
			case "zhangcheng":
				String item="<w:p wsp:rsidR=\"00D47F5C\" wsp:rsidRDefault=\"003F6B28\" wsp:rsidP=\"001C7DBB\"><w:pPr><w:ind w:first-line-chars=\"200\" w:first-line=\"560\"/><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>itemnum、将公司章程第</w:t></w:r><w:r wsp:rsidRPr=\"003F6B28\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>    </w:t></w:r><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>章第</w:t></w:r><w:r wsp:rsidRPr=\"003F6B28\"><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/><w:u w:val=\"single\"/></w:rPr><w:t>    </w:t></w:r><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>条修改为：</w:t></w:r></w:p><w:p wsp:rsidR=\"003F6B28\" wsp:rsidRDefault=\"003F6B28\" wsp:rsidP=\"001C7DBB\"><w:pPr><w:ind w:first-line-chars=\"200\" w:first-line=\"560\"/><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>itemtype：itemvalue</w:t></w:r></w:p>";
				String itemnum = "一";
				int index = 1;
				if(!this.cnamenew.trim().equals("")){
					itemnum = this.getNumChar(index);
					value  = value + item;
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "公司的名称");
					value = value.replaceAll("itemvalue", this.cnamenew);
					index++;
				}
				if(!this.caddressnew.trim().equals("")){
					itemnum = this.getNumChar(index);
					value  = value + item;
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "公司的住所");
					value = value.replaceAll("itemvalue", this.prefix+this.caddressnew);
					index++;					
				}
				if(!this.crangenew.trim().equals("")){
					itemnum = this.getNumChar(index);
					value  = value + item;
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "公司的经营范围");
					value = value.replaceAll("itemvalue", this.crangenew);
					index++;	
				}
				if((this.cyearsnew>0 && this.cyearsnew!=this.cyears ) || !this.cyearslong.trim().equals(this.cyearslongnew.trim())){
					itemnum = this.getNumChar(index);
					value  = value + item;
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "公司的营业期限");
					value = value.replaceAll("itemvalue", this.getFieldValue("cyearsnew"));
					index++;
				}
				break;
			case "changeitems":
				index = 1;
				item= "<w:p wsp:rsidR=\"004B6AB2\" wsp:rsidRDefault=\"004B6AB2\" wsp:rsidP=\"004B6AB2\"><w:pPr><w:listPr><w:ilvl w:val=\"0\"/><w:ilfo w:val=\"1\"/><wx:t wx:val=\"itemnum、\"/><wx:font wx:val=\"Times New Roman\"/></w:listPr><w:rPr><w:rFonts w:hint=\"fareast\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>itemtype</w:t></w:r><w:r wsp:rsidRPr=\"004B6AB2\"><w:rPr><w:sz w:val=\"28\"/><w:sz-cs w:val=\"28\"/></w:rPr><w:t>itemvalue</w:t></w:r></w:p>";
				itemnum = "一";
				if(!this.cnamenew.trim().equals("")){
					value  = value + item;
					itemnum = this.getNumChar(index);
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "将公司的名称变更为：");
					value = value.replaceAll("itemvalue", this.cnamenew);
					index++;
				}
				
				if(!this.caddressnew.trim().equals("")){
					value  = value + item;
					itemnum = this.getNumChar(index);
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "将公司的住所变更为：");
					value = value.replaceAll("itemvalue",  this.prefix+this.caddressnew);
					index++;
				}
				if(!this.crangenew.trim().equals("")){
					value  = value + item;
					itemnum = this.getNumChar(index);
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "将公司的经营范围变更为：");
					value = value.replaceAll("itemvalue",  this.crangenew);
					index++;
				}
				if((this.cyearsnew>0 && this.cyearsnew!=this.cyears ) || !this.cyearslong.trim().equals(this.cyearslongnew.trim())){
					value  = value + item;
					itemnum = this.getNumChar(index);
					value = value.replaceAll("itemnum", itemnum);
					value = value.replaceAll("itemtype", "将公司的营业期限变更为：");
					value = value.replaceAll("itemvalue",  this.getFieldValue("cyearsnew"));
					index++;
				}				
				break;
			case "changes":
				int lines = 0;
				value = "";
				String blankline = "<w:tr wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"00574349\"><w:trPr><w:trHeight w:val=\"377\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1642\" w:type=\"dxa\"/><w:tcBorders><w:left w:val=\"single\" w:sz=\"12\" wx:bdrwidth=\"30\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00261E44\" wsp:rsidP=\"00261E44\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:ind w:first-line-chars=\"50\" w:first-line=\"105\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>             </w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4477\" w:type=\"dxa\"/><w:gridSpan w:val=\"3\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00574349\" wsp:rsidP=\"00574349\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>               </w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4045\" w:type=\"dxa\"/><w:gridSpan w:val=\"3\"/><w:tcBorders><w:right w:val=\"single\" w:sz=\"12\" wx:bdrwidth=\"30\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00574349\" wsp:rsidP=\"00574349\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>            </w:t></w:r></w:p></w:tc></w:tr>";
				String changeline ="<w:tr wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidTr=\"00574349\"><w:trPr><w:trHeight w:val=\"377\"/></w:trPr><w:tc><w:tcPr><w:tcW w:w=\"1642\" w:type=\"dxa\"/><w:tcBorders><w:left w:val=\"single\" w:sz=\"12\" wx:bdrwidth=\"30\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00261E44\" wsp:rsidP=\"00261E44\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:ind w:first-line-chars=\"50\" w:first-line=\"105\"/><w:jc w:val=\"center\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>changetype</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4477\" w:type=\"dxa\"/><w:gridSpan w:val=\"3\"/><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00574349\" wsp:rsidP=\"00574349\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>changeorigin</w:t></w:r></w:p></w:tc><w:tc><w:tcPr><w:tcW w:w=\"4045\" w:type=\"dxa\"/><w:gridSpan w:val=\"3\"/><w:tcBorders><w:right w:val=\"single\" w:sz=\"12\" wx:bdrwidth=\"30\" w:space=\"0\" w:color=\"auto\"/></w:tcBorders><w:vAlign w:val=\"center\"/></w:tcPr><w:p wsp:rsidR=\"00574349\" wsp:rsidRPr=\"00AC3351\" wsp:rsidRDefault=\"00574349\" wsp:rsidP=\"00574349\"><w:pPr><w:autoSpaceDE w:val=\"off\"/><w:autoSpaceDN w:val=\"off\"/><w:adjustRightInd w:val=\"off\"/><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr></w:pPr><w:r><w:rPr><w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:hint=\"fareast\"/><wx:font wx:val=\"宋体\"/><w:b/><w:b-cs/><w:sz-cs w:val=\"21\"/><w:lang w:val=\"ZH-CN\"/></w:rPr><w:t>changenew</w:t></w:r></w:p></w:tc></w:tr>";
				if(!this.cnamenew.trim().equals("")){
					value  = value + changeline;
					value = value.replaceAll("changetype", "企业名称");
					value = value.replaceAll("changeorigin", this.cname);
					value = value.replaceAll("changenew", this.cnamenew);
					lines= lines+1;
				}
				if(!this.caddressnew.trim().equals("")){
					value  = value + changeline;
					value = value.replaceAll("changetype", "住所");
					value = value.replaceAll("changeorigin", this.prefix0+this.caddress);
					value = value.replaceAll("changenew", this.prefix+this.caddressnew);
					lines= lines+1;
				}
				if(!this.crangenew.trim().equals("")){
					value  = value + changeline;
					value = value.replaceAll("changetype", "经营范围");
					value = value.replaceAll("changeorigin", this.crange);
					value = value.replaceAll("changenew", this.crangenew);
					int n =(int) Math.ceil(((double)this.crangenew.length()/20));
					lines= lines+n;
				}
				if((this.cyearsnew>0 && this.cyearsnew!=this.cyears ) || !this.cyearslong.trim().equals(this.cyearslongnew.trim())){
					value  = value + changeline;
					value = value.replaceAll("changetype", "营业期限");
					value = value.replaceAll("changeorigin", this.getFieldValue("cyears"));
					value = value.replaceAll("changenew", this.getFieldValue("cyearsnew"));
					lines= lines+1;
				}
				for(int addLines=lines;addLines<=8;addLines++){
					value = value + blankline;
				}
				break;
			default:
				value = "";
				break;
		}
		if(value==null) value = "";
		return value;
	}

	public String getCnamenotype() {
		return cnamenotype;
	}

	public void setCnamenotype(String cnamenotype) {
		this.cnamenotype = cnamenotype;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getPrefix0() {
		return prefix0;
	}

	public void setPrefix0(String prefix0) {
		this.prefix0 = prefix0;
	}
	
	public String getNumChar(int value){
		String itemnum="";
		switch(value){
		case 1:
			itemnum = "一";
			break;
		case 2:
			itemnum = "二";
			break;
		case 3:
			itemnum = "三";
			break;
		case 4:
			itemnum = "四";
			break;
		}
		return itemnum;
	}

	public boolean isEmptyComments(){
		boolean isEmpty = true;
		
		if(!this.comment1.trim().equals("")){
			isEmpty = false;
		}
		if(!this.comment2.trim().equals("")){
			isEmpty = false;
		}
		if(!this.comment3.trim().equals("")){
			isEmpty = false;
		}
		if(!this.comment4.trim().equals("")){
			isEmpty = false;
		}
		if(!this.comment5.trim().equals("")){
			isEmpty = false;
		}
		return isEmpty;
	}	
	
	
}