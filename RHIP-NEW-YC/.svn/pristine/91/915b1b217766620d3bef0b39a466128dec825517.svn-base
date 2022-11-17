<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/neonatalDiseaseScreen.js" type="text/javascript"></script>
<div style="float: left; width: 25%" class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<thead>
		<tr>
			<th>检测日期</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${neonatalDiseaseScreenList}" var="nfv">
			<tr onclick="brwHealthNeonatalDisease.getNeonatalDiseaseScreen(${nfv.id})" style="cursor: pointer;">
				<td>
					<input type="hidden" value="${nfv.id}" class="neonatalDiseaseScreen" />
					<fmt:formatDate value="${nfv.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 74%">
	<div id="neonatalDiseaseDiv" style="position: relative;"></div>
</div>