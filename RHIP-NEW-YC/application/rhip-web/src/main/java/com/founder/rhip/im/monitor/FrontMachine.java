package com.founder.rhip.im.monitor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 前置机信息
 * @author 鹿存玉
 *
 */
public class FrontMachine {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static Map<String, String> machineMap = new HashMap<String, String>();
	/**
	 * 资源文件
	 */
	private String propName;
	
	public FrontMachine() {
	}

	public FrontMachine(String propName) {
		setPropName(propName);
	}

	
	/**
	 * 获取前置机IP地址
	 * 
	 * @param hostName
	 *            前置机名称
	 * @return
	 */
	public static String getHostAddress(String hostName){
		return machineMap.get(hostName);
	}
	

	@SuppressWarnings("rawtypes")
	protected Map<String, String> releaseProp(){
		Map<String, String> map = new HashMap<String, String>();
		Properties prop = new Properties();
		//获取文件的物理绝对路径
		try {
			String newFileName = this.getClass().getClassLoader().getResource(propName).toURI().getPath().replaceAll("%20", " ");
			prop.load(new FileInputStream(new File(newFileName)));
		} catch (Exception e) {
			log.error("读取前置机配置信息出错", e);
		}
		Enumeration keyEnum = prop.propertyNames();
		while (keyEnum.hasMoreElements()) {
			String key = (String) keyEnum.nextElement();
			map.put(key, prop.getProperty(key));
		}
		return map;
	}
	
	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
		machineMap = releaseProp();
	}

}
