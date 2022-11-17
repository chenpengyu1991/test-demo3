package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

/**
 * 用于体检专项
 * @author ggf
 *
 */
public class ExamSpecialDTO {
	private PhysiqueExamination physiqueExamination;
	private List<ExamineEvent> examineEvents;
	private List<ExamineDetail> examineDetails;
	private List<StudyEvent> studyEvents;
	
	public PhysiqueExamination getPhysiqueExamination() {
		return physiqueExamination;
	}
	public void setPhysiqueExamination(PhysiqueExamination physiqueExamination) {
		this.physiqueExamination = physiqueExamination;
	}
	public List<ExamineEvent> getExamineEvents() {
		return examineEvents;
	}
	public void setExamineEvents(List<ExamineEvent> examineEvents) {
		this.examineEvents = examineEvents;
	}
	public List<ExamineDetail> getExamineDetails() {
		return examineDetails;
	}
	public void setExamineDetails(List<ExamineDetail> examineDetails) {
		this.examineDetails = examineDetails;
	}
	public List<StudyEvent> getStudyEvents() {
		return studyEvents;
	}
	public void setStudyEvents(List<StudyEvent> studyEvents) {
		this.studyEvents = studyEvents;
	}
}
