package gov.cygs.service;

import gov.cygs.dao.DBM;
import gov.cygs.ejb.RangeBean;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.Indivreg;
import gov.cygs.entities.MapPoint;
import gov.cygs.entities.MapSection;
import gov.cygs.entities.Order;
import gov.cygs.entities.Person;
import gov.cygs.entities.Personreg;
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

import java.awt.image.BufferedImage;
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

import com.utils.graph.NewImageUtils; 


@Stateless
@Dependent
public class IndivService {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;
	@EJB DBM dbm;
	@EJB RangeBean rangeBean;
	@EJB NumberPro numberPro;

	public IndivService() { 
		
	}
	
	public void updateRelate(String page, Indivreg creg){

		if(page.equals("creg")){
//			String caddr = creg.getCaddress();
//			String mark1 = creg.getMarkAddr1();
//			String distriction = creg.getPrefix();
//			
//			if(!caddr.trim().equals("")){
//				creg.setMarkAddr1(distriction+caddr);
//			}
			
//			String shname = creg.getShname();
//			String shmobile = creg.getShmobile();
//			String shidno = creg.getShidno();
//			String shemail = creg.getShemail();
			
//			if(creg.getAuthIdno().equals("") && !shidno.equals("")){
//				creg.setAuthName(shname);
//				creg.setAuthIdno(shidno);
//			}
//			if(creg.getAuthMobile().equals("") && !shmobile.equals("")){
//				creg.setAuthMobile(shmobile);
//			}
			
			if(creg.getLocal().equals("清和工商所")){
				creg.setSpecial("长春市工商行政管理局朝阳分局清和工商所");
				if(creg.getMapfile().indexOf("清和工商所")<0){
					creg.setMapfile("清和工商所_05");
					creg.setMapindex(5);
				}

			}
			if(creg.getLocal().equals("桂林工商所")){
				creg.setSpecial("长春市工商行政管理局朝阳分局桂林工商所");
				if(creg.getMapfile().indexOf("桂林工商所")<0){
					creg.setMapfile("桂林工商所_40");
					creg.setMapindex(40);
				}
			}
			
			MapPoint point = new MapPoint(300,280);
			
			MapPoint d1 = new MapPoint(200,50);
			MapPoint d2 = new MapPoint(100,300);
			MapPoint d3 = new MapPoint(300,500);
			MapPoint d4 = new MapPoint(300,250);
			
			
			MapSection s1 = new MapSection();
			s1.addPoint(d1);
			s1.addPoint(d2);
			s1.addPoint(d3);
			s1.addPoint(d4);
			
			
			
			System.out.println(s1.isInOrNot(point));
			
		}
	}

