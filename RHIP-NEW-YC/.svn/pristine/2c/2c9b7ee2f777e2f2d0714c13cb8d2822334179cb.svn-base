package com.founder.rhip.ehr.service.basic;

import java.util.List;

import com.founder.rhip.ehr.entity.basic.PcbDicItem;
import com.founder.fasf.beans.Criteria;


public interface IPcbDicItemService {

    /**
     * 根据条件获取dicCode不重复的数据
     *
     * @param criteria
     * @return
     */
    public List<PcbDicItem> queryDictionary(Criteria criteria);

    /**
     * 根据dicCode获取对应的DicItem
     *
     * @param dicCode
     * @return
     */
    public List<PcbDicItem> queryDicItem(String dicCode);
}