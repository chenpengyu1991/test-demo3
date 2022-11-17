<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	$(function() {
		personMergeSplit.confirmStart();
	});
</script>

<div class="content">
	<table class="formtable">
		<th width="25%">请选择最佳记录</th>
		<td>
			<select id="pmpiSelect">
				<c:forTokens var="pid" items="${pids}" delims=",">
					<option value="${pid}">${pid}</option>
				</c:forTokens>
			</select>
		</td>
	</table>
	<div id="sbrDetailDiv">
		<tiles:insertAttribute name="personBasicInfo"/>
	</div>
	<div>
		<p style="margin-top: 15px;" align="center">
			<a href="javascript:void(0)"><button id="doMergeBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>合并</button></a>
			<a href="javascript:void(0)"><button id="cancelMergeBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>取消</button></a>
		</p>
	</div>
</div>