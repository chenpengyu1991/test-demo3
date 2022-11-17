package com.founder.rhip.hm.service;

import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.FissureSealantReportDTO;
import com.founder.rhip.ehr.entity.pbusiness.student.FissureSealant;

public interface IFissureSealantService {

	/**
	 * 批量导入数据
	 * @param dataList
	 * @return
	 */
	int importDatas(List<FissureSealant> dataList);

	/**
	 * 统计报表
	 * @param beginDate
	 * @param endDate
	 * @param school
	 */
	FissureSealantReportDTO report(Date beginDate, Date endDate, String[] school);

	/**
	 * 查询列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<FissureSealant> getExamPageList(Page page, Criteria criteria);

	/**
	 * 查询
	 * @param id
	 * @return
	 */
	FissureSealant getFissureSealant(Long id);

	/**
	 * 保存
	 * @param fs
	 */
	void save(FissureSealant fs);

	/**
	 * 删除
	 * @param id
	 */
	void delete(Long id);

}
