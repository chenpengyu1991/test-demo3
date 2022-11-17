package com.founder.rhip.ehr.repository.management.mhm;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmBasicsInfo
 * 
 */
@Repository("mhmBasicsInfoDao")
public class MhmBasicsInfoDaoImpl extends AbstractDao<MhmBasicsInfo, Long> implements IMhmBasicsInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void updatePaAddress(String paTownShip, String oldTown, String newTown){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE MHM_BASICS_INFO SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append("WHERE PATOWN_SHIP = " + "'" + paTownShip + "'");
        this.execute(sql.toString());
    }

    public void updateHrAddress(String hrTownShip, String oldTown, String newTown){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE MHM_BASICS_INFO SET HR_ADDRESS = REPLACE(HR_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append("WHERE HRTOWN_SHIP = " + "'" + hrTownShip + "'");
        this.execute(sql.toString());
    }

    public void updatePaAddress2(String paStreet, String townName, String villageName){//
        StringBuilder sql =  new StringBuilder();
//        sql.append("UPDATE MHM_BASICS_INFO SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append("UPDATE MHM_BASICS_INFO SET PA_ADDRESS = '"+townName+villageName+"'||PAHOUSE_NUMBER");
        sql.append(" WHERE PASTREET = " + "'" + paStreet + "'");
        this.execute(sql.toString());
    }

    public void updateHrAddress2(String hrStreet, String oldTown, String newTown){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE MHM_BASICS_INFO SET HR_ADDRESS = REPLACE(HR_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append("WHERE HRSTREET = " + "'" + hrStreet + "'");
        this.execute(sql.toString());
    }
}