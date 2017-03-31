package gov.cygs.entities;

import gov.cygs.utils.Utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityImpl implements EntityInterface {

	protected int id;
	
	protected String uuid;
	
	protected String capprove;
	
	protected String jingshou;
	
	protected Date capptime;
	
	protected String prefix;
	
	protected String special;
	
	protected String transport;
	
	protected String cname;
	
	protected String entityName;
	
	protected String ceoName;
	
	protected String taskType;
	
	public EntityImpl()   {
		// TODO Auto-generated constructor stub
	}
	
	public Object getField(String fieldName) {
		try {
			Object fld = this.getClass().getDeclaredField(fieldName);
			return fld;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//去除String类型字段的前后空格。
	public void reFormat(){  
		try{
			Field[] fields  = this.getClass().getDeclaredFields();
			for(Field fld:fields){
				String type =fld.getType().toString();
				type = type.substring(type.lastIndexOf(".")+1);
				if(fld.get(this)==null){
					continue;
				}
				if(type.equals("String")){
					String strValue = (String) fld.get(this);
					if(strValue!=null){
						strValue = strValue.trim();
						fld.set(this, strValue);
					}
				}
			}
		}catch(Exception e){
			return;
		}
	}
	

	@Override
	public String getFieldAsString(String fieldName, String classes) {
		String strvalue = "null";
		try {
			Field fld =this.getClass().getDeclaredField(fieldName);
			String type =fld.getType().toString();
			type = type.substring(type.lastIndexOf(".")+1);
			
			if(fld.get(this)==null){
				return "null";
			}
			
			switch(type.toString()){
				case "String" :
					strvalue = (String) fld.get(this);
					break;
				case "long":
				case "int":
				case "float":
				case "double":
					strvalue = String.valueOf(fld.get(this));
					break;
				case "boolean":
					strvalue = (boolean)fld.get(this)?"1":"0";
					break;
				case "Date":
					strvalue=Utils.formatDate((Date) fld.get(this),"yyyy/MM/dd");
					break;
				case "List":
					List<EntityInterface> listObj =(List)fld.get(this);
					strvalue = "\n\t";
					for(EntityInterface obj:listObj){
						String classname = obj.getClass().getName();
						classname =classname.substring(classname.lastIndexOf(".")+1);
						strvalue +="<"+classname+">\n\t";						
						strvalue += obj.getAsXml(false,classes);
						strvalue +="</"+classname+">\n\t";
					}
					break;
				case "Set":
					Set<EntityInterface> setObj =(Set)fld.get(this);
					strvalue = "\n\t";
					for(EntityInterface obj:setObj){
						String classname = obj.getClass().getName();
						classname =classname.substring(classname.lastIndexOf(".")+1);
						strvalue +="<"+classname+">\n\t";
						strvalue += obj.getAsXml(false,classes);
						strvalue +="</"+classname+">\n\t";
					}
					break;
				default:
					//strvalue=String.valueOf(((int)((EntityInterface)fld.get(this)).getId()));
					//strvalue="";
					String classname = fld.getType().getName();
					int pos = classes.indexOf(classname);
					if(pos<0){
						strvalue=((EntityInterface)fld.get(this)).getAsXml(false,classes);
					}else{
						strvalue="no tags";
					}
			}
			return strvalue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}
	
	@Override
	public String getAsXml(boolean hasHead, String classes){
		String xmlString = "";
		if(hasHead){
			xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\t<data>\n\t";
		}
		Field[] fldSet = this.getClass().getDeclaredFields();
		String lclasses = this.getClass().getName();
		if(classes.indexOf(lclasses)<0){
			classes= classes+","+lclasses;
		}
		
		for(int i= 0; i<fldSet.length; i++){
			Field fld = fldSet[i];
			String fldName = fld.getName();
			if(fldName.equals("serialVersionUID") || fldName.equals("MAXROW") ){
				continue;
			}
			
			String fldValue = this.getFieldAsString(fldName, classes);
			if(fldValue.equals("no tags")){
				xmlString += "";
			}else{
				xmlString += "<" ;
				xmlString += fldName;
				xmlString += ">" ;
				xmlString += fldValue;
				xmlString += "</" ;
				xmlString += fldName;
				xmlString += ">\n\t" ;
			}
		}
		if(hasHead){
			xmlString += "</data>";
		}
	
		return xmlString;
		
	}

	@Override
	public Object getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCapprove() {
		return capprove;
	}

	public void setCapprove(String capprove) {
		this.capprove = capprove;
	}

	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}

	public Date getCapptime() {
		return capptime;
	}

	public void setCapptime(Date capptime) {
		this.capptime = capptime;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
}
