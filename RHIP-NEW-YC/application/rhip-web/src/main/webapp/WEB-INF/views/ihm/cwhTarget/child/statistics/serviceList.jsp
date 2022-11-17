<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
		</colgroup>
		<thead>
		<tr>
			<th>机构</th>
			<th>新生儿访视数</th>
			<th>苯丙酮尿症筛查数</th>
			<th>甲状腺功能减低症筛查数</th>
			<th>听力筛查数</th>
			<th>3岁以下系统管理数</th>
			<th>7岁以下保健覆盖数</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="service" items="${serviceList}" varStatus="status">
			<tr>
				<td class="centertd">
					<c:choose>
						<c:when test="${service.ORGAN_CODE=='合计'}">合计</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${genreCode == '0'}"><ehr:dic dicmeta="FS990001" code="${service.ORGAN_CODE}"/></c:when>
								<c:otherwise><ehr:tip><ehr:org code="${service.ORGAN_CODE}"/></ehr:tip></c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</td>
				<td class="centertd"><ehr:tip>${service.childVisitCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${service.bbtnCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${service.thyroidCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${service.hearingCount}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${service.count3}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${service.count7}</ehr:tip></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>