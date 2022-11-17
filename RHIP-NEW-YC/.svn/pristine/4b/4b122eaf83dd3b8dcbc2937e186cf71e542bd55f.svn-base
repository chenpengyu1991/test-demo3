<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<div>
	<form id="labExamine">
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
					<th><label class="required">项目</label></th>
					<td><input type="text" id="otherId" name="other" reg='{"required":"true","maxlength":"200"}' value ='${idmListle.other}'/></td>
					<th>送检日期</th>
					<td>
						<tag:dateInput nullToToday="true" id="checkFtId" name="checkFt" pattern="yyyy/MM/dd" 
							date="${idmListle.checkFt}" onlypast="true" style="width: 100px"></tag:dateInput>
					
					</td>
				</tr>
				<tr>
					<th>结果</th>
					<td><input type="text" id="checkResultId" name="checkResult" reg='{"maxlength":"100"}' value ='${idmListle.checkResult}' style="width:98%"/></td>
				</tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveLabExamine" name="saveLabExamine" value="添加" onclick="scarlatinaCase.saveLabExamine()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyLabExamine" name="modifyLabExamine" value="修改" onclick="scarlatinaCase.modifyLabExamine()">
	    </c:if>	
		<input type="button" id="cancelLabExamine" name="cancelLabExamine" value="取消" onclick="scarlatinaCase.closePopUp('labExaDialog')">
	</p>
</div>
