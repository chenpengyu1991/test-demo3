package com.founder.rhip.idm.controller.schistosome;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.SchistosomeDto;
import com.founder.rhip.idm.service.ISchistosomeService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/idm/schistosome/acography")
public class SchAcographyController extends SchBaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "schistosomeService")
	private ISchistosomeService schistosomeService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

	
	/**
	 * 进入治疗记录首页
	 * @param request
	 * @param logoff
	 * @param model
	 * @return
	 */
	@RequestMapping("/initTreatment")
	public String initTreatment(String idmId, Integer logoff, HttpServletRequest request, ModelMap model) {
		
		model.put("idmId", idmId);
		model.put("logoff", logoff);
		return "rhip.idm.schistosome.acography.main";
	}
	
	/**
	 * 查询治疗记录列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String acographylist(String idmId, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);

        PageList<ListRr> plist = schistosomeService.findAcographyList(idmId, page);
        model.addAttribute("acographlist", plist.getList());
        model.addAttribute("page", plist.getPage());   
        model.addAttribute("idmId", idmId); 
		return "rhip.idm.schistosome.acography.list";
	}
	
	/**
	 * 进入治疗记录新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editAcography(HttpServletRequest request, Long idmId, Long singleId, ModelMap model) {
		SchistosomeDto schDto = schistosomeService.getBusiness(idmId,singleId, SpecialEvents.S_ACOGRAPHY,true);
        /*根据当前用户，设置页面中的诊断机构、治疗医生*/
        ListRr listRr = schDto.getListRr();
        if(ObjectUtil.isNullOrEmpty(listRr)){
        	listRr = new ListRr();
        	User user = getCurrentUser(request);
	        Organization org = getCurrentOrg(request);
	        String userCode = getCurrentUser(request).getUserCode();
	        listRr.setDiagnosisUnit(org.getOrganCode());//诊断单位
	        listRr.setTreatmentDoctor(userCode);//治疗医生
			listRr.setCreateUnit(org.getOrganCode());//新增单位
			listRr.setCreateUser(user.getId().toString());//新增人
			listRr.setCreateDt(new Date());//新增时间
	        schDto.setListRr(listRr);	
        }
        model.put("schDto", schDto);
		return "rhip.idm.schistosome.acography.add";
	}	
	/**
	 * 保存治疗记录
	 * @param schDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveAcography(SchistosomeDto schDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(schDto)){
			String actionName = "血吸虫专项-治疗记录";
			OperationName op = OperationName.ADD;
			User user = getCurrentUser(request);
			Organization org = getCurrentOrg(request);
			ListRr listRr = schDto.getListRr();
			listRr.setModifyUnit(org.getOrganCode());//修改单位
			listRr.setModifyUser(user.getId().toString());//修改人
			listRr.setModifyDt(new Date());//修改时间
			schDto.setListRr(listRr);
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

            updatePersonInfo(schDto, SpecialEvents.S_ACOGRAPHY,request);//设定更新平台患者信息的字段
			result = schistosomeService.save(schDto,user, SpecialEvents.S_ACOGRAPHY);
			if(ObjectUtil.isNotEmpty(listRr.getId())){
		        op = OperationName.UPDATE;
			}
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除治疗记录
	 * @param singleId
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String deleteAcography(Long singleId, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(singleId)){
			result = schistosomeService.deleteAcography(singleId);
			createOperationLog(request, RhipModuleName.IDM, "血吸虫专项-治疗记录", OperationName.DELETE);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
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
}
