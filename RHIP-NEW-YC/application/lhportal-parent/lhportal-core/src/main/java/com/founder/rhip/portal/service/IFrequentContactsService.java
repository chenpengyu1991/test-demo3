package com.founder.rhip.portal.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;

/**
 * Created by ss on 2015/11/10.
 */
public interface IFrequentContactsService {

	/***
	 * 根据id获取其常用联系人信息
	 * @param id
	 * @return
	 */
	FrequentContacts get(Long id);
	
	/***
	 * 更新用户的某个字段信息
	 * @param parameters
	 * @param criteria
	 * @return
	 */
	public int update(Parameters parameters, Criteria criteria);
	
    /**
     * 获取其常用联系人信息
     * @param page
     * @param criteria
     * @return
     */
    public PageList<FrequentContacts> getFrequentPageList(Page page, Criteria criteria);
    
    /***
     * 获取常用联系人以及其所隶属的用户的真实姓名
     * @param page
     * @param criteria
     * @return
     */
    public PageList<FrequentContacts> getRealNameByFrequentPageList(Page page, Criteria criteria);
    
    /**
     * 获取常用联系人信息
     * @param criteria
     * @return
     */
    public List<FrequentContacts> getFrequentContactsLists(Criteria criteria);

    /**
     * 排序获取常用联系人信息
     * @param criteria
     * @param order
     * @return
     */
    public List<FrequentContacts> getFrequentContactsByOrderLists(Criteria criteria, Order order);
    
    /**
     * 更新（包括新增和修改操作）常用联系人信息
     * @param frequentContacts
     * @return
     */
    public String update(FrequentContacts frequentContacts, Long accountId);

    /**
     * 删除常用联系人信息
     * @param id
     * @return
     */
    public String delete(Long id);

    
    /**
     * 获取当前联系人
     * @param criteria
     * @return
     */
    public FrequentContacts getFrequent(Criteria criteria);


}
