<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>

<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>

<c:set var="ASSIGN" value="<%=InteractionStatus.ASSIGN.getValue()%>"/>
<c:set var="ACCEPT" value="<%=InteractionStatus.ACCEPT.getValue()%>"/>
<c:set var="RETURN" value="<%=InteractionStatus.RETURN.getValue()%>"/>
<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>
<c:set var="NEW" value="<%=InteractionStatus.NEW.getValue()%>"/>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
<table id="interactionInfo_record_table">
        <colgroup>
            <col style="width:20%;"/>
            <col style="width:5%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:5%;"/>
            <col style="width:25%;">
        </colgroup>
			<thead> 
				<tr>
					<th>标题</th>
					<th>办件类型</th> 
					<th>作者</th>
					<th>联系电话</th>	
					<th>受理单位</th>
					<th>创建时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<!-- 遍历互动管理记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${interactionRecords}" var="record">
					<tr>
					    <td title="${record.title}">${record.title}</td>
						<td style="text-align:center">
						<ehr:tip><ehr:dic dicmeta="LH00002" code="${record.eventType}"/></ehr:tip>
						</td>
						<td title="${record.name}">${record.name}</td>
						<td title="${record.phoneNumber}" style="text-align:center">${record.phoneNumber}</td>
				    	<td><ehr:org code="${record.unitCode}"></ehr:org></td>
					    <td style="text-align:center">
					    	<fmt:formatDate value='${record.insertDate}' pattern='yyyy/MM/dd'/>
					    </td>
						<td style="text-align: center">
						<ehr:tip><ehr:dic dicmeta="LH00003" code="${record.status}"/></ehr:tip>
						</td>
						<td style="text-align: center;">
							<a href="#this" id="viewInteraction${record.id}" data-recordId="${record.id}">查看</a>
							<c:choose>
							 	<%-- 新增 已退回  --%>
								<c:when test="${record.status == NEW || record.status == RETURN}">
									<a href="#this" id="acceptInteraction${record.id}" data-recordId="${record.id}">接受</a>
									<ehr:authorize ifAnyGranted="${ADMIN}">
									<a href="#this" id="popuOrgSelect${record.id}" data-recordId="${record.id}">转交单位</a>
									</ehr:authorize>
								</c:when>
								<%-- 已分派 --%>
								<c:when test="${record.status == ASSIGN}">
								<ehr:authorize ifNotGranted="${ADMIN}"><%-- ADMIN不可见 --%>
									<a href="#this" id="acceptInteraction${record.id}" data-recordId="${record.id}">接受</a>
									<a href="#this" id="retreatInteraction${record.id}" data-recordId="${record.id}">退回</a>
								</ehr:authorize>
								</c:when>
								<%--  已接受 --%>
								<c:when test="${record.status == ACCEPT}">
									<a href="#this" id="modifyInteraction${record.id}" data-recordId="${record.id}" data-status='${record.status}'>回复</a>
								</c:when>
								<c:otherwise>
									<a href="#this" id="modifyInteraction${record.id}" data-recordId="${record.id}" data-status='${record.status}'>修改</a>
								</c:otherwise>
							</c:choose>
							<ehr:authorize ifAnyGranted="${ADMIN}">
									<a href="#this" id="deleteInteraction${record.id}" data-recordId="${record.id}">删除</a>
							</ehr:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging />
	</div>
