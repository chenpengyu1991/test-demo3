package com.founder.rhip.im.common;



import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;

public class XMLParser {

	private static Logger log = Logger.getLogger(XMLParser.class);
	private XMLParser(){
		
	}
	
	public static Node getXpathNode(String xml, String path) throws Exception, DocumentException{
		
		Document doc = DocumentProcessor.parseDocument(xml);
		
		return doc.selectSingleNode(path);
	}
	
	public static String getNodeAttributeValue(Node node ,String attributeName){
		
		Element e = (Element)node;
		
		Attribute attr = e.attribute(attributeName);
		
		return attr.getText();
	}
	
	/**
	 * 解析CDA文档章节(文档header部分、文档体各章节,文档体各章节为单一条目)
	 * @param clazz
	 * @param node
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parse(Class<T> clazz, Node node, Properties properties) {
		T t = null;
		if (ObjectUtil.isNullOrEmpty(clazz) || ObjectUtil.isNullOrEmpty(node) || ObjectUtil.isNullOrEmpty(properties) || properties.isEmpty()) {
			return t;
		}
		
		ClassMetadata cmd = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> linkedHashMap = cmd.getProperty();
		
		//实例化对象
		t = (T) ReflectionUtils.createInstance(clazz);
		
		// 以实体对象创建动态Bean
    	ConvertingWrapDynaBean dynaBean = new ConvertingWrapDynaBean(t);
		
		for (Iterator<String> it = linkedHashMap.keySet().iterator(); it.hasNext();) {
			//引用类中属性名称
			String field = it.next();
			PropertyMetadata md = linkedHashMap.get(field);
			if (StringUtils.equalsIgnoreCase(field, "serialVersionUID") || ObjectUtil.isNullOrEmpty(md)) {
				continue;
			}
			
			//引用类中属性对应的类型/
			Class<?> fieldClass = md.getFieldClass();
			String xpath = null;
			if (ObjectUtil.isNullOrEmpty(field) || ObjectUtil.isNullOrEmpty(xpath = properties.getProperty(field))) {
				continue;
			}
		
			// 读取CDA文档对应节点的值
			String value = StringUtils.trim(readNodeValue(node, xpath));
			
			if (StringUtils.isBlank(value)) {
				continue;
			}
			dynaBean.set(field, convertObjectActualValue(value, fieldClass));
		}
		return t;
	}
	
	/**
	 * 解析CDA文档体章节(章节中包含循环的条目)
	 * @param clazz
	 * @param node
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> parseMultiEntry(Class<T> clazz, Node node, Properties properties) {
		List<T> list = new ArrayList<>();
		if (node == null || clazz == null || properties == null || properties.isEmpty()) {
			return list;
		}
		List<Node> nodes = new ArrayList<>();
		String key = new StringBuilder(StringUtils.substringAfterLast(clazz.getName(), ".")).append(".section.item").toString();
		String xpath = properties.getProperty(key);
		if (StringUtils.isBlank(xpath) || ObjectUtil.isNullOrEmpty(nodes = node.selectNodes(xpath))) {
			return list;
		}
		for (Node n : nodes) {
			T t = parse(clazz, n, properties);
			list.add(t);
		}
		return list;
	}
	
	
	
	/**
	 * 读取对应节点值
	 * @param node
	 * @param xpath
	 * @return
	 */
	public static String readNodeValue(Node node, String xpath) {
		String result = null;
		if (node != null && StringUtils.isNotEmpty(xpath)) {
			Node n = node.selectSingleNode(xpath);
			if (n != null) {
				result = n.getText();
			}
		}
		return result;
	}
	
	/**
	 * 转换对象为实际类型
	 * @param value
	 * @param clazz
	 * @return
	 */
	private static Object convertObjectActualValue(String value, Class<?> clazz) {
		Object o = null;
		if (ObjectUtil.isNotEmpty(value) && ObjectUtil.isNotEmpty(clazz)) {
			String name = clazz.getName();
			if (StringUtils.equals(name, Integer.class.getName())) {
				o = Integer.valueOf(value);
			} else if (StringUtils.equals(name, Float.class.getName())) {
				o = Float.valueOf(value);
			} else if (StringUtils.equals(name, Long.class.getName())) {
				o = Long.valueOf(value);
			} else if (StringUtils.equals(name, Date.class.getName())) {
				if (value.length() == 7) { // 日期格式：yyyy-MM
					o = convertDateStringToDate(value, "yyyy-MM");
				} else if (value.length() == 10) { // 日期格式：yyyy-MM-dd
					o = convertDateStringToDate(value, "yyyy-MM-dd");
				} else {
					o = value;
				}
			} else if (StringUtils.equals(name, BigDecimal.class.getName())) {
				o = convertStringToBigDecimal(value);
			} else {
				o = value;
			}
		}
		return o;
	}
	
