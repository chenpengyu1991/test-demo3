package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of EhrPhysiqueExamination
 */
public interface IPhysiqueExaminationDao extends IDao<PhysiqueExamination, Long> {

	/**
	 * 获取体检报告
	 * @param   year
	 * @param   personId
	 * @param   type
	 * @return  PhysiqueExamination
	 */
	public PhysiqueExamination getExamReport(String year, Long personId, String type);
	
	public PageList<PhysiqueExamination> getPhysiqueExaminations(Criteria criteria, Page page);
	
	public List<PhysiqueExamination> getLastelyPExamination(Criteria criteria);

	/**
	 * 饮食习惯分析
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getEatingHabitsMapList(Criteria ca);

	/**
	 * 运动频率分析
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getTrainFrequencyMapList(Criteria ca);

	/**
	 * 吸烟状况分析
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getSmodeStatusMapList(Criteria ca);

	/**
	 * 饮酒频率分析
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getDrinkFrequencyMapList(Criteria ca);
	
	public void updateEchIdentification(PhysiqueExamination phy);
	
	//处理bug0173577 历史数据
	public PageList<PhysiqueExamination> getPageListTemp(Page page, long id);

}