<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/personRecord/verify/list.js" type="text/javascript"></script>
<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
        	<col style="width:5%;"/>
            <col style="width:8%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:5%;"/>
            <col style="width:8%;"/>
            <col style="width:10%;"/>
            <col style="width:14%;">
            <col style="width:10%;"/>
            <col style="width:10%;">
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
					<th>现住址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${personInfoList}" var="personInfo" varStatus="status"> 
					<tr>
					    <td style="text-align:center">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>					    </td>
						<td title="${personInfo.name}" style="text-align:left" >${personInfo.name}</td>
						<td title="${personInfo.idcard}" style="text-align:center">${personInfo.idcard}</td>
						<td title="${personInfo.birthday}" style="text-align:center"><fmt:formatDate value="${personInfo.birthday}" pattern="yyyy-MM-dd"/> </td>
						<td title="${personInfo.gender}" style="text-align:center">
						<c:choose>
								<c:when test="${personInfo.gender==1}">
									男
								</c:when>
								<c:when test="${personInfo.gender==2}">
									女
								</c:when>
							</c:choose>		
						</td>
						<td title="${personInfo.nation}" style="text-align:center"><ehr:dic dicmeta="GBT3304" code="${personInfo.nation}"/></td>
						<td title="${personInfo.phoneNumber}" style="text-align:center">${personInfo.phoneNumber}</td>
						<td title="${personInfo.pahouseNumber}" style="text-align:center">${personInfo.pahouseNumber}</td>
						<td title="${personInfo.filingFlag}" style="text-align:center">
						<c:choose>
								<c:when test="${personInfo.filingFlag==0}">
									未建档
								</c:when>
								<c:when test="${personInfo.filingFlag==1}">
									已建档
								</c:when>
								<c:when test="${personInfo.filingFlag==3}">
									已退回
								</c:when>
								<c:when test="${personInfo.filingFlag==4}">
									无身份证
								</c:when>
								<c:when test="${personInfo.filingFlag==2}">
									待审核
								</c:when>
							</c:choose>		
						</td>
						<td style="text-align:center">
							<c:choose>
								<c:when test="${personInfo.filingFlag==2}">
									<a href="#" onclick="verifyList.check(${personInfo.id},'check')">审核</a>
									<a href="#" onclick="verifyList.doCheck(${personInfo.id})">快速审核</a>
								</c:when>
								<c:otherwise>
									<a href="#" onclick="verifyList.check(${personInfo.id},'view')">查看</a>		
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
