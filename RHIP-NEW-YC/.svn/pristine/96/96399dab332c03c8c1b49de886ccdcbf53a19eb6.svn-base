package com.founder.rhip.ehr.service.file;

import com.founder.rhip.ehr.entity.file.FileDo;
import com.founder.rhip.ehr.repository.mongo.FileDoDao;
import com.founder.rhip.ehr.repository.mongo.GridFileDao;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;

/**
 * File 服务.
 *
 */
@Service
public class MongoServiceImpl implements MongoService {

	@Resource(name="fileDoDao")
	public FileDoDao fileDoDao;
	@Resource(name="gridFileDao")
	@Autowired
	public GridFileDao gridFileDao;


	@Override
	public String saveGridFSFile(InputStream inputStream, String fileName, String contentType, Date createDate) {
		return gridFileDao.save(inputStream,fileName,contentType,createDate);
	}

	@Override
	public void removeGridFSFile(Object id) {
		this.gridFileDao.removeFile(id);
	}

	@Override
	public GridFSDBFile getGridFSFile(Object id) {
		return gridFileDao.getFileById(id);
	}

	@Override
	public String saveFile(FileDo fileDo) {
		//获取开始时间
		long startTime=System.currentTimeMillis();
		FileDo returnFileDo = fileDoDao.save(fileDo);
		//获取结束时间
		long endTime=System.currentTimeMillis();
		System.out.println(" 上传图片程序运行时间： "+(endTime-startTime)+"ms");
		return returnFileDo.get_id();
	}

	@Override
	public void removeFile(String id) {
		fileDoDao.deleteById(id);
	}

	@Override
	public FileDo getFileById(String id) {
		//获取开始时间
		long startTime=System.currentTimeMillis();
		System.out.println("================getFileById:" + id);
		FileDo fileDo = fileDoDao.queryById(id);
		//获取结束时间
		long endTime=System.currentTimeMillis();
		System.out.println(id + " 获取图片程序运行时间： "+(endTime-startTime)+"ms");
		return fileDo;
	}

}
