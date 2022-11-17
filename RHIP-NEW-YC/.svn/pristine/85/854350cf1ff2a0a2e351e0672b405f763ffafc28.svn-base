<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/newBornInterview.js" type="text/javascript"></script>

<div style="float: left; width: 17%;padding-top: 5px;" class="repeattable">
	<c:forEach items="${gourpNewBornInterviewsMap}" var="newBornInterviews">
		<table class="layui-table x-admin-sm-table-list-small">
			<thead>
			<tr>
				<th title="${newBornInterviews.key}">${newBornInterviews.key}</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${newBornInterviews.value}" var="nbi">
				<tr onclick="macHealthNewBornInterview.getNewBornInterview(${nbi.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${nbi.id}" class="newBornInterview" />
						<fmt:formatDate value="${nbi.visitDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:forEach>
</div>

<div style="float: right; width: 82%">
	<div id="newBornInterviewDiv" style="position: relative;"></div>
</div>