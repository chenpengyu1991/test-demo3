<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/followUp/medication.js" type="text/javascript"></script>
<div class="postcontent">
<fieldset class="layui-elem-field">
<legend>用药记录</legend>
	<form id="medicationForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="medicationDetailTable"  class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:85%;"/>
				</colgroup>
				<tr>
					<th><label class="required">药物名称:</label></th>
					<td>
                        <tag:autoSelect reg="{'required':true}" 
                        	codeValue="${mhmDrugRecord.drugId}" 
                        	nameValue="${mhmDrugRecord.drugName}"
                        	name="drugId" id="drugSelectBox" style="width:120px;"></tag:autoSelect>
                        <input type="hidden" id="hDrugName" name="drugName" value='${mhmDrugRecord.drugName}'/>
                        <input type="hidden" name="type" value="3"/>
					</td>
				</tr>
				<tr>
					<th>早:</th>
					<td>
						<input type="text" name="drugMorning" 
							value ='${mhmDrugRecord.drugMorning}' reg='{"digits":"true","min":"1","max":"100"}' style="width:120px;"/>
					</td>
				</tr>
				<tr>
					<th>中:</th>
					<td>
						<input type="text" name="drugNoon" 
							value ='${mhmDrugRecord.drugNoon}' reg='{"digits":"true","min":"1","max":"100"}' style="width:120px;"/>
					</td>
				</tr>
				<tr>
					<th>晚:</th>
					<td>
						<input type="text" name="drugEvening"
							value ='${mhmDrugRecord.drugEvening}' reg='{"digits":"true","min":"1","max":"100"}' style="width:120px;"/>
					</td>
				</tr>
				<tr>
					<th>单位</th>
					<td>
						<label id="unit">${mhmDrugRecord.unit}</label>
						<input type="hidden" id="hUnit" name="unit" value="${mhmDrugRecord.unit}"/>
					</td>
				</tr>
                <tr>
                    <th>特殊情况:</th>
                    <td>
                        <input name="drugSpecial" type="text" value="${mhmDrugRecord.drugSpecial}" reg='{"maxlength":"100"}' style="width:98%;">
                    </td>
                </tr>
			</table>
		</div>
	</form>
</fieldset>	
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<!-- <input type="button" id="saveMedication" value="添加" > -->
			<button class="layui-btn layui-btn-sm" id="per_search_btn">添加</button>
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<!-- <input type="button" id="modifyMedication" value="修改"> -->
			<button class="layui-btn layui-btn-sm" id="modifyMedication">修改</button>
	    </c:if>	
		<!-- <input type="button" id="cancelMedication" value="取消" > -->
		<button class="layui-btn layui-btn-sm" id="cancelMedication">取消</button>
	</div>
</div>
