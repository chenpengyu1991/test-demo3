<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/view.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function() {
        healthEducationUpload.uploadFile("cdmCardHyperFile", "/he/upload/uploadFile/mbglkgxy", "/he/upload/deleteFile/mbglkgxy"); // 高血压
        healthEducationUpload.uploadFile("cdmCardDiabeteFile", "/he/upload/uploadFile/mbglktnb", "/he/upload/deleteFile/mbglktnb"); // 糖尿病
    });
</script>
<div class="toolbar" style="margin-top: 8px;">
	<%-- <a href="javascript:void(0)"  id="report-input-back-btn"><b class="fanhui">返回</b></a> --%>
	<a href="javascript:void(0)"  id="report-input-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<ehr:authorize ifAnyGranted="0107,0207,0307" >
		<c:if test="${selectedReportStatus eq '4' or selectedReportStatus eq '8' or selectedReportStatus eq '4,8,12'  or selectedReportStatus eq '6' or selectedReportStatus eq '1' or selectedReportStatus eq '2' or selectedReportStatus eq '1,2' or selectedReportStatus eq '3' }">
			<!-- <a href="javascript:void(0);" id="report-input-save-btn"><b class="tijiao">提交</b></a> -->
			<a href="javascript:void(0);" id="report-input-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>提交</button></a>
		</c:if>
	</ehr:authorize>
	
	<ehr:authorize ifAnyGranted="0207,0407" >
		<c:if test="${ selectedReportStatus eq '7' }">
			<%-- <a href="javascript:void(0);" id="report-input-save-btn"><b class="tijiao">退回</b></a> --%>
			<a href="javascript:void(0)"  id="report-input-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#x1006;</i>退回</button></a>
			<b class="xinz" style="display: none" id="save-to-manage-no-btn">纳入</b>
			<%-- <a href="javascript:void(0)" id="save-to-manage-btn"><b class="xinz">纳入管理</b></a> --%>
			<a href="javascript:void(0)" id="save-to-manage-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>纳入管理</button></a>
		</c:if>
	</ehr:authorize>
</div>
<div id="report-card-main" class="postdiv"  >
	<form id="report-input-form">
		<div class="postcontent">
			<i class="popno">报卡审核</i>
			<div class="postdiv">
				<jsp:include page="personInfo.jsp"></jsp:include>
				<c:forEach var="report" items="${reportInfos}" varStatus="status">
					<c:set var="reportInfo" scope="request" value="${report}"></c:set>
					<c:set var="index" scope="request" value="${status.index }"></c:set>
					<c:set var="allowEdit" scope="request" value="${report.allowEdit}"></c:set>
					<c:set var="approvalFlag" scope="request" value="${report.approvalFlag}"></c:set>
					<fieldset>
						<c:choose>
							<c:when test="${report.disType eq 1 }">
								<jsp:include page="hbp.jsp"></jsp:include>
							</c:when>
							<c:when test="${report.disType eq 2 }">
								<jsp:include page="di.jsp"></jsp:include>
							</c:when>
							<c:when test="${report.disType eq 4 }">
								<jsp:include page="coronary.jsp"></jsp:include>
							</c:when>
							<c:when test="${report.disType eq 3 }">
								<jsp:include page="stroke.jsp"></jsp:include>
							</c:when>
							<c:when test="${report.disType eq 5}">
								<jsp:include page="tumor.jsp"></jsp:include>
							</c:when>
						</c:choose>
						<jsp:include page="apphistory.jsp"></jsp:include>
						<%--显示审核操作 --%>
						<ehr:authorize ifAnyGranted="0207,0107,0307" >
							<jsp:include page="app.jsp"></jsp:include>
						</ehr:authorize>
						<%--社区站显示审核操作,默认退回 --%>
						<ehr:authorize ifAnyGranted="0407,0207" >
							<c:if test="${ selectedReportStatus eq '7' }">
								<input value="2"  type="hidden" name="report[${index}].approvalOp" />
								<fieldset>
									<legend>审核备注</legend>
									<table class="posttable app-op-box" data-target="report${index}-manage-select" >
										<tr>
											<td >
												备注<input type="text" name="report[${index}].comments" reg="{'maxlength':500}" />
											</td>
										</tr>
									</table>
								</fieldset>
							</c:if>
						</ehr:authorize>
					</fieldset>
				</c:forEach>
			</div>
		</div>
	</form>
</div>