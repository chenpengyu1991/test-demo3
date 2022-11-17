<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table  id="exportTable">
		<colgroup>
			<col style="min-width:70px;width: 6%;"/>
	        <col style="min-width:50px;width: 6%;"/>
			<col style="min-width:50px;width: 7%;"/>
	        <col style="min-width:90px;width: 4%;"/>
	        <col style="min-width:80px;width: 4%;"/>
			<col style="min-width:100px;width: 9%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
            <col style="min-width:60px;width: 6%;"/>
            <col style="min-width:60px;width: 6%;"/>
            <col style="min-width:60px;width: 6%;"/>       
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:100px;width: 6%;"/>
			<col style="min-width:80px;width: 6%;"/>
			<col style="min-width:80px;width: 6%;"/>
            <col style="min-width:60px;width: 6%;"/>
       
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
				<th>诊断病名</th>
				<th>发病日期</th>
				<th>初诊或复诊</th>
                <th>就诊医生</th>
                <th>就诊科室</th>
               	<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="log" items="${logs}" varStatus="status">
				<tr>
					<td title="<ehr:org code="${log.clinicOrganCode}"></ehr:org>" class="lefttd">
					<ehr:org code="${log.clinicOrganCode}"></ehr:org>
					</td>
					<td title="<ehr:dept organCode ="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"></ehr:dept>" class="centertd"><ehr:dept organCode ="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"></ehr:dept></td>
					<td title="${log.name}" class="centertd">${log.name}</td>
                    <td title="<ehr:dic dicmeta="GBT226112003" code="${log.gender}" />" class="centertd"><ehr:dic dicmeta="GBT226112003" code="${log.gender}" /></td>
					<td title="${log.age}" class="centertd">${log.age}</td>
					<td title="${log.idcard}" class="centertd">${log.idcard}</td>
					<td title="<ehr:dic code="${log.occupation}" dicmeta="GBT6565"></ehr:dic>" class="centertd"><ehr:dic code="${log.occupation}" dicmeta="GBT6565"></ehr:dic></td>
					<td title="${log.paAddress}">${log.paAddress}</td>
					<td title="${log.unitName}" class="centertd">${log.unitName}</td>
					<td title="${log.phoneNumber}" class="centertd">${log.phoneNumber}</td>
					<td title="${log.diseaseName}" class="centertd">${log.diseaseName}</td>
					<td class="centertd" title="<fmt:formatDate value='${log.pathogenesisDate}' pattern='yyyy/MM/dd' /> "><fmt:formatDate value='${log.pathogenesisDate}' pattern='yyyy/MM/dd' /> </td>
					<td title="<ehr:dic code="${log.outpatientType}" dicmeta="IDM00409"></ehr:dic>" class="centertd"><ehr:dic code="${log.outpatientType}" dicmeta="IDM00409"></ehr:dic></td>
					<td title="${log.manaDoctorName}" class="centertd">${log.manaDoctorName}</td>
					<td title="<ehr:dept organCode ="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"></ehr:dept>" class="centertd"><ehr:dept organCode ="${log.clinicOrganCode}" deptCode="${log.medicalRoomCode}"></ehr:dept></td>
					<td class="centertd" title="<ehr:dic code="${log.visitStatus}" dicmeta="DMD00064"></ehr:dic>"><ehr:dic code="${log.visitStatus}" dicmeta="DMD00064"></ehr:dic></td>
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