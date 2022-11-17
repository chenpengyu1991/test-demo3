<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<form id="addCell" method="get">
	<input type="hidden" id="rowIndex" value="${rowIndex}"/>
	<div>
		<table class="formtable" id="popCellTable">
			 <colgroup>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	        </colgroup>
			<tr>
				<th>日期</th>
				<td>
					<tag:dateInput name="cellCategoryDt" onlypast="true" id="cellCategoryDt" date="${idmListLe.cellCategoryDt}"/>
                </td>
				<th>总数</th>
				<td>
					<input type="text" name="totality" id="totality" value="${idmListLe.totality}" reg='{"maxlength":"20"}'>
                 </td>
			</tr>
			<tr>
				<th>中性</th>
				<td>
					<input type="text" name="neutrophilcell" id=neutrophilcell value="${idmListLe.neutrophilcell}" reg='{"maxlength":"100"}'>
                 </td>
				<th>淋巴</th>
				<td>
					<input type="text" name="lymphocyte" id="lymphocyte" value="${idmListLe.lymphocyte}" reg='{"maxlength":"100"}'>
                 </td>
			</tr>
			<tr>
				<th>嗜酸性</th>
				<td>
					<input type="text" name="eosinophils" id="eosinophils" value="${idmListLe.eosinophils}" reg='{"maxlength":"100"}'>
                </td>
                <th>其它</th>
                <td>
					<input type="text" name="otherResult" id="otherResult" value="${idmListLe.otherResult}" reg='{"maxlength":"100"}'>
                </td>
			</tr>
		</table>
	</div>
</form>
<div class="toolbarpop">
    <c:if test="${type == 'add'}">
        <input type="button" id="saveContact" value="添加" onclick="typhiaCase.addCellList()">
    </c:if>
    <c:if test="${type == 'edit'}">
        <input type="button" id="editContact" value="修改" onclick="typhiaCase.editCellList()">
    </c:if>
    <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('cellDialog')">
</div>
</div>

