package gov.cygs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the dongshi database table.
 * 
 */
@Entity
@NamedQuery(name="Vacation.findAll", query="SELECT d FROM Vacation d")
public class Vacation  extends EntityImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="userid")
	protected SysUser user;

	@ManyToOne
	@JoinColumn(name="adminid")
	protected SysUser admin;

	private String reason;

	@Temporal(TemporalType.TIMESTAMP)
	private Date approvetime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date begindate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	private String uuid;
	
	public Vacation() {
		UUID uid = UUID.randomUUID();
		this.uuid = uid.toString();
		this.reason = "事假";
		Date today = new Date();
		this.begindate = today;
		this.enddate = today;
		this.approvetime = today;
	}

	public Object getId() {
		
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public SysUser getAdmin() {
		return admin;
	}

	public void setAdmin(SysUser admin) {
		this.admin = admin;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(Date approvetime) {
		this.approvetime = approvetime;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}