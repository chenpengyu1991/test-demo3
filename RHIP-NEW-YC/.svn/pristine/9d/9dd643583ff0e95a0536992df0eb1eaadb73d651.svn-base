<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	 require(['views/portal/accountInfo/search'],function(accountInfoSearch){
		 accountInfoSearch.load();
	 });
</script>
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
					<th><label>用&nbsp;户&nbsp;名：</label></th>
					<td>${accountInfo.accountName}</td>
					<th><label>真实姓名：</label></th>
					<td>${accountInfo.realName}</td>
				</tr>
				<tr>
					<th><label>身份证号：</label></th>
					<td>${accountInfo.cardNo }</td>
					<th><label>邮箱地址：</label></th>
					<td>${accountInfo.email }</td>
				</tr>
				<tr>
					<th><label>手机号码：</label></th>
					<td style="vertical-align: top;">${accountInfo.telephone }</td>
					<th>现住址：</th>
					<td>
						<ehr:dic dicmeta="FS990001" code="${accountInfo.patownShip}"/>
						<ehr:dic dicmeta="FS990001" code="${accountInfo.pastreet}"/>
						<c:out value="${accountInfo.pahouseNumber}"></c:out>
					</td>
				</tr>
				<tr>
			</table>
		</fieldset>
		</form>
	</div>
</div>



