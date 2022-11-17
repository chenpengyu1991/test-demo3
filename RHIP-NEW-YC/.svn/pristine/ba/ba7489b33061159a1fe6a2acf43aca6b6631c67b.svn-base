package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.CheckUtil;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IMDMConfigService;


import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class MDMBaseApp implements CheckUtil.ICheckDictionary {
	
	@Resource
	private IMDMConfigService mdmConfigService;

    protected Logger log = Logger.getLogger(this.getClass());
    
    private String[] properties;
    
    private CheckUtil checkUtil;
	
	/**
	 * 不为空检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void notNullCheck(List<String> messageList, Record record, EntityType entityType) {
		getCheckUtil().notNullCheck(messageList, record, entityType);
	}
	
	/**
	 * 字典数据检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void dictionaryCheck(List<String> messageList, Record record, EntityType entityType) {
		getCheckUtil().dictionaryCheck(messageList, record, entityType, this);
	}
	
	/**
	 * 正则表达式检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void regexCheck(List<String> messageList, Record record, EntityType entityType) {
		getCheckUtil().regexCheck(messageList, record, entityType);
	}
	
	/**
	 * 最大长度的检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void maxLengthCheck(List<String> messageList, Record record, EntityType entityType) {
		getCheckUtil().maxLengthCheck(messageList, record, entityType);
	}
	
	/**
	 * 检查所有规格
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void checkAll(List<String> messageList, Record record, EntityType entityType) {
		notNullCheck(messageList, record, entityType);
		dictionaryCheck(messageList, record, entityType);
		regexCheck(messageList, record, entityType);
		maxLengthCheck(messageList, record, entityType);
	}
	
	protected void checkAll(List<String> messageList, Record record, EntityType entityType, String... properties) {
		this.properties = properties;
		checkAll(messageList, record, entityType);
	}
	
	/**
	 * 检查输入条件的合法性
	 * @param messageList
	 * @param criteria
	 * @param entityType
	 */
	protected void checkCriteria(List<String> messageList, Criteria criteria, EntityType entityType) {
		getCheckUtil().checkCriteria(messageList, criteria, entityType);
	}
	
	/**
	 * 返回检查错误
	 * @param errorMessageList
	 * @return
	 */
	protected CheckException getCheckException(List<String> errorMessageList) {
		return new CheckException("合法性检查错误：" + StringUtil.join(errorMessageList));
	}
	
	/**
	 * 返回操作时间
	 * @return
	 */
	protected Long getOperatorTime() {
		return CheckUtil.getOperatorTime();
	}
	
	/**
	 * 字典类数据检查必须重新这个方法
	 * @param dictKey
	 * @return
	 */
	public Map<String, String> getDictionary(String dictKey) {
		return null;
	}
	
	private CheckUtil getCheckUtil() {
		if (checkUtil == null) {
			checkUtil = CheckUtil.getInstance(mdmConfigService);
            //2014年3月3日 17:22:50 liuk 每次需要检查的属性并不相同
			//checkUtil.setProperties(properties);
		}
        //每次获取均需要重新设置
        checkUtil.setProperties(properties);
		return checkUtil;
	}
	
}
