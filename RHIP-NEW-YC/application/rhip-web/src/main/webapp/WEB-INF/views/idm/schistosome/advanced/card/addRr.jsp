<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/cardRrEdit.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="rrForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="rrChildTable"  class="formtable">
				<colgroup>
					<col style="width:15%;"/>
					<col style="width:35%;"/>
					<col style="width:15%;"/>
					<col style="width:35%;"/>					
				</colgroup>	
					<tr>
						<th><label class="required">时间:</label></th>
						<td>
							<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="treatmentDt" id="treatmentDtId" value="<fmt:formatDate value='${listRr.treatmentDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
						</td>
						<th><label class="required">类型:</label></th>
						<td>
							<input type="text" name="treatmentType" reg='{"required":"true","maxlength":"100"}'
								value ='${listRr.treatmentType}' style="width:98%"/>					
						</td>						
					</tr>
					<tr>
						<th><label class="required">金额:</label></th>
						<td>
							<tag:numberInput name="treatmentMoney" id="mny1" style="width: 100px;" value="${listRr.treatmentMoney}"
								maxlength="20" point="true" reg='{"required":"true","maxlength":"20"}'/>
						</td>
						<th><label class="required">转归:</label></th>
						<td>
			           		<ehr:dic-list id="lapsetoId" name="lapseto" dicmeta="IDM00005" reg='{"required":"true"}'
										  width="100px" code="1,2,9,6" value="${listRr.lapseto}" />

						</td>						
					</tr>					
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input class="layui-btn layui-btn-sm" type="button" id="saveRr" name="saveRr" value="添加" onclick="cardRrEdit.saveRr('add')">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input class="layui-btn layui-btn-sm" type="button" id="modifyRr" name="modifyRr" value="修改" onclick="cardRrEdit.saveRr('edit')">
	    </c:if>	
		<input class="layui-btn layui-btn-sm" type="button" id="cancelRd" name="cancelRd" value="取消" onclick="idmCommon.closePopUp('rrDialog')">
	</div>
</div>