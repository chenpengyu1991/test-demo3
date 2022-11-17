/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */


package com.founder.rhip.portal.common;

/**
 * 互动管理状态
 * @version 1.0, 2013-2-26
 */
public enum HospitalCodeForYC {
	
	//银川第一人民医院code
	FIRST_HOSPITAL("45404097-1"),
	
	//银川第二人民医院code
	SECOND_HOSPITAL("45404098-X"),
	
	//银川第三人民医院code
	THIRD_HOSPITAL("45404099-8"),
	
	//银川妇幼保健院医院code
	MATERNAL_CHILD_HOSPITAL("45404094-7"),
	
	//银川口腔医院code
	STOMATOLOGICAL_HOSPITAL("45404101-8"),
	
	//银川中医医院code
	CHINESE_MEDICINE_HOSPITAL("45404096-3");
	
   private String hospitalCode;
   
   HospitalCodeForYC(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

   public String getHospitalCode() {
       return this.hospitalCode;
   }
}
