/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.elb.service;

import com.founder.elb.dto.SmsMoItem;
import com.founder.elb.entity.Notice;
import com.founder.fasf.service.AbstractService;

public class SMSNoticeServiceImpl extends AbstractService implements ISMSNoticeService
{
	/* hidden 
	private APIClient handler = new APIClient();
*/
	/**
	 * 短信通知
	 * @param       Notice
	 * @param       NoticeType
	 * @param       Integer... 
	 * @return      void
	 */
	public void sendSms(Notice notice) throws Exception
	{
/* hidden 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SiteConfig  config = new SiteConfig();       //配置信息
		String host = config.getSmsServerUrl();      //移动代理服务器IP地址
		String dbName = config.getSmsDbName();       //数据库名称
		String apiCode = notice.getApiCode();        //接口编码
		String name = notice.getLoginName();         //接口登录名
		String pwd = notice.getLoginPwd();           //接口登录密码
		int connectRe = 0;
		try {
			//输入参数check
			String[] mobiles = notice.getMobiles();
			if (mobiles == null || mobiles.length == 0) {
				log.error(sdf.format(new Date() + notice.getScene() + "手机号码为空。"));
			} else {
				String regex = "^[1]+[3,5]+\\d{9}$";
				boolean flg = false;
				int cnt = 0;
				for(String mobile:mobiles) {
					flg = match(regex, mobile);
					if (flg == false) {
						cnt++;
						log.info(sdf.format(new Date() + notice.getScene() + "手机号码为空。"));
					}
				}
				if (cnt == mobiles.length) {
					log.error(sdf.format(new Date() + notice.getScene() + "所有手机号码格式不正确。"));
				}
			}

			//移动MAS初始化
			connectRe = handler.init(host, name, pwd, apiCode,dbName);
			if ( connectRe != 0) {
				log.error(sdf.format(new Date() + notice.getScene() + "移动MAS初始化失败。"));
				return;
			}
			
			//发送短信
			connectRe = handler.sendSM(mobiles, notice.getContent(), notice.getSrcId());
			if ( connectRe != 0) {
				log.error(sdf.format(new Date() + notice.getScene() + "移动MAS短信发送失败。"));
				return;
			}
			
			//断开连接，释放资源
			handler.release();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
*/
	}

	/**
	 * 平台接收通知
	 * @param       Notice
	 * @param       NoticeType
	 * @param       Integer... 
	 * @return      void
	 */
	public SmsMoItem receiveSms(Notice notice) throws Exception {

	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SiteConfig  config = new SiteConfig();       //配置信息
		String host = config.getSmsServerUrl();      //移动代理服务器IP地址
		String dbName = config.getSmsDbName();       //数据库名称
		String apiCode = notice.getApiCode();        //接口编码
		String name = notice.getLoginName();         //接口登录名
		String pwd = notice.getLoginPwd();           //接口登录密码
		int connectRe = 0;*/
		SmsMoItem ReturnItem = new SmsMoItem();
/* hidden 
		try {
			//输入参数check
			Long srcId = notice.getSrcId();
	        if (srcId == null || srcId <= new Long(0)) {
				log.error(sdf.format(new Date() + notice.getScene() + "短信尾码不正确。"));
				return ReturnItem;
	        }

			//移动MAS初始化
			connectRe = handler.init(host, name, pwd, apiCode,dbName);
			if ( connectRe != 0) {
				log.error(sdf.format(new Date() + notice.getScene() + "移动MAS初始化失败。"));
				return ReturnItem;
			}
			
			//接收回复短信
			MOItem[] items = handler.receiveSM(srcId, -1);

			if (items == null) {
				log.error(sdf.format(new Date() + notice.getScene() + "移动MAS短信回复信息查询失败。"));
				return ReturnItem;
			} else {
				int len = items.length;
				ReturnItem.setReturnCnt(len);
				if (len > 0) {
					String[] mobiles = new String[len];
					String[] contents = new String[len];
					String[] moTimes = new String[len];
					long[] smIds = new long[len];
					for(int i=0; i<len; i++) {
						mobiles[i] = items[i].getMobile();
						contents[i] = items[i].getContent();
						moTimes[i] = items[i].getMoTime();
						smIds[i] = items[i].getSmID();
					}
					ReturnItem.setMobiles(mobiles);
					ReturnItem.setContents(contents);
					ReturnItem.setMoTimes(moTimes);
					ReturnItem.setSmIds(smIds);
				}
			}
			//断开连接，释放资源
			handler.release();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(sdf.format(new Date() + notice.getScene() + "异常错误，短息回复信息查询失败。"));
			throw e;
		}
*/
		return ReturnItem;
	}
	
	/*private boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}*/


}