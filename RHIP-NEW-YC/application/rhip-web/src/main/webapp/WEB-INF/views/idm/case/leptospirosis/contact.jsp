<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addContact" method="get">
		<div>
			<table class="formtable" id="popLeTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">检查项目</th>
					<td style="width: 35%"><ehr:dic-list name="checkItem" dicmeta="IDM00151" value="${idmListLe.checkItem }" uninclude="99" id="checkItem"></ehr:dic-list></td>
					<th style="width: 15%">首次采样时间</th>
					<td>
						<tag:dateInput name="sampleDyFirst" date="${idmListLe.sampleDyFirst }" id="sampleDyFirst" reg='{"compare":["sampleDySecond","le","首次采样时间不能晚于第二次采样时间"]}'></tag:dateInput>
					</td>
				</tr>
				<tr>
					<th>首次检查结果</th>
					<td><input type="text" name="sampleResultFirst" id="sampleResultFirst" value="${idmListLe.sampleResultFirst}" reg='{"maxlength":"100"}'></td>
					<th>第二次采样时间</th>
					<td>
						<tag:dateInput name="sampleDySecond" date="${idmListLe.sampleDySecond }" id="sampleDySecond" reg='{"compare":["sampleDyFirst","ge","第二次采样时间不能早于首次采样时间"]}'></tag:dateInput>
					</td>
				</tr>
				<tr>
					<th>第二次检查结果</th>
					<td colspan="3"><input type="text" name="sampleResultSecond" id="sampleResultSecond" value="${idmListLe.sampleResultSecond}" reg='{"maxlength":"50"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="letopspirosisCase.addLeList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="letopspirosisCase.editLeList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="letopspirosisCase.closePopUp('leDialog')">
    </div>
</div>