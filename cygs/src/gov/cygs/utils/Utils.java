package gov.cygs.utils;

import gov.cygs.backbean.LoginUser;
import gov.cygs.ejb.ConverterEJB;
import gov.cygs.ejb.SysConfig;
import gov.cygs.entities.Branchreg;
import gov.cygs.entities.Companychg;
import gov.cygs.entities.Companyreg;
import gov.cygs.entities.Config;
import gov.cygs.entities.Dongshi;
import gov.cygs.entities.EntityImpl;
import gov.cygs.entities.Indivreg;
import gov.cygs.entities.Jianshi;
import gov.cygs.entities.MapPoint;
import gov.cygs.entities.MapSection;
import gov.cygs.entities.Person;
import gov.cygs.entities.Personreg;
import gov.cygs.entities.Range;
import gov.cygs.entities.Shareholder;
import gov.cygs.entities.SysUser;

import java.awt.print.PrinterJob;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.PrintService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;



@Stateless
@Dependent
public class Utils {
	@PersistenceContext(unitName = "cygs")
	private EntityManager em;	

	@EJB SysConfig sysconfig;
	
	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntityImpl findEntiyInSet(Object dataSet, EntityImpl obj ){
		EntityImpl fobj = null;
		@SuppressWarnings("unchecked")
		Set<EntityImpl> sets  = (Set<EntityImpl>) dataSet; 
		for(EntityImpl e:sets){
			if(((EntityImpl) e).getUuid().equals(obj.getUuid())){
				fobj=(EntityImpl) e;
				break;
			}
		}
		return fobj;
	}
	
	public static EntityImpl findEntiyInList(Object dataSet, EntityImpl obj ){
		EntityImpl fobj = null;
		@SuppressWarnings("unchecked")
		List<EntityImpl> sets  = (List<EntityImpl>) dataSet; 
		for(EntityImpl e:sets){
			if(((EntityImpl) e).getUuid().equals(obj.getUuid())){
				fobj=(EntityImpl) e;
				break;
			}
		}
		return fobj;
	}
	
	public static Config getSysConfig(){
		Context ctx;
		Config config= new Config();
		try{
			ctx = new InitialContext();
			SysConfig sysConfig=(SysConfig) ctx.lookup("java:module/SysConfig!gov.cygs.ejb.SysConfig");
			config = sysConfig.getConfig();
		}catch(Exception e){
			
		}
		return config;
	}
	
