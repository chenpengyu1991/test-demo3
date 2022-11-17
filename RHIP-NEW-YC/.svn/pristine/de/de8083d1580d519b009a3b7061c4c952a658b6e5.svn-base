<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 25%;" />
			<col style="width: 25%;" />
			<col style="width: 25%;" />
			<col style="width: 25%;" />
		</colgroup>
		<thead>
			<tr>
				<th>填报机构</th>
				<th>计划类别</th>
				<th>填报时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="heWorkPlan" items="${heWorkPlans}">
				<tr>
					<td>
						<ehr:tip><ehr:org code="${heWorkPlan.createOrgCode}"/></ehr:tip>
					</td>
					<td>
						<ehr:tip><ehr:dic code="${heWorkPlan.planType}" dicmeta="HE00033"/></ehr:tip>
					</td>
					<td class="centertd">
						<ehr:tip><fmt:formatDate value="${heWorkPlan.createDate}" pattern="yyyy/MM/dd"/></ehr:tip>
					</td>
					<td>
						<%-- <a href="javascript:void(0);" class="view-link" data-id="${heWorkPlan.id}">查看</a> --%>
						<a href="javascript:void(0);" class="view-link layui-btn layui-btn-normal layui-btn-xs" data-id="${heWorkPlan.id}" title="查看" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
						<c:if test="${createrOrg eq heWorkPlan.createOrgCode}">
							<%-- <a href="javascript:void(0);" class="edit-link" data-id="${heWorkPlan.id}">修改</a> --%>
							<a href="javascript:void(0);" class="edit-link layui-btn layui-btn-xs" data-id="${heWorkPlan.id}" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
							<%-- <a href="javascript:void(0);" class="delete-link" data-id="${heWorkPlan.id}">删除</a> --%>
							<a href="javascript:void(0);" class="delete-link layui-btn layui-btn-danger layui-btn-xs" data-id="${heWorkPlan.id}" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="heWorkPlanSearch.search" colspan="4"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="heWorkPlanSearch.search" />
		</tr>
	</table> --%>
</div>