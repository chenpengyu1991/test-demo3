package com.founder.rhip.mdm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.ViewSourceTypeEnum;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.mdm.controller.form.ReportRecordQueryForm;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.service.IDictionaryService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/system/log")
public class UserOperationLogController extends BaseController{

	@Resource(name = "userOperationLogService")
	private IUserOperationLogService userOperationLogService;

    @Resource(name = "reportRecordService")
    private IReportRecordService reportRecordService;

    @Resource(name="mdmDictionaryService")
    private IDictionaryService mdmDictionaryService;

    @Autowired
    private IReadHealthRecordDao readHealthRecordDao;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, Model model) {
		model.addAttribute("moList", RhipModuleName.values());
		return "com.founder.mdm.userOperationLog.search";
	}
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model,Integer indexPage,UserOperationLog userOperationLog) {
        Page page = super.getPage(request, indexPage); 
        Criteria criteria=new Criteria();
		 if(!StringUtil.isNullOrEmpty(userOperationLog.getUserName())){
			 criteria.add("userName",OP.LIKE,userOperationLog.getUserName());
		 }
		 if(!StringUtil.isNullOrEmpty(userOperationLog.getModuleName())){
			 criteria.add("moduleName",OP.LIKE,userOperationLog.getModuleName());
		 }
		 DateUtil.getCriteriaByDateRange(criteria, "operationTime", userOperationLog.getBeginTime(), userOperationLog.getEndTime());
        PageList<UserOperationLog> userOperationLogList=userOperationLogService.getList(page,criteria);
		request.setAttribute("userOperationLogList", userOperationLogList.getList());
        request.setAttribute("page",userOperationLogList.getPage());
		return "com.founder.mdm.userOperationLog.list";
	}

    /**
     * 进入外部报卡记录页面
     * @return
     */
    @RequestMapping(value = "/report/search")
    public String reportReordIndex(HttpServletRequest request, Model model) {
    	/*SQZX只显示本机构数据*/
		if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXWJ, request) || hasRole(RoleType.DDCRBYY, request)){
			String orgCode = getCurrentOrg(request).getOrganCode();
			model.addAttribute("createOrganCode", orgCode);
		}
        return "com.founder.mdm.userOperationLog.report.search";
    }

    /**
     * 查询外部报卡记录
     * @param reportRecordQueryForm
     * @param model
     * @return
     */
    @RequestMapping(value = "/report/list")
    public String reportSearch(HttpServletRequest request, ReportRecordQueryForm reportRecordQueryForm, Model model) {
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage); 
        Criteria ca = reportRecordQueryForm.getCriteria();
