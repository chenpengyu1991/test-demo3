<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ihm/hmTarget/list.js" type="text/javascript"></script>


<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th>机构</th>
				<th>接受健康管理的老年人数(人)</th>
				<th>填写完整的健康体检表格数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="target" items="${targetList}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${target.type eq 1}">
								<ehr:tip><ehr:dic code="${target.code}" dicmeta="FS990001"/></ehr:tip>
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