package com.founder.rhip.im.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.entity.basic.RdTargetIndex;
import com.founder.rhip.im.entity.basic.RdUserTarget;
import com.founder.rhip.im.repository.basic.IRdTargetIndexDao;
import com.founder.rhip.im.repository.basic.IRdUserTargetDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("homeSettingService")
public class HomeSettingServiceImpl implements IHomeSettingService{

	@Resource(name = "rdTargetIndexDao")
	private IRdTargetIndexDao rdTargetIndexDao;

	@Resource(name = "rdUserTargetDao")
	private IRdUserTargetDao rdUserTargetDao;

	@Override
	public List<RdTargetIndex> getTargetIndexList(Criteria criteria) {
		return rdTargetIndexDao.getList(criteria);
	}

	@Override
	@Transactional
	public int saveLayout(List<RdUserTarget> userTargetList,String userCode,String type) {
		int result = 0;
		rdUserTargetDao.delete(new Criteria("userCode",userCode).add("TARGET_TYPE",type));
		if(ObjectUtil.isNotEmpty(userTargetList)){
			result = rdUserTargetDao.batchInsert(userTargetList);
		}
		return result;
	}

	@Override
	public List<RdUserTarget> getUserTargetList(Criteria criteria) {
		return rdUserTargetDao.getUserTargetList(criteria);
	}

	@Override
	public RdTargetIndex getTargetIndex(Criteria criteria) {
		return rdTargetIndexDao.get(criteria);
	}

	@Override
	public List<RdTargetIndex> getTargetIndexList(String type, String userCode) {
		return rdTargetIndexDao.getTargetIndexList(type,userCode);
	}
}