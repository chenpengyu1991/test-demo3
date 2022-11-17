package com.founder.rhip.portal.dto;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.StopDoctor;


public class XmlParserTest {
	
	//@Test
	public void parseTest() throws JAXBException {
//		File file = new File("E:\\Test\\REGISTER_SCHEDULE.xml");
//		
//		JAXBContext context = JAXBContext.newInstance(UpdateResource.class);
//		Marshaller jaxbMarshaller = context.createMarshaller();
//		// output pretty printed
//		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		UpdateResource postpartumDaysHealthInfo = new UpdateResource();
//		jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
//		jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
//		
//		
//		createQueryReserve();
//		createReserveRegister();
//		createError();
//		createDoctor();
		
		createSearchReserve();
	}
	
	private void createSearchReserve() throws JAXBException{
		File file = new File("E:\\Test\\SearchReserve.xml");
		SearchReserve searchReserve = new SearchReserve();
		searchReserve.setEndRequestDate(new Date());
		searchReserve.setHospitalCode("1210121");
		searchReserve.setIdcard("4327189");
		searchReserve.setName("7321");
		searchReserve.setSearchCode("231321");
		searchReserve.setStartRequestDate(new Date());
		
		JAXBContext context = JAXBContext.newInstance(SearchReserve.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(searchReserve, file);
		jaxbMarshaller.marshal(searchReserve, System.out);
	}
	
	private void createDoctor() throws JAXBException{
		File file = new File("E:\\Test\\StopDoctor.xml");
		StopDoctor postpartumDaysHealthInfo = new StopDoctor();
		
		postpartumDaysHealthInfo.setHospitalCode("111");
		postpartumDaysHealthInfo.setDeptSn("keshi");
		postpartumDaysHealthInfo.setDoctorSn("yisheng");
		postpartumDaysHealthInfo.setStartDate(new Date());
		postpartumDaysHealthInfo.setEndDate(new Date());
		postpartumDaysHealthInfo.setStopingStatus("1");
		
		
		JAXBContext context = JAXBContext.newInstance(StopDoctor.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
	}
	
	private void createError() throws JAXBException{
		File file = new File("E:\\Test\\ErrorResult.xml");
		ErrorResult postpartumDaysHealthInfo = new ErrorResult();
		postpartumDaysHealthInfo.setErrorString("NI HAO A");
		
		JAXBContext context = JAXBContext.newInstance(ErrorResult.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
	}
	
	private void createQueryReserve() throws JAXBException{
		File file = new File("E:\\Test\\queryReserve.xml");
		QueryReserve postpartumDaysHealthInfo = new QueryReserve();
		postpartumDaysHealthInfo.setIdcard("342423198701296776");
		postpartumDaysHealthInfo.setSearchCode("nihao13");
		
		
		JAXBContext context = JAXBContext.newInstance(QueryReserve.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
	}
	
	private void createReserveRegister() throws JAXBException{
		File file = new File("E:\\Test\\ReserveRegister.xml");
		ReserveRegister postpartumDaysHealthInfo = new ReserveRegister();
		
		postpartumDaysHealthInfo.setAmpm("p");
		postpartumDaysHealthInfo.setClinicType("01");
		postpartumDaysHealthInfo.setDeptName("11");
		postpartumDaysHealthInfo.setDeptSn("11");
		postpartumDaysHealthInfo.setDoctorName("ni");
		postpartumDaysHealthInfo.setDoctorSn("1231");
		postpartumDaysHealthInfo.setGender("男");
		postpartumDaysHealthInfo.setHospitalCode("001");
		postpartumDaysHealthInfo.setHospitalName("中医院");
		postpartumDaysHealthInfo.setIdcardArchives("yikatong");
		postpartumDaysHealthInfo.setIdcardFarm("新农合");
		postpartumDaysHealthInfo.setIdcardHos("yibaokaha");
		postpartumDaysHealthInfo.setName("laozhang");
		postpartumDaysHealthInfo.setPhoneNumber("15363283728");
		postpartumDaysHealthInfo.setRegisterFee(20.2);
		postpartumDaysHealthInfo.setRequestDate(new Date());
		postpartumDaysHealthInfo.setSearchCode("chaxunma");
		postpartumDaysHealthInfo.setSubmitDate(new Date());
		postpartumDaysHealthInfo.setSubmitOrg("chaozuojigou");
		postpartumDaysHealthInfo.setIdcard("342423198701296776");
		postpartumDaysHealthInfo.setSearchCode("nihao13");
		
		
		JAXBContext context = JAXBContext.newInstance(ReserveRegister.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, file);
		jaxbMarshaller.marshal(postpartumDaysHealthInfo, System.out);
	}
	
	
	public void whchDataTest() throws Exception {
		// 初始化配置文件
		InputStream in = XmlParserTest.class.getClassLoader().getResourceAsStream("config/出生医学证明.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:config/applicationContext.xml");
	}
	
	
}
