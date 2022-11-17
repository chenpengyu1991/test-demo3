<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="content">
	<div class="titlebar" style="margin-top: 10px;">
		<div class="title">个人系统信息</div>
		<div class="toobar"></div>
	</div>
	<table class="formtable">
		<tr>
			<th width="150px">个人主索引</th>
			<td>${person.pmpiId}</td>
		</tr>
		<tr>
			<th width="150px">系统域标识</th>
			<td>${person.domainId}</td>
		</tr>
		<tr>
			<th width="150px">本地系统标识</th>
			<td>${person.localId}</td>
		</tr>
	</table>
	<tiles:insertAttribute name="personBasicInfo"/>
	<div style="text-align: center">
		<button id="closelogInfoBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>关闭</button>
	</div>
</div>