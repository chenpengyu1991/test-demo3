<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%--可疑职业病人添加列表--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hsa/sodp/addsodp.js"></script>
<div class="toolbar" style="text-align: left" >
	<c:if test="${flag !='view'}">
		<a href="javascript:void(0)" id="sodp-add-btn"><b class="xinz">增加</b></a>
	</c:if>	
</div>
<div id="hsa-sodp-result-box" class="repeattable">
	<table id="hsa-sodp-add-list-table" >
		<colgroup>
			<col style="width: 50" span="12" />
			<col style="width: 70px"/>
		</colgroup>
		<thead>
			<tr>
				<th style="text-align: center;">姓名</th>
				<th style="text-align: center;">年龄</th>
				<th style="text-align: center;">性别</th>
				<th style="text-align: center;">身份证号</th>
				<th style="text-align: center;">工作单位</th>
				<th style="text-align: center;">工种</th>
				<th style="text-align: center;">可疑职业病名称</th>
				<th style="text-align: center;">工作单位电话</th>
				<th style="text-align: center;">患者电话</th>
				<th style="text-align: center;">接报人单位</th>
				<th style="text-align: center;">接报人姓名</th>
				<th style="text-align: center;">接报人电话</th>
				<c:if test="${flag !='view'}"><th style="text-align: center;">操作</th></c:if>
				<th style="display: none">id</th>
			</tr>
		</thead>
		<tbody class="tbody" id="susOccDiseaseDatagrid">
			<c:if test="${not empty inspRecord.susOccDisInfoList}">
				<jsp:include page="update.jsp"></jsp:include>
			</c:if>
		</tbody>
	</table>
</div>
