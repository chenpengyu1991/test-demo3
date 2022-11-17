/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import java.util.HashMap;
import java.util.Map;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mhmInterfaceService")
public class MhmInterfaceServiceImpl extends AbstractService implements IMhmInterfaceService {

	@Autowired
	private IPlatformService personService;
	
	private static Map<Integer, String[]> paramMap = new HashMap<Integer, String[]>();

	/**
	 * 获取患者信息
	 * @param       String
	 * @param       String
	 * @return      PersonInfo
	 */
	public PersonInfo queryPersonalInfo(String personName, String idCard) {
		return personService.queryPersonalInfo(personName, idCard);
	}

	/**
	 * 更新患者信息
	 * @param       personInfo
	 * @param       param
	 * @return      String
	 */
	public String updatePersonInfo(PersonInfo personInfo,String...param) {
 		String result = "";
        PersonInfo oldPerson = personService.queryPersonalInfo(personInfo.getId());
        String newIdcard = personInfo.getIdcard();
        
        //如果健康档案已经存在
        if(ObjectUtil.isNotEmpty(oldPerson)){
        	String oldIdcard = oldPerson.getIdcard();
        	//如果已经存在的健康档案身份证为空
        	if(StringUtil.isNullOrEmpty(oldIdcard) ){
        		//新身份证不为空，则删除已经存在的健康档案
        		if(StringUtil.isNotEmpty(newIdcard)){
	        		personService.deleteNoIdCardPerson(personInfo.getId());
	        		oldPerson = personService.queryPersonalInfo(null,newIdcard);
        		}
            }else{//如果已经存在的健康档案身份证不为空
            	//新老健康档案身份证号码不一致
            	if(!oldIdcard.equals(newIdcard)){
            		oldPerson = personService.queryPersonalInfo(null,newIdcard);
            	}
            }
        }

		if(ObjectUtil.isNotEmpty(oldPerson)){
			personInfo.setId(oldPerson.getId());
			personService.updatePersonInfo(personInfo,param);
			personInfo.setSmpiId(oldPerson.getSmpiId());
			result = oldPerson.getSmpiId();
		}else{
            personInfo.setId(null);
			result = personService.createPerson(personInfo, null,false);
		}
		return  result;
	}
}