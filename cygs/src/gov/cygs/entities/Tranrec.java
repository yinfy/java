package gov.cygs.entities;

import gov.cygs.utils.Utils;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tranrec database table.
 * 
 */
@Entity
@NamedQuery(name="Tranrec.findAll", query="SELECT t FROM Tranrec t")
public class Tranrec extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String direction;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date trantime;

	protected int userid;

	public Tranrec() {
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Date getTrantime() {
		return this.trantime;
	}

	public void setTrantime(Date trantime) {
		this.trantime = trantime;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}