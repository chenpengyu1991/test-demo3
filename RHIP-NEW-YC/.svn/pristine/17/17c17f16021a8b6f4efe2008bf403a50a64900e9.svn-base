<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/oh/enterprise/list.js" type="text/javascript"></script>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:40px;width: 20%;"/>
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:100px;width: 15%;"/>	
	        <col style="min-width:100px;width: 15%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>企业名称</th>
				<th>档案号</th>
				<th>地址</th>
				<th>经济类型</th>	
				<th>行业分类</th>
				<th>企业建立时间</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="enterprise" items="${enterpriseList.list}" varStatus="status">
				<tr>
					<td title="${enterprise.companyName}" class="centertd">${enterprise.companyName}</td>
					<td title="${enterprise.fileNo}">${enterprise.fileNo}</td>
					<td title="${enterprise.addr}">${enterprise.addr}</td>
					<td title="${enterprise.economicType}">${enterprise.economicType}</td>
					<td title="${enterprise.industryType}">${enterprise.industryType}</td>
					<td class="centertd" title="<fmt:formatDate value="${enterprise.foundedDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${enterprise.foundedDate}" pattern="yyyy/MM/dd" />
					</td>
					<td class="centertd">
						<a href="javascript:void(0);"  onclick="enterpriseList.view('${enterprise.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
						<ehr:authorize ifNotGranted="01">
						<a href="javascript:void(0);"  onclick="enterpriseList.modify('${enterprise.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
						<a href="javascript:void(0);"  onclick="enterpriseList.del('${enterprise.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="enterpriseSearch.search" colspan="7"/>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="enterpriseSearch.search" />
		</tr>
	</table> --%>
</div>