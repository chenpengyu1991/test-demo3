<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/hospitalInfoList.js" type="text/javascript"></script>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        	<col style="width:4%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:26%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:12%;"/>
            <col style="width:13%;"/>
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>医院名称</th>
					<th>档案号</th> 
					<th>地址</th> 
					<th>医院级别</th>
					<th>档案更新时间</th>
					<th>审核状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record" varStatus="status"> 
					<tr>
					    <td class="centertd">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
					    </td>
						<td title="${record.hospitalName}">${record.hospitalName}</td>
						<td title="${record.fileNo}">${record.fileNo}</td>
						<td title="${record.addr}">${record.addr}</td>
						<td class="centertd"><ehr:dic dicmeta="DM02-02" code="${record.hLevel }"></ehr:dic></td>
						<td class="centertd" title="${record.updateTime}" >
						    <c:choose>
						        <c:when test="${not empty record.updateTime}">
						            <fmt:formatDate value="${record.updateTime}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
						</td>
						<td class="centertd">
						    <ehr:dic dicmeta="CV0900103" code="${record.verifyState }"></ehr:dic>
						</td>
						<td class="centertd">
							<a href="javascript:void(0);"  onclick="listRecord.viewRecord('${record.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
							<c:if test="${record.verifyState!='1'&&record.verifyState!='2'}">
						        <ehr:authorize ifAnyGranted="0123">
									<a href="javascript:void(0);"  onclick="listRecord.check('${record.id}')" title="审核" ><i class="layui-icon">&#xe672;</i></a>&nbsp;&nbsp;

								</ehr:authorize>
							</c:if>
						    <!-- 已审核 -->
						    <c:if test="${record.verifyState=='1'}">
							    <ehr:authorize ifAnyGranted="0123">
							   <!--  审核 -->
									<a href="javascript:void(0);"  onclick="listRecord.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
									<a href="javascript:void(0);"  onclick="listRecord.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;&nbsp;
							    </ehr:authorize>
						    </c:if> 
						    <c:if test="${record.verifyState!='1' }">
						    	<ehr:authorize ifNotGranted="01">
								<a href="javascript:void(0);"  onclick="listRecord.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
								<a href="javascript:void(0);"  onclick="listRecord.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
								</ehr:authorize>
						    </c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="mainPage.search" colspan="8"/>
	</table>
</div>
