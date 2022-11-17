package com.founder.rhip.im.repository.basic;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.basic.RdTargetIndex;

import java.util.List;

/**
 * DAO interface of TargetInex
 * 
 */
public interface IRdTargetIndexDao extends IDao<RdTargetIndex,Long> {

    /**
     * 获取指标列表
     * @param type
     * @param userCode
     * @return 不包含该用户已经被选择的指标
     */
    List<RdTargetIndex> getTargetIndexList(String type, String userCode);
}