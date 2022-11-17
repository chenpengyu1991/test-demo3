/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.idm.AcuteStatisicsDto;
import com.founder.rhip.ehr.dto.idm.DysenteryStatisicsDto;
import com.founder.rhip.ehr.dto.idm.InterviewStatisicsDto;
import com.founder.rhip.ehr.dto.idm.RabiesStatisicsDto;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.ListScDc;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.StatisticsData;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.Supervisor;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IListEfcDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListTsDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.IListScDcDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.ISelfCheckDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.IStatisticsDataDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.ISupervisorDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reportStatisticsService")
public class ReportStatisticsServiceImpl extends AbstractService implements IReportStatisticsService {
	
	@Resource(name = "idmSupervisorDao")
	private ISupervisorDao idmSupervisorDao;

	@Resource(name = "idmSelfCheckDao")
	private ISelfCheckDao idmSelfCheckDao;

	@Resource(name = "idmScDcDao")
	private IListScDcDao idmScDcDao;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
    @Resource(name = "idmListTsDao")
    private IListTsDao listTsDao;     //采样信息
    
    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao statusInfoDao;
    
    @Resource(name = "listEfcDao")
    private IListEfcDao listEfcDao;
    
    @Resource(name = "statisticsDataDao")
    private IStatisticsDataDao statisticsDataDao;
     
