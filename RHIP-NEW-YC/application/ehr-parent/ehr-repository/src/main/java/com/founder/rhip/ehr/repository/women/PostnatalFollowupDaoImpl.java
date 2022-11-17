package com.founder.rhip.ehr.repository.women;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;

import java.util.List;

/**
 * DAO implement of WhPostnatalFollowup
 * 
 */
@Repository("whPostnatalFollowupDao")
public class PostnatalFollowupDaoImpl extends AbstractDao<PostnatalFollowup, Long> implements IPostnatalFollowupDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public Long postnatalFollowupCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT COUNT(DISTINCT PERSON_ID) FROM WH_POSTNATAL_FOLLOWUP ");
		SqlBuilder.buildWhereStatement(PrenatalFollowup.class, sql, criteria);
		Long count = this.getSingle(sql.toString(), criteria, Long.class);
		return count;
	}

	public List<PostnatalFollowup> getPostnatalFollNum(Integer year, Integer quarter, String orgCode){
		int month = 1;
		if(quarter != 0){
			if(quarter == 1){
				month = 1;
			}else if(quarter == 2){
				month = 4;
			}else if(quarter == 3){
				month = 7;
			}else if(quarter == 4){
				month = 10;
			}
		}
		int nextYear = year+1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from WH_POSTNATAL_FOLLOWUP where IS_DELETE = 0");
		stringBuilder.append(" and CREATE_ORGAN_CODE ='"+orgCode+"'");
		if(quarter == 0){
			stringBuilder.append(" and VISIT_DATE >=to_date('"+year+"0101','yyyymmdd') and VISIT_DATE < to_date('"+nextYear+"0101','yyyymmdd')");
		}else {
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + nextYear + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
		}
		/*SqlBuilder.buildWhereStatement(PrenatalFollowup.class, stringBuilder, new Criteria());
		Long count = this.getSingle(stringBuilder.toString(), new Criteria(), Long.class);*/
		return getList(stringBuilder.toString(),new Criteria());
	}
}