/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.idm.AcuteStatisicsDto;
import com.founder.rhip.ehr.dto.idm.DysenteryStatisicsDto;
import com.founder.rhip.ehr.dto.idm.InterviewStatisicsDto;
import com.founder.rhip.ehr.dto.idm.RabiesStatisicsDto;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.ListScDc;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.StatisticsData;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.Supervisor;

import java.util.List;

/**
 * 直报统计service 
 * @author yejianfei
 */
public interface IReportStatisticsService {
	/**
	 * 传染病管理及督导-填写查询
	 * @param       criteria
	 * @param       page
	 * @return      PageList<Supervisor>
	 */
	public PageList<Supervisor> findSupervisorFill(Criteria criteria, Page page);

	/**
	 * 传染病管理及督导-汇总
	 * @param       criteria
	 * @param       summaryType
	 * @return      List<Supervisor>
	 */
	public List<Supervisor> findSupervisorFill(Criteria criteria, String summaryType);

	/**
	 * 传染病管理及督导-合计
	 * @param       criteria
	 * @return      Supervisor
	 */
	public Supervisor getSupervisorSummary(Criteria criteria, String summaryType);
	/**
	 * 传染病管理及督导-查看填写
	 * @param       id
	 * @return      Supervisor
	 */
	public Supervisor getSupervisorFill(Long id);

    /**
     * 保存传染病管理及督导-填写
     * @param       supervisor
     * @return      boolean
     */
    public boolean saveSupervisorFill(Supervisor supervisor);

	/**
	 * 传染病管理及督导-查看填写个数
	 * @param       criteria
	 * @return      int
	 */
	public int getSupervisorFillCount(Criteria criteria);


	/**
	 * 执行情况自查-填写查询
	 * @param       criteria
	 * @param       page
	 * @return      PageList<SelfCheck>
	 */
	public PageList<SelfCheck> findSelfCheckFill(Criteria criteria, Page page);

	/**
	 * 执行情况自查-查看填写
	 * @param       id
	 * @return      SelfCheck
	 */
	public SelfCheck getSelfCheckFill(Long id);

	/**
	 * 执行情况自查-查看填写个数
	 * @param       criteria
	 * @return      int
	 */
	public int getSelfCheckFillCount(Criteria criteria);

    /**
     * 执行情况自查-填写
     * @param       supervisor
     * @return      boolean
     */
    public boolean saveSelfCheckFill(SelfCheck selfCheck);

	/**
	 * 执行情况自查-统计
	 * @param       criteria
	 * @return      List<SelfCheck>
	 */
	public List<SelfCheck> findSelfCheckSummary(Criteria criteria);

	/**
	 * 执行情况自查-合计
	 * @param       criteria
	 * @return      SelfCheck
	 */
	public SelfCheck getSelfCheckSummary(Criteria criteria);

    /**
     * 获取本机构，本月共上报多少种传染病
     * @param       criteria
     * @return      List<ListScDc>
     */
    public List<ListScDc> findInfections(Criteria criteria);

	/**
	 * 执行情况自查-新生儿产房接种统计，每次只有一条
	 * @param       criteria
	 * @return      List<SelfCheck>
	 */
	public SelfCheck findNeonateSummary(Criteria criteria);

    /**
     * 分页查询采样记录
     * @param       criteria
     * @param       page
     * @param       od
     * @return      PageList<findTsList>
     */
    public PageList<ListTs> findTsList(Criteria criteria, Page page, Order od);

    /**
     * 查询采样记录
     * @param       criteria
     * @param       od
     * @return      List<findTsList>
     */
    public List<ListTs> findTsList(Criteria criteria, Order od);

	/**
	 * 传染病访视月报表-统计
	 * @param       criteria
	 * @return      List<SelfCheck>
	 */
	public List<InterviewStatisicsDto> findInterviewSummary(Criteria criteria);

    /**
     * 保存 传染病月报表
     * @param       lists
     * @return      boolean
     */
    public boolean saveStatistics(List<StatisticsData> lists);

	/**
	 * 细菌性痢疾流调月报表-统计
	 * @param       criteria
	 * @return      List<DysenteryStatisicsDto>
	 */
	public List<DysenteryStatisicsDto> findDysenterySummary(Criteria criteria);

	/**
	 * 狂犬病防治月报表-统计
	 * @param       criteria
	 * @return      List<RabiesStatisicsDto>
	 */
	public List<RabiesStatisicsDto> findRabiesSummary(Criteria criteria);

	/**
	 * 急性传染病防制月报表-统计
	 * @param       criteria
	 * @return      List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteMonthSummary(Criteria criteria);

	/**
	 * 急性传染病防制年报表-统计
	 * @param       criteria
	 * @return      List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteYearSummary(Criteria criteria);

    /**
	 * 查询直报报表数据：创建人、创建机构、创建时间,包括月报表、急性传染病
	 * @param type
	 * @param orgCode
	 * @param fillDate
	 * @return	StatisticsData
	 */
	public StatisticsData getStatisticsInfo(Integer type, String orgCode, String fillDate);

    /**查询直报报表，执行情况自查数据：创建人、创建机构、创建时间
	 * @param orgCode
	 * @param fillDate
	 * @return	SelfCheck
	 */
    public SelfCheck getSelfCheckInfo(String orgCode, String fillDate);
}