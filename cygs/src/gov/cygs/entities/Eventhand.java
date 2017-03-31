package gov.cygs.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import gov.cygs.utils.Utils;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;


/**
 * The persistent class for the eventhand database table.
 * 
 */
@Entity
@NamedQuery(name="Eventhand.findAll", query="SELECT b FROM Eventhand b")
public class Eventhand  extends EntityImpl  implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="eventtime")
	protected Date eventtime;

	protected String eventsource;

	protected String eventno;

	protected String eventarea;
	
	protected String eventdetail;

	protected String eventplace;
	
	protected String eventreason;

	protected String eventrequest;
	
	protected String eventresult;

	protected String eventtarget;
	
	protected String eventtele;
	
	protected String eventtitle;
	
	protected String custname;
	
	protected String custplace;	

	protected String custtele;
	
	

	@Temporal(TemporalType.TIMESTAMP)
	protected Date handletime;

	protected String passtoarea;

	protected String passtoname;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date fbtime;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date passtime;
	
	@OneToMany( mappedBy="eventhand", cascade={CascadeType.ALL}, fetch=FetchType.EAGER  )
	protected Set<Upfile2> upfiles;
	
	protected String cno;

	protected String comment1;
	
	protected String comment2;
	
	protected String comment3;

	protected String capprove;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date capptime;

	protected String jingshou;
	
	protected String special;

	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;

	public Eventhand() {
		UUID uuid = UUID.randomUUID();
		Set<Upfile2> upfiles = new LinkedHashSet<Upfile2>();
		this.setUpfiles(upfiles);
		Eventhand creg = this;
		Date today = new Date();
		creg.setUuid(uuid.toString());
		creg.setTransport("inner");
		creg.setCapptime(today);
		creg.setCapprove("创建");
		creg.setComment1("");
		creg.setComment2("");
		creg.setComment3("");
		creg.setCname("");
		creg.setCno("");
		creg.setCustname("");
		creg.setCusttele("");
		creg.setCustplace("");
		creg.setEventarea("");
		creg.setEventno("");
		creg.setEventplace("");
		creg.setEventtele("");
		creg.setEventreason("");
		creg.setEventsource("微信");
		creg.setEventdetail("");
		creg.setEventtarget("");
		creg.setEventtitle("");
		creg.setHandletime(today);
		creg.setEventtime(today);
		creg.setPasstime(today);
		creg.setFbtime(today);
		creg.setPasstoarea("");
		creg.setPasstoname("");
		creg.setUpdtime(today);
		this.upfiles = new LinkedHashSet<Upfile2>();
		creg.setJingshou("");
		creg.setComment1("");
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
			case "handletime":
				value = sf.format(this.handletime);
				break;
			case "passtime":
				value = sf.format(this.passtime);
				break;
			case "eventtime":
				value = sft.format(this.passtime);
				break;
			case "fbtime":
				value = sft.format(this.fbtime);
			default:
				value = this.getFieldAsString(field, "");
				break;
		}
		if(value==null) value = "";
		return value;
	}
	
	public Upfile2 addUpfile(Upfile2 upfile) {
		getUpfiles().add(upfile);
		upfile.setEventhand(this);
		return upfile;
	}

	public Upfile2 removeUpfile(Upfile2 upfile) {
		getUpfiles().remove(upfile);
		upfile.setEventhand(null);
		return upfile;
	}	

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEventtime() {
		return eventtime;
	}

	public void setEventtime(Date eventtime) {
		this.eventtime = eventtime;
	}

	public String getEventsource() {
		return eventsource;
	}

	public void setEventsource(String eventsource) {
		this.eventsource = eventsource;
	}

	public String getEventno() {
		return eventno;
	}

	public void setEventno(String eventno) {
		this.eventno = eventno;
	}

	public String getEventarea() {
		return eventarea;
	}

	public void setEventarea(String eventarea) {
		this.eventarea = eventarea;
	}

	public String getEventplace() {
		return eventplace;
	}

	public void setEventplace(String eventplace) {
		this.eventplace = eventplace;
	}

	public String getEventreason() {
		return eventreason;
	}

	public void setEventreason(String eventreason) {
		this.eventreason = eventreason;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCusttele() {
		return custtele;
	}

	public void setCusttele(String custtele) {
		this.custtele = custtele;
	}

	public Date getHandletime() {
		return handletime;
	}

	public void setHandletime(Date handletime) {
		this.handletime = handletime;
	}

	public String getPasstoarea() {
		return passtoarea;
	}

	public void setPasstoarea(String passtoarea) {
		this.passtoarea = passtoarea;
	}

	public String getPasstoname() {
		return passtoname;
	}

	public void setPasstoname(String passtoname) {
		this.passtoname = passtoname;
	}

	public Date getPasstime() {
		return passtime;
	}

	public void setPasstime(Date passtime) {
		this.passtime = passtime;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEventtarget() {
		return eventtarget;
	}

	public void setEventtarget(String eventtarget) {
		this.eventtarget = eventtarget;
	}

	public String getEventrequest() {
		return eventrequest;
	}

	public void setEventrequest(String eventrequest) {
		this.eventrequest = eventrequest;
	}

	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}

	public String getEventdetail() {
		return eventdetail;
	}

	public void setEventdetail(String eventdetail) {
		this.eventdetail = eventdetail;
	}

	public Set<Upfile2> getUpfiles() {
		return upfiles;
	}

	public void setUpfiles(Set<Upfile2> upfiles) {
		this.upfiles = upfiles;
	}

	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}

	public String getEventresult() {
		return eventresult;
	}

	public void setEventresult(String eventresult) {
		this.eventresult = eventresult;
	}

	public String getCustplace() {
		return custplace;
	}

	public void setCustplace(String custplace) {
		this.custplace = custplace;
	}

	public String getEventtele() {
		return eventtele;
	}

	public void setEventtele(String eventtele) {
		this.eventtele = eventtele;
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

	public Date getFbtime() {
		return fbtime;
	}

	public void setFbtime(Date fbtime) {
		this.fbtime = fbtime;
	}
	
	public int getAppdays(){
		int days = 0;
		days = Utils.getDays(this.capptime,new Date());
		return days;
	}

	public int getPassdays(){
		int days = 0;
		days = Utils.getDays(this.passtime,new Date());
		return days;
	}
	
	public int getHandledays(){
		int days = 0;
		days = Utils.getDays(this.handletime,new Date());
		return days;
	}
	
	public String getAppColor(){
		String color = "black";
		if(this.getAppdays()>1){
			color = "blue";
		}
		if(this.getAppdays()>2){
			color = "purple";
		}
		if(this.getAppdays()>3){
			color = "darkorange";
		}
		if(this.getAppdays()>4){
			color = "plum";
		}
		if(this.getAppdays()>5){
			color = "fuchsia";
		}
		if(this.getAppdays()>6){
			color = "brown";
		}
		if(this.getAppdays()>7){
			color = "red";
		}
		if(this.capprove.equals("处理完毕")){
			color = "black";
		}
		return color;
	}

	public String getPassColor(){
		String color = "black";
		if(this.getPassdays()>1){
			color = "blue";
		}
		if(this.getPassdays()>2){
			color = "purple";
		}
		if(this.getPassdays()>3){
			color = "darkorange";
		}
		if(this.getPassdays()>4){
			color = "plum";
		}
		if(this.getPassdays()>5){
			color = "fuchsia";
		}
		if(this.getPassdays()>6){
			color = "brown";
		}
		if(this.getPassdays()>7){
			color = "red";
		}
		if(this.capprove.equals("处理完毕")){
			color = "black";
		}
		return color;
	}
	
}