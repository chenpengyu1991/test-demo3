<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<form id="addGrubers" method="get">
	<input type="hidden" id="rowIndex" value="${rowIndex}"/>
	<div>
		<table class="formtable" id="popGrubersTable">
			 <colgroup>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	        </colgroup>
			<tr>
				<th>日期</th>
				<td>
					<tag:dateInput name="grubersReactionDt" onlypast="true" id="grubersReactionDt" date="${idmListLe.grubersReactionDt}"/>
                   </td>
				<th>O</th>
				<td>
					<input type="text" name="o" id="o" value="${idmListLe.o}" reg='{"maxlength":"20"}'>
                   </td>
			</tr>
			<tr>
				<th>H</th>
				<td>
					<input type="text" name="h" id=h value="${idmListLe.h}"
                              reg='{"maxlength":"100"}'>
                   </td>
				<th>A</th>
				<td>
					<input type="text" name="a" id="a" value="${idmListLe.a}"
                              reg='{"maxlength":"100"}'>
                   </td>
			</tr>
			<tr>
				<th>B</th>
				<td>
					<input type="text" name="b" id="b" value="${idmListLe.b}"
                              reg='{"maxlength":"100"}'>
                   </td>
                <th>C</th>
				<td>
					<input type="text" name="c" id="c" value="${idmListLe.c}"
                              reg='{"maxlength":"100"}'>
                   </td>
			</tr>
		</table>
	</div>
</form>
<div class="toolbarpop">
    <c:if test="${type == 'add'}">
        <input type="button" id="saveContact" value="添加" onclick="typhiaCase.addGrubersList()">
    </c:if>
    <c:if test="${type == 'edit'}">
        <input type="button" id="editContact" value="修改" onclick="typhiaCase.editGrubersList()">
    </c:if>
    <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('grubersDialog')">
</div>
</div>

