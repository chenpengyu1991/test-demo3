<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/personRecord/verify/list_update.js" type="text/javascript"></script>
<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
        	<col style="width:5%;"/>
            <col style="width:10%;"/>
            <col style="width:20%;"/>
            <col style="width:10%;"/>
            <col style="width:5%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:20%;">
            <col style="width:10%;"/>
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>姓名</th>
					<th>身份证号</th> 
					<th>出生日期</th> 
					<th>性别</th>
					<th>民族</th>
					<th>本人电话号码</th>					
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${personInfoTempList}" var="personInfoTemp" varStatus="status"> 
					<tr>
					    <td style="text-align:center">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>					    </td>
						<td title="${personInfoTemp.name}" style="text-align:left" >${personInfoTemp.name}</td>
						<td title="${personInfoTemp.idcard}" style="text-align:center">${personInfoTemp.idcard}</td>
						<td title="${personInfoTemp.birthday}" style="text-align:center"><fmt:formatDate value="${personInfoTemp.birthday}" pattern="yyyy-MM-dd"/> </td>
						<td title="${personInfoTemp.gender}" style="text-align:center">
						<c:choose>
								<c:when test="${personInfoTemp.gender==1}">
									男
								</c:when>
								<c:when test="${personInfoTemp.gender==2}">
									女
								</c:when>
							</c:choose>		
						</td>
						<td title="${personInfoTemp.nation}" style="text-align:center"><ehr:dic dicmeta="GBT3304" code="${personInfoTemp.nation}"/></td>
						<td title="${personInfoTemp.phoneNumber}" style="text-align:center">${personInfoTemp.phoneNumber}</td>
						<td title="${personInfoTemp.filingFlag}" style="text-align:center">
						<c:choose>
								<c:when test="${personInfoTemp.filingFlag==0}">
									未核实
								</c:when>
								<c:when test="${personInfoTemp.filingFlag==1}">
									已核实
								</c:when>
							</c:choose>		
						</td>
						<td style="text-align:center">
							<c:choose>
								<c:when test="${personInfoTemp.filingFlag==0}">
									<a href="#" onclick="verifyUpdateList.check(${personInfoTemp.id},'check')">审核</a>
									<a href="#" onclick="verifyUpdateList.doCheck(${personInfoTemp.id})">快速审核</a>
								</c:when>
								<c:otherwise>
									<a href="#" onclick="verifyUpdateList.check(${personInfoTemp.id},'view')">查看</a>		
								</c:otherwise>
							</c:choose>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="verifySearch.search" colspan="10"/>
		<!-- 实现分页功能 -->
	</table>
</div>
