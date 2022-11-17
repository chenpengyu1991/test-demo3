<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh4Form" method="get">
		<div>
			<table class="formtable" id="popEh4Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 20%">分离(PCR)阳性标本类型</th>
					<td style="width: 25%">
                        <input type="text" name="pcr" value="${idmListEh.pcr}" reg='{"required":"true","maxlength":"200"}'>
                    </td>
					<th style="width: 22%">采集地点</th>
					<td>
                        <input type="text" name="sampleAddr" value="${idmListEh.sampleAddr}" reg='{"maxlength":"200"}'>
                        <%--<tag:dateInput name="treatmentDt" onlypast="true" date="${idmListEh.treatmentDt}"/>--%>
                    </td>
				</tr>
				<tr>
					<th>采集时间</th>
					<td><tag:dateInput id="sampleDt" name="sampleDt" onlypast="true" date="${idmListEh.sampleDt}" reg='{"compare":["separateDt","le","采集时间不能晚于分离时间"]}'/></td>
					<th>分离时间</th>
					<td><tag:dateInput id="separateDt" name="separateDt" onlypast="true" date="${idmListEh.separateDt}" reg='{"compare":["sampleDt","ge","分离时间不能早于采集时间"]}'/></td>
				</tr>
				<tr>
					<th>分离单位</th>
					<td>
                        <input type="text" name="separateUnit" value="${idmListEh.separateUnit}" reg='{"maxlength":"50"}'>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <td colspan="4" style="text-align: center;">
            <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',4)">
            </c:if>
            <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',4)">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>