<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/healthCheckRecordList.js" type="text/javascript"></script>
<div style="float: left; width: 17%; margin-top: 5px" class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
	<thead>
		<tr>
			<th>随访日期</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${whYcfbjChjcList}" var="whYcfbjChjc">
			<tr onclick="brwHealthCheckRecord.getHealthCheckRecordList(${whYcfbjChjc.id})" style="cursor: pointer;">
				<input type="hidden" value="${whYcfbjChjc.id}" class="WhYcfbjChjc" />
				<td>
						<fmt:formatDate value="${whYcfbjChjc.supervisionDate}" pattern="yyyy/MM/dd"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="WhYcfbjChjcDiv" style="position: relative;"></div>
</div>