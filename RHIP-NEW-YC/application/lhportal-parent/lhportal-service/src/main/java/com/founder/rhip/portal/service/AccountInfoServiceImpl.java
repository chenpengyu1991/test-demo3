package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.repository.portal.IAccountInfoDao;
import com.founder.rhip.portal.service.IAccountInfoService;

import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("lhaccountInfoService")
public class AccountInfoServiceImpl extends AbstractService implements IAccountInfoService{
	@Autowired
	private IAccountInfoDao accountInfoDao;

	@Override
	public PageList<AccountInfo> getList(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");//显示未删除信息
		return accountInfoDao.getPageList(page, criteria);
	}

	@Override
	public AccountInfo get(Criteria criteria) {
		return accountInfoDao.get(criteria);
	}
	
	@Override
	public AccountInfo get(Long id) {
		return accountInfoDao.get(id);
	}

	@Override
	public int insert(AccountInfo accountInfo) {
		 if (accountInfoDao.insert(accountInfo) > 0)
			 return 1;
		 else
			 return 0;
	}
	
	@Override
	public int update(Parameters parameters, Criteria criteria) {
		return accountInfoDao.update(parameters, criteria);
	}
	
	@Override
	public int delete(Long id) {
		int rt1 = accountInfoDao.update(new Parameters("isDelete", 1), new Criteria("id",id));//假删除
		if (rt1 != 0)
			return 1;
		else
			return 0;
	}

	@Override
	public void update(AccountInfo accountInfo) {
		accountInfoDao.update(accountInfo);
	}

	@Override
	public HashMap<String,String> getSetByType(String type){
		Criteria criteria = new Criteria("TYPE",type);
		List<AccountInfo> list = accountInfoDao.getList(criteria);
		HashMap<String,String> map = new HashMap<>();
		if(ObjectUtil.isNullOrEmpty(list)){
			return null;
		}
		for(AccountInfo set:list){
			map.put(set.getAccountName(), set.getEmail());
		}
		return map;
	}

	@Override
	public int updateStatus(AccountInfo accountInfo) {
		if (accountInfoDao.update(accountInfo) > 0)
			 return 1;
		 else
			 return 0;
	}

	@Override
	@Transactional
	public int settingPassword(Long userId) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(userId)){
			result = accountInfoDao.update(new Parameters("password", MD5Encoder.getMD5Str(WebProperties.getMsg("portal.default.pwd"))), new Criteria("id", userId));
		}
		return result;
	}

	@Override
	public String verifyUser(AccountInfo account) {
		Criteria criteria = new Criteria();
		criteria.add(new Criteria("accountName", account.getAccountName()));
		AccountInfo rs = this.get(criteria);
		if(rs==null){
			return XmlWebserviceForUtil.returnError("该用户名不存在!");
		}
		if(!MD5Encoder.getMD5Str(account.getPassword()).equals(rs.getPassword()))
		{
			return XmlWebserviceForUtil.returnError("您输入的密码与账户名不符!");
		}
		if(Constants.USER_STATUS_DISABLE.equals( rs.getStatus()))
		{
			return XmlWebserviceForUtil.returnError("该账户已被禁用，请联系管理员!");
		}
		if(Constants.USER_RESERVESTATUS_DISABLE.equals( account.getReserveStatus()))
		{
			return XmlWebserviceForUtil.returnError("该账户被禁用使用预约功能，请联系管理员!");
		}
		return XmlWebserviceForUtil.getString(rs,AccountInfo.class);
	}

	@Override
	public String createUser(AccountInfo account) {
		this.insert(account);
		return XmlWebserviceForUtil.getString(account,AccountInfo.class);
	}
	@Override
	public void update(Long id) {
		accountInfoDao.update(new Parameters("IS_READ_INFORM", "1"), new Criteria("id", id));
	}
	
	@Override
	public String changePassword(AccountInfo account) {
		Criteria criteria = new Criteria();
		criteria.add(new Criteria("accountName", account.getAccountName()));
		AccountInfo rs = this.get(criteria);
		if(rs==null){
			return XmlWebserviceForUtil.returnError("该用户名不存在!");
		}
		if(!(MD5Encoder.getMD5Str(account.getOldPassword())).equals(rs.getPassword()))
		{
			return XmlWebserviceForUtil.returnError("您输入的密码或账户名不符!");
		}
		if(Constants.USER_STATUS_DISABLE.equals( rs.getStatus()))
		{
			return XmlWebserviceForUtil.returnError("该账户已被禁用，请联系管理员!");
		}
		//md5加密密码
		rs.setPassword(MD5Encoder.getMD5Str(account.getPassword()));
		accountInfoDao.update(rs);
		return "1";
	}
}
