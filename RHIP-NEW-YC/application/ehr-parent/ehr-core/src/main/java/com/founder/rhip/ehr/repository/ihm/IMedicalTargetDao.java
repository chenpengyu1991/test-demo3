package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 医疗服务
 */
public interface IMedicalTargetDao extends IDao<OutpatientInfo, Long> {
	
	/**
	 * 绩效考核-个人绩效:医疗考核-门诊挂号
	 *
	 * @param paramMap
	 * @param page
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPersonRegisterPerformance(Map<String, String> paramMap, Page page);
	
	/**
	 * 绩效考核-个人绩效:医疗考核-处方
	 *
	 * @param paramMap
	 * @param page
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPersonPrescriptionPerformance(Map<String, String> paramMap, Page page);	
	/**
	 * 门急诊信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getOutpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);
	
	/**
	 * 住院信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getInpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);	
	
	/**
	 * 医院费用信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @param opEmHpMark
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getHospitalCostsList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode
			,String opEmHpMark);
	
	/**
	 * 绩效考核：基本医疗效率指标
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getServiceCapacityList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);

    /**
     * 公共卫生服务项目指标
     * @param beginDate
     * @return
     */
    List<Map<String, Object>> getServiceProjectPerformance(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

    /**
     * 临床路径统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getClinicalPathwayStatistics(Map<String, String> paramMap);

    /**
     * 治疗质量统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getCureResultAnalys(Map<String, String> paramMap);

    /**
     * 监测症状统计
     *
     * @param paramMap
     * @return
     * @author Ye jianfei
     */
    public List<Map<String, Object>> getSymptomList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

    /**
     * 检查结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getStudyAnalys(Map<String, String> paramMap);
    /**
     * 检验结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap);

    /**
     * A、B类型传染病统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseType(Map<String, String> paramMap);

    /**
     * 1年内按月统计A、B类型传染病
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap);

    /**
     * 定时任务：计算某天 挂号人次数、就诊人次数、留观人次数
     */
    public List<Map<String, Object>> getRpMapList(String dateStr);
    
    /**
	 * 检验人数
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getExamCount(Map<String, String> paramMap);

}