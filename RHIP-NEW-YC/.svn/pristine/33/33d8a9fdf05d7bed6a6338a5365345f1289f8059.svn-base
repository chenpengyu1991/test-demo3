package com.founder.rhip.cpw;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.PaitentbedStatus;
import com.founder.rhip.ehr.entity.clinic.GetPatientbedRequest;
import com.founder.rhip.ehr.repository.clinic.IPatientbedStatusDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;
import com.founder.rhip.ehr.repository.clinic.ISickbedUseStateDao;

/**
 * 医院床位情况数据管理
 *
 * @author Ye jianfei
 * @version 1.0, 2014-7-3
 */
@Service("sickbedStateService")
public class SickbedStateService implements ISickbedStateService {

    @Resource(name = "sickbedUseStateDao")
    private ISickbedUseStateDao sickbedUseStateDao;

    @Resource(name = "patientbedStatusDao")
    private IPatientbedStatusDao patientbedStatusDao;

    @Override
    @Transactional
    public void uploadSickbedStateData(GetPatientbedRequest getPatientbedRequest) {
        if (ObjectUtil.isNotEmpty(getPatientbedRequest)) {
            updatePaintentState(getPatientbedRequest);
        }
    }


    /**
     * 设置机构、人员相关信息
     *
     * @param sickbedUseState
     * @author Ye jianfei
     */
    private void setBasicInfo(SickbedUseState sickbedUseState) {
        if (ObjectUtil.isNullOrEmpty(sickbedUseState.getId())) {
            sickbedUseState.setCreateOrg("");
            sickbedUseState.setCreateUser("");
            sickbedUseState.setCreateDate(new Date());
        }
        sickbedUseState.setUpdateOrg("");
        sickbedUseState.setUpdateUser("");
        sickbedUseState.setUpdateDate(new Date());
    }


    /**
     * 新增或更新医院床位情况数据
     *
     * @param sickbedUseState
     * @param properties
     * @author Ye jianfei
     */
    private void updateSickbedState(SickbedUseState sickbedUseState, String... properties) {
        if (ObjectUtil.isNotEmpty(sickbedUseState)) {
            setBasicInfo(sickbedUseState);
            if (ObjectUtil.isNotEmpty(sickbedUseState.getId())) {
                sickbedUseStateDao.update(sickbedUseState, properties);
            } else {
                sickbedUseStateDao.insert(sickbedUseState);
            }
        }
    }

    /**
     * 新增或更新床位情况
     *
     * @param getPatientbedRequest
     * @param properties
     */
    private void updatePaintentState(GetPatientbedRequest getPatientbedRequest, String... properties) {
        //获取当前时间
        Date nowdate = new Date();
        if (ObjectUtil.isNotEmpty(getPatientbedRequest)) {
            List<PaitentbedStatus> paitentbedStatusList = getPatientbedRequest.getPaitentbedStatusList();
            for (PaitentbedStatus paitentbedStatus : paitentbedStatusList) {
                String hospitalCode = paitentbedStatus.getHospitalCode();
                String depCode = paitentbedStatus.getDepCode();
                Criteria criteria = new Criteria();
                criteria.add("hospitalCode", hospitalCode);
                criteria.add("depCode", depCode);
                //查询病床表，判断是否更新
                PaitentbedStatus paitentbedStatusRes = patientbedStatusDao.get(criteria);
                if (ObjectUtil.isNotEmpty(paitentbedStatusRes)) {
                    paitentbedStatus.setId(paitentbedStatusRes.getId());
                    paitentbedStatus.setUpdateTime(nowdate);
                    patientbedStatusDao.update(paitentbedStatus, properties);
                } else {
                    String hospitalName = paitentbedStatus.getHospitalName();
                    if (StringUtil.isNotEmpty(hospitalName)) {
                        paitentbedStatus.setCreateTime(nowdate);
                        paitentbedStatus.setUpdateTime(nowdate);
                        patientbedStatusDao.insert(paitentbedStatus);
                    }
                }
            }
        }
    }

}
