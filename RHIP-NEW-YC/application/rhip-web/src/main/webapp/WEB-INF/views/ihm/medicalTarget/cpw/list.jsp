<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable" >
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:120px;width: 15%;"/>
			<col style="min-width:120px;width: 15%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:120px;width: 15%;"/>
			<col style="min-width:120px;width: 15%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>科室名称</th>
				<th>患者身份证</th>
				<th>患者姓名</th>
				<th>住院/门诊号</th>
				<th>诊断名称</th>
				<th>进入路径时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="clinicalPathway" items="${clinicalPathways}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${clinicalPathway.hospitalCode}"/></ehr:tip></td>
					<td><ehr:tip>${clinicalPathway.departmentName}</ehr:tip></td>
					<td><ehr:tip>${clinicalPathway.idCard}</ehr:tip></td>
					<td><ehr:tip>${clinicalPathway.patientName}</ehr:tip></td>
					<td><ehr:tip>${clinicalPathway.admissionNo}${clinicalPathway.outpatientNo}</ehr:tip></td>
					<td><ehr:tip>${clinicalPathway.diagnosisName}</ehr:tip></td>
					<td><fmt:formatDate value="${clinicalPathway.intoTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="clinicalPathwaySearch.search" colspan="7"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="clinicalPathwaySearch.search" />
		</tr>
	</table>	 --%>
</div>