<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 12%;"/>
	        <col style="min-width:80px;width: 18%;"/>
			<col style="min-width:80px;width: 20%;"/>
	        <col/>
	        <col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>检查项目名称</th>
				<th>检查机构</th>
				<th>检查日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="outpatientInfo" items="${outpatientInfoList}" varStatus="status">
				<tr>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.name}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.idCard}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.inspectionItemName}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.hospitalName}</ehr:tip></td>
					<td style="text-align: center"><fmt:formatDate value="${outpatientInfo.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
					<td style="text-align: center">
					    <a title="查看门诊信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" onclick="emrSearch.inspectDetail('${outpatientInfo.id}','${outpatientInfo.personId}')"><i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="emrSearch.emrSearch" colspan="6"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="emrSearch.emrSearch"/>
		</tr>
	</table> --%>
</div>