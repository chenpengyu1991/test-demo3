<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="contactForm" method="get">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
			<table class="formtable">
				<colgroup style="width:50%">
					<col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>		
				<colgroup style="width:50%">
					<col style="width:15%;"/>
					<col style="width:35%;"/>
				</colgroup>	
				<tr>
					<th>患者姓名</th>
					<td>
						<input type="text" id="name" name="name" reg='{"maxlength":"100"}' 
							value ='${idmListEsContact.name}' style="width:150px"/>						
					</td>
					<th>与患者关系</th>
					<td>
		        		<ehr:dic-list  id="relation" name="relation" dicmeta="IDM00112" value="${idmListEsContact.relation}"
							code="1,2,3,4,99"  width="150px;"/>
					</td>					
				</tr>

				<tr>
					<th>发病时间</th>
					<td>
						<tag:dateInput id="attackDt" name="attackDt" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListEsContact.attackDt}' style="80px;"/>	
					</td>				
					<th>最后接触时间</th>
					<td>
						<tag:dateInput id="condactDtLast" name="condactDtLast" onlypast="true" pattern="yyyy/MM/dd"  
							date='${idmListEsContact.condactDtLast}' style="80px;"/>						
					</td>
				</tr>
				<tr>
					<th>接触方式</th>
					<td>
						<ehr:dic-list id="contactType" name="contactType" dicmeta="IDM00113" value="${idmListEsContact.contactType}"
							code="1,2,3,4,5,6,7,99" width="150px;"/>
					</td>				
					<th>接触频率</th>
					<td>
						<ehr:dic-list id="contactRate" name="contactRate" dicmeta="IDM00035" value="${idmListEsContact.contactRate}"
							code="1,3,4" width="150px;"/>
					</td>
				</tr>
				<tr>					
					<th>接触地点</th>
					<td colspan="3">
						<ehr:dic-list id="contactAddr" name="contactAddr" dicmeta="IDM00114" value="${idmListEsContact.contactAddr}"
							code="1,2,3,4,5,6,99" width="150px;"/>
					</td>
				</tr>
				<tr>
					<th>临床诊断</th>
					<td colspan="3">
						<input type="text" id="clinicalDiagnosis" name="clinicalDiagnosis" reg='{"maxlength":"100"}'
							value ='${idmListEsContact.clinicalDiagnosis}' style="width:98%"/>					
					</td>
				</tr>				
			</table>
		</div>
	</form>
    <div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveEsContact" name="saveEsContact" value="添加" onclick="sarsCase.save(5)">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyEsContact" name="modifyEsContact" value="修改" onclick="sarsCase.modify(5)">
	    </c:if>	
		<input type="button" id="cancelEsContact" name="cancelEsContact" value="取消" onclick="caseEdit.closePopUp('contactDialog')">
	</div>
</div>