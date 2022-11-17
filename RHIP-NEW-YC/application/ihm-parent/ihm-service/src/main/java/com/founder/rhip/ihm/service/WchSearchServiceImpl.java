/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.ReflectionUtils;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.child.*;
import com.founder.rhip.ehr.repository.ihm.IEpidemicTargetDao;
import com.founder.rhip.ehr.repository.women.*;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("wchSearchService")
public class WchSearchServiceImpl extends IhmService implements IWchSearchService, IPersonRecordMoveService {
    Logger log = Logger.getLogger(getClass());

    @Resource(name = "epidemicTargetDao")
    private IEpidemicTargetDao epidemicTargetDao;


    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;


    @Resource(name = "birthCertificateDao")
    private IBirthCertificateDao birthCertificateDao; //出生医学证明表

    @Resource(name = "childHealthCardDao")
    private IChildHealthCardDao childHealthCardDao; //儿童保健卡表

    @Resource(name = "birthDefectMonitorDao")
    private IBirthDefectMonitorDao birthDefectMonitorDao;  //出生缺陷监测表

    @Resource(name = "neonatalFamilyVisitDao")
    private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表

    @Resource(name = "childHealthExaminationDao")
    private IChildHealthExaminationDao childHealthExaminationDao;  //儿童健康体检表

    @Resource(name = "deliveryRecordInfoDao")
    private IDeliveryRecordInfoDao deliveryRecordInfoDao;  //分娩记录信息表

    @Resource(name = "motherhoodPeriodFollowupDao")
    private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;  //孕产期保健服务与高危管理随访表

    @Resource(name = "prenatalFollowupDao")
    private IPrenatalFollowupDao prenatalFollowupDao;  //产前随访服务信息表

    @Resource(name = "postpartumDaysHealthInfoDao")
    private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;  //产后42天健康检查信息表

    @Resource(name = "womanDiseaseCensusDao")
    private IWomanDiseaseCensusDao womanDiseaseCensusDao;  //妇女疾病筛查，即妇女病普查

    @Resource(name = "whPostnatalFollowupDao")
    private IPostnatalFollowupDao postnatalFollowupDao;  //产后访视

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;
    @Resource(name = "platformService")
    private IPlatformService platformService;
    @Resource(name = "womenChildHealthDao")
    private IWomenChildHealthDao womenChildHealthDao;

