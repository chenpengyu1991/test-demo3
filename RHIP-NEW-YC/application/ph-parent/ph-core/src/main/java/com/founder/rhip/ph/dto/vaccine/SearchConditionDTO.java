package com.founder.rhip.ph.dto.vaccine;

import java.io.Serializable;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.hp.hpl.sparta.xpath.ThisNodeTest;

/**
 * @author xu_bin
 */
public class SearchConditionDTO implements Serializable {
	private static final long serialVersionUID = 5256909653313237202L;

	private String name; // 患者姓名

	private String idcard; // 身份证号

	private Date vaccinationFromDate;// 查询条件中开始时间

	private Date vaccinationToDate;// 查询条件中结束时间

	private String immType;// 接种疫苗类型

	private String gender;// 性别
	
	private String createOrg;// 接种单位
	
	private String barcode;//条形码 
	
	private String pneumoniaVaccFlag;// 23价疫苗接种标记

	public Criteria getSearchCondition() {
		Criteria criteria = new Criteria("MGMT.VACCINATION_TYPE","02").add("MGMT.IS_DELETE", 0).add("VE.IS_DELETE", 0);

		if (ObjectUtil.isNotEmpty(this.getName())) {
			criteria.add("MGMT.NAME", OP.LIKE, this.getName().trim());
		}
		if (ObjectUtil.isNotEmpty(this.getIdcard())) {
			criteria.add("MGMT.IDCARD",OP.LIKE, this.getIdcard().trim());
		}
		if (ObjectUtil.isNotEmpty(this.getGender()) && !("3".equals(this.getGender()))) {
			criteria.add("MGMT.GENDER", this.getGender());
		}
		if (ObjectUtil.isNotEmpty(this.getImmType()) && !"0".equals(this.getImmType())) {
			criteria.add("VE.IMMU_TYPE", this.getImmType());
		}
		if (ObjectUtil.isNotEmpty(this.pneumoniaVaccFlag)) {
			criteria.add("VE.PNEUMONIA_VACC_FLAG", this.getPneumoniaVaccFlag());
		}
		Date fromDate = this.getVaccinationFromDate();
		Date toDate = this.getVaccinationToDate();
		DateUtil.getCriteriaByDateRange(criteria, "VE.CREATE_DATE", fromDate, toDate);
		if (ObjectUtil.isNotEmpty(this.getName())||ObjectUtil.isNotEmpty(this.getIdcard())||ObjectUtil.isNotEmpty(this.getBarcode())) {
		}
		else{
			if (ObjectUtil.isNotEmpty(this.getCreateOrg())) {
				criteria.add("VE.CREATE_ORG", this.getCreateOrg());
			}
		}
		if (ObjectUtil.isNotEmpty(this.getBarcode())) {
			criteria.add("VE.BARCODE",OP.LIKE, this.getBarcode().trim());
		}		
		return criteria;
	}

	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}


	public Date getVaccinationFromDate() {
		return vaccinationFromDate;
	}

	public void setVaccinationFromDate(Date vaccinationFromDate) {
		this.vaccinationFromDate = vaccinationFromDate;
	}

	public Date getVaccinationToDate() {
		return vaccinationToDate;
	}

	public void setVaccinationToDate(Date vaccinationToDate) {
		this.vaccinationToDate = vaccinationToDate;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImmType() {
		return immType;
	}

	public void setImmType(String immType) {
		this.immType = immType;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPneumoniaVaccFlag() {
		return pneumoniaVaccFlag;
	}

	public void setPneumoniaVaccFlag(String pneumoniaVaccFlag) {
		this.pneumoniaVaccFlag = pneumoniaVaccFlag;
	}

	
}
