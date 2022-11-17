<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table  id="exportTable">
		<colgroup>
			<col style="min-width:70px;width: 9%;"/>
	        <col style="min-width:50px;width: 5%;"/>
			<col style="min-width:50px;width: 5%;"/>
	        <col style="min-width:90px;width: 4%;"/>
	        <col style="min-width:80px;width: 4%;"/>
			<col style="min-width:100px;width: 11%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 8%;"/>
            <col style="min-width:60px;width: 7%;"/>
            <col style="min-width:60px;width: 7%;"/>
            <col style="min-width:60px;width: 7%;"/>       
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<%-- <col style="min-width:80px;width: 9%;"/> --%>
            <col style="min-width:60px;width: 5%;"/>
            <%-- <col style="min-width:60px;width: 8%;"/> --%>
       
		</colgroup>
		<thead>
			<tr>
				<th>机构</th>
				<th>科室</th>
				<th>姓名</th>
                <th>性别</th>
				<th>年龄</th>
				<th>身份证号</th>
				<th>职业</th>
                <th>现住址</th>
				<th>工作单位</th>
				<th>联系电话</th>
				<th>入院日期</th>
				<th>入院诊断</th>
				<th>出院日期</th>
                <th>出院诊断</th>
               <!--  <th>转归情况</th> -->
               	<th>状态</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="log" items="${logs}" varStatus="status">
				<tr>
					<td title="<ehr:org code="${log.clinicOrganCode}"/>">
						<ehr:tip><ehr:org code="${log.clinicOrganCode}"/></ehr:tip>
					</td>
					<td title="<ehr:dept organCode="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"/>">
						<ehr:tip><ehr:dept organCode="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"/></ehr:tip>
					</td>
					<td title="${log.name}">${log.name}</td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${log.gender}" /></td>
					<td title="${log.age}" class="centertd">${log.age}</td>
					<td class="centertd" title="${log.idcard}">${log.idcard}</td>
					<td class="centertd" >
						<ehr:dic dicmeta="GBT6565" code="${log.occupation}"></ehr:dic>
					</td>
					<td title="${log.paAddress}">${log.paAddress}</td>
					<td title="${log.unitName}">${log.unitName}</td>
					<td title="${log.phoneNumber}">${log.phoneNumber}</td>
					<td class="centertd"  title="<fmt:formatDate value='${log.inhosDate}' pattern='yyyy/MM/dd' />"><fmt:formatDate value='${log.inhosDate}' pattern='yyyy/MM/dd' /></td>
					<td title="${log.inDiagnose}">${log.inDiagnose}</td>
					<td class="centertd"  title="<fmt:formatDate value='${log.outHospitalDate}' pattern='yyyy/MM/dd' />"><fmt:formatDate value='${log.outHospitalDate}' pattern='yyyy/MM/dd' /></td>
					<td title="${log.outDiagnose}">${log.outDiagnose}</td>
					<%-- <td>${log.processStatus}</td> --%>
					<td title="<ehr:dic code="${log.visitStatus}" dicmeta="DMD00064"></ehr:dic>"><ehr:dic code="${log.visitStatus}" dicmeta="DMD00064"></ehr:dic></td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="logSearch.search" />
		</tr>
	</table>
</div>