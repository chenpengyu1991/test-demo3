package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of VaccinationInfo
 */
public interface IVaccinationStatisticsDao extends IDao<VaccinationInfo, String> {

	/**
	 * 
	 * */
	List<Map<String,Object>> getCountByOrgCode(Criteria criteria);

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria);

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria);

    /**
     * 儿童接种率统计(乙肝)
     * @return
     */
   List<Map<String, Object>> getVaccinationHBV(String month);
    /**
     * 儿童接种率统计(脊灰)
     * @return
     */
   List<Map<String, Object>> getVaccinationJH(String month);
    /**
     * 儿童接种率统计(百白破)
     * @return
     */
   List<Map<String, Object>> getVaccinationBBP(String month);
    /**
     * 儿童接种率统计(流脑A)
     * @return
     */
   List<Map<String, Object>> getVaccinationLNA(String month);
    /**
     * 儿童接种率统计(麻风)
     * @return
     */
   List<Map<String, Object>> getVaccinationMF(String month);
    /**
     * 儿童接种率统计(乙脑（减毒）)
     * @return
     */
   List<Map<String, Object>> getVaccinationYNJD(String month);
    /**
     * 儿童接种率统计(麻腮风)
     * @return
     */
   List<Map<String, Object>> getVaccinationMSF(String month);
    /**
     * 儿童接种率统计(甲肝灭活)
     * @return
     */
   List<Map<String, Object>> getVaccinationJGMH(String month);
    /**
     * 儿童接种率统计(群流脑A+C)
     * @return
     */
   List<Map<String, Object>> getVaccinationQLNAC(String month);

}