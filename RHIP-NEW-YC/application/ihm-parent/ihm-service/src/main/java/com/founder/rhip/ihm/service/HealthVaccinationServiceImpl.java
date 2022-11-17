package com.founder.rhip.ihm.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Column;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.dto.VaccinationService;
import com.founder.rhip.ehr.repository.statistics.IHealthEducationActiveStatisticsDao;
import com.founder.rhip.ehr.repository.statistics.IHealthVaccinationDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

@Service("healthVaccinationService")
public class HealthVaccinationServiceImpl extends AbstractService implements IhealthVaccinationService {
    private static final String ORGCODE = "orgCode";
    private static final String CENTERORGCODE = "centerOrgCode";
    private static final String GBCODE = "gbcode";

    @Resource(name = "healthVaccinationDao")
    private IHealthVaccinationDao healthVaccinationDao;
    @Autowired
    private IOrganizationApp organizationApp;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Override
    public List<VaccinationService> VaccinationServiceList(Criteria criteria) {
        // TODO Auto-generated method stub
        /*return healthVaccinationDao.getList(criteria);*/

        List<VaccinationService> vaccinationServiceReports = new ArrayList<>();

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                VaccinationService vaccinationService = new VaccinationService();
                vaccinationService = healthVaccinationDao.getVaccinationService(criteria);
                vaccinationService.setOrgCode(criteria.get(ORGCODE).toString());
                vaccinationServiceReports.add(vaccinationService);


            } else {
                if (criteria.contains("qwgzxCode")) {
                    criteria.remove("qwgzxCode");
                }
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                VaccinationService vaccinationService = healthVaccinationDao.get(criteria);
                if (vaccinationService == null) {
                    vaccinationService = new VaccinationService();
                    vaccinationService.setOrgCode(criteria.get(ORGCODE).toString());
                }
                vaccinationServiceReports.add(vaccinationService);
            }


        } else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE) && !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
            //获取卫生服务中心
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            VaccinationService vaccinationService = new VaccinationService();
            String organCode = criteria.get(CENTERORGCODE).toString();
            criteria.add(ORGCODE, organCode);
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                vaccinationService = healthVaccinationDao.getVaccinationService(criteria);
            } else {
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                vaccinationService = healthVaccinationDao.get(criteria);
            }


            if (vaccinationService == null) {
                vaccinationService = new VaccinationService();

            }
            vaccinationService.setOrgCode(organCode);
            vaccinationServiceReports.add(vaccinationService);
            criteria.remove(ORGCODE);
            // 获取卫生服务中心下属服务站
            List<Organization> stations = getStation(organCode);
            for (Organization organization : stations) {
                criteria.add(ORGCODE, organization.getOrganCode());
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    vaccinationService = healthVaccinationDao.getVaccinationService(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    vaccinationService = healthVaccinationDao.get(criteria);
                }
                if (vaccinationService == null) {
                    vaccinationService = new VaccinationService();
                }
                vaccinationService.setOrgCode(organization.getOrganCode());
                vaccinationServiceReports.add(vaccinationService);
                criteria.remove(ORGCODE);
            }
        } else if (criteria.contains(GBCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                VaccinationService vaccinationService = new VaccinationService();
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    vaccinationService = healthVaccinationDao.getVaccinationService(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    vaccinationService = healthVaccinationDao.get(criteria);
                }


                if (vaccinationService == null) {
                    vaccinationService = new VaccinationService();

                }
                vaccinationService.setOrgCode(organCode);
                vaccinationServiceReports.add(vaccinationService);
                criteria.remove(ORGCODE);
                // 获取卫生服务中心下属服务站
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                    if (criteria.contains("month") == false && criteria.contains("year") == true) {
                        vaccinationService = healthVaccinationDao.getVaccinationService(criteria);
                    } else {
                        if (criteria.contains("gbcode")) {
                            String gbCode = (String) criteria.get("gbcode");
                            criteria.remove("gbcode");
                            criteria.add("gbCode", gbCode);
                        }
                        vaccinationService = healthVaccinationDao.get(criteria);
                    }
                    if (vaccinationService == null) {
                        vaccinationService = new VaccinationService();
                    }
                    vaccinationService.setOrgCode(organization.getOrganCode());
                    vaccinationServiceReports.add(vaccinationService);
                    criteria.remove(ORGCODE);
                }
            } else {
                for (Organization organization : centres) {

                    List<String> organCodeList = new ArrayList<>();
                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }
                    VaccinationService vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
                    vaccinationService.setCenterOrgCode(organization.getOrganCode());
                    vaccinationService.setOrgCode(organization.getOrganCode());
                    vaccinationServiceReports.add(vaccinationService);
                    //criteria.remove(CENTERORGCODE);
                }
            }


        } else {
            if (criteria.contains("qwgzxCode")) {
                criteria.add(GBCODE, criteria.get("qwgzxCode"));
                criteria.remove("qwgzxCode");
                List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));

                for (Organization organization : centres) {
                    List<String> organCodeList = new ArrayList<>();

                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }
                    VaccinationService vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
                    vaccinationService.setCenterOrgCode(organization.getOrganCode());
                    vaccinationService.setOrgCode(organization.getOrganCode());
                    vaccinationServiceReports.add(vaccinationService);

                }
                criteria.remove(GBCODE);
            } else {
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
                List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
                for (DicItem dicItem : dicItems) {
                    criteria.add(GBCODE, dicItem.getItemCode());
                    List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));

                    for (Organization organization : centres) {
                        List<String> organCodeList = new ArrayList<>();

                        organCodeList.add(organization.getOrganCode());
                        List<Organization> stations = getStation(organization.getOrganCode());
                        for (Organization organization1 : stations) {
                            organCodeList.add(organization1.getOrganCode());
                        }
                        VaccinationService vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
                        vaccinationService.setCenterOrgCode(organization.getOrganCode());
                        vaccinationService.setOrgCode(organization.getOrganCode());
                        vaccinationServiceReports.add(vaccinationService);

                    }
                    criteria.remove(GBCODE);
                }
            }


        }
        for (VaccinationService va : vaccinationServiceReports) {
            va.setGbCode(organizationApp.queryOrgan(va.getOrgCode()).getGbCode());
        }
        return vaccinationServiceReports;

    }

    private List<Organization> getStation(String supOrganCode) {
        List<Organization> stations = new ArrayList<Organization>();

        stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
        return stations;
    }

    @Override
    public VaccinationService VaccinationServiceListSum(Criteria criteria) {
        // TODO Auto-generated method stub

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        List<String> organCodeList = new ArrayList<>();
        VaccinationService vaccinationService = new VaccinationService();
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            organCodeList.add((String) criteria.get(ORGCODE));
            vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
        } else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE) && !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
            //获取卫生服务中心
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            String organCode = criteria.get(CENTERORGCODE).toString();
            criteria.add(ORGCODE, organCode);
            organCodeList.add(organCode);
            // 获取卫生服务中心下属服务站
            List<Organization> stations = getStation(organCode);
            for (Organization organization : stations) {
                organCodeList.add(organization.getOrganCode());
                criteria.remove(ORGCODE);
                vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
            }
        } else if (criteria.contains(GBCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                }
                vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
            } else {
                for (Organization organization : centres) {
                    // 获取卫生服务中心下属服务站
                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }

                }
                vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
            }


        } else {
            if (criteria.contains("qwgzxCode")) {
                criteria.add(GBCODE, criteria.get("qwgzxCode"));
                criteria.remove("qwgzxCode");
                List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
                for (Organization organization : centres) {
                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }
                }


                criteria.remove(GBCODE);
            } else {
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
                List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
                for (DicItem dicItem : dicItems) {
                    List<Organization> centres = getCentre(String.valueOf(dicItem.getItemCode()));

                    for (Organization organization : centres) {


                        organCodeList.add(organization.getOrganCode());
                        List<Organization> stations = getStation(organization.getOrganCode());
                        for (Organization organization1 : stations) {
                            organCodeList.add(organization1.getOrganCode());
                        }
                    }

                }
            }


            vaccinationService = healthVaccinationDao.getVaccinationServiceSum(criteria, organCodeList);
        }

        return vaccinationService;
    }

    /**
     * 获取镇下面所有服务服务中心
     *
     * @param gbCode 镇的编码
     * @return
     */
    private List<Organization> getCentre(String gbCode) {
        Criteria criteria = new Criteria();
        if (gbCode.equals("_hospital")) {
            criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
        } else if (gbCode.equals("_other")) {
            criteria.add("GENRE_CODE", OrgGenreCode.OTHER.getValue());
        } else if (gbCode.equals(EHRConstants._INFIRMARY)) {
            criteria.add("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
        } else if (gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
            criteria.add("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
        } else {
            criteria = new Criteria("GB_CODE", gbCode);
            criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
        }

        List<Organization> centres = organizationApp.queryOrganization(criteria);
        return centres;
    }

    private <T> String Convert2String(List<T> list, String fieldName) {
        StringBuilder strB = new StringBuilder();
        if (!CollectionUtils.isEmpty(list)) {
            Method method;
            try {
                method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        strB.append("'" + method.invoke(list.get(i)) + "'");
                    } else {
                        strB.append(",").append("'" + method.invoke(list.get(i)) + "'");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strB.toString();
    }

    @Override
    public int updateVaccination(VaccinationService vaccinationService) {
        // TODO Auto-generated method stub

        String[] properties = {"certificateShouldNum", "certificateHasNum", "suspectedCertificateNum",
                "hepatitisShouldNum", "hepatitisHasNum", "bcgShouldNum",
                "bcgHasNum", "polioShouldNum",
                "polioHasNum", "dptShouldNum",
                "dptHasNum", "whiteVaccineShouldNum",
                "whiteVaccineHasNum", "leprosyShouldNum",
                "leprosyHasNum", "measlesShouldNum",
                "measlesHasNum", "ameningococcalShouldNum", "ameningococcalHasNum"
                , "acmeningococcalShouldNum", "acmeningococcalHasNum", "encephalitisShouldNum",
                "encephalitisHasNum", "havShouldNum", "havHasNum", "updateReportingTime", "measlesconstitShouldNum", "measlesconstitHasNum"};
        return healthVaccinationDao.update(vaccinationService, properties);
    }

    @Override
    public int addVaccination(VaccinationService vaccinationService) {
        // TODO Auto-generated method stub
        return healthVaccinationDao.insert(vaccinationService);
    }

    public int getAll(Criteria criteria) {
        return healthVaccinationDao.getAllNum(criteria);
    }

    ;
}
