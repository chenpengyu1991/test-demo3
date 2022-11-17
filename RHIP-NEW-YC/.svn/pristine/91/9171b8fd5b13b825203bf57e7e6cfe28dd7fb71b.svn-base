<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>  
<%@ page import="com.founder.rhip.portal.common.HospitalCodeForYC" %>
<c:set var="MATERNAL_CHILD_HOSPITAL" value="<%=HospitalCodeForYC.MATERNAL_CHILD_HOSPITAL.getHospitalCode()%>"/>
<script src="${pageContext.request.contextPath}/js/views/reserve/schedule.js" type="text/javascript"></script>
<div class="hospitalInfo_slideBox" style="position: relative;">
    <div class="slider_title">
        <div id="titles">
            <ul>
	            <li><a class="select">全部医生</a></li>
                <c:if test="${type eq '01' }">
	                <li><a class="">医院简介</a></li>
	                <li><a class="">就医指南</a></li>
	                <li><a class="">微导诊</a></li>
                </c:if>
                <c:if test="${type eq '02' && not empty hospitalInfo}">
	                <li><a class="">医院简介</a></li>
	                <li><a class="">就医指南</a></li>
	                <li><a class="">微导诊</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="hospitalInfo_detail" id="tabContent1_item0">
        <div id="titleContent1_item0_0">
        	<c:if test="${empty clinicList && type eq '01'}">
                <br><div style="color:#666">无科室！</div><br>
            </c:if>
            <c:if test="${not empty clinicList && type eq '01'}">
                <div class="select-condition">
                     <div class="select-detail clinic-list">
                        <label>科室:</label>
                        <ul id="depart-level1-ul-clinic" class="dropmenus select-clinic-list">
                            <!-- <li class="select-all-clinics select-cur" onclick="reserveschedule.selectOption(this,'clinic','')">全部</li> -->
                            <c:forEach var="clinics" items="${clinicList}">
                                 <li class="select-clinic" value = "${clinics.name}" onclick="reserveschedule.selectOption(this,'clinic','${clinics.deptSn}')">
                                         ${clinics.name}
                                 </li>
                            </c:forEach>
                        </ul>
                    </div>
                    
                    <c:if test="${MATERNAL_CHILD_HOSPITAL != hospitalCode }">
	                    <div id="clinicTypeID" class="select-detail mains-doctor"
	                         <c:if test="${type eq '01' }">style="display:none;border-top: 1px dashed rgb(234, 234, 234);"</c:if>>
	                        <label>号别:</label>
	                        <ul id="medtitle-ul" class="dropmenus">
	                            <li class="select-cur" onclick="reserveschedule.selectOption(this,'clinicType','')">全部</li>
	                            <li onclick="reserveschedule.selectOption(this,'clinicType','01')">普通号
	                            </li>
	                            <li onclick="reserveschedule.selectOption(this,'clinicType','02')">专家号</li>
	                        </ul>
	                    </div>
					</c:if>
					
                    <div class="select-detail mains-doctor"
                         style="border-top: 1px dashed rgb(234, 234, 234);">
                        <label>常用联系人:</label>
                        <ul id="depart-level1-ul" class="drop-menus">
                            <li style="text-align:left;">
                                <c:choose>
                                  <c:when test="${accountInfo.reserveStatus eq '0'}">
	                                  <span title="该用户已被禁止预约">
	                                  	<input type="radio" name="frequentContacts" id="accountInfo"
	                                        value="1" disabled="disabled"
	                                        onchange="reserveschedule.selectFrequentOption(this,'')">
	                                     	${accountInfo.realName}
	                                  </span>
                                  </c:when>
                                  <c:otherwise>
                                  	 <input type="radio" name="frequentContacts" id="accountInfo"
                                        value="1" checked="checked"
                                        onchange="reserveschedule.selectFrequentOption(this,'')">
                                  		${accountInfo.realName}
                                  </c:otherwise>
                                </c:choose>
                                <c:forEach var="frequentContacts" items="${frequentContactsList}">
                                   <c:choose>   
	                                  <c:when test="${frequentContacts.reserveStatus eq '0' }"> 
	                                  	 <span title="该用户已被禁止预约"> 
	                                      	<input type="radio" name="frequentContacts"
	                                                 value="${frequentContacts.id}" disabled="disabled"
	                                                 onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
	                                          ${frequentContacts.frequentName}
	                                      </span>
	                                  </c:when>
	                                  <c:when test="${frequentContacts.reserveStatus eq '1' && frequentContacts.frequentName eq thisFrequentName}">
	                                     	<input type="radio" name="frequentContacts"
	                                                value="${frequentContacts.id}" checked="checked"
	                                                onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
	                                         ${frequentContacts.frequentName}
	                                  </c:when>
	                                  <c:otherwise>
	                                      <input type="radio" name="frequentContacts"
	                                             value="${frequentContacts.id}"
	                                             onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
	                                      ${frequentContacts.frequentName}
	                                  </c:otherwise>
                              		</c:choose>
                                 </c:forEach>                           
                            </li>
                        </ul>
                    </div>
                    <div id="scheduleDiv"></div>
                </div>
                <script type="text/javascript">
				$("#flowChart").addClass("select-department-node"); 
				</script>
            </c:if>
            
            <%-- <c:if test="${type eq '02'}">
                <div class="select-condition">
                    <div class="select-detail mains-doctor"
                         <c:if test="${type eq '01' }">style="border-top: 1px dashed rgb(234, 234, 234);"</c:if>>
                        <label>号别:</label>
                        <ul id="medtitle-ul" class="dropmenus">
                            <c:choose>
                                <c:when test="${clinicType eq '01'}">
                                    <li onclick="reserveschedule.selectOption('clinicType','')">全部</li>
                                    <li class="select-cur"
                                        onclick="reserveschedule.selectOption('clinicType','01')">普通号
                                    </li>
                                    <li onclick="reserveschedule.selectOption('clinicType','02')">专家号</li>
                                </c:when>
                                <c:when test="${clinicType eq '02' }">
                                    <li onclick="reserveschedule.selectOption('clinicType','')">全部</li>
                                    <li onclick="reserveschedule.selectOption('clinicType','01')">普通号</li>
                                    <li class="select-cur"
                                        onclick="reserveschedule.selectOption('clinicType','02')">专家号
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="select-cur"
                                        onclick="reserveschedule.selectOption('clinicType','')">全部
                                    </li>
                                    <li onclick="reserveschedule.selectOption('clinicType','01')">普通号</li>
                                    <li onclick="reserveschedule.selectOption('clinicType','02')">专家号</li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>

                    <div class="select-detail mains-doctor"
                         style="border-top: 1px dashed rgb(234, 234, 234);">
                        <label>常用联系人:</label>
                        <ul id="depart-level1-ul" class="drop-menus">
                            <li style="text-align:left;">
                                <c:choose>
                                  <c:when test="${accountInfo.reserveStatus eq '0'}">
                                  <span title="该用户已被禁止预约">
                                  	<input type="radio" name="frequentContacts" id="accountInfo"
                                        value="1" disabled="disabled"
                                        onchange="reserveschedule.selectFrequentOption(this,'')">
                                     ${accountInfo.realName}
                                  </span>
                                  </c:when>
                                  <c:otherwise>
                                  	 <input type="radio" name="frequentContacts" id="accountInfo"
                                        value="1" checked="checked"
                                        onchange="reserveschedule.selectFrequentOption(this,'')">
                                  ${accountInfo.realName}
                                  </c:otherwise>
                                </c:choose>
                                <c:forEach var="frequentContacts" items="${frequentContactsList}">
                                   <c:choose>   
                                  <c:when test="${frequentContacts.reserveStatus eq '0' }"> 
                                  	 <span title="该用户已被禁止预约"> 
                                      	<input type="radio" name="frequentContacts"
                                                 value="${frequentContacts.id}" disabled="disabled"
                                                 onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
                                          ${frequentContacts.frequentName}
                                      </span>
                                  </c:when>
                                  <c:when test="${frequentContacts.reserveStatus eq '1' && frequentContacts.frequentName eq thisFrequentName}">
                                     	<input type="radio" name="frequentContacts"
                                                value="${frequentContacts.id}" checked="checked"
                                                onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
                                         ${frequentContacts.frequentName}
                                  </c:when>
                                  <c:otherwise>
                                      <input type="radio" name="frequentContacts"
                                             value="${frequentContacts.id}"
                                             onchange="reserveschedule.selectFrequentOption(this,'${frequentContacts.id}')">
                                      ${frequentContacts.frequentName}
                                  </c:otherwise>
                              </c:choose>
                                 </c:forEach>                           
                            </li>
                        </ul>
                    </div>
                    <div id="scheduleDiv"></div>
                </div>
                <script type="text/javascript">
				$("#flowChart").addClass("select-hospital-num-node"); 
				</script>
            </c:if> --%>
        </div>
        <div id="titleContent1_item0_1" style="display:none;">
            <c:choose>
				<c:when test="${not empty hospitalInfo.hospitalInfo}">
					<h1 class="info_title">医院概况：</h1>
					<div class="info_content">${hospitalInfo.hospitalInfo}
					</div>
				</c:when>
				<c:otherwise>
					<h1 class="info_title">无</h1>
				</c:otherwise>
			</c:choose>
        </div>

        <div id="titleContent1_item0_2" style="display:none;">
            <c:choose>
				<c:when test="${not empty hospitalInfo.guideForMedical}">
					<h1 class="info_title">就医指南：</h1>
					<div class="info_content">${hospitalInfo.guideForMedical}
					</div>
				</c:when>
				<c:otherwise>
					<h1 class="info_title">无</h1>
				</c:otherwise>
			</c:choose>
        </div>
        <div id="titleContent1_item0_3" style="display:none;">
            <c:choose>
				<c:when test="${not empty hospitalInfo.microGuidance}">
					<h1 class="info_title">微导诊：</h1>
					<div class="info_content">${hospitalInfo.microGuidance}
					</div>
				</c:when>
				<c:otherwise>
					<h1 class="info_title">无</h1>
				</c:otherwise>
			</c:choose>
        </div>
    </div>
</div>
