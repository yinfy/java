package gov.cygs.entities;

import gov.cygs.dao.DBM;
import gov.cygs.utils.Utils;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.ejb.EJB;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sys_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Column(name="DISPLAY_NAME")
	protected String displayName;

	@Column(name="EMAIL_ID")
	protected String email;

	protected String idno;

	@Column(name="LOGIN_ID")
	protected String loginId;

	@Column(name="MOBILE_NO")
	protected String mobileNo;

	protected String password;
	
	protected String distriction;
	
	protected String role_id;
	
	protected int allcount;
	
	protected int newcount;
	
	@OneToMany( mappedBy="user", cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER  )
	protected List<Vacation> vacations;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_Date")
	protected Date regDate;

	protected String role;

	public SysUser() {
		this.distriction="";
		this.role="用户";
		this.role_id="user";
		this.idno="";
		this.mobileNo="";
		this.allcount = 0;
		this.newcount = 0;
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}
	
	public String getDistriction() {
		return distriction;
	}

	public void setDistriction(String distriction) {
		this.distriction = distriction;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public List<Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}
	
	public Vacation addVacation(Vacation obj) {
		getVacations().add(obj);
		obj.setUser(this);
		return obj;
	}
	public Vacation removeVacation(Vacation obj) {
		getVacations().remove(obj);
		obj.setUser(null);
		return obj;
	}

	public int getAllcount() {
		return allcount;
	}

	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}

	public int getNewcount() {
		return newcount;
	}

	public void setNewcount(int newcount) {
		this.newcount = newcount;
	}
}