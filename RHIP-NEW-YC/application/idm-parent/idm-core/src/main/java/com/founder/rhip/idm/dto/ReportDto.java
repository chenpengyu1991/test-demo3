package com.founder.rhip.idm.dto;


import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReportDesc;

import java.io.Serializable;

public class ReportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private IdmReport report;

    private IdmReportDesc reportDesc;

    private String reSubmitFlag;//报卡监控，补卡标志
    
    private Integer logoff = 0;

    public Integer getLogoff() {
        return logoff == null ? 0 : logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public IdmReport getReport() {
        return report;
    }

    public void setReport(IdmReport report) {
        this.report = report;
    }

    public IdmReportDesc getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(IdmReportDesc reportDesc) {
        this.reportDesc = reportDesc;
    }

	public String getReSubmitFlag() {
		return reSubmitFlag;
	}

	public void setReSubmitFlag(String reSubmitFlag) {
		this.reSubmitFlag = reSubmitFlag;
	}
}