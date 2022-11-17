<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="restSdForm">
			<input type="hidden" id=rowNum value="${rowNum}"/>
			<table id="restSdChildTable" class="formtable"> 
				<colgroup>
					<col style="width:10%;"/>
					<col style="width:20%;"/>
		            <col style="width:10%;"/>
					<col style="width:20%;"/>
				</colgroup>	
				<tr>
					<th><label class="required">用药日期</label></th>
					<td>
						<tag:dateInput id="sdDrugDtId" name="drugDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${listSd.drugDt}' style="100px;" reg='{"required":"true"}'/>
					</td>				
					<th><label class="required">药物名称</label></th>
					<td>
						<input type="text" name="drugName" reg='{"maxlength":"20"}' 
							value ='<c:if test="${empty listSd.drugName}">伯氨喹</c:if>${listSd.drugName}' style="width:98%" reg='{"required":"true"}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">年龄组</label></th>
					<td colspan="3">
				 		<ehr:dic-radio name="ageDose" dicmeta="IDM00223" value="${listSd.ageDose}" reg='{"required":"true"}'/>					
					</td>
				</tr>
			</table>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveFgRestSd" name="saveFgRestSd" value="添加" onclick="fgrestdrugreg.saveRecord('add')">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyFgRestSd" name="modifyFgRestSd" value="修改" onclick="fgrestdrugreg.saveRecord('edit')">
	    </c:if>	
		<input type="button" id="cancelFgRestSd" name="cancelFgRestSd" value="取消" onclick="idmCommon.closePopUp('fgRestSdDialog')">
	</div>
</div>