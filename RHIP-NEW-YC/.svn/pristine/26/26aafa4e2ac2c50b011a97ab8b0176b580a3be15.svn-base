package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.entity.StaffOrg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("mdmStaffDao")
public class StaffDaoImpl extends MDMRepository<Staff, Long> implements IStaffDao {

	@Override
	public void insertStaffLog(String[] properties, String... staffCode) {
		if (staffCode == null || staffCode.length == 0) {
			return;
		}
		int maxLength = 1000, srcPos = 0;
		String[] ids = null;
		do {
			int length = (maxLength < (staffCode.length - srcPos)) ? maxLength : (staffCode.length - srcPos);
			ids = new String[length];
			System.arraycopy(staffCode, srcPos, ids, 0, length);
			String staffFields = StringUtil.join(coverPropertiesToFields(properties));
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MDM_STAFF_LOG (").append(staffFields).append(") SELECT ").append(staffFields).append(" FROM MDM_STAFF WHERE STAFF_CODE IN (")
					.append(StringUtil.join(ids)).append(")");
			execute(sb.toString());
			srcPos += length;
		} while (srcPos < staffCode.length);
	}

	@Override
	public PageList<Staff> getStaffLogs(Page page, String staffCode, String[] properties) {
		String select = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(select).append(" FROM MDM_STAFF WHERE STAFF_CODE = '" + staffCode).append("'")
				.append(" UNION SELECT ").append(select).append(" FROM MDM_STAFF_LOG ")
				.append("WHERE STAFF_CODE = '").append(staffCode).append("'")
				.append(" ORDER BY UPDATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}

	@Override
	public Staff getStaffLog(String staffCode, Long updateTime, String[] properties) {
		String select = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(select).append(" FROM MDM_STAFF_LOG ")
				.append("WHERE STAFF_CODE = '").append(staffCode).append("'")
				.append(" AND UPDATE_TIME = ").append(updateTime);
		return get(sql.toString(), null);
	}
	
	/**
	 * ��ȡ���������µ�ҽ����Ա����
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getStaffNumByOrg(Criteria criteria) {
		
		StringBuilder whereSQL1 = new StringBuilder();
		SqlBuilder.buildWhereStatement(Staff.class,whereSQL1, criteria);
		String sql = "select s.organ_code orgCode, count(*)count from MDM_staff s %1$s group by s.organ_code";
		sql = String.format(sql,whereSQL1);
		return this.getMapList(sql, new Criteria());
	}

	/**
	 * 获取医务人员对象 同时获取非兼职的机构
	 * @param criteria
	 * @return
	 */
	@Override
	public Staff getStaff(Criteria criteria) {
		String sql = "SELECT S.STAFF_CODE, s.SMPI_ID, SO.organ_code, SO.dept_code, s.local_id, NAME, ID_CARD, " +
				"SO.work_id_card, SO.card_num, BIRTHDAY, GENDER, NATION, GB_CODE, PA_PROVINCE, PA_CITY, PA_COUNTY, " +
				"PA_TOWNSHIP, PA_STREET, PA_HOUSE_NUMBER, PA_POSTCODE, HOME_TEL, MOBILE, MAIL, UNIVERSITY, GRADUATE_DATE, " +
				"SPECIALITY, EDUCATION, DEGREE, PARTY, MARRIAGE, TYPE, WORK, TECHNICAL, TECHNICAL_NAME, BUSINESS, " +
				"BUSINESS_NAME, OFFICE_TEL, OFFICE_FAX, START_WORK_DATE, ORG_WORK_DATE, UPDATE_TIME, UPDATE_PERSON, " +
				"PRACTICE_STATUS, QUAL_CERT, PRAC_CERT, PRACTICE_LEVEL, PRACTICE_TYPE, PRACTICE_SUBJECT, APPROVAL_DATE, " +
				"CPY, OPERATE_TYPE, ID, CY_TYPE, RY_TYPE, EDUCATION_CATEGORY, PARTY_DATE, PARTY_JOB, JOB_CONDITION\n" +
				"FROM MDM_STAFF s \n" +
				"left join MDM_STAFF_ORG SO ON (SO.STAFF_CODE = S.STAFF_CODE and IS_MAIN = '0') ";
		StringBuilder sqlWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(Staff.class, sqlWhere, criteria);
		return this.get(sql + sqlWhere, criteria);
	}

	/**
	 * 查询医务人员 关联表staff_org
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<Staff> getStaffPageList(Page page, Criteria criteria) {
		String sql = "SELECT s.status, S.STAFF_CODE, NAME, ID_CARD, BIRTHDAY, GENDER,mobile\n" +
				"FROM MDM_STAFF s \n";
		StringBuilder orgSql = new StringBuilder();
		if(criteria.contains("organCode")) {
			orgSql.append("exists(select * from MDM_STAFF_ORG so where so.organ_code in( ");
			List<String> orgArr = (List<String>) criteria.get("organCode");
			for(int i=0; i<orgArr.size(); i++){
				if(i!=0) {
					orgSql.append(",");
				}
				String orgCode = orgArr.get(i);
				orgSql.append("'"+orgCode+"'");
			}
			orgSql.append(") and s.STAFF_CODE = so.STAFF_CODE) ");
			criteria.remove("organCode");
		} else {
			orgSql.append("exists(select * from MDM_STAFF_ORG so where is_main = '0' and s.STAFF_CODE = so.STAFF_CODE)") ;
		}
		StringBuilder sqlWhere = new StringBuilder("");
		SqlBuilder.buildWhereStatement(Staff.class, sqlWhere, criteria);
		if(StringUtil.isNotEmpty(sqlWhere)) {//原来的写法报错
//			sql = sql + sqlWhere.toString() + " and " + orgSql;
			sqlWhere.append(" and ").append(orgSql);

		} else {//原来的写法报错
//			sql = sql + " where " + orgSql;
			sqlWhere.append(" where ").append(orgSql);

		}

		sql = String.format(sql, orgSql, sqlWhere.toString());
//        return this.getPageList(page, sql, criteria);//原来的写法报错
		return this.getPageList(page, sql + sqlWhere, criteria);

	}

	@Override
	public Long getStaffCount(Criteria criteria) {
		return getCount(criteria, "id", Long.class);
	}

	/**
	 * 返回不存在user表中的staff
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<Staff> getStaffPageListsNoInUsers(Page page, Criteria criteria) {
		String sql = "select SMPI_ID , ID_CARD , NAME , GENDER , MOBILE , STAFF_CODE from mdm_staff s \n";

		StringBuilder sqlWhere = new StringBuilder();
		String orgSql = getOrgSql(criteria);
		SqlBuilder.buildWhereStatement(Staff.class, sqlWhere, criteria);
		sqlWhere.append(" AND not exists (select 1 from mdm_users u where s.staff_code = u.staff_code)");
		sqlWhere.append(orgSql);
		return this.getPageList(page, sql + sqlWhere, criteria);
	}

	/**
	 * 根据条件可以获取哪些机构下的医务人员
	 * @param criteria
	 * @return
	 */
	private String getOrgSql(Criteria criteria) {
		if(!criteria.contains("o.gb_code") && !criteria.contains("o.parent_code") &&
				!criteria.contains("o.organ_code") && !criteria.contains("o.genre_code")) {
			return "";
		}
		String orgSql = "and exists (\n" +
				"      select 1 from mdm_staff_org so where exists(\n" +
				"        select 1 from mdm_organization o \n" +
				"        where 1=1 and (%1$s %2$s %3$s) %4$s\n" +
				"        and so.organ_code = o.organ_code \n" +
				"    )\n" +
				" and s.staff_code = so.staff_code)";
		String gbSql = "";
		String parentCodeSql = "";
		String organCodeSql = "";
		String genreCodeSql = "";
		if(criteria.contains("o.gb_code")) {
			gbSql = "o.gb_code = '" + criteria.get("o.gb_code").toString() + "'";
			criteria.remove("o.gb_code");
		}
		if(criteria.contains("o.parent_code")) {
			parentCodeSql = "o.parent_code = '" + criteria.get("o.parent_code").toString() + "'";
			criteria.remove("o.parent_code");
		}
		if(criteria.contains("o.organ_code") && criteria.contains("o.parent_code")) {
			organCodeSql = " or o.organ_code = '" + criteria.get("o.organ_code").toString() + "'";
			criteria.remove("o.organ_code");
		} else if(criteria.contains("o.organ_code")) {
			List<String> organCodes =(List<String>)criteria.get("o.organ_code");
			String [] organCodesArray = organCodes.toArray(new String[organCodes.size()]);
			organCodeSql = " o.organ_code in (" + getStr(organCodesArray) + ")";
			criteria.remove("o.organ_code");
		}
		if(criteria.contains("o.genre_code")) {
			genreCodeSql = " and o.genre_code = '" + criteria.get("o.genre_code").toString() + "'";
			criteria.remove("o.genre_code");
		}
		return String.format(orgSql, gbSql, parentCodeSql, organCodeSql, genreCodeSql);
	}

	@Override
	public List<Staff> getStaffsByUserCode(String staffCodes[], String userCodes[]) {
		StringBuilder sqlBuilder = new StringBuilder("select * from mdm_staff where 1=1 ");
		if(ObjectUtil.isNotEmpty(staffCodes)) {
			sqlBuilder.append(" and staff_code in (" + this.getStr(staffCodes) + ")");

		}

		if(ObjectUtil.isNotEmpty(userCodes)) {
			sqlBuilder.append(" and staff_code in (select staff_code from mdm_users where user_code in (" + getStr(userCodes) + "))");

		}

		return this.getList(sqlBuilder.toString(), new Criteria());
	}

	private String getStr(String strsAarry[]) {

		String str = "";
		int i = 0;
		for(String tempStr : strsAarry) {
			if(i == 0) {
				str = "'" + tempStr + "'";
			} else {
				str = str + ", '" + tempStr + "'";
			}
			i++;
		}
		return str;
	}

	@Override
	public List<Staff> getStaffs(Criteria criteria) {
		StringBuilder sqlBuilder =  new StringBuilder("select s.* from mdm_staff_org o \n" +
				"left join mdm_staff s on o.staff_code = s.staff_code");
		SqlBuilder.buildWhereStatement(StaffOrg.class, sqlBuilder, criteria);
		SqlBuilder.buildOrderStatement(sqlBuilder,  "s.name desc");
		return this.getList(sqlBuilder.toString(), criteria);
	}
}
