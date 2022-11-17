package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;

import java.util.Map;


public interface ICdmPerformanceDao extends IDao<DmPersonInfo, Long> {
    /**
     *
     * @param type 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<Map<String, Object>> getCdmPerformance(String type, Map<String, String> paramMap, Page page);

}