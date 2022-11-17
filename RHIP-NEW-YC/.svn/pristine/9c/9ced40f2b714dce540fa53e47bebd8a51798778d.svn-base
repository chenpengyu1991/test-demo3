<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">		
	<table id="cdm-hbpManageMonthReport-table" class="layui-table x-admin-sm-table-list-middle">
		<caption><span style="font-size: 25px;font-weight:bold;">${mouth}永城市高血压社区规范化管理月报表</span></caption>
	    <colgroup>
	        
	    </colgroup>
	    <thead>
	     	<tr>
	     		<th rowspan="2">镇(街道)地址</th>
	     		<th rowspan="2">本月新增管理病人数</th>
	     		<th rowspan="2">累计管理病人数</th>
	     		<th rowspan="2">发生事件数</th>
	     		<th colspan="4">时间内完成随访人数</th>
	     		<th rowspan="2">备注</th>
	     	</tr>
	     	<tr>
	     		<th>3个月</th>
	     		<th>6个月</th>
	     		<th>9个月</th>
	     		<th>12个月</th>
	     	</tr>
	     </thead>
	     <tbody>
	     	<c:forEach var="hbpManageMonthReport" items="${hbpManageMonthReport}">
	     		<tr>
	     			<td><ehr:tip>${hbpManageMonthReport.organName}</ehr:tip></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.addPatient}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.patientCount}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.eventTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.threeMonthsTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.sixMonthsTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.nineMonthsTotal}" type="number" /></td>
	     	        <td><tags:numberLabel userGroup="true" defaultValue="0" value="${hbpManageMonthReport.twelveMonthsTotal}" type="number" /></td>
	     	        <td></td>
	     		</tr>
	     	</c:forEach>
	        <tr height="18" style="height:18px">
	            <td colspan="3" height="18" width="145"><span  style="font-weight:bold;">报告单位（盖章）:${currentOrgName} </span></td>
	            <td colspan="3"><span  style="font-weight:bold;"> 报告人:${currentUserName}</span></td>
	            <td colspan="3"><span  style="font-weight:bold;"> 报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/></span></td>
	        </tr>
	    </tbody>
	</table>
</div>