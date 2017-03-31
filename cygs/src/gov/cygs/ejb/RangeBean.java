package gov.cygs.ejb;

import gov.cygs.entities.Range;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Singleton
public class RangeBean {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;	
	
	List<Range> rangeList;
	
	List<String> classList;

	public RangeBean() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(){
		Query tq = em.createNamedQuery("Range.findAll");
		//this.rangeList = tq.getResultList();
		String sql = "select distinct r.itemclass from Range r order by itemclass";
		tq = em.createQuery(sql);
		this.classList = tq.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getSubItem(String itemclass){
		String sql = "select distinct r.itemname from Range r where r.itemclass=:iclass order by itemname ";
		Query tq = em.createQuery(sql);
		tq.setParameter("iclass", itemclass);
		List<String> itemnames = tq.getResultList();
		return itemnames;
	}
	
	@SuppressWarnings("unchecked")
	public Range getRange(String itemclass, String itemname){
		String sql = "select r from Range r where r.itemclass=:iclass and r.itemname=:iname ";
		Query tq = em.createQuery(sql);
		tq.setParameter("iclass", itemclass);
		tq.setParameter("iname", itemname);
		List<Range> ranges = tq.getResultList();
		if(!ranges.isEmpty()){
			return ranges.get(0);
		}else{
			return null;
		}
	}
	
	public Range getRange(int id){
		String sql = "select r from Range r where r.id=:rid";
		Query tq = em.createQuery(sql);
		tq.setParameter("rid", id);
		List<Range> ranges = tq.getResultList();
		if(!ranges.isEmpty()){
			return ranges.get(0);
		}else{
			return null;
		}
	}

	public List<Range> getRangeList() {
		return rangeList;
	}

	public void setRangeList(List<Range> rangeList) {
		this.rangeList = rangeList;
	}

	public List<String> getClassList() {
		return classList;
	}

	public void setClassList(List<String> classList) {
		this.classList = classList;
	}
}
