package com.founder.rhip.dm;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.founder.rhip.ehr.dto.ChronicFollowupInfo;

/**
 * 随访信息
 * 
 * 
 * @author liuk
 * 
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(namespace = "http://result.followup.dm.rhip.founder.com/")
public class FollowupInfoResult implements Serializable {

	private static final long serialVersionUID = -8915585393352958865L;

	private String code;// 编码

	private String message;// 详细

	private List<ChronicFollowupInfo> value;// 内容

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ChronicFollowupInfo> getValue() {
		return value;
	}

	public void setValue(List<ChronicFollowupInfo> value) {
		this.value = value;
	}

}
