<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="leaveForm" method="get">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>		
			<table class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:35%;"/>
		            <col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>			
				<tr>
					<th>日期</th>
					<td>
						<tag:dateInput id="activityDt" name="activityDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListEsLeave.activityDt}' style="100px;"/>						
					</td>
					<th>活动内容</th>
					<td>
						<input type="text" id="activityContent" name="activityContent" reg='{"maxlength":"100"}' 
							value ='${idmListEsLeave.activityContent}' style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>活动地点</th>
					<td>
						<input type="text" id="activityAddr" name="activityAddr" reg='{"maxlength":"100"}' 
							value ='${idmListEsLeave.activityAddr}' style="width:98%"/>						
					</td>
					<th>接触人员</th>
					<td>
						<input type="text" id="contactName" name="contactName" reg='{"maxlength":"100"}' 
							value ='${idmListEsLeave.contactName}' style="width:98%"/>						
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveLeaveAct" name="saveLeaveAct" value="添加" onclick="sarsCase.save(3)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEsLeaveAct" name="modifyEsLeaveAct" value="修改" onclick="sarsCase.modify(3)">
	    </c:if>	
		<input type="button" id="cancelEsLeaveAct" name="cancelEsLeaveAct" value="取消" onclick="caseEdit.closePopUp('leaveDialog')">
	</div>
</div>