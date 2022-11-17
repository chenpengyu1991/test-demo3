package com.founder.rhip.phsr.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.MaternalHealthManage;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;
import com.founder.rhip.ehr.service.woman.IDeliveryService;
import com.founder.rhip.ehr.service.woman.IPrenatalFollowupService;
import com.founder.rhip.ihm.service.IPostnatalFollowupService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by yuanzg on 2017/6/27.
 */
@Controller
@RequestMapping(value = "/maternalHealthManage")
public class MaternalHealthManageController extends BaseController {

    @Resource(name = "prenatalFollowupService")
    private IPrenatalFollowupService prenatalFollowupService;

    @Autowired
    private IDeliveryService deliveryService;

    @Autowired
    private IPostnatalFollowupService postnatalFollowupService;

    @Autowired
    private IOrganizationService organizationService;

	@Autowired
	private IOrganizationApp organizationApp;
    /**
     * 查询页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/search")
    public String search(HttpServletRequest request, ModelMap model) {
        model.addAttribute("searchDate", new Date());
        return "rhip.phsr.maternalHealthManage.search";
    }

    /**
     * 列表
     *
     * @param maternalHealthManage
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(MaternalHealthManage maternalHealthManage, HttpServletRequest request, ModelMap model) {
        //初始化查询条件
        int year = maternalHealthManage.getYear();
        int quarter = maternalHealthManage.getQuarter();
        if (maternalHealthManage.getCountType().equals("1")) {
            quarter = 0;
        }
        //列表集合
        List<MaternalHealthManage> maternalHealthManages = new ArrayList<>();
        //合计Bean
        MaternalHealthManage maternalAll = new MaternalHealthManage();
        //初始化查询条件
        Criteria criteria = initCriteria(maternalHealthManage, request);
        if (hasRole(RoleType.Z_GLY, request)) {
        	List<Organization> list = new ArrayList<Organization>();
        	list.add(getCurrentOrg(request));
            maternalHealthManages.addAll(getSingleOrgData(year, quarter, list));
            maternalAll = maternalHealthManages.get(0);
        } else if (hasRole(RoleType.ZX_GLY, request)) {
            List<Organization> organizationList = initOrg(criteria, request);
            maternalHealthManages = countZX(organizationList, request, year, quarter);
            maternalAll = countAll(maternalHealthManages);
        } else {
            if (criteria.contains("genreCode") || criteria.contains("gbCode")) {
                maternalHealthManages = countArea(criteria,request,year,quarter);
            } else {
                List<Organization> organizationList = initOrg(criteria, request);
                maternalHealthManages = countZX(organizationList, request, year, quarter);
            }
            maternalAll = countAll(maternalHealthManages);
        }
        model.addAttribute("maternalHealthManages", maternalHealthManages);
        model.addAttribute("total", maternalAll);
        return "rhip.phsr.maternalHealthManage.list";
    }
    
    /**
     * 按机构批量获取数据
     * @param year
     * @param quarter
     * @param organizationList
     * @return
     */
    private List<MaternalHealthManage> getSingleOrgData(Integer year, Integer quarter, List<Organization> organizationList) {
    	List<String> organCodeList = new ArrayList<String>();
    	Map<String, Organization> organMap = new HashMap<String, Organization>();
    	for(Organization organ : organizationList){
    		organMap.put(organ.getOrganCode(), organ);
    		organCodeList.add( organ.getOrganCode());
    	}
    	
    	List<MaternalHealthManage> manages = prenatalFollowupService.getMaternalHealthManage(year, quarter, organCodeList);
    	
    	//补全空信息
    	if(manages == null || manages.size() < organizationList.size()){
    		String codes = "";
    		for(MaternalHealthManage maternal : manages){
    			codes += "#" + maternal.getOrganCode() + "#";
    		}
    		for(Organization organ : organizationList){
    			if(codes.indexOf(organ.getOrganCode()) < 0 ){   			
    				MaternalHealthManage m = new MaternalHealthManage();
    				m.setOrganCode(organ.getOrganCode());
    				m.setGbCode(organ.getGbCode());
    				m.setOrganName(organ.getOrganName());
    				manages.add(m);
    			}
    		}
    	}
    	
    	for(MaternalHealthManage maternal : manages){
    		
    		Integer liveBirthsNum =maternal.getLiveBirthsNum();
            Integer thirtweekExaNum = maternal.getThirtweekExaNum();
            
            maternal.setPregnantThirtweekExaNum(thirtweekExaNum);
            maternal.setOrganName(organMap.get(maternal.getOrganCode()).getOrganName());
            maternal.setGbCode(organMap.get(maternal.getOrganCode()).getGbCode());
            
    		//早孕建册率
            BigDecimal pregnantThirtweekExaNum = new BigDecimal(thirtweekExaNum).multiply(new BigDecimal(100));
            if (liveBirthsNum != 0) {//BigDecimal.ROUND_HALF_UP  四舍五入
                BigDecimal earlyPregnancyRate = pregnantThirtweekExaNum.divide(new BigDecimal(liveBirthsNum), 1, BigDecimal.ROUND_HALF_UP);
                maternal.setEarlyPregnancyRate(earlyPregnancyRate);
            } else {
                maternal.setEarlyPregnancyRate(BigDecimal.valueOf(0.0));
            }
            
            //产后访视率
            if (liveBirthsNum != 0) {
                BigDecimal postpartumVisitRate = new BigDecimal(maternal.getLeavehosTwentyeightDay() * 100).divide(new BigDecimal(liveBirthsNum), 1, BigDecimal.ROUND_HALF_UP);
                maternal.setPostpartumVisitRate(postpartumVisitRate);
            } else {
                maternal.setPostpartumVisitRate(BigDecimal.valueOf(0.0));
            }
    	}
    	return manages;
    }

