package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Table(name = "PO_USER")
public class PortalUser implements Serializable{

    @Column(name = "ID")
    private Integer id; //编号
    @Column(name = "ORGAN_CODE")
    private String organCode; //所属公司
    @Column(name = "STAFF_CODE")
    private String staffCode; //所属人员
    @Column(name = "USER_CODE")
    private String userCode;
    @Column(name = "NAME")
    private String name; //人员姓名
    @Column(name = "USERNAME")
    private String username; //用户名
    @Column(name = "PASSWORD")
    private String password; //密码
    @Column(name = "SALT")
    private String salt; //加密密码的盐
    @Column(name = "STATUS")
    private Boolean status = Boolean.TRUE;
    @Column(name = "ROLE_IDS")
    private String roleIds; //拥有的角色列表

    public PortalUser() {
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
