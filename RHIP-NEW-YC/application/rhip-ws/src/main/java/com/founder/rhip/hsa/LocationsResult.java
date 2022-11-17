package com.founder.rhip.hsa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class LocationsResult {
	public final static String SUCCESS = "1";
	public final static String ERROR = "2";
	private String code="";
	private String message="";

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

	public String toXml() {
		return String.format(xml, code, message);
	}
	
	private static final String xml=
	"<?xml version=\"1.0\" encoding=\"UTF-8\"  ?>"+
	"<root>"+
	"    <code>%s</code>"+
	"    <message><![CDATA[%s]]></message>"+
	"</root>";
}
