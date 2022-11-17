<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>

<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 10%"/>
		<col style="width: 13%"/>
		<col style="width: 12%"/>
		<col style="width: 12%"/>
		<col style="width: 12%"/>
		<col style="width: 12%"/>
		<col style="width: 12%"/>
		<col style="width: 17%"/>
	</colgroup>
	<thead>
		<tr>
			<th>体检日期</th>
			<th>体检机构</th>
			<th>体检编号</th>
			<th>是否规范</th>
			<th>是否评估</th>
			<th>是否中医指导</th>
			<th>责任医生</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody style="text-align: center">
		<c:forEach var="phy" items="${phyList}">
			<tr>
				<td>
					<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${phy.examinationDate}"/> </ehr:tip>
				</td>
				<td>
					<ehr:tip><ehr:org code="${phy.examinationOrganCode}" /></ehr:tip>
				</td>
				<td><ehr:tip>${phy.physicalExamCode}</ehr:tip></td>
				<td><c:if test="${phy.criterionExamination eq 1}">是</c:if><c:if test="${phy.criterionExamination eq 0}">否</c:if></td>
				<td><c:if test="${phy.estimateStatus eq 1}">是</c:if><c:if test="${phy.estimateStatus eq 0}">否</c:if></td>
				<td><c:if test="${phy.healthGuideStatus eq 1}">是</c:if><c:if test="${phy.healthGuideStatus eq 0}">否</c:if></td>
				<td>
					<ehr:tip><ehr:staff-name staffCode="${phy.manaDoctorId}"></ehr:staff-name> </ehr:tip>
				</td>
				<td>
				<a class="view-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-ehrid="${phy.ehrId}" data-personid="${phy.personId}" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>
				<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
					<c:if test="${record.logoff == 0}">
						<a class="edit-link layui-btn layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-ehrid="${phy.ehrId}"  data-personid="${phy.personId}" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
						<a class="delete-link layui-btn phyexamhidedeletebtn layui-btn-danger layui-btn-xs"  href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-ehrid="${phy.ehrId}" data-personid="${phy.personId}" data-physicalExamCode="${phy.physicalExamCode}" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
					</c:if>
				</ehr:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<ehr:pagination action="hmPersonPhyExaminationList.search" colspan="8" />
</table>