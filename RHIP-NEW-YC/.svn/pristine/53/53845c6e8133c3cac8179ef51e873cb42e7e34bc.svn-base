/**   
* @Title: CompareUtil.java 
* @Package com.founder.rhip.portal.service.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author TODO 作者
* @date 2013-8-9 上午9:30:54 
* @version V1.0   
*/
package com.founder.rhip.portal.service.util;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.util.ObjectUtil;

/** 
 * @ClassName: CompareUtil 
 * @Description: 对象比较
 * @author LJY
 * @date 2013-8-9 上午9:30:54 
 *  
 */
public class CompareUtil {
	
	public static boolean doCompare(Object o1,Object o2,String ... propertes){
		ConvertingWrapDynaBean fromBean = new ConvertingWrapDynaBean(o1);
		ConvertingWrapDynaBean comBean = new ConvertingWrapDynaBean(o2);

		if(ObjectUtil.isNullOrEmpty(propertes)){
			return true;
		}
		
		for(String p:propertes){
			Object k1 = fromBean.get(p);
			Object k2 = comBean.get(p);
			
			if(!k1.equals(k2)){
				return false;
			}
		}
		
		return true;
	}
}
