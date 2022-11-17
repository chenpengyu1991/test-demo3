package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.management.Dm135Mgmt;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by jingqiu on 17-4-19.
 */
@Repository("dm135MgmtDao")
public class Dm135MgmtDaoImpl extends AbstractDao<Dm135Mgmt, String> implements IDm135MgmtDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public PageList<Dm135Mgmt> getDm135MgmtsFinishedFollow(Page page, Criteria criteria) {

        StringBuilder sqlBuilder = new StringBuilder("select * from dm_135mgmt m");

        if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
            sqlBuilder.append(" where ");
        } else {
            SqlBuilder.buildWhereStatement(Dm135Mgmt.class, sqlBuilder, criteria);
            sqlBuilder.append(" and");
        }
        sqlBuilder.append(" m.done_question = 1 and m.mgmt_flag = 1 ");
        sqlBuilder.append(" and (m.cycle <= (");
        sqlBuilder.append(" select count(*) from dm_135followup f");
        sqlBuilder.append(" where to_char(f.followup_date,'yyyy/mm/dd') >= to_char(m.create_date,'yyyy/mm/dd')");
        sqlBuilder.append(" and to_char(f.followup_date,'yyyy/mm/dd') <=  to_char(add_months(m.create_date,12),'yyyy/mm/dd')");
        sqlBuilder.append(" and f.id_no = m.id_no)");
        sqlBuilder.append(" or exists(select * from dm_135appraise a where a.id_no = m.id_no))");
        return this.getPageList(page, sqlBuilder.toString(), criteria);
    }

    /**
     * 返回true表示此时此居民可以填写评价 false表示不可以
     * @param idNo
     * @return
     */
    public boolean isCanAppraise(String idNo) {
        Boolean result = false;
        if(ObjectUtil.isNullOrEmpty(idNo)) {
            return result;
        }
        StringBuilder sqlBuilder = new StringBuilder("select * from dm_135mgmt m");
        sqlBuilder.append(" where m.done_question = 1 and m.mgmt_flag = 1 ");
        sqlBuilder.append(" and m.is_appraise <> '1'");//未评价的
        sqlBuilder.append(" and m.cycle <= (");
        sqlBuilder.append(" select count(*) from dm_135followup f");
        sqlBuilder.append(" where to_char(f.followup_date,'yyyy/mm/dd') >= to_char(m.create_date,'yyyy/mm/dd')");
        sqlBuilder.append(" and to_char(f.followup_date,'yyyy/mm/dd') <=  to_char(add_months(m.create_date,12),'yyyy/mm/dd')");
        sqlBuilder.append(" and f.id_no = m.id_no)");
        sqlBuilder.append(" and id_no = '" + idNo + "'");
        return ObjectUtil.isNotEmpty(this.get(sqlBuilder.toString(), null));
    }
}
