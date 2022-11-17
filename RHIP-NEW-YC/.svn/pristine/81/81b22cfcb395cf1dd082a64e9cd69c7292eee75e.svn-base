package com.founder.rhip.ehr.service;

import com.founder.rhip.mdm.entity.OrgVillageRelation;

import java.util.List;

/**
 * 行政区划历史、机构区划历史
 */
public interface IOrgVillageRelationService {

	Boolean saveOrgAreaRelation(String organCode, Integer year);
	Boolean saveAdministrativeAreaRelation(String townCode, Integer year);
	List<OrgVillageRelation> getRelation(String organCode, Integer year, Integer type);

}
