package com.founder.rhip.ph.service.vaccine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.RabiesStatisticsDTO;
import com.founder.rhip.ehr.dto.VaccineStatisticsMonthDTO;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.control.IVaccinationEventDao;

/**
 * 
 * @author liu_jingyin
 * 
 */
@Service("vaccineStatisticsService")
public class VaccineStatisticsServiceImpl extends AbstractService implements IVaccineStatisticsService {
	@Autowired
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Resource(name = "vaccinationEventDao")
	private IVaccinationEventDao vaccinationEventDao;
	
	@Override
	public Map<String,RabiesStatisticsDTO> statistics(Date searchDate, String orgCode) {
		Date firstMonthDate = firstDateOfMonth(searchDate);
		Date lastMonthDate = lastDateOfMonth(searchDate);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(searchDate);
		int year = calendar.get(Calendar.YEAR); 
		
		Date firstYearDate = firstDateOfMonth(DateUtil.parseSimpleDate(year + "/01/01 00:00:00","yyyy/MM/dd HH:mm:ss"));
		Date lastYearDate = lastDateOfMonth(DateUtil.parseSimpleDate(year + "/12/01 00:00:00","yyyy/MM/dd HH:mm:ss"));
		
		RabiesStatisticsDTO monthRabiesStatisticsDTO = new RabiesStatisticsDTO();
		RabiesStatisticsDTO yearRabiesStatisticsDTO = new RabiesStatisticsDTO();
		
		//本月就诊人数
		monthRabiesStatisticsDTO.setOutpatient(getCount(firstMonthDate,lastMonthDate,orgCode,0));
		//本年就诊人数
		yearRabiesStatisticsDTO.setOutpatient(getCount(firstYearDate,lastYearDate,orgCode,0));
		
		//本月伤口处理人数
		monthRabiesStatisticsDTO.setWoundTreatment(getCount(firstMonthDate,lastMonthDate,orgCode,1));
		monthRabiesStatisticsDTO.setCommentVaccine(monthRabiesStatisticsDTO.getWoundTreatment());
		//本年伤口处理人数
		yearRabiesStatisticsDTO.setWoundTreatment(getCount(firstYearDate,lastYearDate,orgCode,1));
		yearRabiesStatisticsDTO.setCommentVaccine(yearRabiesStatisticsDTO.getWoundTreatment());
		
		//本月注射免疫蛋白数
		monthRabiesStatisticsDTO.setCommentGray(getCount(firstMonthDate,lastMonthDate,orgCode,2));
		//本年注射免疫蛋白数
		yearRabiesStatisticsDTO.setCommentGray(getCount(firstYearDate,lastYearDate,orgCode,2));
		
		Map<String,RabiesStatisticsDTO> map = new HashMap<String,RabiesStatisticsDTO>();
		map.put("month", monthRabiesStatisticsDTO);
		map.put("year", yearRabiesStatisticsDTO);
		
		return map;
	}
	
	
	private Integer getCount(Date firstDate,Date endDate,String orgCode,int type){
		Criteria criteria = new Criteria();
		criteria.add("EHE.EHR_TYPE", "6");
		criteria.add("DTH.IS_DELETE", 0);
		if(ObjectUtil.isNotEmpty(orgCode)){
			criteria.add("EHE.CREATE_ORGAN_CODE", orgCode);
		}
		if(type == 1){
			criteria.add("DTH.BITE_LEVEL", OP.NE, "1");
		}else if(type == 2){
			criteria.add("DTH.BITE_LEVEL", "3");
		}
		
		criteria.add("DTH.TREATMENT_TIME",OP.BETWEEN, new Date[]{firstDate,endDate});
		return ehrHealthEventDao.getCountBy(criteria);
	}
	
	
	/**
	 * @param startDate 
	 * @param endDate
	 */
	@Override
	public Map<String,VaccineStatisticsMonthDTO> statisticsByMonth(Date startDate,Date endDate){
		Map<String,VaccineStatisticsMonthDTO> ma = new HashMap<String, VaccineStatisticsMonthDTO>();
		List<Map<String,Object>> mm1 = getOutpatient( startDate, endDate);
		List<Map<String,Object>> mm2 = getWoundTreatment( startDate, endDate);
		List<Map<String,Object>> mm3 = getCommentGray( startDate, endDate);
		
		ma = getOrgList(ma,mm1,1);
		ma = getOrgList(ma,mm2,2);
		ma = getOrgList(ma,mm3,3);
		
		return ma;
	}
	