	public static void sendSMS(String mobileNo, String msg) throws IOException {

		Context ctx;
		Config config= new Config();
		try {
			ctx = new InitialContext();
			SysConfig sysConfig=(SysConfig) ctx.lookup("java:module/SysConfig!gov.cygs.ejb.SysConfig");
			config = sysConfig.getConfig();
			
			boolean sendSms = config.isSendSms();
			if(!sendSms) {
				return;
			}
			
			String smsUser = config.getSmsUser();
			String smsPassword = config.getSmsPassword();
			String smsId = config.getSmsId();

			//发送内容
			//String msg = "【朝阳工商局温馨提示】尊敬的企业登记申请人：您的公司设立登记申请，我局已有回复，请您上网查询回复意见"; 
			
			// 创建StringBuffer对象用来操作字符串
			StringBuffer buff = new StringBuffer("http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?");
	
			// 向StringBuffer追加用户名
			buff.append("sn="+ smsUser);
			
			// smsId = MD5(smsUser +smsPassword);
			
			// 向StringBuffer追加密码  //smsId=MD5(sn+password)
			buff.append("&pwd="+smsId);
	
			// 向StringBuffer追加手机号码
			buff.append("&mobile=" + mobileNo);
			
			// 向StringBuffer追加消息内容转URL标准码
			buff.append("&content="+URLEncoder.encode(msg,"UTF-8"));
			
			// 向StringBuffer追加其它参数
			buff.append("&ext=&stime=&rrid=&msgfmt=");
			
			// 创建url对象
			URL url = new URL(buff.toString());
	
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
	
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	
			// 返回发送结果
			String inputline = in.readLine();
			inputline = in.readLine();
			
			// 返回结果为‘100’ 发送成功
			// System.out.println(inputline);
			
			//System.out.println("发送短信到："+mobileNo + ", 结果为：" + inputline);
			
			System.err.println("发送短信到："+mobileNo + ", 结果为：" + inputline);
			
//			-2 	帐号/密码不正确	1.序列号未注册2.密码加密不正确3.密码已被修改4.序列号已注销
//			-4	余额不足支持本次发送	余额不足
//			-5	数据格式错误	只能自行调试了。或与技术支持联系
//			-6	参数有误	看参数传的是否均正常,请调试程序查看各参数
//			-7	权限受限	该序列号是否已经开通了调用该方法的权限
//			-8	流量控制错误	
//			-9	扩展码权限错误	该序列号是否已经开通了扩展子号的权限,把ext这个参数置空。
//			-10	内容长度长	单字节不能超过1000个字符，双字节不能超过500个字符
//			-11	内部数据库错误	
//			-12	序列号状态错误	序列号是否被禁用
//			-14	服务器写文件失败	
//			-17	没有权限	如发送彩信仅限于SDK3
//			-19	禁止同时使用多个接口地址	每个序列号提交只能使用一个接口地址
//			-20	相同手机号，相同内容重复提交	
//			-22	Ip鉴权失败	提交的IP不是所绑定的IP
//			-23	缓存无此序列号信息	
//			-601	序列号为空，参数错误	
//			-602	序列号格式错误，参数错误	
//			-603	密码为空，参数错误	
//			-604	手机号码为空，参数错误	
//			-605	内容为空，参数错误	
//			-606	ext长度大于9，参数错误	
//			-607	参数错误 扩展码非数字 	
//			-608	参数错误 定时时间非日期格式	
//			-609	rrid长度大于18,参数错误 	
//			-610	参数错误 rrid非数字	
//			-611	参数错误 内容编码不符合规范	
//			-623	手机个数与内容个数不匹配	
//			-624	扩展个数与手机个数数	
//			-625	定时时间个数与手机个数数不匹配	
//			-626	rrid个数与手机个数数不匹配	

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Person> getPersons(Companychg creg){
		return getPersons(creg, false);
	}
	
	
	
	public static List<Person> getPersons(Companychg creg, boolean awsAdd){
		List<Person> persons = new ArrayList<Person>();
		try{
		
		if(creg.getLlyName()!=null && !creg.getLlyName().equals("")){
			int index=Utils.findPerson(persons, creg.getLlyName(), creg.getLlyIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getLlyName());
			if(creg.getLlyIdtype()!=null && !creg.getLlyIdtype().equals("")){
				p.setIdType(creg.getLlyIdtype());
			}
			if(creg.getLlyIdno()!=null && !creg.getLlyIdno().equals("")){
				p.setIdNo(creg.getLlyIdno());
			}
			if(creg.getLlyMail()!=null && !creg.getLlyMail().equals("")){
				p.setEmail(creg.getLlyMail());
			}
			if(creg.getLlyMobile()!=null && !creg.getLlyMobile().equals("")){
				p.setMobile(creg.getLlyMobile());
			}
			if(creg.getLlyTele()!=null && !creg.getLlyTele().equals("")){
				p.setPhone(creg.getLlyTele());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		if(creg.getAuthDname()!=null && !creg.getAuthDname().equals("")){
			int index=Utils.findPerson(persons, creg.getAuthDname(), creg.getAuthIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getAuthDname());
			if(creg.getAuthIdtype()!=null && !creg.getAuthIdtype().equals("")){
				p.setIdType(creg.getAuthIdtype());
			}
			if(creg.getAuthIdno()!=null && !creg.getAuthIdno().equals("")){
				p.setIdNo(creg.getAuthIdno());
			}
			if(creg.getAuthMobile()!=null && !creg.getAuthMobile().equals("")){
				p.setMobile(creg.getAuthMobile());
			}
			if(creg.getAuthTele()!=null && !creg.getAuthTele().equals("")){
				p.setPhone(creg.getAuthTele());
			}
			if(index<0){
				persons.add(p);
			}
		}		

		}catch(Exception e){
			e.printStackTrace();
		}
		return persons;
	}

	

	
	public static List<Person> getPersons(Companyreg creg){
		return getPersons(creg, false);
	}

	public static List<Person> getPersons(Companyreg creg, boolean awsAdd){
		List<Person> persons = new ArrayList<Person>();
		try{
		if(creg.getCeoName()!=null && !creg.getCeoName().equals("")){
			int index=Utils.findPerson(persons, creg.getCeoName(), creg.getCeoIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getCeoName());
			if(creg.getCeoIdtype()!=null && !creg.getCeoIdtype().equals("")){
				p.setIdType(creg.getCeoIdtype());
			}
			if(creg.getCeoIdno()!=null && !creg.getCeoIdno().equals("")){
				p.setIdNo(creg.getCeoIdno());
			}
			if(creg.getCeoMail()!=null && !creg.getCeoMail().equals("")){
				p.setEmail(creg.getCeoMail());
			}
			if(creg.getCeoMobile()!=null && !creg.getCeoMobile().equals("")){
				p.setMobile(creg.getCeoMobile());
			}
			if(creg.getCeoTele()!=null && !creg.getCeoTele().equals("")){
				p.setPhone(creg.getCeoTele());
			}
			persons.add(p);
		}
		
		Set<Shareholder> shares = creg.getShareholders();
		for(Shareholder share: shares){
			if(share.getShtype()!=null && !share.getShtype().equals("自然人")){
				continue;
			}
			
			int index=Utils.findPerson(persons, share.getShname(), share.getShidno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(share.getShname());
			if(share.getShidtype()!=null && !share.getShidtype().equals("")){
				p.setIdType(share.getShidtype());
			}
			if(share.getShidno()!=null && !share.getShidno().equals("")){
				p.setIdNo(share.getShidno());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		for(Dongshi ds:creg.getDongshis()){
			int index=Utils.findPerson(persons, ds.getDsname(), ds.getDsidno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(ds.getDsname());
			if(ds.getDsidtype()!=null && !ds.getDsidtype().equals("")){
				p.setIdType(ds.getDsidtype());
			}
			if(ds.getDsidno()!=null && !ds.getDsidno().equals("")){
				p.setIdNo(ds.getDsidno());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		for(Jianshi js:creg.getJianshis()){
			int index=Utils.findPerson(persons, js.getJsname(), js.getJsidno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(js.getJsname());
			if(js.getJsidtype()!=null && !js.getJsidtype().equals("")){
				p.setIdType(js.getJsidtype());
			}
			if(js.getJsidno()!=null && !js.getJsidno().equals("")){
				p.setIdNo(js.getJsidno());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		if(creg.getJlName()!=null && !creg.getJlName().equals("")){
			int index=Utils.findPerson(persons, creg.getJlName(), creg.getJlIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getJlName());
			if(creg.getJlIdtype()!=null && !creg.getJlIdtype().equals("")){
				p.setIdType(creg.getJlIdtype());
			}
			if(creg.getJlIdno()!=null && !creg.getJlIdno().equals("")){
				p.setIdNo(creg.getJlIdno());
			}
			if(index<0){
				persons.add(p);
			}
		}		
		
		if(creg.getLlyName()!=null && !creg.getLlyName().equals("")){
			int index=Utils.findPerson(persons, creg.getLlyName(), creg.getLlyIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getLlyName());
			if(creg.getLlyIdtype()!=null && !creg.getLlyIdtype().equals("")){
				p.setIdType(creg.getLlyIdtype());
			}
			if(creg.getLlyIdno()!=null && !creg.getLlyIdno().equals("")){
				p.setIdNo(creg.getLlyIdno());
			}
			if(creg.getLlyMail()!=null && !creg.getLlyMail().equals("")){
				p.setEmail(creg.getLlyMail());
			}
			if(creg.getLlyMobile()!=null && !creg.getLlyMobile().equals("")){
				p.setMobile(creg.getLlyMobile());
			}
			if(creg.getLlyTele()!=null && !creg.getLlyTele().equals("")){
				p.setPhone(creg.getLlyTele());
			}
			if(index<0){
				persons.add(p);
			}
		}

		if(!creg.getFinName().equals("")){
			int index=Utils.findPerson(persons, creg.getFinName(), creg.getFinIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getFinName());
			if(creg.getFinIdtype()!=null && !creg.getFinIdtype().equals("")){
				p.setIdType(creg.getFinIdtype());
			}
			if(creg.getFinIdno()!=null && !creg.getFinIdno().equals("")){
				p.setIdNo(creg.getFinIdno());
			}
			if(creg.getFinMail()!=null && !creg.getFinMail().equals("")){
				p.setEmail(creg.getFinMail());
			}
			if(creg.getFinMobile()!=null && !creg.getFinMobile().equals("")){
				p.setMobile(creg.getFinMobile());
			}
			if(creg.getFinTele()!=null && !creg.getFinTele().equals("")){
				p.setPhone(creg.getFinTele());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		if(creg.getAuthDname()!=null && !creg.getAuthDname().equals("")){
			int index=Utils.findPerson(persons, creg.getAuthDname(), creg.getAuthIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getAuthDname());
			if(creg.getAuthIdtype()!=null && !creg.getAuthIdtype().equals("")){
				p.setIdType(creg.getAuthIdtype());
			}
			if(creg.getAuthIdno()!=null && !creg.getAuthIdno().equals("")){
				p.setIdNo(creg.getAuthIdno());
			}
			if(creg.getAuthMobile()!=null && !creg.getAuthMobile().equals("")){
				p.setMobile(creg.getAuthMobile());
			}
			if(creg.getAuthTele()!=null && !creg.getAuthTele().equals("")){
				p.setPhone(creg.getAuthTele());
			}
			if(index<0){
				persons.add(p);
			}
		}		

		if(creg.getAuthDname2()!=null && !creg.getAuthDname2().equals("")){
			int index=Utils.findPerson(persons, creg.getAuthDname2(), creg.getAuthIdno2());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getAuthDname2());
				p.setIdType("身份证");
			if(creg.getAuthIdno2()!=null && !creg.getAuthIdno2().equals("")){
				p.setIdNo(creg.getAuthIdno2());
			}
			if(creg.getAuthMobile2()!=null && !creg.getAuthMobile2().equals("")){
				p.setMobile(creg.getAuthMobile2());
			}
			if(index<0){
				persons.add(p);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return persons;
	}
	

	public static List<Person> getPersons(Personreg creg){
		return getPersons(creg, false);
	}
	public static List<Person> getPersons(Personreg creg, boolean awsAdd){
		List<Person> persons = new ArrayList<Person>();
		try{
		if(creg.getShname()!=null && !creg.getShname().equals("")){
			int index=Utils.findPerson(persons, creg.getShname(), creg.getShidno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getShname());
			if(creg.getShidtype()!=null && !creg.getShidtype().equals("")){
				p.setIdType(creg.getShidtype());
			}
			if(creg.getShidno()!=null && !creg.getShidno().equals("")){
				p.setIdNo(creg.getShidno());
			}
			if(creg.getShemail()!=null && !creg.getShemail().equals("")){
				p.setEmail(creg.getShemail());
			}
			if(creg.getShmobile()!=null && !creg.getShmobile().equals("")){
				p.setMobile(creg.getShmobile());
			}
			persons.add(p);
		}

		if(creg.getLlyName()!=null && !creg.getLlyName().equals("")){
			int index=Utils.findPerson(persons, creg.getLlyName(), creg.getLlyIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getLlyName());
			if(creg.getLlyIdtype()!=null && !creg.getLlyIdtype().equals("")){
				p.setIdType(creg.getLlyIdtype());
			}
			if(creg.getLlyIdno()!=null && !creg.getLlyIdno().equals("")){
				p.setIdNo(creg.getLlyIdno());
			}
			if(creg.getLlyMail()!=null && !creg.getLlyMail().equals("")){
				p.setEmail(creg.getLlyMail());
			}
			if(creg.getLlyMobile()!=null && !creg.getLlyMobile().equals("")){
				p.setMobile(creg.getLlyMobile());
			}
			if(creg.getLlyTele()!=null && !creg.getLlyTele().equals("")){
				p.setPhone(creg.getLlyTele());
			}
			if(index<0){
				persons.add(p);
			}
		}

		if(!creg.getFinName().equals("")){
			int index=Utils.findPerson(persons, creg.getFinName(), creg.getFinIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getFinName());
			if(creg.getFinIdtype()!=null && !creg.getFinIdtype().equals("")){
				p.setIdType(creg.getFinIdtype());
			}
			if(creg.getFinIdno()!=null && !creg.getFinIdno().equals("")){
				p.setIdNo(creg.getFinIdno());
			}
			if(creg.getFinMail()!=null && !creg.getFinMail().equals("")){
				p.setEmail(creg.getFinMail());
			}
			if(creg.getFinMobile()!=null && !creg.getFinMobile().equals("")){
				p.setMobile(creg.getFinMobile());
			}
			if(creg.getFinTele()!=null && !creg.getFinTele().equals("")){
				p.setPhone(creg.getFinTele());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		if(creg.getAuthDname()!=null && !creg.getAuthDname().equals("")){
			int index=Utils.findPerson(persons, creg.getAuthDname(), creg.getAuthIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getAuthDname());
			if(creg.getAuthIdtype()!=null && !creg.getAuthIdtype().equals("")){
				p.setIdType(creg.getAuthIdtype());
			}
			if(creg.getAuthIdno()!=null && !creg.getAuthIdno().equals("")){
				p.setIdNo(creg.getAuthIdno());
			}
			if(creg.getAuthMobile()!=null && !creg.getAuthMobile().equals("")){
				p.setMobile(creg.getAuthMobile());
			}
			if(creg.getAuthTele()!=null && !creg.getAuthTele().equals("")){
				p.setPhone(creg.getAuthTele());
			}
			if(index<0){
				persons.add(p);
			}
		}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return persons;
	}
	
	
	public static List<Person> getPersons(Indivreg creg){
		return getPersons(creg, false);
	}
	public static List<Person> getPersons(Indivreg creg, boolean awsAdd){
		List<Person> persons = new ArrayList<Person>();
		try{
		if(creg.getShname()!=null && !creg.getShname().equals("")){
			int index=Utils.findPerson(persons, creg.getShname(), creg.getShidno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getShname());
			if(creg.getShidno()!=null && !creg.getShidno().equals("")){
				p.setIdNo(creg.getShidno());
			}
			if(creg.getShemail()!=null && !creg.getShemail().equals("")){
				p.setEmail(creg.getShemail());
			}
			if(creg.getShmobile()!=null && !creg.getShmobile().equals("")){
				p.setMobile(creg.getShmobile());
			}
			persons.add(p);
		}
		}catch(Exception e){
			
		}
		return persons;
	}
	
	public static List<Person> getPersons(Branchreg creg){
		return getPersons(creg,false);
	}
	public static List<Person> getPersons(Branchreg creg,boolean awsAdd){
		List<Person> persons = new ArrayList<Person>();
		try{
			if(creg.getCeoName()!=null && !creg.getCeoName().equals("")){
				int index=Utils.findPerson(persons, creg.getCeoName(), creg.getCeoIdno());
				Person p;
				if(index>=0){
					p= persons.get(index);
				}else{
					p = new Person();
				}
				if(awsAdd){
					p = new Person();
					index = -1;
				}
				p.setName(creg.getCeoName());
				if(creg.getCeoIdtype()!=null && !creg.getCeoIdtype().equals("")){
					p.setIdType(creg.getCeoIdtype());
				}
				if(creg.getCeoIdno()!=null && !creg.getCeoIdno().equals("")){
					p.setIdNo(creg.getCeoIdno());
				}
				if(creg.getCeoMail()!=null && !creg.getCeoMail().equals("")){
					p.setEmail(creg.getCeoMail());
				}
				if(creg.getCeoMobile()!=null && !creg.getCeoMobile().equals("")){
					p.setMobile(creg.getCeoMobile());
				}
				if(creg.getCeoTele()!=null && !creg.getCeoTele().equals("")){
					p.setPhone(creg.getCeoTele());
				}
				persons.add(p);
			}
			
		if(creg.getLlyName()!=null && !creg.getLlyName().equals("")){
			int index=Utils.findPerson(persons, creg.getLlyName(), creg.getLlyIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getLlyName());
			if(creg.getLlyIdtype()!=null && !creg.getLlyIdtype().equals("")){
				p.setIdType(creg.getLlyIdtype());
			}
			if(creg.getLlyIdno()!=null && !creg.getLlyIdno().equals("")){
				p.setIdNo(creg.getLlyIdno());
			}
			if(creg.getLlyMail()!=null && !creg.getLlyMail().equals("")){
				p.setEmail(creg.getLlyMail());
			}
			if(creg.getLlyMobile()!=null && !creg.getLlyMobile().equals("")){
				p.setMobile(creg.getLlyMobile());
			}
			if(creg.getLlyTele()!=null && !creg.getLlyTele().equals("")){
				p.setPhone(creg.getLlyTele());
			}
			if(index<0){
				persons.add(p);
			}
		}

		if(!creg.getFinName().equals("")){
			int index=Utils.findPerson(persons, creg.getFinName(), creg.getFinIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getFinName());
			if(creg.getFinIdtype()!=null && !creg.getFinIdtype().equals("")){
				p.setIdType(creg.getFinIdtype());
			}
			if(creg.getFinIdno()!=null && !creg.getFinIdno().equals("")){
				p.setIdNo(creg.getFinIdno());
			}
			if(creg.getFinMail()!=null && !creg.getFinMail().equals("")){
				p.setEmail(creg.getFinMail());
			}
			if(creg.getFinMobile()!=null && !creg.getFinMobile().equals("")){
				p.setMobile(creg.getFinMobile());
			}
			if(creg.getFinTele()!=null && !creg.getFinTele().equals("")){
				p.setPhone(creg.getFinTele());
			}
			if(index<0){
				persons.add(p);
			}
		}
		
		if(creg.getAuthDname()!=null && !creg.getAuthDname().equals("")){
			int index=Utils.findPerson(persons, creg.getAuthDname(), creg.getAuthIdno());
			Person p;
			if(index>=0){
				p= persons.get(index);
			}else{
				p = new Person();
			}
			if(awsAdd){
				p = new Person();
				index = -1;
			}
			p.setName(creg.getAuthDname());
			if(creg.getAuthIdtype()!=null && !creg.getAuthIdtype().equals("")){
				p.setIdType(creg.getAuthIdtype());
			}
			if(creg.getAuthIdno()!=null && !creg.getAuthIdno().equals("")){
				p.setIdNo(creg.getAuthIdno());
			}
			if(creg.getAuthMobile()!=null && !creg.getAuthMobile().equals("")){
				p.setMobile(creg.getAuthMobile());
			}
			if(creg.getAuthTele()!=null && !creg.getAuthTele().equals("")){
				p.setPhone(creg.getAuthTele());
			}
			if(index<0){
				persons.add(p);
			}
		}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return persons;
	}

	
	private static int findPerson(List<Person>persons, String name, String idno){
		int index = -1;
		int pos= -1;
		for(Person p: persons){
			index++;
			if(p.getName().equals(name) && p.getIdNo().equals(idno)){
				pos = index;
				break;
			}
		}
		return pos;
	}
	
	//检查人员列表中是否有证件号相同，名称不同，或电话号相同但名称不同的人员，
	//返回字符串数组 [0]:证件号相同人员， [1]:电话号相同人员
	public static String[] findDupPersons(List<Person>persons){
		String[]  dupNames = {"",""};
		for(int i=0;i<persons.size();i++){
			Person per = persons.get(i);
			for(int r=i;r<persons.size();r++){
				Person prest = persons.get(r);
				 if(prest.getMobile().equals(per.getMobile()) && !per.getName().equals(prest.getName()) && !prest.getMobile().trim().equals("")){
					 if(dupNames[1].indexOf(per.getName())<0 && dupNames[1].indexOf(prest.getName())<0 ){
						 dupNames[1] =dupNames[1]+ per.getName()+"与"+ prest.getName()+",";
					 } 
				 }
				 if(prest.getIdNo().equals(per.getIdNo()) && !per.getName().equals(prest.getName()) && !prest.getIdNo().trim().equals("")){
					 if(dupNames[0].indexOf(per.getName())<0 && dupNames[0].indexOf(prest.getName())<0 ){
						 dupNames[0] =dupNames[0]+ per.getName()+"与"+ prest.getName()+",";
					 }
				 }
			}
		}
		if(!dupNames[0].equals("")){
			dupNames[0] = dupNames[0].substring(0, dupNames[0].length()-1);
		}
		if(!dupNames[1].equals("")){
			dupNames[1] = dupNames[1].substring(0, dupNames[1].length()-1);
		}
		return dupNames;
	}
	
	public static String ranges2String( List<Range> ranges){
		String selrange= "";
		int index = 0;
		for(Range r: ranges){
			if(index==0){
				selrange= selrange+"[";
			}
			selrange= selrange + r.getId()+",";
			index++;
		}
		if(selrange.equals("")){
			selrange="[]";
		}else{
			selrange = selrange.substring(0, selrange.length()-1)+"]";
		}
		return selrange;
	}
	
	public static Date getday(Date day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date d= cal.getTime();
		return d; 
	}
	
	public static int getYear(Date day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getDate(Date day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		return cal.get(Calendar.DAY_OF_YEAR);
	}
	
	public static int getDays(Date date1,Date date2){
		long between = date2.getTime() - date1.getTime();
		int days = (int) Math.round(between/(double)(24*3600000));
		return days;
	}
	
	
	public static String formatDate(Date day, String pattern){
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern(pattern);
		return df.format(day);
	}
	
	public static String leadZero(int number, int width){
		String vstr= String.valueOf(number);
		String lead = "";
		for(int i = 0;i<width-vstr.length();i++){
			lead = lead+"0";
		}
		return lead+vstr;
	}
	
	public static String array2string(String[] array, String edge){
		String str="";
		try{
			int count= array.length;
			for(int i=0;i<count;i++){
				if (array[i].equals("null")){
					str=str+array[i]+",";
				}else{
					str=str+edge+array[i]+edge+",";
				}
			}
			str = str.substring(0,str.length()-1);
		}catch(Exception e){
			
		}
		return str;
	}
	
	public static String updateTail(String[] flds){
		String str="";
		try{
			int count= flds.length;
			for(int i=0;i<count;i++){
				if(flds[i].equals("id")){continue;}
				String fld = flds[i];
				str=str+" `"+fld+"`=VALUES(`"+fld+"`),";
			}
			str = str.substring(0,str.length()-1);
		}catch(Exception e){
			
		}
		return str;
	}
	
	
	public static String numFormat(Object num){
		String rstr = "";
		String type = num.getClass().getSimpleName();
		int intv = 0;
		if(type.equals("Float")){
			intv = Math.round((float)num );
			if(intv == (float)num){
				rstr = String.valueOf(intv);
			}else{
				rstr = String.valueOf(num);
			}
		}
		if(type.equals("Integer")){
			rstr = String.valueOf(num);
		}
		return rstr;
	}
	
	public static String numFormat(Object num, int prec){
		String rstr = "";
		String type = num.getClass().getSimpleName();
		int intv = 0;
		if(type.equals("Float")){
			num=(float)(Math.round((float)num*Math.pow(10, prec))/Math.pow(10, prec));
		}
		return numFormat(num);
	}
    
    public static String getRandomFileName() {
        int i = (int) (Math.random() * 10000000);
        return String.valueOf(i);
    }
    
    public static String getPath(){
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String path = servletContext.getRealPath("") + File.separator;
		return path;
    }
    
    /** 
     * 新建目录. 
     *  
     * @param path 文件路径 
     * @throws Exception 
     */  
    public static void createDirectory(String path) throws Exception {  
        if (path==null || path.trim().equals("")) {  
            return;  
        }  
        try {  
            // 获得文件对象  
            File f = new File(path);  
            if (!f.exists()) {  
                // 如果路径不存在,则创建  
                f.mkdirs();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
    }
    
    public static void copyFile(String src, String target) {
    	try{
	    	FileInputStream input=new FileInputStream(src);//可替换为任何路径何和文件名
	    	FileOutputStream output=new FileOutputStream(target);//可替换为任何路径何和文件名
	    	byte[] buffer = new byte[102400];
	    	int in=input.read(buffer);
	    	while(in!=-1){
	    		output.write(buffer, 0, in);
	    		in=input.read(buffer);
	    	}
	    	input.close();
	    	output.close();
    	}catch (IOException e){
    		System.out.println(e.toString());
    	}
    }
    
    public static void compress(String srcPathName,String outFile) {  
    	File zipFile = new File(outFile); 
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists())  
            throw new RuntimeException(srcPathName + "不存在！");  
          
        Project prj = new Project();  
        Zip zip = new Zip();  
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        FileSet fileSet = new FileSet();  
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        //fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");  
        //fileSet.setExcludes(...); 排除哪些文件或文件夹  
        zip.addFileset(fileSet);  
        zip.execute();

    }  
    
    public static Boolean unzip(String fileName, String unzipFilePath){
    	Boolean result = false;
    	int buffer = 2048;
    	try {
    	           ZipFile zipFile = new ZipFile(fileName);
    	           Enumeration emu = zipFile.entries();
    	           int i=0;
    	           while(emu.hasMoreElements()){
    	               ZipEntry entry = (ZipEntry)emu.nextElement();
    	               //会把目录作为一个file读出一次，所以只建立目录就可以，之下的文件还会被迭代到。
    	               if (entry.isDirectory())
    	               {
    	                   new File(unzipFilePath + entry.getName()).mkdirs();
    	                   continue;
    	               }
    	               BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
    	               File file = new File(unzipFilePath + File.separator + entry.getName());
    	               //加入这个的原因是zipfile读取文件是随机读取的，这就造成可能先读取一个文件
    	               //而这个文件所在的目录还没有出现过，所以要建出目录来。
    	               File parent = file.getParentFile();
    	               if(parent != null && (!parent.exists())){
    	                   parent.mkdirs();
    	               }
    	               FileOutputStream fos = new FileOutputStream(file);
    	               BufferedOutputStream bos = new BufferedOutputStream(fos,buffer);           
    	               
    	               int count;
    	               byte data[] = new byte[buffer];
    	               while ((count = bis.read(data, 0, buffer)) != -1)
    	               {
    	                   bos.write(data, 0, count);
    	               }
    	               bos.flush();
    	               bos.close();
    	               bis.close();
    	           }
    	           zipFile.close();
    	           result = true;
    	       } catch (Exception e) {
    	           e.printStackTrace();
    	           result = false;
    	       }
    	return result;
    }
    
    public static boolean  fileExist(String fileName){
    	boolean exist = false;
    	File f = new File(fileName);
    	if(f.exists()){
    		exist = true;
    	}
    	return exist;
    }
    
    public static void delDirectory(String filepath) throws IOException{
    	File f = new File(filepath);//定义文件路径         
    	if(f.exists() && f.isDirectory()){//判断是文件还是目录  
    	   if(f.listFiles().length==0){//若目录下没有文件则直接删除  
    	       f.delete();  
    	    }else{//若有则把文件放进数组，并判断是否有下级目录  
    	        File delFile[]=f.listFiles(); 
    	        int i =f.listFiles().length;
    	        for(int j=0;j<i;j++){
    	            if(delFile[j].isDirectory()){  
    	            	delDirectory(delFile[j].getAbsolutePath());//递归调用delDirectory方法并取得子目录路径  
    	            }
    	            delFile[j].delete();//删除文件
    	        }
    	    }
    	   f.delete();  
    	}
    }
    
    
    public static List<String> getFileList(String filepath) {
    	File f = new File(filepath);
    	File allFile[] = f.listFiles();
    	List<String> fileList = new ArrayList<String>();
    	int i = allFile.length;
    	for(int j = 0; j<i; j++){
    		if(!allFile[j].isDirectory()){
    			fileList.add(allFile[j].getName());
    		}
    	}
    	return fileList;
    }
    
    
    public static String getParam(String pName){
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	String pValue=request.getParameter(pName);
//    	String pValue=(String) request.getAttribute(pName);
    	return pValue;
    }
    public static void setParam(String pName, String value){
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	String [] values = new String[1];
    	values [0] = value;
    	request.getParameterMap().put(pName, values);
    }

    public static String getAttribute(String pName){
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	String pValue=(String) request.getAttribute(pName);
//    	for  (Enumeration e  =  request.getAttributeNames(); e.hasMoreElements();)  
//    	{
//    	        Object o  =  e.nextElement();
//    	        System.out.println((String) o  + ":"   +  request.getAttribute((String) o) );
//    	 }    	
    	if(pValue==null){
    		pValue=(String) request.getSession().getAttribute(pName);
    	}
    	return pValue;
    }

    public static void setAttribute(String pName, String value){
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	request.getSession().setAttribute(pName, value);
    	request.setAttribute(pName, value);
    }
    
    public static void sendRedirect(String uri){
    	try {
        	HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
			String path = FacesContext.getCurrentInstance().getExternalContext().getContextName();
			response.sendRedirect(uri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    
	public static SysUser getCurrentUser(){
		SysUser u;
		try{
		LoginUser loginUser;
		FacesContext context = FacesContext.getCurrentInstance();
		loginUser=(LoginUser)(context.getApplication().getELResolver().getValue(context.getELContext(), null, "loginUser"));
		u= loginUser.getUser();
		}catch(Exception e){
			return null;
		}
		return u;
	}
	
	public static void setCurrentUser(SysUser user){
		LoginUser loginUser;
		FacesContext context = FacesContext.getCurrentInstance();
		loginUser=(LoginUser)(context.getApplication().getELResolver().getValue(context.getELContext(), null, "loginUser"));
		loginUser.setUser(user);
	}
    
    public static List<String> getStringAsList(String str){
		List<String> retList= new ArrayList<String>();
		if(str==null) return retList;
		if (str.equals("")|| str.equals("[]") ) return retList;
		if(str.startsWith("[") && str.endsWith("]"))
			str=str.substring(1, str.length()-1);
			String[] strArray=str.split(",");
			for(int i=0;i<strArray.length;i++){
			retList.add(strArray[i].trim());
		}
		return retList;
    }
    
    public static List<FacesMessage> getMessages(){
    	List<FacesMessage> messages = null;
    	messages = FacesContext.getCurrentInstance().getMessageList();
    	if(messages ==null){
    		messages = new ArrayList<FacesMessage>();
    	}
    	return messages;
    }

	public static void  addMessage(String type, String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,type,msg);
		
		try{
			switch(type){
				case "消息":
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
					break;
				case "警告":
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "警告：", msg));
					break;
				case "错误":
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "错误：", msg));
					break;
				default:
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
					break;
			}
			//FacesContext.getCurrentInstance().addMessage(null, message);
		}catch(Exception e){
			System.out.println("failed to add message");
		}
	}
	
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
	
	public static PrintService choosePrinter() {
	    PrinterJob printJob = PrinterJob.getPrinterJob();
	    if(printJob.printDialog()) {
	        return printJob.getPrintService();          
	    }
	    else {
	        return null;
	    }
	}
	
	public static void PrintPDF(String fileName){
		//--silentPrint：静默打印
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintService(choosePrinter());
			//PDDocument doc = PDDocument.load(fileName);
			//doc.print(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    public static void addTotaltoXLS(Object document, Map<int[], String> totals ) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        int totalcol= header.getPhysicalNumberOfCells();
        for(int i=0; i < totalcol;i++) {
            HSSFCell cell = header.getCell(i);
            cell.setCellStyle(cellStyle);
        }
        int totalrow = sheet.getPhysicalNumberOfRows();
        HSSFRow hssfRow=sheet.createRow(totalrow);
		for(int col=0;col<=totalcol;col++){
    		HSSFCell c=hssfRow.createCell(col);
    		c.setCellStyle(cellStyle);
		}
		
		for(Map.Entry<int[], String> en : totals.entrySet()){
			int begin = en.getKey()[0];
			int end = en.getKey()[1];
			String value = en.getValue();
			for(int col = begin ; col<=end;col++){
				HSSFCell c = hssfRow.getCell(col);
				c.setCellValue(value);
			}
		}
			
		
    }
	
	public static void getCellStyle(){
		HSSFWorkbook book = new HSSFWorkbook();
    	HSSFCellStyle bottomCenterStyle = book.createCellStyle();
    	bottomCenterStyle.setBorderBottom(CellStyle.BORDER_DASHED);
    	bottomCenterStyle.setBorderLeft(CellStyle.BORDER_NONE);
    	bottomCenterStyle.setBorderRight(CellStyle.BORDER_NONE);
    	bottomCenterStyle.setBorderTop(CellStyle.BORDER_NONE);
    	bottomCenterStyle.setAlignment(CellStyle.ALIGN_CENTER);
    	bottomCenterStyle.setAlignment(CellStyle.VERTICAL_CENTER);
    	bottomCenterStyle.setWrapText(true);
    	
    	HSSFCellStyle bottomRightStyle = book.createCellStyle();
    	bottomRightStyle.setBorderBottom(CellStyle.BORDER_DASHED);
    	bottomRightStyle.setBorderLeft(CellStyle.BORDER_NONE);
    	bottomRightStyle.setBorderRight(CellStyle.BORDER_NONE);
    	bottomRightStyle.setBorderTop(CellStyle.BORDER_NONE);
    	bottomRightStyle.setAlignment(CellStyle.ALIGN_RIGHT);
    	bottomRightStyle.setAlignment(CellStyle.VERTICAL_CENTER);
    	bottomRightStyle.setWrapText(true);

    	HSSFCellStyle blankCenterStyle = book.createCellStyle();
    	blankCenterStyle.setBorderBottom(CellStyle.BORDER_NONE);
    	blankCenterStyle.setBorderLeft(CellStyle.BORDER_NONE);
    	blankCenterStyle.setBorderRight(CellStyle.BORDER_NONE);
    	blankCenterStyle.setBorderTop(CellStyle.BORDER_NONE);
    	blankCenterStyle.setAlignment(CellStyle.ALIGN_CENTER);
    	blankCenterStyle.setAlignment(CellStyle.VERTICAL_CENTER);
    	blankCenterStyle.setWrapText(true);

    	HSSFCellStyle blankRightStyle = book.createCellStyle();
    	blankRightStyle.setBorderBottom(CellStyle.BORDER_NONE);
    	blankRightStyle.setBorderLeft(CellStyle.BORDER_NONE);
    	blankRightStyle.setBorderRight(CellStyle.BORDER_NONE);
    	blankRightStyle.setBorderTop(CellStyle.BORDER_NONE);
    	blankRightStyle.setAlignment(CellStyle.ALIGN_RIGHT);
    	blankRightStyle.setAlignment(CellStyle.VERTICAL_CENTER);
    	blankRightStyle.setWrapText(true);
	}
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
         Utils.unzip("D:\\temp\\cygs-20160613.zip","D:\\temp\\");
    }
	
	public static void sendSMS106(String mobileNo) throws IOException {
		
		//发送内容
		String msg = "【朝阳工商局温馨提示】尊敬的企业登记申请人：您的公司设立登记申请，我局已有回复，请您上网查询回复意见"; 
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer buff = new StringBuffer("http://api.106msg.com/TXTJK.aspx?");

		// 向StringBuffer追加用户名
		buff.append("type=send&ua=42825858");
		
		// 向StringBuffer追加密码 
		buff.append("&pwd=42825858");

		// 向StringBuffer追加网关id
		buff.append("&gwid=31");

		// 向StringBuffer追加手机号码
		buff.append("&mobile=" + mobileNo);

		// 向StringBuffer追加消息内容转URL标准码
		buff.append("&msg="+URLEncoder.encode(msg,"GBK"));

		// 创建url对象
		URL url = new URL(buff.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		// 返回发送结果
		String inputline = in.readLine();

		// 返回结果为‘100’ 发送成功
//		1	 发送短信成功(其他请求代表成功)
//		-1	 账号无效或未开户
//		-2	 账号密码错误
//		-3	 下发手机号为空
//		-4	 下发短信内容为空
//		-5	 指定短信企业ID为空
//		-6	 账户或密码错误
//		-7	 账户被冻结
//		-8	 下发短信内容包含非法关键词
//		-9	 账户没有充值或指定企业ID错误
//		-10	 下发短信内容长度超出规定限制，限制为300字符
//		-11	 下发账号余额不足
//		-20	 服务器连接异常
//		-21	 当前短信隶属106营销短信 必须加“尊称”、“退订回复T”
//		-99	系统未知错误
		// System.out.println(inputline);
		System.out.println("发送短信到："+mobileNo + ", 结果为：" + inputline );
	}
	
	
	
	    public static String MD5(String s) {
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
	        try {
	            byte[] btInput = s.getBytes();
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要
	            mdInst.update(btInput);
	            // 获得密文
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	       } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	       }
	}
	
	public static void sendSMS106(String mobileNo, String msg) throws IOException {

		Context ctx;
		Config config= new Config();
		try {
			ctx = new InitialContext();
			SysConfig sysConfig=(SysConfig) ctx.lookup("java:module/SysConfig!gov.cygs.ejb.SysConfig");
			config = sysConfig.getConfig();
			
			boolean sendSms = config.isSendSms();
			if(!sendSms) {
				return;
			}
			
			String smsUser = config.getSmsUser();
			String smsPassword = config.getSmsPassword();
			String smsId = config.getSmsId();

			//发送内容
			//String msg = "【朝阳工商局温馨提示】尊敬的企业登记申请人：您的公司设立登记申请，我局已有回复，请您上网查询回复意见"; 
			
			// 创建StringBuffer对象用来操作字符串
			StringBuffer buff = new StringBuffer("http://api.106msg.com/TXTJK.aspx?");
	
			// 向StringBuffer追加用户名
			buff.append("type=send&ua="+ smsUser);
			
			// 向StringBuffer追加密码 
			buff.append("&pwd="+smsPassword);
	
			// 向StringBuffer追加网关id
			buff.append("&gwid="+smsId);
	
			// 向StringBuffer追加手机号码
			buff.append("&mobile=" + mobileNo);
	
			// 向StringBuffer追加消息内容转URL标准码
			buff.append("&msg="+URLEncoder.encode(msg,"GBK"));
	
			// 创建url对象
			URL url = new URL(buff.toString());
	
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
	
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	
			// 返回发送结果
			String inputline = in.readLine();
			// 返回结果为‘100’ 发送成功
			// System.out.println(inputline);
			
			System.out.println("发送短信到："+mobileNo + ", 结果为：" + inputline );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int itemExist(List<EntityImpl> itemList, EntityImpl item){
		int ind = -1;
		
		for(int i=0; i< itemList.size();i++){
			if((int)itemList.get(i).getId() == (int)item.getId()){
				ind = i;
				break;
			}
		}
		return ind;
	}
	


	
}
