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
					<th style="width: 15%">日期</th>
					<td style="width: 35%"><tag:dateInput name="leDt" id="leDt" date="${idmListLe.leDt}"
                                                  reg='{"required":"true"}'  onlypast="true" style="width: 30%"/></td>
					<th style="width: 15%">采集标本</th>
					<td>
						<ehr:dic-list name="sampleId" dicmeta="IDM00167" value="${idmListLe.sampleId}"></ehr:dic-list>
					</td>
				</tr>
				<tr>
					<th>检查项目</th>
					<td><input type="text" name="other" id="other" value="${idmListLe.other}" reg='{"required":"true","maxlength":"50"}'></td>
					<th>方法</th>
					<td><input type="text" name="method" id="method" value="${idmListLe.method}"
                               reg='{"required":"true","maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>检验结果</th>
					<td colspan="3"><input type="text" name="checkResult" id="checkResult" value="${idmListLe.checkResult}"
                               reg='{"required":"true","maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="plagueCase.addLeList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="plagueCase.editLeList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="plagueCase.closePopUp('leDialog')">
    </div>
</div>