<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addLe1Form" method="get">
		<div>
			<table class="formtable" id="popLe1Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">血常规检查时间</th>
					<td style="width: 35%">
                        <tag:dateInput name="routineBloodTestDt" onlypast="true" date="${idmListLe.routineBloodTestDt}" reg='{"required":"true"}'/>
                    </td>
					<th style="width: 15%">WBC（10<sup>9</sup>/L）</th>
					<td>
                        <input type="text" name="wbc" value="${idmListLe.wbc}" reg='{"maxlength":"20"}'>
                    </td>
				</tr>
				<tr>
					<th>N（%）</th>
					<td><input type="text" name="n" value="${idmListLe.n}" reg='{"maxlength":"20"}'></td>
					<th>L（%）</th>
					<td><input type="text" name="l" value="${idmListLe.l}" reg='{"maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>检测单位</th>
					<td>
                        <input type="text" name="detectionUnit" value="${idmListLe.detectionUnit}" reg='{"maxlength":"100"}'>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveLeData('add',1)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveLeData('edit',1)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('leDialog')">
    </div>
</div>