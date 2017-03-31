package gov.cygs.ejb;

import java.util.Enumeration;
import java.util.ResourceBundle;

import gov.cygs.entities.Config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SysConfig {
	
	private Config config;
	
	@PostConstruct
	public void init(){
		this.config = this.getSysConfig();
	}
	
	public SysConfig() {
		// TODO Auto-generated constructor stub
	}
	
	private Config getSysConfig() {
		// 获得资源包
		Config config = new Config();
		
		String propertyName="config";
		
		ResourceBundle rb = ResourceBundle.getBundle(propertyName.trim());
		// 通过资源包拿到所有的key
		Enumeration<String> allKey = rb.getKeys();
		
		// 遍历key 得到 value
		while (allKey.hasMoreElements()) {
			String key = allKey.nextElement().trim();
			String value = (String) rb.getString(key);
			switch (key){
				case "smsUser" :
					config.setSmsUser(value);
					break;
				case "smsPassword":
					config.setSmsPassword(value);
					break;
				case "smsId":
					config.setSmsId(value);
					break;
				case "sendSms":
					if(value.equals("true")){
						config.setSendSms(true);
					}
					else
					{
						config.setSendSms(false);
					}
					break;
				case "enpass":
					if(value.equals("true")){
						config.setEnpass(true);
					}
					else
					{
						config.setEnpass(false);
					}
					break;
			}
		}
		return config;
	}

	public Config getConfig() {
		return config;
	}
}
