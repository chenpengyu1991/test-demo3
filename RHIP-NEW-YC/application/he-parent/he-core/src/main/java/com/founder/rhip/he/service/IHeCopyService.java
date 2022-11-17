package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.healtheducation.HeCopy;

import java.util.Map;

/**
 * 稿件提供
 * 
 * @author cary
 *
 */
public interface IHeCopyService {

	/**
	 * 获取稿件提供
	 * 
	 * @param criteria 查询条件
	 * @return 稿件提供
	 */
	public HeCopy getHeCopy(Criteria criteria);
	
	/**
	 * 添加稿件提供
	 * 
	 * @param  heCopy 稿件提供
	 * @param fileMap 上传文件记录
	 * @param creator 操作者姓名
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int createHeCopy(HeCopy heCopy, Map<String, String> fileMap, String creator);

	/**
	 * 修改稿件提供
	 * 
	 * @param HeCopy 稿件提供
	 * @param fileMap 上传文件记录
	 * @param creator 操作者姓名
	 * @param properties 要更新的属性
	 * @return  成功或者失败标志1->成功，0->失败
	 */
	public int updateHeCopy(HeCopy HeCopy, Map<String, String> fileMap, String creator, String... properties);

	/**
	 * 删除稿件提供
	 * 
	 * @param ids 稿件提供主键集合
	 * @return 
	 */
	public int deleteHeCopy(Long... ids);

	/**
	 * 分页显示稿件提供
	 * 
	 * @param criteria 查询条件
	 * @param page 页面
	 * @return PageList<HeCopy>
	 */
	public PageList<HeCopy> findHeCopy(Criteria criteria, Page page);

}