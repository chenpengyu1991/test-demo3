<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>--%>
<div>
	<form id="addEddForm" method="get">
		<div>
			<table class="formtable" id="popEddTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 13%"><label class="required">日期：</label></th>
					<td style="width: 20%">
                         <tag:dateInput name="checkDt" onlypast="true" reg='{"required":"true"}' date="${listEdd.checkDt}"/>
					</td>
                    <th style="width: 13%"><label class="required">监测人：</label></th>
                    <td style="width: 20%">
                        <input type="text" name="checkUser" value="${listEdd.checkUser}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
                    <td style="width: 13%"></td>
                    <td></td>
				</tr>
				<tr>
					<th><label class="required">发热人数：</label></th>
					<td><input type="text" name="feverNum" value="${listEdd.feverNum}" reg='{"required":"true", "maxlength":"20"}'></td>
					<th><label class="required">本地居民：</label></th>
					<td><input type="text" name="feverLocal" value="${listEdd.feverLocal}" reg='{"required":"true", "maxlength":"20"}'></td>
                    <th><label class="required">外来人口：</label></th>
                    <td><input type="text" name="feverForeign" value="${listEdd.feverForeign}" reg='{"required":"true", "maxlength":"20"}'></td>
				</tr>
				<tr>
					<th><label class="required">发虐人数：</label></th>
					<td><input type="text" name="agueNum" value="${listEdd.agueNum}" reg='{"required":"true", "maxlength":"20"}'></td>
					<th><label class="required">本地居民：</label></th>
					<td><input type="text" name="agueLocal" value="${listEdd.agueLocal}" reg='{"required":"true", "maxlength":"20"}'></td>
                    <th><label class="required">外来人口：</label></th>
                    <td><input type="text" name="agueForeign" value="${listEdd.agueForeign}" reg='{"required":"true", "maxlength":"20"}'></td>
				</tr>
                <tr>
                    <th><label class="required">血检人数：</label></th>
                    <td><input type="text" name="bloodNum" value="${listEdd.bloodNum}" reg='{"required":"true", "maxlength":"20"}'></td>
                    <th><label class="required">血检阳性：</label></th>
                    <td><input type="text" name="bloodPositiveNum" value="${listEdd.bloodPositiveNum}" reg='{"required":"true", "maxlength":"20"}'></td>
                </tr>
                <tr>
                    <th><label class="required">IFAT人数：</label></th>
                    <td><input type="text" name="ifatNum" value="${listEdd.ifatNum}" reg='{"required":"true", "maxlength":"20"}'></td>
                    <th><label class="required">IFAT阳性：</label></th>
                    <td><input type="text" name="ifatPositiveNum" value="${listEdd.ifatPositiveNum}" reg='{"required":"true", "maxlength":"20"}'></td>
                    <th><label class="required">IFAT>1:80：</label></th>
                    <td><input type="text" name="ifatProportionNum" value="${listEdd.ifatProportionNum}" reg='{"required":"true", "maxlength":"20"}'></td>
                </tr>
				<tr>
					<th><label class="required">处理情况：</label></th>
					<td colspan="5">
                        <input type="text" name="disposeCondition" value="${listEdd.disposeCondition}" style="width: 410px;" reg='{"required":"true", "maxlength":"200"}'>
                    </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="epidemicFocus.saveEddData()">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="epidemicFocus.saveEddData('edit')">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('eddDialog')">
    </div>
</div>