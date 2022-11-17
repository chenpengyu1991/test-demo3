<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-15
  Time: 下午4:14
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<%--<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/archiveManagement.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/ihm/cardTarget/cardIndex.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js" type="text/javascript"></script>

<div class="toolbar">
   <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">疾病控制</a>
		        <a>
		          <cite>
		          报卡监控统计
		          </cite></a>
		      </span>
		</div>
</div>
<div class="main_PS" style="width: 99%;">
    <div id="mainContent" style="width:99%;">

        <div id="inquiry" style="height:325px;" >
            <b class="jiandang">报卡监控统计
            <a class="view" id="viewReportCardMonitor" href="javascript:void(0);">查看详细</a>
                <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
					<div class="layui-input-block">
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" />
                            &nbsp;<i style="margin-top:0px;">当月</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3" />
                            &nbsp;<i style="margin-top:0px;">当年</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="100"  checked="checked"  />
                            &nbsp;<i style="margin-top:0px;">累积</i></label>
					</span>
					</div>
                </i>
            </b>
            <div id="cardMonitorChart" style="height: 280px;width: 98%;" ></div>
        </div>

        <!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><br class="clearfloat" />
    </div>
    <div id="reportCardMonitorList"></div>
</div>