    /**
     * 医学出生证明
     * @param paramMap
     * @param page
     * @return
     */
    @Override
    public PageList<BirthCertificate> getChildBirthList(Map<String, String> paramMap, Page page) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String birthday = paramMap.get("birthday");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String birthCertificateNo = paramMap.get("birthCertificateNo");
        String bcStatus = paramMap.get("bcStatus");

        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NEONATAL_NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("NEONATAL_GENDER", gender);
        }
        if (StringUtil.isNotEmpty(birthday)) {
            DateUtil.getCriteriaByDateRange(ca, "NEONATAL_BIRTHDAY", DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"), DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(createDate)) {
            DateUtil.getCriteriaByDateRange(ca, "ISSUED_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(birthCertificateNo)) {
            ca.add("BIRTH_CERTIFICATE_NO", birthCertificateNo);
        }
        if (StringUtil.isNotEmpty(bcStatus)) {
            ca.add("PROCESS_STATUS", bcStatus);
        }
        PageList<BirthCertificate> pageList = birthCertificateDao.getPageList(page, ca, new Order(" ISSUED_DATE  DESC, BIRTH_CERTIFICATE_NO ", false));

        return pageList;
    }

    /**
     * 出生缺陷登记
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<BirthDefectMonitor> getBirthDefectList(Map<String, String> paramMap, Page page) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String birthday = paramMap.get("birthday");
        String organCode = paramMap.get("organCode");

        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("NEONATAL_GENDER", gender);
        }
        if (StringUtil.isNotEmpty(birthday)) {
            DateUtil.getCriteriaByDateRange(ca, "DELIVERY_DATE", DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"), DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
//        PageList<BirthDefectMonitor> pageList = birthDefectMonitorDao.getPageList(page, ca, new Order("DELIVERY_DATE DESC, ID", false));
        PageList<BirthDefectMonitor> pageList = birthDefectMonitorDao.getPageList(page, ca, new Order("ID", false));

        return pageList;
    }

    /**
     * 儿童登记管理
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<ChildHealthCard> getHealthCardList(Map<String, String> paramMap, Page page) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String birthday = paramMap.get("birthday");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");

        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("SEX_CODE", gender);
        }
        if (StringUtil.isNotEmpty(birthday)) {
            DateUtil.getCriteriaByDateRange(ca, "BIRTHDAY", DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"), DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(createDate)) {
            DateUtil.getCriteriaByDateRange(ca, "INPUT_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
        PageList<ChildHealthCard> pageList = childHealthCardDao.getPageList(page, ca, new Order("INPUT_DATE DESC, ID", false));

        return pageList;
    }

    /**
     * 新生儿随访信息
     * @param paramMap
     * @param page
     * @return
     */


    public PageList<NeonatalFamilyVisit> getNeonatalVisitList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String birthday = paramMap.get("birthday");
        String birthdayEnd = paramMap.get("birthdayEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        Criteria ca = new Criteria();
        ca.add("is_delete", 0);
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NEONATUS_NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("NEONATAL_GENDER", gender);
        }
        if (StringUtil.isNotEmpty(birthday)) {
            DateUtil.getCriteriaByDateRange(ca, "NEONATUS_BIRTHDAY", DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"), DateUtil.parseSimpleDate(birthdayEnd, "yyyy/MM/dd"));
        }
        /*if(StringUtil.isNotEmpty(organCode)){
            ca.add("CREATE_ORGAN_CODE", organCode);
        }*/

        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            } else if (ObjectUtil.isNotEmpty(orgCodes)) {
                ca.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            } else if (ObjectUtil.isNotEmpty(orgCodes)) {
                ca.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        }
        if (StringUtil.isNotEmpty(createDate)) {
            //DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
            DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
//        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("visit_date", false));
        return pageList;
    }

    /**
     * 儿童体检信息
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<ChildHealthExamination> getHealthExaminationList(Map<String, String> paramMap, Page page) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String idCard = paramMap.get("idCard");
        String birthday = paramMap.get("birthday");
        String checkDate = paramMap.get("createDate");
        String organCode = paramMap.get("organCode");
        String genreCode = paramMap.get("genreCode");

        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("GENDER", gender);
        }
        if (StringUtil.isNotEmpty(checkDate)) {
            Date beginDate = DateUtil.parseSimpleDate(checkDate + " 00:00:00", "yyyy/MM/dd HH:mm:ss");
            Date endDate = DateUtil.parseSimpleDate(checkDate + " 23:59:59", "yyyy/MM/dd HH:mm:ss");
            DateUtil.getCriteriaByDateRange(ca, "checkDate", beginDate, endDate);
        }
        if (StringUtil.isNotEmpty(organCode)) {
            Criteria criteriaTemp = new Criteria();
            if ("0".equals(genreCode)) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
            {
                criteriaTemp = new Criteria().add("gbCode", organCode);
            } else //如果是中心或服务站，则查出对应的数据
            {
                ca.add("createOrganCode", organCode);
            }

            if (null != criteriaTemp) {
                List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

                if (!CollectionUtils.isEmpty(orgs)) {
                    ca.add("createOrganCode", OP.IN, Convert2Array(orgs, "organCode"));
                }
            }
        }
        if (StringUtil.isNotEmpty(birthday)) {
            DateUtil.getCriteriaByDateRange(ca, "BIRTHDAY", DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"), DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"));
        }
//        PageList<ChildHealthExamination> pageList = childHealthExaminationDao.getPageList(page, ca, new Order("CHECK_DATE DESC, ID", false));
        PageList<ChildHealthExamination> pageList = childHealthExaminationDao.getPageList(page, ca, new Order("ID", false));

        return pageList;
    }

    private <T> Object[] Convert2Array(List<T> list, String fieldName) {
        Object[] ta = new Object[list.size()];
        if (CollectionUtils.isEmpty(list)) return ta;
        Method method;
        try {
            method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            for (int i = 0; i < list.size(); i++) {
                ta[i] = method.invoke(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ta;
    }


    @Override
    public BirthCertificate getChBirthCertificate(Criteria criteria) {
        return birthCertificateDao.get(criteria);
    }

    @Override
    public BirthDefectMonitor getBirthDefect(Criteria criteria) {
        return birthDefectMonitorDao.get(criteria);
    }

    @Override
    public ChildHealthCard getHealthCard(Criteria criteria) {
        return childHealthCardDao.get(criteria);
    }

    @Override
    public NeonatalFamilyVisit getNeonatalVisit(Criteria criteria) {
        return neonatalFamilyVisitDao.get(criteria);
    }

    @Override
    public List<NeonatalFamilyVisit> getNeonatalVisitList(Criteria criteria, Order order) {
        return neonatalFamilyVisitDao.getList(criteria, order);
    }

    @Override
    public PageList<NeonatalFamilyVisit> getNeonatalVisitList(Criteria criteria, Page page){
        return neonatalFamilyVisitDao.getPageList(page, criteria, new Order("create_Date", false));
    }

    @Override
    public ChildHealthExamination getHealthExamination(Criteria criteria) {
        return childHealthExaminationDao.get(criteria);
    }

    @Override
    public PageList<MotherhoodPeriodFollowup> getMotherhoodPeriodList(Map<String, String> paramMap, Page page) {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(paramMap.get("name"))) {
            criteria.add("motherName", OP.LIKE, paramMap.get("name"));
        }
        if (StringUtil.isNotEmpty(paramMap.get("idCard"))) {
            criteria.add("idcard", paramMap.get("idCard"));
        }
        if (StringUtil.isNotEmpty(paramMap.get("birthday"))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = null;
            try {
                date = sdf.parse(paramMap.get("birthday"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DateUtil.getCriteriaByDateRange(criteria,"birthday",date,date);
        }
//        Order order = new Order("CHECK_DATE", false);
        Order order = new Order("ID", false);
        order.desc("ID");
        return motherhoodPeriodFollowupDao.getPageList(page, criteria, order);
    }

    @Override
    public PageList<PrenatalFollowup> getPrenatalFollowupList(Map<String, String> paramMap, Page page) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String estimatedDueDate = paramMap.get("estimatedDueDate");
        String createDate = paramMap.get("createDate");
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(estimatedDueDate)) {
            DateUtil.getCriteriaByDateRange(ca, "ESTIMATED_DUE_DATES", DateUtil.parseSimpleDate(estimatedDueDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(estimatedDueDate, "yyyy/MM/dd"));
        }
        if (StringUtil.isNotEmpty(createDate)) {
            DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"));
        }
        return prenatalFollowupDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
    }

    @Override
    public PageList<DeliveryRecordInfo> getDeliveryList(Map<String, String> paramMap, Page page) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String idCard = paramMap.get("idCard");
        String createDate = paramMap.get("createDate");
        ca.add("IS_DELETE", 0);
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(createDate)) {
            DateUtil.getCriteriaByDateRange(ca, "DELIVERY_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"));
        }
        return deliveryRecordInfoDao.getPageList(page, ca, new Order("DELIVERY_DATE DESC, ID", false));
    }

    @Override
    public PageList<PostpartumDaysHealthInfo> getPostpartumList(Boolean flg, List<String> list, Map<String, String> paramMap, Page page) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String idCard = paramMap.get("idCard");
        /*String createDate = paramMap.get("createDate");*/
        String checkDateStart = paramMap.get("checkDateStart");
        String checkDateEnd = paramMap.get("checkDateEnd");
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            } else if (ObjectUtil.isNotEmpty(list)) {
                ca.add("CREATE_ORGAN_CODE", OP.IN, list);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            }else if(ObjectUtil.isNotEmpty(list)){
                ca.add("CREATE_ORGAN_CODE", OP.IN, list);
            }
        }
        /*if(StringUtil.isNotEmpty(organCode)){
            ca.add("CREATE_ORGAN_CODE", organCode);
        }*/
        if (StringUtil.isNotEmpty(checkDateStart) || StringUtil.isNotEmpty(checkDateEnd)) {
            DateUtil.getCriteriaByDateRange(ca, "SUPERVISION_DATE", DateUtil.parseSimpleDate(checkDateStart, "yyyy/MM/dd"), DateUtil.parseSimpleDate(checkDateEnd, "yyyy/MM/dd"));
        }
        ca.add("isDelete", 0);
        return postpartumDaysHealthInfoDao.getPageList(page, ca, new Order("SUPERVISION_DATE DESC, ID", false));
    }

    @Override
    public PageList<WomanDiseaseCensus> getWomanDiseaseCensusList(Map<String, String> paramMap, Page page) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String idCard = paramMap.get("idCard");