    /**
     * 获取单个机构的数据
     *
     * @param year
     * @param quarter
     * @param organization
     * @return
     */
    private MaternalHealthManage getSingleOrgData(HttpServletRequest request, int year, int quarter, Organization organization) {
        String curOrgCode = organization.getOrganCode();
        MaternalHealthManage maternal = new MaternalHealthManage();
        
        //该地该时间段内活产数
        Integer liveBirthsNum = deliveryService.getLiveBirthsNum(year, quarter, curOrgCode);
        maternal.setLiveBirthsNum(liveBirthsNum);
        //孕13周建册并第一次产前检查人数
        Integer ThirtweekExaNum = prenatalFollowupService.getPrenataFollNum(year, quarter, curOrgCode);
        maternal.setPregnantThirtweekExaNum(ThirtweekExaNum);
        //早孕建册率
        BigDecimal pregnantThirtweekExaNum = new BigDecimal(ThirtweekExaNum).multiply(new BigDecimal(100));
        if (liveBirthsNum != 0) {
            BigDecimal earlyPregnancyRate = pregnantThirtweekExaNum.divide(new BigDecimal(liveBirthsNum), 1, BigDecimal.ROUND_HALF_UP);
            maternal.setEarlyPregnancyRate(earlyPregnancyRate);
        } else {
            maternal.setEarlyPregnancyRate(BigDecimal.valueOf(0.0));
        }
        //产妇出院28天内接受产后访视
        List<PostnatalFollowup> postnatalFollowups = postnatalFollowupService.getPostnatalFollNum(year, quarter, curOrgCode);
        if (ObjectUtil.isNotEmpty(postnatalFollowups)) {
            for (PostnatalFollowup postnatalFollowup : postnatalFollowups) {
                List<DeliveryRecordInfo> deliveryRecordInfoList = deliveryService.getDeliveryOrder(new Criteria("idCard", postnatalFollowup.getIdCard()), new Order("outPatientDate", false));
                if (ObjectUtil.isNotEmpty(deliveryRecordInfoList)) {
                    if(ObjectUtil.isNotEmpty(postnatalFollowup.getVisitDate()) && ObjectUtil.isNotEmpty(deliveryRecordInfoList.get(0).getOutpatientdate())){
                    Long visitTime = postnatalFollowup.getVisitDate().getTime();
                    Long outPatientTime = deliveryRecordInfoList.get(0).getOutpatientdate().getTime();
                    if ((visitTime - outPatientTime) >= 0 && (visitTime - outPatientTime) / 24 * 60 * 60 * 1000 <= 28) {
                        maternal.setLeavehosTwentyeightDay(maternal.getLeavehosTwentyeightDay() + 1);
                    }
                    }
                }
            }
        }
        //产后访视率
        if (liveBirthsNum != 0) {
            BigDecimal postpartumVisitRate = new BigDecimal(maternal.getLeavehosTwentyeightDay() * 100).divide(new BigDecimal(liveBirthsNum), 1, BigDecimal.ROUND_HALF_UP);
            maternal.setPostpartumVisitRate(postpartumVisitRate);
        } else {
            maternal.setPostpartumVisitRate(BigDecimal.valueOf(0.0));
        }
        maternal.setOrganName(organization.getOrganName());
        maternal.setOrganCode(organization.getOrganCode());
        maternal.setGbCode(organization.getGbCode());
        return maternal;
    }

