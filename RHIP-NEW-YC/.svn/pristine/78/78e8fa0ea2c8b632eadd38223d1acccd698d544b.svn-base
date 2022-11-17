package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.MentalEpilepsyPatient;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/18.
 */
public interface IMentalEpilepsyPatientDao extends IDao<MentalEpilepsyPatient,Long>{

    public List<Map<String,Object>> getCenterAndStation(Criteria criteria);

    public Map<String, Object> countCenterAndStation(String organCode,int year,int quarter);

    public MentalEpilepsyPatient countCenterOrStation(String organCode, int year, int quarter);

    public MentalEpilepsyPatient countCenterOrStation(String organCode,int year);

    public Map<String, Object> countCenterAndStationYear(String organCode,int year);

    public Map<String, Object> countAll(String countType,String gbCode,int year,int quarter);
}
