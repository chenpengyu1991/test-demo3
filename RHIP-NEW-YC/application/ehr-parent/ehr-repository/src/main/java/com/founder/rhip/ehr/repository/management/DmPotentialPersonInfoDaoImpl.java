package com.founder.rhip.ehr.repository.management;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DmPotentialPerinfo
 * 
 */
@Repository("dmPotentialPersonInfoDao")
public class DmPotentialPersonInfoDaoImpl extends AbstractDao<DmPotentialPersonInfo, Long> implements IDmPotentialPersonInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
	public boolean truncateTable() {
		StringBuilder sb = new StringBuilder();
		boolean result=true;
		try {
			sb.append(" DELETE DM_POTENTIAL_PERSON_INFO  WHERE (IS_FROM_ONE IS NULL OR IS_FROM_ONE = '2')");
			 this.delete(sb.toString());
		} catch (Exception e) {
			result=false;
			logger.error("DM_POTENTIAL_PERSON_INFO表删除失败"+e);
		}
		return result;
	}
    @Override
    public PageList<DmPotentialPersonInfo> getNotIntoPatientInfo(Page page, Criteria criteria){
    	StringBuilder sql=new StringBuilder("SELECT DISTINCT PERSON_ID,IDCARD,NAME,GENDER,BIRTHDAY,df FROM DM_POTENTIAL_PERSON_INFO B WHERE NOT EXISTS (SELECT PERSON_ID FROM (SELECT DISTINCT PERSON_ID FROM DM_PERSON_INFO UNION SELECT DISTINCT PERSON_ID FROM  DM_HIGHRISK_PERSON_INFO WHERE RISK_MANAGE_STATUS IS NULL)A WHERE B.PERSON_ID=A.PERSON_ID)");
    	if(criteria.getCriteria().size()>0){
        	sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(DmPotentialPersonInfo.class), ":")).toString();
    	}
		sql.append(" and (abnormal = '1' or abnormal is null)");
    	return this.getPageList(page, sql.toString(), criteria); 
    }
	@Override
	public DmPotentialPersonInfo getPatientInfo(Criteria criteria){
		StringBuilder sql=new StringBuilder("SELECT DISTINCT PERSON_ID,IDCARD,NAME,GENDER,BIRTHDAY FROM DM_POTENTIAL_PERSON_INFO B WHERE NOT EXISTS (SELECT PERSON_ID FROM (SELECT DISTINCT PERSON_ID FROM DM_PERSON_INFO UNION SELECT DISTINCT PERSON_ID FROM  DM_HIGHRISK_PERSON_INFO WHERE RISK_MANAGE_STATUS IS NULL)A WHERE B.PERSON_ID=A.PERSON_ID)");
		if(criteria.getCriteria().size()>0){
			sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(DmPotentialPersonInfo.class), ":")).toString();
		}
		return this.get(sql.toString(), criteria);
	}
}
