package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;

/**
 * DAO implement of OutpatientPrescription
 * 
 */
@Repository("outpatientPrescriptionDao")
public class OutpatientPrescriptionDaoImpl extends AbstractDao<OutpatientPrescription, Long> implements IOutpatientPrescriptionDao {
    /**
     * 更新SQL
     */
    private static final String UPDATE_SQL = " MERGE INTO MS_OUTPATIENT_PRESCRIPTION P USING ("
    		+ " SELECT %1$s UPDATE_VALUE,EHR_ID,RECORD_NUMBER FROM MS_DRUG_USAGE "
    		+ " GROUP BY EHR_ID,RECORD_NUMBER"
    		+ " ) D ON (P.EHR_ID = D.EHR_ID AND P.RECORD_NUMBER= D.RECORD_NUMBER)"
    		+ " WHEN MATCHED THEN"
    		+ " UPDATE SET P.%2$s = D.UPDATE_VALUE"
    		+ " WHERE %2$s IS NULL AND D.UPDATE_VALUE IS NOT NULL";
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
	 * 更新冗余字段：处方品种数
	 *
	 * @return
	 * @author Ye jianfei
	 */
    @Override
    public int updateTotalCount(){
    	String sql = String.format(UPDATE_SQL,"COUNT(*)","PRESCRIPTION_TOTAL_COUNT");
    	return this.execute(sql);
    }
    
	/**
	 * 更新冗余字段：处方中药物使用最大剂量
	 *
	 * @return
	 * @author Ye jianfei
	 */
    @Override
    public int updateMaxDose(){
    	String sql = String.format(UPDATE_SQL,"MAX(DRUG_USE_TOTAL_DOSE)","PRESCRIPTION_MAX_DOSE");
    	return this.execute(sql);
    } 
    
	/**
	 * 更新冗余字段：处方中药物使用最大天数
	 *
	 * @return
	 * @author Ye jianfei
	 */
    @Override
    public int updateMaxUseDays(){
    	String sql = String.format(UPDATE_SQL,"MAX(DRUG_USE_DAYS)","PRESCRIPTION_MAX_USE_DAYS");
    	return this.execute(sql);
    }    
    
    /**
	 * 获取处方详细
	 *
	 * @param ehrId
	 * @param recordNumber
	 * @return
	 * @author Ye jianfei
	 */
    @Override
	public OutpatientPrescription getOutpatientPrescription(String ehrId,String recordNumber){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT pre.RECORD_NUMBER,pre.PRESCRIBE_DATE,pre.PRESCRIBE_ROOM_NAME");
		sql.append(",pre.PRESCRIBE_DOCTOR_NAME,pre.PRESCRIBE_DOCTOR_NO,pre.NAME,pre.GENDER,pre.AGE,pre.CM_TYPE");
		sql.append(" ,out.MEDICAL_COST_PAY_WAY FROM MS_OUTPATIENT_PRESCRIPTION pre");
		sql.append(" LEFT JOIN MS_OUTPATIENT_INFO out ON (pre.EHR_ID = out.EHR_ID ");
		sql.append(" AND pre.RECORD_NUMBER = out.RECORD_NUMBER)");
		Criteria ca = new Criteria("pre.EHR_ID",ehrId);
		ca.add("pre.RECORD_NUMBER",recordNumber);
		SqlBuilder.buildWhereStatement(OutpatientPrescription.class, sql, ca) ;
		return get(sql.toString(),ca);
	}
    
    @Override
    public void updateOpEmHpMark() {
    	this.execute("update ms_outpatient_prescription t set t.op_em_hp_mark = '1' where t.op_em_hp_mark is null and t.ehr_id like 'mz%'");
    	this.execute("update ms_outpatient_prescription t set t.op_em_hp_mark = '3' where t.op_em_hp_mark is null and t.ehr_id like 'zy%'");
    }

	@Override
	public List<Map<String,Object>> getPrescriptionStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT T.HOSPITAL_CODE CODE,TO_CHAR(T.PRESCRIBE_DATE, 'yyyy/MM/dd') DT, SUM(DECODE(T.IF_CHARGE,'1',1,0)) N1, SUM(DECODE(T.IF_DISPENSE,'1',1,0)) N2,SUM(DECODE(T.ANTIBIOTIC_FLAG,'1',1,0)) N3,COUNT(1) N4 FROM MS_OUTPATIENT_PRESCRIPTION T WHERE TO_CHAR(T.GATHER_DATE, 'yyyy/MM/dd')='");
		sqlBuilder.append(dateStr).append("' GROUP BY T.HOSPITAL_CODE, TO_CHAR(T.PRESCRIBE_DATE, 'yyyy/MM/dd') ");
		return getMapList(sqlBuilder.toString(), (Criteria) null);
	}

	@Override
	public PageList<OutpatientPrescription> getOutpatientPrescriptionList(Page page, Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder("select pre.hospital_code,pre.outpatient_no,pre.ehr_id,pre.record_number,"
				+ " pre.name,pre.person_id,p.IDCARD idcard,pre.PRESCRIBE_DATE "
				+ " from MS_OUTPATIENT_PRESCRIPTION pre "
				+ " LEFT JOIN v_phb_bi_person_info p on pre.person_id = p.ID");
		SqlBuilder.buildWhereStatement(OutpatientPrescription.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "pre.PRESCRIBE_DATE desc");
		return this.getPageList(page, sql.toString(), criteria);
	}

    @Override
    public List<Map<String, Object>> getPrescriptionSummary(Criteria ca) {
        StringBuilder  sql = new StringBuilder();
        sql.append("SELECT \n");
        sql.append("	HOSPITAL_CODE\n");
        sql.append("	,SUM(PRESCRIPTION_TOTAL_COST) PRESCRIPTION_TOTAL_COST\n");
        sql.append("	,COUNT(1) PRESCRIPTION_COUNT\n");
        sql.append("	,MAX(PRESCRIPTION_TOTAL_COST) PRESCRIPTION_MAX_COST\n");
        sql.append("FROM MS_OUTPATIENT_PRESCRIPTION\n");
        SqlBuilder.buildWhereStatement(OutpatientPrescription.class, sql, ca) ;
        sql.append("GROUP BY HOSPITAL_CODE\n");
        sql.append("ORDER BY PRESCRIPTION_TOTAL_COST DESC");
        return this.getMapList(sql.toString(),ca);
    }
}