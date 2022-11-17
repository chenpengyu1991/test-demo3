<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/page.css" />

<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/ehrTarget/searchChart.js" type="text/javascript"></script>
<div class="main_PS" style="width: 99%;" id="chartDivId">
    <div id=mainContent style="width:99%;">
        <div id="inquiry" style="height:98%;">
            <b class="jiandang">健康档案调阅统计
                <a class="view" onclick="javascript:communityDistribution.showSearchJsp()" href="javascript:void(0);">查看详细</a>
                <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" id="RadioGroup5_" checked/>
                            &nbsp;<i style="margin-top:0px;">当月</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3" id="RadioGroup5_"/>
                            &nbsp;<i style="margin-top:0px;">当年</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" id="RadioGroup5_"/>
                            &nbsp;<i style="margin-top:0px;">累积</i></label>
					</span>
                </i>
            </b>
            <div id="healthReadChart" style="height: 98%;width: 98%;" ></div>
        </div>
    </div>
</div>
<div id="searchDivId"></div>