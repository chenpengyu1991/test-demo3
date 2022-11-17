package com.founder.rhip.ehr.service.woman;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by bagen on 17-3-23.
 */
public interface IDeliveryService {

    public void saveDelivery(DeliveryRecordInfo deliveryRecordInfo);

    public int deleteDelivery(Long deliveryId);

    public DeliveryRecordInfo getDelivery(Criteria criteria);

    public PageList<DeliveryRecordInfo> getDeliveryList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page, HttpServletRequest request);

    public Integer getLiveBirthsNum(Integer year, Integer quarter, String orgCode);

    public List<DeliveryRecordInfo> getDeliveryOrder(Criteria criteria, Order order);

    public List<Map<String,Object>> liveBirthNum(Criteria criteria);

}
