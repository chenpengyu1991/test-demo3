<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
			<col style="min-width:150px;width: 15%;"/>
	        <col style="min-width:80px;width: 20%;"/>
			<col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>			
				<th>姓名</th>
				<th>身份证号码</th>
				<th>住院号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="health" items="${healthlist}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip><ehr:org code="${health.hospitalCode}"/></ehr:tip></td>					
					<td class="centertd"><ehr:tip>${health.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${health.age}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${health.admissionNo}</ehr:tip></td>
					<td class="centertd">
						<a title="查看入院记录" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" onclick="emrSearch.loadDetailDialog('/inpatient/cindex/${health.id}', '病案首页','600','1000')"><i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="emrSearch.emrSearch" colspan="5"/>
		   </tr>
		</tbody>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="emrSearch.emrSearch"/>
		</tr>
	</table> --%>
</div>