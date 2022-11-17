<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<script src="${pageContext.request.contextPath}/js/views/hm/manage/view.js" type="text/javascript"></script>
<c:if test="${status=='1'}">
	<div class="toolbar" style="margin-top: 8px;">
		<%-- <a href="javascript:void(0)"  id="hm-phyexam-add-back-view-btn"><b class="fanhui">返回</b></a> --%>
		<a href="javascript:void(0)"  id="hm-phyexam-add-back-view-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		<%-- <a href="javascript:void(0)" id="old-phyexam-print-btn"><b class="dayin">打印</b></a> --%>
		<a href="javascript:void(0)" id="old-phyexam-print-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe66d;</i>打印</button></a>
	</div>
</c:if>

<div id="hm-phyexam-main"class="${not empty liciTiJianView?'':'contentfixed149'}">
	<form id="hm-person-phyexam-view-form">
		<div class="postcontent">
			<i class="popno">健康体检</i>
			<jsp:include page="view_personPhyExam.jsp"></jsp:include>
		</div>
	</form>
</div>