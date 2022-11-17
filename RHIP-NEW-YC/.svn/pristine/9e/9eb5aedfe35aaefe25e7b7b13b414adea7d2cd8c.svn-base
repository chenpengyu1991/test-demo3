package com.founder.rhip.mdm.repository;

import com.founder.rhip.mdm.entity.StaffOrg;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdmStaffOrgDao")
public class StaffOrgDaoImpl extends MDMRepository<StaffOrg, Long> implements IStaffOrgDao {

    public void deleteStaffOrg(String newOrgCode, List<String> oldOrgCodes) {
        String sql = "delete from MDM_STAFF_ORG so1\n" +
                "WHERE ORGAN_CODE IN (:oldOrgCodes)\n" +
                "and EXISTS(select 1 from MDM_STAFF_ORG so2 where so1.staff_code= so2.staff_code and ORGAN_CODE = :newOrgCode)";

        String sqlUpdate = "UPDATE MDM_STAFF_ORG so set is_main='0'\n" +
                "where is_main='1' and EXISTS(select 1 from mdm_staff s where s.staff_code=so.staff_code and so.organ_code=s.organ_code) and so.organ_code= :newOrgCode";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource("oldOrgCodes", oldOrgCodes);
        parameterSource.addValue("newOrgCode", newOrgCode);
        simpleJdbcTemplate.update(sql, parameterSource);
        parameterSource = new MapSqlParameterSource("newOrgCode", newOrgCode);
        simpleJdbcTemplate.update(sqlUpdate, parameterSource);

        //0189483: 【机构合并】同一个医务人员在两个站兼职，在机构区划中，选择这两个站合并，报系统数据异常
        parameterSource = new MapSqlParameterSource("oldOrgCodes", oldOrgCodes);
        sql = "delete from MDM_STAFF_ORG s \n" +
                "where not exists(\n" +
                "    select * from (\n" +
                "    select staff_code,max(organ_code) organ_code from MDM_STAFF_ORG where organ_code in (:oldOrgCodes)\n" +
                "    group by staff_code\n" +
                "    having count(*)>1)t\n" +
                "where s.organ_code=t.organ_code and s.staff_code=t.staff_code\n" +
                ")\n" +
                "and s.STAFF_CODE in(\n" +
                "select staff_code from MDM_STAFF_ORG where organ_code in (:oldOrgCodes)\n" +
                "group by staff_code\n" +
                "having count(*)>1\n" +
                ")\n" +
                "and s.organ_code in (:oldOrgCodes)";
        simpleJdbcTemplate.update(sql, parameterSource);
    }
}
