<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/location/add/add.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-back-locInfo-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="hsa-back-locInfo-btn" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	 <!-- <a href="javascript:void(0)" id="hsa-save-LocInfo-btn"><b
		class="baocun"
	>保存</b></a> -->
	<a href="javascript:void(0)" id="hsa-save-LocInfo-btn"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form method="post" id="hsa-add-location-form">
	<input type="hidden" name="id" value="${locationInfo.id}">
	<div class="postcontent divFixed105" style="top: 60px;">
		<i class="popno">地点信息</i>
		<jsp:include page="addLocInfoInput.jsp"></jsp:include>
	</div>
</form>
