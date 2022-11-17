<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 16%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 16%;" />
			<col style="width: 10%;" />
		</colgroup>
		<thead>
			<tr>
				<th>
					服务机构
				</th>
				<th>姓名</th>
				<th>性别</th>
				<th>联系电话</th>
				<th>身份证号码</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="heIndividual" items="${heIndividuals}">
				<tr>
					<td>
                        <ehr:tip><ehr:org code="${heIndividual.orgCode}" /></ehr:tip>
                        <c:if test="${heIndividual.gbcode eq '_999'}">
							<ehr:tip>健康教育所</ehr:tip>
						</c:if>
					</td>
					<td>
						<ehr:tip>${heIndividual.individualName}</ehr:tip>
					</td>
					<td>
						<ehr:dic code="${heIndividual.gender}" dicmeta="GBT226112003"></ehr:dic>
					</td>
					<td>
						<ehr:tip>${heIndividual.phoneNumber}</ehr:tip>
					</td>
					<td>
						<ehr:tip>${heIndividual.idcard}</ehr:tip>
					</td>
					<td>
						<%-- <a href="javascript:void(0);" class="view-link"  data-id="${heIndividual.id}">查看</a> --%>
						<a href="javascript:void(0);" class="view-link"  data-id="${heIndividual.id}" title="查看" ><i class="layui-icon">&#xe615;</i></a>
						<c:if test="${createrOrg eq heIndividual.orgCode }">
						<%-- <a href="javascript:void(0);" class="edit-link"   data-id="${heIndividual.id}">修改</a> --%>
						<a href="javascript:void(0);" class="edit-link"   data-id="${heIndividual.id}" title="修改"><i class="layui-icon">&#xe642;</i></a>
						<%-- <a href="javascript:void(0);" class="delete-link"  data-id="${heIndividual.id}">删除</a> --%>
						<a href="javascript:void(0);" class="delete-link"  data-id="${heIndividual.id}" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="heIndividualSearch.search" />
		</tr>
	</table>
</div>