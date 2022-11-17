package com.founder.rhip.cpw;

import com.founder.fasf.util.StringUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 返回结果
 * 
 * 
 * @version 1.0, 2014-7-3
 * @author Ye jianfei
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class CpwResult {
	public final static String SUCCESS = "2000";
	public final static String ERROR = "2001";
	/**
	 * 返回码
	 */
	private String code = "2000";
	
	
	/**
	 * 返回信息
	 */
	private String message="";
	
	

	public String toXml() {
		if(StringUtil.isNullOrEmpty(this.message)){
			this.message = "成功！";
		}
		String xml = "<root>"
				+ "<code>%1$s</code><message>%2$s</message>";

		xml += "</root>";
		return String.format(xml, code, message);
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
}
