package com.founder.rhip.cdm.controller.reportcard;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.management.DmReportInfo;

import java.util.List;

/**
 * 报卡审核用
 * @author liuk
 *
 */
public class ReportForm {
	
	private List<DmReportInfo> report;
	private PersonInfo personInfo;
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public List<DmReportInfo> getReport() {
		return report;
	}
	public void setReport(List<DmReportInfo> report) {
		this.report = report;
	}
}
