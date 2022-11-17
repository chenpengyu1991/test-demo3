<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/cardCrEdit.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="crForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="crChildTable"  class="formtable">
				<colgroup>
					<col style="width:12%;"/>
					<col style="width:38%;"/>
					<col style="width:12%;"/>
					<col style="width:38%;"/>					
				</colgroup>	
					<tr>
						<th><label class="required">信息变更:</label></th>
						<td colspan="3">
							<input type="text" name="changeContent" reg='{"required":"true","maxlength":"400"}' 
								value ='${listCr.changeContent}' style="width:98%"/>					
						</td>
					</tr>
					<tr>
						<th><label class="required">变更时间:</label></th>
						<td>
							<input type="text" class="layui-input x-admin-content-sm-date"  name="changeDt" id="changeDtId" value="<fmt:formatDate value='${listCr.changeDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
						</td>
						<th><label class="required">变更者:</label></th>
						<td>
							<input type="text" name="changeUser" reg='{"required":"true","maxlength":"50"}' 
								value ='${listCr.changeUser}' style="width:120px"/>	
						</td>	
					</tr>
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<input class="layui-btn layui-btn-sm" type="button" id="saveCr" name="saveCr" value="添加" onclick="cardCrEdit.saveCr('add')">
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<input class="layui-btn layui-btn-sm" type="button" id="modifyCr" name="modifyCr" value="修改" onclick="cardCrEdit.saveCr('edit')">

	    </c:if>	
		<input class="layui-btn layui-btn-sm"type="button" id="cancelCr" name="cancelCr" value="取消" onclick="cardCrEdit.closeDialog()">
	</div>
</div>