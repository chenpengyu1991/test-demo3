package com.founder.rhip.ehr.service.basic;

import javax.annotation.Resource;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.AdministrativeArea;
import com.founder.rhip.ehr.entity.basic.RecordSerialNumber;
import com.founder.rhip.ehr.repository.basic.IAdministrativeAreaDao;
import com.founder.rhip.ehr.repository.basic.IRecordSerialNumberDao;

import java.util.Date;
import java.util.List;

/**
 * 编号生成器
 * @author ding_donghong
 *
 */
@Transactional
@Service("EHRNumberService")
public class EHRNumberServiceImpl extends AbstractService implements IEHRNumberService {
	@Resource(name="recordSerialNumberDao")
	private IRecordSerialNumberDao recordSerialNumberDao;
	
	@Resource(name="administrativeAreaDao")
	private IAdministrativeAreaDao administrativeAreaDao;

    @Autowired
    private IOrganizationApp organizationApp;

    /**
     * 体检编号类型
     */
    private static final String PHY_EXAMINATION_NUMBER_TYPE = "EXBH";
    /**
     * 监控档案编号类型
     */
    private static final String EHR_NUMBER_TYPE = "GRBH";

	/**
	 * 根据个人行政区划编号获取健康档案编号（此函数已经废弃，不建议使用（并发会引起档案号重复））
	 */
	@Override
	@Transactional
    @Deprecated
	public String getHealthFileNo(String villageCode){
        //查询areaId
        Criteria criteriaArea = new Criteria();
        criteriaArea.add("gBCode", villageCode);
        AdministrativeArea administrativeArea = administrativeAreaDao.get(criteriaArea);
        Long areaId = 1L;
        if(administrativeArea != null) {
            areaId = administrativeArea.getId();
        } else{
            return "villageCode is error";
        }

        //当前流水号
        Long currentSerialNum = 1L;
        Criteria criteriaRecord = new Criteria();
        criteriaRecord.add("administratorAreaId", areaId);
        //查找个人档案流水号
        RecordSerialNumber recordSerialNum = recordSerialNumberDao.get(criteriaRecord);
        //存在
        if (recordSerialNum != null) {
            currentSerialNum = recordSerialNum.getSerialNumber() + 1L;
            //更新现有流水号
            recordSerialNum.setSerialNumber(currentSerialNum);
            recordSerialNumberDao.update(recordSerialNum);
        }
        //不存在
        else {
            recordSerialNum = new RecordSerialNumber();
            recordSerialNum.setNumberType("GRBH");
            recordSerialNum.setAdministratorAreaId(areaId);
            recordSerialNum.setSerialNumber(currentSerialNum);
            recordSerialNumberDao.insert(recordSerialNum);
        }
        if (villageCode != null && villageCode.trim().length() >= 12) {
            StringBuffer result = new StringBuffer();
            result.append(villageCode.substring(0, 12));
            //补齐5位流水号
            for (int i = String.valueOf(currentSerialNum).length(); i < 5; i++) {
                result.append("0");
            }
            result.append(currentSerialNum);
            return result.toString();
        } else{
            return "villageCode is error";
        }

	}

    @Override
    @Transactional
    public String getSerialNum(String villageCode,String numberType) {
        String result;
        if(PHY_EXAMINATION_NUMBER_TYPE.equals(numberType)){
            result = getPhyExamNumber(villageCode);
        }else if(EHR_NUMBER_TYPE.equals(numberType)){
            result = getHealthFileNo(villageCode);
        }else{
            return "";
        }
        return result;
    }

