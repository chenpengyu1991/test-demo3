package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.ChargeItem;
import com.founder.rhip.ehr.repository.portal.IChargeItemRelevantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by f on 2016/11/24.
 */
@Service("chargeItemService")
public class ChargeItemServiceImpl implements IChargeItemService {
    @Autowired
    private IChargeItemRelevantDao chargeItemRelevantDao;

    @Override
    public PageList<ChargeItem> getChargeItemPageList(Page page, Criteria criteria) {
        return chargeItemRelevantDao.getPageList(page, criteria, getOrder());
    }

    private Order getOrder() {
        Order order = new Order("TYPE");
        order.asc("ITEM_NAME");
        return order;
    }

}
