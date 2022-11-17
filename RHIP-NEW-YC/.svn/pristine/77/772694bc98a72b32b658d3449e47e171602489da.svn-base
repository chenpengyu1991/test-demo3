<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<form id="addCulture" method="get">
	<input type="hidden" id="rowIndex" value="${rowIndex}"/>
	<div>
		<table class="formtable" id="popCultureTable">
			 <colgroup>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	            <col style="width: 20%"/>
	            <col style="width: 30%"/>
	        </colgroup>
			<tr>
				<th>日期</th>
				<td>
					<tag:dateInput name="cultureDt" onlypast="true" id="cultureDt"  pattern="yyyy/MM/dd" date="${idmListLe.cultureDt}"/>
                   </td>
				<th>血</th>
				<td>
					<input type="text" name="blood" id="blood" value="${idmListLe.blood}" reg='{"maxlength":"20"}'/>
                 </td>
			</tr>
			<tr>
				<th>粪</th>
				<td>
					<input type="text" name="dung" id=dung value="${idmListLe.dung}" reg='{"maxlength":"100"}'/>
                </td>
				<th>尿</th>
				<td>
					<input type="text" name="urine" id="urine" value="${idmListLe.urine}" reg='{"maxlength":"100"}'/>
                </td>
			</tr>
			<tr>
				<th>其它</th>
				<td colspan="3">
					<input type="text" name="other" id="other" value="${idmListLe.other}" reg='{"maxlength":"100"}'/>
                 </td>
			</tr>
		</table>
	</div>
</form>
<div class="toolbarpop">
    <c:if test="${type == 'add'}">
        <input type="button" id="saveContact" value="添加" onclick="typhiaCase.addCultureList()">
    </c:if>
    <c:if test="${type == 'edit'}">
        <input type="button" id="editContact" value="修改" onclick="typhiaCase.editCultureList()">
    </c:if>
    <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('cultureDialog')">
</div>
</div>
