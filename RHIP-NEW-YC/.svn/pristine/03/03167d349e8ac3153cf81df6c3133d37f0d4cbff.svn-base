package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.util.Date;

/**
 * 肿瘤导出
 * @author liuk
 *
 */
@SuppressWarnings("unused")
public class TumorFollowupExportDef {

	@Item(index = 1, isDic = false, column = "姓名")
	private String name;

	@Item(index = 2, column = "性别", isDic = true, dicType = "GBT226112003")
	private String gender;

	@Item(index = 3, column = "生日", isDate = true, datePattern = "yyyy/MM/dd")
	private String birthday;

	@Item(index = 4, column = "身份证")
	private String idcard;

    @Item(index=5,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
    private String hrtownShip;

    @Item(index=6,isDic=true,dicType="FS990001",column ="户籍地址-村")
    private String hrstreet;

    @Item(index=7,column ="户籍地址详细")
    private String hrhouseNumber;

    @Item(index=8,isDic=true,dicType="FS990001",column ="现住址乡镇")
    private String patownShip;

    @Item(index=9,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
    private String pastreet;

    @Item(index=10,column ="现住址详细")
    private String pahouseNumber;

	@Item(index = 15, column = "随访日期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date visitDate;

	@Item(index = 16, column = "随访方式", isDic = true, dicType = "DMD00026")
	private String visitWayCode;

	@Item(index = 17, column = "治疗方式", isDic = true, isMultiple = true, dicType = "DMD00047")
	private String cureProject;

	@Item(index = 18, column = "肿瘤家族史")
	private String theriomaHistoryDetail;

	@Item(index = 19, column = "肿瘤手术")
	private String opsHospital;

	@Item(index = 110, column = "肿瘤放疗")
	private String radiotherapyHospital;

	@Item(index = 199, column = "肿瘤化疗")
	private String chemotherapyHospital;

	@Item(index = 1100, column = "复发次数")
	private Integer recurTime;

    @Item(index = 1101, column = "转移部位 ")
    private String metastasisPart;

	@Item(index = 1102, column = "目前情况", isDic = true, dicType = "DMD00049")
	private String currentStatusFlag;

	@Item(index = 1103, column = "指导内容", isDic = true, dicType = "DMD00050",isMultiple = true)
	private String guidanceContent;

	@Item(index = 1104, column = "备注")
	private String remark;

	@Item(index = 1105, column = "撤销管理日期期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date cancelDate;

	@Item(index = 1106, column = "死亡日期期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date deathDate;

	@Item(index = 1107, isDic = true,dicType = "DMD00051", column = "死亡原因")
	private String deathReason;

	@Item(index = 1108,  isDic = true,dicType = "DMD00052",column = "死亡地点")
	private String deathPlace;

	@Item(index = 1109, column = "卡氏评分")
	private Integer crtesianValue;

	@Item(index = 1110, column = "随访类型 1.首次 2.正常 3.末次")
	private String followupFlag;

	@Item(index = 1153, column = "填报机构", isOrganization = true)
	private String createOrganCode;

	@Item(index = 1154, column = "填报人", isUser = true)
	private String createDoctorCode;

}
