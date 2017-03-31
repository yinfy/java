package gov.cygs.swentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_ins_log database table.
 * 
 */
@Entity
@Table(name="t_ins_log")
@NamedQuery(name="TInsLog.findAll", query="SELECT t FROM TInsLog t")
public class TInsLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivetime;

	private String bsnum;

	private String bstype;

	private String exchange;

	private String handler;

	@Temporal(TemporalType.TIMESTAMP)
	private Date handletime;

	private String idea;

	private String lid;

	private String nexthandler;

	private String nodename;

	private String nodetype;

	private String operattype;

	public TInsLog() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date getArrivetime() {
		return this.arrivetime;
	}

	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getBsnum() {
		return this.bsnum;
	}

	public void setBsnum(String bsnum) {
		this.bsnum = bsnum;
	}

	public String getBstype() {
		return this.bstype;
	}

	public void setBstype(String bstype) {
		this.bstype = bstype;
	}

	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getHandler() {
		return this.handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Date getHandletime() {
		return this.handletime;
	}

	public void setHandletime(Date handletime) {
		this.handletime = handletime;
	}

	public String getIdea() {
		return this.idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getLid() {
		return this.lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getNexthandler() {
		return this.nexthandler;
	}

	public void setNexthandler(String nexthandler) {
		this.nexthandler = nexthandler;
	}

	public String getNodename() {
		return this.nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public String getNodetype() {
		return this.nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getOperattype() {
		return this.operattype;
	}

	public void setOperattype(String operattype) {
		this.operattype = operattype;
	}

}