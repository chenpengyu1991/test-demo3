<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="postcontent">
	<form id="person_cancel_detail_id" name="userForm" action="" method="post">
		
		<div class="postdiv">
				<table style="width:99%" class="posttable">
					<tr>
						<th style="width: 20%;">姓名</th>
						<td>${personDeathRecord.name}</td>
						<th style="width: 20%;">身份证件号码</th>				
						<td>${personDeathRecord.idcard}</td>
					</tr>
					<tr>
						<th style="width: 20%;">死亡日期</th>
						<td><fmt:formatDate value="${personDeathRecord.deathDate}" pattern="yyyy/MM/dd"/></td>
						<th style="width: 20%;">死亡原因</th>				
						<td>${personDeathRecord.deathReason}</td>
					</tr>
					<tr>
						<th style="width: 20%;">录入机构</th>				
						<td><ehr:org code="${personDeathRecord.inputOrgancode}"/></td>
						<th style="width: 20%;">录入人身份证号</th>
						<td>${personDeathRecord.inputIdcard}</td>
					</tr>
					<tr>
						<th style="width: 20%;">注销状态</th>
						<td><ehr:dic dicmeta="PH00035" code="${personDeathRecord.cancelStatus}"/></td>
						<th style="width: 20%;">报告日期</th>
						<td><fmt:formatDate value="${personDeathRecord.reportDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
				</table>
		</div>
		
	</form>
</div>
