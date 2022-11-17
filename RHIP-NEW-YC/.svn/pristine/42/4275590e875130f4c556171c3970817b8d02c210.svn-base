<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/reserve/list.js" type="text/javascript"></script>
<c:if test="${empty reserveRegisters}">
    <label style="text-align:center; font-size:15px;">
        无预约记录！
    </label>
</c:if>
<c:if test="${not empty reserveRegisters}">
<div class="stauts-color-tip">
<div><div>尚未到诊：</div><div class="stauts-color-red">•</div></div>
<div><div>已到诊：</div><div class="stauts-color-green">•</div></div>
<div><div>逾期未到诊：</div><div class="stauts-color-orange">•</div></div>
<div><div>已取消：</div><div class="stauts-color-grey">•</div></div>
<div><div>已停诊：</div><div class="stauts-color-stop">•</div></div>
</div>
    <div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-title-item" style="width:20%;">
                <span>医院</span>
            </div>
            <div class="contact-title-item" style="width:20%;">
                <span>科室</span>
            </div>
            <div class="contact-title-item" style="width:9%;">
                <span>医生</span>
            </div>
            <div class="contact-title-item" style="width:9%;">
                <span>就诊者</span>
            </div>
            <div class="contact-title-item"  style="width:17%;">
                <%-- <img src="${pageContext.request.contextPath}/images/reserve/icon-time.png"> --%>
                <span>就诊时间</span>
            </div>
            <div class="contact-title-item" style="width:7%;">
                <span>状态</span>
            </div>
            <div class="contact-title-item" style="width:18%;">
                <span>操作</span>
            </div>
        </div>
        <ul>
            <c:forEach items="${reserveRegisters }" var="reserveRegister" varStatus="status">
                <li>
                    <div class="contact-content">
                        <div title="${reserveRegister.hospitalName}" class="contact-item-info" style="width:20%;">
                                ${reserveRegister.hospitalName}
                        </div>
                        <div title=" ${reserveRegister.deptName }" class="contact-item-info" style="width:20%;">
                                ${reserveRegister.deptName }
                        </div>
                        <div class="contact-item-info"  style="width:9%;">
                                ${reserveRegister.doctorName}
                        </div>
                        <div class="contact-item-info"  style="width:9%;">
                                ${reserveRegister.name}
                        </div>

                        <div class="contact-item-info" style="width:17%;">
                           <div class="appointment-day">
                               <span><fmt:formatDate value="${reserveRegister.requestDate}" pattern="EEEE"/></span>
						       <span><fmt:formatDate value='${reserveRegister.requestDate}' pattern='yyyy/MM/dd'/></span>
                           </div>
                           <div class="appointment-time">
                               <span>
									<c:if test="${reserveRegister.ampm eq 'a'}">上午</c:if>
									<c:if test="${reserveRegister.ampm eq 'p'}">下午</c:if>
							  </span>
                              <span>${reserveRegister.timeIntervalStart}-${reserveRegister.timeIntervalEnd}</span>
                           </div>
                           
                            <%-- <ul>
                                <li>
                                    <span class="appointment-day"><fmt:formatDate value="${reserveRegister.requestDate}"
                                                                                  pattern="EEEE"/></span>
									<span>
										<fmt:formatDate value='${reserveRegister.requestDate}' pattern='yyyy/MM/dd'/>
									</span><br/>
									<span style="margin-top:10px">
										<c:if test="${reserveRegister.ampm eq 'a'}">上午</c:if>
										<c:if test="${reserveRegister.ampm eq 'p'}">下午</c:if>
									</span>
                                    <span>${reserveRegister.timeIntervalStart}~${reserveRegister.timeIntervalEnd}</span>
                                </li>
                            </ul> --%>
                        </div>

                        <div class="contact-item-info" style="width:7%;">
									<div class="appointment-stauts">
										<c:choose>
                                            <c:when test="${reserveRegister.reserverStauts == '01'}">
                                               <div class="stauts-color-red">•</div>
                                                <%-- <a onclick="reserveList.cancel('${reserveRegister.id}')">取消预约</a><br/> --%>
                                                 
                                            </c:when>
                                            <c:otherwise>
                                              <c:if test="${reserveRegister.reserverStauts == '02'}"><div class="stauts-color-green">•</div></c:if>
                                              <c:if test="${reserveRegister.reserverStauts == '03'}"><div class="stauts-color-orange">•</div></c:if>
                                              <c:if test="${reserveRegister.reserverStauts == '04'}"><div class="stauts-color-grey">•</div></c:if>
                                              <c:if test="${reserveRegister.reserverStauts == '05'}"><div class="stauts-color-stop">•</div></c:if>
                                            </c:otherwise>
                                        </c:choose>
									</div>
                        </div>
                        <div class="contact-item-info" style="width:18%;">
                             
                       	    <input  class="list-edit-btn" type="button" value="查看" onclick="reserveList.view('${reserveRegister.id}')"/>
                       	    <c:if test="${reserveRegister.reserverStauts == '01'}"><input  class="list-cancel-btn" type="button" value="取消" onclick="reserveList.cancel('${reserveRegister.id}')"/></c:if>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <ehr:pagination action="reserveSearch.search"/>
    </div>
</c:if>
