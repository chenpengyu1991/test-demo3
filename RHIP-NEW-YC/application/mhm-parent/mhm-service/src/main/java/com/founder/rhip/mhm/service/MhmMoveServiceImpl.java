/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmMoveStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmMoveDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("mhmMoveService")
public class MhmMoveServiceImpl extends AbstractService implements IMhmMoveService {

    @Resource(name = "mhmStatusInfoDao")
    private IMhmStatusInfoDao mhmStatusInfoDao;     //状态表

    @Resource(name = "mhmEventInfoDao")
    private IMhmEventInfoDao mhmEventInfoDao;     //事件表

    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;     //基本信息

    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;       //其他表

    @Resource(name = "mhmMoveDao")
    private IMhmMoveDao mhmMoveDao;                 //迁移信息

    @Resource
    private IOrganizationApp organizationApp;       //机构

	@Override
	public PageList<MhmMoveQueryDto> findMoveList(Criteria criteria, Page page) {
		PageList<MhmMoveQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmStatusInfoDao.findMoveList(page, criteria);
		}
		return result;
	}

    @Override
    public MhmMoveDto getMove(Criteria criteria){
        MhmMoveDto result = new MhmMoveDto();
        result.setEventId(Long.parseLong(criteria.get("eventId").toString()));
        MhmMove mhmMove = mhmMoveDao.get(criteria);
        if (ObjectUtil.isNotEmpty(mhmMove)) {
            result.setMove(mhmMove);
            //迁移状态
            result.setMoveStatus(mhmMove.getFlag());
        }
        //如果有MHM_MOVE标的主键ID字段，则要去掉
        if(null != criteria.get("id") && StringUtil.isNotEmpty(criteria.get("id").toString())){
            criteria.remove("id");
        }
        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(criteria);
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
            result.setMhmBasicsInfo(mhmBasicsInfo);
        }
        MhmOtherInfo mhmOtherInfo = mhmOtherInfoDao.get(criteria);
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
            result.setMhmOtherInfo(mhmOtherInfo);
        }
        MhmEventInfo mhmEventInfo = mhmEventInfoDao.get(result.getEventId());
        MhmStatusInfo mhmStatusInfo = mhmStatusInfoDao.get(mhmEventInfo.getStatusId());
        if (ObjectUtil.isNotEmpty(mhmStatusInfo)) {
            //人的主键
            result.setStatusId(mhmStatusInfo.getId());
        }
        return result;
    }

    /**
     * 迁入迁出操作
     * @param moveDto
     * @return
     */
    public boolean saveMove(MhmMoveDto moveDto){
        boolean result = true;
        String userId = moveDto.getCurrentUser().getId().toString();
        String organId = moveDto.getCurrentOrg().getOrganCode();

        Criteria criteria = new Criteria("id", moveDto.getMove().getId());

        Parameters parameters = new Parameters();
        parameters.add("flag",moveDto.getMoveStatus());

        //状态
        moveDto.getMove().setStatusId(moveDto.getStatusId());
        moveDto.getMove().setEventId(moveDto.getEventId());
        moveDto.getMove().setFlag(moveDto.getMoveStatus());

        //更新迁移记录表（迁出是新增，迁入和退回是修改）
        if(moveDto.getMoveStatus().equalsIgnoreCase(MhmMoveStatus.OUT.getValue())){
            //登录信息
            moveDto.getMove().setMoveInOrgan(moveDto.getMhmOtherInfo().getManagementStation());
            moveDto.getMove().setMoveOutUser(userId);
            moveDto.getMove().setMoveOutOrgan(organId);
            mhmMoveDao.insert(moveDto.getMove());
        }
        //更新管理单位（纳入后才能更新管理单位，还有更新其他信息表的”迁入迁出关联有效ID“字段）
        else if(moveDto.getMoveStatus().equalsIgnoreCase(MhmMoveStatus.IN.getValue())){
            Criteria criteriaIn = new Criteria("eventId", moveDto.getEventId());

            Parameters parametersIn = new Parameters();
            Organization organization = organizationApp.queryOrgan(moveDto.getMove().getMoveInOrgan());
            parametersIn.add("managementTown",organization.getGbCode());
            parametersIn.add("managementCenter",organization.getParentCode());
            parametersIn.add("managementStation",organization.getOrganCode());
            parametersIn.add("moveId",moveDto.getMove().getId());
            mhmOtherInfoDao.update(parametersIn,criteriaIn);

            parameters.add("moveInUser",userId);
//            parameters.add("moveInOrgan",organId);
            parameters.add("moveInDt",new Date());
            mhmMoveDao.update(parameters,criteria);
        }
        //重新迁出更新原来flag状态为重新迁出，并且新增一条迁出数据
        else if(moveDto.getMoveStatus().equalsIgnoreCase(MhmMoveStatus.REOUT.getValue())){
            //更新
            mhmMoveDao.update(parameters,criteria);
            //新增
            //登录信息
            moveDto.getMove().setMoveOutUser(userId);
            moveDto.getMove().setMoveOutOrgan(organId);
            moveDto.getMove().setId(null);
            moveDto.getMove().setFlag(MhmMoveStatus.OUT.getValue());
            mhmMoveDao.insert(moveDto.getMove());
        }
        //退回或者取消迁出只更新状态
        else{
            mhmMoveDao.update(parameters,criteria);
        }

        return result;
    }
}