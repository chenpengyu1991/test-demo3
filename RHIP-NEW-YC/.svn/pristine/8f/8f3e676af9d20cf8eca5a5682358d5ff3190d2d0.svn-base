package com.founder.rhip.portal.service.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.linkage.netmsg.NetMsgclient;
import com.linkage.netmsg.server.ReceiveMsg;
/**
 * 短信操作
 */
public class SMSUtil {
	
	private static Properties properties;
	
	private static String IP_ADDR="ip_addr";
	
	private static String PORT="port";
	
	private static String USER_NAME="user_name";
	
	private static String PASSWORD="password";
	
	private static final String TEMPLATE_PATH = "/template";
	
	//模板类型1 预约注册成功通知模板
	public static String MODE_TYPE_1="预约成功通知";
	
	//模板类型2 找回密码-发送验证码至手机
	public static String MODE_TYPE_2="找回密码-手机验证码";
	
	//模板类型3 找回密码-发送验证码至Email
	public static String MODE_TYPE_3="找回密码-邮箱验证码";

	//模板类型4 取消预约-发送短信
	public static String MODE_TYPE_4="取消预约通知";
	
	//模板类型5 注册验证码-发送短信
	public static String MODE_TYPE_5="注册验证码";
	
	//返回16则链接异常
	private static final String ERROR_CODE_16 = "16";
	
	//取消预约挂号时候是否发送短信(包括前台和平台) true:发送，false:不发送
	private  boolean portal_cancel_send; 
	
	//前台预约挂号时是否发送短信 true:发送，false:不发送
	private  boolean portal_reserve_send;
	
	protected static Logger log = Logger.getLogger(SMSUtil.class);
	
	private static SMSUtil msgUtil= null;
	
	private static NetMsgclient client=null;
	
	private static  ReceiveMsg receiveMsg =new ReceiveSMS();
	
	public static SMSUtil getInstance() {
		if (msgUtil == null) {
			msgUtil = new SMSUtil();
			client=new NetMsgclient();
			//	    ReceiveMsgImpl为ReceiveMsg类的子类，构造时，构造自己继承的子类就行
			 boolean isLogin=false;
			 try {
			client.initParameters(SMSUtil.getIP_ADDR(), Integer.valueOf(SMSUtil.getPORT()), SMSUtil.getUSER_NAME(), SMSUtil.getPASSWORD(),receiveMsg);
				//		 登录认证
				isLogin = client.anthenMsg(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e.getMessage(),e);
			}
			 if(isLogin){
				 log.info("短信接口成功登陆!");
			 }
			 else{
				 log.warn("短信接口登陆失败!");
			 }
		}
		return msgUtil;
	}
	
	public  SMSUtil(){
		properties = PropertiesUtils.initProperties("sms-conf");
		if(properties==null){
			log.warn("sms-conf properties is null!");
		}else{
			try {
				portal_cancel_send=Boolean.valueOf(properties.getProperty("portal_cancel_send"));
				portal_reserve_send=Boolean.valueOf(properties.getProperty("portal_reserve_send"));
			} catch (Exception e) {
				log.error("Class SMSUtil happend error in static{else ...?}!");
				log.error(e.getMessage(),e);
			}
		}
			
	}

	public boolean isPortal_cancel_send() {
		return portal_cancel_send;
	}

	public void setPortal_cancel_send(boolean portal_cancel_send) {
		this.portal_cancel_send = portal_cancel_send;
	}

	public boolean isPortal_reserve_send() {
		return portal_reserve_send;
	}

	public void setPortal_reserve_send(boolean portal_reserve_send) {
		this.portal_reserve_send = portal_reserve_send;
	}

