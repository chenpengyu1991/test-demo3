<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addHc1Form" method="get">
		<div>
			<table class="formtable" id="popHc1Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">动物种类</th>
					<td style="width: 35%">
                        <input type="text" name="animalType" value="${idmListHc.animalType}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%">饲养数量</th>
					<td>
                        <input type="text" name="animalNum" value="${idmListHc.animalNum}" reg='{"maxlength":"20"}'>
                        <%--<tag:dateInput name="treatmentDt" onlypast="true" date="${idmListHc.treatmentDt}"/>--%>
                    </td>
				</tr>
				<tr>
					<th>病死数量</th>
					<td><input type="text" name="dieNum" value="${idmListHc.dieNum}" reg='{"maxlength":"20"}'></td>
					<th>发病/死亡时间</th>
					<td><tag:dateInput name="dieDt" onlypast="true" date="${idmListHc.dieDt}"/></td>
				</tr>
				<tr>
					<th>死亡原因</th>
					<td>
                        <input type="text" name="dieReason" value="${idmListHc.dieReason}" reg='{"maxlength":"100"}'>
                    </td>
					<th>处理方式</th>
					<td><input type="text" name="processMode" value="${idmListHc.processMode}" reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveHcData('add',1)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveHcData('edit',1)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('hcDialog')">
    </div>
</div>