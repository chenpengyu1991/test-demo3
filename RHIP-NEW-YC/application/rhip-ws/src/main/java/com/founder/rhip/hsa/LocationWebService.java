package com.founder.rhip.hsa;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;
import com.founder.rhip.hsa.service.ILocationService;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

/**
 * @author liuk
 * 
 */
@Service("locationWebService")
@WebService(serviceName = "LocationWebService")
public class LocationWebService extends BaseWebService implements ILocationWebService {

	private Class<?>[] suppotClasses = { LocationsInData.class, LocationsResult.class,PenaltyInfosInData.class };
	private Map<Class<?>, JAXBContext> jaxbCache = new HashMap<Class<?>, JAXBContext>(2);
    //xml保存地址
    private static String folder=null;

	@Resource(name = "hsaLocationService")
	private ILocationService locationService;

	@Override
	public String updateLocations(String locationsXml) {
		LocationsResult locationsResult = new LocationsResult();
		if (ObjectUtil.isNullOrEmpty(locationsXml)) {
			locationsResult.setCode(LocationsResult.ERROR);
			locationsResult.setMessage("传入xml数据为空");
		} else {
            save(locationsXml,"locations");
			LocationsInData locationsInData = null;
			try {
				locationsInData = parse(LocationsInData.class, locationsXml);
				List<LocationInfo> locationInfos = locationsInData.getLocations();
				locationService.importLocationInfos(locationInfos);
				locationsResult.setCode(LocationsResult.SUCCESS);
				locationsResult.setMessage("成功");
			} catch (Exception e) {
				logger.error("基础档案数据保存失败" + e, e);
				locationsResult.setCode(LocationsResult.ERROR);
				locationsResult.setMessage(e.getMessage());
			} finally {
				locationsInData = null;
			}
		}
		String result =marshal(locationsResult);
		return result;
	}

    @Override
    public String updatePenaltys(String locationsXml) {
        LocationsResult locationsResult = new LocationsResult();
        if (ObjectUtil.isNullOrEmpty(locationsXml)) {
            locationsResult.setCode(LocationsResult.ERROR);
            locationsResult.setMessage("传入xml数据为空");
        } else {
            save(locationsXml,"penaltyInfos");
            PenaltyInfosInData penaltyInfosInData = null;
            try {
                penaltyInfosInData = parse(PenaltyInfosInData.class, locationsXml);
                List<PenaltyInfo> peLocationInfos = penaltyInfosInData.getPenaltyInfos();
                locationService.importPenaltyInfos(peLocationInfos);
                locationsResult.setCode(LocationsResult.SUCCESS);
                locationsResult.setMessage("成功");
            } catch (Exception e) {
                logger.error("行政处罚数据保存失败数据保存失败", e);
                locationsResult.setCode(LocationsResult.ERROR);
                locationsResult.setMessage(e.getMessage());
            } finally {
                penaltyInfosInData = null;
            }
        }
        String result =marshal(locationsResult);
        return result;
    }

	@PostConstruct
	public void init() {
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
            folder = properties.getProperty("hsa.data.folder");
        }
	}

    private void save(String xml,String type){
        if(ObjectUtil.isNotEmpty(folder)){
            try {
                XmlWebserviceForUtil.saveDataFile(xml,type,folder);
            } catch (Exception e) {
                logger.error("数据保存失败:"+type,e);
            }
        }
    }

	public String marshal(Object bean) {
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
	private <T> T parse(Class<?> clazz, String xml) {
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

	public static void main(String[] abc) throws IOException {
//		LocationsInData inData = new LocationsInData();
//		List<LocationInfo> infos = new ArrayList<>();
//		LocationInfo info = new LocationInfo();
//		info.setUnitName("单位名称");
//		info.setUnitTypeCode("单位类型");
//
//		info.setRegisterOrgnName("注册地址");
//
//		info.setZipCode("邮政编码");
//		info.setEconomicNatureCode("经济性质");
//
//		info.setContact("联系人");
//		info.setPersonInCharge("负责人");
//		info.setLegal("法人");
//		info.setQualityControlStaff("质管员");
//		info.setContactPhone("联系电话");
//		info.setAgencyPhone("代理电话");
//		info.setContactTelephone("联系手机");
//		info.setAgencyTelephone("代理手机");
//		info.setDocumentTypeCode("证件类别");
//
//		info.setIdcard("身份证号");
//		info.setTownshipLotCode("乡镇地段");
//		info.setEmail("电子邮件");
//		info.setSite("单位网址");
//		info.setHeadDepartment("主管部门 ");
//		info.setScale("单位规模 ");
//		info.setSelfCode("本体代码");
//
//		infos.add(info);
//		infos.add(info);
//		infos.add(info);
//		inData.setLocations(infos);
		LocationWebService service = new LocationWebService();
		service.init();
//
//		LocationsResult locationsResult = new LocationsResult();
//		locationsResult.setCode("1");
//		locationsResult.setMessage("阿萨德发送到发");
//
//		String xml = service.marshal(inData);
//		System.err.println(xml);
//
//		xml = service.marshal(locationsResult);
//		System.err.println(xml);
//
//		InputStream in = LocationWebService.class.getResourceAsStream("test.xml");
//		StringBuffer out = new StringBuffer();
//		byte[] b = new byte[1024];
//		for (int n = 0; (n = in.read(b)) != -1;) {
//			out.append(new String(b, 0, n));
//		}
//		LocationsInData locationsInData = service.parse(LocationsInData.class, out.toString());
//		xml = service.marshal(locationsInData);
//		System.err.println(xml);

        //
		// PenaltyInfosInData penaltyInfosInData=new PenaltyInfosInData();
		// List<PenaltyInfo> penaltyInfos=new ArrayList<>();
		// PenaltyInfo penaltyInfo=new PenaltyInfo();
		// penaltyInfo.setBeginCaseDate(new Date());
		// penaltyInfo.setBusinessAddress("setBusinessAddressName");
		// penaltyInfo.setCaseCause("setCaseCause");
		// penaltyInfo.setEndCaseDate(new Date());
		// penaltyInfo.setIdCard("320323");
		// penaltyInfo.setMainId("1");
		// penaltyInfo.setPersonInCharge("liuk");
		// penaltyInfo.setPunishType("asd");
		// penaltyInfo.setUnitName("asdf");
		//
		// penaltyInfosInData.setPenaltyInfos(penaltyInfos);
		// penaltyInfos.add(penaltyInfo);
		//
		// String xml = service.marshal(penaltyInfosInData);
		// System.err.println(xml);
	}
}