//        String createDate = paramMap.get("createDate");
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (StringUtil.isNotEmpty(organCode)) {
            ca.add("CREATE_ORGAN_CODE", organCode);
        }
//        if(StringUtil.isNotEmpty(createDate)){
//            DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", DateUtil.convert("yyyy/MM/dd", createDate), DateUtil.convert("yyyy/MM/dd", createDate));
//        }

        Date beginDate = DateUtil.parseSimpleDate(paramMap.get("checkDateStart"), null);
        Date endDate = DateUtil.parseSimpleDate(paramMap.get("checkDateEnd"), null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,
                endDate);

//        return womanDiseaseCensusDao.getPageList(page, ca, new Order("CHECK_DATE DESC, ID", false));
        return womanDiseaseCensusDao.getPageList(page, ca, new Order("ID", false));
    }

    @Override
    public PageList<PostnatalFollowup> getPostnatalFollowupList(Boolean flg, List<String> list, Map<String, String> paramMap, Page page) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String idCard = paramMap.get("idCard");
        String checkDateStart = paramMap.get("checkDateStart");
        String checkDateEnd = paramMap.get("checkDateEnd");
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            } else if (ObjectUtil.isNotEmpty(list)) {
                ca.add("CREATE_ORGAN_CODE", OP.IN, list);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            }else if(ObjectUtil.isNotEmpty(list)){
                ca.add("CREATE_ORGAN_CODE", OP.IN, list);
            }
        }
        /*if(StringUtil.isNotEmpty(organCode)){
            ca.add("CREATE_ORGAN_CODE", organCode);
        }*/
        if (StringUtil.isNotEmpty(checkDateStart) || StringUtil.isNotEmpty(checkDateEnd)) {
            DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", DateUtil.parseSimpleDate(checkDateStart, "yyyy/MM/dd"), DateUtil.parseSimpleDate(checkDateEnd, "yyyy/MM/dd"));
        }
        ca.add("isDelete", 0);
