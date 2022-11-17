package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;
import com.founder.rhip.idm.controller.form.SetupQueryForm;
import com.founder.rhip.idm.service.ISetupService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IDiseaseService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/idm/set")
public class setController extends BaseController {

    @Resource(name="mdmDictionaryService")
    private IDictionaryService mdmDictionaryService;

    @Resource(name = "setupService")
    private ISetupService setupService;
    
    @Resource(name="mdmDiseaseService")
	private IDiseaseService diseaseService;
    

	/**
	 * 进入画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/setup")
	public String setupCase(HttpServletRequest request, ModelMap model) {
//        /*根据当前机构，设置页面中的上报机构*/
//        Organization org = getCurrentOrg(request);
//        String currentOrgCode = org.getOrganCode();
//		model.addAttribute("currentOrgCode", currentOrgCode);
		model.addAttribute("currentYear",new Date());
		return "rhip.idm.set.setup";
	}


    /**
     * 重新组织39种疾病的字典组合
     * @param model
     * @return
     * @throws IOException
     */
 
	@RequestMapping("/queryInfection")
    public String queryInfection(ModelMap model) throws IOException {
        Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
        List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);

        JSONObject jsonObject = getInfectionDic(dicItems);
        return EHRMessageUtil.returnMsg(model, jsonObject.toString());
    }
	
	

	/**
	 * 个案查询本机构分配的疾病列表
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/queryCaseInfection")
    public String queryInfection(ModelMap model, HttpServletRequest request) throws IOException {
	    Criteria ca = new Criteria("caseOrganCode",getCurrentOrg(request).getOrganCode());
	   // ca.add("setYear", OP.EQ, DateUtil.getCurrentYear());2017-6-12修改个案设置跟当前年无关
	    List<IdmSetup> setups = setupService.findSetup(ca);
	    List itemCodes = new ArrayList();
	    for(IdmSetup setup : setups){
	    	itemCodes.add(setup.getInfectiousCode());
	    }
	    Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
	    criteria.add("status", 1);
	    if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request)){
	    	criteria.add("itemCode", OP.IN, itemCodes);
	    }
	   //未设置个案的传染病在查询条件：疾病名称中不显示
	     List<String> notCaseCodes = new ArrayList<String>(Arrays.asList("2035", "2132", "222",
    			"2231", "2232", "2233",
    			"2234", "306", "307", "201",
    			"308", "205",
    			"2035","305","309","225","214","2141","2142","2143","2144",
    			 "001", "002", "003", "004", "005", "006", "007", "008", "009"));
	    criteria.add("itemCode", OP.NOTIN, notCaseCodes);
	    List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);
	    JSONObject jsonObject = getInfectionDic(dicItems);
	    return EHRMessageUtil.returnMsg(model, jsonObject.toString());
    }
    

    /**
     * 保存关联内容
     * @param idmSetup
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(IdmSetup idmSetup, HttpServletRequest request, ModelMap model) throws Exception {
        String actionName = "直报-绑定权限";
        OperationName op = OperationName.ADD;
        boolean result = false;
        if(ObjectUtil.isNotEmpty(idmSetup)){
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);
            idmSetup.setCreateUnitCode(org.getOrganCode());
            Calendar calendar = Calendar.getInstance();
            idmSetup.setCreateDt(calendar.getTime());
            if(setupService.createSetupBath(idmSetup)<=0){
                result = true;
                createOperationLog(request, RhipModuleName.IDM, actionName,op);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 搜索
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/setupList")
    public String setupRecord(SetupQueryForm form, HttpServletRequest request, ModelMap model) {
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.getCriteria();
        Order order=new Order("INFECTIOUS_CODE",true);
        PageList<IdmSetup> plist = setupService.findSetupOrder(ca,page,order);
        model.addAttribute("setups", plist);
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.set.setupList";
    }
    
   
    
    @RequestMapping("/delete")
    public String delete(String id, HttpServletRequest request, ModelMap model) throws Exception {
        String actionName = "直报-删除权限";
        OperationName op = OperationName.DELETE;
        boolean result = false;
        if(!StringUtil.isNotEmpty(id)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
        	setupService.deleteSetup(Long.parseLong(id));
            createOperationLog(request, RhipModuleName.IDM, actionName,op);
            result = true;
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    /**
   	 * 进入疾病上报画面
   	 * @param request
   	 * @param model
   	 * @return
   	 */
   	@RequestMapping("/disease")
   	public String setupDisease(HttpServletRequest request, ModelMap model) {
   		return "rhip.idm.set.setupDisease";
   	}
   /**
    * 搜索已关联的直报传染病
    * @param form
    * @param request
    * @param model
    * @return
    */
   @RequestMapping("/setupDiseaseList")
   public String setupDiseaseList(SetupQueryForm form, HttpServletRequest request, ModelMap model) {
 
       String indexPage = request.getParameter("indexPage");
       int currentPage = Integer.valueOf(indexPage);
       Page page = super.getPage(request, currentPage);
       Criteria criteria = form.getSetupDiseaseCriteria();
	   criteria.add(Dictionary.DIC_CODE, "CV0501017");
	   criteria.add("icdCode", OP.UEMPTY, null);
	   criteria.add("status", 1);
	   PageList<DicItem> dicItems = mdmDictionaryService.getDicItems(page, criteria);
	   List<DicItem> dicItemList = dicItems.getList();
	   int size = dicItemList.size();
	   for(int i=0; i < size; i++){
		   dicItemList.get(i).setIcdCode(dicItemList.get(i).getIcdCode().replaceAll(",", " "));
		   
	   }
	   model.addAttribute("indexPage", indexPage);
       model.addAttribute("setups", dicItems);
       model.addAttribute("page", dicItems.getPage());
       return "rhip.idm.set.setupDiseaseList";
   }
   /**
    * 获取icd疾病JSON格式
    * @param model
    * @return
    * @throws IOException
    */
   @RequestMapping("/queryDiseaseJson")
   public String queryDiseaseJson(ModelMap model) throws IOException {
	  /* List<Disease> diseases = new  ArrayList<Disease>();
       List<Disease> diseasesAB =diseaseService.queryDiseasesByCategoryRangeUseCache("A","C");
       List<Disease> diseasesU =diseaseService.queryDiseasesByCategoryRangeUseCache("U","V");
       List<Disease> diseasesJ =diseaseService.queryDiseasesByCategoryRangeUseCache("J","K"); 
       List<Disease> diseasesN =diseaseService.queryDiseasesByCategoryRangeUseCache("N","O");
       diseases.addAll(diseasesAB);
       diseases.addAll(diseasesU);
       diseases.addAll(diseasesJ);
       diseases.addAll(diseasesN);*/
       List<DicItem> dicItems = mdmDictionaryService.getDicItems(new Criteria(Dictionary.DIC_CODE, "CV0501017").add("icdCode", OP.UEMPTY, null));
      /* JSONObject diseaseJsonObject = getDiseaseJson(diseases);*/
       JSONObject icdJsonObject = getIcdJson(dicItems);
       Map<String, Object> map = new HashMap<String, Object>();
/*       map.put("diseases", diseaseJsonObject);*/
       map.put("icds", icdJsonObject);
       return EHRMessageUtil.returnMsg(model, map);
   }
   /**
    * 获取icd疾病
    * @param model
    * @return
    * @throws IOException
    */
   
   @RequestMapping("/queryDisease")
   @ResponseBody
   public List<Disease> queryDisease(ModelMap model) throws IOException {
	   List<Disease> diseases = new ArrayList<Disease>();
       List<Disease> diseasesAB =diseaseService.queryDiseasesByCategoryRangeUseCache("A","C");
       List<Disease> diseasesG =diseaseService.queryDiseasesByCategoryRangeUseCache("G","H");
       List<Disease> diseasesU =diseaseService.queryDiseasesByCategoryRangeUseCache("U","V");
       List<Disease> diseasesJ =diseaseService.queryDiseasesByCategoryRangeUseCache("J","K");
       List<Disease> diseasesMN =diseaseService.queryDiseasesByCategoryRangeUseCache("M","O");
       diseases.addAll(diseasesAB);
       diseases.addAll(diseasesG);
       diseases.addAll(diseasesU);
       diseases.addAll(diseasesJ);
       diseases.addAll(diseasesMN);
       return diseases;
   }
   
   
   /**
    * 保存上报传染病关联内容
    * @param itemCode
    * @param request
    * @param model
    * @return
    * @throws Exception
    */
   @RequestMapping("/saveBinding")
   public String saveBinding(String itemCode, String icdCode, HttpServletRequest request, ModelMap model) throws Exception {
       String actionName = "直报-疾病icd编码绑定";
       OperationName op = OperationName.ADD;
       String bindedCode = "";
       String bindingCode = "";
       String unExistCode = "";
       Map<String, Object> map = new HashMap<String, Object>();
       String icdCodeStr = dealCodes(icdCode);
       String[] icdCodes = icdCodeStr.split(",");
       int size = icdCodes.length;
       //判断Icd-10编码中是否存在以该code开头的疾病
       for(int k=0; k <size; k++){
    	   if(ObjectUtil.isNotEmpty(icdCodes[k])){
    		   List<Disease> diseases = diseaseService.queryDiseasesUseCache(new Criteria("icd10main", OP.LIKE, icdCodes[k]));
    		   List<DicItem> dicItems = mdmDictionaryService.getDicItems(new Criteria(Dictionary.DIC_CODE, "CV0501017").add("icdCode", OP.LIKE, icdCodes[k]));
        	   if(ObjectUtil.isNullOrEmpty(diseases)){
        		   unExistCode = unExistCode + icdCodes[k] + " ";
        	   }  
    		   for(DicItem dicItem : dicItems){
    			   String[] codes =  dicItem.getIcdCode().split(",");
    			   for(String code : codes){
        			   if(icdCodes[k].equals(code)){
        				   bindedCode = bindedCode +  icdCodes[k] + " ";   //已经绑定的疾病
        			   }
        		   }
    		   }
        		
    	   } 
       }
       
       if(unExistCode.length() > 0){
    	   map.put("result", "fail");
		   map.put("info", "ICD编码为" + unExistCode + "类疾病不存在！"); 
		   return EHRMessageUtil.returnMsg(model, map);
       }
       
       if(bindedCode.length() > 0){
		  map.put("result", "fail");
		  map.put("info", "该ICD编码为" + bindedCode + "的已经绑定过，请先解除绑定！");
		  return EHRMessageUtil.returnMsg(model, map);
       }
       for(int i=0; i <size; i++){
    	   if(!bindedCode.contains(icdCodes[i])){
    		   bindingCode = bindingCode + icdCodes[i] + ",";
    	   }
       }
       if(ObjectUtil.isNotEmpty(itemCode)){
           DicItem dicItem = mdmDictionaryService.getDicItem(new Criteria(Dictionary.DIC_CODE, "CV0501017").add("itemCode", itemCode));
           //更新icdCode
       	   dicItem.setIcdCode(ObjectUtil.isNullOrEmpty(dicItem.getIcdCode())? bindingCode : dicItem.getIcdCode() + bindingCode );
       	   mdmDictionaryService.updateItem(dicItem);
           map.put("result", "success");
           createOperationLog(request, RhipModuleName.IDM, actionName,op);
       }
       return EHRMessageUtil.returnMsg(model, map);
   }
   /**
    *删除传染病与icd疾病关联
    * @param id
    * @param request
    * @param model
    * @return
    * @throws Exception
    */
   
   @RequestMapping("/deleteBinding")
   public String deleteBinding(String id, HttpServletRequest request, ModelMap model) throws Exception {
       String actionName = "直报-疾病icd编码解除绑定";
       OperationName op = OperationName.DELETE;
       boolean result = false;
       if(!StringUtil.isNotEmpty(id)){
           return EHRMessageUtil.returnMsg(model, "fail");
       }else {
           	DicItem dicItem = mdmDictionaryService.getDicItem(new Criteria("itemId", id));
           	dicItem.setIcdCode("");
           	mdmDictionaryService.updateDicItem(dicItem);
            createOperationLog(request, RhipModuleName.IDM, actionName,op);
            result = true;
       }
       return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
   /**
    * 解除单个疾病绑定
    * @param icdCode
    * @param request
    * @param model
    * @return
    * @throws Exception
    */
   @RequestMapping("/unBinding")
   public String unBind(String icdCode, HttpServletRequest request, ModelMap model) throws Exception {
       String actionName = "直报-疾病单个icd编码解除绑定";
       OperationName op = OperationName.DELETE;
       Map<String, Object> map = new HashMap<String, Object>();
       DicItem dicItem = mdmDictionaryService.getDicItem(new Criteria("icdCode", OP.LIKE, icdCode));
       if(ObjectUtil.isNullOrEmpty(dicItem)){
    	   map.put("result", "fail");
 		   map.put("info", "ICD编码为" + icdCode + "未绑定任何传染病，不需要解除绑定！"); 
       }else {
    	    dicItem.setIcdCode(dicItem.getIcdCode().replace(icdCode.trim()+",", ""));
           	mdmDictionaryService.updateDicItem(dicItem);
            createOperationLog(request, RhipModuleName.IDM, actionName,op);
            map.put("result", "success");
       }
       return EHRMessageUtil.returnMsg(model, map);
   }
    
    private JSONObject getDiseaseJson(List<Disease> diseases) {
        int length = diseases.size();
        String currentCode = "";
        String currentName = "";
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < length; i++) {
        	Disease item = diseases.get(i);
            currentCode = item.getIcd10main();
            currentName = item.getDiseaseName();   
            jsonObject.put(currentCode, currentName);
        }
        return jsonObject;
    }
    /**
     * 已绑定的疾病列表
     * @param dicItems
     * @return
     */
    private JSONObject getIcdJson(List<DicItem> dicItems) {
        int length = dicItems.size();
        String icdCode = "";
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < length; i++) {
        	DicItem item = dicItems.get(i);
            icdCode = item.getIcdCode();
            icdCode.trim().replace("，", ",");
            String[] icdCodes = icdCode.split(",");
            int size = icdCodes.length;
            for(int j=0; j <size; j++){
            	if(ObjectUtil.isNotEmpty(icdCodes[j])){
            		jsonObject.put(icdCodes[j], icdCodes[j]);
            	}
            }
        }
        return jsonObject;
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
        String preName;
        String preCode = "";
        
        Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
    	Map<String,String> map = mdmDictionaryService.getDicItemMapUseCache(criteria);
    	
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < length; i++) {
        	preName = "";
            DicItem item = dicItems.get(i);
            currentCode = item.getItemCode();
            currentName = item.getItemName();
            if (item.getItemCode().length() == 1) {
                continue;
            }
            int itemLevel = item.getItemCode().length();
            if (itemLevel == 3) {
                preCode = item.getItemCode();
//                preName = item.getItemName();
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
            } else if (itemLevel > 3 && itemLevel < 5) {
//                if (currentCode.substring(0, 3).equals(preCode)) {
//                    jsonObject.put(currentCode, preName + " " + currentName);
//                }else{
//                	jsonObject.put(currentCode, preName + currentName);
//                }
                
                if(ObjectUtil.isNotEmpty(map) && map.containsKey(item.getParentCode())){
            		preName = map.get(item.getParentCode()) + " ";
            	}
                jsonObject.put(currentCode, preName + currentName);
            }
            //其他 code:"99999"
            else if (item.getItemCode().length() == 5) {
                jsonObject.put(currentCode, currentName);
            }
        }
        return jsonObject;
    }
    
    /**
     * 处理页面的icd字段
     */
    private String dealCodes(String icdCode){
    	 
         //获取的icd编码处理：大写， 去空格，逗号转换为英文逗号；
         String icdCodeStr =  icdCode.toUpperCase();
         icdCodeStr = icdCodeStr.trim();
         icdCodeStr = icdCodeStr.replaceAll("，", ",");
         String[] tempIcdCodes = icdCodeStr.split(",");
         String codesStr = "";
         int tempSize = tempIcdCodes.length;
         //去除 两个逗号之间的空格；去除重复的编码
         for(int k=0; k < tempSize; k++){
      	   if(ObjectUtil.isNotEmpty(tempIcdCodes[k]) && !codesStr.contains(tempIcdCodes[k])){
      		   codesStr = codesStr + tempIcdCodes[k] + ","; 
      	   }
         }
         if(codesStr.contains(",")){
      	   codesStr.subSequence(0, codesStr.length()-2);
         }  
         return codesStr;
    }
}