	public boolean checkRules(String page, Indivreg creg){
		boolean pass= true;
		String distriction = creg.getPrefix();
		
		if(distriction==null || distriction.equals("")){
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
			
			String cardNo = creg.getShidno();
			if(!IdCard.checkIdno(cardNo)){
				Utils.addMessage("错误", "投资人身份证号码格式错误");
				pass= false;
			}
		}

		if(page.equals("weituo") || page.equals("all")){
			String mobile = creg.getAuthMobile().trim();
			if(mobile.trim().equals("")){
				Utils.addMessage("错误", "移动电话必须输入");
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
			boolean opt = creg.isAuthOpt1() || creg.isAuthOpt2() || creg.isAuthOpt3() || creg.isAuthOpt4();
			if(!opt){
				Utils.addMessage("错误", "至少同意一项办理事务");
				pass= false;
			}
		}

		if(page.equals("zhusuo") || page.equals("all")){
			String maddr1= creg.getMarkAddr1().trim();
			if(!maddr1.equals("") && maddr1.indexOf(distriction)!=0){
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

	public String commit(Indivreg creg){
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
		generateMap(creg);
		updateCreg(creg,"已受理");
		return "";
	}
	
	public void generateMap(Indivreg creg){
		String localMap = creg.getLocal()+".jpg";
		String sourceFilePath = Utils.getPath()+"images"+ File.separator + localMap;
		String waterFilePath = Utils.getPath()+ "images"+ File.separator +"pos.png";
		String saveFilePath = Utils.getPath()+ "userspace" + File.separator + creg.getUuid()+ ".png";
		
		NewImageUtils newImageUtils = new NewImageUtils();
		// 对图像加水印
		BufferedImage buffImg = NewImageUtils.watermark(new File(sourceFilePath), new File(waterFilePath),creg.getMapx(),creg.getMapy(), 1.0f);
		// 输出水印图片
		newImageUtils.generateWaterFile(buffImg, saveFilePath);		
	}
	
	public boolean saveCreg(Indivreg creg,String state){
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
	
	public boolean updateCreg(Indivreg creg,String state){
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
					Utils.sendSMS(phone,"【长春市工商局】温馨提示:尊敬的登记申请人，您的开业登记申请，我局已有回复，请您上网查询回复意见");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public static Map<String,String> getTemplateMaps(String template, Indivreg creg){
		 Map<String,String> templateMaps = new HashMap<String,String>();
		 String distriction = creg.getPrefix();
		 
		if (template.equals("creg")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("caddress", creg.getFieldValue("caddress"));
			templateMaps.put("capital", creg.getFieldValue("capital"));
			templateMaps.put("cmodea", creg.getFieldValue("cmodea"));
			templateMaps.put("cmodeb", creg.getFieldValue("cmodeb"));
			templateMaps.put("crange", creg.getFieldValue("crange"));
			templateMaps.put("family", creg.getFieldValue("family"));
			templateMaps.put("empnum", creg.getFieldValue("empnum"));
			templateMaps.put("shname", creg.getFieldValue("shname"));
			templateMaps.put("shgender", creg.getFieldValue("shgender"));
			templateMaps.put("shnat", creg.getFieldValue("shnat"));
			templateMaps.put("shemail", creg.getFieldValue("shemail"));
			templateMaps.put("shlevel", creg.getFieldValue("shlevel"));
			templateMaps.put("shpolitical", creg.getFieldValue("shpolitical"));
			templateMaps.put("shmobile", creg.getFieldValue("shmobile"));
			templateMaps.put("shidno", creg.getFieldValue("shidno"));
			templateMaps.put("shaddr", creg.getFieldValue("shaddr"));
			templateMaps.put("shzip", creg.getFieldValue("shzip"));
			templateMaps.put("shcarr", creg.getFieldValue("shcarr"));
		}

		if (template.equals("weituo")){
			templateMaps.put("shname", creg.getShname());
			templateMaps.put("authName", creg.getFieldValue("authDname"));
			templateMaps.put("authAddress", creg.getFieldValue("authAddress"));
			templateMaps.put("authZip", creg.getFieldValue("authZip"));
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("authOpt1", creg.getFieldValue("authOpt1"));
			templateMaps.put("authOpt1b", creg.getFieldValue("authOpt1b"));
			templateMaps.put("authOpt2", creg.getFieldValue("authOpt2"));
			templateMaps.put("authOpt2b", creg.getFieldValue("authOpt2b"));
			templateMaps.put("authOpt3", creg.getFieldValue("authOpt3"));
			templateMaps.put("authOpt3b", creg.getFieldValue("authOpt3b"));
			templateMaps.put("authOpt4", creg.getFieldValue("authOpt4"));
			templateMaps.put("authOpt4b", creg.getFieldValue("authOpt4b"));
			templateMaps.put("authDateb", creg.getFieldValue("authDateb"));
			templateMaps.put("authDatee", creg.getFieldValue("authDatee"));
			templateMaps.put("authMobile", creg.getFieldValue("authMobile"));
			templateMaps.put("authDate", creg.getFieldValue("authDate"));
		}
		
		if (template.equals("zhusuo")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("haddress", creg.getFieldValue("shaddr"));
			if(!creg.getFieldValue("markAddr1").trim().equals("")){
				templateMaps.put("markAddr1", creg.getFieldValue("markAddr1"));
			}else{
				templateMaps.put("markAddr1", "");
			}
			templateMaps.put("markAddr2", "");
			templateMaps.put("markAddr3", "");
		}
		
		if (template.equals("position")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("caddress", creg.getFieldValue("caddress"));
			templateMaps.put("crange", creg.getFieldValue("crange"));
			String posMap = Utils.getPath()+ "userspace" + File.separator + creg.getUuid()+ ".png";; 
			String imageStr = NewImageUtils.getImageStr(posMap);
			templateMaps.put("posmap", imageStr);
		}

		return templateMaps;
	}
	
	@SuppressWarnings("deprecation")
	public boolean generate(Indivreg creg, boolean preview){
		//读取并设置预约的日期
		Date now = new Date();
		long time = now.getTime();
		
		try{
			String userDir= Utils.getPath()+ "userspace" + File.separator + Utils.getCurrentUser().getLoginId()+File.separator 
					+ creg.getCname()+""+File.separator  ;
			Utils.createDirectory(userDir);
			DocUtil docu= new DocUtil();
			
			String outputFile = "";

			Map<String, String> dataMap = null;
			outputFile = userDir + "个体工商户开业登记申请书.doc";
			dataMap = IndivService.getTemplateMaps("creg", creg);
			docu.createDoc(dataMap, "indivreg.xml", outputFile);
			MyThread myThread = new MyThread();
			if(!preview){
				myThread.doWork(userDir, "个体工商户开业登记申请书");
				//docu.wordToPDF(userDir, "个人独资企业登记（备案）申请书");
				//docu.waterMark(userDir, "个人独资企业登记（备案）申请书");
			}
			
			outputFile = userDir + "吉林省市场主体住所（经营场所）登记表.doc";
			dataMap = IndivService.getTemplateMaps("zhusuo", creg);
			docu.createDoc(dataMap, "zhusuo.xml", outputFile);
			if(!preview){
				myThread = new MyThread();
				myThread.doWork(userDir, "吉林省市场主体住所（经营场所）登记表");
	//			docu.wordToPDF(userDir, "吉林省市场主体住所（经营场所）登记表");
	//			docu.waterMark(userDir, "吉林省市场主体住所（经营场所）登记表");
			}
			
			outputFile = userDir + "委托代理人证明.doc";
			dataMap = IndivService.getTemplateMaps("weituo", creg);
			docu.createDoc(dataMap, "weituo2.xml", outputFile);
			if(!preview){
				myThread = new MyThread();
				myThread.doWork(userDir, "委托代理人证明");
	//			docu.wordToPDF(userDir, "指定代表或共同委托代理人授权委托书");
	//			docu.waterMark(userDir, "指定代表或共同委托代理人授权委托书");
			}
			
			outputFile = userDir + "经营场所位置图.doc";
			dataMap = IndivService.getTemplateMaps("position", creg);
			docu.createDoc(dataMap, "position.xml", outputFile);
			if(!preview){
				myThread = new MyThread();
				myThread.doWork(userDir, "经营场所位置图");
	//			docu.wordToPDF(userDir, "吉林省市场主体住所（经营场所）登记表");
	//			docu.waterMark(userDir, "吉林省市场主体住所（经营场所）登记表");
			}
			
			String outFile= Utils.getPath()+ "userspace" + File.separator + Utils.getCurrentUser().getLoginId()+File.separator + creg.getCname()+".zip" ;
			Utils.compress(userDir, outFile);
			
			if(!preview){
				creg.setCapprove("已生成");
				creg.setUpdtime(now);
				creg.setCno("");
				dbm.UpdateObj(creg);
			}else{
				creg.setCno("preview");
				creg.setUpdtime(now);
				dbm.UpdateObj(creg);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
