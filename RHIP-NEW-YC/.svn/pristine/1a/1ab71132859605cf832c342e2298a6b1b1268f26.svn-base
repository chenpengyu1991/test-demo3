<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/reserve/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hotExpert/search.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/hotExpert/hotExpertInfo.css" />

<div class="navHotExpLeft">
    <c:if test="${not empty hospitalNameList}">
    <div id="hotExpert_search" class="reserve_search">
        <div class="s_search">
            <i class="g_icon g_sicon"></i>
            <input id="searchContent" class="search_input" type="text" placeholder="输入医生姓名"
                   name="searchContent" style="color: rgb(153, 153, 153);">
            <input id="btn_hotExpert_search" type="button" class="btn_search" value="搜 索">
        </div>
    </div>
    <div class="hospitalInfo_detail">
       <div class="select-condition">
		    <form id="hotExpertSearch" autocomplete="off"> 
		        <input id="hospital" name="hospitalCode" value="${hospitalInfo.hospitalNo}" type="hidden"/>
		        <input id="clinic" name="deptSn" value="${clinic.deptSn}" type="hidden"/>
		        <input id="doctorSn" name="doctorSn" value="${doctorSns.doctorSn}" type="hidden"/>
		        <%-- <input id="empTit" name="empTit" value="${doctorSns.empTit}" type="hidden"/> --%>
		    </form>
           <div class="select-detail">
               <label>医院:</label>
                   <ul id="depart-level1-ul" class="dropmenus" style="margin-bottom: 0px;">
                   		<c:choose>
			                <c:when test="${empty hospitalInfo.hospitalName}">
			                    <li class="select-cur select-all-clinics"
			                        onclick="hotExpertSearch.selectOption('hospital','')">全部
			                    </li>
			                </c:when>
			                <c:otherwise>
			                    <li class="select-all-clinics" onclick="hotExpertSearch.selectOption('hospital','')">全部</li>
			                </c:otherwise>
		            	</c:choose>
                       <c:forEach var="hospital" items="${hospitalNameList}">
                           <c:choose>
                               <c:when test="${hospital.hospitalName == hospitalInfo.hospitalName}">
                                   <li class="select-cur"
                                       onclick="hotExpertSearch.selectOption('hospital','${hospital.hospitalCode}')">
                                           ${hospital.hospitalName}
                                   </li>
                               </c:when>
                               <c:otherwise>
                                   <li onclick="hotExpertSearch.selectOption('hospital','${hospital.hospitalCode}')">
                                           ${hospital.hospitalName}
                                   </li>
                               </c:otherwise>
                           </c:choose>
                       </c:forEach>
                   </ul>
           </div>
           
           <c:if test="${not empty clinicList }">
		    <div id="showClinic" class="select-detail clinic-list" style="border-top: 1px dashed rgb(234, 234, 234);">
		        <label>科室:</label>
		        <ul id="depart-level1-ul" class="dropmenus select-clinic-list" style="margin-bottom: 0px;width: 730px;">
		            <c:choose>
		                <c:when test="${empty clinic.deptName}">
		                    <li class="select-cur select-all-clinics"
		                        onclick="hotExpertSearch.selectOption('clinic','')">全部
		                    </li>
		                </c:when>
		                <c:otherwise>
		                    <li class="select-all-clinics" onclick="hotExpertSearch.selectOption('clinic','')">全部</li>
		                </c:otherwise>
		            </c:choose>
		            <c:forEach var="clinics" items="${clinicList}">
		                <c:choose>
		                    <c:when test="${clinic.deptName == clinics.deptName}">
		                        <li class="select-cur select-clinic"
		                            onclick="hotExpertSearch.selectOption('clinic','${clinics.deptSn}')">
		                                ${clinics.deptName}
		                        </li>
		                    </c:when>
		                    <c:otherwise>
		                        <li class="select-clinic" onclick="hotExpertSearch.selectOption('clinic','${clinics.deptSn}')">
		                                ${clinics.deptName}
		                        </li>
		                    </c:otherwise>
		                </c:choose>
		            </c:forEach>
		        </ul>
		    </div>
		    </c:if>
		    <%-- <c:if test="${not empty clinic.empTitName }">
		        <div id="showEmpTit" class="select-detail" style="border-top: 1px dashed rgb(234, 234, 234);">
	               <label>职称:</label>
	               <c:if test="${empty empList}">无职称！</c:if>
	               <c:if test="${not empty empList}">
	                   <ul id="depart-level1-ul" class="dropmenus" style="margin-bottom: 0px;width: 730px;">
	                   		<c:choose>
				                <c:when test="${empty empTits.empTitName}">
				                    <li class="select-cur select-all-clinics"
				                        onclick="hotExpertSearch.selectOption('empTit','')">全部
				                    </li>
				                </c:when>
				                <c:otherwise>
				                    <li class="select-all-clinics" onclick="hotExpertSearch.selectOption('empTit','')">全部</li>
				                </c:otherwise>
				            </c:choose>
	                       <c:forEach var="empList" items="${empList}">
	                           <c:choose>
	                               <c:when test="${empList.empTitName == empTits.empTitName}">
	                                   <li class="select-cur"
	                                       onclick="hotExpertSearch.selectOption('empTit','${empList.empTitCode}')">
	                                           ${empList.empTitName}
	                                   </li>
	                               </c:when>
	                               <c:otherwise>
	                                   <li onclick="hotExpertSearch.selectOption('empTit','${empList.empTitCode}')">
	                                           ${empList.empTitName}
	                                   </li>
	                               </c:otherwise>
	                           </c:choose>
	                       </c:forEach>
	                   </ul>
	               </c:if>
	           </div>
           </c:if> --%>
		</div>
   </div>
   <div id="showHotExpetLists"></div>
	</c:if>
	<c:if test="${empty hospitalNameList}">无热门专家！</c:if>
</div>
