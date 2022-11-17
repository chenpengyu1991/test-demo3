package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDM_DRUG_THERAPY")
public class DrugTherapy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "CHLOROQUINE_TOTAL", columnDefinition = "VARCHAR2|氯喹总量||", length = 20, nullable = true)
	private String chloroquineTotal;

	@Column(name = "TROCHE_1", columnDefinition = "VARCHAR2|第1天片数||", length = 20, nullable = true)
	private String troche1;

	@Column(name = "TROCHE_2", columnDefinition = "VARCHAR2|第2天片数||", length = 20, nullable = true)
	private String troche2;

	@Column(name = "TROCHE_3", columnDefinition = "VARCHAR2|第3天片数||", length = 20, nullable = true)
	private String troche3;

	@Column(name = "TROCHE_4", columnDefinition = "VARCHAR2|第4天片数||", length = 20, nullable = true)
	private String troche4;

	@Column(name = "PRIMAQUINE_TOTAL", columnDefinition = "VARCHAR2|伯喹总量||", length = 20, nullable = true)
	private String primaquineTotal;

	@Column(name = "DAYS_NUM", columnDefinition = "VARCHAR2|天数||", length = 20, nullable = true)
	private String daysNum;

	@Column(name = "TROCHE_PRE", columnDefinition = "VARCHAR2|每天片数||", length = 20, nullable = true)
	private String trochePre;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getChloroquineTotal() {
		return this.chloroquineTotal;
	}

	public void setChloroquineTotal(String chloroquineTotal) {
		this.chloroquineTotal = chloroquineTotal;
	}

	public String getTroche1() {
		return this.troche1;
	}

	public void setTroche1(String troche1) {
		this.troche1 = troche1;
	}

	public String getTroche2() {
		return this.troche2;
	}

	public void setTroche2(String troche2) {
		this.troche2 = troche2;
	}

	public String getTroche3() {
		return this.troche3;
	}

	public void setTroche3(String troche3) {
		this.troche3 = troche3;
	}

	public String getTroche4() {
		return this.troche4;
	}

	public void setTroche4(String troche4) {
		this.troche4 = troche4;
	}

	public String getPrimaquineTotal() {
		return this.primaquineTotal;
	}

	public void setPrimaquineTotal(String primaquineTotal) {
		this.primaquineTotal = primaquineTotal;
	}

	public String getDaysNum() {
		return this.daysNum;
	}

	public void setDaysNum(String daysNum) {
		this.daysNum = daysNum;
	}

    public String getTrochePre() {
        return trochePre;
    }

    public void setTrochePre(String trochePre) {
        this.trochePre = trochePre;
    }
}