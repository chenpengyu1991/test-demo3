<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh7Form" method="get">
		<div>
			<table class="formtable" id="popEh7Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 20%">旅行起始地</th>
					<td style="width: 25%">
                        <input type="text" name="travelBegin" value="${idmListEh.travelBegin}" reg='{"required":"true","maxlength":"200"}'>
                    </td>
					<th style="width: 22%">旅行时间</th>
					<td>
                        <tag:dateInput name="travelDt" date="${idmListEh.travelDt}" onlypast="true"/>
                    </td>
				</tr>
				<tr>
					<th>旅行目的地</th>
					<td><input type="text" name="travelAddr" value="${idmListEh.travelAddr}" reg='{"maxlength":"100"}'></td>
					<th>发病地点以外所到地区情况</th>
					<td><input type="text" name="condition" value="${idmListEh.condition}" reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',7)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',7)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>