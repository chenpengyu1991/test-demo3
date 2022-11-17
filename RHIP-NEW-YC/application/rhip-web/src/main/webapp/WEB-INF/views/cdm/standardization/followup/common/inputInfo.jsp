<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>随访信息</legend>
	<input type="hidden" name="createOrganCode" value="${input.createOrganCode}" />
	<input type="hidden" name="createOrganName" value="${input.createOrganName}" />
	<input type="hidden" name="createDoctorCode" value="${input.createDoctorCode}" /> 
	<input type="hidden" name="createDoctorName" value="${input.createDoctorName}" /> 
	<input type="hidden" name="createDate" readonly="readonly" value='<fmt:formatDate value="${input.createDate}" pattern="yyyy/MM/dd" />' />
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label class="required">随访医生</label></th>
			<td><c:choose>
				<c:when test="${empty input.createDoctorCode}">
					<input style="width:178px;" type="text" readonly="readonly" value="${input.createDoctorName}" />
				</c:when>
				<c:otherwise>
					<input style="width:178px;" type="text" readonly="readonly" value="<ehr:user userCode='${input.createDoctorCode}' />" >
				</c:otherwise>
				</c:choose>
			<td>
		</tr>
		<tr>
			<th><label>随访机构</label></th>
			<td><input style="width:178px;" type="text" readonly="readonly" value='<ehr:org code="${input.createOrganCode}"></ehr:org>' /></td>
		</tr>
		<tr>
			<th><label>备注</label></th>
			<td>
				<textarea rows="2" id="comments" name="comments" reg="{'maxlength':1000}">${input.comments}</textarea>
			</td>
		</tr>
	</table>
</fieldset>