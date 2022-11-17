package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 高血压导出
 *
 * @author liuk
 */
@SuppressWarnings("unused")
public class ManageCardExportRef {
    @Item(index = 1, isDic = false, column = "姓名")
    private String name;

    @Item(index = 2, column = "性别", isDic = true, dicType = "GBT226112003")
    private String gender;

    @Item(index = 3, column = "身份证号")
    private String idcard;

    @Item(index = 4, column = "生日日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String birthday;

    @Item(index = 5, isDic = true, dicType = "GBT3304", column = "民族")
    private String nation;

    @Item(index = 6, isDic = true, dicType = "GBT46582006", column = "文化程度")
    private String education;

    @Item(index = 7, column = "电话")
    private String phoneNumber;

    @Item(index = 8, isDic = true, dicType = "FS990001", column = "现住址乡镇")
    private String patownShip;

    @Item(index = 9, isDic = true, dicType = "FS990001", column = "现住址-村(街、路、弄等)")
    private String pastreet;
    @Item(index = 10, isDic = true, dicType = "FS990001", column = "现住址-组")
    private String paGroup;
    @Item(index = 11, column = "现住址详细")
    private String pahouseNumber;
    
    @Item(index = 12, column = "工作单位")
    private String unitName;

    @Item(index = 13, column = "疾病大类", isDic = true, dicType = "DMD00004")
    private Date disType;

    @Item(index = 14, column = "高血压类型", isDic = true, dicType = "DMD00006")
    private String hbpType;

    @Item(index = 15, isDic = true, column = "糖尿病类型", dicType = "DMD00007", isMultiple = true)
    private String diType;

    @Item(index = 16, column = "冠心病类型", isDic = true, dicType = "DMD00008")
    private String coronaryType;

    @Item(index = 17, column = "脑卒中类型", isDic = true, dicType = "DMD00009")
    private BigDecimal strokeType;

    @Item(index = 18, column = "肿瘤病名")
    private BigDecimal tumorType;

    @Item(index = 19, column = "发病日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String accidentDate;

    @Item(index = 20, column = "诊断日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String diagnosisDate;

    @Item(index = 21, column = "确诊日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String diagnosedDate;

    @Item(index = 22, column = "报告单位", isOrganization = true)
    private String createOrganCode;

    @Item(index = 23, column = "报告日期", isDate = true, datePattern = "yyyy/MM/dd")
    private String createDate;

    @Item(index = 24, column = "报告人", isUser = true)
    private String createDoctorName;
}
