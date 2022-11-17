<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mdm/administrative/add.js" type="text/javascript"></script>
<div>
	<form id="addVillageForm" method="get">
		<input type="hidden" name="itemId" value="${dicItem.itemId}"/>
		<input type="hidden" name="dicCode" value="FS990001"/>
		<div>
			<table class="formtable" id="popCcTable">
				<colgroup>
					<col style="width: 30%" />
					<col style="width: 70%" />
				</colgroup>
				<tr>
					<th><label class="required">行政村编码：</label></th>
					<td>
						<c:if test="${empty dicItem.itemCode}">
							<input type="text" name="itemCode" value="${dicItem.itemCode}" reg='{"required":"true","minlength":"12"}'>
							</c:if>
							<c:if test="${not empty dicItem.itemCode}">
								${dicItem.itemCode}
								<input type="hidden" name="itemCode" value="${dicItem.itemCode}">
							</c:if>
					</td>
				</tr>
				<tr>
					<th><label class="required">行政村名称：</label></th>
					<td><input type="text" name="itemName" value="${dicItem.itemName}" reg='{"required":"true","maxlength":"500"}'></td>
				</tr>
				<tr>
					<th>所属行政单位：</th>
					<td><ehr:dic-town-village townName="parentCode" townValue="${dicItem.parentCode}"/> </td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
    	<!-- <input type="button" id="mergeButton" value="保存" onclick="villageAdd.saveVillage()"/> -->
    	<button class="layui-btn layui-btn-sm" id="mergeButton">保存</button>
        <!-- <input type="button" id="cancelContact" value="取消" onclick="villageAdd.closePopUp('villageDialog')"/> -->
        <button class="layui-btn layui-btn-sm" id="mergeCancelButton">取消</button>
    </div>
</div>