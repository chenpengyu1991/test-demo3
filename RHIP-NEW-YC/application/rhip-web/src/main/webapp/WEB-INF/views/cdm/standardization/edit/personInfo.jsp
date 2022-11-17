<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<fieldset>
	<input type="hidden" name="id" value="${diseaseInfo.id}"></input> <input type="hidden" name="personInfo.id" value="${diseaseInfo.personInfo.id}"></input>
	<input type="hidden" name="personInfo.personId" value="${diseaseInfo.personInfo.personId}"></input>
	<legend>
		<span>患者信息</span>
	</legend>
	<table class="fieldset_table">
		<tr>
			<th><label class="required" class="required" for="name">姓名</label></th>
			<td><input id="name" name="personInfo.name" value="${diseaseInfo.personInfo.name}" reg="{'required':true,'maxlength':16}"></input></td>
		</tr>
		<tr>
			<th><label class="required" class="required" for="birthday">出生日期</label></th>
			<td><tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${diseaseInfo.personInfo.birthday}" />
			</td>
		</tr>
		<tr>
			<th><label class="required" class="required" for="gender">性别</label></th>
			<td><ehr:dic-radio dicmeta="GBT226112003" name="personInfo.gender" value="${diseaseInfo.personInfo.gender}" reg="{'required':true}" /></td>
		</tr>
		<tr>
			<th><label class="required" for="phoneNumber">电话</label></th>
			<td><input id="phoneNumber" name="personInfo.phoneNumber" value="${diseaseInfo.personInfo.phoneNumber}" reg="{'regex':'phone'}"></input></td>
		</tr>
	</table>
</fieldset>
