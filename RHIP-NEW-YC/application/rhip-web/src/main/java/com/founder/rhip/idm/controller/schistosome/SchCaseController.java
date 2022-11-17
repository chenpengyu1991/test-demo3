package com.founder.rhip.idm.controller.schistosome;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.idm.SchistosomeQueryDto;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.form.SchQueryForm;
import com.founder.rhip.idm.dto.SchistosomeDto;
import com.founder.rhip.idm.service.IApprovalService;
import com.founder.rhip.idm.service.IHaInterfaceService;
import com.founder.rhip.idm.service.ISchistosomeService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/idm/schistosome/case")
public class SchCaseController extends SchBaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "schistosomeService")
	private ISchistosomeService schistosomeService;
	
	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;

    @Resource(name="approvalService")
    private IApprovalService approvalService;
    
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

	
	/**
	 * 进入个案调查查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String caseSearch(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.schistosome.case.search";
	}
	/**
	 * 个案调查查询列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String caseList(SchQueryForm form, String pageIndex, HttpServletRequest request, ModelMap model) {
        int currentPage = NumberUtil.convert(pageIndex,Integer.class);
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.getCaseCriteria();
        Organization organ = getCurrentOrg(request);
        
        /*事件：血检*/
        List<String> events = new ArrayList<String>();
        events.add(SpecialEvents.S_BlOOD.getValue());
        events.add(SpecialEvents.S_CASE.getValue());
        ca.add("EVENT_ID", OP.IN, events);
        
        if (hasRole(RoleType.JKXXC, request)|| hasRole(RoleType.JKTJZX, request)|| hasRole(RoleType.QWGZX, request)){
			List<String> orgCodes = this.getOrgsByGBCode(organ.getGbCode());
			ca.add("status.CURRENT_UNIT",OP.IN, orgCodes);
		}else if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.ZXTJZX, request)){
			Organization org = getCurrentOrg(request);
			ca.add("status.CURRENT_UNIT",org.getOrganCode());//只能查询本单位的数据
		}
	
        PageList<IdmStatusInfo> plist = schistosomeService.findCaseList(ca, page);
        model.addAttribute("statusInfo", plist.getList());
        model.addAttribute("page", plist.getPage());
			
		return "rhip.idm.schistosome.case.list";
	}
	
	/**
	 * 进入个案调查新增/查看画面
	 * @param request
	 * @param type
	 * @param idmId
	 * @param flag
	 * @param logoff
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editCase(HttpServletRequest request, String type, Long idmId, String flag, Integer logoff, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,null, SpecialEvents.S_CASE,false);
        /*根据当前用户，设置页面中的调查机构*/
        CaseInformation caseInformation = schDto.getCaseInformation();
        if(ObjectUtil.isNullOrEmpty(caseInformation.getId())){
	        Organization org = getCurrentOrg(request);
	        String currentOrgName = org.getOrganName();
	        Long userId = getCurrentUser(request).getId();
	        caseInformation.setRespondents(String.valueOf(userId));
	        caseInformation.setSurveyOrg(org.getOrganCode());	        
	        caseInformation.setSurveyOrgName(currentOrgName);
	        caseInformation.setSurveyDate(new Date());
	        schDto.setCaseInformation(caseInformation);	
        }
        model.put("schDto", schDto);
        model.put("logoff", logoff);        
        model.put("type", type);
		return "rhip.idm.schistosome.case.add";
	}

	/**
	 * 保存个案调查表
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveCase(SchistosomeDto schDto, String type, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(schDto)){
			schDto.setCurrentUser(getCurrentUser(request));
			schDto.setCurrentOrg(getCurrentOrg(request));
			String actionName = "血吸虫专项-个案调查表";
			OperationName op = OperationName.ADD;
			User user = getCurrentUser(request);
			schDto.setCurrentUser(user);
			CaseInformation caseInformation = schDto.getCaseInformation();
	        Organization org = getCurrentOrg(request);
	        schDto.setCurrentOrg(org);
	        String currentOrgCode = org.getOrganCode();
	        String userCode = String.valueOf(getCurrentUser(request).getId());
            /*填写机构和填写日需求变更为：可以前台修改，2014-02-07*/
