package gov.cygs.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

	protected BigDecimal shamount;

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
		sh.setShamount(BigDecimal.ZERO);
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

	public BigDecimal getShamount() {
		return this.shamount;
	}

	public void setShamount(BigDecimal shamount) {
		try{
			this.shamount = shamount;
			BigDecimal capital = this.getShareholder().getCompanyreg().getCapital();

			if(capital.doubleValue()<=0){
				this.shpercent = 0;
			}else{
				this.shpercent =((shamount.divide(capital, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).floatValue();
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
			BigDecimal capital = this.getShareholder().getCompanyreg().getCapital();
			if(capital.doubleValue()<=0){
				this.shpercent = 0;
			}else{
				this.shpercent =((shamount.divide(capital, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).floatValue();
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