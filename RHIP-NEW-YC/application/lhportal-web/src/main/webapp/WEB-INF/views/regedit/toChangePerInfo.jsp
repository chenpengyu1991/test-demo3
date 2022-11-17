<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="${pageContext.request.contextPath}/css/views/accountInfo/accountInfo.css" type="text/css"  rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/views/accountInfo/changePerInfo.js" type="text/javascript"></script>

<div class="accountInfoBg">
	<div class="modifyBg">
		<div class="modify-text">个人信息修改</div>
		<ul>
			<li>
				<i class="icon-username"></i>
				<input class="register-input" type="text" disabled="disabled" name="accountName" id="accountName" value="${accountInfo.accountName}"/>
			</li>
			<li>
				<i class="icon-username"></i>
				<input class="register-input" type="text" disabled="disabled" name="realName" id="realName" value="${accountInfo.realName}"/>
			</li> 
			<li>
				<i class="icon-idcard"></i>
				<input class="register-input" type="text" disabled="disabled"  name="cardNo" id="cardNo" value="${accountInfo.cardNo}"/>
			</li>
			<li>
				<i class="icon-phone"></i>
				<input class="register-input" type="text" disabled="disabled" name="telephone" id="telephone" value="${accountInfo.telephone}" onblur="checkTelephones();"/>
				<span id="telephoneSpan"></span>
			</li>
			<li>
				<i class="icon-email"></i>
				<input class="register-input" type="text" disabled="disabled" name="email" id="email" value="${accountInfo.email}"/>
				<span id="emailSpan"></span>
			</li>
		</ul>
  		<div class="modifyPwdBtn">
			<div id="updatePerInfo">
				<span>修改</span>
			</div>
			<div id="savePerInfo" style="display:none">
				<span>保存</span>
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
