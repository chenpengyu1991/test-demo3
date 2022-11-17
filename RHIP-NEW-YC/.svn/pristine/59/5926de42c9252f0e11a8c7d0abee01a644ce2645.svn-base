package com.founder.rhip.ncp.controller;

import com.founder.rhip.ehr.service.export.Item;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("unused")
public class NcpPatientExportRef {
	
	@Item(index = 1,column = "临床分型", isDic = true, dicType = "NCP00001" )
	private String clinicalclass;
	
    @Item(index = 2,column = "姓名")
    private String name;

    @Item(index = 3, column = "性别", isDic = true, dicType = "GBT226112003")
    private String gender;

    @Item(index = 4, column = "身份证号")
    private String idcard;

    @Item(index = 5, column = "出生日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String birthday;

    @Item(index = 6, column = "联系电话")
    private String phonenumber;

    @Item(index = 7, column = "管理机构")
    private String managementorg;
    
    @Item(index = 8, column = "出院日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String dischargedate;
    
    @Item(index = 9, column = "管理状态")
    private String filingflag;
    
    @Item(index = 10, column = "签约状态")
    private String signflag;
    
}
