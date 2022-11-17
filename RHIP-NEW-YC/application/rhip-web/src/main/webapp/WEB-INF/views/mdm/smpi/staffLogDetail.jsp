<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript">
 $(function() {
	 $("#closeLogInfoDialog").click(function() {
		 layer.close(layer.index);
	 })
 })
</script>
<div class="content" style="padding-bottom: 5px;">
	<div class="titlebar" style="margin-top: 10px;">
		<div class="title">人员职业信息</div>
		<div class="toobar"></div>
	</div>
	<table class="formtable">
		<tr>
			<th width="150px">人员主索引</th>
			<td>${staff.smpiId}</td>
		</tr>
		<tr>
			<th width="150px">所在机构</th>
			<td>${staff.organCode}</td>
		</tr>
		<tr>
			<th width="150px">所在科室</th>
			<td>${staff.deptCode}</td>
		</tr>
		<tr>
			<th width="150px">系统本地标识</th>
			<td>${staff.localId}</td>
		</tr>
		<tiles:insertAttribute name="staffCareerInfo"/>
	</table>
	<tiles:insertAttribute name="staffBasicInfo"/>
	<div style="text-align: center">
		<!-- <input type="button" onclick="$.removeDialog('logInfoDialog')" value="关闭"/> -->
		<button class="layui-btn layui-btn-sm"  id="closeLogInfoDialog">关闭</button>
	</div>
</div>
