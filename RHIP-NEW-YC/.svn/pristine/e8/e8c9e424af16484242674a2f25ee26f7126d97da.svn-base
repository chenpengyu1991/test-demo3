<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable" >
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:50px;width: 8%;"/>
			<col style="min-width:80px;width: 13%;"/>
			<col style="min-width:30px;width: 5%;"/>
            <col style="min-width:30px;width: 5%;"/>
			<col style="min-width:70px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:60px;width: 10%;"/>
	        <col style="min-width:70px;width: 8%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>性别</th>
				<th>年龄</th>
				<th>输血数量</th>
				<th>输血品种名称</th>
				<th>医疗机构名称</th>
                <th>输血时间</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.idcard}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${result.gender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.age}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.bloodQuantity}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.bloodTypeName}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.hospitalName}</ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatDate value="${result.bloodDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></ehr:tip></td>
                    <td class="centertd"><a href="javascript:void(0)" onclick="hospitalBloodUseSearch.viewHospitalBloodUse('${result.id}')"
                           class="person-link-btn">查看</a></td>
				</tr>
			</c:forEach>
		<tr>
			 <ehr:pagination action="hospitalBloodUseSearch.search" colspan="9"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			 <ehr:pagination action="hospitalBloodUseSearch.search" />
		</tr>
	</table> --%>
</div>