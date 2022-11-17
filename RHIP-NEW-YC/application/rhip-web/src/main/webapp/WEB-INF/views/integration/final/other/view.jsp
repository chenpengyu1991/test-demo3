<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%--<script src="${pageContext.request.contextPath}/js/jquery/jquery_fixedtablehead.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/views/integration/other.js" type="text/javascript"></script>--%>
<%--<script type="text/javascript">--%>
<%--<!----%>
	<%--$(function() {--%>
		<%--$("#front_machine_btn").trigger("click");--%>
	<%--});--%>
<%--//-->--%>
<%--</script>--%>
<script type="text/javascript">
	require(['views/integration/other'],function(other){
		other.load();
	});
</script>

<div class="sectionnoborder">
	<ul id="tags">
		<li class=selectTag><a style="width: 53px;" id="drug_category_btn" href="javascript:void(0)">药品目录</a></li>
		<li><a style="width: 53px;" id="transport_btn" href="javascript:void(0)">外送监控</a></li>
		<li><a style="width: 78px;" id="medicalGoods_btn" href="javascript:void(0)">医药卫生用品</a></li>
		<li><a style="width: 35px;" id="bloodStation_btn" href="javascript:void(0)">血站</a></li>
		<li><a style="width: 53px;" id="data120_btn" href="javascript:void(0)">120数据</a></li>
	</ul>
	
	<div id="tagContent">
		<div id="tagContent1" class="selectTag">
			<jsp:include page="drug_search_form.jsp"></jsp:include>
			<div id="drug_category_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent6" style="display: none;">
			<div id="medical_statistics_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent7" style="display: none;">
			<div id="transport_statistics_content" style="height: 400px;" >
				<div style="margin-left: 20px;margin-top: 20px;">
					请访问连接：<a target="blank" href="http://192.168.50.202:8080/FRLIS/">常熟市区域检验信息平台</a>
					<br />
					用户名：wsjk
					<br />
					密码：wsjk
				</div>
			</div>
		</div>
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