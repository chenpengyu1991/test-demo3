package com.founder.rhip.cpw;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.clinic.GetPatientbedRequest;
import com.founder.rhip.ehr.entity.clinic.PaitentbedStatus;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.service.util.XmlWebserviceForUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 医院床位情况数据
 *
 * @author Ye jianfei
 * @version 1.0, 2014-7-3
 */
@Service("sickbedStateWebService")
@WebService(serviceName = "sickbedStateWebService")
public class SickbedStateWebService extends CpwBaseWebService implements ISickbedStateWebService {

    @Resource(name = "sickbedStateService")
    private ISickbedStateService sickbedStateService;

    @Autowired
    private IHospitalInfoDao hospitalInfoDao;

    @Override
    public String uploadSickbedState(String sickbedStateXml) {
        CpwResult cpwResult = new CpwResult();
        if (ObjectUtil.isNullOrEmpty(sickbedStateXml)) {
            cpwResult.setMessage("传入xml数据为空");
        } else {
            save(sickbedStateXml, "ssu");
            GetPatientbedRequest getPatientbedRequest = new GetPatientbedRequest();
            try {
                getPatientbedRequest = XmlWebserviceForUtil.parseDataXml(sickbedStateXml, GetPatientbedRequest.class);
                //判断医院code是否有对应医院
                List<HospitalInfo> hospitalInfos = hospitalInfoDao.getList(new Criteria("IS_DELETE", "0"));
                Map<String, String> hosNameMap = new HashMap<String, String>();
                for (HospitalInfo hospitalInfo : hospitalInfos) {
                    hosNameMap.put(hospitalInfo.getHospitalNo(), hospitalInfo.getHospitalName());
                }
                List<PaitentbedStatus> paitentbedStatusList = getPatientbedRequest.getPaitentbedStatusList();
                for (PaitentbedStatus paitentbedStatus : paitentbedStatusList) {
                    String hospitalName = hosNameMap.get(paitentbedStatus.getHospitalCode());
                    if (StringUtil.isNullOrEmpty(hospitalName)) {
                        cpwResult.setMessage("存在无效的医院编码记录未能插入！");
                    }
                    paitentbedStatus.setHospitalName(hospitalName);
                }
                dealWithData(getPatientbedRequest, cpwResult);
            } catch (Exception e) {
                logger.error("医院床位情况数据接口：" + e, e);
                cpwResult.setMessage(e.getMessage());
            } finally {
                getPatientbedRequest = null;
            }
        }
        if (cpwResult.getCode().equals("2001")) {//失败
            logger.error("医院床位情况数据接口：" + "," + cpwResult.getMessage());
        }

        String result = cpwResult.toXml();
        return result;
    }

    /**
     * 处理数据
     *
     * @param getPatientbedRequest
     * @param cpwResult
     * @return
     * @author Ye jianfei
     */
    private void dealWithData(GetPatientbedRequest getPatientbedRequest, CpwResult cpwResult) {
        boolean checkFlag = checkData(getPatientbedRequest, cpwResult, new String[]{"paitentbedStatusList"});
        if (checkFlag) {
            try {
                sickbedStateService.uploadSickbedStateData(getPatientbedRequest);
            } catch (Exception e) {
                logger.error("医院床位情况数据保存失败" + e, e);
                cpwResult.setMessage("医院床位情况数据保存异常:" + e.getMessage());
            }
        }
    }

    private boolean checkData(GetPatientbedRequest getPatientbedRequest, CpwResult cpwResult, String... properties) {
        boolean result = true;
        String message = validateModel(getPatientbedRequest, properties);
        if (StringUtil.isNotEmpty(message)) {
            cpwResult.setMessage(message);
            result = false;
        }
        return result;
    }
}
