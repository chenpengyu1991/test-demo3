<%@page import="com.founder.rhip.portal.util.InfoConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/css/views/accountInfo/accountInfo.css" type="text/css"  rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/views/accountInfo/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/accountInfo/regeditPage.js" type="text/javascript"></script>

<div class="accountInfoBg">
	<form method="post" id="accountInfoForm">
		<div id="step1" class="step1">
			<div style="width:677px">
			<span class="light1">①登记基本信息</span>
			<span class="dark2">②身份校验</span>
			<span class="dark3">③注册成功</span>
			</div>
			<div class="registerArea">
			<ul>
				<li>
					<i class="icon-username"></i>
					<input class="register-input" type="text" name="accountName" id="accountName" placeholder="用户名（必填）" onblur="checkAccountName();"/>
					<span style="width:250px;" id="accountNameSpan"></span>
				</li>
				<li>
					<i class="icon-password"></i>
					<input class="register-input" type="password" name="password" id="password" placeholder="登录密码（必填）" onblur="checkPassword();"/>
					<span style="width:200px;padding-top:0px;" id="passwordSpan"></span>
				</li>
				<li>
					<i class="icon-password"></i>
					<input class="register-input" type="password" name="surepass" id="surepass" placeholder="确认密码（必填）" onblur="ckeckSurepass();"/>
					<span id="surepassSpan"></span>
				</li>
				<li>
					<i class="icon-username"></i>
					<input class="register-input" type="text" name="realName" id="realName" placeholder="真实姓名（必填）" onblur="checkRealName();"/>
					<span id="realNameSpan"></span>
				</li>
				<li>
					<i class="icon-idcard"></i>
					<input class="register-input" type="text" name="cardNo" id="cardNo" placeholder="身份证号码（必填）" onblur="checkCardNo();"/>
					<span id="cardNoSpan"></span>
				</li>
				<li>
					<i class="icon-email"></i>
					<input class="register-input" type="text" name="email" id="email" placeholder="邮箱地址（可不填）" onblur="checkExistEmail();"/>
					<span id="emailSpan"></span>
				</li>
				<li>
					<i class="icon-phone"></i>
					<input class="register-input" type="text" name="telephone" id="telephone" placeholder="手机号码（必填）" onblur="checkTelephones();" />
					<span id="telephoneSpan"></span>
				</li>
				<li>
					<i class="icon-checkcode"></i>
					<input class="regCheckcode-input" type="text" name="checkCode" id="checkCode" placeholder="验&nbsp;证&nbsp;码" onblur="validateCode();"/>
					<img style="height:28px; width:80px" id="imageValidator" src="${pageContext.request.contextPath}/jsp/imageValidator.jsp"
						onclick='javascript:$("#imageValidator").attr("src",contextPath+"/jsp/imageValidator.jsp?code="+Math.random())'/>
					<span id="checkCodeSpan"></span>
				</li>
			</ul>
			<div id="nextStep" class="stepBtn">
					<span>下一步</span>
			</div> 
			<div style="padding-top:5px;"><span id="accountSpan"></span></div> 
		</div>
	  </div>
	  <div id="step2" class="step2">
		<span class="dark1">①登记基本信息</span>
		<span class="light2">②身份校验</span>
		<span class="dark3">③注册成功</span>
		<div class="registerArea">
			<ul style="margin-top:60px">
				<li>
					<table>
						<tr>
							<td style="width:220px; text-align:right">您的手机号码为：</td>
							<td style="width:220px"><input class="register-input" type="text" id="checkTelephone" value="" disabled="disabled"/></td>
							<td style="width:100px;" id="td_code_0">
								<a id="btnSendCode" class="gbs gbt-orange" href="javascript:;">
								获取验证码
								</a>
							</td>
							<td style="width:100px; display:none;" id="td_code_1">
								<a id="sendingBtn" class="gbs gbt-off" href="javascript:;" >发送中...</a>
							</td>
						</tr>
						<tr>
							<td style="width:220px; text-align:right">请您输入您收到的验证码：</td>
							<td style="width:220px"><input id="registerCode" name="registerCode" class="register-input" type="text" placeholder="验证码（1分钟内有效！）"></td>
							<td style="width:110px;"><span style="padding-left:10px; margin:-10px;" id="registerCodeSpan"></span>
							</td>
						</tr>
					</table>
				</li>
			</ul>
			<div id="returnStepOne" class="stepBtn">
				<span>上一步</span>
			</div>
			<div id="register" class="stepBtn">
				<span>下一步</span>
			</div>
		</div>
	  </div>
	  <div id="step3" class="step3">
	  	  <span class="dark1">①登记基本信息</span>
		  <span class="dark2">②身份校验</span>
		  <span class="light3">③注册成功</span>
		  <div class="registerArea">
				<div style="margin-top:60px;" class="font25">恭喜您注册成功！</div>
				<input id="btnToLoginCode"  type="hidden" />
				<div style="margin-top:30px; margin-left:-25px" id="btnToLogin" class="stepBtn">
					<span>快速登录</span>
				</div> 
		  </div>
	  </div>
  </form>
  <div id="loading" class="loading-grid" style="padding-top:100px;margin-top:-550px;height:350px;padding-left:450px;">
    <div class="loading-cell">
      <div class="loading-card">
        <span class="loading-spinner-loader">Loading&#8230;</span>
      </div>
    </div>
</div>
</div>

