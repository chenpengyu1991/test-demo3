<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/add.js" type="text/javascript"></script>

<div id="con" class="sectionnoborder">
	<div class="layui-tab layui-tab-brief" lay-filter="ohOccPatientTab" style="width: 98%;margin-left: 8px;">
		<ul class="layui-tab-title">
			<li class="layui-this" id="employee_info_btn" href="javascript:void(0)">劳动者信息</li>
			<li id="companyInfo_btn" href="javascript:void(0)">用人单位信息</li>
		</ul>

		<div id="tagContent"  class="layui-tab-content">
			<div id="tagContent0" class="layui-tab-item layui-show">
				<%-- <jsp:include page="starSearchForm.jsp"></jsp:include> --%>
				<div id="star_statistics_con" style="height: 500px;overflow: auto" >
					<jsp:include page="employeeInfo.jsp"></jsp:include>
				</div>

			</div>
			<div id="tagContent1" class="layui-tab-item">
				<%-- <jsp:include page="recordSearchForm.jsp"></jsp:include> --%>
				<div id="record_statistics_con" style="height: 100%;overflow: auto" ></div>
				<div id="record_statistics_chart" style="display: none;height: 450px;overflow: auto;" >
				</div>
			</div>
<%--			<div id="tagContent2" class="layui-tab-item" ></div>--%>
<%--			<div id="tagContent3" class="layui-tab-item" ></div>--%>
<%--			<div id="tagContent4" class="layui-tab-item" ></div>--%>
<%--			<div id="tagContent5" class="layui-tab-item" ></div>--%>
		</div>
	</div>
</div>