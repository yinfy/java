package gov.cygs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the jianshi database table.
 * 
 */
@Entity
@NamedQuery(name="Jianshi.findAll", query="SELECT d FROM Jianshi d")
public class Jianshi  extends EntityImpl implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@ManyToOne
	@JoinColumn(name="companyid")
	protected Companyreg companyreg;

	protected String cuuid;

	protected String jsempl;

	protected String jsidno;

	protected String jsidtype;

	protected String jsname;

	protected String jspos;

	protected String jstype;

	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;

	public Jianshi() {
		UUID uid = UUID.randomUUID();
		this.uuid = uid.toString();
		this.jsidno = "";
		this.jsidtype = "身份证";
		this.jsname = "";
		this.jspos = "监事";
		this.jstype = "监事";
		this.jsempl = "非职工代表";
		this.setTransport("inner");
		this.setUpdtime(new Date());
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

	public String getJsempl() {
		return this.jsempl;
	}

	public void setJsempl(String jsempl) {
		this.jsempl = jsempl;
	}

	public String getJsidno() {
		return this.jsidno;
	}

	public void setJsidno(String jsidno) {
		this.jsidno = jsidno;
	}

	public String getJsidtype() {
		return this.jsidtype;
	}

	public void setJsidtype(String jsidtype) {
		this.jsidtype = jsidtype;
	}

	public String getJsname() {
		return this.jsname;
	}

	public void setJsname(String jsname) {
		this.jsname = jsname;
	}

	public String getJspos() {
		return this.jspos;
	}

	public void setJspos(String jspos) {
		this.jspos = jspos;
	}

	public String getJstype() {
		return this.jstype;
	}

	public void setJstype(String jstype) {
		this.jstype = jstype;
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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Companyreg getCompanyreg() {
		return companyreg;
	}

	public void setCompanyreg(Companyreg companyreg) {
		this.companyreg = companyreg;
	}

}