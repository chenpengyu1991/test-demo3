<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh3Form" method="get">
		<div>
			<table class="formtable" id="popEh3Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 28%">养殖场名称</th>
					<td>
                        <input type="text" name="farmName" value="${idmListEh.farmName}" reg='{"required":"true","maxlength":"50"}' style="width: 400px;">
                    </td>
				</tr>
                <tr>
                    <th>饲养动物种类及数量</th>
                    <td>
                        <input type="text" name="animalType" value="${idmListEh.animalType}" reg='{"maxlength":"200"}' style="width: 400px;">
                    </td>
                </tr>
				<tr>
					<th>病/死动物种类及数量</th>
					<td><input type="text" name="dieNum" value="${idmListEh.dieNum}" reg='{"maxlength":"100"}' style="width: 400px;"></td>

				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',3)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',3)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>