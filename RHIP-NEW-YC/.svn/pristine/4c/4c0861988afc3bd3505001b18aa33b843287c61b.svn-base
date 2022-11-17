package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.mdm.app.IDictionaryApp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of VaccinationMgmt
 * 
 */
@Repository("vaccinationMgmtDao")
public class VaccinationMgmtDaoImpl extends AbstractDao<VaccinationMgmt, String> implements IVaccinationMgmtDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Autowired
    private IDictionaryApp dictionaryApp;
	
    public PageList<VaccinationMgmt> getVaccinationMgmtList(Page page, Criteria criteria){
        StringBuilder sql = new StringBuilder(" SELECT * FROM DC_VACCINATION_MGMT ");
        SqlBuilder.buildWhereStatement(VaccinationMgmt.class, sql, criteria);
        sql.append(" AND NEIGHBORHOOD_ADDRESS NOT LIKE '--数据导入%' ");
        sql.append(" ORDER BY REGISTER_DATE DESC nulls last");
        return getPageList(page, sql.toString(), criteria);
    }

	@Override
	public List<Map<String, Object>> exportVaccineList(Page page, Criteria criteria) {
		StringBuilder sb = new StringBuilder(" SELECT distinct VE.CREATOR,VE.CREATE_ORG,VE.CREATE_DATE,DECODE(VE.IS_INJECTED,'1','是','2','否')IS_INJECTED,VE.LAST_INJECTED_DATE,VE.COMPLETE_FLAG,DH.HURT_TYPE,DH.TREATMENT_TIME,DH.OPS_DATE,DH.BITE_LEVEL, \n");
    	sb.append(" DI.VACCINATION_DATE,DI.VACCINE_MEASUREMENT,DI.VACCINE_FACTORY,DI.VACCINE_LOT_NUMBER,DI.VACCINATION_UNIT_NAME,DI.VACCINATION_WEIGHT,DI.VACCINATION_DOCTOR_NAME,DI.IMMU_UNIT_ID,MGMT.NAME,\n");
    	sb.append(" MGMT.IDCARD,MGMT.GENDER,MGMT.PATOWN_SHIP,MGMT.PASTREET,MGMT.PAHOUSE_NUMBER,MGMT.PHONE_NUMBER FROM \n");
    	sb.append(" DC_VACCINATION_EVENT VE LEFT JOIN DC_VACCINATION_MGMT MGMT ON VE.PERSON_ID = MGMT.PERSON_ID \n" +
				"LEFT JOIN SY_DHS_TRAUMA_HISTORY DH ON VE.PERSON_ID=DH.PERSON_ID\n" +
				"LEFT JOIN DC_VACCINATION_INFO DI ON DI.PERSON_ID=VE.PERSON_ID AND VE.EHR_ID=DI.EHR_ID \n");
    	SqlBuilder.buildWhereStatement(VaccinationEvent.class, sb, criteria);
    	SqlBuilder.buildOrderStatement(sb, "CREATE_DATE DESC");
    	PageList<Map<String, Object>> mapList = this.getPageMapList(page, sb.toString(), criteria);
    	List<Map<String, Object>>  result = (null == mapList ? null : mapList.getList());
    	if (null==result) {
			result=Collections.emptyList();
		}
    	
    	for (Map<String, Object> map : result) {
    		if(ObjectUtil.isNotEmpty(map.get("patown_Ship")) && ObjectUtil.isNotEmpty(map.get("pastreet")) && ObjectUtil.isNotEmpty(map.get("pahouse_Number")) && ObjectUtil.isNotEmpty(dictionaryApp.queryDicItem("FS990001", String.valueOf(map.get("pastreet")))) ){
    			String paaddress = dictionaryApp.queryDicItem("FS990001", String.valueOf(map.get("patown_Ship"))).getItemName()+
    					dictionaryApp.queryDicItem("FS990001", String.valueOf(map.get("pastreet"))).getItemName()+
    					String.valueOf(map.get("pahouse_Number"));
    			map.put("paaddress", paaddress);	
    		}
			map.put("birthday", ObjectUtil.isNullOrEmpty(map.get("idcard")) ? null : IDCardUtil.getBirthByIdCard(String.valueOf(map.get("idcard"))));
			map.put("age", ObjectUtil.isNullOrEmpty(map.get("idcard")) ? null : IDCardUtil.getAgeByIdCard(String.valueOf(map.get("idcard"))));
			getReservationDate(map);
			//预防接种首页导出名字不包含'*'
//			setName(map);
		}
		return result;

	}
	private void setName(Map<String, Object> map){
		StringBuffer sb=new StringBuffer();
		String name=String.valueOf(map.get("name"));
		sb.append(name.substring(0, 1));
		for (int i = 0; i < name.length()-1; i++) {
			sb.append("*");
		}
		map.put("name", sb.toString());
	}
	
	private void getReservationDate(Map<String, Object> map){
		 SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date visitDate = (Date) map.get("CREATE_DATE");
		Date lastInjectedDate = (Date) map.get("LAST_INJECTED_DATE");
		String vaccintionFlag = String.valueOf(map.get("FLAG"));
		if(ObjectUtil.isNullOrEmpty(visitDate)){
			visitDate = new Date();
		}
		if(ObjectUtil.isNullOrEmpty(lastInjectedDate)){
			lastInjectedDate = new Date();
		}
		if (StringUtils.equals(vaccintionFlag, "0") || StringUtils.isBlank(vaccintionFlag)) {// 非加强针
			
			map.put("firstdate", visitDate);
			map.put("seconddate", bartDateFormat.format(DateUtil.getAfterDay(visitDate, 7)));
			map.put("thirddate",  bartDateFormat.format(DateUtil.getAfterDay(visitDate, 21)));
		} else { // 加强针
			
//			int ret = vaccineService.analyseLastVaccineDate(firstDate, personId);
			// 计算最近接种时间与本次就诊时间相差的天数
			int days = DateUtil.getBetweenDays(lastInjectedDate, visitDate);
			// 距离最后一次接种日期大于183天且小于等于365天打两针，分别为0、3天注射
			if (days > 183 && days <= 365) {
				map.put("firstdate", visitDate);
				map.put("seconddate",  bartDateFormat.format(DateUtil.getAfterDay(visitDate, 3)));
			} else if (days > 365 && days <= 365*3) { // 距离最后一次接种日期大于365天且小于等于3年的大三针，分别为0、3、7天注射，第一针打一针
				map.put("firstdate", visitDate);
				map.put("seconddate", bartDateFormat.format(DateUtil.getAfterDay(visitDate, 3)));
				map.put("thirddate", bartDateFormat.format(DateUtil.getAfterDay(visitDate, 7)));
			} else if (days > 365*3) { // 距离最后一次接种日期大于3年以上重新接种，并且第一次打两针
				map.put("firstdate", visitDate);
				map.put("seconddate", bartDateFormat.format(DateUtil.getAfterDay(visitDate, 3)));
				map.put("thirddate", bartDateFormat.format(DateUtil.getAfterDay(visitDate, 7)));
			//	map.put("fourThDate", visitDate); // 便于页面判断第一针打两针
			}
		}
	}
}