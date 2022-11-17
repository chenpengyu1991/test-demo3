package com.founder.rhip.ihm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.ChildCensus;

public interface IchildCensusService {

	List<ChildCensus> getChildCensusList(Criteria criteria);

}
