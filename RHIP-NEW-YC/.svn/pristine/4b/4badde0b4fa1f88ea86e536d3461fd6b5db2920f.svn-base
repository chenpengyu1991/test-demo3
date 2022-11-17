package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;

/**
 * DAO implement of InpatientMedicalRecord
 * 
 */
@Repository("inpatientMedicalRecordDao")
public class InpatientMedicalRecordDaoImpl extends AbstractDao<InpatientMedicalRecord, Long> implements IInpatientMedicalRecordDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String FORMATER = "yyyy/mm/dd";
    
    private static final String BASIC_SQL = "select * from ms_inpatient_medical_record t"
    			+ " where t.GATHER_DATE = to_date('%2$s', '%1$s')";
    /**
     * 病案数统计 病案数种类 甲乙丙
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getInhosMedicalRecordQualityStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	
    	StringBuilder sqlBuilder = new StringBuilder("select t.hospital_code,t.out_hospital_date, allc, jia, yi, bing"
    			+ " from (select count(*) allc, t.hospital_code,to_char(t.out_hospital_date,'%2$s') out_hospital_date"
    			+ " from (%1$s) t where t.inhos_medical_quality_code in ('1','2','3')"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s')) t"
    			+ " left join (select count(*) jia, t.hospital_code,to_char(t.out_hospital_date,'%2$s') out_hospital_date"
    			+ " from (%1$s) t"
    			+ " where t.inhos_medical_quality_code = '1'"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s')) t1 on t.hospital_code ="
    			+ " t1.hospital_code and t.out_hospital_date = t1.out_hospital_date"
    			+ " left join (select count(*) yi, t.hospital_code,to_char(t.out_hospital_date,'%2$s') out_hospital_date"
    			+ " from (%1$s) t"
    			+ " where t.inhos_medical_quality_code = '2'"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s')) t2 on t.hospital_code ="
    			+ " t2.hospital_code and t.out_hospital_date = t2.out_hospital_date"
    			+ " left join (select count(*) bing, t.hospital_code,to_char(t.out_hospital_date,'%2$s') out_hospital_date"
    			+ " from (%1$s) t"
    			+ " where t.inhos_medical_quality_code = '3'"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s')) t3 on t.hospital_code ="
    			+ " t3.hospital_code and t.out_hospital_date = t3.out_hospital_date");
			
    		String basicSql = String.format(BASIC_SQL.toString(), FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), basicSql, FORMATER);
    		return this.getMapList(sql, new Criteria());
    }
    
    /**
     * 获取手术麻醉的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getAnesthesiaAndSurgeryStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select * from (select to_char(t.out_hospital_date,'%2$s') anesthesia_date,t.hospital_code anesthesia_code,count(*) countAnesthesia"
    			+ " from ms_inpatient_medical_record t"
    			+ " %1$s and (t.anesthesia_expense is not null and t.anesthesia_expense <>0.00)"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s'))Anesthesia"
    			+ " full join (select to_char(t.out_hospital_date,'%2$s') surgery_date,t.hospital_code surgery_code,count(*) countSurgery "
    			+ " from ms_inpatient_medical_record t"
    			+ " %1$s and (t.surgery_expense is not null  and t.surgery_expense <>0.00)"
    			+ " group by t.hospital_code,to_char(t.out_hospital_date,'%2$s'))Surgery"
    			+ " on Anesthesia.anesthesia_date = Surgery.surgery_date and Anesthesia.anesthesia_code = Surgery.surgery_code");
			
    		whereSql = String.format(whereSql, FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
    		return this.getMapList(sql, new Criteria());
    }
    
    /**
     * 获取质量质量中有关病案首页的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getCureResultRecordStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("with record as ("
    			+ " select to_char(t.out_hospital_date, '%2$s')out_hospital_date, hospital_code,OUTHOS_METHOD,INHOS_CONDITION,"
    			+ " MONTH_AGE,age,INHOS_RESCUE_TIMES from ms_inpatient_medical_record t %1$s),"
    			+ " die as (select out_hospital_date die_date,t.hospital_code die_code,count(*) die_count "
    			+ " from record t where t.OUTHOS_METHOD = '5' group by t.hospital_code,out_hospital_date),"
    			+ " atuo as (select out_hospital_date atuo_date,t.hospital_code atuo_code,count(*) atuo_count "
    			+ " from record t where t.OUTHOS_METHOD = '4' group by t.hospital_code,out_hospital_date),"
    			+ " wei as (select out_hospital_date wei_date,t.hospital_code wei_code,count(*) wei_count"
    			+ " from record t where t.OUTHOS_METHOD = '5' and t.INHOS_CONDITION=1 group by t.hospital_code,out_hospital_date),"
    			+ " age as (select out_hospital_date age_date,t.hospital_code age_code,count(*) age_count"
    			+ " from record t where MONTH_AGE<=1 and AGE IS NULL group by t.hospital_code,out_hospital_date),"
    			+ " age_die as (select out_hospital_date age_die_date,t.hospital_code age_die_code,count(*) age_die_count"
    			+ " from record t where MONTH_AGE<=1 and AGE IS NULL and t.OUTHOS_METHOD = '5' group by t.hospital_code,out_hospital_date),"
    			+ " rescue as (select out_hospital_date rescue_date,t.hospital_code rescue_code, sum(t.INHOS_RESCUE_TIMES) rescue_count"
    			+ " from record t where INHOS_CONDITION='1' group by t.hospital_code,out_hospital_date)"
    			+ " select r.hospital_code,r.out_hospital_date,nvl(die_count,0)die_count,nvl(atuo_count,0)atuo_count,"
    			+ " nvl(wei_count,0)wei_count,nvl(age_count,0)age_count,nvl(age_die_count,0)age_die_count, nvl(rescue_count,0)rescue_count"
    			+ " from (select r.hospital_code,to_char(r.out_hospital_date, '%2$s')out_hospital_date from "
    			+ " ms_inpatient_medical_record r"
    			+ " %1$s and (r.OUTHOS_METHOD in ('4','5') or (r.MONTH_AGE<=1 and r.AGE IS NULL) or (r.INHOS_CONDITION='1'))"
    			+ " group by r.hospital_code,to_char(r.out_hospital_date, '%2$s')"
    			+ " order by r.hospital_code,to_char(r.out_hospital_date, '%2$s'))r"
    			+ " left join die on r.hospital_code = die.die_code and r.out_hospital_date=die.die_date"
    			+ " left join atuo on r.hospital_code = atuo.atuo_code and r.out_hospital_date=atuo.atuo_date"
    			+ " left join wei on r.hospital_code = wei.wei_code and r.out_hospital_date=wei.wei_date"
    			+ " left join age on r.hospital_code = age.age_code and r.out_hospital_date=age.age_date"
    			+ " left join age_die on r.hospital_code = age_die.age_die_code and r.out_hospital_date=age_die.age_die_date"
    			+ " left join rescue on r.hospital_code = rescue.rescue_code and r.out_hospital_date=rescue.rescue_date");
			
    		whereSql = String.format(whereSql, FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
    		return this.getMapList(sql, new Criteria());
    }
}
