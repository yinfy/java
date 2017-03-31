package gov.cygs.entities;

import gov.cygs.utils.Utils;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the yuyue database table.
 * 
 */
@Entity
@NamedQuery(name="Yuyue.findAll", query="SELECT y FROM Yuyue y")
public class Yuyue extends EntityImpl implements EntityInterface, Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected boolean handled;

	protected String mobile;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date orderdate;

	protected String orderno;

	protected String ordertime;

	protected String ordertype;

	@Column(name="person_id")
	protected String personId;

	@Column(name="person_name")
	protected String personName;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	public Yuyue() {
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getUpdtime() {
		return updtime;
	}

	public void setUpdtime(Date updtime) {
		this.updtime = updtime;
	}

	public String getOrdertimeNew() {
		String timestr= "";
		if(this.ordertime!=null && this.ordertime.equals("9~10") ){
			timestr = "8:30~9:30";
		}
		if(this.ordertime!=null && this.ordertime.equals("10~11") ){
			timestr = "9:30~10:30";
		}
		if(this.ordertime!=null && this.ordertime.equals("11~12") ){
			timestr = "10:30~11:30";
		}
		if(this.ordertime!=null && this.ordertime.equals("13~14") ){
			timestr = "13:30~14:30";
		}
		if(this.ordertime!=null && this.ordertime.equals("14~15") ){
			timestr = "14:30~15:30";
		}
		return timestr;
	}

}