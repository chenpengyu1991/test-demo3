<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/penatalScreenDiagnos.js" type="text/javascript"></script>
<div style="float: left; width: 17%;" class="repeattable">
	<table  class="layui-table x-admin-sm-table-list-small">
		<thead>
			<tr>
				<th>检查时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${penatalScreenDiagnosisList}" var="penatalScreenDiagnosis">
				<tr onclick="penatalScreenDiagnos.getPrenatalScreenDiagnosis(${penatalScreenDiagnosis.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${penatalScreenDiagnosis.id}" class="prenatalScreenDiagnosis" />
						<fmt:formatDate value="${penatalScreenDiagnosis.checkDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="penatalScreenDiagnosDiv" style="position: relative;"></div>
</div>