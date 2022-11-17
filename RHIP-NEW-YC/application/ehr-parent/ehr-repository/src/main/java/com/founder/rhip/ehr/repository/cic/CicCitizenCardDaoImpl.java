package com.founder.rhip.ehr.repository.cic;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;
/**
 * DAO implement of CicCitizenCard
 * 
 */
@Repository("cicCitizenCardDao")
public class CicCitizenCardDaoImpl extends AbstractDao<CicCitizenCard, Long> implements ICicCitizenCardDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    final String selectOrgan = "select a.INPUT_ORGAN_CODE organCode,";
    final String selectTown = "select a.INPUT_GBCODE organCode,";
    private String countSQL =   " count(case when a.CARD_STATUS='00' then 1 end) countNormal,"+
					    		" count(case when a.CARD_STATUS='01' then 1 end) countLoss,"+
					    		" count(case when a.CARD_STATUS='04' then 1 end) countChange,"+
					    		" count(case when a.CARD_STATUS='05' then 1 end) countReissue"+
					    		" from CIC_CITIZEN_CARD a ";
    final String groupByOrganSQL = " group by a.INPUT_ORGAN_CODE";
    final String groupByTownSQL = " group by a.INPUT_GBCODE";

	@Override
	public List<Map<String, Object>> getCicCitizenCardStatistic(
			Criteria criteria) {
		String genreCode = (String)criteria.get("genreCode");
		criteria.remove("genreCode");
		String sql = "";
		if("0".equals(genreCode)){
			sql = selectTown + countSQL;
		}else{
			sql = selectOrgan + countSQL;
		}
		StringBuilder strB = new StringBuilder(sql);
		SqlBuilder.buildWhereStatement(CicCitizenCard.class, strB, criteria);
		if("0".equals(genreCode)){
			strB.append(groupByTownSQL);
		}else{
			strB.append(groupByOrganSQL); 
		}
		List<Map<String, Object>> list = getMapList(strB.toString(), criteria);
		for(Map<String,Object> map : list){
			map.put("countNormal", ((BigDecimal)map.get("countNormal")).intValue());
			map.put("countLoss", ((BigDecimal)map.get("countLoss")).intValue());
			map.put("countChange", ((BigDecimal)map.get("countChange")).intValue());
			map.put("countReissue", ((BigDecimal)map.get("countReissue")).intValue());
		}
		return list;
	}

    public PageList<CicCitizenCard> getCicCitizenCardList(Criteria criteria, Page page){
        StringBuilder sql = new StringBuilder("SELECT *\n" +
                "  FROM CIC_CITIZEN_CARD A\n" +
                " WHERE A.ID =\n" +
                "       (SELECT MAX(B.ID) FROM CIC_CITIZEN_CARD B WHERE A.PAPER_NO = B.PAPER_NO) ");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(CicCitizenCard.class), ":")).toString();
        }

//        SqlBuilder.buildWhereStatement(CicCitizenCard.class, sql, criteria) ;
        SqlBuilder.buildOrderStatement(sql, " UPDATE_DATE DESC , ID DESC ");
        return this.getPageList(page, sql.toString(), criteria);
    }
}