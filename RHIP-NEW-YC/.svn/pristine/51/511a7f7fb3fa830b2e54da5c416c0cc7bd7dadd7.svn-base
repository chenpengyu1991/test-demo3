package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.basic.RqflAbstractDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ncp.common.NcpConstants;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.entity.NcpPatient;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

@Repository("ncpFollowListDao")
public class FollowListDaoImpl extends RqflAbstractDao<FollowDto,String> implements  IFollowListDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Override
    public PageList<FollowDto> searchFollowList(Page page, Criteria criteria) {
        StringBuilder sql = new StringBuilder();
        String select= "ncp.id,ncp.person_id, ncp.cardno, b.name, b.birthday, b.gender as sex, b.phone_number as tel, ncp.clinical_class, ncp.management_org,ncp.discharge_date,ncp.health_status,ncp.reexamine_status,ncp.zl_type,ncp.patient_type,b.population_category ";
        sql.append("SELECT ").append(select).append("from ncp_patient ncp left join bi_person_info b on b.id = ncp.person_id where 1 = 1 ");
        Object gcfObj = criteria.get("groupClassification");
        if (gcfObj!=null) {
            String dynamicRecord = (String)gcfObj;
            criteria.remove("groupClassification");
            sql = getDynamicRecord(dynamicRecord,sql);
        }
        Object nameObj = criteria.get("name");
        if (nameObj!=null) {//姓名
            String name = (String)nameObj;
            criteria.remove("name");
            sql.append(" and b.name = '"+name+"'");
        }
        Object sexObj = criteria.get("sex");
        if (sexObj!=null) {//性别
            String sex = (String)sexObj;
            criteria.remove("sex");
            sql.append(" and b.gender = '"+sex+"'");
        }
        Object telObj = criteria.get("tel");
        if (telObj!=null) {//性别
            String tel = (String)telObj;
            criteria.remove("tel");
            sql.append(" and b.phone_number = '"+tel+"'");
        }
        Object cytsObj = criteria.get("cyts");//出院天数
        if (cytsObj!=null) {
            String cyts = (String)cytsObj;
            criteria.remove("cyts");
            if(NcpConstants.CYTS_1.equals(cyts))
                sql.append(" and to_date(to_char(sysdate, 'mm/dd/yyyy'), 'mm/dd/yyyy') -to_date(to_char(ncp.discharge_date, 'mm/dd/yyyy'), 'mm/dd/yyyy') < 14 ");
            else if(NcpConstants.CYTS_2.equals(cyts))
                sql.append(" and to_date(to_char(sysdate, 'mm/dd/yyyy'), 'mm/dd/yyyy') -to_date(to_char(ncp.discharge_date, 'mm/dd/yyyy'), 'mm/dd/yyyy') = 14 ");
            else if(NcpConstants.CYTS_3.equals(cyts))
                sql.append(" and to_date(to_char(sysdate, 'mm/dd/yyyy'), 'mm/dd/yyyy') -to_date(to_char(ncp.discharge_date, 'mm/dd/yyyy'), 'mm/dd/yyyy') > 28 ");

        }
        Object sflb = criteria.get("sflb");//随访类别
        Object sfBegin = criteria.get("sfBegin");
        Object sfEnd = criteria.get("sfEnd");
        Object doctor = criteria.get("doctor");
        if(sflb!=null||sfBegin!=null||sfEnd!=null||doctor!=null){
            sql.append(" and exists(select 1 from ncp_monitor m where m.patient_id = ncp.id ");
            if(sflb!=null){
                criteria.remove("sflb");
                sql.append(" and m.type ="+sflb);
            }
            if(sfBegin!=null){
                criteria.remove("sfBegin");
                sql.append(" and m.monitor_date >= to_date('"+ DateUtil.toDateString((Date) sfBegin,"yyyy/MM/dd")+"','yyyy/MM/dd')");
            }
            if(sfEnd!=null){
                criteria.remove("sfEnd");
                sql.append(" and m.monitor_date <= to_date('"+ DateUtil.toDateString((Date) sfEnd,"yyyy/MM/dd")+"','yyyy/MM/dd')");
            }
            if(doctor!=null){
                criteria.remove("doctor");
                sql.append(" and m.doctor_name ='"+doctor+"'");
            }
            sql.append(" )");
        }
        Object jhlb = criteria.get("jhlb");//计划类别
        Object jhrq = criteria.get("jhrq");//计划日期
        if(sflb!=jhlb&&jhrq!=null){
            criteria.remove("jhlb");
            criteria.remove("jhrq");
            sql.append(" and exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id ");
            sql.append(" and p.type ="+jhlb);
            if(NcpConstants.NCP_MONITOR_TYPE_1.equals(jhlb)) {
                sql.append(" and p.plan_date =to_date('" + jhrq + "','yyyy-MM-dd')");
//                sql.append(" and p.plan_date <=to_date('" + jhrq + " 23:59:59','yyyy-MM-dd')");
            }
            else
                sql.append(" and p.plan_date <= to_date('"+jhrq+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
            sql.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id ");
            sql.append(" )");
            sql.append(" )");
        }
        Object stObj = criteria.get("stationOrganCode");//机构站
        Object zxObj = criteria.get("centerOrgCode");//中心
        Object zObj = criteria.get("gbcode");//镇
        criteria.remove("stationOrganCode");
        criteria.remove("centerOrgCode");
        criteria.remove("gbcode");
        if (stObj!=null) {
            sql.append(" and b.input_organ_code ='"+stObj+"' ");
        }else if(zxObj!=null){//中心
            List<String> orglist = getOrgCodeByOrgCode(zxObj.toString());
            String inStr = "";
            for(String code:orglist){
                if(inStr.length()>0)
                    inStr+=",";
                inStr +="'"+code+"'";
            }
            if(StringUtil.isNotEmpty(inStr))
                sql.append(" and b.input_organ_code in ("+stObj+")");
        }else if(zObj!=null){//镇
            List<String>  orglist = getOrgCodeByGBCode(zObj.toString());
            String inStr = "";
            for(String code:orglist){
                if(inStr.length()>0)
                    inStr+=",";
                inStr +="'"+code+"'";
            }
            if(StringUtil.isNotEmpty(inStr))
                sql.append(" and b.input_organ_code in ("+inStr+")");
        }
        ClassMetadata cMetadata = ClassMetadata.getMetadata(FollowDto.class);
        if(!criteria.getCriteria().isEmpty())
            sql.append(" and "+criteria.toSql(cMetadata, ":", "ncp"));
//                .append(" ORDER BY UPDATE_TIME DESC");
        return getPageList(page, sql.toString(), criteria);
    }

    @Override
    public Map<String, Object> searchQuickCnt(Criteria ca) {
        StringBuilder sql1 = new StringBuilder("select count(1) td from ncp_patient ncp where  exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 1");
        sql1.append(" and p.plan_date = to_date('%1$s','yyyy-MM-dd hh24:mi:ss') ");
        sql1.append("and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id)) ");

        StringBuilder sql2 = new StringBuilder("select count(1) sec_week from ncp_patient ncp where exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 2 ");
        sql2.append(" and p.plan_date <= to_date('%1$s','yyyy-MM-dd hh24:mi:ss')");
        sql2.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id)) ");

        StringBuilder sql3 = new StringBuilder("select count(1) follow from ncp_patient ncp where ncp.is_delete = 0 and exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 3 ");
        sql3.append("  and p.plan_date <= to_date('%1$s','yyyy-MM-dd hh24:mi:ss') ");
        sql3.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id)) ");
        /* StringBuilder sql = new StringBuilder("select t.td,t1.sec_week,t2.follow from （select count(1) td from ncp_patient ncp where ncp.is_delete = 0 and ");
        sql.append(" exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 1 and p.plan_date = to_date('%1$s','yyyy-MM-dd') ");
        sql.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id) )) t,");*/
