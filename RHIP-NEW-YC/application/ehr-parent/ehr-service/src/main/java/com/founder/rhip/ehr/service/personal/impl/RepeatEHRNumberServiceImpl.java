package com.founder.rhip.ehr.service.personal.impl;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.scheduling.core.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;

/**
 * The type Personal record managment service impl.
 */
@Service("repeatEHRNumberService")
//@TaskBean(description = "健康档案编号重复处理")
public class RepeatEHRNumberServiceImpl implements Task {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IDCardUtil.class);

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;

	@Override
	public void run(Map<String, Object> data) {
		handleRepeatEhrNOData(data);
	}

	@Transient
	private void handleRepeatEhrNOData(Map<String, Object> data) {
		List<PersonInfo> personInfoList = null;
		if(data!=null&&data.get("jobDataCustomParamKey")!=null)
			personInfoList = personInfoDao.getRepeatEhrNONullList();
		else
			personInfoList = personInfoDao.getRepeatEhrNOList();
		int i = 0;
		for(PersonInfo personInfo : personInfoList) {
			String newEhrNO = EHRNumberService.getHealthFileNo(personInfo.getPastreet());
			while (newEhrNO.length()>17) {
				newEhrNO = EHRNumberService.getHealthFileNo(personInfo.getPastreet());
			}
			i++;
			personInfo.setHealthFileNo(newEhrNO);
			personInfoDao.update(new Parameters("HEALTH_FILE_NO", newEhrNO), new Criteria("id", personInfo.getId()));
			System.out.println(i);
		}
		logger.info("健康档案编号重复处理的数量：" + personInfoList.size());
	}
}