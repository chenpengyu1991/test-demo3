<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<fieldset class="layui-elem-field">
	<legend>
		<span>报告信息</span>
	</legend>
	<table class="fieldset_table">
		<tr>
			<th><label class="required" for="personInfo.diagnosisOrganCode">诊断机构</label></th>
			<td colspan="3"><ehr:dic-list dicmeta="FS10002" id="personInfo.diagnosisOrganCode" name="personInfo.diagnosisOrganCode" value="${diseaseInfo.personInfo.diagnosisOrganCode}" reg="{'required':true}"></ehr:dic-list></td>
		</tr>
		<tr>
			<th><label for="personInfo.ehrNo">门诊号</label></th>
			<td><input id="personInfo.ehrNo" name="personInfo.ehrNo" value="${diseaseInfo.personInfo.ehrNo}" reg="{'maxlength':10}"></input></td>
			<th><label for="personInfo.admissionNo">住院号</label></th>
			<td><input id="personInfo.admissionNo" name="personInfo.admissionNo" value="${diseaseInfo.personInfo.admissionNo}" reg="{'maxlength':10}"></input></td>
		</tr>
		<tr>
			<th><label class="required" for="personInfo.createOrganCode">填报机构</label></th>
			<td><ehr:dic-list dicmeta="FS10002" id="personInfo.createOrganCode" name="personInfo.createOrganCode" value="${diseaseInfo.personInfo.createOrganCode}" reg="{'required':true}"></ehr:dic-list></td>
			<th><label class="required" for="personInfo.createDate">填报时间</label></th>
			<td><tag:dateInput onlypast="true" id="personInfo.createDate" name="personInfo.createDate" date="${diseaseInfo.personInfo.createDate}" reg="{'required':true}"></tag:dateInput></td>
		</tr>
	</table>
</fieldset>
