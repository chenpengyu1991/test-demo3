package com.founder.rhip.hm.controller.form;

import com.founder.rhip.ehr.annotation.Star;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author BaGen
 * @Description:
 * @Date Created in 14:47 2018/1/10.
 */

public class ElderPersonInfoExcel implements Serializable {

    @Item(index=35,column ="档案编号")
    private String healthFileNo;

    @Item(index=2,column ="身份证件号码")
    private String idcard;

    @Item(index=1,column = "姓名")
    private String name;

    @Item(index=21,column ="联系电话")
    private String phoneNumber;

    @Item(index=7,column ="常住类型",isDic=true,dicType="FS10005")
    private String householdType;

    @Item(index=9,column ="户籍地址-县(区)",isDic=true,dicType="FS990001")
    private String hrcounty;

    @Item(index=10,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
    private String hrtownShip;

    @Item(index=11,isDic=true,dicType="FS990001",column ="户籍地址-村")
    private String hrstreet;

    @Item(index=13,column ="户籍地址详细")
    private String hrhouseNumber;

    @Item(index=3,column ="现住址-县(区)",isDic=true,dicType="FS990001")
    private String pacounty;

    @Item(index=4,isDic=true,dicType="FS990001",column ="现住址乡镇")
    private String patownShip;

    @Item(index=5,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
    private String pastreet;

    @Item(index=6,column ="现住址详细")
    private String pahouseNumber;

    @Item(index=22,column ="联系人电话")
    private String guardianPhoneOne;

    @Item(index=32,column ="管理人员")
    private String inputName;

    @Item(index=31,column ="建档机构",isOrganization=true)
    private String inputOrganCode;

//    @Item(index=33,column ="责任医师")
//    private String physiciansCaringName;

    @Item(index=34,column ="建档日期",isDate=true,datePattern="yyyy/MM/dd")
    private Date inputDate;

    @Item(index=36,column ="备注",isDic=true,dicType="FS990026")
    private String remarks;

    @Item(index=35,column ="是否中医指导",isDic = true, dicType = "FS10186" )
    private String healthGuideStatus;

    @Item(index=37,column ="体检日期",isDate=true,datePattern="yyyy/MM/dd")
    private Date examinationDate;
}
