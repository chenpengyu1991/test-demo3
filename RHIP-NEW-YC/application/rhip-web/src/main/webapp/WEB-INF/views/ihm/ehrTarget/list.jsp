<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ihm/ehrTarget/list.js" type="text/javascript"></script>


<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 11%;" />
			<col style="width: 12%;" />
			<col style="width: 8%;" />
			<col style="width: 6%;" />
			<col style="width: 8%;" />
			<col style="width: 6%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构</th>
				<th>累计档案-户籍</th>
				<th>累计档案-非户籍</th>
				<th>65岁以上</th>
				<th>高血压</th>
				<th>2型糖尿病</th>
				<th>精神病</th>
				<th>有动态记录</th>
				<th>无动态记录</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="target" items="${targetList}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${target.type eq 1}">
								<ehr:dic code="${target.code}" dicmeta="FS990001"></ehr:dic>
							</c:when>
							<c:otherwise>
								<ehr:org code="${target.code}"></ehr:org>
							</c:otherwise>
						</c:choose>
					</td>
					<c:forEach var="targetCode" items="${target.targetCodes}">
					<td>
						<input type="hidden" name="targetHidden" value="${target.code},${target.type},${targetCode}"/>
					</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>