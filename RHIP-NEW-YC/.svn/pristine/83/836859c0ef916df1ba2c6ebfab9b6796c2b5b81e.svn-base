package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;

/**
 * DAO implement of InpatientInfo
 * 
 */
@Repository("inpatientInfoDao")
public class InpatientInfoDaoImpl extends AbstractDao<InpatientInfo, Long> implements IInpatientInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String FORMATER = "yyyy/mm/dd";
    
    public List<InpatientInfo> getFList(Criteria criteria){

        StringBuilder sql = new StringBuilder("SELECT I.PERSON_ID,\n" +
                "       I.ADMISSION_NO,\n" +
                "       I.MEDICAL_RECORD_NO,\n" +
                "       I.INHOS_DATE,\n" +
                "       I.NAME,\n" +
                "       I.GENDER,\n" +
                "       I.AGE,\n" +
                "       I.BIRTHDAY,\n" +
                "       I.MARRIAGE,\n" +
                "       I.PATHOGENESIS_DATE,\n" +
                "       I.TREATMENT_RESULTS_CODE,\n" +
                "       I.ATTENDING_PHYSICIAN_NO,\n" +
                "       I.OUT_HOSPITAL_DATE,\n" +
                "       S.ICD_CODE\n" +
                "  FROM MS_INPATIENT_INFO I, MS_OUTHOSPITAL_SUMMARY S\n" +
                "  WHERE I.ADMISSION_NO = S.ADMISSION_NO AND " );
        sql.append(criteria.toSql(ClassMetadata.getMetadata(InpatientInfo.class), ":").toString());
        return getList(sql.toString(), criteria);
    }
    
    /**
     * 获取出院入院相关的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getInpatientInfoStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select out.*,inhos.*,nvl(countEhrIdS,0)+ nvl(countEhrId,0) countEhrId from ("
    			+ " select t.referral_hospital_code,to_char(t.out_hospital_date,'%1$s')out_hospital_date,"
    			+ " sum(t.personal_expenses)personal_expenses,sum(t.medical_insurance_cost_sum)medical_insurance_cost_sum,"
    			+ " sum(t.inhos_cost_sum)inhos_cost_sum,sum(t.inhos_days)inhos_days,count(*) out_num,"
    			+ " count(distinct t.ehr_id) countEhrIdS"
    			+ " from ms_inpatient_info t %2$s group by t.referral_hospital_code, to_char(t.out_hospital_date,'%1$s')"
    			+ " order by t.referral_hospital_code, to_char(t.out_hospital_date,'%1$s') ) out"
    			+ " full join (select * from (select t.referral_hospital_code in_hos_code,"
    			+ " to_char(t.inhos_date,'%1$s')inhos_date,count(*) in_num,"
    			+ " count(distinct t.ehr_id) countEhrId from ms_inpatient_info t %2$s"
    			+ " group by t.referral_hospital_code, to_char(t.inhos_date,'%1$s')"
    			+ " order by t.referral_hospital_code, to_char(t.inhos_date,'%1$s')"
    			+ " )) inhos on out.referral_hospital_code = inhos.in_hos_code and inhos_date= out_hospital_date");
			
    		whereSql = String.format(whereSql, FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), FORMATER ,whereSql);
    		return this.getMapList(sql, new Criteria());
    }

	/**
	 * 获取 CURE_NUM（治愈人数）
	 * IMPROVE_NUM（好转人数）
	 * DEATH_NUM（死亡人数）数据
	 * @param dateStr 日期格式必须是yyyy/mm/dd
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getInpatientInfoDataSum(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
		StringBuilder sqlBuilder = new StringBuilder("SELECT \n" +
				"REFERRAL_HOSPITAL_CODE,\n" +
				"HZ_DATE,--汇总日期\n" +
				"sum(case when TREATMENT_RESULTS_CODE = '1' then 1 else 0 end)  ZYRS,--治愈人数\n" +
				"sum(case when TREATMENT_RESULTS_CODE = '2' then 1 else 0 end)  HZRS,--好转人数\n" +
				"sum(case when TREATMENT_RESULTS_CODE = '5' then 1 else 0 end)  SWRS--死亡人数\n" +
				" FROM (SELECT REFERRAL_HOSPITAL_CODE,TREATMENT_RESULTS_CODE,case when OUT_HOSPITAL_DATE is not NULL then OUT_HOSPITAL_DATE else DEATH_DATE end HZ_DATE FROM MS_INPATIENT_INFO\n" +
				"where to_char(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') ='"+dateStr+"' or to_char(DEATH_DATE, 'yyyy/MM/dd') ='"+dateStr+"'\n" +
				") info\n" +
				"GROUP BY info.REFERRAL_HOSPITAL_CODE, info.HZ_DATE");
		return this.getMapList(sqlBuilder.toString(), new Criteria());
	}
    
    @Override
	public PageList<InpatientInfo> getInpatientPageList(Page page, Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder("select pre.REFERRAL_HOSPITAL_CODE,pre.ADMISSION_NO,pre.ehr_id,"
				+ " pre.name,pre.person_id,p.IDCARD idcard,pre.id"
				+ " from MS_INPATIENT_INFO pre "
				+ " LEFT JOIN v_phb_bi_person_info p on pre.person_id = p.ID");
		SqlBuilder.buildWhereStatement(OutpatientPrescription.class, sql, criteria);
//		SqlBuilder.buildOrderStatement(sql, "pre.INHOS_DATE desc");
		return this.getPageList(page, sql.toString(), criteria);
	}
}