<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/drugRecord.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="sdForm">
		<div class="postdiv">
			<div class="toolbarsublist">
				<table class="formtable">
					<colgroup>
						<col style="width:15%;"/>
						<col style="width:35%;"/>
			            <col style="width:15%;"/>
						<col style="width:35%;"/>
					</colgroup>					
					<tr>
						<th><label class="required">用药日期</label></th>
						<td>
							<tag:dateInput id="sdDrugDtId" name="drugDt" onlypast="true" pattern="yyyy/MM/dd"  
								date='${listSd[0].drugDt}' style="100px;" reg='{"required":"true"}'/>
						</td>
						<td></td>
						<td><a href="javascript:void(0)" id="addDrug" ><b class="xinz">新增药品</b></a></td>						
					</tr>
				</table>
			</div>
			<hr/>
			<input type="hidden" id=rowNum value="${rowNum}"/>
			<input type="hidden" id="item" value="${item}"/>
			<table id="sdChildTable"  class="formtable">
				<colgroup>
					<col style="width:10%;"/>
					<col style="width:20%;"/>
		            <col style="width:10%;"/>
					<col style="width:20%;"/>
		            <col style="width:10%;"/>
					<col style="width:20%;"/>
					<col style="width:10%;"/>					
				</colgroup>	
				<c:choose>
                	<c:when test="${empty listSd}">
						<tr>
							<th><label class="required">药物名称</label></th>
							<td>
								<input type="text" name="drugName" reg='{"required":"true","maxlength":"20"}' 
									value ='${sd.drugName}' style="width:98%"/>					
							</td>
							<th>成人剂量</th>
							<td>
								<input type="text" name="adultMetering" reg='{"maxlength":"20"}' 
									value ='${sd.adultMetering}' style="width:98%"/>						
							</td>
							<th>实用剂量</th>
							<td>
								<input type="text" name="practicalMetering" reg='{"maxlength":"20"}' 
									value ='${sd.practicalMetering}' style="width:98%"/>						
							</td>					
						</tr>                	
                    </c:when>
                	<c:otherwise>
						<c:forEach var="sd" items="${listSd}" varStatus="status">		
							<tr>
								<th><label class="required">药物名称</label></th>
								<td>
									<input type="text" name="drugName${status.count}" reg='{"required":"true","maxlength":"20"}' 
										value ='${sd.drugName}' style="width:98%"/>					
								</td>
								<th>成人剂量</th>
								<td>
									<input type="text" name="adultMetering${status.count}" reg='{"maxlength":"20"}' 
										value ='${sd.adultMetering}' style="width:98%"/>						
								</td>
								<th>实用剂量</th>
								<td>
									<input type="text" name="practicalMetering${status.count}" reg='{"maxlength":"20"}' 
										value ='${sd.practicalMetering}' style="width:98%"/>						
								</td>	
								<td>
									<c:if test="${status.count > 1 }">
										<a href="javascript:void(0)" id="deleDrug" onclick="drugRecord.removeTr(this)" >删除</a>
									</c:if>
								</td>				
							</tr>
						</c:forEach>                	
                    </c:otherwise>                    
                </c:choose>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveSd" name="saveSd" value="添加" onclick="drugRecord.addDrugRecord()">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifySd" name="modifySd" value="修改" onclick="drugRecord.modifyDrugRecord()">
	    </c:if>	
		<input type="button" id="cancelSd" name="cancelSd" value="取消" onclick="idmCommon.closePopUp('sdDialog')">
	</div>
</div>