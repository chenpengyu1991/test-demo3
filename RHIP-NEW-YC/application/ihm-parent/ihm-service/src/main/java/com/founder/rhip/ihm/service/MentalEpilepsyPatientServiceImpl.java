package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.MentalEpilepsyPatient;
import com.founder.rhip.ehr.repository.statistics.IMentalEpilepsyPatientDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/18.
 */
@Service("mentalEpilepsyPatientService")
public class MentalEpilepsyPatientServiceImpl extends AbstractService implements IMentalEpilepsyPatientService {

    @Resource(name = "mentalEpilepsyPatientDao")
    private IMentalEpilepsyPatientDao mentalEpilepsyPatientDao;

    @Autowired
    private IOrganizationApp organizationApp;

    @Autowired
    private IOrganizationService organizationService;


    @Override
    public MentalEpilepsyPatient getMentalEpiPatient(Criteria criteria) {
        MentalEpilepsyPatient mentalEpilepsyPatient = mentalEpilepsyPatientDao.get(criteria);
        criteria.remove("quarter");
        criteria.remove("year");
        if (ObjectUtil.isNullOrEmpty(mentalEpilepsyPatient)) {
            mentalEpilepsyPatient = new MentalEpilepsyPatient();
            Organization organization = organizationService.getOrganization(criteria);
            if (ObjectUtil.isNotEmpty(organization)) {
                mentalEpilepsyPatient.setOrganName(organization.getOrganName());
                mentalEpilepsyPatient.setOrganCode(organization.getOrganCode());
                mentalEpilepsyPatient.setGenreCode(organization.getGenreCode());
                mentalEpilepsyPatient.setGbCode(organization.getGbCode());
                mentalEpilepsyPatient.setParentCode(organization.getParentCode());
            }
        }
        return mentalEpilepsyPatient;
    }

    @Override
    public MentalEpilepsyPatient getSingleMental(Criteria criteria) {
        return mentalEpilepsyPatientDao.get(criteria);
    }

    @Override
    public List<MentalEpilepsyPatient> getMentalEpiPaList(Criteria criteria) {
        return mentalEpilepsyPatientDao.getList(criteria);
    }

    //获取中心和站 或 站
    @Override
    public List<MentalEpilepsyPatient> getCenterAndStation(Criteria criteria) {
        int year = (Integer) criteria.get("year");
        int quarter = 0;
        if (ObjectUtil.isNotEmpty(criteria.get("quarter"))){
            quarter = (Integer) criteria.get("quarter") ;
        }

        String countType = (String) criteria.get("countType");
        List<MentalEpilepsyPatient> mentalList = new ArrayList<>();

        if (criteria.contains("CENTER_CODE")) {
            String parentCode = (String) criteria.get("CENTER_CODE");
            String searchStation = (String) criteria.get("SEARCHSTATION");
            List<Organization> organizationList = new ArrayList<>();
            Organization organization = new Organization();
            if (StringUtil.isNullOrEmpty(searchStation)) {
                organization = organizationService.getOrganization(new Criteria("organCode", parentCode));
                organizationList.add(organization);
                organizationList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, parentCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
            } else if (StringUtil.isNotEmpty(searchStation)) {
                organization = organizationService.getOrganization(new Criteria("organCode", searchStation));
                organizationList.add(organization);
            }

            for (Organization organ : organizationList) {
                MentalEpilepsyPatient mentalEpilepsyPatient = null;
                if (countType.equals("1")) {
                    mentalEpilepsyPatient = mentalEpilepsyPatientDao.countCenterOrStation(organ.getOrganCode(), year);
                } else if (countType.equals("2")) {
                    mentalEpilepsyPatient = mentalEpilepsyPatientDao.countCenterOrStation(organ.getOrganCode(), year, quarter);
                }
                mentalEpilepsyPatient.setORGANNAME(organ.getOrganName());
                mentalEpilepsyPatient.setGbCode(organ.getGbCode());
                mentalList.add(mentalEpilepsyPatient);
            }
        }
        if (criteria.contains("ORGAN_CODE")) {
            String orgCode = (String) criteria.get("ORGAN_CODE");
            MentalEpilepsyPatient mentalEpilepsyPatient = null;
            if (countType.equals("1")) {
                mentalEpilepsyPatient = mentalEpilepsyPatientDao.countCenterOrStation(orgCode, year);
            } else if (countType.equals("2")) {
                mentalEpilepsyPatient = mentalEpilepsyPatientDao.countCenterOrStation(orgCode, year, quarter);
            }
            Organization org = organizationService.getOrganization(new Criteria("organCode", orgCode));
            mentalEpilepsyPatient.setORGANNAME(org.getOrganName());
            mentalEpilepsyPatient.setGbCode(org.getGbCode());
            mentalList.add(mentalEpilepsyPatient);
        }
        return mentalList;
    }

