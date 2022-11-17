<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script
	src="${pageContext.request.contextPath}/js/views/oh/enterprise/testItemsList.js"
	type="text/javascript"></script>
<input type="hidden" id="enterpriseId" name="enterpriseId"
	value="${enterpriseId}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:enterpriseAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${type == 'add'}">
		<a href="javascript:testItemsList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
	<c:if test="${type == 'edit'}">
		<a href="javascript:testItemsList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width: 60px; width: 6%;" />
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 40px; width: 20%;" />
			<col style="min-width: 100px; width: 20%;" />
			<col style="min-width: 100px; width: 15%;" />
			<col style="min-width: 100px; width: 8%;" />
			<col style="min-width: 100px; width: 18%;" />
		</colgroup>
		<thead>
			<tr>
				<th >编号</th>
				<th >岗位(应测点)</th>
				<th >应测项目</th>
				<th >采机时机说明</th>
				<th >车间</th>
				<th >制图日期</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="testItem" items="${testItem.list}"
				varStatus="status">
				<tr>
					<td title="${testItem.code}" class="centertd">${testItem.code}</td>
					<td title="${testItem.position}">${testItem.position}</td>
					<td title="${testItem.testItem}">${testItem.testItem}</td>
					<td title="${testItem.explain}">${testItem.explain}</td>
					<td title="${testItem.workshopName}">${testItem.workshopName}</td>
					<td class="centertd" title="<fmt:formatDate value='${testItem.drawDate}' pattern='yyyy/MM/dd' />">
						<fmt:formatDate value='${testItem.drawDate}' pattern='yyyy/MM/dd' />
					</td>
					<td class="centertd">
						<%-- <ehr:imageShow imgUrl="${testItem.miniUrl}" title="示意图"></ehr:imageShow> --%>
						<c:if test="${not empty testItem.miniUrl}">
							<a href="javascript:void(0);"  onclick="testItemsList.showDiagram('${testItem.id}')" title="示意图"><i class="layui-icon">&#xe64a;</i></a>&nbsp;&nbsp;
						</c:if>
						<c:if test="${type != 'view'}">
							<a href="javascript:void(0);"  onclick="testItemsList.initEdit('${testItem.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
							<a href="javascript:void(0);"  onclick="testItemsList.del('${testItem.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="testItemsList.search" />
		</tr>
	</table>
</div>