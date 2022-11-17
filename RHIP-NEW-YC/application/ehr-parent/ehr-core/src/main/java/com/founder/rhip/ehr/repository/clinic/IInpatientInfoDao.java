package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
/**
 * DAO interface of InpatientInfo
 */
public interface IInpatientInfoDao extends IDao<InpatientInfo, Long> {

    public List<InpatientInfo> getFList(Criteria criteria);

    /**
     * 获取出院入院相关的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getInpatientInfoStatistics(String dateStr);
    
    /**
     * 入院记录
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<InpatientInfo> getInpatientPageList(Page page, Criteria criteria, Order order);


    //治愈人数 、好转人数、死亡人数 统计
    public List<Map<String, Object>> getInpatientInfoDataSum(String dateStr);
}