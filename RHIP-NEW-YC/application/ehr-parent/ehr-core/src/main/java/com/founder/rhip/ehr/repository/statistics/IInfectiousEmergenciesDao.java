package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.InfectEmergencies;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/8.
 */
public interface IInfectiousEmergenciesDao extends IDao<InfectEmergencies,Long> {

    public List<InfectEmergencies> getInfectEmerOrgList(String searchOrg,String countType,String parentOrgCode,int year,int quarter);

    public Map<String,Object> getZXTotal(String parentOrgCode,int year,int quarter);

    public Map<String,Object> countAll(int year,int quarter,String genreCode);

    public Map<String,Object> countYearOrg(String orgCode,int year);

    public Map<String,Object> countWGAllZX(int year,int quarter,String genreCode,String gbCode);

	public List<InfectEmergencies> getInfectEmergenciesList(Criteria criteria, List<String> organCodeList);
}
