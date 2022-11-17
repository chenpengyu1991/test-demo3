<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table>
	<thead>
	<tr>
		<th width="30%">域编码</th>
		<th width="40%">域名称</th>
		<th width="30%">操作</th>
	</tr>
	</thead>
	<c:forEach items="${domainList}" var="domain" varStatus="status">
		<tr>
			<td>${domain.domainCode}</td>
			<td>${domain.domainName}</td>
			<td>
				<a href="javascript:void(0);" onclick="domainSearch.editDomain('${domain.domainCode}')">修改</a>&nbsp;
				<a href="javascript:void(0);" onclick="domainSearch.deleteDomain('${domain.domainCode}')">删除</a>&nbsp;
			</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="domainSearch.search" />
	</tr>
</table>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>