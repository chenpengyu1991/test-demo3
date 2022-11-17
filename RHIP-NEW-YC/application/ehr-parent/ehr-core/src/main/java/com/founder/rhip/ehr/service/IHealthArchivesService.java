package com.founder.rhip.ehr.service;

/**
 * 健康档案人群分类定时任务（根据孕产妇的末次月经日期计算满一年后自动生成为“普通人群”）
 */
public interface IHealthArchivesService {
	public void updateClassification();
}
