package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of GeneralCondition
 * 
 */
@Repository("generalConditionDao")
public class GeneralConditionDaoImpl extends AbstractDao<GeneralCondition, Integer> implements IGeneralConditionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void updatePaAddress(String paTownShip, String oldTown, String newTown){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"')");
        sql.append("WHERE PATOWN_SHIP = " + "'" + paTownShip + "'");
        this.execute(sql.toString());
    }

    public void updatePaAddress2(String paStreet, String townName, String villageName){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = '"+townName+villageName+"'||PAHOUSE_NUMBER");
//        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append(" WHERE PASTREET = " + "'" + paStreet + "'");
        this.execute(sql.toString());
    }
    
    public void updateHrAddress2(String hrStreet, String townName, String villageName){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE IDM_GENERAL_CONDITION SET HR_ADDRESS = '"+townName+villageName+"'||HRHOUSE_NUMBER");
//        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append(" WHERE HRSTREET = " + "'" + hrStreet + "'");
        this.execute(sql.toString());
    }
}