package gov.cygs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import gov.cygs.dao.DBM;
import gov.cygs.entities.Numberlib;

@Stateless
@Dependent
public class NumberPro {

	@EJB
	DBM dbm;
	
	public NumberPro() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNumber(String type){
		String sql="select n from Numberlib n where n.ntype='" + type + "' " ;
		String prefix="";
		Date numberDate=null;
		int numWidth=0;
		int seq=0;
		int nodate=0;
		String num="";
		
		Numberlib numberlib=new Numberlib();
		try{
			EntityManager em=dbm.getEntityManager();

			//取得数据库中的编号信息
			Query tq= em.createQuery(sql);
			numberlib=(Numberlib) tq.getSingleResult();
			prefix=numberlib.getPrefix().trim();
			numberDate=numberlib.getNdate();
			seq=numberlib.getSeq();
			Date today= new Date();
			numWidth=numberlib.getWidth();
			nodate=numberlib.getNodate();
			
			if(nodate==0){
				//将数据库中的编号日期信息转换为yyyyMMdd的字条串格式，并与当前日期进行对比
				SimpleDateFormat df=new SimpleDateFormat();
				df.applyPattern("yyyyMMdd");
				int dateInt=Integer.parseInt(df.format(numberDate));
				int todayInt=Integer.parseInt(df.format(today));
				//如果小于当前日期，则重新从1开始计数
				//否则的话，就将该序号递增
				if(dateInt<todayInt){
					seq=1;
				}else{
					seq=seq+1;
				}
				//检查序号是否超长，如超长则说明溢出，抛出异常
				String seqStr= String.valueOf(seq);
				if ( seqStr.length()>numWidth ){
				}
				//按照长度要求拼装序号字符串
				String zero="000000000000000000000000000";
				df.applyPattern("yyyyMMdd");
				num=prefix+df.format(today)+zero.substring(0, (numWidth-seqStr.length()) )+seqStr;
				//设置数据库中的信息
				numberlib.setSeq(seq);
				numberlib.setNdate(today);
				numberlib.setNumberStr(num);
				dbm.SaveObj(numberlib);
			}else{
				//将该序号递增
				seq=seq+1;
				//检查序号是否超长，如超长则说明溢出，抛出异常
				String seqStr= String.valueOf(seq);
				if ( seqStr.length()>numWidth ){
				}
				//按照长度要求拼装序号字符串
				String zero="000000000000000000000000000";
				num="";
				num=prefix+zero.substring(0, (numWidth-seqStr.length()))+seqStr;
				//设置数据库中的信息
				numberlib.setSeq(seq);
				numberlib.setNdate(today);
				numberlib.setNumberStr(num);
				dbm.UpdateObj(numberlib);
			}
		}catch(Exception e){
			return "";
		}
			return num;
			
	}
	
	
	public String getNumber(String type, Date day){
		String sql="select n from Numberlib n where n.ntype=? and n.ndate=? " ;
		String prefix="";
		Date numberDate=null;
		int numWidth=0;
		int seq=0;
		int nodate=0;
		String num="";
		day = Utils.getday(day);
		
		Numberlib numberlib=new Numberlib();
		try{
			EntityManager em=dbm.getEntityManager();

			//取得数据库中的编号信息
			Query tq= em.createQuery(sql);
			tq.setParameter(1, type);
			tq.setParameter(2, day);
			List<Numberlib> numberlibs = (List<Numberlib>) tq.getResultList();
			if(numberlibs.isEmpty()){
				numberlib.setNdate(day);
				numberlib.setNodate(0);
				numberlib.setNtype(type);
				numberlib.setNumberStr("");
				numberlib.setPrefix("");
				numberlib.setSeq(0);
				numberlib.setWidth(5);
			}else{
				numberlib= numberlibs.get(0);
			}
			prefix=numberlib.getPrefix().trim();
			numberDate=numberlib.getNdate();
			seq=numberlib.getSeq();
//			Date today= new Date();
			Date today= day;
			numWidth=numberlib.getWidth();
			nodate=numberlib.getNodate();
			
			if(nodate==0){
				//将数据库中的编号日期信息转换为yyyyMMdd的字条串格式，并与当前日期进行对比
				SimpleDateFormat df=new SimpleDateFormat();
				df.applyPattern("yyyyMMdd");
				int dateInt=Integer.parseInt(df.format(numberDate));
				int todayInt=Integer.parseInt(df.format(today));
				//如果小于当前日期，则重新开始计数
				//否则的话，就将该序号递增
				if(dateInt<todayInt){
					seq=1;
				}else{
					seq=seq+1;
				}
				//检查序号是否超长，如超长则说明溢出，抛出异常
				String seqStr= String.valueOf(seq);
				if ( seqStr.length()>numWidth ){
				}
				//按照长度要求拼装序号字符串
				String zero="000000000000000000000000000";
				df.applyPattern("yyyyMMdd");
				num=prefix+df.format(today)+zero.substring(0, (numWidth-seqStr.length()) )+seqStr;
				//设置数据库中的信息
				numberlib.setSeq(seq);
				numberlib.setNdate(today);
				numberlib.setNumberStr(num);
				dbm.SaveObj(numberlib);
			}else{
				//将该序号递增
				seq=seq+1;
				//检查序号是否超长，如超长则说明溢出，抛出异常
				String seqStr= String.valueOf(seq);
				if ( seqStr.length()>numWidth ){
				}
				//按照长度要求拼装序号字符串
				String zero="000000000000000000000000000";
				num="";
				num=prefix+zero.substring(0, (numWidth-seqStr.length()))+seqStr;
				//设置数据库中的信息
				numberlib.setSeq(seq);
				numberlib.setNdate(today);
				numberlib.setNumberStr(num);
				dbm.SaveObj(numberlib);
			}
		}catch(Exception e){
			return "";
		}
			return num;
			
	}
	
	public String getDocNumber(String type){
		String sql="select n from Numberlib n where n.ntype=?" ;
		String prefix="";
		Date numberDate=null;
		int numWidth=0;
		int seq=0;
		String num="";
		
		Numberlib numberlib=new Numberlib();
		try{
			EntityManager em=dbm.getEntityManager();

			//取得数据库中的编号信息
			Query tq= em.createQuery(sql);
			tq.setParameter(1, type);
			List<Numberlib> numberlibs = (List<Numberlib>) tq.getResultList();
			numberlib= numberlibs.get(0);
			
			prefix=numberlib.getPrefix().trim();
			numberDate=numberlib.getNdate();
			seq=numberlib.getSeq();
			Date today= new Date();
			if(Utils.getYear(today)!= Utils.getYear(numberDate)){
				seq= 0;
				numberlib.setNdate(today);
			}

			numWidth=numberlib.getWidth();
			
			//将该序号递增
			seq=seq+1;
			//检查序号是否超长，如超长则说明溢出，抛出异常
			String seqStr= String.valueOf(seq);
			if ( seqStr.length()>numWidth ){
			}
			//按照长度要求拼装序号字符串
			String zero="000000000000000000000000000";
			num="";
			num=prefix+zero.substring(0, (numWidth-seqStr.length()))+seqStr;
			//设置数据库中的信息
			numberlib.setSeq(seq);
			numberlib.setNumberStr(num);
			dbm.UpdateObj(numberlib);

		}catch(Exception e){
			return "";
		}
			return num;
	}

}
