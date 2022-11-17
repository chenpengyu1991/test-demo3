<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable" id="serviceTb">
	<input type="hidden" id="beginDate" value="${beginDate}">
	<input type="hidden" id="endDate" value="${endDate}">
	<table id="serviceTable">
		<caption>
			<div align="center" style="margin-right: 20px;">
			<span  style="float:right;text-align:center;">:正常</span>
			<span class="colorFlag infolevel1" style="float:right;display:block;width:12px;height:18px"></span>
			<span  style="float:right;text-align:center;">:异常</span>
			<span class="colorFlag infolevel4" style="display:block;width:12px;height:18px"></span>
				</div>
		</caption>
		<colgroup>
	        <col style="min-width:120px;width: 15%;"/>
			<col/>
	        <col style="min-width:150px;width: 25%;"/>
			<col style="min-width:120px;width: 15%;"/>
			<col style="width:60px;"/>
			<col style="width:60px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>接口名称</th>
                <th>服务器地址</th>
				<th>接口描述</th>
				<th>访问次数</th>
				<th>服务状态</th>
				<th>服务开关</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="wsServiceInfo" items="${wsServiceInfos}" varStatus="status">
				<tr id="${status.count}">
					<td><ehr:tip>${wsServiceInfo.webServiceName}</ehr:tip></td>
					<td data-wsdl="${wsServiceInfo.wsdl}"><ehr:tip>${wsServiceInfo.wsdl}</ehr:tip></td>
					<td title="${wsServiceInfo.webServiceDesc}">${fn:substring(wsServiceInfo.webServiceDesc, 0, 20)}</td>
					<td class="centertd"  data-web-service-name="${wsServiceInfo.webServiceName}"><div id="load2${status.count}"></div></td>
					<td class="centertd"><div id="load1${status.count}"></div></td>
					<td  class="centertd"><ehr:dic dicmeta="FS990018" code="${wsServiceInfo.serverStatus}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="serviceMonitorSearch.search" />
		</tr>
	</table>
</div>