	/**
	 * 传染病管理及督导-分页查询填写
	 * @param       criteria
	 * @param       page
	 * @return      PageList<Supervisor>
	 */
	public PageList<Supervisor> findSupervisorFill(Criteria criteria, Page page) {
		PageList<Supervisor> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			Order od = new Order("REPORT_UNIT_CODE,REPORT_MONTH DESC");
			result = idmSupervisorDao.getPageList(page, criteria,od);
		}
		return result;		
	}

	/**
	 * 传染病管理及督导-查询填写
	 * @param       criteria
	 * @param       summaryType:统计方式，年、月
	 * @return      List<Supervisor>
	 */
	public List<Supervisor> findSupervisorFill(Criteria criteria, String summaryType) {
		List<Supervisor> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmSupervisorDao.findSupervisorFill(criteria,summaryType);
		}
		return result;		
	}

	/**
	 * 传染病管理及督导-合计
	 * @param       criteria
	 * @param       summaryType
	 * @return      Supervisor
	 */
	public Supervisor getSupervisorSummary(Criteria criteria, String summaryType){
		Supervisor result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmSupervisorDao.getSummary(criteria,summaryType);
		}
		return result;			
	}
	/**
	 * 传染病管理及督导-查看填写
	 * @param       id
	 * @return      Supervisor
	 */
	public Supervisor getSupervisorFill(Long id){
		Supervisor supervisor = null;
		if(ObjectUtil.isNotEmpty(id)){
			supervisor = idmSupervisorDao.get(id);
		}
		return supervisor;
	}
	
    /**
     * 保存传染病管理及督导-填写
     * @param       supervisor
     * @return      boolean
     */
    @Transactional
    public boolean saveSupervisorFill(Supervisor supervisor){
        int result = 0;
        supervisor.setIsDelete(0);
        if (ObjectUtil.isNotEmpty(supervisor.getId())) {
        	result = idmSupervisorDao.update(supervisor);
        }else{
        	result = idmSupervisorDao.insert(supervisor);
        }
        return result != 0?true:false;
    }
    
	/**
	 * 传染病管理及督导-查看填写个数
	 * @param       criteria
	 * @return      int
	 */
	public int getSupervisorFillCount(Criteria criteria){
		int result = 0;
		if(ObjectUtil.isNotEmpty(criteria)){
			List<Supervisor> supervisors = idmSupervisorDao.getList(criteria, new String[]{"ID"});
			if (ObjectUtil.isNotEmpty(supervisors)){
				result = supervisors.size();
			}
		}
		return result;
	} 
	
	/**
	 * 执行情况自查-填写查询
	 * @param       criteria
	 * @param       page
	 * @return      PageList<SelfCheck>
	 */
	public PageList<SelfCheck> findSelfCheckFill(Criteria criteria, Page page){
		PageList<SelfCheck> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			Order od = new Order("REPORT_UNIT_CODE,REPORT_MONTH DESC,TYPE");
			result = idmSelfCheckDao.getPageList(page, criteria,od);
		}
		return result;			
	}

	/**
	 * 执行情况自查-查看填写
	 * @param       ca
	 * @return      SelfCheck
	 */
	public SelfCheck getSelfCheckFill(Long id){
		SelfCheck selfCheck = null;
		if(ObjectUtil.isNotEmpty(id)){
			selfCheck = idmSelfCheckDao.get(id);
			Criteria caScDc = new Criteria("SELF_CHECK_ID",id);
			List<ListScDc> listScDcs = idmScDcDao.getList(caScDc);
			if(ObjectUtil.isNotEmpty(listScDcs)){
				selfCheck.setListScDcs(listScDcs);
			}
		}
		return selfCheck;		
	}

	/**
	 * 执行情况自查-查看填写个数
	 * @param       criteria
	 * @return      int
	 */
	public int getSelfCheckFillCount(Criteria criteria){
		int result = 0;
		if(ObjectUtil.isNotEmpty(criteria)){
			List<SelfCheck> selfChecks = idmSelfCheckDao.getList(criteria, new String[]{"ID"});
			if (ObjectUtil.isNotEmpty(selfChecks)){
				result = selfChecks.size();
			}
		}
		return result;
	} 
	
    /**
     * 执行情况自查-填写
     * @param       selfCheck
     * @return      boolean
     */
    public boolean saveSelfCheckFill(SelfCheck selfCheck){
    	int result = 0;
    	
    	if(ObjectUtil.isNotEmpty(selfCheck)){
    		selfCheck.setIsDelete(0);
    		Long selfCheckId = selfCheck.getId();
    		if(ObjectUtil.isNotEmpty(selfCheckId)){
    			result = idmSelfCheckDao.update(selfCheck);
    		}else{
    			selfCheckId =  idmSelfCheckDao.generatedKey(selfCheck, "ID", null).longValue();
        		if(ObjectUtil.isNotEmpty(selfCheckId)){
        			result = 1;
        		}else{
        			log.error("执行情况自查-传染病报告保存失败。");
        		}
    		}
    		List<ListScDc> listScDcs = selfCheck.getListScDcs();
        	if(ObjectUtil.isNotEmpty(listScDcs) && result > 0){
                for(ListScDc listScDc:listScDcs){
                	listScDc.setSelfCheckId(selfCheckId);
                	listScDc.setReportMonth(selfCheck.getReportMonth());
                	listScDc.setReportUnitCode(selfCheck.getReportUnitCode());
                	listScDc.setDepartmentCode(selfCheck.getDepartmentCode());
                } 
                Criteria ca = new Criteria("selfCheckId", selfCheckId);
                idmScDcDao.delete(ca);
                result = idmScDcDao.batchInsert(listScDcs);
        	}
    	}
    	return result != 0?true:false;
    }
    
	/**
	 * 执行情况自查-法定传染病统计
	 * @param       criteria
	 * @return      List<SelfCheck>
	 */
	public List<SelfCheck> findSelfCheckSummary(Criteria criteria){
		List<SelfCheck> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			List<DicItem> departments = dictionaryApp.queryDicItem(new Criteria("DIC_CODE","IDM00333"));
			result = idmSelfCheckDao.findSelfCheck(criteria,departments);//查询本月本机构各科室数据
			List<ListScDc> existsInfection = findInfections(criteria);//查询本月本机构上报传染病集合
			Map<String,String> mapDepartments = getMonthDepartments(criteria);//本月上报过传染病的科室集合
			for(SelfCheck selfCheck:result){
				String departmentCode = selfCheck.getDepartmentCode();
				List<ListScDc> listScDcs = getDepartmentInfection(criteria,departmentCode,existsInfection.size(),mapDepartments);
				if(listScDcs.size()<=0){
					/*查询所在部门传染病报告情况*/
					listScDcs = idmScDcDao.findDepartmentInfection(criteria.add("DEPARTMENT_CODE",departmentCode),existsInfection);
				}
				
				if(ObjectUtil.isNotEmpty(listScDcs)){
					selfCheck.setListScDcs(listScDcs);
				}
			}
			if(ObjectUtil.isNullOrEmpty(result)){
				result = initSummaryData(departments);
			}
		}
		return result;			
	}  
	
	private List<SelfCheck> initSummaryData(List<DicItem> departments){
		List<SelfCheck> list = new ArrayList<SelfCheck>();
		for(DicItem item:departments){
			SelfCheck selfcheck = new SelfCheck();
			selfcheck.setDepartmentCode(item.getItemCode());
			selfcheck.setCheckNum(0);
			selfcheck.setShouldNum(0);
			selfcheck.setMissNum(0);
			selfcheck.setMissRate(0D);
			list.add(selfcheck);
		}
		return list;
	}
	private List<ListScDc> getDepartmentInfection(Criteria criteria, String departmentCode, int infectionSize, Map<String,String> map){
		List<ListScDc> result = new ArrayList<>();
		if(!map.containsKey(departmentCode)){
			for(int i=0;i<infectionSize;i++){
				ListScDc scDc = new ListScDc();
				scDc.setMissNum(0);
				scDc.setShouldNum(0);
				result.add(scDc);
			}
		}
		return result;
	}
	
	private Map<String,String> getMonthDepartments(Criteria criteria){
		Map<String,String> mapDepartments = new HashMap<>();
		List<SelfCheck> monthDepartments = idmSelfCheckDao.findDepartment(criteria);//本月上报过传染病的科室集合
		if(ObjectUtil.isNotEmpty(monthDepartments)){
			for(SelfCheck self:monthDepartments){
				mapDepartments.put(self.getDepartmentCode(), self.getDepartmentCode());
			}
		}
		return mapDepartments;
	}
    /**
     * 获取本机构，本月共上报多少种传染病
     * @param       criteria
     * @return      List<ListScDc>
     */
    public List<ListScDc> findInfections(Criteria criteria){
    	List<ListScDc> result = null;
    	if(ObjectUtil.isNotEmpty(criteria)){
    		result = idmScDcDao.findInfections(criteria);
    	}
    	return result;
    }
    
	/**
	 * 执行情况自查-合计
	 * @param       criteria
	 * @return      SelfCheck
	 */
	public SelfCheck getSelfCheckSummary(Criteria criteria){
		SelfCheck result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmSelfCheckDao.summarySelfCheck(criteria);
			List<ListScDc> listScDcs = idmScDcDao.summaryInfection(criteria);
			result.setListScDcs(listScDcs);
		}
		return result;			
	}  
	/**
	 * 执行情况自查-新生儿产房接种统计，每次只有一条
	 * @param       criteria
	 * @return      List<SelfCheck>
	 */
	public SelfCheck findNeonateSummary(Criteria criteria){
		SelfCheck result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmSelfCheckDao.summaryNeonate(criteria);
		}
		return result;			
	}

    /**
     * 分页查询采样记录
     * @param       criteria
     * @param       page
     * @param       od
     * @return      PageList<findTsList>
     */
    public PageList<ListTs> findTsList(Criteria criteria, Page page, Order od){
        return listTsDao.getPageList(page, criteria, od);
    }
    
    /**
     * 查询采样记录
     * @param       criteria
     * @param       page
     * @return      PageList<findTsList>
     */
    public List<ListTs> findTsList(Criteria criteria, Order od){
        return listTsDao.getList(criteria, od);
    }
    
	/**
	 * 传染病访视月报表-统计
	 * @param       criteria
	 * @return      List<InterviewStatisicsDto>
	 */
	public List<InterviewStatisicsDto> findInterviewSummary(Criteria criteria){
		List<InterviewStatisicsDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = statusInfoDao.findInterviewList(criteria);
			InterviewStatisicsDto sumDto = new InterviewStatisicsDto();
			for(InterviewStatisicsDto dto:result){
				criteria.add("DISEASE_CODE",dto.getDiseaseCode());
				Integer contactNumber = listEfcDao.getContactNumber(criteria);
				dto.setContactNumber(ObjectUtil.isNullOrEmpty(contactNumber)?0:contactNumber);
				criteria.remove("DISEASE_CODE");
				sumInterview(sumDto,dto);
			}
			sumDto.setDiseaseCode("-1");
			result.add(sumDto);
		}
		return result;			
	}  
	
	/**
	 * 传染病访视月报表-合计
	 * @param       sumDto
	 * @param       dto
	 */	
	private void sumInterview(InterviewStatisicsDto sumDto, InterviewStatisicsDto dto){
		int contactNumber =  dto.getContactNumber() + sumDto.getContactNumber().intValue();
		int reportNumber = dto.getReportNumber().intValue() + sumDto.getReportNumber().intValue();
		int interviewNumber = dto.getInterviewNumber().intValue() + sumDto.getInterviewNumber().intValue();
		int inHomeNumber = dto.getInHomeNumber().intValue() + sumDto.getInHomeNumber().intValue();
		int inHospitalNumber = dto.getInHospitalNumber().intValue() + sumDto.getInHospitalNumber().intValue();
		int misdiagnose = dto.getMisdiagnose().intValue() + sumDto.getMisdiagnose().intValue();
		int unknownPerson = dto.getUnknownPerson().intValue() + sumDto.getUnknownPerson().intValue();
		int interviewOther = dto.getInterviewOther().intValue() + sumDto.getInterviewOther().intValue();
		int vaccinationNumber  = dto.getVaccinationNumber().intValue() + sumDto.getVaccinationNumber().intValue();
		sumDto.setContactNumber(contactNumber);//密切接触者
		sumDto.setReportNumber(reportNumber);//报告数
		sumDto.setInterviewNumber(interviewNumber);//访视数
		sumDto.setInHomeNumber(inHomeNumber);//在家人数
		sumDto.setInHospitalNumber(inHospitalNumber);//住院人数
		sumDto.setMisdiagnose(misdiagnose);//误诊
		sumDto.setUnknownPerson(unknownPerson);//查无此人
		sumDto.setInterviewOther(interviewOther);//其他
		sumDto.setVaccinationNumber(vaccinationNumber);//疫苗接种人数
	}
	
    /**
     * 保存 传染病月报表
     * @param       lists
     * @return      boolean
     */
    @Transactional
    public boolean saveStatistics(List<StatisticsData> lists){
        int updateCount = 0;
        for(StatisticsData data:lists){
        	Criteria ca = new Criteria();
        	if(StringUtil.isNotEmpty(data.getDiseaseCode())){
        		ca.add("DISEASE_CODE",data.getDiseaseCode());
        	}
        	ca.add("FILL_ORGAN_CODE",data.getFillOrganCode());
        	ca.add("FILL_DATE",data.getFillDate());
        	if(ObjectUtil.isNotEmpty(data.getType())){
        		ca.add("TYPE",data.getType());
        	}
        	Parameters para = getStatisticsPara(data);
        	updateCount = statisticsDataDao.update(para, ca);
        	if(updateCount <= 0){
        		updateCount = statisticsDataDao.insert(data);
        	}
        }
        return updateCount != 0?true:false;
    }
    
    private Parameters getStatisticsPara(StatisticsData data){
    	Parameters para = new Parameters();
    	if(ObjectUtil.isNotEmpty(data.getUnknownPerson())){
    		para.add("UNKNOWN_PERSON", data.getUnknownPerson());
    	}
    	if(ObjectUtil.isNotEmpty(data.getMisdiagnose())){
    		para.add("MISDIAGNOSE", data.getMisdiagnose());
    	}
    	if(ObjectUtil.isNotEmpty(data.getInterviewOther())){
    		para.add("INTERVIEW_OTHER", data.getInterviewOther());
    	}
    	if(ObjectUtil.isNotEmpty(data.getVaccinationNumber())){
    		para.add("VACCINATION_NUMBER", data.getVaccinationNumber());
    	}
    	if(ObjectUtil.isNotEmpty(data.getOther())){
    		para.add("OTHER", data.getOther());
    	}
    	if(ObjectUtil.isNotEmpty(data.getCulture())){
    		para.add("CULTURE", data.getCulture());
    	}
    	if(ObjectUtil.isNotEmpty(data.getWater())){
    		para.add("WATER", data.getWater());
    	}
    	if(ObjectUtil.isNotEmpty(data.getFood())){
    		para.add("FOOD", data.getFood());
    	}
    	if(ObjectUtil.isNotEmpty(data.getContact())){
    		para.add("CONTACT", data.getContact());
    	}
    	if(ObjectUtil.isNotEmpty(data.getUnspecified())){
    		para.add("UNSPECIFIED", data.getUnspecified());
    	}  
    	if(ObjectUtil.isNotEmpty(data.getCall())){
    		para.add("CALL", data.getCall());
    	}
    	if(ObjectUtil.isNotEmpty(data.getSelf())){
    		para.add("SELF", data.getSelf());
    	}
    	if(ObjectUtil.isNotEmpty(data.getBiteMany())){
    		para.add("BITE_MANY", data.getBiteMany());
    	}
    	if(ObjectUtil.isNotEmpty(data.getDisposeEpidemic())){
    		para.add("DISPOSE_EPIDEMIC", data.getDisposeEpidemic());
    	}
    	if(ObjectUtil.isNotEmpty(data.getRabiesOther())){
    		para.add("RABIES_OTHER", data.getRabiesOther());
    	} 
      	if(ObjectUtil.isNotEmpty(data.getEfdDispose())){
    		para.add("EFD_DISPOSE", data.getEfdDispose());
    	} 
      	if(ObjectUtil.isNotEmpty(data.getEfdInsulate())){
    		para.add("EFD_INSULATE", data.getEfdInsulate());
    	} 
      	if(ObjectUtil.isNotEmpty(data.getDysenteryDispose())){
    		para.add("DYSENTERY_DISPOSE", data.getDysenteryDispose());
    	} 
      	if(ObjectUtil.isNotEmpty(data.getDysenteryInsulate())){
    		para.add("DYSENTERY_INSULATE", data.getDysenteryInsulate());
    	} 
    	return para;
    }
	/**
	 * 细菌性痢疾流调月报表-统计
	 * @param       criteria
	 * @return      List<DysenteryStatisicsDto>
	 */
	public List<DysenteryStatisicsDto> findDysenterySummary(Criteria criteria){
		List<DysenteryStatisicsDto> result = new ArrayList<DysenteryStatisicsDto>();
		Object fillDate = criteria.get("FILL_DATE");
		if(ObjectUtil.isNotEmpty(criteria)){
			result = statusInfoDao.findDysenteryList(criteria);
			if(result.size() == 0){
				Object fillOrganCode = criteria.get("FILL_ORGAN_CODE");
				DysenteryStatisicsDto dysentery = new DysenteryStatisicsDto();
				dysentery.setFillDate(DateUtil.parseSimpleDate(fillDate + "/01", "yyyy/MM/dd"));
				if(ObjectUtil.isNotEmpty(fillOrganCode)){
					dysentery.setFillOrganCode(fillOrganCode.toString());
				}
				dysentery.setDiseaseCode("213");
				result.add(dysentery);
			}
			DysenteryStatisicsDto dto = statusInfoDao.findDysenteryTotal(criteria);
			dto.setDiseaseCode("-1");
			result.add(dto);
		}

		return result;			
	} 
	
	/**
	 * 狂犬病防治月报表-统计
	 * @param       criteria
	 * @return      List<RabiesStatisicsDto>
	 */
	public List<RabiesStatisicsDto> findRabiesSummary(Criteria criteria){
		List<RabiesStatisicsDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = statusInfoDao.findRabiesList(criteria);
			if(result.size() == 0){
				Object fillDate = criteria.get("FILL_DATE");
				Object fillOrganCode = criteria.get("FILL_ORGAN_CODE");
				RabiesStatisicsDto rabies = new RabiesStatisicsDto();
				rabies.setFillDate(DateUtil.parseSimpleDate(fillDate + "/01", "yyyy/MM/dd"));
				if(ObjectUtil.isNotEmpty(fillOrganCode)){//疾控中心统计时，可以不选择机构
					rabies.setFillOrganCode(fillOrganCode.toString());
				}
				rabies.setDiseaseCode("209");
				result.add(rabies);
			}
			RabiesStatisicsDto dto = statusInfoDao.findRabiesTotal(criteria);
			dto.setDiseaseCode("-1");
			result.add(dto);
		}
		return result;			
	} 
	
	/**
	 * 急性传染病防制月报表-统计
	 * @param       criteria
	 * @return      List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteMonthSummary(Criteria criteria){
		List<AcuteStatisicsDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			Object fillDate = criteria.get("FILL_DATE");
			Object fillOrganCode = criteria.get("FILL_ORGAN_CODE");
			result = statusInfoDao.findAcuteMonthList(criteria);
			if(result.size() == 0  && ObjectUtil.isNotEmpty(fillOrganCode)){
				AcuteStatisicsDto acute = new AcuteStatisicsDto();
				acute.setFillDate(DateUtil.parseSimpleDate(fillDate + "/01", "yyyy/MM/dd"));
				acute.setFillOrganCode(fillOrganCode.toString());
				result.add(acute);
			}
			/*合计*/
			AcuteStatisicsDto dto = statusInfoDao.findAcuteMonthTotalList(criteria);
			dto.setFillOrganCode("-1");//标记为合计
			result.add(dto);
		}
		return result;			
	} 	
	
	/**
	 * 急性传染病防制年报表-统计
	 * @param       criteria
	 * @return      List<AcuteStatisicsDto>
	 */
	public List<AcuteStatisicsDto> findAcuteYearSummary(Criteria criteria){
		List<AcuteStatisicsDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			Object fillDate = criteria.get("FILL_DATE");
			Object fillOrganCode = criteria.get("FILL_ORGAN_CODE");
			result = statusInfoDao.findAcuteYearList(criteria);
			if(result.size() == 0 && ObjectUtil.isNotEmpty(fillOrganCode)){
				AcuteStatisicsDto acute = new AcuteStatisicsDto();
				acute.setFillDate(DateUtil.parseSimpleDate(fillDate + "/01/01", "yyyy/MM/dd"));
				acute.setFillOrganCode(fillOrganCode.toString());
				result.add(acute);
			}
			/*合计*/
			AcuteStatisicsDto dto = statusInfoDao.findAcuteYearTotalList(criteria);
			dto.setFillOrganCode("-1");//标记为合计
			result.add(dto);
		}
		return result;			
	}

    /**
	 * 查询直报报表数据：创建人、创建机构、创建时间,包括月报表、急性传染病
	 * @param type
	 * @param orgCode
	 * @param fillDate
	 * @return	StatisticsData
	 */
	public StatisticsData getStatisticsInfo(Integer type, String orgCode, String fillDate){
		StatisticsData result = null;
		if(ObjectUtil.isNotEmpty(type)
				&& StringUtil.isNotEmpty(orgCode)
				&& StringUtil.isNotEmpty(fillDate)){
			result = statisticsDataDao.getStatisticsInfo(type, orgCode, fillDate);
		}
		return result;
	}
	
    /**查询直报报表，执行情况自查数据：创建人、创建机构、创建时间
	 * @param orgCode
	 * @param fillDate
	 * @return	SelfCheck
	 */
    public SelfCheck getSelfCheckInfo(String orgCode, String fillDate){
    	SelfCheck result = null;
		if(ObjectUtil.isNotEmpty(orgCode)
				&& StringUtil.isNotEmpty(fillDate)){
			result = idmSelfCheckDao.getSelfCheckInfo(orgCode, fillDate);
		}
		return result;
    }
}