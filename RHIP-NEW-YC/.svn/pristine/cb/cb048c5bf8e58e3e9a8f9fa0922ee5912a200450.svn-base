package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;
import oracle.jdbc.OracleTypes;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DAO implement of ReferralInfo
 * 
 */
@Repository("centerDao")
public class CenterDaoImpl extends AbstractDao<OutTransfer, Long> implements ICenterDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public Map approve(final LinkedHashMap<String, String> map) {
        String sql = "{?=call FNC_TRANS_TREAT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        return this.simpleJdbcTemplate.getJdbcOperations().execute(sql, new CallableStatementCallback<Map>() {
            @Override
            public Map doInCallableStatement(CallableStatement cstmt) throws SQLException, DataAccessException {
                cstmt.registerOutParameter(1, OracleTypes.INTEGER);//
                int i = 2;
                for (String key : map.keySet()) {
                    cstmt.setString(i, map.get(key));
                    i++;
                }
                cstmt.registerOutParameter(17, OracleTypes.VARCHAR);
                cstmt.registerOutParameter(18, OracleTypes.VARCHAR);
                cstmt.execute();

                String poRegCode = cstmt.getString(17);
                String poResult = cstmt.getString(18);
                int result = cstmt.getInt(1);
                Map resultMap = new HashMap();
                resultMap.put("result", result == 0 ? 1:2);
                resultMap.put("hgCode", poRegCode);
                resultMap.put("msg", poResult);
                return resultMap;
            }
        });
    }

}