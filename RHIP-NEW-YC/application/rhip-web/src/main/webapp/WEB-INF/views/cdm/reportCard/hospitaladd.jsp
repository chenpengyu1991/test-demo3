<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/comReport.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/hosReport.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/report.js" type="text/javascript"></script>--%>
<div class="toolbar">
    <a href="javascript:void(0);" id="report-input-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>提交</button></a>
</div>
<div id="report-card-main" class="postdiv" >
	<jsp:include page="add_input.jsp"></jsp:include>
</div>