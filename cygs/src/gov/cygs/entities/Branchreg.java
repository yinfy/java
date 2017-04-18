package gov.cygs.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import gov.cygs.utils.Utils;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;


/**
 * The persistent class for the branchreg database table.
 * 
 */
@Entity
@NamedQuery(name="Branchreg.findAll", query="SELECT b FROM Branchreg b")
public class Branchreg  extends EntityImpl  implements Serializable {
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

	private String calmode;

	private BigDecimal capital;

	private String capprove;

	@Temporal(TemporalType.TIMESTAMP)
	private Date capptime;

	@Column(name="ceo_idno")
	private String ceoIdno;

	@Column(name="ceo_idtype")
	private String ceoIdtype;

	@Column(name="ceo_mail")
	private String ceoMail;

	@Column(name="ceo_mobile")
	private String ceoMobile;

	@Column(name="ceo_name")
	private String ceoName;

	@Column(name="ceo_tele")
	private String ceoTele;

	private int cernum;

	private String cname;

	private String cnameb;

	private String cnameno;

	private String cno;

	private String comment1;

	private String comment2;

	private String comment3;

	private String comment4;

	private String comment5;

	private String comment6;

	private String comment7;

	private String crange;

	private String ctelephone;

	private String czip;

	private int empfornum;

	private int empnum;

	@Column(name="fin_idfile")
	private String finIdfile;

	@Column(name="fin_idno")
	private String finIdno;

	@Column(name="fin_idtype")
	private String finIdtype;

	@Column(name="fin_mail")
	private String finMail;

	@Column(name="fin_mobile")
	private String finMobile;

	@Column(name="fin_name")
	private String finName;

	@Column(name="fin_tele")
	private String finTele;

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

	private String prefix;

	private String selrange;
	
	private String special;

	private String transport;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updtime;

	private int userid;

	private String uuid;

	public Branchreg() {
		UUID uuid = UUID.randomUUID();
		Branchreg creg = this;
		Date today = new Date();
		creg.setUuid(uuid.toString());
		creg.setTransport("inner");
		creg.setCapptime(today);
		creg.setCapprove("创建");
		creg.setCapital(BigDecimal.ZERO);
		creg.setCalmode("独立核算");
		creg.setCname("");
		creg.setCno("");
		creg.setCnameno("");
		creg.setHaddress("");
		creg.setCaddress("");
		creg.setCtelephone("");
		creg.setCzip("130000");
		creg.setCrange("");
		creg.setSelrange("[]");
		creg.setEmpnum(0);
		creg.setEmpfornum(0);

		creg.setCeoName("");
		creg.setCeoTele("");
		creg.setCeoMobile("");
		creg.setCeoMail("");
		creg.setCeoIdtype("身份证");
		creg.setCeoIdno("");
		
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
		creg.setAuthOptblank("");
		creg.setJingshou("");
		creg.setComment1("");
		creg.setComment2("");
		creg.setComment3("");
		creg.setComment4("");
		creg.setComment5("");
		creg.setComment6("");
		creg.setPrefix("吉林省长春市朝阳区");
		creg.setSpecial("请选择");
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
				value = this.prefix+this.caddress;
				break;
			case "capital":
				value = Utils.numFormat(this.capital);
				break;
			case "calmodea":
				if(this.calmode.equals("独立核算")){
					value = "√";
				}else{
					value = "　";
				}
				break;
			case "calmodeb":
				if(!this.calmode.equals("独立核算")){
					value = "√";
				}else{
					value = "　";
				}
				break;
			case "capptime":
				value = sft.format(this.capptime);
				break;
			case "capprove":
				value = this.capprove;
				break;
			case "cernum":
				value = String.valueOf(this.cernum);
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
				
			case "cno":
				value = this.cno;
				break;
			case "cname":
				value = this.cname;
				break;
			case "cnameb":
				value = this.cnameb;
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
			case "crange":
				value = this.crange;
				break;
			case "ctelephone":
				value = this.ctelephone;
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
				value = this.prefix+this.haddress;
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
			default:
				value = "";
				break;
		}
		if(value==null) value = "";
		return value;
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

	public String getCalmode() {
		return this.calmode;
	}

	public void setCalmode(String calmode) {
		this.calmode = calmode;
	}

	public BigDecimal getCapital() {
		return this.capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
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

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnameb() {
		return this.cnameb;
	}

	public void setCnameb(String cnameb) {
		this.cnameb = cnameb;
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

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

}