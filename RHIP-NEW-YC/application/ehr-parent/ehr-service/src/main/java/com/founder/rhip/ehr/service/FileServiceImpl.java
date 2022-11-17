package com.founder.rhip.ehr.service;

import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * File 服务.
 *
 */
@Service
public class FileServiceImpl implements FileService {

	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

}
