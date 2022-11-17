package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "MDM_USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private List<UserRole> userRoles;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|子增长字段|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "USER_CODE", columnDefinition = "VARCHAR2|用户标识|10|", length = 10, nullable = false)
    private String userCode;
    
    @NotEmpty(message = "请输入用户名！")
    @Size(max = 20, message = "超过用户名最大长度限制！")
    @Column(name = "USER_NAME", columnDefinition = "VARCHAR2|用户名称|50|", length = 50, nullable = true)
    private String userName;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2|登录密码|50|", length = 50, nullable = true)
    private String password;

    @NotEmpty(message = "请输入姓名！")
    @Size(max = 20, message = "超过用户姓名最大长度限制！")
    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|20|", length = 20, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "NUMBER|性别|1|", length = 1, nullable = true)
    private Integer gender;

    @Past(message = "请输入正确的出生日期！")
    @Column(name = "BIRTH_DATE", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthDate;

    /*@NotEmpty(message = "请输入身份证！")*/
    @Size(max = 20, message = "超过身份证号最大长度限制！")
    @Column(name = "IDENTITY_CARD", columnDefinition = "VARCHAR2|身份证号|20|", length = 20, nullable = true)
    private String identityCard;

    @Email(message = "请输入正确的电子邮件格式！")
    @Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮件|100|", length = 100, nullable = true)
    private String email;

    @Size(max = 20, message = "超过联系电话最大长度限制！")
    @Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|联系电话|50|", length = 50, nullable = true)
    private String telephone;

    @Size(max = 20, message = "超过手机号码最大长度限制！")
    @Column(name = "MOBILE", columnDefinition = "VARCHAR2|手机号码|20|", length = 20, nullable = true)
    private String mobile;

    @Column(name = "HOME_ADDRESS", columnDefinition = "VARCHAR2|家庭住址|100|", length = 200, nullable = true)
    private String homeAddress;

    @Size(max = 200, message = "超过用户描述最大长度限制！")
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

	/** 关联的是STAFF.SMPI_ID */
    @NotEmpty(message = "选择正确的人员信息！")
    @Column(name = "STAFF_CODE", columnDefinition = "VARCHAR2|人员标示|20|", length = 20, nullable = false)
    private String staffCode;

    @Column(name = "LAST_LOGIN_ORG", columnDefinition = "VARCHAR2|最后登录机构编码|20|", length = 20, nullable = false)
    private String lastLoginOrg;

    @Column(name = "CIC_PERMISSION", columnDefinition = "VARCHAR2|健康档案查看权限 0:有权限 1:无权限", length = 1, nullable = false)
    private String cicPermission;

    @Column(name = "LOCK_FLAG", columnDefinition = "VARCHAR2|用户是否锁定 0:未锁定 1:锁定", length = 1, nullable = false)
    private String lockFlag;

    @Column(name = "LOGIN_ERROR_COUNT", columnDefinition = "NUMBER|登录失败次数", length = 1, nullable = false)
    private Integer loginErrorCount;

    @Column(name = "LOCK_TIME", columnDefinition = "VARCHAR2|用户锁定时的时间", length = 1, nullable = false)
    private Date lockTime;


    //	@NotEmpty(message="请选择角色！")
    private String role;

    private String orgId;

    //private Integer[] roleIds;


    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
/*

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
    }*/

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

    public String getLastLoginOrg() {
        return lastLoginOrg;
    }

    public void setLastLoginOrg(String lastLoginOrg) {
        this.lastLoginOrg = lastLoginOrg;
    }

    public String getCicPermission() {
        return cicPermission;
    }

    public void setCicPermission(String cicPermission) {
        this.cicPermission = cicPermission;
    }
}