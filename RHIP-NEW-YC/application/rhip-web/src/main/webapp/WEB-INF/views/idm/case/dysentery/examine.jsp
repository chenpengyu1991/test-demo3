<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div>
	<form id="le">
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
					<th><label class="required">日期</label></th>
					<td><tag:dateInput id="leDt" name="leDt" pattern="yyyy/MM/dd" onlypast="true" date='${idmListLe.leDt}' reg='{"required":"true"}' style="width: 36%"/></td>			
					<th>红细胞</th>
					<td><input type="text" id="redBloodCell" name="redBloodCell" value="${idmListLe.redBloodCell}" reg='{"maxlength":"50"}' style="width: 36%"/></td>
				</tr>
				<tr>
					<th>白细胞</th>
					<td><input type="text" id="whiteBloodCell" name="whiteBloodCell"  value="${idmListLe.whiteBloodCell}"  reg='{"maxlength":"50"}' style="width: 150px"/></td>
					<th>志贺</th>
					<td><input type="text" id="shigella" name="shigella" value="${idmListLe.shigella}" reg='{"maxlength":"20"}' style="width: 36%"/></td>
				</tr>
				<tr>
					<th>福氏</th>
					<td><input type="text" id="freund" name="freund" value="${idmListLe.freund}" reg='{"maxlength":"50"}' style="width: 150px"/></td>
					<th>鲍氏</th>
					<td><input type="text" id="powell" name="powell" value="${idmListLe.powell}" reg='{"maxlength":"50"}' style="width: 150px"/></td>
				</tr>
				<tr>
					<th>宋内</th>
					<td><input type="text" id="sonnei" name="sonnei"  value="${idmListLe.sonnei}"  reg='{"maxlength":"50"}' style="width: 150px"/></td>
				</tr>
		</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveLe" name="saveLe" value="添加" onclick="dysenteryCase.saveLe()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyLe" name="modifyLe" value="修改" onclick="dysenteryCase.modifyLe()">
	    </c:if>		
		<input type="button" id="cancelLe" name="cancelLe" value="取消" onclick="caseEdit.closePopUp('leDialog')">
	</div>
</div>
