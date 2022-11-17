<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/promoteunit/detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/promoteunit/edit.js" type="text/javascript"></script>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>单位名称</th>
				<th>创建类别</th>
				<th>创建级别</th>
				<th>授予时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthPromoteUnit" items="${healthPromoteUnits}">
				<tr>
					<td>
						<ehr:tip>${healthPromoteUnit.name}</ehr:tip>
					</td>
					<td>
						<c:if test="${healthPromoteUnit.type ne '99'}">
							<ehr:tip><ehr:dic dicmeta="HE00009" code="${healthPromoteUnit.type}"></ehr:dic></ehr:tip>
						</c:if>
						<c:if test="${healthPromoteUnit.type eq '99'}"><ehr:tip>${healthPromoteUnit.otherType}</ehr:tip></c:if>
					<td>
						<c:if test="${healthPromoteUnit.unitLevel ne '99'}">
								<ehr:tip><ehr:dic dicmeta="HE00010" code="${healthPromoteUnit.unitLevel}"></ehr:dic></ehr:tip>
						</c:if>
						<c:if test="${healthPromoteUnit.type eq '99'}"><ehr:tip>${healthPromoteUnit.otherUnitLevel}</ehr:tip></c:if>
					</td>
					<td style="text-align: center;"><fmt:formatDate value="${healthPromoteUnit.grantTime}" pattern="yyyy-MM-dd"/></td>
					<td style="text-align: center;">
						<%-- <a href="javascript:void(0);"  onclick="healthPromoteUnitDetail.viewHealthPromoteUnit(${healthPromoteUnit.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthPromoteUnitDetail.viewHealthPromoteUnit(${healthPromoteUnit.id})" title="查看" ><i class="layui-icon">&#xe615;</i></a>
						<ehr:authorize ifAnyGranted="12">
						<%-- <a href="javascript:void(0);"  onclick="healthPromoteUnitEdit.editHealthPromoteUnit(${healthPromoteUnit.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthPromoteUnitEdit.editHealthPromoteUnit(${healthPromoteUnit.id})" title="修改"><i class="layui-icon">&#xe642;</i></a>
						<%-- <a href="javascript:void(0);"  onclick="healthPromoteUnitEdit.deleteHealthPromoteUnit(${healthPromoteUnit.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthPromoteUnitEdit.deleteHealthPromoteUnit(${healthPromoteUnit.id})" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="healthPromoteUnitSearch.search" colspan="5"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="healthPromoteUnitSearch.search" />
		</tr>
	</table> --%>
</div>