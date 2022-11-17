<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mouseAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="mouseForm" modelAttribute="mouse" >
	  	<input type="hidden" name="createBy" value="${createBy}" />
		<input type="hidden" name="createTime" value="${createTime}" />
	  	<form:hidden path="monitorId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>捕鼠记录:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">鼠种</label></th>
					<td>
						<ehr:dic-list name="mouseSpecies" dicmeta="DMBC00002" reg='{"required":"true"}' value="${mouse.mouseSpecies}"/>
					</td>
				</tr>
				<tr>
					<th ><label class="required">捕鼠地点</label></th>
					<td><form:input path="site" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th><label class="required">室内/室外</label></th>
					<td>
						<ehr:dic-list name="environment" dicmeta="FS10015" code="2,3" reg='{"required":"true"}' value="${mouse.environment}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">性别</label></th>
					<td>
						<ehr:dic-list name="gender" dicmeta="DMBC00010" reg='{"required":"true"}' value="${mouse.gender}"/>
					</td>
				</tr>
				<tr>
					<th>体重(g)</th>
					<td><form:input path="weight"  reg='{"digits":"true","maxlength":"11"}' /></td>
				</tr>
				<tr>
					<th>头体长(mm)</th>
					<td><form:input path="bodyLength"  reg='{"digits":"true","maxlength":"3"}' /></td>
				</tr>
				<tr>
					<th>备注</th>
					<td><form:textarea path="remarks"  reg='{"maxlength":"40"}' /></td>
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
