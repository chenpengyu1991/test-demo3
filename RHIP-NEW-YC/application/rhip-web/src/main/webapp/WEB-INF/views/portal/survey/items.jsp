<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/portal/survey/items.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.portal.common.SurveyStatus" %>

<c:set var="SAVE" value="<%=SurveyStatus.SAVE.getValue()%>"/>
<c:set var="START" value="<%=SurveyStatus.START.getValue()%>"/>
<c:set var="ENDS" value="<%=SurveyStatus.ENDS.getValue()%>"/>

<div>
    <div class="toolbar">
        <a href="javascript:void(0)" id="returnItembtnId"><b class="fanhui">返回</b></a>
        <c:if test="${type == 'edit'}">
            <a href="javascript:void(0)" id="xinzeng" style="display: none"><b class="xinz">新增</b></a>
            <a href="javascript:void(0)" id="xiugai" style="display: none"><b class="baocun">保存</b></a>
            <a href="javascript:void(0)" id="baocun"><b class="baocun">保存</b></a>
            <a href="javascript:void(0)" id="shanchu" style="display: none"><b class="zuofei">删除</b></a>
        </c:if>

    </div>
    <input type="hidden" name="surveyId" value="${surveyId}" id="surveyIdItem"/>
    <input type="hidden" id="typeId" name="type" value="${type}">
    <input type="hidden" id="surveyStatusId" name="surveyStatus" value="${surveyStatus}">
    <div class="repeattable" id="surveyItemsList" style="width:400px; float: left;margin-right: 10px; margin-top: 10px; margin-left: 10px;">
        <jsp:include page="itemList.jsp"/>
    </div>
    <div class="postcontent postdiv" id="itemDiv">
       <jsp:include page="itemDetail.jsp"/>
	</div>
</div>