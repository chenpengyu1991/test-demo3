<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/dmbc/childcareInst/monitorInfoEdit.js"></script>
<div id="infoEditFormDiv">
<form id="infoEditForm">
	<div class="postcontent">
		<i class="popno">幼托机构消毒质量监测记录</i>
		<div class="postdiv">
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 60px;"/>
						<col style="width: 80px;"/>
						<col style="width: 60px;"/>
						<col style="width: 80px;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">监测时间</label></th>
						<td><tag:dateInput name="monitorDate" pattern="yyyy/MM/dd" date="${monitor.monitorDate}" onlypast="true" style="width:75px;" reg='{"required":"true"}'/></td>
						<th><label class="required">机构类型</label></th>
						<td><ehr:dic-list name="orgType" dicmeta="DMBC00009" value="${monitor.orgType}" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th><label class="required">机构名称</label></th>
						<td colspan="3"><input type="text" name="orgName" value="${monitor.orgName}" reg="{'required':'true','maxlength':40}" style="width:250px;"/></td>
						<c:if test="${not empty monitor.id}">
					    	<input type="hidden" name="id" value="${monitor.id}" />
					    </c:if>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<div class="repeattable">
				<table>
					<colgroup>
						<col style="width: 135px;"/>
						<col style="width: 135px;"/>
						<col style="width: 135px;"/>
					</colgroup>
					<tr>
						<th style="text-align:center;">监测项目</th>
						<th style="text-align:center;">采样数</th>
						<th style="text-align:center;">合格数</th>
					</tr>
					<tr>
						<td>空气(动态)</td>
						<td><tag:numberInput name="airDTotal" value="${monitor.airDTotal}" reg='{"min":0,"max":30}' /></td>
						<td><tag:numberInput name="airDAceptNum" value="${monitor.airDAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
					<tr>
						<td>空气(静态)</td>
						<td><tag:numberInput name="airSTotal" value="${monitor.airSTotal}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="airSAceptNum" value="${monitor.airSAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
					<tr>
						<td>物体表面</td>
						<td><tag:numberInput name="surfaceTotal" value="${monitor.surfaceTotal}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="surfaceAceptNum" value="${monitor.surfaceAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
					<tr>
						<td>工作人员手</td>
						<td><tag:numberInput name="handTotal" value="${monitor.handTotal}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="handAceptNum" value="${monitor.handAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
					<tr>
						<td>餐饮具</td>
						<td><tag:numberInput name="tablewareTotal" value="${monitor.tablewareTotal}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="tablewareAceptNum" value="${monitor.tablewareAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
					<tr>
						<td>游泳池戏水池</td>
						<td><tag:numberInput name="playPoolTotal" value="${monitor.playPoolTotal}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="playPoolAceptNum" value="${monitor.playPoolAceptNum}" reg='{"min":0,"max":30}'/></td>
					</tr>
				</table>
		</div>
	</div>
	</div>
</form>
<div class="toolbarpop" style="margin-top:15px;">
	<input type="button" id="btnSave" value="保 存" class="btnopr button"/>
</div>
</div>