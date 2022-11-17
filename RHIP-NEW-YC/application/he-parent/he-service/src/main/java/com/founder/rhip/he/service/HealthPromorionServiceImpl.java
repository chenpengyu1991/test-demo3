package com.founder.rhip.he.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.healtheducation.HealthPromorion;
import com.founder.rhip.ehr.repository.healtheducation.IHealthPromorionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chen.q on 15-6-9.
 */
@Service("healthPromorionService")
public class HealthPromorionServiceImpl extends AbstractService implements IHealthPromorionService {

    @Resource(name = "healthPromorionDao")
    private IHealthPromorionDao healthPromorionDao;

    @Override
    public PageList<HealthPromorion> findHealthPromorion(Criteria criteria, Page page) {
        criteria.add("IS_DELETE", OP.NE, 1);
        return healthPromorionDao.getPageList(page, criteria, new Order("CREATE_DATE", false));
    }

    @Override
    public int createHealthPromorion(HealthPromorion healthPromorion) {
        if (ObjectUtil.isNullOrEmpty(healthPromorion)) {
            return 0;
        }
        int result = 0;
        try {
            if (ObjectUtil.isNotEmpty(healthPromorion.getId())) {
                healthPromorionDao.update(healthPromorion);
            } else {
                healthPromorionDao.insert(healthPromorion);
            }
            result = 1;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    @Override
    public HealthPromorion getHealthPromorionById(Criteria criteria) {
      return   healthPromorionDao.get(criteria);
    }

    @Override
    public int delete(Criteria criteria) {
        return healthPromorionDao.update(new Parameters("IS_DELETE", "1"), criteria);
    }

    @Override
    public int updateStatus(Parameters parameters, Criteria criteria) {
        return healthPromorionDao.update(parameters, criteria);
    }

    @Override
    public int update(HealthPromorion healthPromorion) {
        return healthPromorionDao.update(healthPromorion);
    }
}
