package gov.cygs.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dictionary database table.
 * 
 */
@Entity
@NamedQuery(name="Dictionary.findAll", query="SELECT d FROM Dictionary d")
public class Dictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="`DEFAULT`")
	private String default_;
	
	private String describe;

	private boolean empty;

	@Column(name="FLD_NAME")
	private String fldName;
	
	private String realname;

	@Column(name="FLD_TYPE")
	private String fldType;

	private int length;

	@Column(name="MAX_VALUE")
	private String maxValue;

	@Column(name="MIN_LENTH")
	private int minLenth;

	@Column(name="MIN_VALUE")
	private String minValue;

	@Column(name="`TABLE`")
	private String table;

	@Column(name="`UNIQUE`")
	private boolean unique;

	@Column(name="`EXPORT`")
	private boolean export;

	public Dictionary() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDefault_() {
		return this.default_;
	}

	public void setDefault_(String default_) {
		this.default_ = default_;
	}

	public boolean getEmpty() {
		return this.empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public String getFldName() {
		return this.fldName;
	}

	public void setFldName(String fldName) {
		this.fldName = fldName;
	}

	public String getFldType() {
		return this.fldType;
	}

	public void setFldType(String fldType) {
		this.fldType = fldType;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public int getMinLenth() {
		return this.minLenth;
	}

	public void setMinLenth(int minLenth) {
		this.minLenth = minLenth;
	}

	public String getMinValue() {
		return this.minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getTable() {
		return this.table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public boolean getUnique() {
		return this.unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public boolean getExport() {
		return export;
	}

	public void setExport(boolean export) {
		this.export = export;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}