//        Order order = new Order("create_Date", false);
        String order =  "create_Date desc";
        Integer idmStatus = reportRecordQueryForm.getIdmStatus();
        Integer dmdStatus = reportRecordQueryForm.getDmdStatus();
        Integer type = reportRecordQueryForm.getType();
		/*慢病科显示慢病数据*/
		if (hasRole(RoleType.JKMBK, request)){
			ca.add("type", OP.EQ, EHRConstants.REPORT_CDM);
			if(ObjectUtil.isNotEmpty(dmdStatus)){
				ca.add("status", OP.EQ, dmdStatus);
			}			
		}
		/*防疫科显示传染病数据*/
		if (hasRole(RoleType.JKFYK, request)){
			ca.add("type", OP.EQ, EHRConstants.REPORT_IDM);
			if(ObjectUtil.isNotEmpty(idmStatus)){
				ca.add("status", OP.EQ, idmStatus);
			}
		}	
		/*SQZX只显示本机构数据*/
		if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXWJ, request)){
			String orgCode = getCurrentOrg(request).getOrganCode();
			ca.add("fillOrganCode", OP.EQ, orgCode);
			if(ObjectUtil.isNotEmpty(type)){
				ca.add("type", OP.EQ, type);//上报类型
				if(ObjectUtil.isNotEmpty(idmStatus) && type.equals(EHRConstants.REPORT_IDM)){//慢病
					ca.add("status", OP.EQ, idmStatus);
				}
				if(ObjectUtil.isNotEmpty(dmdStatus) && type.equals(EHRConstants.REPORT_CDM)){//传染病
					ca.add("status", OP.EQ, dmdStatus);
				}			
			}			
		}
		/*ADMIN*/
		if (hasRole(RoleType.ADMIN, request)){
			if(ObjectUtil.isNotEmpty(type)){
				ca.add("type", OP.EQ, type);//上报类型
				if(ObjectUtil.isNotEmpty(idmStatus) && type.equals(EHRConstants.REPORT_IDM)){//慢病
					ca.add("status", OP.EQ, idmStatus);
				}
				if(ObjectUtil.isNotEmpty(dmdStatus) && type.equals(EHRConstants.REPORT_CDM)){//传染病
					ca.add("status", OP.EQ, dmdStatus);
				}			
			}			
		}

        /**需求变更不显示重卡（9），且传染病不显示复诊未上报（3），2012-03-12**/
        PageList<ReportRecord> plist = reportRecordService.findPageReportRecord(ca, page, order);

        for(ReportRecord reportRecord : plist.getList()){
            if(reportRecord.getType()==2){
                reportRecord.setIllnessSecondName(queryInfection(reportRecord.getIllnessSecondCode()));
            }
        }

        model.addAttribute("reportRecordList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "com.founder.mdm.userOperationLog.report.list";
    }

    /**
     * 查看详细
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/report/detail")
    public String reportDetail(Long id,HttpServletRequest request, Model model) {
        ReportRecord reportRecord = reportRecordService.getReportRecord(id);
        if(reportRecord.getType()==2){
            reportRecord.setIllnessSecondName(queryInfection(reportRecord.getIllnessSecondCode()));
        }

        model.addAttribute("reportRecord", reportRecord);

        return "com.founder.mdm.userOperationLog.report.detail";
    }

    /**
     * 弹出报卡删除原因页面
     * @param reportRecordId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/report/popDeleteReportRecord")
    public String popDeleteReportRecord(Long reportRecordId,HttpServletRequest request,ModelMap model){
//        ReportRecord reportRecord = new ReportRecord();
//        reportRecord.setId(reportRecordId);
        model.addAttribute("reportRecordId", reportRecordId);
        return "com.founder.mdm.userOperationLog.report.delete";
    }

    /**
     * 逻辑删除报卡记录
     *
     * @param reportRecord
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
	@RequestMapping("/report/deleteReportRecord")
	public String deleteReportRecord(ReportRecord reportRecord, HttpServletRequest request,ModelMap model){
        boolean result = false;
		if(ObjectUtil.isNotEmpty(reportRecord.getId())){
			result = reportRecordService.deleteReportRecord(reportRecord);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
    /**
     * 根据传染病类型查询传染病
     *
     * @param type
     */
    @RequestMapping("/queryInfection")
    private String queryInfection(String type) {
        Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
        if (StringUtil.isNotEmpty(type)) {
            criteria.add("itemCode", OP.FLIKE, type.substring(0,3));
        }
        List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);

        JSONObject jsonObject = getInfectionDic(dicItems);
        String result = jsonObject.toString().substring(jsonObject.toString().indexOf(type)+type.length()+3,jsonObject.toString().length());
        result = result.substring(0,result.indexOf("\""));
        return result;
    }

    /**
     * 将字段中的树形字段进行组装，只取最末级，名称将上级名称带入
     * @param dicItems
     * @return
     */
    private JSONObject getInfectionDic(List<DicItem> dicItems) {
        int length = dicItems.size();
        String currentCode;
        String currentName;
        String preCode = "";
        String preName = "";
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < length; i++) {
            DicItem item = dicItems.get(i);
            currentCode = item.getItemCode();
            currentName = item.getItemName();
            if (item.getItemCode().length() == 1) {
                continue;
            }
            int itemLevel = item.getItemCode().length();
            if (itemLevel == 3) {
                preCode = item.getItemCode();
                preName = item.getItemName();
                String nextCode;
                if (i < length - 1) {
                    nextCode = dicItems.get(i + 1).getItemCode();
                    if(nextCode.length() <=3){
                        jsonObject.put(currentCode, currentName);
                        continue;
                    }
                    if ( !preCode.equals(nextCode.substring(0, 3))) {
                        jsonObject.put(currentCode, currentName);
                    }
                } else {
                    jsonObject.put(currentCode, currentName);
                }
            } else if (itemLevel > 3) {
                if (currentCode.substring(0, 3).equals(preCode)) {
                    jsonObject.put(currentCode, preName + " " + currentName);
                }
            }
        }
        return jsonObject;
    }

    /**
     * 健康调阅
     * @return
     */
    @RequestMapping(value = "/recordSearch")
    public String recordSearch(HttpServletRequest request, Model model) {
        model.addAttribute("sourceList", ViewSourceTypeEnum.values());
        return "com.founder.mdm.userOperationLog.recordSearch";
    }

    @RequestMapping(value = "/recordList")
    public String recordList(HttpServletRequest request, Model model,Integer indexPage,UserOperationLog userOperationLog) {
        Page page = super.getPage(request, indexPage);
        Criteria criteria=new Criteria();
        if(!StringUtil.isEmpty(userOperationLog.getName())){
            criteria.add("PERSON_NAME",OP.LIKE,userOperationLog.getName());
        }
        if(!StringUtil.isEmpty(userOperationLog.getIdCard())){
            criteria.add("PERSON_IDCARD",OP.EQ,userOperationLog.getIdCard());
        }
        if(!StringUtil.isEmpty(userOperationLog.getSourceName())){
            criteria.add("SOURCE",OP.EQ,userOperationLog.getSourceName());
        }
        if (ObjectUtil.isNotEmpty(userOperationLog.getStationOrganCode())) {
            criteria.add("READER_ORGANCODE",OP.EQ, userOperationLog.getStationOrganCode());
        } else if (ObjectUtil.isNotEmpty(userOperationLog.getCenterOrganCode())) {
            criteria.add("READER_ORGANCODE",OP.EQ, userOperationLog.getCenterOrganCode());
        } else if (ObjectUtil.isNotEmpty(userOperationLog.getGbcode())) {
            criteria.add("READER_ORGANCODE",OP.EQ, userOperationLog.getGbcode());
        }
        Order order = new Order("READ_DATE DESC");
        DateUtil.getCriteriaByDateRange(criteria, "READ_DATE", userOperationLog.getBeginTime(), userOperationLog.getEndTime());
        PageList<ReadHealthRecord> readHealthRecords  = readHealthRecordDao.getPageList(page, criteria, order);
        request.setAttribute("readHealthRecords", readHealthRecords.getList());
        request.setAttribute("page",readHealthRecords.getPage());
        return "com.founder.mdm.userOperationLog.recordList";
    }
}
