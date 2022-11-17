package com.founder.rhip.idm.controller.schistosome;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.idm.SchistosomeQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.idm.common.SchStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.form.JcReportForm;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/idm/schistosome")
public class SchistosomeController extends SchBaseController {
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
	 * 进入血吸虫病首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.schistosome.index";
	}
	
	/**
	 * 进入监测登记查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/search")
	public String registerSearch(HttpServletRequest request, ModelMap model) {
		/*监测登记权限
		 * 乡镇卫生院体检中心：防保科审核->疾控血防科审核
		 * 防保科：疾控血防科审核
		 * 疾控体检中心：疾控血防科审核
		 * */
		if (hasRole(RoleType.ZXTJZX, request) || hasRole(RoleType.ZXXXC, request)
				|| hasRole(RoleType.JKTJZX, request)
				|| hasRole(RoleType.JKXXC, request) ){
			model.put("addFlag", 1);
		}	
		if (hasRole(RoleType.ZXXXC, request) ){
			model.put("ZXXXC", 1);
		}
		if (hasRole(RoleType.JKXXC, request)){
			model.put("JKXXC", 1);
		}
		return "rhip.idm.schistosome.register.search";
	}
	/**
	 * 监测登记查询列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/list")
	public String registerList(SchQueryForm form, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Organization organ = getCurrentOrg(request);
        Criteria ca = form.getRegisterCriteria();
        /*事件：血检*/
        List<String> events = new ArrayList<String>();
        events.add(SpecialEvents.S_BlOOD.getValue());
        ca.add("EVENT_ID", OP.IN, events);
        
        /*监测核实权限*/
        if (hasRole(RoleType.JKXXC, request)|| hasRole(RoleType.JKTJZX, request)|| hasRole(RoleType.QWGZX, request)){
//			List<String> orgCodes = this.getOrgsByGBCode(organ.getGbCode());
//			ca.add("cas.REPORT_ORG",OP.IN, orgCodes);
		}else if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.ZXTJZX, request)){
			Organization org = getCurrentOrg(request);
			ca.add("cas.REPORT_ORG",org.getOrganCode());//只能查询本单位的数据
		}
        
		/*监测核实权限*/
		if (hasRole(RoleType.ZXXXC, request) ){
			model.put("ZXXXC", 1);
		}else if (hasRole(RoleType.JKXXC, request) ){	
			model.put("JKXXC", 1);
		}
		
        PageList<IdmStatusInfo> plist = schistosomeService.findRegisterList(ca, page);
        model.addAttribute("statusInfo", plist.getList());
        model.addAttribute("page", plist.getPage());
	
		return "rhip.idm.schistosome.register.list";
	}


	/**
	 * 进入检测月报查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/report/search")
	public String reportSearch(HttpServletRequest request, ModelMap model) {

		return "rhip.idm.schistosome.report.search";
	}

	/**
	 * 检测月报列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/report/jcList")
	public String jcList(JcReportForm form, String pageIndex, HttpServletRequest request, ModelMap model) {
		Criteria criteria = new Criteria();
		Criteria ca = form.getJcCriteria(criteria);
		Organization org = getCurrentOrg(request);
		
		if (hasRole(RoleType.JKXXC, request)|| hasRole(RoleType.JKTJZX, request)|| hasRole(RoleType.QWGZX, request)){
			List<String> orgCodes = this.getOrgsByGBCode(org.getGbCode());
			criteria.add("orgCode",OP.IN, orgCodes);
		}else if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.ZXTJZX, request)){
			criteria.add("orgCode",org.getOrganCode().toString());
		}
		
		List<Map<String, Object>> list = schistosomeService.findJcReport(ca);
		List<Map<String, Object>> list2 = schistosomeService.findJcReportCount(ca);
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		String time;
		if(criteria.get("month")!=null){
			time = criteria.get("month").toString();
		}else{
			time=sdf.format(date);
		}
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("time",time);
		return "rhip.idm.schistosome.report.jcList";
	}


	/**
	 * 检测月报列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/report/jcReport")
		public void downJcReport(HttpServletRequest request, ModelMap model,HttpServletResponse response,JcReportForm form) throws Exception {
		try {

			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/jcReport.xls"));
			//Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
			Criteria criteria = new Criteria();
			Criteria ca = form.getJcCriteria(criteria);
			Organization org = getCurrentOrg(request);
			
			if (hasRole(RoleType.JKXXC, request)|| hasRole(RoleType.JKTJZX, request)|| hasRole(RoleType.QWGZX, request)){
				List<String> orgCodes = this.getOrgsByGBCode(org.getGbCode());
				criteria.add("orgCode",OP.IN, orgCodes);
			}else if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.ZXTJZX, request)){
				criteria.add("orgCode",org.getOrganCode().toString());
			}
			
			List<Map<String, Object>> lists = schistosomeService.findJcReport(ca);
			List<Map<String, Object>> lists2 = schistosomeService.findJcReportCount(ca);
			int totalRows = 7;
			int beginRowIndex = 6;
			int line = 0;
			excel.shiftRows(line + beginRowIndex, totalRows + line,lists.size());
			for (Map<String, Object> list : lists) {
				List<Object> objects = getJcExcelValues(list, line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex);
				line++;
			}
			excel.shiftRows(line + beginRowIndex, totalRows + line,lists2.size());
			for (Map<String, Object> list : lists2) {
				List<Object> objects = getJcExcelValues2(list, line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex);
				line++;
			}
			excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
			setExcelContent(response, "永城市血吸虫病监测月报.xls");
			excel.save(response.getOutputStream());

			lists.clear();
//			transferList = null;*/
		} catch (Exception e) {
			log.error("下载《永城市血吸虫病监测月报》出错", e);
			throw e;
		}
	}

	/**
	 * 生成转诊EXCEL一行数据
	 *
	 * @param
	 * @return
	 */
	private List<Object> getJcExcelValues(Map<String, Object> list, int lineNumber) {
		List<Object> line = new ArrayList<Object>();
		if(list.get("PATOWN_SHIP")!=null){
			line.add(dictionaryApp.queryDicItemName("FS990001", list.get("PATOWN_SHIP").toString()));
		}else{
			line.add(" ");
		}
		if(list.get("PASTREET")!=null){
			line.add(dictionaryApp.queryDicItemName("FS990001", list.get("PASTREET").toString()));
		}else{
			line.add(" ");
		}

		line.add(list.get("ddia_ALL"));
		line.add(list.get("ddia_ALL"));
		line.add(list.get("COPT_DT"));
		line.add(list.get("STOOL_DT"));
		line.add(list.get("DDIA"));
		line.add(list.get("COPT1"));
		line.add(list.get("COPT2"));
		line.add(list.get("STOOL"));


		return line;
	}
	private List<Object> getJcExcelValues2(Map<String, Object> list, int lineNumber) {
		List<Object> line = new ArrayList<Object>();

		line.add("合计");
		line.add("");
		line.add(list.get("ddia_ALL"));
		line.add(list.get("ddia_ALL"));
		line.add(list.get("COPT_DT"));
		line.add(list.get("STOOL_DT"));
		line.add(list.get("DDIA"));
		line.add(list.get("COPT1"));
		line.add(list.get("COPT2"));
		line.add(list.get("STOOL"));


		return line;
	}

	/**
	 * 进入暂住人口吸虫病监测登记新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/add")
	public String addRegister(HttpServletRequest request, String type, String singleId, String flag, ModelMap model) {
		SchistosomeDto schistosomeDto = new SchistosomeDto();
		String floatPopulation = "";
		if(StringUtil.isNotEmpty(singleId)){
			schistosomeDto = schistosomeService.getRegister(singleId);
			GeneralCondition gen = schistosomeDto.getGeneralCondition();
			if(ObjectUtil.isNotEmpty(gen)){
				floatPopulation = gen.getFloatPopulation();
				/*
				 * 是否流动人口，新增画面显示不同字段
				 * */
				if(floatPopulation.equals("2")){
					flag = "Other";
				}else{
					flag = "Local";
				}
			}
		}else{
	        CaseInformation caseInformation = new CaseInformation();
	        Organization org = getCurrentOrg(request);

	        Long userId = getCurrentUser(request).getId();
	        caseInformation.setReportPerson(String.valueOf(userId));
	        caseInformation.setReportOrg(org.getOrganCode());
	        caseInformation.setReportDate(new Date());
	        schistosomeDto.setCaseInformation(caseInformation);			
		}
        model.put("schistosomeDto", schistosomeDto);
		/*新增或更新*/
		model.put("type", type);
		/*本地居民或暂住人口*/
        model.put("flag", flag);
		return "rhip.idm.schistosome.register.add";
	}
	/**
	 * 进入审批画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/edit")
	public String editRegister(Long singleId, String type, HttpServletRequest request, ModelMap model){
		SchistosomeDto schistosomeDto = schistosomeService.getRegister(singleId.toString());
		String flag = "";
		GeneralCondition gen = schistosomeDto.getGeneralCondition();
		if(ObjectUtil.isNotEmpty(gen)){
			flag = gen.getFloatPopulation();
			/*
			 * 是否流动人口，新增画面显示不同字段
			 * */
			if(flag.equals("2")){
				flag = "Other";
			}else{
				flag = "Local";
			}
		}
		Integer nextStatus = getNextStatus(request,schistosomeDto.getSpecialStatus());
		/*血检核实权限*/
		if (ObjectUtil.isNotEmpty(nextStatus)){
			model.put("approveFlag", 1);
		}	
	
		model.addAttribute("schistosomeDto", schistosomeDto);
        /*新增或更新*/
		model.put("type", type);
		/*本地居民或暂住人口*/
        model.put("flag", flag);      
		return "rhip.idm.schistosome.register.add";
	}	
	/**
	 * 保存监测登记表
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/register/save")
	public String saveregister(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(schDto)){
			schDto.setCurrentUser(getCurrentUser(request));
			schDto.setCurrentOrg(getCurrentOrg(request));
			schDto.setEventId(SpecialEvents.S_BlOOD.getValue());
			String actionName = "血吸虫专项-监测登记表";
			OperationName op = OperationName.ADD;
			User user = getCurrentUser(request);
			/*设置状态信息
			 * IDM_TYPE：4，固定值
			 * SPECIAL_STATUS：1
			 * */
			GeneralCondition gen = schDto.getGeneralCondition();
			String idcard = gen.getIdcard();
			PersonInfo person = haInterfaceService.queryPersonalInfo(null, idcard);
            //平台存在该人
            if(null != person){
                gen.setHrtownShip(person.getHrtownShip());
                gen.setHrstreet(person.getHrstreet());
                gen.setHrhouseNumber(person.getHrhouseNumber());
            }
            
			schDto.setGeneralCondition(gen);
			schDto.setSpecialStatus(getCurrentStatus(request));
			if(ObjectUtil.isNotEmpty(schDto.getGeneralCondition().getId())){
				op = OperationName.UPDATE;
			}
            if(ObjectUtil.isNotEmpty(schDto.getPersonInfo().getIdcard())){
                schDto = setForPlantPerson(schDto, request);
            }
            String ddia = schDto.getLabExamine().getDdia();
			if("2".equals(ddia)){//如果DDIA值为阴性，则直接排除
				schDto.setSpecialStatus(SchStatus.ELIMINATION.getValue());
			}
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long idmId = null;
        	if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
            	idmId = Long.parseLong(schDto.getIdmId());
            }             
        	Long personId = schistosomeService.getPersonId(idmId);
        	schDto.setPersonId(personId);    			
            //存地址
            schDto.getGeneralCondition().setPaAddress(dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber());
            if("2".equals(schDto.getGeneralCondition().getFloatPopulation())){
            	updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_REEXAMINE,request);//设定更新平台患者信息的字段
            }else{
            	updatePersonInfo(schDto, SpecialEvents.S_BlOOD,request);//设定更新平台患者信息的字段
            }
        
			result = schistosomeService.saveRegister(schDto,user, Long.valueOf(SpecialEvents.S_BlOOD.getValue()),null);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 审批报卡
	 * @param schDto
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/register/approval")
	public String approval(SchistosomeDto schDto, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(schDto)){
			schDto.setCurrentUser(getCurrentUser(request));
			schDto.setCurrentOrg(getCurrentOrg(request));
			schDto.setEventId(SpecialEvents.S_BlOOD.getValue());
			String actionName = "血吸虫专项-监测登记表";
			OperationName op = OperationName.UPDATE;
			Integer currentStatus =schDto.getSpecialStatus();
			String ddia = schDto.getLabExamine().getDdia();
			if("2".equals(ddia)){//如果DDIA值为阴性，则直接排除
				currentStatus = SchStatus.ELIMINATION.getValue();
			}
			User user = getCurrentUser(request);
			/*如果是作废，则不用获取状态*/
			if (!currentStatus.equals(SchStatus.ELIMINATION.getValue())){
				Integer status = getNextStatus(request,currentStatus);
				schDto.setSpecialStatus(status);
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
            schDto.getGeneralCondition().setPaAddress(dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", schDto.getGeneralCondition().getPastreet()) + schDto.getGeneralCondition().getPahouseNumber());
            if("2".equals(schDto.getGeneralCondition().getFloatPopulation())){
            	updatePersonInfo(schDto, SpecialEvents.S_ADVANCED_REEXAMINE,request);//设定更新平台患者信息的字段
            }else{
            	updatePersonInfo(schDto, SpecialEvents.S_BlOOD,request);//设定更新平台患者信息的字段
            }
            result = schistosomeService.saveRegister(schDto,user, Long.valueOf(SpecialEvents.S_BlOOD.getValue()),null);
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
    @RequestMapping("/approval")
    public String approval(Long idmId, HttpServletRequest request, ModelMap model){
    	model.addAttribute("idmId", idmId);
        return "rhip.idm.schistosome.approval.search";
    }	
    
    /**
     * 查询审批记录
     * @param idmId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/approvallist")
    public String approvallist(Long idmId, HttpServletRequest request, ModelMap model){
    	String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("IDM_ID",idmId);
        PageList<IdmApprovalInfo> plist = approvalService.findApprovalInfo(ca,page);
        model.addAttribute("ApprovalInfo",plist);
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.schistosome.approval.list";
    }	
    
	/**
	 * 根据血检类型查询血检结果集
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/bloodOption/json")
	public void bloodOptionJson(String optionId, HttpServletResponse response, ModelMap model) throws IOException {
		StringBuffer optionHtml = new StringBuffer();
		List<DicItem> dicItems = null;
		Criteria ca =new Criteria("dicCode","PH00004").add("itemCode", OP.IN,new String[]{"1","2"});
		if(StringUtil.isNotEmpty(optionId)){
			switch(optionId){
				case "1":
					dicItems = dictionaryApp.queryDicItem("IDM00320");//检验结果-IHA
					break;
				case "2":
					dicItems = dictionaryApp.queryDicItem(ca);
					break;
				case "3":
					dicItems = dictionaryApp.queryDicItem("IDM00321");//检验结果-COPT
					break;
				case "4":
					dicItems = dictionaryApp.queryDicItem(ca);
					break;					
			}
			
			if (ObjectUtil.isNotEmpty(dicItems)) {
				optionHtml.append("<option value=''>" + "请选择" + "</option>");
				for(DicItem item :dicItems){
					optionHtml.append("<option value='"+ item.getItemCode() +  "'>" + item.getItemName() + "</option>");
				}
			}			
		}
		String result = optionHtml.toString();
		if(StringUtil.isNullOrEmpty(result)){
			result = "empty";
		}
		MessageUtils.outputJSONResult(result, response);
	}  
	
	/**
	 * 
	 *	导出监测登记EXCEL
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping("/downSchRegisterExcel")
	@ResponseBody
	public void downSchRegisterExcel(HttpServletRequest request, HttpServletResponse response, SchQueryForm form) throws Exception {
		DicItem rootDicItem = dictionaryApp.queryDicItem("FS990001", EHRConstants.FS990001_ROOT);
		try {
			Organization org = getCurrentOrg(request);
            String parentCode = org.getParentCode();
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String time=sdf.format(date);
            String townName ="   镇";//镇
            String centreName = "___________________";
            if(org.getGenreCode().equalsIgnoreCase("B1")){
                parentCode = org.getGbCode();
            }

			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/schRegister.xls"));
			Criteria ca = form.getRegisterCriteria();
	        /*事件：血检*/
	        List<String> events = new ArrayList<String>();
	        events.add(SpecialEvents.S_BlOOD.getValue());
	        ca.add("EVENT_ID", OP.IN, events);
			/*监测核实权限*/
			if (hasRole(RoleType.ZXXXC, request) || hasRole(RoleType.JKTJZX, request) ||hasRole(RoleType.ZXTJZX, request)){
				ca.add("cas.REPORT_ORG",org.getOrganCode());//只能查询本单位的数据
				townName = dictionaryApp.queryDicItemName("FS990001", parentCode);
				centreName = org.getOrganName();
			}
			excel.write("A1", rootDicItem.getItemName() + time+"年血吸虫病监测登记表");
			/*excel.write("A1", "市 " + townName + "      年血吸虫病监测登记表");*/
		//	excel.write("A8","检验单位：" + centreName + "                    检验者：________________");
			List<SchistosomeQueryDto> lists = schistosomeService.findRegisterList(ca);
			int totalRows = 8;
			int beginRowIndex = 6;
			int line = 0;
			excel.shiftRows(line + beginRowIndex-1 , totalRows + line,lists.size());//
			for (SchistosomeQueryDto dto : lists) {
				List<Object> objects = getExcelValues(dto,line + 1);
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
			log.error("下载《" + rootDicItem.getItemName() + "血吸虫病防治列表信息》出错", e);
			throw e;
		}
	}
	
	/**
	 * 生成监测登记EXCEL一行数据
	 *
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getExcelValues(SchistosomeQueryDto dto, int lineNumber) {
		String paAddress = dto.getPaAddress();//详细地址
		String ihaCheck = dictionaryApp.queryDicItemName("IDM00320", dto.getIhaCheck());
		String ddia = dictionaryApp.queryDicItemName("PH00004", dto.getDdia());
		String copt = dictionaryApp.queryDicItemName("IDM00321", dto.getCopt());
		String stool = dictionaryApp.queryDicItemName("PH00004", dto.getStool());

		String sampleResource1="";
		String sampleResource2="";
		String sampleResource3="";
		String sampleResource = dto.getSampleResource();
		if(StringUtil.isNotEmpty(sampleResource)){
			switch(dto.getSampleResource()){
				case "1":
					sampleResource1 = "√";
					break;
				case "2":
					sampleResource2 = "√";
					break;
				case "3":
					sampleResource3 = "√";
					break;
			}	
		}
		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(dto.getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", dto.getGender()));
		line.add(dto.getAge());
		line.add(paAddress);
		line.add(sampleResource1);
		line.add(sampleResource2);
//		line.add(sampleResource3);

		line.add(ihaCheck);
		line.add(DateUtil.getDateTime("yyyy/MM/dd", dto.getIhaDt()));
		line.add(ddia);
		line.add(DateUtil.getDateTime("yyyy/MM/dd", dto.getDdiaDt()));
		line.add(copt);
		line.add(DateUtil.getDateTime("yyyy/MM/dd", dto.getCoptDt()));
		line.add(stool);
		line.add(DateUtil.getDateTime("yyyy/MM/dd", dto.getStoolDt()));
		return line;
	}
	
	/**
	 * 分配
	 * @param request
	 * @param model
	 * @param ids
	 * @return String
	 */
	@RequestMapping("/register/batchApproval")
	public String distribution(HttpServletRequest request, ModelMap model, String ids){
		boolean result = false;
		if(StringUtil.isNotEmpty(ids)){
			String[] singleIds = ids.split(",");
			if(ObjectUtil.isNotEmpty(singleIds)){
				User user = getCurrentUser(request);
				SchStatus status = SchStatus.FBK_VERIFY;
				result = schistosomeService.batchApproval(singleIds,status,user);
			}
		}
		return  EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
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
	 *根据角色和报卡状态获取报卡下一步状态
	 * @param request
	 */
	private Integer getNextStatus(HttpServletRequest request, Integer specialStatus) {
		Integer result = null;
		/*如果是状态为作废,则不变*/
		if(specialStatus.equals(SchStatus.ELIMINATION.getValue())){
			result = specialStatus;
		}
		/*如果角色是疾控中心血防科，且状态为防保科审核*/
		else if(hasRole(RoleType.JKXXC,request) && specialStatus.equals(SchStatus.FBK_VERIFY.getValue())){
			result= SchStatus.JK_VERIFY.getValue();
		} 
		/*如果角色是疾控中心血防科，且状态为待核实(卫生院检验科提交)*/
		else if(hasRole(RoleType.JKXXC,request) && specialStatus.equals(SchStatus.REGISTER_WSYJYK.getValue())){
			result= SchStatus.JK_VERIFY.getValue();
		} 		
		/*如果角色是疾控中心血防科，且状态为待核实(疾控体检中心提交)*/
		else if(hasRole(RoleType.JKXXC,request) && specialStatus.equals(SchStatus.REGISTER_JKTJZX.getValue())){
			result= SchStatus.JK_VERIFY.getValue();
		}
		/*如果角色是疾控中心血防科，且状态为待核实(防保科提交)*/
		else if(hasRole(RoleType.JKXXC,request) && specialStatus.equals(SchStatus.REGISTER_SQZX.getValue())){
			result= SchStatus.JK_VERIFY.getValue();
		}		
		/*如果角色是防保科，且状态为监测登记*/
		else if(hasRole(RoleType.ZXXXC,request) && specialStatus.equals(SchStatus.REGISTER_DOCTOR.getValue())){
			result= SchStatus.FBK_VERIFY.getValue();
		}	
		return result;
	}
	
	/**
	 *根据角色和确定监测登记提交状态
	 * @param request
	 */
	private Integer getCurrentStatus(HttpServletRequest request) {
		Integer result = SchStatus.REGISTER_DOCTOR.getValue();
		/*如果角色是医生*/
		if(hasRole(RoleType.ZXTJZX,request)) {
			result = SchStatus.REGISTER_DOCTOR.getValue();
		}

		/*如果角色是防保科*/
		if(hasRole(RoleType.ZXXXC,request)) {
			result = SchStatus.REGISTER_SQZX.getValue();
		}
		/*如果角色是疾控体检中心*/
		if(hasRole(RoleType.JKTJZX,request)) {
			result = SchStatus.REGISTER_JKTJZX.getValue();
		}
		/*如果角色是疾控血防中心*/
		if(hasRole(RoleType.JKXXC,request)) {
			result = SchStatus.JK_VERIFY.getValue();
		}
		return result;
	}		
}
