package com.founder.rhip.ehr.service.personal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.common.DisHistoryDisCode;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;

/**
 * The interface I platform service.
 */
public interface IPlatformService {

    /**
     * Query personal info.
     *
     * @param personName the person name
     * @param idCard the id card
     * @return the person info
     */
    PersonInfo queryPersonalInfo(String personName, String idCard);

    /**
     * 保存人员信息
     *
     * @param personInfo the person info
     * @param returnType the return type
     * @param integrateData             是否是集成数据
     * @return string
     */
	String createPerson(PersonInfo personInfo, String returnType, boolean integrateData);

    /**
     * 保存人员信息
     *
     * @param personInfo             公卫平台人员信息
     * @param domainId             域Id 人所属机构或者域的Id
     * @param localId             人员所在机构下面的唯一Id
     * @return 公卫平台人员Id或者主索引号 long
     */
	public long createPerson(PersonInfo personInfo, String domainId, String localId);
	public long createPerson(PersonInfo personInfo, String domainId);
    /**
     * Query personal info.
     *
     * @param pixId the pix id
     * @return the person info
     */
    PersonInfo queryPersonalInfo(String pixId);

    /**
     * Update person info.
     *
     * @param personInfo the person info
     * @param param the param
     * @return the int
     */
    int updatePersonInfo(PersonInfo personInfo, String... param);

    /**
     * Update person info no regist.
     *
     * @param personInfo the person info
     * @param param the param
     * @return the int
     */
    int updatePersonInfoNoRegist(PersonInfo personInfo, String... param);

    /**
     * Create ehr health event.
     *
     * @param type the type
     * @param personId the person id
     * @param eventDate the event date
     * @param organCode the organ code
     * @param organName the organ name
     * @return the string
     */
    String createEhrHealthEvent(EventType type, Long personId, Date eventDate, String organCode, String organName);

    /**
     * 通过id获取人员
     *
     * @param id the id
     * @return person info
     */
	PersonInfo queryPersonalInfo(Long id);

    /**
     * 根据条件返回Person Map List
     *
     * @param criteria the criteria
     * @param properties the properties
     * @return list
     */
	List<Map<String, Object>> queryPersonalInfoMap(Criteria criteria, String... properties);

    /**
     * 根据条件返回Person Map List
     *
     * @param criteria the criteria
     * @param order the order
     * @param properties the properties
     * @return list
     */
	List<Map<String, Object>> queryPersonalInfoMap(Criteria criteria, Order order, String... properties);

    /**
     * Save or update person info temp.
     *
     * @param personInfoTemp the person info temp
     */
    void saveOrUpdatePersonInfoTemp(PersonInfoTemp personInfoTemp);

    /**
     * Query personal info temp.
     *
     * @param id the id
     * @return the person info temp
     */
    PersonInfoTemp queryPersonalInfoTemp(Long id);

    /**
     * Update person info temp.
     *
     * @param personInfoTemp the person info temp
     */
    void updatePersonInfoTemp(PersonInfoTemp personInfoTemp);

    /**
     * 更新疾病史
     *
     * @param personId the person id
     * @param disCode the dis code
     * @param confirmationDate the confirmation date
     */
	void addDiseaseHistory(Long personId, DisHistoryDisCode disCode, Date confirmationDate);

    /**
     * Update person info asyn.
     *
     * @param personInfo the person info
     * @param param the param
     * @return the int
     */
    int updatePersonInfoAsyn(PersonInfo personInfo,String... param);

    /**
     * Query personal info.
     *
     * @param criteria the criteria
     * @return PersonInfo person info
     * @Title: queryPersonalInfo
     * @Description: 查询
     * @throws
     */
	PersonInfo queryPersonalInfo(Criteria criteria);

    /**
     * 删除疾病史
     * @param personId the person id
     * @param disCodes the dis codes
     */
	void deleteDiseaseHistory(Long personId, List<DisHistoryDisCode> disCodes);

    /**
     * Delete no id card person.
     *
     * @param personId the person id
     */
    void deleteNoIdCardPerson(Long personId);

    /**
     * 恢复已删除的疾病史
     * @param personId
     * @param disCodes
     */
    public void renewDiseaseHistory(Long personId, List<DisHistoryDisCode> disCodes);
}
