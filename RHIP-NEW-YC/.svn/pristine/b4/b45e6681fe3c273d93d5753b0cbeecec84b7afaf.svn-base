<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="familyForm" method="get">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup>
					<col style="width:20%;"/>
					<col style="width:30%;"/>
		            <col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>				
				<tr>
					<th>接触者姓名</th>
					<td>
						<input type="text" id="familyName" name="name" reg='{"maxlength":"100"}' 
							value ='${idmListEfcFamily.name}' style="width:98%"/>					
					</td>
					<th>性别</th>
					<td>
						<ehr:dic-radio  name="sex" dicmeta="GBT226112003" value="${idmListEfcFamily.sex}" code="1,2"/>					
					</td>
				</tr>
				<tr>
					<th>年龄</th>
					<td>
						<input type="text" id="familyAge" name="age" reg='{"digits":"true","min":"1","max":"200"}' 
							value ='${idmListEfcFamily.age}' style="width:80px"/>								
					</td>
					<th>关系</th>
					<td>
						<input type="text" id="familyRelation" name="relation" reg='{"maxlength":"100"}' 
							value ='${idmListEfcFamily.relation}' style="width:98%"/>						
					</td>
				</tr>
				<tr>
					<th>接触情况</th>
					<td colspan="3">
						<input type="text" id="familyContactType" name="contactType" reg='{"maxlength":"100"}' 
							value ='${idmListEfcFamily.contactType}' style="width:98%"/>						
					</td>
				</tr>
				<tr>					
					<th>住址(或工作单位)</th>
					<td colspan="3">
						<input type="text" id="familyUnitAddr" name="unitAddr" reg='{"maxlength":"100"}' 
							value ='${idmListEfcFamily.unitAddr}' style="width:98%"/>	
					</td>
				</tr>
				<tr>
					<th>电话号码</th>
					<td colspan="3">
						<input type="text" id="familyTel" name="tel" 
							value ='${idmListEfcFamily.tel}' reg='{"regex":"phone","maxlength":20}' style="width:98%"/>						
					</td>
				</tr>	
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveEfcFamily" name="saveEfcFamily" value="添加" onclick="sarsCase.save(6)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEfcFamily" name="modifyEfcFamily" value="修改" onclick="sarsCase.modify(6)">
	    </c:if>	
		<input type="button" id="cancelEfcFamily" name="cancelEfcFamily" value="取消" onclick="caseEdit.closePopUp('familyDialog')">
	</div>
</div>