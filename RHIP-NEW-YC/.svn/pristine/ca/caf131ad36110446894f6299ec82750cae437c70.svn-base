package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "BI_DEPARTMENT")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "SUP_DEPARTMENTS_CODE", columnDefinition = "VARCHAR2|上级科室编码||", length = 5, nullable = true)
    private String supDepartmentsCode;

    @Column(name = "AGENCY_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|机构科室编码||", length = 5, nullable = true)
    private String agencyDepartmentCode;

    @Column(name = "AGENCY_DEPARTMENT_ABBREVIATION", columnDefinition = "VARCHAR2|机构科室简称||", length = 50, nullable = true)
    private String agencyDepartmentAbbreviation;

    @Column(name = "AGENCY_DEPARTMENT_FULL_NAME", columnDefinition = "VARCHAR2|机构科室全称||", length = 70, nullable = true)
    private String agencyDepartmentFullName;

    @Column(name = "AGENCIES_DEPARTMENTS_CATEGORY", columnDefinition = "VARCHAR2|机构科室类别||", length = 5, nullable = true)
    private String agenciesDepartmentsCategory;

    @Column(name = "SUBORDINATE_ORGANIZATIONS_CODE", columnDefinition = "VARCHAR2|所属机构编码||", length = 15, nullable = true)
    private String subordinateOrganizationsCode;

    @Column(name = "SUBORDINATE_ORGANIZATIONS_NAME", columnDefinition = "VARCHAR2|所属机构名称||", length = 70, nullable = true)
    private String subordinateOrganizationsName;

    @Column(name = "DEPARTMENT_PHONE", columnDefinition = "VARCHAR2|科室电话||", length = 20, nullable = true)
    private String departmentPhone;

    @Column(name = "DEPARTMENT_FAX", columnDefinition = "VARCHAR2|科室传真||", length = 20, nullable = true)
    private String departmentFax;

    @Column(name = "M_NUMBER", columnDefinition = "NUMBER|男性职工人数||", length = 8, nullable = true)
    private Integer mNumber;

    @Column(name = "F_NUMBER", columnDefinition = "NUMBER|女性职工人数||", length = 8, nullable = true)
    private Integer fNumber;

    @Column(name = "START_DATE", columnDefinition = "DATE|科室成立日期||", nullable = true)
    private Date startDate;

    @Column(name = "END_DATE", columnDefinition = "DATE|科室撤销日期||", nullable = true)
    private Date endDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSupDepartmentsCode() {
        return this.supDepartmentsCode;
    }

    public void setSupDepartmentsCode(String supDepartmentsCode) {
        this.supDepartmentsCode = supDepartmentsCode;
    }

    public String getAgencyDepartmentCode() {
        return this.agencyDepartmentCode;
    }

    public void setAgencyDepartmentCode(String agencyDepartmentCode) {
        this.agencyDepartmentCode = agencyDepartmentCode;
    }

    public String getAgencyDepartmentAbbreviation() {
        return this.agencyDepartmentAbbreviation;
    }

    public void setAgencyDepartmentAbbreviation(String agencyDepartmentAbbreviation) {
        this.agencyDepartmentAbbreviation = agencyDepartmentAbbreviation;
    }

    public String getAgencyDepartmentFullName() {
        return this.agencyDepartmentFullName;
    }

    public void setAgencyDepartmentFullName(String agencyDepartmentFullName) {
        this.agencyDepartmentFullName = agencyDepartmentFullName;
    }

    public String getAgenciesDepartmentsCategory() {
        return this.agenciesDepartmentsCategory;
    }

    public void setAgenciesDepartmentsCategory(String agenciesDepartmentsCategory) {
        this.agenciesDepartmentsCategory = agenciesDepartmentsCategory;
    }

    public String getSubordinateOrganizationsCode() {
        return this.subordinateOrganizationsCode;
    }

    public void setSubordinateOrganizationsCode(String subordinateOrganizationsCode) {
        this.subordinateOrganizationsCode = subordinateOrganizationsCode;
    }

    public String getSubordinateOrganizationsName() {
        return this.subordinateOrganizationsName;
    }

    public void setSubordinateOrganizationsName(String subordinateOrganizationsName) {
        this.subordinateOrganizationsName = subordinateOrganizationsName;
    }

    public String getDepartmentPhone() {
        return this.departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public String getDepartmentFax() {
        return this.departmentFax;
    }

    public void setDepartmentFax(String departmentFax) {
        this.departmentFax = departmentFax;
    }

    public Integer getMNumber() {
        return this.mNumber;
    }

    public void setMNumber(Integer mNumber) {
        this.mNumber = mNumber;
    }

    public Integer getFNumber() {
        return this.fNumber;
    }

    public void setFNumber(Integer fNumber) {
        this.fNumber = fNumber;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
