<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh5Form" method="get">
		<div>
			<table class="formtable" id="popEh5Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 20%">病例姓名</th>
					<td style="width: 25%">
                        <input type="text" name="name" value="${idmListEh.name}" reg='{"required":"true","maxlength":"200"}'>
                    </td>
					<th style="width: 22%">性别</th>
					<td>
                        <ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2" value="${idmListEh.sex}"/>
                    </td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEh.age}" reg='{"maxlength":"20"}'></td>
					<th>临床表现</th>
					<td><input type="text" name="clinicalManifestation" value="${idmListEh.clinicalManifestation}" reg='{"maxlength":"100"}'></td>
				</tr>
				<tr>
					<th>发病/死亡时间</th>
					<td>
                        <tag:dateInput name="saveDieDt" date="${idmListEh.saveDieDt}" onlypast="true"/>
                    </td>
                    <th>有无接触及时间</th>
                    <td>
                        <input type="text" name="contact" value="${idmListEh.contact}" reg='{"maxlength":"20"}'>
                    </td>
				</tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <input type="text" name="comments" value="${idmListEh.comments}" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEhData('add',5)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEhData('edit',5)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('ehDialog')">
    </div>
</div>