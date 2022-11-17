<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table id="cdm-report-tumorPathology-result" class="layui-table x-admin-sm-table-list-middle">
	<caption><span style="font-size: 25px;font-weight:bold;">永城市${beginDate} 至 ${endDate} 病理统计</span></caption>
	    <colgroup>
	 		<col style="min-width:70px; width: 25%;"/>
			<col style="min-width:70px; width: 25%;"/>
            <col style="min-width:70px; width: 25%;"/>
			<col style="min-width:70px; width: 25%;"/>
	    </colgroup>
	    <thead>
	    	<tr>
	    		<th>上报机构</th>
	    		<th>肿瘤卡数</th>
	    		<th>病理数 </th>
	    		<th>占比(%)</th>
	    	</tr>
	    </thead>
	    <tbody>
	      	<c:forEach var="cdmWorkStatistice" items="${cdmWorkStatistice}" varStatus="status">
	      		
	      		<tr>
	      			<td><ehr:tip>${cdmWorkStatistice['ORGAN_NAME']}</ehr:tip></td>
	      			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${cdmWorkStatistice['REPORT_TOTAL']}" type="number" /></td>
	      			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${cdmWorkStatistice['PATHOLOGY_TOTAL']}" type="number" /></td>
	      			<td><tags:numberLabel userGroup="true" fractionDigits="2"  defaultValue="0" value="${cdmWorkStatistice['PERCENTAGE_TOTAL']}" type="percent" /></td>
	      		</tr>
	      	</c:forEach>
	        <tr height="18"  style="font-weight:bold;">
	            <td height="18" width="145">  报告单位（盖章）:${currentOrgName}</td>
	            <td width="72"> 报告人:${currentUserName}</td>
	            <td width="72"> 报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/></td>
	            <td></td>
	        </tr>
	    </tbody>
	</table>
</div>