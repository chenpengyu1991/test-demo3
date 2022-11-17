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
					<th style="width: 15%"><label class="required">密接姓名</label></th>
					<td style="width: 35%"><input type="text" name="name" value="${idmListEs.name}"
                                                  reg='{"required":"true","maxlength":"50"}'></td>
					<th style="width: 15%"><label class="required">性别</label></th>
					<td><ehr:dic-radio name="sex" dicmeta="GBT226112003"  code="1,2" value="${idmListEs.sex}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" name="age" value="${idmListEs.age}" reg='{"maxlength":"20"}'></td>
					<th><label class="required">与患者关系</label></th>
					<td><input type="text" name="relation" value="${idmListEs.relation}"
                               reg='{"required":"true","maxlength":"20"}'></td>
				</tr>
				<tr>
					<th>发病情况</th>
					<td colspan="3"><input type="text" name="attackCondition" value="${idmListEs.attackCondition}"
                                           reg='{"maxlength":"100"}'></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContactPerson" value="添加" onclick="mumpsCase.addEsList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContactPerson" value="修改" onclick="mumpsCase.editEsList()">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('esDialog')">
    </div>
</div>