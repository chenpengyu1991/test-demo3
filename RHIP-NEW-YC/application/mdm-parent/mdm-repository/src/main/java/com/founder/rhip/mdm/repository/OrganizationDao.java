package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("mdmOrganizationDao")
public class OrganizationDao extends MDMRepository<Organization, Long> implements IOrganizationDao {

	protected static final String TABLE_ORGANIZATION_LOG = "MDM_ORGANIZATION_LOG";
	
	protected static final String TABLE_ORGANIZATION = "MDM_ORGANIZATION";
	
	@Override
	public void insertOrganizationLog(Criteria criteria) {
		insertLogRecord(TABLE_ORGANIZATION_LOG, criteria);
	}
	
	@Override
	public PageList<Organization> getUpdateHistory(Page page, Long organId, String... properties) {
		String fields = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(fields).append(" FROM ").append(TABLE_ORGANIZATION).append(" WHERE ORGAN_ID = ").append(organId)
			.append(" UNION ").append("SELECT ").append(fields).append(" FROM ").append(TABLE_ORGANIZATION_LOG).append(" WHERE ORGAN_ID = ").append(organId)
			.append(" ORDER BY OPERATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}
	
	public Organization getLog(Criteria criteria) {
		setTableName(TABLE_ORGANIZATION_LOG);
		Organization organ = get(criteria);
		setTableName(TABLE_ORGANIZATION);
		return organ;
	}
	
	public int delete(Criteria criteria) {
		setTableName(TABLE_ORGANIZATION_LOG);
		super.delete(criteria);
		setTableName(TABLE_ORGANIZATION);
		return super.delete(criteria);
	}

	@Override
	public Organization getGbcodeByOrganization(String organCode) {
		StringBuilder sb = new StringBuilder("SELECT * FROM MDM_ORGANIZATION A WHERE EXISTS (SELECT 1 FROM MDM_ORGANIZATION B WHERE B.ORGAN_CODE = '"+ organCode +"' AND B.PARENT_CODE = A.ORGAN_CODE) UNION SELECT * FROM MDM_ORGANIZATION C WHERE C.ORGAN_CODE = '"+ organCode +"' AND C.PARENT_CODE = '0'");
		return this.get(sb.toString(), null);
	}

	@Override
	public List<Organization> getOrganizationList(String organCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ORGANIZATION.ORGAN_CODE FROM MDM_ORGANIZATION WHERE PARENT_CODE = '").append(organCode).append("'");
		return this.getList(sb.toString());//查询当前中心下所有服务站CODE
	}
	
	/**
	 * 查询所有机构不包含中心（站）
	 * @return      List<Organization>
	 */
	@Override
	public PageList<Organization> getOrganizationsNoVirtual(Page page, Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MDM_ORGANIZATION org ");
		SqlBuilder.buildWhereStatement(Organization.class, sql, criteria);
		if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
			sql.append(" where substr(organ_code,0,1)<>'X'");
		} else {
			sql.append(" and substr(organ_code,0,1)<>'X'");
		}
		SqlBuilder.buildOrderStatement(sql, "ORGAN_CODE");
		
		return this.getPageList(page, sql.toString(), criteria);
	}

	/**
	 * 根据村code获取机构
	 * @return Organization
	 */
	@Override
	public Organization queryOrganByVillage(String villageCode) {
		final String sql = " SELECT O.* FROM MDM_ORGANIZATION O LEFT JOIN MDM_ORGANIZATION_AREA OA ON O.ORGAN_CODE = OA.ORGANIZATION_CODE WHERE OA.AREA_CODE = :villageCode ";
		Criteria criteria = new Criteria("villageCode", villageCode);
		return get(sql, criteria);
		//return simpleJdbcTemplate.queryForObject(sql, Organization.class, villageCode);
	}
	
	/**
	 * 根据镇一级机构代码汇总所有设备资源
	 * @param page
	 * @param gbCode
	 * @return
	 */
	@Override
	public List<Map<String, Object>> sumEquipmentByTown(String gbCode){
		String baseSql = " select item.item_name as organName," +
				" sum(o.bed_count) as bedCount," +
				" sum(o.open_bed_count) as openBedCount," +
				" sum(o.equipment_num) as equipmentNum," +
				" sum(o.equipment_num_one) as equipmentNumOne," +
				" sum(o.equipment_num_two) as equipmentNumTwo," +
				" sum(o.area) as area," +
				" sum(o.business_area) as businessArea," +
//				" 0 as dilapidatedRatio," +
                " round(sum(o.DILAPIDATED_RATIO)/count(DILAPIDATED_RATIO),4) as dilapidatedRatio," +
				" sum(o.construction_area) as constructionArea," +
				" sum(o.completion_area) as completionArea" +
				" FROM MDM_ORGANIZATION o" +
				" inner join" + 
				" dic_item item on" + 
				" o.gb_code = item.item_code and" + 
				" item.dic_code = 'FS990001'" +
				" %1$s " + 
				" group by " +
				" item.item_name";
		String baseSqlSum = " select decode(grouping(item.item_name), 1 ,'合计',item.item_name) as organName,"+
				" sum(o.bed_count) as bedCount," +
				" sum(o.open_bed_count) as openBedCount," +
				" sum(o.equipment_num) as equipmentNum," +
				" sum(o.equipment_num_one) as equipmentNumOne," +
				" sum(o.equipment_num_two) as equipmentNumTwo," +
				" sum(o.area) as area," +
				" sum(o.business_area) as businessArea," +
                " round(sum(o.DILAPIDATED_RATIO)/count(DILAPIDATED_RATIO),4) as dilapidatedRatio," +
				" sum(o.construction_area) as constructionArea," +
				" sum(o.completion_area) as completionArea" +
				" FROM MDM_ORGANIZATION o" +
				" inner join" + 
				" dic_item item on" + 
				" o.gb_code = item.item_code and" + 
				" item.dic_code = 'FS990001'" +
				" %1$s " + 
				" group by rollup(item.item_name) " +
				" ORDER BY item.item_name";
		if(gbCode != null && gbCode.length() > 0){
			baseSql = String.format(baseSql, " and o.gb_code = " + gbCode );	
		}else{
			baseSql = String.format(baseSqlSum, "");
		}
		return this.getMapList(baseSql, new Criteria());
	}
	/**
	 * 根据除镇一级机构代码汇总所有设备资源
	 * @param page
	 * @param gbCode
	 * @return
	 */
	@Override
	public List<Map<String, Object>> sumEquipment(String orgType, String gbCode, String organCode,  String parentCode){
		String begainSql =" SELECT DECODE( GROUPING(GB_CODE), 1, '' , GB_CODE) AS gbCode," +
					      " DECODE(GROUPING(ORGAN_CODE),1,'',ORGAN_CODE) AS organCode," +
				          " DECODE(GROUPING(ORGAN_NAME),1,'合计',ORGAN_NAME) AS organName," +
				          " sum(NVL(OPEN_BED_COUNT, 0)) openBedCount, " +
				          " sum(NVL(EQUIPMENT_NUM , 0)) equipmentNum, " +
				          " sum(NVL(EQUIPMENT_NUM_ONE , 0))equipmentNumOne, " +
				          " sum(NVL(EQUIPMENT_NUM_TWO , 0))equipmentNumTwo, " +
				          " sum(NVL(BED_COUNT, 0)) bedCount," +
				          " sum(NVL(AREA, 0)) area," +
				          " sum(NVL(BUSINESS_AREA, 0)) businessArea," +
				          " sum(NVL(DILAPIDATED_RATIO, 0)) dilapidatedRatio," +
				          " sum(NVL(CONSTRUCTION_AREA, 0)) constructionArea," +
				          " sum(NVL(COMPLETION_AREA, 0)) completionArea " +
				          " FROM MDM_ORGANIZATION  ";
		String endSql = " GROUP BY ROLLUP((GB_CODE,ORGAN_CODE,ORGAN_NAME)) ORDER BY GB_CODE, ORGAN_CODE";
		String whereSql = "";
		if(orgType.equals("A100")){
			 whereSql = " WHERE  SUBSID= 0" + 
			            " AND GENRE_CODE='" + orgType + "'"; 
		}else if(gbCode != null && gbCode.length() > 0 && parentCode!= null && parentCode.length() > 0){
			 whereSql = " WHERE  GB_CODE= " + gbCode +
					    " AND PARENT_CODE='" + parentCode + "'" +
			            " AND GENRE_CODE='" + orgType + "'"; 	
		}else if(gbCode != null && gbCode.length() > 0 ){
			 whereSql = " WHERE  GB_CODE= " + gbCode +
			            " AND GENRE_CODE='" + orgType + "'";
		}else {
			 whereSql = " WHERE  GENRE_CODE='" + orgType + "'";
		}
		String baseSql = begainSql + whereSql + endSql;
		return this.getMapList(baseSql, new Criteria());
	}

	@Override
	public List<Organization> getOrgansRecursion(String organCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ORGAN_CODE FROM MDM_ORGANIZATION START WITH ORGAN_CODE='").append(organCode).append("' CONNECT BY PRIOR ORGAN_CODE=PARENT_CODE");
		return this.getList(sb.toString());
	}

	/**
	 * 获取机构表中最大的sort为了给新建机构的sort赋值
	 * @return
	 */
	@Override
	public Integer getMaxSort(Criteria criteria) {
		return this.getMax(criteria, "sort", Integer.class);
	}

	@Override
	public Map<String, Object> getEquipmentData() {
		Map<String, Object> result = new HashMap<>();
		String baseSql = "SELECT nvl(sum(equipment_num),0) as equipment_num," +
				"	nvl(sum(equipment_num_one),0) as equipment_num_one," +
				" 	nvl(sum(equipment_num_two),0) as equipment_num_two," +
				"	nvl(sum(bed_count),0) as bed_count," +
				"	nvl(sum(open_bed_count),0) as open_bed_count," +
				"	nvl(sum(area),0) as area," +
				"	nvl(sum(business_area),0) as business_area," +
				"	nvl(sum(construction_area),0) as construction_area," +
				"	nvl(sum(completion_area),0) as completion_area," +
				"	decode(count(DILAPIDATED_RATIO),0,0,round(sum(DILAPIDATED_RATIO)/count(DILAPIDATED_RATIO),4)) as dilapidated_Ratio" +
				" FROM MDM_ORGANIZATION WHERE GENRE_CODE in ('A100', 'B100')"; // 添加机构类型条件与医疗机构病床柱状图查询条件一致  添加人：  高飞   修改日期： 20210616
		List<Map<String,Object>>  mapList = this.getMapList(baseSql,new Criteria());
		if(ObjectUtil.isNotEmpty(mapList)){
			result = mapList.get(0);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getHospitalEquipmentData(Criteria ca) {
		String baseSql = "SELECT ORGAN_CODE,nvl(sum(equipment_num),0) as equipmentNum," +
				"	nvl(sum(equipment_num_one),0) as equipmentNumOne," +
				" 	nvl(sum(equipment_num_two),0) as equipmentNumTwo," +
				"	nvl(sum(bed_count),0) as bedCount," +
				"	nvl(sum(open_bed_count),0) as openBedCount," +
				"	nvl(sum(area),0) as area," +
				"	nvl(sum(business_area),0) as businessArea," +
				"	nvl(sum(construction_area),0) as constructionArea," +
				"	nvl(sum(completion_area),0) as completionArea," +
				"	decode(count(DILAPIDATED_RATIO),0,0,round(sum(DILAPIDATED_RATIO)/count(DILAPIDATED_RATIO),4)) as dilapidatedRatio" +
				" FROM MDM_ORGANIZATION" +
				" %1$s" +
				" GROUP BY ORGAN_CODE,GENRE_CODE" +
				" ORDER BY bedCount desc, GENRE_CODE ASC,ORGAN_CODE DESC";
		StringBuilder whereSql = new StringBuilder();
		SqlBuilder.buildWhereStatement(Organization.class,whereSql,ca);
		String lastSql = String.format(baseSql,whereSql.toString());
		return  this.getMapList(lastSql,ca);
	}
}
