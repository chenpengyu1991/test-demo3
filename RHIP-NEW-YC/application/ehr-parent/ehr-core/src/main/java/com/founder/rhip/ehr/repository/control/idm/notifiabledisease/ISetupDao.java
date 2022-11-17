package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;

import java.util.List;

public interface ISetupDao extends IDao<IdmSetup,Long> {
	
   /**
    * 删除设置
    * @param infectiousCodes
    * @param caseOrganCodes
    * @param getSetYear
    */
   public void deleteSetups(String[] infectiousCodes, String[] caseOrganCodes, Integer getSetYear);

   /**
    * 根据条件查询出不重复的INFECTIOUS_CODE
    * @param criteria
    * @return
    */
   public List<IdmSetup> findDistinctInfectiousCodes(Criteria criteria);
}