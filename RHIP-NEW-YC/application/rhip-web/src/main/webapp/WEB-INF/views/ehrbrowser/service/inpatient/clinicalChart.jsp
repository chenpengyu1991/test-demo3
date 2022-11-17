<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>临床图表</title>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/inpatient/chart.js" type="text/javascript"></script>

</head>
<body>
	<div style="padding: 5px;margin: 5px;">
		<c:set var="inpatientInfo" value="${clinicalChartBasicInfo.inpatientInfo}" scope="request">
		</c:set>
			<fieldset class="layui-elem-field">
			<legend>
			<span>患者信息</span></legend>
			<table class="layout_table" style="width: 99%;">
				<tr>
					<td style="width:10%">姓名</td>
					<td style="width:10%"><c:out value="${inpatientInfo.name}"></c:out></td>
					<td style="width:10%" >性别</td>
					<td style="width:10%" >	<ehr:dic dicmeta="GBT226112003" code="${inpatientInfo.gender}"></ehr:dic></td>
					<td style="width:10%" >年龄</td>
					<td style="width:10%" ><c:out value="${inpatientInfo.age}"></c:out></td>
					<td style="width:10%" >入院日期</td>
					<td style="width:10%" ><fmt:formatDate value="${inpatientInfo.inhosDate}" pattern="yyyy/MM/dd" /></td>
					<td>
					<c:if test="${not empty inpatientInfo.id }">
								<a title="住院摘要" id="inpatient_summary_btn" href="<c:url  value="/inpatient/summary/${inpatientInfo.id}"  />">住院摘要</a>
					</c:if>
					</td>
				</tr>
				<tr>
					<td>出院日期</td>
					<td> <fmt:formatDate value="${inpatientInfo.outHospitalDate}" pattern="yyyy/MM/dd" /></td>
					<td>住院天数</td>
					<td><c:out value="${clinicalChartBasicInfo.inhosDays}"></c:out></td>
					<td>出院诊断</td>
					<td colspan="3">
						<c:forEach items="${clinicalChartBasicInfo.diseaseDiagnosisInfos}" var="diseaseDiagnosisInfo">
							<c:out value="${diseaseDiagnosisInfo.diagnosisDesc} "></c:out> 
						</c:forEach>
					</td>
				</tr>
			</table>
			</fieldset>
			<fieldset class="layui-elem-field">
			<legend>
			
			<span>临床图表</span></legend>
			<div align="right">
				<!--周列表 -->
				<c:forEach begin="1" end="${clinicalChartBasicInfo.inhosWeeks}" var="index">
					<a class="clichart-week-btn btn" href="<c:url value="/inpatient/chartdata/id/${inpatientInfo.id}/week/${index}"  />">第<c:out
							value="${index}"></c:out>周
					</a>
				</c:forEach>
			</div>
			
			<div  id="chichat-data-content"></div>
		</fieldset>
	</div>
</body>
</html>