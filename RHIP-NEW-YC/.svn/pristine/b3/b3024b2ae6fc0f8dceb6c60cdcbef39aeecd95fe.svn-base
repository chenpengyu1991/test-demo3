/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListAi;
import com.founder.rhip.ehr.entity.control.idm.special.ListFg;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.MalariaDto;

import java.util.List;

/*
 * 疟疾专项SERVICE 
 */

public interface IMalariaService {

	/**
	 * 分页
	 * @param       criteria
	 * @param       page
	 * @return      PageList<MalariaDto>
	 */
	public PageList<IdmStatusInfo> findRegisterList(Criteria criteria, Page page);

    /**
     * @param       criteria
     * @return      PageList<MalariaDto>
     */
    public List<IdmStatusInfo> findRegisterList(Criteria criteria);

    /**
     * 添加
     * @param       malariaDto
     * @param       statusInfo
     * @return      int
     */
    public boolean save(MalariaDto malariaDto, IdmStatusInfo statusInfo, User user, Long eventId, String type) throws Exception;

    /**
     * 保存疫点处理
     * @param       malariaDto
     * @param       eventId
     * @return      int
     */
    public boolean saveEpidemicFocus(MalariaDto malariaDto, Long eventId) throws Exception;

    /**
     * 保存访视记录
     * @param       malariaDto
     * @param       eventId
     * @return      int
     */
    public boolean saveVisit(MalariaDto malariaDto, Long eventId) throws Exception;

    /**
     * 保存主动侦查
     * @param       listAis
     * @return      int
     */
    public boolean saveAi(List<ListAi> listAis) throws Exception;

    /**
     * 修改主动侦查
     * @param       listAi
     * @return      int
     */
    public boolean updateAi(ListAi listAi) throws Exception;

    /**
     * 修改
     * @param       malariaDto
     * @param       statusInfo
     * @return      int
     */
    public boolean update(MalariaDto malariaDto, IdmStatusInfo statusInfo, User user) throws Exception;

    /**
     * 删除
     * @param       idmId
     * @return      int
     */
    public boolean delete(String idmId);

    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public MalariaDto getCase(String singleId);

    /**
     * 查看督导服药登记表
     * @param       idmId
     * @return      MalariaDto
     */
    public MalariaDto getDrugRecord(String idmId, SpecialEvents event);
    /**
     * 保存督导服药登记表
     * @param       malariaDto
     * @param       user
     * @return      int
     */
    public boolean saveDrugRecord(MalariaDto malariaDto, User user, SpecialEvents event) throws Exception;

	/**
	 * 查询重点人群休止期督导服药列表
	 * @param       criteria
	 * @param       page
	 * @return      PageList<ListFg>
	 */
	public PageList<ListFg> findFgList(Criteria criteria, Page page);

	/**
	 * 查询重点人群休止期督导服药列表
	 * @param       criteria
	 * @return      List<ListFg>
	 */
    public List<ListFg> findFgList(Criteria criteria);
    /**
     * 查询主动病历侦查(分页)
     * @param       criteria
     * @param       page
     * @return      PageList<ListAi>
     */
    public PageList<ListAi> findAiList(Criteria criteria, Page page);

    /**
     * 查询主动病历侦查
     * @param       criteria
     * @return      List<ListAi>
     */
    public List<ListAi> findAiList(Criteria criteria);

    public ListAi getAi(Long id);

    public void deleteAi(Long id);

    public Long getSingleId(String idmId, String eventId);

	/**
	 * 获取患者（重点人群）
	 * @param idmId
	 * @return MalariaDto
	 */
	public MalariaDto getPatientInfo(String idmId);

	/**
	 * 获取重点人群督导服药信息
	 * @param id
	 * @return MalariaDto
	 */
	public MalariaDto getFgDrugRecord(Long id);

	/**
	 * 保存重点人群督导服药信息
	 * @param malariaDto
	 * @return boolean
	 */
	public boolean saveFgDrugRecord(MalariaDto malariaDto) throws Exception;

    /**
     * 分配
     * @param       acceptTown
     * @param       acceptUnit
     * @param       singleIds
     * @return      boolean
     */
    public boolean  distribution(String acceptTown, String acceptUnit, String[] singleIds, User user);

    /**
     * 查看一般情况表
     * @param       idmId
     * @param       event
     * @return      GeneralCondition
     */
    public GeneralCondition getGeneralCondition(String idmId, SpecialEvents event);
    
	/**
	 * 获取患者ID
	 * @param idmId
	 * @return Long 患者ID
	 */
	public Long getPersonId(Long idmId);

}