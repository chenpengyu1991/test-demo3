package com.founder.rhip.dm;

import javax.annotation.Resource;

import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 慢病webservice基类
 * 
 * @author liuk
 * 
 */
public abstract class DmBaseWebService extends BaseWebService {

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	/**
	 * 处理异常信息
	 * 
	 * @param message
	 */
	public void dealError(String message) {
		throw new RuntimeException(message);
	}

	/**
	 * 处理异常信息
	 * 
	 * @param code
	 */
	public void dealError(DmErrorCode code) {
		throw new DmException(code);
	}

	/**
	 * 检查机构编码是否在数据库中存在
	 * 
	 * @param orgCode
	 * @return
	 */
	public boolean checkOrganCode(String orgCode) {
		Organization organization = organizationApp.queryOrgan(orgCode);
		return null != organization;
	}

	/**
	 * 根据身份证获取到人员信息
	 * 
	 * @param idNum
	 * @return
	 */
	public PersonInfo queryPerson(String idNum) {
		PersonInfo personInfo = platformService.queryPersonalInfo(null, idNum);
		return personInfo;
	}

	/**
	 * 检查身份证的格式
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean checkIdacrd(String idcard) {
		boolean result = true;
		try {
			result = IDCardUtil.validateCard(idcard);
		} catch (Exception e) {
			logger.error("验证身份证发生错误", e);
			result = false;
		}
		return result;
	}

}
