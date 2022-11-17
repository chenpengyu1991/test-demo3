<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/css/views/ihm.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/views/font-awesome.min.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ihm/chartFun2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/main2.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/ihm/baseTarget/hr/main'], function(staff) {
		staff.load();
	})
</script> --%>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">基础资源</a>
			        <a>
			          <cite>
			           人力资源
			          </cite></a>
			      </span>
			</div>
</div>

<div id="inquiry" style="width: 98%;padding-right: 15px;margin-top: 5px;">
	<div id="staffMain">
		<b class="jiandang">人力资源<a class="view" id="viewDetail"><b class="fenbu">查看详细</b></a></b>

		<table class="customTable" style="margin: 10px 15px 5px 5px">
			<colgroup>
				<col style="width: 33%; min-width: 150px;"/>
				<col style="width: 33%; min-width: 150px;"/>
				<col style="width: 34%; min-width: 150px;"/>
			</colgroup>
			<tbody>
			<tr>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-C23531" boxIcon="fa fa-user"
									   id="CY_TYPE1" nameDisplay="卫生人员" unitDisplay="人"  url='' value=""/>
				</td>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-2F4554" boxIcon="fa fa-user-md"
									   id="CY_TYPE2" nameDisplay="卫生技术人员" unitDisplay="人"   url='' value=""/>
				</td>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-61A0A8" boxIcon="fa fa-stethoscope"
									   id="CY_TYPE3" nameDisplay="执业(助理)医师" unitDisplay="人"  url='' value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-D48265" boxIcon="fa fa-plus-square"
									   id="CY_TYPE4" nameDisplay="注册护士" unitDisplay="人"  url='' value=""/>
				</td>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-91C7AE" boxIcon="fa fa-users"
									   id="CY_TYPE5" nameDisplay="卫生监督员" unitDisplay="人"  url='' value=""/>
				</td>
				<td>
					<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-749F83" boxIcon="fa fa-user-secret"
									   id="CY_TYPE6" nameDisplay="管理人员" unitDisplay="人"  url='' value=""/>
				</td>
			</tr>
			<tr>
				<td  colspan="3" style="vertical-align:top;">
					<div id="staffChart" style="height: 350px;" >

					</div>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<div id="detail" style="display:none">

	</div>
</div>
