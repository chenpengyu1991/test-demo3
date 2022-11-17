<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/postnatalInterview.js" type="text/javascript"></script>
<div style="float: left; width: 17%;padding-top: 5px;" class="repeattable">
	<%-- <c:forEach items="${gourpPostnatlInterviewsMap}" var="postnatlInterviews">
		<table class="layui-table x-admin-sm-table-list-small">
		<thead>
		<tr>
			<th title="${postnatlInterviews.key}">${postnatlInterviews.key}</th>
		</tr>
		</thead>
			<tbody>
				<c:forEach items="${postnatlInterviews.value}" var="interview">
					<tr onclick="macHealthFollowUp.getInterviewDetail(${interview.id})" style="cursor: pointer;">
						<td>
							<input type="hidden" value="${interview.id}" class="postnatalInterview" />
							<fmt:formatDate value="${interview.bcfsrq}" pattern="yyyy/MM/dd"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach> --%>
	<table class="layui-table x-admin-sm-table-list-small">
		<thead>
		<tr>
			<th>随访日期</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${postnatalInterviews}" var="postnatalInterview">
			<tr onclick="macHealthFollowUp.getInterviewDetail(${postnatalInterview.id})" style="cursor: pointer;">
				<input type="hidden" value="${postnatalInterview.id}" class="postnatalInterview" />
				<td>
						<fmt:formatDate value="${postnatalInterview.visitDate}" pattern="yyyy/MM/dd"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div style="float: right; width: 82%">
	<div id="postnatalInterviewDiv" style="position: relative;"></div>
</div>