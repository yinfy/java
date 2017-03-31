package gov.cygs.swentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_ins_formdata database table.
 * 
 */
@Entity
@Table(name="t_ins_formdata")
@NamedQuery(name="TInsFormdata.findAll", query="SELECT t FROM TInsFormdata t")
public class TInsFormdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;

	private String bsnum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String dataid;

	@Lob
	private String dataxml;

	private String exchange;

	public TInsFormdata() {
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

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDataid() {
		return this.dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getDataxml() {
		return this.dataxml;
	}

	public void setDataxml(String dataxml) {
		this.dataxml = dataxml;
	}

	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

}