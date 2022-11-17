package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.clinic.PaitentbedStatus;
import com.founder.rhip.ehr.entity.portal.ChargeItem;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.InfoType;
import com.founder.rhip.ehr.entity.portal.ServiceInfo;
import com.founder.rhip.ehr.repository.clinic.IPatientbedStatusDao;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.Medicine;
import com.founder.rhip.mdm.service.IDiseaseService;
import com.founder.rhip.mdm.service.IMedicineService;
import com.founder.rhip.portal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/infoShow")
public class InfoShowController extends BaseController {

    @Resource(name = "lhinfoTypeService")
    private IInfoTypeService infoTypService;

    @Resource(name = "lhserviceInfoService")
    private IServiceInfoService serviceInfoService;

    @Resource(name = "lhhospitalInfoService")
    private IHospitalInfoService hospitalInfoService;

    @Resource(name = "organizationLinkService")
    private IOrganizationLinkService organizationLinkService;

    @Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;

    @Resource(name = "mdmMedicineService")
    private IMedicineService medicineService;

    @Resource(name = "chargeItemService")
    private IChargeItemService chargeItemService;

    @Resource(name = "mdmDiseaseService")
    private IDiseaseService diseaseService;

    @Autowired
    private IPatientbedStatusDao patientbedStatusDao;

    @Autowired
    private IHospitalInfoDao hospitalInfoDao;

