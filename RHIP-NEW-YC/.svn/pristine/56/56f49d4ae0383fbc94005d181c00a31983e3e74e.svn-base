package com.founder.rhip.portal.service.util;

import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.portal.dto.GetDeptmentListResponse;
import com.founder.rhip.portal.dto.GetDeptmentListResponseFY;
import com.founder.rhip.portal.dto.ReturnResult;
import com.founder.rhip.portal.service.IPortalSetService;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;

/**
 * Axis2客户端程序
 *
 * @author bagen
 */
public class Axis2Util {

    private static final Logger log = Logger.getLogger(Axis2Util.class);
    private static Properties properties;
    private static String param;
    private static String nameSpace;
    private static String url;
    private static EndpointReference targetEPR;
    private static OMNamespace paramNs;
    private static String[] params;
    private static OMFactory fac;
    private static OMNamespace omNs;

    private static String portal_reserve_view_end_time = "16:00";//门户预约列表科显示的最晚时间
    
    private  Axis2Util(){
    }


    /**
     * 调用Web服务返回消息
     *
     * @param xml 发送的消息
     * @return 服务响应消息
     */
    @SuppressWarnings("rawtypes")
    public static String sendService(String[] xml, String methodName, String hospitalcode) {
        initParam(hospitalcode);
        if (xml.length == 0) {
            return null;
        }

        String result = null;
        try {
            ServiceClient sender = new ServiceClient();
            Options options = new Options();

            options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
            //请求方法加入命名空间
            options.setAction(nameSpace+methodName);
            options.setTo(targetEPR);
            sender.setOptions(options);
            String[] values = xml;
            OMElement omElement = buildParam(methodName, params, values);
            OMElement response = sender.sendReceive(omElement);
            Iterator it = response.getChildElements();
            result = it.next().toString();
        } catch (AxisFault e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 初始化webservice客户端的配置
     *
     * @param hospitalcode
     */
    private static void initParam(String hospitalcode) {
        String tempName = "";
        if (hospitalcode == null) {
            return ;
        }
        //判断不同的医院采用不同参数模版
        switch (hospitalcode) {
            case Constants.FIRST_HOSPITAL:
                tempName = ".first";
                break;
            case Constants.SECOND_HOSPITAL:
                tempName = ".second";
                break;
            case Constants.THIRD_HOSPITAL:
                tempName = "";
                break;
            case Constants.CHINESE_MEDICINE_HOSPITAL:
                tempName = "";
                break;
            case Constants.MATERNAL_CHILD_HOSPITAL:
                tempName = ".maternal";
                break;
            case Constants.STOMATOLOGICAL_HOSPITAL:
                tempName = ".stomatological";
                break;
            default:
                tempName = "ws_config";
        }
        //初始化接口参数配置
        properties = PropertiesUtils.initProperties("ws_config");
        param = properties.getProperty("ws.params"+tempName);
        nameSpace = properties.getProperty("ws.namespace"+tempName);
        url = properties.getProperty("ws.url"+tempName);
        targetEPR = new EndpointReference(url);
        params = StringUtils.split(param, ",");
        fac = OMAbstractFactory.getOMFactory();
        omNs = fac.createOMNamespace(nameSpace, "");

    }


    private static OMElement buildParam(String method, String[] arg, String[] val) {

        OMElement data = fac.createOMElement(method, omNs);
        if (null != arg) {
            for (int i = 0; i < arg.length; i++) {
                OMElement inner = fac.createOMElement(arg[i], omNs);
                inner.setText(val[i]);
                data.addChild(inner);
            }
        }
        return data;
    }

    /**
     * 返回的报文转换成标准xml
     *
     * @param response 接口返回结果
     * @return 标准xml
     */
    @SuppressWarnings("finally")
    public static Map<String, Object> toXmlResult(String response, String hospitalCode) {
        Map<String, Object> resMap = new HashMap<>();
        if (StringUtil.isEmpty(response)) {
            resMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            resMap.put(Constants.RESERVE_RET_MSG, "接口返回的数据为空!");
            return resMap;
        }
        org.dom4j.Document doc;
        String result = "";
        String responseNode = returnResNode(hospitalCode);
        try {
            doc = DocumentHelper.parseText(response);
            org.dom4j.Node node = doc.selectSingleNode(responseNode);
            result = needDecrypt(hospitalCode,node);
            resMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        } catch (DocumentException e) {
            e.printStackTrace();
            resMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
        } finally {
            resMap.put(Constants.RESERVE_RET_MSG, result);
        }
        return resMap;
    }


    /***
     * 
    * @Title: needDecrypt 
    * @Description: 根据医院编码判断是否需要解码
    * @param @param hospitalCode
    * @param @param node
    * @param @return  参数说明 
    * @return String    返回类型 
    * @throws
     */
	private static String needDecrypt(String hospitalCode, Node node) {
		switch (hospitalCode) {
			case Constants.FIRST_HOSPITAL:
				return Base64Util.decrypt(node.getText(), "UTF-8");
			case Constants.MATERNAL_CHILD_HOSPITAL:
				return node.getText();
			case Constants.STOMATOLOGICAL_HOSPITAL:
				return node.getText();
			default: return null;
		}
	}


	/***
	 * 
	* @Title: returnResNode 
	* @Description: 根据医院编码来return出参报文的Node
	* @param @param hospitalCode
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	private static String returnResNode(String hospitalCode) {
    	switch (hospitalCode) {
			case Constants.FIRST_HOSPITAL:
				return Constants.NODE_FIRST_HOSPITAL;
			case Constants.MATERNAL_CHILD_HOSPITAL:
				return Constants.NODE_MATERNAL_CHILD_HOSPITAL;
			case Constants.STOMATOLOGICAL_HOSPITAL:
				return Constants.NODE_MATERNAL_CHILD_HOSPITAL;//口腔医院和妇幼接口一样
			default: return null;
    	}
	}


	/**
     * 判断返回xml是否正确
     *
     * @param returnResult
     * @return
     */
    public static boolean checkResult(ReturnResult returnResult) {
        return !ObjectUtil.isNullOrEmpty(returnResult) && ("1".equals(returnResult.getReturncode()) ? true : false);
    }

    /**
	 * 返回预约起始时间和结束时间
	 * @return  Map<String,Date>  时间段
	 */
	public static Map<String,Date> getDate(){
		Map<String,Date> dateMap = new HashMap<String,Date>();
//		Date nowDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH, 1);
//		Date endDate = DateUtil.add(nowDate, Calendar.DAY_OF_MONTH, 6);
//		endDate = DateUtil.lastTimeOfDay(endDate);
		Date nowDate = getRequestDateBegin();
		Date endDate = getRequestDateEnd();
		dateMap.put("sDate",nowDate);
		dateMap.put("eDate",endDate);
		return dateMap;
	}

	private static Date getRequestDateBegin() {
		String startViewReserveHour = portal_reserve_view_end_time.split("\\:")[0];
		String startViewReserveMin = portal_reserve_view_end_time.split("\\:")[1];
		Date requestDateBegin = null;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的天资源
			requestDateBegin = getRequestDateByTime(2);
		} else {
			//查看明天以后的天资源
			requestDateBegin = getRequestDateByTime(1);
		}
		return requestDateBegin;
	}
	
	private static Date getRequestDateEnd() {
		String startViewReserveHour = portal_reserve_view_end_time.split("\\:")[0];
		String startViewReserveMin = portal_reserve_view_end_time.split("\\:")[1];
		Date requestDateEnd = null;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的7天资源
			requestDateEnd = getRequestDateByTime(8);
		} else {
			//查看明天以后的7天资源
			requestDateEnd = getRequestDateByTime(7);
		}
		return requestDateEnd;
	}
	
