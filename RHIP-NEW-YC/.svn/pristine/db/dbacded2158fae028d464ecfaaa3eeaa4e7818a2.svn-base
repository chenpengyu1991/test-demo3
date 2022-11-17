package com.founder.rhip.mdm.common;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.EntityModel;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IMDMConfigService;

public class CheckUtil {
	
	private String[] properties;
	
	private static CheckUtil _this;
	
	private IMDMConfigService mdmConfigService;
	
	public static CheckUtil getInstance(IMDMConfigService mdmConfigService) {
		if (_this == null) {
			_this = new CheckUtil(mdmConfigService);
		}
		return _this;
	}
	
	private CheckUtil(IMDMConfigService mdmConfigService) {
		this.mdmConfigService = mdmConfigService;
	}
	
	/**
	 * 不为空检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	public void notNullCheck(List<String> messageList, Record record, EntityType entityType) {
		List<EntityModel> notNullCheckList = getCheckList(entityType, 1);
		for (EntityModel model : notNullCheckList) {
			if (!needCheckPropty(model)) {
				continue;
			}
			Object value = getValue(record, model);
			if (ObjectUtil.isNullOrEmpty(value)) {
				messageList.add(model.getDisplayName()+"不能为空");
			}
		}
	}
	
	/**
	 * 字典数据检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	public void dictionaryCheck(List<String> messageList, Record record, EntityType entityType, ICheckDictionary checkDictionary) {
		List<EntityModel> dictionaryCheckList = getCheckList(entityType, 2);
		for (EntityModel model : dictionaryCheckList) {
			if (!needCheckPropty(model)) {
				continue;
			}
			Object value = getValue(record, model);
			String dictKey = model.getDictionary();
			if (!ObjectUtil.isNullOrEmpty(value)) {
				Map<String, String> dict = checkDictionary.getDictionary(dictKey);
				if (!ObjectUtil.isNullOrEmpty(dict)) {
					if (!dict.containsKey(value)) {
						messageList.add(model.getDisplayName()+"不合法，值：" + value);
					}
				}
			}
		}
	}
	
	/**
	 * 正则表达式检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	public void regexCheck(List<String> messageList, Record record, EntityType entityType) {
		List<EntityModel> regexCheckList = getCheckList(entityType, 3);
		for (EntityModel model : regexCheckList) {
			if (!needCheckPropty(model)) {
				continue;
			}
			Object value = getValue(record, model);
			String regex = model.getRegex();
			if (!ObjectUtil.isNullOrEmpty(value) && !(value instanceof Date)) {
				String valueStr = value.toString();
				if (!Pattern.matches(regex, valueStr)) {
					messageList.add(model.getDisplayName()+"不合法，值：" + value);
				}
			}
		}
	}
	
	/**
	 * 最大长度的检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	public void maxLengthCheck(List<String> messageList, Record record, EntityType entityType) {
		List<EntityModel> maxLengthCheckList = getCheckList(entityType, 4);
		for (EntityModel model : maxLengthCheckList) {
			if (!needCheckPropty(model)) {
				continue;
			}
			Object value = getValue(record, model);
			int maxLength = Integer.parseInt(model.getMaxLength());
			if (!ObjectUtil.isNullOrEmpty(value) && !(value instanceof Date)) {
				String valueStr = value.toString();
				int valueLength = valueStr.length();
				if (valueLength > maxLength) {
					messageList.add(model.getDisplayName() + "最多" + maxLength + "个字符，值：" + value);
				}
			}
		}
	}
	
	/**
	 * 检查所有
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	public void checkAll(List<String> messageList, Record record, EntityType entityType, ICheckDictionary checkDictionary) {
		notNullCheck(messageList, record, entityType);
		dictionaryCheck(messageList, record, entityType, checkDictionary);
		regexCheck(messageList, record, entityType);
		maxLengthCheck(messageList, record, entityType);
	}
	
	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	/**
	 * 检查输入条件的合法性
	 * @param messageList
	 * @param criteria
	 * @param entityType
	 */
	public void checkCriteria(List<String> messageList, Criteria criteria, EntityType entityType) {
		if (ObjectUtil.isNullOrEmpty(criteria)) {
			return;
		}
		List<EntityModel> allModels = mdmConfigService.getEntityModels(entityType);
		List<Criterion> criterias = criteria.getCriteria();
		for (Criterion criter : criterias) {
			String key = criter.getName();
			if (!containKey(key, allModels)) {
				messageList.add(key + "不是合法的条件属性");
			}
		}
	}
	
	public interface ICheckDictionary {
		public Map<String, String> getDictionary(String dictKey);
	}
	
	/**
	 * 取得字符串占用字节数
	 * @param str
	 * @return
	 */
	public static int getTextByteLength(String str) {
		try {
			return str.getBytes("UTF-8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 返回操作时间
	 * @return
	 */
	public static Long getOperatorTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date(System.currentTimeMillis());
		return Long.parseLong(sf.format(date));
	}
	
	private boolean containKey(String key, List<EntityModel> allModels) {
		for (EntityModel model : allModels) {
			if (key.equals(model.getPropertyName())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean needCheckPropty(EntityModel model) {
		String propertyName = model.getPropertyName();
		String fieldName = model.getFieldName();
		if (ObjectUtil.isNullOrEmpty(properties)) {
			return true;
		}
		for (String prop : properties) {
			if (prop.equalsIgnoreCase(propertyName)
					|| prop.equalsIgnoreCase(fieldName)) {
				return true;
			}
		}
		return false;
	}
	
	private Object getValue(Record record, EntityModel model) {
		String fieldName = model.getPropertyName();
		Object value = record.get(fieldName);
		if (ObjectUtil.isNullOrEmpty(value)) {
			fieldName = model.getFieldName();
			value = record.get(fieldName);
		}
		return value;
	}
	
	private Map<String, List<EntityModel>> checkListMap = new HashMap<String, List<EntityModel>>();
	
	private List<EntityModel> getCheckList(EntityType entityType, int checkType) {
		String key = String.valueOf(checkType) + "_" + entityType;
		List<EntityModel> checkList = checkListMap.get(key);
		if (checkList == null) {
			checkList = new ArrayList<EntityModel>();
			checkListMap.put(key, checkList);
			List<EntityModel> allModels = mdmConfigService.getEntityModels(entityType);
			for (EntityModel model : allModels) {
				int useable = (model.getUseable() == null) ? 0 : model.getUseable();
				if (useable == 1) {
					if (checkType == 1) {
						if (StringUtil.isNotEmpty(model.getNotNull())) {
							checkList.add(model);
						}
					}
					if (checkType == 2) {
						if (StringUtil.isNotEmpty(model.getDictionary())) {
							checkList.add(model);
						}
					}
					if (checkType == 3) {
						if (StringUtil.isNotEmpty(model.getRegex())) {
							checkList.add(model);
						}
					}
					if (checkType == 4) {
						if (StringUtil.isNotEmpty(model.getMaxLength())) {
							checkList.add(model);
						}
					}
				}
			}
		}
		return checkList;
	}

}
