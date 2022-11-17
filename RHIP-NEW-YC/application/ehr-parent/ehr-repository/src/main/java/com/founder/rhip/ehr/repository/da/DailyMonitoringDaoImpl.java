package com.founder.rhip.ehr.repository.da;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.ExpenseInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.rhip.ehr.entity.clinic.ExpenseDetail;
import com.founder.rhip.ehr.entity.clinic.Pharmacy;
import com.founder.rhip.ehr.repository.da.IDailyMonitoringDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.annotation.Resource;

/**
 * DAO implement of 日常监控
 * 
 */
@Repository("dailyMonitoringDao")
public class DailyMonitoringDaoImpl extends	AbstractDao<DrugUsage, Long> implements IDailyMonitoringDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
     * 门诊标识
     */
    private static final String CLINIC_MARK_OUTPATIENT = "1";
    /**
     * 急诊标识
     */
    private static final String CLINIC_MARK_EMERGENCY = "2";
    
    /**
     * 住院标识
     */
    private static final String CLINIC_MARK_INPATIENT = "3";
    
    /**
     * 异常处方SQL
     */
    private static final String UNUSUAL_PRESCRIPTION_SQL = " SELECT HOSPITAL_CODE hospitalCode" 
    		+ ",NVL(PRESCRIPTION_TOTAL_COST,0) prescriptionTotalCost" 
    		+ ",PRESCRIBE_DATE prescribeDate"
    		+ ",CM_TYPE cmType"
    		+ ",PRESCRIBE_DOCTOR_NO prescribeDoctorNo" 
    		+ ",PRESCRIBE_DOCTOR_NAME prescribeDoctorName" 
    		+ " %1$s"
    		+ ",P.RECORD_NUMBER recordNumber" 
    		+ ",P.EHR_ID ehrId" 
    		+ " FROM MS_OUTPATIENT_PRESCRIPTION P"
    		+ " %2$s";
    /**
     * 异常指标：用量、天数
     */
    private static final String MONITOR_SQL = " LEFT JOIN ("
    		+ " SELECT EHR_ID,RECORD_NUMBER,MAX(%1$s) %1$s FROM MS_DRUG_USAGE"
    		+ " WHERE %1$s IS NOT NULL  %2$s"
    		+ " GROUP BY EHR_ID,RECORD_NUMBER"
    		+ " ) DRUG  ON P.EHR_ID = DRUG.EHR_ID AND P.RECORD_NUMBER = DRUG.RECORD_NUMBER";

    /**
     * 异常指标：处方品种数
     */
    private static final String PRESCRIPTION_KIND_SQL = " LEFT JOIN ("
    		+ " SELECT COUNT(*) PRESCRIPTION_TOTAL_COUNT,EHR_ID,RECORD_NUMBER  FROM MS_DRUG_USAGE"
    		+ " WHERE EXPENSE_TYPE = 1 %1$s"//类型为药品
    		+ " GROUP BY EHR_ID,RECORD_NUMBER"    		
    		+ " ) DRUG  ON P.EHR_ID = DRUG.EHR_ID AND P.RECORD_NUMBER = DRUG.RECORD_NUMBER";    
    /**
     * 医生用药SQL
     */
    private static final String PHYSICIAN_DRUG_SQL = " SELECT REFERRAL_HOSPITAL_CODE hospitalCode" //机构编码
    		+ ",DRUG_MEDICARE_CODE medicareCode,MAX(DRUG_GENERIC_NAME) drugGenericName" //药品医保编码
    		+ ",NVL(SUM(UNIT_PRICE*QUANTITY),0) totalCost"//总金额//TODO:需要修改成TOTAL_COST
    		+ ",NVL(SUM(DRUG_USE_TOTAL_DOSE),0) totalDose"//总用量
    		+ ",COUNT(DISTINCT RECORD_NUMBER) recordNumber"//处方数/医嘱数
    		+ ",ROUND(DECODE(SIGN(COUNT(DISTINCT RECORD_NUMBER)),0,0,NVL(SUM(DRUG_USE_TOTAL_DOSE),0)/COUNT(DISTINCT RECORD_NUMBER)),2)  avgDose" //平均用量
    		+ ",ROUND(DECODE(SIGN(COUNT(DISTINCT RECORD_NUMBER)),0,0,NVL(SUM(DRUG_USE_DAYS),0)/COUNT(DISTINCT RECORD_NUMBER)),2)  avgDays" //平均天数
    		+ " FROM MS_DRUG_USAGE" 
    		+ " %1$s"  //条件 
    		+ " GROUP BY REFERRAL_HOSPITAL_CODE,DRUG_MEDICARE_CODE"
    		+ " ORDER BY REFERRAL_HOSPITAL_CODE,totalCost desc";

    /**
     * 医师用药排名SQL
     * %1$s:查询条件
     * %2$s：处方类型/医嘱类型
     * %3$s：开具处方时间：医嘱下达时间
     */
    private static final String MEDICATION_RANKING_SQL = "SELECT total.DOCTOR_NO doctorNo,doctor.RECORD_COUNT recordCount,total.DOCTOR_NAME doctorName" 
    		+ ",total.REFERRAL_HOSPITAL_CODE hospitalCode,total.EHR_ID ehrId,total.RECORD_NUMBER recordNumber"
    		+ ",total.total_Cost totalCost ,total.%2$s cmType,total.%3$s clinicDate FROM (" 
    		+ " SELECT REFERRAL_HOSPITAL_CODE,EHR_ID,RECORD_NUMBER,%2$s,%3$s,DOCTOR_NO,MAX(DOCTOR_NAME) DOCTOR_NAME "
    		+ " , NVL(SUM(UNIT_PRICE*QUANTITY),0) total_Cost FROM MS_DRUG_USAGE"
    		+ " %1$s "
    		+" GROUP BY REFERRAL_HOSPITAL_CODE,EHR_ID,RECORD_NUMBER,%2$s,%3$s,DOCTOR_NO) total"
    		+ " LEFT JOIN("//医生开具处方/医嘱数
    		+" SELECT DOCTOR_NO,COUNT(DOCTOR_NO) RECORD_COUNT FROM("
    		+" SELECT EHR_ID,RECORD_NUMBER,DOCTOR_NO,DOCTOR_NAME FROM MS_DRUG_USAGE"
    		+ " %1$s "
    		+ " GROUP BY EHR_ID,RECORD_NUMBER,DOCTOR_NO)"
    		+ " GROUP BY DOCTOR_NO"
    		+ " ) doctor on doctor.DOCTOR_NO = total.doctor_no"
    		+" ORDER BY RECORD_COUNT DESC,totalCost desc";
    
    /**
     * 费用表中,药品费编码
     */
    private static final String DRUG_TYPE_CODE = "'01','02','03'";
    
    /**
     * 门急诊/住院费用药品比例
     */
    private static final String DRUG_RATIO_SQL = "SELECT HOSPITAL_CODE hospitalCode" 
    		+ " ,NVL(SUM(DRUG_COST),0) drugCostSum" //药品费用
    		+ " ,NVL(SUM(TOTAL_COST),0) totalCostSum" //总费用
    		+ " ,NVL(DECODE(SIGN(SUM(TOTAL_COST)),0,0,ROUND(SUM(DRUG_COST)/SUM(TOTAL_COST),4)),0) drugRate"//药占比
    		+ " FROM (SELECT HOSPITAL_CODE"//医院编号
    		+ " ,CASE WHEN COST_TYPE_CODE IN("+ DRUG_TYPE_CODE +") THEN TOTAL_COST ELSE 0 END DRUG_COST"//药品费用
    		+ " ,TOTAL_COST" //总费用
    		+ " ,SETTLEMENT_DATE "//--费用时间
    		+ " ,OP_EM_HP_MARK "//门诊/急诊/住院标志
    		+ " FROM MS_EXPENSE_INFO"
    		+ " %1$s )"
    		+ " GROUP BY HOSPITAL_CODE"
    		+ " ORDER BY drugCostSum DESC";
 
    /**
     * 门急诊/住院药品明细
     */
    private static final String DRUG_DETAIL_SQL = "select total.*"
    		+ " ,pharmacy.specifications"//规格
    		+ " ,pharmacy.packaging"//包装
    		+ " ,pharmacy.SOURCE_TYPE sourceType"//产地
    		+ " ,pharmacy.fac_Name facName"//生产厂家
    		+ " ,pharmacy.WHOLESALE_PRICE  wholesalePrice"//批发价格
    		+ " ,pharmacy.RETAIL_PRICE retailPrice"//零售价格
    		+ " ,pharmacy.DRUG_GENERIC_NAME genericName"
    		+ " ,pharmacy.DRUG_TRADE_NAME tradeName"    		
    		+ " FROM("
    		+ " SELECT HOSPITAL_CODE hospitalCode" 
    		+ " ,MEDICARE_CODE drugCode" 
    		+ " ,NVL(SUM(QUANTITY),0) quantitySum" //数量
    		+ " ,NVL(SUM(DRUG_COST),0) costSum" //总费用
    		+ " ,BATCH_NO batchNo"//批次号
    		+ " FROM (SELECT HOSPITAL_CODE"//医院编号
    		+ " ,MEDICARE_CODE"//药品医保编码/耗材编码/处置编码
    		+ " ,DETAIL_ITEM_QUANTITY"//数量
    		+ " ,DECODE(EXPENSE_TYPE,1,DETAIL_ITEM_QUANTITY,0) QUANTITY"//数量
    		+ " ,DECODE(EXPENSE_TYPE,1,(DETAIL_ITEM_PRICE*DETAIL_ITEM_QUANTITY),0) DRUG_COST"//总金额
    		+ " ,CLINIC_DATE"//--费用时间
    		+ " ,CLINIC_MARK"//门诊/急诊/住院标志
    		+ " ,EXPENSE_TYPE"//药品/耗材/处置等标志
    		+ " ,BATCH_NO"
    		+ " FROM MS_EXPENSE_DETAIL"
    		+ " %1$s )"
    		+ " GROUP BY HOSPITAL_CODE,MEDICARE_CODE,BATCH_NO"
    		+ " ORDER BY costSum DESC"
    		+ " ) total"
    		+ " LEFT JOIN DA_PHARMACY pharmacy ON "
    		+ " (pharmacy.ORGAN_CODE = total.hospitalCode "
    		+ " and pharmacy.drug_Medicare_Code=total.drugCode"
    		+ " and pharmacy.BATCH_NO = total.batchNo) %2$s";

    
    /**
     * 门急诊/住院费用明细
     */
    private static final String ITEM_DETAIL_SQL="select total.*"
    		+ " ,DECODE(total.expenseType,1,pharmacy.specifications,2,consumable.specifications,'') specifications"
    		+ " ,DECODE(total.expenseType,1,pharmacy.packaging,2,consumable.packaging,'') packaging"
    		+ " ,DECODE(total.expenseType,1,pharmacy.SOURCE_TYPE,2,consumable.SOURCE_TYPE,'') sourceType"
    		+ " ,DECODE(total.expenseType,1,pharmacy.FAC_NAME,2,consumable.FAC_NAME,'') facName"
    		+ " ,DECODE(total.expenseType,1,pharmacy.WHOLESALE_PRICE,2,consumable.WHOLESALE_PRICE,'') wholesalePrice"
    		+ " ,DECODE(total.expenseType,1,pharmacy.RETAIL_PRICE,2,consumable.RETAIL_PRICE,'') retailPrice"
    		+ " ,DECODE(total.expenseType,1,pharmacy.DRUG_GENERIC_NAME,2,consumable.GENERIC_NAME,'') genericName"
    		+ " ,DECODE(total.expenseType,1,pharmacy.DRUG_TRADE_NAME,2,consumable.TRADE_NAME,'') tradeName"
    		+ " FROM("
    		+ " SELECT HOSPITAL_CODE hospitalCode" 
    		+ " ,MEDICARE_CODE drugCode" 
    		+ " ,NVL(SUM(QUANTITY),0) quantitySum" //数量
    		+ " ,NVL(SUM(DRUG_COST),0) costSum" //总费用
    		+ " ,EXPENSE_TYPE expenseType"
    		+ " ,BATCH_NO batchNo"//批次号    		
    		+ " FROM (SELECT HOSPITAL_CODE"//医院编号
    		+ " ,MEDICARE_CODE"//药品医保编码/耗材编码/处置编码
    		+ " ,DETAIL_ITEM_QUANTITY"//数量
    		+ " ,DETAIL_ITEM_QUANTITY QUANTITY"//数量
    		+ " ,(DETAIL_ITEM_PRICE*DETAIL_ITEM_QUANTITY) DRUG_COST"//总金额
    		+ " ,CLINIC_DATE"//--费用时间
    		+ " ,CLINIC_MARK"//门诊/急诊/住院标志
    		+ " ,EXPENSE_TYPE"//药品/耗材/处置等标志
    		+ " ,BATCH_NO"    		
    		+ " FROM MS_EXPENSE_DETAIL"
    		+ " %1$s )"
    		+ " GROUP BY HOSPITAL_CODE,MEDICARE_CODE,BATCH_NO,EXPENSE_TYPE"
    		+ " ORDER BY costSum DESC"
    		+ " ) total"
    		+ " LEFT JOIN DA_PHARMACY pharmacy ON "
    		+ " (pharmacy.ORGAN_CODE = total.hospitalCode "
    		+ " and pharmacy.drug_Medicare_Code=total.drugCode"
    		+ " and pharmacy.BATCH_NO = total.batchNo)"
			+ " LEFT JOIN DA_CONSUMABLE_STORE consumable ON "
			+ " (consumable.ORGAN_CODE = total.hospitalCode "
			+ " and consumable.MEDICARE_CODE=total.drugCode"
			+ " and consumable.BATCH_NO = total.batchNo) %2$s";


    /**
     * 药品价格监控列表
     */
    private static final String DRUG_PRICE_SQL="SELECT detail.HOSPITAL_CODE hospitalCode"
    		+ " ,detail.MEDICARE_CODE medicareCode"
    		+ " ,detail.BATCH_NO batchNo"
    		+ " ,pharmacy.DRUG_GENERIC_NAME genericName"//药品通用名
    		+ " ,pharmacy.DRUG_TRADE_NAME tradeName"//药品商用名称
    		+ " ,pharmacy.specifications"//规格
    		+ " ,pharmacy.packaging"//包装
    		+ " ,pharmacy.SOURCE_TYPE sourceType"//产地
    		+ " ,pharmacy.fac_Name facName"//生产厂家
    		+ " ,pharmacy.WHOLESALE_PRICE  wholesalePrice"//批发价格
    		+ " ,pharmacy.RETAIL_PRICE retailPrice"//零售价格
    		+ " ,NVL(pharmacy.WHOLESALE_PRICE-pharmacy.RETAIL_PRICE,0) priceDifference"//价格差 TODO:暂定
    		+ " ,ROUND(DECODE(SIGN(NVL(pharmacy.WHOLESALE_PRICE,0)),0,0,NVL(pharmacy.WHOLESALE_PRICE-pharmacy.RETAIL_PRICE,0)/pharmacy.WHOLESALE_PRICE),2) diffdrenceRate"//差价率
    		+ " ,EXPIRY_DT expiryDt"//失效日期
    		+ " FROM ("
    		+ " SELECT HOSPITAL_CODE,MEDICARE_CODE,BATCH_NO FROM MS_EXPENSE_DETAIL"
    		+ " WHERE EXPENSE_TYPE = 1 AND MEDICARE_CODE is not null and BATCH_NO is not null %2$s"//只查药品
    		+ " GROUP BY HOSPITAL_CODE,MEDICARE_CODE,BATCH_NO"
    		+ " ) detail"
    		+ " LEFT JOIN DA_PHARMACY pharmacy ON "
    		+ " (pharmacy.Organ_Code = detail.HOSPITAL_CODE"
    		+ " and pharmacy.drug_Medicare_Code=detail.MEDICARE_CODE"
    		+ " and pharmacy.BATCH_NO = detail.BATCH_NO) "
    		+ " %1$s"
    		+ " ORDER BY HOSPITAL_CODE";
   
    /**
     * 药品分布监控列表
     */
    private static final String DRUG_DISTRIBUTION_SQL = " SELECT * FROM(" 
    		+ "SELECT a.purchaseNum "
    		+ " ,decode(A.ORGAN_CODE,null,decode(b.ORGAN_CODE,null,decode(c.ORGAN_CODE,null,'',c.ORGAN_CODE),b.ORGAN_CODE),A.ORGAN_CODE) organCode"
    		+ " ,decode(A.DRUG_MEDICARE_CODE,null,decode(b.DRUG_MEDICARE_CODE,null,decode(c.DRUG_MEDICARE_CODE,null,'',c.DRUG_MEDICARE_CODE),b.DRUG_MEDICARE_CODE),A.DRUG_MEDICARE_CODE) medicareCode"
    		+ " ,B.STORAGE_NUM storageNum,C.PHARMACY_NUM pharmacyNum,C.ROOM_NUM roomNum"
    		+ " ,decode(A.GENERIC_NAME,null,decode(b.GENERIC_NAME,null,decode(c.GENERIC_NAME,null,'',c.GENERIC_NAME),b.GENERIC_NAME),A.GENERIC_NAME) genericName"
    		+ " ,decode(A.TRADE_NAME,null,decode(b.TRADE_NAME,null,decode(c.TRADE_NAME,null,'',c.TRADE_NAME),b.TRADE_NAME),A.TRADE_NAME) tradeName"    		
    		+ " FROM ("
    		+ " SELECT ORGAN_CODE ,DRUG_MEDICARE_CODE ,SUM(PURCHASE_NUM) purchaseNum,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME  FROM ("
    		+ " SELECT STORAGEIN.BATCH_NO,STORAGEIN.ORGAN_CODE,STORAGEIN.STORAGE_DT,"
    		+ " DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ " FROM DA_STORAGE_IN_DETAIL DETAIL"
    		+ " LEFT JOIN  DA_STORAGE_IN STORAGEIN ON DETAIL.BATCH_NO = STORAGEIN.BATCH_NO"
    		+ " %1$s"
    		+ " )GROUP BY  ORGAN_CODE,DRUG_MEDICARE_CODE ) A"//药库入库
    		+ " FULL OUTER JOIN ("
    		+ " SELECT ORGAN_CODE,DRUG_MEDICARE_CODE,SUM(STORAGE_NUM) STORAGE_NUM,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME FROM ("
    		+ " SELECT ORGAN_CODE,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME,STORAGE_NUM"
    		+ " FROM DA_STORAGE "
    		+ " %1$s "
    		+ " )GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE ) B"//药库库存
    		+ "  ON (A.ORGAN_CODE = B.ORGAN_CODE AND A.DRUG_MEDICARE_CODE = B.DRUG_MEDICARE_CODE)"
    		+ " FULL OUTER JOIN ("
    		+ " SELECT ORGAN_CODE,DRUG_MEDICARE_CODE,SUM(PHARMACY_NUM) PHARMACY_NUM,SUM(ROOM_NUM) ROOM_NUM,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME  FROM ("
    		+ " SELECT ORGAN_CODE,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME"
    		+ " ,DECODE(PHARMACY_TYPE_CODE,'1',PHARMACY_NUM,'2',PHARMACY_NUM,0) PHARMACY_NUM"//药房库存
    		+ " ,DECODE(PHARMACY_TYPE_CODE,'3',PHARMACY_NUM,0) ROOM_NUM"//科室库存
    		+ " FROM DA_PHARMACY"
    		+ " %1$s "
    		+ " )GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE ) C"//药房、科室库存
    		+ " ON ((A.ORGAN_CODE = C.ORGAN_CODE AND A.DRUG_MEDICARE_CODE = C.DRUG_MEDICARE_CODE)"
    		+ " OR(B.ORGAN_CODE = C.ORGAN_CODE	AND B.DRUG_MEDICARE_CODE = C.DRUG_MEDICARE_CODE))" 
    		+ " ) ORDER BY organCode,MEDICARECODE";

	/**
	 * 获取异常处方列表
	 *
	 * @param page
	 * @param criteria
	 * @param order
	 * @param monitorIndex
	 * @return
	 * @note monitorIndex = 1:处方金额
	 * @note monitorIndex = 2:用量
	 * @note monitorIndex = 3:天数
	 * @note monitorIndex = 4:处方品种
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page, Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap) {
		StringBuilder sql = new StringBuilder(UNUSUAL_PRESCRIPTION_SQL);
		String monitorField =" ";
		String monitorSql = " ";
		String whereStr = "";
		switch (monitorIndex){
			case "1":
				monitorField = " ";
				monitorSql = " ";
				break;
			case "2":
				monitorField = " ,DRUG_USE_TOTAL_DOSE drugUseTotalDose";
				monitorSql = MONITOR_SQL;
				whereStr = getUnusualPrescriptionSql(monitorIndex,paramMap);
				monitorSql = String.format(monitorSql, "DRUG_USE_TOTAL_DOSE",whereStr);
				break;
			case "3":
				monitorField = " ,DRUG_USE_DAYS drugUseDays";
				monitorSql = MONITOR_SQL;
				whereStr = getUnusualPrescriptionSql(monitorIndex,paramMap);
				monitorSql = String.format(monitorSql, "DRUG_USE_DAYS",whereStr);				
				break;
			case "4":
				monitorField = " ,DRUG.PRESCRIPTION_TOTAL_COUNT prescriptionTotalCount";
				monitorSql = PRESCRIPTION_KIND_SQL;
				whereStr = getUnusualPrescriptionSql(monitorIndex,paramMap);
				monitorSql = String.format(monitorSql,whereStr);
				break;				
		}
		String lastSql = String.format(sql.toString(), monitorField,monitorSql);
		sql = new StringBuilder(lastSql);
		SqlBuilder.buildWhereStatement(OutpatientPrescription.class, sql, criteria);
        if(ObjectUtil.isNotEmpty(order)) {
            sql.append(order.toString());
        }
		return this.getPageMapList(page, sql.toString(), criteria);
	}
	
	private String getUnusualPrescriptionSql(String monitorIndex,Map<String,String> paramMap){
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		String hospitalCode = paramMap.get("hospitalCode");
		String monitorValue = paramMap.get("monitorValue");
		StringBuilder  result = new StringBuilder();
		switch (monitorIndex){
			case "2":
				if(StringUtil.isNotEmpty(monitorValue)){
					result.append(" AND DRUG_USE_TOTAL_DOSE > '" + monitorValue + "'");
				}
				if(StringUtil.isNotEmpty(beginDate) && StringUtil.isNotEmpty(endDate) ){
					result.append( " AND (CLINIC_DATE>=TO_DATE('"+ beginDate + "','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('" + endDate + "','yyyy/MM/dd'))");
				}
				if(StringUtil.isNotEmpty(hospitalCode)){
					result.append( " AND REFERRAL_HOSPITAL_CODE = '" + hospitalCode + "'");
				}				
				break;
			case "3":
				if(StringUtil.isNotEmpty(monitorValue)){
					result.append(" AND DRUG_USE_DAYS > '" + monitorValue + "'");
				}
				if(StringUtil.isNotEmpty(beginDate) && StringUtil.isNotEmpty(endDate) ){
					result.append( " AND (CLINIC_DATE>=TO_DATE('"+ beginDate + "','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('" + endDate + "','yyyy/MM/dd'))");
				}
				if(StringUtil.isNotEmpty(hospitalCode)){
					result.append( " AND REFERRAL_HOSPITAL_CODE = '" + hospitalCode + "'");
				}				
				break;
			case "4":
				if(StringUtil.isNotEmpty(beginDate) && StringUtil.isNotEmpty(endDate) ){
					result.append( " AND (CLINIC_DATE>=TO_DATE('"+ beginDate + "','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('" + endDate + "','yyyy/MM/dd'))");
				}
				if(StringUtil.isNotEmpty(hospitalCode)){
					result.append( " AND REFERRAL_HOSPITAL_CODE = '" + hospitalCode + "'");
				}					
				break;				
		}
		return result.toString();
	}
	
	/**
	 * 获取医生用药列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getPhysicianDrugList(String patientType,Page page,Criteria criteria){
		StringBuilder sql = new StringBuilder(PHYSICIAN_DRUG_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(DrugUsage.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),whereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
	}

	/**
	 * 获取医师用药排名列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getMedicationRankingList(String patientType,Page page, Criteria criteria) {
		StringBuilder sql = new StringBuilder(MEDICATION_RANKING_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(DrugUsage.class, whereSQL, criteria);
		String searchType = "";
		String searchDate ="";
		if(patientType.equals(EventType.OUTPATIENT.getCode())){//门急诊
			searchType = "CM_TYPE";//处方类型
			searchDate = "CLINIC_DATE";	//处方开具时间
		}else{//住院
			searchType = "ODR_TYPE";//医嘱类型（临时医嘱、长期医嘱）
			searchDate = "ODRISU_DT";	//医嘱下达时间
		}			
		String lastSql = String.format(sql.toString(),whereSQL.toString(),searchType,searchDate);
		return this.getPageMapList(page, lastSql, criteria);
	}
	
	/**
	 * 获取药品费用占比列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugCostList(String patientType,Page page, Criteria criteria) {
		StringBuilder sql = new StringBuilder(DRUG_RATIO_SQL);
		StringBuilder  totalCostWhereSQL = new StringBuilder();
		if(patientType.equals(EventType.OUTPATIENT.getCode())){//门急诊
			criteria.add("OP_EM_HP_MARK",OP.IN,new String[]{CLINIC_MARK_OUTPATIENT,CLINIC_MARK_EMERGENCY});	//门诊、急诊	
			SqlBuilder.buildWhereStatement(ExpenseInfo.class, totalCostWhereSQL, criteria);
		}else{//住院
			criteria.add("OP_EM_HP_MARK",CLINIC_MARK_INPATIENT);
			SqlBuilder.buildWhereStatement(ExpenseInfo.class, totalCostWhereSQL, criteria);
		}	
		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
	}	
	
	/**
	 * 获取药品明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String,Object>> getDrugDetailList(String patientType,Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder(DRUG_DETAIL_SQL);
		StringBuilder  totalCostWhereSQL = new StringBuilder();
		criteria.add("EXPENSE_TYPE",1);
		
		//关键字(通用名/商用名),要药品库存中查询
		Object itemName = criteria.get("DETAIL_ITEM_NAME");
		criteria.remove("DETAIL_ITEM_NAME");
		StringBuilder pharmacyWhere = new StringBuilder();
		if(ObjectUtil.isNotEmpty(itemName)){
			pharmacyWhere.append(" WHERE pharmacy.DRUG_GENERIC_NAME LIKE '%" + itemName.toString() +"%'");
			pharmacyWhere.append(" OR pharmacy.DRUG_TRADE_NAME LIKE '%" + itemName.toString() +"%'");
		}
		
		if(patientType.equals(EventType.OUTPATIENT.getCode())){//门急诊
			criteria.add("CLINIC_MARK",OP.IN,new String[]{CLINIC_MARK_OUTPATIENT,CLINIC_MARK_EMERGENCY});	//门诊、急诊	
			SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
		}else{//住院
			criteria.add("CLINIC_MARK",CLINIC_MARK_INPATIENT);
			SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
		}	
		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString(),pharmacyWhere.toString());
		return this.getPageMapList(page, lastSql, criteria);
	}
	
	/**
	 * 获取费用明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String,Object>> getItemDetailList(String patientType,Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder(ITEM_DETAIL_SQL);
		StringBuilder  totalCostWhereSQL = new StringBuilder();
	
		//关键字(通用名/商用名),要耗材库存中查询
		Object itemName = criteria.get("DETAIL_ITEM_NAME");
		criteria.remove("DETAIL_ITEM_NAME");
		StringBuilder consumableWhere = new StringBuilder();
		if(ObjectUtil.isNotEmpty(itemName)){
			consumableWhere.append(" WHERE consumable.GENERIC_NAME LIKE '%" + itemName.toString() +"%'");
			consumableWhere.append(" OR consumable.TRADE_NAME LIKE '%" + itemName.toString() +"%'");
			consumableWhere.append(" OR pharmacy.DRUG_GENERIC_NAME LIKE '%" + itemName.toString() +"%'");
			consumableWhere.append(" OR pharmacy.DRUG_TRADE_NAME LIKE '%" + itemName.toString() +"%'");			
		}
		
		criteria.add("DETAIL_ITEM_CODE",OP.UEMPTY,"");
		if(patientType.equals(EventType.OUTPATIENT.getCode())){//门诊费用详细
			criteria.add("CLINIC_MARK",OP.IN,new String[]{CLINIC_MARK_OUTPATIENT,CLINIC_MARK_EMERGENCY});	//门诊、急诊	
			SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
		}else{//住院
			criteria.add("CLINIC_MARK",CLINIC_MARK_INPATIENT);
			SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
		}	
		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString(),consumableWhere.toString());
		return this.getPageMapList(page, lastSql, criteria);		
	}
	
	/**
	 * 获取药品价格监控列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugPriceList(Page page, Criteria criteria) {
//		StringBuilder sql = new StringBuilder(DRUG_PRICE_SQL);
//		StringBuilder  totalCostWhereSQL = new StringBuilder();
//		Object hospitalCode = criteria.get("HOSPITAL_CODE");
//		String expenseWhere = "";
//		if(ObjectUtil.isNotEmpty(hospitalCode)){
//			expenseWhere = " AND HOSPITAL_CODE = '" + hospitalCode + "'";
//		}
//		SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
//		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString(),expenseWhere);

        StringBuilder sql = new StringBuilder("SELECT pharmacy.Organ_Code hospitalCode,\n" +
                "       pharmacy.drug_Medicare_Code medicareCode,\n" +
                "       pharmacy.BATCH_NO batchNo,\n" +
                "       pharmacy.DRUG_GENERIC_NAME genericName,\n" +
                "       pharmacy.DRUG_TRADE_NAME tradeName,\n" +
                "       pharmacy.specifications,\n" +
                "       pharmacy.packaging,\n" +
                "       pharmacy.SOURCE_TYPE sourceType,\n" +
                "       pharmacy.fac_Name facName,\n" +
                "       pharmacy.WHOLESALE_PRICE wholesalePrice,\n" +
                "       pharmacy.RETAIL_PRICE retailPrice,\n" +
                "       NVL(pharmacy.WHOLESALE_PRICE - pharmacy.RETAIL_PRICE, 0) priceDifference,\n" +
                "       ROUND(DECODE(SIGN(NVL(pharmacy.WHOLESALE_PRICE, 0)),\n" +
                "                    0,\n" +
                "                    0,\n" +
                "                    NVL(pharmacy.WHOLESALE_PRICE - pharmacy.RETAIL_PRICE, 0) /\n" +
                "                    pharmacy.WHOLESALE_PRICE),\n" +
                "             2) diffdrenceRate,\n" +
                "       EXPIRY_DT expiryDt\n" +
                "\n" +
                "  FROM DA_PHARMACY pharmacy");
        SqlBuilder.buildWhereStatement(Pharmacy.class, sql, criteria);
		return this.getPageMapList(page, sql.toString(), criteria);
	}	
	

}