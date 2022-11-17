package com.founder.rhip.ep.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ep.SaltMonitorRecord;
import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;
import com.founder.rhip.ehr.entity.ep.SaltTestRecord;

import java.util.List;

public interface IIodateService {

	/**
	 * 抽样登记分页
	 * @param page
	 * @param year
	 * @return
	 */
	public PageList<SaltSamplingRecord> getSamplingPageList(Page page, String year);

	/**
	 * 保存抽样登记
	 * @param records
	 * @return
	 * @throws Exception 
	 */
	public int saveSamplingRecords(List<SaltSamplingRecord> records, String year, String gbCode) throws Exception;

	/**
	 * 删除抽样登记
	 * @param records
	 * @return
	 * @throws Exception 
	 */
	public int deleteSamplingRecords(List<SaltSamplingRecord> records) throws Exception;

	/**
	 * 获取抽样登记信息
	 * @param criteria
	 * @return
	 */
	public SaltSamplingRecord getSamplingRecord(Criteria criteria);

	/**
	 * 获取抽样登记列表
	 * @param criteria
	 * @return
	 */
	public List<SaltSamplingRecord> getSamplingRecords(Criteria criteria);

	/**
	 * 获取抽检的村
	 * @param year
	 * @param gbCode
	 * @return
	 */
	public List<String[]> getSamplingVillages(String year, String gbCode);

	/**
	 * 获取抽检的乡镇
	 * @param year
	 * @return
	 */
	public List<String[]> getSamplingTowns(String year);

	/**
	 * 监测记录分页
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<SaltMonitorRecord> getMonitorPageList(Page page, Criteria criteria);

	/**
	 * 获取监测记录
	 * @param criteria
	 * @return
	 */
	public SaltMonitorRecord getMonitorRecord(Criteria criteria);

	/**
	 * 保存监测记录和盐样测试结果
	 * @param record
	 * @param test
	 * @return
	 */
	public int saveMonitorRecord(SaltMonitorRecord record, List<SaltTestRecord> test);

	/**
	 * 删除监测记录
	 * @param record
	 * @return
	 */
	public int deleteMonitorRecord(SaltMonitorRecord record);

	/**
	 * 获取食盐检测数据
	 * @param criteria
	 * @return
	 */
	public List<SaltTestRecord> getTestRecords(Criteria criteria);
}
