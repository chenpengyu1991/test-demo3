package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.repository.child.*;
import com.founder.rhip.ehr.repository.women.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service("macHealthService")
public class MacHealthServiceImpl extends AbstractService implements IMacHealthService {

    @Autowired
    private IPostnatalFollowupDao whPostnatalFollowupDao;

    @Autowired
    private IChEtbjXsefsDao chEtbjXsefsDao;

    @Resource(name = "chEtbjCsyxzmDao")
    private IChEtbjCsyxzmDao chEtbjCsyxzmDao;

    @Resource(name = "chEtbjJdDao")
    private IChEtbjJdDao chEtbjJdDao;

    @Resource(name = "chEtbjXmgztzDaoImpl")
    private IChEtbjXmgztzDao chEtbjXmgztzDaoImpl;

    @Autowired
    private IMaternalRegistrationDao maternalRegistrationDao;

    @Resource
    private IPrenatalFollowupDao whPrenatalFollowupDao;

    @Autowired
    private IPrenatalFollowupOtherDao prenatalFollowupOtherDao;

    @Autowired
    private IHighriskMaternalRegDao highriskMaternalRegDao;

    @Autowired
    private IHighriskMaternalFollowupDao highriskMaternalFollowupDao;

    @Autowired
    private IChEtbjJkjconeDao chEtbjJkjconeDao;

    @Autowired
    private IChEtbjJkjctwoDao chEtbjJkjctwoDao;

    @Autowired
    private IChEtbjJkjcthrDao chEtbjJkjcthrDao;

    @Autowired
    private IDeliveryRecordInfoDao deliveryRecordInfoDao;

    @Resource(name = "postpartumDaysHealthInfoDao")
    private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;  //产后42天健康检查信息表

    @Autowired
    private IWhYcfbjXsedjDao whYcfbjXsedjDao;

    @Autowired
    private IChEtbjTresfDao chEtbjTresfDao;

    @Autowired
    private IChEtbjTreDao chEtbjTreDao;

    @Autowired
    private IWhYcfbjSwdjDao whYcfbjSwdjDao;

    @Resource(name = "deliveryNeonatalDao")
    private IDeliveryNeonatalDao deliveryNeonatalDao;  //分娩记录新生儿情况

    @Override
    public List<PostnatalFollowup> getPostnatalInterviews(Criteria criteria, Order order, String[] properties) {
        return whPostnatalFollowupDao.getList(criteria, order, properties);
    }

    @Override
    public PostnatalFollowup getPostnatalInterview(Criteria criteria) {
        return whPostnatalFollowupDao.get(criteria);
    }

    @Override
    public List<ChEtbjXsefs> getNewBornInterviews(Criteria criteria, Order order, String[] properties) {
        return chEtbjXsefsDao.getList(criteria, order, properties);
    }

    @Override
    public ChEtbjXsefs getNewBornInterview(Criteria criteria) {
        return chEtbjXsefsDao.get(criteria);
    }

    @Override
    public List<ChEtbjCsyxzm> getChEtbjCsyxzms(Criteria criteria) {
        return chEtbjCsyxzmDao.getList(criteria,new Order("CSRQ DESC"));
    }

    @Override
    public ChEtbjCsyxzm getChEtbjCsyxzmDetail(Criteria criteria) {
        return chEtbjCsyxzmDao.get(criteria);
    }

    @Override
    public List<ChEtbjJd> getChEtbjJds(Criteria criteria, String[] properties) {
        return chEtbjJdDao.getList(criteria,new Order("CSRQ DESC"),properties);
    }

    @Override
    public List<ChEtbjJd> getChEtbjJds(Criteria criteria) {
        return chEtbjJdDao.getList(criteria,new Order("CSRQ DESC"));
    }


    @Override
    public ChEtbjJd getChEtbjJdDetail(Criteria criteria) {
        return chEtbjJdDao.get(criteria);
    }

