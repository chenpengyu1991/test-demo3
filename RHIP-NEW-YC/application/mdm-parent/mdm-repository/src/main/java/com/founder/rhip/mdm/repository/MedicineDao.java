package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Medicine;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("mdmMedicineDao")
public class MedicineDao extends MDMRepository<Medicine, String> implements IMedicineDao {
	
	protected static final String TABLE_MEDICINE = "MDM_MEDICINE";
	
	protected static final String TABLE_MEDICINE_LOG = "MDM_MEDICINE_LOG";
	
	public MedicineDao() {
		setTableName(TABLE_MEDICINE);
		setKey(Medicine.MEDICINE_CODE);
	}

	@Override
	public PageList<Medicine> getLogList(Page page, String medicineCode, String... properties) {
		String fields = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(fields).append(" FROM ").append(TABLE_MEDICINE).append(" WHERE MEDICINE_CODE = '").append(medicineCode).append("' ")
			.append(" UNION ").append("SELECT ").append(fields).append(" FROM ").append(TABLE_MEDICINE_LOG).append(" WHERE MEDICINE_CODE = '").append(medicineCode).append("' ")
			.append(" ORDER BY OPERATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}
	
	@Override
	public Medicine getLog(Criteria criteria) {
		setTableName(TABLE_MEDICINE_LOG);
		Medicine medicine = get(criteria);
		setTableName(TABLE_MEDICINE);
		return medicine;
	}

	@Override
	public void insertLog(Criteria criteria) {
		insertLogRecord(TABLE_MEDICINE_LOG, criteria);
	}

	@Override
	public void deleteLog(Criteria criteria) {
		setTableName(TABLE_MEDICINE_LOG);
		delete(criteria);
		setTableName(TABLE_MEDICINE);
	}
	
	@Override
	public Long getMedicineVersion() {
		final String sql = "SELECT VERSION FROM MDM_VERSION WHERE CODE='MEDICINE'";
		Long version = getSingle(sql, null, Long.class);
		return version;
	}
	
	@Override
	public void publishMedicineVersion() {
		final String sql = "UPDATE MDM_VERSION SET VERSION=(VERSION+1) WHERE CODE='MEDICINE'";
		execute(sql);
	}
	
	@Override
	public List<String> getCategoryOneDict(String categoryName) {
		List<String> names = null;
		if (StringUtil.isNullOrEmpty(categoryName)) {
			String sql = "SELECT DISTINCT CATEGORY_NAME_ONE FROM MDM_MEDICINE WHERE CATEGORY_NAME_ONE IS NOT NULL";
			names = exeQuery(sql, stringRowMapper);
		} else {
			String sql = "SELECT DISTINCT CATEGORY_NAME_ONE FROM MDM_MEDICINE WHERE CATEGORY_NAME_ONE LIKE ?";
			names = exeQuery(sql, stringRowMapper, "%" + categoryName + "%");
		}
		return names;
	}
	
	@Override
	public List<String> getCategoryTwoDict(String categoryOne, String categoryName) {
		List<String> names = null;
		if (StringUtil.isNotEmpty(categoryOne)) {
			String sql = "SELECT DISTINCT CATEGORY_NAME_TWO FROM MDM_MEDICINE WHERE CATEGORY_NAME_TWO IS NOT NULL AND CATEGORY_NAME_ONE=?";
			names = exeQuery(sql, stringRowMapper, categoryOne);
		} else {
			if (StringUtil.isNullOrEmpty(categoryName)) {
				String sql = "SELECT DISTINCT CATEGORY_NAME_TWO FROM MDM_MEDICINE WHERE CATEGORY_NAME_TWO IS NOT NULL";
				names = exeQuery(sql, stringRowMapper);
			} else {
				String sql = "SELECT DISTINCT CATEGORY_NAME_TWO FROM MDM_MEDICINE WHERE CATEGORY_NAME_TWO LIKE ?";
				names = exeQuery(sql, stringRowMapper, "%" + categoryName + "%");
			}
		}
		return names;
	}
	
	@Override
	public List<String> getCategoryThreeDict(String categoryTwo, String categoryName) {
		List<String> names = null;
		if (StringUtil.isNotEmpty(categoryTwo)) {
			final String sql = "SELECT DISTINCT CATEGORY_NAME_THREE FROM MDM_MEDICINE WHERE CATEGORY_NAME_THREE IS NOT NULL AND CATEGORY_NAME_TWO=?";
			names = exeQuery(sql, stringRowMapper, categoryTwo);
		} else {
			if (StringUtil.isNullOrEmpty(categoryName)) {
				final String sql = "SELECT DISTINCT CATEGORY_NAME_THREE FROM MDM_MEDICINE WHERE CATEGORY_NAME_THREE IS NOT NULL";
				names = exeQuery(sql, stringRowMapper);
			} else {
				final String sql = "SELECT DISTINCT CATEGORY_NAME_THREE FROM MDM_MEDICINE WHERE CATEGORY_NAME_THREE LIKE ?";
				names = exeQuery(sql, stringRowMapper, "%" + categoryName + "%");
			}
		}
		return names;
	}
	
	@Override
	public List<String> getDosageDict(String name) {
		List<String> names = null;
		if (StringUtil.isNullOrEmpty(name)) {
			final String sql = "SELECT DISTINCT DOSAGE FROM MDM_MEDICINE WHERE DOSAGE IS NOT NULL";
			names = exeQuery(sql, stringRowMapper);
		} else {
			final String sql = "SELECT DISTINCT DOSAGE FROM MDM_MEDICINE WHERE DOSAGE LIKE ?";
			names = exeQuery(sql, stringRowMapper, "%" + name + "%");
		}
		return names;
	}
	
	private RowMapper<String> stringRowMapper = new RowMapper<String>() {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString(1);
		}
		
	};
}
