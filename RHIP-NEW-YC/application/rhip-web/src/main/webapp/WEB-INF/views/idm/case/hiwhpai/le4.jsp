<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addLe4Form" method="get">
		<div>
			<table class="formtable" id="popLe4Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">标本类型</th>
					<td style="width: 35%">
                        <input type="text" name="sampleType" value="${idmListLe.sampleType}" reg='{"required":"true","maxlength":"200"}'>
                    </td>
					<th style="width: 15%">采集时间</th>
					<td>
                        <tag:dateInput id="collectDt" name="collectDt" onlypast="true" date="${idmListLe.collectDt}" reg='{"compare":["checkFt","le","采集时间不能晚于检测时间"]}'/>
                    </td>
				</tr>
				<tr>
					<th>检测方法</th>
					<td><input type="text" name="method" value="${idmListLe.method}" reg='{"maxlength":"100"}'></td>
					<th>检测结果</th>
					<td><input type="text" name="checkResult" value="${idmListLe.checkResult}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>检测单位</th>
					<td>
                        <input type="text" name="detectionUnit" value="${idmListLe.detectionUnit}" reg='{"maxlength":"100"}'>
                    </td>
                    <th>检测时间</th>
                    <td>
                        <tag:dateInput id="checkFt" name="checkFt" onlypast="true" date="${idmListLe.checkFt}" reg='{"compare":["collectDt","ge","检测时间不能早于采集时间"]}'/>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveLeData('add',4)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveLeData('edit',4)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('leDialog')">
    </div>
</div>