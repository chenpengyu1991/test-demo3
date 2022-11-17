<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
						<th>监测时间</th>
						<td><fmt:formatDate value="${monitor.monitorDate}" pattern="yyyy/MM/dd"/></td>
						<th>机构类型</th>
						<td><ehr:dic dicmeta="DMBC00009" code="${monitor.orgType}" /></td>
					</tr>
					<tr>
						<th>机构名称</th>
						<td colspan="3">${monitor.orgName}</td>
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
						<td>${monitor.airDTotal}</td>
						<td>${monitor.airDAceptNum}</td>
					</tr>
					<tr>
						<td>空气(静态)</td>
						<td>${monitor.airSTotal}</td>
						<td>${monitor.airSAceptNum}</td>
					</tr>
					<tr>
						<td>物体表面</td>
						<td>${monitor.surfaceTotal}</td>
						<td>${monitor.surfaceAceptNum}</td>
					</tr>
					<tr>
						<td>工作人员手</td>
						<td>${monitor.handTotal}</td>
						<td>${monitor.handAceptNum}</td>
					</tr>
					<tr>
						<td>餐饮具</td>
						<td>${monitor.tablewareTotal}</td>
						<td>${monitor.tablewareAceptNum}</td>
					</tr>
					<tr>
						<td>游泳池戏水池</td>
						<td>${monitor.playPoolTotal}</td>
						<td>${monitor.playPoolAceptNum}</td>
					</tr>
				</table>
		</div>
		</div>
	</div>
</form>
</div>