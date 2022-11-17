package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.MentalEpilepsyPatient;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/18.
 */
public interface IMentalEpilepsyPatientService {

    public MentalEpilepsyPatient getMentalEpiPatient(Criteria criteria);

    /*判断该记录是否存在*/
    public MentalEpilepsyPatient getSingleMental(Criteria criteria);

    public List<MentalEpilepsyPatient> getMentalEpiPaList(Criteria criteria);

    //获取中心以及站  或 站
    public List<MentalEpilepsyPatient> getCenterAndStation(Criteria criteria);

    //统计若干中心及下属站
    public List<MentalEpilepsyPatient> countCenterAndStation(Criteria criteria);

    public void save(MentalEpilepsyPatient mentalEpilepsyPatient);

    public void update(MentalEpilepsyPatient mentalEpilepsyPatient);

    //统计所有的
    public MentalEpilepsyPatient countAll(Criteria criteria);
}
