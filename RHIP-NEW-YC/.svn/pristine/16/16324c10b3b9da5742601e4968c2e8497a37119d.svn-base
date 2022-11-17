package com.founder.rhip.ehr.entity.cic;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.util.ObjectUtil;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "CIC_TARGET")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class CicTarget implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@XmlTransient
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
	private Long id;

	@XmlTransient
	@Column(name = "PERSON_ID", columnDefinition = "VARCHAR2|人员唯一编码|38|", length = 38, nullable = true)
	private String personId;

	@XmlTransient
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@XmlElement(nillable = true)
	@Column(name = "ASTHMA_FLAG", columnDefinition = "VARCHAR2|哮喘标志|1|", length = 1, nullable = true)
	private String asthmaFlag;

	@XmlElement(nillable = true)
	@Column(name = "HEART_DISEASE_FLAG", columnDefinition = "VARCHAR2|心脏病标志|1|", length = 1, nullable = true)
	private String heartDiseaseFlag;

	@XmlElement(nillable = true)
	@Column(name = "CARDIOVASCULAR_FLAG", columnDefinition = "VARCHAR2|心脑血管病标志|1|", length = 1, nullable = true)
	private String cardiovascularFlag;

	@XmlElement(nillable = true)
	@Column(name = "EPILEPSY_FLAG", columnDefinition = "VARCHAR2|癫痫病标志|1|", length = 1, nullable = true)
	private String epilepsyFlag;

	@XmlElement(nillable = true)
	@Column(name = "MENTAL_FLAG", columnDefinition = "VARCHAR2|精神病标志|1|", length = 1, nullable = true)
	private String mentalFlag;

	@XmlElement(nillable = true)
	@Column(name = "COAGULOPATHY_FLAG", columnDefinition = "VARCHAR2|凝血紊乱标志|1|", length = 1, nullable = true)
	private String coagulopathyFlag;

	@XmlElement(nillable = true)
	@Column(name = "DIABETES_FLAG", columnDefinition = "VARCHAR2|糖尿病标志|1|", length = 1, nullable = true)
	private String diabetesFlag;

	@XmlElement(nillable = true)
	@Column(name = "GLAUCOMA_FLAG", columnDefinition = "VARCHAR2|青光眼标志|1|", length = 1, nullable = true)
	private String glaucomaFlag;

	@XmlElement(nillable = true)
	@Column(name = "HEART_PACEMAKER_FLAG", columnDefinition = "VARCHAR2|心脏起搏器标志|1|", length = 1, nullable = true)
	private String heartPacemakerFlag;

	@XmlElement(nillable = true)
	@Column(name = "IRRITABILITY", columnDefinition = "VARCHAR2|过敏物质名称及反应(规则 名称:反应;名称:反应;)|4000|", length = 4000, nullable = true)
	private String irritability;

	@XmlElement(nillable = true)
	@Column(name = "ABO_CODE", columnDefinition = "VARCHAR2|ABO血型代码|1|", length = 1, nullable = true)
	private String aboCode;

	@XmlElement(nillable = true)
	@Column(name = "RH_CODE", columnDefinition = "VARCHAR2|RH血型代码|1|", length = 1, nullable = true)
	private String rhCode;

	@XmlElement(nillable = true)
	@Column(name = "IMMUNIZATION", columnDefinition = "VARCHAR2|免疫接种名称及时间(时间:YYYYMMDD)(规则 名称:时间;名称:时间;)|4000|", length = 4000, nullable = true)
	private String immunization;

	@XmlTransient
	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	/**
	 * 查询结果标识
	 * 0：未查到  1：市民卡写入成功，数据没有变化 2：成功 
	 */
	@Transient
	@XmlTransient
	private String flag = "0";
	
	/**
	 * 返回码
	 */
	@Transient
	private String code = "2000";
	
	/**
	 * 交易码
	 */
	@Transient
	private String transcode;
	
	/**
	 * 返回信息
	 */
	@Transient
	private String message ="成功！";
	
	/**
	 * 系统处理码
	 */
	@Transient
	private String rtncode = "0";
	
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAsthmaFlag() {
		return this.asthmaFlag;
	}

	public void setAsthmaFlag(String asthmaFlag) {
		this.asthmaFlag = asthmaFlag;
	}

	public String getHeartDiseaseFlag() {
		return this.heartDiseaseFlag;
	}

	public void setHeartDiseaseFlag(String heartDiseaseFlag) {
		this.heartDiseaseFlag = heartDiseaseFlag;
	}

	public String getCardiovascularFlag() {
		return this.cardiovascularFlag;
	}

	public void setCardiovascularFlag(String cardiovascularFlag) {
		this.cardiovascularFlag = cardiovascularFlag;
	}

	public String getEpilepsyFlag() {
		return this.epilepsyFlag;
	}

	public void setEpilepsyFlag(String epilepsyFlag) {
		this.epilepsyFlag = epilepsyFlag;
	}

	public String getMentalFlag() {
		return this.mentalFlag;
	}

	public void setMentalFlag(String mentalFlag) {
		this.mentalFlag = mentalFlag;
	}

	public String getCoagulopathyFlag() {
		return this.coagulopathyFlag;
	}

	public void setCoagulopathyFlag(String coagulopathyFlag) {
		this.coagulopathyFlag = coagulopathyFlag;
	}

	public String getDiabetesFlag() {
		return this.diabetesFlag;
	}

	public void setDiabetesFlag(String diabetesFlag) {
		this.diabetesFlag = diabetesFlag;
	}

	public String getGlaucomaFlag() {
		return this.glaucomaFlag;
	}

	public void setGlaucomaFlag(String glaucomaFlag) {
		this.glaucomaFlag = glaucomaFlag;
	}

	public String getHeartPacemakerFlag() {
		return this.heartPacemakerFlag;
	}

	public void setHeartPacemakerFlag(String heartPacemakerFlag) {
		this.heartPacemakerFlag = heartPacemakerFlag;
	}

	public String getIrritability() {
		return this.irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getAboCode() {
		return this.aboCode;
	}

	public void setAboCode(String aboCode) {
		this.aboCode = aboCode;
	}

	public String getRhCode() {
		return this.rhCode;
	}

	public void setRhCode(String rhCode) {
		this.rhCode = rhCode;
	}

	public String getImmunization() {
		return this.immunization;
	}

	public void setImmunization(String immunization) {
		this.immunization = immunization;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRtncode() {
		return rtncode;
	}

	public void setRtncode(String rtncode) {
		this.rtncode = rtncode;
	}
	
    public boolean equals(Object obj, Set<String> properties) {
		ConvertingWrapDynaBean dynaBeanOther = new ConvertingWrapDynaBean(obj);
		ConvertingWrapDynaBean dynaBeanThis = new ConvertingWrapDynaBean(this);
		if (properties.size() < 1) {
			properties.addAll(dynaBeanThis.getPropertyNames());
		}
		boolean result = true;
		try {
			Iterator<String> it = properties.iterator();
			while (it.hasNext()) {
				String property = it.next();
				Object value = dynaBeanOther.get(property);
				if (result&&decToUpdate(dynaBeanThis.get(property), value)) {
					result = false;
					break;
				}
			}
		} catch (Exception e) {
			new RuntimeException("计算和比较属性值时发生错误", e);
			e.printStackTrace();
		}
		return result;
    }
    
	/**
	 * 判断信息是否被修改
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean decToUpdate(Object left, Object right) {
		//一个为空，一个不为空，则表示已经更新
		if (ObjectUtil.isNullOrEmpty(left) && ObjectUtil.isNotEmpty(right)) {
			return true;
		}
		if (ObjectUtil.isNotEmpty(left) ) {
			if (ObjectUtil.isNullOrEmpty(right)) {
				return true;
			} else 	if (left instanceof Date) {
				return !(((Date) left).getTime() == ((Date) right).getTime());
			} else {
				return !left.equals(right);
			}
		}
		return false;
	}

}