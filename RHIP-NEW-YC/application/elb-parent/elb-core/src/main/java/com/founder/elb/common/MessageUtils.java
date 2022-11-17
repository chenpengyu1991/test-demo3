package com.founder.elb.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class MessageUtils {
	public static void outputJSONResult(String result, HttpServletResponse response) {
		try {
			response.setHeader("ContentType", "text/json");
			//response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void outputXMLResult(String result, HttpServletResponse response) {
		try {
			response.setHeader("ContentType", "xml");
			//response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void outputJSONResultGBK(String result, HttpServletResponse response) {
		try {
			response.setHeader("ContentType", "text/json");
			//response.setCharacterEncoding("gbk");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String autoWordWrap(String valueStr, Integer charNum){
		
        if(valueStr.length()<charNum){
        	return valueStr;
        }
        
        String retValue = "";
        while(valueStr.length() >= charNum){
        	retValue = retValue + valueStr.substring(0,charNum) + "<br>";
        	valueStr = valueStr.substring(charNum);
        	if(StringUtils.isEmpty(valueStr)){
        		break;
        	}
        	
        	if(valueStr.length() < charNum){
        		retValue = retValue + valueStr;
        	}
        }
        
        return retValue;
	}
	
	public static List<String> getErrorMessage(BindingResult errors) {
		List<String> lm = new ArrayList<String>();
		if (errors.hasErrors()) {
			List<ObjectError> list = errors.getAllErrors();
			for (ObjectError oe : list) {
				lm.add(oe.getDefaultMessage());
			}
		}
		return lm;
	}
}
