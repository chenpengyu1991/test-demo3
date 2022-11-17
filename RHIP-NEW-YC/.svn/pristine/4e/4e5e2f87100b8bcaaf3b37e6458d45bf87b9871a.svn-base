package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ihm.controller.form.HRBaseTargetQueryForm;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  设备资源
 * @author chen_tao
 *
 */
@Controller
@RequestMapping("/ihm")
public class EquipmentResourceController extends IHMBaseController {

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @RequestMapping("/equipment/index")
    public String equipmentIndex(HttpServletRequest request, Model model) {
        return "ihm.equipment.index";
    }

    @RequestMapping("/equipment/detail")
    public String equipmentDetail(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("timeRangeFlag", "1");
        model.addAttribute("searchUrl", "/ihm/equipment/queryEquipment");
        //页面URL
        model.addAttribute("listpath", "basisTarget/equipment/equipmentList.jsp");
        model.addAttribute("type", "ihmDa");// 公用页面显示判断
        return "ihm.equipment.detail";
    }

    /**
     * 综合管理-设备资源
     * @return
     */
    @RequestMapping("/equipment/getEquipmentDate")
    @ResponseBody
    public Map<String, Object> getEquipmentDate() {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> equipmentData = organizationService.getEquipmentData();
        resultMap.put("equipmentNum",equipmentData.get("equipment_num"));
        resultMap.put("equipmentNumOne",equipmentData.get("equipment_num_one"));
        resultMap.put("equipmentNumTwo",equipmentData.get("equipment_num_two"));

        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getEquipmentPieData(series,equipmentData);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        return resultMap;
    }

    /**
     * 获取全市设备资源饼图数据
     * @param series
     * @param equipmentData
     * @return
     */
    private List<String> getEquipmentPieData(List<Map<String,Object>>  series,Map<String,Object> equipmentData){
        List<String> result = new ArrayList<>();
        series.add(putPieData(equipmentData.get("equipment_num"),"10万元以下"));
        series.add(putPieData(equipmentData.get("equipment_num_one"),"10万元~50万元"));
        series.add(putPieData(equipmentData.get("equipment_num_two"),"50万元以上"));

        result.add("10万元以下");
        result.add("10万元~50万元");
        result.add("50万元以上");
        return result;
    }

    @RequestMapping("/bed/index")
    public String bedIndex(HttpServletRequest request, Model model) {
        return "ihm.bed.index";
    }


    @RequestMapping("/bed/detail")
    public String bedDetail(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("timeRangeFlag", "1");
        model.addAttribute("searchUrl", "/ihm/equipment/queryBed");
        //页面URL
        model.addAttribute("listpath", "basisTarget/equipment/bedList.jsp");
        model.addAttribute("type", "ihmDa");// 公用页面显示判断
        return "ihm.bed.detail";
    }

