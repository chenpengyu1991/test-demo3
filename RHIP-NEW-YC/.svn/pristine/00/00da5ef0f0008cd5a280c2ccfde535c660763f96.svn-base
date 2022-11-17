package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.web.BaseController;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HealthPrescription;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHealthPrescriptionService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.common.SurveyStatus;
import com.founder.rhip.portal.service.*;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {
	@Resource(name = "lhserviceInfoService")
	private IServiceInfoService serviceInfoService;
	
	@Resource(name = "lhinfoTypeService")
    private IInfoTypeService infoTypService;
	
	@Resource(name = "lhhospitalInfoService")
	private IHospitalInfoService hospitalInfoService;
	
	@Resource(name = "organizationLinkService")
	private IOrganizationLinkService organizationLinkService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@Resource(name = "healthPrescriptionService")
    private IHealthPrescriptionService healthPrescriptionService;
	
	@Resource(name = "fileManagerService")
	private IFileManagerService fileManagerService;
	
	@Resource(name = "reserveService")
    private IReserveService reserveService;
	
	@Resource(name="lhsurveyService")
	private ISurveyService lhsurveyService;

	@Resource(name = "portalSetService")
	private IPortalSetService portalSetService;

	@Resource(name = "maternalChildrenHospitalReserveAdapter")
	private IHospitalReserveAdapter iHospitalReserveAdapter;

	protected static Logger logger = Logger.getLogger(HomeController.class);
	
	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/index")
	public String home(HttpServletRequest request, Model model) {
		return "portal.manage.home";
	}

	/***
	 * 通过name来显示首页各模块的内容明细
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/infoIndex")
	public String infoHome(HttpServletRequest request, ModelMap model) {
		model.addAttribute("accountInfo", request.getSession().getAttribute(Constants.ACCOUNT_INFO));
		Criteria criteria = new Criteria();
		List<InfoType> infoTypeList = infoTypService.getList(criteria);
		if(infoTypeList != null && infoTypeList.size() > 0) {
			for(int i = 0; i < infoTypeList.size(); i++) {
				String name = infoTypeList.get(i).getName().trim();
				Long id = infoTypeList.get(i).getId();
				String parentCode = infoTypeList.get(i).getParentCode();
				/*List<InfoType> subInfoType= infoTypService.getList(new Criteria("parentCode", id));*/
				switch (name) {
					/*case "新闻中心": model.addAttribute("subNews", subInfoType)
										.addAttribute("newsId", id); break;
					
					case "资料下载": model.addAttribute("subDownload", subInfoType)
										.addAttribute("downloadId", id); break;*/
					
					case "新闻动态": model.addAttribute("newNote", getServiceInfoList(id, parentCode))
										.addAttribute("newNoteMore", infoTypeList.get(i).getId()); break;//获取单击more时的该模块对应的id
										
					case "健康宣教": model.addAttribute("healNote", getServiceInfoList(id, parentCode))
										.addAttribute("healNoteMore", infoTypeList.get(i).getId()); break;
										/*.addAttribute("subHealth", subInfoType)
										.addAttribute("healthId", id)*/
										
					case "就医指南": model.addAttribute("guideNote", getServiceInfoList(id, parentCode))
										.addAttribute("guideNoteMore", infoTypeList.get(i).getId()); break;
										/*.addAttribute("subGuide", subInfoType)
										.addAttribute("guideId", id)*/
										
					case "公告": model.addAttribute("advNote", getServiceInfoList(id, parentCode))
										.addAttribute("advNoteMore", infoTypeList.get(i).getId()); break;
				}				
			}
		}
		//滚动新闻
		rollPic(model);
		//友情链接
		organizationLink(model);
		//医院集团
		yyjt(model);
		
		//医疗机构
		yljg(model);
		
		//健康指导
		jkzd(request, model);
		
		//资料下载
		zlxz(request, model);
		
		//热门专家
		rollDoctors(model);
		
		//调查问卷
		dcwj(model);
		
		return "lhportal.info.home";
	}

	//滚动新闻
	public void rollPic(ModelMap model) {
		List<ServiceInfo> rollPicList = serviceInfoService.getList(new Page(4, 1), new Criteria("isRollPicture", "1").add("status", "1")).getList();
		List<UploadInfoRecord> rollpicuploadInfoRecords = new ArrayList<UploadInfoRecord>();
		for(int i = 0; i < rollPicList.size(); i++) {
			Long id = rollPicList.get(i).getId();
			List<UploadInfoRecord> uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhrollpic"));
			rollpicuploadInfoRecords.addAll(uploadInfoRecord);
		}
		model.addAttribute("rollPicList", rollPicList);
		model.addAttribute("rollPicattches", rollpicuploadInfoRecords);
	}
	
	//友情链接
	public void organizationLink(ModelMap model) {
		Page page = new Page(6,1);
		Criteria criteria = new Criteria("status","1").add("is_delete", 0);
		List<OrganizationLink> orglList = organizationLinkService.getList(page, criteria).getList();
		List<UploadInfoRecord> uploadInfoRecords = new ArrayList<UploadInfoRecord>();
		for(int i = 0; i < orglList.size(); i++) {
			Long id = orglList.get(i).getId();
			List<UploadInfoRecord> uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhol"));
			if(ObjectUtil.isNotEmpty(uploadInfoRecord)) {
				uploadInfoRecords.addAll(uploadInfoRecord);
			}
		}
		model.addAttribute("attches", uploadInfoRecords);
		model.addAttribute("organizationLink", orglList);
	}
	
	//医院集团
	public void yyjt (ModelMap model) {
		List<HospitalInfo> ljyy = hospitalInfoService.getPortalList(new Page(6,1), null, "A1").getList(); //六家医院
		List<HospitalInfo> jdzx = hospitalInfoService.getPortalList(new Page(9,1), null, "B1").getList(); //九大中心
		model.addAttribute("ljyy", ljyy);
		model.addAttribute("jdzx", jdzx);
	}
	
	//医疗机构
	public void yljg (ModelMap model) {
		List<HospitalInfo> yljg = hospitalInfoService.getPortalList(new Page(6,1), null, null).getList(); //六家医院
		model.addAttribute("yljg", yljg);
	}
	
	//健康指导
	public void jkzd (HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HealthPrescription.class, "CREATE_TIME");
        PageList<HealthPrescription> jkzd = healthPrescriptionService.findHealthPrescription(criteria.add("STATUS", "1"), new Page(7,1));
        model.addAttribute("jkzd", jkzd.getList());
	}
	
	//资料下载
	public void zlxz (HttpServletRequest request, ModelMap model) {
		Criteria criteria = new Criteria();
		criteria.add("is_delete", "0");
		criteria.add("status", "1");
		PageList<FileManager> zlxz = fileManagerService.getFileManagers(criteria, new Page(6,1));
		model.addAttribute("zlxz", zlxz.getList());
	}
	
	//热门医生滚动
	public void rollDoctors (ModelMap model) {
		List<OutDoctor> rollDoctors = reserveService.getHosInfosByDoctor(new Criteria("od.is_hot", "1").add("od.is_delete",0).add("od.status", 1));
		List<Long> ids = new ArrayList<Long>();
		for(int i = 0; i < rollDoctors.size(); i++) {
			ids.add(rollDoctors.get(i).getId());	
		}
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",OP.IN, ids).add("FILE_RESOURCE", "outDoctorPic"));
		for (OutDoctor outDoctor: rollDoctors) {
			for (UploadInfoRecord uploadInfoRecord: uploadInfoRecords) {
				if(ObjectUtil.equals(outDoctor.getId(), uploadInfoRecord.getResourceId())){
					outDoctor.setUploadFileId(uploadInfoRecord.getId());
					uploadInfoRecords.remove(uploadInfoRecord);
					break;
				}
			}
		}
		model.addAttribute("rollDoctors", rollDoctors);
	}
	//调查问卷
	public void dcwj (ModelMap model) {
		Criteria criteria = new Criteria();
		criteria.add("status", SurveyStatus.START.getValue());
		PageList<Survey> surveyPageList = lhsurveyService.getSurveyList(new Page(10, 1), criteria);
		model.addAttribute("surveyList", surveyPageList.getList());
	}
		
	@RequestMapping("/showAsImage/{id}")
	public void showAsImage(@PathVariable Long id, Integer type, HttpServletResponse response) {
		List<UploadInfoRecord> uploadInfoRecords = null;
		UploadInfoRecord uploadInfoRecord = null;
		String originalFilePath = null;
		if (ObjectUtil.isNullOrEmpty(id) || ObjectUtil.isNullOrEmpty(uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id)))
				|| ObjectUtil.isNullOrEmpty(uploadInfoRecord = uploadInfoRecords.get(0)) || ObjectUtil.isNullOrEmpty(originalFilePath = uploadInfoRecord.getOriginalFilePath())) {
			return;
		}

		try {
			//InputStream in = type == 1 ? new FileInputStream(originalFilePath) : new FileInputStream(uploadInfoRecord.getThumbnailPath());
			InputStream in = type == 1 ? showImageFromCsws(originalFilePath) : showImageFromCsws(uploadInfoRecord.getThumbnailPath());
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage, StringUtils.substringAfterLast(originalFilePath, "."), outputStream);
			outputStream.flush();
			outputStream.close();
            in.close();
		} catch (FileNotFoundException fileException) {
			log.warn("首页图片文件不存在：" + fileException.getMessage());
		} catch (Exception e) {//FileNotFoundException
			logger.error(e.getMessage(), e);
//			e.printStackTrace();
		}
	}

	private List<ServiceInfo> getServiceInfoList(Long id, String parentCode) {
		String getInfoTypeName = infoTypService.get(id).getName();
		Criteria criteria = new Criteria();
		criteria.add(new Criteria("parentCode", parentCode));
		List<InfoType> infoTypeList = infoTypService.getList(criteria);
		if(infoTypeList.size() != 0) {
			//查找所有父类别中有子类别下的所有信息
			criteria = new Criteria();
			criteria.add("detailType", id);
			criteria.add("infoType", parentCode);
		}else {
			//查找所有父类别中无子类别下的所有信息
			criteria = new Criteria();
			criteria.add("infoType", id);
		}
		criteria.add("status", "1");
		switch (getInfoTypeName) {
			case "就医指南":return serviceInfoService.getList(new Page(6, 1), criteria).getList();//就医指南显示6行
			case "公告": return serviceInfoService.getList(new Page(5, 1), criteria).getList();//公告显示5行
			case "新闻动态": return serviceInfoService.getList(new Page(30, 1), criteria).getList();//新闻动态显示30行
			default:return serviceInfoService.getList(new Page(6, 1), criteria).getList();//其余显示8行
		}
	}

	/**
	 * 远程获取图片
	 * @param relativePath
	 * @return
	 */
	private InputStream showImageFromCsws(String relativePath){
		try {
			relativePath = relativePath.substring(3, relativePath.length());
			HashMap<String,String> map = portalSetService.getSetByType(PortalSetType.UPLOAD_IMG.getValue());
			String smbFilePath = "smb://" + map.get("csws_user") + ":";
			smbFilePath += map.get("csws_password") + "@";
			smbFilePath += map.get("csws_ip") + "/";
			smbFilePath += relativePath;
			SmbFile smbFile = new SmbFile(smbFilePath);
			SmbFileInputStream in = new SmbFileInputStream(smbFile);
			return in;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 正在建设中
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/underConstruction")
	public String underConstruction(HttpServletRequest request, Model model) {
		return "common.underConstruction";
	}
}
