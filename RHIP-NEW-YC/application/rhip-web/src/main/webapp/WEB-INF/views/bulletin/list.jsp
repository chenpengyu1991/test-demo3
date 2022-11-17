<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<ehr:authorize ifAnyGranted="01">
				<col style="width: 65%" />
				<col style="width: 10%;" />
				<col style="width: 10%" />
				<col style="width: 15%" />
			</ehr:authorize>

			<ehr:authorize ifNotGranted="01">
				<col style="width: 85%" />
				<col style="width: 15%" />
			</ehr:authorize>
		</colgroup>
		<thead>
			<tr>
				<th style="width: 50%">标题</th>
				<th style="width: 150px">发布日期</th>

				<ehr:authorize ifAnyGranted="01">
					<th style="width: 150px">显示状态</th>
					<th style="width: 60px;">操作</th>
				</ehr:authorize>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${bulletins}" var="bulletin">
				<tr>
					<td><a href="javascript:void(0)"
						id ="bulletinSearchView${bulletin.id}"  data-id = "${bulletin.id}" ><ehr:tip>${bulletin.title}</ehr:tip></a>
					</td>
					<td style="text-align: center;"><fmt:formatDate
							value='${bulletin.submitTime}' pattern='yyyy/MM/dd' /></td>

					<ehr:authorize ifAnyGranted="01">
						<td><c:choose>
								<c:when test="${bulletin.isDelete == 0}">
	                   				显示
	                   			</c:when>
								<c:otherwise>
	                   				隐藏
	                   			</c:otherwise>
							</c:choose></td>
						<td><%-- <a href="javascript:void(0)"
							id="modifyBulletin${bulletin.id}" data-id="${bulletin.id}">修改</a> --%>
							<a href="javascript:void(0)"
							id="modifyBulletin${bulletin.id}" data-id="${bulletin.id}" title="修改">
							<button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe642;</i>修改</button></a>&nbsp;
						<a href="javascript:void(0)" id="deleteBulletin${bulletin.id}" data-id="${bulletin.id}" title="删除">
						<button class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i>删除</button></a>
						</td>
					</ehr:authorize>
				</tr>
			</c:forEach>
			<tr>
			<ehr:authorize ifAnyGranted="01">
				<td colspan="4"><ehr:paging /> </td>
			</ehr:authorize>
			<ehr:authorize ifNotGranted="01">
				<td colspan="2"><ehr:paging /> </td>
			</ehr:authorize>
			</tr>
		</tbody>
	</table>
	<%-- <ehr:paging /> --%>
</div>

