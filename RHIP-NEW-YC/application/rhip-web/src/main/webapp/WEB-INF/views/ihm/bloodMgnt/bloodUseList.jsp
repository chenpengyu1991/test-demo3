<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 10%;"/>
			<col style="min-width:60px;width: 15%;"/>
			<col style="min-width:100px;width: 15%;"/>
			<col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:100px;width: 8%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 10%;"/>		
		</colgroup>	
		<thead>
			<tr>
				<th>用血者姓名</th>
				<th>用血者证件类型</th>
				<th>用血者证件号</th>
				<th>用血时间</th>
				<th>用血量</th>
				<th>用血医院</th>
				<th>献血者用血者关系</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.patientname}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.patientidentitytype}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.patientidentityid}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.usetime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.useamount}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.hospital}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.relation}</ehr:tip></td>
					<td class="centertd">
						<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
						   onclick="bloodSearch.viewBloodUse('${result.id}')">
							<i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			 <ehr:pagination action="bloodSearch.search" />
		</tr>
	</table>
</div>