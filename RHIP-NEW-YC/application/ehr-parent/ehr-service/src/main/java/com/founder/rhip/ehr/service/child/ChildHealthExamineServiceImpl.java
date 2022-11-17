package com.founder.rhip.ehr.service.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jingqiu on 17-3-23.
 */
@Service("childHealthExamineService")
public class ChildHealthExamineServiceImpl implements IChildHealthExamineService,IPersonRecordMoveService {

    @Resource
    private IChildHealthExaminationDao childHealthExaminationDao;

    @Resource
    private IPersonInfoDao personInfoDao;

    @Override
    public PageList<ChildHealthExamination> getPagedChildInfo(Page page, Criteria criteria, String examineAgeGroup) {
        String properties = "";
        if(examineAgeGroup.equals("1")){
            properties = "DISTINCT NAME, GENDER, BIRTHDAY,BABY_CARD_NO, EXAMINE_AGE_GROUP,ID_CARD";
        }else {
            properties = "DISTINCT NAME, GENDER, BIRTHDAY, ID_CARD,BABY_CARD_NO, EXAMINE_AGE_GROUP";
        }
        Order order = new Order("BIRTHDAY", false);
        return childHealthExaminationDao.getPageList(page, criteria, order, properties);
    }

    @Override
    public List<ChildHealthExamination> getChildHealthExamList(Criteria criteria) {
        return childHealthExaminationDao.getList(criteria);
    }

    @Override
    public List<ChildHealthExamination> getChildHealthExamList(Criteria criteria, Order order) {
        return childHealthExaminationDao.getList(criteria, order);
    }

    @Override
    public List<ChildHealthExamination> getChildHealthExamList(String examineAgeGroup, String babyCardNo, String idCard) {
        if (StringUtil.isNullOrEmpty(examineAgeGroup)) {
            return null;
        }
        Criteria criteria = new Criteria();
        if(examineAgeGroup.equals("1") && StringUtil.isNotEmpty(babyCardNo)){
            criteria.add("babyCardNo", babyCardNo)
                .add("examineAgeGroup", examineAgeGroup);
        }else if(!examineAgeGroup.equals("1") && StringUtil.isNotEmpty(idCard)){
            criteria.add("idCard", idCard)
                    .add("examineAgeGroup", examineAgeGroup);
        }
        Criteria deleteCriteria = new Criteria("IS_DELETE", OP.NE, EHRConstants.DELETE_FLG_1);
        deleteCriteria.add(LOP.OR,"IS_DELETE", OP.IS,"NULL");
        criteria.add(deleteCriteria);
        Order order = new Order("VISIT_DATE", false);
        return childHealthExaminationDao.getList(criteria, order);
    }

    @Override
    public ChildHealthExamination getChildHealthExam(Criteria criteria) {
        return childHealthExaminationDao.get(criteria);
    }

    @Override
    @Transactional
    public int addChildHealthExam(ChildHealthExamination examination, Organization organization, User user) {
        examination.setCreateOrganCode(organization.getOrganCode());
        examination.setCreateOrganName(organization.getOrganName());
        examination.setCreateSuperOrganCode(organization.getParentCode());
        examination.setCreateGbCode(organization.getGbCode());
        String babyNo = examination.getBabyCardNo();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(ObjectUtil.isNotEmpty(examination.getBirthday())){
            String birthday=sdf.format(examination.getBirthday());
            ChildHealthExamination childHealthExamination = new ChildHealthExamination();
            if(StringUtil.isNotEmpty(examination.getIdCard())){
                 childHealthExamination = childHealthExaminationDao.get(new Criteria("idCard",examination.getIdCard()));
                if(ObjectUtil.isNotEmpty(childHealthExamination)){
                    childHealthExaminationDao.updateBirthDay(examination.getIdCard(),birthday,babyNo,examination.getPersonId());
                }
            }
            if(StringUtil.isNotEmpty(examination.getBabyCardNo())){
                 childHealthExamination = childHealthExaminationDao.get(new Criteria("babyCardNo",examination.getBabyCardNo()));
                if(ObjectUtil.isNotEmpty(childHealthExamination)){
                    childHealthExaminationDao.updateBirthDay(examination.getIdCard(),birthday,babyNo,examination.getPersonId());
                }
            }
        }

        if (examination.getPersonId() == null) {
            //儿童个人信息未保存
            Long personId = saveChildInfo(examination, organization, user);
            examination.setPersonId(personId);
            return childHealthExaminationDao.insert(examination);
        } else {
            return childHealthExaminationDao.insert(examination);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addChildrenEchExam(ChildHealthExamination childHealthExamination){
      return childHealthExaminationDao.insert(childHealthExamination);
    }

    @Override
    @Transactional
    public int updateChildHealthExam(ChildHealthExamination examination) {
        return childHealthExaminationDao.update(examination);
    }

    @Override
    @Transactional
    public int deleteChildHealthExam(Integer id) {
        ChildHealthExamination examination = childHealthExaminationDao.get(new Criteria("id", id));
        if (examination != null) {
            examination.setIsDelete(EHRConstants.DELETE_FLG_1.shortValue());
            return childHealthExaminationDao.update(examination, "isDelete");
        }
        return 0;
    }

  @Override
  public PageList<ChildHealthExamination> getPageChildExamine(Criteria criteria, Page page,
                                                              Order order) {
    return childHealthExaminationDao.getPageList(page,criteria,order);
  }

  private Long saveChildInfo(ChildHealthExamination examination, Organization organization, User user) {
        PersonInfo childInfo = new PersonInfo();
        childInfo.setName(examination.getName());
        childInfo.setGender(examination.getGender());
        childInfo.setBirthday(examination.getBirthday());
        childInfo.setBabyCardNo(examination.getBabyCardNo());
        childInfo.setPacounty(examination.getPacounty());
        childInfo.setPatownShip(examination.getPatownShip());
        childInfo.setPastreet(examination.getPastreet());
        childInfo.setPahouseNumber(examination.getPahouseNumber());
        childInfo.setPhoneNumber(examination.getTelNumber());
        childInfo.setUpdateDate(new Date());
        childInfo.setUpdateOrganCode(organization.getOrganCode());
        childInfo.setUpdateOrganName(organization.getOrganName());
        childInfo.setUpdateName(user.getName());
        if (StringUtil.isNullOrEmpty(examination.getIdCard())) {
            //无身份证号
            childInfo.setFilingFlag(EHRConstants.NO_IDCARD);
        } else {
            //有身份证号，设为未建档
            childInfo.setIdcard(examination.getIdCard());
            if("4".equals( childInfo.getFilingFlag()) || StringUtil.isNullOrEmpty(childInfo.getFilingFlag())){
            	childInfo.setFilingFlag("0");
            }else{
            	childInfo.setFilingFlag(childInfo.getFilingFlag());
            }
        }
        
        return personInfoDao.generatedKey(childInfo, "ID", null).longValue();
    }

    //档案迁移,1-8月龄儿童检查记录表,儿童中医药健康管理
    @Override
    @Transactional
    public void personRecordMove(Long personId, String smpiId,Organization oldOrg, Organization newOrg) {
        Criteria criteria = new Criteria("personId", personId);
        Parameters parameters1 = new Parameters();
        parameters1.add("createOrganCode", newOrg.getOrganCode());
        childHealthExaminationDao.update(parameters1, criteria);
    }


}
