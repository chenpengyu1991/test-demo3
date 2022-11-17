package com.founder.rhip.ehr.controller.ehrbrowser;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.IMacHealthService;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 妇幼保健
 * @author liuk
 *
 */
@Controller
@RequestMapping("/ehrbrowser/health")
public class BrwHealthController extends BaseController {

	@Autowired
	private IStaffService staffService;

	@Resource
	private IBrwHealthService brwHealthService;

	@Autowired
	private IMacHealthService macHealthService;

	@Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

    @Resource(name = "personalRecordService")
    private IPersonalRecordService personalRecordService;

	@Resource
	private IChildHealthExamineService childHealthExamineService;

	@RequestMapping()
	public String index(String personId, ModelMap model){
		PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
		model.addAttribute("personBasicInfoDto", personBasicInfoDto);

		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "cPhysicalExamAge"};
		List<ChildHealthExamination> childHealthExaminations = brwHealthService.getChildHealthAge(criteria, properties);
		model.addAttribute("childHealthExaminations", childHealthExaminations);

		PersonInfo personInfo=personalRecordService.getPersonRecord(new Criteria("id",personId),"name","birthday","gender","IDCARD");
		model.addAttribute("personInfo", personInfo);

		//List<BirthCertificate> chBirthCertificates = brwHealthService.getChBirthCertificateList();
		//model.addAttribute("chBirthCeificates", chBirthCertificates);
		criteria = new Criteria("MQSFZHM", personInfo.getIdcard());
		List<ChEtbjCsyxzm>  chEtbjCsyxzm= macHealthService.getChEtbjCsyxzms(criteria);
		model.addAttribute("chEtbjCsyxzm",chEtbjCsyxzm);
		return "rhip.ehr.browser.health";
	}
	
	/**
	 * 产前随访
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/followup")
	public String followup(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		List<PrenatalFollowup> whPrenatalFollowups = brwHealthService.getWhPrenatalFollowupList(criteria);
		if(null == whPrenatalFollowups || whPrenatalFollowups.size() == 0){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("whPrenatalFollowups", whPrenatalFollowups);
		return "rhip.ehr.browser.healthfollowupList";
	}

	/**
	 * 产前随访详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/followupDetail")
	public String followupDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PrenatalFollowup whPrenatalFollowup = brwHealthService.getWhPrenatalFollowup(criteria);
		if(ObjectUtil.isNullOrEmpty(whPrenatalFollowup)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("whPrenatalFollowup", whPrenatalFollowup);
		return "rhip.ehr.browser.healthfollowupDetail";
	}

	/**
	 * 本人出生证明
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/ownBornDetail")
	public String getOwnBornDetail(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		BirthCertificate birthCertificate = brwHealthService.getChBirthCertificate(criteria);
		if(ObjectUtil.isNullOrEmpty(birthCertificate)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("chBirthCertificate", birthCertificate);
		
		if(ObjectUtil.isNotEmpty(birthCertificate)){
			if(ObjectUtil.isNotEmpty(birthCertificate.getMotherIdcard())){
				model.addAttribute("midCard", birthCertificate.getMotherIdcard().toCharArray());
			}
			if(ObjectUtil.isNotEmpty(birthCertificate.getFatherIdcard())){
				model.addAttribute("fidCard", birthCertificate.getFatherIdcard().toCharArray());
			}
		}
		return "rhip.ehr.browser.newBornDetail";
	}

	@RequestMapping("/newBorn")
	public String newBorn(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", personId);
		PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
		if(null == personInfo){
			return "rhip.ehr.browser.error";
		}
		criteria = new Criteria("MOTHER_IDCARD", personInfo.getIdcard());
		List<BirthCertificate> chBirthCertificates = brwHealthService.getChBirthCertificateList(criteria);
		if(null == chBirthCertificates || chBirthCertificates.size() == 0){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("chBirthCertificates", chBirthCertificates);
		return "rhip.ehr.browser.newBornList";
	}

	/**
	 * 出生证明详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/newBornDetail/{id}")
	public String newBornDetail(@PathVariable("id") long id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		/*PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
		if(null == personInfo){
			return "rhip.ehr.browser.error";
		}
		criteria = new Criteria("MOTHER_IDCARD", personInfo.getIdcard());*/
		BirthCertificate chBirthCertificate = brwHealthService.getChBirthCertificate(criteria);
		if(ObjectUtil.isNullOrEmpty(chBirthCertificate)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("chBirthCertificate", chBirthCertificate);
		
		if(ObjectUtil.isNotEmpty(chBirthCertificate)){
			if(ObjectUtil.isNotEmpty(chBirthCertificate.getMotherIdcard())){
				model.addAttribute("midCard", chBirthCertificate.getMotherIdcard().toCharArray());
			}
			if(ObjectUtil.isNotEmpty(chBirthCertificate.getFatherIdcard())){
				model.addAttribute("fidCard", chBirthCertificate.getFatherIdcard().toCharArray());
			}
		}
		return "rhip.ehr.browser.newBornDetail";
	}
	
	
    /**
     * 子女出生证明
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/newBornDetail")
    public String newBornDetail(String personId, ModelMap model) {
		Criteria criteria = new Criteria();
		criteria.add("id", personId);
		PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
		if(null == personInfo){
			return "rhip.ehr.browser.error";
		}
		criteria = new Criteria("MOTHER_IDCARD", personInfo.getIdcard());
		List<BirthCertificate> chBirthCertificates = brwHealthService.getChBirthCertificateList(criteria);
		if(null == chBirthCertificates || chBirthCertificates.size() == 0){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("chBirthCertificates", chBirthCertificates);
		return "rhip.ehr.browser.newBornList";
	}

	/**
	 * 出生缺陷
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/bornDefect")
	public String bornDefect(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		BirthDefectMonitor birthDefectMonitor = brwHealthService.getBirthDefectMonitor(criteria);
		if(ObjectUtil.isNullOrEmpty(birthDefectMonitor)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("birthDefectMonitor", birthDefectMonitor);
		return "rhip.ehr.browser.birthDefect";
	}


	/**
	 * 产后42天健康检查信息
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/postpartumDaysHealthInfo")
	public String postpartumDaysHealthInfo(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		PostpartumDaysHealthInfo postpartumDaysHealthInfo = brwHealthService.getPostpartumDaysHealthInfo(criteria);
		if(ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfo)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("postpartumDaysHealthInfo", postpartumDaysHealthInfo);
		return "rhip.ehr.browser.postpartumDays";
	}

	/**
	 * 产后访视列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/postnatalFollowupList")
	public String getPostnatalFollowups(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "visitDate"};
		List<PostnatalFollowup> postnatalFollowups = brwHealthService.getPostnatalFollowups(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(postnatalFollowups)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("postnatalFollowups", postnatalFollowups);
		return "rhip.ehr.browser.postnatalFollowupList";
	}

	/**
	 * 产后访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/postnatalFollowup")
	public String getPostnatalFollowup(String id, ModelMap model,String type){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PostnatalFollowup postnatalFollowup = brwHealthService.getPostnatalFollowup(criteria);
		if(ObjectUtil.isNotEmpty(postnatalFollowup)){
		String doctorNo = postnatalFollowup.getSupervisionDoctor();
//		boolean result=doctorNo.matches("[0-9]+");
//		if(result){
//		Criteria criteriaDoc = new Criteria();
//		criteriaDoc.add("staffCode",doctorNo);
//		Staff staff = staffService.getStaff(criteriaDoc);
//		postnatalFollowup.setSupervisionDoctor(staff.getName());
//		}
		model.addAttribute("postnatalFollowup", postnatalFollowup);
		model.addAttribute("isShowBackBtn", true);
		}
		if("dialogView".equals(type)){
			return "rhip.ehr.browser.postnatalFollowup1";
		}
		return "rhip.ehr.browser.postnatalFollowup";
	}

	/**
	 * 产后产妇访视（参考新版健康档案浏览器）
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/postnatalInterviewList")
	public String getPostnatalInterviews(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		Order order = new Order("VISIT_DATE DESC");
		String[] properties = {"id","visitDate"};
		List<PostnatalFollowup> postnatalInterviews = macHealthService.getPostnatalInterviews(criteria, order, properties);
		if(ObjectUtil.isNullOrEmpty(postnatalInterviews)){
			model.addAttribute("message", "暂无产后访视记录");
			return "rhip.ehr.browser.norecord";
		}
		Map<String,List<PostnatalFollowup>> gourpPostnatlInterviewsMap = new HashMap<>();
		formateRecordList(postnatalInterviews, "", "getVisitDate",gourpPostnatlInterviewsMap);
		model.addAttribute("postnatalInterviews", postnatalInterviews);
		model.addAttribute("gourpPostnatlInterviewsMap", gourpPostnatlInterviewsMap);
		return "rhip.ehr.browser.postnatalInterviewList";
	}

	/**
	 * 产后产妇访视详细（参考新版健康档案浏览器）
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/postnatalInterview")
	public String getPostnatalInterview(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PostnatalFollowup postnatalInterview = macHealthService.getPostnatalInterview(criteria);
		if(ObjectUtil.isNotEmpty(postnatalInterview)){
			model.addAttribute("postnatalInterview", postnatalInterview);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.postnatalInterview";
	}

	/**
	 * 新生儿访视
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/newBornInterviewList")
	public String getNewBornInterviews(String personId, String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		/*String[] properties = {"id", "xm","bcfsrq"};
		Order order = new Order("CSRQ DESC, BCFSRQ DESC");
		newBornInterviews = macHealthService.getNewBornInterviews(criteria, order, properties);*/
		List<NeonatalFamilyVisit> neonatalFamilyVisitList = wchSearchService.getNeonatalVisitList(criteria, new Order("VISIT_DATE", false));
		if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisitList)){
			model.addAttribute("message", "暂无新生儿访视信息");
			return "rhip.ehr.browser.norecord";
		}
		Map<String,List<NeonatalFamilyVisit>> neonatalFamilyVisitListMap = new LinkedHashMap<>();
		ListUtil.listGroupMap(neonatalFamilyVisitList, neonatalFamilyVisitListMap, NeonatalFamilyVisit.class,"getNeonatusName");
		model.addAttribute("gourpNewBornInterviewsMap", neonatalFamilyVisitListMap);
		return "rhip.ehr.browser.newBornInterviewList";
	}

	/**
	 * 新生儿访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/newBornInterview")
	public String getNewBornInterview(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		NeonatalFamilyVisit newBornInterview = wchSearchService.getNeonatalVisit(criteria);
		if(ObjectUtil.isNotEmpty(newBornInterview)){
			model.addAttribute("newBornInterview", newBornInterview);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.newBornInterview";
	}

	/**
	 * 1-8月龄儿童健康检查列表
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationOneList")
	public String getChildHealthExaminationOnes(String personId, String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("PERSON_ID", personId);
		criteria.add("C_PHYSICAL_EXAM_AGE", OP.IN, new String[]{"满月","3月龄","6月龄","8月龄"});
		List<ChildHealthExamination> childHealthExaminationOnes = childHealthExamineService.getChildHealthExamList(criteria, new Order("VISIT_DATE", false));
		if(ObjectUtil.isNullOrEmpty(childHealthExaminationOnes)){
			model.addAttribute("message", "暂无1-8月龄健康检查信息");
			return "rhip.ehr.browser.norecord";
		}
		Map<String,List<ChildHealthExamination>> gourpChildHealthExaminationOnesMap = new LinkedHashMap<>();
		ListUtil.listGroupMap(childHealthExaminationOnes, gourpChildHealthExaminationOnesMap, ChildHealthExamination.class,"getName");
		model.addAttribute("gourpChildHealthExaminationOnesMap", gourpChildHealthExaminationOnesMap);
		return "rhip.ehr.browser.childHealthExaminationOneList";
	}

	/**
	 * 1-8月龄儿童健康检查详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationOne")
	public String getChildHealthExaminationOne(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ChildHealthExamination childHealthExaminationOne = childHealthExamineService.getChildHealthExam(criteria);
		if(ObjectUtil.isNotEmpty(childHealthExaminationOne)){
			model.addAttribute("childHealthExaminationOne", childHealthExaminationOne);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.childHealthExaminationOne";
	}

	/**
	 * 12-30月龄儿童健康检查记录列表
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationTwoList")
	public String getChildHealthExaminationTwos(String personId, String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("PERSON_ID", personId);
		criteria.add("C_PHYSICAL_EXAM_AGE", OP.IN, new String[]{"12月龄","18月龄","24月龄","30月龄"});
		List<ChildHealthExamination> childHealthExaminationTwos = childHealthExamineService.getChildHealthExamList(criteria, new Order("VISIT_DATE", false));
		if(ObjectUtil.isNullOrEmpty(childHealthExaminationTwos)){
			model.addAttribute("message", "暂无12-30月龄健康检查信息");
			return "rhip.ehr.browser.norecord";
		}
		Map<String,List<ChildHealthExamination>> gourpChildHealthExaminationTwosMap = new LinkedHashMap<>();
		ListUtil.listGroupMap(childHealthExaminationTwos, gourpChildHealthExaminationTwosMap, ChildHealthExamination.class,"getName");
		model.addAttribute("gourpChildHealthExaminationTwosMap", gourpChildHealthExaminationTwosMap);
		return "rhip.ehr.browser.childHealthExaminationTwoList";
	}

	/**
	 * 12-30月龄儿童健康检查记录详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationTwo")
	public String getChildHealthExaminationTwo(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ChildHealthExamination childHealthExaminationTwo = childHealthExamineService.getChildHealthExam(criteria);
		if(ObjectUtil.isNotEmpty(childHealthExaminationTwo)){
			model.addAttribute("childHealthExaminationTwo", childHealthExaminationTwo);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.childHealthExaminationTwo";
	}

	/**
	 * 3-6岁儿童健康检查记录列表
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationThreeList")
	public String getChildHealthExaminationThrees(String personId, String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("PERSON_ID", personId);
		criteria.add("C_PHYSICAL_EXAM_AGE", OP.IN, new String[]{"3岁","4岁","5岁","6岁"});
		List<ChildHealthExamination> childHealthExaminationThrees = childHealthExamineService.getChildHealthExamList(criteria, new Order("VISIT_DATE", false));
		if(ObjectUtil.isNullOrEmpty(childHealthExaminationThrees)){
			model.addAttribute("message", "暂无3-6岁健康检查信息");
			return "rhip.ehr.browser.norecord";
		}
		Map<String,List<ChildHealthExamination>> gourpChildHealthExaminationThreesMap = new LinkedHashMap<>();
		ListUtil.listGroupMap(childHealthExaminationThrees, gourpChildHealthExaminationThreesMap, ChildHealthExamination.class,"getName");
		model.addAttribute("gourpChildHealthExaminationThreesMap", gourpChildHealthExaminationThreesMap);
		return "rhip.ehr.browser.childHealthExaminationThreeList";
	}

	/**
	 * 3-6岁儿童健康检查记录详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthExaminationThree")
	public String getChildHealthExaminationThree(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ChildHealthExamination childHealthExaminationThree = childHealthExamineService.getChildHealthExam(criteria);
		if(ObjectUtil.isNotEmpty(childHealthExaminationThree)){
			model.addAttribute("childHealthExaminationThree", childHealthExaminationThree);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.childHealthExaminationThree";
	}

	/**
	 * 体弱儿专项档案详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailInfantsFile")
	public String getFrailInfantsFile(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ChEtbjTre frailInfantsFile = macHealthService.getFrailInfantsFile(criteria);
		if(ObjectUtil.isNotEmpty(frailInfantsFile)){
			model.addAttribute("frailInfantsFile", frailInfantsFile);
			model.addAttribute("isShowBackBtn", true);
		}
		return "rhip.ehr.browser.frailInfantsFile";
	}

	/**
	 * 体弱儿专项档案列表
	 * @param person_idcard
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailInfantsFileList")
	public String getFrailInfantsFileList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("mqsfzhm", person_idcard);
		String[] properties = {"id", "xm"};
		Order order = new Order("CSRQ DESC");
		List<ChEtbjTre> frailInfantsFileList = macHealthService.getFrailInfantsFileList(criteria, order, properties);
		if(ObjectUtil.isNullOrEmpty(frailInfantsFileList)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("frailInfantsFileList", frailInfantsFileList);
		return "rhip.ehr.browser.frailInfantsFileList";
	}

	/**
	 * 儿童信息登记卡 儿童列表
	 */

	@RequestMapping("/childInformation")
	public String getChildrenInformationRegistrationCard(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("MQSFZHM", person_idcard);
//		PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
//		criteria = new Criteria("MQSFZHM", personInfo.getIdcard());
		String[] properties = {"id","xm","csrq"};
		List<ChEtbjJd>  ChEtbjJd= macHealthService.getChEtbjJds(criteria,properties);
		model.addAttribute("ChEtbjJd",ChEtbjJd);
		if(ObjectUtil.isNullOrEmpty(ChEtbjJd)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("ChEtbjJd", ChEtbjJd);
		return "rhip.ehr.browser.childInformation";
	}

	/**
	 * 儿童信息登记卡 表格详细内容
	 *
	 * @return
	 */

	@RequestMapping("/childrenInformationRegistrationCard")
	public String getRegistrationCard(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ChEtbjJd chEtbjJd = macHealthService.getChEtbjJdDetail(criteria);
		if(ObjectUtil.isNullOrEmpty(chEtbjJd)){
			return "rhip.ehr.browser.error";
		}
		if(ObjectUtil.isNotEmpty(chEtbjJd)){
			model.addAttribute("chEtbjJd", chEtbjJd);
		}
		return "rhip.ehr.browser.childrenInformationRegistrationCard";
	}

	/**
	 * 新增产后访视
	 * @param request
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/addPostnatalFollowup")
	public String addPostnatalFollowup(HttpServletRequest request,ModelMap model){
		return "rhip.ehr.browser.addPostnatalFollowup";
	}*/
	/**
	 * 修改产后访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/modifyPostnatalFollowup")
	public String modifyPostnatalFollowup(String id, ModelMap model){
		return "";
	}*/

	/**
	 * 第一次产前访视列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/prenatalFollowupList")
	public String getPrenatalFollowupFirsts(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "visit_Date"};
		List<PrenatalFollowup> prenatalFollowups = brwHealthService.getPrenatalFollowups(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(prenatalFollowups)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("prenatalFollowups", prenatalFollowups);
		return "rhip.ehr.browser.prenatalFollowupList";
	}

	/**
	 * 第2-5产前访视列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/otherList")
	public String getPrenatalFollowupOthers(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "ESTIMATED_DUE_DATES"};
		List<PrenatalFollowupOther> prenatalFollowupOthers = brwHealthService.getPrenatalFollowupOthers(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(prenatalFollowupOthers)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("prenatalFollowupOthers", prenatalFollowupOthers);
		return "rhip.ehr.browser.prenatalFollowupList.other";
	}

	/**
	 * 产前访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/prenatalFollowupFirst")
	public String getPrenatalFollowupFirst(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PrenatalFollowup prenatalFollowup = brwHealthService.getPrenatalFollowup(criteria);
		model.addAttribute("prenatalFollowup", prenatalFollowup);
		model.addAttribute("isShowBackBtn", false);
		return "rhip.ehr.browser.prenatalFollowup";
	}

	/**
	 * 产前访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/prenatalFollowupOther")
	public String getPrenatalFollowupOther(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PrenatalFollowupOther prenatalFollowup = brwHealthService.getPrenatalFollowupOther(criteria);
		model.addAttribute("prenatalFollowupOther", prenatalFollowup);
		model.addAttribute("isShowBackBtn", false);
		return "rhip.ehr.browser.prenatalFollowup.other";
	}

	/**
	 * 儿童体检详细
	 * @param examId
	 * @param model
	 * @return
	 */
	@RequestMapping("/childExamDetail")
	public String getChildExamDetail(String examId,ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", examId);
		ChildHealthExamination childHealthExamination = brwHealthService.getChildHealthExam(criteria);
		model.addAttribute("exam", childHealthExamination);
		return determineExamView(childHealthExamination.getExamineAgeGroup());
	}

	/**
	 * 分娩登记
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/deliveryRecord")
	public String getDeliveryRecordInfo(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		DeliveryRecordInfo deliveryRecordInfo = brwHealthService.getDeliveryRecordInfo(criteria);
		if(ObjectUtil.isNullOrEmpty(deliveryRecordInfo)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("deliveryRecordInfo", deliveryRecordInfo);
        //集成数据，展示页面
//		return "rhip.ehr.browser.deliveryRecord";
        return "rhip.ehr.woman.delivery.view";
	}


	/**
	 * 产前筛查与诊断（参考新版健康档案浏览器）
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/prenatalScreenDiagnosisList")
	public String prenatalScreenDiagnosisList(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("isDelete",0);
		String[] properties = {"id", "checkDate"};
		List<PrenatalScreenDiagnosis> penatalScreenDiagnosisList = brwHealthService.getPrenatalScreenDiagnosiList(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(penatalScreenDiagnosisList)){
			model.addAttribute("message", "暂无产前筛查与诊断信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("penatalScreenDiagnosisList", penatalScreenDiagnosisList);
		return "rhip.ehr.browser.penatalScreenDiagnosisList";
	}
	/**
	 * 产前筛查与诊断详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/prenatalScreenDiagnosis")
	public String prenatalScreenDiagnosis(Long id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PrenatalScreenDiagnosis prenatalScreenDiagnosis = brwHealthService.getPrenatalScreenDiagnosis(criteria);
		model.addAttribute("prenatalScreenDiagnosis", prenatalScreenDiagnosis);
		return "rhip.ehr.browser.penatalScreenDiagnosis";
	}


	/**
	 * 出生缺陷登记（参考新版健康档案浏览器）
	 */
	@RequestMapping("/bornDefectList")
	public String getBornDefectList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id", "fillDate"};
		List<BirthDefectMonitor> birthDefectMonitors = brwHealthService.getBirthDefectMonitorList(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(birthDefectMonitors)){
			model.addAttribute("message", "暂无出生缺陷登记信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("birthDefectMonitors", birthDefectMonitors);
		return "rhip.ehr.browser.bornDefectList";
	}

	/**
	 * 出生缺陷登记详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/bornDefectDetail")
	public String getBornDefectDetail(Long id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		BirthDefectMonitor birthDefectMonitor = brwHealthService.getBirthDefectMonitor(criteria);
		model.addAttribute("birthDefectMonitor", birthDefectMonitor);
		return "rhip.ehr.browser.birthDefect";
	}

	/**
	 * 计划生育技术服务
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/birthController")
	public String getBirthControllerService(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		BirthControlService birthControlService = brwHealthService.getBirthControlService(criteria);
		if(ObjectUtil.isNullOrEmpty(birthControlService)){
			model.addAttribute("message", "暂无计划生育技术服务信息记录");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("birthControlService", birthControlService);
		return "rhip.ehr.browser.birthController";
	}

	/**
	 * 新生儿家庭访视时间列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/neonatalFamilyVisitList")
	public String getNeonatalFamilyVisitList(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "visitDate"};
		List<NeonatalFamilyVisit> neonatalFamilyVisits = brwHealthService.getNeonatalFamilyVisits(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisits)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("neonatalFamilyVisits", neonatalFamilyVisits);
		return "rhip.ehr.browser.neonatalFamilyVisitList";
	}

	/**
	 * 新生儿家庭访视详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/neonatalFamilyVisitDetail")
	public String getNeonatalFamilyVisit(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		NeonatalFamilyVisit neonatalFamilyVisit = brwHealthService.getNeonatalFamilyVisit(criteria);
		if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
		model.addAttribute("isShowBackBtn", false);
		return "rhip.ehr.child.familyVisit.view";
	}

	/**
	 * 新生儿疾病筛查
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/neonatalDiseaseScreenList")
	public String getNeonatalDiseaseScreenList(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "checkDate"};
		List<NeonatalDiseaseScreen> neonatalDiseaseScreenList = brwHealthService.getNeonatalDiseaseScreenList(criteria, new Order("CHECK_DATE", false) ,properties);
		if(ObjectUtil.isNullOrEmpty(neonatalDiseaseScreenList)){
			model.addAttribute("message", "暂无新生儿疾病筛查信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("neonatalDiseaseScreenList", neonatalDiseaseScreenList);
		return "rhip.ehr.browser.neonatalDiseaseScreenList";
	}

	/**
	 * 新生儿疾病筛查
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/neonatalDiseaseScreenDetail")
	public String getNeonatalDiseaseScreenDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		NeonatalDiseaseScreen neonatalDiseaseScreen = brwHealthService.getNeonatalDiseaseScreen(criteria);
		if(ObjectUtil.isNullOrEmpty(neonatalDiseaseScreen)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("neonatalDiseaseScreen", neonatalDiseaseScreen);
		return "rhip.ehr.browser.neonatalDiseaseScreenDetail";
	}

	/**
	 * 孕产期保健服务与高危管理随访 随访时间列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/motherhoodPeriodFollowupList")
	public String getMotherhoodPeriodFollowups(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "checkDate"};
		List<MotherhoodPeriodFollowup> motherhoodPeriodFollowups = brwHealthService.getMotherhoodPeriodFollowups(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowups)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("motherhoodPeriodFollowups", motherhoodPeriodFollowups);
		return "rhip.ehr.browser.motherhoodPeriodFollowupList";
	}

	/**
	 * 孕产期保健服务与高危管理随访详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/motherhoodPeriodFollowupDetail")
	public String getMotherhoodPeriodFollowup(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		MotherhoodPeriodFollowup motherhoodPeriodFollowup = brwHealthService.getMotherhoodPeriodFollowup(criteria);
		if(ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowup)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("motherhoodPeriodFollowup", motherhoodPeriodFollowup);
		return "rhip.ehr.browser.motherhoodPeriodFollowup";
	}


	/**
	 * 儿童保健卡
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthCard")
	public String getChildHealthCard(String personId,ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		ChildHealthCard childHealthCard = brwHealthService.getChildHealthCard(criteria);
		if(ObjectUtil.isNullOrEmpty(childHealthCard)){
			model.addAttribute("message", "暂无儿童保健卡信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("childHealthCard", childHealthCard);
		return "rhip.ehr.browser.childHealthCard";
	}


	/**
	 * 体弱儿童管理随访 检查时间 列表
	 * @param personId
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailChildFollowupList")
	public String getFrailChildFollowups(String personId, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		String[] properties = {"id", "checkDate"};
		List<FrailChildFollowup> frailChildFollowups = brwHealthService.getFrailChildFollowups(criteria,new Order("CHECK_DATE", false), properties);
		if(ObjectUtil.isNullOrEmpty(frailChildFollowups)){
			model.addAttribute("message", "暂无体弱儿童管理随访信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("frailChildFollowups", frailChildFollowups);
		return "rhip.ehr.browser.frailChildFollowupList";
	}

	/**
	 * 体弱儿童管理随访 详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailChildFollowup")
	public String getFrailChildFollowup(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		FrailChildFollowup frailChildFollowup = brwHealthService.getFrailChildFollowup(criteria);
		if(ObjectUtil.isNullOrEmpty(frailChildFollowup)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("frailChildFollowup", frailChildFollowup);
		return "rhip.ehr.browser.frailChildFollowup";
	}

	private String determineExamView(String examineAgeGroup) {
		if (EHRConstants.CHILD_AGE_GROUP_UNDER_ONE.equals(examineAgeGroup)) {
			return "rhip.ehr.child.underOne.viewExam";
		}
		if (EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO.equals(examineAgeGroup)) {
			return "rhip.ehr.child.oneToTwo.viewExam";
		}
		if (EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX.equals(examineAgeGroup)) {
			return "rhip.ehr.child.threeToSix.viewExam";
		}
		return null;
	}

	/**
	 * 孕产妇登记（参考新版健康档案浏览器）
	 */
	@RequestMapping("/pregnantwomentabList")
	public String getpregnantwomentabList(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id","inputDate"};
		List<MaternalRegistration> whYcfbjJdList = macHealthService.getPregnantWomenTabList(criteria,properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjJdList)){
			model.addAttribute("message", "暂无孕产妇登记信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("maternalRegistrations", whYcfbjJdList);
		return "rhip.ehr.browser.health.pregnantwomentabList";
	}

	/**
	 * 孕产妇登记详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/pregnantwomentabDetail")
	public String getPregnantwomentabDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		MaternalRegistration pregnantWomenTab = macHealthService.getPregnantWomenTab(criteria);
		if(ObjectUtil.isNullOrEmpty(pregnantWomenTab)){
			model.addAttribute("message", "暂无孕产妇登记详情信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("maternalRegistration", pregnantWomenTab);
		return "rhip.ehr.browser.health.pregnantwomentabDetail";
	}

	/**
	 * 产前第一次随访列表（参考新版健康档案浏览器）
	 */
	@RequestMapping("/firstantenatalvisitList")
	public String getfirstantenatalvisitList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id","visitDate"};
		List<PrenatalFollowup> whYcfbjDycsfList = macHealthService.getfirstantenatalvisitList(criteria,properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjDycsfList)){
			model.addAttribute("message", "暂无产前第一次随访信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjDycsfList", whYcfbjDycsfList);
		return "rhip.ehr.browser.health.firstantenatalvisitList";
	}



	/**
	 * 产前第一次随访详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/firstantenatalvisitDetail")
	public String getfirstantenatalvisitDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		PrenatalFollowup whYcfbjDycsf = macHealthService.getFirstAntenatalVisitDetail(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjDycsf)){
			model.addAttribute("message", "暂无产前第一次随访详情信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjDycsf", whYcfbjDycsf);
		return "rhip.ehr.browser.health.firstantenatalvisitDetail";
	}

	/**
     * 产前第2-5次随访列表（参考新版健康档案浏览器）
     */
    @RequestMapping("/twoToFivevisit")
    public String getTwoToFivevisitList(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
        Criteria criteria = new Criteria();
        criteria.add("ID_CARD", person_idcard);
        String[] properties = {"id","inputDateTwo","inputDateThree","inputDateFour","inputDateFive"};
        List<PrenatalFollowupOther> whYcfbjCqsfList = macHealthService.getTwoToFivevisitList(criteria, properties);
        if(ObjectUtil.isNullOrEmpty(whYcfbjCqsfList)){
			model.addAttribute("message", "暂无产前第2-5次随访信息");
            return "rhip.ehr.browser.norecord";
        }else{
            List<PrenatalFollowupOther> others = new ArrayList<>();
            for(PrenatalFollowupOther followupOther : whYcfbjCqsfList){
                PrenatalFollowupOther other = new PrenatalFollowupOther();
                if (ObjectUtil.isNotEmpty(followupOther.getInputDateTwo())) {
                    other.setRecordDate(followupOther.getInputDateTwo());
                    other.setRecordName(DateUtil.getDateTime("MM/dd", followupOther.getInputDateTwo()) + " 第2次产前随访");
                    other.setId(followupOther.getId());
                    others.add(other);
                }
                if (ObjectUtil.isNotEmpty(followupOther.getInputDateThree())) {
                    other = new PrenatalFollowupOther();
                    other.setRecordDate(followupOther.getInputDateThree());
                    other.setRecordName(DateUtil.getDateTime("MM/dd", followupOther.getInputDateThree()) + " 第3次产前随访");
                    other.setId(followupOther.getId());
                    others.add(other);
                }
                if (ObjectUtil.isNotEmpty(followupOther.getInputDateFour())) {
                    other = new PrenatalFollowupOther();
                    other.setRecordDate(followupOther.getInputDateFour());
                    other.setRecordName(DateUtil.getDateTime("MM/dd", followupOther.getInputDateFour()) + " 第4次产前随访");
                    other.setId(followupOther.getId());
                    others.add(other);
                }
                if (ObjectUtil.isNotEmpty(followupOther.getInputDateFour())) {
                    other = new PrenatalFollowupOther();
                    other.setRecordDate(followupOther.getInputDateFive());
                    other.setRecordName(DateUtil.getDateTime("MM/dd", followupOther.getInputDateFive()) + " 第5次产前随访");
                    other.setId(followupOther.getId());
                    others.add(other);
                }
            }
            Collections.sort(others, new PrenatalFollowupOtherComparator());
            model.addAttribute("whYcfbjCqsfList", others);
        }

        return "rhip.ehr.browser.health.twoToFivevisit";
    }

    /**
     * 产前第2-5次随访详情（参考新版健康档案浏览器）
     */
    @RequestMapping("/twoToFivevisitDetail")
    public String getTwoToFivevisitDetail(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
		PrenatalFollowupOther whYcfbjCqsf = macHealthService.getTwoToFivevisitDetail(criteria);
        if(ObjectUtil.isNullOrEmpty(whYcfbjCqsf)){
			model.addAttribute("message", "暂无产前第2-5次随访详情信息");
            return "rhip.ehr.browser.norecord";
        }
        model.addAttribute("whYcfbjCqsf", whYcfbjCqsf);
        return "rhip.ehr.browser.health.twoToFivevisitDetail";
    }

	/**
	 * 高危产妇登记列表（参考新版健康档案浏览器）
	 */
	@RequestMapping("/highRiskMaternalRegistrationList")
	public String getHighRiskMaternalRegistrationList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("IDCARD", person_idcard);
		String[] properties = {"id","reportDate"};
		List<HighriskMaternalReg> whYcfbjGwdjList = macHealthService.getHighRiskMaternalRegistrationList(criteria,properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjGwdjList)){
			model.addAttribute("message", "暂无高危产妇登记信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjGwdjList",whYcfbjGwdjList);
		return "rhip.ehr.browser.health.highRiskMaternalRegistrationList";
	}

	/**
	 * 高危产妇登记（参考新版健康档案浏览器）
	 */
	@RequestMapping("/highRiskMaternalRegistration")
	public String getHighRiskMaternalRegistration(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		HighriskMaternalReg whYcfbjGwdj=macHealthService.getHighRiskMaternalRegistration(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjGwdj)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("whYcfbjGwdj",whYcfbjGwdj);
		return "rhip.ehr.browser.health.highRiskMaternalRegistration";
	}

	/**
	 * 高危产妇随访时间列表（参考新版健康档案浏览器）
	 */
	@RequestMapping("/highRiskMaternalTimeList")
	public String getHighRiskMaternalTimeList(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
		Criteria criteria = new Criteria();
		criteria.add("IDCARD", person_idcard);
		List<HighriskMaternalFollowup> whYcfbjGwsfTimeList=macHealthService.getHighRiskMaternalTimeList(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjGwsfTimeList)){
			model.addAttribute("message", "暂无高危产妇随访信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjGwsfTimeList",whYcfbjGwsfTimeList);
		return "rhip.ehr.browser.health.highRiskMaternalTimeList";
	}
	/**
	 * 高危产妇随访（参考新版健康档案浏览器）
	 */
	@RequestMapping("/highRiskMaternalVisit")
	public String getHighRiskMaternalVisit(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID",id);
		HighriskMaternalFollowup whYcfbjGwsf=macHealthService.getHighRiskMaternalVisit(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjGwsf)){
			model.addAttribute("message", "暂无高危产妇随访详情信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjGwsf",whYcfbjGwsf);
		return "rhip.ehr.browser.health.highRiskMaternalVisit";
	}

	/**
	 * 分娩信息记录列表（参考新版健康档案浏览器）
	 */
	@RequestMapping("/deliveryInfoRecordList")
	public String getDeliveryInfoRecordList(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id","deliveryDate"};
		List<DeliveryRecordInfo> whYcfbjFmxxList = macHealthService.getDeliveryInfoRecordList(criteria,properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjFmxxList)){
			model.addAttribute("message", "暂无分娩信息记录");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("deliveryRecordInfos", whYcfbjFmxxList);
		return "rhip.ehr.browser.health.deliveryInfoRecordList";
	}

	/**
	 * 分娩信息记录详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/deliveryInfoRecordDetail")
	public String getDeliveryInfoRecordDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		DeliveryRecordInfo whYcfbjFmxx = macHealthService.getDeliveryInfoRecordDetail(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjFmxx)){
			model.addAttribute("message", "暂无分娩信息记录详情");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("deliveryRecordInfo", whYcfbjFmxx);
		return "rhip.ehr.browser.health.deliveryInfoRecordDetail";
	}


	/**
	 * 产后42天健康检查记录列表（参考新版健康档案浏览器）
	 */
	@RequestMapping("/healthCheckRecordList")
	public String getHealthCheckRecordList(String person_idcard, ModelMap model) throws InvocationTargetException, IllegalAccessException {
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id","supervisionDate"};
		List<PostpartumDaysHealthInfo> whYcfbjChjcList = macHealthService.getHealthCheckRecordList(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjChjcList)){
			model.addAttribute("message", "暂无产后42天健康检查记录");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjChjcList", whYcfbjChjcList);
		return "rhip.ehr.browser.health.healthCheckRecordList";
	}

	/**
	 * 产后42天健康检查记录详情（参考新版健康档案浏览器）
	 */
	@RequestMapping("/healthCheckRecordDetail")
	public String getHealthCheckRecordDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		PostpartumDaysHealthInfo whYcfbjChjc = macHealthService.getHealthCheckRecordDetail(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjChjc)){
			model.addAttribute("message", "暂无产后42天健康检查记录详情信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjChjc", whYcfbjChjc);
		return "rhip.ehr.browser.health.healthCheckRecordDetail";
	}

	/**
	 * 妇女病普查列表 （参考新版健康档案浏览器）
	 * @param model
	 * @return
	 */
	@RequestMapping("/womanDiseaseCensusList")
	public String getWomanDiseaseCensuses(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id", "checkDate"};
		List<WomanDiseaseCensus> womanDiseaseCensuses = brwHealthService.getWomanDiseaseCensuses(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(womanDiseaseCensuses)){
			model.addAttribute("message", "暂无妇女病普查信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("womanDiseaseCensuses", womanDiseaseCensuses);
		return "rhip.ehr.browser.womanDiseaseCensusList";
	}

	/**
	 * 妇女病普查详情（参考新版健康档案浏览器）
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/womanDiseaseCensus")
	public String getWomanDiseaseCensus(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		WomanDiseaseCensus womanDiseaseCensus = brwHealthService.getWomanDiseaseCensus(criteria);
		if(ObjectUtil.isNullOrEmpty(womanDiseaseCensus)){
			model.addAttribute("message", "暂无妇女病普查记录详情");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("detailInfo", womanDiseaseCensus);
		return "rhip.ehr.browser.womanDiseaseCensus";
	}

	/**
	 * 婚前保健服务列表 （参考新版健康档案浏览器）
	 * @param model
	 * @return
	 */
	@RequestMapping("/premaritalHealthServiceList")
	public String getPremaritalHealthServiceList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID_CARD", person_idcard);
		String[] properties = {"id", "checkDate"};
		List<PremaritalHealthService> premaritalHealthServiceList = brwHealthService.getPremaritalHealthServices(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(premaritalHealthServiceList)){
			model.addAttribute("message", "暂无婚前保健服务信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("premaritalHealthServiceList", premaritalHealthServiceList);
		return "rhip.ehr.browser.premaritalHealthServiceList";
	}

	/**
	 * 婚前保健服务详情（参考新版健康档案浏览器）
	 * @param model
	 * @return
	 */
	@RequestMapping("/premaritalHealthService")
	public String getPremaritalHealthService(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PremaritalHealthService premaritalHealthService = brwHealthService.getPremaritalHealthService(criteria);
		if(ObjectUtil.isNullOrEmpty(premaritalHealthService)){
			model.addAttribute("message", "暂无婚前保健服务详情信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("detailInfo", premaritalHealthService);
		return "rhip.ehr.browser.premaritalHealthService";
	}

	/**
	 * 新生儿登记列表
	 */
	@RequestMapping("/newBornBabyRegisterList")
	public String getNewBornBabyRegisterList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("SFZJH", person_idcard);
		String[] properties = {"id","mcsj","ycfbh"};
		List<WhYcfbjXsedj> whYcfbjXsedjList = macHealthService.getNewBornBabyRegisterList(criteria,properties);
		if(ObjectUtil.isNullOrEmpty(whYcfbjXsedjList)){
			return "rhip.ehr.browser.error";
		}
		Map<String,List<WhYcfbjXsedj>> groupWhYcfbjXsedjMap = new HashMap<>();
		ListUtil.listGroupMap(whYcfbjXsedjList, groupWhYcfbjXsedjMap, WhYcfbjXsedj.class, "getYcfbh");
		model.addAttribute("groupWhYcfbjXsedjMap", groupWhYcfbjXsedjMap);
		return "rhip.ehr.browser.health.newBornBabyRegisterList";
	}
	/**
	 * 新生儿登记表详情
	 */
	@RequestMapping("/newBornBabyRegisterDetail")
	public String getNewBornBabyRegisterDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		WhYcfbjXsedj whYcfbjXsedj = macHealthService.getNewBornBabyRegisterDetail(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjXsedj)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("whYcfbjXsedj", whYcfbjXsedj);
		return "rhip.ehr.browser.health.newBornBabyRegisterDetail";
	}

	/**
	 * 体弱儿童列表
	 */
	@RequestMapping("/weakChildrenList")
	public  String getWeakChildrenList(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("MQSFZHM", person_idcard);
		String[]  properties = {"id","xm","sfrq"};
		List<ChEtbjTresf> chEtbjTresf = macHealthService.getWeakChildrenList(criteria,properties);
        if(ObjectUtil.isNullOrEmpty(chEtbjTresf)){
            return "rhip.ehr.browser.error";
        }
		Map<String,List<ChEtbjTresf>> groupChEtbjTresfMap = new HashMap<>();
		ListUtil.listGroupMap(chEtbjTresf, groupChEtbjTresfMap, ChEtbjTresf.class, "getXm");
		model.addAttribute("groupChEtbjTresfMap",groupChEtbjTresfMap);
        model.addAttribute("chEtbjTresf", chEtbjTresf);
		return "rhip.ehr.browser.health.weakChildrenList";
	}

	/**
	 * 体弱儿童随访详细
	 */
	@RequestMapping("/weakChildrenDetail")
	public String getWeakChildrenDetail(long id ,ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
        ChEtbjTresf chEtbjTresfDetail = macHealthService.getWeakChildrenDetail(criteria);
        if(ObjectUtil.isNullOrEmpty(chEtbjTresfDetail)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("chEtbjTresfDetail",chEtbjTresfDetail);
		return "rhip.ehr.browser.health.weakChildrenDetail";
	}

	/**
	 * 孕产妇死亡登记
	 */
	@RequestMapping("/maternalDeathRegistration")
	public String getMaternalDeathRegistration(String person_idcard, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("SFZJH", person_idcard);
		WhYcfbjSwdj whYcfbjSwdj = macHealthService.getMaternalDeathRegistration(criteria);
		if(ObjectUtil.isNullOrEmpty(whYcfbjSwdj)){
			model.addAttribute("message", "暂无孕产妇死亡登记信息");
			return "rhip.ehr.browser.norecord";
		}
		model.addAttribute("whYcfbjSwdj", whYcfbjSwdj);
		return "rhip.ehr.browser.health.maternalDeathRegistration";
	}

	/**
	 * 格式化排序记录
	 * @param recordList
	 * @param resultMap
	 * @return
	 */
	protected   <T> void formateRecordList(List<T> recordList, String timeLineTitle, String dateMethodName, Map<String, List<T>> resultMap) throws InvocationTargetException, IllegalAccessException {
		String timeOfYear = "";
		//排序

		try {
			T firstRecord = recordList.get(0);
			if(ObjectUtil.isNotEmpty(recordList)){
				Class clazz = firstRecord.getClass();
				Method getDateMethod = clazz.getDeclaredMethod(dateMethodName);

				Date dateObj = (Date)getDateMethod.invoke(firstRecord);
				if(dateObj == null) {
					timeOfYear = "无随访日期";
				} else {
					timeOfYear = DateUtil.getDateTime("yyyy",dateObj) + "年" + timeLineTitle;
				}


			}

			List<T> newRecordList = new ArrayList<>();
			for (T record:recordList){
				Class clazz = record.getClass();
				Method getDateMethod = clazz.getDeclaredMethod(dateMethodName);
				String currenttimeOfYear = "";
				Date dateObj = (Date)getDateMethod.invoke(record);
				if(dateObj == null) {
					currenttimeOfYear = "无随访日期";
				} else {
					currenttimeOfYear = DateUtil.getDateTime("yyyy",dateObj) + "年" + timeLineTitle;
				}
				if(timeOfYear.equals(currenttimeOfYear)){
					newRecordList.add(record);
				}else{
					resultMap.put(timeOfYear,newRecordList);
					newRecordList = new ArrayList<>();
					newRecordList.add(record);
					timeOfYear = currenttimeOfYear;
				}
				resultMap.put(currenttimeOfYear,newRecordList);
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
/*	protected   <T> void GroupRecordList(List<T> recordList,  Class<T> clazz, String dateMethodName, Map<String, List<T>> resultMap) throws InvocationTargetException, IllegalAccessException {
		String key;
		List<T> listTmp;
		for (T val : recordList) {
			Method method = ListUtil.getMethodByName(clazz,dateMethodName);
			Date dateObj =  (Date) method.invoke(val);
			key =DateUtil.getDateTime("yyyy", dateObj);
			//按这个属性分组，map的Key
			listTmp = resultMap.get(key);
			if (null == listTmp) {
				listTmp = new ArrayList<T>();
				resultMap.put(key, listTmp);
			}
			listTmp.add(val);
		}
	}*/

    private class PrenatalFollowupOtherComparator implements Comparator<PrenatalFollowupOther> {
        @Override
        public int compare(PrenatalFollowupOther o1, PrenatalFollowupOther o2) {
            if(o1.getRecordDate() == null || o2.getRecordDate() == null) {
                return -1;
            }
            //	升序o1>o2 return 1 o1<o2 return -1 ,降序o1>o2 return -1 o1<o2 return 1
            if(o1.getRecordDate().before(o2.getRecordDate())) return 1;
            return -1;
        }

    }
}