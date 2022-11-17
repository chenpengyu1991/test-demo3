<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/pxqk/pxqk.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a id="pxqkAdd" href="javascript:pxqk.addRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
</div>
<div class="repeattable">
		<table id="training_record_table" class="layui-table x-admin-sm-table-list-middle">
			<colgroup>
				<col style="width:4%;"/>
				<col style="width:16%;"/>
				<col style="width:15%;"/>
				<col style="width:14%;"/>
				<col style="width:20%;"/>
				<col style="width:16%;"/>
				<col style="width:15%;"/>
			</colgroup>
			<thead>
				<tr>
					<th class="centerth">序号</th>
					<th class="centerth">姓名</th>
					<th class="centerth">培训时间</th>
					<th class="centerth">培训证号</th>
					<th class="centerth">更新时间</th>
					<th class="centerth">更新人</th>
					<th class="centerth">操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${infoRecords}" var="record" varStatus="status">
					<tr>
						<td class="centertd"><ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number></td>
						<td class="centertd" title="${record.name }">${record.name }</td>
						<td class="centertd" title="${record.treateTime }">
                            <c:choose>
						        <c:when test="${not empty record.treateTime}">
						            <fmt:formatDate value="${record.treateTime}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
						<td class="centertd" title="${record.treateNo }">${record.treateNo }</td>
						<td class="centertd" title="${record.updateTime }">
                            <c:choose>
						        <c:when test="${not empty record.updateTime}">
						            <fmt:formatDate value="${record.updateTime}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
						<td class="centertd" title="${record.updateBy }">${record.updateBy }</td>
						<td class="centertd">
							<a href="javascript:void(0);" class="pxqkModify" onclick="pxqk.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>
							<a href="javascript:void(0);" class="pxqkDelete" onclick="pxqk.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="editRecord.pxqk" colspan="14" />
		</table>
	</div>