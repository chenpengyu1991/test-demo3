<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>--%>
<script type="text/javascript">
    $(function() {
        toggleOther('impressType','impressOther',99);
    });
</script>
<div>
	<form id="addFrForm" method="get">
		<div>
			<table class="formtable" id="popFrTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 18%"><label class="required">访视日期：</label></th>
					<td style="width: 32%">
                         <tag:dateInput name="visitDt" onlypast="true" reg='{"required":"true"}' date="${listFr.visitDt}"/>
					</td>
                    <th style="width: 18%"><label class="required">责任人：</label></th>
                    <td>
                        <input type="text" name="checkUser" value="${listFr.checkUser}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
				</tr>
				<tr>
					<th><label class="required">发热天数：</label></th>
					<td><input type="text" name="feverDays" value="${listFr.feverDays}" reg='{"required":"true", "maxlength":"20"}'></td>
					<th><label class="required">热型：</label></th>
					<td><input type="text" name="feverType" value="${listFr.feverType}" reg='{"required":"true", "maxlength":"20"}'></td>
				</tr>
				<tr>
					<th><label class="required">体温℃：</label></th>
					<td><input type="text" name="temperature" value="${listFr.temperature}" reg='{"required":"true", "maxlength":"20"}'></td>
				</tr>
                <tr>
                    <th><label class="required">检查方法：</label></th>
                    <td><input type="text" name="checkType" value="${listFr.checkType}" reg='{"required":"true", "maxlength":"100"}'></td>
                    <th><label class="required">检查结果：</label></th>
                    <td><input type="text" name="checkResult" value="${listFr.checkResult}" reg='{"required":"true", "maxlength":"100"}'></td>
                </tr>
                <tr>
                    <th><label class="required">印象：</label></th>
                    <td colspan="3">
                        <ehr:dic-radio name="impressType" dicmeta="IDM00269" value="${listFr.impressType}" reg='{"required":"true", "maxlength":"20"}'
                                onchange="toggleOther('impressType','impressOther',99);"/>
                        <span id="impressOther" style="display: none"><input type="text" name="impressOther" value="${listFr.impressOther}" reg='{"maxlength":"100"}'></span>
                    </td>
                </tr>
				<tr>
					<th><label class="required">处理意见：</label></th>
					<td colspan="5">
                        <input type="text" name="visitContent" value="${listFr.visitContent}" style="width: 410px;" reg='{"required":"true", "maxlength":"200"}'>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="visit.saveFrData()">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="visit.saveFrData('edit')">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('frDialog')">
    </div>
</div>