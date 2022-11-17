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
				<th>会诊编号</th>
				<th>会诊医院</th>
				<th>会诊日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${consultationInfoPageList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.idCard}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${result.gender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.consultationRecordCode}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.consultationOrgName}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.consultationDae}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="consultationSearch.viewBloodDonation('${result.id}')" class="person-link-btn">查看</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			 <ehr:pagination action="consultationSearch.search" colspan="7"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			 <ehr:pagination action="consultationSearch.search" />
		</tr>
	</table> --%>
</div>