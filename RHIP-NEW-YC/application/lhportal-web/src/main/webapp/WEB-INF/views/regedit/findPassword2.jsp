<%@page import="com.founder.rhip.portal.util.InfoConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/regedit/findPassword.js"></script>

<link type="text/css" rel="stylesheet" media="screen"
      href="${pageContext.request.contextPath}/css/views/regedit/step.css">
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
        <li class="ui-step-active">
            <div class="ui-step-line">-</div>
            <div class="ui-step-icon">
               <!--  <i class="iconfont">&#xf02f;</i> -->
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
        <li class="ui-step-end">
            <div class="ui-step-line">-</div>
            <div class="ui-step-icon">
                <!-- <i class="iconfont">&#xf02f;</i> -->
                <i class="ui-step-number">4</i>
                <span class="ui-step-text">完成</span>
            </div>
        </li>
    </ol>
    <FORM method="post" id="accountInfoForm">
        <input type="hidden" name="accountName" id="accountName" value="${accountInfo.accountName}"/>
        <input type="hidden" name="telephone" value="${accountInfo.telephone}"/>
        <input type="hidden" name="email" value="${accountInfo.email}"/>
        <input type="hidden" name="checkCode" value="${checkCode}"/>
        <input type="hidden" name="realName" id="realName" value="${accountInfo.realName}"/>
        <div class="g-tips-box-error" id="msgdiv" style="display:none">
		<span class="content">
				<img style="margin-right:10px;vertical-align:top;"
                     src="${pageContext.request.contextPath}/css/images/error.png">
				${msg}
		</span>
            <input type="hidden" id="msgcontent" value="${msg}"/>
            <input type="hidden" id="code" name="code" value="${code}"/>
        </div>
        <table width="100%">
            <tr>
                <td height="30" width="300px;">
                    <div align="right">请选择验证身份方式：</div>
                </td>
                <td height="30">
	                <div align="left">
	                    <select id="checkType" onchange="findPassword.checkTypeChange()" style="width: 20%;">
	                        <option value="1">手机</option>
	                        <c:if test="${not empty accountInfo.email}">
	                        	<option value="2">邮件</option>
	                        </c:if>
	                    </select>
	                </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="300px;">
                    <div align="right">登录名：</div>
                </td>
                <td height="30">
                <div align="left">
                <label id="email" name="emails">${accountInfo.accountName}</label>
                    <span id="accountNameSpan"></span>
                </div>
                </td>
            </tr>
            <tr id="tr_phone">
                <td height="30" width="300px;">
                    <div align="right">手机：</div>
                </td>
                <td height="30" id="td_phone_0">
                <div align="left">
                    <label id="telephone" name="telephones">${accountInfo.phoneWithStar}</label>
                    <a id="getCheckCodeByPhone" class="gbs gbt-orange">
                        获取验证码
                    </a>
                    <input type="hidden" id="telephone_input" value="${accountInfo.telephone}"/>
                    </div>
                </td>

                <td height="30" id="td_phone_1" style="display: none"><div align="left">
                    <label id="telephone1">${accountInfo.phoneWithStar}</label>
                    <a id="getCheckCodeByPhoneSend" class="gbs gbt-off">
                        发送中...
                    </a></div>
                </td>
            </tr>
            <tr id="tr_email" style="display:none">
                <td height="30" width="300px;">
                    <div align="right">邮箱：</div>
                </td>
                <td height="30" id="td_email_0"><div align="left"><label id="email1">${accountInfo.emailWithStar}</label>
                    <a id="getCheckCodeByEmail" class="gbs gbt-orange" href="javascript:;">
                        获取验证码
                    </a>
                    <input type="hidden" id="email_input" value="${accountInfo.email}"/>
                    </div>
                </td>
                <td height="30" id="td_email_1" style="display: none"><div align="left">
                    <label id="email2">${accountInfo.emailWithStar}</label>
                    <a id="getCheckCodeByEmailSend" class="gbs gbt-off">
                        发送中...
                    </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30">
                    <div align="right">验&nbsp;证&nbsp;码<!-- <span class="red">*</span> -->：</div>
                </td>
                <td height="30"><div align="left"><input id="checkCodes" name="checkCodes" maxlength="6" type="text" style="height: 23px;">
                    <span id="checkCodeSpan"></span></div>
                </td>
            </tr>
            <tr>
                <td height="30">&nbsp;</td>
                <td height="30">&nbsp;</td>
            </tr>
            <tr>
                <td height="30"> <div align="right"><input name="returnButton" type="button" id="returnStepOneBt" class="button green"
                           onClick="findPassword.returnStepOne()" value="上一步"></div>               
                   </td>
                <td height="30"><div align="left"> 
                    <input name="button" type="button" id="findPwdBt" class="button green"
                           onClick="findPassword.findPwdStep2()" value="下一步"></div></td>
            </tr>
        </table>
    </FORM>
</div>

