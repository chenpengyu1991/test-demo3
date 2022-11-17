package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.ActivityInfoRh;
import com.founder.rhip.ehr.entity.basic.FamilyInfoRh;
import com.founder.rhip.ehr.entity.basic.PersonInfoRh;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecordRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmPersonInfoRh;
import com.founder.rhip.ehr.entity.management.DmReportInfoRh;


/**
 * Date: 17-1-5
 * 机构迁移日志
 */
public interface ITransferLogService {

    //查询机构个人档案迁移日志列表
    public PageList<PersonInfoRh> getEhrLogList(Page page, TransferOperationLog transferLog);
  //查询村委会个人档案迁移日志列表
    public PageList<PersonInfoRh> getVillageEhrLogList(Page page, TransferOperationLog transferLog);
    
    //查询机构迁移家庭档案列表 
    public PageList<FamilyInfoRh> getFamilyLogList(Page page, TransferOperationLog transferLog);
    //查询村委会迁移家庭档案列表
    public PageList<FamilyInfoRh> getVillageFamilyLogList(Page page,TransferOperationLog transferLog);
    
    //查询健康活动列表
    public PageList<ActivityInfoRh> getActivityLogList(Page page, TransferOperationLog transferLog);
    
    //查询慢病报卡
    public PageList<DmReportInfoRh> getReportList(Page page, TransferOperationLog transferLog);
    
    //查询慢病管理卡迁移日志列表 
    public PageList<DmPersonInfoRh> getCdmManaCardLogList(Page page, TransferOperationLog transferLog);
    
    //查询慢病管理卡村委会迁移日志列表
    public PageList<DmPersonInfoRh> getVillageCdmManaCardLogList(Page page, TransferOperationLog transferLog);
    
    //查询老年人健康管理
    public PageList<PhysicalExamRecordRh> getElderPhyExamLogList(Page page, TransferOperationLog transferLog);
}