    /**
     * 计算合计
     *
     * @param maternalHealthManages
     * @return
     */
    private MaternalHealthManage countAll(List<MaternalHealthManage> maternalHealthManages) {
        MaternalHealthManage maternalAll = new MaternalHealthManage();
        for (MaternalHealthManage maternalHealthManage : maternalHealthManages) {
            //该地该时间段内活产数
            maternalAll.setLiveBirthsNum(maternalAll.getLiveBirthsNum() + maternalHealthManage.getLiveBirthsNum());
            //孕13周建册并第一次产前检查人数
            maternalAll.setPregnantThirtweekExaNum(maternalAll.getPregnantThirtweekExaNum() + maternalHealthManage.getPregnantThirtweekExaNum());
            //产妇出院28天内接受产后访视
            maternalAll.setLeavehosTwentyeightDay(maternalAll.getLeavehosTwentyeightDay() + maternalHealthManage.getLeavehosTwentyeightDay());
        }
        BigDecimal pregnantThirtweekExaNum = new BigDecimal(maternalAll.getPregnantThirtweekExaNum()).multiply(new BigDecimal(100));
        if (maternalAll.getLiveBirthsNum() != 0) {
            //早孕建册率 &&   产后访视率
            BigDecimal earlyPregnancyRate = pregnantThirtweekExaNum.divide(new BigDecimal(maternalAll.getLiveBirthsNum()), 1, BigDecimal.ROUND_HALF_UP);
            BigDecimal postpartumVisitRate = new BigDecimal(maternalAll.getLeavehosTwentyeightDay() * 100).divide(new BigDecimal(maternalAll.getLiveBirthsNum()), 1, BigDecimal.ROUND_HALF_UP);
            maternalAll.setEarlyPregnancyRate(earlyPregnancyRate);
            maternalAll.setPostpartumVisitRate(postpartumVisitRate);
        } else {
            maternalAll.setEarlyPregnancyRate(BigDecimal.valueOf(0.0));
            maternalAll.setPostpartumVisitRate(BigDecimal.valueOf(0.0));
        }
        return maternalAll;
    }

