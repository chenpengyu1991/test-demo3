/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugPrice;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugUse;
import com.founder.rhip.mhm.dto.MhmDrugUseDto;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/*
 * 精神卫生-药品SERVICE：药品信息、药品价格历史记录、发药记录 
 */

public interface IMhmDrugService {
	/**
	 * 查询-药品信息
	 * @param       criteria
     *
	 * @return      PageList<MhmDrug>
	 */
	public List<MhmDrug> findDrugList(Criteria criteria);
	
	/**
	 * 查询-药品信息
	 * @param       criteria
     *
	 * @return      PageList<MhmDrug>
	 */
	public PageList<MhmDrug> findDrugList(Criteria criteria,Page page);
	
	/**
	 * 获取药品信息
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public MhmDrug getMhmDrug(Criteria criteria);
	/**
	 * 保存药品信息，每次更新时，记录历史记录
	 *
	 * @param drug
	 * @return
	 * @author Ye jianfei
	 */
	public boolean saveDrug(MhmDrug drug);
	
	/**
	 * 查询-药品修改记录
	 * @param       criteria
     *
	 * @return      PageList<MhmDrugPrice>
	 */
	public PageList<MhmDrugPrice> findDrugPriceList(Criteria criteria,Page page);
	
	/**
	 * 查询-发药信息
	 * @param       criteria
     *
	 * @return      PageList<MhmDrugUse>
	 */
	public PageList<MhmDrugUse> findDrugUseList(Criteria criteria,Page page);	
	
	/**
	 * 获取发药信息--患者基本信息
	 * @param       statusId
     *
	 * @return      MhmUseDrugDto
	 */
	public MhmDrugUseDto getDrugUse(Long statusId);	
	
	/**
	 * 获取发药信息
	 * @param       MhmDrugUse
	 * @return      MhmDrugUse
	 */
	public MhmDrugUse getDrugUse(Criteria criteria);	
	
	/**
	 * 保存发药登记信息
	 *
	 * @param drugUse
	 * @return
	 * @author Ye jianfei
	 */
	public boolean saveDrugUse(MhmDrugUse drugUse);	
	
	/**
	 * 删除发药登记信息
	 *
	 * @param drugUseId
	 * @return
	 * @author Ye jianfei
	 */
	public boolean deleteDrugUse(Long drugUseId);
}