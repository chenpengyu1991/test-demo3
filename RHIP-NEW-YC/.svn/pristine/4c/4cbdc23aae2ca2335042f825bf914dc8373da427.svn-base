package com.founder.rhip.im.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.im.entity.report.ReportDefine;
import com.founder.rhip.im.repository.IReportDao;
import com.founder.rhip.im.repository.basic.IRdTargetIndexDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("imReportService")
public class ReportServiceImpl implements IReportService{

	protected static Logger logger = Logger.getLogger(ReportServiceImpl.class.getName());

	@Resource(name = "reportDao")
	private IReportDao reportDao;

	private String originalFilePath = "";
	private Class<?>[] suppotClasses = {ReportDefine.class};
	private Map<Class<?>, JAXBContext> jaxbCache = new HashMap<Class<?>, JAXBContext>(2);

	private static final String REPORT_DEFINE_PATH = "/reportDefine";

	/**
	 * 构造函数，初始化
	 */
//	public ReportServiceImpl(){
//		if(ObjectUtil.isNullOrEmpty(jaxbCache)){
//			try {
//				for (Class<?> clazz : suppotClasses) {
//					JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
//					jaxbCache.put(clazz, jaxbContext);
//				}
//			} catch (JAXBException e) {
//				logger.error("JAXBContext初始化失败", e);
//				throw new RuntimeException(e);
//			}
//			//取得报表绝对路径
//			originalFilePath = this.getClass().getResource(REPORT_DEFINE_PATH).getPath();
//		}
//	}

	@Override
	public ReportDefine getReportDefine(String reportType) {
		ReportDefine reportDefine = null;
		File file = new File(originalFilePath + File.separator +reportType + ".xml");
		if(ObjectUtil.isNotEmpty(file)){
			reportDefine = parse(file);
		}
		return reportDefine;
	}

	@Override
	public List<Map<String, Object>> getReportList(Criteria ca, String sqlDefine) {
		return reportDao.getReportList(ca,sqlDefine);
	}

	/**
	 * 解析XML
	 * @param xmlFile
	 * @return
     */
	private ReportDefine parse(File xmlFile) {
		ReportDefine reportDefine = null;
		StringReader reader = null;
		try {
			Unmarshaller um = jaxbCache.get(ReportDefine.class).createUnmarshaller();
			reportDefine = (ReportDefine) um.unmarshal(xmlFile);
		} catch (Exception e) {
			throw new RuntimeException("xml解析失败", e);
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
		return reportDefine;
	}
}