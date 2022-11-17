package com.founder.rhip.ehr.repository.statistics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.management.CdmsStatisticsInfo;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
@Repository("cdmsStatisticsDao")
public class CdmsStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements ICdmsStatisticsDao {
	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Override
	public List<Map<String, Object>> getCdmsStatisticList(Criteria criteria) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 1 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 2 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 3 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.TUMOR_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY  DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 4 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.STROKE_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate  AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 5 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.CORONARY_FLAG=2  AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY  DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 6 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2  AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY  DM_PERSON_INFO.CREATE_GBCODE"+
				" UNION ALL"+
				" SELECT 7 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2  AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE" +
				" UNION ALL"+
				" SELECT 8 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.TUMOR_FLAG=2 AND DM_DISEASE_INFO.TUMOR_MANAGED_FLAG=1   AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE" +
				" UNION ALL"+
				" SELECT 9 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.STROKE_FLAG=2 AND DM_DISEASE_INFO.STROKE_MANAGED_FLAG=1   AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE" +
				" UNION ALL"+
				" SELECT 10 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.CORONARY_FLAG=2 AND DM_DISEASE_INFO.CORONARY_MANAGED_FLAG=1  AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate AND DM_PERSON_INFO.TYPE=2 GROUP BY  DM_PERSON_INFO.CREATE_GBCODE  " +
				" UNION ALL"+
				" SELECT 11 AS TOORDER, COUNT(1) AS COUNT, DM_PERSON_INFO.CREATE_GBCODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1  AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY')<=:createDate  AND DM_PERSON_INFO.TYPE=2 GROUP BY   DM_PERSON_INFO.CREATE_GBCODE  " +
				" UNION ALL"+
				" SELECT 12 AS TOORDER,COUNT(1) AS COUNT,DM_PERSON_INFO.CREATE_GBCODE FROM (SELECT B.PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP B INNER JOIN ( SELECT PERSON_ID, MAX (VISIT_DATE) VISIT_DATE FROM DM_HYPERTENSION_FOLLOWUP WHERE TO_CHAR (CREATE_DATE, 'YYYY') <= :createDate GROUP BY PERSON_ID ) A ON B.PERSON_ID = A .PERSON_ID AND A .VISIT_DATE = b.VISIT_DATE WHERE SBP BETWEEN '90' AND '140' AND DBP BETWEEN '60' AND '90') A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_GBCODE "+
				" UNION ALL"+
				" SELECT 13  AS TOORDER,COUNT(1) AS COUNT,DM_PERSON_INFO.CREATE_GBCODE FROM (SELECT B.PERSON_ID FROM DM_DIABETIC_FOLLOWUP B INNER JOIN ( SELECT PERSON_ID, MAX (VISIT_DATE) VISIT_DATE FROM DM_DIABETIC_FOLLOWUP WHERE TO_CHAR (CREATE_DATE, 'YYYY') <=  :createDate GROUP BY PERSON_ID ) A ON B.PERSON_ID = A .PERSON_ID AND A .VISIT_DATE = b.VISIT_DATE WHERE FPG BETWEEN '3.9' AND '6.1' ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_GBCODE "+
				" ORDER BY TOORDER");
		return this.getMapList(sb.toString().replace(":createDate", "'" + criteria.get("createDate") + "'"), new Criteria());
	}
	@Override
	public List<Map<String, Object>> getHBPCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE = :houseHoldType GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getNewHBPCount(String houseHoldType) {
		Criteria cr = createCompareDate(houseHoldType);
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}else {
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}
		return this.getMapList(sb.toString(),cr);
	}
	@Override
	public List<Map<String, Object>> getCuredHBPCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_HYPERTENSION_FOLLOWUP WHERE(SBP BETWEEN '90' AND'140' ) AND(DBP BETWEEN '60' AND '90' ) GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}else{
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_HYPERTENSION_FOLLOWUP WHERE(SBP BETWEEN '90' AND'140' ) AND(DBP BETWEEN '60' AND '90' ) GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType  GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getDITypeTwoCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append( " SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}else{
			cr.add("houseHoldType",houseHoldType);
			sb.append( " SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType  GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getNewDITypeTwoCount(String houseHoldType) {
		Criteria cr = createCompareDate(houseHoldType);
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}else{
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE");
		}
		return this.getMapList(sb.toString(),cr);
	}
	@Override
	public List<Map<String, Object>> getCuredDITypeTwoCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_DIABETIC_FOLLOWUP WHERE FPG BETWEEN '3.9' AND '6.1'  GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE ");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_ORGAN_CODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_DIABETIC_FOLLOWUP WHERE FPG BETWEEN '3.9' AND '6.1'  GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_ORGAN_CODE ");
		}
		return this.getMapList(sb.toString(), cr);
	}

	private Criteria createCompareDate(String houseHoldType){
		Calendar ca =Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);    //获取年
		int month=ca.get(Calendar.MONTH)+1; //获取当前月
		int day = ca.get(Calendar.DAY_OF_MONTH);    //获取当前天数
		String MM;
		String DD;
		if(month<10){
			MM="0"+month;
		}else{
			MM=""+month;
		}
		if(day<10){
			DD="0"+day;
		}else{
			DD=""+day;
		}
		String startDate=year+"-"+MM+"-01";
		String endDate=year+"-"+MM+"-"+DD;
		Criteria cr = new Criteria();
		cr.add("startDate",startDate);
		cr.add("endDate",endDate);
		if(StringUtil.isNotEmpty(houseHoldType)){
			cr.add("houseHoldType",houseHoldType);
		}
		return cr;
	}

	@Override
	public List<Map<String, Object>> getTownHBPCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_GBCODE ");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getTownNewHBPCount(String houseHoldType) {
		Criteria cr = createCompareDate(houseHoldType);
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}else {
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.HBP_FLAG=2 AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}
		return this.getMapList(sb.toString(),cr);
	}
	@Override
	public List<Map<String, Object>> getTownCuredHBPCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_HYPERTENSION_FOLLOWUP WHERE(SBP BETWEEN '90' AND'140' ) AND(DBP BETWEEN '60' AND '90' ) GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_HYPERTENSION_FOLLOWUP WHERE(SBP BETWEEN '90' AND'140' ) AND(DBP BETWEEN '60' AND '90' ) GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType  GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getTownDITypeTwoCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append( " SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append( " SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType  GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getTownNewDITypeTwoCount(String houseHoldType) {
		Criteria cr = createCompareDate(houseHoldType);
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}else {
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID=DM_DISEASE_INFO.PERSON_ID WHERE  DM_DISEASE_INFO.STATUS=1 AND DM_DISEASE_INFO.DI_FLAG=2 AND DM_DISEASE_INFO.DI_TYPE='2' AND TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')>=:startDate AND  TO_CHAR(DM_DISEASE_INFO.CREATE_DATE,'YYYY-MM-DD')<=:endDate AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_GBCODE");
		}
		return this.getMapList(sb.toString(),cr);
	}
	@Override
	public List<Map<String, Object>> getTownCuredDITypeTwoCount(String houseHoldType) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if(ObjectUtil.isNullOrEmpty(houseHoldType)){
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_DIABETIC_FOLLOWUP WHERE FPG BETWEEN '3.9' AND '6.1'  GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 GROUP BY DM_PERSON_INFO.CREATE_GBCODE ");
		}else {
			cr.add("houseHoldType",houseHoldType);
			sb.append(" SELECT COUNT(1) AS COUNT ,DM_PERSON_INFO.CREATE_GBCODE AS ORGAN_CODE FROM (SELECT MAX(ID),PERSON_ID,COUNT(1) FROM DM_DIABETIC_FOLLOWUP WHERE FPG BETWEEN '3.9' AND '6.1'  GROUP BY PERSON_ID ) A INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID=A.PERSON_ID AND DM_PERSON_INFO.TYPE=2 AND  DM_PERSON_INFO.HOUSEHOLD_TYPE=:houseHoldType GROUP BY DM_PERSON_INFO.CREATE_GBCODE ");
		}
		return this.getMapList(sb.toString(), cr);
	}
	@Override
	public List<Map<String, Object>> getCdmStatictics(String code,String organType,Date startDate,Date endDate) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		if (ObjectUtil.isNotEmpty(code)) {
			switch(organType){
				case "QWGZX":
					cr.add("DM_PERSON_INFO.CREATE_GBCODE", code);
					break;
				case "CENTER":
					cr.add("DM_PERSON_INFO.CREATE_CENTER_ORGAN_CODE", code);
					break;
				case "STATION":
					cr.add("DM_PERSON_INFO.CREATE_ORGAN_CODE", code);
					break;
			}
		}
		cr.add("status",1).add("type",2);
		cr.add(this.getHmCardDeleteStatus("DM_DISEASE_INFO.",EHRConstants.DM_MANAGED_FLAG));
		if(ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)){
			Criteria cr1 = new Criteria();
			cr1.add("DM_DISEASE_INFO.HBP_MANAGED_DATE",OP.BETWEEN, new Date[]{startDate,endDate});
			cr1.add(LOP.OR,"DM_DISEASE_INFO.DI_MANAGED_DATE",OP.BETWEEN, new Date[]{startDate,endDate});
			cr1.add(LOP.OR,"DM_DISEASE_INFO.TUMOR_MANAGED_DATE",OP.BETWEEN, new Date[]{startDate,endDate});
			cr1.add(LOP.OR,"DM_DISEASE_INFO.STROKE_MANAGED_DATE",OP.BETWEEN, new Date[]{startDate,endDate});
			cr1.add(LOP.OR,"DM_DISEASE_INFO.CORONARY_MANAGED_DATE",OP.BETWEEN, new Date[]{startDate,endDate});
			cr.add(cr1);
		}
		sb.append(" SELECT "+
				" SUM(CASE WHEN(DM_DISEASE_INFO.HBP_FLAG='2') THEN 1 ELSE 0 END) AS HBP_TOTAL,"+
				" SUM(CASE WHEN(DM_DISEASE_INFO.DI_FLAG='2') THEN 1 ELSE 0 END) AS DI_TOTAL,"+
				" SUM(CASE WHEN(DM_DISEASE_INFO.TUMOR_FLAG='2') THEN 1 ELSE 0 END) AS TUMOR_TOTAL,"+
				" SUM(CASE WHEN(DM_DISEASE_INFO.STROKE_FLAG='2') THEN 1 ELSE 0 END) AS STROKE_TOTAL,"+
				" SUM(CASE WHEN(DM_DISEASE_INFO.CORONARY_FLAG='2') THEN 1 ELSE 0 END) AS CORONARY_TOTAL,"+
				" CASE WHEN(DM_PERSON_INFO.HOUSEHOLD_TYPE='1') THEN '1' ELSE '2' END AS HOUSEHOLD_TYPE"+
				" FROM"+
				" DM_DISEASE_INFO"+
				" INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class,sb, cr);
		sb.append(" GROUP BY DM_PERSON_INFO.HOUSEHOLD_TYPE");
		return this.getMapList(sb.toString(), cr);
	}

	//================高血压综合指标计算=====================//

	private Criteria makeHbpDefaultCriteria() {
		Criteria criteria=new Criteria();
		criteria.add("DM_DISEASE_INFO.STATUS",EHRConstants.DM_MANAGE_STATUS_NORMAL);
		criteria.add("DM_DISEASE_INFO.HBP_FLAG",EHRConstants.DM_MANAGED_FLAG);
		criteria.add("DM_PERSON_INFO.TYPE",EHRConstants.DM_PERSON_MANGE_TYPE);
		return criteria;
	}


	@Override
	public Long getHbpCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) AS COUNT FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeHbpDefaultCriteria();
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DISEASE_INFO.HBP_MANAGED_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getHbpFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) COUNT FROM DM_HYPERTENSION_FOLLOWUP DM_HYPERTENSION_FOLLOWUP INNER JOIN DM_DISEASE_INFO DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_HYPERTENSION_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeHbpDefaultCriteria();
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_HYPERTENSION_FOLLOWUP.CREATE_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getHbpFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder(" SELECT COUNT (1) COUNT FROM DM_HYPERTENSION_FOLLOWUP DM_HYPERTENSION_FOLLOWUP INNER JOIN ( SELECT MAX (ID) ID FROM DM_HYPERTENSION_FOLLOWUP GROUP BY PERSON_ID ) B ON DM_HYPERTENSION_FOLLOWUP. ID = B. ID INNER JOIN DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_HYPERTENSION_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeHbpDefaultCriteria();
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_HYPERTENSION_FOLLOWUP.CREATE_DATE", startDate, endDate);
		//血压合格区间
		//成人 收缩压　 　90~140（12.0~18.7）　 60~90（8.0~12.0）
		criteria.add("DM_HYPERTENSION_FOLLOWUP.SBP", OP.BETWEEN, EHRConstants.SBP_OK_VALUE);
		criteria.add("DM_HYPERTENSION_FOLLOWUP.DBP", OP.BETWEEN, EHRConstants.DBP_OK_VALUE);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	//================糖尿病综合指标计算=====================//

	private Criteria makeDiDefaultCirteria(String DiType) {
		Criteria criteria=new Criteria();
		criteria.add("DM_DISEASE_INFO.STATUS",EHRConstants.DM_MANAGE_STATUS_NORMAL);
		criteria.add("DM_DISEASE_INFO.DI_FLAG",EHRConstants.DM_MANAGED_FLAG);
		criteria.add("DM_PERSON_INFO.TYPE",EHRConstants.DM_PERSON_MANGE_TYPE);
		if (ObjectUtil.isNotEmpty(DiType)) {
			criteria.add("DM_DISEASE_INFO.DI_TYPE","2");
		}
		return criteria;
	}

	@Override
	public Long getDiCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) AS COUNT FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeDiDefaultCirteria(null);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DISEASE_INFO.DI_MANAGED_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getDiFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) COUNT FROM DM_DIABETIC_FOLLOWUP DM_DIABETIC_FOLLOWUP INNER JOIN DM_DISEASE_INFO DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_DIABETIC_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeDiDefaultCirteria(null);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DIABETIC_FOLLOWUP.CREATE_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getDiFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder(" SELECT COUNT (1) COUNT FROM DM_DIABETIC_FOLLOWUP DM_DIABETIC_FOLLOWUP INNER JOIN ( SELECT MAX (ID) ID FROM DM_DIABETIC_FOLLOWUP GROUP BY PERSON_ID ) B ON DM_DIABETIC_FOLLOWUP. ID = B. ID INNER JOIN DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_DIABETIC_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID ");
		Criteria criteria = makeDiDefaultCirteria(null);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DIABETIC_FOLLOWUP.CREATE_DATE", startDate, endDate);
		criteria.add("DM_DIABETIC_FOLLOWUP.FPG", OP.BETWEEN, EHRConstants.BS_OK_VALUE);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getDiTypeTwoCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) AS COUNT FROM DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeDiDefaultCirteria(EHRConstants.DM_DI_TYPE_TWO);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DISEASE_INFO.CREATE_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getDiTypeTwoFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder("SELECT COUNT (1) COUNT FROM DM_DIABETIC_FOLLOWUP DM_DIABETIC_FOLLOWUP INNER JOIN DM_DISEASE_INFO DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_DIABETIC_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID");
		Criteria criteria = makeDiDefaultCirteria(EHRConstants.DM_DI_TYPE_TWO);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DIABETIC_FOLLOWUP.CREATE_DATE", startDate, endDate);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	@Override
	public Long getDiTypeTwoFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate) {
		StringBuilder sql=new StringBuilder(" SELECT COUNT (1) COUNT FROM DM_DIABETIC_FOLLOWUP DM_DIABETIC_FOLLOWUP INNER JOIN ( SELECT MAX (ID) ID FROM DM_DIABETIC_FOLLOWUP GROUP BY PERSON_ID ) B ON DM_DIABETIC_FOLLOWUP. ID = B. ID INNER JOIN DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID = DM_DIABETIC_FOLLOWUP.PERSON_ID INNER JOIN DM_PERSON_INFO ON DM_PERSON_INFO.PERSON_ID = DM_DISEASE_INFO.PERSON_ID ");
		Criteria criteria = makeDiDefaultCirteria(EHRConstants.DM_DI_TYPE_TWO);
		makeOrganCodeCondition(orgCode, criteria);
		makeDateRange(criteria, "DM_DIABETIC_FOLLOWUP.CREATE_DATE", startDate, endDate);
		criteria.add("DM_DIABETIC_FOLLOWUP.FPG", OP.BETWEEN, EHRConstants.BS_OK_VALUE);
		return queryAndGetCount(DmDiseaseInfo.class, sql, criteria);
	}

	private void makeOrganCodeCondition(List<String> orgCode, Criteria criteria) {
		if (ObjectUtil.isNotEmpty(orgCode)) {
			criteria.add("DM_DISEASE_INFO.CREATE_ORGAN_CODE",OP.IN,orgCode);
		}
	}

	private void makeDateRange(Criteria criteria,String column,Date startDate, Date endDate) {
		if (null != startDate && null == endDate) {
			criteria.add(column, OP.GE, startDate);
		} else if (null == startDate && null != endDate) {
			criteria.add(column, OP.LE, endDate);
		}
		if (null != startDate && null != endDate) {
			criteria.add(column, OP.BETWEEN, new Date[] { startDate,endDate});
		}
	}

	private Long queryAndGetCount(Class<?> clazz, StringBuilder sql, Criteria criteria) {
		SqlBuilder.buildWhereStatement(clazz, sql, criteria);
		Map<String, Object> resMap= getMap(sql.toString(), criteria);
		Object count=resMap.get("COUNT");
		if (null==count) {
			return 0L;
		}
		return Long.parseLong(count.toString());
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add(alias + "hbp_flag", isDelete);
		criteria.add(LOP.OR, alias + "di_flag", isDelete);
		criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
		criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
		criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
		return criteria;
	}

}