package com.founder.rhip.mdm.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.StaffOrg;

import java.util.List;

public interface IStaffOrgDao extends IDao<StaffOrg, Long> {

    /**
     * 因为MDM_STAFF_ORG中的主键为ORGAN_CODE、staff_code，当医务人员已经在新机构任职，老的机构就可以不用更新了，直接删除
     * @param newOrgCode
     * @param oldOrgCodes
     */
    void deleteStaffOrg(String newOrgCode, List<String> oldOrgCodes);
}
