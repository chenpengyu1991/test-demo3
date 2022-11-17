package com.founder.rhip.portal.dto;

import com.founder.rhip.portal.common.TransCodeConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class SelectSchduleResponseFY implements Serializable{

	private static final long serialVersionUID = -8552315326189900551L;

    private String RespCode;

    private String RespMessage;

	private String WorkDate;

	private String WorkType;

	private String DoctorCode;

	private String DeptCode;

    private List<TimeList> Num;

    public List<TimeList> getNum() {
        return Num;
    }

    public void setNum(List<TimeList> num) {
        Num = num;
    }

    public String getDoctorCode() {
		return DoctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		DoctorCode = doctorCode;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

    public String getWorkDate() {
        return WorkDate;
    }

    public void setWorkDate(String workDate) {
        WorkDate = workDate;
    }

    public String getWorkType() {
        return WorkType;
    }

    public void setWorkType(String workType) {
        WorkType = workType;
    }

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    public String getRespMessage() {
        return RespMessage;
    }

    public void setRespMessage(String respMessage) {
        RespMessage = respMessage;
    }
}
