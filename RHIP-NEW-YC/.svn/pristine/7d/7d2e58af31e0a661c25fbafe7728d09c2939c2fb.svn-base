package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuk
 * @since 2014/5/22 14:43
 */
@Service
public class EhrConfigServiceImpl implements  IEhrConfigService {
	//
	public static final String LIMITED_ORGAN_CODES_PARAM_KEY = "EHR_LIMITED_ORGAN_CODES";
	public static final String LIMITED_ORGAN_CODES_TYPE_KEY = "EHR_BRW";

	@Autowired(required = false)
	private IStandParameterCfgService iStandParameterCfgService;
	private Set<String> limitedOrganCodes;
	private boolean enabledLimit = false;

	@PostConstruct
	public void init() {
		if (null != iStandParameterCfgService) {
			limitedOrganCodes = new HashSet<>();
			enabledLimit = true;
			Criteria criteria = new Criteria("standardCode", LIMITED_ORGAN_CODES_TYPE_KEY);
			criteria.add("parameterCode", LIMITED_ORGAN_CODES_PARAM_KEY);
			StandParameterCfg cfg = iStandParameterCfgService.getStandParameterCfg(criteria);
			if (null != cfg) {
				String value = cfg.getParameterValue();
				if (ObjectUtil.isNotEmpty(value)) {
					String[] orgs = value.split(",");
					for (String org : orgs) {
						limitedOrganCodes.add(org);
					}
				}
			}
			limitedOrganCodes = Collections.unmodifiableSet(limitedOrganCodes);
		} else {
			limitedOrganCodes = new HashSet<>(0);
			limitedOrganCodes = Collections.unmodifiableSet(limitedOrganCodes);
			enabledLimit = false;
		}
	}

    @Override
	public boolean isLimitEnabled() {
		return enabledLimit && null != limitedOrganCodes && limitedOrganCodes.size() > 0;
	}

    @Override
	public Set<String> getLimitedOrganCode() {
		return limitedOrganCodes;
	}
}