    /***
     * 选择父类时候显示该父类下的所有内容的列表，
     * 如：点击“新闻中心”，跳转的页面左侧就显示
     * 可点击的“新闻动态”，“公告”和“通知”三个子类
     * @param request
     * @param model
     * @param indexPage
     * @return
     */
    @RequestMapping(value = "/infoList")
    public String infoList(HttpServletRequest request, ModelMap model, Integer indexPage) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        String id = request.getParameter("code");
        if (StringUtil.isNotEmpty(id)) {
            //通过get到的id获取父类别的名称
            InfoType infoType = infoTypService.get(new Criteria("id", id));
            //通过get到的id获取parentCode=id的子类别集合
            List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", id));
            //通过get到的id获取infoType=id的服务信息的集合
            PageList<ServiceInfo> serviceInfoPageList = serviceInfoService.getList(page, new Criteria("infoType", id).add("status", "1"));
            model.addAttribute("parentInfoType", infoType);
            model.addAttribute("serviceInfoList", serviceInfoPageList.getList());
            model.addAttribute("page", serviceInfoPageList.getPage());
            model.addAttribute("infoTypeList", infoTypeList);
            /*model.addAttribute("id", id);*/
            model.addAttribute("operation", "serviceInfoClick");
            model.addAttribute("parentCode", id);
            if ("103".equals(id)) {
                //增加国家基本药物目录查询
                model.addAttribute("mdmMedicineOp", "mdmMedicineOp");
                // add by yuanzg增加收费查询和床位查询
                model.addAttribute("chargeitem", "chargeitem");
                model.addAttribute("patientbed", "patientbed");
            }
        }
        return "lhportal.info.infoList";
    }

    /***
     * 单击“更多”按钮时显示的子类列表
     * @param request
     * @param model
     * @param indexPage
     * @return
     */
    @RequestMapping(value = "/infoChildList")
    public String infoChildList(HttpServletRequest request, ModelMap model, Integer indexPage) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        String id = request.getParameter("code");
        if (StringUtil.isNotEmpty(id)) {
            InfoType infoType = infoTypService.get(new Criteria("id", id));
            if (null != infoType.getParentCode()) {
                //获取子类别的id所对应的parentCode，通过父类别id=parentCode来获取该父类别的所有子类别集合
                List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", infoType.getParentCode()));
                //通过id获取detailType=id的服务信息的集合
                PageList<ServiceInfo> serviceInfoPageList = serviceInfoService.getList(page, new Criteria("detailType", id).add("status", "1"));
                InfoType parentInfoType = infoTypService.get(new Criteria("id", infoType.getParentCode()));//获取该子类别所对应的父类别
                model.addAttribute("serviceInfoList", serviceInfoPageList.getList());
                model.addAttribute("page", serviceInfoPageList.getPage());
                model.addAttribute("parentInfoType", parentInfoType);
                model.addAttribute("infoType", infoType);
                model.addAttribute("infoTypeList", infoTypeList);
                model.addAttribute("id", infoType.getId());
                model.addAttribute("operation", "serviceInfoClick");
                model.addAttribute("parentCode", infoType.getParentCode());
                if ("103".equals(infoType.getParentCode())) {//增加国家基本药物目录查询
                    model.addAttribute("mdmMedicineOp", "mdmMedicineOp");
                    // add by yuanzg增加收费查询和床位查询
                    model.addAttribute("chargeitem", "chargeitem");
                    model.addAttribute("patientbed", "patientbed");
                }
            }
        }
        return "lhportal.info.infoChildList";
    }

    @RequestMapping(value = "/infoDetail")
    public String infoDetail(HttpServletRequest request, ModelMap model) {
        ServiceInfo serviceInfo = serviceInfoService.get(Long.parseLong(request.getParameter("id")));
        Long times = serviceInfo.getTimes();
        times++;//浏览人数加1
        serviceInfo.setTimes(times);
        serviceInfoService.update(serviceInfo);
        String infoString = serviceInfo.getContents();
        //TODO csws 配置,正则配置
        if (null != infoString) {
            infoString = changeImageSrc(infoString);
        }
        serviceInfo.setContents(infoString);

        InfoType infoType = infoTypService.get(serviceInfo.getInfoType());
        InfoType detailType = infoTypService.get(serviceInfo.getDetailType());
        List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", serviceInfo.getInfoType()));
        model.addAttribute("parentInfoType", infoType);
        model.addAttribute("infoType", detailType);
        model.addAttribute("serviceInfo", serviceInfo);
        model.addAttribute("infoTypeList", infoTypeList);
        model.addAttribute("operation", "serviceInfoClick");
        return "lhportal.info.detailContent";
    }

    @RequestMapping(value = "/hospitalList")
    public String hospitalList(HttpServletRequest request, ModelMap model, Integer indexPage, String grade) {
        Page page = new Page(EHRConstants.PAGE_SIZE_MIDDLE, indexPage);
        String[] param;
        if (ObjectUtil.isNotEmpty(grade) && grade.trim().equals("1")) {//一级医院
            param = new String[]{"10", "12", "13", "14"};//10：一级；12：一级甲等；13：一级乙等；14：一级丙等
        } else if (ObjectUtil.isNotEmpty(grade) && grade.trim().equals("2")) {//二级医院
            param = new String[]{"20", "22", "23", "24"};//20：二级；22：二级甲等；23：二级乙等；24：二级丙等
        } else if (ObjectUtil.isNotEmpty(grade) && grade.trim().equals("3")) {//三级医院
            param = new String[]{"30", "31", "32", "33", "34"};////30：三级；31：三级特等；32：三级甲等；33：三级乙等；34：三级丙等
        } else if (ObjectUtil.isNotEmpty(grade) && grade.trim().equals("4")) {
            param = new String[]{"99"};//99：其他
        } else {//查询全部医院
            param = null;
        }
        hospitalPic(model);//医院照片
        if (ObjectUtil.isNotEmpty(grade)) {
            Criteria criteria = new Criteria();
            criteria.add("HOSPITAL_LEVEL", OP.IN, param);
            PageList<HospitalInfo> hospitalPageList = hospitalInfoService.getPortalLists(page, criteria);
            model.addAttribute("grade", grade);
            model.addAttribute("operation", "hospitalInfoClick");
            model.addAttribute("hospitalPageList", hospitalPageList.getList());
            model.addAttribute("page", hospitalPageList.getPage());
        } else {
            Criteria criteria = new Criteria();
            PageList<HospitalInfo> hospitalPageList = hospitalInfoService.getPortalLists(page, criteria);
            model.addAttribute("grade", grade);
            model.addAttribute("operation", "hospitalInfoClick");
            model.addAttribute("hospitalPageList", hospitalPageList.getList());
            model.addAttribute("page", hospitalPageList.getPage());
        }
        return "lhportal.info.hospitalList";
    }

    @RequestMapping(value = "/hospitalGroupList")
    public String hospitalGroupList(HttpServletRequest request, ModelMap model, Integer indexPage, String orgType) {
        Page page = new Page(EHRConstants.PAGE_SIZE_MIDDLE, indexPage);
        String[] param = {"A100", "B100", "C100"};
        hospitalPic(model);//医院照片
        if (StringUtil.isNotEmpty(orgType)) {
            Criteria criteria = new Criteria();
            criteria.add("ORGANIZATION_TYPE", orgType);
            PageList<HospitalInfo> hospitalPageList = hospitalInfoService.getPortalLists(page, criteria);
            model.addAttribute("orgType", orgType);
            model.addAttribute("operation", "yyjtInfoClick");
            model.addAttribute("hospitalPageList", hospitalPageList.getList());
            model.addAttribute("page", hospitalPageList.getPage());
        } else {
            Criteria criteria = new Criteria();
            criteria.add("ORGANIZATION_TYPE", OP.IN, param);
            PageList<HospitalInfo> hospitalPageList = hospitalInfoService.getPortalLists(page, criteria);
            model.addAttribute("orgType", orgType);
            model.addAttribute("operation", "yyjtInfoClick");
            model.addAttribute("hospitalPageList", hospitalPageList.getList());
            model.addAttribute("page", hospitalPageList.getPage());
        }

        return "lhportal.info.hospitalList";
    }

    @RequestMapping(value = "/hospitalInfo")
    public String hospitalInfo(HttpServletRequest request, ModelMap model) {
        HospitalInfo hospitalInfo = hospitalInfoService.get(Long.parseLong(request.getParameter("id")));
        String grade = request.getParameter("grade");
        String orgType = request.getParameter("orgType");
        hospitalPic(model);//医院照片
        if (StringUtil.isNotEmpty(grade)) {//医疗机构：一级，二级，三级医院
            switch (hospitalInfo.getHospitalLevel()) {
                case "99":
                    model.addAttribute("grade", "4");
                    break;
                case "10":
                case "12":
                case "13":
                case "14":
                    model.addAttribute("grade", "1");
                    break;
                case "20":
                case "22":
                case "23":
                case "24":
                    model.addAttribute("grade", "2");
                    break;
                case "30":
                case "31":
                case "32":
                case "33":
                case "34":
                    model.addAttribute("grade", "3");
                    break;
            }
            model.addAttribute("operation", "hospitalInfoClick");
        } else if (StringUtil.isNotEmpty(orgType)) {//医院集团：A1:六家医院， B1：九大中心
            switch (hospitalInfo.getOrganizationType()) {
                case "A100":
                    model.addAttribute("orgType", "A100");
                    break;
                case "B100":
                    model.addAttribute("orgType", "B100");
                    break;
            }
            model.addAttribute("operation", "yyjtInfoClick");
        } else {
            model.addAttribute("grade", grade);
        }

        if (ObjectUtil.isNotEmpty(hospitalInfo)) {
            String detail = hospitalInfo.getHospitalInfo();
            if (ObjectUtil.isNotEmpty(detail)) {
                detail = changeImageSrc(detail);
                hospitalInfo.setHospitalInfo(detail);
            }
            String guideForMedical = hospitalInfo.getGuideForMedical();
            if (ObjectUtil.isNotEmpty(guideForMedical)) {
                guideForMedical = changeImageSrc(guideForMedical);
                hospitalInfo.setGuideForMedical(guideForMedical);
            }
            String microGuidance = hospitalInfo.getMicroGuidance();
            if (ObjectUtil.isNotEmpty(microGuidance)) {
                microGuidance = changeImageSrc(microGuidance);
                hospitalInfo.setMicroGuidance(microGuidance);
            }
        }

        model.addAttribute("hospitalInfo", hospitalInfo);

        return "lhportal.info.hospitalInfo";
    }

    //医院照片
    public void hospitalPic(ModelMap model) {
        List<HospitalInfo> hosPicList = hospitalInfoService.get(new Criteria("status", "1").add("is_delete", "0"));
        List<UploadInfoRecord> hospicuploadInfoRecords = new ArrayList<UploadInfoRecord>();
        for (int i = 0; i < hosPicList.size(); i++) {
            Long id = hosPicList.get(i).getId();
            List<UploadInfoRecord> uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", "lhHospitalPic"));
            hospicuploadInfoRecords.addAll(uploadInfoRecord);
        }
        model.addAttribute("hosPicattches", hospicuploadInfoRecords);
    }

    /**
     * 弹出体重自测对话框
     *
     * @return
     */
    @RequestMapping(value = "/bmi")
    public String showBMI(HttpServletRequest request) {
        return "lhportal.info.bmi";
    }

    @RequestMapping("/medicineSearch")
    public String search(ModelMap model) {
        List<String> categoryOne = medicineService.getCategoryOneDict(null);
        model.addAttribute("categoryOne", categoryOne);
        /*List<String> dosage = medicineService.getDosageDict(null);
        model.addAttribute("dosageList", dosage);
		model.addAttribute("criMedicine", new Medicine());*/
        //获取子类别的id所对应的parentCode，通过父类别id=parentCode来获取该父类别的所有子类别集合
        List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", "103"));
        model.addAttribute("infoTypeList", infoTypeList);
        model.addAttribute("operation", "serviceInfoClick");
        model.addAttribute("mdmMedicineOp", "mdmMedicineOp");
        model.addAttribute("chargeitem", "chargeitem");
        model.addAttribute("patientbed", "patientbed");
        return "lhportal.info.medicineSearch";
    }

    /**
     * 收费项目查询框
     *
     * @param model
     * @return
     */
    @RequestMapping("/medicineRelevantSearch")
    public String medicineRelevantSearch(ModelMap model) {
        List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", "103"));
        model.addAttribute("infoTypeList", infoTypeList);
        model.addAttribute("operation", "serviceInfoClick");
        model.addAttribute("chargeitem", "chargeitem");
        model.addAttribute("mdmMedicineOp", "mdmMedicineOp");
        model.addAttribute("patientbed", "patientbed");
        return "lhportal.info.medicineRelevantSearch";
    }

    /**
     * 床位查询
     *
     * @param model
     * @return
     */
    @RequestMapping("/patientbedSearch")
    public String patientbedSearch(ModelMap model) {
        List<InfoType> infoTypeList = infoTypService.getList(new Criteria("parentCode", "103"));
        model.addAttribute("infoTypeList", infoTypeList);
        model.addAttribute("operation", "serviceInfoClick");
        model.addAttribute("patientbed", "patientbed");
        model.addAttribute("chargeitem", "chargeitem");
        model.addAttribute("mdmMedicineOp", "mdmMedicineOp");
        return "lhportal.info.patientbedSearch";
    }

    @RequestMapping("/medicineList")
    public String medicineList(HttpServletRequest request, ModelMap model, Medicine criMedicine, int indexPage) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        Criteria criteria = initCriteria(criMedicine);
        PageList<Medicine> pageList = medicineService.getMedicines(page, criteria);
        model.addAttribute("medicineList", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        model.addAttribute("indexPage", indexPage);
        return "lhportal.info.medicineList";
    }

    /**
     * 医保药品、收费项目、诊断目录查询列表
     *
     * @param request
     * @param model
     * @param chargeItem 医保收费实体
     * @param disease    诊断实体
     * @param indexPage  页码
     * @return
     */
    @RequestMapping("/medicineRelevantList")
    public String medicineRelevantList(HttpServletRequest request, ModelMap model, ChargeItem chargeItem, Disease disease, int indexPage) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        String type = chargeItem.getType();
        //当选项为诊断目录时的查询
        if (type.equals("3")) {
            Criteria criteria = new Criteria();
            String diseaseName = chargeItem.getItemName();
            if (StringUtil.isNotEmpty(diseaseName)) {
                criteria.add("DISEASE_NAME", OP.LIKE, diseaseName);
            }
            PageList<Disease> diseasePageList = diseaseService.getDiseases(page, criteria);
            model.addAttribute("diseaseList", diseasePageList.getList());
            model.addAttribute("page", diseasePageList.getPage());
            model.addAttribute("indexPage", indexPage);
            return "lhportal.info.diseaseList";
            //当选项为医保药品和收费项目时的查询
        } else {
            Criteria criteria = initChargeCriteria(chargeItem);
            PageList<ChargeItem> chargeItemPageList = chargeItemService.getChargeItemPageList(page, criteria);
            model.addAttribute("chargeItemList", chargeItemPageList.getList());
            model.addAttribute("page", chargeItemPageList.getPage());
            model.addAttribute("indexPage", indexPage);
            return "lhportal.info.medicineRelevantList";
        }
    }

    /**
     * 床位查询list
     *
     * @param model
     * @param paitentbedStatus
     * @param indexPage
     * @return
     */
    @RequestMapping("/patientbedList")
    public String patientbedList(ModelMap model, PaitentbedStatus paitentbedStatus, int indexPage) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        Criteria criteria = new Criteria();
        String depName = paitentbedStatus.getDepName();
        if (StringUtil.isNotEmpty(depName)) {
            criteria.add("DEP_NAME", OP.LIKE, depName);
        }
        PageList<PaitentbedStatus> paitentbedStatusesList = patientbedStatusDao.getPageList(page, criteria);
        List<PaitentbedStatus> paitentbedStatusList = paitentbedStatusesList.getList();
        //医院名称 code
        List<HospitalInfo> hospitalInfos = hospitalInfoDao.getList(new Criteria("IS_DELETE", "0"));
        Map<String, String> hosNameMap = new HashMap<String, String>();
        for (HospitalInfo hospitalInfo : hospitalInfos) {
            hosNameMap.put(hospitalInfo.getHospitalNo(), hospitalInfo.getHospitalName());
        }
        for (PaitentbedStatus paitentbedStatus1 : paitentbedStatusList) {
            String hospitalNo = paitentbedStatus1.getHospitalCode();
            String hospitalName = hosNameMap.get(hospitalNo);
            paitentbedStatus1.setHospitalName(hospitalName);
        }
        model.addAttribute("patientbedList", paitentbedStatusList);
        model.addAttribute("page", paitentbedStatusesList.getPage());
        model.addAttribute("indexPage", indexPage);
        return "lhportal.info.patientbedList";
    }


    /**
     * 初始化Criteria
     *
     * @param chargeItem 医保收费实体
     * @return
     */
    private Criteria initChargeCriteria(ChargeItem chargeItem) {
        Criteria criteria = new Criteria();
        String type = chargeItem.getType();
        //默认TYPE字段值为1
        if (StringUtil.isNotEmpty(type)) {
            criteria.add("TYPE", type);
        } else {
            criteria.add("TYPE", "1");
        }
        String itemName = chargeItem.getItemName();
        if (StringUtil.isNotEmpty(itemName)) {
            criteria.add("ITEM_NAME", OP.LIKE, itemName);
        }
        return criteria;
    }

    private Criteria initCriteria(Medicine criMedicine) {
        Criteria criteria = new Criteria();
        String categoryNameOne = criMedicine.getCategoryNameOne();
        if (StringUtil.isNotEmpty(categoryNameOne)) {
            criteria.add("categoryNameOne", categoryNameOne);
        }
        String categoryNameTwo = criMedicine.getCategoryNameTwo();
        if (StringUtil.isNotEmpty(categoryNameTwo)) {
            criteria.add("categoryNameTwo", categoryNameTwo);
        }
        String categoryNameThree = criMedicine.getCategoryNameThree();
        if (StringUtil.isNotEmpty(categoryNameThree)) {
            criteria.add("categoryNameThree", categoryNameThree);
        }
        String medicineCode = criMedicine.getMedicineCode();
        if (StringUtil.isNotEmpty(medicineCode)) {
            criteria.add("medicineCode", OP.LIKE, medicineCode);
        }
        String commonName = criMedicine.getCommonName();
        if (StringUtil.isNotEmpty(commonName)) {
            criteria.add("commonName", OP.LIKE, commonName);
        }
        String productName = criMedicine.getProductName();
        if (StringUtil.isNotEmpty(productName)) {
            criteria.add("productName", OP.LIKE, productName);
        }
        String levelCode = criMedicine.getLevelCode();
        if (StringUtil.isNotEmpty(levelCode)) {
            criteria.add("levelCode", levelCode);
        }
        String dosage = criMedicine.getDosage();
        if (StringUtil.isNotEmpty(dosage)) {
            criteria.add("dosage", dosage);
        }
        String manufactory = criMedicine.getManufactory();
        if (StringUtil.isNotEmpty(manufactory)) {
            criteria.add("manufactory", OP.LIKE, manufactory);
        }
        return criteria;
    }

}
