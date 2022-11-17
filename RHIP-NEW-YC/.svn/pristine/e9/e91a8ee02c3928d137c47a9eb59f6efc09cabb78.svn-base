package com.founder.rhip.ehr.repository.hsa;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;

import java.util.Map;

/**
 * The interface of locationInfo dao.
 * @author liuk
 */
public interface ILocationInfoDao extends IDao<LocationInfo, Long> {

    /**
     * 分页列表
     *
     * @param page the page
     * @param cr the cr
     * @return the page location info map list
     */
    PageList<Map<String, Object>> getPageLocationInfoMapList(Page page, Criteria cr);

    /**
     * 分页列表
     *
     * @param page the page
     * @param cr the cr
     * @return the page location info list
     */
    PageList<LocationInfo> getPageLocationInfoList(Page page, Criteria cr);

    /**
     * Update by self code.
     *
     * @param info the info
     */
    void updateBySelfCode(LocationInfo info);

    /**
     * Import on update.
     *
     * @param info the info
     */
    void importOnUpdate(LocationInfo info);
}