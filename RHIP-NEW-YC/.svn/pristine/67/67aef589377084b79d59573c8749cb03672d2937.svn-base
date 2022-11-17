<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-27
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="repeattable">
     <table id="person_record_table" style="width:98%;">
                <colgroup>
                    <col style="width:10%;"/>
                    <col style="width:30%;"/>
                    <col style="width:30%;"/>
                    <col style="width:25%;"/>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>停诊开始时间</th>
                    <th>停诊结束时间</th>
                    <th>停诊状态</th>
                </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach items="${stopDoctorDetails}" var="stopDoctor" varStatus="status">
                    <tr>
                        <td style="text-align:center">
                            <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }"
                                               pageSize="${page.pageSize }"></ehr:serial-number>
                        </td>
                        <td style="text-align:center">
                            <fmt:formatDate value='${stopDoctor.startDate}' pattern='yyyy/MM/dd'/>
                        </td>
                        <td style="text-align:center">
                            <fmt:formatDate value='${stopDoctor.endDate}' pattern='yyyy/MM/dd'/>
                        </td>
                        <td style="text-align:center">
                            <c:choose>
                                <c:when test="${stopDoctor.stopingStatus == '1'}">停诊</c:when>
                                <c:when test="${stopDoctor.stopingStatus == '0'}">已取消</c:when>
                                <c:otherwise>已过期</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <!-- 实现分页功能 -->
     </table>
 </div>
