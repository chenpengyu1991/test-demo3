<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:140px;width: 20%;"/>
	        <col style="min-width:120px;width: 10%;"/>
			<col style="min-width:140px;width: 10%;"/>
	        <%-- <col style="min-width:120px;width: 15%;"/> --%>
	        <col style="min-width:120px;width: 10%;"/>
	        <%-- <col style="min-width:120px;width: 10%;"/>
	        <col style="min-width:120px;width: 10%;"/> --%>
	        <col style="min-width:120px;width: 15%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>出库单号</th>
				<th>出库方式</th>
				<!-- <th>请领科室</th> -->
				<th>出库日期</th>
				<!-- <th>请领人</th>
				<th>经手人</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="consumableOut" items="${consumableOuts}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${consumableOut.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${consumableOut.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00007" code="${consumableOut.DELIVERY_TYPE_CODE}"/></ehr:tip></td>
                    <%-- <td><ehr:tip>${consumableOut.APPLY_DEPARTMENT}</ehr:tip></td> --%>                  
                    <td><ehr:tip><fmt:formatDate value="${consumableOut.DELIVERY_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <%-- <td><ehr:tip>${consumableOut.APPLY_USER_NAME}</ehr:tip></td>
                    <td><ehr:tip>${consumableOut.HANDLE_USER_NAME}</ehr:tip></td> --%>
                    <td>
						<a style="color: #FFF;font-size: 12px;"class="layui-btn layui-btn-xs" onclick="consumableOutSearch.detailSearch('${consumableOut.batch_No}')"><i class="layui-icon">&#xe615;</i>查看</a>
                    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="consumableOutSearch.search" colspan="5"/>
		    </tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="consumableOutSearch.search" />
		</tr>
	</table> --%>
</div>