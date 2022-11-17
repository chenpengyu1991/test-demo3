package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;

import java.util.Map;

/**
 * 健康资源记录服务接口
 * @author GaoFei
 *
 */
public interface IHeResourceRecordService {
	
	/**
	 * 添加健康资源记录
	 * 
	 * @param healthResourceRecord 健康资源记录对象
	 * @param map 附件上传记录
	 * @param createrName 
	 */
	public void createHealthResourceRecord(HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> filenameMap,String createrName);
	
	/**
	 * 更新健康资源记录
	 * 
	 * @param healthResourceRecord 健康资源记录对象
	 * @param map 附件上传记录
	 * @param createrName 操作人名字
	 * @param properties
	 */
	public void updateHealthResourceRecord(HeResourceRecord healthResourceRecord, Map<String, String> map,  Map<String, String> filenameMap, String createrName, String... properties);
	
	/**
	 * 删除健康资源记录
	 * 
	 * @param ids 健康资源记录主键集合
	 */
	public void deleteHealthResourceRecord(Long... ids);
	
	/**
	 * 分页显示健康资源记录
	 * 
	 * @param criteria 查询条件
	 * @param page 页面对象
	 * @return
	 */
	public PageList<HeResourceRecord> findHealthResourceRecord(Criteria criteria, Page page);
	
	public PageList<HeResourceRecord> findHealthPostionRecord(Criteria criteria, Page page);
	
	/**
	 * 获取健康教育记录对象
	 * 
	 * @param criteria
	 * @return
	 */
	public HeResourceRecord getHealthResourceRecord(Criteria criteria);
}
