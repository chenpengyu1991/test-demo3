<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="repeattable">
	<table id="portal_register_statistic_table">
        <colgroup>
            <col style="width:40%">
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
        </colgroup>
			<thead> 
				<tr>
				    <th>科室</th>
					<th>预约总数</th>
					<th>已到诊</th>
					<th>尚未到诊</th> 
					<th>逾期未到诊</th>
					<th>取消</th>
					<th>停诊</th>
				</tr>
			</thead>
			<!-- 遍历服务信息类别记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${reserveRegisters }" var="reserveRegister">
				<tr>
					<td ><c:choose>
						<c:when test="${reserveRegister.deptName=='合计' }"><b>${reserveRegister.deptName }</b></c:when>
						<c:otherwise><ehr:tip>${reserveRegister.deptName }</ehr:tip></c:otherwise>
					</c:choose>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.total}" type="number"/></td>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.future}" type="number"/></td>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.time}" type="number"/></td>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.fails}" type="number"/></td>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.cancel}" type="number"/></td>
					<td><tags:numberLabel  defaultValue="0"  value="${reserveRegister.stop}" type="number"/></td>
					
					<%-- <td style="text-align: right" >${reserveRegister.total}</td>
					<td style="text-align: right" >${reserveRegister.future}</td>
					<td style="text-align: right" >${reserveRegister.time}</td>
					<td style="text-align: right" >${reserveRegister.fails}</td>
					<td style="text-align: right" >${reserveRegister.cancel}</td>
					<td style="text-align: right" >${reserveRegister.stop}</td> --%>
				</tr>
				</c:forEach>
			</tbody>
	</table>
</div>
