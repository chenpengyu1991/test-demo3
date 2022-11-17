/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.StatusValue;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MDM_ORGANIZATION_HISTORY")
public class OrganizationHistory implements Serializable, Cloneable{

	private static final long serialVersionUID = 5438487900824598368L;

	public static final String ORGAN_CODE = "organCode";

	public static final String ORGAN_ID = "organId";

	public static final String STATUS = "status";

	public static final String OPERATOR = "operator";

	public static final String OPERATE_TIME = "operateTime";

	public static final String OPERATE_TYPE = "operateType";

	public static final String PARENT_CODE = "parentCode";

	public static final String DEFAULT_PARENT_CODE_VALUE = "0";

	@Transient
	private String areaCode;

	@Transient
	private String statusName;// 状态名称
	@Transient
	private String machineAddress; //前置机IP地址

	@Id
	@Column(name = "ORGAN_ID", columnDefinition = "NUMBER|机构ID||", length = 20, nullable = false)
	private Long organId;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = false)
	private String organCode;

	@Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上级机构编码||", length = 20, nullable = true)
	private String parentCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称||", length = 500, nullable = true)
	private String organName;

	@Column(name = "ECONOMY_CODE", columnDefinition = "VARCHAR2|机构经济类型代码||", length = 20, nullable = true)
	private String economyCode;

	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|卫生机构类别代码||", length = 20, nullable = true)
	private String genreCode;

	@Column(name = "MANAGE_CODE", columnDefinition = "VARCHAR2|机构分类管理代码||", length = 20, nullable = true)
	private String manageCode;

	@Column(name = "NATIONAL_ORGAN_CODE", columnDefinition = "VARCHAR2|组织机构代码||", length = 9, nullable = true)
	private String nationalOrganCode;

	@Column(name = "PROVINCE", columnDefinition = "VARCHAR2|单位地址-省(自治区、直辖市)||", length = 250, nullable = true)
	private String province;

	@Column(name = "CITY", columnDefinition = "VARCHAR2|单位地址-市(地区、州)||", length = 250, nullable = true)
	private String city;

	@Column(name = "COUNTY", columnDefinition = "VARCHAR2|单位地址-县(区)||", length = 250, nullable = true)
	private String county;

	@Column(name = "TOWN_SHIP", columnDefinition = "VARCHAR2|单位地址-乡(镇、街道办事处)||", length = 250, nullable = true)
	private String townShip;

	@Column(name = "STREET", columnDefinition = "VARCHAR2|单位地址-村(街、路、弄等)||", length = 250, nullable = true)
	private String street;

	@Column(name = "HOUSE_NUMBER", columnDefinition = "VARCHAR2|单位地址-门牌号码||", length = 250, nullable = true)
	private String houseNumber;

	@Column(name = "POST_CODE", columnDefinition = "VARCHAR2|邮政编码||", length = 20, nullable = true)
	private String postCode;

	@Column(name = "TEL", columnDefinition = "VARCHAR2|单位电话||", length = 20, nullable = true)
	private String tel;

	@Column(name = "FAX", columnDefinition = "VARCHAR2|单位传真||", length = 20, nullable = true)
	private String fax;

	@Column(name = "GRADE_CODE", columnDefinition = "VARCHAR2|医院等级代码||", length = 20, nullable = true)
	private String gradeCode;

	@Column(name = "MAIL", columnDefinition = "VARCHAR2|单位电子邮箱||", length = 70, nullable = true)
	private String mail;

	@Column(name = "ARTIFICIAL_PERSON", columnDefinition = "VARCHAR2|单位法人代表||", length = 150, nullable = true)
	private String artificialPerson;

	@Column(name = "ARTIFICIAL_IDCARD", columnDefinition = "VARCHAR2|法人代表身份证||", length = 20, nullable = true)
	private String artificialIdcard;

	@Column(name = "ARTIFICIAL_TEL", columnDefinition = "VARCHAR2|法人代表电话||", length = 20, nullable = true)
	private String artificialTel;

	@Column(name = "ARTIFICIAL_MOBIL", columnDefinition = "VARCHAR2|法人代表手机||", length = 20, nullable = true)
	private String artificialMobil;

	@Column(name = "MNUMBER", columnDefinition = "NUMBER|男性职工人数||", nullable = true)
	private Integer mnumber;

	@Column(name = "FNUMBER", columnDefinition = "NUMBER|女性职工人数||", nullable = true)
	private Integer fnumber;

	@Column(name = "START_DATE", columnDefinition = "DATE|单位成立日期||", nullable = true)
	private Date startDate;

	@Column(name = "END_DATE", columnDefinition = "DATE|单位撤销日期||", nullable = true)
	private Date endDate;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 20, nullable = true)
	private String gbCode;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;

	@Column(name = "ORGAN_NAME_TWO", columnDefinition = "VARCHAR2|第二机构名称||", length = 500, nullable = true)
	private String organNameTwo;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|地址||", length = 1000, nullable = true)
	private String address;

	@Column(name = "REGIST_CODE", columnDefinition = "VARCHAR2|登记号||", length = 30, nullable = true)
	private String registCode;

	@Column(name = "MANAGER", columnDefinition = "VARCHAR2|负责人||", length = 20, nullable = true)
	private String manager;

	@Column(name = "MANAGER_IDCARD", columnDefinition = "VARCHAR2|负责人身份证||", length = 20, nullable = true)
	private String managerIdcard;

	@Column(name = "BED_COUNT", columnDefinition = "VARCHAR2|床位数||", nullable = true)
	private Integer bedCount;

	@Column(name = "DENTAL_CHAIR_COUNT", columnDefinition = "VARCHAR2|牙椅数||" , nullable = true)
	private Integer dentalChairCount;

	@Column(name = "REGIST_CAPITAL", columnDefinition = "VARCHAR2|注册资金||" , nullable = true)
	private Float registCapital;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态||1", nullable = false)
	private Integer status = StatusValue.normalValue.getValue();

	@Column(name = "OPERATE_DETAIL", columnDefinition = "VARCHAR2|机构操作详情||", length = 500, nullable = true)
	private String operateDetail;

    @Column(name = "EQUIPMENT_NUM", columnDefinition = "NUMBER|专业设备数|", length = 4, nullable = true)
    private Integer equipmentNum;

    @Column(name = "AREA", columnDefinition = "NUMBER|房屋建筑面积||", scale = 2, precision = 8, nullable = true)
    private BigDecimal area;

    @Column(name = "BUSINESS_AREA", columnDefinition = "NUMBER|业务用房面积||", scale = 2, precision = 8, nullable = true)
    private BigDecimal businessArea;

    @Column(name = "DILAPIDATED_RATIO", columnDefinition = "NUMBER|危房比例||", scale = 4, precision = 8, nullable = true)
    private BigDecimal dilapidatedRatio;

    @Column(name = "CONSTRUCTION_AREA", columnDefinition = "NUMBER|年内施工面积||", scale = 2, precision = 8, nullable = true)
    private BigDecimal constructionArea;

    @Column(name = "COMPLETION_AREA", columnDefinition = "NUMBER|年内竣工面积||", scale = 2, precision = 8, nullable = true)
    private BigDecimal completionArea;

    private List<OrganizationHistory> childs = new ArrayList<OrganizationHistory>();

	private List<Department> departments = new ArrayList<Department>();

	public OrganizationHistory() {
		
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getEconomyCode() {
		return this.economyCode;
	}

	public void setEconomyCode(String economyCode) {
		this.economyCode = economyCode;
	}

	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getManageCode() {
		return this.manageCode;
	}

	public void setManageCode(String manageCode) {
		this.manageCode = manageCode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTownShip() {
		return this.townShip;
	}

	public void setTownShip(String townShip) {
		this.townShip = townShip;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGradeCode() {
		return this.gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getArtificialPerson() {
		return this.artificialPerson;
	}

	public void setArtificialPerson(String artificialPerson) {
		this.artificialPerson = artificialPerson;
	}

	public String getArtificialIdcard() {
		return this.artificialIdcard;
	}

	public void setArtificialIdcard(String artificialIdcard) {
		this.artificialIdcard = artificialIdcard;
	}

	public String getArtificialTel() {
		return this.artificialTel;
	}

	public void setArtificialTel(String artificialTel) {
		this.artificialTel = artificialTel;
	}

	public String getArtificialMobil() {
		return this.artificialMobil;
	}

	public void setArtificialMobil(String artificialMobil) {
		this.artificialMobil = artificialMobil;
	}

	public Integer getMnumber() {
		return this.mnumber;
	}

	public void setMnumber(Integer mnumber) {
		this.mnumber = mnumber;
	}

	public Integer getFnumber() {
		return this.fnumber;
	}

	public void setFnumber(Integer fnumber) {
		this.fnumber = fnumber;
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

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void addDepartments(Department department) {
		department.setOrganCode(organCode);
		department.setOrganName(organName);
		departments.add(department);
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public void addChild(OrganizationHistory organization) {
		organization.setParentCode(organCode);
		childs.add(organization);
	}

	public List<OrganizationHistory> getChilds() {
		return childs;
	}

	public void setChilds(List<OrganizationHistory> childs) {
		this.childs = childs;
	}

	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOrganNameTwo() {
		return organNameTwo;
	}

	public void setOrganNameTwo(String organNameTwo) {
		this.organNameTwo = organNameTwo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistCode() {
		return registCode;
	}

	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerIdcard() {
		return managerIdcard;
	}

	public void setManagerIdcard(String managerIdcard) {
		this.managerIdcard = managerIdcard;
	}

	public Integer getBedCount() {
		return bedCount;
	}

	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}

	public Integer getDentalChairCount() {
		return dentalChairCount;
	}

	public void setDentalChairCount(Integer dentalChairCount) {
		this.dentalChairCount = dentalChairCount;
	}

	public Float getRegistCapital() {
		return registCapital;
	}

	public void setRegistCapital(Float registCapital) {
		this.registCapital = registCapital;
	}
	
	public String getOrganizationMenuName() {
        if(StringUtils.isEmpty(organName)){
            return "";
        }
        
        if(organName.length()>12){
            return  organName.substring(0,10)+"....";
        }
        
        return organName;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public OrganizationHistory clone(){
		OrganizationHistory orgClone = null;
		try{  
			orgClone = (OrganizationHistory)super.clone();
		}catch(CloneNotSupportedException e){  
			e.printStackTrace();  
		}  
		 return orgClone;  
	}

	public String getOperateDetail() {
		return operateDetail;
	}

	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}

	public String getNationalOrganCode() {
		return nationalOrganCode;
	}

	public void setNationalOrganCode(String nationalOrganCode) {
		this.nationalOrganCode = nationalOrganCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMachineAddress() {
		return machineAddress;
	}

	public void setMachineAddress(String machineAddress) {
		this.machineAddress = machineAddress;
	}

    public Integer getEquipmentNum() {
        return equipmentNum;
    }

    public void setEquipmentNum(Integer equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(BigDecimal businessArea) {
        this.businessArea = businessArea;
    }

    public BigDecimal getDilapidatedRatio() {
        return dilapidatedRatio;
    }

    public void setDilapidatedRatio(BigDecimal dilapidatedRatio) {
        this.dilapidatedRatio = dilapidatedRatio;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public BigDecimal getCompletionArea() {
        return completionArea;
    }

    public void setCompletionArea(BigDecimal completionArea) {
        this.completionArea = completionArea;
    }
}