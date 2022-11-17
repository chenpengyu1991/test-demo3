<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<form id="hsa-familyrecordadd-form">
	<input type="hidden" name="id" value="${inspRecord.id}">
	<div class="postcontent">
		<i class="popno">工作登记</i>
		<div class="postdiv">
			<fieldset>
				<legend>家庭信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label class="required">户主</label></th>
						<td><input type="text" value="${inspRecord.familyInfo.householderName}" name="familyInfo.householderName" reg="{'required':true,'maxlength':50}"></input></td>
						<th><label>联系电话</label></th>
						<td><input type="text" reg="{'maxlength':20}" value="${inspRecord.familyInfo.phoneNumber}" name="familyInfo.phoneNumber" /></td>
					</tr>
					<tr>
						<th><label class="required">家庭地址</label></th>
						<td colspan="3"><input type="text" value="${inspRecord.familyInfo.address}" name="familyInfo.address" reg="{'maxlength':200,'required':true}"></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label class="required" for="inspDate">巡查日期</label></th>
						<td><tag:dateInput name="inspDate" id="inspDate" onlypast="true" date="${inspRecord.inspDate}" reg="{'required':true}" /></td>
						<th><label class="required" for="inspPersonName">巡查人</label></th>
						<td><ehr:staff-list reg='{"required":true,"compare":["hsa-insprecord-secinsppersoncode","ne","不能选择相同的巡查人"]}' style="width:120px;" id="hsa-insprecord-insppersoncode"
								value="${inspRecord.inspPersonCode}" name="inspPersonCode"></ehr:staff-list> <ehr:staff-list style="width:120px;" value="${inspRecord.secInspPersonCode}"
								reg='{"compare":["hsa-insprecord-insppersoncode","ne","不能选择相同的巡查人"]}' id="hsa-insprecord-secinsppersoncode" name="secInspPersonCode"></ehr:staff-list></td>
					</tr>
					<tr>
						<th><label for="remark">备注</label></th>
						<td colspan="3"><input type="text" id="remark" value="${inspRecord.remark}" name="remark" reg="{'maxlength':40}"></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>饮用水水质感官性状</legend>
				<table class="posttable" id="hsa-guide-water">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label class="required">异味</label></th>
						<td id="td-dosp"><ehr:dic-radio hideCodes="3,4,5" value="${inspRecord.inspGuideRecord.dosp}" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003"
								name="inspGuideRecord.dosp" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">肉眼可见物</label></th>
						<td id="td-dostv"><ehr:dic-radio hideCodes="3,4,5" value="${inspRecord.inspGuideRecord.dostv}" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003"
								name="inspGuideRecord.dostv" /></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label class="required" for="findMainPro">发现的主要问题</label></th>
						<td colspan="3"><input type="text" id="findMainPro" value="${inspRecord.findMainPro}" name="findMainPro" reg="{'required':true,'maxlength':30}"></input></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