	 private static Date getRequestDateByTime(int i) {
		Date requestDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,i);
		return requestDate;
	}
	 
    public static Date getRequestTimeBegin() {
    	Date requestTimeBegin;
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.HOUR_OF_DAY);
		cal.get(Calendar.MINUTE); 
		cal.get(Calendar.SECOND); 
		cal.get(Calendar.MILLISECOND);
		requestTimeBegin = cal.getTime();
		return requestTimeBegin;
	}
    
    public static Date getRequestTimeEnd(String startViewReserveHour, String startViewReserveMin) {
    	Date requestTimeEnd;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startViewReserveHour).intValue());
		if (startViewReserveMin.equals("00")) {
			cal.set(Calendar.MINUTE, 0);
		} else {
			cal.set(Calendar.MINUTE, Integer.valueOf(startViewReserveMin).intValue());
		}
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
		requestTimeEnd = cal.getTime();
		return requestTimeEnd;
	}
    
	/***
	 * 将查询出来的多条数据按照
	 * doctorSn,deptSn,hospitalSn条件
	 * 来筛选合并
	 * @param rsLists
	 * @return
	 */
	public static List<RegisterSchedule> schedulesCombineByConditions(List<RegisterSchedule> rsLists) {
		Map<String, String> map = new HashMap<String, String>();
		//合并regs中的重复项
		for (RegisterSchedule rs : rsLists) {
			if (!map.containsValue(rs.getHospitalCode()) && !map.containsValue(rs.getDeptSn()) && !map.containsValue(rs.getDoctorSn())) {
				map.put(rs.getDoctorSn(), 
				rs.getDoctorName()+":"+rs.getDeptSn()+":"+rs.getDeptName()+":"+rs.getHospitalCode()+":"+rs.getRegisterFee()+":"+rs.getClinicType()+"|");
			}
		}
		//temp1形如
		//doctorSn:doctorName:deptSn:deptName:hospitalCode|doctorSn:doctorName:deptSn:deptName:hospitalCode|
		String temp1="";
		for (Map.Entry<String, String>map1:map.entrySet()) {
			temp1+=map1.getKey()+":"+map1.getValue();
		}
		rsLists.clear();
		String[] infos = temp1.split("\\|");
		for (int j= 0; j<infos.length; j++) {
			String[] info = infos[j].split("\\:");
			RegisterSchedule rs = new RegisterSchedule();
			rs.setHospitalCode(info[4].toString());
			rs.setDeptSn(info[2].toString());
			rs.setDeptName(info[3].toString());
			rs.setDoctorSn(info[0].toString());
			rs.setDoctorName(info[1].toString());
			if (!"null".equals(info[5])) {
				rs.setRegisterFee(Double.parseDouble(info[5].toString()));
			}
			rs.setClinicType(info[6].toString());
			rsLists.add(rs);
		}
		return rsLists;
	}

	/***
     * 根据不同医院判断是否要调用接口
     * @param hospitalCode
     * @return
     */
	public static boolean commonMethods(String hospitalCode) { 
		switch (hospitalCode) {
			case Constants.FIRST_HOSPITAL:
				return false;
			case Constants.SECOND_HOSPITAL:
				return false;
			case Constants.THIRD_HOSPITAL:
				return false;
			case Constants.CHINESE_MEDICINE_HOSPITAL:
				return true;
			case Constants.MATERNAL_CHILD_HOSPITAL:
				return true;
			case Constants.STOMATOLOGICAL_HOSPITAL:
				return true;
			default: return false;
		}
	}
	
	
    public static void main(String args[]) throws UnsupportedEncodingException, JAXBException, ParseException {
    	/*System.out.println(DateUtil.toDateString(new Date(), "yyyy年MM月dd日"));*/
    	/*Date da = DateUtil.parseSimpleDate("2016-05-20 17:44:45", "YYYY-MM-dd HH:mm:ss");
    	System.out.println(DateUtil.toDateString(da, "yyyy年MM月dd日 HH点mm分ss秒"));*/
    	
    	StringBuffer buffer = new StringBuffer();

		buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        buffer.append("<Req>");
		buffer.append("<oracode>00001</oracode>");
		buffer.append("<oraauthcode>cs0087905631</oraauthcode>");
		
//		buffer.append("<TransactionCode>JK2002</TransactionCode>");
//		buffer.append("<WorkTime>0</WorkTime>");
//		buffer.append("<Type>0</Type>");
		
//		buffer.append("<TransactionCode>JK2004</TransactionCode>");
//		buffer.append("<WorkDateStart>2016-06-15</WorkDateStart>");
//		buffer.append("<WorkDateEnd>2016-06-15</WorkDateEnd>");
//		buffer.append("<WorkTime>1</WorkTime>");
//		buffer.append("<Status>0</Status>");
//		buffer.append("<DeptCode>33500</DeptCode>");
//		buffer.append("<DoctorCode>250</DoctorCode>");
		
//		buffer.append("<TransactionCode>JK2005</TransactionCode>");
//		buffer.append("<WorkDate>2016-06-13</WorkDate>");
//		buffer.append("<DocCode>*</DocCode>");
//		buffer.append("<DeptCode>*</DeptCode>");
//		buffer.append("<WorkType>1</WorkType>");
		
		buffer.append("<TransactionCode>JK5001</TransactionCode>");
		buffer.append("<IDCardID>320581199006131724</IDCardID>");
		buffer.append("<Mobile>15850041137</Mobile>");
		buffer.append("<Name>高莉</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>320322198612221652</IDCardID>");
//		buffer.append("<Mobile>15050451206</Mobile>");
//		buffer.append("<Name>魏德忠</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>642222198808200811</IDCardID>");
//		buffer.append("<Mobile>13209513567</Mobile>");
//		buffer.append("<Name>田卫军</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>640222198705051110</IDCardID>");
//		buffer.append("<Mobile>15109605295</Mobile>");
//		buffer.append("<Name>张国军</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>340823199110177593</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>周扬</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>522121197410060077</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>张延炎</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>110000197609260652</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>穆桂英</Name>");
		
//		buffer.append("<TransactionCode>JK5001</TransactionCode>");
//		buffer.append("<IDCardID>422301198408082011</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>冯柳</Name>");
		
//		buffer.append("<TransactionCode>JK5003</TransactionCode>");
//		buffer.append("<IDCardID>422301198408082011</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>冯柳</Name>");
//		buffer.append("<BirthDay>1984-08-08</BirthDay>");
//		buffer.append("<Sex>0</Sex>");
		/*buffer.append("<SickID>6001492139</SickID>");*/
		
//		buffer.append("<TransactionCode>JK5003</TransactionCode>");
//		buffer.append("<IDCardID>340823199110177593</IDCardID>");
//		buffer.append("<Mobile>15850041137</Mobile>");
//		buffer.append("<Name>周扬</Name>");
//		buffer.append("<BirthDay>1991-10-17</BirthDay>");
//		buffer.append("<Sex>1</Sex>");
		
//		buffer.append("<TransactionCode>JK2006</TransactionCode>");
//		buffer.append("<IDCardID>320322198612221652</IDCardID>");
//		buffer.append("<Mobile>15050451206</Mobile>");
//		buffer.append("<Name>魏德忠</Name>");
//		buffer.append("<WorkDate>2016-05-27</WorkDate>");
//		buffer.append("<WorkType>1</WorkType>");
//		buffer.append("<DeptCode>32800</DeptCode>");
//		buffer.append("<DocCode>231</DocCode>");
//		buffer.append("<STime>08:00:00</STime>");
//		buffer.append("<CustomTime>"+new Date()+"</CustomTime>");
//		buffer.append("<SickID>6001492174</SickID>");
//		buffer.append("<CardNo>0200653380</CardNo>");
		
		/*buffer.append("<TransactionCode>JK2008</TransactionCode>");
		buffer.append("<SeqNumber>162013</SeqNumber>");*/
		
		buffer.append("</Req>");
		System.out.println(buffer.toString());
        String[] params = new String[]{"JK5001",buffer.toString()};
		String response = sendService(params, "Interface_Trade_Jkzl",Constants.MATERNAL_CHILD_HOSPITAL);
		org.dom4j.Document doc;
		try {
			doc = DocumentHelper.parseText(response);
			org.dom4j.Node node = doc.selectSingleNode("//Interface_Trade_JkzlResult");
            System.out.println(node.getText());
//            GetDeptmentListResponseFY dr = XmlWebserviceForUtil.parseDataXml(node.getText(),GetDeptmentListResponseFY.class);
        } catch (DocumentException e) {
			e.printStackTrace();
		}

		/*buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
        buffer.append("<request>\r\n");
		buffer.append("  <requestid>weixin</requestid>\r\n");
		buffer.append("  <pageactionin>\r\n");
		buffer.append("    <currentpagenum>1</currentpagenum>\r\n");
		buffer.append("    <rowsperpage>32767</rowsperpage>\r\n");
		buffer.append("    <pageaction>firstpage</pageaction>\r\n");
		buffer.append("    <topagenum>2</topagenum>\r\n");
		buffer.append("  </pageactionin>\r\n");
		buffer.append("  <retrieveargs>\r\n");
		buffer.append("    <begindate>2004-01-01</begindate>\r\n");
		buffer.append("    <hospitalid>001</hospitalid>\r\n");
		buffer.append("<deptcode></deptcode>");
		buffer.append("<doctorno></doctorno>");
		buffer.append("<specialty></specialty>");
		buffer.append("  </retrieveargs>\r\n");
		buffer.append("</request>\r\n");
        System.out.println(buffer.toString());
        String[] params = new String[]{Base64Util.encrypt(buffer.toString(), "UTF-8")};
		String response = sendService(params, "GetDeptmentList",Constants.FIRST_HOSPITAL);
		org.dom4j.Document doc;
		try {
			doc = DocumentHelper.parseText(response);
			org.dom4j.Node node = doc.selectSingleNode("//out");
			String result = Base64Util.decrypt(node.getText(),"UTF-8");
			System.out.println(result);
			GetDeptmentListResponse dr = XmlWebserviceForUtil.parseDataXml(result,GetDeptmentListResponse.class);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}*/
    }
}
