package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.List;

import com.founder.rhip.ehr.entity.clinic.DrugUsage;

public class DrugUsageDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String drugTypeName;
    private String drugTypeCode;
    private List<DrugUsage> drugUsages;

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    public List<DrugUsage> getDrugUsages() {
        return drugUsages;
    }

    public void setDrugUsages(List<DrugUsage> drugUsages) {
        this.drugUsages = drugUsages;
    }

    public String getDrugTypeCode() {
        return drugTypeCode;
    }

    public void setDrugTypeCode(String drugTypeCode) {
        this.drugTypeCode = drugTypeCode;
    }
}
