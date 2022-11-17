package com.founder.rhip.ehr.repository.summary;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of DiseaseHistory
 * 
 */
@Repository("diseaseHistoryDao")
public class DiseaseHistoryDaoImpl extends AbstractDao<DiseaseHistory, String> implements IDiseaseHistoryDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 根据CONFIRMATION_DATE倒序获取不重复的DiseaseCode的疾病列表信息
     * @param criteria
     * @return
     */
    @Override
    public List<DiseaseHistory> getDiseaseHistoryListByDistinctDiseaseCode(Criteria criteria) {
        String sql = "select d.OTHER_DESC,\n" +
                "  d.CONFIRMATION_DATE,\n" +
                "  d.DISEASE_NAME,\n" +
                "  d.EHR_ID,\n" +
                "  d.PERSON_ID,\n" +
                " d.DISEASE_CODE from DHS_DISEASE_HISTORY d right join (SELECT \n" +
                "  max(id) id,\n" +
                "  max(CONFIRMATION_DATE) CONFIRMATION_DATE,\n" +
                " DISEASE_CODE\n" +
                "FROM DHS_DISEASE_HISTORY\n" +
                "%1$s\n" +
                "group by DISEASE_CODE) t on t.id = d.id\n" +
                "order by d.CONFIRMATION_DATE DESC";
        StringBuilder whereSql = new StringBuilder();
        SqlBuilder.buildWhereStatement(DiseaseHistory.class, whereSql, criteria);
        sql =  String.format(sql.toString(),whereSql.toString());
        return this.getList(sql, criteria);
    }
}