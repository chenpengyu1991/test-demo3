<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	if (document.location.href.indexOf("home/index") >= 0) {
		require(['../views/integration/integration'],function(integration){
			 integration.load();
		 });
	}
</script>
<script data-main="${pageContext.request.contextPath}/js/util/main_integration" src="${pageContext.request.contextPath}/js/require/require.js"></script>
<c:if test="${not empty currentUser}">

<div class="toolbar">
    <a href="javascript:void(0)" id="monitor_config"><b class="xiug">提醒设置</b></a>
</div>
</c:if>
<div class="sectionnoborder">
	<ul id="tags">
		<li class=selectTag><a style="width: 65px;"  id="front_machine_btn" href="javascript:void(0)">前置机运行</a></li>
		<li><a style="width: 53px;" id="hospital_medical_btn" href="javascript:void(0)">院内数据</a></li>
		<li><a style="width: 79px;" id="medical_statistics_btn" href="javascript:void(0)">医疗数据统计</a></li>
		<li><a style="width: 53px;" id="physical_exam_btn" href="javascript:void(0)">体检数据</a></li>
		<li><a style="width: 53px;" id="drug_category_btn" href="javascript:void(0)">药品目录</a></li>
		<li><a style="width: 53px;" id="plan_immu_btn" href="javascript:void(0)">计免数据</a></li>
		<li><a style="width: 53px;" id="women_children_btn" href="javascript:void(0)">妇幼数据</a></li>
		<!--<li><a style="width: 53px;" id="transport_btn" href="javascript:void(0)">外送监控</a></li>-->
		<li><a style="width: 78px;" id="medicalGoods_btn" href="javascript:void(0)">医药卫生用品</a></li>
		<li><a style="width: 35px;" id="bloodStation_btn" href="javascript:void(0)">血站</a></li>
		<li><a style="width: 53px;" id="data120_btn" href="javascript:void(0)">120数据</a></li>
	</ul>
	
	<div id="tagContent">
		<div id="tagContent0" class="selectTag" >
			<jsp:include page="front_machine_search_form.jsp"></jsp:include>
			<div id="front_machine_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent1" style="display: none;">
			<jsp:include page="drug_search_form.jsp"></jsp:include>
			<div id="drug_category_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent2" style="display: none;">
			<jsp:include page="hospital_medical_search_form.jsp"></jsp:include>
			<div id="hospital_medical_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent3" style="display: none;">
			<jsp:include page="plan_immu_search_form.jsp"></jsp:include>
			<div id="plan_immu_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent4" style="display: none;">
			<jsp:include page="women_children_search_form.jsp"></jsp:include>
			<div id="women_children_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent5" style="display: none;">
			<jsp:include page="physical_exam_search_form.jsp"></jsp:include>
			<div id="physical_examination_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent6" style="display: none;">
			<div id="medical_statistics_content" style="height: 400px;" ></div>
		</div>
		<%--<div id="tagContent7" style="display: none;">--%>
			<%--<div id="transport_statistics_content" style="height: 400px;" >--%>
				<%--<div style="margin-left: 20px;margin-top: 20px;">--%>
					<%--请访问连接：<a target="blank" href="http://192.168.50.202:8080/FRLIS/">常熟市区域检验信息平台</a>--%>
					<%--<br />--%>
					<%--用户名：wsjk--%>
					<%--<br />--%>
					<%--密码：wsjk--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
        <div id="tagContent8" style="display: none;">
            <jsp:include page="medicalGoods_search_form.jsp"></jsp:include>
            <div id="medicalGoods_content" style="height: 400px;" ></div>
        </div>
        <div id="tagContent9" style="display: none;">
            <jsp:include page="bloodStation_search_form.jsp"></jsp:include>
            <div id="bloodStation_content" style="height: 400px;" ></div>
        </div>
        <div id="tagContent10" style="display: none;">
            <jsp:include page="data120_search_form.jsp"></jsp:include>
            <div id="data120_content" style="height: 400px;" ></div>
        </div>
	</div>
</div>