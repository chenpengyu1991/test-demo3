<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 20%;" />
			<col style="width: 10%;" />
			<col style="width: 30%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />

		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>身份证号</th>
				<th>性别</th>
				<th>体检机构</th>
				<th>月龄</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody style="text-align: center">
			<c:forEach var="personInfo" items="${childHeathExamination}">
				<tr>
					<td><ehr:tip>${personInfo.name}</ehr:tip></td>
                    <td><ehr:tip>${personInfo.idCard}</ehr:tip></td>
                    <td><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}"/></td>
					<td><ehr:org code="${personInfo.checkOrganCode}"></ehr:org></td>
                    <td><ehr:dic dicmeta="ECH00001" code="${personInfo.cPhysicalExamAge}"/></td>
					<td>
						<%--<a href="javascript:void(0)" onclick="echChildrenSearch.initReport(${personInfo.id},'edit')">修改</a>--%>
                        <%-- <a href="javascript:void(0)" onclick="echChildrenSearch.initReport(${personInfo.id},'view')">查看</a> --%>
                        <a title="查看" href="javascript:void(0)" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" onclick="echChildrenSearch.initReport(${personInfo.id},'view')"><i class="layui-icon">&#xe615;查看</i>
                        <%--<a href="javascript:void(0)" onclick="echChildrenSearch.delReport(${personInfo.id})">删除</a>--%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
        <ehr:pagination action="echChildrenSearch.manageSearch" colspan="6"/>
	</table>
</div>