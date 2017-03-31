package gov.cygs.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the shareholders database table.
 * 
 */
@Entity
@Table(name="shmode")
public class Shmode extends EntityImpl implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String shuuid;

	protected float shamount;

	protected String shmethod;

	protected float shpercent;

	protected String transport;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updtime;

	protected String uuid;

	//bi-directional many-to-one association to Companyreg
	@ManyToOne
	@JoinColumn(name="shid")
	protected Shareholder shareholder;
	
	public Shmode() {
		UUID uid = UUID.randomUUID();
		Shmode sh = this;
		sh.setShuuid(uuid);
		sh.setShmethod("货币");
		sh.setShamount(0);
		sh.setShpercent(0);
		sh.setUuid(uid.toString());
		sh.setTransport("inner");
		sh.setUpdtime(new Date());
	}

	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getShamount() {
		return this.shamount;
	}

	public void setShamount(float shamount) {
		try{
			this.shamount = shamount;
			float capital = this.getShareholder().getCompanyreg().getCapital();

			if(capital<=0){
				this.shpercent = 0;
			}else{
				this.shpercent = (shamount/capital) * 100;
			}
		}catch(Exception e){
		}
	}

	public String getShmethod() {
		return this.shmethod;
	}

	public void setShmethod(String shmethod) {
		this.shmethod = shmethod;
	}

	public float getShpercent() {
		try{
			float capital = this.getShareholder().getCompanyreg().getCapital();
			if(capital<=0){
				this.shpercent = 0;
			}else{
				this.shpercent = (shamount/capital) * 100;
			}
		}catch(Exception e){
		}
		return this.shpercent;
	}

	public void setShpercent(float shpercent) {
		this.shpercent = shpercent;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Date getUpdtime() {
		return updtime;
	}

	public void setUpdtime(Date updtime) {
		this.updtime = updtime;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Shareholder getShareholder() {
		return this.shareholder;
	}

	public void setShareholder(Shareholder shareholder) {
		this.shareholder = shareholder;
	}

	public String getShuuid() {
		return shuuid;
	}

	public void setShuuid(String shuuid) {
		this.shuuid = shuuid;
	}
}