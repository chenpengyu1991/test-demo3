<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm//statistics/report/selfcheck/fill/editNeonate.js" type="text/javascript"></script>
<div class="toolbar">
	<c:if test="${type !='add'}">
    	<a href="javascript:void(0)" onclick="javascript:selfFillNeonateEdit.returnSearch()"><b class="fanhui">返回</b></a>
   	</c:if>
	<c:if test="${type !='view'}">
   		<a href="javascript:void(0)" onclick="javascript:selfFillNeonateEdit.fillSubmit()"><b class="tijiao">提交</b></a>
   	</c:if>
</div>

<form id="selfFillForm">
	<input type="hidden" id="type" value="${type}"/>
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" id="selfCheckId" name="id" value="${selfCheck.id}"/>

    <input type="hidden"  id="reportUnitCodeId" name="reportUnitCode" value="${selfCheck.reportUnitCode}"/>	
    <input type="hidden"  name="reportUserCode" value="${selfCheck.reportUserCode}"/>
    <input type="hidden"  id="reportMonthSelfFlag" />
    <input type="hidden"  name="modifyUnitCode" value="${selfCheck.modifyUnitCode}"/>
    <input type="hidden"  name="modifyUserCode" value="${selfCheck.modifyUserCode}"/>	
    <input type="hidden"  name="modifyDate" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${selfCheck.modifyDate}"/>"/>  
    
    <input type="hidden"  id="reportMonthOldId" name="reportMonthOldId" value="<fmt:formatDate pattern="yyyy/MM" value="${selfCheck.reportMonth}"/>"/>	  
    <div class="postcontent">
    	<i class="popno">《传染病防治法》执行情况自查</i>
		<table class="posttable">
		    <tr style="text-align: right;">
		        <td>
		        	<label class="required">填报月份：</label>
					<tag:dateInput nullToToday="true" id="reportMonthSelfId" name="reportMonthSelf" onlypast="true" reg='{"required":"true"}'
			        	pattern="yyyy/MM" date="${selfCheck.reportMonth}" style="width:120px"/>
		        </td>
		        <td>
		        	<label class="required">填报日期：</label>
					<tag:dateInput nullToToday="true" id="reportDateId" name="reportDate" onlypast="true" reg='{"required":"true"}'
			        	pattern="yyyy/MM/dd" date="${selfCheck.reportDate}" style="width:120px"/>
		        </td>		        
		    </tr>
		</table>      	
	<div class="postdiv">
		<fieldset>
			<legend>新生儿产房接种</legend> 
			<table class="posttable">
			    <colgroup>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>            
			 	</colgroup>
			 	<tbody>
					<tr>
				      <th>新生儿：</th>
				      <td colspan="3">
						 	<input type="text" id="neonateNumId" name="neonateNum" value="${selfCheck.neonateNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 
						 	<span>&nbsp;人&nbsp;(其中三类新生儿</span>
						 	<input type="text" id="threeNeonateNumId" name="threeNeonateNum" value="${selfCheck.threeNeonateNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 	
						 	<span>&nbsp;人)</span>		 	
				      </td>
					</tr>
					<tr>
				      <th>乙肝疫苗：</th>
				      <td colspan="3">
				      		<span>&nbsp;应种&nbsp;</span>
						 	<input type="text" id="hbvShouldNumId" name="hbvShouldNum" value="${selfCheck.hbvShouldNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 
						 	<span>&nbsp;人,&nbsp;实种&nbsp;</span>
						 	<input type="text" id="hbvActualNumId" name="hbvActualNum" value="${selfCheck.hbvActualNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 	
						 	<span>&nbsp;人,接种率&nbsp;</span>	
						 	<input type="text" id="hbvActualRateId" name="hbvActualRate" value="${selfCheck.hbvActualRate}" 
						 		style="width: 80px;" reg='{"number":"true","max":100}'/> 
						 	<span>&nbsp;%&nbsp;</span>					 		 	
				      </td>
					</tr>
					<tr>
				      <th>卡介苗：</th>
				      <td colspan="3">
				      		<span>&nbsp;应种&nbsp;</span>
						 	<input type="text" id="bcgShouldNumId" name="bcgShouldNum" value="${selfCheck.bcgShouldNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 
						 	<span>&nbsp;人,&nbsp;实种&nbsp;</span>
						 	<input type="text" id="bcgActualNumId" name="bcgActualNum" value="${selfCheck.bcgActualNum}" 
						 		style="width: 80px;" reg='{"digits":"true","max":1000}'/> 	
						 	<span>&nbsp;人,接种率&nbsp;</span>	
						 	<input type="text" id="bcgActualRateId" name="bcgActualRate" value="${selfCheck.bcgActualRate}" 
						 		style="width: 80px;" reg='{"number":"true","max":100}'/> 
						 	<span>&nbsp;%&nbsp;</span>					 		 	
				      </td>
					</tr>  		      
			    </tbody>
			</table>
		</fieldset>
		<table class="posttable">
		    <tr style="text-align: right;">
		        <td>
		        	填报人：<ehr:user userCode="${selfCheck.modifyUserCode}"/>
		        </td>
		    </tr>
		</table> 
	</div>
</div>
</form>