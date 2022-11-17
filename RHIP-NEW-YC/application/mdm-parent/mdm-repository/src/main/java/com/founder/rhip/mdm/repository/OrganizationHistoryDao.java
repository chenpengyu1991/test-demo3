package com.founder.rhip.mdm.repository;

import org.springframework.stereotype.Repository;

import com.founder.rhip.mdm.entity.OrganizationHistory;

@Repository("mdmOrganizationHistoryDao")
public class OrganizationHistoryDao extends MDMRepository<OrganizationHistory, Long> implements IOrganizationHistoryDao {
}