//        return womanDiseaseCensusDao.getPageList(page, ca, new Order("CHECK_DATE DESC, ID", false));
        return postnatalFollowupDao.getPageList(page, ca, new Order("ID", false));
    }


    @Override
    public int deleteNeonatalFamilyVisit(String id) {
        NeonatalFamilyVisit neonatalFamilyVisit = neonatalFamilyVisitDao.get(id);
        neonatalFamilyVisit.setIsDelete(Short.valueOf("1"));
        int num = neonatalFamilyVisitDao.update(neonatalFamilyVisit);
        return num;
    }

    @Override
    public int saveNeonatalFamilyVisit(NeonatalFamilyVisit neonatalFamilyVisit, Organization org) {
        // TODO Auto-generated method stub
        //List<PersonInfo> list=personInfoDao.getList(new Criteria("Baby_Card_No", OP.LIKE,"%"+ neonatalFamilyVisit.getBabyCardNo() + "%"), "Baby_Card_No");
        int num = 0;

        try {

            //所属乡镇 修改成编号 Modify by:MeiXingjian
            PersonInfo personInfo = new PersonInfo();
            if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisit.getId())) {
                List<PersonInfo> list = new ArrayList<PersonInfo>();
                list = personInfoDao.getList(new Criteria("ID", neonatalFamilyVisit.getPersonId()), "ID");
				/*if(list==null||list.size()==0){
					list=personInfoDao.getList(new Criteria("BABY_CARD_NO", neonatalFamilyVisit.getBabyCardNo()), "BABY_CARD_NO");
				}*/
                if (list == null || list.size() == 0) {
					/*personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(neonatalFamilyVisit.getBabyCardNo());*/
                    personInfo.setUpdateName(neonatalFamilyVisit.getCreateOrganName());
                    //personInfo.setOtherIdcard(neonatalFamilyVisit.getNeonatusIdcard());
                    personInfo.setName(neonatalFamilyVisit.getNeonatusName());
                    personInfo.setBirthday(neonatalFamilyVisit.getNeonatusBirthday());
                    personInfo.setGender(neonatalFamilyVisit.getNeonatalGender());
                    personInfo.setBabyCardNo(neonatalFamilyVisit.getBabyCardNo());
                    /*num=personInfoDao.insert(personInfo);
                     */
                    personInfo.setFilingFlag("0");
                    personInfo.setUpdateOrganCode(org.getOrganCode());
                    personInfo.setUpdateName(org.getOperator());
                    personInfo = ReflectionUtils.wrapBean(PersonInfo.class, neonatalFamilyVisit);
                    personInfo.setPastreet(neonatalFamilyVisit.getPastreet());
                    personInfo.setPatownShip(neonatalFamilyVisit.getPatownShip());
                    personInfo.setPacounty(neonatalFamilyVisit.getPacounty());
                    personInfo.setPahouseNumber(neonatalFamilyVisit.getPahouseNumber());
                    neonatalFamilyVisit.setCreateOrganCode(org.getOrganCode());
                    Long personId = platformService.createPerson(personInfo, org.getOrganCode(), org.getOrganCode());
                    neonatalFamilyVisit.setPersonId(personId);
                    neonatalFamilyVisit.setCreateDate(new Date());
                    neonatalFamilyVisit.setIsDelete(Short.valueOf("0"));
                    num = neonatalFamilyVisitDao.insert(neonatalFamilyVisit);
                } else {
                    if (StringUtil.isNotEmpty(neonatalFamilyVisit.getBabyCardNo())) {
                        personInfo = personInfoDao.get(neonatalFamilyVisit.getPersonId());
                        personInfo.setIdcard(neonatalFamilyVisit.getNeonatusIdcard());
                        personInfo.setBabyCardNo(neonatalFamilyVisit.getBabyCardNo());
                        /*personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
                        personInfo.setOtherIdcard(neonatalFamilyVisit.getBabyCardNo());*/
                        personInfo.setUpdateName(neonatalFamilyVisit.getCreateOrganName());
                        //personInfo.setOtherIdcard(neonatalFamilyVisit.getNeonatusIdcard());
                        personInfo.setName(neonatalFamilyVisit.getNeonatusName());
                        personInfo.setBirthday(neonatalFamilyVisit.getNeonatusBirthday());
                        personInfo.setGender(neonatalFamilyVisit.getNeonatalGender());
                        personInfo.setPastreet(neonatalFamilyVisit.getPastreet());
                        personInfo.setPatownShip(neonatalFamilyVisit.getPatownShip());
                        personInfo.setPacounty(neonatalFamilyVisit.getPacounty());
                        personInfo.setPahouseNumber(neonatalFamilyVisit.getPahouseNumber());
                        /*num=personInfoDao.insert(personInfo);
                         */
                        if ("4".equals(personInfo.getFilingFlag()) && StringUtil.isNotEmpty(neonatalFamilyVisit.getNeonatusIdcard())) {
                            personInfo.setFilingFlag("0");
                        } else {
                            personInfo.setFilingFlag(personInfo.getFilingFlag());
                        }
                        personInfo.setUpdateOrganCode(org.getOrganCode());
                        personInfo.setUpdateOrganCode(org.getOrganCode());
                        personInfo.setUpdateName(org.getOperator());
                        personInfoDao.update(personInfo);
                        neonatalFamilyVisit.setCreateOrganCode(org.getOrganCode());
                        neonatalFamilyVisit.setPersonId(personInfo.getId());
                        neonatalFamilyVisit.setCreateDate(new Date());
                        neonatalFamilyVisit.setIsDelete(Short.valueOf("0"));
                        num = neonatalFamilyVisitDao.insert(neonatalFamilyVisit);
                    }
                }
            } else {

                personInfo = personInfoDao.get(neonatalFamilyVisit.getPersonId());
                /*personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
                personInfo.setOtherIdcard(neonatalFamilyVisit.getBabyCardNo());*/
                personInfo.setUpdateName(neonatalFamilyVisit.getCreateOrganName());
                personInfo.setName(neonatalFamilyVisit.getNeonatusName());
                personInfo.setBirthday(neonatalFamilyVisit.getNeonatusBirthday());
                personInfo.setGender(neonatalFamilyVisit.getNeonatalGender());
                personInfo.setPastreet(neonatalFamilyVisit.getPastreet());
                personInfo.setPatownShip(neonatalFamilyVisit.getPatownShip());
                personInfo.setPacounty(neonatalFamilyVisit.getPacounty());
                personInfo.setPahouseNumber(neonatalFamilyVisit.getPahouseNumber());
                personInfo.setBabyCardNo(neonatalFamilyVisit.getBabyCardNo());
                /*num=personInfoDao.insert(personInfo);
                 */
                if ("4".equals(personInfo.getFilingFlag()) && StringUtil.isNotEmpty(neonatalFamilyVisit.getNeonatusIdcard())) {
                    personInfo.setFilingFlag("0");
                } else {
                    personInfo.setFilingFlag(personInfo.getFilingFlag());
                }
                personInfo.setUpdateOrganCode(org.getOrganCode());
                personInfo.setUpdateOrganCode(org.getOrganCode());
                personInfo.setUpdateName(org.getOperator());
                personInfo.setIdcard(neonatalFamilyVisit.getNeonatusIdcard());
                personInfoDao.update(personInfo);
                neonatalFamilyVisit.setCreateOrganCode(org.getOrganCode());
                neonatalFamilyVisit.setUpdateDate(new Date());
                neonatalFamilyVisit.setIsDelete(Short.valueOf("0"));

                num = neonatalFamilyVisitDao.update(neonatalFamilyVisit);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return num;
        }
        return num;


    }

    @Override
    public List<NeonatalFamilyVisit> getList(Criteria criteria, String string) {
        // TODO Auto-generated method stub
        return neonatalFamilyVisitDao.getList(criteria, string);
    }

    @Override
    public List<WomenChildHealth> getWomenChildHealthList(Criteria criteria) {
        // TODO Auto-generated method stub
        return womenChildHealthDao.getList(criteria);
    }

    @Override
    public List<WomenChildHealth> getWomenChildHealthSumList(Criteria criteria) {
        // TODO Auto-generated method stub
        return womenChildHealthDao.getWomenChildHealthSumList(criteria);
    }

    @Override
    public int inerstWomenChildHealth(WomenChildHealth womenChildHealth) {
        // TODO Auto-generated method stub
        String properties[] = {"babyCardNo", "idCard", "createDate", "createPerson", "updateDate", "updatePerson", "gender", "orgCode", "orgName", "childBirthday", "name", "personId", "identityType", "healthFileNo", "isDelete"};
        return womenChildHealthDao.insert(womenChildHealth, properties);
    }

    @Override
    public int updateWomenChildHealth(WomenChildHealth womenChildHealth) {

        String properties[] = {"babyCardNo", "idCard", "updateDate", "updatePerson", "gender", "orgCode", "orgName", "childBirthday", "name", "personId", "identityType", "healthFileNo"};
        return womenChildHealthDao.update(womenChildHealth, properties);
    }

    @Override
    public PageList<WomenChildHealth> getChildHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap,
                                                         Page page) {

//        String name = paramMap.get("name");
//        String gender = paramMap.get("gender");
//        String updateDate = paramMap.get("updateDate");
//        String updateDateEnd = paramMap.get("updateDateEnd");
//        String organCode = paramMap.get("organCode");
//        String createDate = paramMap.get("createDate");
//        String createDateEnd = paramMap.get("createDateEnd");
//        String idCard=paramMap.get("idCard");
//        String healthGuideStatus= paramMap.get("healthGuideStatus");
//        Criteria ca = new Criteria();
//        ca.add("is_delete",0);
//        ca.add("IDENTITY_TYPE",1);
//        if(StringUtil.isNotEmpty(name)){
//            ca.add("NAME", name);
//        }
//        if(StringUtil.isNotEmpty(idCard)){
//            ca.add("ID_CARD", idCard);
//        }
//        if(StringUtil.isNotEmpty(gender)){
//            ca.add("GENDER", gender);
//        }
//        /*if(StringUtil.isNotEmpty(organCode)){
//            ca.add("CREATE_ORGAN_CODE", organCode);
//        }*/
//        if(StringUtil.isNotEmpty(updateDate)||StringUtil.isNotEmpty(updateDateEnd)){
//            DateUtil.getCriteriaByDateRange(ca, "UPDATE_DATE", DateUtil.parseSimpleDate(updateDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(updateDateEnd, "yyyy/MM/dd"));
//        }
//        if(flg){
//            if(ObjectUtil.isNotEmpty(organCode)){
//                ca.add("ORG_CODE", organCode);
//            }else{
//                ca.add("ORG_CODE", OP.IN, orgCodes);
//            }
//        } else {
//            // 建档机构
//            if (StringUtils.isNotEmpty(organCode))
//                ca.add("ORG_CODE", organCode);
//        }
//        if(StringUtil.isNotEmpty(createDate)||StringUtil.isNotEmpty(createDateEnd)){
//        	//DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
//            DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
//        }
//        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
        PageList<WomenChildHealth> pageList = womenChildHealthDao.queryPageList(page, flg, orgCodes, paramMap, new Order("update_date desc nulls last,CREATE_DATE desc"), 1);
        return pageList;

    }

    @Override
    public PageList<WomenChildHealthNew> getChildHealthNewList(Boolean flg,
                                                               List<String> orgCodes, Map<String, String> paramMap, Page page) {
        PageList<WomenChildHealthNew> pageList = womenChildHealthDao.selectPageList(page, flg, orgCodes, paramMap, new Order("update_date desc nulls last,CREATE_DATE desc"), 1);
        return pageList;
    }

    @Override
    public WomenChildHealth getWomenChildHealthNew(Criteria criteria) {
        WomenChildHealth pageList = womenChildHealthDao.get(criteria);
        return pageList;
    }


    @Override
    public PageList<WomenChildHealth> getWomenHealthList(Boolean flg, List<String> orgCodes,
                                                         Map<String, String> paramMap, Page page) {
//		String name = paramMap.get("name");
//        String gender = paramMap.get("gender");
//        String updateDate = paramMap.get("updateDate");
//        String updateDateEnd = paramMap.get("updateDateEnd");
//        String organCode = paramMap.get("organCode");
//        String createDate = paramMap.get("createDate");
//        String createDateEnd = paramMap.get("createDateEnd");
//        String idCard=paramMap.get("idCard");
//        Criteria ca = new Criteria();
//        ca.add("is_delete",0);
//        ca.add("IDENTITY_TYPE",2);
//        if(StringUtil.isNotEmpty(name)){
//            ca.add("NAME", name);
//        }
//        if(StringUtil.isNotEmpty(gender)){
//            ca.add("GENDER", gender);
//        }if(StringUtil.isNotEmpty(idCard)){
//            ca.add("ID_CARD", idCard);
//        }
//        /*if(StringUtil.isNotEmpty(organCode)){
//            ca.add("CREATE_ORGAN_CODE", organCode);
//        }*/
//        if(StringUtil.isNotEmpty(updateDate)||StringUtil.isNotEmpty(updateDateEnd)){
//            DateUtil.getCriteriaByDateRange(ca, "UPDATE_DATE", DateUtil.parseSimpleDate(updateDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(updateDateEnd, "yyyy/MM/dd"));
//        }
//        if(flg){
//            if(ObjectUtil.isNotEmpty(organCode)){
//                ca.add("ORG_CODE", organCode);
//            }else{
//                ca.add("ORG_CODE", OP.IN, orgCodes);
//            }
//        } else {
//            // 建档机构
//            if (StringUtils.isNotEmpty(organCode))
//                ca.add("ORG_CODE", organCode);
//        }
//        if(StringUtil.isNotEmpty(createDate)||StringUtil.isNotEmpty(createDateEnd)){
//        	//DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
//            DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
//        }
//        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
        PageList<WomenChildHealth> pageList = womenChildHealthDao.queryPageList(page, flg, orgCodes, paramMap, new Order("update_date desc nulls last,CREATE_DATE desc"), 2);
        return pageList;
    }


    @Override
    public List<WomenChildHealth> getWomenHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDate = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard = paramMap.get("idCard");
        Criteria ca = new Criteria();
        ca.add("is_delete", 0);
        ca.add("IDENTITY_TYPE", 2);
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("GENDER", gender);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        /*if(StringUtil.isNotEmpty(organCode)){
            ca.add("CREATE_ORGAN_CODE", organCode);
        }*/
        if (StringUtil.isNotEmpty(updateDate)) {
            DateUtil.getCriteriaByDateRange(ca, "UPDATE_DATE", DateUtil.parseSimpleDate(updateDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(updateDateEnd, "yyyy/MM/dd"));
        }
        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("ORG_CODE", organCode);
            } else {
                ca.add("ORG_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode))
                ca.add("ORG_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(createDate)) {
            //DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
            DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
//        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
        List<WomenChildHealth> pageList = womenChildHealthDao.getList(ca, new Order("update_date desc nulls last,CREATE_DATE desc"));
        return pageList;
    }

    private Criteria getCriteria(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, int type) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDate = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard = paramMap.get("idCard");
        Criteria ca = new Criteria();
        ca.add("is_delete", 0);
        ca.add("IDENTITY_TYPE", type);
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("GENDER", gender);
        }
        if (StringUtil.isNotEmpty(updateDate) || StringUtil.isNotEmpty(updateDateEnd)) {
            DateUtil.getCriteriaByDateRange(ca, "UPDATE_DATE", DateUtil.parseSimpleDate(updateDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(updateDateEnd, "yyyy/MM/dd"));
        }
        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("ORG_CODE", organCode);
            } else {
                ca.add("ORG_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode))
                ca.add("ORG_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(createDate) || StringUtil.isNotEmpty(createDateEnd)) {
            DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
        return ca;
    }

    @Override
    public List<WomenChildHealth> getChildHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap) {
        String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDate = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard = paramMap.get("idCard");
        Criteria ca = new Criteria();
        ca.add("is_delete", 0);
        ca.add("IDENTITY_TYPE", 1);
        if (StringUtil.isNotEmpty(name)) {
            ca.add("NAME", name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            ca.add("ID_CARD", idCard);
        }
        if (StringUtil.isNotEmpty(gender)) {
            ca.add("GENDER", gender);
        }
        /*if(StringUtil.isNotEmpty(organCode)){
            ca.add("CREATE_ORGAN_CODE", organCode);
        }*/
        if (StringUtil.isNotEmpty(updateDate) || StringUtil.isNotEmpty(updateDateEnd)) {
            DateUtil.getCriteriaByDateRange(ca, "UPDATE_DATE", DateUtil.parseSimpleDate(updateDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(updateDateEnd, "yyyy/MM/dd"));
        }
        if (flg) {
            if (ObjectUtil.isNotEmpty(organCode)) {
                ca.add("ORG_CODE", organCode);
            } else {
                ca.add("ORG_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode))
                ca.add("ORG_CODE", organCode);
        }
        if (StringUtil.isNotEmpty(createDate) || StringUtil.isNotEmpty(createDateEnd)) {
            //DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
            DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
//        PageList<NeonatalFamilyVisit> pageList = neonatalFamilyVisitDao.getPageList(page, ca, new Order("VISIT_DATE DESC, ID", false));
        List<WomenChildHealth> pageList = womenChildHealthDao.getList(ca, new Order("update_date desc nulls last,CREATE_DATE desc"), null);
        return pageList;
    }

    @Override
    public List<Map<String, Object>> exportPersonRecordList(Page page, Boolean flg, List<String> orgCodes, Map<String, String> paramMap, int type) {
        //Criteria ca = getCriteria(flg, orgCodes, paramMap, type);
        PageList<Map<String, Object>> mapList = personInfoDao.getPersonInfoListMap(page, flg, orgCodes, paramMap, type);

        if (null == mapList.getList()) {
            return Collections.emptyList();
        }
        return mapList.getList();
    }

    //档案迁移,孕产妇健康管理基本信息,产后访视，产后42天记录,儿童健康管理基本信息,新生儿家庭访视
    @Override
    @Transactional
    public void personRecordMove(Long personId, String smpiId,Organization oldOrg, Organization newOrg) {
        Criteria criteria = new Criteria("personId", personId);
        Parameters parameters = new Parameters();
        Parameters parameters1 = new Parameters();
        parameters1.add("createOrganCode", newOrg.getOrganCode());
        parameters.add("orgCode", newOrg.getOrganCode());
        womenChildHealthDao.update(parameters, criteria);
        postnatalFollowupDao.update(parameters1, criteria);
        postpartumDaysHealthInfoDao.update(parameters1, criteria);
        womenChildHealthDao.updatePersonRecordMove(parameters,criteria);
        neonatalFamilyVisitDao.update(parameters1, criteria);
    }
}