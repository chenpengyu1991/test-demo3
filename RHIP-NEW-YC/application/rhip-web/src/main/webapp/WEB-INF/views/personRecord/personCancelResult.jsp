<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
	<input type="hidden" id="personId" value=""/>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px; width:10%;"/>
			<col style="min-width:70px; width:15%;"/>
			<col style="min-width:70px; width:10%;"/>
            <col style="min-width:70px; width:10%;"/>
			<col style="min-width:70px; width:5%;"/>
	        <col style="min-width:70px; width:15%;"/>
			<col style="min-width:70px; width:7%;"/>
			<col style="min-width:70px; width:8%;"/>
			<col style="min-width:70px; width:20%;"/>
			<%--<col style="min-width:70px; width:5%;"/>--%>
		</colgroup>
		<thead> 
			<tr>
				<th>姓名</th>
				<th>身份证号码</th>
				<th>结案时间</th>
                <th>死亡时间</th>
				<th>结案原因</th>
				<th>结案说明</th>
				<th>结案人</th>
				<th>结案人IP</th>
				<th>结案机构</th>
				<%--<th>操作</th>--%>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${personCancelInfos}" var="person">
		  		<tr>
		  			<td class="centertd"><ehr:tip>${person.personName}</ehr:tip></td>
		  			<td class="centertd"><ehr:tip>${person.idCard}</ehr:tip></td>
		  			<td class="centertd"><fmt:formatDate value="${person.canceledDate}" pattern="yyyy/MM/dd"/></td>
                    <td class="centertd">
                        <c:if test="${person.canceledReason eq '1'}">
                            <fmt:formatDate value="${person.canceledReasonDate}" pattern="yyyy/MM/dd"/>
                        </c:if>
                    </td>
		  			<td>
						<ehr:dic code="${person.canceledReason}" dicmeta="FS10311"/>
		  			</td>
		  			<td><ehr:tipWoldWrap>${person.remark}</ehr:tipWoldWrap></td>
		  			<td class="centertd"><ehr:tip>${person.canceledName}</ehr:tip></td>
		  			<td><ehr:tip>${person.canceledIp}</ehr:tip></td>
		  			<td><ehr:tip>${person.canceledOrganName}</ehr:tip></td>
		  			<%--<td> <c:if test="${person.canceledReason eq '1'}"><a href="#this" onclick="personMoveCancelJS.dialog('${person.idCard}')">查看</a></c:if></td>--%>
		  		</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="personMoveCancelJS.Cancelsearch" page="cancelPage" colspan="9"/>
		</tr>
		</tbody> 
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="personMoveCancelJS.Cancelsearch" page="cancelPage" colspan="6"/>
		</tr>
	</table> --%>
</div>



