<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/traceRecode.js" type="text/javascript"></script>
<input type="hidden" value="<fmt:formatDate value="${nowDate}" pattern="yyyy/MM/dd"/>" id="currentDate">
<input type="hidden" value="${idmId}" id="idmId">

<div>
	<table class="posttable">
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
	        <col style="width:10%;"/>
	        <col style="width:5%;"/>
	        <col style="width:10%;"/>
			<col style="width:20%;"/>
	        <col style="width:10%;"/>
	        <col style="width:25%;"/>
		</colgroup>	
		<tr>
			<th style="text-align: right;">1姓名：</th>
			<td>${generalCondition.name}</td>
			<th>性别：</th>
			<td><ehr:dic code="${generalCondition.gender}" dicmeta="GBT226112003"/></td>
			<th>身份证号：</th>
			<td>${generalCondition.idcard}</td>
        </tr>
        <tr>
			<th style="text-align: right;">现住址：</th>
			<td colspan="7">
				<ehr:tip><ehr:dic code="${generalCondition.patownShip}" dicmeta="FS990001"/>
				<ehr:dic code="${generalCondition.pastreet}" dicmeta="FS990001"/>
				${generalCondition.pahouseNumber} </ehr:tip> 
			</td>
		</tr>
	</table>
</div>
<div class="repeattable" id="listDiv">
</div>