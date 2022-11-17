<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/drugUse/drugAdd.js" type="text/javascript"></script>
<div class="postcontent">
<fieldset class="layui-elem-field">
<legend>发药记录</legend>
	<form id="drugAddForm">
		<div class="postdiv">
			<input type="hidden" id="drugUseId" name="id" value="${mhmDrugUse.id}"/>
			<input type="hidden" id="statusId" name="statusId" value="${statusId}"/>
			<table id="drugAddTable"  class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:85%;"/>
				</colgroup>
				<tr>
					<th><label class="required">发药时间:</label></th>
					<td>
                        <tag:dateInput name="useDt" date="${mhmDrugUse.useDt}" reg='{"required":"true"}' style="width: 100px;"/>
					</td>
				</tr>				
				<tr>
					<th><label class="required">药物名称:</label></th>
					<td>
                        <tag:autoSelect reg="{'required':true}" 
                        	codeValue="${mhmDrugUse.drugId}" 
                        	nameValue="${mhmDrugUse.drugName}"
                        	name="drugId" id="drugSelectBox" style="width:120px;"></tag:autoSelect>
                        <input type="hidden" id="hDrugName" name="drugName" value='${mhmDrugUse.drugName}'/>
                        <input type="hidden" name="type" value="3"/>
					</td>
				</tr>
				<tr>
					<th><label id="lbUseCount" class="required">发药数量:</label></th>
					<td>
						<input type="text" name="useCount" id="useCount"
							value ='${mhmDrugUse.useCount}' reg='{"required":"true","digits":"true","min":"1","max":"10000"}' style="width:120px;"/>
					</td>
				</tr>
				<tr>
					<th>单位:</th>
					<td>
						<label id="drugUnit">${mhmDrugUse.drugUnit}</label>
					</td>
				</tr>
				<tr>
					<th>单位剂量:</th>
					<td>
						<label id="unitMeasure">${mhmDrugUse.unitMeasure}</label>
					</td>
				</tr>	
				<tr>
					<th>单价:</th>
					<td>
						<label id="currentUnitOrice">${mhmDrugUse.currentUnitOrice}</label>
						<input type="hidden" id="currentUnitOriceHidden" name="currentUnitOrice" value="${mhmDrugUse.currentUnitOrice}"/>
						<input type="hidden" id="freeType" name="freeType" value="${mhmDrugUse.freeType}"/>
					</td>
				</tr>	
				<tr>
					<th>总价:</th>
					<td>
						<label id="currentPrice">${mhmDrugUse.currentPrice}</label>
						<input type="hidden" id="currentPriceHidden" name="currentPrice" value="${mhmDrugUse.currentPrice}"/>
					</td>
				</tr>											
			</table>
		</div>
	</form>
</fieldset>	
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<!-- <input type="button" id="saveDrugAdd" value="添加" > -->
			<button class="layui-btn layui-btn-sm"  id="saveDrugAdd" >添加</button>
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<!-- <input type="button" id="modifyDrugAdd" value="修改"> -->
			<button class="layui-btn layui-btn-sm"  id="modifyDrugAdd" >修改</button>
	    </c:if>	
		<!-- <input type="button" id="cancelDrugAdd" value="取消" > -->
		<button class="layui-btn layui-btn-sm"  id="cancelDrugAdd" >取消</button>
	</div>
</div>
