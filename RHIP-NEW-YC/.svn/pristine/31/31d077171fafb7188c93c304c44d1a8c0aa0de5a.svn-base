<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div id="rabiesList" class="repeattable">
	<form id="rabiesForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" id="reportNameId" name="reportName" value="老年人肺炎疫苗免费接种情况汇总统计月报表"/>
	<table id="pneumoniatable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 45px;"/>
			<col style="width: 45px;"/>
			<col style="width: 45px;"/>
			<col style="width: 45px;"/>
			<col style="width: 45px;"/>
			<col style="width: 45px;"/>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">医疗机构</th>
				<th colspan="5">各年龄组实种人数</th>
			</tr>
			<tr>
				<th>65~</th>
				<th>70~</th>
				<th>75~</th>
				<th>80~85</th>
				<th>合计</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="map" items="${mapList}" varStatus="status">
					<tr>
						<td>
							<ehr:tip><ehr:org code="${map.organ_code}"/></ehr:tip>
						</td>
						<td><tags:numberLabel value="${map.sz65}"/></td>
						<td><tags:numberLabel value="${map.sz70}"/></td>
						<td><tags:numberLabel value="${map.sz75}"/></td>
						<td><tags:numberLabel value="${map.sz80}"/></td>
						<td><tags:numberLabel value="${map.szz}"/></td>
					</tr>
			</c:forEach>						
		</tbody>
	</table>
	</form>
</div>