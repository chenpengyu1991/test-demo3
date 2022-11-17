<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mdm/administrative/add.js" type="text/javascript"></script>
<div>
	<form id="mergeTownForm" method="get">
		<input type="hidden" name="oldCode" value="${townCodes}"/>
		<div>
			<table class="formtable" id="popCcTable">
				<colgroup>
					<col style="width: 30%" />
					<col style="width: 70%" />
				</colgroup>
				<tr>
					<th><label class="required">合并方式：</label></th>
					<td>
						<ehr:dic-list name="newCode" dicmeta="FS990001" code="${townCodes}" firstLabel="新建"
							onchange="toggleOtherSC('newCode','newCodeDiv','');"/>
					</td>
				</tr>
				<tr id="newCodeDiv">
					<td colspan="2" style="padding: 0px;">
						<table>
							<colgroup>
								<col style="width: 30%" />
								<col style="width: 70%" />
							</colgroup>
							<tr>
								<th><label class="required">行政村编码：</label></th>
								<td>
									<input type="text" name="itemCode" value="${dicItem.itemCode}" reg='{"required":"true","maxlength":"20"}'>
								</td>
							</tr>
							<tr>
								<th><label class="required">行政单位名称：</label></th>
								<td><input type="text" name="itemName" value="${dicItem.itemName}" reg='{"required":"true","maxlength":"500"}'></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
    	<input type="button" id="saveContact" value="保存" onclick="villageAdd.mergeTown()"/>
        <input type="button" id="cancelContact" value="取消" onclick="villageAdd.closePopUp('mergeDialog')"/>
    </div>
</div>