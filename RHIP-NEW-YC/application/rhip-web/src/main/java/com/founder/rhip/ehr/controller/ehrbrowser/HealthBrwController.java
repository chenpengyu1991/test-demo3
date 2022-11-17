package com.founder.rhip.ehr.controller.ehrbrowser;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.basic.User;

@Controller
@RequestMapping("/personalReport")
public class HealthBrwController extends BaseController {
	
	@RequestMapping("/explorer")
	public String healthBrw(HttpServletRequest request, Model model){

        //假的session
        HttpSession session = request.getSession();
        User cUser = new User();
        cUser.setName("doctor");
        session.setAttribute("currentUser", cUser);
        //设置currentLoginInfo
        CurrentLoginInfo currentLoginInfo =new CurrentLoginInfo();
        session.setAttribute("currentLoginInfo", currentLoginInfo);
        String base = request.getQueryString();
        String result = null;
        try {
            String decodeQueryString = Base64Util.decrypt(base, "UTF-8");
            result = URLDecoder.decode(decodeQueryString,"UTF-8");
        } catch (Exception e) {
            logger.error("参数解析失败!");
        }
        Map<String, String> map = new HashMap<String, String>();
        if(ObjectUtil.isNotEmpty(result)){
            String[] results = result.split("&");
            for(int i=0;i<results.length;i++){
                String[] values = results[i].split("=");
                if(values.length == 2 && ObjectUtil.isNotEmpty(values[0]) && ObjectUtil.isNotEmpty(values[1])){
                    map.put(values[0], values[1]);
                }else {
                    logger.error("参数错误!");
                    break;
                }
            }
        }else {
            logger.error("参数错误!");
        }
        session.setAttribute("explorerInfo", map);

        return "rhip.ehr.browser.explorer";
    }
}