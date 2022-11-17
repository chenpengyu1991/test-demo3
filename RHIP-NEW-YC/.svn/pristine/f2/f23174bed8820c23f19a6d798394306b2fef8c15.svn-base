<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
	<input type="hidden" id="personId" value=""/>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px; width:10%;"/>
			<col style="min-width:70px; width:20%;"/>
			<col style="min-width:70px; width:15%;"/>
			<col style="min-width:70px; width:25%;"/>
	        <col style="min-width:70px; width:25%;"/>
			<col style="min-width:70px; width:10%;"/>
		</colgroup>
		<thead> 
			<tr>
				<th>姓名</th>
				<th>身份证号码</th>
				<th>迁移时间</th>
				<th>迁入机构</th> 
				<th>迁出机构</th>
				<th>操作人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personMoveInfos}" var="person">
		  		<tr>
		  			<td class="centertd">${person.personName}</td>
		  			<td class="centertd">${person.idCard}</td>
		  			<td class="centertd"><fmt:formatDate value="${person.operationDate}" pattern="yyyy/MM/dd"/></td>
		  			<td>${person.newStationName}</td>
		  			<td>${person.oldStationName}</td>
		  			<td>${person.operator}</td>
		  		</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="personMoveCancelJS.moveSearch" page="movePage" colspan="6"/>
		</tr>
		</tbody> 
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="personMoveCancelJS.moveSearch" page="movePage" colspan="5"/>
		</tr>
	</table> --%>
</div>



