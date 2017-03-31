package gov.cygs.service;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gov.cygs.dao.SWDBM;
import gov.cygs.entities.Companyreg;
import gov.cygs.swentities.TInsBusinessinfo;
import gov.cygs.swentities.TInsFormdata;
import gov.cygs.swentities.TInsLog;

public class SwitchService {
	@PersistenceContext(unitName = "eswitch")
	private EntityManager em;
	@EJB SWDBM dbm;
	public SwitchService() {
		// TODO Auto-generated constructor stub
	}

	public void createNewBuss(Companyreg creg){
		
		TInsBusinessinfo bussInfo = new TInsBusinessinfo();
		TInsFormdata formData = new TInsFormdata();
		TInsLog tlog = new TInsLog();
		
		String bsnum ="GSSL_"+String.valueOf((int)creg.getId());
		
		bussInfo.setApplytime(creg.getUpdtime()); //受理时间
		bussInfo.setAppname(creg.getCeoName()); //申请人姓名
		bussInfo.setAreaid("1-20");  //区划ID
		bussInfo.setAreaname(creg.getSpecial()); //区划名称
		bussInfo.setBjtype("6"); //办结类型，0–出证办结（正常产生证照、批文的办结） 1–退回办结（退回或驳回申请的办结） 2–作废办结（指业务处理上无效的纪录） 3–删除办结（指录入错误、操作错误等技术上的无效纪录） 4–转报办结（指转报其他单位或上级单位的办结情况） 5–补交不来办结（指出现补交告知时，通知之后，申请人长期不来补交材料的办结） 6–办结（除以上所述情况外的办结）
		bussInfo.setBsnum(bsnum); //业务流水号
		bussInfo.setDeptid("1-20"); //部门ID
		bussInfo.setDeptname(creg.getSpecial()); //部门名称
		bussInfo.setEndfortime(creg.getCapptime()); //办结时间
		bussInfo.setExchange("0");  //交换状态，0未交换，1已交换
		bussInfo.setIschange("0"); //是否收费，0否，1是
		bussInfo.setLimitdays(3); //承诺时限天数
		bussInfo.setLimitunit("G");  //承诺时限单位 G工作日 Z自然日
		bussInfo.setPermid("");  //事项ID
		bussInfo.setSfcz("1"); //是否出证，0否，1是
		bussInfo.setSfjljb("0"); //是否是即来即办，0否，1是
		bussInfo.setSsgzr("3");  //所剩工作日
		bussInfo.setStatus("0");   //0:在办1:办结2:作废3:补交挂起4:特别程序5:暂存6:已归档;
		bussInfo.setSxbh("1-20");  //大项编号
		bussInfo.setSxzxbh("1-20");  //小项编号
		bussInfo.setSxzxname("有限公司设立登记"); //事项小项名称
		bussInfo.setType("1"); //1通用审批 2网上大厅
		bussInfo.setXzxk("1"); //事项类型，1行政许可，2非行政许可，3公共服务，4其他事项
		
		formData.setBsnum(bsnum);
		formData.setCreatetime(creg.getUpdtime());
		formData.setDataid("");
		formData.setDataxml(creg.getAsXml(true, ""));
		formData.setExchange("0");
		
		tlog.setArrivetime(creg.getUpdtime()); //到达时间（环节开始时间）
		tlog.setBsnum(bsnum);
		tlog.setBstype("1"); //（类型）1.业务程序；2.特别程序
		tlog.setExchange("0");
		tlog.setHandler(creg.getJingshou());  // 处理人
		tlog.setHandletime(creg.getUpdtime());  //处理时间（环节结束时间）
		tlog.setIdea(""); //处理意见
		tlog.setLid(""); //主键ID
		tlog.setNexthandler(creg.getJingshou()); //下一处理人
		tlog.setNodename("网上预受理");  //审批环节名称（见附录A2）
		tlog.setNodetype("WSYSL");   //审批环节代码（见附录A2）
		tlog.setOperattype("9"); //操作类型，0网上申请，1正常环节，3退回，4删除办结，5异常办结， 6特别程序，7补交，8材料收取，9网上预审
		
		try {
			dbm.SaveObj(bussInfo);
			dbm.SaveObj(formData);
			dbm.SaveObj(tlog);
			int lid = tlog.getTid();
			int dataid = formData.getTid();
			formData.setDataid(String.valueOf(dataid));
			tlog.setLid(String.valueOf(lid));
			dbm.UpdateObj(formData);
			dbm.UpdateObj(tlog);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	public void updateBuss(Companyreg creg, String method){
		
		TInsBusinessinfo bussInfo = new TInsBusinessinfo();
		TInsFormdata formData = new TInsFormdata();
		TInsLog tlog = new TInsLog();
		
		String bsnum ="GSSL_"+String.valueOf((int)creg.getId());
		
		bussInfo = (TInsBusinessinfo) dbm.getObjectByCondition("TInsBusinessinfo", "bsnum='"+bsnum+"'");
		bussInfo.setExchange("0");
		if(method.equals("退回")){
			bussInfo.setStatus("3"); //0:在办1:办结2:作废3:补交挂起4:特别程序5:暂存6:已归档;
		}
		if(method.equals("预审通过")){
			bussInfo.setStatus("1"); //0:在办1:办结2:作废3:补交挂起4:特别程序5:暂存6:已归档;
			bussInfo.setBjtype("4"); //办结类型，0–出证办结（正常产生证照、批文的办结） 1–退回办结（退回或驳回申请的办结） 2–作废办结（指业务处理上无效的纪录） 3–删除办结（指录入错误、操作错误等技术上的无效纪录） 4–转报办结（指转报其他单位或上级单位的办结情况） 5–补交不来办结（指出现补交告知时，通知之后，申请人长期不来补交材料的办结） 6–办结（除以上所述情况外的办结）
		}
		
		formData = (TInsFormdata) dbm.getObjectByCondition("TInsFormdata", "bsnum='"+bsnum+"'");
		formData.setDataxml(creg.getAsXml(true, ""));
		formData.setExchange("");
		
		tlog.setArrivetime(creg.getUpdtime()); //到达时间（环节开始时间）
		tlog.setBsnum(bsnum);
		tlog.setBstype("1"); //（类型）1.业务程序；2.特别程序
		tlog.setExchange("0");
		tlog.setHandler(creg.getJingshou());  // 处理人
		tlog.setHandletime(creg.getUpdtime());  //处理时间（环节结束时间）
		
		String comments = creg.getComment1().trim()+""
				+ creg.getComment2().trim()+ ""
				+ creg.getComment3().trim()+ ""
				+ creg.getComment5().trim()+ ""
				+ creg.getComment6().trim()+ ""
				+ creg.getComment7().trim()+ ""
				+ creg.getComment8().trim()+ ""
				+ creg.getComment9().trim()+ ""
				+ creg.getComment10().trim()+ ""
				+ creg.getComment11().trim()+ ""
				+ creg.getComment12().trim()+ ""
				+ creg.getComment13().trim()+ "";
		
		tlog.setIdea(comments); //处理意见
		tlog.setLid(""); //主键ID
		tlog.setNexthandler(creg.getJingshou()); //下一处理人

		
		if(method.equals("退回")){
			tlog.setNodename("补交告知");  //审批环节名称（见附录A2）
			tlog.setNodetype("BJGZ");   //审批环节代码（见附录A2）
			tlog.setOperattype("7"); //操作类型，0网上申请，1正常环节，3退回，4删除办结，5异常办结， 6特别程序，7补交，8材料收取，9网上预审
		}
		if(method.equals("预审通过")){
			tlog.setNodename("办结");  //审批环节名称（见附录A2）
			tlog.setNodetype("BJ");   //审批环节代码（见附录A2）			
			tlog.setOperattype("1"); //操作类型，0网上申请，1正常环节，3退回，4删除办结，5异常办结， 6特别程序，7补交，8材料收取，9网上预审
		}
		
		try {
			dbm.UpdateObj(bussInfo);
			dbm.UpdateObj(formData);
			dbm.SaveObj(tlog);
			int lid = tlog.getTid();
			int dataid = formData.getTid();
			formData.setDataid(String.valueOf(dataid));
			tlog.setLid(String.valueOf(lid));
			dbm.UpdateObj(formData);
			dbm.UpdateObj(tlog);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	

}
