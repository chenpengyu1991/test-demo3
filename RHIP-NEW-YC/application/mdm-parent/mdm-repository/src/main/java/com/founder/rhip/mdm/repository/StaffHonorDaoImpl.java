package com.founder.rhip.mdm.repository;

import org.springframework.stereotype.Repository;

import com.founder.rhip.mdm.entity.StaffHonor;

@Repository("mdmStaffHonorDao")
public class StaffHonorDaoImpl extends MDMRepository<StaffHonor, Long> implements IStaffHonorDao {

}
