package com.founder.rhip.ehr.service.star;

import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * 星级获取
 *
 * @author liuk
 */
public interface IRecordStarService {

    /**
     * 计算1星级
     *
     * @param personalBasicInfo
     */
    void calOneStarRecord(IValidateDTO personalBasicInfo);

    /**
     * 计算星级
     *
     * @param personalPhyExam
     */
    void calTwoAndThreeStarRecord(IValidateDTO personalPhyExam);
    
    /**
     * 计算2星级
     * @param personalBasicInfo
     */
    void calTwoStarRecord(IValidateDTO personalBasicInfo);
    
    /**
     * 计算3星级
     * @param personalBasicInfo
     */
    void calThreeStarRecord(IValidateDTO personalPhyExam);

    /**
     * 更新星级相关属性到数据库
     *
     * @param personInfo
     */
    void updateStar(PersonInfo personInfo);

    /**
     * 拷贝星级相关属性
     *
     * @param to
     * @param from
     */
    void copyStar(PersonInfo to, PersonInfo from);
}
