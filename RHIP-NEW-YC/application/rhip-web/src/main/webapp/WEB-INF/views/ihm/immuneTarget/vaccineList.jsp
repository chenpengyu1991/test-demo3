<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<%--<col style="min-width:150px;width: 15%;"/>--%>
			<%--<col style="min-width:150px;width: 15%;"/>--%>
			<%--<col style="min-width:150px;width: 15%;"/>--%>
			<col style="min-width:150px;width: 30%;"/>
			<col style="min-width:150px;width: 30%;"/>
			<col style="min-width:150px;width: 30%;"/>
			<col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<%--<th>身份证号码</th>--%>
				<th>父亲姓名</th>
				<%--<th>父亲身份证号码</th>--%>
				<th>母亲姓名</th>
				<%--<th>母亲身份证号码</th>--%>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vaccine" items="${vaccinelist}" varStatus="status">
				<tr>
					<td style="text-align: center">${vaccine.name}</td>
					<%--<td style="text-align: center">${vaccine.idCard}</td>--%>
					<td style="text-align: center">${vaccine.fatherName}</td>
					<%--<td style="text-align: center">${vaccine.fatherIdcard}</td>--%>
					<td style="text-align: center">${vaccine.motherName}</td>
					<%--<td style="text-align: center">${vaccine.motherIdcard}</td>--%>
					<td style="text-align: center">
						<!-- ${vaccine.id} -->
						<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
						   onclick="vaccineTargetSearch.loadDetailDialog('/ihm/vaccine/vaccineDetail', ${vaccine.vaccinationCode}, '儿童接种疫苗','550px','1000px')">
							<i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="vaccineTargetSearch.vaccineSearch" colspan="4"/>
			</tr>
		</tbody>
	</table>
</div>