package com.founder.rhip.cic;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 发卡管理返回结果
 * 
 * 
 * @version 1.0, 2014-5-7
 * @author Ye jianfei
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class CicResult {
	public final static String SUCCESS = "2000";
	public final static String ERROR = "2001";
	/**
	 * 返回码
	 */
	private String code = "2000";
	
	/**
	 * 交易码
	 */
	private String transcode;
	
	/**
	 * 返回信息
	 */
	private String message="";
	
	/**
	 * 系统处理码
	 */
	private String rtncode = "0";
	
	/**
	 * 
	 */
	private Integer rtnrst = null;

	public String toXml() {
		if(StringUtil.isNullOrEmpty(this.message)){
			this.message = "成功！";
		}
		String xml = "<root>"
				+ "<code>%1$s</code>"
				+ "<transcode>%2$s</transcode>"
				+ "<message>%3$s</message>"
				+ "<rtncode>%4$s</rtncode>";
		if(ObjectUtil.isNotEmpty(rtnrst)){
			xml += "<rtnrst>%5$s</rtnrst>";
		}
		xml += "</root>";
		return String.format(xml, code,transcode, message,rtncode,rtnrst);
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.code = ERROR;
		this.message += message;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public String getRtncode() {
		return this.rtncode;
	}

	public void setRtncode(String rtncode) {
		this.rtncode = rtncode;
	}

	public Integer getRtnrst() {
		return rtnrst;
	}

	public void setRtnrst(Integer rtnrst) {
		this.rtnrst = rtnrst;
	}
}
