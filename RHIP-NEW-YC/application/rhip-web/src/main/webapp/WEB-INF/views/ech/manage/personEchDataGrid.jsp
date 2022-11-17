<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>

<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="min-width:70px; width:10%;"/>
		<col style="min-width:70px; width:30%;"/>
		<col style="min-width:70px; width:10%;"/>
		<col style="min-width:70px; width:5%;"/>
		<col style="min-width:70px; width:15%;"/>
		<col style="min-width:70px; width:15%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>填表日期</th>
			<th>体质类型</th>
			<th>填表机构</th>
			<th>填表人</th>
			<th>已关联的体检</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="echIdentification" items="${echIdentifications}">
			<tr>
				<td>
					<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${echIdentification.createDate}"/> </ehr:tip>
				</td>
				<td>${echIdentification.tcmConclusion}</td>
				<td><ehr:tip><ehr:org code="${echIdentification.createOrg}" /></ehr:tip></td>
		  		<td><ehr:tip><ehr:user userCode="${echIdentification.createUser}"></ehr:user></ehr:tip></td>
				<td>
					<c:if test="${empty echIdentification.exams}">无</c:if>
					<c:forEach var="exam" items="${echIdentification.exams}">
						<fmt:formatDate pattern="yyyy/MM/dd" value="${exam.examinationDate}"/>（${exam.physicalExamCode }）<br>
					</c:forEach>
				</td>
				<td>
					<a class="view-link layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" data-id="${echIdentification.id}" data-personid="${echIdentification.personId}" data-type="view" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>
					<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
						<c:if test="${record.logoff == 0}">
							<a class="edit-link layui-btn layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-id="${echIdentification.id}" data-personid="${echIdentification.personId}" data-type="edit" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
							<a class="delete-link phyexamhidedeletebtn layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" data-id="${echIdentification.id}" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</ehr:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<ehr:pagination action="echIdenList.search" colspan="6" />
</table>