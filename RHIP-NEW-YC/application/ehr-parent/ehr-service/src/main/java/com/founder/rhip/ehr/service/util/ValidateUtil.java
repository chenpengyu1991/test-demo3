/**   
* @Title: CompareUtil.java 
* @Package com.founder.rhip.portal.service.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author TODO 作者
* @date 2013-8-9 上午9:30:54 
* @version V1.0   
*/
package com.founder.rhip.ehr.service.util;

import net.sf.ehcache.hibernate.management.impl.BeanUtils;

import com.founder.fasf.util.ObjectUtil;


/** 
 * @ClassName: CompareUtil 
 * @Description: 对象比较
 * @author LJY
 * @date 2013-8-9 上午9:30:54 
 *  
 */
public class ValidateUtil {
	
	public static <T> String doValidate(T t,String ... propertes){
		if(ObjectUtil.isNullOrEmpty(propertes)){
			return null;
		}
		if(ObjectUtil.isNullOrEmpty(t)){
			return null;
		}
		String ret = null;
		
		for(String p:propertes){
			Object o = BeanUtils.getBeanProperty(t, p);
			if(ObjectUtil.isNullOrEmpty(o)){
				String newStr = p + "--不能为空";
				ret = addStr(ret,newStr);
			}
		}
		return ret;
	}
	
	private static String addStr(String ret,String newStr){
		if(ret == null){
			return newStr;
		}
		return ret + ";" + newStr;
	}
}
