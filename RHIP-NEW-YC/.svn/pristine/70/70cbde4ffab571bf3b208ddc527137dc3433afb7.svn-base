<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/outInfo/medication.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="medicationForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="medicationDetailTable"  class="formtable">
				<colgroup>
					<col style="width:30%;"/>
					<col style="width:30%;"/>
					<col style="width:20%;"/>
					<col style="width:20%;"/>
				</colgroup>
				<tr>
					<th><label class="required">药物名称:</label></th>
                    <td>
                        <tag:autoSelect reg="{'required':true}"
                                        codeValue="${drugRecord.drugId}"
                                        nameValue="${drugRecord.drugName}"
                                        name="drugId" id="drugSelectBox"/>
                        <input type="hidden" id="hDrugName" name="drugName" value='${drugRecord.drugName}'/>
                    </td>
                    <td></td>
                    <td></td>
				</tr>
				<tr>
					<th>早:</th>
					<td>
						<input type="text" name="drugMorning" reg='{"digits":"true","min":"1","max":"100"}'
							value ='${drugRecord.drugMorning}'/>
					</td>
				</tr>
				<tr>
					<th>中:</th>
					<td>
						<input type="text" name="drugNoon" reg='{"digits":"true","min":"1","max":"100"}'
							value ='${drugRecord.drugNoon}'/>
					</td>
				</tr>
				<tr>
					<th>晚:</th>
					<td>
						<input type="text" name="drugEvening" reg='{"digits":"true","min":"1","max":"100"}'
							value ='${drugRecord.drugEvening}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">单位:</label></th>
					<td>
                        <label id="unit">${drugRecord.unit}</label>
                        <input type="hidden" id="hUnit" name="unit" value="${drugRecord.unit}"/>
					</td>
				</tr>
                <tr>
                    <th>特殊情况:</th>
                    <td colspan="3">
                        <input name="drugSpecial" type="text" value="${drugRecord.drugSpecial}" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<%-- <input type="button" id="saveDetail" value="添加" onclick="medication.saveMedication('add','${refTable}')"> --%>
			<button class="layui-btn layui-btn-sm"  id="saveDetail" onclick="medication.saveMedication('add','${refTable}')">添加</button>
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<%-- <input type="button" id="modifyDetail" value="修改" onclick="medication.saveMedication('edit','${refTable}')"> --%>
			<button class="layui-btn layui-btn-sm"  id="modifyDetail" onclick="medication.saveMedication('edit','${refTable}')">修改</button>
	    </c:if>
		<!-- <input type="button" id="cancelDetail" value="取消" onclick="mhmCommon.closePopUp('medicationDialog')"> -->
		<button class="layui-btn layui-btn-sm"  id="cancelDetail" onclick="mhmCommon.closeLayUiDialog()">取消</button>
	</div>
</div>