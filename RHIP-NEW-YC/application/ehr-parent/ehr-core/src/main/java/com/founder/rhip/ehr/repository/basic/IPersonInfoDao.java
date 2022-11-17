package com.founder.rhip.ehr.repository.basic;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * DAO interface of PersonInfo
 */
public interface IPersonInfoDao extends IDao<PersonInfo, Long> {

    public PageList<PersonInfo> getUnRegFamilyPersonList(PersonInfo personInfo, List<Long> exceptIds, Page page, Criteria criteria);
   
    public List<Map<String, Object>> getPersonCount(Criteria criteria);
    
    public List<Map<String, Object>> getPersonCountStation(Criteria criteria);
    
    public List<Map<String, Object>> getChangedCount(Criteria criteria);

    public List<Map<String, Object>> getChangedCountTown(Criteria criteria);

    public List<Map<String, Object>> getChangedCountStation(Criteria criteria);
    
    public List<Map<String, Object>> getChangedCountNoType(Criteria criteria);
    
    public List<Map<String, Object>> getChangedCountStationNoType(Criteria criteria);

    public List<String> getOrgCodes();

    public List<Map<String, Object>> getStatisticsListByTown();

    public List<Map<String, Object>> getStatisticsListByCenter(String centerCode);

    /**
     * 迁出统计
     *
     * @param criteria
     * @return
     * @author Ye jianfei
     */
    List<Map<String, Object>> getCanceledInfoCount(Criteria criteria);
    
	/** 
	* @Title: getStarCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param criteria
	* @param @return
	* @return List<Map<String,Object>>
	* @throws 
	*/
	List<Map<String, Object>> getStarCount(Criteria criteria);

	/** 
	* @Title: getTypeCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param criteria
	* @param @return
	* @return List<Map<String,Object>>
	* @throws 
	*/
	List<Map<String, Object>> getTypeCount(Criteria criteria);

	/** 
	* @Title: getActiveCount 
	* @Description: 获取活动档案
	* @param @param criteria
	* @param @param startDate
	* @param @param endDate
	* @param @return
	* @return Long
	* @throws 
	*/
	Long getActiveCount(Criteria criteria, Date startDate, Date endDate);
   
	List<Map<String, Object>> getMapList();


    /**
     * 个人绩效（建档量统计）
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<Map<String, Object>> getHRPerformance(Map<String, String> paramMap, Page page);
    
    /**
     * 机构绩效（建档量统计）
     *
     * @param paramMap
     * @return
     * @author Ye jianfei
     */
    public List<Map<String, Object>> getHRPerformance(Map<String, String> paramMap);
    
    /**
     * 星级统计的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getPersonInfoStatistics(String dateStr);

	public Map<String,Object> getStatisticsListEveryCenter(String centerOrgCode);

	public PageList<Map<String, Object>> getPersonInfoListMap(Page page, Criteria ca);

	public PageList<Map<String, Object>> getPersonInfoListMap(Page page,Boolean flg, List<String> orgCodes, Map<String, String> paramMap,int type);
	
	public PageList<PersonInfo> queryPageList(Page page, Criteria criteria, Order order);

	public PageList<Map<String, Object>> queryPageMapList(Page page,Criteria criteria, Order order);

	/**
	 * 查询所有不在ECH_PHYSICAL_EXAM_RECORD（physicalExamType＝31）65岁以上的老年人信息
	 * @param criteria
	 * @return
	 */
	public List<PersonInfo> queryPersonInfoList(Criteria criteria);

	/**
	 * 获取档案编号重复的档案
	 * @return
	 */
	public List<PersonInfo> getRepeatEhrNOList();

	/**
	 * 获取档案编号为null的已建档档案
	 * @return
	 */
	public List<PersonInfo> getRepeatEhrNONullList();

	/**
	 * 根据孕产妇的末次月经日期计算满一年后自动生成为“普通人群”
	 */
	public int updateClassification();
	
	public PageList<PersonInfo> getPageListAndNotInRecord(Page page, Criteria c);

	public PersonInfo getPersoninfo(Long personId);
}
