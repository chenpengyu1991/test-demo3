<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh2Form" method="get">
		<div>
			<table class="formtable" id="popEh2Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 20%">总户数</th>
					<td style="width: 25%">
                        <input type="text" name="familyNum" value="${idmListEh.familyNum}" reg='{"required":"true","maxlength":"20"}'>
                    </td>
					<th style="width: 22%">总人口数</th>
					<td>
                        <input type="text" name="peopleNum" value="${idmListEh.peopleNum}" reg='{"required":"true","maxlength":"20"}'>
                        <%--<tag:dateInput name="treatmentDt" onlypast="true" date="${idmListEh.treatmentDt}"/>--%>
                    </td>
				</tr>
				<tr>
					<th>常驻人口</th>
					<td><input type="text" name="permanentPopulation" value="${idmListEh.permanentPopulation}" reg='{"maxlength":"20"}'></td>
					<th>饲养家禽户数</th>
					<td><input type="text" name="fowlFamilyNum" value="${idmListEh.fowlFamilyNum}" reg='{"maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>饲养家禽户人口数</th>
					<td>
                        <input type="text" name="fowlPeopleNum" value="${idmListEh.fowlPeopleNum}" reg='{"maxlength":"20"}'>
                    </td>
					<th>病死家禽户数</th>
					<td><input type="text" name="dieFowlNum" value="${idmListEh.dieFowlNum}" reg='{"maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>病死家禽户人口数</th>
					<td>
                        <input type="text" name="dieFowlPeopleNum" value="${idmListEh.dieFowlPeopleNum}" reg='{"maxlength":"20"}'>
                    </td>
					<th>异常表现人数
                        (流感/发热等)
                    </th>
					<td><input type="text" name="exceptionNum" value="${idmListEh.exceptionNum}" reg='{"maxlength":"20"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',2)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',2)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>