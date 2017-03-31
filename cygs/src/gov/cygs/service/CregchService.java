package gov.cygs.service;

import gov.cygs.dao.DBM;
import gov.cygs.ejb.RangeBean;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.Order;
import gov.cygs.entities.Person;
import gov.cygs.entities.Precondition;
import gov.cygs.entities.Range;
import gov.cygs.entities.Shareholder;
import gov.cygs.entities.SysUser;
import gov.cygs.entities.TemplateMap;
import gov.cygs.entities.Upfile;
import gov.cygs.entities.Yuyue;
import gov.cygs.exception.PersistenceException;
import gov.cygs.utils.DocUtil;
import gov.cygs.utils.IdCard;
import gov.cygs.utils.NumberPro;
import gov.cygs.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query; 


@Stateless
@Dependent
public class CregchService {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;
	@EJB DBM dbm;
	@EJB RangeBean rangeBean;
	@EJB NumberPro numberPro;

	public CregchService() { 
		
	}
	
	public void updateRelate(String page, Companychg creg){
		if(page.equals("creg")){
			creg.setPrefix(creg.getPrefix0());
			String caddr = creg.getCaddress();

			if(!caddr.equals("")){
				creg.setMarkAddr1(creg.getPrefix()+caddr);
			}
		}

		if(page.equals("biangeng")){
			String caddr = creg.getCaddressnew();

			if(!caddr.equals("")){
				creg.setMarkAddr1(creg.getPrefix()+caddr);
			}
		}
	}

	public boolean checkRules(String page, Companychg creg){
		boolean pass= true;
		String distriction = creg.getPrefix0();
		if(distriction==null ||  distriction.equals("")){
			Utils.addMessage("错误", "未在地址处选择行政区划");
			return false;
		}		
		
		//检查人员身份证号、电话号的重复情况
		List<Person>persons = Utils.getPersons(creg, true);
		String dupNames[] = Utils.findDupPersons(persons);
		if(!dupNames[0].equals("")){
			Utils.addMessage("错误", dupNames[0]+"证件号相同");
			pass= false;
		}
		if(!dupNames[1].equals("")){
			Utils.addMessage("错误", dupNames[0]+"电话号相同");
			pass= false;
		}
		
		if(page.equals("creg") || page.equals("all")){
			if(creg.getCnamenotype().equals("注册号")){
				if(creg.getCnameno().trim().length()!=15){
					Utils.addMessage("错误", "注册号应为15位");
					pass= false;
				}
			}
			if(creg.getCnamenotype().equals("统一社会信用代码")){
				if(creg.getCnameno().trim().length()!=18){
					Utils.addMessage("错误", "统一社会信用代码应为18位");
					pass= false;
				}
			}
		}
		
		if(page.equals("biangeng") || page.equals("all")){
			boolean update = false;
			if(!creg.getCnamenew().trim().equals("")){
				update = true;
			}
			if(!creg.getCaddressnew().trim().equals("")){
				update = true;
			}
			if(!creg.getCrangenew().trim().equals("")){
				update = true;
			}
			if(creg.getCyearslongnew().trim().equals("长期")|| creg.getCyearsnew()>0){
				update = true;
			}
			if(!update){
				Utils.addMessage("错误", "未填写任何变更事项");
				pass = false;
			}
		}

		if(page.equals("lianluo") || page.equals("all") ){
			String tel = creg.getLlyTele().trim();
			String mobile = creg.getLlyMobile().trim();
			if(!creg.getLlyName().trim().equals("")){
				if(tel.equals("") && mobile.equals("")){
					Utils.addMessage("错误", "联络人固定电话或移动电话至少输入一项");
					pass= false;
				}
				if(creg.getLlyIdtype().equals("身份证")){
					String cardNo = creg.getLlyIdno();
					if(!IdCard.checkIdno(cardNo)){
						Utils.addMessage("错误", "联络员身份证号码格式错误");
						pass= false;
					}
					if(IdCard.getAge(cardNo)<18){
						Utils.addMessage("错误", "联络员年龄不能小于18岁");
						pass= false;
					}
				}
			}
		}
		
		if(page.equals("weituo") || page.equals("all")){
			String tel = creg.getAuthTele().trim();
			String mobile = creg.getAuthMobile().trim();
			if(tel.equals("") && mobile.equals("")){
				Utils.addMessage("错误", "固定电话或移动电话至少输入一项");
				pass= false;
			}
			Date date1= creg.getAuthDate();
			Date dateb= creg.getAuthDateb();
			Date datee= creg.getAuthDatee();
			
			if(dateb.before(date1)){
				Utils.addMessage("错误", "委托有效期的开始日期应该在授权日之后");
				pass= false;
			}
			Date dateb_30 = new Date(dateb.getTime()+(long)24*3600000*30);
			
			if(datee.before(dateb_30)){
				Utils.addMessage("错误", "委托有效期的结束日期应该在开始日期30日之后");
				pass= false;
			}
			boolean opt = creg.getAuthOpt13() || creg.getAuthOpt14() || creg.getAuthOpt15() || creg.getAuthOpt16();
			if(!opt){
				Utils.addMessage("错误", "至少同意一项办理事务");
				pass= false;
			}
			if(creg.getAuthOpt12()&&creg.getAuthOptblank().trim().equals("") ){
				Utils.addMessage("错误", "如果选择了其他，则应输入具体手续内容");
				pass= false;
			}
			if(!creg.getAuthOpt12()&&!creg.getAuthOptblank().trim().equals("") ){
				Utils.addMessage("错误", "选择了其他，才可以输入具体手续内容");
				pass= false;
			}
			if(creg.getAuthIdtype().equals("身份证")){
				String cardNo = creg.getAuthIdno();
				if(!IdCard.checkIdno(cardNo)){
					Utils.addMessage("错误", "委托人身份证号码格式错误");
					pass= false;
				}
				if(IdCard.getAge(cardNo)<18){
					Utils.addMessage("错误", "委托人年龄不能小于18岁");
					pass= false;
				}
			}
		}

		if(page.equals("zhusuo") || page.equals("all")){
			distriction = creg.getPrefix();
			String maddr1= creg.getMarkAddr1().trim();
			String maddr2= creg.getMarkAddr2().trim();
			String maddr3= creg.getMarkAddr3().trim();
			if(!maddr1.equals("") && maddr1.indexOf(distriction)!=0){
				Utils.addMessage("错误", "地址必须以"+distriction+"开头");
				pass= false;
			}
			if(!maddr2.equals("") && maddr2.indexOf(distriction)!=0){
				Utils.addMessage("错误", "地址必须以"+distriction+"开头");
				pass= false;
			}
			if(!maddr3.equals("") && maddr3.indexOf(distriction)!=0){
				Utils.addMessage("错误", "地址必须以"+distriction+"开头");
				pass= false;
			}
		}
		
		if(page.equals("tips") || page.equals("all")){
			if(creg.getSpecial().equals("请选择")){
				Utils.addMessage("错误", "必须选择办理机关");
				pass= false;
			}
		}
				
		return pass;
	}

