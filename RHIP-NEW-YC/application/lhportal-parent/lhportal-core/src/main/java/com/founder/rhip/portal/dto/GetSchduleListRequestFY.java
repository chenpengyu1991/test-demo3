package com.founder.rhip.portal.dto;

import com.founder.rhip.portal.common.TransCodeConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "Req")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetSchduleListRequestFY implements Serializable{

	private static final long serialVersionUID = -8552115326689900551L;

    private String oracode = TransCodeConstants.ORACODE;

    private String oraauthcode = TransCodeConstants.ORAAUTHCODE;

	private String TransactionCode;

	private String WorkDateStart;

	private String WorkDateEnd;

	private String DoctorCode;

	private String DeptCode;

	private String WorkTime;

	private String Status;

	public String getOracode() {
		return oracode;
	}

	public void setOracode(String oracode) {
		this.oracode = oracode;
	}

	public String getOraauthcode() {
		return oraauthcode;
	}

	public void setOraauthcode(String oraauthcode) {
		this.oraauthcode = oraauthcode;
	}

	public String getTransactionCode() {
		return TransactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		TransactionCode = transactionCode;
	}

    public String getWorkDateStart() {
        return WorkDateStart;
    }

    public void setWorkDateStart(String workDateStart) {
        WorkDateStart = workDateStart;
    }

    public String getWorkDateEnd() {
        return WorkDateEnd;
    }

    public void setWorkDateEnd(String workDateEnd) {
        WorkDateEnd = workDateEnd;
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

	public String getWorkTime() {
		return WorkTime;
	}

	public void setWorkTime(String workTime) {
		WorkTime = workTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
