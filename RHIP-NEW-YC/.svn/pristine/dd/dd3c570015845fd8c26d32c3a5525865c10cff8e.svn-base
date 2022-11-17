<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlhjkjhda/grjlhjkjhda.js" type="text/javascript"></script>
<input id="doseId" type="hidden" value="${doseId }">
<div class="toolbar">
	<a href="#this" onclick="grjlhjkjhda.back()"><b class="fanhui">返回</b></a>
</div>
<div>
	<label>放射工作人员姓名:${name }</label> <label>个人剂量号:${doseNo }</label>
</div>
<!-- 个人剂量检测结果 -->
<div id="doseDetection">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>个人剂量检测结果</legend>
				<div id="grjljcjgAdd" class="toolbar">
					<a href="#this" onclick="grjlhjkjhda.addDoseDetectionRecord()"><b class="xinz">新增</b></a>
				</div>
				<div id="doseDetectionList"></div>
			</fieldset>
		</div>
	</div>
</div>
<!-- 放射工作人员健康监护结果 -->
<div></div>
<!-- 放射工作人员工作量 -->
<div id="workload">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>放射工作人员工作量</legend>
				<div id="fsgzrygzlAdd" class="toolbar">
					<a href="#this" onclick="grjlhjkjhda.addWorkloadRecord()"><b class="xinz">新增</b></a>
				</div>
				<div id="workloadList"></div>
			</fieldset>
		</div>
	</div>
</div>

