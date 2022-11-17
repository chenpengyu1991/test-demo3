package com.founder.rhip.ehr.entity.clinic;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yuanzg on 2016/12/13.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class GetPatientbedRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElementWrapper(name = "paitentbedStatusList")
    @XmlElement(name = "paitentbedStatus")
    private List<PaitentbedStatus> paitentbedStatusList;

    public List<PaitentbedStatus> getPaitentbedStatusList() {
        return paitentbedStatusList;
    }

    public void setPaitentbedStatusList(List<PaitentbedStatus> paitentbedStatusList) {
        this.paitentbedStatusList = paitentbedStatusList;
    }
}
