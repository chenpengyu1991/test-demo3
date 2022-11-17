<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addHc2Form" method="get">
		<div>
			<table class="formtable" id="popHc2Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">采样种类</th>
					<td style="width: 35%">
                        <input type="text" name="sampleType" value="${idmListHc.sampleType}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%">采样时间</th>
					<td>
                        <tag:dateInput name="sampleDt" onlypast="true" date="${idmListHc.sampleDt}"/>
                    </td>
				</tr>
				<tr>
					<th>采样地点</th>
					<td><input type="text" name="sampleAddr" value="${idmListHc.sampleAddr}" reg='{"maxlength":"100"}'></td>
					<th>采样份数</th>
					<td><input type="text" name="sampleNum" value="${idmListHc.sampleNum}" reg='{"maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>检测结果</th>
					<td>
                        <input type="text" name="detectionResult" value="${idmListHc.detectionResult}" reg='{"maxlength":"100"}'>
                    </td>
					<th>检测单位</th>
					<td><input type="text" name="detectionUnit" value="${idmListHc.detectionUnit}" reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveHcData('add',2)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveHcData('edit',2)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('hcDialog')">
    </div>
</div>