<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/ihmIndex.css"/>
<script type="text/javascript">
	require(['views/uthealth/user/userDetail'],function(userDetail){
		userDetail.load();
	});
</script>
<div class="postcontent">
	<input type="hidden" id="userId" value="${userId}"/>
	<div class="toolbar">
		<a href="javascript:void(0)" id="returnSearch"><b class="fanhui">返回</b></a>
	</div>
	<table  border="0" align="center" cellpadding="0" cellspacing="0">
		<colgroup>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
		</colgroup>
		<tr>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">血糖</b>
					<div id="chartBG" style="height: 270px;"></div>
				</div>
			</td>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">血压</b>
					<div id="chartBP" style="height: 270px;padding-left:15px"></div>
				</div>
			</td>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">血氧心率体温</b>
					<div id="chartOHT" style="height: 270px;"></div>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">水分和油分</b>
					<div id="chartWO" style="height: 270px;"></div>
				</div>
			</td>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">呼吸率</b>
					<div id="chartBF" style="height: 270px;"></div>
				</div>
			</td>
			<td>
				<div id="inquiry" style="height:330px;width:100%;display:inline;float:left;">
					<b style="padding-left:5px">心电</b>
					<div id="chartECG" style="height: 270px;"></div>
				</div>
			</td>
		</tr>
	</table>
</div>
