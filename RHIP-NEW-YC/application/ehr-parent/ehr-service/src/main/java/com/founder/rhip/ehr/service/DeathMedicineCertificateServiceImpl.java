package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.DeathInfo;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.repository.control.IDeathInfoDao;
import com.founder.rhip.ehr.repository.control.IDeathMedicineCertificateDao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service("deathMedicineCertificateService")
public class DeathMedicineCertificateServiceImpl extends AbstractService implements IDeathMedicineCertificateService {

	@Resource(name = "deathMedicineCertificateDao")
	private IDeathMedicineCertificateDao deathMedicineCertificateDao;

	@Resource(name = "deathInfoDao")
	private IDeathInfoDao deathInfoDao;

	@Override
	public PageList<DeathMedicineCertificate> queryList(Criteria criteria, Page page,Order order) {
		return deathMedicineCertificateDao.getPageList(page, criteria, order);
	}

	@Override
	public DeathMedicineCertificate getDeathMedicineCertificate(Criteria criteria){
		return  deathMedicineCertificateDao.get(criteria);
	}

    @Override
    public int batchSave(List<DeathMedicineCertificate> records) {
        return deathMedicineCertificateDao.batchInsert(records);
    }

	@Override
	public int save(DeathMedicineCertificate deathMedicineCertificate) {
		return deathMedicineCertificateDao.insert(deathMedicineCertificate);
	}

	@Override
	public int update(DeathMedicineCertificate deathMedicineCertificate) {
		return deathMedicineCertificateDao.update(deathMedicineCertificate);
	}

	@Override
	public PageList<DeathMedicineCertificate> queryList(Criteria criteria,Page page) {
		return deathMedicineCertificateDao.getPageList(page, criteria);
	}

	@Override
	public int deleteChildDeath(DeathMedicineCertificate deathMedicineCertificate) {
		return deathMedicineCertificateDao.update(deathMedicineCertificate, new String[]{"isDelete"});
	}

	@Override
	public PageList<DeathInfo> queryDeathInfoList(Criteria criteria, Page page) {
		return deathInfoDao.getPageList(page, criteria);
	}

	@Override
	public DeathInfo queryDeathInfo(Criteria criteria) {
		return deathInfoDao.get(criteria);
	}
}
