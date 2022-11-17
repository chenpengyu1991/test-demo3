package com.founder.rhip.ehr.service;

import javax.annotation.Resource;

import com.founder.fasf.beans.Order;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.OuthospitalSummary;
import com.founder.rhip.ehr.repository.clinic.IOuthospitalSummaryDao;

@Service("outhospitalSummaryService")
public class OuthospitalSummaryServiceImpl implements IOuthospitalSummaryService{
	
	@Resource
	private IOuthospitalSummaryDao outhospitalSummaryDao;
	
	@Override
	public PageList<OuthospitalSummary> getOuthospitalSummarys(Criteria criteria, Page page, Order order) {
		return outhospitalSummaryDao.getPageList(page, criteria, order);
	}
}
