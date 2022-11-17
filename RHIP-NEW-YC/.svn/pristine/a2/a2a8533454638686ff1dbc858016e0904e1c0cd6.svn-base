package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.SchoolInfo;

import java.util.List;

public interface ISchoolInfoService {

	/**
	 * 获取学校
	 * @param criteria
	 * @return
	 */
	public List<SchoolInfo> getSchools(Criteria criteria);
	
	/**
	 * 
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<SchoolInfo> getPageSchools(Page page, Criteria criteria);

	/**
	 * 保存学校信息
	 * @param schoolInfo
	 */
	public void saveSchool(SchoolInfo schoolInfo);

	/**
	 * 导入学校信息
	 *
	 * @param schoolList
	 * @return int
	 */
	public int importSchools(List<SchoolInfo> schoolList);

	/**
	 * 获取学校
	 * @param schoolId
	 * @return
	 */
	public SchoolInfo getSchool(Long schoolId);

	/**
	 * 删除学校
	 * @param schoolId
	 */
	public void deleteSchool(Long schoolId);

	/**
	 * 获取学校
	 * @param schoolId
	 * @return
	 */
	public SchoolInfo getSchool(String code);
}
