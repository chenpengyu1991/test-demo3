<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/main.js" type="text/javascript"></script>
<%--<div id="ehrbrowser_basicinfo_toolbar">--%>
<%--<span id="basic_cover">封面</span> / <span id="basic_info">基本信息</span> / <span id="basic_physical_examination">体检表</span>--%>
<%--</div>--%>
<%--<div id="ehrbrowser_basicinfo_content">--%>
<%--</div>--%>

<%-- <DIV id=con>
    <UL id=tags>
        <LI class=selectTag >
            <A id="basic_cover_a" href="javascript:void(0)" style="width:88px">封面</A>
        </LI>
        <LI>
            <A id="basic_info_a" href="javascript:void(0)" style="width:88px">基本信息</A>
        </LI>
        <LI>
            <A id="basic_physical_examination_a" href="javascript:void(0)" style="width:88px">个人体检表</A>
        </LI>
        <LI>
            <A id="basic_reception_status_a" href="javascript:void(0)" style="width:88px">接诊记录表</A>
        </LI>
        <LI>
            <A id="basic_consultation_status_a" href="javascript:void(0)" style="width:88px">会诊记录表</A>
        </LI>
        <LI>
            <A id="basic_referral_status_a" href="javascript:void(0)" style="width:88px">双向转诊单</A>
        </LI>
        <c:if test="${isChild}">
            <li>
                <A id="basic_child_fimaly_interview_a" href="javascript:void(0)">新生儿家庭访视</A>
            </li>
        </c:if>
    </UL>
    <DIV id=tagContent style="height: 516px; overflow-y: auto;">
        <DIV class="tagContent selectTag" id="basic_cover"></DIV>
        <DIV class="tagContent" id="basic_info"></DIV>
        <DIV class="tagContent" id="basic_physical_examination"></DIV>
        <DIV class="tagContent" id="basic_child_fimaly_interview"></DIV>
        <DIV class="tagContent" id="basic_reception_status"></DIV>
        <DIV class="tagContent" id="basic_consultation_view"></DIV>
        <DIV class="tagContent" id="referral_info"></DIV>
    </DIV>
</DIV> --%>
<c:if test="${empty viewType}">
<div class="toolbar" style="margin-top: 10px;">
<c:if test="${empty region}">
<a href="javascript:void(0)"  onclick="personRecordPagination.returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>
<c:if test="${not empty region}">
<a href="javascript:void(0)"  onclick="returnSearch()"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</c:if>
</div>
</c:if>
<div class="layui-tab layui-tab-card" lay-filter="ehrBasic" id="basic_content_div" style="width:98%;margin-left:8px;
    overflow: auto;">
  <ul class="layui-tab-title">
    <li class="layui-this">封面</li>
    <li>基本信息</li>
    <li>个人体检表</li>
    <li>接诊记录表</li>
    <li>会诊记录表</li>
    <li>双向转诊单</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" id="basic_cover" style="overflow: auto;"></div>
    <div class="layui-tab-item" id="basic_info" style="overflow: auto;"></div>
    <div class="layui-tab-item" id="basic_physical_examination" style="overflow: auto;"></div>
    <div class="layui-tab-item" id="basic_reception_status" style="overflow: auto;"></div>
    <div class="layui-tab-item" id="basic_consultation_view" style="overflow: auto;"></div>
    <div class="layui-tab-item" id="referral_info" style="overflow: auto;"></div>
  </div>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(ehrBasic)', function(data){
      if (data.index == 0) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("cover","basic_cover");
      } else if(data.index == 1) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("info","basic_info");
      }  else if(data.index == 2) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("physicalExamination","basic_physical_examination");
      } else if(data.index == 3) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("getReceptionDate","basic_reception_status");
      } else if(data.index == 4) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("consultation","basic_consultation_view");
      } else if(data.index == 5) {
    	  $("#basic_cover").html("");
    	  $("#basic_info").html("");
    	  $("#basic_physical_examination").html("");
    	  $("#basic_reception_status").html("");
    	  $("#basic_consultation_view").html("");
    	  $("#referral_info").html("");
    	  ehrBrowserBasic.loadBasicHtml("referralInfo","referral_info");
      } 
  });
});

function returnSearch() {
	$("#detailDiv").empty();
	$("#top_all").show();
	$("#list_datagrid").show();
	$("#per_search_btn").click();
}
</script>