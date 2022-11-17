package com.founder.rhip.ehr.repository.clinic;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.StorageInDetail;

/**
 * DAO interface of DaStorageInDetail
 * 
 */
public interface IStorageInDetailDao extends IDao<StorageInDetail,Long> {
	
	
	/**
	 * 获取库存明细
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	PageList<Map<String, Object>> getDetailList(Page page, Criteria criteria);

}