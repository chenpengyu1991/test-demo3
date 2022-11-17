<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" style="overflow-x: auto;">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="60px">机构顺序序号</th>
		<th width="70px">机构编码</th>
		<th width="150px">机构名称</th>
		<th width="80px">机构类别</th>
		<th width="90px">经营性质</th>
		<th width="60px">机构级别</th>
		<th width="50px">法人代表</th>
		<th width="60px">单位电话</th>
		<th width="150px">地址</th>
		<th width="40px">状态</th>
		<th width="120px">操作</th>
	</tr>
	</thead>
	<c:forEach items="${organList}" var="organ" varStatus="status">
		<tr>
			<td class="centertd" title="${organ.sort}" class="centertd">${organ.sort}</td>
			<td title="${organ.organCode}"><a href="javascript:void(0);" onclick="organizationSearch.view('${organ.organId}')">${organ.organCode}</a></td>
			<td title="${organ.organName}">${organ.organName}</td>
			<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT2182002" code="${organ.genreCode}" /></ehr:tip> </td>
			<td><ehr:tip><ehr:dic dicmeta="FS10223" code="${organ.manageCode}" /></ehr:tip> </td>
			<td class="centertd"><ehr:dic dicmeta="DM02-02" code="${organ.gradeCode}" /></td>
			<td class="centertd">${organ.artificialPerson}</td>
			<td class="centertd" title="${organ.tel}">${organ.tel}</td>
			<td title="${organ.address}">${organ.address}</td>
			<td class="centertd">
				<a href="javascript:void(0);" onclick="organizationSearch.changeStatus(this, '${organ.organId}',${organ.status})">
					<c:if test="${organ.status eq -1}">禁用</c:if>
					<c:if test="${organ.status eq 1}">启用</c:if>
				</a>
			</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="organizationSearch.edit('${organ.organId}')">修改</a> --%>
				<a href="javascript:void(0);" onclick="organizationSearch.edit('${organ.organId}')" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
				&nbsp;
				<ehr:authorize ifNotGranted="03,39">
					<%-- <a href="javascript:void(0);" onclick="organizationSearch.remove('${organ.organId}')">删除</a> --%>
					<%--<a href="javascript:void(0);" onclick="organizationSearch.remove('${organ.organId}')" title="删除"><i class="layui-icon" style="color: #FF5722;">&#xe640;</i></a>--%>
					&nbsp;				
				</ehr:authorize>
				<%-- <a href="javascript:void(0);" onclick="organizationSearch.showLogs('${organ.organId}')">变化跟踪</a> --%>
				<a href="javascript:void(0);" onclick="organizationSearch.toShowLogs('${organ.organId}')" title="变化跟踪" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe60e;</i>跟踪</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="organizationSearch.search" colspan="11"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="organizationSearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>