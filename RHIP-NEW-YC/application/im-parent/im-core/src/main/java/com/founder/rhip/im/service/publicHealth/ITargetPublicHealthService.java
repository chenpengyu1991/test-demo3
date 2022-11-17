/**
 * 公共卫生统计汇总（从RD_TARGET_PUBLIC_HEALTH表中获取）
 */
package com.founder.rhip.im.service.publicHealth;


import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.entity.publicHealth.RdTargetPublicHealth;

import java.util.Map;

public interface ITargetPublicHealthService {

    /**
     * 获取指标项目
     * @param ca
     * @return
     */
    RdTargetPublicHealth getTarget(Criteria ca);

    /**
     * 获取1~12月份报卡数据，key为报卡类型
     * @param criteria
     * @return
     */
    Map<String,Map<String,Object>> getReportCardTrendMap(Criteria criteria);
}