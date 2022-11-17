package com.founder.rhip.ehr.entity.cic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@Table(name = "CIC_CITIZEN_CARD")
public class CicCitizenCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@NotEmpty(message="证件类型为空")
	@Pattern(regexp="0|1|2|3|4|5|6|7|8",message="证件类型值非法")
	@Column(name = "PAPER_TYPE", columnDefinition = "VARCHAR2|证件类型|1|", length = 1, nullable = true)
	private String paperType;

	@NotEmpty(message="证件号码为空")
	@Length(max = 30,message="证件号码长度过长")
	@Column(name = "PAPER_NO", columnDefinition = "VARCHAR2|证件号码|30|", length = 30, nullable = true)
	private String paperNo;

	@Length(max = 20,message="旧虞城通号长度过长")
	@Column(name = "OLD_CITIZEN_CARD_NO", columnDefinition = "VARCHAR2|旧虞城通号|20|", length = 20, nullable = true)
	private String oldCitizenCardNo;

	@NotEmpty(message="虞城通号为空")
	@Length(max = 20,message="虞城通号长度过长")
	@Column(name = "CITIZEN_CARD_NO", columnDefinition = "VARCHAR2|虞城通号|20|", length = 20, nullable = true)
	private String citizenCardNo;

	@NotEmpty(message="姓名为空")
	@Length(max = 30,message="姓名长度过长")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|30|", length = 30, nullable = true)
	private String name;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="发卡日期为空或格式非法")
	@Column(name = "RELEASE_DATE", columnDefinition = "DATE|发卡日期||", nullable = true)
	private Date releaseDate;

	@Length(max = 120,message="单位名称长度过长")
	@Column(name = "CORP_NAME", columnDefinition = "VARCHAR2|单位名称|120|", length = 120, nullable = true)
	private String corpName;

	@Length(max = 20,message="移动电话长度过长")
	@Column(name = "PHONE", columnDefinition = "VARCHAR2|移动电话|20|", length = 20, nullable = true)
	private String phone;

	@Length(max = 120,message="户籍地址长度过长")
	@Column(name = "PR_ADDR", columnDefinition = "VARCHAR2|户籍地址|120|", length = 120, nullable = true)
	private String prAddr;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="出生日期为空或格式非法")
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@NotEmpty(message="性别为空")
	@Pattern(regexp="1|2",message="性别值非法")
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@NotEmpty(message="市民卡状态为空")
	@Pattern(regexp="00|01|02|03",message="市民卡状态值非法")
	@Column(name = "CARD_STATUS", columnDefinition = "VARCHAR2|市民卡状态|2|", length = 2, nullable = true)
	private String cardStatus;

	@XmlTransient
	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@XmlTransient
	@Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构编码|20|", length = 20, nullable = true)
	private String createOrg;

	@XmlTransient
	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建人编码|100|", length = 100, nullable = true)
	private String createUser;

	@XmlTransient
	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@XmlTransient
	@Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构编码|50|", length = 50, nullable = true)
	private String updateOrg;

	@XmlTransient
	@Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新人编码|50|", length = 50, nullable = true)
	private String updateUser;

	@XmlTransient
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否删除|1|", length = 1, nullable = true)
	private Integer isDelete;

	@XmlTransient
	@Column(name = "INPUT_GBCODE", columnDefinition = "VARCHAR2|健康档案管理机构镇|50|", length = 50, nullable = true)
	private String inputGbcode;
	
	@XmlTransient
	@Column(name = "INPUT_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|健康档案管理机构中心|50|", length = 50, nullable = true)
	private String inputCenterOrganCode;
	
	@XmlTransient
	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|健康档案管理机构站|50|", length = 50, nullable = true)
	private String inputOrganCode;	
	
	@XmlTransient
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|健康档案地址所在镇|50|", length = 50, nullable = true)
	private String patownShip;
	
	@XmlTransient
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|健康档案常住类型|20|", length = 20, nullable = true)
	private String householdType;
	
	/**
	 * 交易码 
	 */
	@Transient
	private String transcode;
	
	/**
	 * 增减标识
	 */
	@Transient
	@NotEmpty(message="增减标识为空")
	@Pattern(regexp="0|1",message="增减标识值非法")
	private String flag;

	/**
	 * 起始日期
	 */
	@Transient
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="起始日期为空或格式非法")
	private Date starDate;
	
	/**
	 * 结束日期
	 */
	@Transient
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="结束日期为空或格式非法")
	private Date endDate;
	
	/**
	 * 交易时间
	 */
	@Transient
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="交易时间为空或格式非法")
	private Date txtDate;
	
	public static class DateAdapter extends XmlAdapter<String, Date> {

		private String pattern = "yyyyMMdd";

		@Override
		public Date unmarshal(String dateStr) throws Exception {
			if (ObjectUtil.isNullOrEmpty(dateStr)) {
				return null;
			}else if(dateStr.trim().length() != pattern.length()){
				return null;
			}
			return DateUtil.parseSimpleDate(dateStr.trim(), pattern);
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
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaperType() {
		return this.paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperNo() {
		return this.paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getOldCitizenCardNo() {
		return this.oldCitizenCardNo;
	}

	public void setOldCitizenCardNo(String oldCitizenCardNo) {
		this.oldCitizenCardNo = oldCitizenCardNo;
	}

	public String getCitizenCardNo() {
		return this.citizenCardNo;
	}

	public void setCitizenCardNo(String citizenCardNo) {
		this.citizenCardNo = citizenCardNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCorpName() {
		return this.corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrAddr() {
		return this.prAddr;
	}

	public void setPrAddr(String prAddr) {
		this.prAddr = prAddr;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCardStatus() {
		return this.cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(Date txtDate) {
		this.txtDate = txtDate;
	}

	public String getInputGbcode() {
		return inputGbcode;
	}

	public void setInputGbcode(String inputGbcode) {
		this.inputGbcode = inputGbcode;
	}

	public String getInputCenterOrganCode() {
		return inputCenterOrganCode;
	}

	public void setInputCenterOrganCode(String inputCenterOrganCode) {
		this.inputCenterOrganCode = inputCenterOrganCode;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

}