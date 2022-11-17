package com.founder.rhip.ehr.controller.ehrbrowser;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import com.founder.rhip.ehr.service.IReadHealthRecordService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.mdm.service.IExplorerSetService;

@Controller
@RequestMapping("/ehrbrowser")
public class ExplorerController extends BaseController {
	
	@Autowired
	private IPersonalRecordService personalRecordService;
	
	@Autowired
	private IReadHealthRecordService readHealthRecordService;
	
	@Resource(name = "explorerSetService")
	private IExplorerSetService explorerSetService;
	
	@RequestMapping("/healthExplore")
	public String getHealthBrw(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		Map<String, String> mapInfo = (Map<String, String>) session.getAttribute("explorerInfo");
		String idcard = mapInfo.get("idcard");
		String doctorType = mapInfo.get("doctorType");
		Criteria criteria = new Criteria("idcard", idcard);
		PersonInfo person = personalRecordService.getPersonRecord(criteria);
		if(ObjectUtil.isNotEmpty(person) && ObjectUtil.isNotEmpty(person.getId())) {
			ReadHealthRecord readHealthRecord = new ReadHealthRecord();
			readHealthRecord.setPersonIdcard(idcard);
			readHealthRecord.setPersonName(person.getName());
			readHealthRecord.setReadDate(new Date());
			readHealthRecord.setReaderOrgancode(mapInfo.get("viewOrganCode"));
			String[] viewUser = new String[2];
			if(ObjectUtil.isNotEmpty(mapInfo.get("viewUser")) && ((String)mapInfo.get("viewUser")).contains("/") ){
				viewUser = mapInfo.get("viewUser").split("/");
			}
			if(ObjectUtil.isNotEmpty(viewUser[0])){
				//readHealthRecord.setReaderId(Long.parseLong(viewUser[0]));
                readHealthRecord.setReaderId(0L);
			}
			if(ObjectUtil.isNotEmpty(viewUser[1])){
				readHealthRecord.setReaderName(viewUser[1]);
			}
			// 根据医生类型获取对应的页面配置信息
			if (ObjectUtil.isNotEmpty(doctorType)) {
				Map<String, List<String>> doctorSetMap = explorerSetService.getExplorerSetMap(new Criteria("doctorType", doctorType));
				session.setAttribute("doctorSetMap", doctorSetMap);
				session.setAttribute("doctorType", doctorType);
			} else {
				session.removeAttribute("doctorSetMap");
				session.removeAttribute("doctorType");
			}
			readHealthRecordService.addReadRecord(readHealthRecord);
			model.addAttribute("personId", person.getId());
			model.addAttribute("personIdcard", idcard);
			model.addAttribute("external", 1); // 外部调用标记，用来判断页面返回按钮是否显示
		}
		return "rhip.ehr.browser.index";
	}
}