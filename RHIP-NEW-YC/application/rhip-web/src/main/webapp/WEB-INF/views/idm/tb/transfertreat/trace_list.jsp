<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="repeattable">
	<input type="hidden" id="currentPageTrace" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width:15%;"/>
	        <col style="width:10%;"/>
	        <col style="width:20%;"/>
	        <col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>到位状态</th>
				<th>转诊时间</th>
				<th>过期天数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="trace" items="${traces}" varStatus="status">
				<tr>
					<td class="centertd">${trace.tbDto.name}</td>
					<td class="centertd"><ehr:dic code="${trace.tbDto.gender}" dicmeta="GBT226112003"/></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${trace.tbDto.idcard}"><ehr:tip>${trace.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td class="centertd">
						<c:choose>
					 		<c:when test="${trace.placeStatus == null}">未到位</c:when>
					 		<c:otherwise><ehr:dic code="${trace.placeStatus}" dicmeta="IDM00255"/></c:otherwise>
					 	</c:choose>
					</td>
					<td class="centertd"><fmt:formatDate value="${trace.tbDto.transferTreatmentDt}" pattern="yyyy/MM/dd"/> </td>
					<td class="righttd">
					 
					 	<c:choose>
					 		<c:when test="${trace.placeStatus == '5'}">${trace.tbDto.transferDays}</c:when>
					 		<c:otherwise>${trace.tbDto.notSeeDay}</c:otherwise>
					 	</c:choose>
					 </td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="transfertreat.addTraceRecord('${trace.tbDto.singleId}','${trace.placeStatus}','<fmt:formatDate value="${nowDate}" pattern="yyyy/MM/dd"/>')" class="person-link-btn">追踪</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="transfertreat.searchTrace" colspan="8" />
		</tr>
	</table>
</div>