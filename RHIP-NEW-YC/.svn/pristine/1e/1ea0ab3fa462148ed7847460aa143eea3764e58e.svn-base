<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/layouts/sticky/sticky.full.js"></script>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/js/views/layouts/sticky/sticky.full.css" type="text/css"/>--%>
<div id="header2">
    <div id="banner2" style="position:relative;">
        <%--没有这个js方法，js报错--%>
        <%--<span class="portaltop" onclick="baseLayoutLoad.updateUser('/home/load')"></span>--%>
        <span class="portaltop" onclick="baseLayoutLoad.loadMenuContent('/home/load')"></span>
		<span class="portalrightbottom">
			<b style="padding-right: 20px;">
				欢迎您，
                <c:choose>
                    <c:when test="${currentUser.userName ne 'admin' and multiOrg}">
                        <span style="cursor: pointer;" onclick="chooseOrg()"><u>${currentLoginInfo.organization.organName}</u></span>
                    </c:when>
                    <c:when test="${currentUser.userName ne 'admin' and not multiOrg}">
                        ${currentLoginInfo.organization.organName}
                    </c:when>
                </c:choose>
                <%--<c:choose><c:when test="${currentUser.userName ne 'admin'}">${currentLoginInfo.organization.organName}</c:when></c:choose> --%>
                <ehr:org code="${currentUser.orgId}"/> <span style="cursor: pointer;" id="homeUserSpId"><u>${currentUser.name}</u>！</span>
                    <span  style="cursor: pointer;" id="homeMsgId">
                        <u><span id="messageDiv"><c:if test="${newMessageNum != 0}">${newMessageNum}条新</c:if></span>消息</u>&nbsp;&nbsp;
                    </span>
                <span style="cursor: pointer;" id="homePasswordSpId"><u>修改密码</u></span>
                <input type="hidden" id="needRefresh" value="${needRefresh}">
                <input type="hidden" id="idmFrequency" value="${idmFrequency}">
			</b>
			<a href="#" id="logoutId">
                <img src="${pageContext.request.contextPath}/images/portal_out_a.gif" name="out" width="90" height="28" border="0" id="out" />
            </a>
            <br/>
		</span>
    </div>
</div>
<%--<script type="text/javascript">--%>
    <%--$(function(){--%>
        <%--var needRefresh = $("#needRefresh").val();--%>
        <%--var idmFrequency = $("#idmFrequency").val();--%>
<%--//        var cmdFrequency = $("#cmdFrequency").val();--%>
        <%--//默认30分钟刷新--%>
        <%--if($.isEmpty(idmFrequency)){--%>
            <%--idmFrequency = 30;--%>
        <%--}--%>
<%--//        if(isEmpty(cmdFrequency)){--%>
<%--//            cmdFrequency = 30;--%>
<%--//        }--%>
        <%--if("1" == needRefresh){--%>
            <%--window.setInterval(getReportCount, idmFrequency*1000*60);--%>
<%--//            window.setInterval(getReportCount, cmdFrequency*1000);--%>
        <%--}--%>
    <%--})--%>

    <%--function getReportCount() {--%>
        <%--$.getJsonByUrl({--%>
            <%--url : "/home/getLatestReport",--%>
            <%--callback : function(data) {--%>
                <%--if(data.idmCount.length > 0){--%>
                    <%--$.sticky('您有 '+'<span style="color:red">'+data.idmCount.length+'</span> 条传染病报卡待审核!');--%>
                <%--}--%>
                <%--if(data.cmdCount.length){--%>
                    <%--$.sticky('您有 '+'<span style="color:red">'+data.cmdCount.length+'</span> 条慢病报卡待审核!');--%>
                <%--}--%>
                <%--if(data.fdmCount.length){--%>
                    <%--$.sticky('您有 '+'<span style="color:red">'+data.fdmCount.length+'</span> 条食源性疾病报卡待审核!');--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>