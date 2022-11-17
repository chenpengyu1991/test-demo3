package com.founder.rhip.ehr.service.ta;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by f on 2016/11/8.
 */
public interface IOutpatientInfoService {
    /**
     * 获取单条门诊摘要信息
     * @param criteria
     * @return
     */
    public OutpatientInfo getOutpatientInfos(Criteria criteria);

    /**
     * 获取多条门诊摘要信息
     * @param criteria
     * @return
     */
    public List<OutpatientInfo>  getOutpatientInfoLists(Criteria criteria);

    /**
     * 通过personId参数获取门诊相关表的字段信息集合
     * @param personId
     * @return
     */
    public List<Map<String,Object>> getPatientAllInfoList(String personId);

    /**
     * 通过EhrID参数获取门诊相关表的字段信息
     * @param EhrId
     * @return
     */
    public Map<String,Object> getOutPatientInfo(String EhrId);

    /**
     * 查找去重的门诊信息
     * @param criteria
     * @param order
     * @return
     */
    public List<OutpatientInfo> getDistinctList(Criteria criteria, Order order);
}
