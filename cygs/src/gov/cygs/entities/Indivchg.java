package gov.cygs.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import gov.cygs.utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Entity
@NamedQuery(name="Indivchg.findAll", query="SELECT p FROM Indivchg p")
public class Indivchg extends EntityImpl  implements Serializable {
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

	@Column(name="auth_mode")
	private String authMode;

	@Column(name="auth_address")
	private String authAddress;

	@Column(name="auth_idno")
	private String authIdno;

	@Column(name="auth_mobile")
	private String authMobile;

	@Column(name="auth_name")
	private String authName;

	@Column(name="auth_opt1")
	private boolean authOpt1;

	@Column(name="auth_opt2")
	private boolean authOpt2;

	@Column(name="auth_opt3")
	private boolean authOpt3;

	@Column(name="auth_opt4")
	private boolean authOpt4;
	
	@Column(name="auth_zip")
	private String authZip;	

	private String caddress;
	
	private String caddressnew;

	private String cmode;

	private String cmodenew;

	private String cno;

	private String capprove;

	@Temporal(TemporalType.TIMESTAMP)
	private Date capptime;

	private String cname;

	private String cnamenew;
	
	private String cnameno;
	
	private String cerno;

	private String comment1;

	private String comment2;

	private String comment3;

	private String comment4;

	private String comment5;

	private String crange;

	private String crangenew;

	private String family;

	private String familynew;

	private String jingshou;
	
	private String local;
	
	private String mapfile;
	
	private int mapx;
	
	private int mapy;
	
	private String markAddr1;

	private String prefix;
	
	private String prefixnew;
	
	private String special;

	private String transport;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updtime;

	private int userid;

	private String uuid;
	
	private int mapindex;

