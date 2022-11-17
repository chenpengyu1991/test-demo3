
package com.founder.elb.service;

import java.util.List;
import java.util.Map;

import com.founder.elb.entity.CvConfig;
import com.founder.elb.entity.CvDicmeta;
import com.founder.elb.entity.CvDictionary;
import com.founder.elb.entity.Domain;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IDictionaryService {

    int createCvDicmeta(CvDicmeta cvDicmeta);

    List<CvDicmeta> getCvDicmetas(Criteria criteria);

    List<CvConfig> getCvConfigs(String code);

    List<CvConfig> getCvConfigs(Criteria criteria);

    int updateCvDicmeta(CvDicmeta cvDicmeta);

    int createDictionary(CvDictionary cvDictionary);

    int updateDictionary(CvDictionary cvDictionary);

    int deleteDictionary(Long...id);

    PageList<Map<String,Object>> getDictionaries(Page page, String code);

    List<Domain> getDomains();

    public int importDictionaries(String code, List<Map<String, Object[]>> list);

    public List<CvDictionary> getDictionary(String code);

    public List<CvDictionary> getDictionaries(Criteria criteria);

    public CvDictionary getDictionaryValue(String cvDicmetaCode, String code);
    
	public List<CvDictionary> getDictionary(String code,String clinicId);

}
