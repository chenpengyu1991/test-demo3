<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div>
	<form id="addFrForm" method="get">
		<div>
			<table class="formtable" id="popFrTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 18%"><label class="required">随访日期</label></th>
					<td style="width: 32%">
                        <tag:dateInput name="visitDt" date="${listFr.visitDt}" reg='{"required":"true"}'></tag:dateInput>
					</td>
					<th style="width: 18%">体温（℃）</th>
					<td><input type="text" name="temperature" value="${listFr.temperature}"></td>
				</tr>
				<tr>
					<th>皮疹</th>
					<td><ehr:dic-list name="rash" dicmeta="IDM00377" value="${listFr.rash}"/></td>
					<th>其他症状体征</th>
					<td><input type="text" name="otherSymptom" value="${listFr.otherSymptom}" ></td>
				</tr>
				<tr>
					<th>病情进展</th>
					<td><ehr:dic-list name="diseaseProgress" dicmeta="IDM00378" value="${listFr.diseaseProgress}"/></td>
					<th>病情加重后转诊医疗机构</th>
					<td>
                        <input type="text" name="transferUnit" value="${listFr.transferUnit}" reg='{"maxlength":"100"}'>
                    </td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3">
                        <input type="text" name="comments" value="${listFr.comments}"  reg='{"maxlength":"200"}'></td>
				</tr>

			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="frSearch.saveFrData('add')">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="frSearch.saveFrData('edit')">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('frDialog')">
    </div>
</div>