<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset class="layui-elem-field">
	<legend>随访信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label>随访医生</label></th>
			<td><ehr:user userCode='${input.createDoctorCode}' /></td>
		</tr>
		<tr>
			<th><label>随访机构</label></th>
			<td><ehr:org code="${input.createOrganCode}"></ehr:org></td>
		</tr>
		<tr>
			<th><label>备注</label></th>
			<td>${input.comments}</td>
		</tr>
	</table>
</fieldset>