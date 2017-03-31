package gov.cygs.swentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_ins_businessinfo database table.
 * 
 */
@Entity
@Table(name="t_ins_businessinfo")
@NamedQuery(name="TInsBusinessinfo.findAll", query="SELECT t FROM TInsBusinessinfo t")
public class TInsBusinessinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date applytime;

	private String appname;

	private String areaid;

	private String areaname;

	private String bjtype;

	private String bsnum;

	private String deptid;

	private String deptname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endfortime;

	private String exchange;

	private String ischange;

	private int limitdays;

	private String limitunit;

	private String permid;

	private String sfcz;

	private String sfjljb;

	private String ssgzr;

	private String status;

	private String sxbh;

	private String sxzxbh;

	private String sxzxname;

	private String type;

	private String xzxk;

	public TInsBusinessinfo() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date getApplytime() {
		return this.applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getBjtype() {
		return this.bjtype;
	}

	public void setBjtype(String bjtype) {
		this.bjtype = bjtype;
	}

	public String getBsnum() {
		return this.bsnum;
	}

	public void setBsnum(String bsnum) {
		this.bsnum = bsnum;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Date getEndfortime() {
		return this.endfortime;
	}

	public void setEndfortime(Date endfortime) {
		this.endfortime = endfortime;
	}

	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getIschange() {
		return this.ischange;
	}

	public void setIschange(String ischange) {
		this.ischange = ischange;
	}

	public int getLimitdays() {
		return this.limitdays;
	}

	public void setLimitdays(int limitdays) {
		this.limitdays = limitdays;
	}

	public String getLimitunit() {
		return this.limitunit;
	}

	public void setLimitunit(String limitunit) {
		this.limitunit = limitunit;
	}

	public String getPermid() {
		return this.permid;
	}

	public void setPermid(String permid) {
		this.permid = permid;
	}

	public String getSfcz() {
		return this.sfcz;
	}

	public void setSfcz(String sfcz) {
		this.sfcz = sfcz;
	}

	public String getSfjljb() {
		return this.sfjljb;
	}

	public void setSfjljb(String sfjljb) {
		this.sfjljb = sfjljb;
	}

	public String getSsgzr() {
		return this.ssgzr;
	}

	public void setSsgzr(String ssgzr) {
		this.ssgzr = ssgzr;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSxbh() {
		return this.sxbh;
	}

	public void setSxbh(String sxbh) {
		this.sxbh = sxbh;
	}

	public String getSxzxbh() {
		return this.sxzxbh;
	}

	public void setSxzxbh(String sxzxbh) {
		this.sxzxbh = sxzxbh;
	}

	public String getSxzxname() {
		return this.sxzxname;
	}

	public void setSxzxname(String sxzxname) {
		this.sxzxname = sxzxname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getXzxk() {
		return this.xzxk;
	}

	public void setXzxk(String xzxk) {
		this.xzxk = xzxk;
	}

}