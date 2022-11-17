<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/reportRecord/add/add.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-report-record-back-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="hsa-report-record-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	 <!-- <a href="javascript:void(0)" id="hsa-report-record-save-btn"><b class="baocun">保存</b></a> -->
	 <a href="javascript:void(0)" id="hsa-report-record-save-btn"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="hsa-report-record-form">
	<div class="postcontent">
		<i class="popno">报告登记</i>
		<c:if test="${not empty locationInfo }">
			<div class="postdiv">
			<jsp:include page="../../inspection/view/locationInfoView.jsp"></jsp:include>
			</div>
		</c:if>
	
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<c:set var="namePreFix" value="" scope="request"></c:set>
				<jsp:include page="reportRecordInput.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>
