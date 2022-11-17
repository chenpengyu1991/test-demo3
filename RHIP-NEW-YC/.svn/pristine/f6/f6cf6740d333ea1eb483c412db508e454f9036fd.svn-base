<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/highRiskMaternalRegistrationList.js" type="text/javascript"></script>
<div style="float: left; width: 17%;padding-top: 5px" class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<%-- <thead>
			<tr>
				<th>孕产妇编号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${whYcfbjGwdjList}" var="gwcfdj">
				<tr onclick="highRiskMaternalRegistrationList.getHighRiskMaternalRegistrationDetail(${gwcfdj.id})" style="cursor: pointer;">
					<td >
						<input type="hidden" value="${gwcfdj.id}" class="gwcfdj" />
                       ${gwcfdj.ycfbh}
					</td>

				</tr>
			</c:forEach> --%>
		<thead>
			<tr>
				<th>登记日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${whYcfbjGwdjList}" var="gwcfdj">
				<tr onclick="highRiskMaternalRegistrationList.getHighRiskMaternalRegistrationDetail(${gwcfdj.id})" style="cursor: pointer;">
					<td >
						<input type="hidden" value="${gwcfdj.id}" class="gwcfdj" />
						<fmt:formatDate value="${gwcfdj.reportDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
					</td>

				</tr>
			</c:forEach>


		</tbody>

		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="highRiskMaternalRegistrationDiv" style="position: relative;"></div>
</div>