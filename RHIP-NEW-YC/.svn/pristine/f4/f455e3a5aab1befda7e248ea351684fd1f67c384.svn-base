<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form id="addContacted" method="get">
		<div>
			<table class="formtable" id="popEfcTable">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 15%"><label class="required">密接姓名</label></th>
					<td style="width: 35%"><input type="text" name="name" value="${idmListEfc.name}"
                                                  reg='{"required":"true","maxlength":"50"}'></td>
					<th style="width: 15%"><label class="required">性别</label></th>
					<td><ehr:dic-radio name="sex" dicmeta="GBT226112003"  code="1,2" value="${idmListEfc.sex}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEfc.age}" reg='{"maxlength":"20"}'></td>
					<th><label class="required">与患者关系</label></th>
					<td><input type="text" name="relation" value="${idmListEfc.relation}"
                               reg='{"required":"true","maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>是否发病</th>
					<td><ehr:dic-radio  dicmeta="PH00001" name="attack" code="1,2" value="${idmListEfc.attack}"/></td>
					<th>发病时间</th>
					<td><tag:dateInput name="attackDt" onlypast="true" date="${idmListEfc.attackDt}"/></td>
				</tr>
				<tr>
					<th>接触时间（起止）</th>
					<td>
                        <tag:dateInput id="contactBeginDtId" name="contactBeginDt" onlypast="true" style="width: 30%" date="${idmListEfc.contactBeginDt}" reg='{"compare":["contactEndDtId","le","开始时间不能晚于结束时间"]}'/>--
                        <tag:dateInput id="contactEndDtId" name="contactEndDt" onlypast="true" style="width: 30%" date="${idmListEfc.contactEndDt}" reg='{"compare":["contactBeginDtId","ge","结束时间不能早于开始时间"]}'/>
					</td>
					<th>住院是否</th>
					<td><ehr:dic-radio  dicmeta="PH00001" name="inhospital" code="1,2" value="${idmListEfc.inhospital}"/></td>
				</tr>
				<tr>
					<th>临床诊断</th>
					<td colspan="3"><input type="text" name="clinicalDiagnosis" value="${idmListEfc.clinicalDiagnosis}"
                                           reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContactPerson" value="添加" onclick="hfmdCase.addEfcList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContactPerson" value="修改" onclick="hfmdCase.editEfcList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('efcDialog')">
    </div>
</div>