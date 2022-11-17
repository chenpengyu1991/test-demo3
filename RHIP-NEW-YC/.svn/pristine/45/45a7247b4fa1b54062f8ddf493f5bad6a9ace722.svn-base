package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.fasf.repository.IDao;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DiseaseDiagnosisInfo
 */
public interface IDiseaseDiagnosisInfoDao extends IDao<DiseaseDiagnosisInfo, Long> {

    public PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoForCdm(Page page, Criteria criteria);

    List<String> getRelationOrganCodes(Long personId);

    /**
     *
     * @param dateStr
     * @return
     */
    public List<Map<String, Object>> getDiseasesStatistics(String dateStr);
    
    /**
     * 获取疾病统计结果
     * @param paramMap 查询条件
     * @return
     */
    public List<Map<String, Object>> getDiseaseMapList(Map<String, String> paramMap);

    /**
     * 获取疾病名称
     * @param criteria
     * @return
     */
    public String getDiseaseName(Criteria criteria);

    /**
     * 疾病排名-数据抽取
     * @param ca 查询条件
     * @return
     */
    public List<Map<String, Object>> getDiseaseMapList(Criteria ca);
}