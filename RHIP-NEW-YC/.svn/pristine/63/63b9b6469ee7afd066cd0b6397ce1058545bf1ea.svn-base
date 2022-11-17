<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorEdit.js"/>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
		</colgroup>
		<thead>
		<tr>
			<th>监测企业或商店名称</th>
			<th>监测类型</th>
			<th>盐样编号</th>
			<th>采样日期</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="record" items="${recordList}">
			<tr>
				<td>${record.name}</td>
				<td class="centertd"><ehr:dic dicmeta="FS10275" code="${record.surveyType}"/></td>
				<td>${record.saltSamplingNumber}</td>
				<td class="centertd"><fmt:formatDate value="${record.monitorTime}" pattern="yyyy-MM-dd"/></td>
				<td >
					<a href="javascript:void(0);"  onclick="epMonitorEdit.detail(${record.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;&nbsp;
					<c:if test="${record.monitorYear eq thisYear}">
						<a href="javascript:void(0);"  onclick="epMonitorSearch.edit('edit', ${record.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;&nbsp;
						<a href="javascript:void(0);"  onclick="epMonitorEdit.del(this, ${record.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="epMonitorSearch.search" colspan="5"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="epMonitorSearch.search"/>
		</tr>
	</table> --%>
</div>
<div><input type="hidden" id="indexPage" value="${indexPage}"/></div>