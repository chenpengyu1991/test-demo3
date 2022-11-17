<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mosquitoesAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="mosquitoesForm" modelAttribute="mosquitoes" >
	  	<input type="hidden" name="createBy" value="${createBy}" />
		<input type="hidden" name="createTime" value="${createTime}" />
	  	<form:hidden path="monitorId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>捕蚊记录:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">地点(户名)</label></th>
					<td>
						<form:input path="place" reg='{"required":"true","maxlength":"20"}'/>
					</td>
				</tr>
				<tr>
					<th ><label >淡色（致倦）库蚊</label></th>
					<td><form:input path="culexPi" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th><label >三带喙库蚊</label></th>
					<td>
						<form:input path="culexTr" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >白纹伊蚊</label></th>
					<td>
						<form:input path="aedesAl" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th>埃及伊蚊</th>
					<td><form:input path="aedesAe" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th>中华按蚊</th>
					<td><form:input path="anS" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th>嗜人按蚊</th>
					<td><form:input path="anA" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				
				<tr>
					<th>大劣按蚊</th>
					<td><form:input path="anD" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th>微小按蚊</th>
					<td><form:input path="anM" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th>其它</th>
					<td><form:input path="other" reg='{"digits":"true","maxlength":"3"}'/></td>
				</tr>
				<tr>
					<th >备注</th>
					<td>
						<form:textarea path="remarks" reg='{"maxlength":"40"}'/>
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
