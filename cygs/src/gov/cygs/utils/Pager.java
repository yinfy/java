package gov.cygs.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import gov.cygs.entities.EntityInterface;

public class Pager implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<String> condations;
	protected String queryObj;
	private Query tquery;
	protected int pageSize;
	protected String orderCol;
	protected String orderDir;
	protected String iniOrderDir;
	protected int total_pages;
	protected int curpage;
	protected Map<String,Object> userFilter;
	
	public void setUserFilter(Map<String, Object> userFilter) {
		this.userFilter = userFilter;
	}

	protected LazyDataModel model; 
	protected int totalRowCount =0;		
		
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;	
	
	public Pager(){
		this.condations= new ArrayList<String>();
		this.queryObj="";
		
		model = new LazyDataModel() {
			
			@Override
		    public Object getRowData(String rowKey) {
		        return Pager.this.getDataById(rowKey);
		    }
			
		    @Override
		    public Object getRowKey(Object obj) {
		    	return ((EntityInterface)obj).getId();
		    }
			
			@SuppressWarnings("rawtypes")
			@Override 
			public List load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) { 
				//load physical data
//				System.out.println("load called : ================================================");
//				System.out.println("first:"+ first);
//				System.out.println("pageSize:"+ pageSize);
//				System.out.println("sortField:"+ sortField);
//				System.out.println("sortOrder:"+ sortOrder.toString());
//				System.out.println("filters:"+ filters.toString());
				
				if(sortField==null){
					if(Pager.this.orderCol!=null){
						sortField=Pager.this.orderCol;
					}else{
						sortField="id";
					}
				}
				
				List<Object> data = new ArrayList<Object>();
				Pager.this.orderCol=sortField;
				
				
				if(sortOrder==null){
					sortOrder= SortOrder.ASCENDING;
					if(Pager.this.orderDir.equals("desc")){
						sortOrder= SortOrder.DESCENDING;	
					}
				}
				
				Pager.this.filterParse(filters);
				
				if(sortOrder==SortOrder.DESCENDING){
					Pager.this.orderDir="desc";
				}else{
					Pager.this.orderDir="asc";
				}
				Pager.this.pageSize= pageSize;
				int pageNo=(int) Math.ceil((float)(first+1)/(float)Pager.this.pageSize);
				Pager.this.curpage= pageNo;
				int rowcount=Pager.this.totalRowCount=Pager.this.getResultCount();
				this.setRowCount(rowcount);
				data=Pager.this.getPage(Pager.this.curpage);
				return data;
			} 
		}; 
		
	}

	public List<String> getCondations() {
		return condations;
	}

	public void setCondations(List<String> condations) {
		this.condations = condations;
	}
	
	public String getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(String queryObj) {
		this.queryObj = queryObj;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderCol() {
		return orderCol;
	}

	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
	
	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
//		System.out.println("set curpage to:"+ curpage);
		this.curpage = curpage;
	}

	public LazyDataModel getModel() {
		return model; 
	}
	
	private String genCon(){
		String qCon = "";
		
		this.filterParse(null);
		
		if(!this.condations.isEmpty()){
			qCon= " where ";
			int seq= 1;
			for(String con: this.condations){
				if(con.indexOf("[")>=0){ // 自定义查询条件 如： [ or (field = "value") ]
					con = con.substring(con.indexOf("[")+1,con.indexOf("]"));
					if (seq ==1){
						if(con.trim().indexOf("and")==0){
							qCon= qCon + " (1>0 " + con +") ";	
						}
						if(con.trim().indexOf("or")==0){
							qCon= qCon + " (1<0 " + con +") ";
						}	
					}else{
					qCon= qCon +" "+ con +" ";
					}
				}else{
					if (seq ==1){
						qCon= qCon + con ;	
					}else{
						qCon= qCon + " and " + con;
					}
				}
				seq++;
			}
		}
		return qCon;
	}

	public int getResultCount(){
		String sql="";
		String qCon=" ";
		int rescount=0;
		
		qCon= genCon();
		
		sql= "select count(c) from " + queryObj + " c " + qCon ;
//		System.out.println("Pager:getResultCount:sql:"+sql);
		tquery= this.em.createQuery(sql);
		rescount=((Long)(tquery.getSingleResult())).intValue();
//		System.out.println("Rescount:"+rescount);
		return rescount;
	}
	
	public double[] getTotals(String[] fields){
		String sql = "select ";
		String qCon= genCon();
		
		for(int i=0; i< fields.length; i++){
			String fld= fields[i];
			sql = sql + "sum(" + fld + ") as t"+i +"," ;
		}
		sql = sql.substring(0, sql.length()-1);
		
		sql = sql + " from " + queryObj + " c " + qCon ;
		tquery= this.em.createQuery(sql);
		Object[] reso = (Object[]) tquery.getSingleResult();
		double[] res = new double[reso.length];
		try{
			for(int i= 0; i<reso.length; i++){
				res[i]= (double) reso[i];
			}
		}catch(Exception e){
			
		}
		return res;
	}
	
	public double[] getTotals(String[] fields, String condition){
		String sql = "select ";
		String qCon= genCon();
		
		if(qCon.equals("")){
			qCon = qCon + " where " + condition;
		}else{
			qCon = qCon + " and " + condition;
		}
		
		for(int i=0; i< fields.length; i++){
			String fld= fields[i];
			sql = sql + "sum(" + fld + ") as t"+i +"," ;
		}
		sql = sql.substring(0, sql.length()-1);
		
		sql = sql + " from " + queryObj + " c " + qCon ;
		tquery= this.em.createQuery(sql);
		Object[] reso = (Object[]) tquery.getSingleResult();
		double[] res = new double[reso.length];
		try{
			for(int i= 0; i<reso.length; i++){
				res[i]= (double) reso[i];
			}
		}catch(Exception e){
			
		}
		return res;
	}
	
	public int getPageCount(){
		int pages=0;
		float pgs=0;
		pgs=((float)this.getResultCount()/(float)this.pageSize);
//		System.out.println("pgs:"+pgs+", rescount:"+ this.getResultCount()+",pagesize:"+this.pageSize);
		pages = (int) Math.ceil(pgs);
		return pages;
	}
	
	public List dogetPage(int pageno){
		String sql;
		List res=null;
		
		String qCon=genCon();
		
		try{
	
			sql = " select c from " + this.queryObj + 
			" c " + qCon +  
			" order by " + this.orderCol + "  " + this.orderDir;
	
			tquery= this.em.createQuery(sql);
			tquery.setMaxResults(this.pageSize);
			tquery.setFirstResult(this.pageSize*(pageno-1));
			res=tquery.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	private void filterParse(Map filters){
		List<String>  cond= new ArrayList<String>();
		if (userFilter != null) {
            for (Iterator<String> it = userFilter.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String[] filterNT=filterProperty.split(":");
                    String fieldName= filterNT[0];
                    String fieldType= filterNT[1].toLowerCase();
                    
                    SelectItem filterVO = (SelectItem) userFilter.get(filterProperty);
                    String filterValue= "";
                    if(fieldType.equals("date")){
                    	filterValue = Utils.formatDate((Date)filterVO.getValue(), "yyyy-MM-dd");
                    }else{
                    	filterValue = (String) filterVO.getValue();
                    }

                    String filterOP= filterVO.getLabel();
                    
                    switch(filterOP){
                    case ">":
                    case "<":
                    case ">=":
                    case "<=":
                    case "<>":
                    case "=":
                    	if(fieldType.equals("number")){
                    		//如果是对于年龄的比较，需要转换为对生日年的比较
                    		if(fieldName.equals("age")){
                    			String c="";
                    			fieldName="birthday";
                    			SimpleDateFormat df= new SimpleDateFormat();
                    			df.applyPattern("yyyy-MM-dd");
                    			Calendar cal=Calendar.getInstance();
                    			Calendar cal2= Calendar.getInstance();
                    			//求比较年
                    			cal.setTime(new Date());
                    			cal2.setTime(cal.getTime());
                    			
                    			int ageYear= cal.get(Calendar.YEAR)-Integer.parseInt(filterValue);
                    			cal2.set(Calendar.YEAR, ageYear-1);
                    			cal2.set(Calendar.HOUR_OF_DAY, 0);
                    			cal2.set(Calendar.MINUTE,0);
                    			cal2.set(Calendar.SECOND,0);
                    			cal.setTime(cal2.getTime());
                    			cal.set(Calendar.YEAR, ageYear);
                    			cal.setTimeInMillis(cal.getTimeInMillis()+24*3599000);
                    			cal2.setTimeInMillis(cal2.getTimeInMillis()+24*3600000);
                    			
//                    			cal.set(ageYear, 0, 1, 0, 0, 0);
                    			Date ageDate= cal.getTime();
//                    			cal.set(ageYear, 11,31,23,59,59);
                    			Date ageDateEnd=cal.getTime();
                    			
                    			ageDate=cal2.getTime();
                    			ageDateEnd=cal.getTime();
                    			
                    			df.applyPattern("yyyy-MM-dd HH:mm:ss");
                    			if(filterOP.equals(">")){
                    				c=fieldName+"<'"+ df.format(ageDate) + "'";
                    			}else if(filterOP.equals(">=")){
                    				c=fieldName+"<='"+ df.format(ageDateEnd) + "'";
                    			}else if(filterOP.equals("<")){
                    				c=fieldName+">'"+ df.format(ageDateEnd) + "'";
                    			}else if(filterOP.equals("<=")){
                    				c=fieldName+">='"+ df.format(ageDate) + "'";
                    			}else if(filterOP.equals("=")){
                    				c=fieldName+">='"+ df.format(ageDate) + "' and "+ fieldName+"<='"+ df.format(ageDateEnd) + "'";
                    			}
                    			cond.add(c);
                    		}else if(fieldName.equals("restAmount")){
                    			String c="(eduAmount + testAmount - payedAmount)" + filterOP +filterValue;
                    			cond.add(c);
                    		}else{
                    			cond.add( fieldName + filterOP + filterValue );
                    		}
                    		
                    	}else if(fieldType.equals("date")){
                    			String c="";
                    			SimpleDateFormat df= new SimpleDateFormat();
                    			df.applyPattern("yyyy-MM-dd");
                    			Calendar cal=Calendar.getInstance();
                    			//求比较日期, 并整理日期数据
                    			Date date1=df.parse(filterValue);
                    			Date date2=date1;
                    			cal.setTime(date1);
                    			cal.set(Calendar.HOUR_OF_DAY, 0);
                    			cal.set(Calendar.MINUTE, 0);
                    			cal.set(Calendar.SECOND, 0);
                    			date1=cal.getTime();
                    			cal.setTime(date2);
                    			cal.set(Calendar.HOUR_OF_DAY, 23);
                    			cal.set(Calendar.MINUTE, 59);
                    			cal.set(Calendar.SECOND, 59);
                    			date2=cal.getTime();
                    			
                    			df.applyPattern("yyyy-MM-dd HH:mm:ss");
                    			if(filterOP.equals(">")){
                    				c=fieldName+">'"+ df.format(date2) + "'";
                    			}else if(filterOP.equals(">=")){
                    				c=fieldName+">='"+ df.format(date1) + "'";
                    			}else if(filterOP.equals("<")){
                    				c=fieldName+"<'"+ df.format(date1) + "'";
                    			}else if(filterOP.equals("<=")){
                    				c=fieldName+"<='"+ df.format(date2) + "'";
                    			}else if(filterOP.equals("=")){
                    				c=fieldName+">='"+ df.format(date1) + "' and "+ fieldName+"<='"+ df.format(date2) + "'";
                    			}
                    			cond.add(c);
                    		}else{
                    			cond.add( fieldName + filterOP +"'"+ filterValue+"'" );
                    		}
                    	break;	
                    case "like":
                    	cond.add( fieldName +" like '%" +filterValue+"%' " );
                    	break;
                    case "beginwith":
                    	cond.add( fieldName +" like '" +filterValue+"%' " );
                    	break;
                    case "endwith":
                    	cond.add( fieldName +" like '%" +filterValue+"' " );
                    	break;
                    }
                } catch(Exception e) {
                	e.printStackTrace();
                }
            }
        }
		
		if (filters != null) {
            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    Object filterValue = filters.get(filterProperty);

                    cond.add( filterProperty +" like '%" +filterValue.toString()+"%' " );
                } catch(Exception e) {
                }
            }
        }
		Pager.this.condations=cond;
		
	}

	public List fetchPage(int pageNo){
		return this.getPage(pageNo);
	}
	
	public List getPage(int pageNo){
		this.setPageSize(this.pageSize);
		this.setQueryObj(this.queryObj);
		this.setOrderCol(this.orderCol);
		this.setOrderDir(this.orderDir);
		this.setCondations(this.condations);
		this.total_pages=this.getPageCount();
		
//		System.out.println("getPage: pageSize:"+ pageSize);
//		System.out.println("getPage: queryObj:"+ queryObj);
//		System.out.println("getPage: orderCol:"+ orderCol);
//		System.out.println("getPage: orderDir:"+ orderDir);
//		System.out.println("getPage: condations:"+ condations.toString());
//		System.out.println("getPage: total_pages:"+ total_pages);
//		System.out.println("getPage: pageNo:"+ pageNo);
		
		
		if(this.total_pages==0)
		{
			this.setCurpage(0);
		}else
		{
			this.setCurpage(pageNo);
		}
		return this.dogetPage(pageNo);
	}
	
	public Object getDataById(Object id){
		Object obj;
		String sql=" select c from "+  queryObj + " c where id=" +id.toString();
		return this.em.createQuery(sql).getSingleResult();
	}
	
	public List fetchNext(){
		int pageNo= curpage+1;
		return fetchPage(pageNo);
	}
	
	public List fetchPre(){
		int pageNo= curpage-1;
		return fetchPage(pageNo);
	}
	
	public List fetchFirst(){
		return fetchPage(1);
	}
	
	public List fetchLast(){
		int pageNo= this.total_pages;
		return fetchPage(pageNo);
	}
	
	public List reOrder(String col, String dir){
		this.orderCol=col;
		this.orderDir=dir;
		return fetchPage(1);
	}

	public String getIniOrderDir() {
		return iniOrderDir;
	}

	public void setIniOrderDir(String iniOrderDir) {
		this.iniOrderDir = iniOrderDir;
	}
}
