package com.founder.rhip.im.common;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.sql.Timestamp;

/**
 * JSON数据转换
 *
 * @author ye jianfei
 * @version 1.0 2016-03-01
 */
public class JSONConvertionUtil {

	/**
	 * 转换单个对象为JSON 字符串
	 *
	 * @param modelObject
	 * @return JSON数据格式为: {"K1":"V1","K2":"V2","...":"...", "Kn":"Vn"}
	 */
	public static String convetObjectToJSONString(Object modelObject) {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(Timestamp.class, new JsonValueProcessor());
		String modelOjbectData = JSONArray.fromObject(modelObject, cfg).toString();
		modelOjbectData = modelOjbectData.substring(1, modelOjbectData.length() - 1);
		return modelOjbectData;
	}
}
