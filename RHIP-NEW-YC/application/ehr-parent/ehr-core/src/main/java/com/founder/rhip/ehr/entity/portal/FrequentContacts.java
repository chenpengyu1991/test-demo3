package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "FREQUENT_CONTACTS")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class FrequentContacts implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ID = "id";

	public static final String FREQUENT_NAME = "frequentName";

	public static final String GENDER = "gender";

	public static final String TELEPHONE = "telephone";

	public static final String CARD_NO = "cardNo";

	public static final String ACCOUNT_ID = "accountId";

	public static final String BIRTHDAY = "birthday";

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "FREQUENT_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String frequentName;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|50|", length = 50, nullable = true)
	private String gender;

	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|手机号码|18|", length = 18, nullable = true)
	private String telephone;

	@Column(name = "CARD_NO", columnDefinition = "VARCHAR2|证件号码|50|", length = 50, nullable = true)
	private String cardNo;

	@Column(name = "ACCOUNT_ID", columnDefinition = "NUMBER|用户ID|11|", length = 11, nullable = false)
	private Long accountId;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date birthday;

	@Column(name = "RESERVE_STATUS", columnDefinition = "VARCHAR2|预约功能开启状态 0：禁用 1：可用|20|", length = 20, nullable = true)
	private String reserveStatus = "1";

	private String realName;//隶属用户姓名
	
	private String idCard; //隶属用户身份证号
	
	public Long getId() {
		return id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFrequentName() {
		return frequentName;
	}

	public void setFrequentName(String frequentName) {
		this.frequentName = frequentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
}