package com.founder.rhip.ehr.entity.hsa;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @author liuk
 * @since 14-3-11 下午5:57
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "HSA_PENALTY_INFO")
public class PenaltyInfo {

    @XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "MAIN_ID", columnDefinition = "VARCHAR2|编号||", length = 20, nullable = true)
	private String mainId;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位名称||", length = 200, nullable = true)
	private String unitName;

	@Column(name = "BUSINESS_ADDRESS", columnDefinition = "VARCHAR2|经营地址名称||", length = 200, nullable = true)
	private String businessAddress;

	@Column(name = "PERSON_IN_CHARGE", columnDefinition = "VARCHAR2|负责人||", length = 50, nullable = true)
	private String personInCharge;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号||", length = 20, nullable = true)
	private String idCard;

	@Column(name = "PUNISH_TYPE", columnDefinition = "VARCHAR2|处罚程序||", length = 100, nullable = true)
	private String punishType;

	@Column(name = "CASE_CAUSE", columnDefinition = "VARCHAR2|案由||", length = 200, nullable = true)
	private String caseCause;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@Column(name = "BEGIN_CASE_DATE", columnDefinition = "TIMESTAMP|立案日期||", nullable = true)
	private Date beginCaseDate;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@Column(name = "END_CASE_DATE", columnDefinition = "TIMESTAMP|结案日期||", nullable = true)
	private Date endCaseDate;

    @XmlTransient
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

    @XmlTransient
    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @XmlTransient
    @Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
    private Integer isDelete;

	public static class DateAdapter extends XmlAdapter<String, Date> {

		private String pattern = "yyyyMMdd hh:mm:ss";

		@Override
		public Date unmarshal(String dateStr) throws Exception {
			if (ObjectUtil.isNullOrEmpty(dateStr)) {
				return null;
			}
			return DateUtil.parseSimpleDate(dateStr, pattern);
		}

		@Override
		public String marshal(Date date) throws Exception {
			if (ObjectUtil.isNullOrEmpty(date)) {
				return null;
			}
			return DateUtil.toDateString(date, pattern);
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddressName) {
		this.businessAddress = businessAddressName;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idcard) {
		this.idCard = idcard;
	}

	public String getPunishType() {
		return punishType;
	}

	public void setPunishType(String punishType) {
		this.punishType = punishType;
	}

	public String getCaseCause() {
		return caseCause;
	}

	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}

	public Date getBeginCaseDate() {
		return beginCaseDate;
	}

	public void setBeginCaseDate(Date beginCaseDate) {
		this.beginCaseDate = beginCaseDate;
	}

	public Date getEndCaseDate() {
		return endCaseDate;
	}

	public void setEndCaseDate(Date endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}
