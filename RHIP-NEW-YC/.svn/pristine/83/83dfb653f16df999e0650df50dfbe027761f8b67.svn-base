<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 22%;"/>
			<col style="width: 10%;"/>
			<col style="width: 22%;"/>
			<col style="width: 10%;"/>
			<col style="width: 12%;"/>
			<col style="width: 20%;"/>
			<col style="width: 120px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>刊（播）出文章题目</th>
				<th>刊（播）日期</th>
				<th>发表单位</th>
				<th>版面</th>
				<th>类型</th>
				<th>作者</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="heCopy" items="${heCopys}">
				<tr>
					<td>
                        <ehr:tip>${heCopy.title}</ehr:tip>
					</td>
					<td class="centertd">
						<fmt:formatDate value="${heCopy.publishDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
					</td>
					<td>
						<ehr:tip><ehr:dic code="${heCopy.publishOrgan}" dicmeta="HE00012"></ehr:dic></ehr:tip>
					</td>
					<td>
						<ehr:tip>${heCopy.edition}</ehr:tip>
					</td>
					<td class="centertd"><ehr:tip><ehr:dic code="${heCopy.type}" dicmeta="HE00013"></ehr:dic></ehr:tip></td>
					<td class="centertd">
						<ehr:tip>${heCopy.author}</ehr:tip>
					</td>
					<td>
						<a href="javascript:void(0);" class="view-link" data-id="${heCopy.id}" title="查看" ><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
						<c:if test="${createrOrg eq heCopy.authorOrg}">
							&nbsp;<a href="javascript:void(0);" class="edit-link"  data-id="${heCopy.id}" title="修改"><i class="layui-icon">&#xe642;</i></a>
							&nbsp;<a href="javascript:void(0);" class="delete-link"  data-id="${heCopy.id}" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="heCopySearch.search"/>
		</tr>
	</table>
</div>