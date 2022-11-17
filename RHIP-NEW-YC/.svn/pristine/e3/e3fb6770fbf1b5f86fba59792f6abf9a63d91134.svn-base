package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ExcelToDB;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by yuanzg on 2017/2/21.
 */
@Repository("excelHealthRecordDao")
public class ExcelHealthRecordDaoImpl extends AbstractDao<ExcelToDB, Long> implements IExcelHealthRecordDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
