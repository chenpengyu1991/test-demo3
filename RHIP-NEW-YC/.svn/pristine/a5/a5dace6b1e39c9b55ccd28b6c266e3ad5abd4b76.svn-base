package com.founder.rhip.im.service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.rhip.ehr.entity.basic.RdRecord;

public interface ITransPortPersistenceService {
	/**
	 * 持久化对象
	 * @param dynaBean 待持久化对象
	 * @param dataType 综合指标类型
	 * 对应的类型如下所示
	 * M01:门急诊综合
	 * M02:门急诊费用分析
	 * M03:住院综合
	 * M04:出院病人费用分析
	 * M05:全院收入情况
	 * M06:医技检查分析
	 * M07:医疗质量与安全
	 * M08:卫生人力
	 * M09:设备情况
	 * M10:床位分布
	 * @param dataXml XML消息
	 * @return 1:新增 2：更新 -1：失败
	 */
	public int persistence(ConvertingWrapDynaBean dynaBean, String dataType, String dataXml);
	
	/**
	 * 记录请求消息
	 * @param rdRecord
	 */
	public void record(RdRecord rdRecord);
}
