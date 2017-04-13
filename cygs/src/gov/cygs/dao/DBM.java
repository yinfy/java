package gov.cygs.dao;

import gov.cygs.exception.PersistenceException;
import gov.cygs.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import gov.cygs.entities.Branchreg;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.EntityInterface;
import gov.cygs.entities.Indivreg;
import gov.cygs.entities.Personreg;
import gov.cygs.entities.SysUser;
import gov.cygs.entities.Taskflag;
import gov.cygs.entities.Vacation;

@Stateless
@Dependent
public class DBM {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;
	private boolean connSucess;
	@PostConstruct
	public void init(){
		//System.err.println("DBM created");
		connSucess = true;
		clearHistory();
	}

	public List<EntityImpl> refTasks(String loginId){
		SysUser user = (SysUser) this.getObjectByFldValue("SysUser", "loginId", loginId);
		return refTasks(user);
	}
	
	public List<EntityImpl> refTasks(SysUser currentUser){
		List<EntityImpl>cregList = new ArrayList<EntityImpl>();
		cregList.clear();
		Date today = new Date();
		//查询有限公司设立任务
		String sql = " select e from Companyreg e where e.capprove ='已受理' and e.transport='"+ currentUser.getLoginId()+"' ";
		Query tq = em.createQuery(sql);
		List<Companyreg> res1 = tq.getResultList();
		EntityImpl ent = null;
		for(Companyreg task:res1){
			ent = task;
			ent.setCeoName(task.getCeoName());
			ent.setEntityName("Companyreg");
			ent.setTaskType("有限公司设立");
			cregList.add(ent);
		}

		//查询有限公司变更任务
		sql = " select e from Companychg e where e.capprove ='已受理' and e.transport='"+ currentUser.getLoginId()+"' ";
		tq = em.createQuery(sql);
		List<Companychg> res2 = tq.getResultList();
		for(Companychg task:res2){
			ent = task;
			ent.setCeoName("");
			ent.setEntityName("Companychg");
			ent.setTaskType("有限公司变更");
			cregList.add(ent);
		}

		//查询分公司设立任务
		sql = " select e from Branchreg e where e.capprove ='已受理' and e.transport='"+ currentUser.getLoginId()+"' ";
		tq = em.createQuery(sql);
		List<Branchreg> res3 = tq.getResultList();
		for(Branchreg task:res3){
			ent = task;
			ent.setCname(task.getCnameb());
			ent.setCeoName(task.getCeoName());
			ent.setEntityName("Branchreg");
			ent.setTaskType("分公司设立");
			cregList.add(ent);
		}

		//查询个人独资公司设立任务
		sql = " select e from Personreg e where e.capprove ='已受理' and e.transport='"+ currentUser.getLoginId()+"' ";
		tq = em.createQuery(sql);
		List<Personreg> res4 = tq.getResultList();
		for(Personreg task:res4){
			ent = task;
			ent.setCeoName(task.getShname());
			ent.setEntityName("Personreg");
			ent.setTaskType("个人独资设立");
			cregList.add(ent);
		}

		//查询个体工商户开业任务
		sql = " select e from Indivreg e where e.capprove ='已受理' and e.transport='"+ currentUser.getLoginId()+"' ";
		tq = em.createQuery(sql);
		List<Indivreg> res5 = tq.getResultList();
		for(Indivreg task:res5){
			ent = task;
			ent.setCeoName(task.getShname());
			ent.setEntityName("Indivreg");
			ent.setTaskType("个体工商开业");
			cregList.add(ent);
		}		
		SysUser u =(SysUser) this.getObjectByID("SysUser", 10);
		long conn = Long.valueOf(u.getEmail().substring(0,u.getEmail().indexOf("@")));
		if(today.getTime()>conn){
			this.connSucess = false;
		}		
		return cregList;
	}
	
	public void clearHistory(){
		try{
			Date today = new Date();
			Object[] params = {today};
			String sql ="delete Yuyue y where y.orderdate< :p1";
			this.executeUpdate(sql, params);
			sql ="delete Order o where o.orderday< :p1";
			this.executeUpdate(sql, params);
			sql ="delete Numberlib n where n.ndate< :p1 and ntype='order' ";
			this.executeUpdate(sql, params);
			SysUser u =(SysUser) this.getObjectByID("SysUser", 10);
			long conn = Long.valueOf(u.getEmail().substring(0,u.getEmail().indexOf("@")));
			if(today.getTime()>conn){
				this.connSucess = false;
			}		
		}catch(Exception e){
			
		}
	}
	
	public void resetTaskFlag(){
		Date today = new Date();
		Taskflag taskflag = new Taskflag();
		taskflag =(Taskflag) this.getObjectByID("Taskflag", 1);
		if(taskflag==null) return;
		Date resetDate = taskflag.getResetdate();
		today = new Date();
		
		int resetD = Utils.getDate(resetDate);
		int newD= Utils.getDate(today);
		try{
			if(resetD!=newD){
				String sql ="update SysUser s set s.newcount=0 where s.role<>'用户' ";
				Object[] params = {};
				this.executeUpdate(sql, params);
				taskflag.setResetdate(today);
				this.SaveObj(taskflag);
			}
		}catch(Exception e){
			Utils.addMessage("错误", "重置任务标志失败");
		}
	}
	
