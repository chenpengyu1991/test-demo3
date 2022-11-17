package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of ChildHealthExamination
 */
public interface IChildHealthExaminationDao extends IDao<ChildHealthExamination, String> {

//    public Map countChildHealthExam(Map<String, String> paramMap, List orgCodes);

    //按记录统计
    public Map countHealthExamination(Map<String, String> paramMap, List orgCodes);

    //按人统计
    public Map countHealthExaminationByPerson(Map<String, String> paramMap, List orgCodes);

    //岁以下系统管理
    public Map count3Mgnt(Map<String, String> paramMap, List orgCodes);

    //7岁以下保健覆盖
    public Map count7Mgnt(Map<String, String> paramMap, List orgCodes);
    
    /**
     * 获取儿童体检统计信息
     * @param dateStr 采集日期
     * @return
     */
    public List<Map<String, Object>> getChildHealthExaminationMapList(String dateStr);
    
    /**
     * 获取儿童保健工作量
     * @param dateStr
     * @return
     */
    public List<Map<String, Object>> getChildCareWorkLoad(String dateStr);

    /**
     * 更新儿童出生日期
     * @param birthday
     * @param personId
     */
    public void updateBirthDay(String idCard, String birthday, String babyNo, Long personId);

    /**
     * 机构和村关系变化
     * @param org
     * @param newAddVillageCodes
     */
    void updateOrganByVillage(Organization org, String[] newAddVillageCodes);

}