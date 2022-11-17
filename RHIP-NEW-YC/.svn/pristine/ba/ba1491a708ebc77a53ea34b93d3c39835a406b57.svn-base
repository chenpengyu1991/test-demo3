package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.AccountInfo;

import java.util.HashMap;

public interface IAccountInfoService {
	
	public static final String SENT_EMAIL = "邮件发送";
	
	PageList<AccountInfo> getList(Page page, Criteria criteria);

	AccountInfo get(Long id);
	
	AccountInfo get(Criteria criteria);
	
	int insert(AccountInfo accountInfo);
	
	int updateStatus(AccountInfo accountInfo);
	
	public int update(Parameters parameters, Criteria criteria);

	public int delete(Long id);

	void update(AccountInfo accountInfo);

	/** 
	* @Title: getSetingByType 
	* @Description: 根据类型查询
	* @param @param type
	* @param @return
	* @return HashMap<String,String>
	* @throws 
	*/
	HashMap<String, String> getSetByType(String type);

	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	public int settingPassword(Long userId);

	/**
	 * 验证健康门户网站账户
	 * @param account
	 * @return
	 */
	String verifyUser(AccountInfo  account);

	/**
	 * 创建健康门户网站账户
	 * @param account
	 * @return
	 */
	String createUser(AccountInfo  account);
	
	/**
	 * 将门户用户告知书阅读状态改为已读
	 * @param id
	 * @return
	 */
	void update(Long id);
	
	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	String changePassword(AccountInfo  account);
}
