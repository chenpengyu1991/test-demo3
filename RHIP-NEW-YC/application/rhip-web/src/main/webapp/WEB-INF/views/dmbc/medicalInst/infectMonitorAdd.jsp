<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/infectMonitorAdd.js" type="text/javascript"/>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<input type="hidden" id="operation" value="${operation}"/>
<div class="toolbar">
	<a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
	<c:if test="${operation eq 'edit'}">
		<a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
	</c:if>
</div>
<form id="infectMonitorEditForm" class="postcontent">
	<div class="postdiv">
		<input type="hidden" id="id" name="id" value="${monitor.id}"/>
		<input type="hidden" id="operation" value="${operation}"/>
		<input type="hidden" id="createBy" name="createBy" value="${monitor.createBy}"/>
		<tag:dateInput id="createTime" name="createTime" date="${monitor.createTime}" style="display:none"/>
		<fieldset>
			<legend>院内感染监测</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th><label <c:if test="${operation eq 'edit'}">class="required"</c:if>>机构名称</label></th>
					<td>
						${currentOrg.organName}
						<input type="hidden" name="orgName" value="${currentOrg.organCode}"/>
					</td>
					<th><label <c:if test="${operation eq 'edit'}">class="required"</c:if>>监测日期</label></th>
					<td><tag:dateInput name="monitorDate" pattern="yyyy/MM/dd" date="${monitor.monitorDate}" style="width: 150px" reg="{'required':'true'}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>

<div id="detailList"></div>