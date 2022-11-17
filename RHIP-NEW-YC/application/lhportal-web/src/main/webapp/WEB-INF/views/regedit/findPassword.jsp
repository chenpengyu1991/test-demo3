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
    <li class="ui-step-active">
        <div class="ui-step-line">-</div>
        <div class="ui-step-icon">
            <!-- <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">1</i>
            <span class="ui-step-text">填写登录名</span>
        </div>
    </li>
    <li class="ui-step-done ">
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
            <!-- <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">3</i>
            <span class="ui-step-text">设置新密码</span>
        </div>
    </li>
    <li class="ui-step-end">
        <div class="ui-step-line">-</div>    
        <div class="ui-step-icon">
            <!-- <i class="iconfont">&#xf02f;</i> -->
            <i class="ui-step-number">4</i>
            <span class="ui-step-text">完成</span>
        </div>
    </li>
</ol>
	
	<FORM method="post" id="accountInfoForm" >
	  <table width="100%">
			<tr>
				<td height="30" width="300px;"><div align="right">用户名<!-- <span class="red">*</span> -->： </div></td>
				<td height="30">
				<div align="left"><input placeholder="用户名/身份证号" id="accountName" name="accountName" maxlength="35" type="text" class="regeditIput" style="height: 23px;width: 240px;"
				value="${accountName}">
			    <span id="accountNameSpan" style="color:red">${userMsg}</span>
			    </div>
			    </td>
			</tr>
			<!-- <tr>
				<td height="30" width="300px;"><div align="right">绑定的邮箱： </div></td>
				<td height="30"><label id="email"></label>
			    <span id="accountNameSpan"></span></td>
			</tr> -->
			<tr>
				<td height="30"><div align="right">验&nbsp;证&nbsp;码<!-- <span class="red">*</span> -->： </div></td>
				<td height="30">
				<div align="left">
				<input id="checkCode" name="checkCode" maxlength="4" type="text" style="height: 23px;" value="${checkCode}">
				<img id="imageValidator" src="${pageContext.request.contextPath}/jsp/imageValidator.jsp" width="80px;" onclick='javascript:$("#imageValidator").attr("src",contextPath+"/jsp/imageValidator.jsp?code="+Math.random())'/>
				<a onclick='javascript:$("#imageValidator").attr("src",contextPath+"/jsp/imageValidator.jsp?code="+Math.random())' style="cursor: pointer">换一张</a>
				<span id="checkCodeSpan" style="color:red">${checkCodemsg}</span>
				</div>
				</td>
			</tr>
			<tr>
				<td height="30">&nbsp;</td>
				<td height="30">&nbsp;</td>
			</tr>
			<tr>
				<td height="30">&nbsp;</td>
				<td height="30"><div align="left">
				<input name="button" type="button"  id="findPwdBt" class="button green" onClick="findPassword.findPwdStep1()" value="下一步"></div></td>
			    <!-- <input name="button2" type="button"  class="search_btn" onClick="findPassword.back()" value="返回"></td> -->
			</tr>
	  </table>
  </FORM>
</div>
