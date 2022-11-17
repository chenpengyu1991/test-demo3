package com.founder.rhip.mhm.service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mhm.common.MhmEvents;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据事件，获取更新患者字段
 * @author yjf
 *
 */
@Component
public class MhmParamUtil {
	private Map<Integer, String[]> personInfoParamMap = new HashMap<>();

	public MhmParamUtil() {
		/**
		 * 线索登记
		 */
		personInfoParamMap.put(MhmEvents.M_CLUE.getValue(), new String[]{"name","occupation","unitName","householdType","patownShip", "pastreet", "pahouseNumber", "paAddress"
			,"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName" });
		/**
		 * 规范管理-基本档案
		 */
		personInfoParamMap.put(MhmEvents.M_ARCHIVES.getValue(), new String[]{"name","gender","nation","patownShip", "pastreet", "pahouseNumber", "paAddress","hrtownShip", "hrstreet", "hrhouseNumber", "hrAddress", "education","occupation","marriage","unitName"
			,"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName" });
		/**
		 * 规范管理-出院信息
		 */
		personInfoParamMap.put(MhmEvents.I_DISCHARGED.getValue(), new String[]{"name","gender","birthday","householdType","nation", "education","occupation","marriage","patownShip", "pastreet", "pahouseNumber", "paAddress"
			,"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"});
		/**
		 * 规范管理-随访记录
		 */
		personInfoParamMap.put(MhmEvents.M_FOLLOWUP.getValue(), new String[]{"name","gender"
			,"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"});
		/**
		 * 规范管理-失访信息
		 */
		personInfoParamMap.put(MhmEvents.M_LOST_FOLLOWUP.getValue(), new String[]{"name","gender"
			,"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"});
	}

	public String[] getParam(Integer mhmEvent) {
		if (ObjectUtil.isNotEmpty(mhmEvent)) {
			return personInfoParamMap.get(mhmEvent);
		}
		return null;
	}
}
