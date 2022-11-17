<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<script src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/list.js" type="text/javascript"></script>
<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
        	<col style="width:5%;"/>
            <col style="width:8%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:7%;">
            <col style="width:15%;"/>
            <col style="width:5%;">
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>操作者</th>
					<th>机构</th> 
					<th>IP</th> 
					<th>请求地址</th>
					<th>模块名称</th>
					<th>功能名称</th>					
					<th>具体操作</th>
					<th>操作时间</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${userOperationLogList}" var="userOperationLog" varStatus="status"> 
					<tr>
					    <td style="text-align:center">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>					    </td>
						<td title="${userOperationLog.userName}" style="text-align:left" >${userOperationLog.userName}</td>
						<td title="<ehr:org code="${userOperationLog.orgCode}"></ehr:org>" style="text-align:center">
							<ehr:org code="${userOperationLog.orgCode}"></ehr:org></td>
						<td title="${userOperationLog.userIp}" style="text-align:center">${userOperationLog.userIp}</td>
						<td title="${userOperationLog.userRequest}" style="text-align:center">${userOperationLog.userRequest}</td>
						<td title="${userOperationLog.moduleName}" style="text-align:center">${userOperationLog.moduleName}</td>
						<td title="${userOperationLog.actionName}" style="text-align:center">${userOperationLog.actionName}</td>
						<td title="${userOperationLog.operationName}" style="text-align:center">${userOperationLog.operationName}</td>
						<td style="text-align:center">
							<c:choose>
								<c:when test="${not empty userOperationLog.operationTime}">
									<fmt:formatDate value='${userOperationLog.operationTime}' pattern='yyyy/MM/dd HH:mm:SS'/>
								</c:when>
								<c:otherwise>
									不详								
								</c:otherwise>
							</c:choose>						
						</td>
						<td title="${userOperationLog.remark}" style="text-align:center">${userOperationLog.remark}</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="userOperationLogSearch.search" colspan="10"/>
		<!-- 实现分页功能 -->
	</table>
</div>
