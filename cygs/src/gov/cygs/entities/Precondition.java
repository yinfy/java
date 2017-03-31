package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the shareholders database table.
 * 
 */
@Entity
@Table(name="precondition")
@NamedQuery(name="Precondition.findAll", query="SELECT s FROM Precondition s")
public class Precondition extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String cuuid;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date prevdate;

	protected String prename;

	protected String preno;

	protected String precontent;

	protected String predept;
	
	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;
	
	protected int rangeid;

	@ManyToOne
	@JoinColumn(name="companyid")
	protected Companyreg companyreg;

	public Precondition() {
		
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

	public Companyreg getCompanyreg() {
		return this.companyreg;
	}

	public void setCompanyreg(Companyreg companyreg) {
		this.companyreg = companyreg;
	}

	public Date getPrevdate() {
		return prevdate;
	}

	public void setPrevdate(Date prevdate) {
		this.prevdate = prevdate;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getPreno() {
		return preno;
	}

	public void setPreno(String preno) {
		this.preno = preno;
	}

	public String getPrecontent() {
		return precontent;
	}

	public void setPrecontent(String precontent) {
		this.precontent = precontent;
	}

	public String getPredept() {
		return predept;
	}

	public void setPredept(String predept) {
		this.predept = predept;
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

	public int getRangeid() {
		return rangeid;
	}

	public void setRangeid(int rangeid) {
		this.rangeid = rangeid;
	}
}