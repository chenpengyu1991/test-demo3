package com.founder.rhip.ph.service.vaccine;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.management.InoculationAppointmentParam;
import com.founder.rhip.ehr.repository.control.IInoculationAppointmentParamDao;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("appointmentNumService")
public class InoculationAppointmentParamServiceImpl extends AbstractService implements IInoculationAppointmentParamService {
	
	@Resource
	private IInoculationAppointmentParamDao inoculationAppointmentParamDao;
	
	@Override
	public List<InoculationAppointmentParam> buildInoculationAppointmentParams(Integer countYear,String orgCode, List<Organization> orgs) {
		Criteria ca = new Criteria("countYear", countYear);
		if(StringUtil.isNotEmpty(orgCode)){
			ca.add("organCode",orgCode);
		}
		List<InoculationAppointmentParam> appointmentNumInfos = inoculationAppointmentParamDao.getInoculationAppointmentParamList(ca);
		if (ObjectUtil.isNotEmpty(appointmentNumInfos)) {
			return appointmentNumInfos;
		}
		List<InoculationAppointmentParam> appointmentNumInfoList = new ArrayList<InoculationAppointmentParam>();
		for (int i = 0; i < orgs.size(); i++) {
			InoculationAppointmentParam inoculationAppointmentParam = new InoculationAppointmentParam();
			inoculationAppointmentParam.setCountNum(0);;
			inoculationAppointmentParam.setOrganCode(orgs.get(i).getOrganCode());
			inoculationAppointmentParam.setOrganName(orgs.get(i).getOrganName());
			inoculationAppointmentParam.setCountYear(countYear);
			appointmentNumInfoList.add(inoculationAppointmentParam);
		}
		inoculationAppointmentParamDao.batchInsert(appointmentNumInfoList);
		List<InoculationAppointmentParam> aniList = inoculationAppointmentParamDao.getInoculationAppointmentParamList(ca);
		return aniList;
	}

	@Override
	public boolean saveOrUpdateInoculationAppointmentParam(List<InoculationAppointmentParam> inoculationAppointmentParams) {
		if (inoculationAppointmentParams != null && inoculationAppointmentParams.size() > 0) {
			inoculationAppointmentParamDao.batchUpdate(inoculationAppointmentParams);
			return true;
		}
		return false;
	}

}
