package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.BusinessInfo;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;

/**
 * @author liuk DAO implement of LocationInfo
 * 
 */
@Repository("hsaBusinessInfoDao")
public class BusinessInfoDaoImpl extends AbstractDao<BusinessInfo, Long> implements IBusinessInfoDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public void importOnAdd(LocationInfo locationInfo) {
		String sql="INSERT INTO \"HSA_BUSINESS_INFO\" (\n" +
				"	\"SECONDARY_ID\",\n" +
				"	\"SECONDARY_UUID\",\n" +
				"	\"LICENSE\",\n" +
				"	\"HEALTH_PROFESSIONAL\",\n" +
				"	\"MAIN_BUSINESS_CODE\",\n" +
				"	\"MAIN_BUSINESS_NAME\",\n" +
				"	\"SECONDARY_BUSINESS_CODE\",\n" +
				"	\"SECONDARY_BUSINESS_NAME\",\n" +
				"	\"BUSINESS_ITEM\",\n" +
				"	\"DUE_DATE\",\n" +
				"	\"RELEASE_DATE\",\n" +
				"	\"CREATE_DATE\",\n" +
				"	\"UPDATE_DATE\",\n" +
				"	\"BUSINESS_TYPE_CODE\",\n" +
				"	\"LICENSE_STATE_CODE\",\n" +
				"	\"MAIN_ID\",\n" +
				"	\"MAIN_UUID\",\n" +
				"	\"NO_FILE_ID\",\n" +
				"	\"LOCATION_INFO_ID\",\n" +
                "	\"NEW_RECORD_FLAG\",\n" +
                "	\"HEALTH_PROFESSIONAL_ORI\",\n" +
                "	\"MAIN_BUSINESS_CODE_ORI\",\n" +
                "	\"BUSINESS_TYPE_CODE_ORI\",\n" +
                "	\"LICENSE_STATE_CODE_ORI\",\n" +
                "	\"NEW_RECORD_FLAG_ORI\",\n" +
                "	\"NO_FILE_ID_ORI\",\n" +
                "	\"DATA_TYPE\"\n" +
				")\n" +
				"VALUES\n" +
				"	(\n" +
				"	:secondaryId,\n" +
				"	:secondaryUuid,\n" +
				"	:license,\n" +
				"	:healthProfessional,\n" +
				"	:mainBusinessCode,\n" +
				"	:mainBusinessName,\n" +
				"	:secondaryBusinessCode,\n" +
				"	:secondaryBusinessName,\n" +
				"	:businessItem,\n" +
				"	:dueDate,\n" +
				"	:releaseDate,\n" +
				"	:createDate,\n" +
				"	:updateDate,\n" +
				"	:businessTypeCode,\n" +
				"	:licenseStateCode,\n" +
				"	:mainId,\n" +
				"	:mainUuid,\n" +
				"	:noFileId,\n" +
				"	:locationInfoId,\n" +
                "	:newRecordFlag,\n" +
                "	:healthProfessionalOri,\n" +
                "	:mainBusinessCodeOri,\n" +
                "	:businessTypeCodeOri,\n" +
                "	:licenseStateCodeOri,\n" +
                "	:newRecordFlagOri,\n" +
                "	:noFileIdOri,\n" +
                "	:dataType\n" +
				"	)";
		
		simpleJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(locationInfo));
	}
	
	@Override
	public void importOnUpdate(LocationInfo locationInfo) {
		String sql="UPDATE \"HSA_BUSINESS_INFO\"\n" +
				"SET \n" +
				" \"SECONDARY_UUID\" = :secondaryUuid,\n" +
				" \"LICENSE\" = :license,\n" +
				" \"HEALTH_PROFESSIONAL\" = :healthProfessional,\n" +
				" \"MAIN_BUSINESS_CODE\" = :mainBusinessCode,\n" +
				" \"MAIN_BUSINESS_NAME\" = :mainBusinessName,\n" +
				" \"SECONDARY_BUSINESS_CODE\" = :secondaryBusinessCode,\n" +
				" \"SECONDARY_BUSINESS_NAME\" = :secondaryBusinessName,\n" +
				" \"BUSINESS_ITEM\" = :businessItem,\n" +
				" \"DUE_DATE\" = :dueDate,\n" +
				" \"RELEASE_DATE\" = :releaseDate,\n" +
				" \"CREATE_DATE\" = :createDate,\n" +
				" \"UPDATE_DATE\" = :updateDate,\n" +
				" \"BUSINESS_TYPE_CODE\" = :businessTypeCode,\n" +
				" \"LICENSE_STATE_CODE\" = :licenseStateCode,\n" +
				" \"MAIN_ID\" = :mainId,\n" +
				" \"MAIN_UUID\" = :mainUuid,\n" +
				" \"NO_FILE_ID\" =:noFileId,\n" +
				" \"LOCATION_INFO_ID\" = :locationInfoId,\n" +
                " \"NEW_RECORD_FLAG\" = :newRecordFlag,\n" +
                " \"HEALTH_PROFESSIONAL_ORI\" = :healthProfessionalOri,\n" +
                " \"MAIN_BUSINESS_CODE_ORI\" = :mainBusinessCodeOri,\n" +
                " \"NEW_RECORD_FLAG_ORI\" = :newRecordFlagOri,\n" +
                " \"LICENSE_STATE_CODE_ORI\" = :licenseStateCodeOri,\n" +
                " \"BUSINESS_TYPE_CODE_ORI\" = :businessTypeCodeOri,\n" +
                " \"NO_FILE_ID_ORI\" = :noFileIdOri,\n" +
                " \"DATA_TYPE\" = :dataType\n" +
				"WHERE\n" +
				"	SECONDARY_ID =:secondaryId";
		simpleJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(locationInfo));
	}
}