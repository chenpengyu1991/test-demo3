<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm//statistics/report/selfcheck/fill/editDc.js" type="text/javascript"></script>
<div class="toolbar">
	<c:if test="${type !='add'}">
    	<a href="javascript:void(0)" onclick="javascript:selfFillDcEdit.returnSearch()"><b class="fanhui">返回</b></a>
    </c:if>
    <c:if test="${type !='view'}">
   		<a href="javascript:void(0)" onclick="javascript:selfFillDcEdit.fillSubmit()"><b class="tijiao">提交</b></a>
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
    
    <input type="hidden"  id="listScDcJsonId" name="listScDcJson" />  
    <div class="postcontent">
        <i class="popno">《传染病防治法》执行情况自查</i>
        
		<table class="posttable">
		    <tr style="text-align: right;">
		        <td>
		        	<label class="required">填报月份：</label>
					<tag:dateInput nullToToday="true" id="reportMonthSelfId" name="reportMonthSelf" onlypast="true" reg='{"required":"true"}'
			        	pattern="yyyy/MM" date="${selfCheck.reportMonth}"  style="width:120px"/>
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
				<legend>法定传染病报告</legend> 
				<table class="posttable">
				    <colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>            
				 	</colgroup>
				 	<tbody>
						<tr>
					      <th><label class="required">抽查部门：</label></th>
					      <td colspan="3">
					      	<ehr:dic-list id="departmentCodeId" name="departmentCode" dicmeta="IDM00333" value="${selfCheck.departmentCode}" reg='{"required":"true"}'
					      		onchange="selfFillDcEdit.existFill()"/>
					      </td>
						</tr>
						<tr>
							<th>抽查病例数：</th>
							<td>
							 	<input type="text" id="checkNumId" name="checkNum" value="${selfCheck.checkNum}" 
							 		style="width: 100px;" reg='{"digits":"true","max":1000}'/>                     	
							</td> 
							<th>应报数：</th>
							<td>
							 	<input type="text" id="shouldNumId" name="shouldNum" value="${selfCheck.shouldNum}" 
							 		style="width: 100px;" reg='{"digits":"true","max":1000}'/>                     	
							</td>                                
						</tr>
					  	<tr>
						     <th>漏报数：</th>
						     <td>
						      	<input type="text" id="missNumId" name="missNum" value="${selfCheck.missNum}" 
						      		style="width: 100px;" reg='{"digits":"true","max":1000}'/>                     	
						     </td> 
						     <th>漏报率%：</th>
						     <td>
						      	<input type="text" id="missRateId" name="missRate" value="${selfCheck.missRate}" 
						      		style="width: 100px;" reg='{"number":"true","max":100}'/>                     	
					        </td>                                
					     </tr>        
				    </tbody>
				</table>				   
				<c:if test="${FYK != '1'}">
					<div class="toolbarsublist">
					    <a href="javascript:void(0)" id="addInfectious" ><b class="xinz">新增</b></a>
					</div>
				</c:if>
					<div id ="childDiv" class="repeattable">	
				       <table id="scDcTable">
				       		<colgroup>
								<col style="min-width: 80px; width: 45%;"/>
								<col style="min-width: 150px; width: 15%;"/>
								<col style="min-width: 80px; width: 15%;"/>
								<col style="min-width: 150px; width: 25%;"/>  
				      		</colgroup>
				      		<tbody>
				      			<tr>
									<th class="centerth">传染病类型</th>	
									<th class="centerth">应报</th>
									<th class="centerth">漏报</th>
									<th class="centerth">操作</th>      			
				      			</tr>
								<c:forEach var="scDc" items="${selfCheck.listScDcs}" varStatus="status">		
									<tr>
										<td field="id" style="display:none;">${scDc.id}</td>
										<td field="infectiousName"><ehr:tip><ehr:dic dicmeta="CV0501017" code="${scDc.infectiousCode}"/></ehr:tip></td>		
										<td field="infectiousCode"  style="display:none;">${scDc.infectiousCode}</td>
										<td field="shouldNum"><ehr:tip>${scDc.shouldNum}</ehr:tip></td>
										<td field="missNum">${scDc.missNum}</td>	
										<td class="btnsublist" field="btn">
											<c:if test="${FYK != '1'}">
												<a href="javascript:void(0)" onclick='selfFillDcEdit.popupInfectious(this,"edit")'>修改</a>				
												<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)" >删除</a>
											</c:if>
										</td>							
									</tr>
								</c:forEach>
				       	</tbody>
					</table>
				</div>     
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
