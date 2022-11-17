package com.founder.elb.service;

import java.util.List;

import com.founder.elb.entity.ActCfg;
import com.founder.elb.entity.CvAct;
import com.founder.elb.entity.CvMetadata;
import com.founder.fasf.beans.Criteria;

public interface IHL7ActService {

	List<CvMetadata> getMetadatas();

	CvMetadata getMetadata(String metadataId);

	CvMetadata getMetadata(Criteria criteria);

	List<CvAct> getActs();

	CvAct getAct(Integer id);

	CvAct getAct(String code);

	CvAct getAct(Criteria criteria);

	List<ActCfg> getActConfig(Integer actCfgId);

	List<ActCfg> getActConfig(String actCode);

	List<ActCfg> getActConfig(Criteria criteria);
}
