package com.founder.rhip.mdm.service;

import com.founder.rhip.mdm.entity.EntityModel;
import com.founder.rhip.mdm.entity.EntityType;

import java.util.List;

public interface IMDMConfigService {
	
	public List<EntityModel> getEntityModels(EntityType entityType);
	
	public String[] getEntityProperties(EntityType entityType);
	
}