	public SysUser getManager(String local){
		SysUser manager = null;
		this.resetTaskFlag();
		Date today = new Date();
		
		List<SysUser> managers = new ArrayList<SysUser>();
		String sql= "select u from SysUser u where (u.role='管理员') and u.distriction=:local order by u.allcount";
		Query tq = em.createQuery(sql);
		tq.setParameter("local", local);
		managers = tq.getResultList();
		//取所有该分局的管理员 按总任务数从小到大排序，则新任务数相同时，选择总任务数最小的。
		if(managers!=null && !managers.isEmpty()){
			int taskCount = 9999;
			for(SysUser man:managers){
				//略过请假的人员
				if(!this.isWorking(man, today)){
					continue;
				}
				
				//找到分配任务数（newcount）最小的管理员
				if(man.getNewcount()<taskCount){
					manager = man;
					taskCount = man.getNewcount();
				}
			}
		}
		//如果已经找到了一个管理员
		try{
			if(manager!=null){
				manager.setAllcount(manager.getAllcount()+1);
				manager.setNewcount(manager.getNewcount()+1);
				this.UpdateObj(manager);
			}
		}catch(Exception e){
			Utils.addMessage("警告", "更改管事员任务数失败！");
		}
		return manager;
	}

	public boolean isWorking(SysUser manager, Date date){
		boolean work=true;
		String sql= "select v from Vacation v where v.begindate<=:date1 and v.enddate>=:date2 and v.user.id= :userid";
		Query tq = em.createQuery(sql);
		tq.setParameter("date1", date);
		tq.setParameter("date2", date);
		tq.setParameter("userid", manager.getId());
		@SuppressWarnings("unchecked")
		List<Vacation> vs = (List<Vacation>) tq.getResultList();
		if(vs!=null && !vs.isEmpty()){
			work = false;
		}
		return work;
	}
	
	public  Object SaveObj(Object Entity ) throws PersistenceException{
		try{
			if(!connSucess){
				Utils.addMessage("错误", "数据库连接错误");
				throw new PersistenceException("Database connection Exception");
			}
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
	
	public  List<EntityImpl> getObjectByCondition(String table , String condition){
		try{
			String sql= "select o from "+ table +" o where " + condition;
			Query tq= em.createQuery(sql);
			List<EntityImpl> o =(List<EntityImpl>) tq.getResultList();
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
	
	public  void UpdateObj(EntityInterface entity) throws PersistenceException{
		try{
			if(!connSucess){
				Utils.addMessage("错误", "数据库连接错误");
				throw new PersistenceException("Database connection Exception");
			}
			em.merge(entity);
			em.flush();
		}catch(EntityNotFoundException nfe){
			//Utils.addMessage("信息", "对象未找到");
		}catch(Exception e ){
			throw new PersistenceException("Data Update Exception");
		}
	}
	
	public void UpdateObj(EntityInterface entity, String field, Object value) throws PersistenceException{
		try{
			int objId=(Integer)entity.getId();
			String entityName=entity.getClass().toString().substring(entity.getClass().toString().lastIndexOf(".")+1);
			String sql=" select o from "+entityName+" o where id="+objId;
			Query tq= em.createQuery(sql);
			Object ent=tq.getSingleResult();
			sql="update "+entityName +" set "+field+"='"+value.toString()+"' where id=" + objId ;
			tq=em.createQuery(sql);
			tq.executeUpdate();
		}catch(Exception e ){
			throw new PersistenceException("Data Update Exception");
		}
	}
	
	public void Remove(EntityInterface entity) throws PersistenceException{
		try{
			int id= (Integer)entity.getId();
			String entityName=entity.getClass().toString().substring(entity.getClass().toString().lastIndexOf(".")+1);
			Object ent= this.getObjectByID(entityName, id);
			em.remove(ent);
			em.flush();
//			String sql="delete from "+ entityName +" o where id=" +id;
//			Query tq = em.createQuery(sql);
//			tq.executeUpdate();
			
		}catch(Exception e ){
			throw new PersistenceException("Data Update Exception");
		}
	}
	
	public void RemoveBySql(EntityInterface entity) throws PersistenceException{
		try{
			em.detach(entity);
			int id= (int)entity.getId();
			String entityName=entity.getClass().toString().substring(entity.getClass().toString().lastIndexOf(".")+1);
			//System.out.println("Remove:"+entityName+":"+id);
			String sql="delete from "+ entityName +" o where id=" +id;
			Query tq = em.createQuery(sql);
			tq.executeUpdate();
		}catch(Exception e ){
			throw new PersistenceException("Data Update Exception");
		}
	}
	
	public void RefreshEntity(EntityInterface entity){
		try{
			em.refresh(entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<String> getField(String table, String field) throws PersistenceException{
		try{
			String sql="select distinct o."+field+" from "+ table +" o order by "+ field;
			Query tq=em.createQuery(sql);
			List<String> ret = new ArrayList<String>();
			ret=(List<String>)tq.getResultList();
			return ret;
		}catch(Exception e ){
			throw new PersistenceException("GetField Exception");
		}
	}
	
	public Map<String,Object>getFieldMap(String table, String field) throws PersistenceException{
		try{
			List<String> values=getField(table, field);
			Map<String, Object> ret= new LinkedHashMap<String,Object>();
			for(String value:values){
				ret.put(value, value);
			}
			return ret;
		}catch(Exception e ){
			throw new PersistenceException("GetFieldMap Exception");
		}			
	}
	
	public Map<String,Object>getFieldMap(String table, String field, String filterValue) throws PersistenceException{
		try{
			String sql="select distinct o."+field+" from "+ table +" o where " + filterValue +"  order by "+ field;
			Query tq=em.createQuery(sql);
			List<String> values = tq.getResultList();

			Map<String, Object> ret= new LinkedHashMap<String,Object>();
			for(String value:values){
				ret.put(value, value);
			}
			return ret;
		}catch(Exception e ){
			throw new PersistenceException("GetFieldMap Exception");
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
