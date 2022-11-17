package com.founder.rhip;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import org.apache.log4j.Logger;

import java.util.Date;

public class BaseWebService {
	protected Logger logger = Logger.getLogger(BaseWebService.class.getName());


	protected void setEndMessage(WsOperationLog wsOperationLog, String response) {
		if(ObjectUtil.isNullOrEmpty(wsOperationLog.getIsSuccess())) {
			wsOperationLog.setIsSuccess(EHRConstants.FAIL);
		}
		wsOperationLog.setEndTime(new Date());
		wsOperationLog.setResponseMeg(response);
	}
}
