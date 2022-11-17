package com.founder.rhip.he.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.healtheducation.HePromorion;
import com.founder.rhip.ehr.repository.healtheducation.IHePromorionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chen.q on 15-6-9.
 */
@Service("hePromorionService")
public class HePromorionServiceImpl extends AbstractService implements IHePromorionService {

    @Resource(name = "hePromorionDao")
    private IHePromorionDao hePromorionDao;

    @Override
    public PageList<HePromorion> findHealthPromorion(Criteria criteria, Page page) {
        criteria.add("IS_DELETE", OP.NE, 1);
        return hePromorionDao.getPageList(page, criteria, new Order("CREATE_DATE", false));
    }

    @Override
    public int createHealthPromorion(HePromorion healthPromorion) {
        if (ObjectUtil.isNullOrEmpty(healthPromorion)) {
            return 0;
        }
        int result = 0;
        try {
            if (ObjectUtil.isNotEmpty(healthPromorion.getId())) {
                hePromorionDao.update(healthPromorion);
            } else {
                hePromorionDao.insert(healthPromorion);
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
    public HePromorion getHealthPromorionById(Criteria criteria) {
      return   hePromorionDao.get(criteria);
    }

    @Override
    public int delete(Criteria criteria) {
        return hePromorionDao.update(new Parameters("IS_DELETE", "1"), criteria);
    }

    @Override
    public int updateStatus(Parameters parameters, Criteria criteria) {
        return hePromorionDao.update(parameters, criteria);
    }

    @Override
    public int update(HePromorion healthPromorion) {
        return hePromorionDao.update(healthPromorion);
    }
}
