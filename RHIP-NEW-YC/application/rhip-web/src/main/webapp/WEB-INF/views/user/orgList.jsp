<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<fieldset id="roleFieldset" class="layui-elem-field">
	<legend>相应机构和角色</legend>
	<div id="roleListDiv"></div>
	<div class="repeattable">
		<table class="posttable" id="userOrgTableId">
			<colgroup>
				<col style="width: 20%"/>
				<col style="width: 80%"/>
			</colgroup>
			<thead>
			<tr>
				<th class="centerth" style="width: 5%">机构名称</th>
				<th class="centerth" style="width: 10%">已选角色</th>
			</tr>
			</thead>
			<c:forEach var="staffOrg" items="${staffOrgs}">
				<tr>
					<td field="organCode" title="<ehr:org code="${staffOrg.organCode}"/>">
						<input name="organCode" value="${staffOrg.organCode}" type="checkbox" onchange="addUser.loadRoleByOrganCode('${staffOrg.organCode}')"
						<c:forEach items="${haveRoles}" var="haveRole">
							<c:if test="${haveRole.organCode eq staffOrg.organCode}">
								checked="checked"
							</c:if>
						</c:forEach>/>
						<a onclick="addUser.loadRoleByOrganCode('${staffOrg.organCode}')"><ehr:org code="${staffOrg.organCode}"/></a>
					</td>
					<td id="td${staffOrg.organCode}" field="roleCode" onclick="addUser.loadRole('${staffOrg.organCode}')">
						<c:set var="roleCodes" value="" scope="application"></c:set>
						<c:forEach items="${haveRoles}" var="haveRole">
							<c:if test="${haveRole.organCode eq staffOrg.organCode}">
								<ehr:role-name roleCode="${haveRole.roleCode}"/>&nbsp;&nbsp;
								<c:set var="roleCodes" value="${roleCodes },${haveRole.roleCode}" scope="application"></c:set>
							</c:if>
						</c:forEach>
						<input name="roleCode" value="${roleCodes}" type="hidden" id="roleCodeIds">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</fieldset>
