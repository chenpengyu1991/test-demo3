package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.idm.*;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;

import java.util.List;
import java.util.Map;


/**
 * DAO interface of IdmStatusInfo
 * 
 */
public interface IIdmStatusInfoDao extends IDao<IdmStatusInfo,Long> {
	public int updateStatus(IdmStatusInfo statusInfo, Criteria cr);

    public int updateCaseStatus(IdmStatusInfo statusInfo, Criteria cr);

    /**
	 * 分页查询疟疾血检登记
	 * @param page
	 * @param criteria
	 * @return PageList<IdmStatusInfo>
	 */
    public PageList<IdmStatusInfo> findRegisterList(Page page, Criteria criteria);

    /**
	 * 查询疟疾血检登记
	 * @param criteria
	 * @return List<IdmStatusInfo>
	 */
    public List<IdmStatusInfo> findRegisterList(Criteria criteria);

    /**
	 * 查询结核病列表  专用病历 管理卡 Criteria statusCr是获取eventId的条件 若为空则criteria.get("EVENT_ID")
	 * @param page
	 * @param criteria
	 * @return
	 */
	public List<IdmStatusInfo> findTreatList(Criteria criteria, Criteria statusCr, Order order);

	public PageList<IdmStatusInfo> findTreatmentList(Page page, Criteria criteria, Criteria statusCr, Order order,String firstVist);
	public List<IdmStatusInfo> findTreatmentList(Criteria criteria, Criteria statusCr, Order order);
	public List<Map<String, Object>> downTreatmentList(Criteria criteria, Criteria statusCr, Order order);

    public PageList<IdmStatusInfo> findMgntList(Page page, Criteria criteria, Criteria statusCr);

    public List<TbQueryDto> findMgntListTotal(Criteria criteria, Criteria statusCr);

	public List<TbQueryDto> getTbList(Criteria criteria, Criteria statusCr);

	/**
	 * 查询结核病追踪单
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findTraceList(Page page, Criteria criteria);

    /**
     * 查询丝虫病列表-血检
     * @param page
     * @param criteria
     * @return
     */
    public PageList<IdmStatusInfo> findFilRegList(Page page, Criteria criteria, boolean isStandard);

	/**
	 * 获取转诊后未到诊的人数
	 * @param criteria
	 * @return
	 */
	public int getNotSeeDoctorCount(Criteria criteria);

    /**
	 * 分页查询血吸虫监测登记
	 * @param page
	 * @param criteria
	 * @return PageList<IdmStatusInfo>
	 */
    public PageList<IdmStatusInfo> findSchRegisterList(Page page, Criteria criteria);

    /**
	 * 查询血吸虫监测登记
	 * @param criteria
	 * @return List<SchistosomeQueryDto>
	 */
    public List<SchistosomeQueryDto> findSchRegisterList(Criteria criteria);

	/**
	 * 分页查询血吸虫个案调查
	 * @param page
	 * @param criteria
     * @return PageList<IdmStatusInfo>
	 */
    public PageList<IdmStatusInfo> findSchCaseList(Page page, Criteria criteria);

	/**
	 * 查询血吸虫个案调查
	 * @param criteria
     * @return List<IdmStatusInfo>
	 */
	public List<IdmStatusInfo> findSchCaseList(Criteria criteria);
    /**
	 * 查询麻风列表信息
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findLeprosyList(Page page, Criteria criteria, Order order);

    /**
	 * 分页查询晚血病人列表信息
	 * @param page
	 * @param criteria
	 * @return	PageList<IdmStatusInfo>
	 */
    public PageList<IdmStatusInfo> findAdvancedList(Page page, Criteria criteria);

    /**
	 * 查询晚血病人列表信息
	 * @param criteria
	 * @return	List<IdmStatusInfo>
	 */
	public List<IdmStatusInfo> findAdvancedList(Criteria criteria);

    /**
	 * 汇总传染病访视月报表
	 * @param criteria
	 * @return	List<InterviewStatisicsDto>
	 */
	public List<InterviewStatisicsDto> findInterviewList(Criteria criteria);

    /**
	 * 汇总细菌性痢疾流调月报表
	 * @param criteria
	 * @return	List<DysenteryStatisicsDto>
	 */
	public List<DysenteryStatisicsDto> findDysenteryList(Criteria criteria);

    /**
	 * 汇总细菌性痢疾流调月报表--累计
	 * @param criteria
	 * @return	DysenteryStatisicsDto
	 */
	public DysenteryStatisicsDto findDysenteryTotal(Criteria criteria);
    /**
	 * 汇总狂犬病防治月报表
	 * @param criteria
	 * @return	List<RabiesStatisicsDto>
	 */
	public List<RabiesStatisicsDto> findRabiesList(Criteria criteria);

    /**
	 * 汇总急性传染病防制月报表
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteMonthList(Criteria criteria);

    /**
	 * 汇总狂犬病防治月报表-累计
	 * @param criteria
	 * @return	RabiesStatisicsDto
	 */
	public RabiesStatisicsDto findRabiesTotal(Criteria criteria);

   /**
	 * 汇总急性传染病防制月报表-合计
	 * @param criteria
	 * @return	AcuteStatisicsDto
	 */
	public AcuteStatisicsDto findAcuteMonthTotalList(Criteria criteria);

    /**
	 * 汇总急性传染病防制年报表
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteYearList(Criteria criteria);

   /**
	 * 汇总急性传染病防制月报表-合计
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	public AcuteStatisicsDto findAcuteYearTotalList(Criteria criteria);

	/**
     * 获取直报中传染病是麻风 还没有填写麻风疑似报卡的人数
     * @param criteria
     * @return
     */
    public int getNotReportLeprosyCount(Criteria criteria);

    /**
     * 指标统计
     * @param criteria
     * @return
     */
    public Float getIDMTarget(Criteria criteria);

    /**
     *更新个案分配
     * @param criteria
     * @param statusInfo
     * @return
     */

    public int updateAssignment(IdmStatusInfo statusInfo, Criteria cr);


	/**
	 * 慢性丝虫病患者统计表
	 * @param       criteria
	 * @return
	 */
	public List<Map<String,Object>> findChreport(Criteria criteria);
	public List<Map<String,Object>> findChreportCount(Criteria criteria);
	public List<Map<String,Object>> findPhreport(Criteria criteria);
	public List<Map<String,Object>> findPhreportCount(Criteria criteria);
	public List<Map<String, Object>> downTreatList(Criteria criteria, Criteria statusCr, Order order);
	public List<Map<String, Object>> findJcReport(Criteria criteria);
	public List<Map<String, Object>> findJcReportCount(Criteria criteria);
}