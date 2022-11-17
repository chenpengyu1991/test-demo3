package com.founder.rhip.ehr.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.service.IEhrConfigService;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuk
 * @since 2014/5/20 9:45
 */
public class EhrBaseController extends BaseController {

    @Autowired
    private IEhrConfigService ehrConfigService;

    public boolean isLimitEnabled(){
       return ehrConfigService.isLimitEnabled();
    }

    public  Set<String> getLimitedOrganCode(){
        return  ehrConfigService.getLimitedOrganCode();
    }

}
