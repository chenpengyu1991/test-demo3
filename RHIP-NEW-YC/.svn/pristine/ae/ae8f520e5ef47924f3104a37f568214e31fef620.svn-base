package com.founder.elb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.fasf.util.ObjectUtil;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private List<UserRole> userRoles;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "USER_ID", columnDefinition = "VARCHAR2|用户ID|20|", length =20, nullable = true)
	private String userId;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2|用户名称|50|", length = 50, nullable = true)
	private String userName;

	@Column(name = "PASSWORD", columnDefinition = "VARCHAR2|登录密码|50|", length = 50, nullable = true)
	private String password;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|20|", length = 20, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "NUMBER|性别|1|", length = 1, nullable = true)
	private Integer gender;

	@Column(name = "BIRTH_DATE", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthDate;

	@Column(name = "IDENTITY_CARD", columnDefinition = "VARCHAR2|身份证号|20|", length = 20, nullable = true)
	private String identityCard;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮件|100|", length = 100, nullable = true)
	private String email;

	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|固定电话|50|", length = 50, nullable = true)
	private String telephone;

	@Column(name = "MOBILE", columnDefinition = "VARCHAR2|手机号码|20|", length = 20, nullable = true)
	private String mobile;

	@Column(name = "HOME_ADDRESS", columnDefinition = "VARCHAR2|家庭住址|100|", length = 200, nullable = true)
	private String homeAddress;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|用户描述|200|", length = 200, nullable = true)
	private String description;

	@Column(name = "STATUS", columnDefinition = "NUMBER|是否可用|1|", length = 1, nullable = true)
	private Integer status = 1;// 1表示可用 0 表示不可用

	@Column(name = "CREATOR", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = true)
	private Long creator;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATER", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = true)
	private Long updater;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date updateTime;
	
	private Integer[] roleIds;
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public void setRoles(Integer[] roleIds) {
		this.roleIds = roleIds;
		if (ObjectUtil.isNullOrEmpty(userRoles)) {
			userRoles = new ArrayList<UserRole>();
		}
		if (ObjectUtil.isNotEmpty(id) && ObjectUtil.isNotEmpty(roleIds)) {
			this.roleIds = roleIds;
			for (Integer roleId : roleIds) {
				if (ObjectUtil.isNotEmpty(roleId) && roleId > 0) {
					//userRoles.add(new UserRole(id, roleId));
				}
			}
		}
	}

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdater() {
		return this.updater;
	}

	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}