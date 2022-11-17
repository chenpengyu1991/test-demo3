package com.founder.rhip.ehr.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.service.basic.IPcbDicItemService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.repository.DicItemDao;
import com.founder.rhip.mdm.repository.IDicItemDao;
import com.founder.rhip.mdm.repository.IOrganizationAreaDao;
import com.founder.rhip.mdm.repository.OrganizationAreaDao;
import com.founder.rhip.mdm.service.IDictionaryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanzg on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/houseHold")
public class HouseHoldController extends BaseController {

    @Resource(name = "mdmOrganizationAreaDao")
    private IOrganizationAreaDao OrganizationAreaDao;

    @Resource(name = "mdmDicItemDao")
    private IDicItemDao dicItemDao;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "mdmDictionaryService")
    private IDictionaryService DictionaryService;

    /**
     * 小区查询页面
     *
     * @return
     */
    @RequestMapping(value = "/manage")
    public String managehouseHold() {
        return "rhip.ehr.houseHold.search";
    }

    /**
     * 小区列表
     *
     * @param request
     * @param model
     * @param houseHoldName
     * @return
     */
    @RequestMapping(value = "/List")
    public String manageHouseHold(HttpServletRequest request, ModelMap model, String houseHoldName,int indexPage) {
        //获取当前机构code
        Page page = super.getPage(request, indexPage);
        Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
        String curOrgCode = currentOrg.getOrganCode();
        Criteria curOrgCriteria = new Criteria();
        curOrgCriteria.add("ORGANIZATION_CODE", curOrgCode);
        List<OrganizationArea> curOrgAreaList = OrganizationAreaDao.getList(curOrgCriteria);
        List<DicItem> houseHoldList = new ArrayList<DicItem>();
        PageList<DicItem> houseHoldPageList = new PageList<DicItem>();
        try {
            //显示全部小区列表
            if (StringUtil.isNullOrEmpty(houseHoldName)) {
                for (OrganizationArea curOrgArea : curOrgAreaList) {
                    String itemCode = curOrgArea.getAreaCode();
                    String dicCode = "FS990001";
                    Criteria criteria = new Criteria();
                    criteria.add(Dictionary.DIC_CODE,dicCode);
                    criteria.add(DicItem.PARENT_CODE,itemCode);
                    houseHoldPageList = DictionaryService.getDicItems(page, criteria);
                    DicItem village = dictionaryApp.queryDicItem(dicCode, itemCode);
                    if(ObjectUtil.isNullOrEmpty(village)){
                        continue;
                    }
                    String villageName = village.getItemName();
                    if (ObjectUtil.isNullOrEmpty(houseHoldPageList)) {
                        continue;
                    } else {
                        List<DicItem> dicItems = houseHoldPageList.getList();
                        for (DicItem dicItem : dicItems) {
                            /*dicItem.setParentName(villageName);*/
                            houseHoldList.add(dicItem);
                        }
                    }
                }
                houseHoldPageList.setList(houseHoldList);
            } else {
                //根据页面小区名称查询
                for (OrganizationArea curOrgArea : curOrgAreaList) {
                    String itemCode = curOrgArea.getAreaCode();
                    String dicCode = "FS990001";
                    Criteria itemCodeCriteria = new Criteria();
                    itemCodeCriteria.add("dicCode", dicCode);
                    itemCodeCriteria.add(DicItem.PARENT_CODE, itemCode);
                    itemCodeCriteria.add(DicItem.ITEM_NAME, OP.LIKE, houseHoldName);
                    houseHoldPageList = DictionaryService.getDicItems(page, itemCodeCriteria);
                    DicItem village = dictionaryApp.queryDicItem(dicCode, itemCode);
                    if(ObjectUtil.isNullOrEmpty(village)){
                        continue;
                    }
                    String villageName = village.getItemName();
                    if (ObjectUtil.isNotEmpty(houseHoldPageList)) {
                        List<DicItem> dicItems = houseHoldPageList.getList();
                        for (DicItem dicItem : dicItems) {
                            /*dicItem.setParentName(villageName);*/
                            houseHoldList.add(dicItem);
                        }
                    }
                }
                houseHoldPageList.setList(houseHoldList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("houseHoldList", houseHoldPageList.getList());
        model.addAttribute("page", houseHoldPageList.getPage());
        model.addAttribute("indexPage", indexPage);
        return "rhip.ehr.houseHold.manage";
    }

    /**
     * 新增小区页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/addHouseHold")
    public String addHouseHold(HttpServletRequest request, ModelMap model) {
        Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
        String curOrgCode = currentOrg.getOrganCode();
        Criteria curOrgCriteria = new Criteria();
        curOrgCriteria.add("ORGANIZATION_CODE", curOrgCode);
        List<OrganizationArea> curOrgAreaList = OrganizationAreaDao.getList(curOrgCriteria);
        List<DicItem> houseHolds = new ArrayList<DicItem>();
        //展现小区列表
        for (OrganizationArea curOrgArea : curOrgAreaList) {
            String itemCode = curOrgArea.getAreaCode();
            String dicCode = "FS990001";
            DicItem dicItem = dictionaryApp.queryDicItem(dicCode, itemCode);
            houseHolds.add(dicItem);
        }
        model.addAttribute("dicItems", houseHolds);
        return "rhip.ehr.houseHold.add";
    }

    /**
     * 保存新增小区
     *
     * @param request
     * @param vaillagecode
     * @param houseHoldName
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveAddHouseHold")
    public void saveAddHouseHold(HttpServletRequest request, String vaillagecode, String houseHoldName, ModelMap model, HttpServletResponse response) {
        try {
            String message = "";
            if (ObjectUtil.isNotEmpty(vaillagecode) && ObjectUtil.isNotEmpty(houseHoldName)) {
                String dicCode = "FS990001";
                Integer ItemCode = (int) (Math.random() * 1000);
                String code = ItemCode.toString();
                String Itemcode = vaillagecode + code;
                String operator = "admin";
                long operator_time = Long.parseLong("201701010000");
                int status = 1;
                DicItem dicItem = new DicItem();
                dicItem.setDicCode("FS990001");
                dicItem.setParentCode(vaillagecode);
                dicItem.setItemName(houseHoldName);
                dicItem.setItemCode(Itemcode);
                dicItem.setOperator(operator);
                dicItem.setOperateTime(operator_time);
                dicItem.setStatus(status);
                DictionaryService.createDicItem(dicItem);
                //验证是否新增成功
                DicItem newdicItem = dictionaryApp.queryDicItem(dicCode, Itemcode);
                if (ObjectUtil.isNullOrEmpty(newdicItem)) {
                    message = "保存成功";
                } /*else {
                    message = "保存失败";
                }*/
            } else {
                message = "居委会和小区名称均不能为空！";
            }
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改小区页面
     *
     * @return
     */
    @RequestMapping(value = "/modifyHouseHold")
    public String modifyHouseHold(String itemCode, ModelMap model) {
        model.addAttribute("itemCode", itemCode);
        return "rhip.ehr.houseHold.modify";
    }

    /**
     * 保存修改
     *
     * @return
     */
    @RequestMapping(value = "/modifysave")
    public String modify(String itemCode, String houseHoldName) {
        try {
            String dicCode = "FS990001";
            if (StringUtil.isNotEmpty(itemCode)) {
                DicItem dicItem = dictionaryApp.queryDicItem(dicCode, itemCode);
                if (StringUtil.isNotEmpty(houseHoldName)) {
                    dicItem.setItemName(houseHoldName);
                    DictionaryService.updateDicItem(dicItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managehouseHold();
    }

    /**
     * 删除小区
     */
    @RequestMapping(value = "/deleteHouseHold")
    public String deleteHouseHold(String itemCode) {
        try {
            if (StringUtil.isNotEmpty(itemCode)) {
                String dicCode = "FS990001";
                DicItem dicItem = dictionaryApp.queryDicItem(dicCode, itemCode);
                long itemId = dicItem.getItemId();
                DictionaryService.deleteDicItem(itemId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managehouseHold();
    }

}
