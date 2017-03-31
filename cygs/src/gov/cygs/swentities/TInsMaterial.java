package gov.cygs.swentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_ins_material database table.
 * 
 */
@Entity
@Table(name="t_ins_material")
@NamedQuery(name="TInsMaterial.findAll", query="SELECT t FROM TInsMaterial t")
public class TInsMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;

	private String bsnum;

	private String clbh;

	private String clid;

	private String clmc;

	private String copynum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String id;

	private String isneed;

	private String orinum;

	private String status;

	private String submittype;

	private String sxid;

	public TInsMaterial() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getBsnum() {
		return this.bsnum;
	}

	public void setBsnum(String bsnum) {
		this.bsnum = bsnum;
	}

	public String getClbh() {
		return this.clbh;
	}

	public void setClbh(String clbh) {
		this.clbh = clbh;
	}

	public String getClid() {
		return this.clid;
	}

	public void setClid(String clid) {
		this.clid = clid;
	}

	public String getClmc() {
		return this.clmc;
	}

	public void setClmc(String clmc) {
		this.clmc = clmc;
	}

	public String getCopynum() {
		return this.copynum;
	}

	public void setCopynum(String copynum) {
		this.copynum = copynum;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsneed() {
		return this.isneed;
	}

	public void setIsneed(String isneed) {
		this.isneed = isneed;
	}

	public String getOrinum() {
		return this.orinum;
	}

	public void setOrinum(String orinum) {
		this.orinum = orinum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmittype() {
		return this.submittype;
	}

	public void setSubmittype(String submittype) {
		this.submittype = submittype;
	}

	public String getSxid() {
		return this.sxid;
	}

	public void setSxid(String sxid) {
		this.sxid = sxid;
	}

}