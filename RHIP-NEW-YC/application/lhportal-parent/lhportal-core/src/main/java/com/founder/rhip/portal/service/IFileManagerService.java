package com.founder.rhip.portal.service;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.FileManager;


/**
 * @author Jiang Haiying
 *
 */
public interface IFileManagerService {

	/**
	 * 获取分页式的列表数据
	 * @param criteria
	 * @param page
	 * @return
	 */
	public PageList<FileManager> getFileManagers(Criteria criteria, Page page);
	
	/**
	 * 保存
	 * @param fileManager
	 * @return
	 * @throws Exception
	 */
    public boolean save(FileManager fileManager, Map<String, String> map, String createUserCode) throws Exception;

	/**
	 * 保存
	 * @param fileManager
	 * @return
	 * @throws Exception
	 */
	public boolean save(FileManager fileManager, Map<String, String> fileMap,Map<String, String> fileNameMap, String createUserCode) throws Exception;
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Long id);
    
    /**
     * 获取FileManager对象
     * @param criteria
     * @return
     */
    public FileManager getFileManager(Criteria criteria, String... properties);
    
    /**
     * 更新
     * @param fileManager
     * @return
     */
    public boolean update(FileManager fileManager,Map<String, String> map, String createUserCode, String... properties);

	/**
	 * 更新
	 * @param fileManager
	 * @return
	 */
	public boolean update(FileManager fileManager,Map<String, String> fileMap,Map<String, String> fileNameMap,  String createUserCode, String... properties);

    public int update(FileManager fileManager);
    /**
     * 修改发布状态
     * @param fileId
     * @param fileStatus
     * @return
     */
    public boolean publish(Long fileId, String fileStatus);
}
