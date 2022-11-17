package com.founder.rhip.ehr.repository.clinic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;

/**
 * DAO implement of EhrPhysiqueExamination
 * 
 */
@Repository("physiqueExaminationDao")
public class PhysiqueExaminationDaoImpl extends AbstractDao<PhysiqueExamination, Long> implements IPhysiqueExaminationDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	//add by yejianfei
	/**
	 * 饮食结构、运动、吸烟相关，每个人只取最近一次体检
	 */
	private String PARTITION_BY_EXAMINATION_DATE_SQL = "WITH EXAM AS(" +
			"	SELECT * FROM\n" +
			"	(\n" +
			"		SELECT t.DIET_HUNSU_EQUILIBRIUM,t.DIET_MEAT_MAIN,t.DIET_VEGETARIAN,t.DIET_HALOPHILIC,t.DIET_ADDICTED_OIL,t.DIET_SUGAR_CRAVINGS\n" +//饮食习惯相关字段
			"			,t.TRAIN_FREQUENCY_TYPE_CODE\n" +//锻炼频率 FS10208
			"			,t.SMODE_STATUS_CODE\n" +//吸烟状况 CV0300101
			"			,t.DRINK_FREQUENCY\n" +//饮酒频率 FS10208
			"			,row_number() over(Partition by t.PERSON_ID order by t.EXAMINATION_DATE desc) rn\n" +
			"		FROM MS_PHYSIQUE_EXAMINATION  t\n" +
			"		%1$s\n" +
			"	) A  \n" +
			"	where A.rn = 1\n" +
			")";

	/**
	 * 饮食习惯
	 */
	private String EATING_HABITS_SQL = "SELECT COUNT(DECODE(DIET_HUNSU_EQUILIBRIUM,'1',1,NULL)) HUNSU_EQUILIBRIUM--荤素均衡\n" +
			"	,COUNT(DECODE(DIET_MEAT_MAIN,'2',1,NULL)) MEAT_MAIN--荤食为主\n" +
			"	,COUNT(DECODE(DIET_VEGETARIAN,'3',1,NULL)) VEGETARIAN--素食为主\n" +
			"	,COUNT(DECODE(DIET_HALOPHILIC,'4',1,NULL)) HALOPHILIC--嗜盐\n" +
			"	,COUNT(DECODE(DIET_ADDICTED_OIL,'5',1,NULL)) ADDICTED_OIL--嗜油\n" +
			"	,COUNT(DECODE(DIET_SUGAR_CRAVINGS,'6',1,NULL)) SUGAR_CRAVINGS--嗜糖\n" +
			"FROM EXAM";

	/**
	 * 运动频率
	 */
	private String TRAIN_FREQUENCY_SQL = "SELECT COUNT(1) TRAIN_FREQUENCY_COUNT\n" +
			"	,TRAIN_FREQUENCY_TYPE_CODE\n" +
			"FROM EXAM\n" +
			//"WHERE TRAIN_FREQUENCY_TYPE_CODE IS NOT NULL\n" +
			"GROUP BY  TRAIN_FREQUENCY_TYPE_CODE";

	/**
	 * 吸烟状况
	 */
	private String SMODE_STATUS_SQL = "SELECT COUNT(1) SMODE_STATUS_COUNT\n" +
			"	,SMODE_STATUS_CODE\n" +
			"FROM EXAM\n" +
			//"WHERE SMODE_STATUS_CODE IS NOT NULL\n" +
			"GROUP BY  SMODE_STATUS_CODE";

	/**
	 * 饮酒频率
	 */
	private String DRINK_FREQUENCY_SQL = "SELECT COUNT(1) DRINK_FREQUENCY_COUNT\n" +
			"	,DRINK_FREQUENCY\n" +
			"FROM EXAM\n" +
			//"WHERE DRINK_FREQUENCY IS NOT NULL\n" +
			"GROUP BY  DRINK_FREQUENCY";

	/**
	 * 获取体检报告
	 * @param   year
	 * @param   personId
	 * @param   type
	 * @return  PhysiqueExamination
	 */
	@Override
	public PhysiqueExamination getExamReport(String year, Long personId, String type) {
		if (StringUtil.isNullOrEmpty(year) || ObjectUtil.isNullOrEmpty(personId) || StringUtil.isNullOrEmpty(type)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MS_PHYSIQUE_EXAMINATION")
			.append(" WHERE PERSON_ID = " + personId)
			.append(" AND PHYSICAL_EXAM_TYPE = '" + type + "'")
			.append(" AND TO_CHAR(EXAMINATION_DATE, 'YYYY') = '" + year + "'");
		return get(sql.toString(), null);
	}
	
	/**
	 * 获取体检关系列表
	 */
	@Override
	public PageList<PhysiqueExamination> getPhysiqueExaminations(Criteria criteria,
			Page page) {
		StringBuilder sql = new StringBuilder(
				" SELECT T1.ID,T1.PERSON_ID,T1.EHR_ID,T1.NAME,T1.AGE,T1.EXAMINATION_DATE,T1.EXAMINATION_ORGAN_NAME " +
				" FROM MS_PHYSIQUE_EXAMINATION T1 ");
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "T1.EXAMINATION_DATE DESC");
		PageList<PhysiqueExamination> physiqueExaminations = this.getPageList(page,sql.toString(), criteria);
		return physiqueExaminations;
	}

	@Override
	public List<PhysiqueExamination> getLastelyPExamination(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT PERSON_ID,MAX(NAME) AS NAME,MAX(GENDER) AS GENDER,MAX(AGE) AS AGE,MAX(BIRTHDAY) AS BIRTHDAY,MAX(LEFT_SBP) AS LEFT_SBP,MAX(LEFT_DBP) AS LEFT_DBP,MAX(SMODE_STATUS_CODE) AS SMODE_STATUS_CODE,MAX(FPG_MMOL) AS FPG_MMOL,MAX(TC) AS TC,MAX(WAOSTLINE) AS WAOSTLINE,MAX(INDEX_OF_BODY_CHARACTERISTICS) AS INDEX_OF_BODY_CHARACTERISTICS,MIN(TRAINING_MIN) AS TRAINING_MIN,MAX(SMODE_STATUS_CODE) AS SMODE_STATUS_CODE,MAX(DRINK_FREQUENCY) AS DRINK_FREQUENCY,MAX(TRIGLYCERIDE_VALUE) AS TRIGLYCERIDE_VALUE FROM MS_PHYSIQUE_EXAMINATION");
		SqlBuilder.buildWhereStatement(PhysiqueExamination.class, sql, criteria);
		sql.append(" GROUP BY PERSON_ID");
		return this.getList(sql.toString(),criteria);
	}

	@Override
	public List<Map<String, Object>> getEatingHabitsMapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PhysiqueExamination.class, reportWhere, ca);
		String sql = String.format(PARTITION_BY_EXAMINATION_DATE_SQL + EATING_HABITS_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getTrainFrequencyMapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PhysiqueExamination.class, reportWhere, ca);
		String sql = String.format(PARTITION_BY_EXAMINATION_DATE_SQL + TRAIN_FREQUENCY_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getSmodeStatusMapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PhysiqueExamination.class, reportWhere, ca);
		String sql = String.format(PARTITION_BY_EXAMINATION_DATE_SQL + SMODE_STATUS_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getDrinkFrequencyMapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PhysiqueExamination.class, reportWhere, ca);
		String sql = String.format(PARTITION_BY_EXAMINATION_DATE_SQL + DRINK_FREQUENCY_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}
	
	@Override
	public void updateEchIdentification(PhysiqueExamination phy) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ehr_Id FROM MS_PHYSIQUE_EXAMINATION")
			.append(" WHERE PERSON_ID = " + phy.getPersonId())
			.append(" AND TO_CHAR(EXAMINATION_DATE, 'YYYY') = '" + DateUtil.getDateYear(phy.getExaminationDate()) + "'");
		List<Map<String, Object>> map =  getMapList(sql.toString(), new Criteria());
		
		if(ObjectUtil.isNotEmpty(map)){
			List<String> list = new ArrayList<String>();  
			for(Map<String, Object> m :map){
				list.add((String) m.get("ehr_Id"));
			}
			Parameters parameters = new Parameters();
			parameters.add("tcmPeacefulQuality", phy.getTcmPeacefulQuality());
			parameters.add("tcmQiQuality", phy.getTcmQiQuality());
			parameters.add("tcmYangQuality", phy.getTcmYangQuality());
			parameters.add("tcmYinDeficiency", phy.getTcmYinDeficiency());
			parameters.add("tcmPhlegmWetness", phy.getTcmPhlegmWetness());
			
			parameters.add("tcmHeatMedium", phy.getTcmHeatMedium());
			parameters.add("tcmBloodQuality", phy.getTcmBloodQuality());
			parameters.add("tcmQiStagnation", phy.getTcmQiStagnation());
			parameters.add("tcmSpecialQuality", phy.getTcmSpecialQuality());
			Criteria criteria = new Criteria("ehrId", OP.IN, list);
			this.update( parameters, criteria);
		}
	}

	public PageList<PhysiqueExamination> getPageListTemp(Page page, long id) {
		StringBuilder sql = new StringBuilder("select PHY.id,ECH.id IDENTIFICATION_ID from MS_PHYSIQUE_EXAMINATION phy "
				+ "inner join ECH_IDENTIFICATION@dl_phb ech  on ECH.person_id=PHY.PERSON_ID  and ECH.temp_year=to_char(phy.EXAMINATION_DATE, 'yyyy') "
				+ " where to_char(BIRTHDAY,'yyyy')<=1955 and ECH.temp_year is not null and IDENTIFICATION_ID is null and phy.id>="+id+" order by phy.id");
		return this.getPageList(page,sql.toString(), new Criteria());
	}
}