<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEfcForm" method="get">
		<div>
			<table class="formtable" id="popEfcTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">姓名</th>
					<td style="width: 35%">
                        <input type="text" name="name" value="${idmListEfc.name}"
                               reg='{"required":"true","maxlength":"50"}'>
					</td>
					<th style="width: 15%">性别</th>
					<td>
                        <ehr:dic-radio name="sex" dicmeta="GBT226112003"  code="1,2" value="${idmListEfc.sex}"/>
					</td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEfc.age}" reg='{"digits":"true","max":"200"}'></td>
					<th>职业</th>
					<td><input type="text" name="profession" value="${idmListEfc.profession}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>住址</th>
					<td>
                        <input type="text" name="unitAddr" value="${idmListEfc.unitAddr}" reg='{"maxlength":"100"}'>
					</td>
                    <th>接触情况</th>
                    <td>
                        <ehr:dic-radio name="contactType" dicmeta="IDM00057" code="1,4,2" value="${idmListEfc.contactType}"/>
                    </td>
				</tr>
                <tr>
                    <th>疫苗接种史</th>
                    <td colspan="3">
                        <input type="text" name="vaccineHistory" value="${idmListEfc.vaccineHistory}"
                               style="width: 350px;" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
				<tr>
					<th>备注</th>
					<td colspan="3">
                        <input type="text" name="comments" value="${idmListEfc.comments}" reg='{"maxlength":"20"}'
                               style="width: 350px;">
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="meningitisCase.addEfcList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="meningitisCase.editEfcList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('efcDialog')">
    </div>
</div>