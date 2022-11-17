package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 人员信息相关
 * 
 * @author liuk
 * 
 */
public interface ICdmPersonService {
	/**
	 * 获取健康档案体检
	 * 
	 * @param personId
	 * @return
	 */
	PhysiqueExamination getPersonPhyExamination(Long personId);

	/**
	 * 获取健康档案基本信息
	 * 
	 * @param personId
	 * @return
	 */
	PersonalBasicInfoDTO getPersonBasicInfo(Long personId);

	/**
	 * 更新慢病人员信息
	 * 
	 * @param dmPersonInfo
	 * @param properties
	 */
	void saveOrUpdateDmPersonInfo(DmPersonInfo dmPersonInfo);

    /**
     * 更新慢病人员信息
     *
     * @param dmPersonInfo
     * @param properties
     */
    void saveOrReUpdateDmPersonInfo(DmPersonInfo dmPersonInfo);

	/**
	 * 慢病人员转为健康档案人员
	 * 
	 * @param dmPersonInfo
	 * @param personInfo
	 */
	void dmPersonInfoToEhrPersonInfo(DmPersonInfo dmPersonInfo, PersonInfo personInfo);

	/**
	 * 更新或者创建健康档案人员
	 * 
	 * @param personInfo
	 * @param user
	 * @param organization
	 */
	void saveOrUpdatePerson(PersonInfo personInfo, User user, Organization organization);

	/**
	 * 通过慢病人员相关信息执行更新或者创建健康档案人员
	 * 
	 * @param dmPersonInfo
	 * @param user
	 * @param organization
	 * @return
	 */
	Long createOrUpdatePersonUseDmPersonInfo(DmPersonInfo dmPersonInfo, User user, Organization organization);

	/**
	 * 获取健康档案信息
	 * @param personId
	 * @param pros
	 * @return
	 */
	PhysiqueExamination getPhyExamWithSeletedProperties(Long personId, String[] pros);

	/**
	 * 异步更新mdm
	 * @param personInfo
	 * @param user
	 * @param organization
	 */
	void saveOrUpdatePersonAsyn(PersonInfo personInfo, User user, Organization organization);

	/**
	 * 拷贝健康档案人员信息到慢病人员
	 * @param dmPersonInfo
	 * @param personInfo
	 */
	void ehrPersonInfoToDmPersonInfo(DmPersonInfo dmPersonInfo, PersonInfo personInfo);

	/**
	 * 更新报卡基本信息
	 */
     void updateDmPersonInfo(Parameters parameters, Criteria criteria);
}
