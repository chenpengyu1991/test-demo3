/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.entity.message.ReceivedInfo;

import java.util.List;

/**
 * 消息发布
 *
 * @version 1.0, 2014-8-06
 * @author Cary
 */
public interface IMessageService {

    /**
     * 发布消息
     * @param messageSent
     * @return
     */
    public void saveSendMessage(MessageSent messageSent) ;

	/**
	 * 已发布消息查询
	 * @param criteria
	 * @return
	 * @author Cary
	 */
	public PageList<MessageSent> getSentMessages(Page page, Criteria criteria);

    public List<MessageSent> getMessages(Criteria criteria);

    /**
     * 未读消息查询
     * @param criteria
     * @return
     * @author Cary
     */
    public PageList<ReceivedInfo> getPersonMsgs(Criteria criteria, Page page);
	
	/**
	 * 更新消息接受状体
	 *
	 * @param criteria
	 * @return
	 * @author Cary
	 */
	public void updateReceiveStatus(Criteria criteria);

    /**
     * 查看，如果查看对象为接受者是跟新接受状态
     * @param personal
     * @return
     */
    public MessageSent viewMessage(Criteria criteria, String personal, Long userId);
}