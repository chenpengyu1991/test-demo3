package com.founder.rhip.ehr.entity.basic;

import com.founder.fasf.util.ObjectUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;


@Entity
@Table(name = "BI_POPULACE")
public class Populace implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|机构ID||", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "COUNT_YEAR", columnDefinition = "NUMBER|人口统计年度||", length = 9, nullable = true)
    private Integer countYear;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR|机构代码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR|机构名称||", length = 100, nullable = true)
    private String organName;

    @Column(name = "HOUSEHOLD_NUM", columnDefinition = "NUMBER|户籍人口数||", length = 9, nullable = true)
    private Integer householdNum;

    @Column(name = "UN_HOUSE_HOLD_NUM", columnDefinition = "NUMBER|流动人口数||", length = 9, nullable = true)
    private Integer unHouseHoldNum;

    @Column(name = "HOUSEHOLD_MAN_NUM", columnDefinition = "NUMBER|户籍男性人口数||", length = 9, nullable = true)
    private Integer householdManNum;

    @Column(name = "UN_HOUSEHOLD_MAN_NUM", columnDefinition = "NUMBER|流动男性人口数||", length = 9, nullable = true)
    private Integer unHouseholdManNum;

    @Column(name = "HOUSEHOLD_WOMAN_NUM", columnDefinition = "NUMBER|户籍女性人口数||", length = 9, nullable = true)
    private Integer householdWomanNum;

    @Column(name = "UN_HOUSEHOLD_WOMAN_NUM", columnDefinition = "NUMBER|流动女性人口数||", length = 9, nullable = true)
    private Integer unHouseholdWomanNum;

    @Column(name = "HOUSEHOLD_SIX_CHILD_NUM", columnDefinition = "NUMBER|户籍0-6岁儿童数量||", length = 9, nullable = true)
    private Integer householdSixChildNum;

    @Column(name = "UN_HOUSEHOLD_SIX_CHILD_NUM", columnDefinition = "NUMBER|流动0-6岁儿童数量||", length = 9, nullable = true)
    private Integer unHouseholdSixChildNum;

    @Column(name = "HOUSEHOLD_FERTILE_WOMAN_NUM", columnDefinition = "NUMBER|户籍育龄妇女数量||", length = 9, nullable = true)
    private Integer householdFertileWomanNum;

    @Column(name = "UN_HOUSEHOLD_FERTILE_WOMAN_NUM", columnDefinition = "NUMBER|流动育龄妇女数量||", length = 9, nullable = true)
    private Integer unHouseholdFertileWomanNum;

    @Column(name = "HOUSEHOLD_SIXO_TO_SIXF_NUM", columnDefinition = "NUMBER|户籍60-65岁老年人数量||", length = 9, nullable = true)
    private Integer householdSixoToSixfNum;

    @Column(name = "UN_HOUSEHOLD_SIXO_TO_SIXF_NUM", columnDefinition = "NUMBER|流动60-65岁老年人数量||", length = 9, nullable = true)
    private Integer unHouseholdSixoToSixfNum;

    @Column(name = "HOUSEHOLD_GREAT_SIXF_NUM", columnDefinition = "NUMBER|户籍>65岁老年人数量||", length = 9, nullable = true)
    private Integer householdGreatSixfNum;

    @Column(name = "UN_HOUSEHOLD_GREAT_SIXF_NUM", columnDefinition = "NUMBER|>66岁老年人数量||", length = 9, nullable = true)
    private Integer unHouseholdGreatSixfNum;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
    private String gbcode;
    
    @Column(name = "ORGAN_PARENT_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 12, nullable = true)
    private String organParentCode;

    @Column(name = "HOUSEHOLD_PHB_NUM", columnDefinition = "NUMBER|户籍高血压患者人数||", length = 9, nullable = true)
    private Integer householdPhbNum = 0;

    @Column(name = "UNHOUSEHOLD_PHB_NUM", columnDefinition = "NUMBER|非户籍高血压患者人数||", length = 9, nullable = true)
    private Integer unhouseholdPhbNum = 0;

    @Column(name = "HOUSEHOLD_DI_NUM", columnDefinition = "NUMBER|户籍糖尿病患者人数||", length = 9, nullable = true)
    private Integer householdDiNum = 0;

    @Column(name = "UNHOUSEHOLD_DI_NUM", columnDefinition = "NUMBER|非户籍糖尿病患者人数||", length = 9, nullable = true)
    private Integer unhouseholdDiNum = 0;

    @Column(name = "HOUSEHOLD_MENTAL_NUM", columnDefinition = "NUMBER|户籍精神病患者人数||", length = 9, nullable = true)
    private Integer householdMentalNum = 0;

    @Column(name = "UNHOUSEHOLD_MENTAL_NUM", columnDefinition = "NUMBER|非户籍精神病患者人数||", length = 9, nullable = true)
    private Integer unhouseholdMentalNum = 0;

    @Column(name = "FAMILY_NUM", columnDefinition = "NUMBER|家庭数||", length = 9, nullable = true)
    private Integer familyNum;

    @Transient
    private Integer total = 0;

    @Transient
    private Integer elderNum = 0;

    @Transient
    private Integer phbNum = 0;

    @Transient
    private Integer diNum = 0;

    @Transient
    private Integer psychosisNum = 0;

    //体质辨识人数
    @Transient
    private Integer identificationNum = 0;

    @Transient
    private Integer childNum = 0;

    @Transient
    private Integer maternalNum = 0;

    @Transient
    private Integer liveBirth = 0;

    public Integer getFamilyNum() {
        return familyNum;
    }

    public void setFamilyNum(Integer familyNum) {
        this.familyNum = familyNum;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCountYear() {
        return this.countYear;
    }

    public void setCountYear(Integer countYear) {
        this.countYear = countYear;
    }

    public String getOrganCode() {
        return this.organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return this.organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public Integer getHouseholdNum() {
        return this.householdNum;
    }

    public void setHouseholdNum(Integer householdNum) {
        this.householdNum = householdNum;
    }

    public Integer getHouseholdManNum() {
        return this.householdManNum;
    }

    public void setHouseholdManNum(Integer householdManNum) {
        this.householdManNum = householdManNum;
    }

    public Integer getUnHouseholdManNum() {
        return this.unHouseholdManNum;
    }

    public void setUnHouseholdManNum(Integer unHouseholdManNum) {
        this.unHouseholdManNum = unHouseholdManNum;
    }

    public Integer getHouseholdWomanNum() {
        return this.householdWomanNum;
    }

    public void setHouseholdWomanNum(Integer householdWomanNum) {
        this.householdWomanNum = householdWomanNum;
    }

    public Integer getUnHouseholdWomanNum() {
        return this.unHouseholdWomanNum;
    }

    public void setUnHouseholdWomanNum(Integer unHouseholdWomanNum) {
        this.unHouseholdWomanNum = unHouseholdWomanNum;
    }

    public Integer getHouseholdSixChildNum() {
        return householdSixChildNum;
    }

    public void setHouseholdSixChildNum(Integer householdSixChildNum) {
        this.householdSixChildNum = householdSixChildNum;
    }

    public Integer getUnHouseholdSixChildNum() {
        return unHouseholdSixChildNum;
    }

    public void setUnHouseholdSixChildNum(Integer unHouseholdSixChildNum) {
        this.unHouseholdSixChildNum = unHouseholdSixChildNum;
    }

    public Integer getHouseholdFertileWomanNum() {
        return this.householdFertileWomanNum;
    }

    public void setHouseholdFertileWomanNum(Integer householdFertileWomanNum) {
        this.householdFertileWomanNum = householdFertileWomanNum;
    }

    public Integer getUnHouseholdFertileWomanNum() {
        return this.unHouseholdFertileWomanNum;
    }

    public void setUnHouseholdFertileWomanNum(Integer unHouseholdFertileWomanNum) {
        this.unHouseholdFertileWomanNum = unHouseholdFertileWomanNum;
    }

    public Integer getUnHouseHoldNum() {
        return unHouseHoldNum;
    }

    public void setUnHouseHoldNum(Integer unHouseHoldNum) {
        this.unHouseHoldNum = unHouseHoldNum;
    }

    public Integer getHouseholdSixoToSixfNum() {
        return householdSixoToSixfNum;
    }

    public void setHouseholdSixoToSixfNum(Integer householdSixoToSixfNum) {
        this.householdSixoToSixfNum = householdSixoToSixfNum;
    }

    public Integer getUnHouseholdSixoToSixfNum() {
        return unHouseholdSixoToSixfNum;
    }

    public void setUnHouseholdSixoToSixfNum(Integer unHouseholdSixoToSixfNum) {
        this.unHouseholdSixoToSixfNum = unHouseholdSixoToSixfNum;
    }

    public Integer getHouseholdGreatSixfNum() {
        return householdGreatSixfNum;
    }

    public void setHouseholdGreatSixfNum(Integer householdGreatSixfNum) {
        this.householdGreatSixfNum = householdGreatSixfNum;
    }

    public Integer getUnHouseholdGreatSixfNum() {
        return unHouseholdGreatSixfNum;
    }

    public void setUnHouseholdGreatSixfNum(Integer unHouseholdGreatSixfNum) {
        this.unHouseholdGreatSixfNum = unHouseholdGreatSixfNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getOrganParentCode() {
		return organParentCode;
	}

	public void setOrganParentCode(String organParentCode) {
		this.organParentCode = organParentCode;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

    public Integer getElderNum() {
        return elderNum;
    }

    public void setElderNum(Integer elderNum) {
        this.elderNum = elderNum;
    }

    public Integer getPhbNum() {
        return phbNum;
    }

    public void setPhbNum(Integer phbNum) {
        this.phbNum = phbNum;
    }

    public Integer getDiNum() {
        return diNum;
    }

    public void setDiNum(Integer diNum) {
        this.diNum = diNum;
    }

    public Integer getPsychosisNum() {
        return psychosisNum;
    }

    public void setPsychosisNum(Integer psychosisNum) {
        this.psychosisNum = psychosisNum;
    }

    public Integer getIdentificationNum() {
        return identificationNum;
    }

    public void setIdentificationNum(Integer identificationNum) {
        this.identificationNum = identificationNum;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Integer getMaternalNum() {
        return maternalNum;
    }

    public void setMaternalNum(Integer maternalNum) {
        this.maternalNum = maternalNum;
    }

    public Integer getLiveBirth() {
        return liveBirth;
    }

    public void setLiveBirth(Integer liveBirth) {
        this.liveBirth = liveBirth;
    }

    public Integer getHouseholdPhbNum() {
        return householdPhbNum;
    }

    public void setHouseholdPhbNum(Integer householdPhbNum) {
        if(ObjectUtil.isNotEmpty(householdPhbNum)){
            this.householdPhbNum = householdPhbNum;
        }else {
            this.householdPhbNum = 0;
        }
    }

    public Integer getUnhouseholdPhbNum() {
        return unhouseholdPhbNum;
    }

    public void setUnhouseholdPhbNum(Integer unhouseholdPhbNum) {
        if(ObjectUtil.isNullOrEmpty(unhouseholdPhbNum)){
            this.unhouseholdPhbNum = 0;
        }else {
            this.unhouseholdPhbNum = unhouseholdPhbNum;
        }
    }

    public Integer getHouseholdDiNum() {
        return householdDiNum;
    }

    public void setHouseholdDiNum(Integer householdDiNum) {
        if(ObjectUtil.isNotEmpty(householdDiNum)) {
            this.householdDiNum = householdDiNum;
        }else {
            this.householdDiNum = 0;
        }
    }

    public Integer getUnhouseholdDiNum() {
        return unhouseholdDiNum;
    }

    public void setUnhouseholdDiNum(Integer unhouseholdDiNum) {
        if(ObjectUtil.isNullOrEmpty(unhouseholdDiNum)){
            this.unhouseholdDiNum = 0;
        }else {
            this.unhouseholdDiNum = unhouseholdDiNum;
        }
    }

    public Integer getHouseholdMentalNum() {
        return householdMentalNum;
    }

    public void setHouseholdMentalNum(Integer householdMentalNum) {
        if(ObjectUtil.isNotEmpty(householdMentalNum)) {
            this.householdMentalNum = householdMentalNum;
        }else {
            this.householdMentalNum = 0;
        }
    }

    public Integer getUnhouseholdMentalNum() {
        return unhouseholdMentalNum;
    }

    public void setUnhouseholdMentalNum(Integer unhouseholdMentalNum) {
        if(ObjectUtil.isNullOrEmpty(unhouseholdMentalNum)){
            this.unhouseholdMentalNum = 0;
        }else {
            this.unhouseholdMentalNum = unhouseholdMentalNum;
        }
    }
}