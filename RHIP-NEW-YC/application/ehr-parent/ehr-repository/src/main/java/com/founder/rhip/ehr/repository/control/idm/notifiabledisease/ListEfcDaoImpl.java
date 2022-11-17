package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ListEfc;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implement of IdmListEfc
 * 
 */
@Repository("listEfcDao")
public class ListEfcDaoImpl extends AbstractDao<ListEfc, Integer> implements IListEfcDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
	 * 染病访视月报表-根据疾病编码、机构编码、年月统计密切接触者人数
	 * @param cr
	 * @return	List<InterviewStatisicsDto>
	 */
    public Integer getContactNumber(Criteria cr){
    	Integer size = 0;
    	List<ListEfc> list = new ArrayList<ListEfc>();
    	StringBuilder sql = new StringBuilder();
    	getInterviewSql(sql,cr);
    	list = getList(sql.toString());
    	if(ObjectUtil.isNotEmpty(list)){
    		size = list.size();
    	}
    	return size;
    }
 
	private void getInterviewSql(StringBuilder sql, Criteria cr){

		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object diseaseCode = cr.get("DISEASE_CODE");
		sql.append(" select ID from idm_list_efc where idm_id in(");
		sql.append(" select  event.id IDM_ID from IDM_STATUS_INFO status");
		sql.append(" left join idm_event_info event on status.id = event.status_id");
		sql.append(" left join idm_report report on report.idm_id = event.id ");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
		sql.append(fillDate + "'");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}
		sql.append(" AND substr(type,0,3) ='" + diseaseCode + "' ");
		sql.append(" and REPORT_STATUS = '2'");
		sql.append(" and idm_type = '1')");
	}
}