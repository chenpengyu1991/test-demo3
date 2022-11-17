
package com.founder.elb.service;

import com.founder.elb.entity.NoticeType;


public abstract class NoticeFactory {

	// @Resource(name = "noticeDao")
	// private INoticeDao noticeDao;
	public static INoticeService creatNoticeService(NoticeType noticeType) {
		INoticeService noticeService = null;
		switch (noticeType) {
//			case EMail:
//				noticeService = new EMailNoticeServiceImpl();
//				break;
//			case SMS:
//				noticeService = new SMSNoticeServiceImpl();
//				break;
			case PM:
				noticeService = new PMNoticeServiceImpl();
				break;
		}
		return noticeService;
	}	
}