	@SuppressWarnings("finally")
	public synchronized  String send(String sms,String phoneNo) {
		String rs = null;
		/*  delete by bagen 通过url方式发送短信
		 * rs=client.sendMsg(client, 1, target, sms, 1);
        AnswerBean  answerBean = new AnswerBean();
        if(receiveMsg!=null)
        	receiveMsg.getAnswer(answerBean);
        log.debug("sendMsg return:"+rs+"client getSeqId:"+client.getSeqId()+"answerBean getSeqId:"+answerBean.getSeqId()+
        		"answerBean getStatus:"+answerBean.getStatus()+"answerBean.getMsgId:"+answerBean.getMsgId());
        //关闭发送短信与接收短信连接
        //   client.closeConn();
        if(ERROR_CODE_16.equals(rs)||answerBean.getStatus()!=0)
        	return false;      
         return true;*/
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("action","send");
		parameterMap.put("userid","2069");
		parameterMap.put("account",SMSUtil.getUSER_NAME());
		parameterMap.put("password",SMSUtil.getPASSWORD());
		parameterMap.put("mobile",phoneNo);
		parameterMap.put("sendTime",null);
		parameterMap.put("extno",null);
		try {
			parameterMap.put("content",properties.getProperty("sign")+sms);
			rs =new SendSMS().doPost(SMSUtil.getIP_ADDR(), parameterMap);
			if(!rs.isEmpty()){
//				Document xmlDc = XmlWebserviceForUtil.parseDocument(rs);
//				Element ele = xmlDc.getRootElement();
//				rs = ele.elementText("returnstatus");
				org.dom4j.Document doc = DocumentHelper.parseText(rs);
		    	org.dom4j.Node node = doc.selectSingleNode("//returnstatus");
		        rs  = node.getText();
			}
		}catch (HttpException e) {
			rs = e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			rs = e.getMessage();
			e.printStackTrace();
		} catch (DocumentException e) {
			rs = e.getMessage();
			e.printStackTrace();
		}finally {
			return rs;
		}
	}
	
	public String createSMSContent(Map<String,String> cfgMap,String modeType) {
		StringWriter writer = new StringWriter();
		String rs=null;
		if (ObjectUtil.isNullOrEmpty(cfgMap)) {
			return writer.toString();
		}
		//初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		Properties properties = new Properties();
		//取得模版绝对路径
		String originalFilePath = this.getClass().getResource(TEMPLATE_PATH).toString().replaceAll("^file:/", ""); 
		try {
			originalFilePath=URLDecoder.decode(originalFilePath,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error("UnsupportedEncodingException!",e1);
			e1.printStackTrace();
		}
		log.info("模版绝对路径="+originalFilePath);
		try {
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, originalFilePath);  
			ve.init(properties);
			//取得velocity的模版 
			Template t = null;
			if(SMSUtil.MODE_TYPE_1.equals(modeType))
				t =ve.getTemplate("smsVelocity.vm","UTF-8"); 
			if(SMSUtil.MODE_TYPE_2.equals(modeType))
				t =ve.getTemplate("findpwd_checkcode.vm","UTF-8"); 
			if(SMSUtil.MODE_TYPE_3.equals(modeType))
				t =ve.getTemplate("getCheckcodeByEmail.vm","UTF-8"); 
			if(SMSUtil.MODE_TYPE_4.equals(modeType))
				t =ve.getTemplate("cancel_sms.vm","UTF-8"); 
			if(SMSUtil.MODE_TYPE_5.equals(modeType))
				t =ve.getTemplate("regedit_checkcode.vm","UTF-8"); 
			//取得velocity的上下文context
			VelocityContext context = new VelocityContext();
			context.put("cfg", cfgMap);
			t.merge(context, writer);
		} catch (ResourceNotFoundException e) {
			log.error("ResourceNotFoundException!",e);
			e.printStackTrace();
		} catch (ParseErrorException e) {
			log.error("ParseErrorException!",e);
			e.printStackTrace();
		} catch (MethodInvocationException e) {
			log.error("MethodInvocationException!",e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException!",e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Exception!",e);
			e.printStackTrace();
		}finally{
			rs= writer.toString();
		}
		return rs;
	}
	public static String getIP_ADDR() {
		return properties.getProperty(IP_ADDR);
	}
	public static void setIP_ADDR(String iP_ADDR) {
		IP_ADDR = iP_ADDR;
	}
	public static String getPORT() {
		return properties.getProperty(PORT);
	}
	public static void setPORT(String pORT) {
		PORT = pORT;
	}
	public static String getUSER_NAME() {
		return properties.getProperty(USER_NAME);
	}
	public static void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public static String getPASSWORD() {
		return properties.getProperty(PASSWORD);
	}
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	
}
