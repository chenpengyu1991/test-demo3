<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/treatmentAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="treatmentForm" modelAttribute="treatment" >
	  	<input type="hidden" name="createBy" value="${createBy}" />
		<input type="hidden" name="createTime" value="${createTime}" />
	  	<form:hidden path="sewageTreatmentId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>处理记录:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">污水处理量</label></th>
					<td>
						<form:input path="treatmentQuantity" reg='{"required":"true","maxlength":"15"}'/>
					</td>
				</tr>
				<tr>
					<th ><label class="required">消毒剂投加量</label></th>
					<td><form:input path="dosingQuantity" reg='{"required":"true","maxlength":"15"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">余氯值</label></th>
					<td><form:input path="residualChlorineVal" reg='{"required":"true","maxlength":"15"}'/></td>
				</tr>
				<tr>
					<th><label class="required">处理人</label></th>
					<td>
						<form:input path="assigner" reg='{"required":"true","maxlength":"20"}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">处理日期</label></th>
					<td>
						<c:if test="${type == 'view'}">
								<input type="text" name="treatmentDate" value="<fmt:formatDate value='${treatment.treatmentDate}' pattern='yyyy/MM/dd HH:mm:ss' />" 
								readonly="readonly"/>
						</c:if>
						<c:if test="${type != 'view'}">
							<tag:dateInput nullToToday="true" name="treatmentDate" date="${treatment.treatmentDate}"
							 pattern="yyyy/MM/dd HH:mm:ss"  onlypast="true"  reg="{'required':'true','tip':'请填写处理时间'}"></tag:dateInput>
						</c:if>
					</td>
				</tr>
			</table>
		</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" id="saveButton" value="保 存" class="btnopr" /> 
			<input type="button" id="cancelButton" value="关 闭" class="btnopr" />
		</p>
	</div>
</div>
