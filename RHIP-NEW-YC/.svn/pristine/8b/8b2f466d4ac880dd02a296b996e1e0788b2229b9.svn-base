package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NC_PERINATAL_CARD")
public class NcPerinatalCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|建卡日期||",  nullable = false)
	private Date createDt;

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

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}