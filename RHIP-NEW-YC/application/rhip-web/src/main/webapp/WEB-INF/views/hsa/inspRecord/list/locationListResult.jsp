<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table>
	<colgroup>
		<col style="width: 15%;" />
		<col style="width: 10%" />
		<col style="width: 7%" />
		<col style="width: 7%" />
		<col style="width: 7%" />
		<col style="width: 10%" />
	</colgroup>
	<thead>
		<tr>
			<th style="width: 40px;">单位名称</th>
			<th style="width: 35px;">联系人</th>
			<th style="width: 35px;">联系电话</th>
			<th style="width: 45px;">身份证号</th>
			<th style="width: 15px;">巡查次数</th>
			<th style="width: 30px;">操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="locationInfo" items="${locationInfoList}">
			<tr>
				<td><a title="点击进行查看和修改 ${locationInfo.unitName}" class="hsa-location-modify-link" href="javascript:void(0)" data-id="${locationInfo.id}">${locationInfo.unitName}
				</a></td>
				<td class="centertd"><ehr:tip>${locationInfo.contact}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${locationInfo.contactPhone}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${locationInfo.idcard}</ehr:tip></td>
				<td class="righttd"><ehr:tip>${locationInfo.inspCount}</ehr:tip></td>
				<td><a title="点击进行新增" class="hsa-location-listdatagrid-modify-link" href="javascript:void(0)" data-id="${locationInfo.id}">新增登记</a> <a
					title="点击进行查看" class="hsa-location-listdatagrid-view-link" href="javascript:void(0)" data-id="${locationInfo.id}"
				>查看登记</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<ehr:paging action="hsaInspRecordLocationList.search" />
			</td>
		</tr>
	</tbody>
</table>
<%-- <ehr:paging action="hsaInspRecordLocationList.search" /> --%>