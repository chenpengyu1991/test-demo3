<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${allowEdit}">
	<tr>
		<th><label class="required" for="diagnosisOrganCode">诊断机构</label></th>
		<td colspan="3">
			<%-- 		<ehr:org-type-list  width="250px" reg="{'required':true}" name="diagnosisOrganCode" type="hospital,centre"  value="${reportInfo.diagnosisOrganCode}"/> --%>
			<c:if test="${reportInfo.otherDiagnosisOrganFlag eq '2' }">
				${reportInfo.otherDiagnosisOrganName}
			</c:if> <c:if test="${reportInfo.otherDiagnosisOrganFlag != '2' }">
				<ehr:org flag="0" code="${reportInfo.diagnosisOrganCode}"></ehr:org>
			</c:if>
		</td>
	</tr>
	<tr>
		<th><label for="ehrNo">门诊号</label></th>
		<td><input type="text" id="ehrNo" name="report[${index}].ehrNo" value="${reportInfo.ehrNo}" reg="{'maxlength':10}" /></td>
		<th><label for="admissionNo">住院号</label></th>
		<td><input type="text" id="admissionNo" name="report[${index}].admissionNo" value="${reportInfo.admissionNo}" reg="{'maxlength':10}" /></td>
	</tr>
</c:if>
<c:if test="${false==allowEdit}">
	<tr>
		<th><label>诊断机构</label></th>
		<td><c:if test="${reportInfo.otherDiagnosisOrganFlag eq '2' }">
				${reportInfo.otherDiagnosisOrganName}
		</c:if> <c:if test="${reportInfo.otherDiagnosisOrganFlag != '2' }">
				<ehr:org flag="0" code="${reportInfo.diagnosisOrganCode}"></ehr:org>
			</c:if>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<th><label for="ehrNo">门诊号</label></th>
		<td><input type="text" id="ehrNo" value="${reportInfo.ehrNo}" readonly="readonly" /></td>
		<th><label for="admissionNo">住院号</label></th>
		<td><input type="text" id="admissionNo" name="admissionNo" value="${reportInfo.admissionNo}" readonly="readonly" /></td>
	</tr>
</c:if>
<tr>
	<c:if test="${not empty reportInfo.createDoctorCode }">
              <c:set var="createDoctorCode"> <ehr:user userCode="${reportInfo.createDoctorCode}"></ehr:user> </c:set>
        </c:if>
       <c:if test="${ empty reportInfo.createDoctorCode }">
                <c:set var="createDoctorCode"> ${reportInfo.createDoctorName}</c:set>
       </c:if>
	<th><label>填报医生</label></th>
	<td><input type="text" readonly="readonly" value='${createDoctorCode}' /></td>
		
</tr>
<tr>
	<th><label>填报机构</label></th>
	<td><input type="text" readonly="readonly" value="<ehr:org code="${reportInfo.createOrganCode}"></ehr:org>" /></td>
	<th><label for="createDate">填报时间</label></th>
	<td><input type="text" readonly="readonly" value='<fmt:formatDate value="${reportInfo.createDate}" pattern="yyyy/MM/dd" />' /></td>

</tr>

