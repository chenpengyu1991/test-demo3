/**
 * 首页设置
 */
package com.founder.rhip.im.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.entity.basic.RdTargetIndex;
import com.founder.rhip.im.entity.basic.RdUserTarget;

import java.util.List;

public interface IHomeSettingService {

    /**
     * 获取指标列表
     * @param criteria
     * @return
     */
    List<RdTargetIndex> getTargetIndexList(Criteria criteria);

    /**
     * 保存首页布局数据
     * @param userTargetList
     * @param userCode
     * @param type
     * @return
     */
    int saveLayout(List<RdUserTarget> userTargetList,String userCode,String type);

    /**
     * 获取首页布局数据
     * @param criteria
     * @return
     */
    List<RdUserTarget> getUserTargetList(Criteria criteria);

    /**
     * 获取指标定义
     * @param criteria
     * @return
     */
    RdTargetIndex getTargetIndex(Criteria criteria);

    /**
     * 获取指标列表
     * @param type
     * @param userCode
     * @return 不包含该用户已经被选择的指标
     */
    List<RdTargetIndex> getTargetIndexList(String type,String userCode);
}