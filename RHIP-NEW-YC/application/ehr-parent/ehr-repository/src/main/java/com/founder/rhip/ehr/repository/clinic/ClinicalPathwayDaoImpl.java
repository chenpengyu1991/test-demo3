package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;

/**
 * DAO implement of ClinicalPathway
 * 
 */
@Repository("clinicalPathwayDao")
public class ClinicalPathwayDaoImpl extends AbstractDao<ClinicalPathway, Long> implements IClinicalPathwayDao {
	@Resource(name = "msdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String FORMATER = "yyyy/mm/dd";
	
	/**
     * 获取临床路径的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getClinicalPathwayStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select * from ("
    			+ " SELECT HOSPITAL_CODE cli_code,to_char(CREATE_DATE, '%1$s') cli_date,count(1)clinicalPathwayNum "
    			+ " FROM MS_CLINICAL_PATHWAY %2$s  and INTO_TIME is not null group by HOSPITAL_CODE,to_char(CREATE_DATE, '%1$s'))clinicalPathway"
    			+ " full join(select * from ("
    			+ " SELECT HOSPITAL_CODE out_code,to_char(CREATE_DATE, '%1$s')out_date,count(1)outCpNum"
    			+ " FROM MS_CLINICAL_PATHWAY %2$s  and QUIT_TIME is not null group by HOSPITAL_CODE,to_char(CREATE_DATE, '%1$s')))out"
    			+ " on clinicalPathway.cli_code = out.out_code and clinicalPathway.cli_date=out.out_date"
    			+ " full join(select * from ("
    			+ " SELECT HOSPITAL_CODE com_code,to_char(CREATE_DATE, '%1$s')com_date,count(1)completeCpNum"
    			+ " FROM MS_CLINICAL_PATHWAY %2$s  and  COMPLETE_TIME is not null group by HOSPITAL_CODE,to_char(CREATE_DATE, '%1$s')))complete"
    			+ " on ((clinicalPathway.cli_code = complete.com_code and clinicalPathway.cli_date=complete.com_date)"
    			+ " or (out.out_code = complete.com_code and out.out_date=complete.com_date))"
    			+ " full join(select * from ( "
    			+ " SELECT HOSPITAL_CODE cu_code,to_char(CREATE_DATE, '%1$s')cu_date,count(1)cureCpNum"
    			+ " FROM MS_CLINICAL_PATHWAY %2$s  and CURE_MARK=1 group by HOSPITAL_CODE,to_char(CREATE_DATE, '%1$s')))cure"
    			+ " on ((clinicalPathway.cli_code = cure.cu_code and clinicalPathway.cli_date=cure.cu_date)"
    			+ " or (out.out_code = cure.cu_code and out.out_date=cure.cu_date)"
    			+ " or (complete.com_code = cure.cu_code and complete.com_date=cure.cu_date))"
    			+ " full join(select * from ( "
    			+ " SELECT HOSPITAL_CODE death_code,to_char(CREATE_DATE, '%1$s') death_date,count(1)deathCpNum "
    			+ " FROM MS_CLINICAL_PATHWAY %2$s  and DEATH_MARK=1 group by HOSPITAL_CODE,to_char(CREATE_DATE, '%1$s')))death"
    			+ " on ((clinicalPathway.cli_code = death.death_code and clinicalPathway.cli_date=death.death_date) "
    			+ " or (out.out_code = death.death_code and out.out_date=death.death_date)"
    			+ " or (complete.com_code = death.death_code and complete.com_date=death.death_date)"
    			+ " or (cure.cu_code = death.death_code and cure.cu_date=death.death_date))");
			
    		whereSql = String.format(whereSql, FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), FORMATER, whereSql);
    		return this.getMapList(sql, new Criteria());
    }
    
}