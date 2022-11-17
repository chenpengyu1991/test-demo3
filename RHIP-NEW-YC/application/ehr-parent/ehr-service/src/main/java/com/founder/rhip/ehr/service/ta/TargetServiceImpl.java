package com.founder.rhip.ehr.service.ta;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.repository.ta.ITargetResultValueDao;

/**
 * 指标
 * 
 * @author liuk
 * @since 2014年4月10日 16:23:26
 */
@Service("targetService")
public class TargetServiceImpl extends AbstractService implements ITargetService {
	@Resource(name = "targetResultValueDao")
	private ITargetResultValueDao targetResultValueDao;

	private Set<String> noUpdateProperties;// 新增不需要更新的字段
	private Set<String> insertProperties;// 每次新增的必须字段
	private Set<String> updateProperties;// 每次更新的必须字段
	private Set<String> targetResultValueProperties;// targetResultValue所有字段
	private Set<String> targetResultValueUpdateProperties;// targetResultValue可以更新字段

	@PostConstruct
	private void init() {
		noUpdateProperties = new HashSet<>(4);
//		noUpdateProperties.add("createDate");
		noUpdateProperties.add("createOrganCode");
		noUpdateProperties.add("createUserCode");
		noUpdateProperties.add("isDelete");
		noUpdateProperties.add("id");

		updateProperties = new HashSet<>(4);
		updateProperties.add("updateDate");
		updateProperties.add("updateOrganCode");
		updateProperties.add("updateUserCode");
		updateProperties.add("type");
		updateProperties.add("createDate");

		insertProperties = new HashSet<>(4);
		insertProperties.add("isDelete");
		insertProperties.add("createDate");
		insertProperties.add("createOrganCode");
		insertProperties.add("createUserCode");
		insertProperties.add("ehrId");
		insertProperties.add("personId");
		insertProperties.add("id");
		insertProperties.add("type");
		insertProperties.addAll(updateProperties);

		ClassMetadata classMetadata = ClassMetadata.getMetadata(TargetResultValue.class);
		Map<String, PropertyMetadata> columns = classMetadata.getProperty();
		targetResultValueProperties = new HashSet<>(columns.size());
		targetResultValueUpdateProperties = new HashSet<>(columns.size());
		for (Map.Entry<String, PropertyMetadata> entry : columns.entrySet()) {
			PropertyMetadata propertyMetadata = entry.getValue();
			if (!propertyMetadata.isDbField()) {
				continue;
			}
			String p = entry.getKey();
			targetResultValueProperties.add(p);
			if (!noUpdateProperties.contains(p)) {
				targetResultValueUpdateProperties.add(p);
			}
		}
		// 初始化后不可修改
		targetResultValueUpdateProperties = Collections.unmodifiableSet(targetResultValueUpdateProperties);
		noUpdateProperties = Collections.unmodifiableSet(noUpdateProperties);
		targetResultValueProperties = Collections.unmodifiableSet(targetResultValueProperties);
		insertProperties = Collections.unmodifiableSet(insertProperties);
		updateProperties = Collections.unmodifiableSet(updateProperties);
	}

	@Override
	public List<TargetResultValue> queryTargetResultValues(Page page, Criteria criteria, Order order, Set<String> properties) {
		Assert.notNull(criteria);
		criteria.add("isDelete", EHRConstants.DELETE_FLG_0);

		List<TargetResultValue> result = null;

		String[] select = null;
		if (null != properties) {
			select = properties.toArray(new String[properties.size()]);
		}

		if (null == page) {
			result = targetResultValueDao.getList(criteria, order, select);
		} else {
			PageList<TargetResultValue> limitedResult = targetResultValueDao.getPageList(page, criteria, order, select);
			if (null != limitedResult) {
				result = limitedResult.getList();
			}
		}

		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	public void addOrUpdateTargetResultValue(TargetResultValue targetResultValue, String organCode, String userId) {
		this.addOrUpdateTargetResultValue(targetResultValue, organCode, userId, null);
	}

	public Long addOrUpdateTargetResultValue(TargetResultValue targetResultValue, String organCode, String userId, Set<String> properties) {
		Assert.notNull(targetResultValue);
		// Assert.notNull(organCode);
		// Assert.notNull(userId);
		if (null != properties) {
			Assert.notEmpty(properties, "请指定需要处理的属性!");
		}
		Long personId = targetResultValue.getPersonId();
		Assert.notNull(personId, "人员id不能为空");
		String ehrId = targetResultValue.getEhrId();
		Long id = targetResultValue.getId();
		// 对于同一个事件id,需要判断是否更新---家医履约同步过来的数据按id更新，或者新增
		TargetResultValue old = null;
		if(ObjectUtil.isNotEmpty(id)){
			Criteria criteria = new Criteria("personId", personId);
			criteria.add("id", id);
			old = targetResultValueDao.get(criteria, "id");
		}else if (ObjectUtil.isNotEmpty(ehrId)) {
			Criteria criteria = new Criteria("personId", personId);
			criteria.add("ehrId", ehrId);
			old = targetResultValueDao.get(criteria, "id");
		}

		// 如果存在,则处理为更新
		boolean update = null != old;

		// 设置默认值和检查需要处理的属性
		setDefaultValue(update, targetResultValue, organCode, userId);
		String[] select = getSelectProperties(targetResultValue, update, properties);
		check(targetResultValue, select);
		if (update) {
            targetResultValue.setId(old.getId());
			targetResultValueDao.update(targetResultValue, select);
		} else {
//			targetResultValueDao.insert(targetResultValue, select);
			Number number =  targetResultValueDao.generatedKey(targetResultValue, "ID", select);
			Assert.notNull(number);
			targetResultValue.setId(number.longValue());
		}
		return targetResultValue.getId();
	}

	private String[] getSelectProperties(TargetResultValue targetResultValue, boolean update, Set<String> properties) {
		String[] select = null;
		try {
			Set<String> set =new HashSet<>();
			set.addAll(properties);
			if (update) {
				if (null == properties) {
					properties = this.targetResultValueUpdateProperties;
				} else {
					// 去掉不需要更新的字段
					properties.removeAll(noUpdateProperties);
					properties.addAll(updateProperties);
				}
			} else {
				if (null == properties) {
					properties = targetResultValueProperties;
				} else {
					properties.addAll(insertProperties);
				}
			}
			if(set.contains("createDate")){
				properties.add("createDate");
			}
			select = properties.toArray(new String[properties.size()]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
	}

	private void check(TargetResultValue targetResultValue, String[] select) {
		// TODO
	}

	private void setDefaultValue(boolean update, TargetResultValue targetResultValue, String organCode, String userId) {
		if (!update) {
			if (null == targetResultValue.getCreateDate()) {
				targetResultValue.setCreateDate(new Date());
			}
			if (null == targetResultValue.getCreateOrganCode()) {
				targetResultValue.setCreateOrganCode(organCode);
			}
			if (null == targetResultValue.getCreateUserCode()) {
				targetResultValue.setCreateUserCode(String.valueOf(userId));
			}
			targetResultValue.setIsDelete(EHRConstants.DELETE_FLG_0);
		}
		targetResultValue.setUpdateDate(new Date());
		targetResultValue.setUpdateOrganCode(organCode);
		targetResultValue.setUpdateUserCode(String.valueOf(userId));
	}

}
