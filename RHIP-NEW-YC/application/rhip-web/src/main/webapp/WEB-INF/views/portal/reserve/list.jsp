<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/portal/reserve/list.js" type="text/javascript"></script>

<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
            <col style="width:8%;"/>
            <col style="width:5%;"/>
            <col style="width:12%;"/>
		    <col style="width:21%;"/>
            <col style="width:6%;"/>
            <col style="width:14%;"/>
			<col style="width:9%;"/>
			<col style="width:7%;"/>
			<col style="width:8%;"/>
        </colgroup>
			<thead> 
				<tr>
			        <th>操作日期</th>
					<th>姓名</th>
					<th>身份证</th>
					<th>医院科室</th>
					<th>预约专家</th>
					<th>预约日期</th>
					<th>取号时间</th>
					<th>状态</th>
					<th>操作</th>
			   </tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${reserveRegisters}" var="reserveRegister" varStatus="status"> 
					<tr>
						<td style="text-align:center">
							<fmt:formatDate value='${reserveRegister.submitDate}' pattern='yyyy/MM/dd'/>
						</td>
						<td title="${reserveRegister.name}" style="text-align:left">
							${reserveRegister.name}
						</td>
						<td title="${reserveRegister.idcard}" style="text-align:left">
							${reserveRegister.idcard}
						</td>
						<td title="${reserveRegister.hospitalName} -- ${reserveRegister.deptName}" style="text-align:left">
							${reserveRegister.hospitalName} -- ${reserveRegister.deptName}
						</td>
						<td title="${reserveRegister.doctorName}" style="text-align:left">
							${reserveRegister.doctorName}
						</td>
						<td style="text-align:center" >
							<fmt:formatDate value='${reserveRegister.requestDate}' pattern='yyyy/MM/dd'/>
								${reserveRegister.timeIntervalStart} -- ${reserveRegister.timeIntervalEnd}
						</td>
						<td style="text-align:center" >
								${reserveRegister.takeNoTimeStart} -- ${reserveRegister.takeNoTimeEnd}
						</td>
						<td style="text-align:center">
							<tag:reserveStauts stauts="${reserveRegister.reserverStauts}"/>
						</td>
						<td style="text-align:center">
							<a href="javascript:void(0)" onclick="reserveList.view('${reserveRegister.id}')">查看</a>
                            <c:if test="${reserveRegister.reserverStauts == '01'}">
                                <a href="javascript:void(0)" onclick="reserveList.print('${reserveRegister.id}')">打印</a>
                            </c:if>
                            <ehr:authorize ifAnyGranted="17,27">
							<c:if test="${reserveRegister.reserverStauts == '01'}">
								<a href="javascript:void(0)" onclick="reserveList.cancel('${reserveRegister.id}')">取消</a>
							</c:if>
							</ehr:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<ehr:paging action="reserveSearch.search"/>
		<!-- 实现分页功能 -->
</div>
