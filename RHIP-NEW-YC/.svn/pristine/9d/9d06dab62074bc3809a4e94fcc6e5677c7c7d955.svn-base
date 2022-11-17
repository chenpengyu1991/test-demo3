<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/newBornBabyRegisterList.js" type="text/javascript"></script>
<div style="float: left; width: 17%;margin-top: 5px" class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
	<c:forEach items="${groupWhYcfbjXsedjMap}" var="whYcfbjXsedjs">
		<thead>
			<tr>
				<th title="${whYcfbjXsedjs.key}">${whYcfbjXsedjs.key}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${whYcfbjXsedjs.value}" var="whYcfbjXsedj">
				<tr onclick="newBornBabyRegister.getBornBabyRegisterList(${whYcfbjXsedj.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${whYcfbjXsedj.id}" class="WhYcfbjXsedj" />
						<fmt:formatDate value="${whYcfbjXsedj.mcsj}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</c:forEach>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="WhYcfbjXsedjDiv" style="position: relative;"></div>
</div>