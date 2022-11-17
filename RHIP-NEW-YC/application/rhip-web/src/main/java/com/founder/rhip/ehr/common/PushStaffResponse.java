package com.founder.rhip.ehr.common;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "pushStaffResponse")
public class PushStaffResponse {

    private String code;
    private String text;
    private String userName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String,String> getMap(){
        Map<String,String> resMap = new HashMap<>();
        resMap.put("code",code);
        resMap.put("text",text);
        return resMap;
    }

}
