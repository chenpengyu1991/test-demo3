<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-14
  Time: 下午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/views/portal/stop/list.js" type="text/javascript"></script>

<div class="repeattable">
    <table id="stopDoctor_record_table">
        <colgroup>
            <col style="width:6%"/>
            <col style="width:15%;"/>
           	<col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="width:12%;"/>
            <col style="width:12%;"/>
            <col style="width:8%;"/>
			<col style="width:15%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>医生姓名</th>
            <th>医院名称</th>
            <th>科室名称</th>
            <th>停诊开始时间</th>
            <th>停诊结束时间</th>
            <th>停诊状态</th>
			<th>操作</th>
        </tr>
        </thead>
        <!-- 遍历服务信息类别记录 -->
        <tbody class="tbody">
        <c:forEach items="${stopDoctorRecords}" var="record" varStatus="status">
            <tr>
                <td style="text-align:center"><ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number></td>
                <td>${record.doctorName}</td>
                <td>
                	<ehr:org code="${record.hospitalCode}"></ehr:org>
                </td>
                <td>${record.deptName}</td>
                <td>
                	<c:if test="${record.stopingStatus == '1'}">
						<fmt:formatDate value="${record.startDate}" pattern='yyyy/MM/dd'/>
					</c:if>
                </td>
                <td>
                	<c:if test="${record.stopingStatus == '1'}">
						<fmt:formatDate value="${record.endDate}" pattern='yyyy/MM/dd'/>
					</c:if>
                </td>
                <td style="text-align: center">
                    <c:choose>
                        <c:when test="${record.stopingStatus == '1'}">已停诊</c:when>
                        <c:otherwise>未停诊</c:otherwise>
                    </c:choose>
                <td style="text-align: center">
                	 <ehr:authorize ifAnyGranted="17,27">
						<c:choose>
							<c:when test="${record.stopingStatus == '1'}">
								<a href="javascript:void(0);" onclick="stopDetialH.cancelStop('${record.id}')">取消</a>
							</c:when>
							<c:otherwise>
		                           <a href="javascript:void(0);" onclick="stopDetialH.Stop('${record.doctorName}','${record.doctorSn}',
		                                   '${record.deptSn}','${record.deptName}','${record.hospitalCode}')">停诊</a>
							</c:otherwise>
						</c:choose>
					</ehr:authorize>
               		<a href="javascript:void(0);" onclick="stopDetialH.viewStop(1,'${record.doctorName}','${record.doctorSn}',
                        '${record.deptSn}','${record.deptName}','${record.hospitalCode}')">停诊记录</a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ehr:paging action="stopSearch.search"/>
</div>

