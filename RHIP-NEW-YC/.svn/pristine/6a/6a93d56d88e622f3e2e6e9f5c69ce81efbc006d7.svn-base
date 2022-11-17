/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalConsultationDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.mdm.entity.Organization;

import java.util.Date;
import java.util.List;

/**
 * The interface I personal record managment service.
 */
public interface IPersonalRecordManagmentService {

    /**
     * 创建个人档案-封面
     *
     * @param personInfo the person info
     * @return PersonInfo person info
     */
    public PersonInfo createCover(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo);

    /**
     * 创建个人档案-基本信息
     *
     * @param personalBasicInfoDTO the personal basic info dTO
     * @return PersonalBasicInfoDTO personal basic info dTO
     */
    public PersonalBasicInfoDTO createBasicInfo(PersonalBasicInfoDTO personalBasicInfoDTO);

    /**
     * 创建个人档案-健康体检
     *
     * @param personalPhyExamDTO the personal phy exam dTO
     * @return PersonalPhyExamDTO
     */
    public void createPhysical(PersonalPhyExamDTO personalPhyExamDTO);

    /** 从慢病和老年人体检过来的数据保存到个人体检 */
    public String savePhyExamFromElderly(User user, Organization organ, PersonInfo personInfo, PhysiqueExamination physiqueExamination, List<HealthEvaluateAnomaly> anomalyList, List<HospitalizedHistory> hospitalizedHistoryList, List<FamilyBedHistory> familyBedHistoryList, List<DrugHistory> drugHistoryHistoryList, List<VaccinationInfo> vaccinationInfoList, String... properties);


    public void savePhyExamFromElderly(User user, PersonInfo personInfo, PhysiqueExamination physiqueExamination, List<HealthEvaluateAnomaly> anomalyList, List<HospitalizedHistory> hospitalizedHistoryList, List<FamilyBedHistory> familyBedHistoryList, List<DrugHistory> drugHistoryList, List<VaccinationInfo> vaccinationInfoList, String... properties);

    /**
     * 修改个人档案-封面
     *
     * @param personInfo the person info
     * @param properties the properties
     * @return boolean boolean
     */
    public boolean upateCover(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo, String... properties);

    /**
     * 修改个人档案-基本信息
     *
     * @param personalBasicInfoDTO the personal basic info dTO
     * @return boolean boolean
     */
    public boolean upateBasicInfo(PersonalBasicInfoDTO personalBasicInfoDTO);

    /**
     * 修改个人档案-健康体检
     *
     * @param personalPhyExamDTO the personal phy exam dTO
     * @return boolean boolean
     */
    public boolean updatePhysical(PersonalPhyExamDTO personalPhyExamDTO);

    /**
     * 查询个人档案-封面
     *
     * @param criteria the criteria
     * @return PersonInfo personal cover
     */
    public PersonInfo getPersonalCover(Criteria criteria);

    /**
     * 查询个人档案-基本信息
     *
     * @param criteria the criteria
     * @return PersonalBasicInfoDTO personal basic info
     */
    public PersonalBasicInfoDTO getPersonalBasicInfo(Criteria criteria);

    /**
     * 查询个人档案-健康体检
     *
     * @param criteria the criteria
     * @return PersonalPhyExamDTO personal physical
     */
    public PersonalPhyExamDTO getPersonalPhysical(Criteria criteria);

    public PersonalPhyExamDTO getPersonalPhysical(Criteria criteria, String ehrId);

    /**
     * Gets deformity history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getDeformityHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets family heredity history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getFamilyHeredityHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets expose history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getExposeHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets family history.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getFamilyHistory(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets trans blood history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getTransBloodHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets trauma history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getTraumaHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets surgery history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getSurgeryHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets disease history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getDiseaseHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * Gets drug allergy history list.
     *
     * @param result the result
     * @param criSearch the cri search
     */
    void getDrugAllergyHistoryList(PersonalBasicInfoDTO result, Criteria criSearch);

    /**
     * 更新学生档案星级到三星
     * @param idcard the idcard
     */
    public void updateStudentToThreeStar(String idcard);

    /**
     * 激活档案
     * @param personId the person id
     * @param filingFlag the filing flag
     * @return string
     */
    String activePersonRecord(Long personId, String filingFlag);

    /**
     * 更新档案星级到三星
     * @param personId the person id
     * @return the boolean
     */
    public boolean updateToThreeStar(Long personId);

    /**
     * 根据personId,获取本年度老年人健康体检信息记录表记录ID
     *
     * @param personId
     * @return Long
     * @author Ye jianfei
     */
    public Long getExamRecordId(Long personId);

    /**
     * 档案加密权限检查
     *
     * @param personInfo the person info
     * @param password the password
     * @return the int
     */
    public int checkRecordAccess(PersonInfo personInfo,String password);

    /**
     * 修改 健康档案浏览器密码
     * @param parameters
     * @param criteria
     */
    public void updateDecryptionPassword(Parameters parameters, Criteria criteria);

    /**
     * 更新档案状态
     * @param personId
     * @param filingFlag
     */
    public void updatePersonFilingFlag(Long personId, String filingFlag);

    public List<PhysiqueExamination> getPersonalPhysicalList(Criteria ca, Order order);

    /**
     * 获取单一的PhysiqueExamination实体对象
     * @param criteria
     * @return
     */
    PhysiqueExamination getPersonalPhysicalOne(Criteria criteria);

    /**
     * 仅仅是已建档的星级变化记录
     * @param orgCode 变更人所属的机构编码
     * @param staffCode 变更人的医务人员编码
     * @param personId
     * @param oldStar 老的星级
     * @param newStar 变化后的新星级
     */
    public void syncWork(String orgCode, String staffCode, Long personId, Integer oldStar, Integer newStar);

    /**
     * 获取单一的PersonalConsultationDTO实体对象
     * @param personId
     * @return
     */
    PersonalConsultationDTO getPersonalConsultationDto(Long personId);

    
    /**
     * 更新体检关联的体质辨识结果
     * @param phy
     */
    public void updateEchIdentification(PhysiqueExamination phy);

    public PhysiqueExamination deletePhysical(final Long personId, String ehrId,User currentUser,Organization currentOrg,String requestIp,String requestUri, String examCode);
}