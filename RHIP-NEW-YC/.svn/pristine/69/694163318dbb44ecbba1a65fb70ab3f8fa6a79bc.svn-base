<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 5%;" />
		<col style="width: 15%;" />
		<col style="width: 15%;" />
		<col style="width: 10%;" />
		<col style="width: 15%;" />
		<col style="width: 10%;" />
		<col style="width: 10%;" />
		<col style="width: 20%;" />
	</colgroup>
	<thead>
		<tr>
			<th>序号</th>
			<th>巡查地点与内容</th>
			<th>发现的主要问题</th>
			<th>巡查日期</th>
			<th>巡查人</th>
			<th>巡查指导</th>
			<th>报告登记</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="inspectionRecord" varStatus="status" items="${inspectionRecordList}">
			<tr>
				<td class="centertd">${status.index+page.startRow+1}</td>
				<td><ehr:tip>${inspectionRecord.unitName} <ehr:dic dicmeta="HSA00006" code="${inspectionRecord.inspHealthProfessional}"></ehr:dic>
					</ehr:tip></td>
				<td><ehr:tip>${inspectionRecord.findMainPro}</ehr:tip></td>
				<td class="centertd"><ehr:tip>
						<fmt:formatDate value="${inspectionRecord.inspDate}" pattern="yyyy/MM/dd" />
					</ehr:tip></td>
				<td class="centertd">
					<c:choose>
						<c:when test="${not empty inspectionRecord.inspPersonName}">${inspectionRecord.inspPersonName}</c:when>
						<c:when test="${not empty inspectionRecord.inspPersonCode}"><ehr:staff-name staffCode="${inspectionRecord.inspPersonCode}"></ehr:staff-name></c:when>
					</c:choose>
					<c:choose>
						<c:when test="${not empty inspectionRecord.secInspPersonName}"> / ${inspectionRecord.secInspPersonName}</c:when>
						<c:when test="${not empty inspectionRecord.secInspPersonCode}"> / <ehr:staff-name staffCode="${inspectionRecord.secInspPersonCode}"></ehr:staff-name></c:when>
					</c:choose>
				</td>
				<td class="centertd"><ehr:tip>
						<ehr:dic dicmeta="FS10246" code="${inspectionRecord.isGuide}" />
					</ehr:tip></td>
				<td class="centertd"><ehr:tip>
						<ehr:dic dicmeta="FS10246" code="${inspectionRecord.isReport}" />
					</ehr:tip></td>
				<td class="centertd"><%-- <a title="点击进行查看" class="view-link" href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}"
					data-id="${inspectionRecord.id}"
				>查看</a> --%>
				<a  title="点击进行查看" class="view-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}"
					style="color: #FFF;font-size: 12px;" data-id="${inspectionRecord.id}"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
					
				 <%-- <a title="点击进行修改" class="modify-link" href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}"
					data-id="${inspectionRecord.id}"
				>修改</a> --%>
				<a title="点击进行修改" class="modify-link layui-btn layui-btn-xs" href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}"
				   style="color: #FFF;font-size: 12px;" data-id="${inspectionRecord.id}"><i class="layui-icon">&#xe642;</i>修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<ehr:paging action="hsaInspRecordList.search" />
			</td>
		</tr>
	</tbody>
</table>
<%-- <ehr:paging action="hsaInspRecordList.search" /> --%>