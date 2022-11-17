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
<table class="layui-table x-admin-sm-table-list-middle">
	 <colgroup>
		<col style="min-width:100px;"/>
		<col style="min-width:100px;"/>
		<col style="min-width:100px;"/>
		<col style="min-width:100px;"/>
		<col style="min-width:100px;"/>
	</colgroup>
	<thead>
		<tr>
			<th>机构/乡镇</th>
			<!-- <th>合计</th>-->
			<th>育龄妇女登记数</th>
			<!--<th>育龄妇女避孕登记数</th>-->
			<th>妇女疾病筛查数</th>
			<th>女性婚检人数</th>
			<th>男性婚检人数</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="statistics" items="${statisticslist}" varStatus="status">
			<tr>
				<td>
					<ehr:tip>
						<c:if test="${statistics.ORGAN_CODE == '<b>合计</b>'}">${statistics.ORGAN_CODE}</c:if>
						<c:if test="${genreCodeFlag == '0'}">
							<c:if test="${statistics.ORGAN_CODE != '<b>合计</b>'}">
								<ehr:dic dicmeta="FS990001" code="${statistics.ORGAN_CODE}"/>
							</c:if>
						</c:if>
						<c:if test="${genreCodeFlag == '1'}">
							<c:if test="${statistics.ORGAN_CODE != '<b>合计</b>'}">
								<ehr:org code="${statistics.ORGAN_CODE}" />
							</c:if>
						</c:if>

					</ehr:tip>
				</td>
				<!--<td style="text-align: center">${statistics.COUNT_ROW}</td>-->
				<td style="text-align: center">${statistics.COUNT1}</td>
				<!--<td style="text-align: center">${statistics.COUNT2}</td>-->
				<td style="text-align: center">${statistics.COUNT3}</td>
				<td style="text-align: center">${statistics.COUNT4}</td>
				<td style="text-align: center">${statistics.COUNT5}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