	public String commit(Companychg creg){
		if(!checkRules("all",creg)){
			return "";
		}
		//若未分配管理员，或者更换了分局，则查找管理员，并分配
		
		boolean changeLocal=false;
		if(!creg.getTransport().equals("inner")){
			SysUser manager = (SysUser) dbm.getObjectByFldValue("SysUser", "loginId", creg.getTransport());
			String local = creg.getSpecial();
			if(!local.equals(manager.getDistriction())){
				changeLocal=true;
			}
		}
		
		if(changeLocal || creg.getJingshou().trim().equals("")){
			String local = creg.getSpecial();
			SysUser manager = dbm.getManager(local);
			creg.setJingshou(manager.getDisplayName());	
			creg.setTransport(manager.getLoginId());
		}
		updateCreg(creg,"已受理");
		return "";
	}
	
	public boolean saveCreg(Companychg creg,String state){
		//读取并设置预约的日期
		Date now = new Date();
		long time = now.getTime();
		
		try{
			creg.setCapprove(state);
			creg.setUpdtime(now);
			creg.reFormat();
			creg.setCno("");
			dbm.SaveObj(creg);
		}catch(Exception e){
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateCreg(Companychg creg,String state){
		//读取并设置预约的日期
		Date now = new Date();
		long time = now.getTime();
		
		try{
			creg.setCapprove(state);
			creg.setUpdtime(now);
			creg.reFormat();
			creg.setCno("");
			dbm.UpdateObj(creg);
			
			if(Utils.getCurrentUser().getRole().equals("管理员")){
				String phone = "";
				if(state.equals("已退回")||state.equals("预审通过")) {
					phone = creg.getAuthMobile();
				}
				
				if(!phone.trim().equals("")){
					Utils.sendSMS(phone,"【长春市工商局】温馨提示:尊敬的企业登记申请人，您的公司变更登记申请，我局已有回复，请您上网查询回复意见");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public static Map<String,String> getTemplateMaps(String template, Companychg creg){
		 Map<String,String> templateMaps = new HashMap<String,String>();
		if (template.equals("creg")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("cnameno", creg.getFieldValue("cnameno"));
			templateMaps.put("orgno1", creg.getFieldValue("orgno1"));
			templateMaps.put("orgno2", creg.getFieldValue("orgno2"));
			templateMaps.put("orgno3", creg.getFieldValue("orgno3"));
			templateMaps.put("haddress", creg.getFieldValue("haddress"));
			templateMaps.put("caddress", creg.getFieldValue("caddress"));
			templateMaps.put("ctelephone", creg.getFieldValue("ctelephone"));
			templateMaps.put("czip", creg.getFieldValue("czip"));
			templateMaps.put("changes", creg.getFieldValue("changes"));
		}

		if(template.equals("zhangcheng")){
			templateMaps.put("zhangcheng", creg.getFieldValue("zhangcheng"));
			templateMaps.put("cname", creg.getFieldValue("cname"));
		}
		
		if(template.equals("gudong")){
			templateMaps.put("changeitems", creg.getFieldValue("changeitems"));
			templateMaps.put("cname", creg.getFieldValue("cname"));
		}
		
		if(template.equals("announcement")){
			templateMaps.put("orgno1chk", creg.getFieldValue("orgno1chk"));
			templateMaps.put("orgno1stk", creg.getFieldValue("orgno1stk"));
			templateMaps.put("orgno2chk", creg.getFieldValue("orgno2chk"));
			templateMaps.put("orgno2stk", creg.getFieldValue("orgno2stk"));
			templateMaps.put("orgno3chk", creg.getFieldValue("orgno3chk"));
			templateMaps.put("orgno3stk", creg.getFieldValue("orgno3stk"));
		}

		if (template.equals("lianluo")){
			templateMaps.put("llyName", creg.getFieldValue("llyName"));
			templateMaps.put("llyTele", creg.getFieldValue("llyTele"));
			templateMaps.put("llyMobile", creg.getFieldValue("llyMobile"));
			templateMaps.put("llyMail", creg.getFieldValue("llyMail"));
			templateMaps.put("llyIdtype", creg.getFieldValue("llyIdtype"));
			templateMaps.put("llyIdno", creg.getFieldValue("llyIdno"));
		}
		
		if (template.equals("weituo")){
			//templateMaps.put("shareNames", creg.getFieldValue("shareNames"));
			templateMaps.put("shareNames", creg.getCname());
			templateMaps.put("authDname", creg.getFieldValue("authDname"));
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("authOpt2", creg.getFieldValue("authOpt2"));
			templateMaps.put("authOpt3", creg.getFieldValue("authOpt3"));			
			templateMaps.put("authOpt13", creg.getFieldValue("authOpt13"));
			templateMaps.put("authOpt13b", creg.getFieldValue("authOpt13b"));
			templateMaps.put("authOpt14", creg.getFieldValue("authOpt14"));
			templateMaps.put("authOpt14b", creg.getFieldValue("authOpt14b"));
			templateMaps.put("authOpt15", creg.getFieldValue("authOpt15"));
			templateMaps.put("authOpt15b", creg.getFieldValue("authOpt15b"));
			templateMaps.put("authOpt16", creg.getFieldValue("authOpt16"));
			templateMaps.put("authOpt16b", creg.getFieldValue("authOpt16b"));
			templateMaps.put("authDateb", creg.getFieldValue("authDateb"));
			templateMaps.put("authDatee", creg.getFieldValue("authDatee"));
			templateMaps.put("authTele", creg.getFieldValue("authTele"));
			templateMaps.put("authMobile", creg.getFieldValue("authMobile"));
			templateMaps.put("authDate", creg.getFieldValue("authDate"));
		}
		
		if (template.equals("zhusuo")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("haddress", creg.getFieldValue("haddress"));
			String caddressnew = creg.getCaddressnew();
			if(caddressnew.equals("")){
				templateMaps.put("haddress", creg.getCaddressnew());
				templateMaps.put("markAddr1", creg.getCaddressnew());
			}else{
				if(!creg.getFieldValue("markAddr1").trim().equals("")){
					templateMaps.put("haddress", creg.getFieldValue("markAddr1"));
					templateMaps.put("markAddr1", creg.getFieldValue("markAddr1"));
				}else{
					templateMaps.put("markAddr1", "");
				}
			}
			if(!creg.getFieldValue("markAddr2").trim().equals("")){
				templateMaps.put("markAddr2", creg.getFieldValue("markAddr2"));
			}else{
				templateMaps.put("markAddr2", "");
			}
			if(!creg.getFieldValue("markAddr3").trim().equals("")){
				templateMaps.put("markAddr3", creg.getFieldValue("markAddr3"));
			}else{
				templateMaps.put("markAddr3", "");
			}
		}
		return templateMaps;
	}
	
	@SuppressWarnings("deprecation")
	public boolean generate(Companychg creg,boolean preview){
		//读取并设置预约的日期
		Date now = new Date();
		long time = now.getTime();
		String ctype = creg.getCtypeSub();
		
		try{
			String userDir= Utils.getPath()+ "userspace" + File.separator + Utils.getCurrentUser().getLoginId()+File.separator 
					+ creg.getCname()+"_变更"+File.separator  ;
			Utils.delDirectory(userDir);
			Utils.createDirectory(userDir);
			DocUtil docu= new DocUtil();
			
			String outputFile = "";

			Map<String, String> dataMap = null;
			outputFile = userDir + "公司登记（备案）申请书.doc";
			dataMap = CregchService.getTemplateMaps("creg", creg);
			docu.createDoc(dataMap, "cregch.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "公司登记（备案）申请书");
				docu.waterMark(userDir, "公司登记（备案）申请书");
			}
			
			if(!creg.getLlyName().trim().equals("")){
				outputFile = userDir + "联络员.doc";
				dataMap = CregchService.getTemplateMaps("lianluo", creg);
				docu.createDoc(dataMap, "lianluo.xml", outputFile);
				if(!preview){
					docu.wordToPDF(userDir, "联络员");
					docu.waterMark(userDir, "联络员");
				}
			}
			if(creg.getCnamenotype().equals("注册号")){
				if(creg.getOrgno1().trim().equals("") || creg.getOrgno2().trim().equals("") || creg.getOrgno3().trim().equals("") ){
					//只要选择了注册号，有一项未填写，即生成《企业声明》
					outputFile = userDir + "企业声明.doc";
					dataMap = CregchService.getTemplateMaps("announcement", creg);
					docu.createDoc(dataMap, "announcement.xml", outputFile);
					if(!preview){
						docu.wordToPDF(userDir, "企业声明");
						docu.waterMark(userDir, "企业声明");
					}
				}
			}
			
			if(!creg.getCaddressnew().trim().equals("")){
				outputFile = userDir + "吉林省市场主体住所（经营场所）登记表.doc";
				dataMap = CregchService.getTemplateMaps("zhusuo", creg);
				docu.createDoc(dataMap, "zhusuo.xml", outputFile);
				if(!preview){
					docu.wordToPDF(userDir, "吉林省市场主体住所（经营场所）登记表");
					docu.waterMark(userDir, "吉林省市场主体住所（经营场所）登记表");
				}
			}
				
			outputFile = userDir + "指定代表或共同委托代理人授权委托书.doc";
			dataMap = CregchService.getTemplateMaps("weituo", creg);
			docu.createDoc(dataMap, "weituo.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "指定代表或共同委托代理人授权委托书");
				docu.waterMark(userDir, "指定代表或共同委托代理人授权委托书");
			}
			
			outputFile = userDir + "股东会决议.doc";
			dataMap = CregchService.getTemplateMaps("gudong", creg);
			docu.createDoc(dataMap, "股东会决议.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "股东会决议");
				docu.waterMark(userDir, "股东会决议");
			}
			
			outputFile = userDir + "章程修正案.doc";
			dataMap = CregchService.getTemplateMaps("zhangcheng", creg);
			docu.createDoc(dataMap, "章程修正案.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "章程修正案");
				docu.waterMark(userDir, "章程修正案");
			}
			
			String outFile= Utils.getPath()+ "userspace" + File.separator + Utils.getCurrentUser().getLoginId()+File.separator + creg.getCname()+"_变更.zip" ;
			Utils.compress(userDir, outFile);
			if(!preview){
				creg.setCapprove("已生成");
				creg.setUpdtime(now);
				creg.setCno("");
				dbm.UpdateObj(creg);
			}else{
				creg.setCno("preview");
				dbm.UpdateObj(creg);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
