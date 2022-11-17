<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 10%;"/>
			<col style="min-width:40px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:80px;width: 10%;"/>	
	        <col style="min-width:60px;width: 10%;"/>
	        <col style="min-width:80px;width: 10%;"/>		
		</colgroup>	
		<thead>
			<tr>
				<th>ABO血型</th>
				<th>RH血型</th>
				<th>采血日期</th>
				<th>制备日期</th>
				<th>失效日期</th>
				<th>区域</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip>${result.abotype}</ehr:tip></td>
					<td class="centertd">
                        <c:choose>
                            <c:when test="${empty result.rhtype}">
                            </c:when>
                            <c:when test="${result.rhtype eq '**D**'}">
                                阳性
                            </c:when>
                            <c:when test="${result.rhtype eq '不详'}">
                                不详
                            </c:when>
                            <c:when test="${result.rhtype eq '未查'}">
                                未查
                            </c:when>
                            <c:otherwise>
                                阴性
                            </c:otherwise>
                        </c:choose>
                    </td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.dontime}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.proctime}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.exptime}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.branch}</ehr:tip></td>
					<td class="centertd">
						<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
						   onclick="bloodSearch.viewbloodBank('${result.id}')">
							<i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			 <ehr:pagination action="bloodSearch.search" />
		</tr>
	</table>
</div>