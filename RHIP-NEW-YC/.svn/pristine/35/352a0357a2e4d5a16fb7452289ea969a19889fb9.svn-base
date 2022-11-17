package com.founder.rhip.ehr.service.file;


import com.founder.rhip.ehr.entity.file.FileDo;
import com.mongodb.gridfs.GridFSDBFile;

import java.io.InputStream;
import java.util.Date;


/**
 * File 服务接口.
 *
 */
public interface MongoService {

	/**
	 * 保存Apk文件
	 * @param inputStream
	 * @param fileName
	 * @param contentType
	 * @param createDate
	 * @return
	 */
	String saveGridFSFile(InputStream inputStream, String fileName, String contentType, Date createDate);

	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	void removeGridFSFile(Object id);

	/**
	 * 根据id获取文件
	 * @param id
	 * @return
	 */
	GridFSDBFile getGridFSFile(Object id);

	/**
	 * 保存文件
	 * @param file
	 * @return 保存后的mongdb生成的id
	 */
	String saveFile(FileDo file);

	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	void removeFile(String id);

	/**
	 * 根据id获取文件
	 * @param id
	 * @return
	 */
	FileDo getFileById(String id);
}
