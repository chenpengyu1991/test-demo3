<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div id="rabiesList" class="repeattable">
	<form id="rabiesForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>
		<input type="hidden" id="reportNameId" name="reportName" value="<ehr:org code="${createOrg}"/>${beginDate }-${endDate}犬伤防治报表"/>
	<table id="rabiestable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
		</colgroup>		
		<thead>
			<tr>
				<th rowspan="2">医疗机构</th>
				<th rowspan="2">被动物咬伤就诊人数</th>
				<th rowspan="2">伤口经正规处理人数</th>
				<th colspan="2">使用人用狂犬病疫苗</th>
				<th colspan="2">使用狂犬病人免疫球蛋白</th>
			</tr>
			<tr>
				<th>人数</th>
				<th>剂数</th>
				<th>人数</th>
				<th>瓶数</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="map" items="${mapList}" varStatus="status">
					<tr>
						<td>
							<c:if test="${map.org_code eq '合计'}"><strong>合计</strong></c:if>
							<c:if test="${map.org_code ne '合计'}"><ehr:tip><ehr:org code="${map.org_code}"/></ehr:tip></c:if>
						</td>
						<td><tags:numberLabel value="${map.person_num}"/></td>
						<td><tags:numberLabel value="${map.person_num}"/></td>
						<td><tags:numberLabel value="${map.num1}"/></td>
						<td><tags:numberLabel value="${map.num3}"/></td>
						<td><tags:numberLabel value="${map.num2}"/></td>
						<td><tags:numberLabel value="${map.num4}"/></td>
					</tr>
			</c:forEach>						
		</tbody>
	</table>
	</form>
</div>