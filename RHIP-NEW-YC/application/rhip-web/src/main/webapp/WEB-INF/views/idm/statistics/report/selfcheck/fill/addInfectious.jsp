<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/views/idm//statistics/report/selfcheck/fill/editScDc.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="scDcForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="scDcChildTable"  class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:35%;"/>
					<col style="width:15%;"/>
					<col style="width:35%;"/>					
				</colgroup>	
					<tr>
						<th><label class="required">传染病类型:</label></th>
						<td colspan="3">
							<ehr:dic-list id="infectiousTypeId" name="infectiousType" dicmeta="FS10063" code="1,2,3"
                                          value="${fn:substring(listScDc.infectiousCode,0,1)}" reg='{"required":"true"}'  onchange="scDcEdit.queryInfection()"/>
                            <select name="infectiousCode" id="infectiousId" style="width: 150px;"
                                    reg='{"required":"true"}' >
                            </select>
                            <input type="hidden" id="infectiousCodeOldId" name="infectiousCodeOld" value="${listScDc.infectiousCode}"/>
                            <input type="hidden" id="scDcId" name="id" value="${listScDc.id}"/>							
						</td>
					</tr>
					<tr>
						<th>应报:</th>
						<td>
							<input type="text" name="shouldNum" reg='{"digits":"true","max":1000}' 
								value ='${listScDc.shouldNum}' style="width:80px"/>					
						</td>
						<th>漏报:</th>
						<td>
							<input type="text" name="missNum" reg='{"digits":"true","max":1000}' 
								value ='${listScDc.missNum}' style="width:80px"/>
						</td>	
					</tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input type="button" id="saveScDc" name="saveScDc" value="添加" onclick="scDcEdit.save('add')">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input type="button" id="modifyScDc" name="modifyScDc" value="修改" onclick="scDcEdit.save('edit')">
	    </c:if>	
		<input type="button" id="cancelScDc" name="cancelScDc" value="取消" onclick="idmCommon.closePopUp('infectiousDialog')">
	</div>
</div>