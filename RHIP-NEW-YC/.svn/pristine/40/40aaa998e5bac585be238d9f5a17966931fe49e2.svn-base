package com.founder.rhip.appInterface;

import com.founder.rhip.ehr.entity.ech.EchIdentificationOption;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 体质辨识接口对象
 * Created by admin on 2016/12/13.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class TzbsData {

    //身份证号
    @XmlElement(name = "idCardNo")
    private String idCardNo;

    //姓名
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "option")
    @XmlElementWrapper(name = "options")
    private List<EchIdentificationOption> options;

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EchIdentificationOption> getOptions() {
        return options;
    }

    public void setOptions(List<EchIdentificationOption> options) {
        this.options = options;
    }
}
