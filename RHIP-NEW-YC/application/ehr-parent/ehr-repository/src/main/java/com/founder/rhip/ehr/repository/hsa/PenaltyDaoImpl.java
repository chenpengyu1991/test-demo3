package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;

/**
 * @author liuk DAO implement of PenaltyInfo
 * 
 */
@Repository("hasPenaltyDao")
public class PenaltyDaoImpl extends AbstractDao<PenaltyInfo, Long> implements IPenaltyInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private final static String IMPORT_UPDATE_BY_MAIN_ID =
//@foff
            "UPDATE HSA_LOCATION_INFO " +
                    "SET MAIN_UUID =:mainUuid, " +
                    " NO_FILE =:noFile, " +
                    " UNIT_NAME =:unitName, " +
                    " REGISTER_ORGN_NAME =:registerOrgnName, " +
                    " BUSINESS_ADDRESS_NAME =:businessAddressName, " +
                    " ORGANIZATION_CODE =:organizationCode, " +
                    " ZIP_CODE =:zipCode, " +
                    " UNIT_TYPE_CODE =:unitTypeCode, " +
                    " ECONOMIC_NATURE_CODE =:economicNatureCode, " +
                    " TOWNSHIP_LOT_CODE =:townshipLotCode, " +
                    " LEGAL =:legal, " +
                    " PERSON_IN_CHARGE =:personInCharge, " +
                    " OWNER =:owner, " +
                    " CONTACT_PHONE =:contactPhone, " +
                    " CONTACT =:contact, " +
                    " HEALTH_PROFESSIONAL =:healthProfessional, " +
                    " MAIN_BUSINESS_CODE =:mainBusinessCode, " +
                    " DUE_DATE =:dueDate, " +
                    " DOCUMENT_TYPE_CODE =:documentTypeCode, " +
                    " IDCARD =:idcard, " +
                    " SUPERVISOR_CODE =:supervisorCode, " +
                    " SUPERVISOR_NAME =:supervisorName, " +
                    " BUSINESS_TYPE_CODE =:businessTypeCode, " +
                    " LICENSE_STATE_CODE =:licenseStateCode, " +
                    " STATUS =:status, " +
                    " UNIT_TYPE_CODE_ORI =:unitTypeCodeOri, " +
                    " ECONOMIC_NATURE_CODE_ORI =:economicNatureCodeOri, " +
                    " DOCUMENT_TYPE_CODE_ORI =:documentTypeCodeOri, " +
                    " TOWNSHIP_LOT_CODE_ORI =:townshipLotCodeOri, " +
                    " SCALE_ORI =:scaleOri, " +
                    " NO_FILE_ORI =:noFileOri, " +
                    " SUPERVISOR_CODE_ORI =:supervisorCodeOri, " +
                    " DATA_TYPE =:dataType " +
                    "WHERE " +
                    "	MAIN_ID =:mainId";
    //@fon
    @Override
    public void importOnUpdate(PenaltyInfo info) {
        getSimpleJdbcTemplate().update(IMPORT_UPDATE_BY_MAIN_ID, new BeanPropertySqlParameterSource(info));
    }

}
