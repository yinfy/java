package gov.cygs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the jianshi database table.
 * 
 */
@Entity
@NamedQuery(name="Taskflag.findAll", query="SELECT d FROM Taskflag d")
public class Taskflag  extends EntityImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int resetflag;

	@Temporal(TemporalType.TIMESTAMP)
	private Date resetdate;

	public 
	Taskflag() {
		this.resetdate= new Date();
		this.resetflag = 0;
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResetflag() {
		return resetflag;
	}

	public void setResetflag(int resetflag) {
		this.resetflag = resetflag;
	}

	public Date getResetdate() {
		return resetdate;
	}

	public void setResetdate(Date resetdate) {
		this.resetdate = resetdate;
	}

}