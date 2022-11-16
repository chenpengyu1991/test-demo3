<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/ech/manage/perEchList.js" type="text/javascript"></script>
<jsp:include page="personInfo.jsp"></jsp:include>
<div class="section" id="ech-person-phyexam-list-box">
	<div class="toolbar">
		<a href="javascript:void(0)" id="ech-person-phyexam-list-back-btn"><b class="fanhui">返回</b></a> 
		<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">	
			<a href="javascript:void(0);" id="ech-person-phyexam-list-add-btn" data-personid="${personInfo.id}" data-type="edit"><b class="xinz" >新增</b></a>
		</ehr:authorize>
	</div>
	<div id="ech-person-phyexam-result-box" class="repeattable"></div>
</div>
<div id="ech-person-phyexam-input-box"></div>
