package gov.cygs.dao;

import gov.cygs.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.EntityInterface;

@Stateless
@Dependent
public class SWDBM {
	@PersistenceContext(unitName = "eswitch")
	private EntityManager em;
	
	@PostConstruct
	public void init(){
	}
	
	public  Object SaveObj(Object Entity ) throws PersistenceException{
		try{
			em.persist(Entity);
			em.flush();
			return Entity;
		}catch( Exception e ){
			throw new PersistenceException("Data Save Exception");
		}
	}
	
	public  Object getObjectByID(String table ,int id){
		try{
			String sql= "select o from "+ table +" o where id="+id;
			Query tq= em.createQuery(sql);
			Object o = tq.getSingleResult();
			sql= null;
			tq = null;
			return o;
		}catch(Exception e ){
		}
		return null;
	}
	
	public  Object getObjectByFldValue(String table ,String fld, Object value){
		try{
			String sql= "select o from "+ table +" o where o."+ fld+" =:para";
			Query tq= em.createQuery(sql);
			tq.setParameter("para", value);
			Object o = tq.getSingleResult();
			tq = null;
			sql = null;
			return o;
		}catch(Exception e ){
		}
		return null;
	}
	
	public  List<Object> getObjectByCondition(String table , String condition){
		try{
			String sql= "select o from "+ table +" o where " + condition;
			Query tq= em.createQuery(sql);
			List<Object> o =(List<Object>) tq.getResultList();
			tq = null;
			sql = null;
			return  o;
		}catch(Exception e ){
		}
		return null;
	}
		
	public int executeUpdate(String sql, Object [] params){
		int rows=0;
		try{
			Query tq= em.createQuery(sql);
			int pi=1;
			String pn = "p"+pi;
			for(Object para:params){
				tq.setParameter(pn, para);
			}
			rows= tq.executeUpdate();
			tq = null;
		}catch(Exception e ){
			rows = -1;
		}
		return rows;
	}
	
	public  boolean CheckExist(Object entity, Map<String,String> values ) throws PersistenceException{

		try{
			String entityName=entity.getClass().toString().substring(entity.getClass().toString().lastIndexOf(".")+1);
			String sql=" select count(o) from "+entityName+" o where 1>0 ";
			for (Iterator<String> it = values.keySet().iterator(); it.hasNext();) {
				String fldName= it.next();
				String fldValue= values.get(fldName);
				sql=sql+" and "+ fldName +"='"+fldValue+"'";		
			}
			Query tq= em.createQuery(sql);
			tq= em.createQuery(sql);
			int rescount=((Long)(tq.getSingleResult())).intValue();
			if(rescount>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e ){
			throw new PersistenceException("Data Equit Exist Exception");
		}
	}
	
	public  void UpdateObj(Object entity) throws PersistenceException{
		try{
			em.merge(entity);
			em.flush();
		}catch(EntityNotFoundException nfe){
			//Utils.addMessage("信息", "对象未找到");
		}catch(Exception e ){
			throw new PersistenceException("Data Update Exception");
		}
	}

	public EntityManager getEntityManager() {
		try{
			return em;
		}catch(Exception e ){
		}
		return null;
	}
	
	public void jdbcExecute(String sql) throws SQLException{
		DB_Conn dbu= new DB_Conn();
		DataSource ds = dbu.getDataSource();
		Connection conn= ds.getConnection();
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.executeUpdate();
		dbu.release(conn, ps, null);		
	}
	
	@PreDestroy
	public void destroy(){
		//em.close();
		//System.err.println("DBM destroyed");
	}
	
	@javax.ejb.Remove
	public void end(){
		//System.err.println("DBM killed");
	}
	
}
