<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grfhyp/grfhyp.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a id="grfhypAdd" href="javascript:grfhyp.addRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        	<col style="width:4%;"/>
            <col style="width:30%;"/>
            <col style="width:26%;"/>
            <col style="width:20%;"/>
            <col style="width:20%;">
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>个人防护用品名称</th>
					<th>防护铅当量</th> 
					<th>数量</th> 
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record" varStatus="status"> 
					<tr>
					    <td class="centertd">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
					    </td>
						<td title="${record.name}">${record.name}</td>
						<td title="${record.leadEquivalent}">${record.leadEquivalent}</td>
						<td class="righttd" title="${record.count}">${record.count}</td>
						<td class="centertd">
							<a href="javascript:void(0);" class="grfhypModify" onclick="grfhyp.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>
							<a href="javascript:void(0);" class="grfhypDelete" onclick="grfhyp.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="editRecord.grfhyp" colspan="7"/>
	</table>
</div>
