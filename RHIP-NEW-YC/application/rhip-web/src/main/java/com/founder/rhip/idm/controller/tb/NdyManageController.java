package com.founder.rhip.idm.controller.tb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.DrugCard;
import com.founder.rhip.ehr.entity.control.idm.special.ListSd;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.service.ITbService;

/**
 * 耐多药管理
 */
@Controller
@RequestMapping("/idm/tb/ndy")
public class NdyManageController extends BaseController {
    @Resource(name = "tbService")
    private ITbService tbService;

    @RequestMapping("/confirm/search")
    public String confirmSearch(String type, HttpServletRequest request, ModelMap model) {
        request.getSession().setAttribute("typeTb", type);
        return "rhip.idm.ndy.confirm.search";
    }

    @RequestMapping("/fuyao/search")
    public String fuyaoSearch(String type, HttpServletRequest request, ModelMap model) {
        request.getSession().setAttribute("typeTb", type);
        return "rhip.idm.ndy.fuyao.search";
    }
    /**
     * 耐多药确诊列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String searchManagementList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
        String fuyao = request.getParameter("fuyao");
        String urlStr = null;
        if("1".equals(fuyao))
            urlStr = "rhip.idm.ndy.fuyao.list";
        else
            urlStr = "rhip.idm.ndy.confirm.list";
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria criteria = form.getCriteria();

        criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_TREATMENT.getValue()});
		/*获取已接受的患者*/
        criteria.add("status.SPECIAL_STATUS", TbStatus.ACCEPT.getValue());
        getRoleCriteria(criteria, request);
        PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);

        model.addAttribute("standardizations", plist.getList());
        model.addAttribute("page", plist.getPage());
        return urlStr;
    }

    @RequestMapping("/initNdyList")
    public String initNdyList(String singleId, String patientName, Integer logoff, HttpServletRequest request, ModelMap model) {
        Criteria criteria =new Criteria("IDM_ID",singleId);
        List<DrugCard> listNdy = tbService.getDrugCardList(criteria);
        model.put("listNdy", listNdy);

        model.put("singleId", singleId);
        model.put("patientName", patientName);
        model.put("logoff", logoff);
        return "rhip.idm.ndy.ndyList";
    }

    @RequestMapping("/initNdyDrug")
    public String initNdyDrug(String singleId, String patientName, Integer logoff, HttpServletRequest request, ModelMap model) {
        String drugCardId = request.getParameter("drugCardId");
        Criteria criteria = new Criteria("IDM_ID",singleId);
        //服药卡ID
        criteria.add("DRUG_CARD_ID", drugCardId);
        //耐多药标记
        criteria.add("FLAG", "1");

        List<ListSd> listSds = null;
        if(drugCardId==null)
            listSds = new ArrayList<ListSd>();
        else
            listSds = tbService.getSdList(criteria);
        if(null != listSds && listSds.size()>0){
            StringBuffer sb = new StringBuffer();
            for(ListSd listSd : listSds){
                sb.append(listSd.getMonthNo().toString() + "-" + listSd.getDayNo().toString());
                sb.append(":");
                String strSb = listSd.getDrudType();
                //简要病程
                if(listSd.getDayNo()==18){
                    strSb=listSd.getMethodDetail();
                }
                sb.append(strSb);
                sb.append(",");
            }
            String initJson = sb.toString();
            initJson = initJson.substring(0, initJson.length()-1);
            model.addAttribute("initJson", initJson);
        }

        User user = getCurrentUser(request);
        Criteria drugCardC =new Criteria("IDM_ID",singleId);
        //服药卡ID
        drugCardC.add("ID", drugCardId);
        DrugCard drugCard = new DrugCard();
        if(drugCardId!=null) {
            drugCard =tbService.getDrugCard(drugCardC);
        }

        GeneralCondition generalCondition = tbService.findGeneralCondition(Long.valueOf(singleId));
        if(ObjectUtil.isNotEmpty(generalCondition.getIdcard()) && ObjectUtil.isNullOrEmpty(generalCondition.getAge())) {
            int age = IDCardUtil.getAgeByIdCard(generalCondition.getIdcard());
            if(ObjectUtil.isNotEmpty(age)) {
                drugCard.setAge(BigDecimal.valueOf(Long.valueOf(age)));
            }
        } else if (ObjectUtil.isNotEmpty(generalCondition.getIdcard()) && ObjectUtil.isNotEmpty(generalCondition.getAge())) {
            drugCard.setAge(BigDecimal.valueOf(Long.valueOf(generalCondition.getAge())));
        }
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        model.put("currentLoginInfo", currentLoginInfo);
        model.put("drugCard", drugCard);
        model.put("singleId", singleId);
        model.put("patientName", patientName);
        model.put("drugDoctor", user.getUserCode());
        model.put("logoff", logoff);
        return "rhip.idm.ndy.ndyAdd";
    }

    /**
     * 确认患者为耐多药患者
     *
     * @param id
     *            IDM
     * @return
     */
    @RequestMapping("/confirm/{id}")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
        int ret = 0;
        createOperationLog(request, RhipModuleName.IDM, "耐多药患者确认", OperationName.UPDATE);
        IdmStatusInfo entity = new IdmStatusInfo();
        entity.setId(id);
        entity.setNdyFlag("1");
        ret = tbService.confirmOrCancelNdy(entity);
        Map<String, Object> map = new HashMap<>();
        map.put("result", ret > 0 ? true : false);
        map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
        return map;
    }

    /**
     * 获取查询结核病 治疗管理卡的权限条件
     * @param criteria
     * @param request
     * @return
     */
    private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
        Criteria temp = new Criteria();
        String orgCode = getCurrentOrg(request).getOrganCode();
        //BUG0095656
        if (!hasRole(RoleType.JKJHB, request) && !hasRole(RoleType.DDCRBYY, request)) {
            temp.add("status.LAST_UNIT", orgCode).add("status.special_status",
                    OP.IN, new Integer[]{TbStatus.REASSIGN.getValue(), TbStatus.ACCEPT.getValue()})
                    .add(LOP.OR, new Criteria("status.CURRENT_UNIT", orgCode));
            criteria.add(temp);
        }
    }
}
