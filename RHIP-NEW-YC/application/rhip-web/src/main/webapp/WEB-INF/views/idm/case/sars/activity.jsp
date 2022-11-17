<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
	<form id="activityForm" method="get">
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
						<tag:dateInput id="activityDt" name="treatmentDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListEs.activityDt}' style="100px;"/>					
					</td>
					<th>活动内容</th>
					<td>
						<input type="text" id="activityContent" name="activityContent" reg='{"maxlength":"100"}' 
							value ='${idmListEs.activityContent}' style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>活动地点</th>
					<td>
						<input type="text" id="activityAddr" name="activityAddr" reg='{"maxlength":"100"}' 
							value ='${idmListEs.activityAddr}' style="width:98%"/>						
					</td>
					<th title="接触人员(有无接触发热等可疑病人)">接触人员</th>
					<td>
						<input type="text" id="contactName" name="contactName" reg='{"maxlength":"100"}' 
							value ='${idmListEs.contactName}' style="width:98%"/>						
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveEsActivity" name="saveEsActivity" value="添加" onclick="sarsCase.save(1)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEsActivity" name="modifyEsActivity" value="修改" onclick="sarsCase.modify(1)">
	    </c:if>	
		<input type="button" id="cancelAc" name="cancelEs" value="取消" onclick="caseEdit.closePopUp('activityDialog')">
	</div>
</div>