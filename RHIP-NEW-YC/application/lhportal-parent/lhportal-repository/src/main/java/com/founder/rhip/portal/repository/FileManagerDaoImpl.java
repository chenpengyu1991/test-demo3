package com.founder.rhip.portal.repository;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.FileManager;
import com.founder.rhip.ehr.repository.portal.IFileManagerDao;

/**
 * DAO implement of FileManager
 * 
 */
@Repository("lhFileManagerDao")
public class FileManagerDaoImpl extends AbstractDao<FileManager, Long> implements IFileManagerDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
