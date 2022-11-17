<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="workOrgForm" method="get">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup>
					<col style="width:20%;"/>
					<col style="width:30%;"/>
		            <col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>				
				<tr>
					<th>单位名称</th>
					<td>
						<input type="text" id="workOrgUnitAddr" name="unitAddr" reg='{"maxlength":"100"}' 
							value ='${idmListEfcWorkOrg.unitAddr}' style="width:98%"/>							
					</td>
					<th>主要联系人</th>
					<td>
						<input type="text" id="workOrgLinkman" name="linkman" reg='{"maxlength":"100"}' 
							value ='${idmListEfcWorkOrg.linkman}' style="width:98%"/>						
					</td>
				</tr>
				<tr>										
					<th>地址及联系电话</th>
					<td colspan="3">
						<input type="text" id="workOrgTel" name="tel" reg='{"maxlength":"100"}' 
							value ='${idmListEfcWorkOrg.tel}' style="width:98%"/>						
					</td>
				</tr>
				<tr>
					<th>接触者名单</th>
					<td  colspan="3">
						<input type="text" id="workOrgContactName" name="contactName" reg='{"maxlength":"100"}' 
							value ='${idmListEfcWorkOrg.contactName}' style="width:98%"/>						
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveEfcWorkOrg" name="saveEfcWorkOrg" value="添加" onclick="sarsCase.save(7)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEfcWorkOrg" name="modifyEfcWorkOrg" value="修改" onclick="sarsCase.modify(7)">
	    </c:if>	
		<input type="button" id="cancelEfcWorkOrg" name="cancelEfcWorkOrg" value="取消" onclick="caseEdit.closePopUp('workOrgDialog')">
	</div>
</div>