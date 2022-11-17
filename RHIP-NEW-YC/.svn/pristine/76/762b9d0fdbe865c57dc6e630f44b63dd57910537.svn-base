package com.founder.rhip.whch.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.child.ReserveChild;
import com.founder.rhip.ehr.entity.child.ReserveVaccination;
import com.founder.rhip.ehr.entity.women.ReserveMaternal;

import java.util.Map;


/**
 * 妇女儿童保健信息保存
 * 
 * @author GaoFei
 *
 */
public interface IWhchService {
	/**
	 * 保存妇女儿童保健信息
	 * 
	 * @param dataXml 妇幼数据 XML格式
	 * @param dataType 数据类型(C01:出生医学证明、C02:新生儿疾病筛查、W01:婚前服务保健服务信息 等等)
	 * @param map TODO
	 * @return
	 */
	int saveWhchInfo(String dataXml, String dataType, Map<String, Long[]> map) throws Exception;
	
	void setExceptionFolder(String exceptionFolder);

	PageList<ReserveChild> getChildList(Page page, Criteria criteria);

	/**
	 * 孕妇体检预约
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<ReserveMaternal> getMaternalList(Page page, Criteria criteria);

	/**
	 * 预防接种预约
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<ReserveVaccination> getVaccinationList(Page page, Criteria criteria);
}
