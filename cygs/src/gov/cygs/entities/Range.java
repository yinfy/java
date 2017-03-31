package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the range database table.
 * 
 */
@Entity
@Table(name="rangetbl")
@NamedQuery(name="Range.findAll", query="SELECT r FROM Range r order by r.code")
public class Range extends EntityImpl  implements Serializable {
	protected static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String code;

	protected String filedept;

	protected String filename;

	protected String isflag;

	protected String itemclass; 

	protected String itemtype;
	
	protected String itemname;

	protected String remark;

	public Range() {
		this.code = "";
		this.filedept="";
		this.filename = "";
		this.id = 0;
		this.isflag = "否";
		this.itemclass ="";
		this.itemname ="";
		this.itemtype = "";
		this.remark ="";
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFiledept() {
		return this.filedept;
	}

	public void setFiledept(String filedept) {
		this.filedept = filedept;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIsflag() {
		return this.isflag;
	}

	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}

	public String getItemclass() {
		return this.itemclass;
	}

	public void setItemclass(String itemclass) {
		this.itemclass = itemclass;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

}