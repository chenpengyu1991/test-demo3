/**
 * copyright    Relax4J 2011
 * @date        2012-02-15
 * @author      founder
 * @version     V1.0
 * @describe    通知服务
 */

package com.founder.elb.service;

import com.founder.elb.entity.Notice;


public interface IEMailNoticeService
{
	/**
	 * 发送邮件以及通过文件路径发送邮件附件
	 * @param       Notice
	 * @return      int
	 */
	public void sendEmailByFilePath(Notice notice) throws Exception;
	
	/**
	 * 发送邮件以及通过byte[]流或base64编码字符串发送邮件附件
	 * @param       Notice
	 * @return      int
	 */
	public void sendEmailByFlow(Notice notice) throws Exception;

}