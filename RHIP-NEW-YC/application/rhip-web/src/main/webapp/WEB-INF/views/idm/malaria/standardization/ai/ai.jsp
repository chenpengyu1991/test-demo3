<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addAiForm" method="get">
		<div>
			<table class="formtable" id="popAiTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
                    <input type="hidden" name="id" value="${listAi.id}"/>
					<th style="width: 18%"><label class="required">姓名：</label></th>
					<td style="width: 32%">
                        <input type="text" name="name" onlypast="true" reg='{"required":"true","maxlength":"50"}' value="${listAi.name}">
					</td>
                    <th style="width: 18%">户主：</th>
                    <td>
                        <input type="text" name="headHouseholdName" value="${listAi.headHouseholdName}" reg='{"maxlength":"50"}'>
                    </td>
				</tr>
				<tr>
					<th><label class="required">性别：</label></th>
					<td><ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="${listAi.gender}" reg='{"required":"true"}'/></td>
					<th><label class="required">年龄：</label></th>
					<td><input type="text" name="age" value="${listAi.age}" reg='{"required":"true", "maxlength":"20"}'></td>
				</tr>
				<tr>
					<th><label class="required">走访结果：</label></th>
					<td>
                        <ehr:dic-list id="visitResult" name="visitResult" dicmeta="IDM00273" value="${listAi.visitResult}" reg='{"required":"true"}'/>
                    </td>
                    <th><label class="required">血检方式：</label></th>
                    <td>
                        <ehr:dic-radio name="checkType" dicmeta="IDM00274" value="${listAi.checkType}" reg='{"required":"true"}'/>
                    </td>
				</tr>
                <tr>
                    <th><label class="required">血检结果：</label></th>
                    <td>
                        <ehr:dic-radio name="checkResult" dicmeta="CV0450015" code="03,01" value="${listAi.checkResult}" reg='{"required":"true"}'/>
                    </td>
                    <th><label class="required">诊断结果：</label></th>
                    <td><input type="text" name="diagnosisResult" value="${listAi.diagnosisResult}" reg='{"required":"true", "maxlength":"100"}'></td>
                </tr>
                <tr>
                    <th>备注：</th>
                    <td colspan="3">
                        <input type="text" name="comments" value="${listAi.comments}" reg='{"maxlength":"400"}' style="width: 500px;">
                        <input type="hidden" name="checkTownShip" value="${listAi.checkTownShip}">
                        <input type="hidden" name="checkStreet" value="${listAi.checkStreet}">
                        <input type="hidden" name="checkHouseNumber" value="${listAi.checkHouseNumber}">
                        <input type="hidden" name="checkUser" value="${listAi.checkUser}">
                        <tag:dateInput id="reportDt" name="reportDt" pattern="yyyy/MM/dd" onlypast="true" date="${listAi.reportDt}" style="display:none"/>
                    </td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="ai.saveAiData()">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="ai.saveAiData('edit')">
            </c:if>
            <c:if test="${type == 'update'}">
                <input type="button" id="editContact" value="修改" onclick="ai.updateAi()">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('aiDialog')">
    </div>
</div>