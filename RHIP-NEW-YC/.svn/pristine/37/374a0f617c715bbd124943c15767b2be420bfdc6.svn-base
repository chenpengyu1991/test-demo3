
package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.ChildStatistical;
import com.founder.rhip.ehr.dto.ElderlyStatistical;
import com.founder.rhip.ehr.repository.statistics.IChildStatisticalDao;
import com.founder.rhip.ehr.repository.statistics.IElderlyStatisticalDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("childStatisticalService")
public class ChildStatisticalServiceImpl extends AbstractService implements IchildStatisticalService {
    private static final String ORGCODE = "orgCode";
    private static final String CENTERORGCODE = "centerOrgCode";
    private static final String GBCODE = "gbcode";

    @Resource(name = "childStatisticalDao")
    private IChildStatisticalDao childStatisticalDao;
    @Resource(name = "elderlyStatisticalDao")
    private IElderlyStatisticalDao elderlyStatisticalDao;
    @Autowired
    private IOrganizationApp organizationApp;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Override
    public List<ChildStatistical> childStatisticalServiceList(Criteria criteria) {

        // TODO Auto-generated method stub
        /*return childStatisticalDao.getList(criteria);*/

        List<ChildStatistical> childStatisticalReports = new ArrayList<>();

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                ChildStatistical childStatistical = new ChildStatistical();
                childStatistical = childStatisticalDao.getChildStatistical(criteria);
                if (ObjectUtil.isNullOrEmpty(childStatistical)) {
                    childStatistical = new ChildStatistical();
                    childStatistical.setOrgCode(criteria.get(ORGCODE).toString());
                }

                childStatisticalReports.add(childStatistical);


            } else {
                if (criteria.contains("qwgzxCode")) {
                    criteria.remove("qwgzxCode");
                }
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                ChildStatistical childStatistical = childStatisticalDao.getChildStatistical(criteria);
                if (childStatistical == null) {
                    childStatistical = new ChildStatistical();
                    childStatistical.setOrgCode(criteria.get(ORGCODE).toString());
                }
                childStatisticalReports.add(childStatistical);
            }


        } else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE) && !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
            //获取卫生服务中心
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            ChildStatistical childStatistical = new ChildStatistical();
            String organCode = criteria.get(CENTERORGCODE).toString();
            criteria.add(ORGCODE, organCode);
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                childStatistical = childStatisticalDao.getChildStatistical(criteria);
            } else {
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                childStatistical = childStatisticalDao.getChildStatistical(criteria);
            }


            if (childStatistical == null) {
                childStatistical = new ChildStatistical();

            }
            childStatistical.setOrgCode(organCode);
            childStatisticalReports.add(childStatistical);
            criteria.remove(ORGCODE);
            // 获取卫生服务中心下属服务站
            List<Organization> stations = getStation(organCode);
            for (Organization organization : stations) {
                criteria.add(ORGCODE, organization.getOrganCode());
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    childStatistical = childStatisticalDao.getChildStatistical(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    childStatistical = childStatisticalDao.getChildStatistical(criteria);
                }
                if (childStatistical == null) {
                    childStatistical = new ChildStatistical();
                }
                childStatistical.setOrgCode(organization.getOrganCode());
                childStatisticalReports.add(childStatistical);
                criteria.remove(ORGCODE);
            }
        } else if (criteria.contains(GBCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                ChildStatistical childStatistical = new ChildStatistical();
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    childStatistical = childStatisticalDao.getChildStatistical(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    childStatistical = childStatisticalDao.getChildStatistical(criteria);
                }


                if (childStatistical == null) {
                    childStatistical = new ChildStatistical();

                }
                childStatistical.setOrgCode(organCode);
                childStatisticalReports.add(childStatistical);
                criteria.remove(ORGCODE);
                // 获取卫生服务中心下属服务站
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                    if (criteria.contains("month") == false && criteria.contains("year") == true) {
                        childStatistical = childStatisticalDao.getChildStatistical(criteria);
                    } else {
                        if (criteria.contains("gbcode")) {
                            String gbCode = (String) criteria.get("gbcode");
                            criteria.remove("gbcode");
                            criteria.add("gbCode", gbCode);
                        }
                        childStatistical = childStatisticalDao.getChildStatistical(criteria);
                    }
                    if (childStatistical == null) {
                        childStatistical = new ChildStatistical();
                    }
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);
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
                    ChildStatistical childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
                    childStatistical.setCenterOrgCode(organization.getOrganCode());
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);
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
                    ChildStatistical childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
                    childStatistical.setCenterOrgCode(organization.getOrganCode());
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);

                }
                criteria.remove(GBCODE);
            } else {
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
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
                        ChildStatistical childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
                        childStatistical.setCenterOrgCode(organization.getOrganCode());
                        childStatistical.setOrgCode(organization.getOrganCode());
                        childStatisticalReports.add(childStatistical);

                    }
                    criteria.remove(GBCODE);
                }
            }


        }
        for (ChildStatistical cs : childStatisticalReports) {
            cs.setGbCode(organizationApp.queryOrgan(cs.getOrgCode()).getGbCode());
        }
        return childStatisticalReports;


    }

    @Override
    public ChildStatistical childStatisticalServiceListSum(Criteria criteria) {

        // TODO Auto-generated method stub

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        List<String> organCodeList = new ArrayList<>();
        ChildStatistical childStatistical = new ChildStatistical();
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            organCodeList.add((String) criteria.get(ORGCODE));
            childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
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

            }
            childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
        } else if (criteria.contains(GBCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                organCodeList.add(organCode);
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                    organCodeList.add(organization.getOrganCode());
                }
                childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
            } else {
                for (Organization organization : centres) {
                    // 获取卫生服务中心下属服务站
                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }

                }
                childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
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
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
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


            childStatistical = childStatisticalDao.getChildStatisticalSum(criteria, organCodeList);
        }

        return childStatistical;

    }

    private List<Organization> getStation(String supOrganCode) {
        List<Organization> stations = new ArrayList<Organization>();

        stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
        return stations;
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
    public List<ElderlyStatistical> elderlyStatisticalServiceListSum(Criteria criteria) {


        // TODO Auto-generated method stub

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        List<String> organCodeList = new ArrayList<>();
        List<ElderlyStatistical> childStatistical = new ArrayList<>();
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            organCodeList.add((String) criteria.get(ORGCODE));
            childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
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

            }
            childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
        } else if (criteria.contains(GBCODE)) {
        	//buxuyao
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                organCodeList.add(organCode);
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                    organCodeList.add(organization.getOrganCode());
                }
                childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
            } else {
                for (Organization organization : centres) {
                    // 获取卫生服务中心下属服务站
                    organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
                        organCodeList.add(organization1.getOrganCode());
                    }

                }
                childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum1(criteria, organCodeList);
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
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
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


            childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum1(criteria, organCodeList);
            /*for (ElderlyStatistical cs : childStatistical) {
                cs.setGbCode(organizationApp.queryOrgan(cs.getOrgCode()).getGbCode());
            }*/
        }

        return childStatistical;


    }

    @Override
    public List<ElderlyStatistical> elderlyStatisticalServiceList(Criteria criteria) {/*

        List<ElderlyStatistical> childStatisticalReports = new ArrayList<>();

        // 统计卫生服务站体检进度
        // 统计卫生服务站体检进度
        if (criteria.contains(ORGCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                ElderlyStatistical childStatistical = new ElderlyStatistical();
                childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                if (ObjectUtil.isNullOrEmpty(childStatistical)) {
                    childStatistical = new ElderlyStatistical();
                    childStatistical.setOrgCode(criteria.get(ORGCODE).toString());
                }

                childStatisticalReports.add(childStatistical);


            } else {
                if (criteria.contains("qwgzxCode")) {
                    criteria.remove("qwgzxCode");
                }
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                ElderlyStatistical childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                if (childStatistical == null) {
                    childStatistical = new ElderlyStatistical();
                    childStatistical.setOrgCode(criteria.get(ORGCODE).toString());
                }
                childStatisticalReports.add(childStatistical);
            }


        } else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE) && !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
            //获取卫生服务中心
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            ElderlyStatistical childStatistical = new ElderlyStatistical();
            String organCode = criteria.get(CENTERORGCODE).toString();
            criteria.add(ORGCODE, organCode);
            if (criteria.contains("month") == false && criteria.contains("year") == true) {
                childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
            } else {
                if (criteria.contains("gbcode")) {
                    String gbCode = (String) criteria.get("gbcode");
                    criteria.remove("gbcode");
                    criteria.add("gbCode", gbCode);
                }
                childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
            }


            if (childStatistical == null) {
                childStatistical = new ElderlyStatistical();

            }
            childStatistical.setOrgCode(organCode);
            childStatisticalReports.add(childStatistical);
            criteria.remove(ORGCODE);
            // 获取卫生服务中心下属服务站
            List<Organization> stations = getStation(organCode);
            for (Organization organization : stations) {
                criteria.add(ORGCODE, organization.getOrganCode());
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                }
                if (childStatistical == null) {
                    childStatistical = new ElderlyStatistical();
                }
                childStatistical.setOrgCode(organization.getOrganCode());
                childStatisticalReports.add(childStatistical);
                criteria.remove(ORGCODE);
            }
        } else if (criteria.contains(GBCODE)) {
            if (criteria.contains("qwgzxCode")) {
                criteria.remove("qwgzxCode");
            }
            List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
            if (criteria.contains(CENTERORGCODE)) {
                ElderlyStatistical childStatistical = new ElderlyStatistical();
                String organCode = criteria.get(CENTERORGCODE).toString();
                criteria.add(ORGCODE, organCode);
                if (criteria.contains("month") == false && criteria.contains("year") == true) {
                    childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                } else {
                    if (criteria.contains("gbcode")) {
                        String gbCode = (String) criteria.get("gbcode");
                        criteria.remove("gbcode");
                        criteria.add("gbCode", gbCode);
                    }
                    childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                }


                if (childStatistical == null) {
                    childStatistical = new ElderlyStatistical();

                }
                childStatistical.setOrgCode(organCode);
                childStatisticalReports.add(childStatistical);
                criteria.remove(ORGCODE);
                // 获取卫生服务中心下属服务站
                List<Organization> stations = getStation(organCode);
                for (Organization organization : stations) {
                    criteria.add(ORGCODE, organization.getOrganCode());
                    if (criteria.contains("month") == false && criteria.contains("year") == true) {
                        childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                    } else {
                        if (criteria.contains("gbcode")) {
                            String gbCode = (String) criteria.get("gbcode");
                            criteria.remove("gbcode");
                            criteria.add("gbCode", gbCode);
                        }
                        childStatistical = elderlyStatisticalDao.getElderlyStatistical(criteria);
                    }
                    if (childStatistical == null) {
                        childStatistical = new ElderlyStatistical();
                    }
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);
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
                    ElderlyStatistical childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
                    childStatistical.setCenterOrgCode(organization.getOrganCode());
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);
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
                    ElderlyStatistical childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
                    childStatistical.setCenterOrgCode(organization.getOrganCode());
                    childStatistical.setOrgCode(organization.getOrganCode());
                    childStatisticalReports.add(childStatistical);

                }
                criteria.remove(GBCODE);
            } else {
                Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
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
                        ElderlyStatistical childStatistical = elderlyStatisticalDao.getElderlyStatisticalSum(criteria, organCodeList);
                        childStatistical.setCenterOrgCode(organization.getOrganCode());
                        childStatistical.setOrgCode(organization.getOrganCode());
                        childStatisticalReports.add(childStatistical);

                    }
                    criteria.remove(GBCODE);
                }
            }
        }
        for (ElderlyStatistical cs : childStatisticalReports) {
            cs.setGbCode(organizationApp.queryOrgan(cs.getOrgCode()).getGbCode());
        }
        return childStatisticalReports;
    */
    	return null;
    }

    @Override
    public List<Map<String, Object>> getElderlyManagementSum(Criteria criteria,List<String> orgCodes) {
        List<Map<String, Object>> list = elderlyStatisticalDao.getElderlyManagementSum(criteria,orgCodes);
        List<Map<String, Object>> newList = new ArrayList<>();
        Long jy_reserve = 0l,RESIDENT_NUM = 0l,SAMSUNG_NUM=0l,HEALTH_MANAGEMENT_NUM=0l,TOWSTAR_NUM=0l;
        for(int i=0; i<list.size(); i++) {
            Map<String, Object> map = list.get(i);
            String orgCode = map.get("ORG_CODE").toString();
            if(!"合计".equals(orgCode)) {
                Organization org = organizationApp.queryOrgan(orgCode);
                if(ObjectUtil.isNotEmpty(org)) {
                    map.put("GB_CODE",org.getGbCode());
                    if(!"R11".equals(org.getGenreCode()) && !"J100".equals(org.getGenreCode())) { // 过滤掉县疾病预防控制中心和县卫生和计划生育局
                        map.put("organName",org.getOrganName());
                        Object mapObj = map.get("RESIDENT_NUM");
                        if(mapObj!=null&&Long.valueOf(mapObj.toString()) != 0){
                        	map.put("MANAGEMENT_RATE", new BigDecimal(Long.valueOf(map.get("HEALTH_MANAGEMENT_NUM").toString()) * 100).divide(new BigDecimal(Long.valueOf(map.get("RESIDENT_NUM").toString())), 2, BigDecimal.ROUND_HALF_UP));
                        }else{
                        	map.put("MANAGEMENT_RATE", BigDecimal.valueOf(0.0));
                        }
                        newList.add(map);
                    } else {
                        jy_reserve += Long.valueOf(map.get("JY_RESERVE").toString());
                        RESIDENT_NUM += Long.valueOf(map.get("RESIDENT_NUM").toString());
                        SAMSUNG_NUM += Long.valueOf(map.get("SAMSUNG_NUM").toString());
                        HEALTH_MANAGEMENT_NUM += Long.valueOf(map.get("HEALTH_MANAGEMENT_NUM").toString());
                        TOWSTAR_NUM += Long.valueOf(map.get("TOWSTAR_NUM").toString());
                    }
                }
            } else {
                map.put("organName","合计");
                map.put("JY_RESERVE",map.get("JY_RESERVE")==null?0:Long.valueOf(map.get("JY_RESERVE").toString())-jy_reserve);
                map.put("RESIDENT_NUM",map.get("RESIDENT_NUM")==null?0:Long.valueOf(map.get("RESIDENT_NUM").toString())-RESIDENT_NUM);
                map.put("SAMSUNG_NUM",map.get("SAMSUNG_NUM")==null?0:Long.valueOf(map.get("SAMSUNG_NUM").toString())-SAMSUNG_NUM);
                map.put("HEALTH_MANAGEMENT_NUM",map.get("HEALTH_MANAGEMENT_NUM")==null?0:Long.valueOf(map.get("HEALTH_MANAGEMENT_NUM").toString())-HEALTH_MANAGEMENT_NUM);
                map.put("TOWSTAR_NUM",map.get("TOWSTAR_NUM")==null?0:Long.valueOf(map.get("TOWSTAR_NUM").toString())-TOWSTAR_NUM);
                
                if(Long.valueOf(map.get("RESIDENT_NUM").toString()) != 0){
                	map.put("MANAGEMENT_RATE", new BigDecimal(Long.valueOf(map.get("HEALTH_MANAGEMENT_NUM").toString()) * 100).divide(new BigDecimal(Long.valueOf(map.get("RESIDENT_NUM").toString())), 2, BigDecimal.ROUND_HALF_UP));
                }else{
                	map.put("MANAGEMENT_RATE", BigDecimal.valueOf(0.0));
                }
                
                newList.add(map); // 最后的统计结果也要放到集合内
            }
        }
        return newList;
    }
}
