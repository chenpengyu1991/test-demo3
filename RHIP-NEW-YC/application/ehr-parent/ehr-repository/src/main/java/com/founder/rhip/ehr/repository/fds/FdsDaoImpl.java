package com.founder.rhip.ehr.repository.fds;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameter;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of Doctor
 * 
 */
@Repository("fdsDao")
public class FdsDaoImpl extends AbstractDao<FamilyInfo, Long> implements IFdsDao {
    @Resource(name = "fdsdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public int updateOrganCode(String tableName, String columnName, Parameters parameters, Criteria criteria) {
        if (parameters == null) {
            return 0;
        }
        String sql = "UPDATE "+ tableName+ " SET "+columnName+"=:newOrganCode  WHERE "+columnName+"=:oldOrganCode ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("newOrganCode", parameters.getParameters().get(0).getValue());
        parameterSource.addValue("oldOrganCode", criteria.get("ORGAN_CODE"));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int updateInputOrgan(Parameters parameters, Criteria criteria) {
        if (parameters == null) {
            return 0;
        }
        String sql = "UPDATE SIGN_FAMILY SET INPUT_ORGAN_CODE=:newOrganCode, INPUT_ORGAN_NAME=:newOrganName  WHERE INPUT_ORGAN_CODE=:oldOrganCode ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        for (Parameter paramName : parameters.getParameters()) {
            if(paramName.getName().equals("INPUT_ORGAN_CODE")){
                parameterSource.addValue("newOrganCode", paramName.getValue());
            }
            if(paramName.getName().equals("INPUT_ORGAN_NAME")){
                parameterSource.addValue("newOrganName", paramName.getValue());
            }
        }
        parameterSource.addValue("oldOrganCode", criteria.get("INPUT_ORGAN_CODE"));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int updateGbOrgan(Parameters parameters, Criteria criteria) {
        if (parameters == null) {
            return 0;
        }
        String sql = "UPDATE NOTICE SET ORGAN_CODE=:newOrganCode, GB_CODE=:newGbCode  WHERE ORGAN_CODE =:oldOrganCode ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        for (Parameter paramName : parameters.getParameters()) {
            if(paramName.getName().equals("ORGAN_CODE")){
                parameterSource.addValue("newOrganCode", paramName.getValue());
            }
            if(paramName.getName().equals("GB_CODE")){
                parameterSource.addValue("newGbCode", paramName.getValue());
            }
        }
        parameterSource.addValue("oldOrganCode", criteria.get("ORGAN_CODE"));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int updateGbCode(Parameters parameters, Criteria criteria) {
        if (parameters == null) {
            return 0;
        }
        String sql = "UPDATE NOTICE SET GB_CODE=:newGbCode  WHERE ORGAN_CODE =:oldOrganCode ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        for (Parameter paramName : parameters.getParameters()) {
            if(paramName.getName().equals("GB_CODE")){
                parameterSource.addValue("newGbCode", paramName.getValue());
            }
        }
        parameterSource.addValue("oldOrganCode", criteria.get("ORGAN_CODE"));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int updateTownShip(String tableName, Parameters parameters, String[] oldTownCode) {
        if (parameters == null || oldTownCode==null || oldTownCode.length==0) {
            return 0;
        }
        String sql = "UPDATE "+ tableName+ " SET PATOWN_SHIP=:newTownShip  WHERE PATOWN_SHIP in (:oldTownShip) ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("newTownShip", parameters.getParameters().get(0).getValue());
        String oldTownStr = "";
        for(String townCode : oldTownCode){
            oldTownStr = oldTownStr+townCode+",";
        }
        parameterSource.addValue("oldTownShip", oldTownStr.substring(0,oldTownStr.length()-1));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int updateTownShipByStreet(String tableName, Parameters parameters, String[] newAddVillageCodes) {
        if (parameters == null) {
            return 0;
        }
        String sql = "UPDATE "+ tableName+ " SET PATOWN_SHIP=:newTownShip  WHERE PASTREET in (:oldStreet) ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("newTownShip", parameters.getParameters().get(0).getValue());
        String villageCodeStr = "";
        for(String villageCode : newAddVillageCodes){
            villageCodeStr = villageCodeStr+villageCode+",";
        }
        parameterSource.addValue("oldStreet", villageCodeStr.substring(0,villageCodeStr.length()-1));
        return simpleJdbcTemplate.update(sql, parameterSource);
    }

    public void updatePaAddress(String tableName, String paStreet, String townName, String villageName){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE "+ tableName+ " SET ADDRESS = '"+townName+villageName+"'||PAHOUSE_NUMBER");
        sql.append(" WHERE PASTREET = " + "'" + paStreet + "'");
        this.execute(sql.toString());
    }


}