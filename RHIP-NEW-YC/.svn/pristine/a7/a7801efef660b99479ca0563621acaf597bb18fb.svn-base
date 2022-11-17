package com.founder.rhip.im.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;



public class DocumentProcessor {
	
	private static Logger log = Logger.getLogger(DocumentProcessor.class);

	private static Map<String, String> nameSpaceMap = new HashMap<String, String>();
	
	private static final String FILE_PATH = "config/";
	private static final String FILE_EXTENSION = ".xml";
	
	static {
		nameSpaceMap.put("ns", "urn:hl7-org:v3"); // XML 命名空间，在使用XPATH的时候需要处理下
		nameSpaceMap.put("ns2", "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0");// XDS.b 命名空间
		nameSpaceMap.put("ns3", "urn:ihe:iti:xds-b:2007");
	}
	
	/**
	 * 通过XML格式的字符串来创建文档
	 * @param xmlStrs
	 * @return Document
	 */
	public static Document parseDocument(String xmlStrs) {
		Document doc = null;
		if (StringUtils.isNotEmpty(xmlStrs)) {
			SAXReader saxReader = new SAXReader();
			saxReader.getDocumentFactory().setXPathNamespaceURIs(nameSpaceMap); // 设置XPath命名空间
			try {
				doc = saxReader.read(new ByteArrayInputStream(xmlStrs.getBytes("utf-8")));
			} catch (Exception e) {
				e.printStackTrace();
				log.error("parse message occur error!", e);
			}
		}
		return doc;
	}
	
	public static Document parseDocument(InputStream inputStream) {
		Document doc = null;
		if (inputStream != null) {
			SAXReader saxReader = new SAXReader();
			saxReader.getDocumentFactory().setXPathNamespaceURIs(nameSpaceMap); // 设置XPath命名空间
			try {
				doc = saxReader.read(inputStream);
			} catch (Exception e) {
				log.error("parse message occur error!", e);
			}
		}
		return doc;
	}
	
	
	/**
	 * 根据XML模版创建文档
	 * 
	 * @param fileName
	 * @return
	 */
	public static Document createDocument(String fileName) {
		Document doc = null;
		if (StringUtils.isNotEmpty(fileName)) {
			SAXReader saxReader = new SAXReader();
			saxReader.getDocumentFactory().setXPathNamespaceURIs(nameSpaceMap); // 设置XPath命名空间
			StringBuilder builder = new StringBuilder(FILE_PATH).append(fileName).append(FILE_EXTENSION);
			InputStream is = DocumentProcessor.class.getClassLoader().getResourceAsStream(builder.toString());
//			if(!ObjectUtil.isNotEmpty(is)){
//				builder = new StringBuilder(FILE_PATH).append("hip/").append(fileName).append(FILE_EXTENSION);
//			}
			is = DocumentProcessor.class.getClassLoader().getResourceAsStream(builder.toString());
			try {
				doc = saxReader.read(is);
			} catch (DocumentException e) {
				log.error("read file template occur error!", e);
			}
		}
		return doc;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Node> selectNodes(Properties properties, Class<?> clazz, Node node) {
		List<Node> nodes = new ArrayList<>();
		if (properties == null || clazz == null) {
			return nodes;
		}
		String key = new StringBuilder(StringUtils.substringAfterLast(clazz.getName(), ".")).append(ImConstants.SECTION_ITEM).toString();
		String xpath = properties.getProperty(key);
		if (StringUtils.isNotBlank(xpath)) {
			nodes = node.selectNodes(xpath);
		}
		return nodes;
	}
	
	public static Node selectSectionNode(Class<?> clazz, Document doc, Properties properties) {
		if (clazz == null || doc == null) {
			return null;
		}
		String key = new StringBuilder(StringUtils.substringAfterLast(clazz.getName(), ".")).append(ImConstants.SECTION).toString();
		String xpath = properties.getProperty(key);
		Node node = doc.selectSingleNode(xpath);
		if (node != null) {
			return node.getParent();
		}
		return null;
	}
	
	public static Node selectSingleNode(Properties properties, Class<?> clazz, Node node) {
		Node n = null;
		if (properties == null || properties.isEmpty() || clazz == null || node == null) {
			return node;
		}
		String key = new StringBuilder(StringUtils.substringAfterLast(clazz.getName(), ".")).append(ImConstants.SECTION_ITEM).toString();
		String xpath = properties.getProperty(key);
		if (StringUtils.isNotBlank(xpath)) {
			n = node.selectSingleNode(xpath);
		}
		return n;
	}
	
	@SuppressWarnings("unchecked")
	public static void cloneNode(int cloneCount, Node node, int positon) {
		if (cloneCount < 1 || node == null) {
			return;
		}
		Node parent = node.getParent();
		if (parent != null) {
			Element parentElement = (Element) parent;
			List<Element> elements = parentElement.elements();
			int index = elements.indexOf(node);
			for (int i = positon; i < cloneCount + positon; i++) {
				Node cloneNode = (Node) node.clone();
				elements.add(index+1, (Element) cloneNode); // 克隆的节点顺序为被克隆的节点+1
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void cloneNodeForXdsMessage(int cloneCount, Node node, int positon) {
		if (cloneCount < 1 || node == null) {
			return;
		}
		try {
			Node parent = node.getParent();
			if (parent != null) {
				Element parentElement = (Element) parent;
				List<Element> elements = parentElement.elements();
				for (int i = positon; i < cloneCount + positon; i++) {
					int index = i+1;
					Node cloneNode = (Node) node.clone();
					String xml = cloneNode.asXML().replaceAll("\\$doc1", "\\$doc"+index).replaceAll("\\$XDSDocumentEntry.uniqueId1", "\\$XDSDocumentEntry.uniqueId"+index);
					Document doc = DocumentHelper.parseText(xml);
					Element element = doc.getRootElement();
					elements.add(i, element);
				}
			}
		} catch (DocumentException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
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
	 * 验证市平台响应消息
	 * @param xml 返回的响应消息
	 * @return 是否通过
	 */
	public static boolean isValid(String xml) {
		if (ObjectUtil.isNullOrEmpty(xml)) {
			return false;
		}
		Document doc = parseDocument(xml);
		if (ObjectUtil.isNullOrEmpty(doc)) {
			return false;
		}
		String codeValue = readNodeValue(doc, ImConstants.CODE_PATH);
		return StringUtils.equals(codeValue, "200");
	}
	
	private static String convertTimeStyle(String time) {
		Date date = DateUtil.parseSimpleDate(time, ImConstants.CDA_TIME_STYLE);
		return DateUtil.getDateTime(ImConstants.DB_TIME_STYLE, date);
	}
	
	@SuppressWarnings("unused")
	private static String convertTimeColumn(String value) {
		StringBuilder sb = new StringBuilder("to_date('");
		sb.append(convertTimeStyle(value));
		sb.append("' , 'yyyy/MM/dd')");
		return sb.toString();
	}
	
}
