package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfoReponse;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.service.ta.IOutpatientInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 2016/11/8.
 */
@Service("inpatientInfoService")
public class OutpatientInfoServiceImpl implements IOutpatientInfoService {

    @Resource
    private IOutpatientInfoDao outpatientInfoDao;

    /**
     * 获取单条门诊摘要信息
     * @param criteria
     * @return
     */
    @Override
    public OutpatientInfo getOutpatientInfos(Criteria criteria) {
        return outpatientInfoDao.get(criteria);
    }

    /**
     * 获取多条门诊摘要信息
     * @param criteria
     * @return
     */
    @Override
    public List<OutpatientInfo> getOutpatientInfoLists(Criteria criteria) {
        return outpatientInfoDao.getList(criteria);
    }

    /**
     * 通过personId参数获取门诊相关表的字段信息集合
     * @param personId
     * @return
     */
    @Override
    public List<Map<String, Object>> getPatientAllInfoList(String personId) {
        return outpatientInfoDao.getPatientAllInfos(personId);
    }

    /**
     * 通过EhrID参数获取门诊相关表的字段信息
     * @param EhrId
     * @return
     */
    @Override
    public Map<String, Object> getOutPatientInfo(String EhrId) {
        return outpatientInfoDao.getOutPatientInfo(EhrId);
    }

    /**
     * 查找去重的门诊信息
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public List<OutpatientInfo> getDistinctList(Criteria criteria, Order order){
        return outpatientInfoDao.getDistinctList(criteria, order);
    }
}
