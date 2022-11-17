<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="person_record_table">
		<colgroup>
			<col width="30%"/>
			<col width="30%"/>
			<col width="10%"/>
			<col width="100px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>来访机器IP地址</th>
				<th>禁用标志</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach var="wsClientInfo" items="${wsClientInfos}" varStatus="status">
				<tr>
					<td><ehr:tip>${wsClientInfo.orgName}</ehr:tip></td>
					<td><ehr:tip>${wsClientInfo.userIp}</ehr:tip></td>
					<td class="centertd"><ehr:dic dicmeta="FS990020" code="${wsClientInfo.isOff}"/></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${wsClientInfo.isOff eq '1'}">
								<a href="javascript:void(0);" class="edit-link" data-id="${wsClientInfo.id}">修改</a>
								<a href="javascript:void(0);" class="view-link" data-id="${wsClientInfo.id}">查看</a>
								<a href="javascript:void(0);" class="delete-link" data-id="${wsClientInfo.id}">删除</a>
								<a href="javascript:void(0);" class="change-link" data-id="${wsClientInfo.id}" data-flag="0">禁用</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0);" class="delete-link" data-id="${wsClientInfo.id}">删除</a>
								<a href="javascript:void(0);" class="change-link" data-id="${wsClientInfo.id}" data-flag="1">启用</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	<table>
		<tr>
			<ehr:pagination action="clientRegisterSearch.search" />
		</tr>
	</table>
</div>