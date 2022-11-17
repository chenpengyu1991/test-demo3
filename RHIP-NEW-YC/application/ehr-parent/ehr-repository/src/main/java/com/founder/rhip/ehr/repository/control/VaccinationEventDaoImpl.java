package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of VaccinationInfo
 * 
 */
@Repository("vaccinationEventDao")
public class VaccinationEventDaoImpl extends AbstractDao<VaccinationEvent, String> implements IVaccinationEventDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /*public static String RABIES_STATISTICS_SQL = "select decode(grouping_id(t.create_org),1,'合计',t.create_org) org_code,"
    		+ " count(distinct t.ehr_id) person_num,"
    		+ " sum(decode(i.immu_type, '5', 1, 0)) imm_person_num,"
    		+ " sum(decode(i.immu_type, '1', i.vaccine_measurement, 0)) vaccine_num,"
    		+ " sum(decode(i.immu_type, '5', i.vaccine_measurement, 0))/200 imm_num"
    		+ " from (select create_org,ehr_id,immu_type from DC_VACCINATION_EVENT where IS_DELETE=0 %1$s)t left join Dc_Vaccination_Info i"
    		+ " on t.ehr_id = i.ehr_id and t.immu_type = '1' group by rollup(t.create_org)";*/
    
    public static String RABIES_STATISTICS_SQL = "select decode(grouping_id(org.ORGAN_CODE),1,'合计',org.ORGAN_CODE) org_code,"
    		+ " nvl(sum(e.evenum),0)person_num, nvl(sum(vaccine.vaccine_person_num),0) num1,nvl(sum(vaccine.imm_person_num),0) num2,"
    		+ " nvl(sum(vaccine.vaccine_num),0) num3,nvl(sum(vaccine.imm_num),0) num4"
    		+ " from (select ORGAN_CODE from SY_PHBDB_MDM_ORGANIZATION where 1=1 and genre_code in ('"+ OrgGenreCode.HOSPITAL.getValue() +"'," +
            " '"+ OrgGenreCode.CENTRE.getValue() +"', '"+ OrgGenreCode.JK.getValue() +"') %1$s) org"
    		+ " left join (select CREATE_ORG, count(1) evenum from DC_VACCINATION_EVENT where IMMU_TYPE = 1 and IS_DELETE = 0"
    		+ " %2$s group by CREATE_ORG) e on org.ORGAN_CODE=e.CREATE_ORG"
    		+ " left join(select IMMU_UNIT_ID,sum(decode(immu_type, '5', 1, 0)) imm_person_num,"
    		+ " sum(decode(immu_type, '1', 1, 0)) vaccine_person_num,"
    		+ " sum(decode(immu_type, '1', vaccine_measurement, 0)) vaccine_num,"
    		+ " sum(decode(immu_type, '5', vaccine_measurement, 0)) / 200 imm_num from dc_vaccination_info"
    		+ " where 1=1 and immu_unit_id is not null %3$s group by IMMU_UNIT_ID) vaccine on org.ORGAN_CODE=vaccine.IMMU_UNIT_ID"
    		+ " group by rollup(org.ORGAN_CODE)";
    
    @Override
    public PageList<VaccinationEvent> getVaccinationEventList(Page page, Criteria criteria){
    	StringBuilder sb = new StringBuilder(" SELECT VE.*, MGMT.NAME,MGMT.IDCARD, ");
    	sb.append(" MGMT.BIRTHDAY,MGMT.GENDER,MGMT.PATOWN_SHIP,MGMT.PASTREET,MGMT.PAHOUSE_NUMBER ");
    	sb.append(" FROM DC_VACCINATION_EVENT VE ");
    	sb.append(" INNER JOIN DC_VACCINATION_MGMT MGMT ");
    	sb.append(" ON VE.PERSON_ID = MGMT.PERSON_ID ");
    	SqlBuilder.buildWhereStatement(VaccinationEvent.class, sb, criteria);
    	SqlBuilder.buildOrderStatement(sb, "CREATE_DATE DESC");
    	PageList<VaccinationEvent> mapList = this.getPageList(page, sb.toString(),criteria);
    	return mapList;
    }

	@Override
	public List<Map<String, Object>> statisticsRabiesMapList(Criteria criteria) {
		StringBuilder conditionBuilder = new StringBuilder();
		if (criteria.contains("createOrg")) {
			conditionBuilder.append(" and ORGAN_CODE='").append(criteria.get("createOrg")).append("'");
		}
		/*if (criteria.contains("createOrg")) {
			conditionBuilder.append(" and CREATE_ORG='").append(criteria.get("createOrg")).append("'");
		}*/
		StringBuilder eventConditonBuiler =  new StringBuilder();
		StringBuilder vaccineConditonBuiler = new StringBuilder();
		if (criteria.contains("fillBeginDate") && criteria.contains("fillEndDate")) {
			eventConditonBuiler.append(" and to_char(CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("fillBeginDate"))
			.append("' and to_char(CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("fillEndDate")).append("'");
			
			vaccineConditonBuiler.append(" and to_char(VACCINATION_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("fillBeginDate"))
			.append("' and to_char(VACCINATION_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("fillEndDate")).append("'");
			
		} else if (criteria.contains("fillBeginDate") && !criteria.contains("fillEndDate")) {
			eventConditonBuiler.append(" and to_char(CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("fillBeginDate")).append("'");
			
			vaccineConditonBuiler.append(" and to_char(VACCINATION_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("fillBeginDate")).append("'");
		} else if (!criteria.contains("fillBeginDate") && criteria.contains("fillEndDate")) {
			eventConditonBuiler.append(" and to_char(CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("fillEndDate")).append("'");
			
			vaccineConditonBuiler.append(" and to_char(VACCINATION_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("fillEndDate")).append("'");
		}
		String sql = String.format(RABIES_STATISTICS_SQL, conditionBuilder.toString(), eventConditonBuiler.toString(), vaccineConditonBuiler.toString());
		return getMapList(sql, (Criteria)null);
	}

}