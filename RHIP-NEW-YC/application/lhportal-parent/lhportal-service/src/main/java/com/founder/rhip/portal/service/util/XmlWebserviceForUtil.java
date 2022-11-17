/**   
* @Title: CompareUtil.java 
* @Package com.founder.rhip.portal.service.util 
* @Description: 处理XML的工具类
* @author LJY
* @date 2013-8-9 上午9:30:54 
* @version V1.0   
*/
package com.founder.rhip.portal.service.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.portal.dto.ErrorResult;
import com.founder.rhip.portal.dto.ReferralResult;

/** 
 * @ClassName: CompareUtil 
 * @Description: 对象比较
 * @author LJY
 * @date 2013-8-9 上午9:30:54 
 *  
 */
public class XmlWebserviceForUtil {
	protected static Logger logger = Logger.getLogger(XmlWebserviceForUtil.class.getName());
	
	/** 
	* @Title: getString 
	* @Description: 对象转为xml字符串
	* @param @param t
	* @param @return
	* @param @throws Exception
	* @return String
	* @throws 
	*/
	public static <T> String getString(T t,Class<T> clz){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clz);
			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(t, baos);
			String str = new String(baos.toByteArray(),"UTF-8");
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String returnResult(String code, String message){
		ReferralResult returnResult = new ReferralResult();
		returnResult.setRtnCode(code);
		returnResult.setRtnMessage(message);
		try {
			return getString(returnResult,ReferralResult.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static String returnError(String e){
		ErrorResult errorResult = new ErrorResult();
		errorResult.setErrorString(e);
		
		try {
			return getString(errorResult,ErrorResult.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T parseDataXml(String dataXml, Class<T> clazz) throws JAXBException, UnsupportedEncodingException {
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(clazz)) {
			return null;
		}
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller um = context.createUnmarshaller();
		T t = (T) um.unmarshal(new ByteArrayInputStream(dataXml.getBytes("UTF-8")));
		return t;
	}
	
	
	/**
	 * 保存妇幼保健数据文件XML到指定的磁盘目录
	 * 
	 * @param dataXml 妇幼保健数据XML格式
	 * @param dataType 妇幼数据类型
	 */
	public static void saveDataFile(String dataXml, String dataType,String folder) {
		if (ObjectUtil.isNotEmpty(folder)) {
			StringBuilder sb = new StringBuilder(folder).append(dataType).append(File.separator).append(DateUtil.toFormatString("yyyyMMdd", new Date())).append(File.separator);
			File file = new File(sb.toString());
			if (!file.exists()) {
				file.mkdirs();
			}
			String time = DateUtil.toFormatString("yyyyMMddHHmmss", new Date());
			StringBuilder nb = new StringBuilder(time).append(".xml");
			File f = new File(file, nb.toString());
			InputStream in = null;
			OutputStream os = null;
			try {
				in = new ByteArrayInputStream(dataXml.getBytes("UTF-8"));
				os = new FileOutputStream(f);
				int len = 0;
				byte buffer[] = new byte[3 * 1024];
				while ((len = in.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (os != null) {
						os.close();
					}
				} catch (IOException e) {
				}
			}
		}
	}
	
	/**
	 * 传入的Sting Xml对象转换成文档
	 * @param xml
	 * @return document对象
	 */
	public static Document parseDocument(String xml){
		Document doc = null;
		if(StringUtil.isNotEmpty(xml)){
			SAXReader saxReader = new SAXReader();
			try {
				doc = saxReader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));
			} catch (Exception e) {
				logger.error("parse message occur error!",e);
			}
		}
		return doc;
	}
}
