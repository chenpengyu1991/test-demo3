package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.statistics.ICdmWorkStatisticsDao;
import com.founder.rhip.ehr.statisticsdto.DmManageAndFollowup;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CdmWorkStatisticsReportService implements ICdmWorkStatisticsReportService {

	@Resource(name = "cdmWorkStatisticsDao")
	private ICdmWorkStatisticsDao cdmWorkStatisticsDao;

	@Resource
	private IOrganizationApp organizationApp;

	@Resource
	private IDictionaryApp dictionaryApp;

	@Override
	public List<Map<String, Object>> searchTumorPathologyResult(String beginAge, String endAge, String gbCode, String orgCode) {
		List<Map<String, Object>> cdmWorkStatisticsList = cdmWorkStatisticsDao.getTumorPathologyResult(beginAge, endAge, gbCode, orgCode);
		// if(ObjectUtil(cdmWorkStatisticsList)){
		// Map<String,Object> totalMap=new HashMap<String,Object>(2);
		// totalMap.put("ORGAN_NAME","合计");
		// totalMap.put("ORGAN_CODE", "合计");
		// cdmWorkStatisticsList.add(totalMap);
		// }
		return cdmWorkStatisticsList;
	}

	// DmManageAndFollowup
	@Override
	public List<DmManageAndFollowup> searchManageAndFollowup(String beginAge, String endAge, String town, String center, String station, String cdmType) {
		List<DmManageAndFollowup> dmManageAndFollowupList = new ArrayList<DmManageAndFollowup>();
		Map<String, DmManageAndFollowup> dmManageAndFollowupMap = new HashMap<String, DmManageAndFollowup>();
		// 获取镇
		if (ObjectUtil.isNotEmpty(station)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria(Organization.ORGAN_CODE, station));
			for (Organization dicItem : townList) {
				DmManageAndFollowup dmManageAndFollowup = new DmManageAndFollowup();
				dmManageAndFollowup.setOrganCode(dicItem.getOrganCode());
				dmManageAndFollowup.setOrganName(dicItem.getOrganName());
				dmManageAndFollowupList.add(dmManageAndFollowup);
				dmManageAndFollowupMap.put(dicItem.getOrganCode(), dmManageAndFollowup);
			}
		} else if (ObjectUtil.isNotEmpty(center)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, center).add("GENRE_CODE", OrgGenreCode.STATION.getValue()));
			for (Organization dicItem : townList) {
				DmManageAndFollowup dmManageAndFollowup = new DmManageAndFollowup();
				dmManageAndFollowup.setOrganCode(dicItem.getOrganCode());
				dmManageAndFollowup.setOrganName(dicItem.getOrganName());
				dmManageAndFollowupList.add(dmManageAndFollowup);
				dmManageAndFollowupMap.put(dicItem.getOrganCode(), dmManageAndFollowup);
			}
		} else if (ObjectUtil.isNotEmpty(town)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria("gbCode", town).add("GENRE_CODE", OP.IN,new String[]{OrgGenreCode.CENTRE.getValue()}));
			for (Organization dicItem : townList) {
				DmManageAndFollowup dmManageAndFollowup = new DmManageAndFollowup();
				dmManageAndFollowup.setOrganCode(dicItem.getOrganCode());
				dmManageAndFollowup.setOrganName(dicItem.getOrganName());
				dmManageAndFollowupList.add(dmManageAndFollowup);
				dmManageAndFollowupMap.put(dicItem.getOrganCode(), dmManageAndFollowup);
			}
		}
		else {
			List<DicItem> townList = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
			for (DicItem dicItem : townList) {
				DmManageAndFollowup dmManageAndFollowup = new DmManageAndFollowup();
				dmManageAndFollowup.setOrganCode(dicItem.getItemCode());
				dmManageAndFollowup.setOrganName(dicItem.getItemName());
				dmManageAndFollowupList.add(dmManageAndFollowup);
				dmManageAndFollowupMap.put(dicItem.getItemCode(), dmManageAndFollowup);
			}
		}
		DmManageAndFollowup dmaf = new DmManageAndFollowup();
		List<DmManageAndFollowup> manageAndFollowupList = cdmWorkStatisticsDao.getManageAndFollowup(beginAge, endAge, town,center,station,  cdmType);
		if (ObjectUtil.isNotEmpty(manageAndFollowupList)) {
			for (DmManageAndFollowup dmManageAndFollowup : manageAndFollowupList) {
				if ("合计".equals(dmManageAndFollowup.getOrganCode())) {
					dmaf.copyFrom(dmManageAndFollowup);
				}
				DmManageAndFollowup target = dmManageAndFollowupMap.get(dmManageAndFollowup.getOrganCode());
				if (ObjectUtil.isNotEmpty(target)) {
					target.copyFrom(dmManageAndFollowup);
				}
			}
		}
		List<DmManageAndFollowup> followupStatusList = cdmWorkStatisticsDao.getFollowupStatus(beginAge, endAge, town, center,station, cdmType);
		if (ObjectUtil.isNotEmpty(followupStatusList)) {
			for (DmManageAndFollowup followupStatus : followupStatusList) {
				if ("合计".equals(followupStatus.getOrganCode())) {
					dmaf.copyFollowupStatus(followupStatus);
				}
				DmManageAndFollowup target = dmManageAndFollowupMap.get(followupStatus.getOrganCode());
				if (ObjectUtil.isNotEmpty(target)) {
					target.copyFollowupStatus(followupStatus);
				}
			}
		}
		List<DmManageAndFollowup> intoStatusList = cdmWorkStatisticsDao.getIntoStatus(beginAge, endAge, town,center,station,  cdmType);
		if (ObjectUtil.isNotEmpty(intoStatusList)) {
			for (DmManageAndFollowup intoStatus : intoStatusList) {
				if ("合计".equals(intoStatus.getOrganCode())) {
					dmaf.copyIntoStatus(intoStatus);
				}
				DmManageAndFollowup target = dmManageAndFollowupMap.get(intoStatus.getOrganCode());
				if (ObjectUtil.isNotEmpty(target)) {
					target.copyIntoStatus(intoStatus);
				}
			}
		}
		dmaf.setOrganName("合计");
		dmManageAndFollowupList.add(dmaf);
		return dmManageAndFollowupList;
	}
}