	private Map<String,VaccineStatisticsMonthDTO> getOrgList(Map<String,VaccineStatisticsMonthDTO> ma,
			List<Map<String,Object>> mm,int type){
		for(Map<String,Object> m:mm){
			Object orgCode = m.get("CREATE_ORGAN_CODE");
			if(orgCode == null){
				continue;
			}
			VaccineStatisticsMonthDTO vaccineStatisticsMonthDTO = ma.get(orgCode.toString());
			if(vaccineStatisticsMonthDTO == null){
				vaccineStatisticsMonthDTO = new VaccineStatisticsMonthDTO();
			}
			
			Integer count = Integer.parseInt(m.get("count").toString());
			vaccineStatisticsMonthDTO = setVaccineStatisticsMonthDTO(vaccineStatisticsMonthDTO, count, type);
			ma.put(orgCode.toString(), vaccineStatisticsMonthDTO);
		}
		return ma;
	}
	
	private VaccineStatisticsMonthDTO setVaccineStatisticsMonthDTO(VaccineStatisticsMonthDTO vaccineStatisticsMonthDTO,int count,int type){
		if(type == 1){
			vaccineStatisticsMonthDTO.setOutpatient(count);
		}else if(type == 2){
			vaccineStatisticsMonthDTO.setWoundTreatment(count);
			vaccineStatisticsMonthDTO.setCommentVaccine(count);
		}else if(type == 3){
			vaccineStatisticsMonthDTO.setCommentGray(count);
		}
		return vaccineStatisticsMonthDTO;
	}
	
	/**
	 * 就诊数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private List<Map<String,Object>> getOutpatient(Date startDate,Date endDate){
		Criteria criteria = new Criteria();
		
		criteria.add("EHE.EHR_TYPE", "6");
		criteria.add("DTH.IS_DELETE", 0);
		criteria.add("DTH.TREATMENT_TIME",OP.BETWEEN, new Date[]{startDate,endDate});
		
		List<Map<String,Object>> uList = ehrHealthEventDao.getCountByOrgCode(criteria);
		return uList;
	}
	
	/**
	 * 获取伤口处理数，和注射疫苗数，两数相同
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private List<Map<String,Object>> getWoundTreatment(Date startDate,Date endDate){
		Criteria criteria = new Criteria();
		
		criteria.add("EHE.EHR_TYPE", "6");
		criteria.add("DTH.BITE_LEVEL", OP.NE, "1");
		criteria.add("DTH.IS_DELETE", "0");
		criteria.add("DTH.TREATMENT_TIME",OP.BETWEEN, new Date[]{startDate,endDate});
		
		List<Map<String,Object>> uList = ehrHealthEventDao.getCountByOrgCode(criteria);
		return uList;
	}
	
	/**
	 * 获取注射免疫蛋白数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private List<Map<String,Object>> getCommentGray(Date startDate,Date endDate){
		Criteria criteria = new Criteria();
		
		criteria.add("EHE.EHR_TYPE", "6");
		criteria.add("DTH.BITE_LEVEL", "3");
		criteria.add("DTH.IS_DELETE", "0");
		criteria.add("DTH.TREATMENT_TIME",OP.BETWEEN, new Date[]{startDate,endDate});
		
		List<Map<String,Object>> uList = ehrHealthEventDao.getCountByOrgCode(criteria);
		return uList;
	}
	
	private static List<Months> getMonths(Date startDate,Date endDate){
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		int startYear = startCalendar.get(Calendar.YEAR);
		int endYear = endCalendar.get(Calendar.YEAR);
		
		int startMonth =  startCalendar.get(Calendar.MONTH) +1;
		int endMonth =  endCalendar.get(Calendar.MONTH) + 1 + 12*(endYear - startYear);
		
		List<Months> mList = new ArrayList<>();
		
		for(int i = startMonth ; i< endMonth + 1 ; i++){
			String dateString = startYear + "/" + i + "/01";
			Date d = DateUtil.parseDateString(dateString);
			
			Date msDate = firstDateOfMonth(d);
			Date meDate = lastDateOfMonth(d);
			Months month = new Months();
			
			month.startDate = msDate;
			month.endDate = meDate;
			
			mList.add(month);
		}
		
		return mList;
	}
	
	private static Date lastDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 2;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
	
	private static Date firstDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		return first;
	}
	
	public static void main(String[] args){
		Date d1 = DateUtil.parseDateString("2011/05/06");
		Date d2 = DateUtil.parseDateString("2013/05/06");
		getMonths(d1,d2);
	}


	@Override
	public List<Map<String, Object>> statisticsRabiesMapList(Criteria criteria) {
		return vaccinationEventDao.statisticsRabiesMapList(criteria);
	}

}
class Months{
	Date startDate;
	Date endDate;
	Long number;
}