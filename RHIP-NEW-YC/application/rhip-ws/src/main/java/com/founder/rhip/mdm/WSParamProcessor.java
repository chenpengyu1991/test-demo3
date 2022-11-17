package com.founder.rhip.mdm;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WSParamProcessor {

	private Logger log = LoggerFactory.getLogger(getClass());

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final String ITEM_PATH = "//item";

	private static final String VALUE_PATH = "//value";

	private static final String RETURN = "return";

	private static final String DESCRIPTION = "description";

	private static final String SUCCESS = "Success";
	private static final String ERROR = "Error";

	public Map<String, Object> parseRequest(String xml) throws Exception {
		Document doc = parseDocument(xml);
		if (doc == null) {
			return null;
		}
		Element root = doc.getRootElement();
		String[] rootName = root.getName().split("_");
		if (!"req".equals(rootName[0])) {
			log.error("请求报文XML根节点不规范");
			throw new Exception("根节点不规范");
		}
		Properties properties = getXpathProperties(root.getName());
		if (properties == null) {
			return null;
		}
		return parseDocToMap(doc, properties);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> parseRequestToList(String xml) throws Exception {
		Document doc = parseDocument(xml);
		if (doc == null) {
			return null;
		}
		Element root = doc.getRootElement();
		String[] rootName = root.getName().split("_");
		if (!"req".equals(rootName[0])) {
			log.error("请求报文XML根节点不规范");
			throw new Exception("根节点不规范");
		}
		Properties properties = getXpathProperties(root.getName());
		if (properties == null) {
			return null;
		}
		List<Node> items = doc.selectNodes("//item");
		List<Map<String, Object>> list = new ArrayList<>();
		for (Node item : items) {
			Map<String, Object> map = parseDocToMap(item, properties);
			if (ObjectUtil.isNotEmpty(map)) {
				list.add(map);
			}
		}
		return list;
	}

	public String createResponse(String templateName, Map<String, Object> returnValues) throws Exception {
		Document doc = createDocument(templateName);
		Properties properties = getXpathProperties(templateName);
		writeMapToDoc(doc, properties, returnValues);
		return doc.asXML();
	}

	@SuppressWarnings("unchecked")
	public String createResponse(String templateName, List<Map<String, Object>> returnValues) throws Exception {
		Document doc = createDocument(templateName);
		Properties properties = getXpathProperties(templateName);
		boolean hasValue = false;
		if (ObjectUtil.isNotEmpty(returnValues)) {
			hasValue = true;
		}
		Map<String, Object> head = new HashMap<>();
		head.put(RETURN, SUCCESS);
		if (hasValue) {
			writeMapToDoc(doc, properties, head);
			cloneItemNode(doc.selectSingleNode(VALUE_PATH), returnValues.size() - 1);
			List<Node> items = doc.selectNodes(ITEM_PATH);
			for (int i = 0; i < returnValues.size(); i++) {
				Node item = items.get(i);
				writeMapToDoc(item, properties, returnValues.get(i));
			}
		} else {
			head.put(DESCRIPTION, "没有找到数据");
			writeMapToDoc(doc, properties, head);
			removeValueNode(doc);
		}
		return doc.asXML();
	}

	public String errorResponse(String templateName, String errorMessage) {
		try {
			Document doc = createDocument(templateName);
			Properties properties = getXpathProperties(templateName);
			Map<String, Object> values = new HashMap<>();
			values.put(RETURN, ERROR);
			values.put(DESCRIPTION, errorMessage);
			writeMapToDoc(doc, properties, values);
            removeValueNode(doc);
			return doc.asXML();
		} catch (Exception e) {
			log.error("生成错误消息出错", e);
		}
		return null;
	}

	private Document parseDocument(String xmlStrs) throws Exception{
		Document doc = null;
		if (ObjectUtil.isNotEmpty(xmlStrs)) {
			SAXReader saxReader = new SAXReader();
			try {
				doc = saxReader.read(new ByteArrayInputStream(xmlStrs.getBytes("utf-8")));
			} catch (Exception e) {
				log.error("无法解析XML", e);
				throw e;
			}
		}
		return doc;
	}

	private Document createDocument(String fileName) {
		Document doc = null;
		if (ObjectUtil.isNotEmpty(fileName)) {
			SAXReader saxReader = new SAXReader();
			StringBuilder builder = new StringBuilder("./template/").append(fileName).append(".xml");
			URL url = getClass().getClassLoader().getResource(builder.toString());
			try {
				doc = saxReader.read(url);
			} catch (DocumentException e) {
				log.error("read file template occur error!", e);
			}
		}
		return doc;
	}

	private Properties getXpathProperties(String rootName) {
		String fileName = rootName.replace(':', '_');
		try {
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream("xpathProperties/" + fileName + ".properties"));
			return properties;
		} catch (Exception e) {
			log.error("Cannot read xpath properties file", e);
		}
		return null;
	}

	private Map<String, Object> parseDocToMap(Node node, Properties properties) throws Exception{
		Map<String, Object> map = new HashMap<>();
		Set<Object> keys = properties.keySet();
		for (Object key : keys) {
			String xpath = (String) properties.get(key);
			Node n = node.selectSingleNode(xpath);
			if (n == null) {
				continue;
			}
			String value = n.getText();
			Map<String, Object> keyValue = formatKeyValue((String) key, value);
			if (ObjectUtil.isNotEmpty(keyValue)) {
				map.putAll(keyValue);
			}
		}
		return map;
	}

	private void writeMapToDoc(Node node, Properties properties, Map<String, Object> values) throws Exception {
		try {
			Set<Object> keys = properties.keySet();
			for (Object key : keys) {
				String xpath = (String) properties.get(key);
				Object value = values.get((String) key);
				Node n = node.selectSingleNode(xpath);
				if (n == null || value == null) {
					continue;
				}
				n.setText(formatStringValue(value));
			}
		} catch (Exception e) {
			log.error("生成XML时出错", e);
			throw e;
		}
	}

	private Map<String, Object> formatKeyValue(String key, String value) throws Exception {
		if (StringUtil.isNullOrEmpty(key) || StringUtil.isNullOrEmpty(value)) {
			return null;
		}
		Map<String, Object> map = new HashMap<>();
		if (key.contains("@")) {
			String[] k = key.split("@");
			String field = k[0];
			if ("date".equals(k[1])) {
				try {
					SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
					Date date = df.parse(value);
					map.put(field, date);
				} catch (Exception e) {
					log.error("日期转换错误", e);
					throw e;
				}
			}
		} else {
			map.put(key, value);
		}
		return map;
	}

	private String formatStringValue(Object value) throws Exception {
		if (value == null) {
			return "";
		}
		if (value instanceof Date) {
			Date date = (Date) value;
			SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
			return df.format(date);
		} else if (value instanceof Integer) {
			return String.valueOf(value);
		} else if (value instanceof Double) {
			DecimalFormat df = new DecimalFormat("0.00");
			return df.format(value);
		}
		return (String) value;
	}

	@SuppressWarnings("unchecked")
	private void cloneItemNode(Node parentNode, int cloneCount) {
		Element parentEle = (Element) parentNode;
		Object itemO = parentNode.selectObject(ITEM_PATH);
		if (ObjectUtil.isNotEmpty(itemO)) {
			Element item = (Element) itemO;
			for (int i = 0; i < cloneCount; i++) {
				Element cloneItem = (Element) item.clone();
				List<Element> elements = parentEle.elements();
				elements.add(i, cloneItem);
			}
		}
	}

    private void removeValueNode(Document doc) {
	    Element value = (Element) doc.selectObject("//value");
	    doc.getRootElement().remove(value);
    }
}
