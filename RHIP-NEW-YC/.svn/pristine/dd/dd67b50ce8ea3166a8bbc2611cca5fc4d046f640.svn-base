<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%-- <c:set var="FYK" value="<%=RoleType.FYK.getValue()%>" />
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>" />
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>
<c:set var="CANCEL" value="<%=ReportStatus.CANCEL.getValue()%>"/> --%>

<%--<script src="${pageContext.request.contextPath}/js/views/idm/report/search.js" type="text/javascript"></script>--%>


<div class="repeattable">
	<table id="exportTable" >
		<colgroup>	
	        <col style="min-width:90px;width: 12%;"/>
	        <%-- <col style="min-width:80px;width: 8%;"/> --%>
			<col style="min-width:100px;width: 6%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 9%;"/>
         <%--    <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/> --%>
           <%--  <col style="min-width:60px;width: 8%;"/>   --%>     
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 9%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <%-- <col style="min-width:60px;width: 8%;"/> --%>
       
		</colgroup>
		<thead>
			<tr>
				<th>机构</th>
			<!-- 	<th>时间</th> -->
				<th>姓名</th>
                <th>性别</th>
				<th>年龄</th>
				<!-- <th>职业</th>
                <th>住址</th> -->
				<!-- <th>联系方式</th> -->
				<th>检验/检查日期</th>
				<th>初/复诊</th>
				<th>检查科室</th>
                <th>送检科室</th>
                <th>送检医生</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${results}" varStatus="status">
				<tr>
					<td class="lefttd">
						<ehr:tip><ehr:org code="${result.hospitalCode}"/></ehr:tip>
					</td>
					<%-- <td>${result.checkDate}</td> --%>
					<%-- <td>
						<ehr:tip><ehr:dept organCode="${result.clinicOrganCode}" deptCode="${log.medicalRoomCode}"/></ehr:tip>
					</td> --%>
					<td title="${result.name}" class="centertd">${result.name}</td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${result.gender}" /></td>
					<td class="centertd" title="${result.age}" class="centertd">${result.age}</td>
					<%-- <td>
						<ehr:dic dicmeta="GBT6565" code="${result.occupation}"></ehr:dic>
					</td> --%>
					<%-- <td>${result.paAddress}</td> --%>
					<%-- <td>${result.phoneNumber}</td> --%>	
					<td class="centertd" ><fmt:formatDate value='${result.checkDate}' pattern='yyyy/MM/dd' /></td>
					<td class="centertd" >
						<c:if test="${'1'== result.visitStatus}">
							初诊
						</c:if>
						<c:if test="${'2'== result.visitStatus}">
							复诊
						</c:if>
					</td>
					<td class="centertd">
						<c:choose>
						   <c:when test="${null eq result.detectionRoomCode ||'' eq result.detectionRoomCode}">  
						      ${result.detectionRoomName}
						   </c:when>
						   <c:otherwise> 
						     <ehr:tip><ehr:dept organCode="${result.hospitalCode}" deptCode="${result.detectionRoomCode}"/></ehr:tip>
						   </c:otherwise>
						</c:choose>				
					</td>
					<td class="centertd">
						<c:choose>
						   <c:when test="${null eq result.applyRoomCode || '' eq result.applyRoomCode}">  
						      ${result.applyRoomName}
						   </c:when>
						   <c:otherwise> 
						     <ehr:tip><ehr:dept organCode="${result.hospitalCode}" deptCode="${result.applyRoomCode}"/></ehr:tip>
						   </c:otherwise>
						</c:choose>
					</td>
					<td class="centertd" >${result.applyPeopleName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="inspectionSearch.search" />
		</tr>
	</table>
</div>