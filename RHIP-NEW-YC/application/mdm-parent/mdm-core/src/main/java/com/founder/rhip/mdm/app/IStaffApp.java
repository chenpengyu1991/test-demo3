package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Staff;

import java.util.List;

public interface IStaffApp {

	public Staff registStaff(Staff staff) throws CheckException, Exception;
	
	public List<Staff> queryStaff(Criteria criteria) throws CheckException, Exception;
}
