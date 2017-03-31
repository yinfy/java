package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the shareholders database table.
 * 
 */
@Entity
@Table(name="upfile2")
@NamedQuery(name="Upfile2.findAll", query="SELECT s FROM Upfile2 s order by s.fileno ")
public class Upfile2 extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String cuuid;

	protected String filename;

	protected int fileno;

	protected String filetype;

	protected String remark;
	
	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;
	
	@ManyToOne
	@JoinColumn(name="companyid")
	protected Eventhand eventhand;

	public Upfile2() {
		
	}

	public Object getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuuid() {
		return cuuid;
	}

	public void setCuuid(String cuuid) {
		this.cuuid = cuuid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Eventhand getEventhand() {
		return eventhand;
	}

	public void setEventhand(Eventhand eventhand) {
		this.eventhand = eventhand;
	}


}