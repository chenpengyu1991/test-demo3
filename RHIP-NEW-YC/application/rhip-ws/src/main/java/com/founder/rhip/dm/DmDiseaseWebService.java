package com.founder.rhip.dm;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.dto.ToBringIntoDiseaseInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * 待建慢病管理卡提醒
 * 
 * @author liuk
 * 
 */
@Service("dmDiseaseWebService")
@WebService(serviceName = "dmDiseaseWebService")
public class DmDiseaseWebService extends DmBaseWebService implements IDmDiseaseWebService {

	/**
	 * 无待建管理卡
	 */
	public static final String NO_TO_BRING = "0";
	public static final String NO_TO_BRING_MESSAGE = "无待建管理卡";
	/**
	 * 有待建管理卡
	 */
	public static final String HAS_TO_BRING = "1";
	public static final String HAS_TO_BRING_MESSAGE = "有待建管理卡";

	@Autowired(required = false)
	@Qualifier("standardizationService")
	private IStandardizationService standardizationService;

	@Override
	public DmDiseaseInfoResult queryToBringIntoInfo(String idNum, String orgCode) {
		check(idNum, orgCode);
		PersonInfo personInfo = queryPerson(idNum);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			dealError(DmErrorCode.PERSON_CANNOT_FOUND);
		}
		DmDiseaseInfoResult diseaseInfoResult = new DmDiseaseInfoResult();
		//获取慢病待建卡信息
		List<ToBringIntoDiseaseInfo> resut = getToBringIntoInfo(personInfo.getId(), orgCode);
		if (ObjectUtil.isNullOrEmpty(resut)) {
			diseaseInfoResult.setCode(NO_TO_BRING);
			diseaseInfoResult.setMessage(NO_TO_BRING_MESSAGE);
		} else {
			diseaseInfoResult.setCode(HAS_TO_BRING);
			diseaseInfoResult.setMessage(HAS_TO_BRING_MESSAGE);
			diseaseInfoResult.setValue(resut);
		}
		return diseaseInfoResult;
	}

	private List<ToBringIntoDiseaseInfo> getToBringIntoInfo(Long personId, String orgCode) {
		if (null != standardizationService) {
			return standardizationService.getToBringIntoDiseaseInfos(personId, orgCode);
		}
		return null;
	}

	/**
	 * 检查参数
	 * @param idNum
	 * @param orgCode
	 */
	private void check(String idNum, String orgCode) {
		if (ObjectUtil.isNullOrEmpty(idNum)) {
			logger.error("管理卡提醒接口:身份证参数为空");
			dealError(DmErrorCode.IDCARD_IS_NULL);
		}
		if (!checkIdacrd(idNum)) {
			logger.error("管理卡提醒接口:身份证不合法");
			dealError(DmErrorCode.IDCARD_IS_ERROR);
		}
		if (ObjectUtil.isNullOrEmpty(orgCode)) {
			logger.error("管理卡提醒接口:机构参数为空");
			dealError(DmErrorCode.ORG_CODE_IS_NULL);
		}
		if (!checkOrganCode(orgCode)) {
			logger.error("管理卡提醒接口:根据机构代码无法获取到机构 当前机构代码为:" + orgCode);
			dealError(DmErrorCode.ORG_CANNOT_FOUND);
		}
	}

}
