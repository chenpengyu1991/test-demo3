<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh6Form" method="get">
		<div>
			<table class="formtable" id="popEh6Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 20%">病例姓名</th>
					<td style="width: 25%">
                        <input type="text" name="name" value="${idmListEh.name}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 22%">发病时间</th>
					<td>
                        <tag:dateInput name="attackDt" date="${idmListEh.attackDt}" onlypast="true"/>
                    </td>
				</tr>
				<tr>
					<th>临床表现</th>
					<td><input type="text" name="clinicalManifestation" value="${idmListEh.clinicalManifestation}" reg='{"maxlength":"100"}'></td>
                    <th>诊断</th>
                    <td><input type="text" name="diagnosis" value="${idmListEh.diagnosis}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>最后接触时间</th>
					<td>
                        <tag:dateInput name="contactDtLast" date="${idmListEh.contactDtLast}" onlypast="true"/>
                    </td>
                    <th>接触方式及频率</th>
                    <td>
                        <input type="text" name="contactTypeRate" value="${idmListEh.contactTypeRate}" reg='{"maxlength":"100"}'>
                    </td>
				</tr>
                <tr>
                    <th>接触地点</th>
                    <td colspan="3">
                        <input type="text" name="contactAddr" value="${idmListEh.contactAddr}" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',6)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',6)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>