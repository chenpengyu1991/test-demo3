package com.founder.rhip.ehr.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class JaxbUtils {
	private static Map<Class<?>, JAXBContext> jaxbCache = new HashMap<Class<?>, JAXBContext>(2);
	public static String marshal(Object bean, Class<?> clazz) {
		StringWriter writer = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			writer = new StringWriter();
			marshaller.marshal(bean, writer);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		} 
		return writer==null?null: writer.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(Class<?> clazz, String xml) {
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

}
