<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/view.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 8px;">
	<%-- <a href="javascript:void(0)"  id="report-input-back-btn"><b class="fanhui">返回</b></a> --%>
	<a href="javascript:void(0)"  id="report-input-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div id="report-card-main" class="postdiv"  >
	<form id="report-input-form">
		<div class="postcontent">
			<i class="popno">报卡查看</i>
			<div class="postdiv">
				<jsp:include page="../app/personInfo.jsp"></jsp:include>
				<c:forEach var="report" items="${reportInfos}" varStatus="status">
					<c:set var="reportInfo" scope="request" value="${report}"></c:set>
					<c:set var="index" scope="request" value="${status.index }"></c:set>
					<c:set var="allowEdit" scope="request" value="${false}"></c:set>
					<c:set var="approvalFlag" scope="request" value="0"></c:set>
					<fieldset class="layui-elem-field">
					<c:choose>
						<c:when test="${report.disType eq 1 }">
							<jsp:include page="../app/hbp.jsp"></jsp:include>
						</c:when>
						<c:when test="${report.disType eq 2 }">
							<jsp:include page="../app/di.jsp"></jsp:include>
						</c:when>
						<c:when test="${report.disType eq 4 }">
							<jsp:include page="../app/coronary.jsp"></jsp:include>
						</c:when>
						<c:when test="${report.disType eq 3 }">
							<jsp:include page="../app/stroke.jsp"></jsp:include>
						</c:when>
						<c:when test="${report.disType eq 5}">
							<jsp:include page="../app/tumor.jsp"></jsp:include>
						</c:when>
					</c:choose>
					<jsp:include page="../app/apphistory.jsp"></jsp:include>
					</fieldset>
				</c:forEach>
			</div>
		</div>
	</form>
</div>