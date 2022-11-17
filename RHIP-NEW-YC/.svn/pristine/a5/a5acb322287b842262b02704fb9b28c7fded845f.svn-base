package com.founder.rhip.ehr.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.StringUtils;

/**
 * 格式化JAXB转换中时间格式
 * 
 * @author GaoFei
 *
 */
public class JaxbDateSerializer extends XmlAdapter<String, Date> {
	private static final String LONG_STYLE = "yyyy/MM/dd HH:mm:ss";
	private static final String MEDIUM_STYLE = "yyyy/MM/dd HH:mm";
	private static final String SHORT_STYLE = "yyyy/MM/dd";
	private SimpleDateFormat longDateFormat = new SimpleDateFormat(LONG_STYLE);
	private SimpleDateFormat mediumDateFormat = new SimpleDateFormat(MEDIUM_STYLE);
	private SimpleDateFormat shortDateFormat = new SimpleDateFormat(SHORT_STYLE); 
	  
    @Override  
    public String marshal(Date date) {
    	try {
    		return longDateFormat.format(date);   
		} catch (Exception e) {
			try {
				return mediumDateFormat.format(date);
			} catch (Exception e1) {
				return shortDateFormat.format(date);
			}
		}
    }   
  
    @Override  
    public Date unmarshal(String date) throws Exception {   
    	if (date == null) {
			return null;
		}
		if (date.indexOf("-") > 0) {
			date = date.replace("-","/");
		}
    	if (StringUtils.length(date) == StringUtils.length(LONG_STYLE)) {
			return longDateFormat.parse(date);
		} else if (StringUtils.length(date) == StringUtils.length(MEDIUM_STYLE)) {
			return mediumDateFormat.parse(date);
		} else if (StringUtils.length(date) == StringUtils.length(SHORT_STYLE)) {
			return shortDateFormat.parse(date);
		} 
        return null;
    } 
}
