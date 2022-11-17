package com.founder.rhip.cpw;

import javax.annotation.Resource;
import javax.jws.WebService;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;

/**
 * 临床路径
 * 
 * @version 1.0, 2014-7-3
 * @author Ye jianfei
 */
@Service("clinicalPathwayWebService")
@WebService(serviceName = "clinicalPathwayWebService")
public class CpwWebService extends CpwBaseWebService implements ICpwWebService {
	
	@Resource(name = "clinicalPathwayService")
	private ICpwService cpwService;
	
	@Override
	public String uploadCpw(String cpwXml) {
		CpwResult cpwResult = new CpwResult();
		if (ObjectUtil.isNullOrEmpty(cpwXml)) {
			cpwResult.setMessage("传入xml数据为空");
		} else {
            save(cpwXml,"cpw");
            ClinicalPathway clinicalPathway = null;
			try {
				clinicalPathway = parse(ClinicalPathway.class, cpwXml);
				dealWithData(clinicalPathway,cpwResult);
			} catch (Exception e) {
				logger.error("临床路径数据接口：" + e, e);
				cpwResult.setMessage(e.getMessage());
			} finally {
				clinicalPathway = null;
			}
		}
		if(cpwResult.getCode().equals("2001")){//失败
			logger.error("临床路径数据接口："  + "," + cpwResult.getMessage());
		}

		String result =cpwResult.toXml();
		return result;		
	}
	/**
	 * 处理数据
	 *
	 * @param clinicalPathway
	 * @param cpwResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithData(ClinicalPathway clinicalPathway,CpwResult cpwResult){
		boolean checkFlag = checkData(clinicalPathway,cpwResult,new String[]{"hospitalCode","departmentCode","departmentName","idCard"
				,"patientName","admissionNo","outpatientNo","diagnosisCode"
				,"diagnosisName","intoTime","quitReason","variationReason"
				,"cureMark","improveMark","deathMark","quitPathTime"
				,"completePathTime","variationOfTime","deathOfDate"});
		if(checkFlag){
			try{
				cpwService.uploadCpwData(clinicalPathway);
			}
			catch(Exception e){
				logger.error("临床路径数据保存失败" + e, e);
				cpwResult.setMessage("临床路径数据保存异常:" + e.getMessage());
			}
		}	
	}
	
	private boolean checkData(ClinicalPathway clinicalPathway,CpwResult cpwResult,String...properties) {
		boolean result = true;
		String message = validateModel(clinicalPathway,properties);
		if(StringUtil.isNotEmpty(message)){
			cpwResult.setMessage(message);
			result = false;
		}
		return result;
	}
}
