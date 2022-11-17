package com.founder.elb.service;

import java.util.List;
import java.util.Map;

import com.founder.elb.entity.CvAct;


public interface ICvActService {
	List<CvAct> getCvActs();
	Map<String, Map<String, String>> organizeCvActs();
}
