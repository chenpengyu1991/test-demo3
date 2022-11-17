package com.founder.rhip.rd;

import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.dom4j.Document;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.entity.basic.RdRecord;
import com.founder.rhip.im.common.DocumentProcessor;
import com.founder.rhip.im.common.ImConstants;
import com.founder.rhip.im.common.PropertiesUtils;
import com.founder.rhip.im.common.ReflectionUtils;
import com.founder.rhip.im.common.XMLParser;
import com.founder.rhip.im.common.XmlValidator;
import com.founder.rhip.im.entity.medical.RdBedDistribution;
import com.founder.rhip.im.entity.medical.RdIncome;
import com.founder.rhip.im.entity.medical.RdInpatientAnalyse;
import com.founder.rhip.im.entity.medical.RdInpatientCompositive;
import com.founder.rhip.im.entity.medical.RdInspectionAnalyse;
import com.founder.rhip.im.entity.medical.RdMedicalQuality;
import com.founder.rhip.im.entity.medical.RdOutpatientAnalyse;
import com.founder.rhip.im.entity.medical.RdOutpatientCompositive;
import com.founder.rhip.im.service.ITransPortPersistenceService;
import com.founder.rhip.mdm.app.IOrganizationApp;


@Service("rdWebService")
@WebService(serviceName="rdWebService")
public class RdWebService extends BaseWebService implements IRdWebService {
	
	@Resource(name = "transPortPersistenceService")
	private ITransPortPersistenceService transPortPersistenceService;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	// 初始化配置
	private static Properties properties = PropertiesUtils.initProperties("im_config");

	@Override
	public String trans(String dataXML, String dataType) {
		if (ObjectUtil.isNullOrEmpty(dataType) || ObjectUtil.isNullOrEmpty(dataXML)) {
			return "500";
		}
		// 不区分大小写
		dataType = dataType.toUpperCase();
		// XML对应的Xpath配置
		Properties xpathProperties = PropertiesUtils.initProperties(properties.getProperty(dataType));
		// 解析XML转换为Document
		Document doc = DocumentProcessor.parseDocument(dataXML);
		String xsdFileName = getClass().getResource(properties.getProperty(new StringBuilder(dataType).append(".xsd").toString())).getFile();
		// schema验证文档结构和内容是否正确
		String validateRet = XmlValidator.validateXMLByXSD(dataXML, xsdFileName);
		if (ObjectUtil.isNotEmpty(validateRet)) {
			return validateRet;
		}
		Object o = parse(xpathProperties, doc, dataType);
		if (ObjectUtil.isNullOrEmpty(o)) {
			return "500";
		}
		RdRecord rdRecord = ReflectionUtils.wrapBean(RdRecord.class, o);
		if (ObjectUtil.isNullOrEmpty(rdRecord)) {
			return "500";
		}
		rdRecord.setMessage(dataXML);
		rdRecord.setDataType(dataType);
		if (ObjectUtil.isNotEmpty(validateRet)) {
			rdRecord.setCause(validateRet);
			rdRecord.setStatus(-1); // 失败状态
			transPortPersistenceService.record(rdRecord);
			return validateRet;
		}
		
		int ret = transPortPersistenceService.persistence(new ConvertingWrapDynaBean(o), dataType, dataXML);
		rdRecord.setStatus(ret);
		transPortPersistenceService.record(rdRecord);
		return (ret == 1 || ret == 2) ? "200" : "500";
	}
	
	/**
	 * 解析消息转换为对应的对象
	 * @param xpathProperties
	 * @param doc
	 * @param dataType
	 * @return
	 */
	private Object parse(Properties xpathProperties, Document doc, String dataType) {
		Object o = null;
		if (xpathProperties == null || xpathProperties.isEmpty() || doc == null || ObjectUtil.isNullOrEmpty(dataType)) {
			return o;
		}
		// 分类解析转换为对应的对象
		switch (dataType) {
		case ImConstants.M01: // 门急诊综合
			o = XMLParser.parse(RdOutpatientCompositive.class, doc, xpathProperties);
			break;
		case ImConstants.M02: // 门急诊费用分析
			o = XMLParser.parse(RdOutpatientAnalyse.class, doc, xpathProperties);
			break;
		case ImConstants.M03: // 住院综合
			o = XMLParser.parse(RdInpatientCompositive.class, doc, xpathProperties);
			break;
		case ImConstants.M04: // 出院病人费用分析
			o = XMLParser.parse(RdInpatientAnalyse.class, doc, xpathProperties);
			break;
		case ImConstants.M05: // 全院收入情况
			o = XMLParser.parse(RdIncome.class, doc, xpathProperties);
			break;
		case ImConstants.M06: // 医技检查分析
			o = XMLParser.parse(RdInspectionAnalyse.class, doc, xpathProperties);
			break;
		case ImConstants.M07: // 医疗质量与安全
			o = XMLParser.parse(RdMedicalQuality.class, doc, xpathProperties);
			break;
		case ImConstants.M08: // 床位分布
			o = XMLParser.parse(RdBedDistribution.class, doc, xpathProperties);
			break;
		default:
			break;
		}
		return o;
	}

}
