<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
	
	<%--可疑职业病人添加表单--%>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 35%; min-width: 200px;" />
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 35%; min-width: 200px;" />
		</colgroup>
		<tr>
			<th><label class="required" for="name">姓名</label></th>
			<td><input type="text" id="name" name="name" value="${data.name}" reg="{'required':'true','maxlength':50}"></input></td>
			<th><label class="required" for="gender">性别</label></th>
			<td><ehr:dic-radio dicmeta="GBT226112003" name="gender" id="gender"  reg="{'required':'true'}" value="${data.gender}"/></td>
		</tr>
		<tr>
			<th><label class="required" for="age">年龄</label></th>
			<td><tag:numberInput  id="age" name="age" value="${data.age}" reg="{'required':'true','maxlength':10}"/></td>
			<th><label class="required" for="idcard">居民身份证</label></th>
			<td><input type="text" id="idcard" name="idcard" value="${data.idcard}" reg="{'required':'true','creditcard':'true'}"></input></td>
		</tr>
		<tr>
			<th><label for="workUnit">工作单位</label></th>
			<td><input type="text" id="workUnit" name="workUnit" value="${data.workUnit}" reg="{'maxlength':50}"></input></td>
			<th><label for="occupation">工种</label></th>
			<td><ehr:dic-list dicmeta="GBT6565"  width="210px;" code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120224,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"  value="${data.occupation}" id="occupation" name="occupation"  /></td>
		</tr>
		<tr>
			<th><label for="susOccDiseaseName">可疑职业病名称</label></th>
			<td><input type="text" id="susOccDiseaseName" name="susOccDiseaseName" value="${data.susOccDiseaseName}" reg="{'maxlength':100}"></input></td>
			<th><label for="unitPhoneNumber">工作单位电话</label></th>
			<td><input type="text" id="unitPhoneNumber" name="unitPhoneNumber" value="${data.unitPhoneNumber}" reg="{'maxlength':20}"/></td>
		</tr>
		<tr>
			<th><label for="phoneNumber">患者电话</label></th>
			<td><input type="text" id="phoneNumber" name="phoneNumber" value="${data.phoneNumber}" reg="{'maxlength':20}"/></td>
			<th><label for="recipientUnit">接报人单位</label></th>
			<td><input type="text" id="recipientUnit" name="recipientUnit" value="${data.recipientUnit}" reg="{'maxlength':50}"></input></td>
		</tr>
		<tr>			
			<th><label for="recipientName">接报人姓名</label></th>
			<td><input type="text" id="recipientName" name="recipientName" value="${data.recipientName}" reg="{'maxlength':50}"></input></td>
			<th><label for="recipientPhone">接报人电话</label></th>
			<td><input type="text" id="recipientPhone" name="recipientPhone" value="${data.recipientPhone}" reg="{'maxlength':20}"/></td>
		</tr>
		<tr>
			
			<td><input type="hidden" id="id" name="id" value="${data.id}" reg="{'maxlength':30}"></input></td>
		</tr>
	</table>
