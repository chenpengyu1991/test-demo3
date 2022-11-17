package com.founder.rhip.portal.service.util;

import com.linkage.netmsg.NetMsgclient;

public class Msgclient extends NetMsgclient {

	// 私有的默认构造子
	private Msgclient() {
//		super();
	}

	private static NetMsgclient msgClient = null;

	// 静态工厂方法
	public static NetMsgclient getInstance() {
		if (msgClient == null) {
			msgClient = new NetMsgclient();
		}
		return msgClient;
	}

}
