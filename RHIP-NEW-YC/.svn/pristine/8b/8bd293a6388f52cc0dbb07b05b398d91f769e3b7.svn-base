package com.founder.rhip.ph.dto.vaccine;
import java.io.Serializable;
import java.util.List;

import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;

/**
 * @author 刘敬寅
 *
 */
public class VaccinationMgmtDTO implements Serializable {
	private static final long serialVersionUID = 2736755534315658502L;
	
	private VaccinationMgmt vaccinationMgmt;
	
	/**
	 * 咬傷情況
	 * */
	private TraumaHistory traumaHistory;
	
	/**
	 * 乙肝检查情况
	 * */
	private List<ExamineDetail> examineDetailList; 

	public List<ExamineDetail> getExamineDetailList() {
		return examineDetailList;
	}

	public void setExamineDetailList(List<ExamineDetail> examineDetailList) {
		this.examineDetailList = examineDetailList;
	}

	public VaccinationMgmt getVaccinationMgmt() {
		return vaccinationMgmt;
	}

	public void setVaccinationMgmt(VaccinationMgmt vaccinationMgmt) {
		this.vaccinationMgmt = vaccinationMgmt;
	}

	public TraumaHistory getTraumaHistory() {
		return traumaHistory;
	}

	public void setTraumaHistory(TraumaHistory traumaHistory) {
		this.traumaHistory = traumaHistory;
	}
	
}
