package com.founder.rhip.ehr.repository.pbusiness.student;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.pbusiness.student.ClassInfo;
import com.founder.rhip.ehr.entity.pbusiness.student.FissureSealant;

public interface IFissureSealantDao extends IDao<FissureSealant, Long> {

	public List<ClassInfo> getClasses(Date beginDate, Date endDate, String school);
	
	public List<Map<String, Object>> report(Date beginDate, Date endDate, String[] schoolCodes);

}
