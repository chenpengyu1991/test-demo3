package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by f on 2016/12/7.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class DrugResponse {
    private String name;
    private String referralHospitalName;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date clinicDate;
    private String drugGenericName;
    private String drugSpecifications;
    private BigDecimal quantity;
    private String quantityUnit;

    public String getName() {
        return name;
    }

    public String getReferralHospitalName() {
        return referralHospitalName;
    }

    public Date getClinicDate() {
        return clinicDate;
    }

    public String getDrugGenericName() {
        return drugGenericName;
    }

    public String getDrugSpecifications() {
        return drugSpecifications;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public void setDrugGenericName(String drugGenericName) {
        this.drugGenericName = drugGenericName;
    }

    public void setDrugSpecifications(String drugSpecifications) {
        if (drugSpecifications == null) {
            this.drugSpecifications = "";
        } else {
            this.drugSpecifications = drugSpecifications;
        }
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }
}
