package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PushStaffResponse;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.portal.service.IAccountInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/portalAccount")
public class PortalAccountController extends BaseController {
	
	@Resource(name = "lhaccountInfoService")
	private IAccountInfoService lhaccountInfoService;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;
	
	@RequestMapping("/createAccount")
	@ResponseBody
	public Map<String,String> createAccount(HttpServletRequest request, String accountXml) {
		PushStaffResponse psr = new PushStaffResponse();
		try {
			AccountInfo accountInfo = unmarshal(accountXml, AccountInfo.class);
			StringBuilder textBuilder = new StringBuilder();
			if (ObjectUtil.isNullOrEmpty(accountInfo.getCardNo())) {
				textBuilder.append("身份证号码为空！");
			}
			if (ObjectUtil.isNullOrEmpty(accountInfo.getRealName())) {
				textBuilder.append("真实姓名为空！");
			}
			if (ObjectUtil.isNotEmpty(textBuilder.toString())) {
				psr.setCode(EHRConstants.AE);
				psr.setText(textBuilder.toString());
				return psr.getMap();
			}
			AccountInfo accInfo = lhaccountInfoService.get(new Criteria("cardNo", accountInfo.getCardNo()));
			if (ObjectUtil.isNotEmpty(accInfo)) {
				psr.setCode(EHRConstants.AA);
				psr.setText("该人员之前已经在健康门户注册过！");
				return psr.getMap();
			}
			PersonInfo personInfo = platformService.queryPersonalInfo("",accountInfo.getCardNo());
			//TODO:家庭医生签约都是已建档，如果单单是家庭医生签约服务调用，可以去掉此处判断
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				psr.setText("人员区域平台建立健康档案！");
				psr.setCode(EHRConstants.AE);
				return psr.getMap();
			}
//				String accountName = PinyinHelper.toHanyuPinyinString(personInfo.getName(), new HanyuPinyinOutputFormat(), "");
//				AccountInfo accif = lhaccountInfoService.get(new Criteria("accountName", accountName));
//				if (ObjectUtil.isNotEmpty(accif)) {
//					accountName += IDCardUtil.getBirthByIdCard(accountInfo.getCardNo());
//				}
			accountInfo.setAccountName(accountInfo.getCardNo()); // 家庭医生签约居民身份证就是健康门户用户名
			accountInfo.setActivateStatus("1"); //0：未激活，1：激活
			accountInfo.setStatus("1"); //1：启用,0：禁用
			accountInfo.setReserveStatus("1"); //1：启用预约,0：禁用预约
			accountInfo.setIsDelete(0);
			accountInfo.setPassword(MD5Encoder.getMD5Str(StringUtils.substring(accountInfo.getCardNo(), accountInfo.getCardNo().length() - 6, accountInfo.getCardNo().length())));
			lhaccountInfoService.createUser(accountInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			psr.setCode(EHRConstants.AE);
			psr.setText("注册门户用户出错！");
			return psr.getMap();
		}
		psr.setCode(EHRConstants.AA);
		psr.setText("注册门户用户成功！");
		return psr.getMap();
	}

}
