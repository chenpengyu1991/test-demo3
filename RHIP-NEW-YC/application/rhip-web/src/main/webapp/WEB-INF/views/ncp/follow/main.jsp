<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/ncp/follow/main.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<div id="msgError" class="msgError" style="display: none;"></div>
<input type="hidden" id="ncp-follow-cardno"  value="${personInfo.idcard}" />
<input type="hidden" id="ncp-follow-personid"  value="${personInfo.id}" />
<input type="hidden" id="ncp-follow-ncpid"  value="${ncpid}" />
<input type="hidden" id="ncp-follow-type"  value="${type}" />
<input type="hidden" id="monitorType"  value="${monitorType}"/>
<input type="hidden" id="reexamType"  value="${reexamType}"/>
<input type="hidden" id="followType"  value="${followType}"/>

<div id="ncp-followup-main" style="margin-top: 10px;">
	<table>
		<tr>
			<td><jsp:include page="personInfo.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<%-- <ul id=tags>
						<li>
							<a id="monitor_btn" data-target="${monitorType}" href="javascript:void(0)">健康监测</a>
						</li>
						<li>
							<a id="reexam_btn" data-target="${reexamType}" href="javascript:void(0)">患者复查</a>
						</li>
						<li>
							<a id="follow_btn" data-target="${followType}" href="javascript:void(0)">追踪随访</a>
						</li>
				</ul>
				<div id="tagContent" style="width: 99.5%; height: 490px;">
					<div class="toolbar">
							<!-- <a href="javascript:void(0)" id="followup-back-btn"><b class="fanhui">返回</b></a> -->
							<a href="javascript:void(0)" id="followup-back-btn"><button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe65c;</i>返回</button></a>
							<!-- <a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a> -->
							<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe66d;</i>打印</button></a>
							<ehr:authorize ifAnyGranted="${ZXXG},${ZXG},${JKXG}">
								<!-- <a href="javascript:void(0);" id="followup-save-btn"><b class="baocun">保存</b></a> -->
								<a href="javascript:void(0);" id="followup-save-btn"><button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe605;</i>保存</button></a>
							</ehr:authorize>
						<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a>
					</div>
					<div class="tab-content" id="tagContent0">
						<jsp:include page="monitor/monitor.jsp"></jsp:include>
					</div>
					<div class="tab-content"  id="tagContent1" style="display: none;">
						<jsp:include page="monitor/monitor.jsp"></jsp:include>
					</div>
					<div class="tab-content"  id="tagContent2" style="display: none;">
						<jsp:include page="monitor/monitor.jsp"></jsp:include>
					</div>
				</div> --%>
				
				
				<div class="layui-tab layui-tab-card" lay-filter="ncpFollowupTab" style="width: 98%;margin-left: 8px;">
				  <ul class="layui-tab-title">
				    <li class="layui-this" id="healthMonitorTag">健康监测</li>
				    <li id="patientCheckTag">患者复查</li>
				    <li id="traceFollowupTag">追踪随访</li>
				  </ul>
				  <div class="layui-tab-content">
				  	<div class="toolbar" style="margin-top: -5px;">
							<!-- <a href="javascript:void(0)" id="followup-back-btn"><b class="fanhui">返回</b></a> -->
							<a href="javascript:void(0)" id="followup-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
							<!-- <a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a> -->
							<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
							<ehr:authorize ifAnyGranted="${ZXXG},${ZXG},${JKXG}">
								<!-- <a href="javascript:void(0);" id="followup-save-btn"><b class="baocun">保存</b></a> -->
								<a href="javascript:void(0);" id="followup-save-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
							</ehr:authorize>
						<%--<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a>--%>
					</div>
				    <div class="layui-tab-item layui-show" id="healthMonitorContent"><jsp:include page="monitor/monitor.jsp"></jsp:include></div>
				    <div class="layui-tab-item" id="patientCheckContent"></div>
				    <div class="layui-tab-item" id="traceFollowupContent"></div>
				  </div>
			  </div>

			</td>
		</tr>
	</table>
</div>
<script>
layui.use('element', function() {
  var element = layui.element;
  
  $("#healthMonitorTag").click(function() {
	   	if($("#healthMonitorTag").hasClass("layui-this")) {
	   		
	    } else if ($("#patientCheckTag").hasClass("layui-this")) {
	    	$("#healthMonitorContent").html($("#patientCheckContent").html());
	    	$("#patientCheckContent").html("");
	    } else if ($("#traceFollowupTag").hasClass("layui-this")) {
	    	$("#healthMonitorContent").html($("#traceFollowupContent").html());
	    	$("#traceFollowupContent").html("");
	    }
	  });
  
  $("#patientCheckTag").click(function() {
	   	if($("#patientCheckTag").hasClass("layui-this")) {
	   		
	    } else if ($("#healthMonitorTag").hasClass("layui-this")) {
	    	$("#patientCheckContent").html($("#healthMonitorContent").html());
	    	$("#healthMonitorContent").html("");
	    } else if ($("#traceFollowupTag").hasClass("layui-this")) {
	    	$("#patientCheckContent").html($("#traceFollowupContent").html());
	    	$("#traceFollowupContent").html("");
	    }
	  });
  
  
  $("#traceFollowupTag").click(function() {
	   	if($("#traceFollowupTag").hasClass("layui-this")) {
	   		
	    } else if ($("#healthMonitorTag").hasClass("layui-this")) {
	    	$("#traceFollowupContent").html($("#healthMonitorContent").html());
	    	$("#healthMonitorContent").html("");
	    } else if ($("#patientCheckTag").hasClass("layui-this")) {
	    	$("#traceFollowupContent").html($("#patientCheckContent").html());
	    	$("#patientCheckContent").html("");
	    }
	  });
  
  element.on('tab(ncpFollowupTab)', function(data){
      if (data.index == 0) {
    	  ncpFollowupEdit.load1($("#monitorType").val());
      } else if(data.index == 1) {
    	  ncpFollowupEdit.load1($("#reexamType").val());
      } else if(data.index == 2) {
    	  ncpFollowupEdit.load1($("#followType").val());
      } 
  });
});
</script>