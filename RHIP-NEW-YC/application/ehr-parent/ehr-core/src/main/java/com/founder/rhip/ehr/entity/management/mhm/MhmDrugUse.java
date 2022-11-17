package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MHM_DRUG_USE")
public class MhmDrugUse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表id（人）|11|", length = 11, nullable = false)
	private Long statusId;

	@Column(name = "DRUG_ID", columnDefinition = "NUMBER|药品字典表id（药）|11|", length = 11, nullable = true)
	private Long drugId;

	@Column(name = "USE_DT", columnDefinition = "DATE|发药时间|50|", length = 50, nullable = true)
	private Date useDt;

	@Column(name = "USE_COUNT", columnDefinition = "NUMBER|发药数量|20|", length = 20, nullable = true)
	private Integer useCount;

	@Column(name = "CURRENT_UNIT_ORICE", columnDefinition = "NUMBER|发药当时单价||", scale = 5, precision = 2, nullable = true)
	private BigDecimal currentUnitOrice;

	@Column(name = "CURRENT_PRICE", columnDefinition = "NUMBER|发药当时总价||", scale = 5, precision = 2, nullable = true)
	private BigDecimal currentPrice;

	@Column(name = "FREE_TYPE", columnDefinition = "VARCHAR2|病人类型（1免费，2不免费）|2|", length = 2, nullable = true)
	private String freeType;

    @Column(name = "FILL_ORGAN_TOWN", columnDefinition = "VARCHAR2|填报机构－镇|100|", length = 100, nullable = true)
    private String fillOrganTown;
    
    @Column(name = "FILL_ORGAN_CENTER", columnDefinition = "VARCHAR2|填报机构－中心|100|", length = 100, nullable = true)
    private String fillOrganCenter;
    
    @Column(name = "FILL_ORGAN_STATION", columnDefinition = "VARCHAR2|填报机构－站|100|", length = 100, nullable = true)
    private String fillOrganStation;    

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_TOWN", columnDefinition = "VARCHAR2|修改机构－镇|100|", length = 100, nullable = true)
	private String modifyOrganTown;
	
	@Column(name = "MODIFY_ORGAN_CENTER", columnDefinition = "VARCHAR2|修改机构－中心|100|", length = 100, nullable = true)
	private String modifyOrganCenter;
	
	@Column(name = "MODIFY_ORGAN_STATION", columnDefinition = "VARCHAR2|修改机构－站|100|", length = 100, nullable = true)
	private String modifyOrganStation;	

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态（0正常，1删除）|1|0", length = 1, nullable = false)
	private Integer isDelete;

    /*患者姓名*/
    @Transient
	private String name;
 
    /*患者性别*/
    @Transient
	private String gender;
    
    /*身份证号*/
    @Transient
	private String idcard;
    
    /*药品名称*/
    @Transient
	private String drugName;

    /*药品单位*/
    @Transient
	private String drugUnit;
 
    /*单位剂量*/
    @Transient
	private String unitMeasure;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	
	public Long getDrugId() {
		return drugId;
	}
	
	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}
	
	public Date getUseDt() {
		return useDt;
	}
	
	public void setUseDt(Date useDt) {
		this.useDt = useDt;
	}
	
	public Integer getUseCount() {
		return useCount;
	}
	
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
	
	public BigDecimal getCurrentUnitOrice() {
		return currentUnitOrice;
	}
	
	public void setCurrentUnitOrice(BigDecimal currentUnitOrice) {
		this.currentUnitOrice = currentUnitOrice;
	}
	
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public String getFreeType() {
		return freeType;
	}
	
	public void setFreeType(String freeType) {
		this.freeType = freeType;
	}
	
	public String getFillDoctorId() {
		return fillDoctorId;
	}
	
	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}
	
	public Date getFillDate() {
		return fillDate;
	}
	
	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}
	
	public String getModifyDoctorId() {
		return modifyDoctorId;
	}
	
	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public Integer getIsDelete() {
		return isDelete;
	}
	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getDrugName() {
		return drugName;
	}
	
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugUnit() {
		return drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public String getFillOrganTown() {
		return fillOrganTown;
	}

	public void setFillOrganTown(String fillOrganTown) {
		this.fillOrganTown = fillOrganTown;
	}

	public String getFillOrganCenter() {
		return fillOrganCenter;
	}

	public void setFillOrganCenter(String fillOrganCenter) {
		this.fillOrganCenter = fillOrganCenter;
	}

	public String getFillOrganStation() {
		return fillOrganStation;
	}

	public void setFillOrganStation(String fillOrganStation) {
		this.fillOrganStation = fillOrganStation;
	}

	public String getModifyOrganTown() {
		return modifyOrganTown;
	}

	public void setModifyOrganTown(String modifyOrganTown) {
		this.modifyOrganTown = modifyOrganTown;
	}

	public String getModifyOrganCenter() {
		return modifyOrganCenter;
	}

	public void setModifyOrganCenter(String modifyOrganCenter) {
		this.modifyOrganCenter = modifyOrganCenter;
	}

	public String getModifyOrganStation() {
		return modifyOrganStation;
	}

	public void setModifyOrganStation(String modifyOrganStation) {
		this.modifyOrganStation = modifyOrganStation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}