/*
        sql.append(" (select count(1) sec_week from ncp_patient ncp where ncp.is_delete = 0 and exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 2 ");
        sql.append(" and p.plan_date <= to_date('%1$s','yyyy-MM-dd')");
        sql.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id) )) t1, ");

        sql.append(" (select count(1) follow from ncp_patient ncp where ncp.is_delete = 0 and exists(select 1 from ncp_monitor_plan p where p.pid = ncp.id and p.type = 3 ");
        sql.append(" and p.plan_date <= to_date('%1$s','yyyy-MM-dd') ");
        sql.append(" and not exists( select 1 from ncp_monitor mp where mp.plan_id = p.id) )) t2 ");*/
        ClassMetadata cMetadata = ClassMetadata.getMetadata(NcpPatient.class);
        String dd = DateUtil.toDateString(new Date(),DateUtil.getDateFormat());
        String ddWithS = dd+" 23:59:59";
        sql1.append(" and "+ca.toSql(cMetadata, ":", "ncp"));
        sql2.append(" and "+ca.toSql(cMetadata, ":", "ncp"));
        sql3.append(" and "+ca.toSql(cMetadata, ":", "ncp"));
        Long td = this.getSingle(String.format(sql1.toString(), dd), ca, Long.class);
        Long sec_week = this.getSingle(String.format(sql2.toString(), ddWithS), ca, Long.class);
        Long follow = this.getSingle(String.format(sql3.toString(), ddWithS), ca, Long.class);
        Map map = new HashMap();
        map.put("td",td);
        map.put("sec_week",sec_week);
        map.put("follow",follow);
        return map;
    }

    /**
     * 根据服务中心的orgCode得到下面所有orgCode
     * @param orgCode
     * @return
     */
    private List<String> getOrgCodeByOrgCode(String orgCode){
        List<String> orgCodes = new ArrayList<String>();
        Criteria criteria = new Criteria(Organization.PARENT_CODE,orgCode);
        List<Organization> organizationList = organizationApp.queryOrganization(criteria);
        if(ObjectUtil.isNullOrEmpty(organizationList)){
            orgCodes.add(orgCode);
        }else{
            for (Organization organization : organizationList) {
                orgCodes.add(organization.getOrganCode());
            }
        }
        return orgCodes;
    }

    /**
     * 根据GBCODE得到镇下面所有orgCode
     * @param gbCode
     * @return
     */
    private List<String> getOrgCodeByGBCode(String gbCode){
        Criteria criteria = new Criteria("gbCode",gbCode);
        /*criteria.add("genreCode", OrgGenreCode.STATION.getValue());*/
        List<Organization> stations = organizationApp.queryOrganization(criteria);
        List<String> stationsCodes = new ArrayList<>();
        if(ObjectUtil.isNotEmpty((stations))){
            for (Organization organization : stations) {
                stationsCodes.add(organization.getOrganCode());
            }
        }
        return stationsCodes;
    }
}
