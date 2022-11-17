package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.StudentExamReportDTO;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;

import java.util.List;
import java.util.Map;

public interface IStudentExamService {

	/**
	 * 取得体检名单分页列表
	 * @param criteria
	 * @return
	 */
	public PageList<StudentExam> getExamStudentPageList(Page page, Criteria criteria);
	
	/**
	 * 取得体检记录分页列表
	 * @param criteria
	 * @return
	 */
	public PageList<StudentExam> getExamPageList(Page page, Criteria criteria);

	/**
	 * 获取体检记录列表
	 * @param criteria
	 * @return
	 */
	public List<StudentExam> getExamList(Criteria criteria);

	/**
	 * 学生体检汇总报表
	 * @param examYear
	 * @param school
	 * @param grades
	 * @param mergeFlag
	 * @return
	 */
	public StudentExamReportDTO.ReportDataList report(String examYear, String[] school, String[] grade,boolean mergeFlag);

	/**
	 * 添加体检记录
	 * @param studentExam
	 * @return
	 */
	public int addStudentExam(StudentExam studentExam);

	/**
	 * 更新体检记录
	 * @param studentExam
	 * @return
	 */
	public int updateStudentExam(StudentExam studentExam);

	/**
	 * 获取学生体检信息数量
	 *
	 * @param ca
	 * @return
	 * @author Ye jianfei
	 */
	public Integer getHealthExaminationCount(StudentExam studentExam);
	/**
	 * 取得体检记录
	 * @param criteria
	 * @return
	 */
	public StudentExam getStudentExam(Criteria criteria);
	
	/**
	 * 取得体检记录
	 * @param examYear
	 * @param idcard
	 * @return
	 */
	public StudentExam getStudentExamInfo(String examYear, String idcard);

	/**
	 * 删除体检记录
	 * @param criteria
	 * @return
	 */
	public int deleteStudentExam(Long studentExamId);

	/**
	 * 检查身高发育情况
	 * @param age
	 * @param gender
	 * @param height
	 * @return
	 */
	public String checkHeightCatagory(double age, String gender, double height);
	
	/**
	 * 检查体重发育情况
	 * @param age
	 * @param gender
	 * @param height
	 * @param weight
	 * @return
	 */
	public String checkWeightCatagory(double age, String gender, double height, double weight);
	
	/**
	 * 检查儿童高血压
	 * @param age
	 * @param gender
	 * @param sbp
	 * @param dbp
	 * @return
	 */
	public String checkHighBlood(double age, String gender, double sbp, double dbp);

	/**
	 * 保存打印日期
	 * @param examIds
	 */
	public void savePrintStatus(Long[] examIds);

	/**
	 * 导出体检数据
	 * @param page
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> exportExamList(Page page, Criteria criteria);
	
	/**
	 * 统计体检进度
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Map<String, Object>> getProgressList(Page page, Criteria criteria);	
}
