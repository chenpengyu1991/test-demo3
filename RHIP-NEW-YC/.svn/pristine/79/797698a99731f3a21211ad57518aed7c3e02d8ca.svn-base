package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.management.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jingqiu on 17-4-14.
 */
public interface IHighRisk135Service {

    /**
     * 获取筛选标准
     * @return
     */
    List<Dm135Standard> getStandards();

    /**
     * 获取问卷调查列表页面
     * @param page
     * @param criteria
     * @return
     */
    public PageList<Dm135Question> getPagedQuestionList(Page page, Criteria criteria);

    /**
     * 获取问卷调查
     * @param criteria
     * @return
     */
    public Dm135Question getQuestion(Criteria criteria);

    /**
     * 保存问卷调查
     * @param question
     * @return
     */
    public int saveQuestion(Dm135Question question);

    /**
     * 添加问卷调查
     * @param question
     * @return
     */
    public int addQuestion(Dm135Question question);

    /**
     * 更新问卷调查
     * @param question
     * @return
     */
    public int updateQuestion(Dm135Question question);

    /**
     * 删除问卷调查
     * @param id
     * @return
     */
    public int deleteQuestion(String id);

    /**
     * 获取末次问卷调查列表页面
     * @param page
     * @param criteria
     * @return
     */
    public PageList<Dm135LastQuestion> getPagedLastQuestionList(Page page, Criteria criteria);

    /**
     * 获取末次问卷调查
     * @param criteria
     * @return
     */
    public Dm135LastQuestion getLastQuestion(Criteria criteria);
    PageList<Dm135LastQuestion> getLastQuestionList(Criteria criteria, Page page);

    /**
     * 获取评价详细列表
     * @param question
     * @return
     */
    PageList<Dm135Appraise> getDm315AppraiseList(Criteria criteria, Page page);
    /**
     * 获取评价详细
     * @param question
     * @return
     */
    Dm135Appraise getDm315Appraise(Criteria criteria);
    /**
     * 保存末次问卷调查
     * @param question
     * @return
     */
    public int saveLastQuestion(Dm135LastQuestion question);

    /**
     * 添加末次问卷调查
     * @param question
     * @return
     */
    public int addLastQuestion(Dm135LastQuestion question);

    /**
     * 更新末次问卷调查
     * @param question
     * @return
     */
    public int updateLastQuestion(Dm135LastQuestion question);

    /**
     * 删除末次问卷调查
     * @param id
     * @return
     */
    public int deleteLastQuestion(String id);

    /**
     * 查询管理卡首页列表
     * @param page
     * @param criteria
     * @return
     */
    public PageList<Dm135Mgmt> getPagedMgmtList(Page page, Criteria criteria);

    /**
     * 获取管理卡数据
     * @param criteria
     * @return
     */
    public Dm135Mgmt getMgmt(Criteria criteria);

    /**
     * 保存管理卡首页
     * @param mgmt
     * @return
     */
    public int saveMgmtCover(Dm135Mgmt mgmt);

    public int addMgmtCover(Dm135Mgmt mgmt);

    public int updateMgmtCover(Dm135Mgmt mgmt);

    /**
     * 获取体检数据
     * @param criteria
     * @return
     */
    public Dm135ManageCardTemp getManageCardTemp(Criteria criteria);

    public PageList<Dm135ManageCardTemp> getManageCardTempList(Page page, Criteria criteria);
    /**
     * 获取随访列表
     * @param criteria
     * @return
     */
    public List<Dm135Followup> getFollowupList(Criteria criteria);

    /**
     * 获取随访趋势图数据
     * @param id
     * @return
     */
    public List<Map<String, Object>> getFollowupTrendData(String id);

    /**
     * 获取随访记录
     * @param criteria
     * @return
     */
    public Dm135Followup getFollowup(Criteria criteria);

    /**
     * 保存随访记录
     * @param followup
     * @return
     */
    public int saveFollowup(Dm135Followup followup);

    /**
     * 保存评价信息
     *
     * */
    public int saveEvaluate(Dm135Appraise appraise);


    /**
     * 获取在一个年度中已经按照计划完成随访的高危人群信息
     * @param criteria
     * @param page
     * @return
     */
    PageList<Dm135Mgmt> getDm135MgmtsFinishedFollow(Page page, Criteria criteria);

    /**
     * 返回true表示此时此居民可以填写评价 false表示不可以
     * @param idNo
     * @return
     */
    boolean isCanAppraise(String idNo);

}
