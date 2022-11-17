<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/views/hsa/reportRecord/add/view.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-report-record-back-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="hsa-report-record-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<form id="hsa-report-record-form">
	<div class="postcontent divFixed105"style="top: 60px;">
		<i class="popno">报告登记</i>
		<c:if test="${not empty locationInfo }">
			<div class="postdiv">
			<jsp:include page="../../inspection/view/locationInfoView.jsp"></jsp:include>
			</div>
		</c:if>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<jsp:include page="reportRecordInput.jsp"></jsp:include>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<jsp:include page="../app/appInfo.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>