//	        if (ObjectUtil.isNotEmpty(caseInformation)) {
//                caseInformation.setModifySurveyOrg(currentOrgCode);
//                caseInformation.setModifyRespondents(userCode);
//                caseInformation.setModifySurveyDate(new Date());
//	        }
	        IdmType idmType = IdmType.SCHISTOSOME;
	        if(StringUtil.isNotEmpty(type) && type.equals("new")){
	        	idmType = IdmType.SCHISTOSOME_CASE;
	        }
	        if(ObjectUtil.isNotEmpty(schDto.getCaseInformation().getId())){
	        	op = OperationName.UPDATE;
	        }
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);  	        
            if(ObjectUtil.isNotEmpty(schDto.getPersonInfo().getIdcard())){
                schDto = setForPlantPerson(schDto, request);
            }

            //存地址
            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
                    : schDto.getGeneralCondition().getPahouseNumber());
            schDto.getGeneralCondition().setHrAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getHrstreet()) + schDto.getGeneralCondition().getHrhouseNumber()
                    : schDto.getGeneralCondition().getHrhouseNumber());
          
            updatePersonInfo(schDto, SpecialEvents.S_CASE,request);//设定更新平台患者信息的字段
            result = schistosomeService.saveCase(schDto,user, Long.valueOf(SpecialEvents.S_CASE.getValue()),idmType);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}		
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

    /**
     * 进入审批记录画面
     * @param idmId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/approvallist")
    public String approvallist(Long idmId, HttpServletRequest request, ModelMap model){
        Page page = super.getPage(request,  1);
        Criteria ca = new Criteria("IDM_ID",idmId);
        PageList<IdmApprovalInfo> plist = approvalService.findApprovalInfo(ca,page);
        model.addAttribute("ApprovalInfo",plist);
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.schistosome.approval.list";
    }	
	/**
	 * 进入暂住人口吸虫病监测登记查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewRegister")
	public String viewRegister(HttpServletRequest request, String type, Long idmId, String flag, ModelMap model) {
		SchistosomeDto schDto = new SchistosomeDto();
		String floatPopulation = "";
		if(ObjectUtil.isNotEmpty(idmId)){
			schDto = schistosomeService.getBusiness(idmId,null, SpecialEvents.S_BlOOD,false);
			GeneralCondition gen = schDto.getGeneralCondition();
			if(ObjectUtil.isNotEmpty(gen)){
				floatPopulation = gen.getFloatPopulation();
				/*
				 * 是否流动人口，新增画面显示不同字段
				 * */
				if(floatPopulation.equals("1")){
					flag = "Local";
				}else{
					flag = "Other";
				}
			}
		}
        model.put("schistosomeDto", schDto);
		/*本地居民或暂住人口*/
        model.put("flag", flag);
		return "rhip.idm.schistosome.case.viewregister";
	} 
	
	/**
	 * 
	 *	导出个案调查列表EXCEL
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping("/downExcel")
	@ResponseBody
	public void downExcel(HttpServletRequest request, HttpServletResponse response, SchQueryForm form) throws Exception {
		DicItem rootDicItem = dictionaryApp.queryDicItem("FS990001", EHRConstants.FS990001_ROOT);
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/schCase.xls"));
			Organization org = getCurrentOrg(request);
            String parentCode = org.getParentCode();
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String time=sdf.format(date);
            String townName ="   镇";//镇
            if(org.getGenreCode().equalsIgnoreCase("B1")){
                parentCode = org.getGbCode();
            }				
            Criteria ca = form.getCaseCriteria();
			/*事件：血检*/
			List<String> events = new ArrayList<String>();
			events.add(SpecialEvents.S_BlOOD.getValue());
			events.add(SpecialEvents.S_CASE.getValue());
			ca.add("EVENT_ID", OP.IN, events);
			/*监测核实权限*/
			if (hasRole(RoleType.ZXXXC, request) ){
				ca.add("cas.REPORT_ORG",org.getOrganCode());//只能查询本单位的数据
				townName = dictionaryApp.queryDicItemName("FS990001", parentCode);
			}			
			List<IdmStatusInfo> lists = schistosomeService.findCaseList(ca);
			int totalRows = 5;
			int beginRowIndex = 5;
			int line = 0;
			excel.write("A1", rootDicItem.getItemName() + time + "年血吸虫病防治列表信息");
			/*excel.write("A1", "市 " + townName + "      年血吸虫病防治列表信息");*/
			excel.shiftRows(line + beginRowIndex-1 , totalRows + line,lists.size());//
			for (IdmStatusInfo status : lists) {
				List<Object> objects = getExcelValues(status.getSchDto(),line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex-1);
				line++;
			}
			excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
			setExcelContent(response, rootDicItem.getItemName() + "血吸虫病防治列表信息.xls");
			excel.save(response.getOutputStream());

			lists.clear();
			lists = null;
		} catch (Exception e) {
			log.error("下载《" +rootDicItem.getItemName() + "血吸虫病防治列表信息》出错", e);
			throw e;
		}
	}

    /**
     * 更新平台患者信息的时候三个必备参数
     * @param schDto
     * @param request
     * @return
     * @throws Exception
     */
    private SchistosomeDto setForPlantPerson(SchistosomeDto schDto, HttpServletRequest request) throws Exception {
        if(ObjectUtil.isNotEmpty(schDto.getPersonInfo().getIdcard())){
            schDto.getPersonInfo().setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
            schDto.getPersonInfo().setUpdateName(getCurrentUser(request).getId().toString());
            schDto.getPersonInfo().setUpdateDate(new Date());
        }
        return schDto;
    }

	/**
	 * 生成监测登记EXCEL一行数据
	 *
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getExcelValues(SchistosomeQueryDto dto, int lineNumber) {
		String paAddress = dto.getPaAddress();//现住址详细地址
		String hrAddress = dto.getHrAddress();//户口详细地址

		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(dto.getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", dto.getGender()));
		line.add(dto.getAge());
		line.add(paAddress);
		line.add(hrAddress);
		return line;
	}	
}
