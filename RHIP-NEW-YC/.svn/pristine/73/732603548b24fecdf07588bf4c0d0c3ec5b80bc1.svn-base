<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="person_record_table">
		<colgroup>
			<col width="20%"/>
			<col width="30%"/>
			<col width="25%"/>
			<col width="10%"/>
			<col width="100px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>接口名称(KEY)</th>
				<th>服务器地址</th>
				<th>接口描述</th>
				<th>服务器状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach var="wsServiceInfo" items="${wsServiceInfos}" varStatus="status">
				<tr>
					<td><ehr:tip>${wsServiceInfo.webServiceName}</ehr:tip></td>
					<td><ehr:tip>${wsServiceInfo.wsdl}</ehr:tip></td>
					<td><ehr:tip>${wsServiceInfo.webServiceDesc}</ehr:tip></td>
					<td class="centertd"><ehr:dic dicmeta="FS990018" code="${wsServiceInfo.serverStatus}"/></td>
					<td class="centertd">
						<a href="javascript:void(0);" class="edit-link" data-id="${wsServiceInfo.id}">修改</a>
						<a href="javascript:void(0);" class="view-link" data-id="${wsServiceInfo.id}">查看</a>
						<a href="javascript:void(0);" class="delete-link" data-id="${wsServiceInfo.id}">删除</a>
						<c:choose>
							<c:when test="${wsServiceInfo.serverStatus eq '1'}">
								<a href="javascript:void(0);" class="change-link" data-id="${wsServiceInfo.id}" data-flag="0">关闭</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0);" class="change-link" data-id="${wsServiceInfo.id}" data-flag="1">开启</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	<table>
		<tr>
			<ehr:pagination action="serviceRegisterSearch.search" />
		</tr>
	</table>
</div>