<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
	$(function() {
		toggleOther('contactAttackCondition','spanAttackDt',1);
	});
</script>
<div>
	<form id="contact">
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
					<th><label class="required">姓名</label></th>
					<td><input type="text" id="contactsName" name="name" reg='{"required":"true","maxlength":"50"}' value ='${idmListEfc.name}'/></td>
					<th>性别</th>
					<td><ehr:dic-list id="contactSex" name="sex" dicmeta="GBT226112003" code="1,2" value ='${idmListEfc.sex}' width="150px"/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" id="contactAge" name="age" reg='{"digits":"true","min":"1","max":"200"}' value ='${idmListEfc.age}' reg='{"digits":"true","max":"200"}'style="width:36%"/></td>
					<th>关系</th>
					<td><ehr:dic-list id="contactRelation" name="relation" dicmeta="IDM00018" value ='${idmListEfc.relation}' width="150px"/></td>
				</tr>
				<tr>
					<th>单位或住址</th>
					<td><input type="text" id="contactUnitAddr" name="unitAddr" reg='{"maxlength":"100"}' value ='${idmListEfc.unitAddr}' style="width:98%"/>	</td>
					<th>实验室检查</th>
					<td><input type="text" id="contactLabExamination" name="labExamination" reg='{"maxlength":"100"}' value ='${idmListEfc.labExamination}' style="width:98%"/></td>
				</tr>
				<tr>
					<th>接触方式</th>
					<td colspan="3"> 	
						<ehr:dic-checkbox id="contactType" name="contactType" dicmeta="IDM00033" value="${idmListEfc.contactType}" code="1,2,7,99"/>
						</td>
				</tr>
				<tr>
					<th><label class="required">是否发病</label></th>
					<td colspan="3">
						<ehr:dic-radio name="contactAttackCondition" dicmeta="PH00002"  code="1,2" value ='${idmListEfc.attack}' 
							onchange="toggleOther('contactAttackCondition','spanAttackDt',1)" reg='{"required":"true"}' />
						<span id="spanAttackDt">发病日期<tag:dateInput id="contactAttackDt" name="attackDt" onlypast="true" pattern="yyyy/MM/dd"  reg='{"required":"true"}' date='${idmListEfc.attackDt}' style="width: 36%"/></span>
					</td>
				</tr>				
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveContact" name="saveContact" value="添加" onclick="dysenteryCase.saveContact()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyContact" name="modifyContact" value="修改" onclick="dysenteryCase.modifyContact()">
	    </c:if>	
		<input type="button" id="cancelContact" name="cancelContact" value="取消" onclick="caseEdit.closePopUp('contactDialog')">
	</div>
</div>
