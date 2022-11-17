<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/idm/case/sarsanimal.js" type="text/javascript"></script>
<div>
	<form id="animalForm" method="get">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:35%;"/>
		            <col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>				
				<tr>
					<th>时间:</th>
					<td>
						<tag:dateInput id="contactBeginDt" name="contactBeginDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListEsAnimal.contactBeginDt}' style="100px;"/>					
					</td>
					<th>动物名称:</th>
					<td>
						<input type="text" id="contactAnimalName" name="contactAnimalName" reg='{"maxlength":"100"}' 
							value ='${idmListEsAnimal.contactAnimalName}' style="width:98%"/>					
					</td>	
				</tr>
				<tr>									
					<th>地点:</th>
					<td colspan="3">
						<input type="text" id="contactAnimalAddr" name="contactAnimalAddr" reg='{"maxlength":"100"}' 
							value ='${idmListEsAnimal.contactAnimalAddr}' style="width:98%"/>					
					</td>
				</tr>
				<tr>

					<th><label class="required">接触方式:</label></th>
					<td colspan="3">
						<ehr:dic-checkbox id="contactAnimalSell" name="contactAnimalSell" dicmeta="IDM00143" 
							onchange="toggleOtherCK('contactAnimalSell','contactAnimalOther','99')" reg='{"required":"true"}' code="1,2,3,4,99" value ='${idmListEsAnimal.contactAnimalSell}' />
						<input type="text" id="contactAnimalOther" name="contactAnimalOther" reg='{"maxlength":"100"}' 
							value ='${idmListEsAnimal.contactAnimalOther}' style="width:48%"/>								
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveEsAnimal" name="saveEsAnimal" value="添加" onclick="sarsCase.save(2)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEsAnimal" name="modifyEsAnimal" value="修改" onclick="sarsCase.modify(2)">
	    </c:if>	
		<input type="button" id="cancelEsAnimal" name="cancelEsAnimal" value="取消" onclick="caseEdit.closePopUp('animalDialog')">
	</div>
</div>