package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.Consultation;

import java.util.List;


public class PersonalConsultationDTO implements IValidateDTO {

    //个人基本信息
    private PersonInfo personInfo;

    //体格检查记录
    private List<Consultation> consultations;

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}