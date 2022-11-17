<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/frailInfantsFile.js" type="text/javascript"></script>
<div style="float: left; width: 17%;padding-top: 5px;" class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<thead>
			<tr>
				<th>姓名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${frailInfantsFileList}" var="fif">
				<tr onclick="brwHealthFrailInfantsFile.getFrailInfantsFile(${fif.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${fif.id}" class="frailInfantsFile" />
						${fif.xm}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="frailInfantsFileDiv" style="position: relative;"></div>
</div>