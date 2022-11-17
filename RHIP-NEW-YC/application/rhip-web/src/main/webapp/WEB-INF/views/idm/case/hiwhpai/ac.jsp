<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addAcForm" method="get">
		<div>
			<table class="formtable" id="popAcTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">就诊单位</th>
					<td style="width: 35%">
                        <input type="text" name="treatmentUnit" value="${idmListAc.treatmentUnit}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%">就诊日期</th>
					<td><tag:dateInput name="treatmentDt" onlypast="true" date="${idmListAc.treatmentDt}"/></td>
				</tr>
				<tr>
					<th>治疗天数</th>
					<td><input type="text" name="treatDays" value="${idmListAc.treatDays}" reg='{"maxlength":"20"}'></td>
					<th>诊断结果</th>
					<td><input type="text" name="diagnosisResult" value="${idmListAc.diagnosisResult}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>是否隔离</th>
					<td><ehr:dic-radio name="quarantine" dicmeta="PH00001" code="1,2" value="${idmListAc.quarantine}"/></td>
					<th>入住院时间</th>
					<td><tag:dateInput name="inhospitalDt" onlypast="true" date="${idmListAc.inhospitalDt}"/></td>
				</tr>
				<tr>
					<th>门诊/住院病历号</th>
					<td><input type="text" name="outpatientNo" value="${idmListAc.outpatientNo}" reg='{"maxlength":"100"}'></td>
					<th>转 归</th>
					<td><ehr:dic-radio name="lapse" dicmeta="CV550102" code="1,2,4" value="${idmListAc.lapse}"/></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveAcData('add')">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveAcData('edit')">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('acDialog')">
    </div>
</div>