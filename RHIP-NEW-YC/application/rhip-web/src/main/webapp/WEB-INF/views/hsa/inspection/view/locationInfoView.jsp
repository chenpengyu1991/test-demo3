<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fieldset class="layui-elem-field">
	<table class="posttable" id="has-view-loaction-info-table">
		<colgroup>
			<col style="width: 12%;" />
			<col style="width: 38%;" />
			<col style="width: 12%;" />
			<col style="width: 38%;" />
		</colgroup>
		<tr>
			<th><label for="unitName">单位名称</label></th>
			<td colspan="3">
			<select class="hide" name="locationInfo.healthProfessional">
				<option value="${locationInfo.healthProfessional}" >${locationInfo.healthProfessional}</option>
			</select>
			<input type="text" readonly id="unitName" value="${locationInfo.unitName}"></input></td>
		</tr>
		<tr>
			<th><label for="unitTypeCode">负责人</label></th>
			<td>${locationInfo.personInCharge}</td>
			<th><label for="scale">联系电话</label></th>
			<td>${locationInfo.contactPhone}</td>
		</tr>
	</table>
</fieldset>
