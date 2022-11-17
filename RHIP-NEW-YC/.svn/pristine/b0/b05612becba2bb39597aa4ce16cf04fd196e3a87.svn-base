package com.founder.rhip.mhm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugPrice;
import com.founder.rhip.mhm.controller.form.MhmDrugQueryForm;
import com.founder.rhip.mhm.service.IMhmDrugService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/mhm/drug")
public class DrugController extends MhmBaseController {

	@Resource(name = "mhmDrugService")
	private IMhmDrugService mhmDrugService;

	private final static String CONTROLLER_NAME = "精神卫生-药品维护";	
    /**
     * 药品维护查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request,ModelMap model) {
        return "rhip.mhm.drug.search";
    }

    /**
     * 药品维护查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(MhmDrugQueryForm query,HttpServletRequest request,ModelMap model) {
    	Criteria ca = query.getCriteria();
    	PageList<MhmDrug> plist = mhmDrugService.findDrugList(ca, buildPage(request));
        model.addAttribute("mhmDrugs", plist.getList());
        model.addAttribute("page", plist.getPage());  	
        return "rhip.mhm.drug.list";
    }

    /**
     * 药品维护新增画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Long id,HttpServletRequest request,ModelMap model) {
    	if(ObjectUtil.isNotEmpty(id)){
    		MhmDrug mhmDrug = mhmDrugService.getMhmDrug(new Criteria("ID",id));
    		model.addAttribute("mhmDrug",mhmDrug);  
    	}
        return "rhip.mhm.drug.add";
    }

	/**
	 * 保存药品
	 * @param drug
	 * @param request
	 * @param model
	 */
	@RequestMapping("/save")
	public String saveDrug(MhmDrug drug,HttpServletRequest request,ModelMap model){
		boolean result = false;
		if(ObjectUtil.isNotEmpty(drug)){
			OperationName op = OperationName.ADD;
			if(ObjectUtil.isNotEmpty(drug.getId())){
				op = OperationName.UPDATE;
			}
			updateModify(drug,request);
			result = mhmDrugService.saveDrug(drug);
	    	record(request, op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

    /**
     * 进入药品修改记录画面
     * @param drugId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/popuDrugPrice")
    public String approval(Long drugId,HttpServletRequest request, ModelMap model){
    	model.addAttribute("drugId", drugId);
        return "rhip.mhm.drug.drugPriceSearch";
    }	
    
    /**
     * 查询药品修改记录
     * @param drugId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugPriceList")
    public String approvallist(Long drugId,HttpServletRequest request, ModelMap model){
        Criteria ca = new Criteria("DRUG_ID",drugId);
        PageList<MhmDrugPrice> plist = mhmDrugService.findDrugPriceList(ca,buildPage(request));
        model.addAttribute("mhmDrugPrices",plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.drug.drugPriceList";
    }

    /**
     * 根据药品名称查询药物
     *
     * @param model
     * @param drugName
     * @return
     * @author Ye jianfei
     */
	@RequestMapping("/drugTree")
	@ResponseBody
	public SelectDTO<MhmDrug> getDrugTreeData(HttpServletRequest request,
			ModelMap model
			,@RequestParam(required = false, value = "inputValue") String drugName
			,@RequestParam(required = false, value = "isFree") String isFree
			,@RequestParam(required = false, value = "currentPage") int indexPage) {
		Criteria ca = new Criteria();
		if(StringUtil.isNotEmpty(drugName)){
			ca.add("drug.DRUG_NAME", OP.LIKE,drugName);
		}
		if(StringUtil.isNotEmpty(isFree)){
			ca.add("drug.IS_FREE", isFree);
		}		
		Page page = super.getPage(request, indexPage);
		PageList<MhmDrug> pList = mhmDrugService.findDrugList(ca,page);
		SelectDTO<MhmDrug> result = new SelectDTO<>(pList);
		return result;
	}  

	/**
	 * 根据药品ID查询药品详细信息
	 * @param idCard
	 * @param name
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryDrug")
	public String queryDrug(Long drugId,HttpServletResponse response, ModelMap model) throws IOException {
		MhmDrug mhmDrug = mhmDrugService.getMhmDrug(new Criteria("ID",drugId));
		Map<String, Object> map = new HashMap<String, Object>();
		if (ObjectUtil.isNotEmpty(mhmDrug)) {
			map.put("flag", true);
			map.put("id", mhmDrug.getId());
			map.put("drugName", mhmDrug.getDrugName());
			map.put("drugForm", mhmDrug.getDrugForm());
			map.put("drugUnit",mhmDrug.getDrugUnit());
			map.put("unitMeasure",mhmDrug.getUnitMeasure());
			map.put("amount",mhmDrug.getAmount());
            map.put("drugSpecifications",mhmDrug.getDrugSpecifications());
			map.put("drugPrice",mhmDrug.getDrugPrice());
			map.put("unitPrice",mhmDrug.getUnitPrice());
			map.put("isFree",mhmDrug.getIsFree());
        }else{
        	map.put("flag", false);
			map.put("id", drugId);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}
	/**
	 * 设置药品创建人、更新人等信息
	 *
	 * @param drug
	 * @param request
	 * @author Ye jianfei
	 */
	private void updateModify(MhmDrug drug,HttpServletRequest request){
		if(ObjectUtil.isNullOrEmpty(drug.getId())){
			drug.setFillDate(new Date());
			drug.setFillDoctorId(getCurrentUser(request).getId().toString());
			drug.setFillOrganCode(getCurrentOrg(request).getOrganCode());
		}
		drug.setModifyDate(new Date());
		drug.setModifyDoctorId(getCurrentUser(request).getId().toString());
		drug.setModifyOrganCode(getCurrentOrg(request).getOrganCode());			
	}
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
