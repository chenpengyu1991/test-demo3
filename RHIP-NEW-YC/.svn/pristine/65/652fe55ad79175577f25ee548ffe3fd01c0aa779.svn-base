package com.founder.rhip.mdm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.StandParameterCfg;
import org.springframework.stereotype.Service;


public interface IStandParameterCfgService {
	String getValue(String paramName);

    Integer getIntegerValue(String paramName);
    Long getLongValue(String paramName);
    Boolean isValid(String paramName);

    List<StandParameterCfg> listSystemConfig(Criteria criteria);

    StandParameterCfg getSystemConfig(Criteria criteria);

    int saveSystemConfig(StandParameterCfg systemConfig);


    PageList<StandParameterCfg>  getSysConfigList(Criteria criteria, Page page);
}
