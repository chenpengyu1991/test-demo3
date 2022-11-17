<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div>
	<form id="disinfect">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup>
					<col style="width:80px;"/>
					<col style="width:200px;"/>
		            <col style="width:80px;"/>
					<col style="width:200px;"/>
				</colgroup>		
				<tr>
					<th><label class="required">对象</label></th>
					<td><ehr:dic-list id="disObject" name="disObject" dicmeta="IDM00209" value="${idmListEfc.object}" reg='{"required":"true"}' width="150px"/></td>
					<th>药物浓度</th>
					<td><input type="text" id="disninfectDrugCon" name="drugConcentration" value="${idmListEfc.drugConcentration}" reg='{"maxlength":"100"}' style="width: 36%"/></td>
				</tr>
				<tr>
					<th>消毒药物</th>
					<td><input type="text" id="disninfectSterDrug" name="sterilizeDrug"  value="${idmListEfc.sterilizeDrug}"  reg='{"maxlength":"100"}' style="width: 150px"/></td>
					<th>数  量</th>
					<td><input type="text" id="disninfectDrugNum" name="drugNum" value="${idmListEfc.drugNum}" reg='{"maxlength":"20"}' style="width: 36%"/></td>
				</tr>
				<tr>
					<th>消毒方式</th>
					<td><input type="text" id="disninfectSterType" name="sterilizeTrug" value="${idmListEfc.sterilizeType}" reg='{"maxlength":"100"}' style="width: 150px"/></td>
					<th><label class="required">消毒时间</label></th>
					<td><tag:dateInput id="disninfectAttackDt" name="attackDt" pattern="yyyy/MM/dd" onlypast="true" date='${idmListEfc.attackDt}' reg='{"required":"true"}' style="width: 36%"/></td>
				</tr>
		</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveDisinfect" name="saveDisinfect" value="添加" onclick="dysenteryCase.saveDisinfect()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyDisinfect" name="modifyDisinfect" value="修改" onclick="dysenteryCase.modifyDisinfect()">
	    </c:if>		
		<input type="button" id="cancelDisinfect" name="cancelDisinfect" value="取消" onclick="caseEdit.closePopUp('disinfectDialog')">
	</div>
</div>
