package gov.cygs.utils;

import gov.cygs.ejb.ConverterEJB;
import gov.cygs.entities.Dictionary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter("gov.cygs.ConValidator")
public class ConValidator implements Converter {
	private Map<String,Dictionary> dictMap;

	ConverterEJB cvejb;
	public ConValidator(){
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) {
		String fld=component.getId();
		String table="";
		String fldName="";
		if(fld.indexOf("filter")>=0){
			table = "Filter";
			fldName= "Filter";
		}else{
			table = fld.substring(0,fld.indexOf("_"));
			fldName= fld.substring(fld.indexOf("_")+1);
		}
		
		try {
			Context ctx = new InitialContext();
			cvejb=(ConverterEJB) ctx.lookup("java:module/ConverterEJB!gov.cygs.ejb.ConverterEJB");
			
		} catch (NamingException e) {
			throw new ConverterException( new FacesMessage("Converter Init error!"));
		}
		String fldType="string";  //默认值为 string, 在Dict没找到时，就按照string 取值
		try{
			this.dictMap=cvejb.getDictMap(table);		
			fldType=getFldType(fld).toLowerCase();
		}catch(Exception e){
			
		}
		Object obj;
		
		List<String> errorMsg=CheckInput(fld,str);
		if(!errorMsg.isEmpty()){
			FacesMessage message= new FacesMessage(errorMsg.toString());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(message);
		}

		try{
			switch(fldType){
				case "string":
				case "email":
				case "password":
				case "digital":
					obj= new String(str);
					break;
				case "double":
					obj= new Double(str);
					break;
				case "integer":
					obj= new Integer(str);
					break;
				case "float":
					obj= new Float(str);
					break;
				case "boolean":
					obj= new Boolean(str);
					break;
				case "datetime":
					SimpleDateFormat df=new SimpleDateFormat();
					obj=new Date();
					df.applyPattern("yyyy/MM/dd");
					obj= df.parse(str);
					break;
				default:
					obj=str;
			}
		}catch(Exception e){
			throw new ConverterException("Put value Failed!");
		}
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		String fld=component.getId();

		if(fld.indexOf("filter")>=0){
			fld= "Filter_Filter";
		}
		
		String table=fld.substring(0,fld.indexOf("_"));
		String fldName=fld.substring(fld.indexOf("_")+1);
		try {
			Context ctx = new InitialContext();
			cvejb=(ConverterEJB) ctx.lookup("java:module/ConverterEJB!gov.cygs.ejb.ConverterEJB");
			
		} catch (NamingException e) {
			throw new ConverterException( new FacesMessage("Converter Init error!"));
		}
		this.dictMap=cvejb.getDictMap(table);		
		String fldType=getFldType(fld).toLowerCase();
		String retstr=obj.toString();
		
		switch(fldType){
		case "string":
		case "email":
		case "password":
		case "digital":
		case "double":
		case "integer":
		case "float":
		case "boolean":
			break;
		case "datetime":
			SimpleDateFormat df=new SimpleDateFormat();
			df.applyPattern("yyyy/MM/dd");
			if(obj!=null) retstr=df.format(obj);
			break;
		}
		return retstr;
	}
	
