<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/views/reserve/schedule.js" type="text/javascript"></script>
<c:if test="${not empty hospitalInfo}">
    <div class="hospitalInfo_lists">
        <ul>
            <li class="hospital-info-li">
                <div class="hospital-info">
                    <div class="hospital-pic">
                        <c:forEach items="${hosPicattches}" var="attche">
                            <c:choose>
                                <c:when test="${attche.resourceId eq hospitalInfo.id }">
                                    <img src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1"/>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <div class="hospital-introduces">
                        <div class="introduces-title">
                            <label>${hospitalInfo.hospitalName}</label>
                            <span class="hospital-sign">
                            	<ehr:dic code="${hospitalInfo.hospitalLevel}" dicmeta="DM02-02"/>
                            </span>
                        </div>
                        <table cellspacing="0" cellpadding="0">
                            <tr>
                                <td valign="top">医院电话：</td>
                                <td>${hospitalInfo.hospitalPhone }</td>
                            </tr>
                            <tr>
                                <td valign="top">医院地址：</td>
                                <td class="info-pos">
                                        ${hospitalInfo.hospitalAddress }
                                </td>
                            </tr>
                            <tr>
                                <td valign="top">医院网址：</td>
                                <td>
                                	<c:choose>
										<c:when test="${empty hospitalInfo.hospitalWebsite }">暂无</c:when>
										<c:otherwise>
											<a target="_blank" href="${hospitalInfo.hospitalWebsite }">${hospitalInfo.hospitalWebsite }</a>
										</c:otherwise>
									</c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top">挂号时间：</td>
                                <td>${hospitalInfo.registrationTime }</td>
                            </tr>
                            <c:if test="${hospitalInfo.isRegisteredHospital eq  1}">
							<tr>
								<td valign="top">提供服务：</td>
								<td class="server" valign="top">
									<i class="icon-order"></i>
									预约挂号
									<i class="fixed"></i>
								</td>
							</tr>
							</c:if>
							<c:if test="${not empty hospitalInfo.tips}">
							<tr>
								<td valign="top">友情提示：</td>
								<td class="server" valign="top">
									${hospitalInfo.tips }
								</td>
							</tr>
							</c:if>
                        </table>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <c:if test="${type eq '01'}">
		<jsp:include page="scheduleShowClinic.jsp"/>
	</c:if>
    <script type="text/javascript">
    $("#flowChart").addClass("select-department"); 
    </script>
</c:if>
<c:if test="${ not empty hospitalList && type eq '02'}">
    <jsp:include page="scheduleShowClinic.jsp"/>
</c:if>

