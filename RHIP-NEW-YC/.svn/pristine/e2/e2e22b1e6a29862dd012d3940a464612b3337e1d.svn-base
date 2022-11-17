package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;

import java.util.List;
import java.util.Map;

public interface IMacHealthService {

    /**
     * 产后访视列表
     * @param criteria
     * @param properties
     * @return
     */
    public List<PostnatalFollowup> getPostnatalInterviews(Criteria criteria, Order order, String[] properties);

    /**
     * 产后访视
     * @param criteria
     * @return
     */
    public PostnatalFollowup getPostnatalInterview(Criteria criteria);

    /**
     * 新生儿访视列表
     * @param criteria
     * @param properties
     * @return
     */
    public List<ChEtbjXsefs> getNewBornInterviews(Criteria criteria, Order order, String[] properties);

    /**
     * 新生儿访视
     * @param criteria
     * @return
     */
    public ChEtbjXsefs getNewBornInterview(Criteria criteria);


    /**
     * 查询母亲所有子女列表
     * @param criteria
     * @return
     */
    public List<ChEtbjCsyxzm> getChEtbjCsyxzms(Criteria criteria);


    /**
     * 查询出生登记卡所需详细信息
     */
    public ChEtbjCsyxzm getChEtbjCsyxzmDetail(Criteria criteria);

    /**
     * 查询母亲所有小孩列表
     */
    public List<ChEtbjJd> getChEtbjJds(Criteria criteria, String[] properties);

    public List<ChEtbjJd> getChEtbjJds(Criteria criteria);
    /**
     * 儿童信息登记卡
     */
    public ChEtbjJd getChEtbjJdDetail(Criteria criteria);

    /**
     * 孕产妇选项卡列表
     */
    public List<MaternalRegistration> getPregnantWomenTabList(Criteria criteria, String[] properties);

    /**
     * 孕产妇选项卡
     */
    public MaternalRegistration getPregnantWomenTab(Criteria criteria);

    /**
     * 产前第一次随访列表
     */
    public List<PrenatalFollowup> getfirstantenatalvisitList(Criteria criteria, String[] properties);
    /**
     * 产前第一次随访
     */
    public PrenatalFollowup getFirstAntenatalVisitDetail(Criteria criteria);

    /**
     * 产前第2-5次随访列表
     */
    public List<PrenatalFollowupOther> getTwoToFivevisitList(Criteria criteria, String[] properties);

    /**
     * 产前第2-5次随访详情
     */
    public PrenatalFollowupOther getTwoToFivevisitDetail(Criteria criteria);

    /**
     * 高危产妇登记列表
     */
    public List<HighriskMaternalReg> getHighRiskMaternalRegistrationList(Criteria criteria, String[] properties);
    /**
     * 高危产妇登记
     */
    public HighriskMaternalReg getHighRiskMaternalRegistration(Criteria criteria);

    /**
     * 高危产妇随访时间列表
     */
    public List<HighriskMaternalFollowup> getHighRiskMaternalTimeList(Criteria criteria);
    /**
     * 高危产妇随访
     */
    public HighriskMaternalFollowup getHighRiskMaternalVisit(Criteria criteria);
    /**
     * 1-8月龄儿童健康检查记录列表
     * @param criteria
     * @param properties
     * @return
     */
    public List<ChEtbjJkjcone> getChildHealthExaminationOnes(Criteria criteria, Order order, String[] properties);

    /**
     * 1-8月龄儿童健康检查记录详细
     * @param criteria
     * @return
     */
    public ChEtbjJkjcone getChildHealthExaminationOne(Criteria criteria);

    /**
     * 12-30月龄儿童健康检查记录列表
     * @param criteria
     * @param properties
     * @return
     */
    public List<ChEtbjJkjctwo> getChildHealthExaminationTwos(Criteria criteria, Order order, String[] properties);

    /**
     * 12-30月龄儿童健康检查记录详细
     * @param criteria
     * @return
     */
    public ChEtbjJkjctwo getChildHealthExaminationTwo(Criteria criteria);

    /**
     * 3-6岁儿童健康检查记录列表
     * @param criteria
     * @param properties
     * @return
     */
    public List<ChEtbjJkjcthr> getChildHealthExaminationThrees(Criteria criteria, Order order, String[] properties);

    /**
     * 3-6岁儿童健康检查记录详细
     * @param criteria
     * @return
     */
    public ChEtbjJkjcthr getChildHealthExaminationThree(Criteria criteria);

    /**
     * 分娩信息记录列表
     */
    public List<DeliveryRecordInfo> getDeliveryInfoRecordList(Criteria criteria, String[] properties);

    /**
     * 分娩信息记录详情
     */
    public DeliveryRecordInfo getDeliveryInfoRecordDetail(Criteria criteria);

    /**
     * 产后42天健康检查记录列表
     */
    public List<PostpartumDaysHealthInfo> getHealthCheckRecordList(Criteria criteria, String[] properties);

    /**
     * 产后42天健康检查记录详情
     */
    public PostpartumDaysHealthInfo getHealthCheckRecordDetail(Criteria criteria);

    /**
     * 新生儿登记列表
     */
    public List<WhYcfbjXsedj> getNewBornBabyRegisterList(Criteria criteria, String[] properties);

    /**
     * 新生儿登记表详情
     */
    public WhYcfbjXsedj getNewBornBabyRegisterDetail(Criteria criteria);

    /**
     * 体弱儿专项档案详细
     */
    public ChEtbjTre getFrailInfantsFile(Criteria criteria);

    /**
     * 体弱儿专项档案列表
     */
    public List<ChEtbjTre> getFrailInfantsFileList(Criteria criteria, Order order, String[] properties);

    /**
     * 查询体弱儿童列表
     */
    public List<ChEtbjTresf> getWeakChildrenList(Criteria criteria, String[] properties);

    /**
     * 体弱儿童随访
     */
    public ChEtbjTresf getWeakChildrenDetail(Criteria criteria);

    /**
     * 孕产妇死亡登记
     */
    public WhYcfbjSwdj getMaternalDeathRegistration(Criteria criteria);

    /**
     * 儿童花名册台账
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<Map<String, Object>> queryChEtbjJdPageList(Page page, Criteria criteria, Order order);

    /**
     * 儿童花名册台账 导出
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public List<Map<String, Object>> exportChEtbjJdPageList(Page page, Criteria criteria, Order order);

    /**
     * 获取建档儿童列表
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<ChEtbjJd> getChEtbjJdPageList(Page page, Criteria criteria, Order order);

    /**
     * 0-6岁儿童项目工作台账
     * @param criteria
     * @param order
     * @return
     */
    public List<Map<String, Object>> queryChEtbjXmgztzList(Criteria criteria, Order order);

    /**
     * 根据查询条件获取0-6岁儿童项目的合计数据
     * @param criteria
     * @return
     */
    public Map<String, Object> queryTotalEtbjXmgztzGroupByNf(Criteria criteria);

}