    /**
     * 初始化机构查询条件
     *
     * @param maternalHealthManage
     * @param request
     * @return
     */
    private Criteria initCriteria(MaternalHealthManage maternalHealthManage, HttpServletRequest request) {
        Criteria criteria = new Criteria();
        String organCode = maternalHealthManage.getOrganCode();
        String parentCode = maternalHealthManage.getParentCode();
        String gbCode = maternalHealthManage.getGbCode();
        if (hasRole(RoleType.ZX_GLY, request)||hasRole(RoleType.ZXJKDN, request)||hasRole(RoleType.ZJKDN, request)) {
            if (StringUtil.isNotEmpty(organCode)) {
                criteria.add("organCode", organCode);
            } else {
                criteria.add("parentCode", getCurrentOrg(request).getOrganCode());
            }
        } else if (hasRole(RoleType.QWGZX, request)) {
            if (StringUtil.isNullOrEmpty(parentCode) && StringUtil.isNullOrEmpty(organCode)) {
                criteria.add("gbCode", getCurrentOrg(request).getGbCode());
                criteria.add("genreCode", "B100");
            }
            if (StringUtil.isNotEmpty(parentCode) && StringUtil.isNullOrEmpty(organCode)) {
                criteria.add("parentCode", parentCode);
            }
            if (StringUtil.isNotEmpty(organCode)) {
                criteria.add("organCode", organCode);
            }
        }else {
            if (StringUtil.isNullOrEmpty(gbCode) && StringUtil.isNullOrEmpty(parentCode) && StringUtil.isNullOrEmpty(organCode)) {
                criteria.add("genreCode", "B100");
            }
            if(StringUtil.isNotEmpty(gbCode) && StringUtil.isNullOrEmpty(parentCode) && StringUtil.isNullOrEmpty(organCode)){
                criteria.add("gbCode", gbCode);
            }
            if (StringUtil.isNotEmpty(parentCode) && StringUtil.isNullOrEmpty(organCode)) {
                criteria.add("parentCode", parentCode);
            }
            if (StringUtil.isNotEmpty(organCode)) {
                criteria.add("organCode", organCode);
            }
        }
        return criteria;
    }

    /**
     * 机构
     *
     * @param criteria
     * @param request
     * @return
     */
    private List<Organization> initOrg(Criteria criteria, HttpServletRequest request) {
        Organization org = new Organization();
        if(hasRole(RoleType.ZX_GLY,request)){
            org = getCurrentOrg(request);
        }else {
            if (criteria.contains("parentCode")){
                org = organizationService.getOrganization(new Criteria("organCode",criteria.get("parentCode")));
            }
        }
        List<Organization> organizationList = new ArrayList<>();
        organizationList =organizationApp.queryOrganization(criteria);
        if (!criteria.contains("organCode")) {
            organizationList.add(org);//增加自身中心机构
        }
        return organizationList;
    }

    /**
     * 单个中心下每个机构的数据
     *
     * @param organizationList
     * @param request
     * @param year
     * @param quarter
     * @return
     */
    private List<MaternalHealthManage> countZX(List<Organization> organizationList, HttpServletRequest request, int year, int quarter) {
        List<MaternalHealthManage> maternalHealthManages = new ArrayList<>();
        
        maternalHealthManages =  getSingleOrgData(year, quarter, organizationList);
//        for (Organization organization : organizationList) {
//            MaternalHealthManage maternal = new MaternalHealthManage();
//            maternal = getSingleOrgData(request, year, quarter, organization);
//            maternalHealthManages.add(maternal);
//        }
        return maternalHealthManages;
    }

    /**
     * 单个区域下每个机构的数据
     * @param criteria
     * @param request
     * @param year
     * @param quarter
     * @return
     */
    private List<MaternalHealthManage> countArea(Criteria criteria, HttpServletRequest request, int year, int quarter) {
        List<MaternalHealthManage> maternalHealthManages = new ArrayList<>();
        List<Organization> organizationList = new ArrayList<>();
        criteria.add("genreCode","B100");
        criteria.add("status","1");
        List<Organization> orgZXList = organizationService.getOrganizations(criteria);
        //循环每个中心机构
        for (Organization org : orgZXList) {
            organizationList = organizationApp.queryOrganization(new Criteria("parentCode", org.getOrganCode()));
            organizationList.add(org);//增加中心机构
            List<MaternalHealthManage> ZXAllList = countZX(organizationList, request, year, quarter);
            MaternalHealthManage ZXAll = countAll(ZXAllList);
            ZXAll.setOrganName(org.getOrganName());
            ZXAll.setOrganCode(org.getOrganCode());
            ZXAll.setGbCode(org.getGbCode());
            maternalHealthManages.add(ZXAll);
        }
        return maternalHealthManages;
    }
}
