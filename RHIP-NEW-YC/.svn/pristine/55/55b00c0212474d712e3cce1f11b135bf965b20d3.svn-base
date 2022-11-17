<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="${pageContext.request.contextPath}/css/views/accountInfo/accountInfo.css" type="text/css"  rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/views/accountInfo/changePwd.js" type="text/javascript"></script>

<div class="accountInfoBg">
	<div class="modifyBg">
		<div class="modify-text">密码修改</div>
		<ul>
			<li>
				<i class="icon-username"></i>
				<input class="register-input" type="text" readonly="readonly" name="accountName" id="accountName" value="${accountInfo.accountName}"/>
			</li>
			<li>
				<i class="icon-password"></i>
				<input class="register-input" type="password" name="password" id="password" placeholder="原始密码"/>
				<!-- <span id="passwordSpan">请输入密码</span> -->
				<span id="passwordSpan"></span>
			</li>
			<li>
				<i class="icon-password"></i>
				<input class="register-input" type="password" name="newPassword" id="newPassword" placeholder="新密码"/>
				<!-- <span style="width:220px;padding-top:0px;" id="newPasswordSpan">必须由6~30位的英文字母、数字和字符组成，字母区分大小写</span> -->
				<span style="width:220px;padding-top:0px;" id="newPasswordSpan"></span>
			</li>
			<li>
				<i class="icon-password"></i>
				<input class="register-input" type="password" name="newPasswordAgain" id="newPasswordAgain" placeholder="确认新密码"/>
				<!-- <span id="newPasswordAgainSpan">请确认您的登录密码</span> -->
				<span id="newPasswordAgainSpan"></span>
			</li>
		</ul>
  		<div class="modifyPwdBtn">
			<div id="changePwd">
				<span>提交</span>
			</div>
			<div id="clear">
				<span>清空</span>
			</div>
			<div style="display:none" id="toLogin">
				<span>登录</span>
			</div>
  		</div>
  		<span id="messageSpan"></span>
  		<div id="loading" class="loading-grid" style="height:390px;margin-top:-300px;padding-top:100px;padding-left:200px;">
		    <div class="loading-cell">
		      <div class="loading-card">
		        <span class="loading-spinner-loader">Loading&#8230;</span>
		      </div>
		    </div>
		</div>
	</div>
</div>
