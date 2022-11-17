package com.founder.rhip.ce.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ce.ContinueEducation;
import com.founder.rhip.mdm.entity.Staff;

/**
 * Created by chen_wenbo on 2014/04/02.
 */
public interface IContinueEducationService {

    public PageList<ContinueEducation> getPageList(Page page, Criteria criteria);
    
    public List<ContinueEducation> getList(Criteria criteria);
    
    public List<ContinueEducation> getList(Criteria criteria, Order order);

    public ContinueEducation getContinueEducation(Criteria criteria);

    public int save(ContinueEducation ContinueEducation);

    public int delete(Criteria criteria);
    
    public int updateStaff(Staff staff);
    
    public Staff getStaff(Criteria criteria);
    
    public PageList<ContinueEducation> getPageStaffCodeList(Page page, Criteria criteria);

}