    /**
     * 综合管理-床位资源
     * @return
     */
    @RequestMapping("/bed/getBedDate")
    @ResponseBody
    public Map<String, Object> getBedDate() {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> bedData = organizationService.getEquipmentData();
        resultMap.put("bedCount",bedData.get("bed_count"));
        resultMap.put("openBedCount",bedData.get("open_bed_count"));
        Criteria ca = new Criteria("GENRE_CODE", OP.IN,new String[]{OrgGenreCode.CENTRE.getValue(),OrgGenreCode.HOSPITAL.getValue()});
        List<Organization> organizations = organizationService.sumEquipmentByHospital(ca);
        List<Map<String, Object>> series = new ArrayList<>();
        List<String> xAxis = getBedChartData(series,organizations);
        resultMap.put(LEGEND_JSON, new String[]{"核准床位数", "开放床位数"});
        resultMap.put(SERIES_JSON, series);
        resultMap.put(XAXIS_JSON, xAxis);
        List<Map<String,Object>> yAxis = new ArrayList<>();
        yAxis.add(addYAxis("床位资源","张"));
        resultMap.put(YAXIS_JSON, yAxis);
        resultMap.put("title", "");
        resultMap.put("unit", "张");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    @RequestMapping("/building/index")
    public String buildingList(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("timeRangeFlag", "1");
        model.addAttribute("searchUrl", "/ihm/equipment/queryBuilding");
        //页面URL
        model.addAttribute("listpath", "basisTarget/equipment/buildingList.jsp");
        return "ihm.building.index";
    }
	
	@RequestMapping("/equipment/queryEquipment")
	public String queryEq(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Organization> organizations = query(form);
        model.addAttribute("organizations", organizations);
        return "ihm.equipment.queryEquipment";
	}


    @RequestMapping("/equipment/queryBed")
    public String queryBed(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Organization> organizations = query(form);
        model.addAttribute("organizations", organizations);
        return "ihm.equipment.queryBed";
    }

    @RequestMapping("/equipment/queryBuilding")
    public String queryBuilding(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Organization> organizations = query(form);
        model.addAttribute("organizations", organizations);
        return "ihm.equipment.queryBuilding";
    }

    /**
     * 医疗机构
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/organization/index")
    public String organizationIndex(HttpServletRequest request, Model model) {
        return "ihm.organization.index";
    }

    /**
     * 综合管理-基础资源-医疗机构
     * @return
     */
    @RequestMapping("/organization/getOrganizationDate")
    @ResponseBody
    public Map<String, Object> getOrganizationDate() {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> orgData = getOrganization();
        resultMap.put("A1_ORG",orgData.get("A1_ORG"));
        resultMap.put("B1_ORG",orgData.get("B1_ORG"));
        resultMap.put("B2_ORG",orgData.get("B2_ORG"));
        resultMap.put("D400_ORG",orgData.get("D400_ORG"));
        resultMap.put("L_ORG",orgData.get("L_ORG"));
        resultMap.put("R2_ORG",orgData.get("R2_ORG"));

        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getOrgPieData(series,orgData);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        return resultMap;
    }

    private Map<String,Object> getOrganization(){
        Map<String,Object> result = new HashMap<>();
        //综合医院
        Criteria criA1 = new Criteria("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
        criA1.add("status", StatusValue.normalValue.getValue());
        Page page = new Page(1000,1);
        PageList<Organization> organizationA1s = organizationService.getOrganizationsNoVirtual(page,criA1);
        if(ObjectUtil.isNotEmpty(organizationA1s)){
            result.put("A1_ORG",organizationA1s.getPage().getTotalRows());
        }

        //社区卫生服务中心
        Criteria criB1 = new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
        criB1.add("status",StatusValue.normalValue.getValue());
        PageList<Organization> organizationB1s = organizationService.getOrganizationsNoVirtual(page,criB1);
        if(ObjectUtil.isNotEmpty(organizationB1s)){
            result.put("B1_ORG",organizationB1s.getPage().getTotalRows());
        }

        //社区卫生服务站
        Criteria criB2 = new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue());
        criB2.add("status",StatusValue.normalValue.getValue());
        PageList<Organization> organizationB2s = organizationService.getOrganizationsNoVirtual(page,criB2);
        if(ObjectUtil.isNotEmpty(organizationB2s)){
            result.put("B2_ORG",organizationB2s.getPage().getTotalRows());
        }

        //医务室
        Criteria criD400 = new Criteria("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
        criD400.add("status",StatusValue.normalValue.getValue());
        PageList<Organization> organizationD400s = organizationService.getOrganizationsNoVirtual(page,criD400);
        if(ObjectUtil.isNotEmpty(organizationD400s)){
            result.put("D400_ORG",organizationD400s.getPage().getTotalRows());
        }

        //卫生监督检验(监测、检测)所(站)
        Criteria criL = new Criteria("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
        criL.add("status",StatusValue.normalValue.getValue());
        PageList<Organization> organizationLs = organizationService.getOrganizationsNoVirtual(page,criL);
        if(ObjectUtil.isNotEmpty(organizationLs)){
            result.put("L_ORG",organizationLs.getPage().getTotalRows());
        }

        //其他
        Criteria criR2= new Criteria("GENRE_CODE", OrgGenreCode.OTHER.getValue());
        criR2.add("status",StatusValue.normalValue.getValue());
        PageList<Organization> organizationR2s = organizationService.getOrganizationsNoVirtual(page,criR2);
        if(ObjectUtil.isNotEmpty(organizationR2s)){
            result.put("R2_ORG",organizationR2s.getPage().getTotalRows());
        }
        return result;
    }
    /**
     * 获取医疗机构饼图数据
     * @param series
     * @param orgData
     * @return
     */
    private List<String> getOrgPieData(List<Map<String,Object>>  series,Map<String,Object> orgData){
        List<String> result = new ArrayList<>();
        series.add(putPieData(orgData.get("A1_ORG"),"综合医院"));
        series.add(putPieData(orgData.get("B1_ORG"),"社区卫生服务中心"));
        series.add(putPieData(orgData.get("B2_ORG"),"社区卫生服务站"));
        series.add(putPieData(orgData.get("D400_ORG"),"医务室"));
        series.add(putPieData(orgData.get("L_ORG"),"卫生监督检验"));
        series.add(putPieData(orgData.get("R2_ORG"),"其他"));

        result.add("综合医院");
        result.add("社区卫生服务中心");
        result.add("社区卫生服务站");
        result.add("医务室");
        result.add("卫生监督检验");
        result.add("其他");
        return result;
    }


    private List<Organization> query(TargetOrgQueryForm form){
        String orgType = form.getGenreCode();
        List<Organization> organizations = null;
        if("0".equals(orgType)) //按镇
        {
            organizations = organizationService.sumEquipmentByTown(form.getGbCode());
            return organizations;
        }
        String organCode = null;
        String genreCode = null;
        String fieldName = null;
        String gbCode = form.getGbCode();
        Criteria criteria = new Criteria();
        if("A100".equals(orgType)) //按市级医院
        {
            organCode = form.getSuperOrganCode();
            genreCode = "A100";
            fieldName = "organCode";
            //del by bagen  删除subsid的条件
//            criteria.add("SUBSID","0");
        }
        else if("B100".equals(orgType)) //按卫生院
        {
            //如果选择的是镇
            if("0".equals(form.getGenreCode()))
            {
                fieldName = "gbCode";
               
            }
            else
            {
                fieldName = "organCode";
            }
            organCode = form.getSuperOrganCode();
            genreCode = "B100";
        }
        else if("B200".equals(orgType)) //按社区卫服务站
        {
            if("0".equals(form.getGenreCode())) //如果选择的是镇
            {
                fieldName = "gbCode";
            }
            else if("B100".equals(form.getGenreCode())) //如果选择的是卫生服务中心
            {
                fieldName = "parentCode";
            }
            else
            {
                fieldName = "organCode";
            }
            organCode = form.getOrganCode();
            if(StringUtil.isNullOrEmpty(organCode)){
                String parentCode = form.getSuperOrganCode();
                if(StringUtil.isNotEmpty(parentCode))
                {
                    criteria.add("parentCode", parentCode);
                }
            }
            genreCode = "B200";
        }

        if(StringUtil.isNotEmpty(genreCode))
        {
            criteria.add("genreCode", genreCode);
        }

        if(StringUtil.isNotEmpty(organCode))
        {
            criteria.add(fieldName, organCode);
        }
        if(StringUtil.isNotEmpty(gbCode))
        {
            criteria.add("gbCode", gbCode);
        }
        if(organCode != null && organCode.length() > 0){
            organizations = organizationService.getOrganizations(criteria);
        } else if("B200".equals(orgType)){
        	organizations = organizationService.sumEquipment(orgType, gbCode, organCode, form.getSuperOrganCode());
        } else {
        	organizations = organizationService.sumEquipment(orgType, gbCode, organCode, "");
        }
        	return organizations;
    }

    private Map<String, Object> putPieData(Object value,String name){
        Map<String, Object> data = new HashMap<String,Object>();
        data.put("value",value);
        data.put("name",name);
        return data;
    }

    /**
     * 生成床位图表数据
     * @param series
     * @param organizations
     */
    private List<String> getBedChartData(List<Map<String,Object>>  series,List<Organization> organizations){
        List<String> result = new ArrayList<>();
        List<String> seriesBedDatas = new ArrayList<>();
        List<String> seriesOpenBedDatas = new ArrayList<>();
        for(Organization org:organizations){
            Organization orgNew = organizationService.getOrganization(org.getOrganCode());
            if(ObjectUtil.isNullOrEmpty(orgNew)){
                continue;
            }
            result.add(orgNew.getOrganName());
            Integer bedCount = org.getBedCount();
            seriesBedDatas.add(ObjectUtil.isNotEmpty(bedCount)?bedCount.toString():"0");
            Integer openBedCount = org.getOpenBedCount();
            seriesOpenBedDatas.add(ObjectUtil.isNotEmpty(openBedCount)?openBedCount.toString():"0");
        }
        Map<String,Object> seriesBedMap = addSeries("核准床位数","bar",seriesBedDatas);
        Map<String,Object> seriesOpenBedMap = addSeries("开放床位数","bar",seriesOpenBedDatas);
        series.add(seriesBedMap);
        series.add(seriesOpenBedMap);
        return result;
    }

}