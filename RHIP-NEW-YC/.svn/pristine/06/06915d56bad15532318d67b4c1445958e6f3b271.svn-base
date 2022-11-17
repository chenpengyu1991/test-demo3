package com.founder.rhip.oh.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RoleType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.control.oh.OhPoisonReport;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.oh.controller.form.PesticidePoisonReportForm;
import com.founder.rhip.ph.service.oh.IOhPoisonReportService;

@Controller
@RequestMapping("/oh/poisonReport")
public class OhPoisonReportController extends BaseController {

	@Autowired
	private IOhPoisonReportService ohPoisonReportService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		return "rhip.oh.poisonReport.search";
	}
	
	@RequestMapping("/records")
	public String getRecords(HttpServletRequest request,PesticidePoisonReportForm pesticidePoisonReportForm,Integer indexPage){
		Page page = super.getPage(request, indexPage);
		PageList<OhPoisonReport> ohPoisonReportList = ohPoisonReportService.searchOhPoisonReportList(page, initSearchCondition(pesticidePoisonReportForm, request));
		request.setAttribute("page", ohPoisonReportList.getPage());
		request.setAttribute("infoRecords", ohPoisonReportList.getList());
		return "rhip.oh.poisonReport.list";
	}
	
	@RequestMapping("/edit")
	public String add(HttpServletRequest request,String id,String operationType){
		request.setAttribute("operationType", operationType);
		if(StringUtil.isNotEmpty(id)){
			request.setAttribute("record", ohPoisonReportService.searchOhPoisonReport(new Criteria("ID",id)));
		}else{
			OhPoisonReport record = new OhPoisonReport();
			record.setCardType((long) 1);
			record.setReportDate(new Date());
			record.setReporter(this.getCurrentUser(request).getName());
			record.setReporterTel(this.getCurrentUser(request).getMobile());
			request.setAttribute("record", record);
		}
		return "rhip.oh.poisonReport.edit";
	}
	
	@RequestMapping("/save")
	public String saveRecord(HttpServletRequest request,ModelMap model,OhPoisonReport ohPoisonReport,String operationType){
		int i = 0;
		OhPoisonReport report =null;
		if(ohPoisonReport.getCardNo()!=null)
			report = ohPoisonReportService.searchOhPoisonReport(new Criteria("CARD_NO",ohPoisonReport.getCardNo()));
		if(StringUtil.isNotEmpty(operationType)&&operationType.trim().equals("2")){//更新
			if(report!=null&&!report.getId().equals(ohPoisonReport.getId()))
				return EHRMessageUtil.returnMsg(model, "-2");
			verifyStateSet(ohPoisonReport,request);
			ohPoisonReport.setVerifier(this.getCurrentUser(request).getName());
			ohPoisonReport.setVerifyDate(new Date());
			ohPoisonReport.setUpdateTime(new Date());
			ohPoisonReport.setUpdateBy(this.getCurrentUser(request).getName());
            ohPoisonReport.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
			i = ohPoisonReportService.updateOhPoisonReport(ohPoisonReport);
			this.createOperationLog(request, RhipModuleName.OH, "农药中毒报告", OperationName.UPDATE);
		}else{//新增
			if(report!=null)
				return EHRMessageUtil.returnMsg(model, "-2");
			ohPoisonReport.setIsDelete(0);
			ohPoisonReport.setCreateTime(new Date());
			ohPoisonReport.setVerifyState("3");
			ohPoisonReport.setCreateBy(this.getCurrentUser(request).getName());
			ohPoisonReport.setUpdateTime(new Date());
			ohPoisonReport.setUpdateBy(this.getCurrentUser(request).getName());
            ohPoisonReport.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
            ohPoisonReport.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
			List<Role> roles = this.getCurrentUserRole(request);
			for(Role role:roles){
				if(role.getRoleCode().equals(OHConstants.ROLE_23)){
					ohPoisonReport.setVerifyState("1");
					break;
				}
			}
		    i = ohPoisonReportService.addOhPoisonReport(ohPoisonReport);
		    //新增人员健康档案-未建档
            try {
				ohPoisonReportService.createPerson(ohPoisonReport);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    this.createOperationLog(request, RhipModuleName.OH, "农药中毒报告", OperationName.ADD);
		}
		if(i != 1){
			return EHRMessageUtil.returnMsg(model, "-1");
		}else
			return EHRMessageUtil.returnMsg(model, "1");
	}
	
	@RequestMapping("/delete")
	public String deleteRecord(HttpServletRequest request,ModelMap model,String id){
		int i = ohPoisonReportService.deleteOhPoisonReport("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "农药中毒报告", OperationName.DELETE);
		if(i != 1){
			return EHRMessageUtil.returnMsg(model, "-1");
		}else
			return EHRMessageUtil.returnMsg(model, "1");
	}
	
	@RequestMapping("/check")
	public String checkRecord(HttpServletRequest request,ModelMap model,String id,String verifyState){
		int i = ohPoisonReportService.checkOhPoisonReport(this.getCurrentUser(request).getName(),verifyState, new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "农药中毒报告", OperationName.CHECK);
		if(i != 1){
			return EHRMessageUtil.returnMsg(model, "-1");
		}else
			return EHRMessageUtil.returnMsg(model, "1");
	}
	
	private Criteria initSearchCondition(PesticidePoisonReportForm pesticidePoisonReportForm, HttpServletRequest request){
		Criteria criteria = new Criteria();
		if(pesticidePoisonReportForm==null)
			return null;
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getCheckCondition()))
			criteria.add("VERIFY_STATE", pesticidePoisonReportForm.getCheckCondition());
		DateUtil.getCriteriaByDateRange(criteria, "REPORT_DATE", pesticidePoisonReportForm.getStartDate(), pesticidePoisonReportForm.getEndDate());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getIdCard()))	
		    criteria.add("IDCARD",OP.LIKE, pesticidePoisonReportForm.getIdCard());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getName()))
			criteria.add("NAME",OP.LIKE, pesticidePoisonReportForm.getName());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getOutCome()))
			criteria.add("OUTCOME", pesticidePoisonReportForm.getOutCome());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getPoisonDegree()))
			criteria.add("POISON_LEVEL", pesticidePoisonReportForm.getPoisonDegree());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getPoisonPesticideType()))
			criteria.add("DRUG_TYPE", pesticidePoisonReportForm.getPoisonPesticideType());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getPoisonType()))
			criteria.add("POISON_TYPE", pesticidePoisonReportForm.getPoisonType());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getReportCardType()))
			criteria.add("CARD_TYPE", pesticidePoisonReportForm.getReportCardType().toUpperCase());
		if(ObjectUtil.isNotEmpty(pesticidePoisonReportForm.getDrugType()))
			criteria.add("DRUG_TYPE", pesticidePoisonReportForm.getDrugType());

        if(hasRole(RoleType.ZX_GLY, request)){
            criteria.add("CREATE_ORGAN_CODE",getCurrentOrg(request).getOrganCode());
        }
		return criteria;
	}
	
	private void verifyStateSet(OhPoisonReport ohPoisonReport,HttpServletRequest request){
		List<Role> roleList = this.getCurrentUserRole(request);
		for(Role role:roleList){
			if(OHConstants.ROLE_3.equals(role.getRoleCode())||OHConstants.ROLE_19.equals(role.getRoleCode())){
				ohPoisonReport.setVerifyState(OHConstants.VERIFY_STATE_3);
				break;
			}
		}
	}
	
	@RequestMapping("/test")
	public @ResponseBody List<OhPoisonReport> invoke(HttpServletRequest request){
		return ohPoisonReportService.searchOhPoisonReportList(new Page(10,1), new Criteria()).getList();
	}
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@RequestMapping("/subSelect")
	public @ResponseBody String getSubSelect(HttpServletRequest request,String poisonReasonCode,String poisonReasonSubcode){
		List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dic_code",codeConvert(poisonReasonCode)));
		StringBuilder sb = new StringBuilder("<select name=\"poisonReasonSubcode\" id=\"poisonReasonSubcode\">\r\n");
		if(StringUtil.isNullOrEmpty(poisonReasonCode))
		    sb.append("<option value=\"\">请选择</option>\r\n");
		
		for (DicItem item : dicItems) {
			if (StringUtils.isNotEmpty(poisonReasonSubcode)) {
				if (item.getItemCode().equals(poisonReasonSubcode))
					sb.append("<option value=\"" + item.getItemCode()+ "\" selected=\"selected\">" + item.getItemName() + "</option>\r\n");
				else
					sb.append("<option value=\"" + item.getItemCode()+ "\">" + item.getItemName() + "</option>\r\n");
			}else
				sb.append("<option value=\"" + item.getItemCode()+ "\">" + item.getItemName() + "</option>\r\n");
		}
		sb.append("</select>");
		return sb.toString();
		
	}
	private String codeConvert(String poisonReasonCode){
		switch(poisonReasonCode){
		case "1":
			return "OH00008";
		case "2":
			return "OH00009";
		case "3":
			return "OH00010";
		case "4":
			return "OH00011";
		case "5":
			return "OH00012";
		case "6":
			return "OH00013";
		case "7":
			return "OH00014";
		case "8":
			return "OH00015";
		case "9":
			return "OH00016";
		}
		return null;
	}
	
}
