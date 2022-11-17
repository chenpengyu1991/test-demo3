<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form id="addContacted" method="get">
		<input type="hidden" id="rowIndex" value="${rowIndex}"/>
		<div>
			<table class="formtable" id="popEfcTable">
				<colgroup>
		            <col style="min-width: 185px; width: 20%"/>
		            <col style="min-width: 175px; width: 30%"/>
		            <col style="min-width: 125px; width: 20%"/>
		            <col style="min-width: 235px; width: 30%"/>
		        </colgroup>
				<tr>
					<th>姓名</th>
					<td><input type="text" name="name" value="${idmListEfc.name}"
                                                  reg='{"required":"true","maxlength":"50"}'></td>
					<th>性别</th>
					<td><ehr:dic-radio name="sex" dicmeta="GBT226112003"  code="1,2" value="${idmListEfc.sex}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEfc.age}" reg='{"maxlength":"20"}'>
                    </td>
					<th>住址</th>
					<td><input type="text" name="unitAddr" value="${idmListEfc.unitAddr}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>预防接种日期</th>
					<td><tag:dateInput name="vaccineDt" onlypast="true" date="${idmListEfc.vaccineDt}"/></td>
					<th>灭虱日期</th>
					<td><tag:dateInput name="delousingDt" onlypast="true" date="${idmListEfc.delousingDt}"/></td>
				</tr>
				<tr>
					<th>接触方式</th>
					<td colspan="3"><input type="text" name="contactType" value="${idmListEfc.contactType}" reg='{"maxlength":"100"}'></td>
				</tr>
                <tr>
                    <td colspan="4" style="text-align: center;">
                        <c:if test="${type == 'add'}">
                            <input type="button" id="saveContactPerson" value="添加" onclick="typhusCase.addEfcList()">
                        </c:if>
                        <c:if test="${type == 'edit'}">
                            <input type="button" id="editContactPerson" value="修改" onclick="typhusCase.editEfcList()">
                        </c:if>
                        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('efcDialog')">
                    </td>
                </tr>
			</table>
		</div>
	</form>
</div>