package com.founder.rhip.idm.controller.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.idm.controller.form.ReportStatisticsQueryForm;
import com.founder.rhip.idm.service.IReportStatisticsService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/idm/statistics/report/takeSample")
public class TakeSampleController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportStatisticsService")
	private IReportStatisticsService reportStatisticsService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

	/**
	 * 手足口病采样登记-汇总列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String takeSampleList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = 1;
		if(StringUtil.isNotEmpty(indexPage)){
			currentPage = Integer.valueOf(indexPage);
		}
        
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.gettakeSampleCriteria();
		if (hasRole(RoleType.JKFYK, request)){
			Organization org = getCurrentOrg(request);
			ca.add("MODIFY_UNIT",org.getOrganCode());//只能查询本单位的数据
		}	
		        
        Order od = new Order("MODIFY_UNIT,SAMPLE_DT DESC");
        PageList<ListTs> plist = reportStatisticsService.findTsList(ca, page,od);
        model.addAttribute("tsList", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "rhip.idm.statistics.report.takeSample.list";
	}
	
	/**
	 * 
	 *	导出手足口病采样登记列表EXCEL
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping("/downExcel")
	@ResponseBody
	public void downExcel(ReportStatisticsQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/takeSampleTemplet.xls"));
	        Criteria ca = form.gettakeSampleCriteria();
			if (hasRole(RoleType.JKFYK, request)){
				Organization org = getCurrentOrg(request);
				ca.add("MODIFY_UNIT",org.getOrganCode());//只能查询本单位的数据
			}		
			Order od = new Order("MODIFY_UNIT,SAMPLE_DT DESC");
			List<ListTs> lists = reportStatisticsService.findTsList(ca, od);
			int totalRows = 8;
			int beginRowIndex = 8;
			int line = 0;
			excel.shiftRows(beginRowIndex-1 , totalRows,lists.size());//
			for (ListTs ts : lists) {
				List<Object> objects = getExcelValues(ts);
				excel.writeLineWithFormat(objects,line + beginRowIndex-1);
				line++;
			}
			excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
			setExcelContent(response, " 市手足口病采样登记表.xls");
			excel.save(response.getOutputStream());

			lists.clear();
			lists = null;
		} catch (Exception e) {
			log.error("下载《 市手足口病采样登记表》出错", e);
			throw e;
		}
	}
	
	/**
	 * 生成手足口病采样登记列表EXCEL一行数据
	 *
	 * @param fg
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getExcelValues(ListTs ts) {
		String outpatient = "1".equals(ts.getOutpatient())?"√":"";
		String hospitalization = "1".equals(ts.getHospitalization())?"√":"";
		String diagnosisHfmd = "1".equals(ts.getDiagnosisHfmd())?"√":"";
		String diagnosisAngina = "1".equals(ts.getDiagnosisAngina())?"√":"";
		String diagnosisMeningitis = "1".equals(ts.getDiagnosisMeningitis())?"√":"";
		String diagnosisEncephalitis = "1".equals(ts.getDiagnosisEncephalitis())?"√":"";
		String diagnosisOther = "1".equals(ts.getDiagnosisOther())?"√":"";
		String throatSwab = "1".equals(ts.getThroatSwab())?"√":"";
		String percolate = "1".equals(ts.getPercolate())?"√":"";
		String excrement = "1".equals(ts.getExcrement())?"√":"";
		String anusSwab = "1".equals(ts.getAnusSwab())?"√":"";
		String csf = "1".equals(ts.getCsf())?"√":"";
		String acuteSerum = "1".equals(ts.getAcuteSerum())?"√":"";
		String convalescentSerum = "1".equals(ts.getConvalescentSerum())?"√":"";
		String other = "1".equals(ts.getOther())?"√":"";

		List<Object> line = new ArrayList<Object>();
		line.add(ts.getMediRecordNum());//病例编号
		line.add(ts.getName());//患者姓名
		line.add(ts.getParentsName());//患者家长姓名
		line.add(dictionaryApp.queryDicItemName("GBT226112003", ts.getGender()));
		line.add(DateUtil.getDateTime("yyyy/MM/dd", ts.getBirthday()));//出生年月
		line.add(DateUtil.getDateTime("yyyy/MM/dd", ts.getAttackDt()));//发病日期
		line.add(DateUtil.getDateTime("yyyy/MM/dd", ts.getTreatDt()));//就诊日期
		line.add(DateUtil.getDateTime("yyyy/MM/dd", ts.getSampleDt()));//采样日期
		line.add(ts.getTemperature());//体温
		line.add(outpatient);//门诊病例
		line.add(hospitalization);//住院病例
		line.add(diagnosisHfmd);//手足口病
		line.add(diagnosisAngina);//疱疹性咽峡炎
		line.add(diagnosisMeningitis);//无菌性脑膜炎
		line.add(diagnosisEncephalitis);//脑干脑炎
		line.add(diagnosisOther);//临床诊断-其他
		line.add(throatSwab);//咽拭子
		line.add(percolate);//疱内渗出液
		line.add(excrement);//粪便
		line.add(anusSwab);//肛拭子
		line.add(csf);//标本种类-脑脊液
		line.add(acuteSerum);//急性期血清
		line.add(convalescentSerum);//恢复期血清
		line.add(other);//标本种类-其它
		line.add(ts.getLabResult());

		return line;
	}	
}
