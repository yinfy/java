package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the numberlib database table.
 * 
 */
@Entity
@NamedQuery(name="Numberlib.findAll", query="SELECT n FROM Numberlib n")
public class Numberlib extends EntityImpl implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ndate;

	private String ntype;

	private int nodate;
	
	private String numberStr;

	private String prefix;

	private int seq;

	private int width;

	public Numberlib() {
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNdate() {
		return this.ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	public String getNtype() {
		return this.ntype;
	}

	public void setNtype(String ntype) {
		this.ntype = ntype;
	}

	public int getNodate() {
		return nodate;
	}

	public void setNodate(int nodate) {
		this.nodate = nodate;
	}

	public String getNumberStr() {
		return this.numberStr;
	}

	public void setNumberStr(String numberStr) {
		this.numberStr = numberStr;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}