<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">

<style>
<!--
/* #basic_content_div{height: 580px;width: 98%;} */
-->
</style>

<%-- <script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/header.js" type="text/javascript"></script>
<div id="banner">
	<c:if test="${empty doctorSetMap}">
    	<span><a class="pop_ba01 ehrbrowser-menu" href="<c:url value="/ehrbrowser/basic"/> "></a></span>
    </c:if>
    <c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '2')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '3')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '4')}">
	    <span><a class="pop_ba02 ehrbrowser-menu"href="<c:url value="/ehrbrowser/service"/> "></a></span>
	 </c:if>
	 <c:if test="${empty doctorSetMap}">
	    <span><a class="pop_ba03 ehrbrowser-menu" href="<c:url value="/ehrbrowser/health"/> "></a></span>
	    <span><a class="pop_ba04 ehrbrowser-menu" href="<c:url value="/ehrbrowser/management"/> "></a></span>
	</c:if>
	
</div> --%>




<%-- <c:if test="${empty external}">
<div class="toolbar" style="margin-top: 10px;">
<c:if test="${empty region}">
<a href="javascript:void(0)"  onclick="personRecordPagination.returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>
<c:if test="${not empty region}">
<c:if test="${empty cdm}">
	<a href="javascript:void(0)"  onclick="returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>
<c:if test="${not empty cdm}">
	<a href="javascript:void(0)"  onclick="returnSearchCdm()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>
</c:if>
</div>
</c:if> --%>


<c:if test="${empty external}">

<c:if test="${empty region}">
    <div class="toolbar" style="margin-top: 10px;">
        <a href="javascript:void(0)"  onclick="personRecordPagination.returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </div>
</c:if>

<c:if test="${not empty region}">

<c:if test="${empty cdm}">
    <div class="toolbar" style="margin-top: 10px;">
    <a href="javascript:void(0)"  onclick="returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </div>
</c:if>

<%--<c:if test="${not empty cdm}">
	<a href="javascript:void(0)"  onclick="returnSearchCdm()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>--%>
</c:if>
</c:if>


<div class="layui-tab layui-tab-brief" lay-filter="ehrIndex">
  <ul class="layui-tab-title">
    <li class="layui-this">基本资料</li>
    <c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '2')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '3')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '4')}">
    <li>医疗服务</li>
    </c:if>
    <c:if test="${empty doctorSetMap}">
    <li>妇幼保健</li>
    <li>疾病管理</li>
    </c:if>
<%--        <ehr:authorize ifAnyGranted="${idmBrwRoleStr}">--%>
        <li>疾病控制</li>
<%--    </ehr:authorize>--%>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show"  id="base_info"></div>
    <c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '2')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '3')
      || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '4')}">
    <div class="layui-tab-item" id="medical_service" ></div>
    </c:if>
    <c:if test="${empty doctorSetMap}">
    <div class="layui-tab-item" id="maternity_child_care" ></div>
    <div class="layui-tab-item" id="disease_management" ></div>
    </c:if>
<%--    <ehr:authorize ifAnyGranted="${idmBrwRoleStr}">--%>
        <div class="layui-tab-item" id="disease_control" ></div>
<%--    </ehr:authorize>--%>
  </div>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(ehrIndex)', function(data){
      if (data.index == 0) {
    	  $("#base_info").html("");
    	  $("#medical_service").html("");
    	  $("#maternity_child_care").html("");
    	  $("#disease_management").html("");
          $("#disease_control").html("");
    	  loadContent("/ehrbrowser/basic", {personId:$("#ehrbrowser_person_id_input").val(),viewType:"ehr"}, "base_info");
      } else if(data.index == 1) {
    	  $("#base_info").html("");
    	  $("#medical_service").html("");
    	  $("#maternity_child_care").html("");
    	  $("#disease_management").html("");
          $("#disease_control").html("");
    	  var param = {
              personId: $("#ehrbrowser_person_id_input").val(),
              doctorSetMap : $("#doctorSetMap").val(),
              doctorType : $("#doctortype").val()
          }
    	  loadContent("/ehrbrowser/service", param, "medical_service");
    	  
      }  else if(data.index == 2) {
    	  $("#base_info").html("");
    	  $("#medical_service").html("");
    	  $("#maternity_child_care").html("");
    	  $("#disease_management").html("");
          $("#disease_control").html("");
    	  loadContent("/ehrbrowser/health", {personId:$("#ehrbrowser_person_id_input").val()}, "maternity_child_care");
      } else if(data.index == 3) {
    	  $("#base_info").html("");
    	  $("#medical_service").html("");
    	  $("#maternity_child_care").html("");
    	  $("#disease_management").html("");
          $("#disease_control").html("");
    	  loadContent("/ehrbrowser/management", {personId:$("#ehrbrowser_person_id_input").val()}, "disease_management");
      } else if(data.index == 4) {
        $("#base_info").html("");
        $("#medical_service").html("");
        $("#maternity_child_care").html("");
        $("#disease_management").html("");
        $("#disease_control").html("");
        loadContent("/ehrbrowser/control", {personId:$("#ehrbrowser_person_id_input").val()}, "disease_control");
      }
  });
});

$(function() {
	$("#base_info").html("");
	$("#medical_service").html("");
	$("#maternity_child_care").html("");
	$("#disease_management").html("");
	loadContent("/ehrbrowser/basic", {personId:$("#ehrbrowser_person_id_input").val(),viewType:"ehr"}, "base_info");
});

function loadContent(url, param, divId) {
	$.loadHtmlByUrl({
        url: url,
        param: param,
        insertDiv: divId
    });
}

function returnSearch() {
	$("#detailDiv").empty();
	$("#top_all").show();
	$("#list_datagrid").show();
	$("#per_search_btn").click();
}

function returnSearchCdm() {
	$("#ehrDetailDiv").empty();
	$("#dm-followup-main").show();
}
</script>