    /**
     * 孕产妇专项卡列表
     */
    @Override
    public List<MaternalRegistration> getPregnantWomenTabList(Criteria criteria, String[] properties) {
        return maternalRegistrationDao.getList(criteria,new Order("INPUT_DATE DESC"),properties);
    }

    /**
     * 孕产妇专项卡
     */
    @Override
    public MaternalRegistration getPregnantWomenTab(Criteria criteria) {
        return maternalRegistrationDao.get(criteria);
    }

    @Override
    public List<PrenatalFollowup> getfirstantenatalvisitList(Criteria criteria, String[] properties) {
        return whPrenatalFollowupDao.getList(criteria,new Order("VISIT_DATE DESC"),properties);
    }

    /**
     * 产前第一次随访
     */
    @Override
    public PrenatalFollowup getFirstAntenatalVisitDetail(Criteria criteria) {
        return whPrenatalFollowupDao.get(criteria);
    }

    /**
     * 产前第2-5次随访列表
     */
    @Override
    public List<PrenatalFollowupOther> getTwoToFivevisitList(Criteria criteria, String[] properties) {
        return prenatalFollowupOtherDao.getList(criteria,new Order("INPUT_DATE_TWO DESC"),properties);
    }

    /**
     * 产前第2-5次随访详情
     */
    @Override
    public PrenatalFollowupOther getTwoToFivevisitDetail(Criteria criteria) {
        return prenatalFollowupOtherDao.get(criteria);
    }

    /**
     * 高危产妇登记列表
     */
    @Override
    public List<HighriskMaternalReg> getHighRiskMaternalRegistrationList(Criteria criteria, String[] properties) {
        return highriskMaternalRegDao.getList(criteria,new Order("ID DESC"),properties);
    }

    /**
     * 高危产妇登记
     */
    @Override
    public HighriskMaternalReg getHighRiskMaternalRegistration(Criteria criteria) {
        return highriskMaternalRegDao.get(criteria);
    }

    /**
     * 高危产妇随访时间列表
     */
    @Override
    public List<HighriskMaternalFollowup> getHighRiskMaternalTimeList(Criteria criteria) {
        return highriskMaternalFollowupDao.getList(criteria,new Order("FOLLOWUP_DATE DESC"));
    }

    /**
     * 高危产妇随访
     */
    @Override
    public HighriskMaternalFollowup getHighRiskMaternalVisit(Criteria criteria) {
        return highriskMaternalFollowupDao.get(criteria);
    }

    @Override
    public List<ChEtbjJkjcone> getChildHealthExaminationOnes(Criteria criteria, Order order, String[] properties) {
        return chEtbjJkjconeDao.getList(criteria, order, properties);
    }

    @Override
    public ChEtbjJkjcone getChildHealthExaminationOne(Criteria criteria) {
        return chEtbjJkjconeDao.get(criteria);
    }

    @Override
    public List<ChEtbjJkjctwo> getChildHealthExaminationTwos(Criteria criteria, Order order, String[] properties) {
        return chEtbjJkjctwoDao.getList(criteria, order, properties);
    }

    @Override
    public ChEtbjJkjctwo getChildHealthExaminationTwo(Criteria criteria) {
        return chEtbjJkjctwoDao.get(criteria);
    }

    @Override
    public List<ChEtbjJkjcthr> getChildHealthExaminationThrees(Criteria criteria, Order order, String[] properties) {
        return chEtbjJkjcthrDao.getList(criteria, order, properties);
    }

    @Override
    public ChEtbjJkjcthr getChildHealthExaminationThree(Criteria criteria) {
        return chEtbjJkjcthrDao.get(criteria);
    }

    /**
     * 分娩信息记录列表
     */
    public List<DeliveryRecordInfo> getDeliveryInfoRecordList(Criteria criteria, String[] properties){
        return deliveryRecordInfoDao.getList(criteria,new Order("DELIVERY_DATE DESC"),properties);
    };

