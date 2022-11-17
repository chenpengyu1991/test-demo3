package com.founder.rhip.ehr.common;

import com.founder.fasf.util.ObjectUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.ui.ModelMap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 用于向前台返回JSON对象 By Liu jingyin
 */
public class EHRMessageUtil {

	private static final Class<?>[] clzArray = { String.class, Integer.class, Byte.class,
		Long.class, Double.class, Float.class, Character.class,
		Short.class, BigDecimal.class, BigInteger.class, Boolean.class,
		Date.class};
	
	//返回JSON信息
	public static final String MSG_KEY = "msgVo";
	public static final String MSG_PAGE = "rhip.ehr.msg";
	

	/**
	 * 将对象类型的返回到前台
	 * 
	 * @param model
	 * @param t
	 * @return
	 */
	public static <T> String returnMsg(ModelMap model, T t) {
		model.addAttribute(MSG_KEY, toJsonString(t));
		return MSG_PAGE;
	}
	
	
	/**
	 * 返回字符串
	 * 基础类型直接toString
	 * @param t
	 * @return
	 */
	private static <T> String toJsonString(T t) {
		for(Class<?> clz :clzArray){
			if(t.getClass().equals(clz)){
				return t.toString();
			}
		}
		if (ObjectUtil.isArray(t)||ObjectUtil.isCollection(t)) {
			return	JSONArray.fromObject(t).toString();
		}
		JSONObject jsonObject = JSONObject.fromObject(t);
		return jsonObject.toString();
	}
}