package com.founder.rhip.dm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.service.IFollowupRecordService;
import com.founder.rhip.ehr.dto.ChronicFollowupInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * 随访提醒
 * 
 * @author liuk
 * 
 */
@Service("followupWebService")
@WebService(serviceName = "FollowupWebService")
public class FollowupWebService extends DmBaseWebService implements IFollowupWebService {

	@Resource(name = "followupRecordService")
	private IFollowupRecordService followupRecordService;

	/**
	 * 无提醒
	 */
	public static final String NO_FOLLOWP = "0";
	public static final String NO_FOLLOWP_MESSAGE = "无需提示";
	/**
	 * 有提醒
	 */
	public static final String HAS_FOLLOWP = "4";
	public static final String HAS_FOLLOWP_MESSAGE = "待随访";

	@Override
	public FollowupInfoResult queryFollowupInfo(String idNum, String name) {
		logger.info("随访提醒接口:调用开始 idNum:" + idNum);
		check(idNum, name);
		FollowupInfoResult result = new FollowupInfoResult();
		PersonInfo personInfo = queryPerson(idNum);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			dealError(DmErrorCode.PERSON_CANNOT_FOUND);
		}
		if (!personInfo.getName().equals(name)) {
			// dealError("姓名与已管理人员不同");
		}
		List<ChronicFollowupInfo> resultInfos = new ArrayList<>();
		//获取慢病
		List<ChronicFollowupInfo> cdmReult = queryCdmFollowupInfo(personInfo);
		//获取传染病
		List<ChronicFollowupInfo> idmReult = queryIdmFollowupInfo(personInfo);
		if (ObjectUtil.isNotEmpty(cdmReult)) {
			resultInfos.addAll(cdmReult);
		}
		if (ObjectUtil.isNotEmpty(idmReult)) {
			resultInfos.addAll(idmReult);
		}

		if (resultInfos.size() == 0) {
			result.setCode(NO_FOLLOWP);
			result.setMessage(NO_FOLLOWP_MESSAGE);
		} else {
			result.setCode(HAS_FOLLOWP);
			result.setMessage(HAS_FOLLOWP_MESSAGE);
			result.setValue(resultInfos);
		}
		logger.info("随访提醒接口:调用结束");
		return result;
	}

	/**
	 * 检查参数
	 * 
	 * @param idNum
	 * @param name
	 */
	private void check(String idNum, String name) {
		if (ObjectUtil.isNullOrEmpty(idNum)) {
			logger.error("随访提醒接口:身份证参数为空");
			dealError(DmErrorCode.IDCARD_IS_NULL);
		}
		if (!checkIdacrd(idNum)) {
			logger.error("随访提醒接口:身份证不合法");
			dealError(DmErrorCode.IDCARD_IS_ERROR);
		}

		// if (ObjectUtil.isNullOrEmpty(name)) {
		// logger.error("随访提醒接口:姓名参数为空");
		// dealError("姓名不能为空");
		// }
	}

	/**
	 * 获取慢病提醒
	 * 
	 * @param personInfo
	 * @return
	 */
	private List<ChronicFollowupInfo> queryCdmFollowupInfo(PersonInfo personInfo) {
		List<ChronicFollowupInfo> resultInfos = null;
		try {
			resultInfos = followupRecordService.queryNextFollowupInfo(personInfo);
		} catch (Exception e) {
			logger.error("获取慢病随访信息出错,请求人员id:" + personInfo.getId() + " 身份证:" + personInfo.getIdcard());
		}
		return resultInfos;
	}

	/**
	 * 获取传染病提醒
	 * 
	 * @param personInfo
	 * @return
	 */
	private List<ChronicFollowupInfo> queryIdmFollowupInfo(PersonInfo personInfo) {
		List<ChronicFollowupInfo> result = new ArrayList<>();
		return result;
	}

}
