package com.founder.rhip.mhm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.dto.MalariaDto;

/**
 * 精神卫生
 * 
 * 
 */
public abstract class MhmBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
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
    /**
     * 设置患者信息，更新人相关信息
     *
     * @param personInfo
     * @param request
     * @throws Exception
     * @author Ye jianfei
     */
    protected void updatePersonInfo(PersonInfo  personInfo,HttpServletRequest request) throws Exception{
		personInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
		personInfo.setUpdateOrganName(getCurrentOrg(request).getOrganName());
		personInfo.setUpdateName(getCurrentUser(request).getName());
		personInfo.setUpdateDate(new Date());
		personInfo.setUpdateIdcard(getCurrentUser(request).getIdentityCard()); 
    }     
}
