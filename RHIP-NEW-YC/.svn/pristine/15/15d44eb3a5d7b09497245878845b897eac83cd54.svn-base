package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.InfectEmergencies;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/8.
 */
public interface IInfectiousEmergenciesService {


    public InfectEmergencies getInfectEmerGency(Criteria criteria);

    public List<InfectEmergencies> getInfectEmergencyList(Criteria criteria);

    public void save(InfectEmergencies infectEmergencies);

    public void update(InfectEmergencies infectEmergencies);

    //获取中心下所有站以及本中心的数据
    public List<InfectEmergencies> getInfectEmerOrgList(String searchOrg,String countType,String parentOrg,int year,int quarter);

    //计算单个中心以及下属站的数据的总和
    public Map<String,Object> CountZXTotal(String parentOrg,int year,int quarter);

    //计算所有中心和站的数据的总和
    public Map<String,Object> countAll(int year,int quarter,String genreCode);

    //计算单个机构中的年度统计
    public Map<String,Object> countYearOrg(String orgCode,int year);

    //获取卫管管辖区域内的所有中心
    public List<InfectEmergencies> getWGAllZX(String gbCode, int year, int quarter);

    //统计卫管管辖区域内的所有中心
    public Map<String,Object> countWGAllZX(int year,int quarter,String genreCode,String gbCode);
    							  
	public List<InfectEmergencies> getInfectEmergenciesList(Criteria criteria);
}
