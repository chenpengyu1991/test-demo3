package com.founder.rhip.ehr.listener;

import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

/**
 * Created by haiyingjiang on 16/8/9.
 */
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // 取得登录的用户名
        User user = (User) session.getAttribute("currentUser");
        String username = user.getUserName();
        ServletContext application = session.getServletContext();
        // 获取在线列表
        Map<String, String> onlineUserlist = (Map<String, String>) application.getAttribute("onlineUserlist");

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
        IStandParameterCfgService standParameterCfgService = (IStandParameterCfgService) context.getBean("standParameterCfgService");

        if (onlineUserlist.containsKey(username) && (onlineUserlist.get(username).equals(session.getId()))) {
            onlineUserlist.remove(username);
            application.removeAttribute("onlineUserlist");
            session.removeAttribute("currentLoginInfo");
            session.removeAttribute("menus");
            session.removeAttribute("currentUser");
            session.removeAttribute("currentPatient");
            application.setAttribute("onlineUserlist", onlineUserlist);
            standParameterCfgService.saveStandParameter(setStandParameterCfg(onlineUserlist.size()));
        }
    }

    /**
     * StandParameterCfg赋值
     *
     * @param count
     * @return
     */
    private StandParameterCfg setStandParameterCfg(Integer count) {
        StandParameterCfg standParameterCfg = new StandParameterCfg();
        standParameterCfg.setStandardCode(EHRConstants.STANDARD_CODE_USER);
        standParameterCfg.setStandardName("平台在线人数");
        standParameterCfg.setParameterCode(EHRConstants.PARAMETER_CODE_USER);
        standParameterCfg.setParameterName("总人数");
        standParameterCfg.setParameterValue(count.toString());
        return standParameterCfg;
    }

}