	public List<String> CheckInput (String fld, String valueStr ){
		String key= fld; 	
		String table="";
		String fldName="";
		String fldDes="";
		
		if(fld.indexOf("filter")>=0){
			table = "Filter";
			fldName= "Filter";
			key= "Filter_Filter";
		}else{
			table = fld.substring(0,fld.indexOf("_"));
			fldName= fld.substring(fld.indexOf("_")+1);
		}		
		List<String> errorMsg = new ArrayList<String>();
		String regex="";
		
		Dictionary dic = dictMap.get(key);
		
		if(dic==null){
			return errorMsg;
		}
		String fldType= dic.getFldType().toLowerCase().trim();
		int fldLength=dic.getLength();
		int fldMinLength=dic.getMinLenth();
		String fldMinValue=dic.getMinValue();
		String fldMaxValue=dic.getMaxValue();
		boolean fldUnique= dic.getUnique();
		boolean fldEmpty= dic.getEmpty();
		fldDes= dic.getDescribe();

		try{
			
		//检查格式和长度
		switch(fldType){
		case "filter":
			regex="\\\\|\\?|\\\"";
			if(valueStr.matches(regex)){
				errorMsg.add(fldDes+"包含非法字符!");
			}
			if(valueStr.length()>fldLength){
				errorMsg.add(fldDes+"长度不能大于"+fldLength+"!");
			}
			if(fldMinLength>0 && valueStr.length()<fldMinLength ){
				errorMsg.add(fldDes+"长度不能小于"+fldMinLength+"!");
			}
			break;
		case "email":
			regex="^[a-z0-9A-Z]+[a-z0-9A-Z_\\-\\.]+[a-z0-9A-Z_\\-]+\\@([a-z0-9A-Z_\\-]+\\.)+[a-z0-9A-Z]+$|\\b*";
			if(!valueStr.matches(regex)){
				errorMsg.add(fldDes+"不是有效的电子邮件地址!");
			}
			if(valueStr.length()>fldLength){
				errorMsg.add(fldDes+"长度不能大于"+fldLength+"!");
			}
			break;
		case "string":
			if(valueStr.length()>fldLength){
				errorMsg.add(fldDes+"长度不能大于"+fldLength+"!");
			}
			if(fldMinLength>0 && valueStr.length()<fldMinLength && valueStr.trim().length()>0 ){
				errorMsg.add(fldDes+"长度不能小于"+fldMinLength+"!");
			}
			break;
		case "password":
			regex=".+[0-9]+.+";
			String regex2=".+[a-z]+.+";
			String regex3=".+[A-Z]+.+";
			if(!(valueStr.matches(regex) && valueStr.matches(regex2) && valueStr.matches(regex3))){
				errorMsg.add(fldDes+"不是有效的密码, 密码必须包含大写字母、小写字母和数字!");
			}
			if(valueStr.length()>fldLength){
				errorMsg.add(fldDes+"长度不能大于"+fldLength+"!");
			}
			if(fldMinLength>0 && valueStr.length()<fldMinLength){
				errorMsg.add(fldDes+"长度不能小于"+fldMinLength+"!");
			}
			break;
		case "datetime":
			SimpleDateFormat df=new SimpleDateFormat();
			df.applyPattern("yyyy/MM/dd");
			Date inputDate=new Date();
			try{
//				df=new SimpleDateFormat();
//				df.applyPattern("dd/MM/yyyy");
//				inputDate=new Date();
				inputDate=df.parse(valueStr);
			}catch( ParseException e ){
				errorMsg.add(fldDes+"不是有效的日期值!");
			}
			try{
				if(fldMinValue!=null&&!fldMinValue.trim().equals("")){
					Date minDate=new Date();
					minDate=df.parse(fldMinValue);
					if(inputDate.before(minDate)){
						errorMsg.add(fldDes+"日期不应该早于"+fldMinValue+"!");
					}
				}
				if(fldMaxValue!=null&&!fldMaxValue.trim().equals("")){
					Date maxDate=new Date();
					maxDate=df.parse(fldMaxValue);
					if(inputDate.after(maxDate)){
						errorMsg.add(fldDes+"日期不应该晚于"+fldMaxValue+"!");
					}
				}
			}catch(ParseException e ){
				errorMsg.add(fldDes+"日期格式错误!");
			}
			break;
		case "digital":
			regex="[0-9]*";
			if(!valueStr.matches(regex) ){
				errorMsg.add(fldDes+"不是有效的值, 只能输入数字!");
			}
			if(valueStr.length()>fldLength){
				errorMsg.add(fldDes+"长度不能大于"+fldLength+"!");
			}
			if(fldMinLength>0 && valueStr.length()<fldMinLength && valueStr.trim().length()>0){
				errorMsg.add(fldDes+"长度不能小于"+fldMinLength+"!");
			}
			break;
		case "double":
		case "float":
			regex="-?[0-9]+.?[0-9]{0,2}";
			if(!valueStr.matches(regex) ){
				errorMsg.add(fldDes+"不是有效的数字格式, 格式为：#########.##");
			}
			try{
				if(fldMinValue!=null&&!fldMinValue.trim().equals("")){
					if(Double.parseDouble(valueStr)<=Double.parseDouble(fldMinValue)){
						errorMsg.add(fldDes+"值必须大于"+fldMinValue+"!");
					}
				}
				if(fldMaxValue!=null&&!fldMaxValue.trim().equals("")){
					if(Double.parseDouble(valueStr)>Double.parseDouble(fldMaxValue)){
						errorMsg.add(fldDes+"值不能大于"+fldMaxValue+"!");
					}
				}
			}catch(NumberFormatException e ){
				errorMsg.add(fldDes+"不是有效的数字格式, 格式为：#########.##");
			}
			
			break;
		case "integer":
			regex="-?[0-9]+";
			if(!valueStr.matches(regex) ){
				errorMsg.add(fldDes+"不是有效的整数, 格式为：###########");
			}
			try{
				if(fldMinValue!=null&&!fldMinValue.trim().equals("")){
					if(Integer.parseInt(valueStr)<=Integer.parseInt(fldMinValue)){
						errorMsg.add(fldDes+"值必须大于"+fldMinValue+"!");
					}
				}
				if(fldMaxValue!=null&&!fldMaxValue.equals("")){
					if(Integer.parseInt(valueStr)>Integer.parseInt(fldMaxValue)){
						errorMsg.add(fldDes+"值不能大于"+fldMaxValue+"!");
					}
				}
			}catch( NumberFormatException e){
				errorMsg.add(fldDes+"不是有效的整数, 格式为：###########");
			}
			break;
		default:
		} // end of switch
		}catch(Exception e ){
			errorMsg.add(fldDes+"不是有效的数字格式!");
		}
		
		//检查为空
		try{
			if(!fldEmpty&&valueStr.trim().equals("")){
				errorMsg.add(fldDes+"不能为空!");
			}
		}catch(Exception e){
			errorMsg.add(fldDes+"空值检查错误!");
		}
		
		if(fldUnique){
			boolean pass = cvejb.CheckUnique(table, fldName, fldType, valueStr);
			if(!pass){
				errorMsg.add(fldDes+"字段值不能重复!");	
			}
			
		}

		return errorMsg;
	}
	
	

	public String getFldType(String key){
		String fldType="string";
		if(key.indexOf("filter")>=0){
			return "filter";
		}
		try{
			Dictionary dic = dictMap.get(key);
			fldType= dic.getFldType().toLowerCase().trim();
		}catch(Exception e){
			
		}
		return fldType;
	}
}
