package com.founder.rhip.ncp.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.*;
import com.founder.rhip.cdm.service.ICdmPersonService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.service.INcpPatientService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ncp/healthManageCard")
public class NcpPatientController extends NcpController {
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
    @Resource(name = "cdmPersonService")
    private ICdmPersonService cdmPersonService;
    @Resource(name = "standardizationService")
    private IStandardizationService standardizationService;
    @Resource(name = "ncpPatientService")
    private INcpPatientService ncpPatientService;
	@Autowired
	private IDictionaryApp dictionaryApp;
    @Resource(name = "platformService")
    private IPlatformService platformService;

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;
    @RequestMapping(value = "/healthCard/list")
    public String healthCardListSearch(HttpServletRequest request, ModelMap model, String diseaseType, String isManagedFlag) {
        model.addAttribute("diseaseType" , diseaseType);
        model.addAttribute("isManagedFlag" , isManagedFlag);
        return "rhip.ncp.base.healthManageCard.healthCard";
    }
    @RequestMapping(value = "/healthCardList")
	public String manageCardRecord(/* QueryForm form, */HttpServletRequest request, ModelMap model) {
        Criteria criteria = createSearchCriteria(request);
//		if(StringUtil.isNotEmpty(form.getGbcode()) && StringUtil.isEmpty(form.getCenterOrganCode())){
//			List<String> orgCodes = this.getOrgCodeByGBCode(form.getGbcode());
//			criteria.remove("dmPersonInfo.CREATE_GBCODE");
//			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", OP.IN, orgCodes);
//		}
        PageList<NcpPatient> list = ncpPatientService.getNcpPatientList(buildPage(request), criteria);
        model.addAttribute("ncpPatientList", list.getList());
        return "rhip.ncp.base.healthManageCard.ncpPatientResult";
    }
    private Criteria createSearchCriteria(HttpServletRequest request) {

		Criteria criteria = new Criteria();
		criteria.add("ncp.is_delete","0");
		// 姓名
		if (StringUtils.isNotEmpty(request.getParameter("name"))) {
				criteria.add("b.name", OP.EQ, request.getParameter("name"));
			}
		Date createBeginDate = DateUtil.parseSimpleDate(request.getParameter("managedDateStart"), null);
		Date createEndDate = DateUtil.parseSimpleDate(request.getParameter("managedDateEnd"), null);
		DateUtil.getCriteriaByDateRange(criteria, "ncp.discharge_date", createBeginDate, createEndDate);
		this.createRoleSearch(request,criteria);


		// 年龄段
		int eYear = -1;
		int bYear = -1;
		if (StringUtils.isNotEmpty(request.getParameter("startAge"))) {
			eYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("startAge")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("endAge"))) {
			bYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("endAge")));
		}
		DateUtil.getCriteriaByYearRange(criteria, "b.birthday", bYear, eYear);
		// 性别
		if (StringUtils.isNotEmpty(request.getParameter("gender"))) {
			int genderCode = Integer.parseInt(request.getParameter("gender"));
			if (genderCode != -1)
				criteria.add("b.gender", request.getParameter("gender"));
		}
		// 身份证
		if (StringUtils.isNotEmpty(request.getParameter("idcard")))
			criteria.add("b.idcard", request.getParameter("idcard"));
		
		if (StringUtils.isNotEmpty(request.getParameter("status"))) {
			if( "1".equals(request.getParameter("status"))) {
				criteria.add("b.filing_flag",OP.IN,"1,5");
			}else {
				criteria.add("b.filing_flag",OP.EQ,"9");
			}
		}
		// 档案类型
		if (StringUtils.isNotEmpty(request.getParameter("clinicalClass"))) {
			criteria.add("ncp.clinical_Class", request.getParameter("clinicalClass"));
		}
		// 人群分类
		if (StringUtils.isNotEmpty(request.getParameter("groupClassification"))) {
			criteria.add("groupClassification", request.getParameter("groupClassification"));
		}
		// 是否签约 modify by yejianfei 2019/01/07
		String signFlag = request.getParameter("signFlag");
		if (StringUtil.isNotEmpty(signFlag)) {
			if("0".equals(signFlag)){
				//签约状态字典：FS10399，0：表示未签约
				Criteria signCri = new Criteria();
				signCri.add("b.sign_Flag",signFlag);
				signCri.add(LOP.OR,"b.sign_flag",OP.IS," null");
				criteria.add(signCri);
			}else{
				criteria.add("b.sign_flag", NumberUtil.convert(signFlag,Integer.class));
			}
		}

		//病例分类
		String patientType = request.getParameter("patientType");
		//县内治疗、县外治疗
		String zlType = request.getParameter("zlType");
		if (StringUtil.isNotEmpty(patientType)) {
			criteria.add("ncp.patient_type", patientType);
			if("2".equals(patientType) && StringUtil.isNotEmpty(zlType)){
				criteria.add("ncp.zl_type", zlType);
			}
		}
		return criteria;
	
    }

    /**
     * 新增管理卡获取人和管理卡信息
     *
     * @param idCard
     * @return
     */
    @RequestMapping("/load")
    @ResponseBody
    public Object load(@RequestParam("personInfo.idcard") String idCard, @RequestParam("ncpPatientId") String ncpPatientId, HttpServletRequest request) {

        PersonInfo personInfo = platformService.queryPersonalInfo(null, StringUtil.trimAllWhitespace(idCard));
        if (ObjectUtil.isNullOrEmpty(personInfo)) {
            return null;
        }

        if (ObjectUtil.isNotEmpty(personInfo)) {
            getPersonAddress(personInfo);
        }
        Map<String, Object> record = new Record(personInfo);

		Organization org  = this.getCurrentOrg(request);
		if(OrgGenreCode.CENTRE.getValue().equals(org.getGenreCode())||OrgGenreCode.INSTITUTES.getValue().equals(org.getGenreCode())) {//若是中心能建健康档案在下属机构的新冠档案
			List<String> orgList = getOrgsByOrgCode(org.getOrganCode());
			if(orgList.contains(personInfo.getInputOrganCode()))
				record.put("subOrg",true);//是否下属机构标记
		}
        Date birthday = setBirthday(personInfo);
        if (ObjectUtil.isNotEmpty(birthday)) {
            SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
            record.put("birthdayStr", df.format(birthday));
        }
        if(ObjectUtil.isNotEmpty(personInfo)) {
        	Criteria criteria1 = null;
            Criteria criteria2 = null;
            NcpPatient ncpPatient1=null;
            NcpPatient ncpPatient2=null;
            criteria1=new Criteria("cardno", idCard);
            ncpPatient1 = ncpPatientService.getNcpPatient(criteria1);
            if(ObjectUtil.isNullOrEmpty(ncpPatientId)) {
                if(ObjectUtil.isNotEmpty(ncpPatient1)) {
                	record.put("manageFlag", "1");
                }else {
                	record.put("manageFlag", "0");
                }
            }else {
            	criteria2=new Criteria("id", ncpPatientId);
             	ncpPatient2 = ncpPatientService.getNcpPatient(criteria2);
            	if(ObjectUtil.isNotEmpty(ncpPatient1)) {
            		if(ncpPatient2.getId()!=ncpPatient1.getId()) {
                    	record.put("manageFlag", "2");
            		}else {
                    	record.put("manageFlag", "0");
                    }
            	}else {
            		record.put("manageFlag", "0");
            	}
            }
        }
        
        return record;
    }
    
    @RequestMapping(value = "/excel")
    public void exportManageCard( HttpServletRequest request, ModelMap model, HttpServletResponse response) throws UnsupportedEncodingException {

//        if (ObjectUtil.isNotEmpty(form.getName())) {
//            //中文乱码
//            form.setName(new String(form.getName().getBytes("ISO-8859-1"), "UTF-8"));
//        }

        String title = "新冠肺炎患者管理卡";

        final  Criteria criteria = createSearchCriteria(request);
        final  Page page= buildPage(request);
        try {
            excelExportService.exportListExecl(title, NcpPatientExportRef.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    List<Map<String, Object>> dataSource = ncpPatientService.exportNcpPatientList(page, criteria);
                    return dataSource;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("导出失败", e);
        }
    }
    
    @RequestMapping("/save")
	@ResponseBody
	public Object save(NcpPatient ncpPatient,PersonInfo personInfo, HttpServletRequest request) {
		 Organization organization = getCurrentOrg(request);
		 User user = getCurrentUser(request);
		 int num=ncpPatientService.saveNcpPatientInfo(ncpPatient,user, organization);
		 if(num>0) {
			 return "success";
		 }else {
			 return "error";
		 }
		 
    }
    
    protected void getPersonAddress(PersonInfo personInfo) {
		String paAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPatownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String pacountyName = paDicItem1.getItemName();
				paAddressDetail = pacountyName;
			}
		}

		if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPastreet());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String paStreetName = paDicItem1.getItemName();
				paAddressDetail += " " + paStreetName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getPaGroup())) {
			DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getPaGroup());
			if (ObjectUtil.isNotEmpty(paDicItem2)) {
				String paVillagName = paDicItem2.getItemName();
				paAddressDetail += " " + paVillagName;
			}
		}

		String hrAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getHrtownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrtownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String hrcountyName = paDicItem1.getItemName();
				hrAddressDetail = hrcountyName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrstreet())) {
			DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrstreet());
			if (ObjectUtil.isNotEmpty(hrDicItem1)) {
				String paTownName = hrDicItem1.getItemName();
				hrAddressDetail += " " + paTownName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrGroup())) {
			DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrGroup());
			if (ObjectUtil.isNotEmpty(hrDicItem2)) {
				String paStreetName = hrDicItem2.getItemName();
				hrAddressDetail += " " + paStreetName;
			}
		}
		personInfo.setHrAddressDetail(hrAddressDetail);
		personInfo.setPaAddressDetail(paAddressDetail);
	}
    /**
     * 查看管理卡
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, String isShow, @RequestParam("dialogId")String dialogId,  ModelMap model) {
		model.put("dialogId", dialogId);
        Criteria criteria = new Criteria("id", id);
        model.put("isShow", isShow);
        NcpPatient ncpPatient = ncpPatientService.getNcpPatient(criteria);
        if (ObjectUtil.isNotEmpty(ncpPatient)) {
            PersonInfo personInfo = ncpPatient.getPersonInfo();
            // 当查看管理卡时,如果此人没有生日,则计算出默认值
            setBirthday(personInfo);
            model.put("personInfo", personInfo);
            model.put("ncpPatient", ncpPatient);
        }
        model.put("viewFlag","1");
        return "rhip.ncp.base.healthManageCard.add";
    
    
    }
    
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id, String isShow,  ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Criteria criteria = new Criteria("id", id);
        NcpPatient ncpPatient = ncpPatientService.getNcpPatient(criteria);
        if (ObjectUtil.isNotEmpty(ncpPatient)) {
        	ncpPatient.setIsDelete(1);
        }
        boolean result = true;
		try {
			ncpPatientService.deleteNcpPatient(ncpPatient);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			result = false;
		}
		MessageUtils.outputJSONResult(result? "success" : "fail", response);
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, String isShow,@RequestParam("dialogId")String dialogId,  ModelMap model) {
    	model.put("dialogId", dialogId);
        Criteria criteria = new Criteria("id", id);
        model.put("isShow", isShow);
        NcpPatient ncpPatient = ncpPatientService.getNcpPatient(criteria);
        if (ObjectUtil.isNotEmpty(ncpPatient)) {
            PersonInfo personInfo = ncpPatient.getPersonInfo();
            // 当查看管理卡时,如果此人没有生日,则计算出默认值
            setBirthday(personInfo);
            model.put("personInfo", personInfo);
            model.put("ncpPatient", ncpPatient);
        }
		model.put("edit", true);
        return "rhip.ncp.base.healthManageCard.add";
    }
    
    /**
	 * 如果人员生日为空,则根据身份证设置生日
	 * 
	 * @param personInfo
	 * @return
	 */
	public Date setBirthday(PersonInfo personInfo) {
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNullOrEmpty(birthday)) {
			String idcard = personInfo.getIdcard();
			if (ObjectUtil.isNotEmpty(idcard)) {
				// 如果没有生日,根据身份证算出
				birthday = IDCardUtil.getBirthDateByIdCard(idcard);
				personInfo.setBirthday(birthday);
			}
		}
		return birthday;
	}
    public RoleType getRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.ZXXG, request)) {
			role = RoleType.ZXXG;
		}else if (hasRole(RoleType.JKXG, request)) {
			role = RoleType.JKXG;
		} else if (hasRole(RoleType.ZXG, request)) {
			role = RoleType.ZXG;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else {
			Assert.notNull(role, "没有权限,请更换用户登录");
		}
		return role;
	}
    
    @RequestMapping("/input")
    public String input(ModelMap modelMap, HttpServletRequest request,@RequestParam("dialogId")String dialogId) {
    	modelMap.put("dialogId", dialogId);
    	Organization organization = getCurrentOrg(request);
		User user = getCurrentUser(request);
		NcpPatient ncpPatient=new NcpPatient();
		ncpPatient.setManagementOrg(organization.getOrganCode());
		ncpPatient.setCreateDoctorCode(user.getStaffCode());
		ncpPatient.setCreateDoctorName(user.getName());
		modelMap.addAttribute("ncpPatient", ncpPatient);
        return "rhip.ncp.base.healthManageCard.add";
    }

    
}
