package gov.cygs.swentities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_ins_material_file database table.
 * 
 */
@Entity
@Table(name="t_ins_material_file")
@NamedQuery(name="TInsMaterialFile.findAll", query="SELECT t FROM TInsMaterialFile t")
public class TInsMaterialFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;

	private String fileid;

	private String id;

	private String mid;

	private String status;

	public TInsMaterialFile() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getFileid() {
		return this.fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}