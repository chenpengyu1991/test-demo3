package com.founder.rhip.dref.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class OutTransferQueryForm {

	private String name;

	private String idCard;

	private String fromOrganCode;

	private String patientType;

	private String status1;

	private String status2;

    private String transferDateBegin;//转诊开始日期

    private String transferDateEnd;//转诊结束日期

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFromOrganCode() {
        return fromOrganCode;
    }

    public void setFromOrganCode(String fromOrganCode) {
        this.fromOrganCode = fromOrganCode;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getTransferDateBegin() {
        return transferDateBegin;
    }

    public void setTransferDateBegin(String transferDateBegin) {
        this.transferDateBegin = transferDateBegin;
    }

    public String getTransferDateEnd() {
        return transferDateEnd;
    }

    public void setTransferDateEnd(String transferDateEnd) {
        this.transferDateEnd = transferDateEnd;
    }

    public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idCard)) {
			criteria.add("idcard", idCard);
		}
		if (ObjectUtil.isNotEmpty(fromOrganCode)) {
			criteria.add("FROM_ORGAN_CODE", fromOrganCode);
		}
        if (ObjectUtil.isNotEmpty(patientType)) {
            criteria.add("PATIENT_TYPE", patientType);
        }
        if (ObjectUtil.isNotEmpty(status1)) {
            if("1".equals(status1)){
                criteria.add("MEDICAL_DEPT_AUDIT", OP.IS, null);
            }
            if("2".equals(status1)){
                criteria.add("MEDICAL_DEPT_AUDIT", OP.UEMPTY, null);
            }
        }
        if (ObjectUtil.isNotEmpty(status2)) {
            if("1".equals(status2)){
                criteria.add("MEDICAL_DEPT_AUDIT", "2");
            }
            if("2".equals(status2)){
                criteria.add("MEDICAL_DEPT_AUDIT", "1");
            }
            if("3".equals(status2)){
                criteria.add("CENTER_AUDIT", "2");
            }
            if("4".equals(status2)){
                criteria.add("CENTER_AUDIT", "1");
            }
        }
        Date transferDateBegin = DateUtil.parseSimpleDate(this.transferDateBegin, "yyyy/MM/dd");
        Date transferDateEnd = DateUtil.parseSimpleDate(this.transferDateEnd, "yyyy/MM/dd");
        DateUtil.getCriteriaByDateRange(criteria, "TRANSFER_DT", transferDateBegin,transferDateEnd);
		return criteria;
	}
}
