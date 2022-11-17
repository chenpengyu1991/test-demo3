package com.founder.rhip.ehr.service.sync;

import java.util.List;

import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ServiceSyncLog;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;

public interface IServiceSyncLogService {

	void insertExam(PersonalPhyExamDTO personalPhyExamDTO, User currentUser, EchIdentification syncIden, String jsonType, String operate);

	void insertHbp(DmHypertensionFollowup hbpFollowup, User currentUser, String planType);
	
	void insertDi(DmDiabeticFollowup diFollowup, User currentUser, String planType);

	void deleteExam(Long personId, String physicalExamCode, String type);

	List<ServiceSyncLog> getLogs(List<String> physicalExamCodes, Long personId, String type);
	
	ServiceSyncLog getLog(String examCode, Long personId, String type);

}
