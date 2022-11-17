package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.entity.clinic.ImageIndex;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

public class StudyReportDTO {

    //检查信息
    private StudyEvent studyEvent;

    //检查信息列表
    List<StudyEvent> studyEventList;

    //影像信息
    private ImageIndex imageIndex;

    public List<StudyEvent> getStudyEventList() {
        return studyEventList;
    }

    public void setStudyEventList(List<StudyEvent> studyEventList) {
        this.studyEventList = studyEventList;
    }

    public StudyEvent getStudyEvent() {
        return studyEvent;
    }

    public void setStudyEvent(StudyEvent studyEvent) {
        this.studyEvent = studyEvent;
    }

    public ImageIndex getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(ImageIndex imageIndex) {
        this.imageIndex = imageIndex;
    }
}
