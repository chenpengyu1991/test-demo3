package com.founder.rhip.idm.controller.leprosy;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.service.ILeprosyService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  结核病统计
 */
@Controller
@RequestMapping("/idm/leprosy/statistics")
public class LeprosyStatisticsController extends BaseController {

	@Resource(name = "leprosyService")
	private ILeprosyService leprosyService;
	
	@Autowired
    private IDictionaryApp dictionaryApp;

	@Autowired
	private IEhrSecurityService ehrSecurityService;
	
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap model) {
		model.put("pageIndex", 1);
		return "rhip.idm.leprosy.statistics.index";
	}
    
    /**
     * 密切接触者列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/cc/list")
    public String searchCcList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = getCriteria(form, request);

        PageList<ListCc> plist = leprosyService.getCcListForLeprosySt(page, criteria);
        model.addAttribute("ccList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.statistics.ccList";
    }
    
    /**
     * 随访列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/fr/list")
    public String searchFrList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = getCriteria(form, request);

        PageList<ListFr> plist = leprosyService.getFrListForLeprosySt(page, criteria);
        model.addAttribute("frList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.statistics.frList";
    }

    /**
     *
     *下载密切接触者
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downCcExcel")
    @ResponseBody
    public void downCcExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/leprosy_cc.xls"));
            Criteria criteria = getCriteria(form, request);
            List<ListCc> plist = leprosyService.getCcListForLeprosySt(criteria);
            int totalRows = 7;
            int beginRowIndex = 4;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
            for (ListCc cc : plist) {
                List<Object> objects = getCcExcelValues(cc, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, "市麻风患者密切接触者汇总表.xls");
            excel.save(response.getOutputStream());

            plist.clear();
            plist = null;
        } catch (Exception e) {
            log.error("下载《市麻风患者密切接触者汇总表》出错", e);
            throw e;
        }
    }
    /**
     * 生成疑似病人EXCEL一行数据
     *
     * @param listCc
     * @param lineNumber
     * @return
     */
    private List<Object> getCcExcelValues(ListCc listCc, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add(listCc.getCloseName());
        line.add(dictionaryApp.queryDicItemName("GBT226112003", listCc.getSex()));
        line.add(listCc.getAge());
        line.add(listCc.getAddress());
        line.add(listCc.getPatientName());
        line.add(dictionaryApp.queryDicItemName("FS990001", listCc.getAcceptTown()));
        line.add(dictionaryApp.queryDicItemName("IDM00249", listCc.getCloseType()));
        line.add("2".equals(listCc.getPositiveSigns())?"√":"");
        line.add(listCc.getDiagnosisResultDetail());
        line.add(listCc.getDorctorName());
        line.add(DateUtil.getDateTime("yyyy/MM/dd", listCc.getRegistDt()));
        return line;
    }
    
    /**
    *
    *下载随访
    * @param request
    * @param response
    * @param form
    * @throws Exception
    */
   @RequestMapping("/downFrExcel")
   @ResponseBody
   public void downFrExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
       try {
           ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/leprosy_fr.xls"));
           Criteria criteria = getCriteria(form, request);
           List<ListFr> plist = leprosyService.getFrListForLeprosySt(criteria);
           int totalRows = 7;
           int beginRowIndex = 4;
           int line = 0;
           excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
           for (ListFr fr : plist) {
               List<Object> objects = getFrExcelValues(fr, line + 1);
               excel.writeLineWithFormat(objects,line + beginRowIndex);
               line++;
           }
           excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
           excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
           setExcelContent(response, "市麻风患者随访观察汇总表.xls");
           excel.save(response.getOutputStream());

           plist.clear();
           plist = null;
       } catch (Exception e) {
           log.error("下载《市麻风患者随访观察汇总表》出错", e);
           throw e;
       }
   }
   
   /**
    * 生成疑似病人EXCEL一行数据
    *
    * @param listCc
    * @param lineNumber
    * @return
    */
   private List<Object> getFrExcelValues(ListFr listFr, int lineNumber) {
       List<Object> line = new ArrayList<Object>();
       line.add(listFr.getName());
       line.add(dictionaryApp.queryDicItemName("GBT226112003", listFr.getGender()));
       line.add(listFr.getAge());
       line.add(listFr.getPaAddress());
       line.add("2".equals(listFr.getLeprosy())?"√":"");
       line.add(dictionaryApp.queryDicItemName("IDM00317", listFr.getLeprosyType()));
       line.add(dictionaryApp.queryDicItemName("IDM00280", listFr.getUlcerHand()));
       line.add(dictionaryApp.queryDicItemName("IDM00280", listFr.getUlcerLeg()));
       line.add(dictionaryApp.queryDicItemName("IDM00280", listFr.getUlcerAnkle()));
       line.add(dictionaryApp.queryDicItemName("IDM00280", listFr.getUlcerFoot()));
       line.add(dictionaryApp.queryDicItemName("IDM00280", listFr.getUlcerToe()));
       line.add(listFr.getUlcerOther());
       line.add(ehrSecurityService.getUser(Long.parseLong(listFr.getCheckUser())).getName());
       line.add(DateUtil.getDateTime("yyyy/MM/dd", listFr.getVisitDt()));
       return line;
   }
   
    private Criteria getCriteria(TbQueryForm form, HttpServletRequest request){
        Criteria criteria = new Criteria();
        criteria.add("S.IDM_TYPE", IdmType.LEPROSY.getValue());
        Date startDt = form.getDateFrom();
        Date endDt = form.getDateTo();
        String orgCode = form.getOrgCode();
        DateUtil.getCriteriaByDateRange(criteria, "caseInfo.Modify_Survey_Date", startDt, endDt);
        //权限
        
        if(StringUtil.isNotEmpty(orgCode)){
        	criteria.add("caseInfo.Modify_Survey_Org", orgCode);
        }
        return criteria;
    }
}