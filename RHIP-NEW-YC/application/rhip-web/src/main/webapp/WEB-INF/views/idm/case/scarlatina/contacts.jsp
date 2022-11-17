<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<div>
	<form id="contact">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup>
					<col style="width:80px;"/>
					<col style="width:200px;"/>
		            <col style="width:80px;"/>
					<col style="width:200px;"/>
				</colgroup>		
				<tr>
					<th><label class="required">姓名</label></th>
					<td><input type="text" id="nameId" name="name" reg='{"required":"true","maxlength":"50"}' value ='${idmListEfc.name}'/></td>
					<th><label class="required">性别</label></th>
					<td><ehr:dic-list id="sexId" name="sex" dicmeta="GBT226112003" code="1,2" reg='{"required":"true"}' value ='${idmListEfc.sex}' width="150px"/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><input type="text" id="ageId" name="age"  value ='${idmListEfc.age}' reg='{"digits":"true","max":"200"}'style="width:36%"/></td>
					<th>关系</th>
					<td>
						<input type="text" id="relationId" name="relation" reg='{"maxlength":"100"}' value ='${idmListEfc.relation}' style="width:98%"/>
					</td>
				</tr>
				<tr>
					<th>接触方式</th>
					<td>
						<input type="text" id="contactTypeId" name="contactType" reg='{"maxlength":"100"}' value ='${idmListEfc.contactType}' style="width:98%"/>	
					</td>
					<th>发病情况</th>
					<td>
						<input type="text" id="attackConditionId" name="attackCondition" reg='{"maxlength":"100"}' value ='${idmListEfc.attackCondition}' style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>住址</th>
					<td colspan="3"><input type="text" id="unitAddrId" name="unitAddr" reg='{"maxlength":"100"}' value ='${idmListEfc.unitAddr}' style="width:98%"/>	</td>
				</tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveContact" name="saveContact" value="添加" onclick="scarlatinaCase.saveContact()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyContact" name="modifyContact" value="修改" onclick="scarlatinaCase.modifyContact()">
	    </c:if>
		<input type="button" id="cancelContact" name="cancelContact" value="取消" onclick="caseEdit.closePopUp('contactDialog')">
	</div>
</div>
