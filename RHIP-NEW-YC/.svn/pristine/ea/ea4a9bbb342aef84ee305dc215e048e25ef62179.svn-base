package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of StudyEvent
 * 
 */
@Repository("studyEventDao")
public class StudyEventDaoImpl extends AbstractDao<StudyEvent, Long> implements IStudyEventDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String FORMATER = "yyyy/mm/dd";
    
     
    /**
     * 获取检查的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getStudyInfoStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select t.hospital_code,t.inspection_item_code,"
    			+ " to_char(t.audit_date,'%2$s') audit_date, count(*) study_num"
    			+ " from ms_study_event t %1$s and t.inspection_item_code in ('CXR','ECG','BUS','CT') and t.audit_date is not null"
    			+ " group by t.hospital_code,t.inspection_item_code,to_char(t.audit_date,'%2$s')"
    			+ " order by t.hospital_code,t.inspection_item_code,to_char(t.audit_date,'%2$s')");
			
    		whereSql = String.format(whereSql, FORMATER, dateStr);
    		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
    		return this.getMapList(sql, new Criteria());
    }

	@Override
	public List<Map<String, Object>> getStudyEventMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder("select hospital_code,to_char(check_date, 'yyyy/MM/dd') rpDate, "
				+ "inspection_item_code examination_code, count(1) examination_num from ms_study_event  where inspection_item_code in('ECG','BUS')"
				+ " and to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by hospital_code, to_char(check_date, 'yyyy/MM/dd'),inspection_item_code");
		return getMapList(sqlBuilder.toString(), new Criteria());
	}
    
}