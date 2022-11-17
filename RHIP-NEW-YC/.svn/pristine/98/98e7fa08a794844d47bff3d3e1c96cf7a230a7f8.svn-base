package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;

/**
 * DAO interface of InpatientDrugUsage
 */
public interface IDrugUsageDao extends IDao<DrugUsage, Long> {

	List<String> getRelationOrganCodes(Long personId);

    /**
     * 更新医生工号：门诊
     *
     * @return
     * @author Ye jianfei
     */
    public int updateOutpatientDoctorNo();

    /**
     * 更新医生工号：住院
     *
     * @return
     * @author Ye jianfei
     */
    public int updateInpatientDoctorNo();
    
    /**
     * 获取本次需要更新的EHR_ID列表
     *
     * @param page
     * @param criteria
     * @return
     * @author Ye jianfei
     */
    public PageList<DrugUsage> getEhrIdList(Page page,Criteria criteria); 
    
    public int batchUpdate(String sql);
    
    /**
     * 根据ehr_id区分是住院还是门诊来填充CLINIC_MARK
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateClinicMark();
	
	/**
	 * 获取药物相关数据记录
	 * @param paramMap 查询参数
	 * @param page 分页
	 * @return
	 */
	public PageList<Map<String, Object>> getDrugMapPageList(Map<String, String> paramMap, Page page);
}