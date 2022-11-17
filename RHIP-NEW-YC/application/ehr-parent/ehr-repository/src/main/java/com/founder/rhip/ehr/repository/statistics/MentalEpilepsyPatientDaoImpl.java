package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.MentalEpilepsyPatient;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/18.
 */
@Repository("mentalEpilepsyPatientDao")
public class MentalEpilepsyPatientDaoImpl extends AbstractDao<MentalEpilepsyPatient, Long> implements IMentalEpilepsyPatientDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    //获取中心和站 或站
    public List<Map<String, Object>> getCenterAndStation(Criteria criteria) {
        String organCode = (String) criteria.get("ORGAN_CODE");
        String centerCode = (String) criteria.get("CENTER_CODE");
        int quarter = criteria.get("quarter")==null?0:(Integer) criteria.get("quarter");
        int year = (Integer) criteria.get("year");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT org.ORGAN_NAME organName,org.ORGAN_CODE organCode,nvl(mep.MENTAL_NUM,0) mentalNum," +
                " nvl(mep.STABLE_DISEASE_NUM,0) stableDiseaseNum,nvl(mep.EPILEPSY_NUM,0) epilepsyNum, " +
                " nvl(mep.MENTAL_MANAGE_NUM,0) mentalManageNum,nvl(mep.EPILEPSY_CONTROL_NUM,0) epilepsyControlNum " +
                " FROM mdm_organization org LEFT JOIN SR_MENTAL_EPILEPSY_PATIENT mep ON " +
                " org.ORGAN_CODE = mep.ORGAN_CODE ");
        if(quarter!=0){
        	stringBuilder.append(" and mep.QUARTER =" + quarter);
        }
        stringBuilder.append(" and mep.YEAR = "+year+" where ");
        
        /*站角色*/
        if (criteria.contains("ORGAN_CODE")) {
            stringBuilder.append("org.ORGAN_CODE = '" + organCode + "' ");
            /*stringBuilder.append("and mep.QUARTER ="+quarter+" ");*/
        }
        /*中心角色*/
        if (criteria.contains("CENTER_CODE")) {
            if (ObjectUtil.isNullOrEmpty(criteria.get("SEARCHSTATION"))) {
                stringBuilder.append("org.CENTER_CODE = '" + centerCode + "' or " +
                        " org.ORGAN_CODE = '" + centerCode + "'");
            } else {
                stringBuilder.append("org.ORGAN_CODE = '" + (String) criteria.get("SEARCHSTATION") + "'");
            }
        }
        stringBuilder.append(" ORDER BY org.ORGAN_TYPE ,org.ORGAN_NAME");
        return getMapList(stringBuilder.toString(), criteria);
    }

    //统计中心机构及下属站总和--季度
    public Map<String, Object> countCenterAndStation(String organCode, int year, int quarter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select nvl(sum(MENTAL_NUM),0) mentalNum," +
                " nvl(sum(STABLE_DISEASE_NUM),0) stableDiseaseNum," +
                " nvl(sum(EPILEPSY_CONTROL_NUM),0) epilepsyControlNum," +
                " nvl(sum(MENTAL_MANAGE_NUM),0) mentalManageNum," +
                " nvl(sum(EPILEPSY_NUM),0) epilepsyNum FROM SR_MENTAL_EPILEPSY_PATIENT where ");
        stringBuilder.append("(YEAR = "+year+" and QUARTER= " + quarter + " and PARENT_CODE = '" + organCode + "') or (YEAR = "+year+" and QUARTER= " + quarter + " and ORGAN_CODE = '" + organCode + "')");
        return getMap(stringBuilder.toString(), new Criteria());
    }

    //统计中心机构及下属站总和--年度
    public Map<String, Object> countCenterAndStationYear(String organCode,int year) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select nvl(sum(MENTAL_NUM),0) mentalNum," +
                " nvl(sum(STABLE_DISEASE_NUM),0) stableDiseaseNum," +
                " nvl(sum(EPILEPSY_CONTROL_NUM),0) epilepsyControlNum," +
                " nvl(sum(MENTAL_MANAGE_NUM),0) mentalManageNum," +
                " nvl(sum(EPILEPSY_NUM),0) epilepsyNum FROM SR_MENTAL_EPILEPSY_PATIENT where ");
        stringBuilder.append("(YEAR = "+year+" and PARENT_CODE = '" + organCode + "') or (YEAR = "+year+" and ORGAN_CODE = '" + organCode + "')");
        return getMap(stringBuilder.toString(), new Criteria());
    }

    //统计每个中心或站的年度累计
    public MentalEpilepsyPatient countCenterOrStation(String organCode, int year, int quarter) {
        Map<String, Object> map = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select nvl(sum(MENTAL_NUM),0) mentalNum," +
                " nvl(sum(STABLE_DISEASE_NUM),0) stableDiseaseNum," +
                " nvl(sum(EPILEPSY_CONTROL_NUM),0) epilepsyControlNum," +
                " nvl(sum(MENTAL_MANAGE_NUM),0) mentalManageNum," +
                " nvl(sum(EPILEPSY_NUM),0) epilepsyNum FROM SR_MENTAL_EPILEPSY_PATIENT where ");
        stringBuilder.append("ORGAN_CODE = '" + organCode + "' and YEAR = " + year + "");
        if (quarter != 0){
            stringBuilder.append(" and quarter = " + quarter);
        }
        map = getMap(stringBuilder.toString(), new Criteria());
        MentalEpilepsyPatient mentalEpilepsyPatient = new MentalEpilepsyPatient();
        try {
            BeanUtils.populate(mentalEpilepsyPatient, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mentalEpilepsyPatient;
    }

    public MentalEpilepsyPatient countCenterOrStation(String organCode, int year) {

        return countCenterOrStation(organCode, year, 0);
    }

    //统计所有的
    public Map<String, Object> countAll(String countType, String gbCode, int year, int quarter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select nvl(sum(MENTAL_NUM),0) mentalNum," +
                " nvl(sum(STABLE_DISEASE_NUM),0) stableDiseaseNum," +
                " nvl(sum(EPILEPSY_CONTROL_NUM),0) epilepsyControlNum," +
                " nvl(sum(MENTAL_MANAGE_NUM),0) mentalManageNum," +
                " nvl(sum(EPILEPSY_NUM),0) epilepsyNum FROM SR_MENTAL_EPILEPSY_PATIENT where ");
        if (StringUtil.isNotEmpty(gbCode)) {
            stringBuilder.append("GB_CODE = '" + gbCode + "' and ");
        }
        if(countType.equals("1")){
            stringBuilder.append("YEAR = " + year + "");
        }else if (countType.equals("2")){
            stringBuilder.append("YEAR = " + year + " and ");
            stringBuilder.append("QUARTER = " + quarter + "");
        }
        return getMap(stringBuilder.toString(), new Criteria());
    }
}
