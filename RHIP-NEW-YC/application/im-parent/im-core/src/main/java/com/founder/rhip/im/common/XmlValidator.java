package com.founder.rhip.im.common;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;

import com.founder.fasf.util.Assert;


/**
 * XML格式验证
 * @author GaoFei
 *
 */
public class XmlValidator {
	
	private static Logger log = Logger.getLogger(XmlValidator.class);
	
	private static Properties properties = PropertiesUtils.initProperties("config");

    /** 
     * 通过XSD（XML Schema）校验XML 
     */ 
    public static String validateXMLByXSD(String xml) {
    	Assert.notNull(properties);
    	String xsdFileName = XmlValidator.class.getResource(properties.getProperty("xml.schema.path")).getFile();
    	Assert.notNull(xsdFileName);
       return validate(xml, xsdFileName);
    } 
    
    /**
     * 通过XSD（XML Schema）校验XML 
     * @param xml xml字符串
     * @param xsdFileName xsd文件名称包含路径
     * @return
     */
    public static String validateXMLByXSD(String xml, String xsdFileName) {
    	return validate(xml, xsdFileName);
    } 
    
    /**
     * 验证XML
     * @param xml
     * @param xsdFileName
     * @return
     */
    private static String validate(String xml, String xsdFileName) {
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

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		XmlValidator.properties = properties;
	}
    
    
}
