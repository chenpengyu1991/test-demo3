package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.statistics.ICdControlReportDao;
import com.founder.rhip.ehr.statisticsdto.HbpManageMonthReport;
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

@Service("cdControlReportService")
public class CdControlReportServiceImpl implements ICdControlReportService {
	
	@Resource(name = "cdControlReportDao")
	private ICdControlReportDao cdControlReportDao;
	
	@Resource
	private IOrganizationApp organizationApp;
	
	@Resource
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<HbpManageMonthReport> getManageMonthReport(String town, String center, String station, String mouth){
		List<HbpManageMonthReport> hbpManageMonthReportList = new ArrayList<HbpManageMonthReport>();
		Map<String,HbpManageMonthReport> hbpManageMonthReportMap=new HashMap<String, HbpManageMonthReport>();
		
		// 获取镇
		if (ObjectUtil.isNotEmpty(station)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria(Organization.ORGAN_CODE, station));
			for (Organization dicItem : townList) {
				HbpManageMonthReport hbpManageMonthReport = new HbpManageMonthReport();
				hbpManageMonthReport.setOrganCode(dicItem.getOrganCode());
				hbpManageMonthReport.setOrganName(dicItem.getOrganName());
				hbpManageMonthReportList.add(hbpManageMonthReport);
				hbpManageMonthReportMap.put(dicItem.getOrganCode(), hbpManageMonthReport);
			}
		} else if (ObjectUtil.isNotEmpty(center)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, center).add("GENRE_CODE", OrgGenreCode.STATION.getValue()));
			for (Organization dicItem : townList) {
				HbpManageMonthReport hbpManageMonthReport = new HbpManageMonthReport();
				hbpManageMonthReport.setOrganCode(dicItem.getOrganCode());
				hbpManageMonthReport.setOrganName(dicItem.getOrganName());
				hbpManageMonthReportList.add(hbpManageMonthReport);
				hbpManageMonthReportMap.put(dicItem.getOrganCode(), hbpManageMonthReport);
			}
		} else if (ObjectUtil.isNotEmpty(town)) {
			List<Organization> townList = organizationApp.queryOrganization(new Criteria("gbCode", town).add("GENRE_CODE", OP.IN,new String[]{OrgGenreCode.CENTRE.getValue()}));
			for (Organization dicItem : townList) {
				HbpManageMonthReport hbpManageMonthReport = new HbpManageMonthReport();
				hbpManageMonthReport.setOrganCode(dicItem.getOrganCode());
				hbpManageMonthReport.setOrganName(dicItem.getOrganName());
				hbpManageMonthReportList.add(hbpManageMonthReport);
				hbpManageMonthReportMap.put(dicItem.getOrganCode(), hbpManageMonthReport);
			}
		} else {
			List<DicItem> townList = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
			for (DicItem dicItem : townList) {
				HbpManageMonthReport hbpManageMonthReport = new HbpManageMonthReport();
				hbpManageMonthReport.setOrganCode(dicItem.getItemCode());
				hbpManageMonthReport.setOrganName(dicItem.getItemName());
				hbpManageMonthReportList.add(hbpManageMonthReport);
				hbpManageMonthReportMap.put(dicItem.getItemCode(), hbpManageMonthReport);
			}
		}

		HbpManageMonthReport hmmr = new HbpManageMonthReport();
		List<HbpManageMonthReport> hbpManageMonthReportTotalList = cdControlReportDao.getHbpManageMonthReport(town,center,station,mouth);
		if(ObjectUtil.isNotEmpty(hbpManageMonthReportTotalList)){
			for (HbpManageMonthReport hbpManageMonthReport : hbpManageMonthReportTotalList) {
				if("合计".equals(hbpManageMonthReport.getOrganCode())){
					hmmr.copyFrom(hbpManageMonthReport);
				}
				HbpManageMonthReport target = hbpManageMonthReportMap.get(hbpManageMonthReport.getOrganCode());
				if(ObjectUtil.isNotEmpty(target)){
					target.copyFrom(hbpManageMonthReport);
				}
			}
		}
		List<HbpManageMonthReport> monthTotalList = cdControlReportDao.followupCompletedWithinDate(town,center,station,mouth);
		if(ObjectUtil.isNotEmpty(monthTotalList)){
			for (HbpManageMonthReport mouthTotal : monthTotalList) {
				if("合计".equals(mouthTotal.getOrganCode())){
					hmmr.copyMonthTotal(mouthTotal);
				}
				HbpManageMonthReport target = hbpManageMonthReportMap.get(mouthTotal.getOrganCode());
				if(ObjectUtil.isNotEmpty(target)){
					target.copyMonthTotal(mouthTotal);
				}
			}
		}
		hmmr.setOrganName("本月小计");
		hbpManageMonthReportList.add(hmmr);	
		return hbpManageMonthReportList;
	}
}
