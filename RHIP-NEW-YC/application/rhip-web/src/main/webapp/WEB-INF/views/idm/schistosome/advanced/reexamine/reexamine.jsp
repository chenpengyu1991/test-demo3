<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/reexamineEdit.js" type="text/javascript"></script>

<form id="reexamineForm">
<input type="hidden" name="singleId" id="singleId" value="${schDto.singleId}">
<input type="hidden" name="idmId" value="${schDto.idmId}">
<input type="hidden" name="specialStatus" id="specialStatusId" value="${schDto.specialStatus}">
<input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
<input type="hidden" name="otherCondition.id" value="${schDto.otherCondition.id}">
<input type="hidden" name="caseInformation.id" value="${schDto.caseInformation.id}">

<input type="hidden" name="caseInformation.respondents" value="${schDto.caseInformation.respondents}">
<input type="hidden" name="caseInformation.surveyDate" value="<fmt:formatDate value="${schDto.caseInformation.surveyDate}" pattern="yyyy/MM/dd"/>">
<div class="postcontent">
<i class="popno">晚期血吸虫病人复查登记表</i>
<fieldset class="layui-elem-field">
	<legend>基本信息</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
           <col style="min-width: 110px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
      		</colgroup>
      		<tbody>
       		<tr>
	        	<th>姓名:</th>
           		<td>
           			<input type="text" id="name" name="generalCondition.name" value="${schDto.generalCondition.name}" 
           				style="width: 100px;" reg='{"maxlength":"50"}'/>
           		</td>
                <th>性别:</th>
                <td>
                	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  code="1,2"/>
           		</td>           		
			</tr>
			<tr>                    
	          	<th>年龄:</th>
           		<td>
		           	<input type="text" id="age" name="generalCondition.age" value="${schDto.generalCondition.age}" 
		           		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>
                </td>
                <th>职业:</th>
                <td>
	               	<ehr:dic-list name="generalCondition.occupation" dicmeta="GBT6565"  value="${schDto.generalCondition.occupation}"
								  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209
	               		,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120218,CV020120219"  width="200px"/>
                </td>                
			</tr>
			<tr>
		       	<th><label class="required">常住类型:</label></th>
		       	<td colspan="3">
		 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
		           		value="${schDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
		       	</td>
       		</tr>			
       		<tr>
            	<th class="required">现住址：</th>
	            <td colspan="3">
		        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
		            	villageValue="${schDto.generalCondition.pastreet}" townValue="${schDto.generalCondition.patownShip}" width="160px;" reg='{"required":"true"}'/>
                    <div>
	                    <label id="tempPaValue">
	                        <ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                    </label>
	                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}"
			                	reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
			         	<span id="spanPaNumber">(门牌号)</span>
		         	</div>
		        </td>
	     	</tr> 
       		<tr>
				<th><label class="required">晚血分型:</label></th>
				<td colspan="3">
					<span>&nbsp;&nbsp;复查前&nbsp;&nbsp;</span>
	           		<ehr:dic-list name="otherCondition.classifyAccording" dicmeta="CV0501025" 
                   		code="1,2,3,4" value="${schDto.otherCondition.classifyAccording}" />
                   	<span>&nbsp;&nbsp;复查后&nbsp;&nbsp;</span>
					<ehr:dic-list name="otherCondition.classifyAccordingLast" dicmeta="CV0501025" 
                   		code="1,2,3,4" value="${schDto.otherCondition.classifyAccordingLast}" reg='{"required":"true"}' />
                </td> 
       		</tr>
       		<tr>
				<th><label class="required">病情分类:</label></th>
				<td colspan="3">
					<span>&nbsp;&nbsp;复查前&nbsp;&nbsp;</span>
	           		<ehr:dic-list name="otherCondition.caseType" dicmeta="IDM00328" 
                   		code="1,2,3,4" value="${schDto.otherCondition.caseType}" />
                   	<span>&nbsp;&nbsp;复查后&nbsp;&nbsp;</span>
	           		<ehr:dic-list name="otherCondition.caseTypeLast" dicmeta="IDM00328" 
                   		code="1,2,3,4" value="${schDto.otherCondition.caseTypeLast}" reg='{"required":"true"}' />
                </td> 	
       		</tr>
       		<tr>
				<th>救助情况:</th>
				<td colspan="3"> 
		        	<input type="text" name="otherCondition.salvationCondition" value="${schDto.otherCondition.salvationCondition}"
		                	reg='{"maxlength":"100"}'  style="width: 98%;">				
				</td>     			
       		</tr>
       		<tr>
				<th>备注:</th>
				<td colspan="3"> 
		 			<textarea name="otherCondition.comments" style="width: 98%" rows=8  reg='{"maxlength":"1000"}'>${schDto.otherCondition.comments}</textarea>
				</td>     			
       		</tr>       			       			     	
       </tbody>
  </table>
  </fieldset>
</div>
</form>
