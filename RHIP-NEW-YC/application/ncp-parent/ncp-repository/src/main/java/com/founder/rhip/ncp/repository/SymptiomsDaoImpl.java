package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ncp.entity.NcpSymptioms;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository("ncpSymptiomsDao")
public class SymptiomsDaoImpl extends AbstractDao<NcpSymptioms,Long> implements ISymptiomsDao{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public String findSymptiomsByMonitorid(String id) {
        String rs = null ;
        StringBuffer sb =new StringBuffer("select wmsys.wm_concat(symptom_code) result from ncp_symptoms where monitor_id ='"+id+"'");
        Map map = this.getMap(sb.toString(),new Criteria());
        if(map!=null)
            rs = (String) map.get("result");
        return rs;
    }
}
