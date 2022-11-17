package com.founder.rhip.portal.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class ExceptionHandler extends SimpleMappingExceptionResolver {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		response.setStatus(500);
		logger.error(ex.getLocalizedMessage());
		this.handlerException(request, response, handler, ex);
		
		Map<String,Object> model = new HashMap<String,Object>();  
		model.put("msgVo",getExceptionMsg(ex));
        return new ModelAndView("rhip.ehr.msg",model);
	}

	/**
	 * 获取异常字符串
	 * */
	private String getExceptionMsg(Exception ex){
		String str = "JAVA:" + ex.toString();
//		StackTraceElement[] se = ex.getStackTrace();
//		for (int i = 0; i < se.length; i++) {
//			str += "\n" + se[i].toString();
//		}
		return str;
	}
	
	/**
	 * 异常处理方法
	 * 
	 * */
	private void handlerException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex){
		clearFlashScope(request);
	}
	
	/**
	 * 清空FlashScope
	 * 
	 * */
	private void clearFlashScope(HttpServletRequest request){
//		HttpSession session = request.getSession(); 
//		Map flash = flash = new HashMap();
//		session.setAttribute(FlashScope.FLASH_SCOPE_ATTRIBUTE, flash);
	}
}