	private static Date convertDateStringToDate(String strDate, String timeStyle) {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
	
		timeStyle = StringUtils.isBlank(timeStyle) ? "yyyy-MM-dd" : timeStyle;
		SimpleDateFormat df = new SimpleDateFormat(timeStyle);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static BigDecimal convertStringToBigDecimal(String value) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Document convertXmlString(String xml) {
		Document doc = null;
		if (StringUtils.isNotEmpty(xml)) {
			SAXReader saxReader = new SAXReader();
			try {
				doc = saxReader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
	
	 /**
     * 验证XML
     * @param xml
     * @param xsdFileName
     * @return
     */
    public static String validate(String xml, String xsdFileName) {
    	Assert.notNull(xml);
    	Assert.notNull(xsdFileName);
    	 try { 
             //创建默认的XML错误处理器 
             XMLErrorHandler errorHandler = new XMLErrorHandler(); 
             //获取基于 SAX 的解析器的实例 
             SAXParserFactory factory = SAXParserFactory.newInstance(); 
             //解析器在解析时验证 XML 内容。 
             factory.setValidating(true); 
             //指定由此代码生成的解析器将提供对 XML 名称空间的支持。 
             factory.setNamespaceAware(true); 
             //使用当前配置的工厂参数创建 SAXParser 的一个新实例。 
             SAXParser parser = factory.newSAXParser(); 
             //创建一个读取工具 
             SAXReader xmlReader = new SAXReader(); 
             //获取要校验xml文档实例 
             Document xmlDocument = (Document) xmlReader.read(new ByteArrayInputStream(xml.getBytes("utf-8"))); 
             //设置 XMLReader 的基础实现中的特定属性。核心功能和属性列表可以在 [url]http://sax.sourceforge.net/?selected=get-set[/url] 中找到。 
             parser.setProperty( 
                     "http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
                     "http://www.w3.org/2001/XMLSchema"); 
             parser.setProperty( 
                     "http://java.sun.com/xml/jaxp/properties/schemaSource", 
                     "file:" + xsdFileName); 
             //创建一个SAXValidator校验工具，并设置校验工具的属性 
             SAXValidator validator = new SAXValidator(parser.getXMLReader()); 
             //设置校验工具的错误处理器，当发生错误时，可以从处理器对象中得到错误信息。 
             validator.setErrorHandler(errorHandler); 
             //校验 
             validator.validate(xmlDocument); 

             XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint()); 
             //如果错误信息不为空，说明校验失败，打印错误信息 
             if (errorHandler.getErrors().hasContent()) { 
                 log.warn("XML文件通过XSD文件校验失败！"); 
                 writer.write(errorHandler.getErrors());
                 log.error(errorHandler.getErrors().asXML());
                 return errorHandler.getErrors().asXML();
             } else { 
             	log.info("XML文件通过XSD文件校验成功！");
             	return "";
             } 
         } catch (Exception ex) { 
             log.error("XML文件: " + xsdFileName + " 通过XSD文件:" + xsdFileName + "检验失败。\n原因： " + ex.getMessage()); 
             ex.printStackTrace(); 
             return ex.getMessage();
         } 
    }
	
	public static void main (String[] args){
		String xml = "<?xml version='1.0' encoding='UTF-8'?><ClinicalDocument xmlns='urn:hl7-org:v3' xmlns:mif='urn:hl7-org:v3/mif'  xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='urn:hl7-org:v3 ..\\sdschemas\\CDA.xsd'><code code='HSDB04.02' codeSystem='2.16.156.10011.2.4' codeSystemName='卫生信息共享文档规范编码体系'/></ClinicalDocument> ";
//		String xml = "<?xml version='1.0' encoding='UTF-8'?><ClinicalDocument><code code='HSDB04.02' codeSystem='2.16.156.10011.2.4' codeSystemName='卫生信息共享文档规范编码体系'/></ClinicalDocument> ";
		try {
			Node node = XMLParser.getXpathNode(xml, "/ClinicalDocument/code");
			System.out.println(node);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
