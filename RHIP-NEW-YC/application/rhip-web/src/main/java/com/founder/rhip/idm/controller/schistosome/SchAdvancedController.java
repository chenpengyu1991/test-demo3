package com.founder.rhip.idm.controller.schistosome;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.idm.SchistosomeQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.ListCr;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.form.SchQueryForm;
import com.founder.rhip.idm.dto.SchistosomeDto;
import com.founder.rhip.idm.service.IHaInterfaceService;
import com.founder.rhip.idm.service.ISchistosomeService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/idm/schistosome/advanced")
public class SchAdvancedController extends SchBaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "schistosomeService")
	private ISchistosomeService schistosomeService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
  
	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;
	
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

	
	/**
	 * 进入晚血管理首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String index(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.schistosome.advanced.search";
	}

	/**
	 * 进入调查记录首页
	 * @param idmId
	 * @param logoff:人员注销状态
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/initSurvey")
	public String initSurvey(String idmId, Integer logoff, HttpServletRequest request, ModelMap model) {
		model.put("idmId", idmId);
		model.put("logoff", logoff);
		return "rhip.idm.schistosome.advanced.survey.main";
	}
	
	/**
	 * 查询晚血病人列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String advancedlist(SchQueryForm form, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.getAdvancedCriteria();
        /*事件：血检*/
        List<String> events = new ArrayList<String>();
        events.add(SpecialEvents.S_CASE.getValue());
        events.add(SpecialEvents.S_ADVANCED_ADVANCED_IMPORT.getValue());
        ca.add("EVENT_ID", OP.IN, events);
        
        Organization org = getCurrentOrg(request);
		if (hasRole(RoleType.JKXXC, request)|| hasRole(RoleType.JKTJZX, request)|| hasRole(RoleType.QWGZX, request)){
			List<String> orgCodes = this.getOrgsByGBCode(org.getGbCode());
			ca.add("status.CURRENT_UNIT",OP.IN, orgCodes);
		}else if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.ZXTJZX, request)){
			ca.add("status.CURRENT_UNIT",org.getOrganCode());
		}
		
        PageList<IdmStatusInfo> plist = schistosomeService.findAdvancedList(ca, page);
        model.addAttribute("advancedlist", plist.getList());
        model.addAttribute("page", plist.getPage());   
		return "rhip.idm.schistosome.advanced.list";
	}

	/**
	 * 查询调查记录列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/survey/list")
	public String surveylist(String idmId, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        PageList<CaseInformation> plist = schistosomeService.findSurveyList(idmId, page);
        model.addAttribute("surveylist", plist.getList());
        model.addAttribute("page", plist.getPage());   
        model.addAttribute("idmId", idmId); 
		return "rhip.idm.schistosome.advanced.survey.list";
	}
	/**
	 * 进入调查表新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/survey/edit")
	public String editSurvey(HttpServletRequest request, Long idmId, Long singleId, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,singleId, SpecialEvents.S_ADVANCED_SURVEY,true);
        /*根据当前用户，设置页面中的调查者、调查日期*/
		CaseInformation caseInformation = schDto.getCaseInformation();
		Organization org = getCurrentOrg(request);
		Long userId = getCurrentUser(request).getId();
        if(ObjectUtil.isNullOrEmpty(caseInformation)){
        	caseInformation = new CaseInformation();
	        caseInformation.setRespondents(userId.toString());//调查者
	        caseInformation.setSurveyDate(new Date());//调查日期
	        caseInformation.setReportOrg(org.getOrganCode());//调查单位
	        schDto.setCaseInformation(caseInformation);	
        }
        /*修改者、修改日期每次都更新*/
        caseInformation.setModifyRespondents(userId.toString());//调查者
        caseInformation.setModifySurveyDate(new Date());//调查日期
        /*根据当前用户，设置页面中的检查单位、检查日期*/
        LabExamine labExamine = schDto.getLabExamine();
        if(ObjectUtil.isNullOrEmpty(labExamine)){
        	labExamine = new LabExamine();
        	labExamine.setCheckDt(new Date());//检查日期
        	labExamine.setCheckUnit(org.getOrganCode());//检查单位
        	schDto.setLabExamine(labExamine);
        }
        model.put("schDto", schDto);
		return "rhip.idm.schistosome.advanced.survey.add";
	}
	
	/**
	 * 保存调查表
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/survey/save")
	public String saveSurvey(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		String actionName = "血吸虫专项-晚期血吸虫病人调查表";
		OperationName op = OperationName.ADD;
		if(ObjectUtil.isNotEmpty(schDto)){
			CaseInformation caseInformation = schDto.getCaseInformation();
			if(ObjectUtil.isNotEmpty(caseInformation.getId())){
		        op = OperationName.UPDATE;
			}
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);    			
			User user = getCurrentUser(request);
            if(ObjectUtil.isNotEmpty(schDto.getPersonInfo().getIdcard())){
                schDto = setForPlantPerson(schDto, request);
            }

            //存地址
            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
                    : schDto.getGeneralCondition().getPahouseNumber());
        
            updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_SURVEY,request);//设定更新平台患者信息的字段
			result = schistosomeService.save(schDto,user, SpecialEvents.S_ADVANCED_SURVEY);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除调查表
	 * @param singleId
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/survey/delete")
	public String deleteSurvey(Long singleId, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		String actionName = "血吸虫专项-晚期血吸虫病人调查表";
		if(ObjectUtil.isNotEmpty(singleId)){
			result = schistosomeService.deleteSurvey(singleId);
			createOperationLog(request, RhipModuleName.IDM, actionName, OperationName.DELETE);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 进入管理卡新增/查看画面
	 * @param request
	 * @param idmId
	 * @param logoff:人员注销状态
	 * @param model
	 * @return
	 */
	@RequestMapping("/card/edit")
	public String editCard(HttpServletRequest request, Long idmId, Integer logoff, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,null, SpecialEvents.S_ADVANCED_CARD,false);
        /*根据当前用户，设置页面中的调查者、调查日期*/
		CaseInformation caseInformation = schDto.getCaseInformation();
        if(ObjectUtil.isNullOrEmpty(caseInformation)){
        	caseInformation = new CaseInformation();
        	Organization org = getCurrentOrg(request);
	        caseInformation.setSurveyOrg(org.getOrganCode());//建卡单位
	        caseInformation.setSurveyDate(new Date());//建卡时间
	        schDto.setCaseInformation(caseInformation);	
        }
        model.put("schDto", schDto);
		model.put("logoff", logoff);        
		return "rhip.idm.schistosome.advanced.card.add";
	}
	
	/**
	 * 进入信息变更子画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/card/addcr")
    public String editCr(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            @SuppressWarnings("unchecked")
            List<ListCr> listCr = (List<ListCr>) json2Obj(trData, ListCr.class);
            model.put("listCr", listCr.get(0));
            model.put("rowIndex", rowIndex);
        }else{
        	ListCr cr = new ListCr();
        	User user = getCurrentUser(request);
        	cr.setChangeUser(user.getName());
        	cr.setChangeDt(new Date());
        	model.put("listCr", cr);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.schistosome.advanced.card.addcr";
    }

	/**
	 * 进入治疗记录子画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/card/addrr")
    public String editRr(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            @SuppressWarnings("unchecked")
            List<ListRr> listRr = (List<ListRr>) json2Obj(trData, ListRr.class);
            model.put("listRr", listRr.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.schistosome.advanced.card.addrr";
    }
	/**
	 * 保存管理卡
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/card/save")
	public String saveCard(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		String actionName = "血吸虫专项-晚期血吸虫病人信息管理卡";
		OperationName op = OperationName.ADD;
		if(ObjectUtil.isNotEmpty(schDto)){
			getListData(schDto);
			CaseInformation caseInformation = schDto.getCaseInformation();
			if(ObjectUtil.isNotEmpty(caseInformation.getId())){
		        Long userId = getCurrentUser(request).getId();
		        caseInformation.setModifyRespondents(userId.toString());//调查者
		        caseInformation.setModifySurveyDate(new Date());//调查日期
		        schDto.setCaseInformation(caseInformation);	
		        op = OperationName.UPDATE;
			}
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);      			
			User user = getCurrentUser(request);
            if(ObjectUtil.isNotEmpty(schDto.getPersonInfo().getIdcard())){
                schDto = setForPlantPerson(schDto, request);
            }

            //存地址
            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
                    : schDto.getGeneralCondition().getPahouseNumber());
      
            updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_CARD,request);//设定更新平台患者信息的字段
			result = schistosomeService.save(schDto,user, SpecialEvents.S_ADVANCED_CARD);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 进入复查登记页面
	 * @param idmId
	 * @param logoff
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/initReexamine")
	public String initReexamine(String idmId, Integer logoff, HttpServletRequest request, ModelMap model) {
		model.put("idmId", idmId);
		model.put("logoff", logoff);    
		return "rhip.idm.schistosome.advanced.reexamine.main";
	}	
	/**
	 * 查询复查登记列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/reexamine/list")
	public String reexaminelist(String idmId, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);

        PageList<CaseInformation> plist = schistosomeService.findReexamineList(idmId, page);
        model.addAttribute("reexaminelist", plist.getList());
        model.addAttribute("page", plist.getPage());   
        model.addAttribute("idmId", idmId); 
		return "rhip.idm.schistosome.advanced.reexamine.list";
	}
	
	/**
	 * 进入复查登记表新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/reexamine/edit")
	public String editReexamine(HttpServletRequest request, Long idmId, Long singleId, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,singleId, SpecialEvents.S_ADVANCED_REEXAMINE,true);
        /*根据当前用户，设置页面中的复查者、复查登记日期*/
		CaseInformation caseInformation = schDto.getCaseInformation();
        if(ObjectUtil.isNullOrEmpty(caseInformation)){
        	caseInformation = new CaseInformation();
	        Long userId = getCurrentUser(request).getId();
	        caseInformation.setRespondents(userId.toString());//调查者
	        caseInformation.setSurveyDate(new Date());//调查日期
	        caseInformation.setModifyRespondents(userId.toString());//调查者
	        caseInformation.setModifySurveyDate(new Date());//调查日期
	        schDto.setCaseInformation(caseInformation);	
        }
        model.put("schDto", schDto);
		return "rhip.idm.schistosome.advanced.reexamine.add";
	}
	/**
	 * 保存复查登记表
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/reexamine/save")
	public String saveReexamine(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		OperationName op = OperationName.ADD;
		if(ObjectUtil.isNotEmpty(schDto)){
			CaseInformation caseInformation = schDto.getCaseInformation();
			if(ObjectUtil.isNotEmpty(caseInformation.getId())){
		        Long userId = getCurrentUser(request).getId();
		        caseInformation.setModifyRespondents(userId.toString());//登记者
		        caseInformation.setModifySurveyDate(new Date());//登记日期
		        schDto.setCaseInformation(caseInformation);	
		        op = OperationName.UPDATE;
			}
			User user = getCurrentUser(request);

            //存地址
            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
                    : schDto.getGeneralCondition().getPahouseNumber());
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);
			result = schistosomeService.save(schDto,user, SpecialEvents.S_ADVANCED_REEXAMINE);
			createOperationLog(request, RhipModuleName.IDM, "血吸虫专项-晚期血吸虫病人复查登记表",op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除复查登记表
	 * @param singleId
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/reexamine/delete")
	public String deleteReexamine(Long singleId, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(singleId)){
			result = schistosomeService.deleteReexamine(singleId);
			createOperationLog(request, RhipModuleName.IDM, "血吸虫专项-晚期血吸虫病人复查登记表", OperationName.DELETE);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	/**
	 * 进入体检页面
	 * @param idmId
	 * @param logoff
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/initMedical")
	public String initMedical(String idmId, Integer logoff, HttpServletRequest request, ModelMap model) {
		model.put("idmId", idmId);
		model.put("logoff", logoff);    
		return "rhip.idm.schistosome.advanced.medical.main";
	}	
	/**
	 * 查询体检列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/medical/list")
	public String medicallist(String idmId, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);

        PageList<CaseInformation> plist = schistosomeService.findMedicalList(idmId, page);
        model.addAttribute("medicallist", plist.getList());
        model.addAttribute("page", plist.getPage());   
        model.addAttribute("idmId", idmId); 
		return "rhip.idm.schistosome.advanced.medical.list";
	}
	
	/**
	 * 进入体检新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/medical/edit")
	public String editMedical(HttpServletRequest request, Long idmId, Long singleId, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,singleId, SpecialEvents.S_ADVANCED_MEDICAL,true);
        /*根据当前用户，设置页面中的操作者、操作机构*/
		CaseInformation caseInformation = schDto.getCaseInformation();
        if(ObjectUtil.isNullOrEmpty(caseInformation)){
        	caseInformation = new CaseInformation();
        	Organization org = getCurrentOrg(request);
	        Long userId = getCurrentUser(request).getId();
	        caseInformation.setRespondents(userId.toString());//操作者
	        caseInformation.setSurveyOrg(org.getOrganCode());//操作机构
	        schDto.setCaseInformation(caseInformation);	
        }
        model.put("schDto", schDto);
		return "rhip.idm.schistosome.advanced.medical.add";
	}
	/**
	 * 保存体检
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/medical/save")
	public String saveMedical(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		OperationName op = OperationName.ADD;
		if(ObjectUtil.isNotEmpty(schDto)){
			CaseInformation caseInformation = schDto.getCaseInformation();
			if(ObjectUtil.isNotEmpty(caseInformation.getId())){
				Organization org = getCurrentOrg(request);
		        Long userId = getCurrentUser(request).getId();
		        caseInformation.setModifyRespondents(userId.toString());//修改者
		        caseInformation.setModifyDt(new Date());//修改日期
		        caseInformation.setModifySurveyOrg(org.getOrganCode());//修改机构
		        schDto.setCaseInformation(caseInformation);	
		        op = OperationName.UPDATE;
			}
			User user = getCurrentUser(request);
			if(StringUtil.isNotEmpty(schDto.getGeneralCondition().getFloatPopulation())){
	            //存地址
	            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
	                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
	                    : schDto.getGeneralCondition().getPahouseNumber());
			}
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);
        	updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_MEDICAL,request);//设定更新平台患者信息的字段
			result = schistosomeService.save(schDto,user, SpecialEvents.S_ADVANCED_MEDICAL);
			createOperationLog(request, RhipModuleName.IDM, "血吸虫专项-晚期血吸虫病人体检表",op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除体检
	 * @param singleId
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/medical/delete")
	public String deleteMedical(Long singleId, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(singleId)){
			result = schistosomeService.deleteMedical(singleId);
			createOperationLog(request, RhipModuleName.IDM, "血吸虫专项-晚期血吸虫病人体检表", OperationName.DELETE);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	/**
	 * 
	 *	导出晚血病人列表EXCEL
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
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/schAdvanced.xls"));
			Organization org = getCurrentOrg(request);
            String parentCode = org.getParentCode();
            String townName ="   镇";//镇
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String time=sdf.format(date);
            if(org.getGenreCode().equalsIgnoreCase("B1")){
                parentCode = org.getGbCode();
            }			
	        Criteria ca = form.getAdvancedCriteria();
	        /*事件：血检*/
	        List<String> events = new ArrayList<String>();
	        events.add(SpecialEvents.S_CASE.getValue());
	        ca.add("EVENT_ID", OP.IN, events);
			if (hasRole(RoleType.ZXXXC, request) ){
				ca.add("cas.REPORT_ORG",org.getOrganCode());//只能查询本单位的数据
				townName = dictionaryApp.queryDicItemName("FS990001", parentCode);				
			}			
			List<IdmStatusInfo> lists = schistosomeService.findAdvancedList(ca);
			int totalRows = 5;
			int beginRowIndex = 5;
			int line = 0;
			excel.write("A1", rootDicItem.getItemName() + time + "年 晚期血吸虫病人防治列表信息");
			/*excel.write("A1", "市 " + townName + "      年 晚期血吸虫病人防治列表信息");*/
			excel.shiftRows(line + beginRowIndex-1 , totalRows + line,lists.size());//
			for (IdmStatusInfo status : lists) {
				List<Object> objects = getExcelValues(status.getSchDto(),line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex-1);
				line++;
			}
			excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
			setExcelContent(response, rootDicItem.getItemName() + "晚期血吸虫病人防治列表信息.xls");
			excel.save(response.getOutputStream());

			lists.clear();
			lists = null;
		} catch (Exception e) {
			log.error("下载《"+rootDicItem.getItemName() + "晚期血吸虫病人防治列表信息》出错", e);
			throw e;
		}
	}

	/**
	 * 进入导入画面-导入血吸虫病历史数据
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showHistoricalImport")
	public String showImport(ModelMap model, HttpServletRequest request) {
		return "rhip.idm.schistosome.advanced.historicalImport";
	}
	
	@RequestMapping("/downloadHistoricalTemplet")
	public void downloadHistoricalTemplet(HttpServletResponse response,String infectiousCode) throws Exception {
		ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/schAdvancedImport.xls"));
		setExcelContent(response, "血吸虫历史数据导入模板.xls");
		excel.save(response.getOutputStream());
	}	
	/**
	 * 导入血吸虫病历史数据
	 *
	 * @param request
	 * @param file
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/uploadHistorical")
//	@ResponseBody
	public void uploadHistorical(HttpServletRequest request, @RequestParam("qqfile") MultipartFile file, HttpServletResponse response) {ModelMap model = new ModelMap();
		boolean isContinue = true;
		try {
			InputStream in = file.getInputStream();
			try {
				int count = 0;
				ExcelUtils excelUtils = new ExcelUtils(in);
				List<SchistosomeDto> dataList = readImportData(excelUtils);
				if (ObjectUtil.isNullOrEmpty(dataList)) {
					model.addAttribute("success", false);
					model.addAttribute("message", "导入历史数据为空");
//					return model;
					//为了兼容火狐\谷歌\IE8\IE11等浏览器,要求返回json格式,并且success要强转双引号
					response.setContentType("text/html");
					String messageStr= "导入历史数据为空";
					response.getWriter().write("{\"success\":\"false\",\"msg\":\""+messageStr+"\"}");
					isContinue = false;
				}
				List<String> msg = validateData(dataList);
				if (msg != null && msg.size()>0 && isContinue) {
					model.addAttribute("success", false);
					model.addAttribute("message", "导入历史数据失败，" + StringUtil.join(msg));
//					return model;
					//为了兼容火狐\谷歌\IE8\IE11等浏览器,要求返回json格式,并且success要强转双引号
					response.setContentType("text/html");
					String messageStr= "导入历史数据失败" + StringUtil.join(msg);
					response.getWriter().write("{\"success\":\"false\",\"msg\":\""+messageStr+"\"}");
					isContinue = false;
				}
				if(isContinue) {
					initData(request, dataList);
					count = schistosomeService.importHistory(dataList);
					model.addAttribute("message", "总共导入" + dataList.size() + "条历史数据，成功" + count + "条，失败" + (dataList.size() - count) + "条");
					model.addAttribute("success", true);
					//为了兼容火狐\谷歌\IE8\IE11等浏览器,要求返回json格式,并且success要强转双引号
					response.setContentType("text/html");
					String messageStr = "总共导入" + dataList.size() + "条历史数据，成功" + count + "条，失败" + (dataList.size() - count) + "条";
					response.getWriter().write("{\"success\":\"true\",\"msg\":\"" + messageStr + "\"}");
				}
			} finally {
				in.close();
			}
		} catch (Exception e) {
			logger.error("导入历史数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
//			return model;
		}
//		return model;
	}

	private void initData(HttpServletRequest request,List<SchistosomeDto> dataList) throws Exception {
		Organization org = getCurrentOrg(request);
		for(SchistosomeDto schDto:dataList){
			schDto.setCurrentOrg(org);
			if(StringUtil.isNotEmpty(schDto.getGeneralCondition().getFloatPopulation())){
	            //存地址
	            schDto.getGeneralCondition().setPaAddress(schDto.getGeneralCondition().getFloatPopulation().equalsIgnoreCase("1")
	                    ? dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber()
	                    : schDto.getGeneralCondition().getPahouseNumber());	
			}
		
			updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_ADVANCED_IMPORT,request);//设定更新平台患者信息的字段
		}
	}
	/**
	  * 导入血吸虫历史数据-读取数据
	  * @param excelUtils
	  * @return List<SchistosomeDto>
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	  */
	private List<SchistosomeDto> readImportData(ExcelUtils excelUtils) throws IllegalAccessException, InvocationTargetException {
		for (int i = 0; i < 3; i++) {
			excelUtils.readLine();
		}
		List<SchistosomeDto> results = new ArrayList<SchistosomeDto>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				results.add(readImportLine(line));
			}
		}
		return results;
	}

	/**
     * 导入血吸虫历史数据-读取一行数据
     * @param line
     * @return SchistosomeDto
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
     */
	private SchistosomeDto readImportLine(List<Object> line) throws IllegalAccessException, InvocationTargetException {
		SchistosomeDto dto = new SchistosomeDto();
		GeneralCondition gen = new GeneralCondition();//一般情况
		Diagnosis diagnosis = new Diagnosis();//诊断
		String idcard = ExcelUtils.getStringValue(line.get(1));
		PersonInfo personInfo = null;
		if(StringUtil.isNotEmpty(idcard)){
			personInfo = haInterfaceService.queryPersonalInfo("", idcard);
		}
		if(ObjectUtil.isNotEmpty(personInfo)){
			initGeneralCondition(personInfo,gen);
		}else{
			gen.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
			gen.setIdcard(ExcelUtils.getStringValue(line.get(1)));//身份证号码
		}
		gen.setGender(formatGender(ExcelUtils.getStringValue(line.get(2))));//性别
		gen.setAge(ExcelUtils.getStringValue(line.get(3)));
		diagnosis.setDiagnosisDt(ExcelUtils.getDateValue(line.get(4),"yyyy/MM/dd"));//诊断日期
		diagnosis.setTransferTreatmentAccording("3");//诊断分期：固定为：晚血病人
		dto.setGeneralCondition(gen);
		dto.setDiagnosis(diagnosis);
		return dto;
	}
	
	/**
	 * 导入血吸虫历史数据-从健康获取患者基本信息
	 *
	 * @param personInfo
	 * @param gen
	 * @author Ye jianfei
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void initGeneralCondition(PersonInfo personInfo, GeneralCondition gen) throws IllegalAccessException, InvocationTargetException {
	    ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	    BeanUtils.copyProperties(gen, personInfo);
	    gen.setFloatPopulation(personInfo.getHouseholdType());//户籍类型
	    gen.setId(null);
	}
	
	private static String formatGender(String gender) {
		if (StringUtil.isNullOrEmpty(gender)) {
			return null;
		}
		String ret = gender.trim();
		if ("男".equals(ret)) {
			ret = "1";
		}
		if ("女".equals(ret)) {
			ret = "2";
		}
		return ret;
	}

    /**
     * 导入血吸虫历史数据--数据验证
     * @param dataList
     * @return List<String>
     */
	private List<String> validateData(List<SchistosomeDto> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			SchistosomeDto dto = dataList.get(index);
			GeneralCondition gen = dto.getGeneralCondition();
			Diagnosis diagnosis = dto.getDiagnosis();
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", gen.getName(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", gen.getGender(), ret);
			validateIdcard("身份证号码",gen.getIdcard(),ret);
			validateDate("诊断日期",diagnosis.getDiagnosisDt(),ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}

	private static void validateObject(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空");
		}
	}

	private static void validateIdcard(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空");
		}else if(!IDCardUtil.validateCard(val.toString())){
			ret.add(msg+"不合法");
		}
	}

	private static void validateNumber(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNotEmpty(val)) {
			if(!String.valueOf(val).matches("[0-9]+")){
				ret.add(msg+"不合法");
			}
		}
	}
	
	private static void validateDate(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空或不合法");
		}		
	}
	private static void validateDict(IDictionaryApp dictionaryApp, String msg, String dicCode, String key, List<String> ret) {
		if (StringUtil.isNullOrEmpty(key)) {
			return;
		}
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dicCode);
		if (!dictMap.containsKey(key)) {
			ret.add(msg+"不合法");
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
		String paAddress = dto.getPaAddress();//现居住地详细地址
		String hrAddress = dto.getHrAddress();//户口详细地址
		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(dto.getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", dto.getGender()));
		line.add(dto.getAge());
		line.add(hrAddress);
		line.add(paAddress);
		line.add("6".equals(dto.getSpecialStatus())?"已治愈":"管理中");
		return line;
	}
	
    /**
     * 子表数据处理
     *
     * @param schDto
     * @return SchistosomeDto
     */
    @SuppressWarnings("unchecked")
	private SchistosomeDto getListData(SchistosomeDto schDto) throws InstantiationException, IllegalAccessException {
        // 添加变更记录
        String crList = schDto.getListCrJson();
        if (StringUtil.isNotEmpty(crList)) {
            List<ListCr> idmListCr = (List<ListCr>) json2Obj(crList, ListCr.class);
            schDto.setListCrs(idmListCr);
        }
        // 添加变更记录
        String rrList = schDto.getListRrJson();
        if (StringUtil.isNotEmpty(rrList)) {
            List<ListRr> idmListRr = (List<ListRr>) json2Obj(rrList, ListRr.class);
            schDto.setListRrs(idmListRr);
        }       
        return schDto;
    }
}
