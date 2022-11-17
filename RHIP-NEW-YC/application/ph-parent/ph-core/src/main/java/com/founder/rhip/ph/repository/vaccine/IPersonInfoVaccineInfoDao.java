package com.founder.rhip.ph.repository.vaccine;

import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ph.dto.vaccine.VaccinationRecordsDTO;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

public interface IPersonInfoVaccineInfoDao extends IDao<VaccinationInfo, Long> {
}
