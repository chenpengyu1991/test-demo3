package com.founder.rhip.mdm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.repository.IStandParameterCfgDao;
import com.founder.rhip.mdm.entity.StandParameterCfg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("systemConfigService")
public class StandParameterCfgServiceImpl extends MDMService implements IStandParameterCfgService {

	@Resource(name = "sysParameterConfigDao")
	private IStandParameterCfgDao standParameterCfgDao;

	@Override
	public String getValue(String paramName) {
		Criteria criteria = new Criteria();
		criteria.add("name", paramName);
		criteria.add("valid", "1");
        List<StandParameterCfg> standParameterCfgs = standParameterCfgDao.getList(criteria);
        if (ObjectUtil.isNotEmpty(standParameterCfgs)) {
            return standParameterCfgs.get(0).getValue();
        }
        return null;
	}

	@Override
	public Integer getIntegerValue(String paramName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getLongValue(String paramName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValid(String paramName) {
		Criteria criteria = new Criteria();
		criteria.add("name", paramName);
		criteria.add("valid", "1");
        List<StandParameterCfg> standParameterCfgs = standParameterCfgDao.getList(criteria);
        return ObjectUtil.isNotEmpty(standParameterCfgs);
	}

	@Override
	public List<StandParameterCfg> listSystemConfig(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StandParameterCfg getSystemConfig(Criteria criteria) {
		return standParameterCfgDao.get(criteria);
	}

	@Override
	public int saveSystemConfig(StandParameterCfg systemConfig) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(systemConfig.getId())){
			result=standParameterCfgDao.update(systemConfig,"name", "description", "value","valid");
		}else{
			result=standParameterCfgDao.insert(systemConfig);
		}

		return result;
	}


	@Override
	public PageList<StandParameterCfg> getSysConfigList(Criteria criteria, Page page) {
		return standParameterCfgDao.getPageList(page,criteria);
	}

}
