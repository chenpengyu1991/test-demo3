package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.idm.*;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DAO implement of IdmStatusInfo
 * 
 */
@Repository("idmStatusInfoDao")
public class IdmStatusInfoDaoImpl extends AbstractDao<IdmStatusInfo, Long> implements IIdmStatusInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	@Override
	public int updateStatus(IdmStatusInfo statusInfo, Criteria cr){
		Parameters parameters = new Parameters();
		String pixId = statusInfo.getPixId();
		Long personId = statusInfo.getPersonId();
		Integer specialStatus = statusInfo.getSpecialStatus();
		Integer reportStatus = statusInfo.getReportStatus();
		String currentUnit = statusInfo.getCurrentUnit();
		String currentTown = statusInfo.getCurrentTown();
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		Integer logOff = statusInfo.getLogoff();
		if(StringUtil.isNotEmpty(pixId)){
			if(pixId.equals("-1")){
				parameters.add("PIX_ID", null);
			}else{
				parameters.add("PIX_ID", pixId);
			}
		}
		if(ObjectUtil.isNotEmpty(personId)){
			parameters.add("PERSON_ID", personId);
		}		
		if(ObjectUtil.isNotEmpty(specialStatus)){
			parameters.add("SPECIAL_STATUS", specialStatus);
		}
		if(ObjectUtil.isNotEmpty(reportStatus)){
			parameters.add("REPORT_STATUS", reportStatus);
		}
		if(ObjectUtil.isNotEmpty(currentUnit)){
			parameters.add("CURRENT_UNIT", currentUnit);
		}
		if(ObjectUtil.isNotEmpty(currentTown)){
			parameters.add("CURRENT_TOWN", currentTown);
		}	
		if(ObjectUtil.isNotEmpty(logOff)){
			parameters.add("LOGOFF", logOff);
		}
		parameters.add("TYPE", statusInfo.getType());
		return update(parameters,cr);
	}

    @Override
    public int updateAssignment(IdmStatusInfo statusInfo, Criteria cr){
        Parameters parameters = new Parameters();
        parameters.add("ASSIGNMENT_STATUS", statusInfo.getAssignmentStatus());
        parameters.add("ASSIGNED_TO_UNIT", statusInfo.getAssignedToUnit());
        parameters.add("CURRENT_UNIT", statusInfo.getCurrentUnit());
        return update(parameters,cr);
    }




	@Override
    public int updateCaseStatus(IdmStatusInfo statusInfo, Criteria cr){
        Parameters parameters = new Parameters();
        parameters.add("CASE_STATUS", statusInfo.getCaseStatus());
        return update(parameters,cr);
    }

    /**
     * 获取直报中传染病是麻风 还没有填写麻风疑似报卡的人数
     * @param criteria
     * @return
     */
    public int getNotReportLeprosyCount(Criteria criteria) {
    	StringBuilder sql = new StringBuilder();
		sql.append(" select count(status.id) notd from idm_status_info status");
		sql.append(" left join idm_event_info event on status.id = event.status_id");
		sql.append(" left join idm_report re on re.idm_id = event.id");
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria);
		
		Map<String, Object> map = this.getMap(sql.toString(), criteria);
		return map != null ? ((BigDecimal)map.get("notd")).intValue(): 0;
    }
    
	/* 
	 * 分页查询疟疾血检登记
	 * @author yejianfei 20130507
	 */
	@Override
	public PageList<IdmStatusInfo> findRegisterList(Page page, Criteria criteria) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  drugreg.ID D_ID,epidemicfocus.ID E_ID,restdrugreg.ID R_ID,status.ID IDM_ID,status.LOGOFF,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID, ");
        sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.float_population,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
        sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" attc.PATHOGENESIS_DATE, ");
		sql.append(" cas.ACCEPT_UNIT,cas.ACCEPT_TOWN, cas.report_Org,");
		sql.append(" dia.TENTATIVE_DIAGNOSIS,");
		sql.append(" lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
		sql.append(" LEFT JOIN IDM_ATTACK_CONDITION attc ON event.ID = attc.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );	
		sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );	
		/*疟疾-服药登记*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '1004') drugreg ON event.status_id = drugreg.status_id");
		/*疟疾-疫点处理*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '1005') epidemicfocus ON event.status_id = epidemicfocus.status_id");
		/*休止期间日疟服药登记*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '1006') restdrugreg ON event.status_id = restdrugreg.status_id");
		
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF,status.SPECIAL_STATUS ASC,lab.TEST_DT DESC ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			MalariaQueryDto dto = this.get(map, MalariaQueryDto.class);
			status.setMalariaQueryDto(dto);
			list.add(status);
		}
		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;	
	}

    public List<IdmStatusInfo> findRegisterList(Criteria criteria){
        List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
        Object eventIds = criteria.get("EVENT_ID");
        Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID, ");
        sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
        sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
        sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
        sql.append(" attc.PATHOGENESIS_DATE, ");
        sql.append(" dia.TENTATIVE_DIAGNOSIS, ");
        sql.append(" cas.ACCEPT_UNIT,cas.ACCEPT_TOWN, ");
        sql.append(" cas.MODIFY_RESPONDENTS,cas.MODIFY_SURVEY_ORG,cas.MODIFY_SURVEY_DATE, ");
        sql.append(" lab.TEST_DT,lab.TEST_RESULT,lab.TEST_USER,lab.OTHER_RESULT FROM IDM_STATUS_INFO status ");
        sql.append(getEventInfoSql(statusCr));
        sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
        sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );
        sql.append(" LEFT JOIN IDM_ATTACK_CONDITION attc ON event.ID = attc.IDM_ID" );
        sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );
        SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
        SqlBuilder.buildOrderStatement(sql, " status.SPECIAL_STATUS ASC,lab.TEST_DT DESC ");
        List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
        for (Map<String, Object> map : maps) {
            IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
            MalariaQueryDto dto = this.get(map, MalariaQueryDto.class);
            status.setMalariaQueryDto(dto);
            list.add(status);
        }
        return list;
    }

	@Override
	public List<IdmStatusInfo> findTreatList(Criteria criteria, Criteria statusCr, Order order) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(statusCr)) {
			statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
		}
/*
		sql.append("SELECT status.ID ,status.SPECIAL_STATUS ,status.IDM_TYPE ,event.ID ,status.place_status ,status.logoff ,");
		sql.append(" gen.NAME,gen.GENDER,gen.AGE,gen.IDCARD,gen.PHONE_NUMBER, gen.float_population,gen.pa_address, gen.hr_address,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.register_num, caseInfo.Transfer_Treatment_Dt, caseInfo.TRANSFER_TREATMENT_DOCTOR, ");
		sql.append(" caseInfo.MODIFY_SURVEY_ORG,caseInfo.MODIFY_SURVEY_DATE,status.CURRENT_UNIT,");
		sql.append(" dia.diagnosis_Type,dia.LAST_DIAGNOSIS,dia.DIAGNOSIS_ACCORDING,dia.DIAGNOSIS_REASON_MULTI,dia.DIAGNOSIS_OTHER,dia.OTHER,");
		sql.append(" clinical.ORIGINAL_SYMPTOM,dia.TENTATIVE_DIAGNOSIS,dia.DIAGNOSIS_REASON,");
		sql.append(" other.CASE_SOURCE,other.CASE_TYPE,other.MANAGE_TYPE,other.THIS_TYPE,other.THIS_DT,other.CHEMOTHERAPY, ");
		sql.append(" lab.CHEST_XRAYS, lab.PHLEGM_PCR, exp.HANDLING_WAY ");
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
		sql.append(" LEFT JOIN Idm_Clinical_Manifestations clinical on event.ID = clinical.IDM_ID");
		sql.append(" LEFT JOIN Idm_Diagnosis dia on event.ID = dia.IDM_ID");
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID" );
		sql.append(" LEFT JOIN Idm_Other_Condition other on event.ID = other.IDM_ID");
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE lab on event.ID = lab.IDM_ID");
		sql.append(" LEFT JOIN IDM_EXPOSURE_HISTORY exp on event.ID = exp.IDM_ID");*/
		this.getTreatmentSql(sql, statusCr);
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("status.logoff", true);
			order.asc("status.SPECIAL_STATUS");
			order.asc("status.PLACE_STATUS");
			order.desc("caseInfo.MODIFY_SURVEY_DATE");
		}
		sql.append(order.toString());
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			TbQueryDto tbDto = this.get(map, TbQueryDto.class);
			status.setTbDto(tbDto);
			list.add(status);
		}

		return list;
	}

	
	/**
	 * 查询结核病列表  专用病历 管理卡
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<IdmStatusInfo> findTreatmentList(Page page, Criteria criteria, Criteria statusCr, Order order,String firstVist) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(statusCr)) {
			statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
		}
		this.getTreatmentSql(sql, statusCr);
		//根据管理机构查询
		String orgCode = null;
		if(ObjectUtil.isNotEmpty(criteria.get("other.orgCode"))){
			orgCode = (String)criteria.get("other.orgCode");
		}

		if(ObjectUtil.isNotEmpty(orgCode)){
			sql.append(" RIGHT JOIN ").append("BI_PERSON_INFO peron on peron.INPUT_ORGAN_CODE = '").append(orgCode).append("' and gen.IDCARD =  peron.IDCARD");
		}

		criteria.remove("other.orgCode");
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据

		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;

//		if(ObjectUtil.isNotEmpty(orgCode)){
//			sql.append(" AND ").append("status.CURRENT_UNIT = '").append(orgCode).append("'");
//		}
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("status.logoff", true);
			order.asc("status.SPECIAL_STATUS");
			order.asc("status.PLACE_STATUS");
			order.desc("caseInfo.MODIFY_SURVEY_DATE");
		}
		sql.append(order.toString());

		//是否首次随访 选择是
		if("1".equals(firstVist)){
			sql.insert(0,"SELECT * FROM \n" + "(");
			String str = ") t2  " +
					"inner  join  (\n" +
					"\tSELECT IDM_ID , FIRST_VIST\n" +
					"\tFROM IDM_LIST_SR\n" +
					"\tWHERE  FIRST_VIST = '1'\n" +
					") t3\n" +
					"ON t2.SINGLE_ID = t3.IDM_ID";
			sql.append(str);
		}
		//SqlBuilder.buildOrderStatement(sql, " status.SPECIAL_STATUS asc,status.PLACE_STATUS asc,caseInfo.MODIFY_SURVEY_DATE DESC ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			TbQueryDto tbDto = this.get(map, TbQueryDto.class);
			status.setTbDto(tbDto);
			list.add(status);
		}

		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;
	}
	@Override
	public List<IdmStatusInfo> findTreatmentList(Criteria criteria, Criteria statusCr, Order order) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(statusCr)) {
			statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
		}
		this.getTreatmentSql(sql, statusCr);
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("status.logoff", true);
			order.asc("status.SPECIAL_STATUS");
			order.asc("status.PLACE_STATUS");
			order.desc("caseInfo.MODIFY_SURVEY_DATE");
		}
		sql.append(order.toString());
		//SqlBuilder.buildOrderStatement(sql, " status.SPECIAL_STATUS asc,status.PLACE_STATUS asc,caseInfo.MODIFY_SURVEY_DATE DESC ");
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			TbQueryDto tbDto = this.get(map, TbQueryDto.class);
			status.setTbDto(tbDto);
			list.add(status);
		}
		return list;
	}

	public List<Map<String, Object>> downTreatmentList(Criteria criteria, Criteria statusCr, Order order){
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(statusCr)) {
			statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
		}
		this.getTreatmentSql(sql, statusCr);
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("status.logoff", true);
			order.asc("status.SPECIAL_STATUS");
			order.asc("status.PLACE_STATUS");
			order.desc("caseInfo.MODIFY_SURVEY_DATE");
		}
		sql.append(order.toString());
		List<Map<String, Object>> mapList = this.getMapList(sql.toString(), criteria);
		return mapList;
	}

    //统计用-- 管理
    public PageList<IdmStatusInfo> findMgntList(Page page, Criteria criteria, Criteria statusCr){
        List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
        StringBuilder sql = new StringBuilder();
        if (ObjectUtil.isNullOrEmpty(statusCr)) {
            statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
        }
        String town = (String) criteria.get("town");
        String village = (String) criteria.get("village");
        criteria.remove("town");
        criteria.remove("village");
        
        sql.append(" select gen.NAME, gen.GENDER, gen.AGE, gen.PATOWN_SHIP, gen.PASTREET, gen.PAHOUSE_NUMBER, ");
        sql.append(" other.THIS_TYPE, other.This_Type_1 AS THIS_TYPE_F, other.THIS_DT, other.MANAGE_TYPE, other.OUTCOME_CODE, other.Chemotherapy, other.Chemotherapy_1 AS CHEMOTHERAPY_F, other.Chemotherapy_2 AS CHEMOTHERAPY_S, other.Chemotherapy_3 AS CHEMOTHERAPY_T, other.Chemotherapy_Other, other.STOP_REASON_DT,");
        sql.append(" SP.SPUTUM_RESULT_2 AS SPUTUM_RESULT_S, SP.SPUTUM_RESULT_5 AS SPUTUM_RESULT_FI, SP.SPUTUM_RESULT_6 AS SPUTUM_RESULT_SI, SP.SPUTUM_RESULT_8 AS SPUTUM_RESULT_E");
        sql.append(" FROM IDM_STATUS_INFO status ");
        sql.append(getEventInfoSql(statusCr));
        sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
        sql.append(" LEFT JOIN Idm_Other_Condition other on event.ID = other.IDM_ID ");
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID ");
        if(StringUtil.isNotEmpty(town) || StringUtil.isNotEmpty(village)){
        	sql.append(" LEFT JOIN MDM_ORGANIZATION org ON org.organ_code = status.CURRENT_UNIT ");
        }
        sql.append(" LEFT JOIN ( SELECT T.IDM_ID, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '2', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_2, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '5', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_5, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '6', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_6, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '8', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_8 " );
        sql.append(" FROM IDM_LIST_AS T " );
        sql.append(" GROUP BY T.IDM_ID " );
        sql.append(" )SP ON event.ID = SP.IDM_ID " );
        SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
        if(StringUtil.isNotEmpty(town)){
        	sql.append(" and org.gb_code='" + town + "' ");
        }
        if(StringUtil.isNotEmpty(village)){
        	sql.append(" and (org.organ_code='" + village + "' or org.PARENT_CODE ='" + village + "' )");
        }
        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
        for (Map<String, Object> map : maps.getList()) {
            IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
//                    com.founder.fasf.beans.BeanUtil.getBean(IdmStatusInfo.class, map);
            TbQueryDto tbDto = this.get(map, TbQueryDto.class);
//                    com.founder.fasf.beans.BeanUtil.getBean(TbQueryDto.class, map);
            status.setTbDto(tbDto);
            list.add(status);
        }

        PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
        result.setList(list);
        result.setPage(page);
        return result;
    }

    public List<TbQueryDto> findMgntListTotal(Criteria criteria, Criteria statusCr){
        List<TbQueryDto> list = new ArrayList<TbQueryDto>();
        StringBuilder sql = new StringBuilder();
        if (ObjectUtil.isNullOrEmpty(statusCr)) {
            statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
        }
        sql.append(" select gen.NAME, gen.GENDER, gen.AGE, gen.PATOWN_SHIP, gen.PASTREET, gen.PAHOUSE_NUMBER, ");
        sql.append(" other.THIS_TYPE, other.This_Type_1 AS THIS_TYPE_F, other.THIS_DT, other.MANAGE_TYPE, other.OUTCOME_CODE, other.Chemotherapy, other.Chemotherapy_1 AS CHEMOTHERAPY_F, other.Chemotherapy_2 AS CHEMOTHERAPY_S, other.Chemotherapy_3 AS CHEMOTHERAPY_T, other.Chemotherapy_Other, other.STOP_REASON_DT, ");
        sql.append(" SP.SPUTUM_RESULT_2 AS SPUTUM_RESULT_S, SP.SPUTUM_RESULT_5 AS SPUTUM_RESULT_FI, SP.SPUTUM_RESULT_6 AS SPUTUM_RESULT_SI, SP.SPUTUM_RESULT_8 AS SPUTUM_RESULT_E");
        sql.append(" FROM IDM_STATUS_INFO status ");
        sql.append(getEventInfoSql(statusCr));
        sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
        sql.append(" LEFT JOIN Idm_Other_Condition other on event.ID = other.IDM_ID ");
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID ");
        sql.append(" LEFT JOIN ( SELECT T.IDM_ID, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '2', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_2, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '5', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_5, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '6', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_6, ");
        sql.append(" SUM(decode(T.MONTH_SEQ, '8', T.SPUTUM_RESULT,null)) AS SPUTUM_RESULT_8 " );
        sql.append(" FROM IDM_LIST_AS T " );
        sql.append(" GROUP BY T.IDM_ID " );
        sql.append(" )SP ON event.ID = SP.IDM_ID " );
        SqlBuilder.buildWhereStatement(TbQueryDto.class, sql, criteria) ;
        List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
        for (Map<String, Object> map : maps) {
            IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
            TbQueryDto tbDto = this.get(map, TbQueryDto.class);
            list.add(tbDto);
        }
        return list;
    }

    //统计用
    public List<TbQueryDto> getTbList(Criteria criteria, Criteria statusCr){
        List<TbQueryDto> list = new ArrayList<TbQueryDto>();
        StringBuilder sql = new StringBuilder();
        if (ObjectUtil.isNullOrEmpty(statusCr)) {
            statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
        }

        this.getTreatmentSql(sql, statusCr);
        criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
        SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
        SqlBuilder.buildOrderStatement(sql, " status.SPECIAL_STATUS  asc ,caseInfo.MODIFY_SURVEY_DATE DESC ");
        List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
        for (Map<String, Object> map : maps) {
            IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
            TbQueryDto tbDto = this.get(map, TbQueryDto.class);
            list.add(tbDto);
        }
        return list;
    }
	
	/**
	 * 查询结核病追踪单
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<IdmStatusInfo> findTraceList(Page page, Criteria criteria) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		this.getTraceSql(sql, statusCr);
		
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria);
		/*预约时间 系统自动计算为开转诊单的后一天 */
		sql.append(" and trunc(sysdate)-trunc(caseInfo.Transfer_Treatment_Dt) > 1");
		SqlBuilder.buildOrderStatement(sql, " status.PLACE_STATUS asc ,caseInfo.Transfer_Treatment_Dt DESC");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			TbQueryDto tbDto = this.get(map, TbQueryDto.class);
			status.setTbDto(tbDto);
			list.add(status);
		}
	
		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;
	}
	
	/**
	 * 获取转诊后未到诊的人数
	 * @param criteria
	 * @return
	 */
	public int getNotSeeDoctorCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		sql.append("SELECT count(status.ID) notSeeDoctorCount");
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSql(statusCr));
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID" );
		
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria);
		/*预约时间 系统自动计算为开转诊单的后一天 */
		sql.append(" and trunc(sysdate)-trunc(caseInfo.Transfer_Treatment_Dt) > 1");
		//this.get(sql.toString(), criteria);
		Map<String, Object> map = this.getMap(sql.toString(), criteria);
		
		return map != null ? ((BigDecimal)map.get("notSeeDoctorCount")).intValue(): 0;
		
	}
	/**
	 * 结核病列表  专用病历 管理卡 sql形成
	 * @param sql
	 * @param statusCr
	 */
	private void getTreatmentSql(StringBuilder sql, Criteria statusCr) {
		sql.append("SELECT status.ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID,status.place_status,status.logoff," +
				"status.ndy_flag,status.DANGER_FLAG1,status.DANGER_FLAG2,status.DANGER_FLAG3,status.DANGER_FLAG4,status.DANGER_FLAG5,");
		sql.append(" gen.NAME,gen.GENDER,gen.AGE,gen.IDCARD,gen.PHONE_NUMBER, gen.float_population,gen.pa_address, gen.hr_address,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.register_num, caseInfo.Transfer_Treatment_Dt, caseInfo.TRANSFER_TREATMENT_DOCTOR, ");
		sql.append(" caseInfo.MODIFY_SURVEY_ORG,caseInfo.MODIFY_SURVEY_DATE,status.CURRENT_UNIT,");
        sql.append(" dia.diagnosis_Type,dia.LAST_DIAGNOSIS,dia.DIAGNOSIS_ACCORDING,dia.DIAGNOSIS_REASON_MULTI,dia.DIAGNOSIS_OTHER,dia.OTHER,");
        sql.append(" clinical.ORIGINAL_SYMPTOM,dia.TENTATIVE_DIAGNOSIS,dia.DIAGNOSIS_REASON,");
        sql.append(" other.CASE_SOURCE,other.CASE_TYPE,other.MANAGE_TYPE,other.THIS_TYPE,other.THIS_DT,other.CHEMOTHERAPY, ");
        sql.append(" lab.CHEST_XRAYS, lab.PHLEGM_PCR, exp.HANDLING_WAY ");
        sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
		sql.append(" LEFT JOIN Idm_Clinical_Manifestations clinical on event.ID = clinical.IDM_ID");
		sql.append(" LEFT JOIN Idm_Diagnosis dia on event.ID = dia.IDM_ID");
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID" );
		sql.append(" LEFT JOIN Idm_Other_Condition other on event.ID = other.IDM_ID");
        sql.append(" LEFT JOIN IDM_LAB_EXAMINE lab on event.ID = lab.IDM_ID");
        sql.append(" LEFT JOIN IDM_EXPOSURE_HISTORY exp on event.ID = exp.IDM_ID");
	}
	
	/**
	 * 结核病追踪单sql
	 * @param sql
	 * @param statusCr
	 */
	private void getTraceSql(StringBuilder sql, Criteria statusCr) {
		sql.append("SELECT status.ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID,status.logoff,");
		sql.append(" gen.NAME,gen.GENDER,gen.AGE,gen.IDCARD,gen.PHONE_NUMBER, gen.float_population,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,status.place_Status, gen.pa_address, gen.hr_address,");
		sql.append(" caseInfo.Transfer_Treatment_Dt, trace.transfer_days,");
		sql.append(" trunc(sysdate)-trunc(caseInfo.Transfer_Treatment_Dt)-1 not_See_Day");
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID");
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID");
		sql.append(" LEFT JOIN Idm_List_Tr trace ON event.ID = trace.IDM_ID and trace.transfer_dt is not null");
	}
	
	/**
	 * 存在STATUS_ID相同的多条记录,根据EVENT_ID号过滤唯一
	 * criteria： EVENT_ID IN ('1001')
	 * ca.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.M_BlOOD.getValue()});
	 * @param criteria
	 */	
	private String getEventInfoSql(Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append(" LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(")) event ON status.ID = event.STATUS_ID " );
		return sql.toString();
	}

	/**
	 * 专项，需要用到个案填写的信息IDM_EVENT_INFO表应该取max
	 * 存在STATUS_ID相同的多条记录,根据EVENT_ID号过滤唯一
	 * criteria： EVENT_ID IN ('1001')
	 * ca.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.M_BlOOD.getValue()});
	 * @param criteria
	 */	
	private String getEventInfoSpecialSql(Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append(" LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(")) event ON status.ID = event.STATUS_ID " );
		return sql.toString();
	}

	/**
	 * 分页查询血吸虫监测登记
	 * @param page
	 * @param criteria
	 */		
	@Override
	public PageList<IdmStatusInfo> findSchRegisterList(Page page, Criteria criteria) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" lab.DDIA_DT,lab.DDIA,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );	
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC ");
	
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			status.setSchDto(dto);
			list.add(status);
		}
		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;	
	}

	/**
	 * 查询血吸虫监测登记
	 * @param criteria
	 */	
	@Override
	public List<SchistosomeQueryDto> findSchRegisterList(Criteria criteria) {
		List<SchistosomeQueryDto> list = new ArrayList<SchistosomeQueryDto>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" lab.SAMPLE_RESOURCE,lab.IHA_DT,lab.IHA_CHECK,lab.DDIA_DT,lab.DDIA,lab.COPT_DT,lab.COPT,lab.STOOL_DT,lab.STOOL ");		
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );	
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.SPECIAL_STATUS ASC,cas.MODIFY_DT DESC ");
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			list.add(dto);
		}
		return list;
	}
	
	/**
	 * 分页查询血吸虫个案调查
	 * @param page
	 * @param criteria
     * @return PageList<IdmStatusInfo>
	 */		
	@Override
	public PageList<IdmStatusInfo> findSchCaseList(Page page, Criteria criteria) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  case.ID CASE_ID,status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,status.LOGOFF,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" dia.TRANSFER_TREATMENT_ACCORDING TREATMENT,");
		sql.append(" lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
        sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );		
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );	
		/*已建立个案调查*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '3002') case ON event.status_id = case.status_id");		
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF,status.SPECIAL_STATUS ASC,cas.MODIFY_DT DESC ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			status.setSchDto(dto);
			list.add(status);
		}
		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;	
	}
	
	/**
	 * 查询血吸虫个案调查
	 * @param criteria
     * @return List<IdmStatusInfo>
	 */		
	@Override
	public List<IdmStatusInfo> findSchCaseList(Criteria criteria) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,status.LOGOFF,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" dia.TRANSFER_TREATMENT_ACCORDING TREATMENT,");
		sql.append(" lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
        sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );		
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );	
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF,status.SPECIAL_STATUS ASC,cas.MODIFY_DT DESC ");
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			status.setSchDto(dto);
			list.add(status);
		}
		return list;	
	}	

    public PageList<IdmStatusInfo> findFilRegList(Page page, Criteria criteria, boolean isStandard){
        List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
        Object eventIds = criteria.get("E.EVENT_ID");
        Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, S.LOGOFF, S.CURRENT_UNIT, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC, I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
        sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L, ");
        sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID ");
        sql.append(" AND ").append(statusCr.toSql(ClassMetadata.getMetadata(IdmStatusInfo.class), ":")).toString();
        sql.append("  )) E ");
        sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+) ");
        sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(IdmStatusInfo.class), ":")).toString();
        if(isStandard){
            sql.append(" AND (A.LYMPHEDEMA = 1 OR A.CHYLURIA = 1) ");
        }
        SqlBuilder.buildOrderStatement(sql, " S.LOGOFF, S.ID DESC");


        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
        for (Map<String, Object> map : maps.getList()) {
            IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
            FilariasisQueryDto dto = this.get(map, FilariasisQueryDto.class);
            status.setFilDto(dto);
            list.add(status);
        }
        PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
        result.setList(list);
        result.setPage(page);
        return result;

    }
    
    /**
	 * 查询麻风列表信息
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<IdmStatusInfo> findLeprosyList(Page page, Criteria criteria, Order order) {
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		StringBuilder sql = new StringBuilder();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		this.getLeprosySql(sql, statusCr);
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		sql.append(order.toString());
		//SqlBuilder.buildOrderStatement(sql, " caseInfo.REVIEW_RESULT DESC,  caseInfo.MODIFY_SURVEY_DATE DESC ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			LeprosyQueryDto leprosyDto = this.get(map, LeprosyQueryDto.class);
			status.setLeprosyQueryDto(leprosyDto);
			list.add(status);
		}

		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;	
	}
	
	/**
	 * 麻风 sql形成
	 * @param sql
	 * @param statusCr
	 */
	private void getLeprosySql(StringBuilder sql, Criteria statusCr) {
		sql.append("SELECT status.ID,status.SPECIAL_STATUS,status.IDM_TYPE,event.ID SINGLE_ID,status.place_status,status.logoff,");
		sql.append(" gen.NAME,gen.GENDER,gen.AGE,gen.birthday,gen.IDCARD,gen.PHONE_NUMBER, gen.float_population,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,caseInfo.REVIEW_RESULT,gen.pa_address, gen.hr_address,");
		sql.append(" caseInfo.MODIFY_SURVEY_ORG,caseInfo.MODIFY_SURVEY_DATE,caseInfo.MODIFY_RESPONDENTS ");
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID" );
	}
	
    /**
	 * 分页查询晚血病人列表信息
	 * @param page
	 * @param criteria
	 * @return	PageList<IdmStatusInfo>
	 */
	public PageList<IdmStatusInfo> findAdvancedList(Page page, Criteria criteria){
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT nvl(survey.ID,0) SID,nvl(card.ID,0) CID,nvl(reexamine.ID,0) RID,status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,status.LOGOFF,status.CURRENT_UNIT,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" dia.TRANSFER_TREATMENT_ACCORDING TREATMENT,");
		sql.append(" lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
        sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );		
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );
		/*已建立复查登记*/
		sql.append(" LEFT JOIN (SELECT t5.ID,t5.status_id  FROM IDM_EVENT_INFO t5 WHERE t5.id IN(SELECT MAX(t6.id) FROM IDM_EVENT_INFO t6  WHERE t5.STATUS_ID=t6.STATUS_ID  AND EVENT_ID IN ('3006'))) reexamine ON event.status_id = reexamine.status_id");
		
		sql.append(" LEFT JOIN IDM_OTHER_CONDITION other ON reexamine.ID = other.IDM_ID" );			
		/*已建立晚血调查*/
		sql.append(" LEFT JOIN (SELECT t3.ID,t3.status_id  FROM IDM_EVENT_INFO t3 WHERE t3.id IN(SELECT MAX(t4.id) FROM IDM_EVENT_INFO t4  WHERE t3.STATUS_ID=t4.STATUS_ID  AND EVENT_ID IN ('3004'))) survey ON event.status_id = survey.status_id");
		sql.append(" LEFT JOIN IDM_OTHER_CONDITION otherSurvey ON survey.ID = otherSurvey.IDM_ID" );		
		/*已建立晚血管理卡*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '3005') card ON event.status_id = card.status_id");
		
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF,status.SPECIAL_STATUS ASC,survey.ID DESC,card.ID ASC,reexamine.ID ASC,cas.SURVEY_DATE DESC,status.id desc ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			status.setSchDto(dto);
			list.add(status);
		}
		PageList<IdmStatusInfo> result = new PageList<IdmStatusInfo>();
		result.setList(list);
		result.setPage(page);
		return result;			
	}
	
    /**
	 * 查询晚血病人列表信息
	 * @param criteria
	 * @return	List<IdmStatusInfo>
	 */
	@Override
	public List<IdmStatusInfo> findAdvancedList(Criteria criteria){
		List<IdmStatusInfo> list = new ArrayList<IdmStatusInfo>();
		Object eventIds = criteria.get("EVENT_ID");
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN,eventIds);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT nvl(survey.ID,0) SID,nvl(card.ID,0) CID,nvl(reexamine.ID,0) RID,status.ID IDM_ID,status.SPECIAL_STATUS,status.IDM_TYPE,status.LOGOFF,event.ID SINGLE_ID, ");
		sql.append(" gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER,");
		sql.append(" gen.PATOWN_SHIP,gen.PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS,");
		sql.append(" gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS,");
		sql.append(" dia.TRANSFER_TREATMENT_ACCORDING TREATMENT,");
		sql.append(" lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID" );
        sql.append(" LEFT JOIN IDM_DIAGNOSIS dia ON event.ID = dia.IDM_ID" );		
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID" );	
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID " );
		/*已建立晚血调查*/
		sql.append(" LEFT JOIN (SELECT t3.ID,t3.status_id  FROM IDM_EVENT_INFO t3 WHERE t3.id IN(SELECT MAX(t4.id) FROM IDM_EVENT_INFO t4  WHERE t3.STATUS_ID=t4.STATUS_ID  AND EVENT_ID IN ('3004'))) survey ON event.status_id = survey.status_id");
		/*已建立晚血管理卡*/
		sql.append(" LEFT JOIN (SELECT ID,status_id FROM IDM_EVENT_INFO WHERE EVENT_ID = '3005') card ON event.status_id = card.status_id");
		/*已建立复查登记*/
		sql.append(" LEFT JOIN (SELECT t5.ID,t5.status_id  FROM IDM_EVENT_INFO t5 WHERE t5.id IN(SELECT MAX(t6.id) FROM IDM_EVENT_INFO t6  WHERE t5.STATUS_ID=t6.STATUS_ID  AND EVENT_ID IN ('3006'))) reexamine ON event.status_id = reexamine.status_id");
		
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF,status.SPECIAL_STATUS ASC,survey.ID DESC,card.ID ASC,reexamine.ID ASC,cas.SURVEY_DATE DESC ");
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			IdmStatusInfo status = this.get(map, IdmStatusInfo.class);
			SchistosomeQueryDto dto = this.get(map, SchistosomeQueryDto.class);
			status.setSchDto(dto);
			list.add(status);
		}
		return list;			
	}	

	
    /**
	 * 汇总传染病访视月报表
	 * @param criteria
	 * @return	List<InterviewStatisicsDto>
	 */
	@Override
	public List<InterviewStatisicsDto> findInterviewList(Criteria criteria){
		List<InterviewStatisicsDto> list = new ArrayList<InterviewStatisicsDto>();
		StringBuilder sql = new StringBuilder();
		getInterviewSql(sql,criteria);
		
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		for (Map<String, Object> map : maps) {
			InterviewStatisicsDto dto = this.get(map, InterviewStatisicsDto.class);
			list.add(dto);
		}
		return list;			
	}
	
	private void getInterviewSql(StringBuilder sql, Criteria cr){

		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){
			sql.append(" select  SUM(results.REPORT_NUMBER) report_Number,");
			sql.append(" SUM(results.INTERVIEW_NUMBER) INTERVIEW_NUMBER,results.DISEASE_CODE,");
			sql.append(" SUM(results.IN_HOME_NUMBER) IN_HOME_NUMBER,SUM(results.IN_HOSPITAL_NUMBER) IN_HOSPITAL_NUMBER,");
			sql.append(" SUM(results.UNKNOWN_PERSON) UNKNOWN_PERSON,SUM(results.MISDIAGNOSE) MISDIAGNOSE,");
			sql.append(" SUM(results.INTERVIEW_OTHER) INTERVIEW_OTHER,SUM(results.VACCINATION_NUMBER) VACCINATION_NUMBER");
			sql.append(" from(");
		}
		sql.append(" select interview.REPORT_NUMBER,interview.INTERVIEW_NUMBER,interview.DISEASE_CODE,");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" interview.FILL_ORGAN_CODE,");
		}
		sql.append(" interview.IN_HOME_NUMBER,interview.IN_HOSPITAL_NUMBER,");
		sql.append(" sta.fill_Organ_Code fill_org_code,sta.fill_User_Id,sta.fill_dt,sta.UNKNOWN_PERSON,sta.MISDIAGNOSE,sta.INTERVIEW_OTHER,sta.VACCINATION_NUMBER,sta.OTHER from (");
		sql.append(" select ");
		sql.append(" TO_CHAR(idmreport.FILL_DATE,'yyyy/mm') FILL_DATE,");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" idmreport.FILL_ORGAN_CODE,");
		}
		sql.append(" count(idmreport.idm_id) report_Number,count(idmreport.idm_id) interview_Number,idmreport.disease_code,");
		sql.append(" sum(idmreport.inHome) IN_HOME_NUMBER,sum(idmreport.inHospital) IN_HOSPITAL_NUMBER FROM (");
		sql.append(" select  report.FILL_ORGAN_CODE,report.FILL_DATE,event.id IDM_ID ,substr(type,0,3) disease_Code,");
		sql.append(" (case fr.case_type when '1' THEN 1 ELSE 0 END) inHome,");
		sql.append(" (case fr.case_type when '2' THEN 1 ELSE 0 END) inHospital from IDM_STATUS_INFO status");
		sql.append(" left join idm_event_info event on status.id = event.status_id");
		sql.append(" left join (");
		sql.append(" SELECT fr1.case_type,fr1.id,fr1.idm_id,fr1.VISIT_DT FROM idm_list_fr fr1 WHERE (to_char(fr1.VISIT_DT,'yyyyMMdd')+ id)");
		sql.append(" IN(SELECT min(to_char(fr2.VISIT_DT,'yyyyMMdd')+ id) FROM idm_list_fr fr2  WHERE fr1.idm_id=fr2.idm_id)");
		sql.append(" )fr on event.id = fr.idm_id");
		sql.append(" left join idm_report report on report.idm_id = event.id ");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
		sql.append(fillDate + "'");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append("  AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		sql.append(" AND substr(type,0,3) in('203','215','213','207')");
		sql.append(" and REPORT_STATUS = '2'");
		sql.append(" and idm_type = '1')");
		sql.append(" idmreport");
		sql.append(" group by disease_code,TO_CHAR(FILL_DATE,'yyyy/mm')");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append("  ,FILL_ORGAN_CODE");
		}
		SqlBuilder.buildOrderStatement(sql, "disease_code ASC ");
		sql.append(" ) interview");
		sql.append(" left join idm_statistics sta on");
		sql.append(" (sta.DISEASE_CODE = interview.disease_code");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" and sta.FILL_ORGAN_CODE = interview.FILL_ORGAN_CODE");
		}
		sql.append(" and TO_CHAR(sta.FILL_DATE,'yyyy/mm') = interview.FILL_DATE");
		sql.append(" and sta.TYPE = 1)");
		
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){
			sql.append(" ) results");
			sql.append(" GROUP BY DISEASE_CODE");
			sql.append(" ORDER BY DISEASE_CODE ASC");
		}
	}
	
    /**
	 * 汇总细菌性痢疾流调月报表
	 * @param criteria
	 * @return	List<DysenteryStatisicsDto>
	 */
	@Override
	public List<DysenteryStatisicsDto> findDysenteryList(Criteria criteria){
		List<DysenteryStatisicsDto> list = new ArrayList<DysenteryStatisicsDto>();
		StringBuilder sql = new StringBuilder();
		getDysenterySql(sql,criteria,false);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,"213","2",false);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		for (Map<String, Object> map : maps) {
			DysenteryStatisicsDto dto = this.get(map, DysenteryStatisicsDto.class);
			list.add(dto);
		}
		return list;			
	}

    /**
	 * 汇总细菌性痢疾流调月报表--累计
	 * @param criteria
	 * @return	List<DysenteryStatisicsDto>
	 */
	@Override
	public DysenteryStatisicsDto findDysenteryTotal(Criteria criteria){
		DysenteryStatisicsDto dtoTotal = null;
		StringBuilder sql = new StringBuilder();
		getDysenterySql(sql,criteria,true);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,"213","2",true);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		for (Map<String, Object> map : maps) {
			if(ObjectUtil.isNullOrEmpty(dtoTotal)){
				dtoTotal = this.get(map, DysenteryStatisicsDto.class);
			}else{//手动填写的数据需要累加
				DysenteryStatisicsDto dto = this.get(map, DysenteryStatisicsDto.class);
				dtoTotal.setCulture(dtoTotal.getCulture() + dto.getCulture());
				dtoTotal.setWater(dtoTotal.getWater() + dto.getWater());
				dtoTotal.setFood(dtoTotal.getFood() + dto.getFood());
				dtoTotal.setContact(dtoTotal.getContact() + dto.getContact());
				dtoTotal.setUnspecified(dtoTotal.getUnspecified() + dto.getUnspecified());
				dtoTotal.setCall(dtoTotal.getCall() + dto.getCall());
				dtoTotal.setSelf(dtoTotal.getSelf() + dto.getSelf());
			}
		}
		if(ObjectUtil.isNullOrEmpty(dtoTotal)){//如果没有数据，生成一行空数据
			dtoTotal = new DysenteryStatisicsDto();
		}
		return dtoTotal;			
	}

    /**
	 * 汇总细菌性痢疾流调月报表--生成SQL
	 * @param sql
	 * @param cr
	 * @param summaryType,false:按月，true：累计
	 * @return	DysenteryStatisicsDto
	 */
	private void getDysenterySql(StringBuilder sql, Criteria cr, boolean summaryType){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){
			sql.append(" select  results.REPORT REPORT,");
			sql.append(" results.SURVEY SURVEY,results.DISEASE_CODE,");
			sql.append(" results.CATERING CATERING,results.ROUTINE ROUTINE,");
			sql.append(" results.NOT_DONE NOT_DONE,SUM(results.CULTURE) CULTURE,");
			sql.append(" SUM(results.WATER) WATER,SUM(results.FOOD) FOOD,");
			sql.append(" SUM(results.CONTACT) CONTACT,SUM(results.UNSPECIFIED) UNSPECIFIED,");
			sql.append(" SUM(results.CALL) CALL,SUM(results.SELF) SELF");
			sql.append(" from(");
		}		
		sql.append(" select dysentery.REPORT,dysentery.SURVEY,dysentery.DISEASE_CODE,");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" dysentery.FILL_ORGAN_CODE,");
		}
		sql.append(" dysentery.CATERING,dysentery.ROUTINE,dysentery.NOT_DONE,");
		sql.append(" sta.fill_Organ_Code fill_org_code,sta.fill_User_Id,sta.fill_dt,");
		sql.append(" nvl(sta.CULTURE,0) CULTURE,nvl(sta.WATER,0) WATER,nvl(sta.FOOD,0) FOOD,");
		sql.append(" nvl(sta.CONTACT,0) CONTACT,nvl(sta.UNSPECIFIED,0) UNSPECIFIED,nvl(sta.CALL,0) CALL,nvl(sta.SELF,0) SELF FROM");
		sql.append(" (SELECT ");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" idmreport.FILL_ORGAN_CODE,");
		}
		if(summaryType){
			sql.append(" TO_CHAR(idmreport.FILL_DATE,'yyyy') FILL_DATE,");
		}else {
			sql.append(" TO_CHAR(idmreport.FILL_DATE,'yyyy/mm') FILL_DATE,");
		}		
		sql.append(" COUNT(idmreport.IDM_ID) REPORT,");
		sql.append(" COUNT(idmreport.IDM_ID) SURVEY,");
		sql.append(" idmreport.DISEASE_CODE,");
		sql.append(" SUM(idmreport.CATERING) CATERING,");
		sql.append(" SUM(idmreport.ROUTINE) ROUTINE,");
		sql.append(" SUM(idmreport.NOT_DONE) NOT_DONE");
		sql.append(" FROM(");
		sql.append(" SELECT report.FILL_ORGAN_CODE,report.FILL_DATE,event.id IDM_ID ,");
		sql.append(" SUBSTR(type,0,3) DISEASE_CODE,");
		sql.append(" (CASE report.OCCUPATION WHEN 'CV020120206' THEN 1 ELSE 0 END) CATERING,");
		sql.append(" (CASE WHEN  lab.DEJECTA_LEUKOCYTE > '15' and lab.DEJECTA_ERYTHROCYTE is not null THEN 1 ELSE 0 END) ROUTINE,");
		sql.append(" (CASE WHEN  lab.DEJECTA_LEUKOCYTE is null ");
		sql.append(" and lab.DEJECTA_ERYTHROCYTE is null");
		sql.append(" and lab.AMOEBA_TROPHOZOITE_S is null");
		sql.append(" and lab.AMOEBA_TROPHOZOITE_B is null");
		sql.append(" and lab.STOOL_CULTURE is null THEN 1 ELSE 0 END) NOT_DONE");
		sql.append(" FROM IDM_STATUS_INFO status");
		sql.append(" LEFT JOIN idm_event_info event  ON status.id = event.status_id");
		sql.append(" LEFT JOIN idm_report report  ON report.idm_id = event.id");
		sql.append(" LEFT JOIN idm_lab_examine lab on lab.idm_id = event.id");
		sql.append(" WHERE type ='2131'");
		if(summaryType){
			sql.append(" AND TO_CHAR(FILL_DATE,'yyyy')='");
			sql.append(fillDate.toString().substring(0, 4) + "'");
		}else{
			sql.append(" AND TO_CHAR(FILL_DATE,'yyyy/MM')='");
			sql.append(fillDate + "'");
		}
		
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		sql.append(" and REPORT_STATUS = '2'");
		sql.append(" and idm_type = '1')");
		sql.append(" idmreport");
		sql.append(" group by disease_code");
		if(summaryType){
			sql.append(" ,TO_CHAR(FILL_DATE,'yyyy')");
		}else{
			sql.append(" ,TO_CHAR(FILL_DATE,'yyyy/mm')");
		}		
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" ,FILL_ORGAN_CODE");
		}
		sql.append(" ) dysentery");
		sql.append(" left join idm_statistics sta on");
		sql.append(" (sta.DISEASE_CODE = dysentery.disease_code");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" and sta.FILL_ORGAN_CODE = dysentery.FILL_ORGAN_CODE");
		}

		if(summaryType){
			sql.append(" and TO_CHAR(sta.FILL_DATE,'yyyy') = dysentery.FILL_DATE");
		}else{
			sql.append(" and TO_CHAR(sta.FILL_DATE,'yyyy/mm') = dysentery.FILL_DATE");
		}		
		sql.append(" and sta.TYPE = 2)");
		
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){
			sql.append(" ) results");
			sql.append(" GROUP BY DISEASE_CODE,REPORT,SURVEY,CATERING,ROUTINE,NOT_DONE");
			sql.append(" ORDER BY DISEASE_CODE ASC");
		}
	}	

    /**
	 * 汇总狂犬病防治月报表
	 * @param criteria
	 * @return	List<RabiesStatisicsDto>
	 */
	@Override
	public List<RabiesStatisicsDto> findRabiesList(Criteria criteria){
		List<RabiesStatisicsDto> list = new ArrayList<RabiesStatisicsDto>();
		StringBuilder sql = new StringBuilder();
		getRabiesSql(sql,criteria,false);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,"209","3",false);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		for (Map<String, Object> map : maps) {
			RabiesStatisicsDto dto = this.get(map, RabiesStatisicsDto.class);
			list.add(dto);
		}
		return list;			
	}

    /**
	 * 汇总狂犬病防治月报表-累计
	 * @param criteria
	 * @return	RabiesStatisicsDto
	 */
	@Override
	public RabiesStatisicsDto findRabiesTotal(Criteria criteria){
		RabiesStatisicsDto dtoTotal = null;
		StringBuilder sql = new StringBuilder();
		getRabiesSql(sql,criteria,true);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,"209","3",true);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		for (Map<String, Object> map : maps) {
			if(ObjectUtil.isNullOrEmpty(dtoTotal)){
				dtoTotal = this.get(map, RabiesStatisicsDto.class);
			}else{//手动填写的数据需要累加
				RabiesStatisicsDto dto = this.get(map, RabiesStatisicsDto.class);
				dtoTotal.setDisposeEpidemic(dtoTotal.getDisposeEpidemic() + dto.getDisposeEpidemic());
			}
		}
		if(ObjectUtil.isNullOrEmpty(dtoTotal)){
			dtoTotal = new RabiesStatisicsDto();
		}
		return dtoTotal;			
	}

    /**
	 * 汇总狂犬病防治月报表-生成SQL
	 * @param sql
	 * @param cr
	 * @param total:是否是累计
	 * @return	void
	 */
	private void getRabiesSql(StringBuilder sql, Criteria cr, boolean total){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){//如果不选机构需要合计所有机构的数据
			sql.append(" select  results.death_Toll death_Toll,");
			sql.append(" results.incidence incidence,results.DISEASE_CODE,");
			sql.append(" results.BITE_MANY,SUM(results.dispose_Epidemic) dispose_Epidemic");
			sql.append(" from(");
		}	
		sql.append(" select rabies.DISEASE_CODE, rabies.death_Toll,rabies.incidence,rabies.BITE_MANY,");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" rabies.FILL_ORGAN_CODE,");
		}
		sql.append(" sta.fill_Organ_Code fill_org_code,sta.fill_User_Id,sta.fill_dt,");
		sql.append(" nvl(sta.dispose_Epidemic,0) dispose_Epidemic,nvl(sta.rabies_Other,'') rabies_Other from");

		if(total){
			sql.append(" (SELECT TO_CHAR(idmreport.FILL_DATE,'yyyy') FILL_DATE,idmreport.disease_code,");
		}else{
			sql.append(" (SELECT TO_CHAR(idmreport.FILL_DATE,'yyyy/mm') FILL_DATE,idmreport.disease_code,");
		}		
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" idmreport.FILL_ORGAN_CODE,");
		}
		sql.append(" SUM(idmreport.BITE_MANY) BITE_MANY,");
		sql.append(" SUM(idmreport.death_Toll) death_Toll,SUM(idmreport.incidence) incidence FROM (");
		sql.append(" SELECT report.FILL_ORGAN_CODE,report.FILL_DATE,event.id IDM_ID ,");
		sql.append(" SUBSTR(type,0,3) DISEASE_CODE,");
		sql.append(" (CASE WHEN  attack.DIE_DT is not null THEN 1 ELSE 0 END) death_Toll,");
		sql.append(" (CASE WHEN  attack.PATHOGENESIS_DATE  is not null THEN 1 ELSE 0 END) incidence,");
		sql.append(" DECODE(CONCAT(route.bite_Total,CONCAT(route.what_Bite,route.die_Total)) ,null ,0,1) BITE_MANY");//一犬伤多人事件数
		sql.append(" FROM IDM_STATUS_INFO status");
		sql.append(" LEFT JOIN idm_event_info event  ON status.id = event.status_id");
		sql.append(" LEFT JOIN idm_report report  ON report.idm_id = event.id");
		sql.append(" LEFT JOIN idm_attack_Condition attack on attack.idm_id = event.id");
		sql.append(" LEFT JOIN IDM_INFECTION_SOURCE_ROUTE route on route.idm_id = event.id");

		if(total){
			sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy')='");
			sql.append(fillDate.toString().substring(0, 4) + "'");
		}else{
			sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
			sql.append(fillDate + "'");
		}		
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		sql.append(" AND substr(type,0,3) ='209'");
		sql.append(" and REPORT_STATUS = '2'");
		sql.append(" and idm_type = '1')");
		sql.append(" idmreport");

		if(total){
			sql.append(" group by disease_code,TO_CHAR(FILL_DATE,'yyyy')");
		}else{
			sql.append(" group by disease_code,TO_CHAR(FILL_DATE,'yyyy/mm')");
		}			
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" ,FILL_ORGAN_CODE");
		}
		sql.append(" ) rabies");
		sql.append(" left join idm_statistics sta on");
		sql.append(" (sta.DISEASE_CODE = rabies.disease_code");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" and sta.FILL_ORGAN_CODE = rabies.FILL_ORGAN_CODE");
		}

		if(total){
			sql.append(" and TO_CHAR(sta.FILL_DATE,'yyyy') = rabies.FILL_DATE");
		}else{
			sql.append(" and TO_CHAR(sta.FILL_DATE,'yyyy/mm') = rabies.FILL_DATE");
		}		
		sql.append(" and sta.TYPE = 3)");
		
		if(ObjectUtil.isNullOrEmpty(fillOrganCode)){
			sql.append(" ) results");
			sql.append(" GROUP BY DISEASE_CODE,BITE_MANY,DEATH_TOLL,INCIDENCE");
			sql.append(" ORDER BY DISEASE_CODE ASC");
		}
	}
	private void getStatisticsNoDataSql(StringBuilder sql, Criteria cr, String diseaseCode, String type, boolean total){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		sql.append(" select FILL_ORGAN_CODE,");
		sql.append(" sum(CULTURE) CULTURE,");
		sql.append(" sum(WATER) WATER,");
		sql.append(" sum(FOOD) FOOD,");
		sql.append(" sum(CONTACT) CONTACT,");
		sql.append(" sum(UNSPECIFIED) UNSPECIFIED,");
		sql.append(" sum(CALL) CALL,");
		sql.append(" sum(SELF) SELF,");
		sql.append(" sum(BITE_MANY) BITE_MANY,");
		sql.append(" sum(DISPOSE_EPIDEMIC) DISPOSE_EPIDEMIC,");
		sql.append(" sum(EFD_DISPOSE) EFD_DISPOSE,");	
		sql.append(" sum(EFD_INSULATE) EFD_INSULATE,");
		sql.append(" sum(DYSENTERY_DISPOSE) DYSENTERY_DISPOSE,");
		sql.append(" sum(DYSENTERY_INSULATE) DYSENTERY_INSULATE,");	
		sql.append(" sum(HFMD_GRAVE) HFMD_GRAVE,");
		sql.append(" sum(HFMD_DISPOSITION) HFMD_DISPOSITION,");
		sql.append(" sum(HFMD_AGGREGATION) HFMD_AGGREGATION,");	
		sql.append(" sum(HFMD_INVESTIGATION) HFMD_INVESTIGATION,");
		sql.append(" sum(HEV_FULMINANT) HEV_FULMINANT,");
		sql.append(" sum(HEV_DISPOSE) HEV_DISPOSE FROM");		
		sql.append(" (select *");
		sql.append(" from idm_statistics");
		if(total){
			sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy')='");
			sql.append(fillDate.toString().substring(0, 4) + "'");
		}else{
			sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
			sql.append(fillDate + "'");
		}		

		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		if(StringUtil.isNotEmpty(diseaseCode)){
			sql.append(" AND DISEASE_CODE ='" + diseaseCode + "'");
		}
		sql.append(" and TYPE = '" + type + "'");
		sql.append(" )group by");
		sql.append(" FILL_ORGAN_CODE");		
	}
	
    /**
	 * 汇总急性传染病防制月报表
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	@Override
	public List<AcuteStatisicsDto> findAcuteMonthList(Criteria criteria){
		List<AcuteStatisicsDto> list = new ArrayList<AcuteStatisicsDto>();
		StringBuilder sql = new StringBuilder();
		getAcuteMonthSql(sql,criteria,false);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,null,"4",false);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		Map<String,Integer> mapFirstKey = getFirstKeyMaps(criteria,1,false);
		
		for (Map<String, Object> map : maps) {
			AcuteStatisicsDto dto = this.get(map, AcuteStatisicsDto.class);
			Integer firstKey = mapFirstKey.get(dto.getFillOrganCode());
			if(ObjectUtil.isNotEmpty(firstKey)){
				dto.setFirstAndKey(firstKey);		
			}
			list.add(dto);
		}
		return list;			
	}

   /**
	 * 汇总急性传染病防制月报表-合计
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	@Override
	public AcuteStatisicsDto findAcuteMonthTotalList(Criteria criteria){
		AcuteStatisicsDto dto = new AcuteStatisicsDto();
		StringBuilder sql = new StringBuilder();
		getAcuteMonthSql(sql,criteria,true);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsNoDataSql(sql,criteria,null,"4",false);
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		Map<String,Integer> mapFirstKey = getFirstKeyMaps(criteria,1,true);
		for (Map<String, Object> map : maps) {
			dto = this.get(map, AcuteStatisicsDto.class);
			dto.setFillOrganCode("-1");//标记为合计
			Integer firstKey = mapFirstKey.get(dto.getFillOrganCode());
			if(ObjectUtil.isNotEmpty(firstKey)){
				dto.setFirstAndKey(firstKey);		
			}			
		}	
		
		return dto;			
	}
	
	private void getAcuteMonthSql(StringBuilder sql, Criteria cr, boolean isTotal){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		sql.append(" select");
		if(!isTotal){
			sql.append(" FILL_ORGAN_CODE,");
		}	
		sql.append(" INVESTIGATION, REGULATE_DISPOSAL,EFD_SPORADIC,");
		sql.append(" DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,");
		sql.append(" HAV_CASE,HF_SURVEY,HF_SAMPLE,");
		sql.append(" BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" sum(EFD_DISPOSE) EFD_DISPOSE,");
		sql.append(" sum(EFD_INSULATE) EFD_INSULATE,");
		sql.append(" sum(DYSENTERY_DISPOSE) DYSENTERY_DISPOSE,");
		sql.append(" sum(DYSENTERY_INSULATE) DYSENTERY_INSULATE,");
		sql.append(" HFMD_GRAVE,HFMD_DISPOSITION,HFMD_AGGREGATION,");
		sql.append(" HFMD_INVESTIGATION,  HEV_FULMINANT,HEV_DISPOSE from(");
		sql.append(" select");
		if(!isTotal){
			sql.append(" acute.FILL_ORGAN_CODE,");
		}
		sql.append(" INVESTIGATION,REGULATE_DISPOSAL,EFD_SPORADIC,DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,HAV_CASE,");
		sql.append(" HF_SURVEY,HF_SURVEY HF_SAMPLE,RABIES_BITE_MANY BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" nvl(sta.efd_Dispose,0) EFD_DISPOSE,");
		sql.append(" nvl(sta.efd_Insulate,0) EFD_INSULATE,");
		sql.append(" nvl(sta.dysentery_Dispose,0) DYSENTERY_DISPOSE,");
		sql.append(" nvl(sta.dysentery_Insulate,0) DYSENTERY_INSULATE,");
		sql.append(" nvl(sta.hfmd_Grave,0) HFMD_GRAVE,");
		sql.append(" nvl(sta.hfmd_Disposition,0) HFMD_DISPOSITION,");
		sql.append(" nvl(sta.hfmd_Aggregation,0) HFMD_AGGREGATION,");
		sql.append(" nvl(sta.hfmd_Investigation,0) HFMD_INVESTIGATION,");
		sql.append(" nvl(sta.hev_Fulminant,0) HEV_FULMINANT,");
		sql.append(" nvl(sta.hev_Dispose,0) HEV_DISPOSE");
		sql.append(" from(SELECT ");
		if(!isTotal){
			sql.append(" idmreport.FILL_ORGAN_CODE,");
		}
		sql.append(" TO_CHAR(idmreport.FILL_DATE,'yyyy/mm') FILL_DATE,");
		sql.append(" count(idmreport.idm_id) INVESTIGATION,");
		sql.append(" count(idmreport.idm_id) REGULATE_DISPOSAL,");
		sql.append(" sum(idmreport.efd_Sporadic) EFD_SPORADIC,");
		sql.append(" sum(idmreport.dysentery_Sporadic) DYSENTERY_SPORADIC,");
		sql.append(" sum(idmreport.hav_Sporadic) HAV_SPORADIC,");
		sql.append(" sum(idmreport.hav_Sporadic) HAV_DISPOSE,");
		sql.append(" sum(idmreport.hav_Case) HAV_CASE,");
		sql.append(" sum(idmreport.hav_Case) HF_SURVEY,");
		sql.append(" sum(idmreport.rabies_Bite_Many) RABIES_BITE_MANY,");
		sql.append(" sum(idmreport.rabies_Investigation)  RABIES_INVESTIGATION");
		sql.append(" FROM(");
		sql.append(" SELECT report.FILL_DATE,event.id IDM_ID ,");
		if(!isTotal){
			sql.append(" report.FILL_ORGAN_CODE,");
		}
				
		sql.append(" DECODE(SUBSTR(report.infectious_code,0,3), '215',1,0) efd_Sporadic,");
		sql.append(" DECODE(SUBSTR(report.infectious_code,0,3), '213',1,0) dysentery_Sporadic,");
		sql.append(" DECODE(report.infectious_code, '2031',1,0) hav_Sporadic,");
		sql.append(" DECODE(report.infectious_code, '208',1,0) hav_Case,");
		sql.append(" DECODE(report.infectious_code, '209',1,0) rabies_Investigation,");
		sql.append(" DECODE(CONCAT(route.bite_Total,CONCAT(route.what_Bite,route.die_Total)) ,null ,0,1) rabies_Bite_Many");//一犬伤多人事件数
		sql.append(" FROM IDM_STATUS_INFO status");
		sql.append(" LEFT JOIN idm_event_info event  ON status.id = event.status_id");
		sql.append(" LEFT JOIN idm_report report  ON report.idm_id = event.id");
		sql.append(" LEFT JOIN IDM_INFECTION_SOURCE_ROUTE route on route.idm_id = event.id");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
		sql.append(fillDate + "'");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		
		sql.append(" AND REPORT_STATUS = '2' AND idm_type = '1')idmreport");
		sql.append(" group by TO_CHAR(FILL_DATE,'yyyy/mm')");
		if(!isTotal){
			sql.append(" ,FILL_ORGAN_CODE");
		}
		sql.append(" ) acute");
		sql.append(" left join idm_statistics sta on(");
		sql.append(" TO_CHAR(sta.FILL_DATE,'yyyy/mm') = acute.FILL_DATE");
		if(isTotal){
			if(ObjectUtil.isNotEmpty(fillOrganCode)){
				sql.append(" and sta.FILL_ORGAN_CODE = '" + fillOrganCode +"'");
			}else if(ObjectUtil.isNotEmpty(genreCode)){
				sql.append(" AND sta.GENRE_CODE ='");
				sql.append(genreCode + "'");
			}
		} else {
			sql.append(" and sta.FILL_ORGAN_CODE = acute.FILL_ORGAN_CODE");
		}
		sql.append(" and sta.TYPE = 4) ");
		if(!isTotal){
			sql.append(" order by acute.FILL_ORGAN_CODE");
		}
		sql.append(" ) group by");
		if(!isTotal){
			sql.append(" FILL_ORGAN_CODE,");
		}		
		sql.append(" INVESTIGATION, REGULATE_DISPOSAL,EFD_SPORADIC,");
		sql.append(" DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,");
		sql.append(" HAV_CASE,HF_SURVEY,HF_SAMPLE,");
		sql.append(" BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" HFMD_GRAVE,HFMD_DISPOSITION,HFMD_AGGREGATION,");
		sql.append(" HFMD_INVESTIGATION,  HEV_FULMINANT,HEV_DISPOSE ");		
	}
	
    /**
	 * 汇总急性传染病防制年报表
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	@Override
	public List<AcuteStatisicsDto> findAcuteYearList(Criteria criteria){
		List<AcuteStatisicsDto> list = new ArrayList<AcuteStatisicsDto>();
		StringBuilder sql = new StringBuilder();
		getAcuteYearSql(sql,criteria,false);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsYearNoDataSql(sql,criteria,false,"4");
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		Map<String,Integer> mapFirstKey = getFirstKeyMaps(criteria,2,false);
		for (Map<String, Object> map : maps) {
			AcuteStatisicsDto dto = this.get(map, AcuteStatisicsDto.class);
			Integer firstKey = mapFirstKey.get(dto.getFillOrganCode());
			if(ObjectUtil.isNotEmpty(firstKey)){
				dto.setFirstAndKey(firstKey);		
			}
			list.add(dto);
		}
		return list;			
	}

   /**
	 * 汇总急性传染病防制月报表-合计
	 * @param criteria
	 * @return	List<AcuteStatisicsDto>
	 */
	@Override
	public AcuteStatisicsDto findAcuteYearTotalList(Criteria criteria){
		AcuteStatisicsDto dto = new AcuteStatisicsDto();
		StringBuilder sql = new StringBuilder();
		getAcuteYearSql(sql,criteria,true);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		if(maps.size() == 0){//如果没有获取到数据则从统计表中获取手动填写的数据
			sql = new StringBuilder();
			getStatisticsYearNoDataSql(sql,criteria,true,"4");
			maps = this.getMapList( sql.toString(), new Criteria());
		}
		Map<String,Integer> mapFirstKey = getFirstKeyMaps(criteria,2,true);
		for (Map<String, Object> map : maps) {
			dto = this.get(map, AcuteStatisicsDto.class);
			Integer firstKey = mapFirstKey.get("-1");
			if(ObjectUtil.isNotEmpty(firstKey)){
				dto.setFirstAndKey(firstKey);		
			}
		}	
		
		return dto;			
	}
	
	private void getStatisticsYearNoDataSql(StringBuilder sql, Criteria cr, boolean total, String type){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		sql.append(" select ");
		if(!total){
			sql.append(" FILL_ORGAN_CODE,");
		}			
		sql.append(" sum(DYSENTERY_INSULATE) DYSENTERY_INSULATE,");
		sql.append(" sum(DYSENTERY_DISPOSE) DYSENTERY_DISPOSE,");
		sql.append(" sum(EFD_INSULATE) EFD_INSULATE,");
		sql.append(" sum(EFD_DISPOSE) EFD_DISPOSE FROM");
		sql.append(" (select *");
		sql.append(" from idm_statistics");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy')='");
		sql.append(fillDate + "'");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		sql.append(" )");
		if(!total){
			sql.append(" group by FILL_ORGAN_CODE");
		}		
	}	
	
	private void getAcuteYearSql(StringBuilder sql, Criteria cr, boolean isTotal){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		sql.append(" select");
		if(!isTotal){
			sql.append(" FILL_ORGAN_CODE,");
		}	
		sql.append(" INVESTIGATION, REGULATE_DISPOSAL,EFD_SPORADIC,");
		sql.append(" DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,");
		sql.append(" HAV_CASE,HF_SURVEY,HF_SAMPLE,");
		sql.append(" BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" sum(EFD_DISPOSE) EFD_DISPOSE,");
		sql.append(" sum(EFD_INSULATE) EFD_INSULATE,");
		sql.append(" sum(DYSENTERY_DISPOSE) DYSENTERY_DISPOSE,");
		sql.append(" sum(DYSENTERY_INSULATE) DYSENTERY_INSULATE,");
		sql.append(" HFMD_GRAVE,HFMD_DISPOSITION,HFMD_AGGREGATION,");
		sql.append(" HFMD_INVESTIGATION,  HEV_FULMINANT,HEV_DISPOSE from(");
		sql.append(" select");
		if(!isTotal){
			sql.append(" acute.FILL_ORGAN_CODE,");
		}
		sql.append(" INVESTIGATION,REGULATE_DISPOSAL,EFD_SPORADIC,DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,HAV_CASE,");
		sql.append(" HF_SURVEY,HF_SURVEY HF_SAMPLE,RABIES_BITE_MANY BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" nvl(sta.efd_Dispose,0) EFD_DISPOSE,");
		sql.append(" nvl(sta.efd_Insulate,0) EFD_INSULATE,");
		sql.append(" nvl(sta.dysentery_Dispose,0) DYSENTERY_DISPOSE,");
		sql.append(" nvl(sta.dysentery_Insulate,0) DYSENTERY_INSULATE,");
		sql.append(" nvl(hfmd_Grave,0) HFMD_GRAVE,");
		sql.append(" nvl(hfmd_Disposition,0) HFMD_DISPOSITION,");
		sql.append(" nvl(hfmd_Aggregation,0) HFMD_AGGREGATION,");
		sql.append(" nvl(hfmd_Investigation,0) HFMD_INVESTIGATION,");
		sql.append(" nvl(hev_Fulminant,0) HEV_FULMINANT,");
		sql.append(" nvl(hev_Dispose,0) HEV_DISPOSE");
		sql.append(" from(SELECT ");
		if(!isTotal){
			sql.append(" idmreport.FILL_ORGAN_CODE,");
		}
		sql.append(" TO_CHAR(idmreport.FILL_DATE,'yyyy') FILL_DATE,");
		sql.append(" count(idmreport.idm_id) INVESTIGATION,");
		sql.append(" count(idmreport.idm_id) REGULATE_DISPOSAL,");
		sql.append(" sum(idmreport.efd_Sporadic) EFD_SPORADIC,");
		sql.append(" sum(idmreport.dysentery_Sporadic) DYSENTERY_SPORADIC,");
		sql.append(" sum(idmreport.hav_Sporadic) HAV_SPORADIC,");
		sql.append(" sum(idmreport.hav_Sporadic) HAV_DISPOSE,");
		sql.append(" sum(idmreport.hav_Case) HAV_CASE,");
		sql.append(" sum(idmreport.hav_Case) HF_SURVEY,");
		sql.append(" sum(idmreport.rabies_Bite_Many) RABIES_BITE_MANY,");
		sql.append(" sum(idmreport.rabies_Investigation)  RABIES_INVESTIGATION");
		sql.append(" FROM(");
		sql.append(" SELECT report.FILL_DATE,event.id IDM_ID ,");
		if(!isTotal){
			sql.append(" report.FILL_ORGAN_CODE,");
		}
		sql.append(" DECODE(SUBSTR(report.infectious_code,0,3), '215',1,0) efd_Sporadic,");
		sql.append(" DECODE(SUBSTR(report.infectious_code,0,3), '213',1,0) dysentery_Sporadic,");
		sql.append(" DECODE(report.infectious_code, '2031',1,0) hav_Sporadic,");
		sql.append(" DECODE(report.infectious_code, '208',1,0) hav_Case,");
		sql.append(" DECODE(report.infectious_code, '209',1,0) rabies_Investigation,");
		sql.append(" DECODE(CONCAT(route.bite_Total,CONCAT(route.what_Bite,route.die_Total)) ,null ,0,1) rabies_Bite_Many");//一犬伤多人事件数
		sql.append(" FROM IDM_STATUS_INFO status");
		sql.append(" LEFT JOIN idm_event_info event  ON status.id = event.status_id");
		sql.append(" LEFT JOIN idm_report report  ON report.idm_id = event.id");
		sql.append(" LEFT JOIN IDM_INFECTION_SOURCE_ROUTE route on route.idm_id = event.id");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy')='");
		sql.append(fillDate + "'");
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE='" + fillOrganCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		
		sql.append(" AND REPORT_STATUS = '2' AND idm_type = '1')idmreport");
		sql.append(" group by TO_CHAR(FILL_DATE,'yyyy')");
		if(!isTotal){
			sql.append(" ,FILL_ORGAN_CODE");
		}
		sql.append(" ) acute");
		sql.append(" left join idm_statistics sta on(");
		sql.append(" TO_CHAR(sta.FILL_DATE,'yyyy') = acute.FILL_DATE");
		if(isTotal){
			if(ObjectUtil.isNotEmpty(fillOrganCode)){
				sql.append(" and sta.FILL_ORGAN_CODE = '" + fillOrganCode +"'");
			}else if(ObjectUtil.isNotEmpty(genreCode)){
				sql.append(" AND GENRE_CODE ='");
				sql.append(genreCode + "'");
			}
		} else {
			sql.append(" and sta.FILL_ORGAN_CODE = acute.FILL_ORGAN_CODE");
		}
		sql.append(" and sta.TYPE = 4) ");
		if(!isTotal){
			sql.append(" order by acute.FILL_ORGAN_CODE");
		}
		sql.append(" ) group by");
		if(!isTotal){
			sql.append(" FILL_ORGAN_CODE,");
		}		
		sql.append(" INVESTIGATION, REGULATE_DISPOSAL,EFD_SPORADIC,");
		sql.append(" DYSENTERY_SPORADIC,HAV_SPORADIC,HAV_DISPOSE,");
		sql.append(" HAV_CASE,HF_SURVEY,HF_SAMPLE,");
		sql.append(" BITE_MANY,RABIES_INVESTIGATION,");
		sql.append(" HFMD_GRAVE,HFMD_DISPOSITION,HFMD_AGGREGATION,");
		sql.append(" HFMD_INVESTIGATION,  HEV_FULMINANT,HEV_DISPOSE ");
	}	
	

	/**
	 * 汇总急性传染病防制-首发和重点Map,Key:机构编码，value:首发和重点数
	 * @param criteria
	 * @param type,1:月报，2：年报
	 * @param total,true:报表合计，false：非合计
	 * @return	void
	 */
	private Map<String,Integer> getFirstKeyMaps(Criteria criteria, Integer type, boolean total){
		Map<String,Integer> mapFirstKey = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		getFirstKeySql(sql,criteria,type,total);
		List<Map<String, Object>> maps = this.getMapList( sql.toString(), new Criteria());
		for (Map<String, Object> map : maps) {
			AcuteStatisicsDto dto = this.get(map, AcuteStatisicsDto.class);
			mapFirstKey.put(dto.getFillOrganCode(), dto.getFirstAndKey());
		}		
		return mapFirstKey;
	}

	/**
	 * 汇总急性传染病防制-首发和重点SQL
	 * @param sql
	 * @param cr
	 * @param type,1:月报，2：年报
	 * @param total,true:报表合计，false：非合计
	 * @return	void
	 */
	private void getFirstKeySql(StringBuilder sql, Criteria cr, Integer type, boolean total){
		Object fillDate = cr.get("FILL_DATE");
		Object fillOrganCode = cr.get("FILL_ORGAN_CODE");
		Object genreCode = cr.get("GENRE_CODE");
		sql.append(" SELECT ");
		if(total){
			sql.append(" COUNT(FILL_DATE) first_And_Key,'-1' FILL_ORGAN_CODE");
		}else{
			sql.append(" COUNT(FILL_ORGAN_CODE) first_And_Key,FILL_ORGAN_CODE");
		}
		sql.append(" FROM (");
		sql.append(" SELECT distinct (FILL_ORGAN_CODE || infectious_code ||TO_CHAR(report.FILL_DATE,'yyyy/MM') ),report.FILL_ORGAN_CODE,report.infectious_code,");
		if(type.equals(1)){//月报
			sql.append(" TO_CHAR(report.FILL_DATE,'yyyy/MM') FILL_DATE");
		}else{
			sql.append(" TO_CHAR(report.FILL_DATE,'yyyy') FILL_DATE");
		}		
		sql.append(" FROM    IDM_STATUS_INFO status");
		sql.append(" LEFT JOIN idm_event_info event ON status.id = event.status_id");
		sql.append(" LEFT JOIN idm_report report ON report.idm_id = event.id");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'");
		if(type.equals(1)){//月报
			sql.append("yyyy/MM')='");
		}else{
			sql.append("yyyy')='");
		}
		sql.append(fillDate + "'");
		
		if(ObjectUtil.isNotEmpty(fillOrganCode)){
			sql.append(" AND FILL_ORGAN_CODE = '" + fillOrganCode +"'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}		
		sql.append(" AND REPORT_STATUS = '2'");
		sql.append(" AND idm_type = '1'");
		sql.append(" AND report.infectious_code IN ('101','102','201','2031','2034','205','206','207','208','209','210','211','2121','2122','2123','2131','2151','2152','216','219','220','221','224','225','2261','2262','2263','305','307'))");
		if(!total){
			sql.append(" group by FILL_ORGAN_CODE");			
		}else{
			sql.append(" GROUP BY FILL_DATE");
		}

	}

    /**
     * 指标统计
     * @param criteria
     * @return
     */
    public Float getIDMTarget(Criteria criteria){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(1) AS COUNT FROM IDM_STATUS_INFO S, IDM_REPORT R, IDM_EVENT_INFO E ");
        sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = R.IDM_ID ");
//        sql.append(" AND S.IDM_TYPE = 1 AND S.REPORT_STATUS = 2 ");
        sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(IdmReport.class), ":")).toString();
        Map<String, Object> resultMap = this.getMap(sql.toString(), criteria);
        return Float.valueOf(resultMap.get("COUNT").toString());
    }

	@Override
	public List<Map<String, Object>> findChreport(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String time=sdf.format(date);
		StringBuilder sql = new StringBuilder();
		sql.append(" select aa.t as town,nvl(aa.n0,'0') s1,nvl(aa.n1,'0') s2,nvl(aa.n2,'0') s3,nvl(aa.n3,'0') s4,nvl(aa.n4,'0') s5,nvl(bb.n5,'0') t1,nvl(bb.n6,'0') t2, ");
		sql.append(" nvl(bb.n7,'0') t3,nvl(bb.n8,'0') t4,nvl(bb.n9,'0') t5 from ");
		sql.append(" (  select T,count(T) n0 ,sum(LYMPHEDEMA) n1,sum(CHYLURIA) n2,sum(TUNICA_VAGINALI) n3,sum(LYMPHATIC) n4  from   ");
		sql.append(" ( (SELECT E.ID AS SINGLE_ID,S.ID AS IDM_ID1, REPLACE(A.LYMPHEDEMA,'2','0') LYMPHEDEMA,REPLACE(A.CHYLURIA,'2','0') CHYLURIA,REPLACE(A.TUNICA_VAGINALI,'2','0') TUNICA_VAGINALI,REPLACE(A.LYMPHATIC,'2','0') LYMPHATIC,   ");
		sql.append(" I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT,G.PATOWN_SHIP AS T,S.CURRENT_UNIT as CURRENT_UNIT  FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,   ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E   WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND   ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5002' AND S.IDM_TYPE='5' ORDER BY  S.LOGOFF, S.ID DESC) a1   ");
		sql.append(" left join   ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS,   ");
		sql.append(" S.LOGOFF,  I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT   FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L, ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E    ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2  ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) where TO_Number(TO_CHAR(FILL_DATE,'yyyy'))<=TO_Number('");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append("') ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  and CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by T  ) aa ");
		sql.append(" left join ");
		sql.append(" (  select T,count(T) n5 ,sum(LYMPHEDEMA) n6,sum(CHYLURIA) n7,sum(TUNICA_VAGINALI) n8,sum(LYMPHATIC) n9  from  ");
		sql.append(" ( (SELECT E.ID AS SINGLE_ID,S.ID AS IDM_ID1, REPLACE(A.LYMPHEDEMA,'2','0') LYMPHEDEMA,REPLACE(A.CHYLURIA,'2','0') CHYLURIA,REPLACE(A.TUNICA_VAGINALI,'2','0') TUNICA_VAGINALI,REPLACE(A.LYMPHATIC,'2','0') LYMPHATIC,   ");
		sql.append(" I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT,G.PATOWN_SHIP AS T,S.CURRENT_UNIT as CURRENT_UNIT  FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,   ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E   WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND  ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5002' AND S.IDM_TYPE='5' ORDER BY  S.LOGOFF, S.ID DESC) a1   ");
		sql.append(" left join   ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS,   ");
		sql.append(" S.LOGOFF,  I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT   FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,    ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E    ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2   ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) where TO_CHAR(FILL_DATE,'yyyy')='");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append("' ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  and CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append("group by T  ) bb ");
		sql.append(" on aa.t=bb.t ");
		Criteria c = new Criteria();
		List<Map<String, Object>> list = this.getMapList(sql.toString(), c);
		return list;
	}





	@Override
	public List<Map<String, Object>> findChreportCount(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String time=sdf.format(date);
		StringBuilder sql = new StringBuilder();
		sql.append(" select nvl(sum(s1),'0') s1,nvl(sum(s2),'0') s2,nvl(sum(s3),'0') s3,nvl(sum(s4),'0') s4,nvl(sum(s5),'0') s5,nvl(sum(t1),'0') t1,nvl(sum(t2),'0') t2,nvl(sum(t3),'0') t3,nvl(sum(t4),'0') t4,nvl(sum(t5),'0') t5  ");
		sql.append(" from(   ");
		sql.append(" select aa.t as town,nvl(aa.n0,'0') s1,nvl(aa.n1,'0') s2,nvl(aa.n2,'0') s3,nvl(aa.n3,'0') s4,nvl(aa.n4,'0') s5,nvl(bb.n5,'0') t1,nvl(bb.n6,'0') t2, ");
		sql.append(" nvl(bb.n7,'0') t3,nvl(bb.n8,'0') t4,nvl(bb.n9,'0') t5 from ");
		sql.append(" (  select T,count(T) n0 ,sum(LYMPHEDEMA) n1,sum(CHYLURIA) n2,sum(TUNICA_VAGINALI) n3,sum(LYMPHATIC) n4  from   ");
		sql.append(" ( (SELECT E.ID AS SINGLE_ID,S.ID AS IDM_ID1, REPLACE(A.LYMPHEDEMA,'2','0') LYMPHEDEMA,REPLACE(A.CHYLURIA,'2','0') CHYLURIA,REPLACE(A.TUNICA_VAGINALI,'2','0') TUNICA_VAGINALI,REPLACE(A.LYMPHATIC,'2','0') LYMPHATIC,   ");
		sql.append(" I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT,G.PATOWN_SHIP AS T,S.CURRENT_UNIT as CURRENT_UNIT  FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,   ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E   WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND   ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5002' AND S.IDM_TYPE='5' ORDER BY  S.LOGOFF, S.ID DESC) a1   ");
		sql.append(" left join   ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS,   ");
		sql.append(" S.LOGOFF,  I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT   FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L, ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E    ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2  ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) where TO_Number(TO_CHAR(FILL_DATE,'yyyy'))<=TO_Number('");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append("') ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  and CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by T  ) aa ");
		sql.append(" left join ");
		sql.append(" (  select T,count(T) n5 ,sum(LYMPHEDEMA) n6,sum(CHYLURIA) n7,sum(TUNICA_VAGINALI) n8,sum(LYMPHATIC) n9  from  ");
		sql.append(" ( (SELECT E.ID AS SINGLE_ID,S.ID AS IDM_ID1, REPLACE(A.LYMPHEDEMA,'2','0') LYMPHEDEMA,REPLACE(A.CHYLURIA,'2','0') CHYLURIA,REPLACE(A.TUNICA_VAGINALI,'2','0') TUNICA_VAGINALI,REPLACE(A.LYMPHATIC,'2','0') LYMPHATIC,   ");
		sql.append(" I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT,G.PATOWN_SHIP AS T,S.CURRENT_UNIT as CURRENT_UNIT  FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,   ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E   WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND  ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5002' AND S.IDM_TYPE='5' ORDER BY  S.LOGOFF, S.ID DESC) a1   ");
		sql.append(" left join   ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS,   ");
		sql.append(" S.LOGOFF,  I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT   FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,    ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E    ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2   ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) where TO_CHAR(FILL_DATE,'yyyy')='");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append("' ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  and CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append("group by T  ) bb ");
		sql.append(" on aa.t=bb.t ");
		sql.append(")");
		List<Map<String, Object>> list = this.getMapList(sql.toString(), criteria);
		return list;
	}


	@Override
	public List<Map<String, Object>> findPhreport(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String time=sdf.format(date);
	    StringBuilder sql = new StringBuilder();
		sql.append("	SELECT ORGAN_NAME,ORGAN_CODE,PARENT_CODE,GENRE_CODE,nvl(cn1,'0') cn1,nvl(cn2,'0') cn2,nvl(cn3,'0') cn3,FILL_DATE FROM((SELECT ORGAN_NAME,ORGAN_CODE,PARENT_CODE,GENRE_CODE FROM mdm_organization ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  WHERE ORGAN_CODE= '");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" ) a ");
		sql.append("		 left join ");
		sql.append("		 ( select x.CURRENT_UNIT as CURRENT_UNIT,cn1,cn2,cn3,x.FILL_DATE FILL_DATE from(( ");
		sql.append("     select  CURRENT_UNIT,nvl(count(name),'0') cn1,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from ( ");
		sql.append("     SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append("     G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5'   ");
		sql.append(" ) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy') ) x ");
		sql.append(" left join ");
		sql.append(" (select  CURRENT_UNIT,nvl(count(name),'0') cn2,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from ( ");
		sql.append(" SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append(" G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5'  and TEST_RESULT='1' ) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy')) y ");
		sql.append("  on x.CURRENT_UNIT=y.CURRENT_UNIT and x.FILL_DATE=y.FILL_DATE ");
		sql.append(" left join      ");
		sql.append(" (select a2.CURRENT_UNIT CURRENT_UNIT,nvl(count(name),'0') cn3,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from( ");
		sql.append(" (SELECT G.NAME as name1, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC,S.ID AS IDM_ID1 ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, ");
		sql.append(" IDM_LAB_EXAMINE L,  (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM ");
		sql.append(" IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND ");
		sql.append(" E.ID = L.IDM_ID(+)  AND E.EVENT_ID IN ('5002')  AND S.IDM_TYPE=5 AND (A.LYMPHEDEMA = 1 OR A.CHYLURIA = 1) ) a1 ");
		sql.append(" left join ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append(" G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2 ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy') )z ");
		sql.append(" on x.CURRENT_UNIT=z.CURRENT_UNIT and x.FILL_DATE=z.FILL_DATE ");
		sql.append(" ) where x.FILL_DATE= ");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append(" ) b on a.ORGAN_CODE = b.CURRENT_UNIT) where GENRE_CODE ='B100' or GENRE_CODE ='J100' and ORGAN_CODE !='SZ586000' order by GENRE_CODE desc ");

		List<Map<String, Object>> list = this.getMapList(sql.toString(), criteria);
		return list;

	}


	@Override
	public List<Map<String, Object>> findPhreportCount(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String time=sdf.format(date);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT nvl(sum(cn1),'0') cn1,nvl(sum(cn2),'0') cn2，nvl(sum(cn3),'0') cn3 FROM((SELECT ORGAN_NAME,ORGAN_CODE,PARENT_CODE,GENRE_CODE FROM mdm_organization ");
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append("  WHERE ORGAN_CODE= '");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" ) a ");
		sql.append("		 left join ");
		sql.append("		 ( select x.CURRENT_UNIT as CURRENT_UNIT,cn1,cn2,cn3,x.FILL_DATE FILL_DATE from(( ");
		sql.append("     select  CURRENT_UNIT,nvl(count(name),'0') cn1,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from ( ");
		sql.append("     SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append("     G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5'   ");
		sql.append(" ) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy') ) x ");
		sql.append(" left join ");
		sql.append(" (select  CURRENT_UNIT,nvl(count(name),'0') cn2,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from ( ");
		sql.append(" SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append(" G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5'  and TEST_RESULT='1' ) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy')) y ");
		sql.append("  on x.CURRENT_UNIT=y.CURRENT_UNIT and x.FILL_DATE=y.FILL_DATE ");
		sql.append(" left join      ");
		sql.append(" (select a2.CURRENT_UNIT CURRENT_UNIT,nvl(count(name),'0') cn3,TO_CHAR(FILL_DATE,'yyyy') FILL_DATE from( ");
		sql.append(" (SELECT G.NAME as name1, A.LYMPHEDEMA, A.CHYLURIA, A.TUNICA_VAGINALI, A.LYMPHATIC,S.ID AS IDM_ID1 ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, ");
		sql.append(" IDM_LAB_EXAMINE L,  (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM ");
		sql.append(" IDM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5002')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND E.ID = I.IDM_ID(+) AND ");
		sql.append(" E.ID = L.IDM_ID(+)  AND E.EVENT_ID IN ('5002')  AND S.IDM_TYPE=5 AND (A.LYMPHEDEMA = 1 OR A.CHYLURIA = 1) ) a1 ");
		sql.append(" left join ");
		sql.append(" (SELECT E.ID AS SINGLE_ID,G.NAME, G.GENDER, G.AGE, G.PATOWN_SHIP, G.PASTREET, ");
		sql.append(" G.PAHOUSE_NUMBER, G.PHONE_NUMBER, G.PA_ADDRESS, S.ID AS IDM_ID, S.CASE_STATUS, ");
		sql.append(" S.LOGOFF, S.CURRENT_UNIT, ");
		sql.append(" I.SURVEY_DATE AS FILL_DATE, I.CHANGE_DETAIL AS COMMENTS, I.SURVEY_ORG, L.TEST_RESULT  ");
		sql.append(" FROM IDM_STATUS_INFO S, IDM_GENERAL_CONDITION G, IDM_ATTACK_CONDITION A, IDM_CASE_INFORMATION I, IDM_LAB_EXAMINE L,  ");
		sql.append(" (SELECT T1.* FROM IDM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM IDM_EVENT_INFO T2 ");
		sql.append(" WHERE T1.STATUS_ID = T2.STATUS_ID  AND EVENT_ID IN ('5001')   )) E  ");
		sql.append(" WHERE S.ID = E.STATUS_ID AND E.ID = G.IDM_ID(+) AND E.ID = A.IDM_ID(+) AND ");
		sql.append(" E.ID = I.IDM_ID(+) AND E.ID = L.IDM_ID(+)  AND E.EVENT_ID='5001' AND S.IDM_TYPE='5') a2 ");
		sql.append(" on a1.IDM_ID1=a2.IDM_ID) group by CURRENT_UNIT,TO_CHAR(FILL_DATE,'yyyy') )z ");
		sql.append(" on x.CURRENT_UNIT=z.CURRENT_UNIT and x.FILL_DATE=z.FILL_DATE ");
		sql.append(" ) where x.FILL_DATE= ");
		if(criteria.get("year")!=null){
			sql.append(criteria.get("year") );
		}else{
			sql.append(time);
		}
		sql.append("  ) b on a.ORGAN_CODE = b.CURRENT_UNIT) where GENRE_CODE ='B100' or GENRE_CODE ='J100' and ORGAN_CODE !='SZ586000' ");
		List<Map<String, Object>> list = this.getMapList(sql.toString(), criteria);
		return list;
	}

	@Override
	public List<Map<String, Object>> downTreatList(Criteria criteria, Criteria statusCr, Order order) {
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(statusCr)) {
			statusCr = new Criteria("EVENT_ID", OP.IN, criteria.get("EVENT_ID"));
		}
		sql.append("SELECT AA.A1,AA.A2,AA.A3,AA.A4,AA.A5,AA.A6,AA.A7,AA.A8,AA.A9,AA.A10,AA.A11,AA.A12,AA.A13,AA.A14,");
		sql.append(" AA.A15,AA.A16,AA.A17,AA.A18,AA.A19,AA.A20,v.ORGAN_NAME AANAME,AA.A22,AA.A23,AA.A24,AA.A25,AA.A26,AA.A27,AA.A28,");
		sql.append(" AA.A29,AA.A30,AA.A31,AA.A32,AA.A33,AA.A34,AA.A35,AA.A36,AA.A37,AA.A38,AA.A39,AA.A40,AA.A41");
		sql.append(" FROM ( ");

		sql.append("SELECT status.ID A1,status.SPECIAL_STATUS A2,status.IDM_TYPE A3,event.ID A4,status.place_status A5,status.logoff A6,");
		sql.append(" gen.NAME A7,gen.GENDER A8,gen.AGE A9,gen.IDCARD A10,gen.PHONE_NUMBER A11, gen.float_population A12,gen.pa_address A13, gen.hr_address A14,");
		sql.append(" gen.PATOWN_SHIP A15,gen.PASTREET A16,gen.PAHOUSE_NUMBER A17,gen.register_num A18, caseInfo.Transfer_Treatment_Dt A19, caseInfo.TRANSFER_TREATMENT_DOCTOR A20, ");
		sql.append(" caseInfo.MODIFY_SURVEY_ORG A21,caseInfo.MODIFY_SURVEY_DATE A22,status.CURRENT_UNIT A23,");
		sql.append(" dia.diagnosis_Type A24,dia.LAST_DIAGNOSIS A25,dia.DIAGNOSIS_ACCORDING A26,dia.DIAGNOSIS_REASON_MULTI A27,dia.DIAGNOSIS_OTHER A28,dia.OTHER A29,");
		sql.append(" clinical.ORIGINAL_SYMPTOM A30,dia.TENTATIVE_DIAGNOSIS A31,dia.DIAGNOSIS_REASON A32,");
		sql.append(" other.CASE_SOURCE A33,other.CASE_TYPE A34,other.MANAGE_TYPE A35,other.THIS_TYPE A36,other.THIS_DT A37,other.CHEMOTHERAPY A38, ");
		sql.append(" lab.CHEST_XRAYS A39, lab.PHLEGM_PCR A40, exp.HANDLING_WAY A41");
		sql.append(" FROM IDM_STATUS_INFO status ");
		sql.append(getEventInfoSpecialSql(statusCr));
		sql.append(" LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID ");
		sql.append(" LEFT JOIN Idm_Clinical_Manifestations clinical on event.ID = clinical.IDM_ID");
		sql.append(" LEFT JOIN Idm_Diagnosis dia on event.ID = dia.IDM_ID");
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION caseInfo ON event.ID = caseInfo.IDM_ID" );
		sql.append(" LEFT JOIN Idm_Other_Condition other on event.ID = other.IDM_ID");
		sql.append(" LEFT JOIN IDM_LAB_EXAMINE lab on event.ID = lab.IDM_ID");
		sql.append(" LEFT JOIN IDM_EXPOSURE_HISTORY exp on event.ID = exp.IDM_ID");
//		this.getTreatmentSql(sql, statusCr);
		criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
		SqlBuilder.buildWhereStatement(IdmStatusInfo.class, sql, criteria) ;
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("status.logoff", true);
			order.asc("status.SPECIAL_STATUS");
			order.asc("status.PLACE_STATUS");
			order.desc("caseInfo.MODIFY_SURVEY_DATE");
		}
		sql.append(order.toString());
		sql.append(" ) AA inner join mdm_organization v on AA.A21=V.ORGAN_CODE ");
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);


		return maps;
	}

	@Override
	public List<Map<String, Object>> findJcReport(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		String time;
		if(criteria.get("month")!=null){
			time = criteria.get("month").toString();
		}else{
			time=sdf.format(date);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("  with a as (   select PATOWN_SHIP,PASTREET,count(name) ddia_dt from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,   ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC ) where TO_CHAR(DDIA_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET), ");
//		sql.append(" --DDIA 阳性人数      ");
		sql.append("     b as (select PATOWN_SHIP,PASTREET,count(name) ddia from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where DDIA='1' and TO_CHAR(DDIA_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT 检测人数       ");
		sql.append("      c as (select PATOWN_SHIP,PASTREET,count(name) copt_dt from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT阳性人数       ");
		sql.append("     d as  (      select PATOWN_SHIP,PASTREET,count(name) copt1 from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where COPT='1' and  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT阴性人数      ");
		sql.append("       e as (           select PATOWN_SHIP,PASTREET,count(name) copt2 from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where COPT='2' and  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --粪检人数	 ");
		sql.append("       f as ( select PATOWN_SHIP,PASTREET,count(name) STOOL_DT from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where TO_CHAR(STOOL_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --粪检阳性人数 ");
		sql.append("       g as  (select PATOWN_SHIP,PASTREET,count(name) STOOL from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'   ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where STOOL='1' and TO_CHAR(STOOL_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET)   ");
		sql.append("       select a.PATOWN_SHIP,a.PASTREET,nvl(ddia_dt,'0') ddia_all,nvl(ddia,'0') ddia,nvl(copt_dt,'0') copt_dt,nvl(copt1,'0') copt1,nvl(copt2,'0') copt2,nvl(STOOL_DT,'0') STOOL_DT,nvl(STOOL,'0') STOOL ");
		sql.append("     from a left join b on a.PASTREET = b.PASTREET ");
		sql.append("     left join c on a.PASTREET = c.PASTREET ");
		sql.append("     left join d on a.PASTREET = d.PASTREET ");
		sql.append("     left join e on a.PASTREET = e.PASTREET ");
		sql.append("     left join f on a.PASTREET = f.PASTREET ");
		sql.append("    left join g on a.PASTREET = g.PASTREET ");
		List<Map<String, Object>> list = this.getMapList(sql.toString(), criteria);



		return list;
	}

	@Override
	public List<Map<String, Object>> findJcReportCount(Criteria criteria) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		String time;
		if(criteria.get("month")!=null){
			time = criteria.get("month").toString();
		}else{
			time=sdf.format(date);
		}
		StringBuilder sql = new StringBuilder();
//		sql.append(" --DDIA 检测人数 ");
		sql.append("  with a as (   select PATOWN_SHIP,PASTREET,count(name) ddia_dt from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,   ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC ) where TO_CHAR(DDIA_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET), ");
//		sql.append(" --DDIA 阳性人数      ");
		sql.append("     b as (select PATOWN_SHIP,PASTREET,count(name) ddia from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where DDIA='1' and TO_CHAR(DDIA_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT 检测人数       ");
		sql.append("      c as (select PATOWN_SHIP,PASTREET,count(name) copt_dt from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT阳性人数       ");
		sql.append("     d as  (      select PATOWN_SHIP,PASTREET,count(name) copt1 from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where COPT='1' and  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --COPT阴性人数      ");
		sql.append("       e as (           select PATOWN_SHIP,PASTREET,count(name) copt2 from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where COPT='2' and  TO_CHAR(COPT_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --粪检人数	 ");
		sql.append("       f as ( select PATOWN_SHIP,PASTREET,count(name) STOOL_DT from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where  TO_CHAR(STOOL_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET),   ");
//		sql.append(" --粪检阳性人数 ");
		sql.append("       g as  (select PATOWN_SHIP,PASTREET,count(name) STOOL from( ");
		sql.append("       SELECT  status.ID IDM_ID,status.SPECIAL_STATUS,status.CURRENT_UNIT CURRENT_UNIT,status.IDM_TYPE,event.ID SINGLE_ID, gen.IDCARD,gen.NAME,gen.GENDER,gen.AGE,gen.AGE_UNIT,gen.PHONE_NUMBER, gen.PATOWN_SHIP PATOWN_SHIP,    ");
		sql.append(" 		  gen.PASTREET PASTREET,gen.PAHOUSE_NUMBER,gen.PA_ADDRESS, gen.HRTOWN_SHIP,gen.HRSTREET,gen.HRHOUSE_NUMBER,gen.HR_ADDRESS, lab.DDIA_DT DDIA_DT,lab.DDIA DDIA,lab.IHA_CHECK IHA_CHECK,lab.IHA_DT IHA_DT,lab.COPT COPT,    ");
		sql.append(" 		  lab.COPT_DT COPT_DT,lab.STOOL STOOL,lab.STOOL_DT STOOL_DT,lab.TEST_DT,lab.TEST_RESULT FROM IDM_STATUS_INFO status  LEFT JOIN  (select t1.* from IDM_EVENT_INFO t1 where t1.id in ( select max(t2.id)     ");
		sql.append(" 		  from  IDM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND EVENT_ID IN ('3001') )) event ON status.ID = event.STATUS_ID  LEFT JOIN IDM_GENERAL_CONDITION gen ON event.ID = gen.IDM_ID    ");
		sql.append(" 		  LEFT JOIN IDM_LAB_EXAMINE	 lab ON event.ID = lab.IDM_ID LEFT JOIN IDM_CASE_INFORMATION	 cas ON event.ID = cas.IDM_ID  WHERE IDM_TYPE='4' AND EVENT_ID IN ('3001') AND gen.FLOAT_POPULATION='1'  ORDER BY     ");
		sql.append(" 		  DECODE(status.SPECIAL_STATUS, '12',1,'13',2,'3',3,'14',4,'11',5,'4',6,'5',7,'6',8,'2',9) ASC,cas.MODIFY_DT DESC )where STOOL='1' and TO_CHAR(STOOL_DT,'yyyy/MM') ='");
		sql.append(time);
		sql.append("'  ");
		if(criteria.get("patownShip")!=null){
			sql.append(" AND PATOWN_SHIP='");
			sql.append(criteria.get("patownShip"));
			sql.append("'  ");
		}
		if(!EHRConstants.JK_CODE.equals(criteria.get("orgCode"))){
			sql.append(" AND CURRENT_UNIT='");
			sql.append(criteria.get("orgCode"));
			sql.append("'  ");
		}
		sql.append(" group by PATOWN_SHIP,PASTREET)   ");
		sql.append("select  nvl(sum(ddia_all),'0') ddia_all,nvl(sum(DDIA),'0') DDIA,nvl(sum(COPT_DT) ,'0')COPT_DT,");
		sql.append("nvl(sum(COPT1),'0') COPT1,nvl(sum(COPT2),'0') COPT2,nvl(sum(STOOL_DT),'0') STOOL_DT,nvl(sum(STOOL),'0') STOOL ");
		sql.append(" from( ");
		sql.append("       select a.PATOWN_SHIP,a.PASTREET,nvl(ddia_dt,'0') ddia_all,nvl(ddia,'0') ddia,nvl(copt_dt,'0') copt_dt,nvl(copt1,'0') copt1,nvl(copt2,'0') copt2,nvl(STOOL_DT,'0') STOOL_DT,nvl(STOOL,'0') STOOL ");
		sql.append("     from a left join b on a.PASTREET = b.PASTREET ");
		sql.append("     left join c on a.PASTREET = c.PASTREET ");
		sql.append("     left join d on a.PASTREET = d.PASTREET ");
		sql.append("     left join e on a.PASTREET = e.PASTREET ");
		sql.append("     left join f on a.PASTREET = f.PASTREET ");
		sql.append("    left join g on a.PASTREET = g.PASTREET ");
		sql.append(" ) ");
		List<Map<String, Object>> list = this.getMapList(sql.toString(), criteria);



		return list;
	}

}