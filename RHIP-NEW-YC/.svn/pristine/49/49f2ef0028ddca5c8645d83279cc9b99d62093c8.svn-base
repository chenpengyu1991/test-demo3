<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="60px">主要编码</th>
		<th width="120px">附加编码</th>
		<th width="140px">疾病名称</th>
		<th width="50px">状态</th>
		<th width="100px">操作</th>
	</tr>
	</thead>
	<c:forEach items="${diseaseList}" var="disease" varStatus="status">
		<tr>
			<td class="centertd">${disease.icd10main}</td>
			<td class="centertd">${disease.icd10ext}</td>
			<td>${disease.diseaseName}</td>
			<td class="centertd">
				<a href="javascript:void(0);" onclick="diseaseSearch.changeStatus(this, '${disease.diseaseId}',${disease.status})">
					<c:if test="${disease.status eq -1}">作废</c:if>
					<c:if test="${disease.status eq 1}">有效</c:if>
				</a>
			</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="diseaseSearch.editDisease('${disease.diseaseId}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="diseaseSearch.editDisease('${disease.diseaseId}')" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="diseaseSearch.deleteDisease('${disease.diseaseId}')">删除</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="diseaseSearch.deleteDisease('${disease.diseaseId}')" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="diseaseSearch.showDiseaseLogs('${disease.diseaseId}')">变化跟踪</a> --%>
				<a href="javascript:void(0);" onclick="diseaseSearch.showDiseaseLogs('${disease.diseaseId}')" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="变化跟踪" ><i class="layui-icon">&#xe60e;</i>跟踪</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="diseaseSearch.search" colspan="5"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="diseaseSearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>