package com.founder.rhip.mdm.service;

import java.util.List;

import javax.annotation.Resource;

import com.founder.fasf.beans.*;
import org.springframework.stereotype.Service;

import com.founder.rhip.mdm.entity.DicVersion;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IDicVersionDao;

@Service("mdmDicVersionService")
public class DicVersionServiceImpl extends MDMService implements
		IDicVersionService {
	@Resource(name = "mdmDicVersionDao")
	private IDicVersionDao mdmDicVersionDao;

	protected static final String SEQ_DIC_VERSION = "SEQ_DIC_VERSION";

	@Override
	public List<DicVersion> getDicVersionsUseCache(Criteria criteria) {
		String key = LSIT_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<DicVersion> retList = (List<DicVersion>) getCache(EntityType.DIC_VERSION, key);
		if (retList == null) {
			retList = getDicVersions(criteria);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DIC_VERSION, key, retList);
			}
		}
		return retList;
	}

	@Override
	public List<DicVersion> getDicVersions(Criteria criteria) {
		Order order = new Order("VERSION_NUMBER");
//		order.asc("VERSION_NUMBER");
		List<DicVersion> retList = mdmDicVersionDao.getList(criteria, order);
		return retList;
	}

	@Override
	public PageList<DicVersion> getDicVersions(Page page, Criteria criteria) {
		Order order = new Order("VERSION_NUMBER");
		PageList<DicVersion> retList = mdmDicVersionDao.getPageList(page,criteria, order);
		return retList;
	}

	@Override
	public DicVersion getDicVersion(String dicCode, String versionNumber) {
		Criteria criteria = new Criteria(DicVersion.DIC_CODE, dicCode);
		criteria.add(DicVersion.VERSION_NUMBER, versionNumber);
		DicVersion dicVersion = mdmDicVersionDao.get(criteria);
		return dicVersion;
	}

	@Override
	public DicVersion getDicVersionDesc(String dicCode, String versionDesc) {
		Criteria criteria = new Criteria(DicVersion.DIC_CODE, dicCode);
		criteria.add(DicVersion.VERSION_DESC, versionDesc);
		DicVersion dicVersion = mdmDicVersionDao.get(criteria);
		return dicVersion;
	}

	@Override
	public void createDicVersion(DicVersion dicVersion) {
		String dicCode = dicVersion.getDicCode();
		mdmDicVersionDao.insertWithSeq(dicVersion, SEQ_DIC_VERSION);
		removeCache(EntityType.DIC_VERSION, dicCode);
	}

	@Override
	public void updateDicVersion(DicVersion dicVersion) {
		Long versionId = dicVersion.getId();
		String dicCode = dicVersion.getDicCode();
		//Dictionary dictionary = dictionaryDao.get(dicCode);
//		Criteria criteria = new Criteria(DicVersion.ID, versionId);
//		mdmDicVersionDao.insertLogs(criteria);
//		item.setVersion(dictionary.getVersion());
		mdmDicVersionDao.update(dicVersion);
		removeCache(EntityType.DIC_VERSION, dicCode);
	}

	@Override
	public void changeVersionStatus(DicVersion dicVersion) {
		Parameters params = new Parameters(DicVersion.VERSION_STATUS, dicVersion.getVersionStatus());
		Criteria criteria = new Criteria(DicVersion.ID, dicVersion.getId());
		mdmDicVersionDao.update(params, criteria);
	}

	@Override
	public void changeMajorVersion(DicVersion dicVersion) {
		Parameters params = new Parameters(DicVersion.MAJOR_VERSION, dicVersion.getMajorVersion());
		Criteria criteria = new Criteria(DicVersion.ID, dicVersion.getId());
		mdmDicVersionDao.update(params, criteria);
	}
	
	@Override
	public int deleteDicVersion(Criteria criteria) {
		return mdmDicVersionDao.delete(criteria);
	}
}
