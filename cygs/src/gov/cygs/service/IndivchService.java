package gov.cygs.service;

import gov.cygs.dao.DBM;
import gov.cygs.ejb.RangeBean;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.Indivchg;
import gov.cygs.entities.Indivreg;
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
public class IndivchService {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;
	@EJB DBM dbm;
	@EJB NumberPro numberPro;

	public IndivchService() { 
		
	}
	
	public void updateRelate(String page, Indivchg creg){
		if(page.equals("creg")){
			String caddr = creg.getCaddressnew();

			if(!caddr.equals("")){
				creg.setMarkAddr1(creg.getPrefixnew()+caddr);
			}
		}
	}

	public boolean checkRules(String page, Indivchg creg){
		boolean pass= true;
		String distriction = creg.getPrefix();
		if(distriction==null ||  distriction.equals("")){
			Utils.addMessage("错误", "未在地址处选择行政区划");
			return false;
		}		
		
		//检查人员身份证号、电话号的重复情况
		if(page.equals("creg") || page.equals("all")){
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
			if(!creg.getCmodenew().trim().equals("")){
				update = true;
			}
			
			if(!update){
				Utils.addMessage("错误", "未填写任何变更事项");
				pass = false;
			}
			
			String cmode = creg.getCmode();
			String cmodenew= creg.getCmodenew();
			String family = creg.getFamily().trim();
			String familynew = creg.getFamilynew().trim();
			
			if(cmode.equals("家庭经营") && family.equals("")){
				Utils.addMessage("错误", "家庭经营需要填写家庭成员姓名及身份证号码");
				pass = false;
				
			}
			if(cmodenew.equals("家庭经营") && familynew.trim().equals("")){
				Utils.addMessage("错误", "家庭经营需要填写家庭成员姓名及身份证号码");
				pass = false;
			}
			
			if(cmode.equals(cmodenew) && family.equals(familynew) && !cmodenew.equals("")){
				Utils.addMessage("错误", "组成形式变更前后不应一致");
				pass = false;
			}
			
			if(creg.getCrange().equals(creg.getCrangenew()) && !creg.getCrange().trim().equals("") ){
				Utils.addMessage("错误", "经营范围变更前后不应一致");
				pass = false;
			}
			
			if(creg.getCaddress().equals(creg.getCaddressnew()) && !creg.getCaddress().trim().equals("") ){
				Utils.addMessage("错误", "经营场所变更前后不应一致");
				pass = false;
			}
		}

		if(page.equals("weituo") || page.equals("all")){
			String mobile = creg.getAuthMobile().trim();
			if(mobile.equals("")){
				Utils.addMessage("错误", "移动电话不能为空");
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

		if((page.equals("zhusuo") || page.equals("all")) && !creg.getCaddressnew().equals("")){
			distriction = creg.getPrefix();
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

	public String commit(Indivchg creg){
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
		
		//如果更改了地址，需要输入定位，并生成地图
		if(!creg.getCaddressnew().trim().equals("")){
			generateMap(creg);
		}
		updateCreg(creg,"已受理");
		return "";
	}
	
	public boolean saveCreg(Indivchg creg,String state){
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
	
	public boolean updateCreg(Indivchg creg,String state){
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
					Utils.sendSMS(phone,"【长春市工商局】温馨提示:尊敬的登记申请人，您的个体工商户变更登记申请，我局已有回复，请您上网查询回复意见");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Map<String,String> getTemplateMaps(String template, Indivchg creg){
		 Map<String,String> templateMaps = new HashMap<String,String>();
		if (template.equals("creg")){
			templateMaps.put("cname", creg.getFieldValue("cname"));
			templateMaps.put("cnamenew", creg.getFieldValue("cnamenew"));
			templateMaps.put("cerno", creg.getFieldValue("cerno"));
			templateMaps.put("cnameno", creg.getFieldValue("cnameno"));
			templateMaps.put("caddress", creg.getFieldValue("caddress"));
			templateMaps.put("caddressnew", creg.getFieldValue("caddressnew"));
			templateMaps.put("cmodea", creg.getFieldValue("cmodea"));
			templateMaps.put("cmodeb", creg.getFieldValue("cmodeb"));
			templateMaps.put("cmodenewa", creg.getFieldValue("cmodenewa"));
			templateMaps.put("cmodenewb", creg.getFieldValue("cmodenewb"));
			templateMaps.put("crange", creg.getFieldValue("crange"));
			templateMaps.put("crangenew", creg.getFieldValue("crangenew"));
			templateMaps.put("cfamily", creg.getFieldValue("family"));
			templateMaps.put("cfamilynew", creg.getFieldValue("familynew"));
		}
		
		if (template.equals("weituo")){
			templateMaps.put("shname", "");
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
			templateMaps.put("haddress", creg.getFieldValue("caddressnew"));
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
				templateMaps.put("markAddr2", "");
				templateMaps.put("markAddr3", "");
			}
		}
		return templateMaps;
	}
	
	public void generateMap(Indivchg creg){
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
	
	@SuppressWarnings("deprecation")
	public boolean generate(Indivchg creg,boolean preview){
		//读取并设置预约的日期
		Date now = new Date();
		long time = now.getTime();
		
		try{
			String userDir= Utils.getPath()+ "userspace" + File.separator + Utils.getCurrentUser().getLoginId()+File.separator 
					+ creg.getCname()+"_变更"+File.separator  ;
			Utils.delDirectory(userDir);
			Utils.createDirectory(userDir);
			DocUtil docu= new DocUtil();
			
			String outputFile = "";

			Map<String, String> dataMap = null;
			outputFile = userDir + "个体工商户变更（换照）登记申请书.doc";
			dataMap = IndivchService.getTemplateMaps("creg", creg);
			docu.createDoc(dataMap, "indivchg.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "个体工商户变更（换照）登记申请书");
				docu.waterMark(userDir, "个体工商户变更（换照）登记申请书");
			}
			
			if(!creg.getCaddressnew().trim().equals("")){
				outputFile = userDir + "吉林省市场主体住所（经营场所）登记表.doc";
				dataMap = IndivchService.getTemplateMaps("zhusuo", creg);
				docu.createDoc(dataMap, "zhusuo.xml", outputFile);
				if(!preview){
					docu.wordToPDF(userDir, "吉林省市场主体住所（经营场所）登记表");
					docu.waterMark(userDir, "吉林省市场主体住所（经营场所）登记表");
				}
			}
				
			outputFile = userDir + "委托代理人证明.doc";
			dataMap = IndivchService.getTemplateMaps("weituo", creg);
			docu.createDoc(dataMap, "weituo2.xml", outputFile);
			if(!preview){
				docu.wordToPDF(userDir, "委托代理人证明");
				docu.waterMark(userDir, "委托代理人证明");
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
