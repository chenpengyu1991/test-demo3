/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionResult;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectDetail;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcSewageTreatment;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcTreatmentRecord;

public interface IMedicalInstService {

	/**
	 * 污水处理情况查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcSewageTreatment>
	 */
	public PageList<DmbcSewageTreatment> searchSewageTreatment(Criteria criteria,
			Page page);

	/**
	 * 污水处理情况查询
	 * 
	 * @param Long
	 * @return DmbcSewageTreatment
	 */
	public DmbcSewageTreatment searchSewageTreatment(Long id);

	/**
	 * 污水处理情况保存
	 * 
	 * @param DmbcSewageTreatment
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveSewageTreatment(DmbcSewageTreatment sewageTreatment,
			String type);

	/**
	 * 污水处理记录查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcTreatmenRecord>
	 */
	public PageList<DmbcTreatmentRecord> searchTreatmentRecord(Page page,
			Criteria criteria);

	/**
	 * 污水处理记录查询
	 * 
	 * @param Long
	 * @return DmbcTreatmenRecord
	 */
	public DmbcTreatmentRecord searchTreatmentRecord(Long id);
	/**
	 * 污水处理记录保存
	 * 
	 * @param DmbcTreatmentRecord
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveTreatmentRecord(DmbcTreatmentRecord treatmentRecord,String type);

	/**
	 * 消毒质量监测查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcDisinfectionMonitor>
	 */
	public PageList<DmbcDisinfectionMonitor> searchDisinfectionMonitor(
			Criteria criteria,Page page);

	/**
	 * 消毒质量监测查询
	 * 
	 * @param Long
	 * @return DmbcDisinfectionMonitor
	 */
	public DmbcDisinfectionMonitor searchDisinfectionMonitor(Long id);
	/**
	 * 消毒质量监测保存
	 * 
	 * @param DmbcDisinfectionMonitor
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveDisinfectionMonitor(
			DmbcDisinfectionMonitor disinfectionMonitor,String type);

	/**
	 * 消毒质量记录查询
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<DmbcDisinfectionResult>
	 */
	public PageList<DmbcDisinfectionResult> searchDisinfectionResult(
			Criteria criteria,Page page);

	/**
	 * 消毒质量记录查询
	 * 
	 * @param Long
	 * @return DmbcDisinfectionResult
	 */
	public DmbcDisinfectionResult searchDisinfectionResult(Long id);
	/**
	 * 消毒质量记录保存
	 * 
	 * @param DmbcDisinfectionResult
	 * @param String
	 * @return Boolean
	 */
	public Boolean saveDisinfectionResult(
			DmbcDisinfectionResult disinfectionResult,String type);

	/**
	 * 院内感染监测查询
	 * 
	 * @param criteria
	 * @return PageList<DmbcHInfectMonitor>
	 */
	public PageList<DmbcInfectMonitor> searchInfectMonitor(Page page, Criteria criteria);

	/**
	 * 院内感染监测保存
	 * 
	 * @param DmbcInfectMonitor
	 * @return Boolean
	 */
	public Boolean saveInfectMonitor(DmbcInfectMonitor hInfectMonitor);

	/**
	 * 院内感染监测删除
	 *
	 * @param infectMonitor
	 * @return
	 */
	public Boolean deleteInfectMonitor(DmbcInfectMonitor infectMonitor);

	/**
	 * 院内感染监测获取
	 *
	 * @param criteria
	 * @return
	 */
	public DmbcInfectMonitor getInfectMonitor(Criteria criteria);

	/**
	 * 院内感染明细查询
	 * 
	 * @param Criteria
	 * @return PageList<DmbcHInfectDetail>
	 */
	public PageList<DmbcInfectDetail> searchInfectDetail(Page page, Criteria criteria);

	/**
	 * 院内感染明细保存
	 * 
	 * @param DmbcInfectDetail
	 * @return Boolean
	 */
	public Boolean saveInfectDetail(DmbcInfectDetail hInfectDetail);

	public Boolean deleteInfectDetail(DmbcInfectDetail infectDetail);

	/**
	 * 院内感染明细获取
	 *
	 * @param criteria
	 * @return
	 */
	public DmbcInfectDetail getInfectDetail(Criteria criteria);

}