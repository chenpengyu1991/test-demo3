<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addContact" method="get">
		<div>
			<table class="formtable" id="popEsTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%">病例姓名</th>
					<td style="width: 35%"><input type="text" name="name" value="${idmListEs.name}"
                                                  reg='{"required":"true","maxlength":"50"}'></td>
					<th style="width: 15%">性别</th>
					<td><ehr:dic-radio name="sex" dicmeta="GBT226112003"  code="1,2" value="${idmListEs.sex}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEs.age}" reg='{"maxlength":"20"}'></td>
					<th>与病例关系</th>
					<td><input type="text" name="relation" value="${idmListEs.relation}"
                               reg='{"required":"true","maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>发病时间</th>
					<td><tag:dateInput name="attackDt" onlypast="true" date="${idmListEs.attackDt}"
                                       reg='{"required":"true"}'/></td>
					<th>临床诊断</th>
					<td><input type="text" name="clinicalDiagnosis" value="${idmListEs.clinicalDiagnosis}"
                               reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>接触时间（起止）</th>
					<td><tag:dateInput id="contactBeginDtId" name="contactBeginDt" onlypast="true" style="width: 30%" date="${idmListEs.contactBeginDt}" reg='{"compare":["contactEndDtId","le","开始时间不能晚于结束时间"]}'/>--
                        <tag:dateInput id="contactEndDtId" name="contactEndDt" onlypast="true" style="width: 30%" date="${idmListEs.contactEndDt}" reg='{"compare":["contactBeginDtId","ge","结束时间不能早于开始时间"]}'/>
                    </td>
					<th>住院是否</th>
					<td><ehr:dic-radio  dicmeta="PH00001" name="inhospital" code="1,2" value="${idmListEs.inhospital}"/></td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><input type="text" name="comments" value="${idmListEs.comments}"
                                           reg='{"maxlength":"200"}'></td>
				</tr>

			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="hfmdCase.addEsList()">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="hfmdCase.editEsList()">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('esDialog')">
    </div>
</div>