    /**
     * 获取健康档案编号
     * @param villageCode
     * @return
     */
    private String getHealthFileNoFinal(String villageCode){
        //健康档案
        Criteria criteriaArea = new Criteria();
        criteriaArea.add("gBCode", villageCode);
        AdministrativeArea administrativeArea = administrativeAreaDao.get(criteriaArea);
        if(ObjectUtil.isNullOrEmpty(administrativeArea)){
            return "";
        }
        Long areaId = administrativeArea.getId();

        Long currentSerialNum = getCurrentSerialNum(areaId,EHR_NUMBER_TYPE);
        StringBuffer result = new StringBuffer();
        //添加机构部分编码
        result.append(getOrganCodePart(villageCode,EHR_NUMBER_TYPE));
        result.append(getSerialNumPart(currentSerialNum,EHR_NUMBER_TYPE));
        return result.toString();
    }

    /**
     * 获取体检编号
     * @param villageCode
     * @return
     */
    private String getPhyExamNumber(String villageCode){
        Organization organization = organizationApp.queryOrgan(villageCode);
        if(ObjectUtil.isNullOrEmpty(organization)){
            return "";
        }
        Long areaId = organization.getOrganId();
        Long currentSerialNum = getCurrentSerialNum(areaId,PHY_EXAMINATION_NUMBER_TYPE);
        StringBuffer result = new StringBuffer();
        //添加机构部分编码
        result.append(getOrganCodePart(villageCode,PHY_EXAMINATION_NUMBER_TYPE));
        result.append(getSerialNumPart(currentSerialNum,PHY_EXAMINATION_NUMBER_TYPE));
        return result.toString();
    }

    /**
     * 获取当前流水号
     * @param areaId
     * @param numberType
     * @return
     */
    private synchronized Long getCurrentSerialNum(Long areaId,String numberType){
        //当前流水号
        Long currentSerialNum = 1L;

        Criteria criteriaRecord = new Criteria();
        criteriaRecord.add("administratorAreaId", areaId);
        criteriaRecord.add("numberType", numberType);
        //查找个人档案流水号
        RecordSerialNumber recordSerialNum = recordSerialNumberDao.get(criteriaRecord);
        if(ObjectUtil.isNotEmpty(recordSerialNum)){
            //存在
            currentSerialNum = recordSerialNum.getSerialNumber() + 1L;
            //更新现有流水号
            recordSerialNum.setSerialNumber(currentSerialNum);
            recordSerialNumberDao.update(recordSerialNum);
        }else{
            //不存在
            recordSerialNum = new RecordSerialNumber();
            recordSerialNum.setNumberType(numberType);
            recordSerialNum.setAdministratorAreaId(areaId);
            recordSerialNum.setSerialNumber(currentSerialNum);
            recordSerialNumberDao.insert(recordSerialNum);
        }
        return currentSerialNum;
    }
    /**
     * 获取机构部分编码
     * @param villageCode
     * @param numberType
     * @return
     */
    private String getOrganCodePart(String villageCode,String numberType){
        StringBuffer result = new StringBuffer();
        int start = 0;
        int end = 12;
        int codeLen = 12;
        if(PHY_EXAMINATION_NUMBER_TYPE.equals(numberType)){
            start = villageCode.length()-4;
            end = villageCode.length();
            codeLen = 4;
        }
        if(StringUtil.isNotEmpty(villageCode) && villageCode.length() >= codeLen){
            //机构编码满足位数
            result.append(villageCode, start, end);
        }else{
            //机构编码不足位数
            result.append(String.format("%0" + codeLen + "d",villageCode));
        }
        return result.toString();
    }

    /**
     * 补足流水号
     * @param currentSerialNum
     * @param numberType
     * @return
     */
    private String getSerialNumPart(Long currentSerialNum,String numberType){
        StringBuffer result = new StringBuffer();
        int servialNumLen = 5;
        if(PHY_EXAMINATION_NUMBER_TYPE.equals(numberType)){
            //如果是 体检编号则是2位年份加7位流水号
            servialNumLen = 7;
            result.append(DateUtil.getDateTime("yy",new Date()));
        }
        result.append(String.format("%0" + servialNumLen + "d",currentSerialNum));
        return result.toString();
    }
}