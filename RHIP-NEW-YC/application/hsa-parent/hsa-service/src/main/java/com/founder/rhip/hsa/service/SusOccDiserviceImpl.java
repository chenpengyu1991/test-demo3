package com.founder.rhip.hsa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.founder.fasf.beans.*;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.entity.hsa.SusOccDisInfo;
import com.founder.rhip.ehr.repository.hsa.ISusOccDisInfoDao;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 职业卫生指导
 * 
 * @author liuk
 * 
 */
@Service("susOccDiService")
public class SusOccDiserviceImpl extends AbstractService implements ISusOccDiservice {

	@Resource(name = "hsaSusOccDisInfoDao")
	private ISusOccDisInfoDao susOccDisInfoDao;

	private final static String[] properties = { "name", "gender", "age", "idcard", "workUnit", "occupation", "susOccDiseaseName", "susOccDiseaseCode", "unitPhoneNumber", "phoneNumber", "recipientUnit", "recipientName", "recipientPhone",
			"reporterName", "reporterCode", "reportDate" };

	private final static String[] NO_UPDATE_PROPERTIES = { "createOrganName", "createOrganCode", "createDoctorName", "createDoctorCode", "createCenterOrganName", "createCenterOrganCode", "createGbcode" };
	private  static String[] UPDATE_PROPERTIES;

	@PostConstruct
	public void init() {
		ClassMetadata classMetadata = ClassMetadata.getMetadata(SusOccDisInfo.class);
		Map<String, PropertyMetadata> columns = classMetadata.getProperty();
		HashSet<String> noupdate = new HashSet<>(Arrays.asList(NO_UPDATE_PROPERTIES));
		HashSet<String> update = new HashSet<>();
		for (Map.Entry<String, PropertyMetadata> entry : columns.entrySet()) {
			PropertyMetadata propertyMetadata = entry.getValue();
			if (!propertyMetadata.isDbField()) {
				continue;
			}
			String proper = entry.getKey();
			if (noupdate.contains(proper)) {
				continue;
			}
			update.add(proper);

		}
		UPDATE_PROPERTIES = update.toArray(new String[update.size()]);
	}

	/**
	 * 添加
	 * @return void
	 */

	@Transactional
	@Override
	public void updateSusOccDisInfo(ReportRecord reportRecord, List<SusOccDisInfo> susOccDisInfoList, Organization organization, User user) {

		Assert.notNull(reportRecord);
		Assert.notNull(reportRecord.getId());
		Long reportId = reportRecord.getId();
		Criteria deleteCri = new Criteria("reportRecordId", reportId);

		if (ObjectUtil.isNotEmpty(susOccDisInfoList)) {
			List<SusOccDisInfo> updateList = new ArrayList<SusOccDisInfo>();
			Set<Long> updateIds = new HashSet<>();
			List<SusOccDisInfo> insertList = new ArrayList<SusOccDisInfo>();
			for (SusOccDisInfo susOccDisInfo : susOccDisInfoList) {
				susOccDisInfo.setReportRecordId(reportId);
				if (susOccDisInfo.getId() != null) {
					updateList.add(susOccDisInfo);
					updateIds.add(susOccDisInfo.getId());
				} else {
					susOccDisInfo.setCreateOrganName(organization.getOrganName());
					susOccDisInfo.setCreateOrganCode(organization.getOrganCode());
					susOccDisInfo.setCreateGbcode(organization.getGbCode());
					susOccDisInfo.setCreateDoctorCode(user.getId().toString());
					susOccDisInfo.setCreateDoctorName(user.getName());
					insertList.add(susOccDisInfo);
				}
			}
			if (updateIds.size() > 0) {
				deleteCri.add("id", OP.NOTIN, updateIds);
			}

			susOccDisInfoDao.delete(deleteCri);

			if (ObjectUtil.isNotEmpty(updateList)) {
				susOccDisInfoDao.batchUpdate(updateList, properties);
			}
			susOccDisInfoDao.batchInsert(insertList);

		} else {
			susOccDisInfoDao.delete(deleteCri);
		}

	}

	/**
	 * 添加
	 * @return void
	 */

	@Transactional
	@Override
	public void addSusOccDisInfo(ReportRecord reportRecord, List<SusOccDisInfo> susOccDisInfoList, Organization organization, User user) {
		Assert.notNull(reportRecord);
		Assert.notNull(reportRecord.getId());
		Long reportId = reportRecord.getId();
		if (ObjectUtil.isNotEmpty(susOccDisInfoList)) {
			List<SusOccDisInfo> insertList = new ArrayList<SusOccDisInfo>(susOccDisInfoList.size());
			for (SusOccDisInfo susOccDisInfo : susOccDisInfoList) {
				susOccDisInfo.setReportRecordId(reportId);
				susOccDisInfo.setCreateOrganName(organization.getOrganName());
				susOccDisInfo.setCreateOrganCode(organization.getOrganCode());
				susOccDisInfo.setCreateGbcode(organization.getGbCode());
				susOccDisInfo.setCreateDoctorCode(user.getId().toString());
				susOccDisInfo.setCreateDoctorName(user.getName());
				insertList.add(susOccDisInfo);
			}
			susOccDisInfoDao.batchInsert(insertList);
		}
	}

	/**
	 * 保存
	 * @return boolean
	 */
	@Override
	public boolean saveSusOccDisInfo(SusOccDisInfo susOccDisInfo, Organization organization, User user) {
		Assert.notNull(susOccDisInfo);
		Long id = susOccDisInfo.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			susOccDisInfo.setCreateOrganName(organization.getOrganName());
			susOccDisInfo.setCreateOrganCode(organization.getOrganCode());
			susOccDisInfo.setCreateGbcode(organization.getGbCode());
			susOccDisInfo.setCreateDoctorCode(user.getId().toString());
			susOccDisInfo.setCreateDoctorName(user.getName());
			susOccDisInfoDao.insert(susOccDisInfo);
		} else {
			susOccDisInfoDao.update(susOccDisInfo, UPDATE_PROPERTIES);
		}
		return true;
	}

	/**
	 * 删除
	 * @return void
	 */
	public void deleteSusOccDisInfo(Criteria criteria, Organization organization, User user) {
		// TODO
	}

	/**
	 * 查看
	 * @return PageList<SusOccDisInfo>
	 */
	@Override
	public PageList<SusOccDisInfo> getSusOccDisInfo(Criteria criteria, Page page, RoleType roleType, Organization organization) {
		setInspRecordParam(organization, roleType, criteria);
		PageList<SusOccDisInfo> susOccDisInfoList = susOccDisInfoDao.getPageList(page, criteria);
		return susOccDisInfoList;
	}

	/**
	 * 查看个人详细信息
	 * 
	 * @param id
	 * 
	 * @return PageList<SusOccDisInfo>
	 */
	@Override
	public SusOccDisInfo searchSusOccDiDetialedInfo(Long id) {
		if (ObjectUtil.isNullOrEmpty(id)) {
			return null;
		}
		SusOccDisInfo susOccDiInfo = susOccDisInfoDao.get(id);
		return susOccDiInfo;
	}

	@Override
	public List<SusOccDisInfo> susOccDisInfoList(Criteria criteria) {
		List<SusOccDisInfo> list = susOccDisInfoDao.getList(criteria);
		return list;

	}

	private void setInspRecordParam(Organization organization, RoleType roleType, Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		if (RoleType.ZX_GLY.equals(roleType)) {
			criteria.add("CREATE_ORGAN_CODE", organization.getOrganCode());
		}
	}

}