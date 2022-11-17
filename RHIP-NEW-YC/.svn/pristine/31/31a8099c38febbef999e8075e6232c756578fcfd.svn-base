<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.PortalSetType" %>

<c:set var="portalSetTypes" value="<%=PortalSetType.values()%>" />

<form id="portal_set_form">
	<input type="hidden" name="id" value="${portalSet.id}"/>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 80%;" />
		</colgroup>
		<tr>
			<th>
				<label class="required">编码</label>
			</th>
			<td>
				<input type="text" name="code" value="${portalSet.code}" reg="{'required':true,'maxlength':50}" readonly/>
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">名称</label>
			</th>
			<td>
				<input type="text" name="name" value="${portalSet.name}" reg="{'required':true,'maxlength':20}" readonly/>
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">类型</label>
			</th>
			<td>
				${portalSet.type}
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">描述</label>
			</th>
			<td colspan="5">
				<input type="text" name="description" value="${portalSet.description}" reg="{'required':true,'maxlength':200}" />
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<br/>
				<input type="button" value="保存" class="btnopr" onclick="setSearch.save()"/>
			</td>
		</tr>
	</table>
</div>
</form>