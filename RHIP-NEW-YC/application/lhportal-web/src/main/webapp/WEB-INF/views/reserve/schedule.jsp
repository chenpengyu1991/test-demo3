<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/views/accountInfo/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/reserve/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/reserve/schedule.js" type="text/javascript"></script>
<div class="navRight">
    <div class="location">
    <c:if test="${type eq '01' }">
	             当前位置:<label>预约挂号</label>&gt;&gt;<label>按医院预约</label>
    </c:if>
    <c:if test="${type eq '02' }">
    	当前位置:<label>预约挂号</label>&gt;&gt;<label>按科室预约</label>
    </c:if>
    </div>
    <%-- <input id="type" name="type" value="${type}" type="hidden"/> --%>
   <%--  <c:if test="${type eq '01' }">
	    <div id="reserve_search" class="reserve_search">
	        <div class="s_search">
	            <i class="g_icon g_sicon"></i>
	            <input id="searchContent" class="search_input" type="text" placeholder="输入科室名称"
	                   name="searchContent" style="color: rgb(153, 153, 153);">
	            <input id="btn_reserve_search" type="button" class="btn_search" value="搜 索">
	        </div>
	    </div>
    </c:if> --%>
    <div id="reserveSelect" class="reserveSelect">
        <form id="scheduleSearch" autocomplete="off"> 
            <input id="hospital" name="hospital" value="${hospitalInfo.hospitalNo}" type="hidden"/>
            <input id="clinic" name="clinic" value="${clinic.deptSn}" type="hidden"/>
            <input id="deptName" name="deptName" value="${deptName }" type="hidden"/>
            <input id="clinicName" name="clinicName" value="${clinic.name}" type="hidden"/>
            <input id="clinicType" name="clinicType" value="${clinicType}" type="hidden"/>
            <input id="frequent" name="frequent" value="${frequent.id}" type="hidden"/>
            <input id="type" name="type" value="${type}" type="hidden"/>
        </form>
		<c:if test="${type eq '01' }">
	        <div class="hospitalInfo_detail">
	            <div class="select-condition">
	                <div class="select-detail">
	                    <label>医院:</label>
	                    <c:if test="${not empty hospitalInfoList}">
	                        <ul id="depart-level1-ul-hospital" class="dropmenus" style="margin-bottom: 0px;width: 790px;">
	                            <c:forEach var="hospital" items="${hospitalInfoList}">
	                            	 <li onclick="reserveschedule.selectOption(this,'hospital','${hospital.hospitalNo}')">
	                                        ${hospital.hospitalName}
	                                </li>
	                            </c:forEach>
	                        </ul>
	                    </c:if>
	                </div>
	            </div>
	        </div>
		    <div id="showJinggao" class="jinggaoInfo">请先择医院！</div>
          <script type="text/javascript">
		    $("#flowChart").addClass("select-hospital-node"); 
		    </script>
    	</c:if>
    	<c:if test="${type eq '02' }">
    		<div style="background-image:url('${pageContext.request.contextPath}/css/images/unworking.jpg');
    			background-repeat: no-repeat;background-position: center; height:400px;width:700px">
    		</div>
    	</c:if>
    <%-- <c:if test="${type eq '02' }">
        <div class="hospitalInfo_detail">
            <div class="select-condition">
                <div class="select-detail clinic-list"
                style="border-bottom: 1px solid rgb(234, 234, 234);">
                    <label>科室:</label>
                    <c:if test="${not empty DeptNameList}">
                        <ul id="depart-level1-ul" class="dropmenus select-clinic-list">
                            <c:forEach var="dept" items="${DeptNameList}">
                            	<c:choose>
                                    <c:when test="${dept.deptName == deptName}">
                                        <li class="select-cur select-clinic" 
                                            onclick="reserveschedule.selectOption('deptName','${dept.deptName}')">
                                                ${dept.deptName}
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="select-clinic" onclick="reserveschedule.selectOption('deptName','${dept.deptName}')">
                                       		${dept.deptName}
                                		</li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </c:if>
                </div>
                  <script type="text/javascript">
		    		$("#flowChart").addClass("select-clinic-node"); 
		  		  </script>  
	            <c:if test="${not empty hospitalList}">
	                <div class="select-detail">
	                    <label>医院:</label>
	                        <ul id="depart-level1-ul" class="dropmenus" style="margin-bottom: 0px;width: 790px;">
	                        	<c:choose>
	                                <c:when test="${empty hospitalInfo.hospitalName}">
	                                    <li class="select-cur select-all-clinics"
	                                        onclick="reserveschedule.selectOption('hospital','')">全部
	                                    </li>
	                                </c:when>
	                                <c:otherwise>
	                                    <li class="select-all-clinics" onclick="reserveschedule.selectOption('hospital','')">全部</li>
	                                </c:otherwise>
	                            </c:choose>
	                            <c:forEach var="hospital" items="${hospitalList}">
	                            	<c:choose>
	                                    <c:when test="${hospital.hospitalCode == hospitalInfo.hospitalNo}">
	                                        <li class="select-cur"
	                                            onclick="reserveschedule.selectOption('hospital','${hospital.hospitalCode}')">
	                                       		${hospital.hospitalName}
	                                        </li>
	                                    </c:when>
	                                    <c:otherwise>
	                                        <li onclick="reserveschedule.selectOption('hospital','${hospital.hospitalCode}')">
	                                       		${hospital.hospitalName}
	                                		</li>
	                                    </c:otherwise>
                                	</c:choose>
	                            </c:forEach>
	                        </ul>
	                </div>
	            </c:if>
	         </div>
        </div>
		    <div id="showJinggao" class="jinggaoInfo">请先择科室！</div>
    	</c:if> --%>
    	<div id="scheduleClinicDiv"></div>
		<%-- <jsp:include page="scheduleShowHospitalInfo.jsp"/> --%>
    </div>
    <div id="reserveSearchList"></div>
</div>
