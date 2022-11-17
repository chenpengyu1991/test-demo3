package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NC_BLOOD_DONATION")
public class NcBloodDonation implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "WHOLE_BLOOD", columnDefinition = "NUMBER|全血献血量|10|", length = 10, nullable = false)
	private Integer wholeBlood;

	@Column(name = "OPERATE_DATE", columnDefinition = "DATE|时间||", nullable = false)
	private Date operateDate;

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

    public Integer getWholeBlood() {
        return wholeBlood;
    }

    public void setWholeBlood(Integer wholeBlood) {
        this.wholeBlood = wholeBlood;
    }

    public Date getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

}