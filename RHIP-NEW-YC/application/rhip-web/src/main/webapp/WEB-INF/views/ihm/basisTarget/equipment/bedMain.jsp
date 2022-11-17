<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/css/views/ihm.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/views/font-awesome.min.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ihm/chartFun2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/equipment/bedMain2.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/ihm/baseTarget/equipment/bedMain'], function(bedMain) {
		bedMain.load();
	})
</script> --%>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">基础资源</a>
			        <a>
			          <cite>
			           床位资源
			          </cite></a>
			      </span>
			</div>
</div>

<div id="inquiry" style="width: 98%;padding-right: 15px;margin-top: 5px;">
	<div id="bedMain">
		<b class="jiandang">床位资源<a class="view" id="viewDetail"><b class="fenbu">查看详细</b></a></b>

		<table class="customTable" style="margin: 10px 15px 5px 5px">
			<tbody>
			<tr>
				<td style="vertical-align:top;">
					<table>
						<colgroup>
							<col style="width: 25%;"/>
							<col style="width: 25%; "/>
							<col style="width: 25%; "/>
							<col style="width: 25%; "/>
						</colgroup>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-red" boxIcon="fa  fa-bed"
												   id="bedCount" nameDisplay="核准床位数" unitDisplay="张" style="background-color:#c23531 !important" url='' value=""/>
							</td>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-blue" boxIcon="fa  fa-bed"
												   id="openBedCount" nameDisplay="开放床位数" unitDisplay="张" style="background-color:#2f4554 !important" url='' value=""/>
							</td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td  style="vertical-align:top;">
					<div id="bedChart" style="height: 500px;" >

					</div>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<div id="detail" style="display:none">

	</div>
</div>
