<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/phyExamination/view.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 8px;">
	<%-- <a href="javascript:void(0)" id="cdm-phyexam-view-back-btn"><b class="fanhui">返回</b></a> --%> 
	<a href="javascript:void(0)" id="cdm-phyexam-view-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div id="cdm-phyexam-main" class="divFixed105" style="top: 150px;">
	<form id="cdm-person-phyexam-view-form">
		<input type="hidden" id="disPersonId" name="personId" value="${diseaseInfo.personInfo.id}"> 
		<input type="hidden" id="disid" name="id" value="${diseaseInfo.id}" >
		<div class="postcontent">
			<i class="popno">健康体检</i>
			<div class="postdiv">
				<jsp:include page="view_personPhyExam.jsp"></jsp:include>
			</div>
		</div>
	</form>
</div>