	public Indivchg() {
		UUID uuid = UUID.randomUUID();
		Indivchg creg = this;
		Date today = new Date();
		creg.setUuid(uuid.toString());
		creg.setTransport("inner");
		creg.setCaddress("");
		creg.setCaddressnew("");
		creg.setCapptime(today);
		creg.setCapprove("创建");
		creg.setCmode("个人经营");
		creg.setCmodenew("");
		creg.setCname("");
		creg.setCnamenew("");
		creg.setCnameno("");
		creg.setCerno("");
		creg.setCrange("");
		creg.setCrangenew("");
		creg.setFamily("");
		creg.setFamilynew("");
		
		creg.setMapx(0);
		creg.setMapy(0);
		creg.setMapfile("");
		creg.setLocal("重庆工商所");
		
		creg.setMarkAddr1("");
		creg.setAuthDate(today);
		creg.setAuthDateb(new Date(today.getTime()));
		creg.setAuthDatee(new Date(today.getTime()+(long)24*3600000*31));
		creg.setAuthDname("");
		creg.setAuthIdno("");
		creg.setAuthMobile("");
		creg.setAuthAddress("");
		creg.setAuthMode("本人办理");
		creg.setAuthOpt1(true);
		creg.setAuthOpt2(true);
		creg.setAuthOpt3(true);
		creg.setAuthOpt4(true);
		creg.setAuthZip("130000");
		creg.setJingshou("");
		creg.setComment1("");
		creg.setComment2("");
		creg.setComment3("");
		creg.setComment4("");
		creg.setComment5("");
		creg.setPrefix("吉林省长春市朝阳区");
		creg.setPrefixnew("吉林省长春市朝阳区");
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
			case "authAddress":
				value = this.authAddress;
				break;
			case "authDname":
				value = this.authDname;
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
			case "authOpt1b":
				value = this.authOpt1?"　":"√";
				break;
			case "authOpt2b":
				value = this.authOpt2?"　":"√";
				break;
			case "authOpt3b":
				value = this.authOpt3?"　":"√";
				break;
			case "authOpt4b":
				value = this.authOpt4?"　":"√";
				break;
			case "authZip":
				value = this.authZip;
				break;
			case "caddress":
				value =this.prefix + this.caddress;
				break;
			case "cmodea":
				if(this.cmode.equals("个人经营")){
					value = "√";
				}else{
					value = "　";
				}
				if(this.cmodenew.trim().equals("")){
					value = "　";
				}
				break;
			case "cmodeb":	
				if(!this.cmode.equals("个人经营")){
					value = "√";
				}else{
					value = "　";
				}
				if(this.cmodenew.trim().equals("")){
					value = "　";
				}
				break;
			case "cmodenewa":
				if(this.cmodenew.equals("个人经营")){
					value = "√";
				}else{
					value = "　";
				}
				if(this.cmodenew.trim().equals("")){
					value = "　";
				}
				break;
			case "cmodenewb":	
				if(!this.cmodenew.equals("个人经营")){
					value = "√";
				}else{
					value = "　";
				}
				if(this.cmodenew.trim().equals("")){
					value = "　";
				}
				break;
			case "capptime":
				value = sft.format(this.capptime);
				break;
			case "capprove":
				value = this.capprove;
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
			case "cerno":
				value = this.cerno;
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
				value = this.comment4;
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
			case "family":
				value = this.family;
				break;
			case "familynew":
				value = this.familynew;
				break;
			case "markAddr1":
				value = this.markAddr1;
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
			try {
				value = ((Field)this.getField(field)).get(this).toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public String getAuthMode() {
		return authMode;
	}

	public void setAuthMode(String authMode) {
		this.authMode = authMode;
	}

	public String getAuthAddress() {
		return authAddress;
	}

	public void setAuthAddress(String authAddress) {
		this.authAddress = authAddress;
	}

	public String getAuthIdno() {
		return authIdno;
	}

	public void setAuthIdno(String authIdno) {
		this.authIdno = authIdno;
	}

	public String getAuthMobile() {
		return authMobile;
	}

	public void setAuthMobile(String authMobile) {
		this.authMobile = authMobile;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public boolean isAuthOpt1() {
		return authOpt1;
	}

	public void setAuthOpt1(boolean authOpt1) {
		this.authOpt1 = authOpt1;
	}

	public boolean isAuthOpt2() {
		return authOpt2;
	}

	public void setAuthOpt2(boolean authOpt2) {
		this.authOpt2 = authOpt2;
	}

	public boolean isAuthOpt3() {
		return authOpt3;
	}

	public void setAuthOpt3(boolean authOpt3) {
		this.authOpt3 = authOpt3;
	}

	public boolean isAuthOpt4() {
		return authOpt4;
	}

	public void setAuthOpt4(boolean authOpt4) {
		this.authOpt4 = authOpt4;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCmode() {
		return cmode;
	}

	public void setCmode(String cmode) {
		this.cmode = cmode;
	}

	public String getCapprove() {
		return capprove;
	}

	public void setCapprove(String capprove) {
		this.capprove = capprove;
	}

	public Date getCapptime() {
		return capptime;
	}

	public void setCapptime(Date capptime) {
		this.capptime = capptime;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getCrange() {
		return crange;
	}

	public void setCrange(String crange) {
		this.crange = crange;
	}

	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}


	public String getTransport() {
		return transport;
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
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMapfile() {
		return mapfile;
	}

	public void setMapfile(String mapfile) {
		this.mapfile = mapfile;
	}

	public int getMapx() {
		return mapx;
	}

	public void setMapx(int mapx) {
		this.mapx = mapx;
	}

	public int getMapy() {
		return mapy;
	}

	public void setMapy(int mapy) {
		this.mapy = mapy;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getAuthZip() {
		return authZip;
	}

	public void setAuthZip(String authZip) {
		this.authZip = authZip;
	}

	public String getMarkAddr1() {
		return markAddr1;
	}

	public void setMarkAddr1(String markAddr1) {
		this.markAddr1 = markAddr1;
	}

	public String getCaddressnew() {
		return caddressnew;
	}

	public void setCaddressnew(String caddressnew) {
		this.caddressnew = caddressnew;
	}

	public String getCmodenew() {
		if(this.cmodenew==null) 	this.cmodenew = "";
		return cmodenew;
	}

	public void setCmodenew(String cmodenew) {
		if(cmodenew==null) 	cmodenew = "";
		this.cmodenew = cmodenew;
	}

	public String getCnamenew() {
		return cnamenew;
	}

	public void setCnamenew(String cnamenew) {
		this.cnamenew = cnamenew;
	}

	public String getCrangenew() {
		return crangenew;
	}

	public void setCrangenew(String crangenew) {
		this.crangenew = crangenew;
	}

	public String getFamilynew() {
		return familynew;
	}

	public void setFamilynew(String familynew) {
		this.familynew = familynew;
	}

	public String getCnameno() {
		return cnameno;
	}

	public void setCnameno(String cnameno) {
		this.cnameno = cnameno;
	}

	public String getPrefixnew() {
		return prefixnew;
	}

	public void setPrefixnew(String prefixnew) {
		this.prefixnew = prefixnew;
	}

	public String getCerno() {
		return cerno;
	}

	public void setCerno(String cerno) {
		this.cerno = cerno;
	}

	public int getMapindex() {
		return mapindex;
	}

	public void setMapindex(int mapindex) {
		this.mapindex = mapindex;
	}

}