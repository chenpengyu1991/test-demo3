package com.founder.rhip.ehr.repository.hsa;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;

/**
 * @author liuk
 * 
 */
public interface IInspectionRecordDao extends IDao<InspectionRecord, Long> {
	/**
	 * 地点记录
	 * 
	 * @param page
	 * @param cr
	 * @return
	 */
	public PageList<InspectionRecord> getPageInspectionRecordList(Page page, Criteria cr);

	/**
	 * 家庭记录
	 * 
	 * @param page
	 * @param criteria
	 * @return
	 */
	List<InspectionRecord> getPagedFamilyRecordList(Page page, Criteria criteria);

	PageList<InspectionRecord> getPagedLocationRecordList(Page page, Criteria criteria);
}