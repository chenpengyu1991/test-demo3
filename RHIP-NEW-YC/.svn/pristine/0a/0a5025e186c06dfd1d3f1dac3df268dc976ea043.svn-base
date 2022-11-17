<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<div>
	<form id="addHc3Form" method="get">
		<div>
			<table class="formtable" id="popHc3Table">
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
					<th>饲养时间</th>
					<td><tag:dateInput name="animalDt" onlypast="true" date="${idmListHc.animalDt}"/></td>

				</tr>
                <tr>
                    <th>活动范围</th>
                    <td colspan="3">
                        <ehr:dic-checkbox name="activityRange" dicmeta="IDM00140" value="${idmListHc.activityRange}"/>
                    </td>
                </tr>
				<tr>
					<th>动物粪便可见范围</th>
					<td colspan="3">
                        <ehr:dic-checkbox name="dungRange" dicmeta="IDM00141" value="${idmListHc.dungRange}"/>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveHcData('add',3)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveHcData('edit',3)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('hcDialog')">
    </div>
</div>