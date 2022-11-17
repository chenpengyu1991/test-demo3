<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table id="cdm-report-manageAndFollowup-result">
	<caption><span style="font-size: 25px;font-weight:bold;">永城市${beginAge} 至 ${endAge} 纳入与随访情况</span></caption>
	    <colgroup>
       		<col style="min-width:260px; width: 15%;"/>
			<col style="min-width:160px; width: 7%;" span="11"/>
	    </colgroup>
	    <thead>
	     	<tr>
	     		<th rowspan="2">单位</th>
	     		<th colspan="2" style="text-align: center;">纳入</th>
	     		<th colspan="5" style="text-align: center;">随访人数</th>
	     		<th>待访</th>
	     		<th>过期随访</th>
	     		<th colspan="2" style="text-align: center;">结案</th>
	     	</tr>
	     	<tr>
	     		<th>合计</th>
	     		<th>累计</th>
	     		<th>门诊</th>
	     		<th>上门</th>
	     		<th>电话</th>
	     		<%--<th>集中</th>--%>
	     		<th>合计</th>
	     		<th>累计</th>
	     		<th>待访</th>
	     		<th>过期未访</th>
	     		<th>合计</th>
	     		<th>累计</th>
	     	</tr>
	     </thead>
	     <tbody>
	     	<c:forEach var="dmManageAndFollowup" items="${dmManageAndFollowup}">
	     		<tr>
	     			<td><ehr:tip>${dmManageAndFollowup.organName}</ehr:tip></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.intoManageTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.intoManageCount}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.outTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.visitTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.phoneTotal}" type="number" /></td>
	     			<%--<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.centralTotal}" type="number" /></td>--%>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.total}" type="number" /></td>
	     	        <td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.followupTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.waitTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.expiredTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.cancelTotal}" type="number" /></td>
	     			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${dmManageAndFollowup.deleteCount}" type="number" /></td>
	     		</tr>
	     	</c:forEach>
	        <tr height="18"   style="font-weight:bold;">
	            <td colspan="3" height="18" width="145">报告单位（盖章）:${currentOrgName} </td>
	            <td colspan="5"> 报告人:${currentUserName}
	            <td colspan="4"> 报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/>
	        </tr>
	    </tbody>
	</table>
</div>