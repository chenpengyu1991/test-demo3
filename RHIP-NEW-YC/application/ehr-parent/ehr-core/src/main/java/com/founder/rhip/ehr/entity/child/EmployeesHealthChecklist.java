package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MS_EMPLOYEES_HEALTH_CHECKLIST")
@XmlRootElement
public class EmployeesHealthChecklist implements Serializable {
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "person_id", columnDefinition = "VARCHAR2|personid|11|", length = 11, nullable = false)
    private String personId;

    @Column(name = "physical_examination_date", columnDefinition = "DATE|体检日期||", nullable = true)
    private Date physicalExaminationDate;

    @Column(name = "registered_residence", columnDefinition = "VARCHAR2|个人户口所在地||", nullable = true)
    private String registeredResidence;

    @Column(name = "physical_examination_no", columnDefinition = "VARCHAR2|编号||", nullable = true)
    private String physicalExaminationNo;


    @Column(name = "companys", columnDefinition = "VARCHAR2|单位||", nullable = true)
    private String companys;

    @Column(name = "nature", columnDefinition = "VARCHAR2|性质||", nullable = true)
    private String nature;


    @Column(name = "name", columnDefinition = "VARCHAR2|姓名||", nullable = true)
    private String name;

    @Column(name = "genders", columnDefinition = "VARCHAR2|性别||", nullable = true)
    private String genders;


    @Column(name = "family_name", columnDefinition = "VARCHAR2|名族||", nullable = true)
    private String familyName;

    @Column(name = "age", columnDefinition = "VARCHAR2|年龄||", nullable = true)
    private String age;


    @Column(name = "company_detail_address", columnDefinition = "VARCHAR2|单位详细地址||", nullable = true)
    private String companyDetailAddress;

    @Column(name = "industry_category", columnDefinition = "VARCHAR2|本人工种||", nullable = true)
    private String industryCategory;


    @Column(name = "myself_work_type", columnDefinition = "VARCHAR2|体检日期||", nullable = true)
    private String myselfWorkType;

    @Column(name = "hepatitis_date", columnDefinition = "DATE|肝炎患病时间||", nullable = true)
    private Date hepatitisDate;


    @Column(name = "dysentery_date", columnDefinition = "DATE|痢疾患病时间||", nullable = true)
    private Date dysenteryDate;

    @Column(name = "typhoidfever_date", columnDefinition = "DATE|伤寒患病时间||", nullable = true)
    private Date typhoidfeverDate;


    @Column(name = "tuberculosis_date", columnDefinition = "DATE|肺结核患病时间||", nullable = true)
    private Date tuberculosisDate;

    @Column(name = "skindisease_date", columnDefinition = "DATE|皮肤病患病时间||", nullable = true)
    private Date skindiseaseDate;


    @Column(name = "cardiac_sign", columnDefinition = "VARCHAR2|心脏体征||", nullable = true)
    private String cardiacSign;

    @Column(name = "liver_sign", columnDefinition = "VARCHAR2|肝脏体征||", nullable = true)
    private String liverSign;


    @Column(name = "splenic_sign", columnDefinition = "VARCHAR2|脾脏体征||", nullable = true)
    private String splenicSign;

    @Column(name = "lung_sign", columnDefinition = "VARCHAR2|肺体征||", nullable = true)
    private String lungSign;


    @Column(name = "skin_sign", columnDefinition = "VARCHAR2|皮肤体征||", nullable = true)
    private String skinSign;

    @Column(name = "skin_diseases_type", columnDefinition = "VARCHAR2|皮肤体征类型||", nullable = true)
    private String skinDiseasesType;


    @Column(name = "other_skin_signs", columnDefinition = "VARCHAR2|其它皮肤体征||", nullable = true)
    private String otherSkinSigns;

    @Column(name = "sign_doctor_signature", columnDefinition = "VARCHAR2|体征医生签名||", nullable = true)
    private String signDoctorSignature;


    @Column(name = "chest", columnDefinition = "VARCHAR2|胸透||", nullable = true)
    private String chest;

    @Column(name = "chest_doctor_signature", columnDefinition = "VARCHAR2|胸透医生签名||", nullable = true)
    private String chestDoctorSignature;


    @Column(name = "dysentery_bacillus", columnDefinition = "VARCHAR2|体检痢疾杆菌||", nullable = true)
    private String dysenteryBacillus;

    @Column(name = "dysentery_bacillus_doctor", columnDefinition = "VARCHAR2|痢疾杆菌医生签名||", nullable = true)
    private String dysenteryBacillusDoctor;


    @Column(name = "typhoid_result", columnDefinition = "VARCHAR2|伤寒检查结果||", nullable = true)
    private String typhoidResult;

    @Column(name = "typhoid_doctor_signature", columnDefinition = "VARCHAR2|伤寒医生签名||", nullable = true)
    private String typhoidDoctorSignature;


    @Column(name = "glutamic_pyruvic_transaminase", columnDefinition = "VARCHAR2|谷丙转氨酶||", nullable = true)
    private String glutamicPyruvicTransaminase;

    @Column(name = "hepatitisa", columnDefinition = "VARCHAR2|甲肝||", nullable = true)
    private String hepatitisa;

    @Column(name = "glutamic_pyruvic_doctor", columnDefinition = "VARCHAR2|谷丙转氨酶医生签名||", nullable = true)
    private String glutamicPyruvicDoctor;

    @Column(name = "hepatitisa_doctor", columnDefinition = "VARCHAR2|甲肝医生签名||", nullable = true)
    private String hepatitisaDoctor;


    @Column(name = "hepatitise", columnDefinition = "VARCHAR2|戊肝||", nullable = true)
    private String hepatitise;

    @Column(name = "hepatitise_doctor", columnDefinition = "VARCHAR2|戊肝医生签名||", nullable = true)
    private String hepatitiseDoctor;


    @Column(name = "trust", columnDefinition = "VARCHAR2|trust||", nullable = true)
    private String trust;

    @Column(name = "inspect_result", columnDefinition = "VARCHAR2|检查结论||", nullable = true)
    private String inspectResult;


    @Column(name = "inspect_result_doctor", columnDefinition = "VARCHAR2|主检医生签名||", nullable = true)
    private String inspectResultDoctor;

    @Column(name = "inspect_result_date", columnDefinition = "DATE|主检医生签名时间||", nullable = true)
    private Date inspectResultDate;

    @Column(name = "preventive_opinion", columnDefinition = "VARCHAR2|疾病预防控制意见||", nullable = true)
    private String preventiveOpinion;

    @Column(name = "preventive_opinion_date", columnDefinition = "DATE|疾病预防控制意见时间||", nullable = true)
    private Date preventiveOpinionDate;

    @Column(name = "is_delete", columnDefinition = "VARCHAR2|删除标识||", nullable = true)
    private String isDelete;

    @Column(name = "create_time", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "DATE|更新时间||", nullable = true)
    private Date updateTime;

    @Column(name = "create_person", columnDefinition = "VARCHAR2|创建人||", nullable = true)
    private String creaPerson;

    @Column(name = "update_person", columnDefinition = "VARCHAR2|更新人||", nullable = true)
    private String updatePerson;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号||", nullable = true)
    private String idcard;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
    private String createOrganCode;

    @Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
    private String createOrganName;

    @Column(name = "HEPATITIS_FLAG", columnDefinition = "VARCHAR2|肝炎标识||", length = 10, nullable = true)
    private String hepatitisFlag;

    @Column(name = "DYSENTERY_FLAG", columnDefinition = "VARCHAR2|痢疾标识||", length = 10, nullable = true)
    private String dysenteryFlag;

    @Column(name = "TUBERCULOSIS_FLAG", columnDefinition = "VARCHAR2|肺结核标识||", length = 10, nullable = true)
    private String tuberculosisFlag;

    @Column(name = "SKINDISEASE_FLAG", columnDefinition = "VARCHAR2|皮肤病标识||", length = 10, nullable = true)
    private String skindiseaseFlag;

    @Column(name = "TYPHOIDFEVER_FLAG", columnDefinition = "VARCHAR2|伤寒标识||", length = 10, nullable = true)
    private String typhoidfeverFlag;

    @Column(name = "NZZ_FLAG", columnDefinition = "VARCHAR2|其他标识||", length = 10, nullable = true)
    private String nzzFlag;

    @Column(name = "NZZ_DATE", columnDefinition = "DATE|其他患病时间||", length = 30, nullable = true)
    private Date nzzDate;

    @Column(name = "disease_History_Flag", columnDefinition = "VARCHAR2|既往史标识||", length = 10, nullable = true)
    private String diseaseHistoryFlag;

    public String getDiseaseHistoryFlag() {
        return diseaseHistoryFlag;
    }

    public void setDiseaseHistoryFlag(String diseaseHistoryFlag) {
        this.diseaseHistoryFlag = diseaseHistoryFlag;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getHepatitisFlag() {
        return hepatitisFlag;
    }

    public void setHepatitisFlag(String hepatitisFlag) {
        this.hepatitisFlag = hepatitisFlag;
    }

    public String getDysenteryFlag() {
        return dysenteryFlag;
    }

    public void setDysenteryFlag(String dysenteryFlag) {
        this.dysenteryFlag = dysenteryFlag;
    }

    public String getTuberculosisFlag() {
        return tuberculosisFlag;
    }

    public void setTuberculosisFlag(String tuberculosisFlag) {
        this.tuberculosisFlag = tuberculosisFlag;
    }

    public String getSkindiseaseFlag() {
        return skindiseaseFlag;
    }

    public void setSkindiseaseFlag(String skindiseaseFlag) {
        this.skindiseaseFlag = skindiseaseFlag;
    }

    public String getTyphoidfeverFlag() {
        return typhoidfeverFlag;
    }

    public void setTyphoidfeverFlag(String typhoidfeverFlag) {
        this.typhoidfeverFlag = typhoidfeverFlag;
    }

    public String getNzzFlag() {
        return nzzFlag;
    }

    public void setNzzFlag(String nzzFlag) {
        this.nzzFlag = nzzFlag;
    }

    public Date getNzzDate() {
        return nzzDate;
    }

    public void setNzzDate(Date nzzDate) {
        this.nzzDate = nzzDate;
    }

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getCreateOrganName() {
        return createOrganName;
    }

    public void setCreateOrganName(String createOrganName) {
        this.createOrganName = createOrganName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreaPerson() {
        return creaPerson;
    }

    public void setCreaPerson(String creaPerson) {
        this.creaPerson = creaPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPhysicalExaminationDate() {
        return physicalExaminationDate;
    }

    public void setPhysicalExaminationDate(Date physicalExaminationDate) {
        this.physicalExaminationDate = physicalExaminationDate;
    }

    public String getRegisteredResidence() {
        return registeredResidence;
    }

    public void setRegisteredResidence(String registeredResidence) {
        this.registeredResidence = registeredResidence;
    }

    public String getPhysicalExaminationNo() {
        return physicalExaminationNo;
    }

    public void setPhysicalExaminationNo(String physicalExaminationNo) {
        this.physicalExaminationNo = physicalExaminationNo;
    }

    public String getCompanys() {
        return companys;
    }

    public void setCompanys(String companys) {
        this.companys = companys;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCompanyDetailAddress() {
        return companyDetailAddress;
    }

    public void setCompanyDetailAddress(String companyDetailAddress) {
        this.companyDetailAddress = companyDetailAddress;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getMyselfWorkType() {
        return myselfWorkType;
    }

    public void setMyselfWorkType(String myselfWorkType) {
        this.myselfWorkType = myselfWorkType;
    }

    public Date getHepatitisDate() {
        return hepatitisDate;
    }

    public void setHepatitisDate(Date hepatitisDate) {
        this.hepatitisDate = hepatitisDate;
    }

    public Date getDysenteryDate() {
        return dysenteryDate;
    }

    public void setDysenteryDate(Date dysenteryDate) {
        this.dysenteryDate = dysenteryDate;
    }

    public Date getTyphoidfeverDate() {
        return typhoidfeverDate;
    }

    public void setTyphoidfeverDate(Date typhoidfeverDate) {
        this.typhoidfeverDate = typhoidfeverDate;
    }

    public Date getTuberculosisDate() {
        return tuberculosisDate;
    }

    public void setTuberculosisDate(Date tuberculosisDate) {
        this.tuberculosisDate = tuberculosisDate;
    }

    public Date getSkindiseaseDate() {
        return skindiseaseDate;
    }

    public void setSkindiseaseDate(Date skindiseaseDate) {
        this.skindiseaseDate = skindiseaseDate;
    }

    public String getCardiacSign() {
        return cardiacSign;
    }

    public void setCardiacSign(String cardiacSign) {
        this.cardiacSign = cardiacSign;
    }

    public String getLiverSign() {
        return liverSign;
    }

    public void setLiverSign(String liverSign) {
        this.liverSign = liverSign;
    }

    public String getSplenicSign() {
        return splenicSign;
    }

    public void setSplenicSign(String splenicSign) {
        this.splenicSign = splenicSign;
    }

    public String getLungSign() {
        return lungSign;
    }

    public void setLungSign(String lungSign) {
        this.lungSign = lungSign;
    }

    public String getSkinSign() {
        return skinSign;
    }

    public void setSkinSign(String skinSign) {
        this.skinSign = skinSign;
    }

    public String getSkinDiseasesType() {
        return skinDiseasesType;
    }

    public void setSkinDiseasesType(String skinDiseasesType) {
        this.skinDiseasesType = skinDiseasesType;
    }

    public String getOtherSkinSigns() {
        return otherSkinSigns;
    }

    public void setOtherSkinSigns(String otherSkinSigns) {
        this.otherSkinSigns = otherSkinSigns;
    }

    public String getSignDoctorSignature() {
        return signDoctorSignature;
    }

    public void setSignDoctorSignature(String signDoctorSignature) {
        this.signDoctorSignature = signDoctorSignature;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getChestDoctorSignature() {
        return chestDoctorSignature;
    }

    public void setChestDoctorSignature(String chestDoctorSignature) {
        this.chestDoctorSignature = chestDoctorSignature;
    }

    public String getDysenteryBacillus() {
        return dysenteryBacillus;
    }

    public void setDysenteryBacillus(String dysenteryBacillus) {
        this.dysenteryBacillus = dysenteryBacillus;
    }

    public String getDysenteryBacillusDoctor() {
        return dysenteryBacillusDoctor;
    }

    public void setDysenteryBacillusDoctor(String dysenteryBacillusDoctor) {
        this.dysenteryBacillusDoctor = dysenteryBacillusDoctor;
    }

    public String getTyphoidResult() {
        return typhoidResult;
    }

    public void setTyphoidResult(String typhoidResult) {
        this.typhoidResult = typhoidResult;
    }

    public String getTyphoidDoctorSignature() {
        return typhoidDoctorSignature;
    }

    public void setTyphoidDoctorSignature(String typhoidDoctorSignature) {
        this.typhoidDoctorSignature = typhoidDoctorSignature;
    }

    public String getGlutamicPyruvicTransaminase() {
        return glutamicPyruvicTransaminase;
    }

    public void setGlutamicPyruvicTransaminase(String glutamicPyruvicTransaminase) {
        this.glutamicPyruvicTransaminase = glutamicPyruvicTransaminase;
    }

    public String getHepatitisa() {
        return hepatitisa;
    }

    public void setHepatitisa(String hepatitisa) {
        this.hepatitisa = hepatitisa;
    }

    public String getGlutamicPyruvicDoctor() {
        return glutamicPyruvicDoctor;
    }

    public void setGlutamicPyruvicDoctor(String glutamicPyruvicDoctor) {
        this.glutamicPyruvicDoctor = glutamicPyruvicDoctor;
    }

    public String getHepatitisaDoctor() {
        return hepatitisaDoctor;
    }

    public void setHepatitisaDoctor(String hepatitisaDoctor) {
        this.hepatitisaDoctor = hepatitisaDoctor;
    }

    public String getHepatitise() {
        return hepatitise;
    }

    public void setHepatitise(String hepatitise) {
        this.hepatitise = hepatitise;
    }

    public String getHepatitiseDoctor() {
        return hepatitiseDoctor;
    }

    public void setHepatitiseDoctor(String hepatitiseDoctor) {
        this.hepatitiseDoctor = hepatitiseDoctor;
    }

    public String getTrust() {
        return trust;
    }

    public void setTrust(String trust) {
        this.trust = trust;
    }

    public String getInspectResult() {
        return inspectResult;
    }

    public void setInspectResult(String inspectResult) {
        this.inspectResult = inspectResult;
    }

    public String getInspectResultDoctor() {
        return inspectResultDoctor;
    }

    public void setInspectResultDoctor(String inspectResultDoctor) {
        this.inspectResultDoctor = inspectResultDoctor;
    }

    public Date getInspectResultDate() {
        return inspectResultDate;
    }

    public void setInspectResultDate(Date inspectResultDate) {
        this.inspectResultDate = inspectResultDate;
    }

    public String getPreventiveOpinion() {
        return preventiveOpinion;
    }

    public void setPreventiveOpinion(String preventiveOpinion) {
        this.preventiveOpinion = preventiveOpinion;
    }

    public Date getPreventiveOpinionDate() {
        return preventiveOpinionDate;
    }

    public void setPreventiveOpinionDate(Date preventiveOpinionDate) {
        this.preventiveOpinionDate = preventiveOpinionDate;
    }


}
