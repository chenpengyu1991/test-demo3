/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * 妇幼保健
 *
 * @version 1.0, 2014-4-22
 * @author Cary
 */
public interface IWchSearchService {

	/**
	 * 医学出生证明
	 * @param page
	 * @param paramMap
	 * @return
	 * @author Cary
	 */
	public PageList<BirthCertificate> getChildBirthList(Map<String, String> paramMap, Page page);

    public PageList<BirthDefectMonitor> getBirthDefectList(Map<String, String> paramMap, Page page);

    public PageList<ChildHealthCard> getHealthCardList(Map<String, String> paramMap, Page page);

    public PageList<NeonatalFamilyVisit> getNeonatalVisitList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page);

    public PageList<ChildHealthExamination> getHealthExaminationList(Map<String, String> paramMap, Page page);

    public WomenChildHealth getWomenChildHealthNew(Criteria criteria);









	public BirthCertificate getChBirthCertificate(Criteria criteria);

    public BirthDefectMonitor getBirthDefect(Criteria criteria);

    public ChildHealthCard getHealthCard(Criteria criteria);

    public NeonatalFamilyVisit getNeonatalVisit(Criteria criteria);

	public List<NeonatalFamilyVisit> getNeonatalVisitList(Criteria criteria, Order order);

	public PageList<NeonatalFamilyVisit> getNeonatalVisitList(Criteria criteria, Page page);

    public ChildHealthExamination getHealthExamination(Criteria criteria);


    public PageList<MotherhoodPeriodFollowup> getMotherhoodPeriodList(Map<String, String> paramMap, Page page);

    public PageList<PrenatalFollowup> getPrenatalFollowupList(Map<String, String> paramMap, Page page);

    public PageList<DeliveryRecordInfo> getDeliveryList(Map<String, String> paramMap, Page page);

    public PageList<PostpartumDaysHealthInfo> getPostpartumList(Boolean flg, List<String> list, Map<String, String> paramMap, Page page);

    public PageList<WomanDiseaseCensus> getWomanDiseaseCensusList(Map<String, String> paramMap, Page page);

    public PageList<PostnatalFollowup> getPostnatalFollowupList(Boolean flg, List<String> list, Map<String, String> paramMap, Page page);

	public int saveNeonatalFamilyVisit(NeonatalFamilyVisit neonatalFamilyVisit, Organization org);

	public List<NeonatalFamilyVisit> getList(Criteria criteria, String string);

	int deleteNeonatalFamilyVisit(String id);

	public List<WomenChildHealth> getWomenChildHealthList(Criteria criteria);
	public List<WomenChildHealth> getWomenChildHealthSumList(Criteria criteria);
	public int inerstWomenChildHealth(WomenChildHealth womenChildHealth);
	public int updateWomenChildHealth(WomenChildHealth womenChildHealth);

	public PageList<WomenChildHealth> getWomenHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page);
	public PageList<WomenChildHealth> getChildHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page);

	public PageList<WomenChildHealthNew> getChildHealthNewList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page);
	public List<WomenChildHealth> getChildHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap);

	List<WomenChildHealth> getWomenHealthList(Boolean flg, List<String> orgCodes, Map<String, String> paramMap);
	public List<Map<String, Object>> exportPersonRecordList(Page page, Boolean flg, List<String> orgCodes, Map<String, String> paramMap, int type);
}