<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form id="addContact" method="get">
		<div>
			<table class="formtable" id="popEfcTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%"><label class="required">姓名</label></th>
					<td style="width: 35%">
                        <input type="text" name="name" value="${idmListEfc.name}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%"><label class="required">性别</label></th>
					<td><ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2" value="${idmListEfc.sex}" reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEfc.age}" reg='{"maxlength":"20"}'></td>
					<th><label class="required">关系</label></th>
					<td><input type="text" name="relation" value="${idmListEfc.relation}" reg='{"required":"true","maxlength":"50"}'></td>
				</tr>
				<tr>
					<th>单位或住址</th>
					<td><input type="text" name="unitAddr" value="${idmListEfc.unitAddr}" reg='{"maxlength":"100"}'></td>
					<th>是否发病</th>
					<td>
                        <ehr:dic-radio dicmeta="PH00001" name="attack" code="1,2" value="${idmListEfc.attack}"/>
					</td>
				</tr>
				<tr>
					<th>发病日期</th>
					<td><tag:dateInput name="attackDt" onlypast="true" date="${idmListEfc.attackDt}"/></td>
					<th>实验室检查</th>
					<td><input type="text" name="labExamination" value="${idmListEfc.labExamination}" reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="havCase.addEfcList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="havCase.editEfcList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('efcDialog')">
    </div>
</div>