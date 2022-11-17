package com.founder.rhip.idm.controller.schistosome;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.dto.SchistosomeDto;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 疟疾
 * 
 * 
 */
public abstract class SchBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key

	/**
	 * 分页设置
	 * 
	 * @param request
	 * @return
	 */
	public Page buildPage(HttpServletRequest request) {
		String indexPage = request.getParameter(INDEX_PAGE_KEY);
		int currentPage = 1;
		try {
			currentPage = Integer.valueOf(indexPage);
		} catch (Exception e) {
			logger.warn("没有当前页数");
		}
		Page page = super.getPage(request, currentPage);
		request.setAttribute(PAGE_KEY, page);
		return page;
	}


	/**
	 * 当前controller类功能描述
	 * 
	 * @return
	 */
	protected String getActionName() {
		String clazzName = this.getClass().getName();
		return clazzName;
	}

	/**
	 * 记录操作日志
	 * 
	 * @param request
	 * @param op
	 */
	protected void record(HttpServletRequest request, OperationName op) {
		createOperationLog(request, RhipModuleName.MHM, getActionName(), op);
	}
    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static List<?> json2Obj(String jsonArrayStr, @SuppressWarnings("rawtypes") Class clazz) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        @SuppressWarnings("rawtypes")
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            if(ObjectUtil.isNotEmpty(obj)){
                resultList.add(obj);
            }
        }
        return resultList;
    }
    
    protected void updatePersonInfo(SchistosomeDto schDto, SpecialEvents event, HttpServletRequest request) throws Exception {
    	String[] param = null;
    	switch(event){
    		case S_BlOOD://监测登记
    			param = new String[]{"name", "gender",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case S_CASE://个案调查
    			param = new String[]{"name", "gender","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
    					"hrtownShip", "hrstreet", "hrhouseNumber", "hrAddress",    	
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case S_ACOGRAPHY://治疗记录
    			param = new String[]{"name", "gender", "occupation", "marriage", "unitName",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case S_ADVANCED_CARD://管理卡
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;	
    		case S_ADVANCED_SURVEY://晚期血吸虫病人调查表
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case S_ADVANCED_MEDICAL://体检表
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;    			
    		default:
    			param = new String[]{"name", "gender",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};	    			
    	}
    	schDto.setPersonInfoParam(param);
    	schDto.getPersonInfo().setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
    	schDto.getPersonInfo().setUpdateOrganName(getCurrentOrg(request).getOrganName());
    	schDto.getPersonInfo().setUpdateName(getCurrentUser(request).getName());
    	schDto.getPersonInfo().setUpdateDate(new Date());
    	schDto.getPersonInfo().setUpdateIdcard(getCurrentUser(request).getIdentityCard()); 
    }    
}
