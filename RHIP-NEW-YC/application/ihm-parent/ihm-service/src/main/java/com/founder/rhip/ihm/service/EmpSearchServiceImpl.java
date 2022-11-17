package com.founder.rhip.ihm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.EmployeesHealthChecklist;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.child.IEmplSearchDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
@Service("empSearchService")
public class EmpSearchServiceImpl implements IEmpSearchService{
	@Resource(name = "emplSearchDao")
	private IEmplSearchDao emplSearchDao;
	@Resource
    private IPersonInfoDao personInfoDao;
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	@Override
	public PageList<EmployeesHealthChecklist> getEmployeesHealthChecklist(Boolean flg, List<String> orgCodes,
			Map<String, String> paramMap, Page page) {
		String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String idCard = paramMap.get("idCard");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        Criteria ca = new Criteria();
        if(StringUtil.isNotEmpty(name)){
            ca.add("NAME", name);
        }
        if(StringUtil.isNotEmpty(idCard)){
            ca.add("idcard", idCard);
        }
        if(StringUtil.isNotEmpty(gender)){
            ca.add("GENDERS", gender);
        }
        if(StringUtil.isNotEmpty(createDate)||StringUtil.isNotEmpty(createDateEnd)){
            DateUtil.getCriteriaByDateRange(ca, "physical_examination_date", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
        
        if(flg){
            if(ObjectUtil.isNotEmpty(organCode)){
                ca.add("CREATE_ORGAN_CODE", organCode);
            }else{
            	if(ObjectUtil.isNotEmpty(orgCodes)){
            		ca.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            	}
                
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode))
                ca.add("CREATE_ORGAN_CODE", organCode);
        }
        /*if(StringUtil.isNotEmpty(createDate)){
            DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }*/
        PageList<EmployeesHealthChecklist> pageList = emplSearchDao.getPageList(page, ca, new Order("Physical_examination_date", false));
        return pageList;
	}

	@Override
	public EmployeesHealthChecklist getHealthCheck(Criteria criteria) {
		// TODO Auto-generated method stub
		return emplSearchDao.get(criteria);
	}
	@Override
	public List<EmployeesHealthChecklist> getHealthCheckList(Criteria criteria,Order order) {
		// TODO Auto-generated method stub
		return emplSearchDao.getList(criteria,order);
	}
	@Override
	public Integer saveEmployees(EmployeesHealthChecklist employeesHealthChecklist) {
		// TODO Auto-generated method stub
		
		
		if(ObjectUtil.isNullOrEmpty(employeesHealthChecklist.getId())){
			Criteria criteria = new Criteria();
			String idCard=employeesHealthChecklist.getIdcard();
	        if (StringUtil.isNotEmpty(idCard)) {
	        	if(idCard.length()==15){
	        		if(IDCardUtil.validateIdCard15(idCard)){
	        			idCard=IDCardUtil.conver15CardTo18(idCard);
	        		}
	        		
	        		
	        	}
	            criteria.add("idcard", idCard);
	            criteria.add("FILING_FLAG","1");
	        } else {
	            return null;
	        }
	        PersonInfo personInfo = personInfoDao.get(criteria);
			 String ehrNo = EHRNumberService.getHealthFileNo(personInfo.getPastreet());
			 employeesHealthChecklist.setPhysicalExaminationNo(DateUtil.toDateString(new Date(), "yyyy-MM-dd").substring(0, 4)+ehrNo.substring(12, personInfo.getHealthFileNo().length()));
			return emplSearchDao.insert(employeesHealthChecklist);
			
		}else{
			return emplSearchDao.update(employeesHealthChecklist);
		}
	}

}
