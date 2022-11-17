<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 20%" />
		<col style="width: 20%" />
		<col style="width: 20%" />
		<col style="width: 20%" />
		<col style="width: 20%" />
	</colgroup>
	<thead>
		<tr>
			<th>体检日期</th>
			<th>体检机构</th>
			<th>体检编号</th>
			<th>责任医生</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="healthExamination" items="${healthExaminations}">
			<tr>
				<td>
					<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${healthExamination.examinationDate}"/> </ehr:tip>
				</td>
				<td>
					<ehr:tip><ehr:org code="${healthExamination.hospitalCode}" /></ehr:tip>
				</td>
				<td>${ healthExamination.physicalExamCode}</td>
				<td>
					<ehr:tip><ehr:staff-name staffCode="${healthExamination.manaDoctorId}"></ehr:staff-name> </ehr:tip>
				</td>
				<td>
				<a class="view-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" title="查看" style="color: #FFF;" data-ehrid="${healthExamination.ehrId}" data-personid="${healthExamination.personId}"><i class="layui-icon" >&#xe615;</i>查看</a>&nbsp;
				<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
					<a title="修改" class="edit-link layui-btn layui-btn-xs button" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-ehrid="${healthExamination.ehrId}"  data-personid="${healthExamination.personId}" ><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
					<a title="删除" class="delete-link layui-btn layui-btn-danger layui-btn-xs"  href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-ehrid="${healthExamination.ehrId}"  data-personid="${healthExamination.personId}" ><i class="layui-icon">&#xe640;</i>删除</a>
				</ehr:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<ehr:pagination action="cmdPersonPhyExaminationList.search" colspan="5" />
</table>