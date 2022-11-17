package com.founder.rhip.ehr.service.woman;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.founder.fasf.beans.*;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.MaternalHealthManage;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;
import com.founder.rhip.ehr.entity.women.PrenatalFollowupOther;
import com.founder.rhip.ehr.repository.women.IPrenatalFollowupDao;
import com.founder.rhip.ehr.repository.women.IPrenatalFollowupOtherDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jingqiu on 17-3-23.
 */
@Service("prenatalFollowupService")
public class PrenatalFollowupServiceImpl implements IPrenatalFollowupService,IPersonRecordMoveService {

    @Resource(name = "prenatalFollowupDao")
    private IPrenatalFollowupDao prenatalFollowupDao;  //产前随访服务信息表

    @Resource(name = "prenatalFollowupOtherDao")
    private IPrenatalFollowupOtherDao prenatalFollowupOtherDao;

    public PageList<PrenatalFollowup> getPrenatalFollowupList(Criteria criteria, Page page){
        return prenatalFollowupDao.getPageList(page, criteria, new Order("VISIT_DATE DESC, ID", false));
    }

    public PrenatalFollowup getPrenatalFollowup(Criteria criteria){
        return prenatalFollowupDao.get(criteria);
    }

    public void savePrenatalFollowup(PrenatalFollowup prenatalFollowup) {
    	
    	prenatalFollowup.setUpdateDate(new Date());
        if (ObjectUtil.isNullOrEmpty(prenatalFollowup.getId())) {
        	prenatalFollowup.setInputDate(new Date());
            prenatalFollowupDao.insert(prenatalFollowup);
        } else {
        	PrenatalFollowup prenatalFollowup1 = prenatalFollowupDao.get(prenatalFollowup.getId().toString());
        	prenatalFollowup.setInputDate(prenatalFollowup1.getInputDate());
            prenatalFollowupDao.update(prenatalFollowup);
        }
    }

    public int deletePrenatalFollowup(Long prenatalFollowupId) {
        int result = 0;
        if(ObjectUtil.isNullOrEmpty(prenatalFollowupId)) {
            return result;
        }
        result = prenatalFollowupDao.delete(new Criteria("id", prenatalFollowupId));
        return result;
    }

    public PageList<PrenatalFollowupOther> getPrenatalFollowupOtherList(Criteria criteria, Page page){
        return prenatalFollowupOtherDao.getPageList(page, criteria, new Order("ESTIMATED_DUE_DATES DESC, ID", false));
    }

    public PrenatalFollowupOther getPrenatalFollowupOther(Criteria criteria){
        return prenatalFollowupOtherDao.get(criteria);
    }

    public void savePrenatalFollowupOther(PrenatalFollowupOther prenatalFollowupOther) {
        if (ObjectUtil.isNullOrEmpty(prenatalFollowupOther.getId())) {
            prenatalFollowupOtherDao.insert(prenatalFollowupOther);
        } else {
            prenatalFollowupOtherDao.update(prenatalFollowupOther);
        }
    }

    public int deletePrenatalFollowupOther(Long prenatalFollowupOtherId) {
        int result = 0;
        if(ObjectUtil.isNullOrEmpty(prenatalFollowupOtherId)) {
            return result;
        }
        result = prenatalFollowupOtherDao.delete(new Criteria("id", prenatalFollowupOtherId));
        return result;
    }

    @Override
    public List<PrenatalFollowup> getList(Criteria criteria) {
        return prenatalFollowupDao.getList(criteria);
    }

    public Integer getPrenataFollNum(Integer year,Integer quarter,String orgCode){
        return prenatalFollowupDao.getPrenataFollNum(year,quarter,orgCode);
    }

	@Override
	public List<MaternalHealthManage> getMaternalHealthManage(Integer year, Integer quarter, List<String> organCodeList) {
		return prenatalFollowupDao.getMaternalHealthManage(year, quarter, organCodeList);
	}

    //档案迁移,孕产妇健康管理第1次产前随访服务记录,第2-5次产前随访服务记录
    @Override
    @Transactional
    public void personRecordMove(Long personId, String smpiId,Organization oldOrg, Organization newOrg) {
        Criteria criteria = new Criteria("personId", personId);
        Parameters parameters = new Parameters();
        parameters.add("createOrganCode", newOrg.getOrganCode());
        prenatalFollowupDao.update(parameters, criteria);
        prenatalFollowupOtherDao.update(parameters, criteria);
    }
}
