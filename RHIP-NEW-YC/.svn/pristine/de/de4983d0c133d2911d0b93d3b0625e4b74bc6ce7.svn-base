<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<c:choose>
			<c:when test="${genreCode == '0' }">
				<col style="min-width:240px;width: 20%;"/>
			</c:when>
			<c:when test="${genreCode == STATION}">
				<col style="min-width:80px;width: 12%;"/>
				<col style="min-width:80px;width: 12%;"/>
				<col style="min-width:80px;width: 16%;"/>
			</c:when>
			<c:otherwise>
				<col style="min-width:100px;width: 40%;"/>
			</c:otherwise>
		</c:choose>
		<col style="min-width:160px;width: 20%;"/>
		<col style="min-width:160px;width: 20%;"/>
	</colgroup>
	<thead>
	<tr>
		<c:choose>
			<c:when test="${genreCode == '0' }">
				<th rowspan="2">镇</th>
			</c:when>
			<c:when test="${genreCode == STATION}">
				<th colspan="3">医疗机构</th>
			</c:when>
			<c:otherwise>
				<th rowspan="2">医疗机构</th>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${genreCode == '0' }">
				<th>个人健康档案建档工作量</th>
				<th>档案更新数</th>
			</c:when>
			<c:otherwise>
				<th rowspan="2">个人健康档案建档工作量</th>
				<th rowspan="2">档案更新数</th>
			</c:otherwise>
		</c:choose>

	</tr>
	<tr>
		<c:choose>
			<c:when test="${genreCode == '0' }">
			</c:when>
			<c:when test="${genreCode == HOSPITAL}">
				<th>镇</th>
				<th>医院</th>
			</c:when>
			<c:when test="${genreCode == STATION}">
				<th>镇</th>
				<th>中心</th>
				<th>站</th>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="report" items="${reports}" varStatus="status">
		<tr>
			<c:set var="gbGroup" value="${report.GB_CODE== 'grouping'}"></c:set>
			<c:set var="parentGroup" value="${report.PARENT_CODE== 'grouping'}"></c:set>
			<c:set var="organGroup" value="${report.ORGAN_CODE== 'grouping'}"></c:set>
			<c:set var="colCount" value="0"></c:set>
			<c:if test="${gbGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
			<c:if test="${parentGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
			<c:if test="${organGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
			<c:choose>
				<c:when test="${gbGroup}">
					<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
				</c:when>
				<c:when test="${parentGroup}">
					<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
					<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
				</c:when>
				<c:when test="${organGroup}">
					<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
					<c:if test="${genreCode != HOSPITAL && genreCode != CENTRE}"><td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td></c:if>
					<td class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${genreCode == STATION}">
							<c:if test="${not empty report.GB_CODE && !gbGroup}">
								<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
							</c:if>
							<c:if test="${not empty report.PARENT_CODE && !parentGroup}">
								<td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td>
							</c:if>
							<c:if test="${not empty report.ORGAN_CODE && !organGroup}">
								<td data-is-orgcode = "true" data-orgcode="${report.ORGAN_CODE}"><ehr:tip><ehr:org  code="${report.ORGAN_CODE}"/></ehr:tip></td>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:if test="${not empty report.GB_CODE && !gbGroup}">
								<td data-is-orgcode = "true" data-orgcode="${report.GB_CODE}"><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<td><tags:numberLabel value="${report.PCOUNT}" defaultValue="0" /></td>
			<td><tags:numberLabel value="${report.FCOUNT}" defaultValue="0" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

