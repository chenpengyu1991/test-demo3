package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.EntityModel;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IEntityModelDao;
import com.founder.rhip.mdm.service.IMDMConfigService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mdmConfigService")
public class MDMConfigService extends MDMService implements IMDMConfigService {
	
	@Resource(name="mdmEntityModelDao")
	private IEntityModelDao entityModelDao;
	
	private Map<EntityType, List<EntityModel>> entityModelsMap = new HashMap<EntityType, List<EntityModel>>();
	
	private Map<EntityType, String[]> entityPropertiesMap = new HashMap<EntityType, String[]>();
	
	@Override
	public List<EntityModel> getEntityModels(EntityType entityType) {
		List<EntityModel> organizationModels = entityModelsMap.get(entityType);
		if (organizationModels == null) {
			Criteria criteria = new Criteria("entityId", entityType.ordinal()).add("useable", 1);
			organizationModels = entityModelDao.getList(criteria);
			if (organizationModels != null) {
				entityModelsMap.put(entityType, organizationModels);
			}
		}
		return organizationModels;
	}

	@Override
	public String[] getEntityProperties(EntityType entityType) {
		String[] organizationProperties = entityPropertiesMap.get(entityType);
		if (organizationProperties == null) {
			List<EntityModel> organizationModels = getEntityModels(entityType);
			List<String> organizationFields = new ArrayList<String>();
			for (EntityModel model : organizationModels) {
				organizationFields.add(model.getPropertyName());
			}
			organizationProperties = organizationFields.toArray(
					new String[organizationFields.size()]);
			entityPropertiesMap.put(entityType, organizationProperties);
		}
		return organizationProperties;
	}
}
