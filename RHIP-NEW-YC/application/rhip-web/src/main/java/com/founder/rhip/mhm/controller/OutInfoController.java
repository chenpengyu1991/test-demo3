package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugRecord;
import com.founder.rhip.ehr.entity.management.mhm.MhmInhospital;
import com.founder.rhip.ehr.repository.management.mhm.IMhmInhospitalDao;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmDrugService;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/mhm/outInfo")
public class OutInfoController extends MhmBaseController {

    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;

    @Resource(name = "mhmDrugService")
    private IMhmDrugService mhmDrugService;

    @Resource(name = "mhmInhospitalDao")
    private IMhmInhospitalDao mhmInhospitalDao;

	private final static String CONTROLLER_NAME = "精神卫生-出院信息";	
    /**
     * 进入出院信息画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/init")
    public String initOutInfo(String statusId, HttpServletRequest request, ModelMap model) {
        int currentPage = Integer.valueOf(1);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("event_type", MhmEvents.I_DISCHARGED.getValue());
        ca.add("statusId", statusId);
        PageList<MhmInhospital> plist = mhmManagementService.getDisChargeList(ca, page);
        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.mgnt.outInfo";
    }

    @RequestMapping("/inPatientRecords")
    public String inPatientRecords(Long statusId, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.mhm.mgnt.outInfoList";

        Criteria ca = new Criteria("event_type", MhmEvents.I_DISCHARGED.getValue());
        ca.add("statusId", statusId);
        Page page = super.getPage(request,  pageIndex);
        Order od = new Order("DISCHARGE_DATE",false);//正序
        PageList<MhmInhospital> plist = mhmManagementService.getDisChargeList(ca, page);

        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());

        return url;
    }

    /**
     * 进入出院信息画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initDetail")
    public String initDetail(Long statusId, Long eventId, HttpServletRequest request, ModelMap model) {
        ManagementDto managementDto = mhmManagementService.getMulManagement(statusId, eventId, null);
        model.addAttribute("managementDto", managementDto);
        return "rhip.mhm.mgnt.outInfoDetail";
    }

    /**
     * 弹出用药明细画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/popMedication")
    public String popMedication(String trData, String rowIndex, String type, String refTable, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<MhmDrugRecord> drugRecords = (List<MhmDrugRecord>) json2Obj(trData, MhmDrugRecord.class);
            model.put("drugRecord", drugRecords.get(0));
            model.put("rowIndex", rowIndex);
        }
        List<MhmDrug> mhmDrugs = mhmDrugService.findDrugList(null);
        model.put("mhmDrugs", mhmDrugs);

        model.put("refTable", refTable);
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.mhm.mgnt.outInfo.medication";
    }

    @SuppressWarnings("unchecked")
	@RequestMapping("/save")
    public String saveMgnt(ManagementDto dto, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = false;
        if (ObjectUtil.isNotEmpty(dto)) {
            dto.setCurrentUser(getCurrentUser(request));

            PersonInfo personInfo = dto.getPersonInfo();
            personInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
            personInfo.setUpdateName(getCurrentUser(request).getId().toString());

            //住院用药
            String inMedicationStr = dto.getInMedication();
            List<MhmDrugRecord> inMedicationRecords = (List<MhmDrugRecord>) json2Obj(inMedicationStr, MhmDrugRecord.class);
            for(MhmDrugRecord mhmDrugRecord : inMedicationRecords){
                mhmDrugRecord.setFillOrganCode(getCurrentOrg(request).getOrganCode());
                mhmDrugRecord.setFillDoctorId(getCurrentUser(request).getId().toString());
                mhmDrugRecord.setFillDate(new Date());
            }
            dto.setInMedicationRecords(inMedicationRecords);
            //下一步治疗用药
            String nextMedicationStr = dto.getNextMedication();
            List<MhmDrugRecord> nextMedicationRecords = (List<MhmDrugRecord>) json2Obj(nextMedicationStr, MhmDrugRecord.class);
            for(MhmDrugRecord mhmDrugRecord : nextMedicationRecords){
                mhmDrugRecord.setFillOrganCode(getCurrentOrg(request).getOrganCode());
                mhmDrugRecord.setFillDoctorId(getCurrentUser(request).getId().toString());
                mhmDrugRecord.setFillDate(new Date());
            }
            dto.setNextMedicationRecords(nextMedicationRecords);
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = mhmManagementService.getPersonId(dto.getStatusId());
        	dto.setPersonId(personId);            
        	updatePersonInfo(dto.getPersonInfo(),request);
            result = mhmManagementService.saveMhmManagement(dto, MhmEvents.I_DISCHARGED, null);
            OperationName  opName = ObjectUtil.isNullOrEmpty(dto.getMhmBasicsInfo().getId())?OperationName.ADD:OperationName.UPDATE;
        	record(request, opName);
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
