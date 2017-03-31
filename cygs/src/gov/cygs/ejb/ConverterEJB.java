package gov.cygs.ejb;

import gov.cygs.entities.Dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
public class ConverterEJB {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;	
	
	private Map<String,Dictionary> dictMap;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(){
		dictMap=new HashMap<String,Dictionary>();
		List <Dictionary> dictList= em.createNamedQuery("Dictionary.findAll").getResultList();
		for(Dictionary d:dictList){
			dictMap.put(d.getTable()+"_"+d.getFldName(),d);
		}
	}

	public Map<String, Dictionary> getDictMap() {
		return dictMap;
	}

	public Map<String, Dictionary> getDictMap(String table) {
		Map<String,Dictionary> dMap=new HashMap<String,Dictionary>();
		Set<String> keys= dictMap.keySet();
		for(String k:keys){
			dMap.put(k, dictMap.get(k));
		}
		return dMap;
	}
	
	public boolean CheckUnique(String table, String fld,String fldType,String valueStr){
		String sql="select count(c) from " +table + " where c."+fld+"="+valueStr;
		switch(fldType){
		case "email":
		case "string":
		case "password":
		case "dateTime":
		case "digital":
			sql="select count(c) from " +table + " c where c."+fld+"='"+valueStr+"'";
		}
		Query tq= em.createQuery(sql);
		
		int cnt=((Long)(tq.getSingleResult())).intValue();
		if(cnt>0){
			return false;
		}else{
			return true;
		}
	}

	

}
