<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/user/addOrg.js" type="text/javascript"></script>

<form id="orgForm">
<input type="hidden" name="userCode" value="${userCode}"/>
<div class="section" style="width: 99%">
	<table class="formtable">
		<tr>
			<th style="width: 100px;">选择机构</th>
			<td>
				<ehr:dic-town-centre-station townId="searchTownId" centreId="searchCenterId" stationId="searchStationId"
				townValue="${townCode}" centreValue="${centerCode}" stationValue="${stationCode}"
				 centreName="searchCenter" stationName="searchstation" townName="searchTown"  style="width:130px;"/>
			</td>
		</tr>
		<tr>
			<th>设定角色</th>
			<td>
				<c:forEach var="role" items="${roles}" varStatus="status">
					<input type="checkbox" name="rolecheck" class="chk_selectone" value="${role.id}"/> ${role.description}<br/>
					<input type="hidden" id="roleName${role.id}" value="${role.description}"/>
				</c:forEach>
			</td>
		</tr>
	</table>
	<div>
		<input type="button" id="saveRoleBtn" value="保存"/>
		<input type="button" id="cancelBtnId" value="取消"/>
	</div>
</div>
</form>