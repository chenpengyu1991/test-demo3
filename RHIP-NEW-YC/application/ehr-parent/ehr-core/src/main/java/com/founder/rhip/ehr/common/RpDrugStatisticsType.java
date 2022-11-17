package com.founder.rhip.ehr.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 综合管理药占比统计类型(门急诊、住院、医院)
 * @author GaoFei
 *
 */
public enum RpDrugStatisticsType {
	outpatient, //门急诊
	inpatient, // 住院
	consumable, // 耗材
	hosipital; // 医院
	
	public static List<String> getRpDrugStatisticsTypes() {
		List<String> list = new ArrayList<String>();
		for (RpDrugStatisticsType drugStatisticsType : RpDrugStatisticsType.values()) {
			list.add(drugStatisticsType.name());
		}
		return list;
	}
}