    @Override
    public List<MentalEpilepsyPatient> countCenterAndStation(Criteria criteria) {
        //角色为中心-合计
        if (criteria.contains("CENTER_CODE")) {
            if (StringUtil.isNullOrEmpty((String) criteria.get("SEARCHSTATION"))) {
                criteria.add("organCode", criteria.get("CENTER_CODE"));
                criteria.remove("SEARCHSTATION");
                criteria.remove("CENTER_CODE");
            }
        }
        criteria.remove("SEARCHSTATION");
        int year = (Integer) criteria.get("year");
        int quarter = criteria.get("quarter") == null ? 0 : (Integer) criteria.get("quarter");
        String countType = (String) criteria.get("countType");
        criteria.remove("year");
        criteria.remove("quarter");
        criteria.remove("countType");
        List<MentalEpilepsyPatient> mentalEpilepsyPatientList = new ArrayList<>();
        List<Organization> organizationList = organizationService.getOrganizations(criteria);
        Map<String, Object> map = null;
        try {
            for (Organization organization : organizationList) {
                MentalEpilepsyPatient mentalEpilepsyPatient = new MentalEpilepsyPatient();
                //年度统计
                if (countType.equals("1") || quarter == 0) {
                    map = mentalEpilepsyPatientDao.countCenterAndStationYear(organization.getOrganCode(), year);
                }
                //季度统计
                if (countType.equals("2") && quarter != 0) {
                    map = mentalEpilepsyPatientDao.countCenterAndStation(organization.getOrganCode(), year, quarter);
                }
                BeanUtils.populate(mentalEpilepsyPatient, map);
                mentalEpilepsyPatient.setORGANNAME(organization.getOrganName());
                mentalEpilepsyPatient.setGbCode(organization.getGbCode());
                mentalEpilepsyPatientList.add(mentalEpilepsyPatient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //为后续方法
        criteria.add("year", year);
        criteria.add("quarter", quarter);
        criteria.add("countType", countType);

        return mentalEpilepsyPatientList;
    }

    @Override
    public void save(MentalEpilepsyPatient mentalEpilepsyPatient) {
        mentalEpilepsyPatientDao.insert(mentalEpilepsyPatient);
    }

    @Override
    public void update(MentalEpilepsyPatient mentalEpilepsyPatient) {
        mentalEpilepsyPatientDao.update(mentalEpilepsyPatient);
    }

    //统计某个区域的所有
    public MentalEpilepsyPatient countAll(Criteria criteria) {
        int year = (Integer) criteria.get("year");
        int quarter = (Integer) criteria.get("quarter");
        String countType = (String) criteria.get("countType");
        String gbCode = (String) criteria.get("gbCode");
        criteria.remove("year");
        criteria.remove("quarter");
        criteria.remove("countType");
        Map<String, Object> map = null;
        MentalEpilepsyPatient mentalEpilepsyPatient = new MentalEpilepsyPatient();
        /*卫管中心角色*/
        if (criteria.contains("gbCode")) {
            map = mentalEpilepsyPatientDao.countAll(countType, gbCode, year, quarter);
        } else {/*ADMIN角色*/
            gbCode = "";
            map = mentalEpilepsyPatientDao.countAll(countType, gbCode, year, quarter);
        }
        /*map转成java bean*/
        try {
            BeanUtils.populate(mentalEpilepsyPatient, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mentalEpilepsyPatient;
    }
}
