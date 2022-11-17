<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/phyExamUtil.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/phyExamination/add.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 8px;">
	<%-- <a href="javascript:void(0)" id="cdm-phyexam-add-back-btn"><b class="fanhui">返回</b></a> --%>
	<a href="javascript:void(0)" id="cdm-phyexam-add-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
	<%-- <a href="javascript:void(0);" id="cdm-phyexam-add-save-btn"><b class="baocun">保存</b></a> --%>
	<a href="javascript:void(0);" id="cdm-phyexam-add-save-btn" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</ehr:authorize>
</div>
<div id="cdm-phyexam-main" class="contentfixed149">
	<form id="cdm-person-phyexam-form">
		<input type="hidden" name="id" value="${examination.id}"/>
		<input type="hidden" name="ehrId" value="${examination.ehrId}"/>
		<input type="hidden" name="personId" id="personId" value="${examination.personId}"/>
		<div class="postcontent">
			<i class="popno">健康体检</i>
			<jsp:include page="add_personPhyExam.jsp"></jsp:include>
		</div>
	</form>
</div>
