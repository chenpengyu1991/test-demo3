<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/list.js" type="text/javascript"></script>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:13%;"/>
			<col style="width:13%;"/>
			<col style="width:13%;"/>
		</colgroup>
		<thead>
			<tr>
				<th colspan="4">儿童保健</th>
				<th colspan="4">孕产妇保健</th>
			</tr>
			<tr>
				<th>新生儿访视人数</th>
				<th>婴幼儿健康管理数</th>
				<th>4-6岁儿童健康管理数</th>
				<th>0-6岁儿童保健覆盖数</th>
				<th>早孕建册数(册)</th>
				<th>产前检查5次及以上孕妇数(人)</th>
				<th>产后访视产妇数(人)</th>
				<th>产后42天健康检查产妇数</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="targetCode" items="${targetCodes}">
					<td>
						<input type="hidden" name="targetHidden" value="${targetCode}"/>
					</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>