package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.child.IWomenChildHealthDao;
import com.founder.rhip.ehr.repository.control.IDeathMedicineCertificateDao;
import com.founder.rhip.ehr.repository.women.*;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service("ycfMergerOrgService")//孕产妇管理/儿童健康管理模块 机构合并,数据迁移(孕产妇健康管理基本信息,产后访视，产后42天记录,儿童健康管理基本信息,新生儿家庭访视,分娩信息记录)
public class YcfMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener, IMergerTownListener {

    @Resource(name = "womenChildHealthDao")
    private IWomenChildHealthDao womenChildHealthDao;

    @Resource(name = "whPostnatalFollowupDao")
    private IPostnatalFollowupDao postnatalFollowupDao;  //产后访视

    @Resource(name = "postpartumDaysHealthInfoDao")
    private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;  //产后42天健康检查信息表

    @Resource(name = "neonatalFamilyVisitDao")
    private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表

    @Resource(name = "deliveryRecordInfoDao")
    private IDeliveryRecordInfoDao deliveryRecordInfoDao;  //分娩记录信息表

    @Resource(name = "prenatalFollowupDao")
    private IPrenatalFollowupDao prenatalFollowupDao;  //产前随访服务信息表

    @Resource(name = "prenatalFollowupOtherDao")
    private IPrenatalFollowupOtherDao prenatalFollowupOtherDao;

    @Resource(name = "childHealthExaminationDao")
    private IChildHealthExaminationDao childHealthExaminationDao;  //儿童健康体检表

    @Resource(name = "deathMedicineCertificateDao")
    private IDeathMedicineCertificateDao deathMedicineCertificateDao;//儿童死亡报告卡

