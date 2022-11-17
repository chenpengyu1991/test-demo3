package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.util.Date;

/**
 * 随访计划导出
 *
 */
@SuppressWarnings("unused")
public class FollowupPlanExportDef {
	@Item(index = 1, isDic = false, column = "姓名")
	private String name;

	@Item(index = 2, column = "性别", isDic = true, dicType = "GBT226112003")
	private String gender;

	@Item(index = 3, column = "生日", isDate = true, datePattern = "yyyy/MM/dd")
	private String birthday;

	@Item(index = 4, column = "身份证")
	private String idcard;
	
	@Item(index = 5, column = "电话号码")
	private String phoneNumber;
	
	@Item(index = 6, column = "患病类型", isDic = true, dicType = "DMD00004")
	private String diseaseType;

	@Item(index = 7, column = "随访日期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date followupDate;
	
	@Item(index = 8, column = "剩余待随访天数")
	private String days;

}
