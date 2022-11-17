<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="acForm" method="get">
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
					<th>就诊日期</th>
					<td>
						<tag:dateInput id="treatmentDt" name="treatmentDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListAc.treatmentDt}' style="100px;"/>					
					</td>
					<th>就诊医院和科室</th>
					<td>
						<input type="text" id="treatmentDepartments" name="treatmentDepartments" reg='{"maxlength":"100"}' value ='${idmListAc.treatmentDepartments}' style="width:98%"/>
					</td>
				</tr>
				<tr>
					<th>诊断病名</th>
					<td>
						<input type="text" id="diagnosisName" name="diagnosisName" reg='{"maxlength":"100"}' value ='${idmListAc.diagnosisName}' style="width:98%"/>
					</td>
					<th>接诊治疗的医护人员</th>
					<td>
						<input type="text" id="medicalWorkers" name="medicalWorkers" reg='{"maxlength":"100"}' value ='${idmListAc.medicalWorkers}' style="width:98%"/>					
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveAc" name="saveAc" value="添加" onclick="sarsCase.save(4)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyAc" name="modifyAc" value="修改" onclick="sarsCase.modify(4)">
	    </c:if>	
		<input type="button" id="cancelAc" name="cancelAc" value="取消" onclick="caseEdit.closePopUp('acDialog')">
	</div>
</div>