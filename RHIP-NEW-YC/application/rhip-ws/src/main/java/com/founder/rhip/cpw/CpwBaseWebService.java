package com.founder.rhip.cpw;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

/**
 * 临床路径/病床使用情况webservice基类
 * 
 * 
 * @version 1.0, 2014-7-3
 * @author Ye jianfei
 */
public abstract class CpwBaseWebService extends BaseWebService {
	protected static Logger logger = Logger.getLogger(BaseWebService.class.getName());
	protected static Class<?>[] suppotClasses = {ClinicalPathway.class,SickbedUseState.class, CpwResult.class};	
	protected static Map<Class<?>, JAXBContext> jaxbCache = new HashMap<Class<?>, JAXBContext>(2);

	protected static Validator validator;

    //xml保存地址
	protected static String folder=null;
	public CpwBaseWebService(){
		init();
	}
	public static void init() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		if(ObjectUtil.isNullOrEmpty(jaxbCache)){
			try {
				for (Class<?> clazz : suppotClasses) {
					JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
					jaxbCache.put(clazz, jaxbContext);
				}
			} catch (JAXBException e) {
				logger.error("JAXBContext初始化失败", e);
				throw new RuntimeException(e);
			}
	
	        Properties properties = PropertiesUtils.initProperties("setting");
	        if (ObjectUtil.isNotEmpty(properties)) {
	            folder = properties.getProperty("cpw.data.folder");
	        }
		}
	}
	protected String marshal(Object bean) {
		StringWriter writer = null;
		try {
			Marshaller marshaller = jaxbCache.get(bean.getClass()).createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			writer = new StringWriter();
			marshaller.marshal(bean, writer);
		} catch (JAXBException e) {
			logger.error("JAXBContext初始化失败", e);
			throw new RuntimeException(e);
		} 
		return writer==null?null: writer.toString();
	}

	@SuppressWarnings("unchecked")
	protected <T> T parse(Class<?> clazz, String xml) {
		T message = null;
		StringReader reader = null;
		try {
			Unmarshaller um = jaxbCache.get(clazz).createUnmarshaller();
			reader = new StringReader(xml);
			message = (T) um.unmarshal(reader);
		} catch (Exception e) {
			throw new RuntimeException("xml解析失败", e);
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
		return message;
	}
	
	/**
	 * 检查身份证的格式
	 * 
	 * @param idcard
	 * @return
	 */
	protected boolean checkIdacrd(String idcard,CpwResult cicCardResult,String message) {
		boolean result = true;
		try {
			result = IDCardUtil.validateCard(idcard);
			if(!result){
				cicCardResult.setMessage(message + "格式非法。");
			}
		} catch (Exception e) {
			logger.error("验证身份证发生错误", e);
			result = false;
		}
		return result;
	}

	protected void save(String xml,String type){
        if(ObjectUtil.isNotEmpty(folder)){
            try {
                XmlWebserviceForUtil.saveDataFile(xml,type,folder);
            } catch (Exception e) {
                logger.error("数据保存失败:"+type,e);
            }
        }
    }
	
	/**
	 * 验证模型
	 *
	 * @param data
	 * @return
	 * @author Ye jianfei
	 */
	protected String  validateModel(Object data,String... properties){
		StringBuffer buffer = new StringBuffer();//用于存储验证后的错误信息
		Set<ConstraintViolation<Object>> constraintViolations;
		for(String property:properties){
			constraintViolations = validator.validateProperty(data,property);
			Iterator<ConstraintViolation<Object>> iter = constraintViolations.iterator();  
			while (iter.hasNext()) {  
				String message = iter.next().getMessage();  
				buffer.append(message);  
				buffer.append(";");
			}			
		}
		return buffer.toString();
	}
}
