package com.founder.rhip.ce.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.ce.ContinueEducation;
import com.founder.rhip.ehr.repository.ce.IContinueEducationDao;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.repository.IStaffDao;

/**
 * Created by chen_wenbo on 2014/04/02.
 */
@Service("continueEducationService")
public class ContinueEducationServiceImpl implements IContinueEducationService {

    @Resource(name = "continueEducationDao")
    private IContinueEducationDao continueEducationDao;

    @Resource(name = "queryContinueEducationDao")
    private IContinueEducationDao queryContinueEducationDao;
    
    @Resource(name = "mdmStaffDao")
	private IStaffDao staffDao;
    
    @Override
    public PageList<ContinueEducation> getPageList(Page page, Criteria criteria) {
    	Order order = new Order("SMPI_ID", true);
        return continueEducationDao.getPageList(page, criteria, order);
    }
    
	@Override
	public List<ContinueEducation> getList(Criteria criteria) {
		return continueEducationDao.getList(criteria);
	}
	
	@Override
	public List<ContinueEducation> getList(Criteria criteria, Order order) {
		return continueEducationDao.getList(criteria, order);
	}

    @Override
    public ContinueEducation getContinueEducation(Criteria criteria) {
        return continueEducationDao.get(criteria);
    }

    @Override
    public int save(ContinueEducation continueEducation) {
        int result = 0;
        Long id = continueEducation.getId();
        if (ObjectUtil.isNotEmpty(id)) {
            result = continueEducationDao.update(continueEducation);
        } else {
            result = continueEducationDao.insert(continueEducation);
        }
        return result;
    }

    @Override
    public int delete(Criteria criteria) {
        return continueEducationDao.delete(criteria);
    }

	@Override
	public int updateStaff(Staff staff) {
		Parameters parameters = new Parameters();
		parameters.add("period", staff.getPeriod());
		parameters.add("creditA", staff.getCreditA());
		parameters.add("creditB", staff.getCreditB());
		Criteria criteria = new Criteria();
		criteria.add("staff_code", staff.getStaffCode());
		criteria.add("smpi_id", staff.getSmpiId());
		return staffDao.update(parameters, criteria);
	}

	@Override
	public Staff getStaff(Criteria criteria) {
		return staffDao.get(criteria);
	}
	
	@Override
	public PageList<ContinueEducation> getPageStaffCodeList(Page page, Criteria criteria)
	{
		return queryContinueEducationDao.getPageStaffCodeList(page, criteria);
	}

}
