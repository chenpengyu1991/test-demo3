<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
			<col style="min-width:40px;width: 10%;"/>
			<col style="min-width:40px;width: 10%;"/>
	        <col style="min-width:80px;width: 10%;"/>	
	        <col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:20px;width: 8%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>性别</th>
				<th>ABO血型</th>
				<th>献血类型及献血量</th>
				<th>采血日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.idcard}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.gender}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.aboBloodType}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.donBlood}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.bloodDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd">
						<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
						   onclick="bloodSearch.viewBloodDonation('${result.id}')">
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