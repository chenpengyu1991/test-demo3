package com.founder.rhip.idm.controller.malaria;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.dto.MalariaDto;
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
public abstract class MalariaBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key

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
    
    protected void updatePersonInfo(MalariaDto malariaDto, SpecialEvents event, HttpServletRequest request) throws Exception {
    	String[] param = null;
    	switch(event){
    		case M_BlOOD://血检登记
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case M_CASE://个案已填写
    			param = new String[]{"name", "gender","phoneNumber","occupation","education","householdType",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
    					"hrtownShip", "hrstreet", "hrhouseNumber", "hrAddress",    	
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case M_EPIDEMICFOCUS://疫点处理
    			param = new String[]{"name",
    					"patownShip", "pastreet", "pahouseNumber", "paAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    	}
    	malariaDto.setPersonInfoParam(param);
    	malariaDto.getPersonInfo().setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
    	malariaDto.getPersonInfo().setUpdateOrganName(getCurrentOrg(request).getOrganName());
    	malariaDto.getPersonInfo().setUpdateName(getCurrentUser(request).getName());
    	malariaDto.getPersonInfo().setUpdateDate(new Date());
    	malariaDto.getPersonInfo().setUpdateIdcard(getCurrentUser(request).getIdentityCard());  		    	
    }    
}
