/**
 * 生活方式类统计
 */
package com.founder.rhip.im.service.publicHealth;


import com.founder.fasf.beans.Criteria;

import java.util.List;
import java.util.Map;

public interface ILifeWayService {

    /**
     * 生活方式统计
     * @param criteria
     * @type 1:饮食习惯分析,2:运动频率分析,3:吸烟状况分析,4:饮酒频率分析
     * @return
     */
    List<Map<String,Object>> getLifeWayMapList(Criteria criteria, String type);
}