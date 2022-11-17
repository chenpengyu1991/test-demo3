<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:80px;width: 25%;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
		</colgroup>
		<thead>
		<tr>
			<th>机构</th>
			<th>体重检查人数</th>
			<th>体重<(中位数-2SD)的人数</th>
			<th>血红蛋白检查人数</th>
			<th>中重度贫血人数</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="nutrition" items="${nutritionList}" varStatus="status">
			<tr>
				<td class="centertd">
					<c:choose>
						<c:when test="${nutrition.ORGAN_CODE=='合计'}">合计</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${genreCode == '0'}"><ehr:dic dicmeta="FS990001" code="${nutrition.ORGAN_CODE}"/></c:when>
								<c:otherwise><ehr:tip><ehr:org code="${nutrition.ORGAN_CODE}"/></ehr:tip></c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</td>
				<td class="centertd"><ehr:tip>${nutrition.weightCheckCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${nutrition.weightCheckLowCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${nutrition.hhbCheckCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${nutrition.hhbCheckLowCount}</ehr:tip></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>