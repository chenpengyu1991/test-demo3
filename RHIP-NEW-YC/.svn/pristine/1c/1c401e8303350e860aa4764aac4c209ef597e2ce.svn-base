<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="adminForm">
	<table id="frList" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 50%" />
			<col style="width: 50%" />
		</colgroup>
		<c:if test="${type eq 1}">
			<c:forEach var="village" items="${villages}" varStatus="status">
				<c:if test="${status.index%2==0}"><tr></c:if>
				<td>
					<input name="villageCodes" type="checkbox" value="${village.itemCode}"
						   <c:if test="${village.parentCode == townCode}">checked="checked"</c:if> />
					<a href="javascript:void(0)" onclick="javascript:villageAdd.popup('${village.itemCode}')" id="xiugai">${village.itemName}</a>
				</td>
				<c:if test="${status.count%2==0}"></tr></c:if>
			</c:forEach>
			<c:forEach var="village" items="${noParents}" varStatus="status">
				<c:if test="${status.index%2==0}"><tr></c:if>
				<td>
					<input name="villageCodes" type="checkbox" value="${village.itemCode}"
						   <c:if test="${village.parentCode == townCode}">checked="checked"</c:if> />
					<a href="javascript:void(0)" onclick="javascript:villageAdd.popup('${village.itemCode}')" id="xiugai">${village.itemName}</a>
				</td>
				<c:if test="${status.count%2==0}"></tr></c:if>
			</c:forEach>
		</c:if>
		<c:if test="${type eq 2}">
			<c:forEach var="organizationArea" items="${villages}" varStatus="status">
				<c:if test="${status.index%2==0}"><tr></c:if>
				<td>

					<a href="javascript:void(0)" onclick="javascript:villageAdd.popupView('${organizationArea.villageCode}')">${organizationArea.villageName}</a>
				</td>
				<c:if test="${status.count%2==0}"></tr></c:if>
			</c:forEach>
		</c:if>
	</table>
</form>
