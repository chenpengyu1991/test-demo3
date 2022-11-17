<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
	<input type="hidden" id="personId" value=""/>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:20%;"/>
			<col style="width:20%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">机构名称</th>
				<th colspan="2">慢病随访人次数</th>
				<th colspan="2">慢病体检人数</th>
			</tr>
			<tr>
				<th>高血压</th>
				<th>糖尿病</th>
				<th>高血压</th>
				<th>糖尿病</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${followupMapList}" var="followupMap">
				<tr>
					<td>
						<c:choose>
							<c:when test="${followupMap.create_organ_code == '合计'}"><b>合计</b></c:when>
							<c:otherwise><ehr:org code="${followupMap.create_organ_code}"/></c:otherwise>
						</c:choose>
					</td>
					<td>${followupMap.hbp_fllowup_times_num}</td>
					<td>${followupMap.di_fllowup_times_num}</td>
					<td>${followupMap.hbp_phy_num}</td>
					<td>${followupMap.di_phy_num}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>



