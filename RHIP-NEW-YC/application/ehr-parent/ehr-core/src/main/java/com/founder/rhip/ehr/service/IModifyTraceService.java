package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.ModifyTrace;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * 修改痕迹保存
 *
 * @author donghong
 */
public interface IModifyTraceService {

    public void executeCover(PersonInfo personInfo, String[] properties);

    /**
     * 保存个人基本信息表修改痕迹
     *
     * @param personalBasicInfoDTO
     */
    public void executeBasicInfo(PersonalBasicInfoDTO personalBasicInfoDTO);

    /**
     * 保存个人体检表修改痕迹
     *
     * @param personalPhyExamDTO
     */
    public void executePhyExam(PersonalPhyExamDTO personalPhyExamDTO);

    public PageList<ModifyTrace> getModifyTraceList(Criteria criteria, Page page, Order order);
    
    public void setModifyTrace(ModifyTrace modifyTrace);
}
