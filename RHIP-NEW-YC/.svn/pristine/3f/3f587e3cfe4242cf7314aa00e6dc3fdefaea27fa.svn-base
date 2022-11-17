package com.founder.rhip.ehr.repository.portal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;

/**
 * Created by ss on 2015/11/10.
 */
public interface IFrequentContactsDao extends IDao<FrequentContacts, Long> {
	
	 /***
     * 获取常用联系人以及其所隶属的用户的真实姓名
     * @param page
     * @param criteria
     * @return
     */
	PageList<FrequentContacts> getRealNameByFrequentPageList(Page page, Criteria criteria);


}
