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
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.mhm.dto.MhmMoveDto;

/*
 * 精神卫生-规范管理SERVICE 
 */

public interface IMhmMoveService {
	/**
	 * 分页查询-迁入迁出列表
	 * @param       criteria
	 * @param       page
     *
	 * @return      PageList<MhmMoveQueryDto>
	 */
	public PageList<MhmMoveQueryDto> findMoveList(Criteria criteria, Page page);

    /**
     * 获取迁入迁出具体信息
     * @param criteria
     * @return
     */
    public MhmMoveDto getMove(Criteria criteria);

    /**
     * 迁入迁出操作
     * @param moveDto
     * @return
     */
    public boolean saveMove(MhmMoveDto moveDto);

}