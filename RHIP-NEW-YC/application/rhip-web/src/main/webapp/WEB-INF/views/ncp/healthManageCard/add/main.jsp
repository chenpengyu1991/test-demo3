<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/ncp/healthManageCard/input/add.js" type="text/javascript"></script>
<script>
    function returnPersonRecord(){
			$("#beforeSaveDiv").show();
			$("#mbglk").hide();
    }
</script>
<c:if test="${'' eq dialogId }"><%--弹出对话框ID--%>
	<div id="toolbar" class="toolbar" style="margin-top: 10px;">
		<%-- <a href="${personRecordFlag==1?'javascript:returnPersonRecord();':'javascript:void(0);'}" id="health-card-back-btn"><b class="fanhui">返回</b></a> --%>
		<a href="${personRecordFlag==1?'javascript:returnPersonRecord();':'javascript:void(0);'}" id="health-card-back-btn" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		<c:if test="${viewFlag!='1'}">
			<!-- <a href="javascript:void(0);" id="health-card-save-btn"><b class="tijiao" >提交</b></a> -->
			<a href="javascript:void(0);" id="health-card-save-btn" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>提交</button></a>
		</c:if>
	</div>
</c:if>
<div id="health-card-main">
	<form id="health-card-form">
		<input type="hidden" id="edit" value="${edit}" >
		<input type="hidden" id="filingFlag" name="personInfo.filingFlag" value="${personInfo.filingFlag}">
	<input type="hidden" id="personId"   name="personId"  value="${personInfo.id}" > 
	<input type="hidden" id="disid"   name="id" value="${ncpPatient.id}" > 
	<input type="hidden" id="manageFlag" /> 
	
		<div class="postcontent" ${"1" eq personRecordFlag ?"style='overflow:auto;height:420px;'":""}>
			<i class="popno">新冠肺炎出院患者健康管理卡</i>
			<div class="postdiv">
				<div id="person-info"><jsp:include page="../input/add.jsp"></jsp:include>
				</div>
				<div id="dis-info"></div>
				<div id="phyexam-info"></div>
				<div id="input-info"></div>
			</div>
		</div>
	</form>
</div>
