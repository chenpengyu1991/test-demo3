<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/phyExamination/perPhyList.js" type="text/javascript"></script>
<jsp:include page="personInfo.jsp"></jsp:include>
<div class="section" id="cdm-person-phyexam-list-box">
	<div class="toolbar">
		<a href="javascript:void(0)" id="cdm-person-phyexam-list-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">	
	<%-- <a href="javascript:void(0);" id="cdm-person-phyexam-list-add-btn"><b
			class="xinz"
		>新增</b></a> --%>
		<a  href="javascript:void(0);" id="cdm-person-phyexam-list-add-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</ehr:authorize>
	</div>
	<div id="cdm-person-phyexam-result-box" class="repeattable"></div>
</div>
<div id="cdm-person-phyexam-input-box"></div>
