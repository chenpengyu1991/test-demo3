package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.ImageIndex;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of ImageIndex
 * 
 */
@Repository("imageIndexDao")
public class ImageIndexDaoImpl extends AbstractDao<ImageIndex, Long> implements IImageIndexDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}