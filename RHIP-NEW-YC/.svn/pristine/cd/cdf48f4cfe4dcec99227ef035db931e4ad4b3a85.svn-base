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
                        <input type="text" name="name" value="${idmListEfc.name}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
					<th style="width: 15%">性别</th>
					<td>
                        <ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2" value="${idmListEfc.sex}"/>
                    </td>
				</tr>
				<tr>
					<th>与患者关系</th>
					<td><input type="text" name="relation" value="${idmListEfc.relation}" reg='{"maxlength":"20"}'></td>
					<th>联系电话</th>
					<td><input type="text" name="tel" value="${idmListEfc.tel}" reg='{"regex":"phone","maxlength":"20"}'></td>
				</tr>
                <tr>
                    <td></td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveEfcData('add')">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveEfcData('edit')">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('efcDialog')">
    </div>
</div>