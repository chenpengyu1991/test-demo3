<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/css/views/ihm.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/views/font-awesome.min.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ihm/chartFun2.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/js/util/bootstrap-box.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/equipment/main2.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
	require(['views/ihm/baseTarget/equipment/main'], function(equipment) {
		equipment.load();
	})
</script> -->
<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">基础资源</a>
			        <a>
			          <cite>
			           设备资源
			          </cite></a>
			      </span>
			</div>
</div>
<div id="inquiry" style="width: 98%;padding-right: 15px;margin-top: 5px;">
	<div id="equipmentMain">
		<b class="jiandang">设备资源<a class="view" id="viewDetail"><b class="fenbu">查看详细</b></a></b>

		<table class="customTable" style="margin: 10px 15px 5px 5px">
			<colgroup>
				<col style="width: 70%; min-width: 300px;"/>
				<col style="width: 30%; min-width: 150px;"/>
			</colgroup>
			<tbody>
			<tr>
				<td  style="vertical-align:top;">
					<div id="equipmentChart" style="height: 450px;" >

					</div>
				</td>
				<td>
					<table>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-C23531" boxIcon="fa  fa-medkit"
												   id="equipmentNum" nameDisplay="10万元以下" unitDisplay="台"  url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-2F4554" boxIcon="fa  fa-medkit"
												   id="equipmentNumOne" nameDisplay="10万元~50万元" unitDisplay="台"   url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-61A0A8" boxIcon="fa  fa-medkit"
												   id="equipmentNumTwo" nameDisplay="50万元以上" unitDisplay="台"  url='' value=""/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<div id="detail" style="display:none">

	</div>
</div>
