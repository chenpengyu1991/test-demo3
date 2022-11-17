/**
 * copyright    Relax4J 2011
 * @date        2012-02-15
 * @author      founder
 * @version     V1.0
 * @describe    通知服务
 */

package com.founder.elb.service;

import com.founder.elb.entity.Notice;



public interface INoticeService
{
	/**
	 * 平台通知
	 * @param       Notice
	 * @param       NoticeType
	 * @param       Integer... 
	 * @return      void
	 */
	public void send(Notice notice);
	

}