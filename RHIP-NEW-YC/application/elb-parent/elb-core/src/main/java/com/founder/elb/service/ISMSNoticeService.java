/**
 * copyright    Relax4J 2011
 * @date        2012-02-15
 * @author      founder
 * @version     V1.0
 * @describe    通知服务
 */

package com.founder.elb.service;

import com.founder.elb.dto.SmsMoItem;
import com.founder.elb.entity.Notice;



public interface ISMSNoticeService
{
	/**
	 * 发送短信
	 * @param       Notice
	 * @return      int
	 */
	public void sendSms(Notice notice) throws Exception;
	
	/**
	 * 短信回复信息查询
	 * @param       MoItem
	 * @param       NoticeType
	 * @param       Integer... 
	 * @return      void
	 */
	public SmsMoItem receiveSms(Notice notice) throws Exception;
}