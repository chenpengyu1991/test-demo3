package com.founder.rhip.portal.service.util;

public class Constants {
	
	//用户账号能否登陆状态0:禁止1:开启
	public static final String USER_STATUS_DISABLE = "0";
	
	//用户预约功能开启状态0:禁止1:开启
	public static final String USER_RESERVESTATUS_DISABLE= "0";
	
	//预约短信发送开关key值
	public static final String PORTAL_RESERVE_SEND= "portal_reserve_send";
	
	//取消预约短信发送开关key值
	public static final String PORTAL_CANCEL_SEND= "portal_cancel_send";
	
	//可见预约时间的key值
  	public static final String PORTAL_RESERVE_VIEW_END_TIME= "portal_reserve_view_end_time";
  	
	//接口返回CODE值
	public static final String RESERVE_RET_CODE= "RET_CODE";
	
	//接口返回CODE值错误
	public static final String RET_CODE_ERROR= "0";
	
	//接口返回CODE值正确
	public static final String RET_CODE_CORRECT= "1";
	
	//接口返回值
	public static final String RESERVE_RET_MSG= "RET_MSG";

	//银川第一人民医院code
	public static final String FIRST_HOSPITAL= "45404097-1";

	//银川第二人民医院code
	public static final String SECOND_HOSPITAL= "45404098-X";

	//银川第三人民医院coden
	public static final String THIRD_HOSPITAL= "45404099-8";

	//银川妇幼保健院医院code
	public static final String MATERNAL_CHILD_HOSPITAL= "45404094-7";

	//银川口腔医院code
	public static final String STOMATOLOGICAL_HOSPITAL= "45404101-8";

	//银川中医医院code
	public static final String CHINESE_MEDICINE_HOSPITAL= "45404096-3";
	
	//银川第一人民医院,返回报文的Node
	public static final String NODE_FIRST_HOSPITAL= "//out";
	
	//银川妇幼保健院医院,返回报文的Node
	public static final String NODE_MATERNAL_CHILD_HOSPITAL= "//Interface_Trade_JkzlResult";
	
	
	//中医院的请求地址
	public static final String REQUEST_URL_CMH= "http://api.ihealthyun.com:6001/his/";
	
	//中医院查询科室请求路径
	public static final String QUERY_DEPTMENTS_URL_CMH= REQUEST_URL_CMH + "baseinfo/dept/00000004";
	
	//中医院查询医生信息请求路径
	public static final String QUERY_DOCTORS_URL_CMH= REQUEST_URL_CMH + "baseinfo/doctor/00000004/";
	
	//中医院查询预约请求路径
	public static final String QUERY_RESERVE_URL_CMH= REQUEST_URL_CMH + "reg/regtable/00000004/";
	
	//中医院保存预约请求路径
	public static final String SAVE_RESERVE_URL_CMH= REQUEST_URL_CMH + "reg/visit";
	
	//中医院取消预约请求路径
	public static final String CANCEL_RESERVE_URL_CMH= REQUEST_URL_CMH + "reg/cancel";

}
