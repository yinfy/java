package gov.cygs.entities;

import gov.cygs.utils.Utils;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.lang.reflect.Field;
import java.math.BigInteger;


/**
 * The persistent class for the shareholders database table.
 * 
 */
@Entity
@Table(name="shareholder")
@NamedQuery(name="Shareholder.findAll", query="SELECT s FROM Shareholder s")
public class Shareholder extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String cuuid;

	protected float shamount;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date shdate;

	protected String shidno;

	protected String shidtype;

	protected String shmethod;

	protected String shname;

	protected float shpercent;

	protected String shtype;

	protected String transport;
	
	protected String shaddr;
	
	protected String shphone;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;
	
	@OneToMany( mappedBy="shareholder", cascade={CascadeType.REMOVE}, fetch=FetchType.EAGER  )
	protected List<Shmode> shmodes;

	
	//bi-directional many-to-one association to Companyreg
	@ManyToOne
	@JoinColumn(name="companyid")
	protected Companyreg companyreg;
	
	public List<String> getShidtypes(){
		List<String> shidtypes = new ArrayList<String>();
		if (shtype!=null && shtype.equals("自然人")){
			shidtypes.add("身份证");
			shidtypes.add("其他有效身份证件");
		}
		if (shtype!=null && shtype.equals("法人单位")){
			shidtypes.add("法人登记证");
			shidtypes.add("营业执照");
		}
		if (shtype!=null && shtype.equals("其他")){
			shidtypes.add("其他");
		}
		return shidtypes;
	}
	
	public Shareholder() {
		UUID uid = UUID.randomUUID();
		Shareholder sh = this;
		sh.setShname("");
		sh.setShidno("");
		sh.setShmethod("货币");
		sh.setShamount(0);
		sh.setShpercent(0);
		sh.setShtype("自然人");
		sh.setShidtype("身份证");
		sh.setUuid(uid.toString());
		sh.setTransport("inner");
		sh.setShaddr("");
		sh.setShphone("");
		sh.setUpdtime(new Date());
		this.shmodes = new ArrayList<Shmode>();
		Shmode shmode = new Shmode();
		shmode.setShuuid(uid.toString());
		shmode.setShmethod("货币");
		this.addShmode(shmode);
		
		shmode = new Shmode();
		shmode.setShuuid(uid.toString());
		shmode.setShmethod("实物");
		this.addShmode(shmode);
		
		shmode = new Shmode();
		shmode.setShuuid(uid.toString());
		shmode.setShmethod("知识产权");
		this.addShmode(shmode);
		
		shmode = new Shmode();
		shmode.setShuuid(uid.toString());
		shmode.setShmethod("土地使用权");
		this.addShmode(shmode);

		shmode = new Shmode();
		shmode.setShuuid(uid.toString());
		shmode.setShmethod("股权");
		this.addShmode(shmode);
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuuid() {
		return this.cuuid;
	}

	public void setCuuid(String cuuid) {
		this.cuuid = cuuid;
	}

	public float getShamount() {
		this.shamount = 0;
		if(this.shmodes==null) return 0;
		for(Shmode shmode: this.shmodes){
			this.shamount =this.shamount + shmode.getShamount();
		}
		return this.shamount;
	}

	public void setShamount(float shamount) {
		this.shamount = 0;
		if(this.shmodes==null) {
			this.shamount = 0;
			return ;
		}
		for(Shmode shmode: this.shmodes){
			this.shamount =this.shamount + shmode.getShamount();
		}
		this.shamount = shamount;
	}

	public Date getShdate() {
		return this.shdate;
	}

	public void setShdate(Date shdate) {
		this.shdate = shdate;
	}

	public String getShidno() {
		return this.shidno;
	}

	public void setShidno(String shidno) {
		this.shidno = shidno;
	}

	public String getShidtype() {
		return this.shidtype;
	}

	public void setShidtype(String shidtype) {
		this.shidtype = shidtype;
	}

	public String getShmethod() {
		return this.shmethod;
	}

	public void setShmethod(String shmethod) {
		this.shmethod = shmethod;
	}

	public String getShname() {
		return this.shname;
	}

	public void setShname(String shname) {
		this.shname = shname;
	}

	public float getShpercent() {
		this.shpercent = 0;
		if(this.shmodes==null) return 0;
		for(Shmode shmode: this.shmodes){
			this.shpercent =this.shpercent + shmode.getShpercent();
		}
		this.shpercent = (float) Math.round(this.shpercent*100)/100;
		return this.shpercent;
	}

	public void setShpercent(float shpercent) {
		this.shpercent = 0;
		if(this.shmodes==null) {
			this.shpercent = 0;
			return;
		}
		for(Shmode shmode: this.shmodes){
			this.shpercent =this.shpercent + shmode.getShpercent();
		}
		this.shpercent = shpercent;
	}

	public String getShtype() {
		return this.shtype;
	}

	public void setShtype(String shtype) {
		this.shtype = shtype;
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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Companyreg getCompanyreg() {
		return this.companyreg;
	}

	public void setCompanyreg(Companyreg companyreg) {
		this.companyreg = companyreg;
	}

	public String getShaddr() {
		return shaddr;
	}

	public void setShaddr(String shaddr) {
		this.shaddr = shaddr;
	}

	public String getShphone() {
		return shphone;
	}

	public void setShphone(String shphone) {
		this.shphone = shphone;
	}

	public List<Shmode> getShmodes() {
		return shmodes;
	}

	public void setShmodes(List<Shmode> shmodes) {
		this.shmodes = shmodes;
	}
	
	public Shmode addShmode(Shmode shmode) {
		getShmodes().add(shmode);
		shmode.setShareholder(this);
		return shmode;
	}

	public Shmode removeShmode(Shmode shmode) {
		getShmodes().remove(shmode);
		shmode.setShareholder(null);
		return shmode;
	}
}