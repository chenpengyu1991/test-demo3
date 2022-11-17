<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script
	src="${pageContext.request.contextPath}/js/views/oh/enterprise/contactSituationList.js"
	type="text/javascript"></script>
<input type="hidden" id="enterpriseId" name="enterpriseId"
	value="${enterpriseId}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:enterpriseAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${type == 'add'}">
		<a href="javascript:contactSituationList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
	<c:if test="${type == 'edit'}">
		<a href="javascript:contactSituationList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width: 60px; width: 8%;" />
			<col style="min-width: 120px; width: 9%;" />
			<col style="min-width: 40px; width: 10%;" />
			<col style="min-width: 100px; width: 10%;" />
			<col style="min-width: 100px; width: 5%;" />
			<col style="min-width: 100px; width: 5%;" />
			<col style="min-width: 100px; width: 5%;" />
			<col style="min-width: 100px; width: 12%;" />
			<col style="min-width: 100px; width: 12%;" />
			<col style="min-width: 100px; width: 12%;" />
			<col style="min-width: 100px; width: 12%;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">时间</th>
				<th rowspan="2">车间</th>
				<th rowspan="2">岗位</th>
				<th rowspan="2">危害因素名称</th>
				<th colspan="3">接触人数</th>
				<th rowspan="2">防护情况</th>
				<th rowspan="2">个人防护情况</th>
				<th rowspan="2">日接触时间</th>
				<th rowspan="2">操作</th>
			</tr>
			<tr>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contactSituation" items="${contactSituation.list}"
				varStatus="status">
				<tr>
					<td title="<fmt:formatDate value='${contactSituation.createTime}' pattern='yyyy/MM/dd' />" class="centertd">
						<fmt:formatDate value='${contactSituation.createTime}' pattern='yyyy/MM/dd' />
					</td>
					<td title="${contactSituation.workshopName}">${contactSituation.workshopName}</td>
					<td title="${contactSituation.position}">${contactSituation.position}</td>
					<td title="${contactSituation.hazardFactorsName}">${contactSituation.hazardFactorsName}</td>
					<td class="righttd" title="${contactSituation.manNum+contactSituation.womanNum}">${contactSituation.manNum+contactSituation.womanNum}</td>
					<td class="righttd" title="${contactSituation.manNum}">${contactSituation.manNum}</td>
					<td class="righttd" title="${contactSituation.womanNum}">${contactSituation.womanNum}</td>
					<td class="righttd" title="${contactSituation.safeguardProcedures}">${contactSituation.safeguardProcedures}</td>
					<td class="righttd"><ehr:tip>${contactSituation.protectiveMeasures}</ehr:tip></td>
					<td class="righttd"><ehr:tip>${contactSituation.dayContactTime}</ehr:tip></td>
					<td class="centertd">
						<c:if test="${type != 'view'}">
							<a href="javascript:void(0);"  onclick="contactSituationList.initEdit('${contactSituation.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
							<a href="javascript:void(0);"  onclick="contactSituationList.del('${contactSituation.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</c:if>
					</td>
						
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="contactSituationList.search" />
		</tr>
	</table>
</div>