package gov.cygs.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sysmenu database table.
 * 
 */
@Entity
@NamedQuery(name="SysMenu.findAll", query="SELECT s FROM SysMenu s")
@Table(name="sysmenu")
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int super_admin;

	private int local_admin;

	private int admin;

	private int catalog;

	private String function;

	private int menulevel;

	private String menuname;

	private int user;

	private int none;

	private float sequence;
	
	private int ts_admin;
	
	private int ts_handle;

	public SysMenu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCatalog() {
		return this.catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getMenulevel() {
		return this.menulevel;
	}

	public void setMenulevel(int menulevel) {
		this.menulevel = menulevel;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public float getSequence() {
		return this.sequence;
	}

	public void setSequence(float sequence) {
		this.sequence = sequence;
	}

	public int getSuper_admin() {
		return super_admin;
	}

	public void setSuper_admin(int super_admin) {
		this.super_admin = super_admin;
	}

	public int getLocal_admin() {
		return local_admin;
	}

	public void setLocal_admin(int local_admin) {
		this.local_admin = local_admin;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getNone() {
		return none;
	}

	public void setNone(int none) {
		this.none = none;
	}

	public int getTs_admin() {
		return ts_admin;
	}

	public void setTs_admin(int ts_admin) {
		this.ts_admin = ts_admin;
	}

	public int getTs_handle() {
		return ts_handle;
	}

	public void setTs_handle(int ts_handle) {
		this.ts_handle = ts_handle;
	}

}