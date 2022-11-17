<%@page import="com.founder.rhip.portal.util.InfoConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/regedit/findPassword.js"></script>
<link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/views/regedit/step.css">
<div style="height: 400px;">
	<DIV class="areaATitle">密码找回</DIV>
	<ol class="ui-step ui-step-4">
    <li class="ui-step-done">
        <div class="ui-step-line">-</div>
        <div class="ui-step-icon">
            <!-- <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">1</i>
            <span class="ui-step-text">填写登录名</span>
        </div>
    </li>
    <li class="ui-step-done">
        <div class="ui-step-line">-</div>
        <div class="ui-step-icon">
            <!-- <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">2</i>
            <span class="ui-step-text">验证身份</span>
        </div>
    </li>
    <li class="ui-step-done">
        <div class="ui-step-line">-</div>
        <div class="ui-step-icon">
           <!--  <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">3</i>
            <span class="ui-step-text">设置新密码</span>
        </div>
    </li>
    <li class="ui-step-end ui-step-active">
        <div class="ui-step-line">-</div>    
        <div class="ui-step-icon">
           <!--  <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">4</i>
            <span class="ui-step-text">完成</span>
        </div>
    </li>
</ol>
	<FORM method="post" id="accountInfoForm">
	<input type="hidden" name="accountName" value="${accountInfo.accountName}"/>
	<input type="hidden" name="telephone" value="${accountInfo.telephone}"/>
	<input type="hidden" name="email" value="${accountInfo.email}"/>
	<input type="hidden" name="accountInfo" value="${accountInfo}"/>
	  <table width="100%" >
			<tr>
				<td align="center">${msg }</td>
			</tr>
		
			<tr>
				<td align="center" height="30">请使用新密码<a href="${pageContext.request.contextPath}/accountInfo/toLogin">重新登录</a>&nbsp;</td>
			</tr>
	  </table>
  </FORM>
    </div>

