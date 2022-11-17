package com.founder.rhip.ehr.service.basic;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.ActivityInfoRh;
import com.founder.rhip.ehr.entity.basic.FamilyInfoRh;
import com.founder.rhip.ehr.entity.basic.PersonInfoRh;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecordRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmPersonInfoRh;
import com.founder.rhip.ehr.entity.management.DmReportInfoRh;
import com.founder.rhip.ehr.repository.basic.IActivityInfoRhDao;
import com.founder.rhip.ehr.repository.basic.IFamilyInfoRhDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoRhDao;
import com.founder.rhip.ehr.repository.management.IDmPersonInfoRhDao;
import com.founder.rhip.ehr.repository.management.IDmReportInfoRhDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordRhDao;


@Service("transferLogService")
public class TransferLogServiceImpl implements ITransferLogService {

    @Resource(name = "personInfoRhDao")
    private IPersonInfoRhDao personInfoRhDao;
    
	@Resource(name = "dmreportInfoRhDao")
    private IDmReportInfoRhDao dmreportInfoRhDao;
    
    @Resource(name = "dmPersonInfoRhDao")
    private IDmPersonInfoRhDao dmPersonInfoRhDao;
    
    @Resource(name = "physicalExamRecordRhDao")
    private IPhysicalExamRecordRhDao physicalExamRecordRhDao;
    
    @Resource(name = "familyInfoRhDao")
    private IFamilyInfoRhDao familyInfoRhDao;
    
    @Resource(name = "activityInfoRhDao")
    private IActivityInfoRhDao activityInfoRhdao;
	
	@Override
	public PageList<PersonInfoRh> getEhrLogList(Page page, TransferOperationLog transferLog) {
		 
		return personInfoRhDao.getTransferPersonInfo(page,transferLog);
    }
	
	@Override
	public PageList<PersonInfoRh> getVillageEhrLogList(Page page, TransferOperationLog transferLog) {
		 
		return personInfoRhDao.getVillageTransferPersonInfo(page,transferLog);
    }
	
    @Override
	public PageList<DmReportInfoRh> getReportList(Page page, TransferOperationLog transferLog) {
		
		return dmreportInfoRhDao.getTransferReportInfo(page, transferLog);
	}

	@Override
	public PageList<DmPersonInfoRh> getCdmManaCardLogList(Page page, TransferOperationLog transferLog) {
		 
		return dmPersonInfoRhDao.getTransferDmPersonInfo(page,transferLog);
    }
	
	@Override
	public PageList<DmPersonInfoRh> getVillageCdmManaCardLogList(Page page,
			TransferOperationLog transferLog) {
		
		return dmPersonInfoRhDao.getVillageTransferDmPersonInfo(page, transferLog);
	}
	
	@Override
	public PageList<PhysicalExamRecordRh> getElderPhyExamLogList(Page page, TransferOperationLog transferLog){
		 
		return physicalExamRecordRhDao.getphysicalexamrecordInfo(page,transferLog);
    }
	
	@Override
	public PageList<FamilyInfoRh> getFamilyLogList(Page page, TransferOperationLog transferLog) {
		return familyInfoRhDao.getTransferFamilyInfo(page, transferLog);
	}
	
	@Override
	public PageList<FamilyInfoRh> getVillageFamilyLogList(Page page,
			TransferOperationLog transferLog) {
		return familyInfoRhDao.getTransferVillageFamilyInfo(page, transferLog);
	}

	@Override
	public PageList<ActivityInfoRh> getActivityLogList(Page page,TransferOperationLog transferLog) {
		return activityInfoRhdao.getTransferActivityInfo(page, transferLog);
	}
}
