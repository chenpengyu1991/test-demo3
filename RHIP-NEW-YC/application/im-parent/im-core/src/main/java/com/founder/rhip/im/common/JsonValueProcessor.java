/**
 * 
 */
package com.founder.rhip.im.common;

import net.sf.json.JsonConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JavaBean Date 转换为 指定格式的字符串
 *
 * @author ye jianfei
 * @version 1.0 2016-03-01
 */
public class JsonValueProcessor implements net.sf.json.processors.JsonValueProcessor {

	private String format = "yyyy-MM-dd HH:mm:ss";

	public JsonValueProcessor() {
	}

	public JsonValueProcessor(String format) {
		this.format = format;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.sf.json.processors.JsonValueProcessor#processArrayValue(java.lang
	 * .Object, net.sf.json.JsonConfig)
	 */
	@Override
	public Object processArrayValue(Object value, JsonConfig arg1) {
		String[] obj = {};
		if (value instanceof Date[]) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date[] dates = (Date[]) value;
			obj = new String[dates.length];
			for (int i = 0; i < dates.length; i++) {
				obj[i] = sf.format(dates[i]);
			}
		}
		return obj;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.sf.json.processors.JsonValueProcessor#processObjectValue(java.lang
	 * .String, java.lang.Object, net.sf.json.JsonConfig)
	 */
	@Override
	public Object processObjectValue(String arg0, Object value, JsonConfig arg2) {
		if (value instanceof Date) {
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		} /*else if (value instanceof java.sql.Timestamp) {
			System.out.println("#**** 4");
			String str = new SimpleDateFormat(format).format((java.sql.Timestamp) value);
			return str;
		}*/
		return value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
