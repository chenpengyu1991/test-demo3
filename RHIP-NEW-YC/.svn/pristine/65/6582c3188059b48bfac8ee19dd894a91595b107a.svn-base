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
<script src="${pageContext.request.contextPath}/js/views/accountInfo/accountLogin.js" type="text/javascript"></script>

<div class="accountInfoBg">
<%-- <input type="hidden" id="lastUrl" value="${lastUrl}"/> --%>
	<div class="loginBg">
	<div class="login-text">登录</div>
		<div class="loginArea">
			<ul>
				<li>
					<i class="icon-username"></i>
					<span class="select_showbox">
						<span>用户名</span>
						<ul class="select_option" style="display: none;">
							<li val="accountName">用户名</li>
							<li val="telephone">手机号</li>
						</ul>
					</span>
					<input class="login-input" style="width:120px;margin-left: 0px;" type="text" name="accountName" id="accountName"/>
					<input class="login-input" style="width:120px;margin-left: 0px;display:none" type="text" name="telephone" id="telephone"/>
				</li>
				<li>
					<i class="icon-password"></i>
					<input class="login-input" type="password" name="password" id="password" placeholder="密&nbsp;码"/>
				</li>
				<li>
					<i class="icon-checkcode"></i>
					<input class="checkcode-input" type="text" name="checkCode" id="checkCode" placeholder="验&nbsp;证&nbsp;码"/>
					<img id="imageValidator" src="${pageContext.request.contextPath}/jsp/imageValidator.jsp"
						onclick='javascript:$("#imageValidator").attr("src",contextPath+"/jsp/imageValidator.jsp?code="+Math.random())'/>
				</li>
				<li>
					<a id="toRegister" style="color:#777777" href="javascript:void(0)"><U>注册</U>&nbsp;</a>
					<a id="toFindPwd" style="color:#777777" href="javascript:void(0)"><U>密码找回</U></a>
				</li>
			</ul>
			<div id="login" class="login-btn">
				<span>登录</span>
			</div>
			<div style="padding-top:5px;"><span id="accountSpan"></span></div> 
		</div>
		<div id="loading" class="loading-grid" style="height:390px;margin-top:-300px;padding-top:100px;padding-left:200px;">
		    <div class="loading-cell">
		      <div class="loading-card">
		        <span class="loading-spinner-loader">Loading&#8230;</span>
		      </div>
		    </div>
		</div>
	</div>
</div>
