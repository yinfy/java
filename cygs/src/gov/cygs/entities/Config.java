package gov.cygs.entities;

public class Config {

	private String smsUser;
	private String smsPassword;
	private String smsId;
	private boolean sendSms;
	private boolean enpass;
	
	public Config() {
		// TODO Auto-generated constructor stub
	}


	public String getSmsUser() {
		return smsUser;
	}


	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}


	public String getSmsPassword() {
		return smsPassword;
	}


	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}


	public String getSmsId() {
		return smsId;
	}


	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}


	public boolean isSendSms() {
		return sendSms;
	}


	public void setSendSms(boolean sendSms) {
		this.sendSms = sendSms;
	}


	public boolean isEnpass() {
		return enpass;
	}


	public void setEnpass(boolean enpass) {
		this.enpass = enpass;
	}

}
