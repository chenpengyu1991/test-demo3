/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ISetupDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("setupService")
public class SetupServiceImpl extends AbstractService implements ISetupService {

    @Autowired
    private IDictionaryApp dictionaryApp;

    private Map infections;

	@Resource(name = "idmSetupDao")
	private ISetupDao setupDao;

	@Override
	public int createSetup(IdmSetup idmSetup) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(idmSetup)){
			result = setupDao.generatedKey(idmSetup, "ID",null).intValue();
		}
		return result;
	}

	@Override
	public int updateSetup(IdmSetup idmSetup) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(idmSetup)){
			result = setupDao.update(idmSetup);
		}		
		return result;
	}

	@Override
	public int deleteSetup(Long Id) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(Id)){
			Criteria ca = new Criteria("id", Id);
			result = setupDao.delete(ca);
		}
		return result;
	}
	
	@Override
	public List<IdmSetup> findSetup(Criteria criteria) {
		return setupDao.getList(criteria);
	}

    /**
     * 根据条件查询出不重复的INFECTIOUS_CODE
     * @param criteria
     * @return
     */
    public List<IdmSetup> findDistinctInfectiousCodes(Criteria criteria) {
        return setupDao.findDistinctInfectiousCodes(criteria);
    }

    @Override
    public PageList<IdmSetup> findSetupOrder(Criteria criteria, Page page, Order order) {
        return setupDao.getPageList(page, criteria, order);
    }

	@Override
	public IdmSetup getSetup(Long id) {
		IdmSetup result = null;
		if(ObjectUtil.isNotEmpty(id)){
			result = setupDao.get(id);
		}
		return result;
	}


    @Override
    public int createSetupBath(IdmSetup idmSetup) {
    	//2017-5-5修改  该机构如果已存在,则删除后再添加，没有的直接添加
    	 List<DicItem> dicItems = new ArrayList<DicItem>();
         dicItems = dictionaryApp.queryDicItem("CV0501017");
         getInfectionDic(dicItems);
         int result = 0;
         List<IdmSetup> setups = new ArrayList<IdmSetup>();
         if(ObjectUtil.isNotEmpty(idmSetup)){
             //循环组成list
             String[] infectiousCodes = idmSetup.getInfectiousCode().split(",");
             String[] caseOrganCodes = idmSetup.getCaseOrganCode().split(",");
             
             for(int i = 0; i < infectiousCodes.length; i++){
             	
                  for(int j = 0; j < caseOrganCodes.length; j++){
                      IdmSetup setup = new IdmSetup();
                      setup.setSetYear(idmSetup.getSetYear());
                      setup.setInfectiousCode(infectiousCodes[i]);
                      setup.setInfectiousName(getFullName(infectiousCodes[i]));
                      setup.setCaseOrganCode(caseOrganCodes[j]);
                      setup.setCreateUnitCode(idmSetup.getCreateUnitCode());
                      setup.setCreateUserId(idmSetup.getCreateUserId());
                      setup.setCreateDt(idmSetup.getCreateDt());
                      setups.add(setup);
                  }
             }
             
             setupDao.deleteSetups(infectiousCodes, caseOrganCodes, idmSetup.getSetYear() );

             result = setupDao.batchInsert(setups);
         }
         return result;
       /* List<DicItem> dicItems = new ArrayList<DicItem>();
        dicItems = dictionaryApp.queryDicItem("CV0501017");
        getInfectionDic(dicItems);

        int result = 0;
        List<IdmSetup> oldSetups = new ArrayList<IdmSetup>();
        Criteria criteria = new Criteria();
        criteria.add("setYear", idmSetup.getSetYear());
        oldSetups = setupDao.getList(criteria);
        //要删除的
        //新的要新增的
        List<IdmSetup> setups = new ArrayList<IdmSetup>();
        List<IdmSetup> deleteSetups = new ArrayList<IdmSetup>();
        //要删除的
        if(ObjectUtil.isNotEmpty(idmSetup)){
            //循环组成list
            String[] infectiousCodes = idmSetup.getInfectiousCode().split(",");
            String[] caseOrganCodes = idmSetup.getCaseOrganCode().split(",");
            for(int i = 0; i < infectiousCodes.length; i++){
                //已经存的单独存放，已被删除用
                for(int k = 0; k < oldSetups.size(); k++){
                    if(infectiousCodes[i].endsWith(oldSetups.get(k).getInfectiousCode())){
                        deleteSetups.add(oldSetups.get(k));
                        break;
                    }else{

                    }
                }
                for(int j = 0; j < caseOrganCodes.length; j++){
                    IdmSetup setup = new IdmSetup();
                    setup.setSetYear(idmSetup.getSetYear());
                    setup.setInfectiousCode(infectiousCodes[i]);
                    setup.setInfectiousName(getFullName(infectiousCodes[i]));
                    setup.setCaseOrganCode(caseOrganCodes[j]);
                    setup.setCreateUnitCode(idmSetup.getCreateUnitCode());
                    setup.setCreateUserId(idmSetup.getCreateUserId());
                    setup.setCreateDt(idmSetup.getCreateDt());
                    setups.add(setup);
                }

            }

            Criteria deleteCriteria = new Criteria();
            deleteCriteria.add("setYear", idmSetup.getSetYear());
            for(int l = 0; l < deleteSetups.size(); l++){
                deleteCriteria.add("infectiousCode", deleteSetups.get(l).getInfectiousCode());
                setupDao.delete(deleteCriteria);
                continue;
            }

            result = setupDao.batchInsert(setups);
        }
        return result;*/
    }


    /**
     * 将字段中的树形字段进行组装，只取最末级，名称将上级名称带入
     * @param dicItems
     * @return
     */

    private void getInfectionDic(List<DicItem> dicItems) {
        int length = dicItems.size();
        String currentCode;
        String currentName;
        String preCode = "";
        String preName = "";
        Map map = new HashMap();
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
                        map.put(currentCode, currentName);
                        continue;
                    }
                    if ( !preCode.equals(nextCode.substring(0, 3))) {
                        map.put(currentCode, currentName);
                    }
                } else {
                    map.put(currentCode, currentName);
                }
            } else if (itemLevel > 3) {
                if (currentCode.substring(0, 3).equals(preCode)) {
                    map.put(currentCode, preName + " " + currentName);
                }
            }
        }
        infections = map;
    }

    private String getFullName(String code){
        String fullName = "";
        for(Object o : infections.keySet()){
            if(StringUtils.equalsIgnoreCase(o.toString(),code)){
                fullName = infections.get(o).toString();
                break;
            }
        }
        return fullName;
    }
}