<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<form id="addExam" method="get">
	<input type="hidden" id="rowIndex" value="${rowNum}"/>
	<div>
		<table class="formtable" id="popExamTable">
			 <colgroup>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	        </colgroup>
			<tr>
				<th>试验类型</th>
				<td>
					<ehr:dic-list name="checkItem" id="checkItem" dicmeta="IDM00185" value="${idmListle.checkItem}" defaultval="F"/>
                </td>
				<th>采样时间</th>
				<td>
					<tag:dateInput name="sampleDyFirst" id="sampleDyFirst" onlypast="true" date="${idmListle.sampleDyFirst}"/>
                 </td>
			</tr>
			<tr>
				<th>结果</th>
				<td colspan="3">
					<input type="text" name="checkResult" id="checkResult" value="${idmListle.checkResult}" reg='{"maxlength":"100"}'>
                 </td>
			</tr>
		</table>
	</div>
</form>
<div class="toolbarpop">
    <c:if test="${type == 'add'}">
        <input type="button" id="saveContact" value="添加" onclick="diphtheriaCase.addExamList()">
    </c:if>
    <c:if test="${type == 'edit'}">
        <input type="button" id="editContact" value="修改" onclick="diphtheriaCase.editExamList()">
    </c:if>
    <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('examDialog')">
</div>
</div>

