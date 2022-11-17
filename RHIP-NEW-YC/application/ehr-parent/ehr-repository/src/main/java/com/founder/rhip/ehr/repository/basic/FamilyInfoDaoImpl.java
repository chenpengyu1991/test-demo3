package com.founder.rhip.ehr.repository.basic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;

import javax.annotation.Resource;

/**
 * DAO implement of FamilyInfo
 * 
 */
@Repository("familyInfoDao")
public class FamilyInfoDaoImpl extends AbstractDao<FamilyInfo, Long> implements IFamilyInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
//Canceled_Flag 改成 Family.status
//  public PageList<FamilyInfo> getFamliyPageList(Page page, Criteria criteria)
//  {
//	  StringBuilder sql=new StringBuilder("SELECT FI.ID,FI.GBCODE,FI.ZONE_GBCODE,FI.HOUSEHOLDER_NAME,FI.HOUSEHOLDER_IDCARD,FI.FAMILY_TYPE,FI.HOUSE_STRUCTURE,FI.OUT_WIND,FI.HASTOILET,FI.WATER,FI.FUEL,FI.FOWL_TYPE,FI.MEMBER_LINK,FI.ACCOUNT_NUMBER,FI.IS_DELETE,FI.HEATING_FACILITIES,FI.AIR_CONDITIONING_FLAG,FI.STATUS,FCI.Canceled_Flag FROM BI_FAMILY_INFO FI LEFT JOIN BI_FAMILY_CANCELED_INFO FCI ON FI.ID=FCI.FAMILY_ID");
//	  SqlBuilder.buildWhereStatement(FamilyInfo.class, sql, criteria);
//	  return getPageList(page, sql.toString(), criteria);
//  }
	
}