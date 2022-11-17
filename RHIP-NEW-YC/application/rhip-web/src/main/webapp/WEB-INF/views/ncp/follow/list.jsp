<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<style type="text/css">
     
</style>
<div >
<table id="ncpFollowList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 11%;" />
		<col style="width: 7%;" />
		<col style="width: 6%" />
		<col style="width: 4%" />
		<col style="width: 13%" />
		<col style="" />

		<col style="" />
		<col style="width:11%;" />
		<col style="" />
		<%--<col style="" />--%>
		<col style="width: 5%" />
		<col style="width: 5%" />
		<col style="" />
	</colgroup>
	<thead>
		<tr>
			<th>类型</th>
			<th>临床分型</th>
			<th>姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>出生日期</th>

			<th>联系电话</th>
			<th>管理机构</th>
			<th>出院日期</th>
			<%--<th>人群分类</th>--%>
			<th>健康评价</th>
			<th>复查状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="follow" items="${followList}" varStatus="status">
			<tr>
				<td>
					<ehr:dic dicmeta="NCP00003" code="${follow.patientType}" />
					<c:if test="${not empty follow.zlType}">
						(<ehr:dic dicmeta="NCP00011" code="${follow.zlType}" />)
					</c:if>
				</td>
				<td>
					<c:if test="${follow.clinicalClass=='1'}"> <span style="font-size:28px;color:#00CC00;">●</span></c:if>
					<c:if test="${follow.clinicalClass=='2'}"> <span style="font-size:28px;color:#0000FF;">●</span></c:if>
					<c:if test="${follow.clinicalClass=='3'}"> <span style="font-size:28px;color:#FF9900;">●</span></c:if>
					<c:if test="${follow.clinicalClass=='4'}"> <span style="font-size:28px;color:#FF0000;">●</span></c:if>
					<ehr:tip><ehr:dic dicmeta="NCP00001" code="${follow.clinicalClass}"/> </ehr:tip></td>
				<td><a title="查看管理卡信息" class="view-link" href="javascript:void(0)" data-disid="${follow.id}">${follow.name}</a></td>
				<td><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${follow.sex}"/></ehr:tip></td>
				<td><ehr:ehrBrwLink  personId="${follow.personId}">${follow.cardno}</ehr:ehrBrwLink></td>
				<td><div style="text-align: center;padding-right: 13px"><ehr:tip><fmt:formatDate value="${follow.birthday }" pattern="yyyy/MM/dd"/></ehr:tip></div></td>

				<td><ehr:tip>${follow.tel}</ehr:tip></td>
				<td><ehr:tip><ehr:org code="${follow.managementOrg}"/></ehr:tip></td>
				<td><div style="text-align: center;padding-right: 13px"><ehr:tip><fmt:formatDate value="${follow.dischargeDate }" pattern="yyyy/MM/dd"/></ehr:tip></div></td>
			<%--	<td><ehr:tip><ehr:dic dicmeta="FS990023" code="${follow.populationCategory}"/></ehr:tip></td>--%>
				<td><div style="text-align: center;padding-right: 13px"><font color="${follow.healthStatus eq '2'?'red':''}"><ehr:tip><ehr:dic dicmeta="NCP00004" code="${follow.healthStatus}"/></ehr:tip></font></div></td>
				<td><div style="text-align: center;padding-right: 13px"><ehr:tip><ehr:dic dicmeta="NCP00005" code="${follow.reexamineStatus}"/></ehr:tip></div></td>
				<td>
					<%--<ehr:authorize ifAnyGranted="${ZXXG},${ZXG},${JKXG}">--%>
						<%-- <a class="monitor-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${monitorType}" data-pid="${follow.personId}">监测</a> --%>
						<a class="monitor-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${monitorType}" data-pid="${follow.personId}" title="监测"><i class="layui-icon">&#xe60a;</i></a>
						<%-- <a class="reexam-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${reexamType}" data-pid="${follow.personId}">复查</a> --%>
						&nbsp;
						<a class="reexam-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${reexamType}" data-pid="${follow.personId}" title="复查"><i class="layui-icon">&#xe6b2;</i></a>
						<%-- <a class="follow-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${followType}" data-pid="${follow.personId}">随访</a> --%>
						&nbsp;
						<a class="follow-link" href="javascript:void(0)" data-id="${follow.id}" data-type="${followType}" data-pid="${follow.personId}" title="随访"><i class="layui-icon">&#xe60e;</i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
  <tr>
  	<ehr:pagination action="ncpFollowSearch.search" />
  </tr>
</table>
</div>

