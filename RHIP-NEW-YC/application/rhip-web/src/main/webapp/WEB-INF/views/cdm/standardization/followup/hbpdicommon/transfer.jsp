<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset>
	<legend>转诊</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label class="required" for="drugName1">原因</label></th>
			<td><input type="text" /></td>
		<tr>
			<th><label class="required" for="hbpDiagnosedOrganCode">机构</label></th>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<th><label class="required" for="hbpDiagnosedOrganCode">科别</label></th>
			<td><input type="text" /></td>
		</tr>
	</table>
</fieldset>
