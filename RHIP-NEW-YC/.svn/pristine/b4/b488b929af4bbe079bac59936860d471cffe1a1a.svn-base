<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<!-- CDC 主页面查询结果 -->
<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="person_record_table">
        <colgroup>
         	<col style="width:15%;"/>
            <col style="width:20%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:7%;"/>
            <col style="width:8%;"/>
            <col style="width:25%;"/>
        </colgroup>
			<thead> 
				<tr>
					<th>账户名</th>
					<th>Email</th> 
					<th>移动电话</th>
					<th>身份证号</th>
					<th>用户状态</th>
					<th>预约状态</th>					
					<th>操作</th>
				</tr>
			</thead>
			<!-- 遍历接种记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${accountInfos}" var="accountInfo" varStatus="status"> 
					<tr>
						<td title="${accountInfo.accountName}">${accountInfo.accountName}</td>
						<td title="${accountInfo.email}">${accountInfo.email}</td>
						<td title="${accountInfo.telephone}" style="text-align:center">${accountInfo.telephone}</td>
						<td title="${accountInfo.cardNo}" style="text-align:center">${accountInfo.cardNo}</td>
						<td style="text-align:center">
							<ehr:tip><ehr:dic dicmeta="LH00006" code="${accountInfo.status}"/></ehr:tip>
							</td>
						<td style="text-align:center">
							<ehr:tip><ehr:dic dicmeta="LH00006" code="${accountInfo.reserveStatus}"/></ehr:tip>
							</td>
						<td style="text-align:center">
									<a href="#this" id="viewAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">查看</a>
									<c:if test="${accountInfo.status==0}">
										<a href="#this" id="enableAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">启用用户</a>
									</c:if>
									<c:if test="${accountInfo.status==1}">
										<a href="#this" id="disableAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">禁用用户</a>
									</c:if>
									<c:if test="${accountInfo.reserveStatus==0}">
										<a href="#this" id="enableReserveAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">启用预约</a>
									</c:if>
									<c:if test="${accountInfo.reserveStatus==1}">
										<a href="#this" id="disableReserveAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">禁用预约</a>
									</c:if>
									<a href="#this" id="deleteAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">删除</a>
									<%-- <ehr:authorize ifAnyGranted="01">
										<a href="#this" id="passwordAccountInfo${accountInfo.id}" data-fileCode="${accountInfo.id}">密码重置</a>
									</ehr:authorize> --%>
						    
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging/>
</div>
