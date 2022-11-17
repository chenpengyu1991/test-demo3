<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/js/views/oh/enterprise/add.js" type="text/javascript"></script>

<div id="con" class="sectionnoborder">
	<div class="layui-tab layui-tab-brief" lay-filter="ohEnterpriseTab" style="width: 98%;margin-left: 8px;">
		<ul class="layui-tab-title">
			<li class="layui-this" id="enterprise_info_btn" href="javascript:void(0)">企业基本信息</li>
			<li id="condition_btn" href="javascript:void(0)">职业卫生情况</li>
			<li id="chemicals_used_btn" href="javascript:void(0)">使用化学物质</li>
			<li id="contact_situation_btn" href="javascript:void(0)">危害因素接触</li>
			<li id="equipment_btn" href="javascript:void(0)">主要生产设备</li>
			<li id="test_items_btn" href="javascript:void(0)">监测点示意图</li>
			<!-- <li><a id="" href="javascript:void(0)">监测结果</a></li>
			<li><a id="" href="javascript:void(0)">健康检查结果</a></li> -->
		</ul>

		<div id="tagContent"  class="layui-tab-content">
			<div id="tagContent0" class="layui-tab-item layui-show" >
				<jsp:include page="enterpriseInfo.jsp"></jsp:include>
			</div>
			<div id="tagContent1" class="layui-tab-item" >
				<%-- <jsp:include page="recordSear chForm.jsp"></jsp:include> --%>
				<div id="record_statistics_con" style="height: 450px;overflow: auto" ></div>
				<div id="record_statistics_chart" style="display: none;height: 450px;overflow: auto;" >
				</div>
			</div>
			<div id="tagContent2" class="layui-tab-item" ></div>
			<div id="tagContent3" class="layui-tab-item" ></div>
			<div id="tagContent4" class="layui-tab-item" ></div>
			<div id="tagContent5" class="layui-tab-item" ></div>
		</div>
		<input type="hidden" id="type" value="${type}">
	</div>
</div>