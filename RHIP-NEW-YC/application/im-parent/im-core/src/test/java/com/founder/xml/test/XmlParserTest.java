package com.founder.xml.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;
import com.founder.rhip.im.entity.medical.RdOutpatientCompositive;



public class XmlParserTest {
	
	@Test
	public void parseTest() throws JAXBException, UnsupportedEncodingException {
	/*	JAXBContext context = JAXBContext.newInstance(BirthCertificate.class);
		Unmarshaller um = context.createUnmarshaller();
		BirthCertificate birthCertificate = (BirthCertificate) um.unmarshal(new File("E:\\Test\\CERTIFICATE.xml"));
		Assert.assertNotNull(birthCertificate);*/
		//File file = new File("E:\\Test\\WH_POSTPARTUM_DAYS_HEALTH_INFO.xml");
		
		JAXBContext context = JAXBContext.newInstance(RdOutpatientCompositive.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		RdOutpatientCompositive rdOutpatientCompositive = new RdOutpatientCompositive();
		rdOutpatientCompositive.setOrganCode("320003282");
		rdOutpatientCompositive.setOrganName("梅李人民医院");
		rdOutpatientCompositive.setGbCode("320000000");
		rdOutpatientCompositive.setCenterCode("320003282");
		
		//jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		jaxbMarshaller.marshal(rdOutpatientCompositive, bos);
		String str = new String(bos.toByteArray(), "UTF-8");
		System.out.println(str);
		//jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
	}
	
	public void whchDataTest() throws Exception {
		// 初始化配置文件
		InputStream in = XmlParserTest.class.getClassLoader().getResourceAsStream("config/出生医学证明.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:config/applicationContext.xml");
//		IWhchService whchService = (IWhchService) context.getBean("whchService");
		String dataXml = convertInputStreamToString(in);
		Map<String, Long[]> map = new HashMap<String, Long[]>();
//		int ret = whchService.saveWhchInfo(dataXml, DataType.C01.getType(), map);
//		Assert.assertEquals(true, ret > 0);
	}
	
	
	private String convertInputStreamToString(InputStream in) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		int i = -1;
		while ((i = in.read()) != -1) {
			os.write(i);
		}
		return os.toString();
	}
}
