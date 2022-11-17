<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh1Form" method="get">
		<div>
			<table class="formtable" id="popEh1Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">养殖场名称</th>
					<td style="width: 35%">
                        <input type="text" name="farmName" value="${idmListEh.farmName}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%">动物种类</th>
					<td>
                        <input type="text" name="animalType" value="${idmListEh.animalType}" reg='{"required":"true","maxlength":"50"}'>
                        <%--<tag:dateInput name="treatmentDt" onlypast="true" date="${idmListEh.treatmentDt}"/>--%>
                    </td>
				</tr>
				<tr>
					<th>饲养数量</th>
					<td><input type="text" name="animalNum" value="${idmListEh.animalNum}" reg='{"maxlength":"20"}'></td>
					<th>病/死数量</th>
					<td><input type="text" name="dieNum" value="${idmListEh.dieNum}" reg='{"maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>病/死时间</th>
					<td>
                        <tag:dateInput id="dieDt" name="dieDt" onlypast="true" date="${idmListEh.dieDt}" reg='{"compare":["processDt","le","病死时间不能晚于处理时间"]}'/>
                    </td>
					<th>处理方式</th>
					<td><input type="text" name="processMode" value="${idmListEh.processMode}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>处理时间</th>
					<td><tag:dateInput id="processDt" name="processDt" onlypast="true" date="${idmListEh.processDt}" reg='{"compare":["dieDt","ge","处理时间不能早于病死时间"]}'/></td>
					<th>参与处理人员数量</th>
					<td><input type="text" name="processNum" value="${idmListEh.processNum}" reg='{"maxlength":"20"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',1)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',1)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>