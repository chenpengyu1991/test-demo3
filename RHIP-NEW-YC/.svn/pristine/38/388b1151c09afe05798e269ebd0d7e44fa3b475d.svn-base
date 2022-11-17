package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of SurgeryInfo
 * 
 */
@Repository("surgeryInfoDao")
public class SurgeryInfoDaoImpl extends AbstractDao<SurgeryInfo, Long> implements ISurgeryInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String FORMATER = "yyyy/mm/dd";
    
    @Override
    public void updateOpEmHpMark() {
    	this.execute("update ms_surgery_info t set t.op_em_hp_mark = '1' where t.op_em_hp_mark is null and t.ehr_id like 'mz%'");
    	this.execute("update ms_surgery_info t set t.op_em_hp_mark = '3' where t.op_em_hp_mark is null and t.ehr_id like 'zy%'");
    }

	@Override
	public List<Map<String, Object>> getCureResultHosOperationStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select t.hospital_code,to_char (opertation_date, '%2$s')opertation_date,count (*)hos_op_count"
    			+ " from ms_surgery_info t "
    			+ "%1$s and ehr_id like 'zy%%' "
    			+ "group by t.hospital_code,to_char (opertation_date, '%2$s')");
			
		whereSql = String.format(whereSql, FORMATER, dateStr);
		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
		return this.getMapList(sql, new Criteria());
	}
    
}