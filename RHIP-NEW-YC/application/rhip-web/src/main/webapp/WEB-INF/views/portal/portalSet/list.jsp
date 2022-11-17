<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="person_record_table">
        <colgroup>
            <col style="width:12%;"/>
            <col style="width:12%;"/>
            <col style="width:8%;"/>
			<col style="width:18%;"/>
			<col style="width:5%;"/>
        </colgroup>
			<thead> 
				<tr>
			        <th>编码</th>
					<th>名称</th>
					<th>类型</th>
					<th>数据</th>
					<th>操作</th>
			   </tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${list}" var="portalSet" varStatus="status"> 
					<tr>
						<td style="text-align:left">
							${portalSet.code}
						</td>
						<td style="text-align:left">
							${portalSet.name}
						</td>
						<td style="text-align:left">
							${portalSet.type}
						</td>
						<td style="text-align:left">
							${portalSet.description}
						</td>
						<td style="text-align:center">
							<a href="javascript:void(0)" onclick="setSearch.add('${portalSet.code}')">修改</a>
							<%--<a href="javascript:void(0)" onclick="setSearch.deleteSet('${portalSet.id}')">删除</a>--%>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<ehr:paging/>
	<%-- <ehr:paging action="setSearch.search"/> --%>
		<!-- 实现分页功能 -->
</div>
