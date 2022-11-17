package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ListEfc;

/**
 * DAO interface of IdmListEfc
 * 
 */
public interface IListEfcDao extends IDao<ListEfc,Integer> {

    /**
	 * 染病访视月报表-根据疾病编码、机构编码、年月统计密切接触者人数
	 * @param cr
	 * @return	List<InterviewStatisicsDto>
	 */
    public Integer getContactNumber(Criteria cr);
}