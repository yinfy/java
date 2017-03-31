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
@NamedQuery(name="Dongshi.findAll", query="SELECT d FROM Dongshi d")
public class Dongshi  extends EntityImpl implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@ManyToOne
	@JoinColumn(name="companyid")
	protected Companyreg companyreg;

	protected String cuuid;

	protected String dsempl;

	protected String dsidno;

	protected String dsidtype;

	protected String dsname;

	protected String dspos;

	protected String dstype;

	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;

	public Dongshi() {
		UUID uid = UUID.randomUUID();
		this.uuid = uid.toString();
		this.dsidno = "";
		this.dsidtype = "身份证";
		this.dsname = "";
		this.dspos = "董事";
		this.dstype = "董事";
		this.dsempl = "";
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

	public String getDsempl() {
		return this.dsempl;
	}

	public void setDsempl(String dsempl) {
		this.dsempl = dsempl;
	}

	public String getDsidno() {
		return this.dsidno;
	}

	public void setDsidno(String dsidno) {
		this.dsidno = dsidno;
	}

	public String getDsidtype() {
		return this.dsidtype;
	}

	public void setDsidtype(String dsidtype) {
		this.dsidtype = dsidtype;
	}

	public String getDsname() {
		return this.dsname;
	}

	public void setDsname(String dsname) {
		this.dsname = dsname;
	}

	public String getDspos() {
		if(this.dspos==null){
			return "";
		}else{
			return this.dspos;
		}
	}

	public void setDspos(String dspos) {
		this.dspos = dspos;
	}

	public String getDstype() {
		return this.dstype;
	}

	public void setDstype(String dstype) {
		this.dstype = dstype;
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