    @Autowired
    private IOrganizationApp organizationApp;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     *
     * @param station     合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList) {
        List<String> stationCodes = new ArrayList<>();
        List<String> stationNames = new ArrayList<>();
        for (Organization org : stationList) {
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
            stationNames.add(org.getOrganName());
        }
        //更新数据
        updateYcfInfo(station,stationCodes);

    }

    /**
     * 中心合并
     *
     * @param center     合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList) {
        List<String> centerCodes = new ArrayList<>();
        List<String> centerNames = new ArrayList<>();
        for (Organization org : centerList) {
            String centerCode = org.getOrganCode();
            centerCodes.add(centerCode);
            centerNames.add(org.getOrganName());
        }
        //更新数据
        updateYcfInfo(center,centerCodes);
    }

    /**
     * 站转移
     *
     * @param center      转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList) {
        List<String> stationCodes = new ArrayList<>();
        for (Organization org : stationList) {
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        updateYcfInfo(center,stationCodes);
    }

    @Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        Organization organization = organizationApp.queryOrgan(orgCode);
        Assert.notNull(orgCode, "YcfMergerOrgListenerImpl-changeRelationOrgVillage目标机构在系统中不存在");
        Assert.notEmpty(newAddVillageCodes, "YcfMergerOrgListenerImpl-changeRelationOrgVillage需要迁移的村编码为空");
        List<String> personIds = new ArrayList<>();
        for(String villageCode : newAddVillageCodes){
            List<PersonInfo> personInfoList = personInfoDao.getList(new Criteria("pastreet",villageCode),"id");
            if(ObjectUtil.isNotEmpty(personInfoList)){
                for(PersonInfo personInfo:personInfoList){
                    if(ObjectUtil.isNotEmpty(personInfo.getId())){
                        personIds.add(String.valueOf(personInfo.getId()));
                    }
                }
            }
        }
        if(personIds.size()>0){
            updateYcfInfoByPersonId(organization,personIds);
        }
    }

    private void updateYcfInfoByPersonId(Organization organization,List<String> personIds) {
        Criteria criteria = new Criteria("personId", OP.IN, personIds);
        Parameters parameters = new Parameters();
        Parameters parameters1 = new Parameters();
        Parameters parameters2 = new Parameters();
        parameters2.add("fillOrganCode", organization.getOrganCode());
        parameters2.add("fillOrganName", organization.getOrganName());
        parameters1.add("createOrganCode",  organization.getOrganCode());
        parameters1.add("createOrganName",  organization.getOrganName());
        parameters.add("orgCode",  organization.getOrganCode());
        parameters.add("orgName",  organization.getOrganName());
        womenChildHealthDao.update(parameters, criteria);//孕产妇健康管理基本信息
        postnatalFollowupDao.update(parameters1, criteria);//产后访视
        postpartumDaysHealthInfoDao.update(parameters1, criteria);//产后42天记录
        womenChildHealthDao.updatePersonRecordMove(parameters,criteria);//儿童健康管理基本信息
        neonatalFamilyVisitDao.update(parameters1, criteria);//新生儿家庭访视
        deliveryRecordInfoDao.update(parameters1, criteria);//分娩信息记录
        prenatalFollowupDao.update(parameters1, criteria);//第1次产前随访服务记录
        prenatalFollowupOtherDao.update(new Parameters("createOrganCode",  organization.getOrganCode()).add("createSuperOrganCode",organization.getParentCode()), criteria);//第2-5次产前随访服务记录
        childHealthExaminationDao.update(parameters1, criteria);//1-8月龄儿童检查记录表
//        deathMedicineCertificateDao.update(parameters2, criteria);//儿童死亡报卡 死亡报卡不需要迁移
    }

    private void updateYcfInfo(Organization organization,List<String> organizationList) {
        Criteria criteria = new Criteria("CREATE_ORGAN_CODE", OP.IN, organizationList);
        Criteria criteria1 = new Criteria("ORG_CODE", OP.IN, organizationList);
        Criteria criteria2 = new Criteria("FILL_ORGAN_CODE", OP.IN, organizationList);
        Parameters parameters = new Parameters();
        Parameters parameters1 = new Parameters();
        Parameters parameters2 = new Parameters();
        parameters2.add("fillOrganCode", organization.getOrganCode());
        parameters2.add("fillOrganName", organization.getOrganName());
        parameters1.add("createOrganCode",  organization.getOrganCode());
        parameters1.add("createOrganName",  organization.getOrganName());
        parameters.add("orgCode",  organization.getOrganCode());
        womenChildHealthDao.update(parameters, criteria1);//孕产妇健康管理基本信息
        postnatalFollowupDao.update(parameters1, criteria);//产后访视
        postpartumDaysHealthInfoDao.update(parameters1, criteria);//产后42天记录
        womenChildHealthDao.updatePersonRecordMove(parameters,criteria1);//儿童健康管理基本信息
        neonatalFamilyVisitDao.update(parameters1, criteria);//新生儿家庭访视
        deliveryRecordInfoDao.update(parameters1, criteria);//分娩信息记录
        prenatalFollowupDao.update(parameters1, criteria);//第1次产前随访服务记录
        prenatalFollowupOtherDao.update(new Parameters("createOrganCode",  organization.getOrganCode()).add("createSuperOrganCode",organization.getParentCode()), criteria);//第2-5次产前随访服务记录
        childHealthExaminationDao.update(parameters1, criteria);//1-8月龄儿童检查记录表
        deathMedicineCertificateDao.update(parameters2, criteria2);//儿童死亡报卡
    }

    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {

    }

    @Override
    public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
        Assert.notNull(townCode, "目标镇编码为空");
        Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
        // 更新现地址 镇
        Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
        Parameters parameters = new Parameters("patownShip", townCode);
        deathMedicineCertificateDao.update(new Parameters("pacounty", townCode), new Criteria("patownShip", OP.IN, newAddVillageCodes));
        childHealthExaminationDao.update(parameters, criteria);
        neonatalFamilyVisitDao.update(parameters, criteria);
    }
}
