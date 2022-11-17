<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/css/views/ihm.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/views/font-awesome.min.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/ihm/baseTarget/organization/main'], function(main) {
		main.load();
	})
</script>

<div id="inquiry" style="width: 98%;padding-right: 15px;">
	<div id="orgMain">
		<b class="jiandang">医疗机构</b>

		<table class="customTable" style="margin: 10px 15px 5px 5px">
			<colgroup>
				<col style="width: 70%; min-width: 300px;"/>
				<col style="width: 30%; min-width: 150px;"/>
			</colgroup>
			<tbody>
			<tr>
				<td  style="vertical-align:top;">
					<div id="orgChart" style="height: 450px;" >

					</div>
				</td>
				<td>
					<table>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-green" boxIcon="fa fa-hospital-o"
												   id="A1_ORG" nameDisplay="综合医院" unitDisplay="个"  url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-yellow" boxIcon="fa fa-user-md"
												   id="B1_ORG" nameDisplay="社区卫生服务中心" unitDisplay="个"   url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-blue" boxIcon="fa fa-stethoscope"
												   id="B2_ORG" nameDisplay="社区卫生服务站" unitDisplay="个"  url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-red" boxIcon="fa fa-plus-square"
												   id="D400_ORG" nameDisplay="医务室" unitDisplay="个"  url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-aqua" boxIcon="fa fa-plus-square"
												   id="L_ORG" nameDisplay="卫生监督检验" unitDisplay="个"  url='' value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<ehr:bootstrap-box boxType="small-box" boxBgCss="bg-red" boxIcon="fa fa-plus-square"
												   id="R2_ORG" nameDisplay="其他" unitDisplay="个"  url='' value=""/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

</div>
