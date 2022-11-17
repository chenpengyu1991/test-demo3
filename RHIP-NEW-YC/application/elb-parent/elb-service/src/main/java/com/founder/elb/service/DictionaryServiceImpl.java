package com.founder.elb.service;

import com.founder.elb.entity.CvConfig;
import com.founder.elb.entity.CvDicmeta;
import com.founder.elb.entity.CvDictionary;
import com.founder.elb.entity.Domain;
import com.founder.elb.repository.ICvDicmetaDao;
import com.founder.elb.repository.ICvDictionaryDao;
import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryServiceImpl extends AbstractService implements IDictionaryService {
	
	@Resource(name = "cvDicmetaDao")
	private ICvDicmetaDao cvDicmetaDao;	
	
	@Resource(name = "cvDictionaryDao")
	private ICvDictionaryDao cvDictionaryDao;	

	/**
	 * 新增字典结构
	 * 
	 * @param CvDicmeta
	 * @return int
	 */
	@Transactional
	public int createCvDicmeta(CvDicmeta cvDicmeta) {
		int result = 0;
		
		List<CvConfig> list = cvDicmeta.getCvConfigList();
		for (CvConfig cvConfig:list) {
			if (ObjectUtil.isNotEmpty(cvConfig)) {
				result = genericDao.insert(cvConfig);
				if (result < 0) {
					return result;
				}
			}
		}

		if (ObjectUtil.isNotEmpty(cvDicmeta)) {
			result = cvDicmetaDao.insert(cvDicmeta);
		}
		return result;
	}
	
	/**
	 * 查询字典结构目录列表
	 * 
	 * @param CvDicmeta
	 * @return List<CvDicmeta>
	 */
	public List<CvDicmeta> getCvDicmetas(Criteria criteria) {
		List<CvDicmeta> cvDicmetaList = null;
		List<CvConfig> cvConfigList = null;

		if (ObjectUtil.isNotEmpty(criteria)) {
			cvDicmetaList = cvDicmetaDao.getList(criteria);
			for (CvDicmeta cvDicmeta:cvDicmetaList) {
				cvConfigList = getCvConfigs(cvDicmeta.getCode());
				cvDicmeta.setCvConfigList(cvConfigList);
			}
		}
		return cvDicmetaList;
	}
	
	/**
	 * 查询字典结构配置列表
	 * 
	 * @param Code  术语目录编码
	 * @return List<CvConfig>
	 */
	public List<CvConfig> getCvConfigs(String code) {
		Criteria criteria = new Criteria("code",code);	
		List<CvConfig> cvConfigList = genericDao.getList(CvConfig.class,criteria);
		return cvConfigList;
	}
	
	/**
	 * 查询审批字典结构详细
	 * 
	 * @param Code  术语目录编码
	 * @return List<CvConfig>
	 */
	public List<CvConfig> getCvConfigs(Criteria criteria) {
		List<CvConfig> cvConfigList = genericDao.getList(CvConfig.class,criteria);
		return cvConfigList;
	}
	
	/**
	 * 更新字典结构
	 * 
	 * @param CvDicmeta
	 * @return int
	 */
	public int updateCvDicmeta(CvDicmeta cvDicmeta) {
		
		int result = 0;
		if (ObjectUtil.isNotEmpty(cvDicmeta) && cvDicmeta.getId() > 0) {
			result = cvDicmetaDao.update(cvDicmeta);
		}

		return result;
	}

	/**
	 * 新增字典内容
	 * 
	 * @param cvDictionary
	 * @return int
	 */
	public int createDictionary(CvDictionary cvDictionary) {
		
		int result = 0;
		if (ObjectUtil.isNotEmpty(cvDictionary)) {
			result = genericDao.insert(cvDictionary);
		}

		return result;
	}
	
	/**
	 * 更新字典内容
	 * 
	 * @param cvDictionary
	 * @return int
	 */
	public int updateDictionary(CvDictionary cvDictionary) {
		
		int result = 0;
		if (ObjectUtil.isNotEmpty(cvDictionary) && cvDictionary.getId() > 0) {
			result = genericDao.update(cvDictionary);
		}

		return result;
	}
	
	/**
	 * 通过PK数组删除字典内容
	 * 
	 * @param cvDictionary
	 * @return int
	 */
	public int deleteDictionary(Long...id) {
		
		int result = 0;
		if (id != null && id.length > 0) {
			result = genericDao.delete(CvDictionary.class,id);
		}

		return result;
	}
	
	/**
	 * 查询字典内容列表
	 * 
	 * @param page
	 * @param code 术语目录编码
	 * @return PageList<Map<String,Object>>
	 */
	public PageList<Map<String,Object>> getDictionaries(Page page, String code) {
		
		PageList<Map<String,Object>> list = null;
		List<CvConfig> cvConfigList = null;
		String sql = "select ";
		cvConfigList = getCvConfigs(code);
		if (cvConfigList != null) {
			for (int i=0; i<cvConfigList.size(); i++) {
				if (i < cvConfigList.size() - 1) {
					sql = sql + cvConfigList.get(i).getColumnName() + ",";
				} else {
					sql = sql + cvConfigList.get(i).getColumnName() + " ";
				}
			}
		}
		sql = sql + " from cv_dictionary  ";
		Criteria criteria = new Criteria("cv_dicmeta_code", code);	
		list = cvDictionaryDao.getDictionaries(page,sql,criteria);
		return list;
	}
	
	/**
	 * 查询域表信息列表
	 * 
	 * @return List<Domain>
	 */
	public List<Domain> getDomains() {
		List<Domain> domainList = genericDao.getAll(Domain.class);
		return domainList;
	}
	
	/**
	 * 批量导入指定字典内容
	 * 
	 * @param code 术语目录编码
	 * @param List<Map<String,Object[]>>  字典内容, Excel一行的内容存入一个MAP中，value以Object[]形式存储
	 * @return int
	 */
	public int importDictionaries(String code, List<Map<String, Object[]>> list) {
		
		CvDictionary cvDictionary = null;
		List<CvDictionary> insertList = new ArrayList<CvDictionary>();

		int result = 0;
		if (list != null) {
			int columnCnt = list.size();
			for (int i=0; i<columnCnt; i++) {
				cvDictionary = BeanUtil.getBean(CvDictionary.class, list.get(i));
				insertList.add(cvDictionary);
			}
		}

		result = genericDao.batchInsert(insertList);
		return result;
	}
	
	/**
	 * 查询指定字典内容列表
	 * 
	 * @param code 术语目录编码
	 * @return List<CvDictionary>
	 */
	public List<CvDictionary> getDictionary(String code) {
		
		List<CvDictionary> list = null;

		Criteria criteria = new Criteria("cv_dicmeta_code", code);	
		list = genericDao.getList(CvDictionary.class,criteria);
		return list;
	}

	/**
	 * 查询指定字典内容列表
	 * 
	 * @param code 术语目录编码
	 * @return List<CvDictionary>
	 */
	public List<CvDictionary> getDictionaries(Criteria criteria) {
		
		List<CvDictionary> list = null;
		list = genericDao.getList(CvDictionary.class,criteria);
		return list;
	}
	
	/**
	 * 查询指定字典内容值
	 * 
	 * @param cvDicmetaCode 术语目录编码
	 * @param code 术语编码
	 * @return CvDictionary
	 */
	public CvDictionary getDictionaryValue(String cvDicmetaCode, String code) {
		
		CvDictionary cvDictionary = null;
		Criteria criteria = new Criteria("cvDicmetaCode", cvDicmetaCode).add("code", code);	
		cvDictionary = genericDao.get(CvDictionary.class,criteria);
		return cvDictionary;
	}

	/**
	 * 根据科室ID查询该科室职称编码
	 */
	@Override
	public List<CvDictionary> getDictionary(String code, String clinicId) {
		List<CvDictionary> list = null;

		list = cvDictionaryDao.getDictionary(code, clinicId);
		return list;
	}
}
