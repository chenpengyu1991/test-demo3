/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachMonitor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IVertorService {

	/**
	 * 查询鼠密度监测
	 * 
	 * @param Criteria
	 * @return PageList<DmbcMouseMonitor>
	 */
	public PageList<DmbcMouseMonitor> searchMouseMonitor(Criteria criteria,
			Page page);

	/**
	 * 保存鼠密度监测信息
	 * 
	 * @param DmbcMouseMonitor
	 * @param String
	 *            保存、更新、删除
	 * @return Boolean
	 */
	public Boolean saveMouseMonitor(DmbcMouseMonitor mouseMonitor, String type);

	/**
	 * 查看/修改鼠密度监测
	 * 
	 * @param Criteria
	 * @return DmbcMouseMonitor
	 */
	public DmbcMouseMonitor searchMouseMonitor(Long id);

	/**
	 * 查询被捕老鼠
	 * 
	 * @param Criteria
	 * @return PageList<DmbcMouseCaught>
	 */
	public PageList<DmbcMouseCaught> searchMouse(Page page, Criteria criteria);

	/**
	 * 查询被捕老鼠
	 * 
	 * @param Long
	 * @return DmbcMouseCaught
	 */
	public DmbcMouseCaught searchMouse(Long id);

	/**
	 * 保存已捕老鼠
	 * 
	 * @param DmbcMouseCaught
	 * @return Boolean
	 */
	public Boolean saveMouse(DmbcMouseCaught mouse, String type);

	/**
	 * 查询成蚊监测情况
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcMosquitoesMonitor>
	 */
	public PageList<DmbcMosquitoesMonitor> searchMosquitoesMonitor(
			Criteria criteria, Page page);

	/**
	 * 保存成蚊监测情况
	 * 
	 * @param DmbcMosquitoesMonitor
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveMosquitoesMonitor(
			DmbcMosquitoesMonitor mosquitoesMonitor, String type);

	/**
	 * 查看/修改成蚊监测
	 * 
	 * @param Criteria
	 * @return DmbcMouseMonitor
	 */
	public DmbcMosquitoesMonitor searchMosquitoesMonitor(Long id);

	/**
	 * 查询被捕蚊子
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcMosquitoesCaught>
	 */
	public PageList<DmbcMosquitoesCaught> searchMosquitoes(Page page,
			Criteria criteria);

	/**
	 * 查询被捕蚊子
	 * 
	 * @param Long
	 * @return DmbcMosquitoesCaught
	 */
	public DmbcMosquitoesCaught searchMosquitoes(Long id);

	/**
	 * 保存蚊子
	 * 
	 * @param DmbcMosquitoesCaught
	 * @param String
	 *            type
	 * @return Boolean
	 */
	public Boolean saveMosquitoes(DmbcMosquitoesCaught mosquitoes, String type);

	/**
	 * 苍蝇监测查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcFlyMonitor>
	 */
	public PageList<DmbcFlyMonitor> searchFlyMonitor(Criteria criteria,
			Page page);

	/**
	 * 苍蝇监测查询
	 * 
	 * @param Long
	 * @return DmbcFlyMonitor
	 */
	public DmbcFlyMonitor searchFlyMonitor(Long id);

	/**
	 * 保存苍蝇监测
	 * 
	 * @param DmbcFlyMonitor
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveFlyMonitor(DmbcFlyMonitor flyMonitor, String type);

	/**
	 * 查询苍蝇
	 * 
	 * @param Criteria
	 * @return PageList<DmbcFlyCaught>
	 */
	public PageList<DmbcFlyCaught> searchFly(Page page, Criteria criteria);

	/**
	 * 查询苍蝇
	 * 
	 * @param Long
	 * @return DmbcFlyCaught
	 */
	public DmbcFlyCaught searchFly(Long id);

	/**
	 * 保存设备
	 * 
	 * @param DmbcFlyCaught
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveFly(DmbcFlyCaught fly, String type);

	/**
	 * 蟑螂监测查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcRoachMonitor>
	 */
	public PageList<DmbcRoachMonitor> searchRoachMonitor(Criteria criteria,
			Page page);

	/**
	 * 蟑螂监测查询
	 * 
	 * @param Long
	 * @return DmbcRoachMonitor
	 */
	public DmbcRoachMonitor searchRoachMonitor(Long id);

	/**
	 * 保存蟑螂监测
	 * 
	 * @param DmbcRoachMonitor
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveRoachMonitor(DmbcRoachMonitor roachMonitor, String type);

	/**
	 * 查询蟑螂
	 * @param Page
	 * @param Criteria
	 * @return PageList<DmbcRoachCaught>
	 */
	public PageList<DmbcRoachCaught> searchRoach(Page page, Criteria criteria);

	/**
	 * 查询蟑螂
	 * @param Long
	 * @return DmbcRoachCaught
	 */
	public DmbcRoachCaught searchRoach(Long id);
	/**
	 * 保存蟑螂
	 * 
	 * @param DmbcRoachCaught
	 * @return Boolean
	 */
	public Boolean saveRoach(DmbcRoachCaught roach,String type);

	/**
	 * 鼠密度监测汇总
	 * @param beginDate
	 * @param endDate
	 * @param townShip
	 * @return
	 */
	public List<Map<String, Object>> mouseReport(String beginDate, String endDate, String townShip);

	/**
	 * 成蚊监测汇总
	 * @param beginDate
	 * @param endDate
	 * @param townShip
	 * @return
	 */
	public List<Map<String, Object>> mosquitoesReport(String beginDate, String endDate, String townShip);

	/**
	 * 苍蝇监测汇总
	 * @param beginDate
	 * @param endDate
	 * @param townShip
	 * @return
	 */
	public List<Map<String, Object>> flyReport(String beginDate, String endDate, String townShip);

	/**
	 * 蟑螂监测汇总
	 * @param beginDate
	 * @param endDate
	 * @param townShip
	 * @return
	 */
	public List<Map<String, Object>> roachReport(String beginDate, String endDate, String townShip);
}