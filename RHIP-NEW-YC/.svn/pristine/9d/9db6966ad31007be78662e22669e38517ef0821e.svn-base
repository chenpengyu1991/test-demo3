<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/reportList.js" type="text/javascript"></script>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
	        <col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 15%;"/>
            <col style="min-width:100px;width: 80px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>	
				<th>身份证号</th>
				<th>上报日期</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>	
			<c:forEach var="report" items="${reportList}" varStatus="status">
				<tr>
					<td title="${report.name}" class="centertd">${report.name}</td>
					<td class="centertd" title="<ehr:dic dicmeta="FS10006"  code="${report.gender}"/>">
						<ehr:dic dicmeta="FS10006"  code="${report.gender}"/>
					</td>
					<td class="centertd" title="<fmt:formatDate value="${report.birthday}" pattern="yyyy/MM/dd"/>">
						<fmt:formatDate value="${report.birthday}" pattern="yyyy/MM/dd"/>
					</td>
					<td class="centertd" title="${report.idcard}">${report.idcard}</td>
					<td class="centertd" title="<fmt:formatDate value="${report.fillTime}" pattern="yyyy/MM/dd"/>">
						<fmt:formatDate value="${report.fillTime}" pattern="yyyy/MM/dd"/>
					</td>
					<td class="centertd">
						<a href="javascript:void(0);"  onclick="occPatientReportList.view('${report.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="occPatientReportSearch.search" colspan="6"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="occPatientReportSearch.search"/>
		</tr>
	</table> --%>
</div>