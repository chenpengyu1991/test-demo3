<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 18%;"/>
			<col style="min-width:40px;width: 11%;"/>
			<col style="min-width:40px;width: 9%;"/>
			<col style="min-width:40px;width: 18%;"/>
	        <col style="min-width:50px;width: 9%;"/>
	        <col style="min-width:40px;width: 14%;"/>
	        <col/>
	        <col style="min-width:50px;width: 8%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>受理编码</th>
                <th>受理类型</th>
                <th>受理人</th>
                <th>开始受理时刻</th>
                <th>患者姓名</th>
				<th>呼救电话</th>
				<th>病种判断</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.acceptNo}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.acceptType}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.assignee}</ehr:tip></td>
					<td class="centertd"><fmt:formatDate value="${result.beginTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
					<td class="centertd"><ehr:tip>${result.patName}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.fromCall}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.diseaseDiscribe}</ehr:tip></td>
					<td class="centertd">
						<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
						   onclick="firstAidSearch.viewAcceptEvent('${result.acceptNo}')">
							<i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			 <ehr:pagination action="firstAidSearch.search" />
		</tr>
	</table>
</div>