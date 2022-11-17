<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/portal/frequent/frequentInfoShowPage.js" type="text/javascript"></script>

<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
</div>
<div class="postcontent">
	<div class="postdiv" id="accountInfo">
		<form method="post" name="accountInfoForm">
	<fieldset>
			<legend>用户信息</legend>
			<table style="width: 99%;" class="posttable">
				<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="35%" />
				<colgroup>
				<tr>
					<th><label>姓名：</label></th>
					<td>${frequent.frequentName}</td>
					<th><label>性别：</label></th>
					<td><ehr:tip><ehr:dic dicmeta="GBT226112003" code = "${frequent.gender}"/></ehr:tip></td>
				</tr>
				<tr>
					<th><label>身份证号：</label></th>
					<td>${frequent.cardNo }</td>
					<th><label>出生日期：</label></th>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${frequent.birthday }"/></td>
				</tr>
				<tr>
					<th><label>手机号码：</label></th>
					<td style="vertical-align: top;">${frequent.telephone }</td>
					<th>预约状态：</th>
					<td><ehr:tip><ehr:dic dicmeta="LH00006" code="${frequent.reserveStatus}"/></ehr:tip></td>
				</tr>
				<tr>
			</table>
		</fieldset>
		</form>
	</div>
</div>



