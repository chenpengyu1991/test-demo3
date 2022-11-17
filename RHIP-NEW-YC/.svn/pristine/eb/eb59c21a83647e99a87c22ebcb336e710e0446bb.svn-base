package com.founder.rhip.vaccine.controller.hospital;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.ph.dto.vaccine.SearchConditionDTO;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;
import com.founder.rhip.ph.service.vaccine.IVaccinationSaveService;

/**
 * 
 * @author xu_bin
 * for Hospital user perform Vaccine. include(condition search / item
 * list / CRUD etc.)
 */
@Controller
public class HospitalRecordsPerformsController extends BaseController {
	@Resource(name = "vaccineOperatorService")
	IVaccinationSaveService vaccineOperatorService;
	
	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;

	@Autowired
	private IDictionaryApp dictionaryApp;

    @RequestMapping("/ph/hospital/records/add")
    public String vaccineAdd(Model model){
		return "rhip.vaccine.hospital.add";
	}
    
    @RequestMapping("/ph/hospital/records/factory/{isM}")
    public @ResponseBody List<DicItem> factory(@PathVariable("isM") Boolean isM){
    	List<DicItem> itemList = dictionaryApp.queryDicItem("FS990003");
    	List<DicItem> rs = new ArrayList<DicItem>();
    	String firstName =IVaccinationSaveService.FISRT_NAME;
    	if(isM)
    		firstName=IVaccinationSaveService.M_FISRT_NAME;
		for(DicItem dic:itemList){
			if(firstName.equals(dic.getItemName()))
			{
				rs.add(dic);
			}
		}
		for(DicItem dic:itemList){
			if(!firstName.equals(dic.getItemName()))
			rs.add(dic);
		}
		return rs;
	}

	/**
	 * 疫苗生产厂家
	 *
	 * @param isM
	 * @return
	 * @author yjf
	 */
	@RequestMapping("/ph/hospital/records/factoryData/{isM}")
	@ResponseBody
	public SelectDTO<DicItem> getFactoryData(@PathVariable("isM") Boolean isM) {
		List<DicItem> itemList = dictionaryApp.queryDicItem("FS990003");
    	List<DicItem> rs = new ArrayList<DicItem>();
    	//String firstName =IVaccinationSaveService.FISRT_NAME;
    	if(isM){
    		
    		for(DicItem dic:itemList){
    			if(dic.getItemCode().equals("21")||dic.getItemCode().equals("22")||dic.getItemCode().equals("23")||dic.getItemCode().equals("24")||dic.getItemCode().equals("25")||dic.getItemCode().equals("26")||dic.getItemCode().equals("27"))
    			rs.add(dic);
    		}
    	}
    	else{
    	//	firstName=IVaccinationSaveService.M_FISRT_NAME;
		for(DicItem dic:itemList){
			if(dic.getItemCode().equals("19")||dic.getItemCode().equals("20")||dic.getItemCode().equals("28")||dic.getItemCode().equals("29")||dic.getItemCode().equals("30")||dic.getItemCode().equals("31")||dic.getItemCode().equals("32")||dic.getItemCode().equals("33")||dic.getItemCode().equals("34"))
			{
				rs.add(dic);
			}
		}
    	}
		SelectDTO<DicItem> result = new SelectDTO<>();
		result.setObjList(rs);
		return result;
	}
	
    /**
     *
     * @param idCard
     * @param request
     * @return
     */
	@RequestMapping("/hospital/records/flush")
	public @ResponseBody VaccinationMgmt vaccineFlush(HttpServletRequest request,String idCard, String immuType){
		idCard = idCard.trim();
		
		VaccinationMgmt vaccinationMgmt = new VaccinationMgmt();
		if(ObjectUtil.isNotEmpty(idCard)){
			vaccinationMgmt = vaccineOperatorService.getDetailsByIdCard(idCard);
			// 判断5年内是否接种过23价疫苗 添加人：高飞  添加日期：20180403
			if (ObjectUtil.isNotEmpty(vaccinationMgmt) && StringUtils.equals(immuType, IVaccinationSaveService.VACCINE_PNEUMONIA)) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_MONTH, -365*5);
				Date date = calendar.getTime();
				Criteria criteria = new Criteria("personId", vaccinationMgmt.getPersonId()).add("immuType", IVaccinationSaveService.VACCINE_PNEUMONIA).add("isDelete", 0);
				DateUtil.getCriteriaByDateRange(criteria, "vaccinationDate", date, new Date());
				VaccinationInfo vaccinationInfo = vaccineService.getVaccinationInfo(criteria);
				if (ObjectUtil.isNotEmpty(vaccinationInfo)) {
					vaccinationMgmt.setPneumoniaVaccFlag("1");
					return vaccinationMgmt;
				}
			}
			Date birthDate= IDCardUtil.getBirthDateByIdCard(idCard);
			Calendar ca1 = DateUtil.getToday();
			Calendar ca2 = DateUtil.getToday();
			ca1.add(Calendar.YEAR, -65);
			ca2.add(Calendar.YEAR, -85);
			Date date1= ca1.getTime();
			Date date2= ca2.getTime();
			if(ObjectUtil.isNotEmpty(vaccinationMgmt)) {
				if(birthDate.before(date1) && birthDate.after(date2)){
					vaccinationMgmt.setAgeFlag("0");
				}else{
					vaccinationMgmt.setAgeFlag("1");
				}
			}
		}
		return vaccinationMgmt;
	}

	//加入ph前缀
	@RequestMapping("/ph/hospital/records/grid")
	public String result(HttpServletRequest request,Boolean gray,Integer indexPage,SearchConditionDTO searchConditionDTO) {
		Page page = super.getPage(request, indexPage); 
        Criteria criteria = searchConditionDTO.getSearchCondition();
        
		PageList<VaccinationEvent> list = vaccineService.getList(page, criteria);
		request.setAttribute("vaccinationRecords", list.getList());
        request.setAttribute("page",list.getPage());
        request.setAttribute("gray",gray);
        request.setAttribute("searchConditionDTO",searchConditionDTO);
		return "rhip.vaccine.hospital.records";
	}
}
