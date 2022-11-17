package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OUT_REGINFO")
public class OutReginfo implements Serializable {

	private static final long serialVersionUID = 8553424421257022152L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号|50|", length = 50, nullable = true)
	private String idCard;

	@Column(name = "SICK_ID", columnDefinition = "VARCHAR2|病人唯一号|50|", length = 50, nullable = true)
	private String sickId;

	@Column(name = "HOSPITAL_NO", columnDefinition = "VARCHAR2|医院编号|20|", length = 20, nullable = true)
	private String hospitalNo;

	@Column(name = "RESERVE_FIELD1", columnDefinition = "VARCHAR2|保留字段1|50|", length = 50,nullable = true)
	private String reserveField1;
	
	@Column(name = "RESERVE_FIELD2", columnDefinition = "VARCHAR2|保留字段2|50|", length = 50,nullable = true)
	private String reserveField2;
	
	@Column(name = "RESERVE_FIELD3", columnDefinition = "VARCHAR2|保留字段3|50|",length = 50, nullable = true)
	private String reserveField3;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSickId() {
		return sickId;
	}

	public void setSickId(String sickId) {
		this.sickId = sickId;
	}

	public String getHospitalNo() {
        return hospitalNo;
    }

    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    public String getReserveField1() {
        return reserveField1;
    }

    public void setReserveField1(String reserveField1) {
        this.reserveField1 = reserveField1;
    }

    public String getReserveField2() {
        return reserveField2;
    }

    public void setReserveField2(String reserveField2) {
        this.reserveField2 = reserveField2;
    }

    public String getReserveField3() {
        return reserveField3;
    }

    public void setReserveField3(String reserveField3) {
        this.reserveField3 = reserveField3;
    }
}