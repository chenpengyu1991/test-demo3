package com.founder.rhip.ehr.service.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;

import java.util.List;
import java.util.Map;

public interface IYiZhengService {

    public PageList<HmOutpatient> statisticsOutpatient(Criteria criteria,
                                                       Page page);

    public PageList<HmHospitalize> statisticsHospitalize(Criteria criteria,
                                                         Page page);

    public HmOutpatient statisticsOutpatient(Criteria criteria);

    public HmHospitalize statisticsHospitalize(Criteria criteria);

    public Boolean importHistoryData(String begin, String end);

    /**
     * 门急诊运营监管
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> statisticsOutpatient(Map<String, String> paramMap);

    /**
     * 住院运营监管
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> statisticsHmHospitalize(Map<String, String> paramMap);
}
