package com.founder.rhip.phsr.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.MentalEpilepsyPatient;
import com.founder.rhip.ehr.repository.statistics.IMentalEpilepsyPatientDao;
import com.founder.rhip.ihm.service.IMentalEpilepsyPatientService;

/**
 * 严重精神障碍患者管理统计报表
 */
@Controller
@RequestMapping(value = "/mentalEpilepsyCensus")
public class MentalEpilepsyCensusController extends BaseController {

    @Resource(name = "mentalEpilepsyPatientService")
    private IMentalEpilepsyPatientService mentalEpilepsyPatientService;

    @Autowired
    private IMentalEpilepsyPatientDao mentalEpilepsyPatientDao;

    /**
     * 查询界面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/search")
    public String search(HttpServletRequest request, ModelMap model) {
        model.addAttribute("searchDate", new Date());
        return "rhip.phsr.mentalEpilepsyCensus.search";
    }

    /**
     * 获取列表
     *
     * @param mentalEpilepsyPatient
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(MentalEpilepsyPatient mentalEpilepsyPatient, HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("year", mentalEpilepsyPatient.getYear());
        if (mentalEpilepsyPatient.getQuarter() != null) {
            criteria.add("quarter", mentalEpilepsyPatient.getQuarter());
            criteria.add("countType", mentalEpilepsyPatient.getCountType());
        } else {
            criteria.add("countType", "1");
        }

        List<MentalEpilepsyPatient> mentalList = new ArrayList<>();
        MentalEpilepsyPatient mentalTotal = new MentalEpilepsyPatient();
        MentalEpilepsyPatient editMental = new MentalEpilepsyPatient();
        Criteria cri = new Criteria("organCode", getCurrentOrg(request).getOrganCode()).add("year", mentalEpilepsyPatient.getYear());
        if (mentalEpilepsyPatient.getQuarter() != null) {
            cri.add("quarter", mentalEpilepsyPatient.getQuarter());
        }
        if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZJSB, request)) {
            criteria.add("ORGAN_CODE", getCurrentOrg(request).getOrganCode());
            mentalList = mentalEpilepsyPatientService.getCenterAndStation(criteria);
            /*合计*/
            mentalTotal = mentalList.get(0);
            /*编辑*/
            editMental = mentalEpilepsyPatientService.getMentalEpiPatient(cri);
            model.addAttribute("editMental", editMental);
        }
        if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXJFYS, request)) {
            criteria.add("CENTER_CODE", getCurrentOrg(request).getOrganCode());
            criteria.add("SEARCHSTATION", mentalEpilepsyPatient.getOrganCode());
            mentalList = mentalEpilepsyPatientService.getCenterAndStation(criteria);
            /*合计*/
            if (ObjectUtil.isNullOrEmpty(mentalEpilepsyPatient.getOrganCode())) {
                mentalTotal = mentalEpilepsyPatientService.countCenterAndStation(criteria).get(0);
            } else {
                criteria.remove("CENTER_CODE");
                criteria.remove("SEARCHSTATION");
                criteria.add("ORGAN_CODE", mentalEpilepsyPatient.getOrganCode());
                mentalTotal = mentalEpilepsyPatientService.getCenterAndStation(criteria).get(0);
            }
            /*编辑*/
            editMental = mentalEpilepsyPatientService.getMentalEpiPatient(cri);
            model.addAttribute("editMental", editMental);
        }
        if (hasRole(RoleType.QWGZX, request)) {
            criteria.add("gbCode", getCurrentOrg(request).getGbCode());
            criteria.add("genreCode", "B100");
            criteria = initListCriteria(criteria, mentalEpilepsyPatient);
            mentalList = getAllList(criteria);
            /*合计*/
            mentalTotal = countAll(criteria, mentalEpilepsyPatient);
        }
        if (hasRole(RoleType.ADMIN, request) || hasRole(RoleType.JKJFZX, request)) {
            criteria.add("genreCode", "B100");
            criteria = initListCriteria(criteria, mentalEpilepsyPatient);
            mentalList = getAllList(criteria);
            /*合计*/
            mentalTotal = countAll(criteria, mentalEpilepsyPatient);
        }
        model.addAttribute("mentalEpiPatientList", mentalList);
        model.addAttribute("total", mentalTotal);
        return "rhip.phsr.mentalEpilepsyCensus.list";
    }

    /**
     * 保存
     *
     * @param mentalEpilepsyPatient
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(MentalEpilepsyPatient mentalEpilepsyPatient, HttpServletRequest request, ModelMap model) {
        Criteria criteria = initSaveCriteria(mentalEpilepsyPatient);

        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            int year = mentalEpilepsyPatient.getYear();
            int quarter = mentalEpilepsyPatient.getQuarter();
            Date reportDate = new Date();
            switch (quarter) {
                case 1:
                    reportDate = format.parse(year + "-01-01");
                    break;
                case 2:
                    reportDate = format.parse(year + "-04-01");
                    break;
                case 3:
                    reportDate = format.parse(year + "-07-01");
                    break;
                case 4:
                    reportDate = format.parse(year + "-10-01");
                    break;

            }
            mentalEpilepsyPatient.setReportTime(reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MentalEpilepsyPatient judgemental = mentalEpilepsyPatientService.getSingleMental(criteria);
        if (ObjectUtil.isNotEmpty(judgemental)) {
            mentalEpilepsyPatientService.update(mentalEpilepsyPatient);
        }
        if (ObjectUtil.isNullOrEmpty(judgemental)) {
            mentalEpilepsyPatientService.save(mentalEpilepsyPatient);
        }
        return "rhip.phsr.mentalEpilepsyCensus.list";
    }


    private Criteria initSaveCriteria(MentalEpilepsyPatient mentalEpilepsyPatient) {
        Criteria criteria = new Criteria();
        int year = mentalEpilepsyPatient.getYear();
        int quarter = mentalEpilepsyPatient.getQuarter();
        String organCode = mentalEpilepsyPatient.getOrganCode();
        criteria.add("year", year);
        criteria.add("quarter", quarter);
        criteria.add("organCode", organCode);
        return criteria;
    }

    private Criteria initListCriteria(Criteria criteria, MentalEpilepsyPatient mentalEpilepsyPatient) {
        String gbCode = mentalEpilepsyPatient.getGbCode();
        String parentCode = mentalEpilepsyPatient.getParentCode();
        String organCode = mentalEpilepsyPatient.getOrganCode();
        if (StringUtil.isNotEmpty(gbCode)) {
            if (!criteria.contains("gbCode")) {
                criteria.add("gbCode", gbCode);
            }
        }
        if (StringUtil.isNotEmpty(parentCode)) {
            criteria.add("CENTER_CODE", parentCode);
        }
        criteria.add("SEARCHSTATION", organCode);
        return criteria;
    }


    //获取列表
    private List<MentalEpilepsyPatient> getAllList(Criteria criteria) {
        List<MentalEpilepsyPatient> mentalList = new ArrayList<>();
        if (criteria.contains("CENTER_CODE")) {
            criteria.remove("gbCode");
            criteria.remove("genreCode");
            mentalList = mentalEpilepsyPatientService.getCenterAndStation(criteria);
        } else {
            mentalList = mentalEpilepsyPatientService.countCenterAndStation(criteria);
        }
        return mentalList;
    }

    //统计
    private MentalEpilepsyPatient countAll(Criteria criteria, MentalEpilepsyPatient mentalEpilepsyPatient) {
        MentalEpilepsyPatient mentalTotal = new MentalEpilepsyPatient();
        if (criteria.contains("CENTER_CODE") && ObjectUtil.isNullOrEmpty(mentalEpilepsyPatient.getOrganCode())) {
            mentalTotal = mentalEpilepsyPatientService.countCenterAndStation(criteria).get(0);
        } else if (ObjectUtil.isNotEmpty(mentalEpilepsyPatient.getOrganCode())) {
            criteria.remove("genreCode");
            criteria.remove("gbCode");
            criteria.remove("CENTER_CODE");
            criteria.remove("SEARCHSTATION");
            criteria.add("ORGAN_CODE", mentalEpilepsyPatient.getOrganCode());
            List<MentalEpilepsyPatient> list = mentalEpilepsyPatientService.getCenterAndStation(criteria);
            if (ObjectUtil.isNotEmpty(list)) {
                mentalTotal = list.get(0);
            } else {
                mentalTotal = new MentalEpilepsyPatient();
            }
        } else {
            mentalTotal = mentalEpilepsyPatientService.countAll(criteria);
        }
        return mentalTotal;
    }
}
