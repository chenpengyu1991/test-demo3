package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.womenChild.GravidaReportResultDto;
import com.founder.rhip.ehr.dto.womenChild.GravidaSearchDto;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.child.WomenChildHealthNew;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("womenChildHealthDao")
public class WomenChildHealthDaoImpl extends AbstractDao<WomenChildHealth, String> implements IWomenChildHealthDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	private static final String HEALTH_VIDEO_SQL = "SELECT ID,NAME,ORG_CODE,ORG_NAME,GENDER,child_birthday,CREATE_DATE,UPDATE_DATE,CREATE_PERSON,UPDATE_PERSON,BABY_CARD_NO,ID_CARD,IS_DELETE FROM WOMEN_CHILD_HEALTH WHERE IS_DELETE=0 %1$s";
	
	private static final String UPDATE_SQL = "SELECT ID, IS_DELETE FROM WOMEN_CHILD_HEALTH WHERE MONTHS_BETWEEN(SYSDATE, CHILD_BIRTHDAY) > 72 AND IS_DELETE=0 AND IDENTITY_TYPE=1";
	
	private static final String LIST_SQL = "SELECT ID, NAME,  ORG_CODE, ORG_NAME, GENDER, CHILD_BIRTHDAY, CREATE_DATE, UPDATE_DATE, CREATE_PERSON, UPDATE_PERSON, BABY_CARD_NO, ID_CARD, IDENTITY_TYPE, IS_DELETE, PERSON_ID, HEALTH_FILE_NO FROM WOMEN_CHILD_HEALTH WC ";
	private static final String LISTNEW_SQL = "SELECT DISTINCT WC.ID, WC.NAME,  WC.ORG_CODE, WC.ORG_NAME, WC.GENDER, WC.CHILD_BIRTHDAY, WC.CREATE_DATE, WC.UPDATE_DATE, WC.CREATE_PERSON, WC.UPDATE_PERSON, WC.BABY_CARD_NO, WC.ID_CARD, WC.IDENTITY_TYPE, WC.IS_DELETE, WC.PERSON_ID, WC.HEALTH_FILE_NO,FLOOR(MONTHS_BETWEEN(SYSDATE, WC.CHILD_BIRTHDAY) / 12) AGE,V.MOTHER_NAME  FROM WOMEN_CHILD_HEALTH WC LEFT JOIN CH_NEONATAL_FAMILY_VISIT V ON WC.PERSON_ID=V.PERSON_ID ";
	
	@Override
	public List<WomenChildHealth> getWomenChildHealthSumList(Criteria criteria) {
		// TODO Auto-generated method stub
		String idCard=(String) criteria.get("ID_CARD");
		String babyCardNo=(String)criteria.get("BABY_CARD_NO");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition(idCard,babyCardNo,where, sqlParameterSource);
		String finalSql = String.format(HEALTH_VIDEO_SQL, where.toString());
		
		return getList(WomenChildHealth.class, finalSql, sqlParameterSource);
	}
	private void buildOrganCondition(String idCard, String babyCardNo,StringBuilder where, MapSqlParameterSource sqlParameterSource) {
		
		if(ObjectUtil.isNotEmpty(idCard) && ObjectUtil.isNotEmpty(babyCardNo) ){
			
			where.append(" AND (").append("ID_CARD").append(" =:idCard");
			where.append(" OR ").append("BABY_CARD_NO").append(" =:babyCardNo").append(")");
			sqlParameterSource.addValue("idCard", idCard);
			sqlParameterSource.addValue("babyCardNo", babyCardNo);
		}else if(ObjectUtil.isNotEmpty(idCard) && ObjectUtil.isNullOrEmpty(babyCardNo) ){
			where.append(" AND ").append("ID_CARD").append(" =:idCard");
			sqlParameterSource.addValue("idCard", idCard);
		}else{
			where.append(" AND ").append("BABY_CARD_NO").append(" =:babyCardNo");
			sqlParameterSource.addValue("babyCardNo", babyCardNo);
		}
	}
	
	@Override
	public PageList<WomenChildHealth> getPageList(Page page) {
		//查询大于6岁未删除的儿童
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(UPDATE_SQL).append(" )");
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		String nSql = dialect.getLimitString(UPDATE_SQL, page.getStartRow(), page.getPageSize());
		
		return new PageList<WomenChildHealth>(getList(WomenChildHealth.class, nSql,  sqlParameterSource), page);
	}
	@Override
	public PageList<WomenChildHealth> queryPageList(Page page, Boolean flg,
                                                    List<String> orgCodes, Map<String, String> paramMap, Order order, int type) {
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		
		String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDate = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard=paramMap.get("idCard");
        String healthGuideStatus= paramMap.get("healthGuideStatus");
        String birthday= paramMap.get("birthday");
        String birthdayEnd= paramMap.get("birthdayEnd");
		
        StringBuilder sql = new StringBuilder(LIST_SQL);
        sql.append(" WHERE IS_DELETE=0 ").append(" AND ").append(" IDENTITY_TYPE").append("=:type");
        sqlParameterSource.addValue("type", type);
        if(StringUtil.isNotEmpty(healthGuideStatus)){
        	if(type==1){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM CH_CHILD_HEALTH_EXAMINATION CH WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL AND WC.PERSON_ID = CH.PERSON_ID ").append(getVisitDateSql("CH.VISIT_DATE", createDate, createDateEnd)).append(")");
        	}else if(type==2){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM WH_PRENATAL_FOLLOWUP WH WHERE CM_HEALTH_MANAGE IS NOT NULL  AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_PRENATAL_FOLLOWUP_OTHER WH WHERE ((TCM_HEALTH_SIGN_TWO IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_TWO", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_THREE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_THREE", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FOUR IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FOUR", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FIVE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FIVE", createDate, createDateEnd)).append(")) AND WC.PERSON_ID = WH.PERSON_ID UNION ALL SELECT 1 FROM WH_POSTNATAL_FOLLOWUP WH WHERE CMEDICI_MANAGE_FLAG IS NOT NULL AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_POSTPARTUM_DAYS_HEALTH_INFO WH WHERE CM_HEALTH_MANAGE IS NOT NULL AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.SUPERVISION_DATE", createDate, createDateEnd)).append(")");
        	}
        }
        if(StringUtil.isNotEmpty(name)){
            sql.append(" AND ").append("NAME").append("=:name");
            sqlParameterSource.addValue("name", name);
        }
        if(StringUtil.isNotEmpty(idCard)){
            sql.append(" AND ").append("ID_CARD").append("=:idcard");
            sqlParameterSource.addValue("idcard", idCard);
        }
        if(StringUtil.isNotEmpty(gender)){
            sql.append(" AND ").append("GENDER").append("=:gender");
            sqlParameterSource.addValue("gender", gender);
        }
        if(StringUtil.isNotEmpty(updateDate)){
            sql.append(" AND TO_CHAR(").append("UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:updateDate");
			sqlParameterSource.addValue("updateDate", updateDate);
        }
        if(StringUtil.isNotEmpty(updateDateEnd)){
			sql.append(" AND TO_CHAR(").append("UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:updateDateEnd");
			sqlParameterSource.addValue("updateDateEnd", updateDateEnd);
        }
        if(StringUtil.isNotEmpty(createDate)){
            sql.append(" AND TO_CHAR(").append("CREATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:createDate");
			sqlParameterSource.addValue("createDate", createDate);
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
			sql.append(" AND TO_CHAR(").append("CREATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:createDateEnd");
			sqlParameterSource.addValue("createDateEnd", createDateEnd);
        }
        if(flg){
            if(ObjectUtil.isNotEmpty(organCode)){
                sql.append(" AND ").append("ORG_CODE").append(" =:organCode");
    			sqlParameterSource.addValue("organCode", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
            	sql.append(" AND ").append("ORG_CODE").append(" IN(:organCode)");
     			sqlParameterSource.addValue("organCode", orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)){
	            sql.append(" AND ").append("ORG_CODE").append(" =:organCode");
				sqlParameterSource.addValue("organCode", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
                sql.append(" AND ").append("ORG_CODE").append(" IN(:organCode)");
                sqlParameterSource.addValue("organCode", orgCodes);
            }
        }
        if(StringUtil.isNotEmpty(birthday)){
            sql.append(" AND TO_CHAR(").append("CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" >=:birthday");
			sqlParameterSource.addValue("birthday", birthday);
        }
        if(StringUtil.isNotEmpty(birthdayEnd)){
			sql.append(" AND TO_CHAR(").append("CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" <=:birthdayEnd");
			sqlParameterSource.addValue("birthdayEnd", birthdayEnd);
        }
        
//        if(StringUtil.isNotEmpty(startAge)){
//			sql.append(" AND MONTHS_BETWEEN(SYSDATE, CHILD_BIRTHDAY)/12").append(" >=:startAge");
//			sqlParameterSource.addValue("startAge", startAge);
//        }
//        if(StringUtil.isNotEmpty(endAge)){
//			sql.append(" AND MONTHS_BETWEEN(SYSDATE, CHILD_BIRTHDAY)/12").append(" <=:endAge");
//			sqlParameterSource.addValue("endAge", endAge);
//        }
        
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		
		sql.append(order.toString());
		String nSql = dialect.getLimitString(sql.toString(), page.getStartRow(), page.getPageSize());
		
        return new PageList<WomenChildHealth>(getList(WomenChildHealth.class, nSql,  sqlParameterSource), page);
	}
	
	private String getVisitDateSql(String col, String createDate, String createDateEnd){
		StringBuilder sql = new StringBuilder();
   	 	if(StringUtil.isNotEmpty(createDate)){
            sql.append(" AND TO_CHAR(").append(col).append(", 'YYYY/MM/DD')").append(" >=:createDate");
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
			sql.append(" AND TO_CHAR(").append(col).append(", 'YYYY/MM/DD')").append(" <=:createDateEnd");
        }
        return sql.toString();
	}
	@Override
	public PageList<WomenChildHealthNew> selectPageList(Page page, Boolean flg,
                                                        List<String> orgCodes, Map<String, String> paramMap, Order order,
                                                        int type) {
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		
		String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDate = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard=paramMap.get("idCard");
        String healthGuideStatus= paramMap.get("healthGuideStatus");
        String birthday= paramMap.get("birthday");
        String birthdayEnd= paramMap.get("birthdayEnd");
		
        StringBuilder sql = new StringBuilder(LISTNEW_SQL);
        sql.append(" WHERE WC.IS_DELETE=0 ").append(" AND ").append(" WC.IDENTITY_TYPE").append("=:type");
        sqlParameterSource.addValue("type", type);
        if(StringUtil.isNotEmpty(healthGuideStatus)){
        	if(type==1){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM CH_CHILD_HEALTH_EXAMINATION CH WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL AND WC.PERSON_ID = CH.PERSON_ID ").append(getVisitDateSql("CH.VISIT_DATE", createDate, createDateEnd)).append(")");
        	}else if(type==2){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM WH_PRENATAL_FOLLOWUP WH WHERE CM_HEALTH_MANAGE IS NOT NULL  AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_PRENATAL_FOLLOWUP_OTHER WH WHERE ((TCM_HEALTH_SIGN_TWO IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_TWO", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_THREE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_THREE", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FOUR IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FOUR", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FIVE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FIVE", createDate, createDateEnd)).append(")) AND WC.PERSON_ID = WH.PERSON_ID UNION ALL SELECT 1 FROM WH_POSTNATAL_FOLLOWUP WH WHERE CMEDICI_MANAGE_FLAG IS NOT NULL AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_POSTPARTUM_DAYS_HEALTH_INFO WH WHERE CM_HEALTH_MANAGE IS NOT NULL AND WC.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.SUPERVISION_DATE", createDate, createDateEnd)).append(")");
        	}
        }
        if(StringUtil.isNotEmpty(name)){
            sql.append(" AND ").append("WC.NAME").append("=:name");
            sqlParameterSource.addValue("name", name);
        }
        if(StringUtil.isNotEmpty(idCard)){
            sql.append(" AND ").append("WC.ID_CARD").append("=:idcard");
            sqlParameterSource.addValue("idcard", idCard);
        }
        if(StringUtil.isNotEmpty(gender)){
            sql.append(" AND ").append("WC.GENDER").append("=:gender");
            sqlParameterSource.addValue("gender", gender);
        }
        if(StringUtil.isNotEmpty(updateDate)){
            sql.append(" AND TO_CHAR(").append("WC.UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:updateDate");
			sqlParameterSource.addValue("updateDate", updateDate);
        }
        if(StringUtil.isNotEmpty(updateDateEnd)){
			sql.append(" AND TO_CHAR(").append("WC.UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:updateDateEnd");
			sqlParameterSource.addValue("updateDateEnd", updateDateEnd);
        }
        if(StringUtil.isNotEmpty(createDate)){
            sql.append(" AND TO_CHAR(").append("WC.CREATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:createDate");
			sqlParameterSource.addValue("createDate", createDate);
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
			sql.append(" AND TO_CHAR(").append("WC.CREATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:createDateEnd");
			sqlParameterSource.addValue("createDateEnd", createDateEnd);
        }
        if(flg){
            if(ObjectUtil.isNotEmpty(organCode)){
                sql.append(" AND ").append("WC.ORG_CODE").append(" =:organCode");
    			sqlParameterSource.addValue("organCode", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
            	sql.append(" AND ").append("WC.ORG_CODE").append(" IN(:organCode)");
     			sqlParameterSource.addValue("organCode", orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)){
	            sql.append(" AND ").append("WC.ORG_CODE").append(" =:organCode");
				sqlParameterSource.addValue("organCode", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
                sql.append(" AND ").append("WC.ORG_CODE").append(" IN(:organCode)");
                sqlParameterSource.addValue("organCode", orgCodes);
            }
        }
        if(StringUtil.isNotEmpty(birthday)){
            sql.append(" AND TO_CHAR(").append("WC.CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" >=:birthday");
			sqlParameterSource.addValue("birthday", birthday);
        }
        if(StringUtil.isNotEmpty(birthdayEnd)){
			sql.append(" AND TO_CHAR(").append("WC.CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" <=:birthdayEnd");
			sqlParameterSource.addValue("birthdayEnd", birthdayEnd);
        }
        
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		
		sql.append(order.toString());
		String nSql = dialect.getLimitString(sql.toString(), page.getStartRow(), page.getPageSize());
		
        return new PageList<WomenChildHealthNew>(getList(WomenChildHealthNew.class, nSql,  sqlParameterSource), page);
	}

	private String searchGravidaReportSql(GravidaSearchDto dto){
        String zy = dto.getZy();
        String twentySf = dto.getTwentySf();
        String twentyFourSf = dto.getTwentyFourSf();
        String thirtySixSf = dto.getThirtySixSf();
        String fourtySf = dto.getFourtySf();
        String chfs = dto.getChFs();
        String chfsSql = null;
        if(StringUtil.isEmpty(chfs))
            chfsSql = "case when EXISTS(select chfs.id from wh_ycfbj_chfs chfs where chfs.ycfbh=zxk.ycfbh) then '1' else '0' end ";
        else
            chfsSql ="'"+chfs+"'";
        String jc = dto.getJiancha();
        String jcSql = null;
        if(StringUtil.isEmpty(jc))
            jcSql = "case when EXISTS(select chjc.id from wh_ycfbj_chjc chjc where chjc.ycfbh=zxk.ycfbh) then '1' else '0' end ";
        else
            jcSql ="'"+jc+"'";
       /*  String twentySfSql = null;
       if(StringUtil.isNotEmpty(twentySf))
            twentySfSql ="'"+twentySf+"'";
        else
            twentySfSql = " case when EXISTS(select dyc.ycfbh from WH_YCFBJ_DYCSF dyc full join WH_YCFBJ_CQSF cqsf on dyc.ycfbh=zxk.ycfbh and dyc.dqyz >= 16 and dyc.dqyz <= 20 and cqsf.dqyz >= 16 and cqsf.dqyz <= 20 where cqsf.ycfbh=zxk.ycfbh and dyc.ycfbh=cqsf.ycfbh) then '1' else '0' end ";
        String twentyFourSfSql = null;
        if(StringUtil.isNotEmpty(twentyFourSf))
            twentyFourSfSql ="'"+twentyFourSf+"'";
        else
            twentyFourSfSql = " case when EXISTS(select dyc.ycfbh from WH_YCFBJ_DYCSF dyc full join WH_YCFBJ_CQSF cqsf on dyc.ycfbh=zxk.ycfbh and dyc.dqyz >= 21 and dyc.dqyz <= 24 and cqsf.dqyz >= 21 and cqsf.dqyz <= 24 where cqsf.ycfbh=zxk.ycfbh and dyc.ycfbh=cqsf.ycfbh) then '1' else '0' end ";
        String thirtySixSfSql = null;
        if(StringUtil.isNotEmpty(thirtySixSf))
            thirtySixSfSql ="'"+thirtySixSf+"'";
        else
            thirtySixSfSql = " case when EXISTS(select dyc.ycfbh from WH_YCFBJ_DYCSF dyc full join WH_YCFBJ_CQSF cqsf on dyc.ycfbh=zxk.ycfbh and dyc.dqyz >= 28 and dyc.dqyz <= 36 and cqsf.dqyz >= 28 and cqsf.dqyz <= 36 where cqsf.ycfbh=zxk.ycfbh and dyc.ycfbh=cqsf.ycfbh) then '1' else '0' end ";
        String fourtySfSql = null;
        if(StringUtil.isNotEmpty(fourtySf))
            fourtySfSql ="'"+fourtySf+"'";
        else
            fourtySfSql = " case when EXISTS(select dyc.ycfbh from WH_YCFBJ_DYCSF dyc full join WH_YCFBJ_CQSF cqsf on dyc.ycfbh=zxk.ycfbh and dyc.dqyz >= 37 and dyc.dqyz <= 40 and cqsf.dqyz >= 37 and cqsf.dqyz <= 40 where cqsf.ycfbh=zxk.ycfbh and dyc.ycfbh=cqsf.ycfbh) then '1' else '0' end ";
        */
        String sql ="select zxk.xm, zxk.zflxdh,fmxx.mcrq,zxk.zyjcz, CASE WHEN zxk.zyjcz is null THEN '0'  ELSE '1' END as zy,"+
                " zxk.twenty_sf,zxk.twenty_Four_Sf,zxk.thirty_Six_Sf,zxk.fourty_Sf, "+chfsSql+ " as chfs,"+jcSql+ " as jc "
                +" from wh_ycfbj_jd zxk left join wh_ycfbj_fmxx fmxx on fmxx.ycfbh = zxk.ycfbh where 1=1 ";
        //是否早孕
        if(EHRConstants.YCFHMC_FOU.equals(zy)){
            sql+=" and zyjcz is null ";
        }else if(EHRConstants.YCFHMC_SHI.equals(zy)){
            sql+=" and zyjcz is not null ";
        }
        if(StringUtil.isNotEmpty(twentySf))
            sql+=" and zxk.twenty_sf ='"+twentySf+"' ";
        if(StringUtil.isNotEmpty(twentyFourSf))
            sql+=" and zxk.twenty_Four_Sf ='"+twentyFourSf+"' ";
        if(StringUtil.isNotEmpty(thirtySixSf))
            sql+=" and zxk.thirty_Six_Sf ='"+thirtySixSf+"'";
        if(StringUtil.isNotEmpty(fourtySf))
            sql+=" and zxk.fourty_Sf ='"+fourtySf+"' ";
        /*//16-20周是否随访
        if(EHRConstants.YCFHMC_FOU.equals(twentySf)){
            sql+=" and (not exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=16 and dyc.dqyz<=20) and not exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=16 and cqsf.dqyz<=20)) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(twentySf)){
            sql+=" and (exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=16 and dyc.dqyz<=20) or exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=16 and cqsf.dqyz<=20)) ";
        }
        //21-24周随访
        if(EHRConstants.YCFHMC_FOU.equals(twentyFourSf)){
            sql+=" and (not exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=21 and dyc.dqyz<=24) and not exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=21 and cqsf.dqyz<=24)) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(twentyFourSf)){
            sql+=" and (exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=21 and dyc.dqyz<=24) or exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=21 and cqsf.dqyz<=24)) ";
        }
        //28-36周随访
        if(EHRConstants.YCFHMC_FOU.equals(thirtySixSf)){
            sql+=" and (not exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=28 and dyc.dqyz<=36) and not exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=28 and cqsf.dqyz<=36)) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(thirtySixSf)){
            sql+=" and (exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=28 and dyc.dqyz<=36) or exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=28 and cqsf.dqyz<=36)) ";
        }
        //37-40周随访
        if(EHRConstants.YCFHMC_FOU.equals(fourtySf)){
            sql+=" and (not exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=37 and dyc.dqyz<=40) and not exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=37 and cqsf.dqyz<=40)) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(fourtySf)){
            sql+=" and (exists (select dyc.id from wh_ycfbj_dycsf dyc where dyc.ycfbh=zxk.ycfbh and dyc.dqyz>=37 and dyc.dqyz<=40) or exists (select cqsf.id from wh_ycfbj_cqsf cqsf where cqsf.ycfbh=zxk.ycfbh and cqsf.dqyz>=37 and cqsf.dqyz<=40)) ";
        }*/
        //产后访视
        if(EHRConstants.YCFHMC_FOU.equals(chfs)){
            sql+=" and not exists (select chfs.id from wh_ycfbj_chfs chfs where chfs.ycfbh=zxk.ycfbh) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(chfs)){
            sql+=" and exists (select chfs.id from wh_ycfbj_chfs chfs where chfs.ycfbh=zxk.ycfbh) ";
        }
        //42天检查
        if(EHRConstants.YCFHMC_FOU.equals(jc)){
            sql+=" and  exists (select chjc.id from wh_ycfbj_chjc chjc where chjc.ycfbh=zxk.ycfbh) ";
        }else if(EHRConstants.YCFHMC_SHI.equals(jc)){
            sql+=" and  not exists (select chjc.id from wh_ycfbj_chjc chjc where chjc.ycfbh=zxk.ycfbh) ";
        }
        return sql;
    }
    @Override
    public PageList<GravidaReportResultDto> searchGravidaReportList(Page page, GravidaSearchDto dto, Order order) {

        String sql = searchGravidaReportSql(dto);
        sql +=order.toString();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
        int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
        page.setTotalRows(rowCounts);
        String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());

        return new PageList<GravidaReportResultDto>(getList(GravidaReportResultDto.class, nSql,  sqlParameterSource), page);
    }

    @Override
    public PageList<Map<String, Object>> searchGravidaReportMapList(Page page, GravidaSearchDto dto, Order order) {
        String sql = searchGravidaReportSql(dto);
        sql +=order.toString();
	    return this.getPageMapList(page, sql.toString(), null);
    }

    //档案迁移 儿童健康管理菜单中- 儿童基本信息  更新机构信息
    @Override
    public void updatePersonRecordMove(Parameters parameters, Criteria criteria) {
        update(WomenChildHealthNew.class,parameters,criteria);
    }
}
