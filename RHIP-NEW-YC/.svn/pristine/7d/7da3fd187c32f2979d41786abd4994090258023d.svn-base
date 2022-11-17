/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.entity.message.ReceivedInfo;
import com.founder.rhip.ehr.repository.basic.IUserRoleDao;
import com.founder.rhip.ehr.repository.ihm.IMessageReceivedDao;
import com.founder.rhip.ehr.repository.ihm.IMessageSentDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("messageService")
public class messageServiceImpl extends IhmService implements IMessageService {

	@Resource(name = "messageSentDao")
    private IMessageSentDao messageSentDao;

    @Resource(name = "messageReceivedDao")
    private IMessageReceivedDao messageReceivedDao;

    @Resource(name = "ehrUserRoleDao")
    private IUserRoleDao userRoleDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Override
    @Transactional
    public void saveSendMessage(MessageSent messageSent) {
        Long messageId = messageSentDao.generatedKey(messageSent, "ID", null).longValue();
        //获取机构下的所有用户
        String organ = messageSent.getReceivingUnit();
        Organization org = organizationApp.queryOrgan(organ);
        List<UserRole> userRole = userRoleDao.getList(new Criteria("ORGAN_CODE", org.getOrganCode()));
        List<ReceivedInfo> receivedInfos = new ArrayList<>();
        for(UserRole role : userRole){
            ReceivedInfo receivedInfo = new ReceivedInfo();
            receivedInfo.setRecipient(role.getUserCode());
            receivedInfo.setMessageId(messageId.toString());
            receivedInfo.setStatus("0");//未接受
            receivedInfo.setCreateDate(new Date());
            receivedInfo.setCreateOrganCode(messageSent.getCreateOrganCode());
            receivedInfo.setCreateUserCode(messageSent.getCreateUserCode());
            receivedInfo.setTitle(messageSent.getTitle());
            receivedInfo.setReceivingUnit(messageSent.getReceivingUnit());
            receivedInfos.add(receivedInfo);
        }
        messageReceivedDao.batchInsert(receivedInfos);
    }

    @Override
    public PageList<MessageSent> getSentMessages(Page page, Criteria criteria) {
        Order order = new Order("CREATE_DATE", false);
//        Order order = new Order("STATUS", false);
        return messageSentDao.getPageList(page, criteria, order);
    }

    @Override
    public List<MessageSent> getMessages(Criteria criteria){
        List<MessageSent> result = messageSentDao.getList(criteria);
        if(ObjectUtil.isNotEmpty(result) && result.size()>0){
            Parameters param = new Parameters();
            param.add("STATUS", "2");//已通知
            messageSentDao.update(param, criteria);
        }
        return result;
    }

    /**
     * 未读消息查询
     * @param criteria
     * @return
     * @author Cary
     */
    public PageList<ReceivedInfo> getPersonMsgs(Criteria criteria, Page page){
        Order order = new Order("STATUS", true);
        order.desc("CREATE_DATE");
        return  messageReceivedDao.getPageList(page, criteria, order);
    }

    @Override
    public void updateReceiveStatus(Criteria criteria) {
        Parameters parameter = new Parameters();
        parameter.add("STATUS", "1");//已接受
        parameter.add("RECEIVE_DATE", new Date());
        messageSentDao.update(parameter, criteria);
    }

    @Override
    @Transactional
    public MessageSent viewMessage(Criteria criteria, String personal, Long userId) {
        if("1".equals(personal)){
            Parameters parameter = new Parameters();
            parameter.add("STATUS", "1");//已接受
            parameter.add("RECEIVE_DATE", new Date());
            Long messageId = (Long) criteria.get("ID");
            Criteria ca = new Criteria("recipient", userId);
            ca.add("MESSAGE_ID", messageId);
            messageReceivedDao.update(parameter, ca);
        }
        return messageSentDao.get(criteria);
    }
}