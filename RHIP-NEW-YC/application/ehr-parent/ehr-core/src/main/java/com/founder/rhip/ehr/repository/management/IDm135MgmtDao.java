package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.Dm135Mgmt;

/**
 * Created by jingqiu on 17-4-19.
 */
public interface IDm135MgmtDao extends IDao<Dm135Mgmt, String> {

    /**
     * 获取在一个年度中已经按照计划完成随访的高危人群信息
     * @param criteria
     * @param page
     * @return
     */
    PageList<Dm135Mgmt> getDm135MgmtsFinishedFollow(Page page, Criteria criteria);

    /**
     * 返回true表示此时此居民可以填写评价 false表示不可以
     * @param idNo
     * @return
     */
    boolean isCanAppraise(String idNo);
}
