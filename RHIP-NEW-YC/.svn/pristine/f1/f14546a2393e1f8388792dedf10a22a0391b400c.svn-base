package com.founder.rhip.mhm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mhm.controller.form.MhmStatisticsQueryForm;
import com.founder.rhip.mhm.service.IMhmStatisticsService;

@Controller
@RequestMapping(value = "/mhm/statistics")
public class MhmStatisticsController extends MhmBaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource(name = "mhmStatisticsService")
    private IMhmStatisticsService mhmStatisticsService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    private static String CONTROLLER_NAME = "免费用药统计";

	/**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/drug/search")
	public String drugSearch(HttpServletRequest request,ModelMap model) {
		return "rhip.mhm.statistics.drug.search";
	}	
	/**
	 * 列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/drug/list")
	public String drugList(MhmStatisticsQueryForm form, String townName, String centerName, String stationName, HttpServletRequest request, ModelMap model) {
        Criteria criteria = form.getCriteria();
        PageList<MhmDrug> plist = mhmStatisticsService.getDrugResult(criteria, buildPage(request));
        model.addAttribute("drugList", plist.getList());
        model.addAttribute("page", plist.getPage());
//        model.put("drugDtFrom", form.getDrugDtFrom());
//        model.put("drugDtTo", form.getDrugDtTo());
        model.put("dateRange", getDateRange(form.getDrugDtFrom(), form.getDrugDtTo()));
        String organName = StringUtil.isNullOrEmpty(stationName)?(StringUtil.isNullOrEmpty(centerName)?StringUtil.isNullOrEmpty(townName)?"":townName:centerName):stationName;
        model.put("organName", StringUtil.isNullOrEmpty(organName)?"多机构":organName);
		return "rhip.mhm.statistics.drug.list";
	}
    /**
     * 进入查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/patient/search")
    public String patientSearch(HttpServletRequest request,ModelMap model) {
        return "rhip.mhm.statistics.patient.search";
    }
    /**
     * 列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/patient/list")
    public String patientList(MhmStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
        Criteria criteria = form.getPatientCriteria();
        PageList<MhmDrug> plist = mhmStatisticsService.getPatientResult(criteria, buildPage(request));
        model.addAttribute("patientList", plist.getList());
        model.addAttribute("page", plist.getPage());
//        model.put("drugDtFrom", form.getDrugDtFrom());
//        model.put("drugDtTo", form.getDrugDtTo());
        model.put("dateRange", getDateRange(form.getDrugDtFrom(), form.getDrugDtTo()));
        return "rhip.mhm.statistics.patient.list";
    }

    /**
     *
     *	导出按药统计EXCEL
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downDrugExcel")
    @ResponseBody
    public void downDrugExcel(MhmStatisticsQueryForm form , HttpServletRequest request, HttpServletResponse response) throws Exception {
        String townCode = form.getTownCode();
        String centerCode = form.getCenterCode();
        String stationCode = form.getStationCode();
        String townName = dictionaryApp.queryDicItemName("FS990001", townCode);

        String centerName = organizationApp.queryOrganName(centerCode);
        String stationName = organizationApp.queryOrganName(stationCode);


        String organName = StringUtil.isNullOrEmpty(stationName)?(StringUtil.isNullOrEmpty(centerName)?StringUtil.isNullOrEmpty(townName)?"":townName:centerName):stationName;
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/mhm/template/drugTemplate.xls"));
            Criteria criteria = form.getCriteria();
            List<MhmDrug> mhmDrugs = mhmStatisticsService.getDrugList(criteria);
            int totalRows = 8;
            int beginRowIndex = 8;
            int line = 0;
            excel.shiftRows(beginRowIndex-1 , totalRows,mhmDrugs.size());//
            for (MhmDrug mhmDrug : mhmDrugs) {
                List<Object> objects = getDrugExcelValues(line, mhmDrug, form.getDrugDtFrom(), form.getDrugDtTo(), organName);
                excel.writeLineWithFormat(objects,line + beginRowIndex-1);
                line++;
            }
            excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
            String title = EHRConstants.COUNTY_NAME + "精神卫生免费用药统计表.xls";
            setExcelContent(response, title);
            excel.save(response.getOutputStream());

            mhmDrugs.clear();
            mhmDrugs = null;
            OperationName  opName = OperationName.EXP;
            CONTROLLER_NAME = "免费用药统计";
            record(request, opName);
        } catch (Exception e) {
            log.error("下载《"+EHRConstants.COUNTY_NAME+"精神卫生免费用药统计表》出错", e);
            throw e;
        }
    }

    /**
     * 生成按药统计EXCEL一行数据
     *
     * @param drug
     * @return
     */
    private List<Object> getDrugExcelValues(int rowNumber,MhmDrug drug, String dateFrom, String dateTo,  String organName) {
        List<Object> line = new ArrayList<Object>();
        line.add(rowNumber + 1);//
        line.add(drug.getDrugName());//药品名称
        line.add(drug.getDrugForm());//剂型
        line.add(drug.getDrugSpecifications());//规格
        line.add(StringUtil.isNullOrEmpty(organName)?"多机构":organName);//机构
        line.add(getDateRange(dateFrom, dateTo));//时间
        line.add(drug.getCurrentPrice());//费用
        return line;
    }

    /**
     *
     *	导出按药统计EXCEL
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downPatientExcel")
    @ResponseBody
    public void downPatientExcel(MhmStatisticsQueryForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/mhm/template/patientTemplate.xls"));
            Criteria criteria = form.getPatientCriteria();
            List<MhmDrug> mhmDrugs = mhmStatisticsService.getPatientList(criteria);
            int totalRows = 8;
            int beginRowIndex = 8;
            int line = 0;
            excel.shiftRows(beginRowIndex-1 , totalRows,mhmDrugs.size());//
            for (MhmDrug mhmDrug : mhmDrugs) {
                List<Object> objects = getPatientExcelValues(line, mhmDrug, form.getDrugDtFrom(), form.getDrugDtTo());
                excel.writeLineWithFormat(objects,line + beginRowIndex-1);
                line++;
            }
            excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
            String title = EHRConstants.COUNTY_NAME + "精神卫生免费用药患者统计表.xls";
            setExcelContent(response, title);
            excel.save(response.getOutputStream());

            mhmDrugs.clear();
            mhmDrugs = null;

            OperationName  opName = OperationName.EXP;
            CONTROLLER_NAME = CONTROLLER_NAME + "(患者)";
            record(request, opName);
        } catch (Exception e) {
            log.error("下载《"+EHRConstants.COUNTY_NAME+"精神卫生免费用药患者统计表》出错", e);
            throw e;
        }
    }

    /**
     * 生成按药统计EXCEL一行数据
     *
     * @param patient
     * @return
     */
    private List<Object> getPatientExcelValues(int rowNumber,MhmDrug patient, String dateFrom, String dateTo) {
        List<Object> line = new ArrayList<Object>();
        line.add(rowNumber + 1);//
        line.add(patient.getName());//姓名
        line.add(dictionaryApp.queryDicItemName("GBT226112003", patient.getGender()));  //性别
        line.add(patient.getAge());//年龄
        line.add(patient.getIdcard());//身份证号
        line.add(patient.getDiagnosisContent());//诊断
        line.add(dictionaryApp.queryDicItemName("FS990001", patient.getOrganTown()));//所属乡镇
        line.add(getDateRange(dateFrom, dateTo));//时间
        line.add(patient.getCurrentPrice());//费用
        return line;
    }

    private String getDateRange(String dateFrom, String dateTo){
        String dateRange = "";
        if(StringUtil.isNullOrEmpty(dateFrom) && StringUtil.isNullOrEmpty(dateTo)) {
            dateRange = "迄今为止";
        }
        if(StringUtil.isNullOrEmpty(dateFrom) && StringUtil.isNotEmpty(dateTo)){
            dateRange = "最初" + "-" + dateTo;
        }
        if(StringUtil.isNotEmpty(dateFrom) && StringUtil.isNullOrEmpty(dateTo)){
            dateRange = dateFrom + "至今";
        }
        if(StringUtil.isNotEmpty(dateFrom) && StringUtil.isNotEmpty(dateTo))
        {
            dateRange = dateFrom + "-" + dateTo;
        }
        return dateRange;
    }

    public static String deCodeURLName(String name) {
        String result = null;
        try {
            result = name != null ? new String(name.getBytes("ISO-8859-1"),"UTF-8") : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected String getActionName() {
        return CONTROLLER_NAME;
    }
}
