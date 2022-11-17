<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<%--
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/detail.js" type="text/javascript"></script>
--%>
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/mediaEdit.js" type="text/javascript"></script>


<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 15%;" />
			<col style="width: 20%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;;" />
			<col style="width: 15%;;" />
            <col style="width: 20%;;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>视频主题</th>
				<th>开始播放日期</th>
				<th>播放天数(天)</th>
				<th>每日播放时长(分钟)</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResource" items="${healthEducationResources}">
				<tr>
					<td>
						<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
					</td>
					<td>${healthEducationResource.theme}</td>
					<td class="centertd"><fmt:formatDate value="${healthEducationResource.playDate}" pattern="yyyy-MM-dd"/></td>
					<td class="righttd">${healthEducationResource.times}</td>
					<td class="righttd">${healthEducationResource.period}</td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.viewHealthEducationResource(${healthEducationResource.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.viewHealthEducationResource(${healthEducationResource.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
						<c:if test="${createrOrg eq healthEducationResource.orgCode || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.editHealthEducationResourceMedia(${healthEducationResource.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.editHealthEducationResourceMedia(${healthEducationResource.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.deleteHealthEducationResourceMedia(${healthEducationResource.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceMediaEdit.deleteHealthEducationResourceMedia(${healthEducationResource.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="healthEducationResourceMediaSearch.search" colspan="6"/>
			</tr>
		</tbody>
	</table>

	<%-- <table>
		<tr>
			<ehr:pagination action="healthEducationResourceMediaSearch.search" />
		</tr>
	</table> --%>
	<input type="hidden" id="actType" value="" />
</div>