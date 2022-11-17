<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
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
				<th>所在病区</th>
				<th>病区床号</th>
				<th>是否加床</th>
				<th>是否开放</th>
				<th>性别限制</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sickbedUseState" items="${sickbedUseStates}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${sickbedUseState.hospitalCode}"/></ehr:tip></td>
					<td><ehr:tip>${sickbedUseState.departmentName}</ehr:tip></td>
					<td><ehr:tip>${sickbedUseState.sickArea}</ehr:tip></td>
					<td><ehr:tip>${sickbedUseState.sickbedNo}</ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="FS10186" code="${sickbedUseState.extraBedMark}" /></ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="FS10186" code="${sickbedUseState.avirableBedMark}" /></ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="PH00036" code="${sickbedUseState.genderLimited}" /></ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="sickbedUseStateSearch.search" colspan="7"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="sickbedUseStateSearch.search" />
		</tr>
	</table> --%>	
</div>