    /**
     * 分娩信息记录详情
     */
    public DeliveryRecordInfo getDeliveryInfoRecordDetail(Criteria criteria){
        DeliveryRecordInfo info = deliveryRecordInfoDao.get(criteria);
        if(ObjectUtil.isNotEmpty(info)){
            info.setNeonatalList(deliveryNeonatalDao.getList(new Criteria("MOTHER_IDCARD",info.getIdCard()).add("RECORD_NUMBER",info.getRecordNumber()), new Order("ID", true)));
        }
        return info;
    };

    /**
     * 产后42天健康检查记录列表
     */
    public List<PostpartumDaysHealthInfo> getHealthCheckRecordList(Criteria criteria, String[] properties){
        return postpartumDaysHealthInfoDao.getList(criteria,new Order("SUPERVISION_DATE DESC"),properties);
    };


    /**
     * 产后42天健康检查记录详情
     */
    public PostpartumDaysHealthInfo getHealthCheckRecordDetail(Criteria criteria){
        return postpartumDaysHealthInfoDao.get(criteria);
    };

    /**
     * 新生儿登记列表
     */
    public List<WhYcfbjXsedj> getNewBornBabyRegisterList(Criteria criteria, String[] properties){
        return whYcfbjXsedjDao.getList(criteria,new Order("MCSJ DESC"),properties);
    };

    /**
     * 新生儿登记表详情
     */
    public WhYcfbjXsedj getNewBornBabyRegisterDetail(Criteria criteria){
        return whYcfbjXsedjDao.get(criteria);
    }

    @Override
    public ChEtbjTre getFrailInfantsFile(Criteria criteria) {
        return chEtbjTreDao.get(criteria);
    }

    @Override
    public List<ChEtbjTre> getFrailInfantsFileList(Criteria criteria, Order order, String[] properties) {
        return chEtbjTreDao.getList(criteria, order, properties);
    }

    /**
     * 查询体弱儿童列表
     * @param criteria
     * @return
     */
    @Override
    public List<ChEtbjTresf> getWeakChildrenList(Criteria criteria, String[] properties) {
        return chEtbjTresfDao.getList(criteria,new Order("XM DESC, SFRQ DESC"),properties);
    }
    /**
     * 查询体弱儿童详细
     * @param criteria
     * @return
     */
    @Override
    public ChEtbjTresf getWeakChildrenDetail(Criteria criteria) {
        return chEtbjTresfDao.get(criteria);
    };

    /**
     * 孕产妇死亡登记
     */
    public WhYcfbjSwdj getMaternalDeathRegistration(Criteria criteria) {
        return whYcfbjSwdjDao.get(criteria);
    }

    /**
     * 儿童花名册台账
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public PageList<Map<String, Object>> queryChEtbjJdPageList(Page page, Criteria criteria, Order order) {
        return chEtbjJdDao.queryChEtbjJdPageList(page, criteria, order);
    }

    /**
     * 儿童花名册台账 导出
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public List<Map<String, Object>> exportChEtbjJdPageList(Page page, Criteria criteria, Order order) {
        PageList<Map<String, Object>> pageList =  chEtbjJdDao.queryChEtbjJdPageList(page, criteria, order);
        List<Map<String, Object>> list = null;
        if (null != pageList) {
            list = pageList.getList();
        }
        if (null == list) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public PageList<ChEtbjJd> getChEtbjJdPageList(Page page, Criteria criteria, Order order) {
        return chEtbjJdDao.getPageList(page, criteria, order);
    }

    /**
     * 0-6岁儿童项目工作台账
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public List<Map<String, Object>> queryChEtbjXmgztzList(Criteria criteria, Order order) {
        return chEtbjXmgztzDaoImpl.queryEtbjXmgztzList(criteria, order);
    }

    /**
     * 根据查询条件获取0-6岁儿童项目的合计数据
     * @param criteria
     * @return
     */
    @Override
    public Map<String, Object> queryTotalEtbjXmgztzGroupByNf(Criteria criteria) {
        return chEtbjXmgztzDaoImpl.queryTotalEtbjXmgztzGroupByNf(criteria);
    }

}
