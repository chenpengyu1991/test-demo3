package com.founder.rhip.cic;

/**
 * 请求类型
 * 
 * 
 * @version 1.0, 2014-5-7
 * @author Ye jianfei
 */
public class CicConstants {
	
	/**
	 * 黑名单增减标志：删除黑名单
	 */
	public static final String FLAG_DELETE = "0";

	/**
	 * 黑名单增减标志：增加黑名单
	 */
	public static final String FLAG_ADD = "1";
	
	/**
	 * 证件类型：身份证
	 */
	public static final String PAPERTYPE = "0";
	/**
	 * 日期格式
	 */
	public static final String FORMATER = "YYYMMDD";
	
	/**
	 * 健康数据查询：没有查询到数据
	 */
	public static final String HEALTH_FLAG_NONE = "0";
	
	/**
	 * 健康数据查询：数据没有变化
	 */
	public static final String HEALTH_FLAG_NOCHANGE = "1";
	
	/**
	 * 健康数据查询：查询成功
	 */
	public static final String HEALTH_FLAG_SUCCESS = "2";
	
	/**
	 * 市民卡写入失败
	 */
	public static final String WRITE_STATUS_FAIL = "0";
	
	/**
	 * 市民卡写入成功 
	 */
	public static final String WRITE_STATUS_SUCCESS = "1";
	/**
	 * 黑名单
	 */
	public static final String BLACKLIST = "R101";
	/**
	 * 发卡
	 */
	public static final String CREATE = "R102";
	/**
	 * 补卡
	 */
	public static final String REISSUE = "R103";
	/**
	 * 换卡
	 */
	public static final String CHANGE = "R104";
	
	/**
	 * 市民卡使用次数
	 */
	public static final String USE_COUNT = "R105";
	/**
	 * 基础健康数据查询
	 */
	public static final String HEALTH_DATA = "R106";
	
	/**
	 * 市民卡写入状态
	 */
	public static final String CARD_WRITE_STATUS = "R107";
}
