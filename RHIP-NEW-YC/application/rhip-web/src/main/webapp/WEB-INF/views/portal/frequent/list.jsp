<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<!-- CDC 主页面查询结果 -->
<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="person_record_table">
        <colgroup>
         	<col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:20%;"/>
            <col style="width:7%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:23%;"/>
        </colgroup>
			<thead> 
				<tr>
					<th>姓名</th>
					<th>移动电话</th>
					<th>身份证号</th>
					<th>性别</th>
					<th>预约状态</th>		
					<th>隶属用户</th>				
					<th>操作</th>
				</tr>
			</thead>
			<!-- 遍历接种记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${frequent}" var="frequent" varStatus="status"> 
					<tr>
						<td title="${frequent.frequentName}" style="text-align:center">${frequent.frequentName}</td>
						<td title="${frequent.telephone}" style="text-align:center">${frequent.telephone}</td>
						<td title="${frequent.cardNo}" style="text-align:center">${frequent.cardNo}</td>
						<td style="text-align:center"><ehr:tip><ehr:dic dicmeta="GBT226112003" code = "${frequent.gender}"/></ehr:tip></td>
						<td style="text-align:center">
							<ehr:tip><ehr:dic dicmeta="LH00006" code="${frequent.reserveStatus}"/></ehr:tip>
							</td>
						<td title="${frequent.realName}" style="text-align:center">${frequent.realName}</td>
						<td style="text-align:center">
									<%-- <a href="#this" onclick="frequentSearch.viewFrequent(${frequent.id})">查看</a> --%>
									<c:if test="${frequent.reserveStatus==0}">
										<a href="#this" onclick="frequentSearch.enableReserveFrequent(${frequent.id})">启用预约</a>
									</c:if>
									<c:if test="${frequent.reserveStatus==1}">
										<a href="#this" onclick="frequentSearch.disableReserveFrequent(${frequent.id})">禁用预约</a>
									</c:if>
									<%-- <a href="#this" onclick="frequentSearch.deleteFrequent(${frequent.id})">删除</a> --%>
						    
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<ehr:paging action="frequentSearch.frequentSearch"/>
</div>
