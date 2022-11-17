<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	require(['views/wsMonitor/log/view'],function(logView){
		logView.load();
	});
</script>

<div class="toolbar">
	<a href="javascript:void(0)" id="logBackId"><b class="fanhui">返回</b></a>
</div>
<div class="postcontent contentfixed32">
	<div class="postdiv">
		<fieldset style="margin-top: 10px">
			<legend>日志详细信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width: 80px; width: 15%;"/>
				<col style="min-width: 350px; width: 85%;"/>
				</colgroup>
			<tbody>
				<tr>
					<th>机构名称</th>
					<td style="text-align: left"><ehr:tip><ehr:org code="${logInfo.orgCode}"/></ehr:tip></td>
				</tr>
				<tr>
					<th>IP地址</th>
					<td style="text-align: left"><ehr:tip>${logInfo.userIp}</ehr:tip></td>
				</tr>
				<tr>
					<th>接口名称</th>
					<td style="text-align: left"><ehr:tip>${logInfo.webServiceName}</ehr:tip></td>
				</tr>
				<tr>
					<th>接口方法</th>
					<td style="text-align: left"><ehr:tip>${logInfo.wsMethodName}</ehr:tip></td>
				</tr>
				<tr>
					<th>请求开始时间</th>
					<td style="text-align: left"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${logInfo.startTime}"/></ehr:tip></td>
				</tr>
				<tr>
					<th>请求结束时间</th>
					<td style="text-align: left"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${logInfo.endTime}"/></ehr:tip></td>
				</tr>
				<tr>
					<th>成功标志</th>
					<td style="text-align: left"><ehr:dic dicmeta="FS990021" code="${logInfo.isSuccess}" /></td>
				</tr>
				<tr>
					<th>请求消息</th>
					<td style="text-align: left">
						<div>
							<a href="#this" id="requestMegId">查看详细</a>
						</div>
						<div id="requestMegSub">
							<xmp>${fn:substring(logInfo.requestMeg, 0, 20)}......</xmp>
						</div>
						<div id="requestMeg" style="display:none;word-wrap:break-word">
							<xmp>${logInfo.requestMeg}</xmp>
						</div>
					</td>
				</tr>
				<tr>
					<th>响应消息</th>
					<td style="text-align: left">
						<div>
							<a href="#this" id="responseMegId">查看详细</a>
						</div>
						<div id="responseMegSub">
							<xmp>${fn:substring(logInfo.responseMeg, 0, 20)}......</xmp>
						</div>
						<div id="responseMeg" style="display:none;word-wrap:break-word">
							<xmp>${logInfo.responseMeg}</xmp>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
			</fieldset>
	</div>

</div>
