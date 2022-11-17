package com.founder.rhip.ehr.service.star.impl;

import org.apache.log4j.Logger;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

public class AgeHelper {
	
	private static ThreadLocal<Integer > cache=new ThreadLocal<Integer >();
	
	private static Logger logger=Logger.getLogger(AgeHelper.class);
	
	public static int getAge(PersonalPhyExamDTO dto) {
		Integer age=cache.get();
		if (null==age) {
			age=getAge(dto.getPersonInfo());
			cache.set(age);
			if (logger.isDebugEnabled()) {
				logger.debug("get age, value is"+age);
			}
		}
		return age;
	}
	
	private static int getAge(PersonInfo person) {
		if (null==person) {
			return 0;
		}
		if (null==person.getBirthday()&&null!=person.getIdcard()) {
				return IDCardUtil.getAgeByIdCard(person.getIdcard());
		}
		return DateUtil.getAgeByBirthday(person.getBirthday());
	}
	
	public static void destroy() {
		cache.set(null);
	}
	public static void init(PersonalPhyExamDTO dto) {
		Integer age=getAge(dto.getPersonInfo());
		cache.set(age);
	}
}
