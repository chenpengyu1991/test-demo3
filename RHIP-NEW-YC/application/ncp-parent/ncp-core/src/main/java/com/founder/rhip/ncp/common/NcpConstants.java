package com.founder.rhip.ncp.common;

/**
 * 卫生综合管理信息系统定义的一些常量
 * 
 * @author yejianfei
 * 
 */
public class NcpConstants {
	/**
	 * 监测/复查/随访/
	 * 1:监测,2:复查,3:随访
	 */
	public static final String NCP_MONITOR_TYPE_1 = "1";
	public static final String NCP_MONITOR_TYPE_2 = "2";
	public static final String NCP_MONITOR_TYPE_3 = "3";

	/**
	 * 快速查询
	 * 1:本日待监测,2:满2周待复查,3:待追踪随访
	 */
	public static final String QUICK_SEARCH_TYPE_1 = "1";
	public static final String QUICK_SEARCH_TYPE_2 = "2";
	public static final String QUICK_SEARCH_TYPE_3 = "3";
	//复查状态1:已复查
	public static final String REEXAM_STATUS_1 = "1";

	//出院天数
	public static final String CYTS_1 = "1";//小于2周
	public static final String CYTS_2 = "2";//满2周
	public static final String CYTS_3 = "3";//大于2周

	public static final Integer SYMPTOMFLAG_2 = 2;//有症状

}
