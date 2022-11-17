<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addLe3Form" method="get">
		<div>
			<table class="formtable" id="popLe3Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 25%">检查时间</th>
					<td>
                        <tag:dateInput name="ctDt" onlypast="true" date="${idmListLe.ctDt}" reg='{"required":"true"}'/>
                    </td>

				</tr>
                <tr>
                    <th style="width: 15%">结果</th>
                    <td>
                        <input type="text" name="resultContent" value="${idmListLe.resultContent}" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
				<tr>
					<th>检测单位</th>
					<td><input type="text" name="detectionUnit" value="${idmListLe.detectionUnit}" reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveLeData('add',3)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveLeData('edit',3)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('leDialog')">
    </div>
</div>